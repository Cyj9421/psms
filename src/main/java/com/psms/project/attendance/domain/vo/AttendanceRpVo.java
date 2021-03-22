package com.psms.project.attendance.domain.vo;

import lombok.Data;

/**
 * 部门奖惩汇总
 */
@Data
public class AttendanceRpVo {
    /** 扣分次数 */
    private int punishmentNum;
    /** 加分次数 */
    private int rewardsNum;
    /** 部门名称 */
    private String deptName;
}
