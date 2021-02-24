package com.psms.project.induction.mapper;

import com.psms.project.induction.domain.InductionCurrency;
import com.psms.project.induction.domain.vo.CurrencyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 币种管理
 */
@Mapper
public interface InductionCurrencyMapper {

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
