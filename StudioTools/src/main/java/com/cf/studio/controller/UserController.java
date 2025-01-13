package com.cf.studio.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.studio.dto.LoginRequest;
import com.cf.studio.dto.RegisterRequest;
import com.cf.studio.entity.User;
import com.cf.studio.service.UserService;
import com.cf.studio.util.EmailUtil;
import com.cf.studio.util.JwtUtil;
import com.cf.studio.util.PasswordUtil;
import com.cf.studio.util.R;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public R login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        String passwordhash = userService.getUserPassword(email);
        boolean result = passwordUtil.checkPassword(password, passwordhash);
        if (result==true){
            String token = JwtUtil.createToken(email);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
        return R.success("登录成功", jsonObject);
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
    public R register(@RequestBody RegisterRequest registerRequest, HttpSession session) {
        String name = registerRequest.getName();
        String email = registerRequest.getEmail();
        String password = registerRequest.getPassword();
        String code = registerRequest.getVcode();
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
                session.setAttribute("emailCode", null);
                return R.successMsg("注册成功");
            } else {
                return R.error("注册失败");
            }
        } catch (RuntimeException e) {
            return R.error(e.getMessage());
        }
    }
    //更新用户信息
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(
            @RequestParam(value = "bio", required = false) String bio,
            @RequestParam(value = "qq", required = false) String qq,
            @RequestParam(value = "wechat", required = false) String wechat,
            @RequestParam(value = "sexy", required = false) String sexy,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam("userid") int userid) {
        String encodedPassword = passwordUtil.encryptPassword(password);
        int result = userService.updateUser(bio, qq, wechat, sexy, encodedPassword, username, userid);
        if (result > 0) {
            return ResponseEntity.ok("用户信息更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("用户信息更新失败");
        }
    }
}
