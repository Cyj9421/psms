package com.psms.project.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysDevice;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.service.ISysDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制层 设备管理
 */
@RestController
@RequestMapping("/system/device")
public class SysDeviceController extends BaseController {
    @Autowired
    private ISysDeviceService sysDeviceService;

    /**
     * 设备列表
     * @param sysDevice
     * @return
     */
    @GetMapping("/list")
    public AjaxResult deviceList(SysDevice sysDevice,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysDevice> list = sysDeviceService.deviceList(sysDevice);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 添加设备
     * @param sysDevice
     * @return
     */
    @PostMapping
    public AjaxResult addDevice(@RequestBody SysDevice sysDevice){
        return toAjax(sysDeviceService.addDevice(sysDevice));
    }
    /**
     * 设备管理
     * @param sysDevice
     * @return
     */
    @PutMapping("/update")
    public AjaxResult deviceManager(@RequestBody SysDevice sysDevice){
        return toAjax(sysDeviceService.deviceManager(sysDevice));
    }

    /**
     * 设备注销
     * @param sysDevice
     * @return
     */
    @PutMapping("/del")
    public AjaxResult delDevice(@RequestBody SysDevice sysDevice){
        return toAjax(sysDeviceService.deviceManager(sysDevice));
    }
}
