package com.itheima.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(String email,String password){
        return "home/main";
    }

    @RequestMapping("/home")
    public String home(){
        return "home/home";
    }
}
