package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceSchedule;

import java.util.List;

/**
 * 服务层 排班管理
 */
public interface IAttendanceScheduleService {
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
     * 批量删除排班
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
