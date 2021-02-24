package com.psms.project.induction.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("试用期表")
public class InductionProbation {
    @ApiModelProperty("试用期id")
    private int probationId;
    @ApiModelProperty("试用期-月")
    private int probationMonth;
    @ApiModelProperty("试用期-日")
    private int probationDay;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
