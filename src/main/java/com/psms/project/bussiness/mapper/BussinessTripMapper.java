package com.psms.project.bussiness.mapper;

import com.psms.project.bussiness.domain.BussinessTrip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 出差管理  数据层
 */
@Mapper
public interface BussinessTripMapper {
    /**
     *查询出差列表
     * @return 出差列表
     */
    public List<BussinessTrip> selectTripList(BussinessTrip bussinessTrip);
    /**
     * 查询出差详情
     * @return 出差详情
     */
    public List<BussinessTrip> selectTripInfo(int tripId);
    /**
     * 新增出差申请
     * @param bussinessTrip
     * @return 结果
     */
    public int addTrip(BussinessTrip bussinessTrip);
    /**
     * 出差详情修改
     * @param bussinessTrip
     * @return 结果
     */
    public int updateTrip(BussinessTrip bussinessTrip);

    /**
     * 审核出差申请
     * @param bussinessTrip
     * @return
     */
    public int updateStatus(BussinessTrip bussinessTrip);

    /**
     * 销差
     * @param bussinessTrip
     * @return
     */
    public int bussinessDestroy(BussinessTrip bussinessTrip);
}
