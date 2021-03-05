package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceIo;
import com.psms.project.attendance.service.IAttendanceIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层 出入口管理
 */
@RestController
@RequestMapping("/attendance/io")
public class AttendanceIoController extends BaseController {
    @Autowired
    private IAttendanceIoService attendanceIoService;

    /**
     * 出入口列表
     *
     * @return
     */
    @GetMapping("/list")
    public AjaxResult ioList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AttendanceIo> list = attendanceIoService.ioList();
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 添加出入口
     * @param attendanceIo
     * @return
     */
    @PostMapping
    public AjaxResult addIo(@RequestBody AttendanceIo attendanceIo) {
        return toAjax(attendanceIoService.addIo(attendanceIo));
    }

    /**
     * 修改出入口
     * @param attendanceIo
     * @return
     */
    @PutMapping
    public AjaxResult updateIo(@RequestBody AttendanceIo attendanceIo){
        return toAjax(attendanceIoService.updateIo(attendanceIo));
    }

    /**
     * 批量删除出入口
     * @param ioIds
     * @return
     */
    @DeleteMapping
    public AjaxResult delIos(@RequestParam int [] ioIds){
        return toAjax(attendanceIoService.delIos(ioIds));
    }
}

