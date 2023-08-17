package com.itgroup.interceptor;

import com.itgroup.common.BaseContext;
import com.itgroup.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("mytoken");
            Claims claims = JwtUtil.parseJWT("usertoken", token);
            Long userId = Long.valueOf(claims.get("userId").toString());
            System.out.println("userId: " + userId);
            return true;
        }catch (Exception ex){
            log.info("JWT 错误: {}", ex.getMessage());
            response.setStatus(401);
            return false;
        }


    }
}
