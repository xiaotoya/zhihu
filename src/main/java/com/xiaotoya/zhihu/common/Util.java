package com.xiaotoya.zhihu.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Util {
    public static Cookie getJWTCookie(String jwt) {
        Cookie jwtCookie = new Cookie("jwt", jwt);
        jwtCookie.setHttpOnly(true);
//        jwtCookie.setSecure(true); // 确保在HTTPS环境下使用
        jwtCookie.setMaxAge(3600*24); // 设置Cookie的过期时间，单位为秒，这里设置为1小时
        return jwtCookie;
    }

    public static void responseToJson(HttpServletResponse response, Response respObj, int code) throws IOException {
        response.setStatus(code);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JwtUtil.toJSONString(respObj));
    }
}
