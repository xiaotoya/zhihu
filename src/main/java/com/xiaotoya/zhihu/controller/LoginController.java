package com.xiaotoya.zhihu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaotoya.zhihu.common.Response;
import com.xiaotoya.zhihu.common.Util;
import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping()
    @PreAuthorize("hasAuthority('get::user')")
    public Response showUser() {
        return Response.ok().message("get::user").data("user", "test");
    }
    @DeleteMapping()
    @PreAuthorize("hasAuthority('delete::user')")
    public Response delUser() {
        return Response.ok().message("delete::user").data("user", "test");
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('update::user')")
    public Response updateUser() {
        return Response.ok().message("update::user").data("user", "test");
    }
    @PostMapping()
    @PreAuthorize("hasAuthority('create::user')")
    public Response addUser() {
        return Response.ok().message("create::user").data("user", "test");
    }
    @GetMapping("plus")
    @PreAuthorize("hasAuthority('customer::plus')")
    public Response customerPlus() {
        return Response.ok().message("customer::plus").data("user", "test");
    }
}
