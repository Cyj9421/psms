package com.psms.project.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.vo.InsertRoomVo;
import com.psms.project.dormitory.domain.vo.SelectRoomVo;
import com.psms.project.dormitory.domain.vo.UpdateRoomVo;
import com.psms.project.dormitory.service.IDormitoryRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory/room")
@Api(tags = "房间管理")
public class DormitoryRoomController extends BaseController {
    @Autowired
    private IDormitoryRoomService roomService;
    @GetMapping("/list")
    @ApiOperation(value = "房间列表",notes = "房间列表")
    public AjaxResult roomList(SelectRoomVo selectRoomVo,@ApiParam("页码")@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @ApiParam("页显示条数") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DormitoryRoom> list = roomService.roomList(selectRoomVo);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info/list")
    @ApiOperation(value = "房间入住人员列表",notes = "房间入住人员列表")
    public AjaxResult roomInfoList(@ApiParam(value = "宿舍id") @RequestParam(value = "dormitoryId") int dormitoryId,
                                   @ApiParam(value = "房间id") @RequestParam(value = "roomId") int roomId){
        return AjaxResult.success(roomService.roomInfoList(dormitoryId,roomId));
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加房间",notes = "添加房间")
    public AjaxResult addRoom(@ApiParam("添加房间参数") @RequestBody InsertRoomVo insertRoomVo){
        if(StringUtils.isEmpty(insertRoomVo.getRoomName())){
            return AjaxResult.error(400,"房间名不能为空!");
        }
        DormitoryRoom dormitoryRoom = roomService.roomInfoByRoomName(insertRoomVo);
        if(dormitoryRoom != null){
            return AjaxResult.error(400,dormitoryRoom.getDormitoryName()+"已经有这个房间名了!");
        }
        return toAjax(roomService.addRoom(insertRoomVo));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改房间",notes = "修改房间")
    public AjaxResult updateRoom(@ApiParam("修改房间参数") @RequestBody UpdateRoomVo updateRoomVo){
        return toAjax(roomService.updateRoom(updateRoomVo));
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除房间",notes = "批量删除房间")
    public AjaxResult delRooms(@ApiParam("房间id数组") @RequestParam(value = "roomIds") int [] roomIds){
        return toAjax(roomService.delRooms(roomIds));
    }
}
