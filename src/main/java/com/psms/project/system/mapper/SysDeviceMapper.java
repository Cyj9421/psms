package com.psms.project.system.mapper;

import com.psms.project.system.domain.SysDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 设备管理
 */
@Mapper
public interface SysDeviceMapper {
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
