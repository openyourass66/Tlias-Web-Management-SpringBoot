package com.zhang;


import com.zhang.Utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;


public class jwttest {
    @Test
    public void testGenetateJwt(){
        Claims claims = JwtUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi5a6L5rGfIiwiaWQiOjIsInVzZXJuYW1lIjoic29uZ2ppYW5nIiwiZXhwIjoxNzY0Mzc3MTkxfQ.G8Uz_i-hiMf2N5-fMpuJhV89RWMvar2rrrK-rUyX7g0");
        System.out.println(claims);
    }
}
