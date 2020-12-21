package com.psms.project.bussiness.service;

import com.psms.project.bussiness.domain.BussinessComplete;

import java.util.List;

/**
 * 销差管理  服务层
 */
public interface IBussinessCompleteService {
    /**
     * 查询销差列表
     * @param bussinessComplete
     * @return
     */
    public List<BussinessComplete> destroyList(BussinessComplete bussinessComplete);

    /**
     * 查询销差详情
     * @param destroyId
     * @return
     */
    public BussinessComplete destroyInfo(int destroyId);
    /**
     *
     * @新增销差申请
     * @return 结果
     */
    public int addDestroy(BussinessComplete bussinessComplete);
    /**
     *
     * @部门领导审核销差
     * @return 结果
     */
    public int updateDestroy(BussinessComplete bussinessComplete);
}
