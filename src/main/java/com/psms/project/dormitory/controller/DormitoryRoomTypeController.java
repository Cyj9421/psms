package com.psms.project.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryRoomType;
import com.psms.project.dormitory.domain.vo.UpdateRoomTypeVo;
import com.psms.project.dormitory.service.IDormitoryRoomTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory/room/type")
@Api(tags = "房间类型管理")
public class DormitoryRoomTypeController extends BaseController {
    @Autowired
    private IDormitoryRoomTypeService typeService;
    @GetMapping("/list")
    @ApiOperation(value = "房间类型列表",notes = "房间类型列表")
    public AjaxResult typeList(@ApiParam("页码") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @ApiParam("页显示条数") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DormitoryRoomType> list = typeService.typeList();
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加房间类型",notes = "添加房间类型")
    public AjaxResult addType(@RequestParam(value = "typeName") String typeName){
        if(StringUtils.isEmpty(typeName)){
            return AjaxResult.error(400,"房间类型不能为空");
        }
        DormitoryRoomType roomType=typeService.typeInfoByTypeName(typeName);
        if(roomType !=null){
            return AjaxResult.error(400,"已经有这个类型了!");
        }
        return toAjax(typeService.addType(typeName));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改房间类型",notes = "修改房间类型")
    public AjaxResult updateType(@ApiParam("修改房间类型参数") @RequestBody UpdateRoomTypeVo updateRoomTypeVo){
        if(StringUtils.isEmpty(updateRoomTypeVo.getTypeName())){
            return AjaxResult.error(400,"房间类型不能为空");
        }
        return toAjax(typeService.updateType(updateRoomTypeVo));
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除房间类型",notes = "批量删除房间类型")
    public AjaxResult delTypes(@ApiParam("类型id数组") @RequestParam(value = "typeIds") int [] typeIds){
        return toAjax(typeService.delTypes(typeIds));
    }
}
