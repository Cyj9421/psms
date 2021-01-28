package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceRp;

import java.util.List;

public interface IAttendanceRpService {
    /**
     * 奖惩详情
     * @param rpId
     * @return
     */
    AttendanceRp rpInfo(int rpId);

    /**
     * 奖惩列表
     * @param attendanceRp
     * @return
     */
    List<AttendanceRp> rpList(AttendanceRp attendanceRp);

    /**
     * 审核状态
     * @param attendanceRp
     * @return
     */
    int updateById(AttendanceRp attendanceRp);

    /**
     * 取消奖惩
     * @param rpIds
     * @return
     */
    int deleteById(int [] rpIds);

    /**
     * 添加奖惩
     * @param attendanceRp
     * @return
     */
    int addRp(AttendanceRp attendanceRp);
    /**
     * 奖惩详情
     * @param workNum
     * @return
     */
    public Double selectR(String workNum);
    /**
     * 惩罚总额
     * @param workNum
     * @return
     */
    public Double selectP(String workNum);
}
