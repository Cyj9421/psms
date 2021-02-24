package com.psms.project.induction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.induction.domain.InductionCurrency;
import com.psms.project.induction.domain.vo.CurrencyVo;
import com.psms.project.induction.service.IInductionCurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/induction/currency")
@Api(tags = "币种管理")
public class InductionCurrencyController extends BaseController {
    @Autowired
    private IInductionCurrencyService currencyService;
    @GetMapping("/list")
    @ApiOperation(value = "查询币种列表",notes = "查询币种列表，目前只允许通过币种名查询")
    public AjaxResult currencyList(InductionCurrency currency,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<InductionCurrency> list = currencyService.currencyList(currency);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info")
    @ApiOperation(value = "查询币种详情",notes = "查询币种详情")
    public AjaxResult currencyInfo(@ApiParam("币种id") @RequestParam int currencyId){
        return AjaxResult.success(currencyService.currencyInfo(currencyId));
    }
    @PostMapping
    @ApiOperation(value = "添加币种",notes = "添加币种")
    public AjaxResult addCurrency(@ApiParam("币种对象,新增不带id") @RequestBody CurrencyVo currencyVo){
        return toAjax(currencyService.addCurrency(currencyVo));
    }
    @PutMapping
    @ApiOperation(value = "修改币种",notes = "修改币种")
    public AjaxResult updateCurrency(@ApiParam("币种对象") @RequestBody CurrencyVo currencyVo){
        return toAjax(currencyService.updateCurrency(currencyVo));
    }
    @DeleteMapping
    @ApiOperation(value = "批量删除币种",notes = "批量删除币种")
    public AjaxResult delCurrency(@ApiParam("币种id数组") @RequestParam int [] currencyIds){
        return toAjax(currencyService.delCurrency(currencyIds));
    }
}
