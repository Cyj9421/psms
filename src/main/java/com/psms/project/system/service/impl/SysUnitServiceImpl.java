package com.psms.project.system.service.impl;

import com.psms.project.system.domain.SysUnitPrice;
import com.psms.project.system.mapper.SysUnitPriceMapper;
import com.psms.project.system.service.ISysUnitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单价管理
 */
@Service
public class SysUnitServiceImpl implements ISysUnitPriceService {
    @Autowired
    private SysUnitPriceMapper sysUnitPriceMapper;

    /**
     * 单价列表
     * @param sysUnitPrice
     * @return
     */
    @Override
    public List<SysUnitPrice> priceList(SysUnitPrice sysUnitPrice) {
        return sysUnitPriceMapper.priceList(sysUnitPrice);
    }

    /**
     * 单价详情
     * @param workNum
     * @return
     */
    @Override
    public SysUnitPrice priceInfo(String workNum) {
        return sysUnitPriceMapper.priceInfo(workNum);
    }

    /**
     * 添加单价
     * @param sysUnitPrice
     * @return
     */
    @Override
    public int addPrice(SysUnitPrice sysUnitPrice) {
        return sysUnitPriceMapper.addPrice(sysUnitPrice);
    }

    /**
     * 更新单价
     * @param sysUnitPrice
     * @return
     */
    @Override
    public int updatePrice(SysUnitPrice sysUnitPrice) {
        return sysUnitPriceMapper.updatePrice(sysUnitPrice);
    }

    /**
     * 批量删除单价
     * @param priceIds
     * @return
     */
    @Override
    public int delPrice(int[] priceIds) {
        return sysUnitPriceMapper.delPrice(priceIds);
    }
}
