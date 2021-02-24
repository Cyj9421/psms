package com.psms.common.utils;

import com.psms.project.system.domain.vo.SysIndexVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

import static io.netty.handler.codec.DateFormatter.format;

@Slf4j
public class Test1 {
    public static void main(String[] args) throws ParseException, IOException {
        Map<String,Object> map=new HashMap<>();
         map.put("1","map1");
         System.out.println(map.get("1"));


    }

}
