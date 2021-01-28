package com.psms.project.attendance.domain;

import com.psms.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 考勤汇总
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceSummary {
    /** 考勤汇总id */
    private int summaryId;
    /** 姓名 */
    private String fullName;
    /** 工号 */
    private String workNum;
    /** 部门名称 */
    private String deptName;
    /** 部门领导 */
    private String leader;
    /** 职位名称 */
    private String postName;
    /** 岗位编码 */
    private String postCode;
    /** 迟到次数 */
    private int lateNum;
    /** 早退次数 */
    private int earlyNum;
    /** 缺勤次数 */
    private int afdNum;
    /** 加班时长 */
    private double overtime;
    /** 加分次数 */
    private int rewardsNum;
    /** 加分总额 */
    private double rewards;
    /** 扣分次数 */
    private int punishmentNum;
    /** 扣分总额 */
    private double punishments;
    /** 出差次数 */
    private int btNum;
    /** 报表类型(1日,2月(默认),3季,4年) */
    private int reportType;
    /** 月份 */
    private int summaryMonth;
    /** 季份 */
    private int summaryQuarter;
    /** 年份 */
    private int summaryYear;
}
