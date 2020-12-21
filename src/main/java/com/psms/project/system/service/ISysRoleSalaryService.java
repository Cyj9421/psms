package com.psms.project.system.service;

import com.psms.project.bussiness.domain.AttendnceSummary;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.vo.SalaryVo;

import java.util.List;

/**
 * 服务层 工资汇总
 */
public interface ISysRoleSalaryService {
    /**
     * 工资汇总列表
     * @param sysRoleSalary
     * @return
     */
    public List<SysRoleSalary> salaryList(SysRoleSalary sysRoleSalary);
    /**
     * 查询工资详情
     * @param salaryId
     * @return
     */
    public SysRoleSalary salaryInfo(int salaryId);
    /**
     * 新增工资数据
     * @param sysRoleSalary
     * @return
     */
    public int addSalary(SysRoleSalary sysRoleSalary);
    /**
     * 领取工资
     * @param sysRoleSalary
     * @return
     */
    public int getSalary(SysRoleSalary sysRoleSalary);
    /**
     * 计算工资
     * @return
     */
    public int calcSalary(SalaryVo salaryVo);
    /**
     * 统计考勤
     * @return
     */
    public AttendnceSummary calcSummary(int workNumId);


}
