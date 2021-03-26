package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.domain.vo.AttendanceReportDateVo;
import com.psms.project.attendance.domain.vo.AttendanceRpVo;
import com.psms.project.attendance.domain.vo.AttendanceSummaryVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import com.psms.project.attendance.service.IAttendanceInfoService;
import com.psms.project.attendance.service.IAttendanceOvertimeService;
import com.psms.project.attendance.service.IAttendanceScheduleService;
import com.psms.project.attendance.service.IAttendanceSummaryService;
import com.psms.project.system.service.ISysUserNumberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//考勤汇总
@RestController
@RequestMapping("/attendance/summary")
public class AttendanceSummaryController extends BaseController {
    @Autowired
    private IAttendanceSummaryService attendanceSummaryService;
    @Autowired
    private IAttendanceOvertimeService attendanceOvertimeService;
    @Autowired
    private IAttendanceScheduleService attendanceScheduleService;
    @Autowired
    private IAttendanceInfoService attendanceInfoService;
    @Autowired
    private ISysUserNumberService sysUserNumberService;

    /**
     * 考勤汇总列表
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "考勤列表",notes ="考勤列表")
    public AjaxResult summaryList(AttendanceSummary attendanceSummary, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceSummary> list = attendanceSummaryService.summaryList(attendanceSummary);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 考勤汇总详情
     *
     * @param summaryId
     * @return
     */
    @GetMapping("/{summaryId}")
    public AjaxResult summaryInfo(@PathVariable int summaryId) {
        return AjaxResult.success(attendanceSummaryService.summaryInfo(summaryId));
    }

    /**
     * 日报表
     * @return
     */
    @GetMapping("/day")
    public AjaxResult reportToDay(AttendanceVo attendanceVo,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
            PageHelper.startPage(pageNum,pageSize);
            List<AttendanceVo> list = attendanceSummaryService.attendanceToDayList(attendanceVo);
            PageInfo pageInfo = new PageInfo(list);
            return AjaxResult.success(pageInfo);
    }

