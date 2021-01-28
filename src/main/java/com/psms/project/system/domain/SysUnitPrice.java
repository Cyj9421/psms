package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 薪资单价表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysUnitPrice {
    /** 单价id */
    private int priceId;
    /** 员工工号 */
    private String workNum;
    /** 底薪 */
    private double baseSalary;
    /** 加班单价 */
    private double overtimePrice;
    /** 缺勤扣款单价 */
    private double afdPrice;
    /** 迟到扣款单价 */
    private double latePrice;
    /** 早退扣款单价 */
    private double earlyPrice;
    /** 备注 */
    private double remark;
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
}
