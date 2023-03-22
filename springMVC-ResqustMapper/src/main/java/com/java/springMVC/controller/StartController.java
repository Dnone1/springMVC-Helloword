package com.java.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class StartController {
    @RequestMapping("/")
    public String start() {
        return "index";
    }

//    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
