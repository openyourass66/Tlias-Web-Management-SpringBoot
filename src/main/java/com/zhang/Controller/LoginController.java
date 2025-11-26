package com.zhang.Controller;

import com.zhang.Service.EmpService;
import com.zhang.pojo.Emp;
import com.zhang.pojo.LoginInfo;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;
    //登录
    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("登录,参数:{}", emp);
        LoginInfo loginInfo =empService.login(emp);
        if(loginInfo == null){
            return Result.error("用户名或密码错误");
        }
        return Result.success(loginInfo);
    }
}
