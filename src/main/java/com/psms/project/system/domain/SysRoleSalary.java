package com.psms.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psms.project.attendance.domain.AttendanceSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 工资汇总表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRoleSalary {
    /** 工资id */
    private int salaryId;
    /** 底薪 */
    private double baseSalary;
    /** 加班总额 */
    private double overtimeSalary;
    /** 奖金总额 */
    private double bonus;
    /** 罚款总额 */
    private double penalty;
    /** 迟到扣款总额 */
    private double lateSalary;
    /** 早退扣款总额 */
    private double earlySalary;
    /** 缺勤扣款总额 */
    private double afdSalary;
    /** 备注(其他收入) */
    private double remark;
    /** 工资总额 */
    private double salary;
    /** 领取状态(1领取,2未发放,3未领取）(默认2) */
    private int getStatus;
    /** 领取时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date getTime;
//    /** 考勤汇总对象 */
//    private List<AttendnceSummary> attendnceSummaries;
    /** 员工工号 */
    private String workNum;
    /** 员工姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 部门负责人 */
    private String leader;
    /** 岗位名称 */
    private String postName;
    /** 岗位编码 */
    private String postCode;
    /** 薪资单价列表 */
    private List<SysUnitPrice> sysUnitPrices;
    /** 考勤列表 */
    private List<AttendanceSummary> attendanceSummaries;
}
