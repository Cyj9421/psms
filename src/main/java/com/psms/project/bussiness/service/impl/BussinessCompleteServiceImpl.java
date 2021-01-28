package com.psms.project.bussiness.service.impl;

import com.psms.project.bussiness.domain.BussinessComplete;
import com.psms.project.bussiness.mapper.BussinessCompleteMapper;
import com.psms.project.bussiness.service.IBussinessCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销差管理 服务实现
 */
@Service
public class BussinessCompleteServiceImpl implements IBussinessCompleteService {
    @Autowired
    private BussinessCompleteMapper bussinessCompleteMapper;

    /**
     * 查询销差列表
     * @param bussinessComplete
     * @return
     */
    @Override
    public List<BussinessComplete> destroyList(BussinessComplete bussinessComplete) {
        return bussinessCompleteMapper.destroyList(bussinessComplete);
    }

    /**
     * 查询销差详情
     * @param destroyId
     * @return
     */
    @Override
    public BussinessComplete destroyInfo(int destroyId) {
        return bussinessCompleteMapper.destroyInfo(destroyId);
    }

    /**
     * 提交销差申请
     * @param bussinessComplete
     * @return
     */
    @Override
    public int addDestroy(BussinessComplete bussinessComplete) {
        return bussinessCompleteMapper.addDestroy(bussinessComplete);
    }

    /**
     * 审核销差申请
     * @param bussinessComplete
     * @return
     */
    @Override
    public int updateDestroy(BussinessComplete bussinessComplete) {
        return bussinessCompleteMapper.updateDestroy(bussinessComplete);
    }

    /**
     * 批量删除销差信息
     * @param destroyIds
     * @return
     */
    @Override
    public int delDestroys(int[] destroyIds) {
        return bussinessCompleteMapper.delDestroys(destroyIds);
    }
}
