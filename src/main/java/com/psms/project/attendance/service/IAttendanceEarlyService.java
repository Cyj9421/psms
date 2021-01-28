package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceEarly;

import java.util.List;

/**
 * 服务层 早退记录
 */
public interface IAttendanceEarlyService {
    /**
     * 早退列表
     * @return
     */
    List<AttendanceEarly> earlyList(AttendanceEarly attendanceEarly);

    /**
     * 早退详情
     * @param earlyId
     * @return
     */
    AttendanceEarly earlyInfo(int earlyId);

    /**
     * 新增早退记录
     * @param attendanceEarly
     * @return
     */
    public int addEarly(AttendanceEarly attendanceEarly);

    /**
     * 批量删除早退信息
     * @param earlyIds
     * @return
     */
    public int delEarly(int [] earlyIds);
}
