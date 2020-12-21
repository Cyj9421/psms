package com.psms.project.system.controller;

import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 员工工号
 */
@RestController
@RequestMapping("/system/user/work")
public class SysUserNumberController extends BaseController {
    @Autowired
    private ISysUserNumberService sysUserNumberService;

    /**
     * 工号列表
     * @param sysUserNumber
     * @return
     */
    @GetMapping("/list")
    public AjaxResult numberList(SysUserNumber sysUserNumber){
        return AjaxResult.success(sysUserNumberService.numberList(sysUserNumber));
    }

    /**
     * 工号详情
     * @param sysUserNumber
     * @return
     */
    @GetMapping("/info")
    public AjaxResult numberInfo(@RequestBody SysUserNumber sysUserNumber){
        return AjaxResult.success(sysUserNumberService.numberInfo(sysUserNumber.getWorkId()));
    }

    /**
     * 新增工号
     * @param sysUserNumber
     * @return
     */
//    @PreAuthorize("@ss.hasPermi('system:user:work:add')")
    @PostMapping("/add")
    public AjaxResult addNumber(@RequestBody SysUserNumber sysUserNumber){
        SysUserNumber numberinfo=sysUserNumberService.checkNum(sysUserNumber.getFullName());
        if(numberinfo != null){
            numberinfo.setUpdateBy("cyj");
            numberinfo.setUpdateTime(new Date());
            sysUserNumberService.saveNewNum(numberinfo);
            return AjaxResult.error("老员工,已生成新的工号");
        }
        Date now=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String body=dateFormat.format(now);
        sysUserNumber.setWorkNum(sysUserNumber.getWorkNumHead()+body);
        sysUserNumber.setCreateBy("root");
        sysUserNumber.setCreateTime(new Date());
        return toAjax(sysUserNumberService.addNumber(sysUserNumber));
    }
}
