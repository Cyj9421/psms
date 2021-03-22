package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.domain.vo.AskVo;

import java.util.List;

/**
 * 服务层 请假管理
 */
public interface IAttendanceAskOffService {
    /**
     * 请假审核
     * @param attendanceAskOff
     * @return
     */
    int updateById(AttendanceAskOff attendanceAskOff);

    /**
     * 请假详情
     * @param askId
     * @return
     */
    AttendanceAskOff askOffInfo(Integer askId);

    /**
     * 请休假详情
     * @param askVo
     * @return
     */
    AttendanceAskOff askOffByWorkNum(AskVo askVo);

    /**
     * 请假列表
     * @return
     */
    List<AttendanceAskOff> askList(AttendanceAskOff attendanceAskOff);

    /**
     * 请假申请
     * @param attendanceAskOff
     * @return
     */
    int askOff(AttendanceAskOff attendanceAskOff);

    /**
     * 批量删除
     * @param askIds
     * @return
     */
    int delAskOff(int [] askIds);
}
