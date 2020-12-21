package com.psms.project.system.service.impl;

import com.psms.project.system.domain.SysAttendanceTime;
import com.psms.project.system.mapper.SysAttendanceTimeMapper;
import com.psms.project.system.service.ISysAttendanceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 打卡时间
 */
@Service
public class SysAttendanceTimeServiceImpl implements ISysAttendanceTimeService {
    @Autowired
    SysAttendanceTimeMapper sysAttendanceTimeMapper;
    /**
     * 时间段列表
     * @param sysAttendanceTime
     * @return
     */
    @Override
    public List<SysAttendanceTime> timeList(SysAttendanceTime sysAttendanceTime) {
        return sysAttendanceTimeMapper.timeList(sysAttendanceTime);
    }
    /**
     * 时间段详情
     * @param timeId
     * @return
     */
    @Override
    public SysAttendanceTime timeInfo(int timeId) {
        return sysAttendanceTimeMapper.timeInfo(timeId);
    }
    /**
     * 新增时间段
     * @param sysAttendanceTime
     * @return
     */
    @Override
    public int addTime(SysAttendanceTime sysAttendanceTime) {
        return sysAttendanceTimeMapper.addTime(sysAttendanceTime);
    }
    /**
     * 修改时间段
     * @param sysAttendanceTime
     * @return
     */
    public int updateTime(SysAttendanceTime sysAttendanceTime) {
        return sysAttendanceTimeMapper.updateTime(sysAttendanceTime);
    }
    /**
     * 删除时间段
     * @param timeId
     * @return
     */
    @Override
    public int delTime(int timeId) {
        return sysAttendanceTimeMapper.delTime(timeId);
    }
}
