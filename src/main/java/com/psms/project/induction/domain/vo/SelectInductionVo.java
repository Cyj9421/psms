package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询入职表")
public class SelectInductionVo {
    @ApiModelProperty("国籍名")
    private String citizenshipName;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("性别(1男,2女)")
    private int sex;
    @ApiModelProperty("试用期状态(1已转正,2试用中(默认))")
    private int probationStatus;
}
