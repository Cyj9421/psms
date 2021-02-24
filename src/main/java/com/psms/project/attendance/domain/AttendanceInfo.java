package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//考勤
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceInfo implements Serializable {
    private int attendanceId;//考勤ID
    private String workNum;//工号
    private int isOvertime;//是否加班(0:否；1：是)
    private int isLate;//是否迟到(0:否；1：是)
    private int isEarly;//是否早退(0:否；1：是)
    private int isAbsenteeism; //是否缺勤(0:否；1：是)
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time startTime;//上班打卡时间
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time endTime;//下班打卡时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date attendanceDate;//考勤日期
    private Integer attendanceStatus;//考勤状态（0：正常；1：异常）
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
    private String personalPhoto;

}
