package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceFingerprint;
import com.psms.project.attendance.mapper.AttendanceFingerprintMapper;
import com.psms.project.attendance.service.IAttendanceFingerprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 指纹库
 */
@Service("attendanceFingerprintService")
public class AttendanceFingerprintServiceImpl implements IAttendanceFingerprintService {
    @Autowired
    private AttendanceFingerprintMapper attendanceFingerprintMapper;

    /**
     * 指纹列表
     * @param attendanceFingerprint
     * @return
     */
    @Override
    public List<AttendanceFingerprint> fingerprintList(AttendanceFingerprint attendanceFingerprint) {
        return attendanceFingerprintMapper.fingerprintList(attendanceFingerprint);
    }

    /**
     * 指纹详情
     * @param fingerprintId
     * @return
     */
    @Override
    public AttendanceFingerprint fingerprintInfo(int fingerprintId) {
        return attendanceFingerprintMapper.fingerprintInfo(fingerprintId);
    }

    /**
     * 指纹录入
     * @param attendanceFingerprint
     * @return
     */
    @Override
    public int addFingerprint(AttendanceFingerprint attendanceFingerprint) {
        return attendanceFingerprintMapper.addFingerprint(attendanceFingerprint);
    }

    /**
     * 指纹更新
     * @param attendanceFingerprint
     * @return
     */
    @Override
    public int updateFingerprint(AttendanceFingerprint attendanceFingerprint) {
        return attendanceFingerprintMapper.updateFingerprint(attendanceFingerprint);
    }

    /**
     * 批量删除指纹
     * @param fingerprintIds
     * @return
     */
    @Override
    public int delFingerprints(int[] fingerprintIds) {
        return attendanceFingerprintMapper.delFingerprints(fingerprintIds);
    }

    /**
     * 指纹注销
     * @param workNum
     * @return
     */
    @Override
    public int delFingerprint(String workNum) {
        return attendanceFingerprintMapper.delFingerprint(workNum);
    }



}
