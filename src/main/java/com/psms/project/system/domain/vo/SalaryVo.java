package com.psms.project.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaryVo {
    /** 员工工号id */
    private int workId;
    /** 底薪 */
    private double baseSalary;
    /** 加班单价 */
    private double overtimePrice;
    /** 奖金单价 */
    private double bonusPrice;
    /** 罚款单价 */
    private double penaltyPrice;
    /** 缺勤扣款单价 */
    private double afdPrice;
    /** 迟到扣款单价 */
    private double latePrice;
    /** 早退扣款单价 */
    private double earlyPrice;
    /** 备注 */
    private double remark;
}
