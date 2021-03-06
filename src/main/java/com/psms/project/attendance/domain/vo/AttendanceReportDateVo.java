package com.psms.project.attendance.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 考勤汇总报表日期
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceReportDateVo {

    /** 工号 */
    private String workNum;
    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /** 部门名称 */
    private String deptName;
    /** 报表类型(1月,2季,3年) */
    private int reportType;
    /** 查询类型(1未出勤,2休假中,3迟到,4早退,5旷工,6犯错,7已出勤) */
    private int selectType;
}
