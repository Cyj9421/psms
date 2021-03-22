package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("房间入住详情")
public class DormitoryRoomInfoVo {
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("姓")
    private String firstName;
    @ApiModelProperty("名")
    private String lastName;
    @ApiModelProperty("性别(1男,2女)")
    private int sex;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("班别名")
    private String scheduleName;
    @ApiModelProperty("房间名称")
    private String roomName;
    @ApiModelProperty("房间类型名称")
    private String typeName;
    @ApiModelProperty("宿舍楼名称")
    private String dormitoryName;
    @ApiModelProperty("备注")
    private String remark;
}
