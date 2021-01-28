package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceSchedule;
import com.psms.project.attendance.mapper.AttendanceScheduleMapper;
import com.psms.project.attendance.service.IAttendanceScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 排班管理
 */
@Service
public class AttendanceScheduleServiceImpl implements IAttendanceScheduleService {
    @Autowired
    private AttendanceScheduleMapper attendanceScheduleMapper;

    /**
     * 排班列表
     * @param attendanceSchedule
     * @return
     */
    @Override
    public List<AttendanceSchedule> scheduleList(AttendanceSchedule attendanceSchedule) {
        return attendanceScheduleMapper.scheduleList(attendanceSchedule);
    }

    /**
     * 排班详情
     * @param workNum
     * @return
     */
    @Override
    public AttendanceSchedule scheduleInfo(String workNum) {
        return attendanceScheduleMapper.scheduleInfo(workNum);
    }

    /**
     * 新增排班
     * @param attendanceSchedule
     * @return
     */
    @Override
    public int addSchedule(AttendanceSchedule attendanceSchedule) {
        return attendanceScheduleMapper.addSchedule(attendanceSchedule);
    }

    /**
     * 删除排班
     * @param scheduleIds
     * @return
     */
    @Override
    public int delSchedule(int [] scheduleIds) {
        return attendanceScheduleMapper.delSchedule(scheduleIds);
    }

    /**
     * 修改排班
     * @param attendanceSchedule
     * @return
     */
    @Override
    public int updateSchedule(AttendanceSchedule attendanceSchedule) {
        return attendanceScheduleMapper.updateSchedule(attendanceSchedule);
    }
}
