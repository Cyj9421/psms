package com.psms.project.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.dormitory.domain.DormitoryBuilding;
import com.psms.project.dormitory.domain.DormitoryRoom;
import com.psms.project.dormitory.domain.DormitoryTransfer;
import com.psms.project.dormitory.domain.vo.InsertTransferVo;
import com.psms.project.dormitory.domain.vo.UpdateTransferVo;
import com.psms.project.dormitory.service.IDormitoryRoomService;
import com.psms.project.dormitory.service.IDormitoryTransferService;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import com.psms.project.induction.service.IInductionStaffService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dormitory/transfer")
@Api(tags = "房间调动")
public class DormitoryTransferController extends BaseController {
    @Autowired
    private IDormitoryTransferService transferService;
    @Autowired
    private ISysUserNumberService userNumberService;
    @Autowired
    private IDormitoryRoomService roomService;
    @Autowired
    private IInductionStaffService staffService;
    @GetMapping("/list")
    @ApiOperation(value = "房间调动列表",notes = "房间调动列表")
    public AjaxResult transferList(@ApiParam("页码") @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @ApiParam("页显示条数") @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DormitoryTransfer> list = transferService.transferList();
        for(int i=0;i<list.size();i++){
            DormitoryTransfer dormitoryTransfer = list.get(i);
            dormitoryTransfer.setTotalNum(transferService.totalNum(dormitoryTransfer.getWorkNum()));
        }
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/info")
    @ApiOperation(value = "房间调动详情",notes = "房间调动详情")
    public AjaxResult transferInfo(@ApiParam(value = "调动id") @RequestParam(value = "transferId") Integer transferId){
        DormitoryTransfer dormitoryTransfer = transferService.transferInfo(transferId);
        dormitoryTransfer.setTotalNum(transferService.totalNum(dormitoryTransfer.getWorkNum()));
        return AjaxResult.success(dormitoryTransfer);
    }
    @PostMapping("/add")
    @ApiOperation(value = "申请调动",notes = "申请调动")
    public AjaxResult addTransfer(@ApiParam(value = "申请调动参数") @RequestBody InsertTransferVo insertTransferVo){
        if(StringUtils.isEmpty(insertTransferVo.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空!");
        }
        SysUserNumber sysUserNumber = userNumberService.numberByWorkNum(insertTransferVo.getWorkNum());
        if(sysUserNumber==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }
        DormitoryRoom dormitoryRoom = roomService.roomInfo(insertTransferVo.getRoomId());
        if(dormitoryRoom.getRoomCapacity()<=0){
            return AjaxResult.error(400,"该房间入住人数已满!");
        }
        return toAjax(transferService.addTransfer(insertTransferVo));
    }
    @PutMapping("/update")
    @ApiOperation(value = "审核调动",notes = "审核调动")
    public AjaxResult updateTransfer(@ApiParam(value = "审核调动参数") @RequestBody UpdateTransferVo updateTransferVo){
        int i = transferService.updateTransfer(updateTransferVo);
        if(i<=0){
            return AjaxResult.error(400,"不能二次审核!");
        }
        if(updateTransferVo.getTransferStatus()==1){
            DormitoryTransfer dormitoryTransfer = transferService.transferInfo(updateTransferVo.getTransferId());
            InductionVo inductionVo = staffService.inductionInfoByWorkNum(dormitoryTransfer.getWorkNum());
            UpdateInductionVo updateInductionVo=new UpdateInductionVo();
            updateInductionVo.setInductionId(inductionVo.getInductionId());
            updateInductionVo.setDormitoryId(dormitoryTransfer.getDormitoryId());
            updateInductionVo.setRoomId(dormitoryTransfer.getRoomId());
            staffService.updateInduction(updateInductionVo);
        }
        return AjaxResult.success();
    }
    @DeleteMapping("/del")
    @ApiOperation(value = "批量删除调动信息",notes = "批量删除调动信息")
    public AjaxResult delTransfers(@ApiParam(value = "调动id数组") @RequestParam(value = "transferIds")int [] transferIds){
        return toAjax(transferService.delTransfers(transferIds));
    }
}
