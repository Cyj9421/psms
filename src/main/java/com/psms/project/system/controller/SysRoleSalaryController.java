package com.psms.project.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.service.IAttendanceRpService;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.SysUnitPrice;
import com.psms.project.system.service.ISysRoleSalaryService;
import com.psms.project.system.service.ISysUnitPriceService;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 工资汇总
 */
@RestController
@RequestMapping("/system/role/salary")
public class SysRoleSalaryController extends BaseController {
    @Autowired
    private ISysRoleSalaryService sysRoleSalaryService;
    @Autowired
    private ISysUserNumberService sysUserNumberService;
    @Autowired
    private ISysUnitPriceService sysUnitPriceService;
    /**
     * 工资列表
     * @param sysRoleSalary
     * @return
     */
    @GetMapping("/list")
    public AjaxResult salaryList(SysRoleSalary sysRoleSalary, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysRoleSalary> list = sysRoleSalaryService.salaryList(sysRoleSalary);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 工资详情
     * @param salaryId
     * @return
     */
    @GetMapping("/{salaryId}")
    public AjaxResult salaryInfo(@PathVariable("salaryId") int salaryId){
        return AjaxResult.success(sysRoleSalaryService.salaryInfo(salaryId));
    }
    /**
     * 领取工资
     * @param sysRoleSalary
     * @return
     */
    @PutMapping("/get")
    public AjaxResult getSalary(@RequestBody SysRoleSalary sysRoleSalary){
            sysRoleSalary.setGetTime(new Date());
        return toAjax(sysRoleSalaryService.getSalary(sysRoleSalary));
    }
    /**
     * 计算工资
     * @return
     */
    @PostMapping("/calc")
    public AjaxResult calcSalary(){
        List<String> list=sysUserNumberService.numList();
        Calendar c = Calendar.getInstance();
        AttendanceSummary summary=new AttendanceSummary();
        for(int i=0;i<list.size();i++) {
            c.setTime(new Date());
            summary.setSummaryMonth(c.get(Calendar.MONTH)+1);
            summary.setSummaryQuarter(c.get(Calendar.MONTH)/3+1);
            summary.setSummaryYear(c.get(Calendar.YEAR));
            summary.setWorkNum(list.get(i));
            SysUnitPrice sysUnitPrice = sysUnitPriceService.priceInfo(list.get(i));
            SysRoleSalary sysRoleSalary = new SysRoleSalary();
            summary= sysRoleSalaryService.calcSummary(summary);
            sysRoleSalary.setWorkNum(list.get(i));
            sysRoleSalary.setBaseSalary(sysUnitPrice.getBaseSalary());
            sysRoleSalary.setOvertimeSalary(summary.getOvertime() * sysUnitPrice.getOvertimePrice());
            sysRoleSalary.setBonus(summary.getRewards());
            sysRoleSalary.setPenalty(summary.getPunishments());
            sysRoleSalary.setLateSalary(sysUnitPrice.getLatePrice() * summary.getLateNum());
            sysRoleSalary.setEarlySalary(sysUnitPrice.getEarlyPrice() * summary.getEarlyNum());
            sysRoleSalary.setAfdSalary(sysUnitPrice.getAfdPrice() * summary.getAfdNum());
            sysRoleSalary.setRemark(sysUnitPrice.getRemark());
            double salary = sysRoleSalary.getBaseSalary() + sysRoleSalary.getBonus() + sysRoleSalary.getOvertimeSalary() +
                    sysRoleSalary.getRemark() - sysRoleSalary.getPenalty() - sysRoleSalary.getLateSalary() -
                    sysRoleSalary.getEarlySalary() - sysRoleSalary.getAfdSalary();
            sysRoleSalary.setSalary(salary);
            sysRoleSalaryService.addSalary(sysRoleSalary);
        }
        return AjaxResult.success();
    }
}
