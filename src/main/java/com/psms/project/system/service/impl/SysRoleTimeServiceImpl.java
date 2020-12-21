package com.psms.project.system.service.impl;

import com.psms.project.system.domain.SysRoleTimeManager;
import com.psms.project.system.mapper.SysRoleTimeMapper;
import com.psms.project.system.service.ISysRoleTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleTimeServiceImpl implements ISysRoleTimeService {

    @Autowired
    private SysRoleTimeMapper sysRoleTimeMapper;

    /**
     * 新增时间段
     * @param sysRoleTimeManager
     * @return
     */

    @Override
    public int addTime(SysRoleTimeManager sysRoleTimeManager) {
        return sysRoleTimeMapper.addTime(sysRoleTimeMapper);
    }
}
