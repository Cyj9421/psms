package com.psms.project.monitor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.monitor.domain.SysLock;
import com.psms.project.monitor.service.ISysLockService;
import com.psms.project.system.domain.SysUserNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 系统锁定
 */
@RestController
@RequestMapping("/system/lock")
public class SysLockController extends BaseController {
    @Autowired
    private ISysLockService sysLockService;

    /**
     * 锁定日期列表
     * @param sysLock
     * @return
     */
    @GetMapping("/list")
    public AjaxResult lockList(SysLock sysLock,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysLock> list = sysLockService.lockList(sysLock);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    /**
     * 添加锁定日期
     * @param sysLock
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addLock(@RequestBody SysLock sysLock){
        sysLock.setCreateBy(SecurityUtils.getUsername());
        return toAjax(sysLockService.addLock(sysLock));
    }
    /**
     * 修改锁定日期
     * @param sysLock
     * @return
     */
    @PutMapping("/update")
    public AjaxResult updateLock(@RequestBody SysLock sysLock){
        sysLock.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(sysLockService.updateLock(sysLock));
    }

    /**
     * 批量删除锁定日期
     * @param lockIds
     * @return
     */
    @DeleteMapping("/{lockIds}")
    public AjaxResult delDates(@PathVariable int [] lockIds){
        return toAjax(sysLockService.delDates(lockIds));
    }

}
