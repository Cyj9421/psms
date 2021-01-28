package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.mapper.AttendanceAskOffMapper;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.service.IAttendanceAskOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 请假管理
 */
@Service
public class AttendanceAskOffServiceImpl implements IAttendanceAskOffService {
    @Autowired
    private AttendanceAskOffMapper attendanceAskOffMapper;

    /**
     * 请假审核
     * @param attendanceAskOff
     * @return
     */
    @Override
    public int updateById(AttendanceAskOff attendanceAskOff) {
        return attendanceAskOffMapper.updateById(attendanceAskOff);
    }

    /**
     * 请假详情
     * @param askId
     * @return
     */
    @Override
    public AttendanceAskOff askOffInfo(Integer askId) {
        return attendanceAskOffMapper.askOffInfo(askId);
    }

    /**
     * 请假列表
     * @return
     */
    @Override
    public List<AttendanceAskOff> askList(AttendanceAskOff attendanceAskOff) {
        return attendanceAskOffMapper.askList(attendanceAskOff);
    }

    /**
     * 请假申请
     * @param attendanceAskOff
     * @return
     */
    @Override
    public int askOff(AttendanceAskOff attendanceAskOff) {
        return attendanceAskOffMapper.askOff(attendanceAskOff);
    }

    /**
     * 批量删除请假
     * @param askIds
     * @return
     */
    @Override
    public int delAskOff(int[] askIds) {
        return attendanceAskOffMapper.delAskOff(askIds);
    }
}
