package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改床号")
public class UpdateBedVo {
    @ApiModelProperty("床号id")
    private int bedId;
    @ApiModelProperty("房间id")
    private int roomId;
    @ApiModelProperty("床号")
    private String bedNo;
}
