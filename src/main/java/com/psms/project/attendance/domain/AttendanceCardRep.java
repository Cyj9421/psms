package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

//补卡
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendanceCardRep  {
    private int replacementId;//补卡ID
    private String workNum;//工号
    private String fullName;//姓名
    private String deptName;//部门名称
    private String leader;//部门领导
    private String postName;//职位名称
    private String postCode;//职位编码
    private String reason;//补卡原因
    private int repType;//补卡类型(0,迟到,1,缺勤)
    private int cardStatus;//补卡状态（0：批准；1：审核中；2:补卡失败）
    private String nickName;//办理者姓名
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date nickTime;//办理时间
    private String updateBy;//审核者
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;//审核时间
}
