package com.psms.project.induction.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel("入职员工表")
public class InductionStaff {
    @ApiModelProperty("入职id")
    private int inductionId;
    @ApiModelProperty("国籍id")
    private int citizenshipId;
    @ApiModelProperty("币种id")
    private int currencyId;
    @ApiModelProperty("岗位id")
    private Long postId;
    @ApiModelProperty("试用期id")
    private int probationId;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("性别(1男,2女)")
    private int sex;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("工资")
    private double salary;
    @ApiModelProperty("个人照片")
    private String personalPhoto;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("押金")
    private double deposit;
}
