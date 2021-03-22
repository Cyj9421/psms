package com.psms.project.system.service.impl;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.SysUnitPrice;
import com.psms.project.system.domain.vo.SysGetSalaryVo;
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
     * 领取工资详情
     * @param salaryYear
     * @param salaryMonth
     * @return
     */
    @Override
    public List<SysGetSalaryVo> getSalaryList(int salaryYear, int salaryMonth) {
        return sysRoleSalaryMapper.getSalaryList(salaryYear,salaryMonth);
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
     * 更新工资数据
     * @param sysRoleSalary
     * @return
     */
    @Override
    public int updateSalary(SysRoleSalary sysRoleSalary) {
        return sysRoleSalaryMapper.updateSalary(sysRoleSalary);
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
     * 统计考勤
     * @param attendanceSummary
     * @return
     */
    @Override
    public AttendanceSummary calcSummary(AttendanceSummary attendanceSummary) {
        return sysRoleSalaryMapper.calcSummary(attendanceSummary);
    }
}
