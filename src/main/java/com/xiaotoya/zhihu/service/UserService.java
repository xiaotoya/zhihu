package com.xiaotoya.zhihu.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiaotoya.zhihu.entities.User;

public interface UserService {
    public String login(User user) throws JsonProcessingException;
}
