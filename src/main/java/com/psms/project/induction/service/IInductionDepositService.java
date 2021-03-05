package com.psms.project.induction.service;

import com.psms.project.induction.domain.InductionDeposit;
import com.psms.project.induction.domain.vo.InductionDepositVo;
import com.psms.project.induction.domain.vo.SelectDepositVo;

import java.util.List;

/**
 * 服务层 押金管理
 */
public interface IInductionDepositService {

    /**
     * 押金列表
     * @return
     */
    public List<InductionDepositVo> depositList(SelectDepositVo selectDepositVo);

    /**
     * 押金详情
     * @param depositId
     * @return
     */
    public InductionDepositVo depositInfo(int depositId);

    /**
     * 通过工号查找押金信息
     * @param workNum
     * @return
     */
    public InductionDepositVo depositInfoByworkNum(String workNum);

    /**
     * 添加押金
     * @param inductionDeposit
     * @return
     */
    public int addDeposit(InductionDeposit inductionDeposit);

    /**
     * 修改押金
     * @param inductionDeposit
     * @return
     */
    public int updateDeposit(InductionDeposit inductionDeposit);

    /**
     * 返还押金
     * @param depositId
     * @param operType
     * @return
     */
    public int returnDeposit(int depositId,int operType);
}
