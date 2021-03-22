package com.psms.project.dormitory.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("申请调动参数")
public class InsertTransferVo {
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("宿舍id")
    private Integer dormitoryId;
    @ApiModelProperty("房间id")
    private Integer roomId;
    @ApiModelProperty("调动申请日期")
    private Date createDate;
    @ApiModelProperty("备注")
    private String remark;
}
