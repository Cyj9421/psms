package com.psms.project.attendance.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.domain.AttendanceLate;
import com.psms.project.attendance.service.IAttendanceLateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//迟到管理
@RestController
@RequestMapping("/attendance/late")
public class AttendanceLateController extends BaseController {
    @Autowired
    private IAttendanceLateService attendanceLateService;

    /**
     * 迟到列表
     * @param attendanceLate
     * @return
     */
    @GetMapping("/list")
    public AjaxResult lateList(AttendanceLate attendanceLate, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceLate> list = attendanceLateService.lateList(attendanceLate);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 迟到详情
     * @param lateId
     * @return
     */
    @GetMapping("/{lateId}")
    public AjaxResult lateInfo(@PathVariable int lateId){
        return AjaxResult.success(attendanceLateService.lateInfo(lateId));
    }

    /**
     * 添加迟到记录
     * @param attendanceLate
     * @return
     */
    @PostMapping
    public AjaxResult addLate(@RequestBody AttendanceLate attendanceLate){
        return toAjax(attendanceLateService.addLate(attendanceLate));
    }

    /**
     * 批量删除迟到信息
     * @param lateIds
     * @return
     */
    @DeleteMapping("/{lateIds}")
    public AjaxResult delLate(@PathVariable int [] lateIds){
        return toAjax(attendanceLateService.delLates(lateIds));
    }
}
