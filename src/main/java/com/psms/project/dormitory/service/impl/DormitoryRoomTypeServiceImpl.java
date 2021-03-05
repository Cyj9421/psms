package com.psms.project.dormitory.service.impl;

import com.psms.project.dormitory.domain.DormitoryRoomType;
import com.psms.project.dormitory.domain.vo.UpdateRoomTypeVo;
import com.psms.project.dormitory.mapper.DormitoryRoomTypeMapper;
import com.psms.project.dormitory.service.IDormitoryRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 房间类型管理
 */
@Service
public class DormitoryRoomTypeServiceImpl implements IDormitoryRoomTypeService {
    @Autowired
    private DormitoryRoomTypeMapper typeMapper;

    /**
     * 房间类型列表
     * @return
     */
    @Override
    public List<DormitoryRoomType> typeList() {
        return typeMapper.typeList();
    }

    /**
     * 房间类型信息
     * @param typeId
     * @return
     */
    @Override
    public DormitoryRoomType typeInfo(int typeId) {
        return typeMapper.typeInfo(typeId);
    }

    /**
     * 房间类型信息
     * @param typeName
     * @return
     */
    @Override
    public DormitoryRoomType typeInfoByTypeName(String typeName) {
        return typeMapper.typeInfoByTypeName(typeName);
    }

    /**
     * 添加类型
     * @param typeName
     * @return
     */
    @Override
    public int addType(String typeName) {
        return typeMapper.addType(typeName);
    }

    /**
     * 修改房间类型
     * @param updateRoomTypeVo
     * @return
     */
    @Override
    public int updateType(UpdateRoomTypeVo updateRoomTypeVo) {
        return typeMapper.updateType(updateRoomTypeVo);
    }

    /**
     * 批量删除类型
     * @param typeIds
     * @return
     */
    @Override
    public int delTypes(int[] typeIds) {
        return typeMapper.delTypes(typeIds);
    }
}
