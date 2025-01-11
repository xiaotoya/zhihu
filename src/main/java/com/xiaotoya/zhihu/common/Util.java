package com.xiaotoya.zhihu.common;

import jakarta.servlet.http.Cookie;

public class Util {
    public static Cookie getJWTCookie(String jwt) {
        Cookie jwtCookie = new Cookie("jwt", jwt);
        jwtCookie.setHttpOnly(true);
//        jwtCookie.setSecure(true); // 确保在HTTPS环境下使用
        jwtCookie.setMaxAge(3600*24); // 设置Cookie的过期时间，单位为秒，这里设置为1小时
        return jwtCookie;
    }
}
