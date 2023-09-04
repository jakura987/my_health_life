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
        // 直接放行 OPTIONS 请求(前后端都部署在本地时, 前端加proxy,后端"addCrosMapping")
        // 只有后端部署在服务器上时(记得改配置),前端不用加proxy,后端preHandler放行"OPTIONS"
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        try {
            String token = request.getHeader("mytoken");
            Claims claims = JwtUtil.parseJWT("usertoken", token);
//            System.out.println("claims: " + claims);
            Long userId = Long.valueOf(claims.get("userId").toString());
//            log.info("userId: {}", userId);
            return true;
        }catch (Exception ex){
            log.info("JWT error: {}", ex.getMessage());
            response.setStatus(401);
            return false;
        }


    }
}
