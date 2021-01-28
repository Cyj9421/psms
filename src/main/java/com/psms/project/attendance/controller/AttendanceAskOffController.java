package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceAskOff;
import com.psms.project.attendance.service.IAttendanceAskOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//请休假管理
@RestController
@RequestMapping("/attendance/askOff")
public class AttendanceAskOffController extends BaseController {
    @Autowired
    private IAttendanceAskOffService attendanceAskOffService;

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
