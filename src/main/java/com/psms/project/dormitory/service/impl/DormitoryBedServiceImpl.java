package com.psms.project.dormitory.service.impl;

import com.psms.project.dormitory.domain.DormitoryBed;
import com.psms.project.dormitory.domain.vo.InsertBedVo;
import com.psms.project.dormitory.domain.vo.SelectBedVo;
import com.psms.project.dormitory.domain.vo.UpdateBedVo;
import com.psms.project.dormitory.mapper.DormitoryBedMapper;
import com.psms.project.dormitory.service.IDormitoryBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 床号管理
 */
@Service
public class DormitoryBedServiceImpl implements IDormitoryBedService {
    @Autowired
    private DormitoryBedMapper bedMapper;
    /**
     * 床号列表
     * @param selectBedVo
     * @return
     */
    @Override
    public List<DormitoryBed> bedList(SelectBedVo selectBedVo) {
        return bedMapper.bedList(selectBedVo);
    }

    /**
     * 根据床号id查找床号
     * @param bedId
     * @return
     */
    @Override
    public DormitoryBed bedInfo(int bedId) {
        return bedMapper.bedInfo(bedId);
    }

    /**
     * 添加床号
     * @param insertBedVo
     * @return
     */
    @Override
    public int addBed(InsertBedVo insertBedVo) {
        return bedMapper.addBed(insertBedVo);
    }

    /**
     * 修改床号
     * @param updateBedVo
     * @return
     */
    @Override
    public int updateBed(UpdateBedVo updateBedVo) {
        return bedMapper.updateBed(updateBedVo);
    }

    /**
     * 批量删除床号
     * @param bedIds
     *
     * @return
     */
    @Override
    public int delBeds(int[] bedIds) {
        return bedMapper.delBeds(bedIds);
    }

    /**
     * 统计房间床数
     * @param roomId
     * @return
     */
    @Override
    public int totalBed(int roomId) {
        return bedMapper.totalBed(roomId);
    }

    /**
     * 查找床号
     * @param insertBedVo
     * @return
     */
    @Override
    public DormitoryBed selectBed(InsertBedVo insertBedVo) {
        return bedMapper.selectBed(insertBedVo);
    }
}
