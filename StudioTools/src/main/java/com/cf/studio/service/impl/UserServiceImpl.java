package com.cf.studio.service.impl;

import com.cf.studio.entity.User;
import com.cf.studio.mapper.UserMapper;
import com.cf.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String email, String password) {
        return userMapper.login(email, password);
    }

    @Override
    public String getUserPassword(String email) {
        return userMapper.getUserPassword(email);
    }

    @Override
    public int register(String name, String password, String email, String role) {
        if (userMapper.checkEmailExists(email) > 0) {
            throw new RuntimeException("该邮箱已被注册");
        }
        return userMapper.register(name, password, email, role);
    }

}
