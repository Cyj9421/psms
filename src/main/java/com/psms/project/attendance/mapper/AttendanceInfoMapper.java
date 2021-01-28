package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 业务层 考勤记录
 */
@Mapper
@Repository
public interface AttendanceInfoMapper {
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
}
