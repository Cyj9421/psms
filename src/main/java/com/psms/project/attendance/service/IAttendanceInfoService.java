package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.domain.vo.AttendanceInfoVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import com.psms.project.attendance.domain.vo.BrushCardInfoVo;

import java.util.List;

/**
 * 服务层 考勤记录
 */
public interface IAttendanceInfoService {
    /**
     * 考勤列表
     * @param attendanceInfo
     * @return
     */
    public List<AttendanceInfo> attendanceList(AttendanceInfo attendanceInfo);

    /**
     * 考勤详情
     * @param attendanceId
     * @return
     */
    public AttendanceInfo attendanceInfo(int attendanceId);

    /**
     * 通过工号和考勤日期查找考勤信息
     * @param attendanceInfo
     * @return
     */
    public AttendanceInfo attendateInfo(AttendanceInfo attendanceInfo);

    /**
     * 上班考勤
     * @param attendanceInfo
     * @return
     */
    public int startAttendance(AttendanceInfo attendanceInfo);

    /**
     * 下班考勤
     * @param attendanceInfo
     * @return
     */
    public int endAttendance(AttendanceInfo attendanceInfo);

    /**
     * 异常记录
     * @param attendanceInfo
     * @return
     */
    public int updateAttendance(AttendanceInfo attendanceInfo);

    /**
     * 批量删除考勤信息
     * @param attendanceIds
     * @return
     */
    public int delAttendance(int [] attendanceIds);

    /**
     * 刷卡信息
     * @param workNum
     * @return
     */
    public BrushCardInfoVo brushCardInfoByDoor(String workNum);

    /**
     * 刷卡考勤信息
     * @param workNum
     * @return
     */
    public BrushCardInfoVo brushCardInfoByAttendance(String workNum);

    /**
     * 指纹考勤信息
     * @param workNum
     * @return
     */
    public AttendanceInfoVo printFingerInfo(String workNum);

    /**
     * 新增记录
     * @param attendanceVo
     * @return
     */
    public int addAttendance(AttendanceVo attendanceVo);
}
