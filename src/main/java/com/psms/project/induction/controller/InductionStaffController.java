package com.psms.project.induction.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.vo.UpdateRoomVo;
import com.psms.project.dormitory.service.IDormitoryRoomService;
import com.psms.project.induction.domain.InductionProbation;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import com.psms.project.induction.service.IInductionProbationService;
import com.psms.project.induction.service.IInductionStaffService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/induction")
@Api(tags = "入职申请")
public class InductionStaffController extends BaseController {
    @Autowired
    private IInductionStaffService inductionStaffService;
    @Autowired
    private IInductionProbationService probationService;
    @Autowired
    private ISysUserNumberService userNumberService;
    @Autowired
    private IDormitoryRoomService roomService;
    @GetMapping("/list")
    @ApiOperation(value = "入职列表",notes = "入职列表")
    public AjaxResult inductionList(SelectInductionVo selectInductionVo, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<InductionVo> list = inductionStaffService.inductionList(selectInductionVo);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/salary")
    @ApiOperation(value = "根据工号查找底薪",notes = "根据工号查找底薪")
    public AjaxResult selectBaseSalary(@ApiParam("工号") @RequestParam(value = "workNum") String workNum){
        if(StringUtils.isEmpty(workNum)){
            return AjaxResult.error(400,"工号不能为空");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(workNum);
        if(userNumber ==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }
        DecimalFormat df   = new DecimalFormat("######0.00");
        double baseSalary =0;
        try {
            baseSalary=inductionStaffService.selectBaseSalary(workNum);
        }catch (Exception e) {
            e.printStackTrace();
            baseSalary=4000.00;
        }
        df.format(baseSalary);
        return AjaxResult.success(baseSalary);
    }
    @GetMapping("/info")
    @ApiOperation(value = "入职详情",notes = "入职详情")
    public AjaxResult inductionInfo(@ApiParam("入职id") @RequestParam(value = "inductionId") int inductionId){
        return AjaxResult.success(inductionStaffService.inductionInfo(inductionId));
    }
    @PostMapping
    @ApiOperation(value = "添加入职",notes = "添加入职")
    public AjaxResult addInduction(@ApiParam("新增入职参数表")  @RequestBody InsertInductionVo insertInductionVo){
        if(StringUtils.isEmpty(insertInductionVo.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(insertInductionVo.getWorkNum());
        if(userNumber ==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }
        InductionVo inductionVo=inductionStaffService.inductionInfoByWorkNum(insertInductionVo.getWorkNum());
        if(inductionVo!=null){
            return AjaxResult.error(400,"已有该工号的信息");
        }
        if(inductionVo.getDormitoryId()==0){
            return AjaxResult.error(400,"请选择宿舍!");
        }
        if(inductionVo.getRoomId()==0){
            return AjaxResult.error(400,"请选择房间!");
        }
        DormitoryRoom dormitoryRoom = roomService.roomInfo(inductionVo.getRoomId());
            if(dormitoryRoom.getRoomCapacity()<=0){
                return AjaxResult.error(400,"该房间入住人员已满");
            }
        UpdateRoomVo roomVo=new UpdateRoomVo();
            roomVo.setRoomId(dormitoryRoom.getRoomId());
            roomVo.setRoomCapacity(dormitoryRoom.getRoomCapacity()-1);
            roomService.updateRoom(roomVo);
        insertInductionVo.setProbationId(probationService.maxProbationId()+1);
        inductionStaffService.addInduction(insertInductionVo);
        InductionProbation probation=new InductionProbation();
        probation.setProbationId(probationService.maxProbationId()+1);
        probation.setProbationMonth(insertInductionVo.getProbationMonth());
        probation.setProbationDay(insertInductionVo.getProbationDay());
        probation.setWorkNum(insertInductionVo.getWorkNum());
        probationService.addProbation(probation);
        return AjaxResult.success();
    }
    @PutMapping
    @ApiOperation(value = "修改入职",notes = "修改入职")
    public AjaxResult updateInduction(@ApiParam("入职申请表") @RequestBody UpdateInductionVo updateInductionVo){
        return toAjax(inductionStaffService.updateInduction(updateInductionVo));
    }
    @PutMapping("/update/status")
    @ApiOperation(value = "入职审核",notes = "入职审核")
    public AjaxResult updateStatus(@ApiParam("入职id") @RequestParam(value = "inductionId") int inductionId,
                                   @ApiParam("入职状态(1审核通过,2审核中,3未通过)") @RequestParam(value = "inductionStatus") int inductionStatus){
        int row=inductionStaffService.updateInductionStatus(inductionId,inductionStatus);
        if(row >=0){
            return AjaxResult.error(400,"不能二次审核!");
        }
        return AjaxResult.success();
    }
    @DeleteMapping
    @ApiOperation(value = "批量删除入职记录",notes = "批量删除入职记录")
    public AjaxResult delInduction(@ApiParam("入职id数组") @RequestParam(value = "inductionIds") int [] inductionIds){
        return toAjax(inductionStaffService.delInductions(inductionIds));
    }
}
