package com.psms.project.attendance.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 指纹库
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceFingerprint {
    /** 指纹id */
    private int fingerprintId;
    /** 工号 */
    private String workNum;
    /** 指纹名 */
    private String fingerprintTemplate;
    /** 使用状态(0正常,1注销) */
    public int useStatus;
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
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
