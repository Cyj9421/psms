package com.psms.project.bussiness.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendnceSummary {
    /** 考勤汇总id */
    private int summaryId;
    /** 工号id */
    private int workId;
    /** 奖惩id */
    private int rpId;
    /** 迟到次数 */
    private int lateNum;
    /** 早退次数 */
    private int earlyNum;
    /** 缺勤次数 */
    private  int afdNum;
    /** 加班次数 */
    private double overtime;
    /** 加分次数 */
    private int rewardsNum;
    /** 扣分次数 */
    private int punishmentNum;
    /** 出差次数 */
    private int btNum;
}
