package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改类型参数")
public class UpdateRoomTypeVo {
    @ApiModelProperty("类型id")
    private int typeId;
    @ApiModelProperty("类型名称")
    private String typeName;
}
