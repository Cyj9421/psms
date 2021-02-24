package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("新增入职参数表")
public class InsertInductionVo {
    @ApiModelProperty("国籍id")
    private int citizenshipId;
    @ApiModelProperty("币种id")
    private int currencyId;
    @ApiModelProperty("岗位id")
    private Long postId;
    @ApiModelProperty("试用期id(新增忽略该参数)")
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
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("押金")
    private double deposit;
    @ApiModelProperty("试用期-月")
    private int probationMonth;
    @ApiModelProperty("试用期-日")
    private int probationDay;

}
