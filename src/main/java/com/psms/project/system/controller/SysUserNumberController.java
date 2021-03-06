package com.psms.project.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.domain.SysWorkNumHead;
import com.psms.project.system.service.ISysUserNumberService;
import com.psms.project.system.service.ISysWorkNumHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 员工工号
 */
@RestController
@RequestMapping("/system/user/work")
public class SysUserNumberController extends BaseController {
    @Autowired
    private ISysUserNumberService sysUserNumberService;
    @Autowired
    private ISysWorkNumHeadService workNumHeadService;
    /**
     * 工号列表
     * @param sysUserNumber
     * @return
     */
    @GetMapping("/list")
    public AjaxResult numberList(SysUserNumber sysUserNumber,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUserNumber> list = sysUserNumberService.numberList(sysUserNumber);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/generate")
    public AjaxResult generateWorkNum(@RequestParam(value = "deptId") long deptId,
                                      @RequestParam(value = "postId") long postId){
        SysWorkNumHead workNumHead=workNumHeadService.selectHeadByDeptId(deptId,postId);
        if(workNumHead ==null){
            return AjaxResult.error(400,"没有该工号开头，请设置!");
        }
        String body=String.format("%06d",workNumHead.getNumTotal()+1);
        String workNum=workNumHead.getWorkNumHead()+body;
        AjaxResult ajax=AjaxResult.success();
        ajax.put("workNum",workNum);
        return ajax;
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
     * 注销工号
     * @param sysUserNumber
     * @return
     */
    @PutMapping
    public AjaxResult delNumber(@RequestBody SysUserNumber sysUserNumber){
        sysUserNumber.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(sysUserNumberService.delNumbers(sysUserNumber));
    }
}
