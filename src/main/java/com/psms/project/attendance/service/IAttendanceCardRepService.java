package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceCardRep;

import java.util.List;

/**
 * 服务层 补卡记录
 */
public interface IAttendanceCardRepService {
    /**
     * 补卡列表
     * @return
     */
    public List<AttendanceCardRep> cardRepList(AttendanceCardRep attendanceCardRep);

    /**
     * 补卡详情
     * @param replacementId
     * @return
     */
    public AttendanceCardRep cardRepInfo(int replacementId);

    /**
     * 补卡申请
     * @param attendanceCardRep
     * @return
     */
    public int addCardRep(AttendanceCardRep attendanceCardRep);

    /**
     * 补卡审核
     * @param attendanceCardRep
     * @return
     */
    public int updateCard(AttendanceCardRep attendanceCardRep);

    /**
     * 批量删除补卡
     * @param replacementIds
     * @return
     */
    public int delCard(int [] replacementIds);
}
