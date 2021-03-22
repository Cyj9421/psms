package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查找房间参数")
public class SelectRoomVo {
    @ApiModelProperty("宿舍id")
    private String dormitoryId;
}
