package com.psms.project.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysDeptVo {
    /** 部门名称 */
    private String deptName;
    /** 部门人数 */
    private int employees;
    /** 部门工时 */
    private double workTime;
    /** 考勤日期 */
    private Date attendanceDate;
}
