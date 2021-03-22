package com.psms.project.attendance.domain;

import com.psms.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 考勤汇总
 */
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
    /** 职位名称 */
    private String postName;
    /** 出勤次数 */
    private int attendanceNum;
    /** 请假次数 */
    private int askNum;
    /** 休假次数 */
    private int vacateNum;
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
    /** 是否全勤(1是,2否) */
    private int isFullTime;
    /** 报表类型(1月,2季,3年) */
    private int reportType;
    /** 月份 */
    private int summaryMonth;
    /** 季份 */
    private int summaryQuarter;
    /** 年份 */
    private int summaryYear;
    /** 薪资 */
    private double salary;
    /** 查询类型(1未出勤,2休假中,3迟到,4早退,5旷工,6犯错,7已出勤) */
    private int selectType;
}
