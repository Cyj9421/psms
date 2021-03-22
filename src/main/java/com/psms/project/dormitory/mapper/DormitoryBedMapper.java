package com.psms.project.dormitory.mapper;

import com.psms.project.dormitory.domain.DormitoryBed;
import com.psms.project.dormitory.domain.vo.InsertBedVo;
import com.psms.project.dormitory.domain.vo.SelectBedVo;
import com.psms.project.dormitory.domain.vo.UpdateBedVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 床号管理
 */
@Mapper
public interface DormitoryBedMapper {
    /**
     * 查看床号列表
     * @param selectBedVo
     * @return
     */
    public List<DormitoryBed> bedList(SelectBedVo selectBedVo);

    /**
     * 根据床号id查看床号
     * @param bedId
     * @return
     */
    public DormitoryBed bedInfo(int bedId);

    /**
     * 添加床号
     * @param insertBedVo
     * @return
     */
    public int addBed(InsertBedVo insertBedVo);

    /**
     * 修改床号
     * @param updateBedVo
     * @return
     */
    public int updateBed(UpdateBedVo updateBedVo);

    /**
     * 统计房间床数量
     * @param roomId
     * @return
     */
    public int totalBed(int roomId);

    /**
     * 批量删除床号
     * @param bedIds
     *
     * @return
     */
    public int delBeds(int [] bedIds);

    /**
     * 查找床号
     * @param insertBedVo
     * @return
     */
    public DormitoryBed selectBed(InsertBedVo insertBedVo);
 }
