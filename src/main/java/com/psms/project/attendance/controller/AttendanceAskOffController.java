package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.service.IAttendanceAskOffService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//请休假管理
@RestController
@RequestMapping("/attendance/askOff")
public class AttendanceAskOffController extends BaseController {
    @Autowired
    private IAttendanceAskOffService attendanceAskOffService;
    @Autowired
    private ISysUserNumberService userNumberService;
    /**
     * 请假列表
     * @return
     */
    @GetMapping("/list")
    public AjaxResult askOffList(AttendanceAskOff attendanceAskOff, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceAskOff> list = attendanceAskOffService.askList(attendanceAskOff);
        PageInfo pageInfo = new PageInfo(list);
            return AjaxResult.success(pageInfo);
    }
    /**
     * 请假详情
     * @param askId
     * @return
     */
    @GetMapping("/{askId}")
    public AjaxResult askOffInfo(@PathVariable int askId){
        return AjaxResult.success(attendanceAskOffService.askOffInfo(askId));
    }

    /**
     * 请假申请
     * @param attendanceAskOff
     * @return
     */
    @PostMapping("/add")
    public AjaxResult askOff(@RequestBody AttendanceAskOff attendanceAskOff){
        if(StringUtils.isEmpty(attendanceAskOff.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(attendanceAskOff.getWorkNum());
        if(userNumber ==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }
        return toAjax(attendanceAskOffService.askOff(attendanceAskOff));
    }

    /**
     * 请假审核
     * @param attendanceAskOff
     * @return
     */
    @PutMapping("/update")
    public AjaxResult updateById(@RequestBody AttendanceAskOff attendanceAskOff){
        attendanceAskOff.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(attendanceAskOffService.updateById(attendanceAskOff));
    }

    /**
     * 批量删除
     * @param askIds
     * @return
     */
    @DeleteMapping("/{askIds}")
    public AjaxResult delAsk(@PathVariable int [] askIds){
        return toAjax(attendanceAskOffService.delAskOff(askIds));
    }
}
