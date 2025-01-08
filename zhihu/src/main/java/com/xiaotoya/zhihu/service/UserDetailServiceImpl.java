package com.xiaotoya.zhihu.service;

import com.xiaotoya.zhihu.entities.User;
import com.xiaotoya.zhihu.mapper.UserMapper;
import com.xiaotoya.zhihu.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userMapper.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户名不存在!");
        }
        return new LoginUser(user);
    }
}
