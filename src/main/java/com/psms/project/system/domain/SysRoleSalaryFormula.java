package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRoleSalaryFormula {
    /** 公式id */
    private int salaryFormulaId;
    /** 公式 */
    private String salaryFormula;
    /** 公式创建者 */
    private String createBy;
    /** 公式创建时间 */
    private Date createTime;
    /** 公式修改者 */
    private String updateBy;
    /** 公式修改时间 */
    private Date updateTime;
}
