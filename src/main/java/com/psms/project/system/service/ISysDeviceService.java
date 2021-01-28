package com.psms.project.system.service;

import com.psms.project.system.domain.SysDevice;

import java.util.List;

/**
 * 服务层 设备管理
 */
public interface ISysDeviceService {
    /**
     * 设备列表
     * @param sysDevice
     * @return
     */
    public List<SysDevice> deviceList(SysDevice sysDevice);

    /**
     * 添加设备
     * @param sysDevice
     * @return
     */
    public int addDevice(SysDevice sysDevice);

    /**
     * 设备管理
     * @param sysDevice
     * @return
     */
    public int deviceManager(SysDevice sysDevice);
}
