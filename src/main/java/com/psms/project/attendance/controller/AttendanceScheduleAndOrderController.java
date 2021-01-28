package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceRp;
import com.psms.project.attendance.domain.AttendanceSchedule;
import com.psms.project.attendance.domain.AttendanceScheduleOrder;
import com.psms.project.attendance.service.IAttendanceScheduleOrderService;
import com.psms.project.attendance.service.IAttendanceScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层 排班和班次管理
 */
@RestController
@RequestMapping("/attendance/schedule")
@Api(description = "控制层 班次和排班管理")
public class AttendanceScheduleAndOrderController extends BaseController {
    @Autowired
    private IAttendanceScheduleService attendanceScheduleService;
    @Autowired
    private IAttendanceScheduleOrderService attendanceScheduleOrderService;

    /**
     * 班次管理 班次列表
     * @param attendanceScheduleOrder
     * @return
     */
    @GetMapping("/order/list")
    @ApiOperation("班次列表")
    public AjaxResult orderList(AttendanceScheduleOrder attendanceScheduleOrder, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceScheduleOrder> list = attendanceScheduleOrderService.orderList(attendanceScheduleOrder);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 班次管理 班次详情
     * @param orderId
     * @return
     */
    @GetMapping("/order/{orderId}")
    public AjaxResult orderInfo(@PathVariable int orderId){
        return AjaxResult.success(attendanceScheduleOrderService.orderInfo(orderId));
    }

    /**
     * 班次管理 添加班次
     * @param attendanceScheduleOrder
     * @return
     */
    @PostMapping("/order")
    public AjaxResult addOrder(@RequestBody AttendanceScheduleOrder attendanceScheduleOrder){
        attendanceScheduleOrder.setCreateBy(SecurityUtils.getUsername());
        return toAjax(attendanceScheduleOrderService.addOrder(attendanceScheduleOrder));
    }

    /**
     * 班次管理 删除班次
     * @param orderId
     * @return
     */
    @DeleteMapping("/order/{orderId}")
    public AjaxResult delOrder(@PathVariable int orderId){
        return toAjax(attendanceScheduleOrderService.delOrder(orderId));
    }
    /**
     * 班次管理 修改班次
     * @param attendanceScheduleOrder
     * @return
     */
    @PutMapping("/order")
    public AjaxResult updateOrder(@RequestBody AttendanceScheduleOrder attendanceScheduleOrder){
        attendanceScheduleOrder.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(attendanceScheduleOrderService.updateOrder(attendanceScheduleOrder));
    }
    /**
     * 排班管理 排班列表
     */
    @GetMapping("/list")
    public AjaxResult scheduleList(AttendanceSchedule attendanceSchedule,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceSchedule> list = attendanceScheduleService.scheduleList(attendanceSchedule);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    /**
     * 排班管理 排班详情
     */
    @GetMapping("/{workNum}")
    public AjaxResult scheduleInfo(@PathVariable String workNum){
        return AjaxResult.success(attendanceScheduleService.scheduleInfo(workNum));
    }
    /**
     * 排班管理 新增排班
     */
    @PostMapping
    public AjaxResult addSchedule(@RequestBody AttendanceSchedule attendanceSchedule){
        attendanceSchedule.setCreateBy(SecurityUtils.getUsername());
        return toAjax(attendanceScheduleService.addSchedule(attendanceSchedule));
    }
    /**
     * 排班管理 删除排班
     */
    @DeleteMapping("/{scheduleIds}")
    public AjaxResult delSchedule(@PathVariable int [] scheduleIds){
        return toAjax(attendanceScheduleService.delSchedule(scheduleIds));
    }
    /**
     * 排班管理 修改排班
     */
    @PutMapping
    public AjaxResult updateSchedule(@RequestBody AttendanceSchedule attendanceSchedule){
        attendanceSchedule.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(attendanceScheduleService.updateSchedule(attendanceSchedule));
    }
}
