package com.zhang.Controller;

import com.zhang.Utils.AliyunOSSOperator;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@Slf4j
@CrossOrigin
public class uploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping
    public Result upload(MultipartFile  file) throws Exception{
        log.info("上传文件 {}" ,file.getOriginalFilename());
        //将文件交给oss管理
        String url=aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("上传成功,url:{}",url);
        return Result.success(url) ;
    }
}
