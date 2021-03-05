package com.psms.project.attendance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.psms.common.utils.StringUtils;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.attendance.domain.*;
import com.psms.project.attendance.domain.vo.AttendanceCardVo;
import com.psms.project.attendance.domain.vo.BrushCardInfoVo;
import com.psms.project.attendance.service.*;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * 刷卡管理
 */
@RestController
@RequestMapping("/attendance/card/device")
public class AttendanceCardController extends BaseController {
    @Autowired
    private IAttendanceCardService attendanceCardService;
    @Autowired
    private IAttendanceInfoService attendanceInfoService;
    @Autowired
    private IAttendanceScheduleService attendanceScheduleService;
    @Autowired
    private IAttendanceLateService attendanceLateService;
    @Autowired
    private IAttendanceEarlyService attendanceEarlyService;
    @Autowired
    private IAttendanceOvertimeService attendanceOvertimeService;
    @Autowired
    private ISysUserNumberService userNumberService;
    private int i=0;
    /**
     * 卡号列表
     * @param attendanceCard
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public AjaxResult cardList(AttendanceCard attendanceCard,@RequestParam(value="pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttendanceCard> list = attendanceCardService.cardList(attendanceCard);
        PageInfo pageInfo = new PageInfo(list);
        return AjaxResult.success(pageInfo);
    }

    /**
     * 卡号详情
     * @param cardId
     * @return
     */
    @GetMapping("/{cardId}")
    public AjaxResult cardInfo(@PathVariable int cardId){
        return AjaxResult.success(attendanceCardService.cardInfo(cardId));
    }

