package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//早退
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEarly implements Serializable {
    private int earlyId;//早退ID
    private String workNum;//工号
    private String fullName;//姓名
    private String deptName;//部门名称
    private String leader;//部门领导
    private String postName;//职位名称
    private String postCode;//岗位编码
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time earlyTime;//早退时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date earlyDate;//考勤日期
}
