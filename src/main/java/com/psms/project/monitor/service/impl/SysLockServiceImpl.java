package com.psms.project.monitor.service.impl;

import com.psms.project.monitor.domain.SysLock;
import com.psms.project.monitor.mapper.SysLockMapper;
import com.psms.project.monitor.service.ISysLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 系统锁定
 */
@Service("ISysLockService")
public class SysLockServiceImpl implements ISysLockService {
    @Autowired
    private SysLockMapper sysLockMapper;

    /**
     * 锁定日期列表
     * @param sysLock
     * @return
     */
    @Override
    public List<SysLock> lockList(SysLock sysLock) {
        return sysLockMapper.lockList(sysLock);
    }

    /**
     * 新增锁定日期
     * @param sysLock
     * @return
     */
    @Override
    public int addLock(SysLock sysLock) {
        return sysLockMapper.addLock(sysLock);
    }

    /**
     * 修改锁定日期
     * @param sysLock
     * @return
     */
    @Override
    public int updateLock(SysLock sysLock) {
        return sysLockMapper.updateLock(sysLock);
    }

    /**
     * 批量删除锁定日期
     * @param lockIds
     * @return
     */
    @Override
    public int delDates(int[] lockIds) {
        return sysLockMapper.delDates(lockIds);
    }

    /**
     * 查询锁定日期
     * @return
     */
    @Override
    public List<String> dateList() {
        return sysLockMapper.dateList();
    }

    /**
     * 锁定系统
     * @return
     */
    @Override
    public int isTrue() {
        return sysLockMapper.isTrue();
    }

    /**
     * 解锁系统
     * @return
     */
    @Override
    public int isFlase() {
        return sysLockMapper.isFlase();
    }
}
