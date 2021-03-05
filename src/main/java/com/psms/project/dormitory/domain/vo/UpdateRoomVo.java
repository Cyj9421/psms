package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改房间参数")
public class UpdateRoomVo {
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
}
