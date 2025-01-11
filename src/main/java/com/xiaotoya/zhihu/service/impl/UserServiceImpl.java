package com.xiaotoya.zhihu.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaotoya.zhihu.common.JwtUtil;
import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String login(User user) throws JsonProcessingException {
        // 封装authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }
        User loginUser = (User) authentication.getPrincipal();
        String loginUserString = JwtUtil.toJSONString(loginUser);
        String jwtToken = JwtUtil.createJWT(loginUserString, null);
        // 登录用户录入redis
//        stringRedisTemplate.opsForValue().set("login:" + userId, loginUser);
        return jwtToken;
    }
}
