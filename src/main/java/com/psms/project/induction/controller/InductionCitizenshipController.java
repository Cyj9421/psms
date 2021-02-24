package com.psms.project.induction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.induction.domain.InductionCitizenship;
import com.psms.project.induction.domain.vo.CitizenshipVo;
import com.psms.project.induction.domain.vo.SelectCitizenshipVo;
import com.psms.project.induction.service.IInductionCitizenshipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/induction/citizenship")
@Api(tags = "国籍管理")
public class InductionCitizenshipController extends BaseController {
    @Autowired
    private IInductionCitizenshipService citizenshipService;
    @GetMapping("/list")
    @ApiOperation(value = "查询国籍列表",notes="查询国籍列表")
    public AjaxResult citizenshipList(@ApiParam("国际名") SelectCitizenshipVo selectCitizenshipVo, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<InductionCitizenship> list = citizenshipService.citizenshipList(selectCitizenshipVo);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info")
    @ApiOperation(value = "查询国籍详情",notes="查询国籍详情")
    public AjaxResult citizenshipInfo(@ApiParam("国籍id") @RequestParam(value = "citizenshipId") int citizenshipId){
        return AjaxResult.success(citizenshipService.citizenshipInfo(citizenshipId));
    }
    @PostMapping
    @ApiOperation(value = "添加国籍",notes ="添加国籍")
    public AjaxResult addCitizenship(@ApiParam("国籍对象,新增不带id") @RequestBody CitizenshipVo citizenshipVo){
        return toAjax(citizenshipService.addCitizenship(citizenshipVo));
    }
    @PutMapping
    @ApiOperation(value = "修改国籍",notes = "修改国籍")
    public AjaxResult updateCitizenship(@ApiParam("国籍对象") @RequestBody CitizenshipVo citizenshipVo){
        return toAjax(citizenshipService.updateCitizenship(citizenshipVo));
    }
    @DeleteMapping
    @ApiOperation(value = "批量删除国籍",notes = "批量删除国籍")
    public AjaxResult delCitizenship(@ApiParam("国籍id数组") @RequestParam(value = "citizenshipIds") int [] citizenshipIds){
        return toAjax(citizenshipService.delCitizenship(citizenshipIds));
    }
}
