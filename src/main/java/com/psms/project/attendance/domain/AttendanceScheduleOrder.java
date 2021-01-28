package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

/**
 * 班次表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description = "班次表")
public class AttendanceScheduleOrder {
    @ApiModelProperty("班次id")
    private int orderId;
    /** 排班名称 */
    private String scheduleName;
    /** 上班时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time startTime;
    /** 下班时间 */
    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time endTime;
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
}
