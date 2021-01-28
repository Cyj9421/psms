package com.psms.project.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.SysNotice;
import com.psms.project.system.domain.SysWorkNumHead;
import com.psms.project.system.service.ISysWorkNumHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/work/head")
public class SysWorkNumHeadController extends BaseController {
    @Autowired
    private ISysWorkNumHeadService sysWorkNumHeadService;

    /**
     * 工号开头列表
     * @param sysWorkNumHead
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public AjaxResult headList(SysWorkNumHead sysWorkNumHead,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<SysWorkNumHead> list = sysWorkNumHeadService.headList(sysWorkNumHead);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 新增工号开头
     * @param sysWorkNumHead
     * @return
     */
    @PostMapping
    public AjaxResult addHead(@RequestBody SysWorkNumHead sysWorkNumHead){
        return toAjax(sysWorkNumHeadService.addHead(sysWorkNumHead));
    }

    /**
     * 修改工号开头
     * @param sysWorkNumHead
     * @return
     */
    @PutMapping
    public AjaxResult updateHead(@RequestBody SysWorkNumHead sysWorkNumHead){
        return toAjax(sysWorkNumHeadService.updateHead(sysWorkNumHead));
    }

    /**
     * 批量删除工号开头
     * @param deptIds
     * @return
     */
    @DeleteMapping("/{deptIds}")
    public AjaxResult delHead(@PathVariable int [] deptIds){
        return toAjax(sysWorkNumHeadService.delHead(deptIds));
    }
}
