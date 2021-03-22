package com.psms.project.induction.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("工牌返回参数")
public class InductionWorkCard {
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("姓")
    private String lastName;
    @ApiModelProperty("名")
    private String firstName;
    @ApiModelProperty("性别")
    private Integer sex;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("班别")
    private String scheduleName;
    @ApiModelProperty("房间号")
    private String roomName;
    @ApiModelProperty("宿舍名")
    private String dormitoryName;
    @ApiModelProperty("电话号码")
    private String phoneNumber;
    @ApiModelProperty("证件照")
    private String passport;
}
