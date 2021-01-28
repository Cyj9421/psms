package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.domain.AttendanceCardRep;
import com.psms.project.attendance.service.IAttendanceCardRepService;
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
        return toAjax(attendanceCardRepService.updateCard(attendanceCardRep));
    }
    @DeleteMapping("/{replacementIds}")
    public AjaxResult delCards(@PathVariable int [] replacementIds){
        return toAjax(attendanceCardRepService.delCard(replacementIds));
    }
}
