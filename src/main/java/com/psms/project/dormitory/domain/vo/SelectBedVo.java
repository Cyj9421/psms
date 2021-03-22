package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查看床位列表参数")
public class SelectBedVo {
    @ApiModelProperty("房间id")
    private int roomId;
}
