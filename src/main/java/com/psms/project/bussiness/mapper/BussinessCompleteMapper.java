package com.psms.project.bussiness.mapper;

import com.psms.project.bussiness.domain.BussinessComplete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 销差管理  数据层
 */
@Mapper
public interface BussinessCompleteMapper {
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
