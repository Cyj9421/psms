package com.psms.project.dormitory.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("房间管理")
public class DormitoryRoom {
    @ApiModelProperty("房间id")
    private int roomId;
    @ApiModelProperty("宿舍id")
    private int dormitoryId;
    @ApiModelProperty("房间类型id")
    private int typeId;
    @ApiModelProperty("房间名称")
    private String roomName;
    @ApiModelProperty("房间容量")
    private int roomCapacity;
    @ApiModelProperty("备注")
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("类型名称")
    private String typeName;
    @ApiModelProperty("宿舍名称")
    private String dormitoryName;
}
