package com.psms.project.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysIndexVo {
    /** 开始日期 */
    @JsonFormat(pattern ="yyyy-MM-dd" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    /** 结束日期 */
    @JsonFormat(pattern ="yyyy-MM-dd" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /** 开始时间 */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /** 结束时间 */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /** 考勤日期 */
    @JsonFormat(pattern ="yyyy-MM-dd" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date attendanceDate;
}
