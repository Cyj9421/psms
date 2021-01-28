package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * 排班表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceSchedule {
    /** 排班id */
    private int scheduleId;
    /** 班次id */
    private int orderId;
    /** 员工工号 */
    private String workNum;
    /** 员工姓名 */
    private String fullName;
    /** 岗位名称 */
    private String postName;
    /** 岗位编码 */
    private String postCode;
    /** 部门名称 */
    private String deptName;
    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
    /** 上班时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time startTime;
    /** 下班时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time endTime;
    /** 班次集合 */
    private List<AttendanceScheduleOrder> orderList;
}
