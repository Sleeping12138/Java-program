package com.test.webchat.Interceptor;

import com.test.webchat.Constants.Constant;
import com.test.webchat.Utils.JWTUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constant.TOKEN_NAME);
        log.info("token为：" + token);
        Claims claims = null;
        try {
            claims = JWTUtil.parseToken(token);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
        if (claims == null) return false;
        return true;
    }
}
