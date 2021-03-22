package com.psms.project.dormitory.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("房间调动")
public class DormitoryTransfer {
    @ApiModelProperty("调动id")
    private Integer transferId;

    @ApiModelProperty("宿舍id")
    private Integer dormitoryId;

    @ApiModelProperty("房间id")
    private Integer roomId;

    @ApiModelProperty("工号")
    private String workNum;

    @ApiModelProperty("姓")
    private String firstName;

    @ApiModelProperty("名")
    private String lastName;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("调动状态(1审核成功,2审核中,3审核通过)")
    private int transferStatus;

    @ApiModelProperty("宿舍")
    private String dormitoryName;

    @ApiModelProperty("房间名")
    private String roomName;

    @ApiModelProperty("调动次数")
    private int totalNum;

    @ApiModelProperty("班别")
    private String scheduleName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("申请调动日期")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("审核日期")
    private Date updateDate;

    @ApiModelProperty("备注")
    private String remark;
}
