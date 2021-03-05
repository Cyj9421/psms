package com.psms.project.dormitory.service.impl;

import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.vo.UpdateDormitoryVo;
import com.psms.project.dormitory.mapper.DormitoryBuildingMapper;
import com.psms.project.dormitory.service.IDormitoryBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 宿舍管理
 */
@Service
public class DormitoryBuildingServiceImpl implements IDormitoryBuildingService {
    @Autowired
    private DormitoryBuildingMapper dormitoryBuildingMapper;

    /**
     * 宿舍列表
     * @return
     */
    @Override
    public List<DormitoryBuilding> dormitoryList() {
        return dormitoryBuildingMapper.dormitoryList();
    }

    /**
     * 宿舍详情
     * @param dormitoryId
     * @return
     */
    @Override
    public DormitoryBuilding dormitoryInfo(int dormitoryId) {
        return dormitoryBuildingMapper.dormitoryInfo(dormitoryId);
    }

    /**
     * 房间详情
     * @param dormitoryName
     * @return
     */
    @Override
    public DormitoryBuilding dormitoryInfoBuDormitoryName(String dormitoryName) {
        return dormitoryBuildingMapper.dormitoryInfoBuDormitoryName(dormitoryName);
    }

    /**
     * 添加宿舍
     * @param dormitoryName
     * @return
     */
    @Override
    public int addDormitory(String dormitoryName) {
        return dormitoryBuildingMapper.addDormitory(dormitoryName);
    }

    /**
     * 修改宿舍
     * @param updateDormitoryVo
     * @return
     */
    @Override
    public int updateDormitory(UpdateDormitoryVo updateDormitoryVo) {
        return dormitoryBuildingMapper.updateDormitory(updateDormitoryVo);
    }

    /**
     * 批量删除宿舍
     * @param dormitoryIds
     * @return
     */
    @Override
    public int delDormitory(int[] dormitoryIds) {
        return dormitoryBuildingMapper.delDormitory(dormitoryIds);
    }
}
