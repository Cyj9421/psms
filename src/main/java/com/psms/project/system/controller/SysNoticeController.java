package com.psms.project.system.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.project.system.domain.SysDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.psms.common.utils.SecurityUtils;
import com.psms.framework.aspectj.lang.annotation.Log;
import com.psms.framework.aspectj.lang.enums.BusinessType;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.framework.web.page.TableDataInfo;
import com.psms.project.system.domain.SysNotice;
import com.psms.project.system.service.ISysNoticeService;

/**
 * 公告 信息操作处理
 *
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController
{
    @Autowired
    private ISysNoticeService noticeService;

    /**
     * 获取通知公告列表
     */
//    @PreAuthorize("@ss.hasPermi('system:notice:list')")
    @GetMapping("/list")
    public AjaxResult list(SysNotice notice,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }


    /**
     * 根据通知公告编号获取详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId)
    {
        return AjaxResult.success(noticeService.selectNoticeById(noticeId));
    }

    /**
     * 新增通知公告
     */
//    @PreAuthorize("@ss.hasPermi('system:notice:add')")
    @Log(title = "通知公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysNotice notice)
    {
        notice.setCreateBy(SecurityUtils.getUsername());
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * 修改通知公告
     */
//    @PreAuthorize("@ss.hasPermi('system:notice:edit')")
    @Log(title = "通知公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysNotice notice)
    {
        notice.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(noticeService.updateNotice(notice));
    }

    /**
     * 删除通知公告
     */
//    @PreAuthorize("@ss.hasPermi('system:notice:remove')")
    @Log(title = "通知公告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(noticeService.deleteNoticeByIds(noticeIds));
    }
}
