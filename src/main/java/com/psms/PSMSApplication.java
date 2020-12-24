package com.psms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动程序
 * 
 * @author jeethink  官方网址：www.jeethink.vip
 */
@EnableScheduling
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class PSMSApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(PSMSApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  吉想 启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
