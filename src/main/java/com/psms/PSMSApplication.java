package com.psms;

import javafx.application.Application;
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
        SpringApplication app=new SpringApplication(Application.class);
        app.run(PSMSApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ   启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
