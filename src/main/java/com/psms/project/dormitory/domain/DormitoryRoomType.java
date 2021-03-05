package com.psms.project.dormitory.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("宿舍房间类型")
public class DormitoryRoomType {
    @ApiModelProperty("类型id")
    private int typeId;
    @ApiModelProperty("类型名称")
    private String typeName;
    @JsonFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd Hh:mm:ss")
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
