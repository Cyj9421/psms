package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改宿舍参数")
public class UpdateDormitoryVo {
    @ApiModelProperty("宿舍id")
    private int dormitoryId;
    @ApiModelProperty("宿舍名称")
    private String dormitoryName;
}
