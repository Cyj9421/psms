package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 考勤卡号
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceCard {
    /** 卡号id */
    private int cardId;
    /** 工号 */
    private String workNum;
    /** 卡号 */
    private String cardNum;
    /** 携带人数 */
    private int carryNum;
    /** 剩余可刷次数 */
    private int brushNum;
    /** 累积次数 */
    private int totalNum;
    /** 默认可刷次数 */
    private int defaultNum;
    /** 出入口id */
    private int ioId;
    /** 姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 部门领导 */
    private String leader;
    /** 职位名称 */
    private String postName;
    /** 岗位编码 */
    private String postCode;
    /** 出入口名称 */
    private String ioName;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
