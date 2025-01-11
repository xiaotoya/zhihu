package com.xiaotoya.zhihu.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    // one hour
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    // 私钥
    private static final String JWT_KEY = "xiaotoya";

    // 生成 JWT
    public static String createJWT(String subject, Long ttlMillis) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (ttlMillis == null ? JWT_TTL : ttlMillis)))
                .signWith(SignatureAlgorithm.HS256, JWT_KEY)
                .compact();
    }

    // 解析 JWT
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


    public static String toJSONString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
    public static <T> T toObj(String jsonString, Class<T> tClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, tClass);
    }
}
