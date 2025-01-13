package com.cf.studio.service;

import com.cf.studio.entity.User;

public interface UserService {
 //常规登录
 User login(String email, String password);
 //根据邮箱获取加密密码（加密登录）
 String getUserPassword(String email);
 //注册
 int register(String name, String password, String email,String role);
 //修改用户信息
 int updateUser(String bio,String qq,String wechat,String Sexy, String password,String username,int userid);
}