    /**
     * 服务器绑定IC卡
     * @param attendanceCardVo
     * @return
     */
    @PostMapping("/client/add")
    public AjaxResult clientAddCard(AttendanceCardVo attendanceCardVo){
        if(StringUtils.isEmpty(attendanceCardVo.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空!");
        }
        if(StringUtils.isEmpty(attendanceCardVo.getCardNum())){
            return AjaxResult.error(400,"卡号不能为空!");
        }
        if(userNumberService.numberByWorkNum(attendanceCardVo.getWorkNum())==null){
            return AjaxResult.error(400,"没有该工号的信息!");
        }
        AttendanceCard cardInfo=attendanceCardService.attendanceCardInfo(attendanceCardVo.getCardNum());
        if(cardInfo !=null){
            return AjaxResult.error(400,"一张卡只能绑定一个人!");
        }else {
            if (attendanceCardVo.getCardType() == 0 || attendanceCardVo.getCardType()==1) {
                return AjaxResult.error(400, "该工号已经绑定过考勤卡了!");
            }
        }
        AttendanceCard attendanceCard=new AttendanceCard();
        attendanceCard.setWorkNum(attendanceCardVo.getWorkNum());
        attendanceCard.setCardNum(attendanceCardVo.getCardNum());
        attendanceCard.setCardType(attendanceCardVo.getCardType());
        attendanceCard.setBrushNum(attendanceCardVo.getBrushNum());
        attendanceCard.setCarryNum(attendanceCardVo.getCarryNum());
        attendanceCard.setIoId(attendanceCardVo.getIoId());
        if(attendanceCardVo.getCardType()==2) {
            if (attendanceCard.getBrushNum() != 0) {
                attendanceCard.setDefaultNum(attendanceCard.getBrushNum());
            }else {
                attendanceCard.setBrushNum(10);
                attendanceCard.setDefaultNum(10);
            }
        }
        else {
            attendanceCard.setBrushNum(2);
            attendanceCard.setDefaultNum(2);
        }
        return toAjax(attendanceCardService.addCard(attendanceCard));
    }
    /**
     * 绑定卡号
     * @param attendanceCard
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addCard(@RequestBody AttendanceCard attendanceCard){
        if(StringUtils.isEmpty(attendanceCard.getWorkNum())){
            return AjaxResult.error(400,"工号不能为空!");
        }
        if(StringUtils.isEmpty(attendanceCard.getCardNum())){
            return AjaxResult.error(400,"卡号不能为空!");
        }
        if(userNumberService.numberByWorkNum(attendanceCard.getWorkNum())==null){
            return AjaxResult.error(400,"没有该工号的信息!");
        }
        AttendanceCard cardInfo=attendanceCardService.attendanceCardInfo(attendanceCard.getCardNum());
        if(cardInfo !=null){
            return AjaxResult.error(400,"一张卡只能绑定一个人!");
        }else {
            if (attendanceCard.getCardType() == 0 || attendanceCard.getCardType()==1) {
                return AjaxResult.error(400, "该工号已经绑定过考勤卡了!");
            }
        }
        if(attendanceCard.getCardType()==2) {
            if (attendanceCard.getBrushNum() != 0) {
                attendanceCard.setDefaultNum(attendanceCard.getBrushNum());
            }else {
                attendanceCard.setBrushNum(10);
                attendanceCard.setDefaultNum(10);
            }
        }
        return toAjax(attendanceCardService.addCard(attendanceCard));
    }

    /**
     * 修改卡号信息
     * @param attendanceCard
     * @return
     */
    @PutMapping
    public AjaxResult updateCard(@RequestBody AttendanceCard attendanceCard){
        if(attendanceCard.getCardType()==2) {
            if (attendanceCard.getBrushNum() != 0) {
                attendanceCard.setDefaultNum(attendanceCard.getBrushNum());
            }else {
                attendanceCard.setBrushNum(10);
                attendanceCard.setDefaultNum(10);
            }
        }
        return toAjax(attendanceCardService.updateCard(attendanceCard));
    }
    /**
     * 批量删除卡号
     * @param cardIds
     * @return
     */
    @DeleteMapping("/{cardIds}")
    public AjaxResult delCard(@PathVariable int [] cardIds){
        return toAjax(attendanceCardService.delCard(cardIds));
    }
    /**
     * 通过卡号
     * @param cardNum
     * @return
     * @throws ParseException
     */
    @PostMapping("/through")
    public AjaxResult startAndEnd(@RequestParam(value = "cardNum") String cardNum,
                                  @RequestParam(value = "carryNum") int carryNum) throws ParseException {
        LocalTime localTime = LocalTime.now(); // gets the current time
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AttendanceCard attendanceCard=attendanceCardService.attendanceCardInfo(cardNum);
        if(attendanceCard==null){
            return AjaxResult.error(400,"该卡未绑定员工");
        }
        if(attendanceCard.getCardType()==2){
            BrushCardInfoVo brushCardDoorInfo=attendanceInfoService.brushCardInfoByDoor(attendanceCard.getWorkNum());
            brushCardDoorInfo.setBrushCardTime(dateTime.format(new Date()));
            if(carryNum>attendanceCard.getCarryNum()){
                return AjaxResult.success("携带人数超出了!",brushCardDoorInfo);
            }
            if(attendanceCard.getBrushNum()<=0){
                return AjaxResult.success("抱歉,今天的剩余次数已用完！",brushCardDoorInfo);
            }
            attendanceCard.setBrushNum(attendanceCard.getBrushNum()-1);
            attendanceCard.setTotalNum(attendanceCard.getTotalNum()+1);
            attendanceCardService.updateCard(attendanceCard);
            BrushCardInfoVo brushCardDoorFor=attendanceInfoService.brushCardInfoByDoor(attendanceCard.getWorkNum());
            brushCardDoorFor.setBrushCardTime(dateTime.format(new Date()));
            return AjaxResult.success(brushCardDoorFor);
        }
        BrushCardInfoVo brushCardAttendanceInfo=attendanceInfoService.brushCardInfoByAttendance(attendanceCard.getWorkNum());
        brushCardAttendanceInfo.setBrushCardTime(dateTime.format(new Date()));
        if(attendanceCard.getBrushNum()<=0){
            return AjaxResult.success("抱歉,今天的剩余次数已用完！",brushCardAttendanceInfo);
        }
        AttendanceInfo attendanceInfo=new AttendanceInfo();
        attendanceCard.setBrushNum(attendanceCard.getBrushNum()-1);
        attendanceCard.setTotalNum(attendanceCard.getBrushNum()+1);
        attendanceCardService.updateCard(attendanceCard);
        BrushCardInfoVo brushCardAttendanceFor=attendanceInfoService.brushCardInfoByAttendance(attendanceCard.getWorkNum());
        brushCardAttendanceFor.setBrushCardTime(dateTime.format(new Date()));
        attendanceInfo.setWorkNum(attendanceCard.getWorkNum());
        attendanceInfo.setAttendanceDate(date.parse(date.format(new Date())));
        if(i==0){
            try {
                //上班打卡
                Time time = Time.valueOf(localTime);
                attendanceInfo.setStartTime(time);
                i += 1;
                AttendanceInfo Info = attendanceInfoService.attendateInfo(attendanceInfo);
                if (Info == null) {
                    attendanceInfoService.startAttendance(attendanceInfo);
                    attendanceInfo = attendanceInfoService.attendateInfo(attendanceInfo);
                    return AjaxResult.success(attendanceInfo);
                }else{
                    i=0;
                    return AjaxResult.success("你今天已经打过卡了",brushCardAttendanceInfo);
                }
            }
            catch (Exception e){
                i=0;
                e.printStackTrace();
                return AjaxResult.success("你今天已经打过卡了",brushCardAttendanceInfo);
            }
        }
        attendanceInfo=attendanceInfoService.attendateInfo(attendanceInfo);
        if(attendanceInfo.getEndTime()==null && i==1){
            //下班打卡
            Time time=Time.valueOf(localTime);
            attendanceInfo.setEndTime(time);
            i+=1;
            attendanceInfoService.endAttendance(attendanceInfo);
            i=0;
        }
        AttendanceSchedule attendanceSchedule = attendanceScheduleService.scheduleInfo(attendanceInfo.getWorkNum());
        attendanceInfo.setAttendanceDate(attendanceInfo.getAttendanceDate());
        if (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null) {
            attendanceInfo.setIsAbsenteeism(2);
            //缺勤记录
        }else {
            if (attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) {
                attendanceInfo.setIsLate(2);
                //迟到记录
                AttendanceLate attendanceLate = new AttendanceLate();
                attendanceLate.setWorkNum(attendanceInfo.getWorkNum());
                attendanceLate.setLateTime(attendanceInfo.getStartTime());
                attendanceLate.setLateDate(attendanceInfo.getAttendanceDate());
                attendanceLateService.addLate(attendanceLate);
            }
            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) {
                attendanceInfo.setIsEarly(2);
                //早退记录
                AttendanceEarly attendanceEarly = new AttendanceEarly();
                attendanceEarly.setWorkNum(attendanceInfo.getWorkNum());
                attendanceEarly.setEarlyTime(attendanceInfo.getEndTime());
                attendanceEarly.setEarlyDate(attendanceInfo.getAttendanceDate());
                attendanceEarlyService.addEarly(attendanceEarly);
            }
            if (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) > 0) {
                attendanceInfo.setIsOvertime(2);
                //加班记录
                long overtime = attendanceInfo.getEndTime().getTime() - attendanceSchedule.getEndTime().getTime();
                double hours = (double) overtime / (1000 * 60 * 60);
                AttendanceOvertime attendanceOvertime = new AttendanceOvertime();
                attendanceOvertime.setWorkNum(attendanceInfo.getWorkNum());
                attendanceOvertime.setClockTime(attendanceInfo.getEndTime());
                attendanceOvertime.setOverTime(hours);
                attendanceOvertime.setClockDate(attendanceInfo.getAttendanceDate());
                attendanceOvertimeService.addOvertime(attendanceOvertime);
            }
            if ((attendanceInfo.getStartTime().compareTo(attendanceSchedule.getStartTime()) > 0) ||
                    (attendanceInfo.getEndTime().compareTo(attendanceSchedule.getEndTime()) < 0) ||
                    (attendanceInfo.getStartTime() == null && attendanceInfo.getEndTime() == null)
            ) {
                attendanceInfo.setAttendanceStatus(2);
                //异常记录
            }
        }
        attendanceInfoService.updateAttendance(attendanceInfo);
        return AjaxResult.success(brushCardAttendanceFor);
    }
}
