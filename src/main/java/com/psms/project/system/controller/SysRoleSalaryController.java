package com.psms.project.system.controller;

import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.bussiness.domain.AttendnceSummary;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.vo.SalaryVo;
import com.psms.project.system.service.ISysRoleSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 工资列表
     * @param sysRoleSalary
     * @return
     */
    @GetMapping("/list")
    public AjaxResult salaryList(SysRoleSalary sysRoleSalary){
        startPage();
        List<SysRoleSalary> info=sysRoleSalaryService.salaryList(sysRoleSalary);
        return AjaxResult.success(info);
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
     * @param salaryVo
     * @return
     */
    @PostMapping("/calc")
    public AjaxResult calcSalary(@RequestBody SalaryVo salaryVo){
        SysRoleSalary sysRoleSalary=new SysRoleSalary();
        AttendnceSummary summary=sysRoleSalaryService.calcSummary(salaryVo.getWorkId());
        sysRoleSalary.setWorkId(salaryVo.getWorkId());
        sysRoleSalary.setBaseSalary(salaryVo.getBaseSalary());
        sysRoleSalary.setOvertimeSalary((summary.getOvertime()/60)*salaryVo.getOvertimePrice());
        sysRoleSalary.setBonus(salaryVo.getBonusPrice()*summary.getRewardsNum());
        sysRoleSalary.setPenalty(salaryVo.getPenaltyPrice()*summary.getPunishmentNum());
        sysRoleSalary.setLateSalary(salaryVo.getLatePrice()*summary.getLateNum());
        sysRoleSalary.setEarlySalary(salaryVo.getEarlyPrice()*summary.getEarlyNum());
        sysRoleSalary.setAfdSalary(salaryVo.getAfdPrice()*summary.getAfdNum());
        sysRoleSalary.setRemark(salaryVo.getRemark());
        double salary=sysRoleSalary.getBaseSalary()+sysRoleSalary.getBonus()+sysRoleSalary.getOvertimeSalary()+
                sysRoleSalary.getRemark()-sysRoleSalary.getPenalty()- sysRoleSalary.getLateSalary()-
                sysRoleSalary.getEarlySalary()-sysRoleSalary.getAfdSalary();
        sysRoleSalary.setSalary(salary);
        return toAjax(sysRoleSalaryService.addSalary(sysRoleSalary));
    }
}
