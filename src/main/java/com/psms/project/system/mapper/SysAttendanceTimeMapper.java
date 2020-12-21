package com.psms.project.system.mapper;

import com.psms.project.system.domain.SysAttendanceTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据层 打卡时间段
 */
@Mapper
public interface SysAttendanceTimeMapper {
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
