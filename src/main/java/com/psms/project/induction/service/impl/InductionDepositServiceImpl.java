package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionDeposit;
import com.psms.project.induction.domain.vo.InductionDepositVo;
import com.psms.project.induction.domain.vo.SelectDepositVo;
import com.psms.project.induction.mapper.InductionDepositMapper;
import com.psms.project.induction.service.IInductionDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 押金管理
 */
@Service
public class InductionDepositServiceImpl implements IInductionDepositService {
    @Autowired
    private InductionDepositMapper depositMapper;

    /**
     * 押金列表
     * @return
     */
    @Override
    public List<InductionDepositVo> depositList(SelectDepositVo selectDepositVo) {
        return depositMapper.depositList(selectDepositVo);
    }

    /**
     * 押金详情
     * @param depositId
     * @return
     */
    @Override
    public InductionDepositVo depositInfo(int depositId) {
        return depositMapper.depositInfo(depositId);
    }

    /**
     * 通过工号查找押金信息
     * @param workNum
     * @return
     */
    @Override
    public InductionDepositVo depositInfoByworkNum(String workNum) {
        return depositMapper.depositInfoByworkNum(workNum);
    }

    /**
     * 添加押金信息
     * @param inductionDeposit
     * @return
     */
    @Override
    public int addDeposit(InductionDeposit inductionDeposit) {
        return depositMapper.addDeposit(inductionDeposit);
    }

    /**
     * 修改押金信息
     * @param inductionDeposit
     * @return
     */
    @Override
    public int updateDeposit(InductionDeposit inductionDeposit) {
        return depositMapper.updateDeposit(inductionDeposit);
    }

    /**
     * 返还押金
     * @param depositId
     * @param operType
     * @return
     */
    @Override
    public int returnDeposit(int depositId,int operType) {
        return depositMapper.returnDeposit(depositId,operType);
    }
}
