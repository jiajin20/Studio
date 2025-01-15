package com.cf.studio.service.impl;

import com.cf.studio.dto.UserDto;
import com.cf.studio.entity.User;
import com.cf.studio.mapper.UserMapper;
import com.cf.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //常规登录
    @Override
    public User login(String email, String password) {
        return userMapper.login(email, password);
    }
    //根据邮箱获取加密密码（加密登录）
    @Override
    public String getUserPassword(String email) {
        return userMapper.getUserPassword(email);
    }
    //注册
    @Override
    public int register(String name, String password, String email, String role) {
        if (userMapper.checkEmailExists(email) > 0) {
            throw new RuntimeException("该邮箱已被注册");
        }
        return userMapper.register(name, password, email, role);
    }
    //修改用户信息
    @Override
    public int updateUser(String bio, String qq, String wechat, String sexy, String password, String username, int userid) {
        UserDto user = new UserDto();
        user.setId(userid);
        // 使用 Map 存储非空的字段
        Map<String, Object> updates = new HashMap<>();
        if (bio != null) updates.put("bio", bio);
        if (qq != null) updates.put("qq", qq);
        if (wechat != null) updates.put("wechat", wechat);
        if (sexy != null) updates.put("sexy", sexy);
        if (password != null) updates.put("password", password);
        if (username != null) updates.put("username", username);
        // 将更新信息传递给 Mapper 方法
        return userMapper.updateUser(user, updates);
    }

    @Override
    public User getUserById(int id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public int getUseridByEmail(String email) {
        return userMapper.getUserIdByEmail(email);
    }

}
