package com.psms.project.induction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.induction.domain.InductionDeposit;
import com.psms.project.induction.domain.vo.InductionDepositVo;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.SelectDepositVo;
import com.psms.project.induction.service.IInductionDepositService;
import com.psms.project.induction.service.IInductionStaffService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/induction/deposit")
@Api(tags = "押金管理")
public class InductionDepositController extends BaseController {
    @Autowired
    private IInductionDepositService depositService;
    @Autowired
    private ISysUserNumberService userNumberService;
    @Autowired
    private IInductionStaffService iInductionStaffService;
    @GetMapping("/list")
    @ApiOperation(value = "押金列表",notes = "押金列表")
    public AjaxResult depositVoList(@ApiParam("押金列表查询参数") SelectDepositVo selectDepositVo,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PageHelper.startPage(pageNum, pageSize);
        List<InductionDepositVo> list = depositService.depositList(selectDepositVo);
            for(int i=0;i<list.size();i++){
                InductionDepositVo depositVo=list.get(i);
                long diff=sdf.parse(sdf.format(new Date())).getTime()-sdf.parse(sdf.format(depositVo.getCreateTime())).getTime();
                int year=(int) (diff/86400000/365);
                if(year>=1){
                    depositVo.setWorkingYears(year+"年以上");
                }else {
                    depositVo.setWorkingYears("1年以内");
                }
            }
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info")
    @ApiOperation(value = "押金详情",notes = "押金详情")
    public AjaxResult depositInfo(@ApiParam("押金id") @RequestParam(value = "depositId") int depositId) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InductionDepositVo depositVo=depositService.depositInfo(depositId);
        long diff=sdf.parse(sdf.format(new Date())).getTime()-sdf.parse(sdf.format(depositVo.getCreateTime())).getTime();
        int year=(int) (diff/86400000/365);
        if(year>=1){
            depositVo.setWorkingYears(year+"年以上");
        }else {
            depositVo.setWorkingYears("1年以内");
        }
        return AjaxResult.success(depositVo);
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加押金信息",notes = "添加押金信息,不用带depositId")
    public AjaxResult addDeposit(@ApiParam("押金参数") @RequestBody InductionDeposit inductionDeposit){
        if(("null").equals(inductionDeposit.getWorkNum()) || ("").equals(inductionDeposit.getWorkNum())){
            return AjaxResult.error(400,"请输入工号!");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(inductionDeposit.getWorkNum());
        if(userNumber==null){
            return AjaxResult.error(400,"请输入正确的工号");
        }
        InductionVo inductionVo = iInductionStaffService.inductionInfoByWorkNum(inductionDeposit.getWorkNum());
        if(inductionVo==null){
            return AjaxResult.error(400,"添加失败,请先入职!");
        }
        InductionDepositVo inductionDepositVo=depositService.depositInfoByworkNum(inductionDeposit.getWorkNum());
        if(inductionDepositVo != null){
            return AjaxResult.error(400,"已有该工号的押金信息!");
        }
        return toAjax(depositService.addDeposit(inductionDeposit));
    }
    @PutMapping("/update")
    @ApiOperation(value = "修改押金信息",notes = "修改押金信息")
    public AjaxResult updateDeposit(@ApiParam("押金参数") @RequestBody InductionDeposit inductionDeposit){
            return toAjax(depositService.updateDeposit(inductionDeposit));
    }
    @PutMapping("/return")
    @ApiOperation(value = "返还押金信息",notes = "返还押金信息")
    public AjaxResult returnDeposit(@ApiParam("押金id") @RequestParam(value = "depositId") int depositId,
                                    @ApiParam("操作类型") @RequestParam(value = "operType") int operType){
        return toAjax(depositService.returnDeposit(depositId,operType));
    }
}
