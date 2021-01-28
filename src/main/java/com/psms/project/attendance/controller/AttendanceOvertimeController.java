package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceLate;
import com.psms.project.attendance.domain.AttendanceOvertime;
import com.psms.project.attendance.service.IAttendanceOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 加班记录
 */
@RestController
@RequestMapping("/attendance/overtime")
public class AttendanceOvertimeController extends BaseController {
    @Autowired
    private IAttendanceOvertimeService attendanceOvertimeService;

    /**
     * 加班列表
     * @param attendanceOvertime
     * @return
     */
    @GetMapping("/list")
    public AjaxResult overtimeList(AttendanceOvertime attendanceOvertime, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceOvertime> list = attendanceOvertimeService.overtimeList(attendanceOvertime);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 加班详情
     * @param overtimeId
     * @return
     */
    @GetMapping("/{overtimeId}")
    public AjaxResult overtimeInfo(@PathVariable int overtimeId){
        return AjaxResult.success(attendanceOvertimeService.overtimeInfo(overtimeId));
    }

    /**
     * 新增加班记录
     * @param attendanceOvertime
     * @return
     */
    @PostMapping
    public AjaxResult addOvertime(@RequestBody AttendanceOvertime attendanceOvertime){
        return toAjax(attendanceOvertimeService.addOvertime(attendanceOvertime));
    }

    /**
     * 批量删除加班信息
     * @param overtimeIds
     * @return
     */
    @DeleteMapping("/{overtimeIds}")
    public AjaxResult delOvertime(@PathVariable int [] overtimeIds){
        return toAjax(attendanceOvertimeService.delOvertime(overtimeIds));
    }
}
