package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.domain.vo.AttendanceReportDateVo;
import com.psms.project.attendance.domain.vo.AttendanceRpVo;
import com.psms.project.attendance.domain.vo.AttendanceSummaryVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import com.psms.project.attendance.mapper.AttendanceSummaryMapper;
import com.psms.project.attendance.service.IAttendanceSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 考勤汇总
 */
@Service
public class AttendanceSummaryServiceImpl implements IAttendanceSummaryService {
    @Autowired
    private AttendanceSummaryMapper attendanceSummaryMapper;

    /**
     * 考勤汇总列表
     * @param attendanceSummary
     * @return
     */
    @Override
    public List<AttendanceSummary> summaryList(AttendanceSummary attendanceSummary) {
        return attendanceSummaryMapper.summaryList(attendanceSummary);
    }

    /**
     * 考勤汇总详情
     * @param summaryId
     * @return
     */
    @Override
    public AttendanceSummary summaryInfo(int summaryId) {
        return attendanceSummaryMapper.summaryInfo(summaryId);
    }

    /**
     * 汇总考勤
     * @param attendanceSummary
     * @return
     */
    @Override
    public int addSummary(AttendanceSummary attendanceSummary) {
        return attendanceSummaryMapper.addSummary(attendanceSummary);
    }

    /**
     * 部门奖惩次数
     * @param attendanceReportDateVo
     * @return
     */
    @Override
    public List<AttendanceRpVo> attendanceRpVoList(AttendanceReportDateVo attendanceReportDateVo) {
        return attendanceSummaryMapper.attendanceRpVoList(attendanceReportDateVo);
    }

    /**
     * 部门考勤列表
     * @param attendanceReportDateVo
     * @return
     */
    @Override
    public List<AttendanceSummaryVo> summaryVoList(AttendanceReportDateVo attendanceReportDateVo) {
        return attendanceSummaryMapper.summaryVoList(attendanceReportDateVo);
    }

    /**
     * 考勤日汇总
     * @return
     */
    @Override
    public List<AttendanceVo> attendanceToDayList(AttendanceVo attendanceVo) {
        return attendanceSummaryMapper.attendanceToDayList(attendanceVo);
    }

    /**
     * 月/季/年 汇总报表
     * @param attendanceReportDateVo
     * @return
     */
    @Override
    public AttendanceSummary summaryToType(AttendanceReportDateVo attendanceReportDateVo) {
        return attendanceSummaryMapper.summaryToType(attendanceReportDateVo);
    }

    /**
     * 删除汇总
     * @param reportType
     * @param summaryMonth
     * @param summaryQuarter
     * @param summaryYear
     * @return
     */
    @Override
    public int delSummaryByDate(int reportType, int summaryMonth, int summaryQuarter, int summaryYear,String workNum) {
        return attendanceSummaryMapper.delSummaryByDate(reportType,summaryMonth,summaryQuarter,summaryYear,workNum);
    }

    /**
     * 批量删除汇总
     * @param summaryIds
     * @return
     */
    @Override
    public int delSummary(int[] summaryIds) {
        return attendanceSummaryMapper.delSummary(summaryIds);
    }


}
