package com.psms.project.monitor.service;

import com.psms.project.monitor.domain.SysLock;

import java.util.List;

/**
 * 服务层 系统锁定
 */
public interface ISysLockService {
    /**
     * 锁定日期列表
     * @param sysLock
     * @return
     */
    public List<SysLock> lockList(SysLock sysLock);

    /**
     * 添加锁定日期
     * @param sysLock
     * @return
     */
    public int addLock(SysLock sysLock);

    /**
     * 修改锁定日期
     * @param sysLock
     * @return
     */
    public int updateLock(SysLock sysLock);

    /**
     * 批量删除锁定日期
     * @param lockIds
     * @return
     */
    public int delDates(int[] lockIds);
    /**
     * 查询日期
     * @return
     */
    public List<String> dateList();
    /**
     * 锁定系统
     * @return
     */
    public int isTrue();

    /**
     * 解锁系统
     * @return
     */
    public int isFlase();
}
