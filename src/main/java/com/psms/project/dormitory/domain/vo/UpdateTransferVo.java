package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("审核调动房间参数")
public class UpdateTransferVo {
    @ApiModelProperty("调动id")
    public int transferId;
    @ApiModelProperty("调动状态(1审核成功,2审核中,3审核不通过)")
    public int transferStatus;
}
