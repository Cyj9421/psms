package com.psms.project.dormitory.controller;

import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryBed;
import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.vo.InsertBedVo;
import com.psms.project.dormitory.domain.vo.SelectBedVo;
import com.psms.project.dormitory.domain.vo.UpdateBedVo;
import com.psms.project.dormitory.service.IDormitoryBedService;
import com.psms.project.dormitory.service.IDormitoryRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dormitory/bed")
@Api(tags = "床号管理")
public class DormitoryBedController extends BaseController {
    @Autowired
    private IDormitoryBedService bedService;
    @Autowired
    private IDormitoryRoomService roomService;
    @GetMapping("/list")
    @ApiOperation(value = "床号列表",notes = "床号列表")
    public AjaxResult bedList(@ApiParam("床号查询参数") SelectBedVo selectBedVo){
        return AjaxResult.success(bedService.bedList(selectBedVo));
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加床号",notes ="添加床号")
    public AjaxResult addBed(@ApiParam("添加床号") @RequestBody InsertBedVo insertBedVo){
        if(StringUtils.isEmpty(insertBedVo.getBedNo())){
            return AjaxResult.error(400,"床号不能为空");
        }
        DormitoryRoom dormitoryRoom = roomService.roomInfo(insertBedVo.getRoomId());
        DormitoryBed dormitoryBed = bedService.selectBed(insertBedVo);
        int beds = bedService.totalBed(insertBedVo.getRoomId());
        if(beds >= dormitoryRoom.getRoomCapacity()){
            return AjaxResult.error(400,dormitoryRoom.getRoomCapacity()+"人房,不能再添加床号了");
        }
        if(dormitoryBed != null ){
            return AjaxResult.error(400,"已经有该床号了");
        }
        return toAjax(bedService.addBed(insertBedVo));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改床号",notes = "修改床号")
    public AjaxResult updateBed(@ApiParam("修改床号") @RequestBody UpdateBedVo updateBedVo){
        return toAjax(bedService.updateBed(updateBedVo));
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除床号",notes = "批量删除床号")
    public AjaxResult delBeds(@ApiParam("批量删除床号") @RequestParam(value = "bedIds") int [] bedIds){
        return toAjax(bedService.delBeds(bedIds));
    }
}
