package com.psms.project.system.controller;

import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysAttendanceTime;
import com.psms.project.system.service.ISysAttendanceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/system/time")
public class SysAttendanceTimeController extends BaseController {
    @Autowired
    private ISysAttendanceTimeService sysAttendanceTimeService;

    /**
     * 时间段列表
     * @param sysAttendanceTime
     * @return
     */
    @GetMapping("/list")
    public AjaxResult timeList(SysAttendanceTime sysAttendanceTime){
        return AjaxResult.success(sysAttendanceTimeService.timeList(sysAttendanceTime));
    }

    /**
     * 时间段详情
     * @param timeId
     * @return
     */
    @GetMapping(value = "/{timeId}")
    public AjaxResult timeInfo(@PathVariable int timeId){
        return AjaxResult.success(sysAttendanceTimeService.timeInfo(timeId));
    }

    /**
     * 新增时间段
     * @param sysAttendanceTime
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addTime(@RequestBody SysAttendanceTime sysAttendanceTime){
        return toAjax(sysAttendanceTimeService.addTime(sysAttendanceTime));
    }

    /**
     * 修改时间段
     * @param sysAttendanceTime
     * @return
     */
    @PutMapping("/update")
    public AjaxResult updateTime(@RequestBody SysAttendanceTime sysAttendanceTime){
        return toAjax(sysAttendanceTimeService.updateTime(sysAttendanceTime));
    }

    /**
     * 删除时间段
     * @param timeId
     * @return
     */
    @DeleteMapping("/{timeId}")
    public AjaxResult delTime(@PathVariable int timeId){
       return toAjax(sysAttendanceTimeService.delTime(timeId));
    }
}
