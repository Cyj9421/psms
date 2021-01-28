package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.*;
import com.psms.project.attendance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * 刷卡管理
 */
@RestController
@RequestMapping("/attendance/card/device")
public class AttendanceCardController extends BaseController {
    @Autowired
    private IAttendanceCardService attendanceCardService;
    @Autowired
    private IAttendanceInfoService attendanceInfoService;
    @Autowired
    private IAttendanceScheduleService attendanceScheduleService;
    @Autowired
    private IAttendanceLateService attendanceLateService;
    @Autowired
    private IAttendanceEarlyService attendanceEarlyService;
    @Autowired
    private IAttendanceOvertimeService attendanceOvertimeService;
    private int i=0;
    /**
     * 卡号列表
     * @param attendanceCard
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public AjaxResult cardList(AttendanceCard attendanceCard,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceCard> list = attendanceCardService.cardList(attendanceCard);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);

    }

    /**
     * 卡号详情
     * @param cardId
     * @return
     */
    @GetMapping("/{cardId}")
    public AjaxResult cardInfo(@PathVariable int cardId){
        return AjaxResult.success(attendanceCardService.cardInfo(cardId));
    }

    /**
     * 绑定卡号
     * @param attendanceCard
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addCard(@RequestBody AttendanceCard attendanceCard){
        return toAjax(attendanceCardService.addCard(attendanceCard));
    }

    /**
     * 批量删除卡号
     * @param cardIds
     * @return
     */
    @DeleteMapping("/{cardIds}")
    public AjaxResult delCard(@PathVariable int [] cardIds){
        return toAjax(attendanceCardService.delCard(cardIds));
    }

    /**
     * 通过卡号
     * @param cardNum
     * @return
     * @throws ParseException
     */
    @PostMapping("/{cardNum}")
    public AjaxResult startAndEnd(@PathVariable String cardNum) throws ParseException {
        LocalTime localTime = LocalTime.now(); // gets the current time
        AttendanceCard attendanceCard=attendanceCardService.attendanceCardInfo(cardNum);
        AttendanceInfo attendanceInfo=new AttendanceInfo();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        attendanceInfo.setWorkNum(attendanceCard.getWorkNum());
        attendanceInfo.setAttendanceDate(date.parse(date.format(new Date())));
        if(i==0){
            try {
                //上班打卡
                Time time = Time.valueOf(localTime);
                attendanceInfo.setStartTime(time);
                i += 1;
                AttendanceInfo Info = attendanceInfoService.attendateInfo(attendanceInfo);
                if (Info == null) {
                    attendanceInfoService.startAttendance(attendanceInfo);
                    attendanceInfo = attendanceInfoService.attendateInfo(attendanceInfo);
                    return AjaxResult.success(attendanceInfo);
                }else{
                    i=0;
                    return AjaxResult.success("你今天已经打过卡了");
                }
            }
            catch (Exception e){
                i=0;
                e.printStackTrace();
                return AjaxResult.success("你今天已经打过卡了");
            }
        }
        attendanceInfo=attendanceInfoService.attendateInfo(attendanceInfo);
        if(attendanceInfo.getEndTime()==null && i==1){
            //下班打卡
            Time time=Time.valueOf(localTime);
            attendanceInfo.setEndTime(time);
            i+=1;
            attendanceInfoService.endAttendance(attendanceInfo);
            i=0;
        }
        AttendanceSchedule attendanceSchedule = attendanceScheduleService.scheduleInfo(attendanceInfo.getWorkNum());
        attendanceInfo.setAttendanceDate(attendanceInfo.getAttendanceDate());
        if (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null) {
            attendanceInfo.setIsAbsenteeism(2);
            //缺勤记录
        }else {
            if (attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) {
                attendanceInfo.setIsLate(2);
                //迟到记录
                AttendanceLate attendanceLate = new AttendanceLate();
                attendanceLate.setWorkNum(attendanceInfo.getWorkNum());
                attendanceLate.setLateTime(attendanceInfo.getStartTime());
                attendanceLate.setLateDate(attendanceInfo.getAttendanceDate());
                attendanceLateService.addLate(attendanceLate);
            }
            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) {
                attendanceInfo.setIsEarly(2);
                //早退记录
                AttendanceEarly attendanceEarly = new AttendanceEarly();
                attendanceEarly.setWorkNum(attendanceInfo.getWorkNum());
                attendanceEarly.setEarlyTime(attendanceInfo.getEndTime());
                attendanceEarly.setEarlyDate(attendanceInfo.getAttendanceDate());
                attendanceEarlyService.addEarly(attendanceEarly);
            }
            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) > 0) {
                attendanceInfo.setIsOvertime(2);
                //加班记录
                long overtime = attendanceInfo.getEndTime().getTime() - attendanceSchedule.getEndTime().getTime();
                double hours = (double) overtime / (1000 * 60 * 60);
                AttendanceOvertime attendanceOvertime = new AttendanceOvertime();
                attendanceOvertime.setWorkNum(attendanceInfo.getWorkNum());
                attendanceOvertime.setClockTime(attendanceInfo.getEndTime());
                attendanceOvertime.setOverTime(hours);
                attendanceOvertime.setClockDate(attendanceInfo.getAttendanceDate());
                attendanceOvertimeService.addOvertime(attendanceOvertime);
            }
            if ((attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) ||
                    (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) ||
                    (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null)
            ) {
                attendanceInfo.setAttendanceStatus(2);
                //异常记录
            }
        }
        attendanceInfoService.updateAttendance(attendanceInfo);
        return AjaxResult.success(attendanceInfoService.attendateInfo(attendanceInfo));
    }
}
