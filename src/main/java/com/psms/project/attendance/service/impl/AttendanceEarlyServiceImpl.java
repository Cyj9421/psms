package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.mapper.AttendanceEarlyMapper;
import com.psms.project.attendance.domain.AttendanceEarly;
import com.psms.project.attendance.service.IAttendanceEarlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 早退记录
 */
@Service
public class AttendanceEarlyServiceImpl implements IAttendanceEarlyService {
    @Autowired
    private AttendanceEarlyMapper attendanceEarlyMapper;

    /**
     * 早退列表
     * @param attendanceEarly
     * @return
     */
    @Override
    public List<AttendanceEarly> earlyList(AttendanceEarly attendanceEarly) {
        return attendanceEarlyMapper.earlyList(attendanceEarly);
    }

    /**
     * 早退详情
     * @param earlyId
     * @return
     */
    @Override
    public AttendanceEarly earlyInfo(int earlyId) {
        return attendanceEarlyMapper.earlyInfo(earlyId);
    }

    /**
     * 新增早退记录
     * @param attendanceEarly
     * @return
     */
    @Override
    public int addEarly(AttendanceEarly attendanceEarly) {
        return attendanceEarlyMapper.addEarly(attendanceEarly);
    }

    /**
     * 批量删除早退信息
     * @param earlyIds
     * @return
     */
    @Override
    public int delEarly(int[] earlyIds) {
        return attendanceEarlyMapper.delEarly(earlyIds);
    }
}

