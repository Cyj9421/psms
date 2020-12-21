package com.psms.project.bussiness.controller;

import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.bussiness.domain.BussinessComplete;
import com.psms.project.bussiness.domain.BussinessTrip;
import com.psms.project.bussiness.service.IBussinessCompleteService;
import com.psms.project.bussiness.service.IBussinessTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 销差信息
 */
@RestController
@RequestMapping("/bussiness/complete")
public class BussinessCompleteController extends BaseController {
    @Autowired
    private IBussinessCompleteService bussinessCompleteService;
    @Autowired
    private IBussinessTripService bussinessTripService;

    /**
     * 查询销差列表
     * @param bussinessComplete
     * @return
     */
    @GetMapping("/list")
    public AjaxResult destroyList(BussinessComplete bussinessComplete){
        return AjaxResult.success(bussinessCompleteService.destroyList(bussinessComplete));
    }

    /**
     * 查询销差详情
     * @param destroyId
     * @return
     */
    @GetMapping(value = "/{destroyId}")
    public AjaxResult destroyInfo(@PathVariable("destroyId") int destroyId){
        BussinessComplete bussinessComplete=bussinessCompleteService.destroyInfo(destroyId);
        return AjaxResult.success(bussinessComplete);
    }
    /**
     * 提交销差申请
     * @param bussinessComplete
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addDestroy(@RequestBody BussinessComplete bussinessComplete){
        bussinessComplete.setCreateDestroyTime(new Date());
        return toAjax(bussinessCompleteService.addDestroy(bussinessComplete));
    }
    /**
     * 审核销差申请
     * @param bussinessComplete
     * @return
     */
    @PutMapping("/updateStatus")
    public AjaxResult updateDestroy(@RequestBody BussinessComplete bussinessComplete){
//          bussinessComplete.setUpdateDestroyBy(SecurityUtils.getUsername());
            bussinessComplete.setUpdateDestroyTime(new Date());
        int res=bussinessCompleteService.updateDestroy(bussinessComplete);
        BussinessComplete bussinessCompleteinfo=bussinessCompleteService.destroyInfo(bussinessComplete.getDestroyId());
        BussinessTrip bussinessTrip=new BussinessTrip();
        if(bussinessComplete.getDestroyStatus()==0){
            bussinessTrip.setTripId(bussinessCompleteinfo.getTripId());
            bussinessTrip.setTripStatus(3);
//          bussinessTrip.setCreateTripBy(SecurityUtils.getUsername());
            bussinessTrip.setUpdateTripTime(new Date());
            bussinessTripService.bussinessDestroy(bussinessTrip);
        }
        return toAjax(res);

    }
}
