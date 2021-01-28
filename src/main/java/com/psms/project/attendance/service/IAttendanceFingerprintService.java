package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceFingerprint;

import java.util.List;

/**
 * 服务层 指纹库
 */
public interface IAttendanceFingerprintService {
    /**
     * 指纹列表
     * @param attendanceFingerprint
     * @return
     */
    public List<AttendanceFingerprint> fingerprintList(AttendanceFingerprint attendanceFingerprint);

    /**
     * 指纹详情
     * @param fingerprintId
     * @return
     */
    public AttendanceFingerprint fingerprintInfo(int fingerprintId);

    /**
     * 录入指纹
     * @param attendanceFingerprint
     * @return
     */
    public int addFingerprint(AttendanceFingerprint attendanceFingerprint);

    /**
     * 注销指纹
     * @param workNum
     * @return
     */
    public int delFingerprint(String workNum);
    /**
     * 指纹更新
     * @param attendanceFingerprint
     * @return
     */
    public int updateFingerprint(AttendanceFingerprint attendanceFingerprint);

    /**
     * 批量删除指纹
     * @param fingerprintIds
     * @return
     */
    public int delFingerprints(int [] fingerprintIds);
}
