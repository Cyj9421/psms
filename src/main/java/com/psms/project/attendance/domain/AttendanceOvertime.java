package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * 加班表
 */
public class AttendanceOvertime {
    /** 加班id */
    private int overtimeId;
    /** 工号 */
    private String workNum;
    /** 下班打卡时间 */
    @JsonFormat(pattern = "hh:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time clockTime;
    /** 加班时长 */
    private double overTime;
    /** 考勤日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clockDate;
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
