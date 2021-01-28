package com.psms.project.attendance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 考勤卡号
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceCard {
    /** 卡号id */
    private int cardId;
    /** 工号 */
    private String workNum;
    /** 卡号 */
    private String cardNum;
    /** 姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 部门领导 */
    private String leader;
    /** 职位名称 */
    private String postName;
    /** 岗位编码 */
    private String postCode;
}
