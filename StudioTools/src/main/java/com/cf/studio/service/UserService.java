package com.cf.studio.service;

import com.cf.studio.entity.User;

public interface UserService {
 User login(String email, String password);
 int register(String name, String password, String email,String role);
}

