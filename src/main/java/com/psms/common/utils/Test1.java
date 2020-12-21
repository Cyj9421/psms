package com.psms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
//        SecurityUtils securityUtils=new SecurityUtils();
//        String password="9421";
//        String encryptPassword=securityUtils.encryptPassword(password);
//        boolean result=securityUtils.matchesPassword(password,encryptPassword);
//        System.out.println(encryptPassword);
//        Date now=new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        String tablename=dateFormat.format(now);
//        String head="YF";
        SecurityUtils securityUtils=new SecurityUtils();
        String result=securityUtils.encryptPassword("9421");
        System.out.println(result);
    }
}
