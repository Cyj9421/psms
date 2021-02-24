package com.psms.project.induction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.induction.domain.InductionProbation;
import com.psms.project.induction.domain.InductionStaff;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import com.psms.project.induction.service.IInductionProbationService;
import com.psms.project.induction.service.IInductionStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/induction")
@Api(tags = "入职申请")
public class InductionStaffController extends BaseController {
    @Autowired
    private IInductionStaffService inductionStaffService;
    @Autowired
    private IInductionProbationService probationService;
    @GetMapping("/list")
    @ApiOperation(value = "入职列表",notes = "入职列表")
    public AjaxResult inductionList(SelectInductionVo selectInductionVo, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<InductionVo> list = inductionStaffService.inductionList(selectInductionVo);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info")
    @ApiOperation(value = "入职详情",notes = "入职详情")
    public AjaxResult inductionInfo(@ApiParam("入职id") @RequestParam(value = "inductionId") int inductionId){
        return AjaxResult.success(inductionStaffService.inductionInfo(inductionId));
    }
    @PostMapping
    @ApiOperation(value = "添加入职",notes = "添加入职")
    public AjaxResult addInduction(@ApiParam("新增入职参数表") @RequestBody InsertInductionVo insertInductionVo){
        insertInductionVo.setProbationId(probationService.maxProbationId()+1);
        inductionStaffService.addInduction(insertInductionVo);
        InductionProbation probation=new InductionProbation();
        probation.setProbationId(probationService.maxProbationId()+1);
        probation.setProbationMonth(insertInductionVo.getProbationMonth());
        probation.setProbationDay(insertInductionVo.getProbationDay());
        probationService.addProbation(probation);
        return AjaxResult.success();
    }
    @PutMapping
    @ApiOperation(value = "修改入职",notes = "修改入职")
    public AjaxResult updateInduction(@ApiParam("入职申请表") @RequestBody UpdateInductionVo updateInductionVo){
        return toAjax(inductionStaffService.updateInduction(updateInductionVo));
    }
    @DeleteMapping
    @ApiOperation(value = "批量删除入职记录",notes = "批量删除入职记录")
    public AjaxResult delInduction(@ApiParam("入职id数组") @RequestParam(value = "inductionIds") int [] inductionIds){
        return toAjax(inductionStaffService.delInductions(inductionIds));
    }
}
