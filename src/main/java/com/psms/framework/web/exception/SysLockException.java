package com.psms.framework.web.exception;

import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.domain.AttendanceCard;
import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.domain.AttendanceSchedule;
import com.psms.project.attendance.domain.vo.AskVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import com.psms.project.attendance.service.IAttendanceAskOffService;
import com.psms.project.attendance.service.IAttendanceCardService;
import com.psms.project.attendance.service.IAttendanceInfoService;
import com.psms.project.attendance.service.IAttendanceScheduleService;
import com.psms.project.induction.domain.InductionProbation;
import com.psms.project.induction.service.IInductionProbationService;
import com.psms.project.monitor.service.ISysLockService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自动锁定系统、解锁系统、刷新刷卡次数、试用期转正、缺勤、请休假记录
 */
@Component
@Slf4j
public class SysLockException {
    @Autowired
    private ISysLockService sysLockService;
    @Autowired
    private IAttendanceCardService cardService;
    @Autowired
    private IInductionProbationService probationService;
    @Autowired
    private IAttendanceScheduleService scheduleService;
    @Autowired
    private ISysUserNumberService userNumberService;
    @Autowired
    private IAttendanceInfoService attendanceInfoService;
    @Autowired
    private IAttendanceAskOffService attendanceAskOffService;
    @Scheduled(cron = "0 0 0 * * ?")     //每天凌晨12点执行一次
    public void sysLock() throws InterruptedException, ParseException {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        //获取当前日期
        String date=dayFormat.format(new Date());
        Date nowDate=dateFormat.parse(dateFormat.format(new Date()));
        Date nowDateTime=dateTimeFormat.parse(dateTimeFormat.format(new Date()));
        //缺勤、请休假记录
        List<String> numList = userNumberService.numList(null);
        for(int i=0;i<numList.size();i++){
            AttendanceSchedule attendanceSchedule = scheduleService.scheduleInfo(numList.get(i));
            if(attendanceSchedule.getStartDate().after(nowDate) && attendanceSchedule.getEndDate().before(nowDate)){
                calendar.setTime(nowDate);
                calendar.add(Calendar.DAY_OF_MONTH,-1);
                AttendanceInfo attendance=new AttendanceInfo();
                attendance.setWorkNum(numList.get(i));
                attendance.setAttendanceDate(calendar.getTime());
                AttendanceVo attendanceVo=new AttendanceVo();
                attendanceVo.setWorkNum(numList.get(i));
                attendanceVo.setAttendanceDate(calendar.getTime());
                AttendanceInfo attendanceInfo = attendanceInfoService.attendateInfo(attendance);
                if(attendanceInfo==null){
                    AskVo askVo=new AskVo();
                    askVo.setWorkNum(numList.get(i));
                    askVo.setNowDateTime(nowDateTime);
                    AttendanceAskOff attendanceAskOff = attendanceAskOffService.askOffByWorkNum(askVo);
                    if(attendanceAskOff !=null && attendanceAskOff.getAskStatus()==1){
                        if(attendanceAskOff.getAskType()==1){
                            attendanceVo.setIsAsk(2);
                            attendanceVo.setAttendanceStatus(1);
                        }else {
                            attendanceVo.setIsVacate(2);
                            attendanceVo.setAttendanceStatus(1);
                        }
                    }else {
                        attendanceVo.setIsAbsenteeism(2);
                        attendanceVo.setAttendanceStatus(2);
                    }
                    attendanceInfoService.addAttendance(attendanceVo);
                }
            }
        }
        //试用期转正
        List<InductionProbation> probationList=probationService.probationList();
        for(int i=0;i<probationList.size();i++){
            InductionProbation probation=probationList.get(i);
            calendar.setTime(dateFormat.parse(dateFormat.format(probation.getCreateTime())));
            calendar.add(Calendar.MONTH,probation.getProbationMonth());
            calendar.add(Calendar.DAY_OF_MONTH,probation.getProbationDay());
            if(nowDate.compareTo(calendar.getTime())==0){
                probation.setProbationStatus(1);
                probationService.updateProbation(probation);
            }
        }
        //刷新ic卡刷卡次数
        List<AttendanceCard> cardList=cardService.cardList(new AttendanceCard());
        for(int i=0;i<cardList.size();i++){
            AttendanceCard attendanceCard=cardList.get(i);
            attendanceCard.setBrushNum(attendanceCard.getDefaultNum());
            cardService.updateCard(attendanceCard);
        }
        List<String> list=sysLockService.dateList();
        //查询系统锁定日期
        for(int i=0;i<list.size();i++){
            if(date.equals(list.get(i))){
                sysLockService.isTrue();
                //锁定系统
                log.info("系统锁定中!");
                TimeUnit.HOURS.sleep(24);
            }else{
                log.info("今天不是锁定日!");
            }
        }
        sysLockService.isFlase();
        //解锁系统
        log.info("解锁成功!");
    }
}
