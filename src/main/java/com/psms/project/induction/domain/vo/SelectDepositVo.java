package com.psms.project.induction.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("押金列表查询参数")
public class SelectDepositVo {
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("操作类型(1退押金,2退机票,3正常)")
    private int operType;
    @JsonIgnore
    @ApiModelProperty("开始时间")
    private String beginTime;
    @JsonIgnore
    @ApiModelProperty("结束时间")
    private String endTime;
}
