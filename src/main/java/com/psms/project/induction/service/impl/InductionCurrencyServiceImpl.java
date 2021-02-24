package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionCurrency;
import com.psms.project.induction.domain.vo.CurrencyVo;
import com.psms.project.induction.mapper.InductionCurrencyMapper;
import com.psms.project.induction.service.IInductionCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 币种管理
 */
@Service
public class InductionCurrencyServiceImpl implements IInductionCurrencyService {
    @Autowired
    private InductionCurrencyMapper currencyMapper;

    /**
     * 币种列表
     * @param currency
     * @return
     */
    @Override
    public List<InductionCurrency> currencyList(InductionCurrency currency) {
        return currencyMapper.currencyList(currency);
    }

    /**
     * 币种详情
     * @param currencyId
     * @return
     */
    @Override
    public InductionCurrency currencyInfo(int currencyId) {
        return currencyMapper.currencyInfo(currencyId);
    }

    /**
     * 添加币种
     * @param currencyVo
     * @return
     */
    @Override
    public int addCurrency(CurrencyVo currencyVo) {
        return currencyMapper.addCurrency(currencyVo);
    }

    /**
     * 修改币种
     * @param currencyVo
     * @return
     */
    @Override
    public int updateCurrency(CurrencyVo currencyVo) {
        return currencyMapper.updateCurrency(currencyVo);
    }

    /**
     * 批量删除币种
     * @param currencyIds
     * @return
     */
    @Override
    public int delCurrency(int[] currencyIds) {
        return currencyMapper.delCurrency(currencyIds);
    }
}
