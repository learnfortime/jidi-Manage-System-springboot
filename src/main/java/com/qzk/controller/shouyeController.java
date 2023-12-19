package com.qzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class shouyeController {
    @RequestMapping("/")
    public String shouye(){
        return "login.html";
    }
    @RequestMapping("/index")
    public  String index(){
        return "pages/index.html";
    }
    @RequestMapping("/tIndex")
    public String tIndex(){
        return "pages/teacher/index.html";
    }
}

