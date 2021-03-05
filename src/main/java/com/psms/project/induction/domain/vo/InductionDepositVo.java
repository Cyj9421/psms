package com.psms.project.induction.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("押金返回参数")
public class InductionDepositVo {

    @ApiModelProperty("押金id")
    private int depositId;

    @ApiModelProperty("工号")
    private String workNum;

    @ApiModelProperty("机票")
    private int airTicket;

    @ApiModelProperty("押金备注")
    private String depositRemark;

    @ApiModelProperty("押金")
    private double deposit;

    @ApiModelProperty("操作类型(1退押金,退机票,正常)")
    private int operType;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("姓名")
    private String fullName;

    @ApiModelProperty("入职时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("工龄")
    private String workingYears;
}
