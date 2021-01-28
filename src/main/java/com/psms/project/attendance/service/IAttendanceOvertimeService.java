package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceOvertime;

import java.util.List;

/**
 * 服务层 加班记录
 */
public interface IAttendanceOvertimeService {
    /**
     * 加班列表
     * @param attendanceOvertime
     * @return
     */
    public List<AttendanceOvertime> overtimeList(AttendanceOvertime attendanceOvertime);

    /**
     * 加班详情
     * @param overtimeId
     * @return
     */
    public AttendanceOvertime overtimeInfo(int overtimeId);

    /**
     * 新增加班记录
     * @param attendanceOvertime
     * @return
     */
    public int addOvertime(AttendanceOvertime attendanceOvertime);

    /**
     * 是否存在加班
     * @param workNum
     * @return
     */
    public String isOverTime(String workNum);

    /**
     * 计算加班时长
     * @param workNum
     * @return
     */
    public double sumTime(String workNum);

    /**
     * 批量删除加班
     * @param overtimeIds
     * @return
     */
    public int delOvertime(int [] overtimeIds);
}
