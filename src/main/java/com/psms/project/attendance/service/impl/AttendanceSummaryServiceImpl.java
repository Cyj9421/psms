package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.domain.vo.AttendanceReportDateVo;
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
     * 月/季/年 汇总报表
     * @param attendanceReportDateVo
     * @return
     */
    @Override
    public AttendanceSummary summaryToType(AttendanceReportDateVo attendanceReportDateVo) {
        return attendanceSummaryMapper.summaryToType(attendanceReportDateVo);
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
