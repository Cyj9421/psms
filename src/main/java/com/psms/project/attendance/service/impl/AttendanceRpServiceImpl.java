package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.mapper.AttendanceRpMapper;
import com.psms.project.attendance.domain.AttendanceRp;
import com.psms.project.attendance.service.IAttendanceRpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 奖惩管理
 */
@Service
public class AttendanceRpServiceImpl implements IAttendanceRpService {
    @Autowired
    private AttendanceRpMapper attendanceRpMapper;

    /**
     * 奖惩详情
     * @param rpId
     * @return
     */
    @Override
    public AttendanceRp rpInfo(int rpId) {
        return attendanceRpMapper.rpInfo(rpId);
    }

    /**
     * 奖惩列表
     * @param attendanceRp
     * @return
     */
    @Override
    public List<AttendanceRp> rpList(AttendanceRp attendanceRp) {
        return attendanceRpMapper.rpList(attendanceRp);
    }

    /**
     * 奖惩审核
     * @param attendanceRp
     * @return
     */
    @Override
    public int updateById(AttendanceRp attendanceRp) {
        return attendanceRpMapper.updateById(attendanceRp);
    }

    /**
     * 取消奖惩
     * @param rpIds
     * @return
     */
    @Override
    public int deleteById(int [] rpIds) {
        return attendanceRpMapper.deleteById(rpIds);
    }

    /**
     * 奖惩申请
     * @param attendanceRp
     * @return
     */
    @Override
    public int addRp(AttendanceRp attendanceRp) {
        return attendanceRpMapper.addRp(attendanceRp);
    }

    /**
     * 奖励总额
     * @param workNum
     * @return
     */
    @Override
    public Double selectR(String workNum) {
        return attendanceRpMapper.selectR(workNum);
    }

    /**
     * 惩罚总额
     * @param workNum
     * @return
     */
    @Override
    public Double selectP(String workNum) {
        return attendanceRpMapper.selectP(workNum);
    }
}
