package com.xiaotoya.zhihu.exception;
import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.common.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler  {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Util.responseToJson(response, Response.error().message("登录失败"), HttpServletResponse.SC_UNAUTHORIZED);
    }
}
