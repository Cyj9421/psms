package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceLate;

import java.util.List;

/**
 * 服务层 迟到管理
 */
public interface IAttendanceLateService {
    /**
     * 迟到列表
     * @param attendanceLate
     * @return
     */
    public List<AttendanceLate> lateList(AttendanceLate attendanceLate);

    /**
     * 迟到详情
     * @param lateId
     * @return
     */
    public AttendanceLate lateInfo(int lateId);

    /**
     * 新增迟到记录
     * @param attendanceLate
     * @return
     */
    public int addLate(AttendanceLate attendanceLate);

    /**
     * 补卡成功 清除迟到记录
     * @param lateId
     * @return
     */
    public int delLate(int lateId);

    /**
     * 批量删除迟到记录
     * @param lateIds
     * @return
     */
    public int delLates(int [] lateIds);
}
