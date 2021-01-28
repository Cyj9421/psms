package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.mapper.AttendanceCardRepMapper;
import com.psms.project.attendance.domain.AttendanceCardRep;
import com.psms.project.attendance.service.IAttendanceCardRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 补卡管理
 */
@Service
public class AttendanceCardRepServiceImpl implements IAttendanceCardRepService {
    @Autowired
    private AttendanceCardRepMapper attendanceCardRepMapper;

    /**
     * 补卡列表
     * @param attendanceCardRep
     * @return
     */
    @Override
    public List<AttendanceCardRep> cardRepList(AttendanceCardRep attendanceCardRep) {
        return attendanceCardRepMapper.cardRepList(attendanceCardRep);
    }

    /**
     * 补卡详情
     * @param replacementId
     * @return
     */
    @Override
    public AttendanceCardRep cardRepInfo(int replacementId) {
        return attendanceCardRepMapper.cardRepInfo(replacementId);
    }

    /**
     * 补卡申请
     * @param attendanceCardRep
     * @return
     */
    @Override
    public int addCardRep(AttendanceCardRep attendanceCardRep) {
        return attendanceCardRepMapper.addCardRep(attendanceCardRep);
    }

    /**
     * 补卡审核
     * @param attendanceCardRep
     * @return
     */
    @Override
    public int updateCard(AttendanceCardRep attendanceCardRep) {
        return attendanceCardRepMapper.updateCard(attendanceCardRep);
    }

    /**
     * 批量删除补卡信息
     * @param replacementIds
     * @return
     */
    @Override
    public int delCard(int[] replacementIds) {
        return attendanceCardRepMapper.delCard(replacementIds);
    }
}
