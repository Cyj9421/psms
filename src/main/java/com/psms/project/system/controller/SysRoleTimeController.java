package com.psms.project.system.controller;

import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysRoleTimeManager;
import com.psms.project.system.service.ISysRoleTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/role")
public class SysRoleTimeController {
    @Autowired
    private ISysRoleTimeService iSysRoleTimeService;
    @PostMapping("/add")
    public AjaxResult addTime(@RequestBody SysRoleTimeManager sysRoleTimeManager){
        int result=iSysRoleTimeService.addTime(sysRoleTimeManager);
        if(result<=0){
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
}
