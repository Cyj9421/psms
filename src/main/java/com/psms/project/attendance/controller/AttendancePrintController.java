package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.*;
import com.psms.project.attendance.domain.vo.AttendanceInfoVo;
import com.psms.project.attendance.service.*;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 指纹管理
 */
@RestController
@RequestMapping("/attendance/fp")
public class AttendancePrintController extends BaseController {
    @Autowired
    private IAttendanceFingerprintService attendanceFingerprintService;
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
    @Autowired
    private ISysUserNumberService userNumberService;
    /** 用来判断是上班打卡还是下班打卡 */
    private int i=0;
    /**
     * 指纹列表
     * @param attendanceFingerprint
     * @return
     */
    @GetMapping("/list")
    public AjaxResult templateList(AttendanceFingerprint attendanceFingerprint, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceFingerprint> list = attendanceFingerprintService.fingerprintList(attendanceFingerprint);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 可用指纹列表
     * @return
     */
    @GetMapping("/available/list")
    public AjaxResult templateListIsAvailable() {
        AttendanceFingerprint attendanceFingerprint=new AttendanceFingerprint();
        attendanceFingerprint.setUseStatus(1);
        return AjaxResult.success(attendanceFingerprintService.fingerprintList(attendanceFingerprint));
    }
    /**
     * 指纹详情
     * @param fingerprintId
     * @return
     */
    @GetMapping("/{fingerprintId}")
    public AjaxResult templateInfo(@PathVariable int fingerprintId){
        return AjaxResult.success(attendanceFingerprintService.fingerprintInfo(fingerprintId));
    }

    /**
     * 录入指纹
     * @param workNum 工号
     * @param fingerprintTemplate 指纹模板
     * @return
     */
    @PostMapping("/enroll")
    public AjaxResult addTemplate(String workNum,String fingerprintTemplate,int ioId){
        if(userNumberService.numberByWorkNum(workNum)==null){
            return AjaxResult.success("没有该工号的信息!",false);
        }
        AttendanceFingerprint attendanceFingerprint=new AttendanceFingerprint();
        attendanceFingerprint.setWorkNum(workNum);
        attendanceFingerprint.setFingerprintTemplate(fingerprintTemplate);
        attendanceFingerprint.setIoId(ioId);
        return toAjax(attendanceFingerprintService.addFingerprint(attendanceFingerprint));
    }

    /**
     * 打卡记录
     * @param fingerprintId
     * @return
     * @throws ParseException
     */
    @PostMapping("/startAndEnd/{fingerprintId}")
    public AjaxResult startAndEnd(@PathVariable int fingerprintId) throws ParseException {
        LocalTime localTime = LocalTime.now(); // gets the current time
        AttendanceFingerprint attendanceFingerprint=attendanceFingerprintService.fingerprintInfo(fingerprintId);
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(attendanceFingerprint==null){
            return AjaxResult.error(400,"该指纹已注销!");
        }
        AttendanceInfoVo attendanceInfoVo=attendanceInfoService.printFingerInfo(attendanceFingerprint.getWorkNum());
        attendanceInfoVo.setAttendanceTime(datetime.format(new Date()));
        AttendanceInfo attendanceInfo=new AttendanceInfo();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        attendanceInfo.setWorkNum(attendanceFingerprint.getWorkNum());
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
                    return AjaxResult.success("你今天已经打过卡了",attendanceInfoVo);
                }
            }
            catch (Exception e){
                i=0;
                e.printStackTrace();
                return AjaxResult.success("你今天已经打过卡了",attendanceInfoVo);
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
        return AjaxResult.success(attendanceInfoVo);
    }
    /**
     * 指纹更新
     * @param attendanceFingerprint
     * @return
     */
    @PutMapping("/update")
    public AjaxResult updateFingerprint(@RequestBody AttendanceFingerprint attendanceFingerprint){
        return toAjax(attendanceFingerprintService.updateFingerprint(attendanceFingerprint));
    }

    /**
     * 指纹注销
     * @param workNum
     * @return
     */
    @PutMapping("/{workNum}")
    public AjaxResult delTemplate(@PathVariable String workNum){
        return toAjax(attendanceFingerprintService.delFingerprint(workNum));
    }

    /**
     * 批量删除指纹
     * @param fingerprintIds
     * @return
     */
    @DeleteMapping("/{fingerprintIds}")
    public AjaxResult delFingerprints(@PathVariable int [] fingerprintIds){
        return toAjax(attendanceFingerprintService.delFingerprints(fingerprintIds));
    }
}
