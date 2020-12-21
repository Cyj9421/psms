package com.psms.project.bussiness.service.impl;

import com.psms.project.bussiness.domain.BussinessTrip;
import com.psms.project.bussiness.mapper.BussinessTripMapper;
import com.psms.project.bussiness.service.IBussinessTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出差管理  服务实现
 */
@Service
public class BussinessTripServiceImpl implements IBussinessTripService {
    @Autowired
    private BussinessTripMapper bussinessTripMapper;
    /**
     *查询出差列表
     * @return 出差列表
     */
    @Override
    public List<BussinessTrip> selectTripList(BussinessTrip bussinessTrip) {
        return bussinessTripMapper.selectTripList(bussinessTrip);
    }
    /**
     * 查询出差详情
     * @return 出差详情
     */
    @Override
    public List<BussinessTrip> selectTripInfo(int tripId) {
        return bussinessTripMapper.selectTripInfo(tripId);
    }
    /**
     * 新增出差申请
     * @param bussinessTrip
     * @return 结果
     */
    @Override
    public int addTrip(BussinessTrip bussinessTrip) {
        return bussinessTripMapper.addTrip(bussinessTrip);
    }
    /**
     * 出差详情修改
     * @param bussinessTrip
     * @return 结果
     */
    @Override
    public int updateTrip(BussinessTrip bussinessTrip) {
        return bussinessTripMapper.updateTrip(bussinessTrip);
    }
    /**
     * 审核出差申请
     * @param bussinessTrip
     * @return
     */
    @Override
    public int updateStatus(BussinessTrip bussinessTrip){
        return bussinessTripMapper.updateStatus(bussinessTrip);
    }

    @Override
    public int bussinessDestroy(BussinessTrip bussinessTrip) {
        return bussinessTripMapper.bussinessDestroy(bussinessTrip);
    }
}
