package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//请假
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceAskOff implements Serializable {
    private int askId;//请假ID
    private String workNum;//工号
    private String fullName;//姓名
    private String deptName;//部门名称
    private String leader;//部门领导
    private String postName;//职位名称
    private String postCode;//职位编号
    private int askType;//请假类型(0请假,1休假)
    private String reason;//请假原因
    private Integer askStatus;//申请状态（0：批准；1：审核中；2:申请失败）(默认1)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date askFrom;//开始时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date askTo;//结束时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date askTime;//申请时间
    private String updateBy;//审核人
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss")
    private Date updateTime;//审核时间
}

