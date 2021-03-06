package com.psms.project.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工号开头表
 */
@Data
@ApiModel("工号开头")
public class SysWorkNumHead {
    @ApiModelProperty("工号开头id")
    private int headId;
    @ApiModelProperty("工号开头")
    private String workNumHead;
    @ApiModelProperty("工号编码计数")
    private int numTotal;
    @ApiModelProperty("部门id")
    private long deptId;
    @ApiModelProperty("岗位id")
    private long postId;
}
