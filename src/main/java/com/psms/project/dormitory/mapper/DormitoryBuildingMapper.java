package com.psms.project.dormitory.mapper;

import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.vo.UpdateDormitoryVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 宿舍管理
 */
@Mapper
public interface DormitoryBuildingMapper {
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
    public  DormitoryBuilding dormitoryInfoBuDormitoryName(String dormitoryName);

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
     * 漂亮删除宿舍
     * @param dormitoryIds
     * @return
     */
    public int delDormitory(int [] dormitoryIds);
}
