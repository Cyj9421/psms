package com.psms.project.induction.service;

import com.psms.project.induction.domain.InductionCurrency;
import com.psms.project.induction.domain.vo.CurrencyVo;

import java.util.List;

/**
 * 服务层 币种管理
 */
public interface IInductionCurrencyService {

    /**
     * 币种列表
     * @param currency
     * @return
     */
    public List<InductionCurrency> currencyList(InductionCurrency currency);

    /**
     * 币种详情
     * @param currencyId
     * @return
     */
    public InductionCurrency currencyInfo(int currencyId);

    /**
     * 添加币种
     * @param currencyVo
     * @return
     */
    public int addCurrency(CurrencyVo currencyVo);

    /**
     * 修改币种
     * @param currencyVo
     * @return
     */
    public int updateCurrency(CurrencyVo currencyVo);

    /**
     * 批量删除币种
     * @param currencyIds
     * @return
     */
    public int delCurrency(int [] currencyIds);
}
