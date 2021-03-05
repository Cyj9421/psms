package com.psms.project.dormitory.service;

import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.vo.UpdateDormitoryVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;

import java.util.List;

/**
 * 服务层 宿舍管理
 */
public interface IDormitoryBuildingService {
    /**
     * 宿舍列表
     * @return
     */
    public List<DormitoryBuilding> dormitoryList();

    /**
     * 宿舍详情
     * @param dormitoryId
     * @return
     */
    public DormitoryBuilding dormitoryInfo(int dormitoryId);

    /**
     * 宿舍详情
     * @param dormitoryName
     * @return
     */
    public DormitoryBuilding dormitoryInfoBuDormitoryName(String dormitoryName);

    /**
     * 添加宿舍
     * @param dormitoryName
     * @return
     */
    public int addDormitory(String dormitoryName);

    /**
     * 修改宿舍
     * @param updateDormitoryVo
     * @return
     */
    public int updateDormitory(UpdateDormitoryVo updateDormitoryVo);

    /**
     * 批量删除宿舍
     * @param dormitoryIds
     * @return
     */
    public int delDormitory(int [] dormitoryIds);
}
