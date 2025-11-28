//package com.zhang.Filter;
//
//import com.zhang.Utils.CurrentHolder;
//import com.zhang.Utils.JwtUtils;
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class TokenFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //获取请求路径
//        String path = request.getRequestURI();
//        //登录接口放行
//        if (path.contains("/login")){
//            log.info("登录请求，放行");
//            filterChain.doFilter(request, response);
//            return;
//        }
//        //获取请求头中的令牌
//        String token= request.getHeader("token");
//        //判断令牌是否存在，不存在则返回错误信息
//        if (token == null || token.isEmpty()){
//            log.info("令牌为空，响应401");
//            response.setStatus(401);
//            return;
//        }
//        //验证令牌，如果验证失败则返回错误信息
//        try{
//            Claims claims = JwtUtils.parseJWT(token);
//            Integer empId = Integer.valueOf(claims.get("empId").toString());
//            CurrentHolder.setCurrentId(empId);
//            log.info("当前用户id为：{}",empId);
//        } catch (Exception e) {
//            log.info("令牌非法，响应401");
//            response.setStatus(401);
//            return;
//        }
//        //放行
//        log.info("令牌合法，放行");
//        filterChain.doFilter(request, response);
//        CurrentHolder.remove();
//    }
//}
