package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//加分、过失
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRp implements Serializable {
    private int rpId;//奖惩Id
    private String workNum;//工号
    private String fullName;//姓名
    private String deptName;//部门名称
    private String postName;//职位名称
    private String postCode;//职位编码
    private String leader;//部门负责人
    private int operation;//操作（1：奖励；2：惩罚；3：其他）
    private int rpWay;//奖惩具体方式（1：现金；2：其他）
    private double cashAmount;//奖惩金额数量
    private String rpInfo;//奖惩备注
    private String nickName;//当前办理人员姓名
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;//当前办理时间
    private String updateBy;//当前审核人员姓名
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;//当前审核时间
    private int rpStatus;//审核状态（1：审核中；2：通过；3：失败）
}
