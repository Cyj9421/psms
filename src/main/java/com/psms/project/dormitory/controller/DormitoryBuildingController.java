package com.psms.project.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.vo.UpdateDormitoryVo;
import com.psms.project.dormitory.service.IDormitoryBuildingService;
import com.psms.project.induction.domain.vo.InductionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory")
@Api(tags = "宿舍管理")
public class DormitoryBuildingController extends BaseController {
    @Autowired
    private IDormitoryBuildingService buildingService;
    @ApiOperation(value = "宿舍列表",notes = "宿舍列表")
    @GetMapping("/list")
    public AjaxResult dormitoryList(@ApiParam("页码") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                    @ApiParam("页显示条数") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DormitoryBuilding> list = buildingService.dormitoryList();
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加宿舍",notes = "添加宿舍")
    public AjaxResult addDormitory(@RequestParam(value = "dormitoryName") String dormitoryName){
        if(StringUtils.isEmpty(dormitoryName)){
            return AjaxResult.error(400,"宿舍名不能为空!");
        }
        DormitoryBuilding dormitoryBuilding = buildingService.dormitoryInfoBuDormitoryName(dormitoryName);
        if(dormitoryBuilding != null){
            return AjaxResult.error(400,"已经有这个名字了!");
        }
        return toAjax(buildingService.addDormitory(dormitoryName));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改宿舍",notes = "修改宿舍")
    public AjaxResult updateDormitory(@ApiParam("修改宿舍参数") @RequestBody UpdateDormitoryVo updateDormitoryVo){
        if(StringUtils.isEmpty(updateDormitoryVo.getDormitoryName())){
            return AjaxResult.error(400,"宿舍名不能为空!");
        }
        return toAjax(buildingService.updateDormitory(updateDormitoryVo));
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除宿舍",notes = "批量删除宿舍")
    public AjaxResult delDormitorys(@ApiParam("宿舍id数组") @RequestParam(value = "dormitoryIds") int [] dormitoryIds){
        return toAjax(buildingService.delDormitory(dormitoryIds));
    }
}
