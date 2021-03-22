package com.psms.project.attendance.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("部门考勤汇总列表")
public class AttendanceSummaryVo {
    /** 部门名称 */
    private String deptName;
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
    /** 加分次数 */
    private int rewardsNum;
    /** 扣分次数 */
    private int punishmentNum;
    /** 是否全勤(1是,2否) */
    private int isFullTime;
}
