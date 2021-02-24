package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("国籍参数表")
public class CitizenshipVo {
    @ApiModelProperty("国籍id(新增时不带)")
    private int citizenshipId;
    @ApiModelProperty("国籍名称")
    private String citizenshipName;
    @ApiModelProperty("备注")
    private String remark;
}
