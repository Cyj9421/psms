package com.psms.project.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysDeptVo {
    /** 部门名称 */
    private String deptName;
    /** 部门领导 */
    private String leader;
}
