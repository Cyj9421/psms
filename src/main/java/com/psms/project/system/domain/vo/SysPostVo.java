package com.psms.project.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("部门岗位列表")
public class SysPostVo {
    @ApiModelProperty("部门id")
    private long deptId;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("岗位id")
    private long postId;
    @ApiModelProperty("岗位名称")
    private String postName;
}
