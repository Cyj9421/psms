package com.psms.project.induction.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("入职申请返回参数表")
public class InductionVo {
    @ApiModelProperty("入职id")
    private int inductionId;
    @ApiModelProperty("国籍id")
    private int citizenshipId;
    @ApiModelProperty("部门id")
    private Long deptId;
    @ApiModelProperty("币种id")
    private int currencyId;
    @ApiModelProperty("岗位id")
    private Long postId;
    @ApiModelProperty("试用期id")
    private int probationId;
    @ApiModelProperty("宿舍id")
    private int dormitoryId;
    @ApiModelProperty("房间id")
    private int roomId;
    @ApiModelProperty("班别id")
    private int orderId;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("姓")
    private String firstName;
    @ApiModelProperty("名")
    private String lastName;
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("性别(1男,2女)")
    private int sex;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("工资")
    private double salary;
    @ApiModelProperty("个人照片")
    private String personalPhoto;
    @ApiModelProperty("护照")
    private String passport;
    @ApiModelProperty("民族")
    private String national;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("联系方式")
    private String contact;
    @ApiModelProperty("学历")
    private String education;
    @ApiModelProperty("是否结婚(1结婚,2未婚(默认))")
    private int isMarried;
    @ApiModelProperty("出生日期")
    private String bornDate;
    @ApiModelProperty("电话号码")
    private String phoneNumber;
    @ApiModelProperty("出生地址")
    private String bornAddress;
    @ApiModelProperty("出生省份")
    private String bornProvince;
    @ApiModelProperty("出生所在区")
    private String bornArea;
    @ApiModelProperty("当前所在地址")
    private String nowAddress;
    @ApiModelProperty("当前所在省份")
    private String nowProvince;
    @ApiModelProperty("当前所在区")
    private String nowArea;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("发薪日")
    private String payDay;
    @ApiModelProperty("押金")
    private double deposit;
    @ApiModelProperty("国籍名")
    private String citizenshipName;
    @ApiModelProperty("币种名")
    private String currencyName;
    @ApiModelProperty("岗位名")
    private String postName;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("班别名称")
    private String scheduleName;
    @ApiModelProperty("试用期-月")
    private int probationMonth;
    @ApiModelProperty("试用期-日")
    private int probationDay;
}
