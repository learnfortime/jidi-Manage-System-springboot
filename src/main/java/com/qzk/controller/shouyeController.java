package com.qzk.controller;


import com.qzk.server.AdminServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class shouyeController {
    @Resource
    private AdminServer adminServer;

    @RequestMapping("/")
    public String shouye() {
        return "login";
    }
//    @PostMapping("/login")
//    public ResultVO login(@RequestBody Admin admin) {
//        int n =adminServer.boolAdmin(admin);
//
//        if (n==1){
//            return new ResultVO<>(200, "匹配成功，登录成功！");
//        }
//        return new ResultVO<>(500, "服务器异常，list错误！");
//    }
//}
}