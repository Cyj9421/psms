package com.psms.project.system.service;

import com.psms.project.system.domain.SysUnitPrice;

import java.util.List;

public interface ISysUnitPriceService {
    /**
     * 单价列表
     * @param sysUnitPrice
     * @return
     */
    public List<SysUnitPrice> priceList(SysUnitPrice sysUnitPrice);

    /**
     * 单价详情
     * @param workNum
     * @return
     */
    public SysUnitPrice priceInfo(String workNum);

    /**
     * 添加单价
     * @return
     */
    public int addPrice(SysUnitPrice sysUnitPrice);

    /**
     * 修改单价
     * @param sysUnitPrice
     * @return
     */
    public int updatePrice(SysUnitPrice sysUnitPrice);
    /**
     * 批量删除单价
     * @param priceIds
     * @return
     */
    public int delPrice(int [] priceIds);
}
