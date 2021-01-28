package com.psms.project.bussiness.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.bussiness.domain.BussinessTrip;
import com.psms.project.bussiness.service.IBussinessTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 出差信息
 */
@RestController
@RequestMapping("/bussiness/trip")
public class BussinessTripController extends BaseController {
    @Autowired
    private IBussinessTripService bussinessTripService;

    /**
     *查询出差列表
     */
    @GetMapping("/list")
    public AjaxResult tripList(BussinessTrip bussinessTrip, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BussinessTrip> list = bussinessTripService.selectTripList(bussinessTrip);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     *
     * 根据出差id查询出差详情
     */
    @GetMapping(value = "/{tripId}")
    public AjaxResult tripInfo(@PathVariable("tripId") int tripId){
        List<BussinessTrip> info=bussinessTripService.selectTripInfo(tripId);
        return AjaxResult.success(info);
    }

    /**
     *
     * 新增出差申请
     */
    @PostMapping("/add")
    public AjaxResult addTrip(@RequestBody BussinessTrip bussinessTrip){
        bussinessTrip.setCreateTripBy(SecurityUtils.getUsername());
        bussinessTrip.setCreateTripTime(new Date());
        return toAjax( bussinessTripService.addTrip(bussinessTrip));
    }
    /**
     *
     * 修改出差申请
     */
    @PutMapping("/update")
    public AjaxResult updateTrip(@RequestBody BussinessTrip bussinessTrip){
        bussinessTrip.setCreateTripBy(SecurityUtils.getUsername());
        bussinessTrip.setCreateTripTime(new Date());
        return toAjax(bussinessTripService.updateTrip(bussinessTrip));
    }
    /**
     *
     * 审核出差申请
     */
    @PutMapping("/updateStatus")
    public AjaxResult updateStatus(@RequestBody BussinessTrip bussinessTrip){
        bussinessTrip.setUpdateTripBy(SecurityUtils.getUsername());
        bussinessTrip.setUpdateTripTime(new Date());
        return toAjax(bussinessTripService.updateStatus(bussinessTrip));
    }

    /**
     * 批量删除出差信息
     * @param tripIds
     * @return
     */
    @DeleteMapping("/{tripIds}")
    public AjaxResult delTrip(@PathVariable int[] tripIds){
        return toAjax(bussinessTripService.delTrips(tripIds));
    }
}
