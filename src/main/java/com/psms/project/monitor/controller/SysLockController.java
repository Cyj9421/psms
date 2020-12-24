package com.psms.project.monitor.controller;

import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.monitor.domain.SysLock;
import com.psms.project.monitor.service.ISysLockService;
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
    public AjaxResult lockList(SysLock sysLock){
        return AjaxResult.success(sysLockService.lockList(sysLock));
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
    @PostMapping("/lock")
    public AjaxResult lock(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String date=dateFormat.format(new Date());
        sysLockService.isFlase();
        List<String> list=sysLockService.dateList();
        if(list.size()>0){
            for (int i=0;i<list.size();i++) {
                if(list.get(i).equals(date)){
                    return toAjax(sysLockService.isTrue());
                }else{
                    return toAjax(sysLockService.isFlase());
                }
            }
        }return AjaxResult.error("还没有设置锁定日期");
    }
}
