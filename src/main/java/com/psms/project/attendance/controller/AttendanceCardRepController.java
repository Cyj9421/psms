package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.domain.AttendanceCardRep;
import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.domain.AttendanceLate;
import com.psms.project.attendance.service.IAttendanceCardRepService;
import com.psms.project.attendance.service.IAttendanceInfoService;
import com.psms.project.attendance.service.IAttendanceLateService;
import com.psms.project.attendance.service.IAttendanceSummaryService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//补卡日志
@RestController
@RequestMapping("/attendance/card")
@Slf4j
public class AttendanceCardRepController extends BaseController {
    @Autowired
    private IAttendanceCardRepService attendanceCardRepService;
    @Autowired
    private IAttendanceSummaryService summaryService;
    @Autowired
    private ISysUserNumberService userNumberService;
    @Autowired
    private IAttendanceInfoService infoService;
    @Autowired
    private IAttendanceLateService lateService;
    /**
     * 补卡列表
     * @param attendanceCardRep
     * @return
     */
    @GetMapping("/list")
    public AjaxResult cardRepList(AttendanceCardRep attendanceCardRep, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceCardRep> list = attendanceCardRepService.cardRepList(attendanceCardRep);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 补卡详情
     * @param replacementId
     * @return
     */
    @GetMapping("/{replacementId}")
    public AjaxResult cardRepInfo(@PathVariable int replacementId){
        return AjaxResult.success(attendanceCardRepService.cardRepInfo(replacementId));
    }

    /**
     * 补卡申请
     * @param attendanceCardRep
     * @return
     */
    @PostMapping
    public AjaxResult addCardRep(@RequestBody AttendanceCardRep attendanceCardRep){
        if(StringUtils.isEmpty(attendanceCardRep.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(attendanceCardRep.getWorkNum());
        if(userNumber ==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }if(attendanceCardRep.getAttendanceDate()==null){
            return AjaxResult.error(400,"请输入考勤日期");
        }
        AttendanceInfo attendanceInfo=new AttendanceInfo();
        attendanceInfo.setWorkNum(attendanceCardRep.getWorkNum());
        attendanceInfo.setAttendanceDate(attendanceCardRep.getAttendanceDate());
        AttendanceInfo attendance = infoService.attendateInfo(attendanceInfo);
        if(attendance==null){
            return AjaxResult.error(400,"没有该员工的考勤信息");
        }
        if(attendance.getAttendanceStatus()==1){
            return AjaxResult.error(400,"考勤正常，不需要补卡");
        }
        attendanceCardRep.setNickName(SecurityUtils.getUsername());
        return toAjax(attendanceCardRepService.addCardRep(attendanceCardRep));
    }

    /**
     *  补卡审核
     * @param attendanceCardRep
     * @return
     */
    @PutMapping
    public AjaxResult updateCard(@RequestBody AttendanceCardRep attendanceCardRep){
        attendanceCardRep.setUpdateBy(SecurityUtils.getUsername());
        attendanceCardRepService.updateCard(attendanceCardRep);
        attendanceCardRep= attendanceCardRepService.cardRepInfo(attendanceCardRep.getReplacementId());
        if(attendanceCardRep.getCardStatus()!=2){
            return AjaxResult.error(400,"不能二次审核!");
        }
        if(attendanceCardRep.getCardStatus()==1) {
            AttendanceInfo attendanceInfo=new AttendanceInfo();
            attendanceInfo.setWorkNum(attendanceCardRep.getWorkNum());
            attendanceInfo.setAttendanceDate(attendanceCardRep.getAttendanceDate());
            attendanceInfo = infoService.attendateInfo(attendanceInfo);
            if (attendanceInfo.getIsLate() == 2) {
                AttendanceLate attendanceLate = new AttendanceLate();
                attendanceLate.setWorkNum(attendanceCardRep.getWorkNum());
                attendanceLate.setLateDate(attendanceCardRep.getAttendanceDate());
                attendanceLate = lateService.lateInfoByAttendance(attendanceLate);
                lateService.delLate(attendanceLate.getLateId());
            }
            attendanceInfo.setAttendanceStatus(1);
            attendanceInfo.setIsLate(1);
            attendanceInfo.setIsEarly(1);
            attendanceInfo.setIsAbsenteeism(1);
            infoService.updateAttendance(attendanceInfo);
        }
        return AjaxResult.success();
    }
    @DeleteMapping("/{replacementIds}")
    public AjaxResult delCards(@PathVariable int [] replacementIds){
        return toAjax(attendanceCardRepService.delCard(replacementIds));
    }
}
