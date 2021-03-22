package com.psms.project.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("领取工资参数详情")
public class SysGetSalaryVo {
    @ApiModelProperty("总人数")
    private int headcount;
    @ApiModelProperty("领取人数统计")
    private int receiveCount;
    @ApiModelProperty("未领取人数统计")
    private int notReceiveCount;
    @ApiModelProperty("领取工资统计")
    private double receiveSalaryCount;
    @ApiModelProperty("未领取工资统计")
    private double notReceiveSalaryCount;
    @ApiModelProperty("币种")
    private String currencyName;
}
