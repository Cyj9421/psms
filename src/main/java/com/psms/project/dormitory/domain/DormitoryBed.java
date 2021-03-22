package com.psms.project.dormitory.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("床号管理")
public class DormitoryBed {
    @ApiModelProperty("床号id")
    private int bedId;
    @ApiModelProperty("房间id")
    private int roomId;
    @ApiModelProperty("床号")
    private String bedNo;
    @ApiModelProperty("分配状态(1未分配(默认),2已分配)")
    private int useStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("房间名称")
    private String roomName;
}
