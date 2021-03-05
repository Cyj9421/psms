package com.psms.project.attendance.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("绑定IC卡参数")
public class AttendanceCardVo {
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("卡号")
    private String cardNum;
    @ApiModelProperty("ic卡id")
    private int ioId;
    @ApiModelProperty("ic卡类型(1考勤卡,2门禁卡)")
    private int cardType;
    @ApiModelProperty("携带人数")
    private int carryNum;
    @ApiModelProperty("可刷次数")
    private int brushNum;
}
