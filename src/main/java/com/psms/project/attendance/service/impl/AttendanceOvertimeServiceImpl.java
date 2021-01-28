package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceOvertime;
import com.psms.project.attendance.mapper.AttendanceOvertimeMapper;
import com.psms.project.attendance.service.IAttendanceOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 加班记录
 */
@Service
public class AttendanceOvertimeServiceImpl implements IAttendanceOvertimeService {
    @Autowired
    private AttendanceOvertimeMapper attendanceOvertimeMapper;

    /**
     * 加班列表
     * @param attendanceOvertime
     * @return
     */
    @Override
    public List<AttendanceOvertime> overtimeList(AttendanceOvertime attendanceOvertime) {
        return attendanceOvertimeMapper.overtimeList(attendanceOvertime);
    }

    /**
     * 加班详情
     * @param overtimeId
     * @return
     */
    @Override
    public AttendanceOvertime overtimeInfo(int overtimeId) {
        return attendanceOvertimeMapper.overtimeInfo(overtimeId);
    }

    /**
     * 新增加班记录
     * @param attendanceOvertime
     * @return
     */
    @Override
    public int addOvertime(AttendanceOvertime attendanceOvertime) {
        return attendanceOvertimeMapper.addOvertime(attendanceOvertime);
    }

    /**
     * 是否存在加班
     * @param workNum
     * @return
     */
    @Override
    public String isOverTime(String workNum) {
        return attendanceOvertimeMapper.isOverTime(workNum);
    }

    /**
     * 计算加班时长
     * @param workNum
     * @return
     */
    @Override
    public double sumTime(String workNum) {
        return attendanceOvertimeMapper.sumTime(workNum);
    }

    /**
     * 批量删除加班信息
     * @param overtimeIds
     * @return
     */
    @Override
    public int delOvertime(int[] overtimeIds) {
        return attendanceOvertimeMapper.delOvertime(overtimeIds);
    }
}
