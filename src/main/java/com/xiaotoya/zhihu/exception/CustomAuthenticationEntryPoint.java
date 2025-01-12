package com.xiaotoya.zhihu.exception;

import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.common.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Util.responseToJson(response, Response.error().message("用户无法识别"), HttpServletResponse.SC_FORBIDDEN);
    }
}
