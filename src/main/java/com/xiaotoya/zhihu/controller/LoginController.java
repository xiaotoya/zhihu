package com.xiaotoya.zhihu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.common.Util;
import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Response login(@RequestBody User user, HttpServletResponse response) throws JsonProcessingException {
        String token = userService.login(user);
        response.addCookie(Util.getJWTCookie(token));
        return Response.ok().message("登录成功").data("token", token);
    }
}
