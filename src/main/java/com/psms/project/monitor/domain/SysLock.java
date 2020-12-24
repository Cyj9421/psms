package com.psms.project.monitor.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 实体 系统锁定
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysLock {
    /** 系统锁定id */
    private int lockId;
    /** 系统锁定日期 */
    private String lockDate;
    /** 角色id */
    private Long roleId;
    /** 锁定状态(0已锁定,1未锁定) */
    private int lockStatus;
    /** 创建人 */
    private String createBy;
    /** 创建时间 */
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss")
    private Date creteTime;
    /** 修改人 */
    private String updateBy;
    /** 修改时间 */
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss")
    private Date updateTime;
}
