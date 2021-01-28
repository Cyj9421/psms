package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.domain.vo.AttendanceReportDateVo;

import java.util.List;

public interface IAttendanceSummaryService {

    /**
     * 考勤汇总列表
     * @param attendanceSummary
     * @return
     */
    public List<AttendanceSummary> summaryList(AttendanceSummary attendanceSummary);

    /**
     * 汇总详情
     * @param summaryId
     * @return
     */
    public AttendanceSummary summaryInfo(int summaryId);

    /**
     * 考勤汇总
     * @param attendanceSummary
     * @return
     */
    public int addSummary(AttendanceSummary attendanceSummary);

    /**
     * 月/季/年汇总
     * @param attendanceReportDateVo
     * @return
     */
    public AttendanceSummary summaryToType(AttendanceReportDateVo attendanceReportDateVo);

    /**
     * 批量删除汇总
     * @param summaryIds
     * @return
     */
    public int delSummary(int [] summaryIds);
}
