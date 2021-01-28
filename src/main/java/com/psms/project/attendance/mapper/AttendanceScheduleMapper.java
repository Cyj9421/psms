package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 排班管理
 */
@Mapper
public interface AttendanceScheduleMapper {
    /**
     * 排班列表
     * @param attendanceSchedule
     * @return
     */
    public List<AttendanceSchedule> scheduleList(AttendanceSchedule attendanceSchedule);

    /**
     * 排班详情
     * @param workNum
     * @return
     */
    public AttendanceSchedule scheduleInfo(String workNum);

    /**
     * 新增排班
     * @param attendanceSchedule
     * @return
     */
    public int addSchedule(AttendanceSchedule attendanceSchedule);

    /**
     * 删除排班
     * @param scheduleIds
     * @return
     */
    public int delSchedule(int [] scheduleIds);

    /**
     * 修改排班
     * @param attendanceSchedule
     * @return
     */
    public int updateSchedule(AttendanceSchedule attendanceSchedule);
}
