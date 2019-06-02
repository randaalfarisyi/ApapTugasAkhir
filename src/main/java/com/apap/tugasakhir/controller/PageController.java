package com.apap.tugasakhir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/lab/user")
    public String account(){
        return "account";
    }
}