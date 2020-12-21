package com.psms.project.system.service;

import com.psms.project.system.domain.SysAttendanceTime;

import java.util.List;

/**
 * 服务层 打卡时间
 */
public interface ISysAttendanceTimeService {
    /**
     * 时间段列表
     * @param sysAttendanceTime
     * @return
     */
    public List<SysAttendanceTime> timeList(SysAttendanceTime sysAttendanceTime);

    /**
     * 时间段详情
     * @param timeId
     * @return
     */
    public SysAttendanceTime timeInfo(int timeId);

    /**
     * 新增时间段
     * @param sysAttendanceTime
     * @return
     */
    public int addTime(SysAttendanceTime sysAttendanceTime);

    /**
     * 修改时间段
     * @param sysAttendanceTime
     * @return
     */
    public int updateTime(SysAttendanceTime sysAttendanceTime);

    /**
     * 删除时间段
     * @param timeId
     * @return
     */
    public int delTime(int timeId);
}
