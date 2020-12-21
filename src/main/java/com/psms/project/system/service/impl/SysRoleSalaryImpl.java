package com.psms.project.system.service.impl;

import com.psms.project.bussiness.domain.AttendnceSummary;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.vo.SalaryVo;
import com.psms.project.system.mapper.SysRoleSalaryMapper;
import com.psms.project.system.service.ISysRoleSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 工资汇总
 */
@Service
public class SysRoleSalaryImpl implements ISysRoleSalaryService {
    @Autowired
    private SysRoleSalaryMapper sysRoleSalaryMapper;

    /**
     * 工资列表
     * @param sysRoleSalary
     * @return
     */
    @Override
    public List<SysRoleSalary> salaryList(SysRoleSalary sysRoleSalary) {
        return sysRoleSalaryMapper.salaryList(sysRoleSalary);
    }

    /**
     * 工资详情
     * @param salaryId
     * @return
     */
    @Override
    public SysRoleSalary salaryInfo(int salaryId) {
        return sysRoleSalaryMapper.salaryInfo(salaryId);
    }

    /**
     * 新增工资数据
     * @param sysRoleSalary
     * @return
     */
    @Override
    public int addSalary(SysRoleSalary sysRoleSalary) {
        return sysRoleSalaryMapper.addSalary(sysRoleSalary);
    }

    /**
     * 领取工资
     * @param sysRoleSalary
     * @return
     */
    @Override
    public int getSalary(SysRoleSalary sysRoleSalary) {
        return sysRoleSalaryMapper.getSalary(sysRoleSalary);
    }

    /**
     * 计算工资
     * @param salaryVo
     * @return
     */
    @Override
    public int calcSalary(SalaryVo salaryVo) {
        return sysRoleSalaryMapper.calcSalary(salaryVo);
    }

    @Override
    public AttendnceSummary calcSummary(int workId) {
        return sysRoleSalaryMapper.calcSummary(workId);
    }
}
