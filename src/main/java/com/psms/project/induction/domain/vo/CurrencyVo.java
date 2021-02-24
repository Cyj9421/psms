package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("币种参数表")
public class CurrencyVo {
    @ApiModelProperty("币种id")
    private int currencyId;
    @ApiModelProperty("币种名称")
    private String currencyName;
    @ApiModelProperty("备注")
    private String remark;
}