    /**
     * 部门考勤汇总
     * @param
     * @return
     */
    @GetMapping("/dept/list")
    public AjaxResult sumReportByDept(AttendanceReportDateVo attendanceReportDateVo,
                                      @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c=Calendar.getInstance();
        if(attendanceReportDateVo.getStartDate()==null || attendanceReportDateVo.getEndDate()==null){
            c.add(Calendar.MONTH, 0);
            c.set(GregorianCalendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            attendanceReportDateVo.setStartDate(c.getTime());
            c.set(Calendar.DATE, 1);
            c.roll(Calendar.DATE, -1);
            attendanceReportDateVo.setEndDate(c.getTime());
        }
        int days=(int)(new Date().getTime()-(sdf.parse(sdf.format(attendanceReportDateVo.getStartDate()))).getTime())/(60*60*24*1000);
        List<AttendanceSummaryVo> attendanceSummaryVoList = attendanceSummaryService.summaryVoList(attendanceReportDateVo);
        if(StringUtils.isEmpty(attendanceReportDateVo.getWorkNum())==false){
            if(attendanceSummaryVoList.size()==0){
                return AjaxResult.error(400,"没有该部门的考勤信息!");
            }
        }
        List<AttendanceRpVo> attendanceRpVoList = attendanceSummaryService.attendanceRpVoList(attendanceReportDateVo);
        for(int i=0;i<attendanceSummaryVoList.size();i++){
            AttendanceSummaryVo attendanceSummaryVo = attendanceSummaryVoList.get(i);
            for(int j=0;j<attendanceRpVoList.size();j++){
                AttendanceRpVo attendanceRpVo=attendanceRpVoList.get(j);
                if(attendanceSummaryVo.getDeptName().equals(attendanceRpVo.getDeptName())){
                    attendanceSummaryVo.setRewardsNum(attendanceRpVo.getRewardsNum());
                    attendanceSummaryVo.setPunishmentNum(attendanceRpVo.getPunishmentNum());
                }else{
                    attendanceSummaryVo.setRewardsNum(0);
                    attendanceSummaryVo.setPunishmentNum(0);
                }
            }
            if(attendanceSummaryVo.getAfdNum()!=0){
                attendanceSummaryVo.setIsFullTime(2);
            }
            if(attendanceSummaryVo.getAttendanceNum()+attendanceSummaryVo.getAskNum()+attendanceSummaryVo.getVacateNum()==days){
                attendanceSummaryVo.setIsFullTime(1);
            }else {
                attendanceSummaryVo.setIsFullTime(2);
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(attendanceSummaryVoList);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 统计报表 月/季/年
     *
     * @param type
     * @return
     */
    @PostMapping("/{type}")
    public AjaxResult sumReport(@PathVariable int type){
        AttendanceReportDateVo attendanceReportDateVo=new AttendanceReportDateVo();
        List<String> list=sysUserNumberService.numList(null);
        int days=0;
        for(int i=0;i<list.size();i++) {
            attendanceReportDateVo.setWorkNum(list.get(i));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            if (type == 1) {
                c.add(Calendar.MONTH, 0);
                c.set(GregorianCalendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
                days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                attendanceReportDateVo.setStartDate(c.getTime());
                c.set(Calendar.DATE, 1);
                c.roll(Calendar.DATE, -1);
                attendanceReportDateVo.setEndDate(c.getTime());
            }
            if (type == 2) {
                c.clear();
                c.setTime(new Date());
                int num = c.get(Calendar.MONTH) / 3 + 1;
                switch (num) {
                    case 1:
                        c.set(Calendar.MONTH, 3);
                        c.set(Calendar.DATE, 1);
                        c.add(Calendar.DATE, -1);
                        days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                        attendanceReportDateVo.setEndDate(c.getTime());
                        String str1 = sdf.format(c.getTime());
                        try {
                            attendanceReportDateVo.setStartDate(sdf.parse(str1.substring(0, str1.length() - 5) + "01-01"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        c.set(Calendar.MONTH, 6);
                        c.set(Calendar.DATE, 1);
                        c.add(Calendar.DATE, -1);
                        days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                        attendanceReportDateVo.setEndDate(c.getTime());
                        String str2 = sdf.format(c.getTime());
                        try {
                            attendanceReportDateVo.setStartDate(sdf.parse(str2.substring(0, str2.length() - 5) + "04-01"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        c.set(Calendar.MONTH, 9);
                        c.set(Calendar.DATE, 1);
                        c.add(Calendar.DATE, -1);
                        days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                        attendanceReportDateVo.setEndDate(c.getTime());
                        String str3 = sdf.format(c.getTime());
                        try {
                            attendanceReportDateVo.setStartDate(sdf.parse(str3.substring(0, str3.length() - 5) + "07-01"));

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        c.set(Calendar.MONTH, 12);
                        c.set(Calendar.DATE, 1);
                        c.add(Calendar.DATE, -1);
                        days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                        attendanceReportDateVo.setEndDate(c.getTime());
                        String str4 = sdf.format(c.getTime());
                        try {
                            attendanceReportDateVo.setStartDate(sdf.parse(str4.substring(0, str4.length() - 5) + "10-01"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
            if (type == 3) {
                c.clear();
                String str = sdf.format(new Date());
                int year = Integer.parseInt(str.substring(0, 4));
                c.set(Calendar.YEAR, year);
                days=(int)(new Date().getTime()-c.getTime().getTime())/(60*60*24*1000);
                attendanceReportDateVo.setStartDate(c.getTime());
                c.roll(Calendar.DAY_OF_YEAR, -1);
                attendanceReportDateVo.setEndDate(c.getTime());
            }
            c.clear();
            c.setTime(new Date());
            AttendanceSummary attendanceSummary = attendanceSummaryService.summaryToType(attendanceReportDateVo);
            if(attendanceSummary.getAfdNum()!=0){
                attendanceSummary.setIsFullTime(2);
            }
            if(attendanceSummary.getAttendanceNum()+attendanceSummary.getAskNum()+attendanceSummary.getVacateNum()==days){
                attendanceSummary.setIsFullTime(1);
            }else {
                attendanceSummary.setIsFullTime(2);
            }
            attendanceSummaryService.delSummaryByDate
                    (type,c.get(Calendar.MONTH)+1,c.get(Calendar.MONTH) / 3 + 1,c.get(Calendar.YEAR),attendanceReportDateVo.getWorkNum());
            attendanceSummary.setWorkNum(attendanceReportDateVo.getWorkNum());
            attendanceSummary.setReportType(type);
            attendanceSummary.setSummaryMonth(c.get(Calendar.MONTH)+1);
            attendanceSummary.setSummaryQuarter(c.get(Calendar.MONTH) / 3 + 1);
            attendanceSummary.setSummaryYear(c.get(Calendar.YEAR));
            attendanceSummaryService.addSummary(attendanceSummary);
            System.out.println("汇总成功");
        }
        return AjaxResult.success();
        }

    /**
     * 批量删除汇总
     * @param summaryIds
     * @return
     */
    @DeleteMapping("/{summaryIds}")
    public AjaxResult delSummary(@PathVariable int [] summaryIds){
        return toAjax(attendanceSummaryService.delSummary(summaryIds));
    }
    }

