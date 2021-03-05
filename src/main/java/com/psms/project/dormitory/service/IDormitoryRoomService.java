package com.psms.project.dormitory.service;

import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.vo.DormitoryRoomInfoVo;
import com.psms.project.dormitory.domain.vo.InsertRoomVo;
import com.psms.project.dormitory.domain.vo.UpdateRoomVo;

import java.util.List;

/**
 * 服务层 房间管理
 */
public interface IDormitoryRoomService {
    /**
     * 房间列表
     * @return
     */
    public List<DormitoryRoom> roomList();

    /**
     * 房间入住人员列表
     * @return
     */
    public List<DormitoryRoomInfoVo> roomInfoList();

    /**
     * 房间信息
     * @param roomId
     * @return
     */
    public DormitoryRoom roomInfo(int roomId);

    /**
     * 房间信息
     * @param insertRoomVo
     * @return
     */
    public DormitoryRoom roomInfoByRoomName(InsertRoomVo insertRoomVo);

    /**
     * 添加房间
     * @param insertRoomVo
     * @return
     */
    public int addRoom(InsertRoomVo insertRoomVo);

    /**
     * 修改房间
     * @param updateRoomVo
     * @return
     */
    public int updateRoom(UpdateRoomVo updateRoomVo);

    /**
     * 批量删除房间
     * @param roomIds
     * @return
     */
    public int delRooms(int [] roomIds);
}
