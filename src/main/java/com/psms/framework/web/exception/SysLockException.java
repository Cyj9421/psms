package com.psms.framework.web.exception;

import com.psms.framework.web.domain.AjaxResult;
import com.psms.framework.web.domain.server.Sys;
import com.psms.project.bussiness.service.IBussinessTripService;
import com.psms.project.monitor.service.ISysLockService;
import com.psms.project.monitor.service.impl.SysLockServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自动锁定系统、解锁系统
 */
@Component
@Slf4j
public class SysLockException {
    @Autowired
    private ISysLockService sysLockService;
    @Scheduled(cron = "0 0 0 * * ?")     //每天凌晨12点执行一次
    public void sysLock() throws InterruptedException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        //获取当前日期
        String date=dateFormat.format(new Date());
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
