package com.psms.project.dormitory.service;

import com.psms.project.dormitory.domain.DormitoryRoomType;
import com.psms.project.dormitory.domain.vo.UpdateRoomTypeVo;

import java.util.List;

/**
 * 服务层 房间类型
 */
public interface IDormitoryRoomTypeService {
    /**
     * 房间类型列表
     * @return
     */
    public List<DormitoryRoomType> typeList();

    /**
     * 房间类型信息
     * @param typeId
     * @return
     */
    public DormitoryRoomType typeInfo(int typeId);

    /**
     * 房间类型信息
     * @param typeName
     * @return
     */
    public DormitoryRoomType typeInfoByTypeName(String typeName);

    /**
     * 添加房间类型
     * @param typeName
     * @return
     */
    public int addType(String typeName);

    /**
     * 修改房间类型
     * @param updateRoomTypeVo
     * @return
     */
    public int updateType(UpdateRoomTypeVo updateRoomTypeVo);

    /**
     * 批量删除房间类型
     * @param typeIds
     * @return
     */
    public int delTypes(int [] typeIds);
}
