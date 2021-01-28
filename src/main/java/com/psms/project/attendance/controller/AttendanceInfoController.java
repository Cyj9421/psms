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
import java.util.Date;
import java.util.List;

//考勤信息
@RestController
@RequestMapping("/attendance/info")
public class AttendanceInfoController extends BaseController {
    @Autowired
    private IAttendanceInfoService attendanceInfoService;
    @Autowired
    private IAttendanceScheduleService attendanceScheduleService;
    @Autowired
    private IAttendanceScheduleOrderService attendanceScheduleOrderService;
    @Autowired
    private IAttendanceLateService attendanceLateService;
    @Autowired
    private IAttendanceEarlyService attendanceEarlyService;
    @Autowired
    private IAttendanceOvertimeService attendanceOvertimeService;

    /**
     * 考勤列表
     *
     * @param attendanceInfo
     * @return
     */
    @GetMapping("/list")
    public AjaxResult attendanceList(AttendanceInfo attendanceInfo,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceInfo> list = attendanceInfoService.attendanceList(attendanceInfo);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 考勤详情
     *
     * @param attendanceId
     * @return
     */
    @GetMapping("/{attendanceId}")
    public AjaxResult attendanceInfo(@PathVariable int attendanceId) {
        return AjaxResult.success(attendanceInfoService.attendanceInfo(attendanceId));
    }

//    /**
//     * 上班考勤
//     *
//     * @param attendanceInfo
//     * @return
//     */
//    @PostMapping
//    public AjaxResult startAttendance(@RequestBody AttendanceInfo attendanceInfo) {
//        return toAjax(attendanceInfoService.startAttendance(attendanceInfo));
//    }
//
//    /**
//     * 下班考勤
//     *
//     * @param attendanceInfo
//     * @return
//     */
//    @PutMapping("/end")
//    public AjaxResult endAttendance(@RequestBody AttendanceInfo attendanceInfo) {
//        return toAjax(attendanceInfoService.endAttendance(attendanceInfo));
//    }

//    /**
//     * 异常记录
//     *
//     * @param attendanceInfo
//     * @return
//     */
//    @PutMapping("/update")
//    public AjaxResult updateAttendance(@RequestBody AttendanceInfo attendanceInfo){
//        AttendanceSchedule attendanceSchedule = attendanceScheduleService.scheduleInfo(attendanceInfo.getWorkNum());
//        attendanceInfo.setAttendanceDate(attendanceInfo.getAttendanceDate());
//        if (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null) {
//            attendanceInfo.setIsAbsenteeism(2);
//            //缺勤记录
//        }else {
//            if (attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) {
//                attendanceInfo.setIsLate(2);
//                //迟到记录
//                AttendanceLate attendanceLate = new AttendanceLate();
//                attendanceLate.setWorkNum(attendanceInfo.getWorkNum());
//                attendanceLate.setLateTime(attendanceInfo.getStartTime());
//                attendanceLate.setLateDate(attendanceInfo.getAttendanceDate());
//                attendanceLateService.addLate(attendanceLate);
//            }
//            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) {
//                attendanceInfo.setIsEarly(2);
//                //早退记录
//                AttendanceEarly attendanceEarly = new AttendanceEarly();
//                attendanceEarly.setWorkNum(attendanceInfo.getWorkNum());
//                attendanceEarly.setEarlyTime(attendanceInfo.getEndTime());
//                attendanceEarly.setEarlyDate(attendanceInfo.getAttendanceDate());
//                attendanceEarlyService.addEarly(attendanceEarly);
//            }
//            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) > 0) {
//                attendanceInfo.setIsOvertime(2);
//                //加班记录
//                long overtime = attendanceInfo.getEndTime().getTime() - attendanceSchedule.getEndTime().getTime();
//                double hours = (double) overtime / (1000 * 60 * 60);
//                AttendanceOvertime attendanceOvertime = new AttendanceOvertime();
//                attendanceOvertime.setWorkNum(attendanceInfo.getWorkNum());
//                attendanceOvertime.setClockTime(attendanceInfo.getEndTime());
//                attendanceOvertime.setOverTime(hours);
//                attendanceOvertime.setClockDate(attendanceInfo.getAttendanceDate());
//                attendanceOvertimeService.addOvertime(attendanceOvertime);
//            }
//            if ((attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) ||
//                    (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) ||
//                    (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null)
//            ) {
//                attendanceInfo.setAttendanceStatus(2);
//                //异常记录
//            }
//        }
//            return toAjax(attendanceInfoService.updateAttendance(attendanceInfo));
//    }

    /**
     * 批量删除考勤信息
     * @param attendanceIds
     * @return
     */
    @DeleteMapping("/{attendanceIds}")
    public AjaxResult delAttendance(@PathVariable int [] attendanceIds){
        return toAjax(attendanceInfoService.delAttendance(attendanceIds));
    }
}
