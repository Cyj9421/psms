package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.mapper.AttendanceLateMapper;
import com.psms.project.attendance.domain.AttendanceLate;
import com.psms.project.attendance.service.IAttendanceLateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 迟到记录
 */
@Service
public class AttendanceLateServiceImpl implements IAttendanceLateService {
    @Autowired
    private AttendanceLateMapper attendanceLateMapper;

    /**
     * 迟到列表
     * @param attendanceLate
     * @return
     */
    @Override
    public List<AttendanceLate> lateList(AttendanceLate attendanceLate) {
        return attendanceLateMapper.lateList(attendanceLate);
    }

    /**
     * 迟到详情
     * @param lateId
     * @return
     */
    @Override
    public AttendanceLate lateInfo(int lateId) {
        return attendanceLateMapper.lateInfo(lateId);
    }

    /**
     * 添加迟到记录
     * @param attendanceLate
     * @return
     */
    @Override
    public int addLate(AttendanceLate attendanceLate) {
        return attendanceLateMapper.addLate(attendanceLate);
    }

    /**
     * 补卡成功，清除迟到记录
     * @param lateId
     * @return
     */
    @Override
    public int delLate(int lateId) {
        return attendanceLateMapper.delLate(lateId);
    }

    /**
     * 批量删除迟到信息
     * @param lateIds
     * @return
     */
    @Override
    public int delLates(int[] lateIds) {
        return attendanceLateMapper.delLates(lateIds);
    }
}
