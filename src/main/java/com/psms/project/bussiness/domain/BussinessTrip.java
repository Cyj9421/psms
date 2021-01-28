package com.psms.project.bussiness.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 *
 *出差表  sys_business_trip
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BussinessTrip {
    /**  出差id  */
    private int tripId;
    /** 员工工号  */
    private String workNum;
    /** 部门名称  */
    private String deptName;
    /** 员工姓名  */
    private String fullName;
    /** 岗位编号 */
    private String postCode;
    /** 职位名称 */
    private String postName;
    /** 部门领导  */
    private String leader;
    /** 出差地点  */
    private String tripAddress;
    /** 申请原因  */
    private String reason;
    /** 申请状态  */
    private int tripStatus;
    /** 计划出发时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /** 计划结束时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    /** 申请人  */
    private String createTripBy;
    /** 申请时间  */
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date createTripTime;
    /** 审核人  */
    private String updateTripBy;
    /** 审核时间  */
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private Date updateTripTime;
}
