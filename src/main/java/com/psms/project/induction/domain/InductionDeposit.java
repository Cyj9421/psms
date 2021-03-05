package com.psms.project.induction.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("押金表")
public class InductionDeposit {

    @ApiModelProperty("押金id")
    private int depositId;

    @ApiModelProperty("工号")
    private String workNum;

    @ApiModelProperty("机票")
    private int airTicket;

    @ApiModelProperty("押金备注")
    private String depositRemark;

    @ApiModelProperty("押金")
    private double deposit;
}
