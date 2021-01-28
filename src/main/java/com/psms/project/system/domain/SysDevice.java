package com.psms.project.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 设备管理
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysDevice {
    /** 设备id */
    private int deviceId;
    /** 设备名称 */
    private String deviceName;
    /** 设备状态(1打开,2关闭(默认),3注销) */
    private int deviceStatus;
    /** 设备创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date deviceCreateTime;
    /** 设备更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date deviceUpdateTime;
}
