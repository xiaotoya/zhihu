package com.xiaotoya.zhihu.filter;
import com.xiaotoya.zhihu.common.Constant;
import com.xiaotoya.zhihu.common.JwtUtil;
import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.entities.User;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        if (!Constant.LOGIN_PATH.equals(request.getRequestURI())) {
            String jwt = getJwtFromRequest(request);
            if (jwt != null) {
                Claims claims = JwtUtil.parseToken(jwt);
                User loginUser = JwtUtil.toObj(claims.getSubject(), User.class);
                Authentication authentication = new UsernamePasswordAuthenticationToken(loginUser, null, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                response.getWriter().write(JwtUtil.toJSONString(Response.error().data("Fail reason", "Login First")));
                return;
            }
        }
        // 放行
        filterChain.doFilter(request, response);
    }
    private String getJwtFromRequest(HttpServletRequest request) {
        // 从请求头或请求参数中提取JWT
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        // 还可以从请求参数、Cookie等位置提取JWT
        // 从Cookie中提取JWT（新增的方法）
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) { // 假设Cookie的名称为"jwt"
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
