package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//迟到
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendanceLate  {
    private Integer lateId;//迟到ID
    private String workNum;//工号
    private String fullName;//姓名
    private String deptName;//部门名称
    private String leader;//部门领导
    private String postName;//职位名称
    private String postCode;//岗位编码
    @JsonFormat(pattern = "hh:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time lateTime;//迟到时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lateDate;//考勤日期

}
