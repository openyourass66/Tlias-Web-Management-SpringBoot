package com.zhang;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwttest {
    @Test
    public void testGenetateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","zhang");
        String jwt=Jwts.builder().signWith(SignatureAlgorithm.HS512,"emhhbmd4aQ==")//指定加密算法和密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//设置有效期
                .compact();//生成jwt
        System.out.println(jwt);
    }
}
