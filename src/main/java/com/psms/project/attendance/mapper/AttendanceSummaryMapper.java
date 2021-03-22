package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceSummary;
import com.psms.project.attendance.domain.vo.AttendanceReportDateVo;
import com.psms.project.attendance.domain.vo.AttendanceRpVo;
import com.psms.project.attendance.domain.vo.AttendanceSummaryVo;
import com.psms.project.attendance.domain.vo.AttendanceVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendanceSummaryMapper {
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
     * 部门奖惩次数
     * @param attendanceReportDateVo
     * @return
     */
    public List<AttendanceRpVo> attendanceRpVoList(AttendanceReportDateVo attendanceReportDateVo);

    /**
     * 部门考勤汇总列表
     * @param attendanceReportDateVo
     * @return
     */
    public List<AttendanceSummaryVo> summaryVoList(AttendanceReportDateVo attendanceReportDateVo);

    /**
     * 考勤汇总
     * @param attendanceSummary
     * @return
     */
    public int addSummary(AttendanceSummary attendanceSummary);

    /**
     * 考勤日汇总
     * @return
     */
    public List<AttendanceVo> attendanceToDayList(AttendanceVo attendanceVo);

    /**
     * 月/季/年汇总
     * @param attendanceReportDateVo
     * @return
     */
    public AttendanceSummary summaryToType(AttendanceReportDateVo attendanceReportDateVo);

    /**
     * 删除汇总
     * @param summaryMonth
     * @param summaryQuarter
     * @param summaryYear
     * @return
     */
    public int delSummaryByDate(int reportType,int summaryMonth,int summaryQuarter,int summaryYear,String workNum);

    /**
     * 批量删除汇总
     * @param summaryIds
     * @return
     */
    public int delSummary(int [] summaryIds);

}
