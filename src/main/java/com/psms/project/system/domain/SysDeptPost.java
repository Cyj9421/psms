package com.psms.project.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("部门岗位")
public class SysDeptPost {
    @ApiModelProperty("主键自增id")
    private int id;
    @ApiModelProperty("部门id")
    private long deptId;
    @ApiModelProperty("岗位id")
    private long postId;
}
