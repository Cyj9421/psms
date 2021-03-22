package com.psms.project.system.service;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.system.domain.SysRoleSalary;
import com.psms.project.system.domain.SysUnitPrice;
import com.psms.project.system.domain.vo.SysGetSalaryVo;

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
     * 领取参数详情
     * @return
     */
    public List<SysGetSalaryVo> getSalaryList(int salaryYear, int salaryMonth);

    /**
     * 新增工资数据
     * @param sysRoleSalary
     * @return
     */
    public int addSalary(SysRoleSalary sysRoleSalary);
    /**
     * 更新工资数据
     * @param sysRoleSalary
     * @return
     */
    public int updateSalary(SysRoleSalary sysRoleSalary);
    /**
     * 领取工资
     * @param sysRoleSalary
     * @return
     */
    public int getSalary(SysRoleSalary sysRoleSalary);

    /**
     * 统计考勤
     * @return
     */
    public AttendanceSummary calcSummary(AttendanceSummary attendanceSummary);

}



