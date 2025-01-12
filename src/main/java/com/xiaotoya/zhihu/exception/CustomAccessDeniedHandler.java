package com.xiaotoya.zhihu.exception;
import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.common.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Util.responseToJson(response, Response.error().message("权限不足"), HttpServletResponse.SC_FORBIDDEN);
    }
}
