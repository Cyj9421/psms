package com.psms.project.attendance.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.SecurityUtils;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.AttendanceOvertime;
import com.psms.project.attendance.domain.AttendanceRp;
import com.psms.project.attendance.service.IAttendanceRpService;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//加分/过失管理
@RestController
@RequestMapping("/attendance/rp")
public class AttendanceRpController extends BaseController {
    @Autowired
    private IAttendanceRpService attendanceRpService;
    @Autowired
    private ISysUserNumberService userNumberService;
    /**
     * 奖惩列表
     * @param attendanceRp
     * @return
     */
    @GetMapping("/list")
    public AjaxResult rpList(AttendanceRp attendanceRp, @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceRp> list = attendanceRpService.rpList(attendanceRp);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 奖惩详情
     * @param rpId
     * @return
     */
    @GetMapping("/{rpId}")
    public AjaxResult rpInfo(@PathVariable int rpId){
        return AjaxResult.success(attendanceRpService.rpInfo(rpId));
    }

    /**
     * 奖惩申请
     * @param attendanceRp
     * @return
     */
    @PostMapping
    public AjaxResult addRp(@RequestBody AttendanceRp attendanceRp){
        if(StringUtils.isEmpty(attendanceRp.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空");
        }
        SysUserNumber userNumber=userNumberService.numberByWorkNum(attendanceRp.getWorkNum());
        if(userNumber ==null){
            return AjaxResult.error(400,"请输入正确的工号!");
        }
        attendanceRp.setNickName(SecurityUtils.getUsername());
        return toAjax(attendanceRpService.addRp(attendanceRp));
    }

    /**
     * 奖惩审核
     * @param attendanceRp
     * @return
     */
    @PutMapping
    public AjaxResult updateRp(@RequestBody AttendanceRp attendanceRp){
        attendanceRp.setUpdateBy(SecurityUtils.getUsername());
        attendanceRp.setUpdateTime(new Date());
        return toAjax(attendanceRpService.updateById(attendanceRp));
    }

    /**
     * 取消奖惩
     * @param rpIds
     * @return
     */
    @DeleteMapping("/{rpIds}")
    public AjaxResult delRp(@PathVariable int [] rpIds){
        return toAjax(attendanceRpService.deleteById(rpIds));
    }
}
