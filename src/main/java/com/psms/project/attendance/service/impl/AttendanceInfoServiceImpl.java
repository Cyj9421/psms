package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.vo.AttendanceInfoVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import com.psms.project.attendance.domain.vo.BrushCardInfoVo;
import com.psms.project.attendance.mapper.AttendanceInfoMapper;
import com.psms.project.attendance.domain.AttendanceInfo;
import com.psms.project.attendance.service.IAttendanceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 考勤记录
 */
@Service
public class AttendanceInfoServiceImpl implements IAttendanceInfoService {
    @Autowired
    private AttendanceInfoMapper attendanceInfoMapper;

    /**
     * 考勤列表
     * @param attendanceInfo
     * @return
     */
    @Override
    public List<AttendanceInfo> attendanceList(AttendanceInfo attendanceInfo) {
        return attendanceInfoMapper.attendanceList(attendanceInfo);
    }

    /**
     * 考勤详情
     * @param attendanceId
     * @return
     */
    @Override
    public AttendanceInfo attendanceInfo(int attendanceId) {
        return attendanceInfoMapper.attendanceInfo(attendanceId);
    }

    /**
     * 通过考勤日期和工号查找考勤信息
     * @param attendanceInfo
     * @return
     */
    @Override
    public AttendanceInfo attendateInfo(AttendanceInfo attendanceInfo) {
        return attendanceInfoMapper.attendateInfo(attendanceInfo);
    }

    /**
     * 上班考勤
     * @param attendanceInfo
     * @return
     */
    @Override
    public int startAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoMapper.startAttendance(attendanceInfo);
    }

    /**
     * 下班考勤
     * @param attendanceInfo
     * @return
     */
    @Override
    public int endAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoMapper.endAttendance(attendanceInfo);
    }

    /**
     * 异常记录
     * @param attendanceInfo
     * @return
     */
    @Override
    public int updateAttendance(AttendanceInfo attendanceInfo) {
        return attendanceInfoMapper.updateAttendance(attendanceInfo);
    }

    /**
     * 批量删除考勤信息
     * @param attendanceIds
     * @return
     */
    @Override
    public int delAttendance(int[] attendanceIds) {
        return attendanceInfoMapper.delAttendance(attendanceIds);
    }

    /**
     * 门禁刷卡信息
     * @param workNum
     * @return
     */
    @Override
    public BrushCardInfoVo brushCardInfoByDoor(String workNum) {
        return attendanceInfoMapper.brushCardInfoByDoor(workNum);
    }

    /**
     * 考勤刷卡信息
     * @param workNum
     * @return
     */
    @Override
    public BrushCardInfoVo brushCardInfoByAttendance(String workNum) {
        return attendanceInfoMapper.brushCardInfoByAttendance(workNum);
    }

    /**
     * 指纹考勤信息
     * @param workNum
     * @return
     */
    @Override
    public AttendanceInfoVo printFingerInfo(String workNum) {
        return attendanceInfoMapper.printFingerInfo(workNum);
    }

    /**
     * 添加考勤信息
     * @param attendanceVo
     * @return
     */
    @Override
    public int addAttendance(AttendanceVo attendanceVo) {
        return attendanceInfoMapper.addAttendance(attendanceVo);
    }

}
