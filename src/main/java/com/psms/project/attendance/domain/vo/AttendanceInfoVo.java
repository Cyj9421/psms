package com.psms.project.attendance.domain.vo;

import lombok.Data;
import java.util.Date;

@Data
public class AttendanceInfoVo {
    /** 工号 */
    private String workNum;
    /** 姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 个人照片 */
    private String personalPhoto;
    /** 考勤时间 */
    private String attendanceTime;
}
