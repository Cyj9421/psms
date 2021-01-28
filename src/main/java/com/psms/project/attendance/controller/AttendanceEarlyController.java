package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceCardRep;
import com.psms.project.attendance.domain.AttendanceEarly;
import com.psms.project.attendance.service.IAttendanceEarlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//早退管理
@RestController
@RequestMapping("/attendance/early")
public class AttendanceEarlyController extends BaseController {
    @Autowired
    private IAttendanceEarlyService attendanceEarlyService;

    /**
     * 早退列表
     * @param attendanceEarly
     * @return
     */
    @GetMapping("/list")
    public AjaxResult earlyList(AttendanceEarly attendanceEarly,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceEarly> list = attendanceEarlyService.earlyList(attendanceEarly);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 早退详情
     * @param earlyId
     * @return
     */
    @GetMapping("/{earlyId}")
    public AjaxResult earlyInfo(@PathVariable int earlyId){
        return AjaxResult.success(attendanceEarlyService.earlyInfo(earlyId));
    }

    /**
     * 新增早退记录
     * @param attendanceEarly
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addEarly(@RequestBody AttendanceEarly attendanceEarly){
        return toAjax(attendanceEarlyService.addEarly(attendanceEarly));
    }
    @DeleteMapping("/{earlyIds}")
    public AjaxResult delEarly(@PathVariable int [] earlyIds){
        return toAjax(attendanceEarlyService.delEarly(earlyIds));
    }
}
