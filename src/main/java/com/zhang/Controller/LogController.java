package com.zhang.Controller;

import com.zhang.Service.LogService;
import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.Log;
import com.zhang.pojo.PageResult;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
   LogService logService;
    @GetMapping("/page")
    public Result  page(LogQueryParam param){
        log.info("日志查询,参数:{}");
        PageResult<Log> pageResult = logService.page(param);
        return Result.success(pageResult);
    }

}
