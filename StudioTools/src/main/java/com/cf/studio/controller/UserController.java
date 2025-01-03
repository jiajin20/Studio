package com.cf.studio.controller;

import com.cf.studio.entity.User;
import com.cf.studio.service.UserService;
import com.cf.studio.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public R login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.login(email, password);
        if (user != null){
        System.out.println("登录成功");
        return R.success("登录成功");
        }
        return R.error("登录失败");
    }

}
