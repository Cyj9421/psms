package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 请假表 sys_ask_off
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysAskOff {
    /** 请假id  */
    private Long askId;
    /** 员工工号  */
    private String workNum;
    /** 员工姓名  */
    private String fullName;
    /** 部门名称  */
    private String deptName;
    /** 部门领导  */
    private String deptLeader;
    /** 职位名称  */
    private String postName;
    /** 请假原因  */
    private String reason;
    /** 申请状态  */
    private String askStatus;
    /** 开始时间  */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /** 结束时间  */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
