package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * 考勤表 sys_attendance
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysAttendance {
    /** 考勤id  */
    private Long attendanceId;
    /** 员工工号 */
    private String workNum;
    /** 部门名称 */
    private String dept_name;
    /** 员工姓名 */
    private String postName;
    /** 是否加班 */
    private String isOvertime;
    /** 是否迟到 */
    private String isLate;
    /** 是否早退 */
    private String isEarly;
    /** 上班时间 */
    private String startTime;
    /** 下班时间 */
    private String endTime;
    /** 考勤状态(0,正常;1,异常) */
    private char attendanceStatus;
}
