package com.itgroup.interceptor;

import com.itgroup.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT token validation interceptor
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        try {
            String token = request.getHeader("mytoken");
            Claims claims = JwtUtil.parseJWT("usertoken", token);
            Long userId = Long.valueOf(claims.get("userId").toString());
            return true;
        }catch (Exception ex){
            log.info("JWT error: {}", ex.getMessage());
            response.setStatus(401);
            return false;
        }


    }
}
