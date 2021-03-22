package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改学历参数表")
public class UpdateEducationBackgroundVo {
    @ApiModelProperty("学历id")
    private int educationId;
    @ApiModelProperty("学历")
    private String educationBackground;
}
