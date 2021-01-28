package com.psms.project.system.controller;

import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.system.domain.vo.SysDeptVo;
import com.psms.project.system.domain.vo.SysIndexVo;
import com.psms.project.system.service.ISysIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/system/index")
public class SysIndexController extends BaseController {
    @Autowired
    private ISysIndexService sysIndexService;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    List<SysDeptVo> list=new ArrayList();
    Date date=sdf.parse(sdf.format(new Date()));

    public SysIndexController() throws ParseException {
    }

    /**
     * 在职人数
     * @return
     */
    @GetMapping("/onWork")
    public AjaxResult onWork(){
        int employees=sysIndexService.onWork();
        return AjaxResult.success(employees);
    }

    /**
     * 当月累积工时
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/workTime")
    public AjaxResult workTime(SysIndexVo sysIndexVo){
        c.add(Calendar.MONTH, 0);
        c.set(GregorianCalendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        sysIndexVo.setStartDate(c.getTime());
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, - 1 );
        sysIndexVo.setEndDate(c.getTime());
        double workTime=sysIndexService.workTime(sysIndexVo);
        return AjaxResult.success(workTime);
    }

    /**
     * 当月预计支出
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/salary")
    public AjaxResult salaryCost(SysIndexVo sysIndexVo){
        double salary=sysIndexService.salaryCost();
        return AjaxResult.success(salary);
    }

    /**
     * 当月离职人数
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/departure")
    public AjaxResult departure(SysIndexVo sysIndexVo){
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(GregorianCalendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        sysIndexVo.setStartTime(c.getTime());
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, - 1 );
        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        sysIndexVo.setEndTime(c.getTime());
        int employees=sysIndexService.departure(sysIndexVo);
        return AjaxResult.success(employees);
    }

    /**
     * 预计工时
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/expectedTime")
    public AjaxResult expectedTime(SysIndexVo sysIndexVo){
        c.setTime(new Date());
        c.add(Calendar.DATE,-1);
        sysIndexVo.setAttendanceDate(c.getTime());
        Double workTime=sysIndexService.expectedTime(sysIndexVo);
        SysDeptVo sysDeptVo=new SysDeptVo();
        sysDeptVo.setWorkTime(workTime);
        sysDeptVo.setAttendanceDate(sysIndexVo.getAttendanceDate());
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, + 1);
        int res=c.getTime().compareTo(sysIndexVo.getAttendanceDate());
        if(res==0) {
            list.clear();
        }
        list.add(sysDeptVo);
        return AjaxResult.success(list);
    }

    /**
     * 实际工时
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/actualTime")
    public AjaxResult actualTime(SysIndexVo sysIndexVo) throws ParseException {
        c.setTime(new Date());
        Date dt=sdf.parse(sdf.format(c.getTime()));
        c.add(Calendar.DATE,-1);
        sysIndexVo.setAttendanceDate(sdf.parse(sdf.format(c.getTime())));
        Double workTime=sysIndexService.expectedTime(sysIndexVo);
        SysDeptVo sysDeptVo=new SysDeptVo();
        sysDeptVo.setWorkTime(workTime);
        sysDeptVo.setAttendanceDate(sysIndexVo.getAttendanceDate());
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, + 1 );
        int res=c.getTime().compareTo(sysIndexVo.getAttendanceDate());
        if(res==0) {
            list.clear();
        }
        if(list.size()<1) {
            list.add(sysDeptVo);
        }else {
            if (date.compareTo(dt) != 0) {
                list.add(sysDeptVo);
            }
        }
        return AjaxResult.success(list);
    }

    /**
     * 各部门人数
     * @return
     */
    @GetMapping("/deptNum")
    public AjaxResult deptNum(){
        List<SysDeptVo> list=sysIndexService.deptNum();
        return AjaxResult.success(list);
    }

    /**
     * 各部门预计工时
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/dept/expectedTime")
    public AjaxResult expectedTimeByDept(SysIndexVo sysIndexVo) throws ParseException {
        c.setTime(new Date());
        c.add(Calendar.DATE,-1);
        sysIndexVo.setAttendanceDate(sdf.parse(sdf.format(c.getTime())));
        return AjaxResult.success(sysIndexService.expectedTimeByDept(sysIndexVo));
    }

    /**
     * 各部门实际工时
     * @param sysIndexVo
     * @return
     */
    @GetMapping("/dept/actualTime")
    public AjaxResult actualTimeByDept(SysIndexVo sysIndexVo) throws ParseException {
        c.setTime(new Date());
        c.add(Calendar.DATE,-1);
        sysIndexVo.setAttendanceDate(sdf.parse(sdf.format(c.getTime())));
        return AjaxResult.success(sysIndexService.actualTimeByDept(sysIndexVo));
    }
}
