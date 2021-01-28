package com.psms.project.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.system.domain.SysDevice;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.SysUnitPrice;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysRoleSalaryService;
import com.psms.project.system.service.ISysUnitPriceService;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单价管理
 */
@RestController
@RequestMapping("/sys/unit/price")
public class SysUnitPriceController extends BaseController {
    @Autowired
    private ISysUnitPriceService sysUnitPriceService;
    @Autowired
    private ISysRoleSalaryService sysRoleSalaryService;
    @Autowired
    private ISysUserNumberService sysUserNumberService;

    /**
     * 单价列表
     * @param sysUnitPrice
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public AjaxResult priceList(SysUnitPrice sysUnitPrice,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUnitPrice> list = sysUnitPriceService.priceList(sysUnitPrice);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     *单价详情
     * @param workNum
     * @return
     */
    @GetMapping("/{workNum}")
    public AjaxResult priceInfo(@PathVariable String workNum){
        return AjaxResult.success(sysUnitPriceService.priceInfo(workNum));
    }

    /**
     * 添加单价
     * @param sysUnitPrice
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addPrice(@RequestBody SysUnitPrice sysUnitPrice){
           SysUserNumber sysUserNumber=sysUserNumberService.numberByWorkNum(sysUnitPrice.getWorkNum());
           if(sysUserNumber==null) {
               return AjaxResult.success("工号输入错误");
           }
        return toAjax(sysUnitPriceService.addPrice(sysUnitPrice));
    }

    /**
     * 更新单价
     * @param sysUnitPrice
     * @return
     */
    @PutMapping
    public AjaxResult updatePrice(@RequestBody SysUnitPrice sysUnitPrice){
        return toAjax(sysUnitPriceService.updatePrice(sysUnitPrice));
    }

    /**
     * 批量删除单价
     * @param priceIds
     * @return
     */
    @DeleteMapping("/{priceIds}")
    public AjaxResult delPrice(@PathVariable int [] priceIds){
        return toAjax(sysUnitPriceService.delPrice(priceIds));
    }
}
