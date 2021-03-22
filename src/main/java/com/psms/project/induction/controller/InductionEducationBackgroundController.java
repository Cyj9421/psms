package com.psms.project.induction.controller;

import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.induction.domain.InductionEducationBackground;
import com.psms.project.induction.domain.vo.UpdateEducationBackgroundVo;
import com.psms.project.induction.service.IInductionEducationBackgroundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/induction/education/bg")
@Api(tags = "学历管理")
public class InductionEducationBackgroundController extends BaseController {
    @Autowired
    private IInductionEducationBackgroundService educationBackgroundService;
    @GetMapping("/list")
    @ApiOperation(value = "学历列表",notes = "学历列表")
    public AjaxResult educationBackgroundList(){
        List<InductionEducationBackground> inductionEducationBackgroundList = educationBackgroundService.educationBackgroundList();
        return AjaxResult.success(inductionEducationBackgroundList);
    }
    @GetMapping("/info")
    @ApiOperation(value = "学历详情",notes = "学历详情")
    public AjaxResult educationBackgroundInfo(@ApiParam("学历id") @RequestParam(value = "educationId") int educationId){
        return AjaxResult.success(educationBackgroundService.educationBackgroundInfo(educationId));
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加学历",notes = "添加学历")
    public AjaxResult addEducationBackground(@ApiParam("学历") @RequestParam(value = "educationBackground") String educationBackground){
        if(StringUtils.isEmpty(educationBackground)){
            return AjaxResult.error(400,"学历不能为空");
        }
        InductionEducationBackground inductionEducationBackground = educationBackgroundService.educationBackground(educationBackground);
        if(inductionEducationBackground != null){
            return AjaxResult.error(400,"添加失败，已经有该学历了");
        }
        return toAjax(educationBackgroundService.addEducationBackground(educationBackground));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改学历",notes = "修改学历")
    public AjaxResult updateEducationBackground(@RequestBody UpdateEducationBackgroundVo updateEducationBackgroundVo){
        return toAjax(educationBackgroundService.updateEducationBackground(updateEducationBackgroundVo));
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除学历",notes = "批量删除学历")
    public AjaxResult delEducationBackgrounds(@ApiParam("学历id数组") @RequestParam(value = "educationIds") int [] educationIds){
        return toAjax(educationBackgroundService.delEducationBackgrounds(educationIds));
    }
}
