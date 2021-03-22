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
    public static void main(String[] args) {

        String body="http://103.149.27.155:18080/profile/upload/2021/03/17/a61e48e4-b00a-41a0-994e-024987680f8f.jpg";
        int index=body.indexOf("/");
        index=body.indexOf("/",index+4);
        String str=body.substring(index);
        System.out.println(str.substring(9));
    }
}