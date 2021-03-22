package com.psms.project.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("部门岗位")
public class SysDeptPostVo {
    @ApiModelProperty("部门id")
    private long deptId;
    @ApiModelProperty("岗位id")
    private long postId;
}
