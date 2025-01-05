package com.cf.studio.controller;

import com.cf.studio.entity.User;
import com.cf.studio.service.UserService;
import com.cf.studio.util.EmailUtil;
import com.cf.studio.util.PasswordUtil;
import com.cf.studio.util.R;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private PasswordUtil passwordUtil;

    //登录
    @PostMapping("/login")
    public R login(@RequestParam("email") String email,
                   @RequestParam("password") String password) {

        String passwordhash = userService.getUserPassword(email);
        boolean result = passwordUtil.checkPassword(password, passwordhash);
        if (result==true){
        return R.successMsg("登录成功");
        }
        return R.error("登录失败");
    }
    // 生成并发送验证码
    @GetMapping("/getCode")
    public R code(@RequestParam("email") String email, HttpSession session) throws Exception {
        StringBuilder builder = new StringBuilder();
        int num;
        for (int i = 0; i < 6; i++) {
            num = (int)(Math.random() * 10);
            builder.append(String.valueOf(num));
        }
        String snum = builder.toString();
        EmailUtil.sendMail(email, "验证码", "您的验证码是：" + snum);
        session.setAttribute("emailCode", snum);
        session.setMaxInactiveInterval(2 * 60);
        return R.successMsg("验证码已发送到您的邮箱，请注意查收");
    }

    // 验证验证码的接口
    @PostMapping("/verifyCode")
    public R verifyCode(@RequestParam("email") String email, @RequestParam("vcode") String code, HttpSession session) {
        // 从Session中获取验证码
        String sessionCode = (String) session.getAttribute("emailCode");
        if (sessionCode == null) {
            return R.error("验证码已过期，请重新获取验证码");
        }
        if (!sessionCode.equals(code)) {
            return R.error("验证码错误");
        }
        return R.successMsg("验证码验证成功");
    }
    //注册用户
    @PostMapping("/register")
    public R register(@RequestParam("name")String name,
                      @RequestParam("email")String email,
                      @RequestParam("password")String password,
                      @RequestParam("vcode")String code,
                      HttpSession session) {
        String sessionCode = (String) session.getAttribute("emailCode");
        if (sessionCode == null) {
            return R.error("验证码已过期，请重新获取验证码");
        }
        if (!sessionCode.equals(code)) {
            return R.error("验证码错误");
        }
       String encodedPassword = passwordUtil.encryptPassword(password);
        try {
            int result = userService.register(name, encodedPassword, email, "member");
            if (result > 0) {
                return R.successMsg("注册成功");
            } else {
                return R.error("注册失败");
            }
        } catch (RuntimeException e) {
            return R.error(e.getMessage());
        }
    }
}
