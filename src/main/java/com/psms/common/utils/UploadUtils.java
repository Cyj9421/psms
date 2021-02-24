package com.psms.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class UploadUtils {
    //文件上传路径
    @Value("${upload.filepath}")
    private String UPLOAD_FOLDER;
    //服务器地址
    @Value("${address}")
    private String serverAddress;
    //服务器端口
    @Value("${server.port}")
    private String port;
    public String upload(MultipartFile file){
        String OriginalFilename=file.getOriginalFilename();//获取原始文件名
        File dest=new File(UPLOAD_FOLDER+OriginalFilename);
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdirs();
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "http://"+serverAddress+":"+port+"/"+OriginalFilename;
//        return "http://x22dtm.natappfree.cc"+"/"+OriginalFilename;
    }
}
