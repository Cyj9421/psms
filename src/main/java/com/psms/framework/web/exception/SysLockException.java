package com.psms.framework.web.exception;

import com.psms.project.attendance.domain.AttendanceCard;
import com.psms.project.attendance.service.IAttendanceCardService;
import com.psms.project.monitor.service.ISysLockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自动锁定系统、解锁系统、刷新刷卡次数
 */
@Component
@Slf4j
public class SysLockException {
    @Autowired
    private ISysLockService sysLockService;
    @Autowired
    private IAttendanceCardService cardService;
    @Scheduled(cron = "0 0 0 * * ?")     //每天凌晨12点执行一次
    public void sysLock() throws InterruptedException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        //获取当前日期
        String date=dateFormat.format(new Date());
        List<AttendanceCard> cardList=cardService.cardList(new AttendanceCard());
        for(int i=0;i<cardList.size();i++){
            AttendanceCard attendanceCard=cardList.get(i);
            attendanceCard.setBrushNum(attendanceCard.getDefaultNum());
            cardService.updateCard(attendanceCard);
        }
        List<String> list=sysLockService.dateList();
        //查询系统锁定日期
        for(int i=0;i<list.size();i++){
            if(date.equals(list.get(i))){
                sysLockService.isTrue();
                //锁定系统
                log.info("系统锁定中!");
                TimeUnit.HOURS.sleep(24);
            }else{
                log.info("今天不是锁定日!");
            }
        }
        sysLockService.isFlase();
        //解锁系统
        log.info("解锁成功!");
    }
}
