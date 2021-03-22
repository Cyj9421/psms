package com.psms.project.dormitory.service.impl;

import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.vo.DormitoryRoomInfoVo;
import com.psms.project.dormitory.domain.vo.InsertRoomVo;
import com.psms.project.dormitory.domain.vo.SelectRoomVo;
import com.psms.project.dormitory.domain.vo.UpdateRoomVo;
import com.psms.project.dormitory.mapper.DormitoryRoomMapper;
import com.psms.project.dormitory.service.IDormitoryRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 房间管理
 */
@Service
public class DormitoryRoomServiceImpl implements IDormitoryRoomService {
    @Autowired
    private DormitoryRoomMapper roomMapper;

    /**
     * 房间列表
     * @return
     */
    @Override
    public List<DormitoryRoom> roomList(SelectRoomVo selectRoomVo) {
        return roomMapper.roomList(selectRoomVo);
    }

    /**
     * 房间入住人员列表
     * @return
     */
    @Override
    public List<DormitoryRoomInfoVo> roomInfoList(int dormitoryId,int roomId) {
        return roomMapper.roomInfoList(dormitoryId,roomId);
    }

    /**
     * 房间详情
     * @param roomId
     * @return
     */
    @Override
    public DormitoryRoom roomInfo(int roomId) {
        return roomMapper.roomInfo(roomId);
    }

    /**
     * 房间详情
     * @param insertRoomVo
     * @return
     */
    @Override
    public DormitoryRoom roomInfoByRoomName(InsertRoomVo insertRoomVo) {
        return roomMapper.roomInfoByRoomName(insertRoomVo);
    }

    /**
     * 添加房间
     * @param insertRoomVo
     * @return
     */
    @Override
    public int addRoom(InsertRoomVo insertRoomVo) {
        return roomMapper.addRoom(insertRoomVo);
    }

    /**
     * 修改房间
     * @param updateRoomVo
     * @return
     */
    @Override
    public int updateRoom(UpdateRoomVo updateRoomVo) {
        return roomMapper.updateRoom(updateRoomVo);
    }

    /**
     * 批量删除房间
     * @param roomIds
     * @return
     */
    @Override
    public int delRooms(int[] roomIds) {
        return roomMapper.delRooms(roomIds);
    }
}
