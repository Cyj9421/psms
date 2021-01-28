package com.psms.project.system.service.impl;

import com.psms.project.system.domain.SysDevice;
import com.psms.project.system.mapper.SysDeviceMapper;
import com.psms.project.system.service.ISysDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 设备管理
 */
@Service
public class SysDeviceServiceImpl implements ISysDeviceService {
    @Autowired
    private SysDeviceMapper sysDeviceMapper;

    /**
     * 设备列表
     * @param sysDevice
     * @return
     */
    @Override
    public List<SysDevice> deviceList(SysDevice sysDevice) {
        return sysDeviceMapper.deviceList(sysDevice);
    }

    /**
     * 添加设备
     * @param sysDevice
     * @return
     */
    @Override
    public int addDevice(SysDevice sysDevice) {
        return sysDeviceMapper.addDevice(sysDevice);
    }

    /**
     * 设备管理
     * @param sysDevice
     * @return
     */
    @Override
    public int deviceManager(SysDevice sysDevice) {
        return sysDeviceMapper.deviceManager(sysDevice);
    }
}
