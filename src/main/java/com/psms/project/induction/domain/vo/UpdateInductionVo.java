package com.psms.project.induction.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("修改入职参数表")
public class UpdateInductionVo {
    @ApiModelProperty("入职id")
    private int inductionId;
    @ApiModelProperty("国籍id")
    private int citizenshipId;
    @ApiModelProperty("币种id")
    private int currencyId;
    @ApiModelProperty("部门id")
    private Long deptId;
    @ApiModelProperty("岗位id")
    private Long postId;
    @ApiModelProperty("试用期id(新增忽略该参数)")
    private int probationId;
    @ApiModelProperty("宿舍id")
    private int dormitoryId;
    @ApiModelProperty("房间id")
    private int roomId;
    @ApiModelProperty("班别id")
    private int orderId;
    @ApiModelProperty("学历id")
    private int educationId;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("姓（民族）")
    private String firstNameNational;
    @ApiModelProperty("名（民族）")
    private String lastNameNational;
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
    @ApiModelProperty("电话号码")
    private String phoneNumber;
    @ApiModelProperty("是否结婚(1结婚,2未婚(默认))")
    private int isMarried;
    @ApiModelProperty("出生日期")
    private String bornDate;
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
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("发薪日")
    private String payDay;
    @ApiModelProperty("押金")
    private double deposit;
}
