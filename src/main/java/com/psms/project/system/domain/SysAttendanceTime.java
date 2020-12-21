package com.psms.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 实体层 设置打卡时间段
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysAttendanceTime {
    /** 时间段id */
    private int timeId;
    /** 角色id */
    private Long roleId;
    /** 开始时间 */
    @JsonFormat(pattern = "hh:mm:ss")
    private Date startTime;
    /** 结束时间 */
    @JsonFormat(pattern = "hh:mm:ss")
    private Date endTime;
    /** 角色名称 */
    private String roleName;
    /** 角色权限字符串 */
    private String roleKey;
    /** 角色状态(0正常,1停用) */
    private char status;
}
