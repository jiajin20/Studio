package com.cf.studio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BasicController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index1(){
        return "index";
    }
    @RequestMapping("/active")
    public String active(){
        return "active";
    }
    @RequestMapping("/category")
    public String category(){
        return "category";
    }
    @RequestMapping("/particulars")
    public String particulars(){
        return "particulars";
    }
    @RequestMapping("/my")
    public String my(){
        return "my";
    }
    @RequestMapping("/us")
    public String us(){
        return "us";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}