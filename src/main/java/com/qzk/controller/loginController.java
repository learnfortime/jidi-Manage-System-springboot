package com.qzk.controller;

import com.qzk.pojo.Admin;
import com.qzk.pojo.Students;
import com.qzk.pojo.Teachers;
import com.qzk.server.AdminServer;
import com.qzk.server.StudentServer;
import com.qzk.server.TeacherServer;
import com.qzk.vo.utils.JWTUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
//@ResponseBody
@RequestMapping("/auth")
public class loginController {
    @Resource
    private AdminServer adminServer;
    @Resource
    private StudentServer studentServer;
    @Resource
    private TeacherServer teacherServer;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Admin admin) {
        System.out.println("admin:" + admin);
        System.out.println("user:" + admin.getUser());
        System.out.println("pwd:" + admin.getPwd());
        Map<String, Object> map = new HashMap<>();
        Admin a = adminServer.boolAdmin(admin);
        try {
            if (a != null) {
                Map<String, Object> payLoad = new HashMap<>();
                payLoad.put("user:", a.getUser());
                payLoad.put("pwd:", a.getPwd());
                String token = JWTUtils.getToken(payLoad);
                map.put("state", true);
                map.put("message", "管理员认证成功");
                map.put("token", token);
            } else {
                map.put("state", false);
                map.put("message", "用户名或者密码错误");
            }
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        System.out.println(map);
        return map;
    }

    @PostMapping("/studentLogin")
    public Map<String, Object> studentLogin(
            @RequestBody Students students
    ) {
        Map<String, Object> map = new HashMap<>();
        Students s = studentServer.boolStudent(students);
        try {
            if (s != null) {
                Map<String, Object> payLoad = new HashMap<>();
                payLoad.put("email:", s.getEmail());
                payLoad.put("phoneNumber:", s.getPhoneNumber());
                String token = JWTUtils.getToken(payLoad);
                map.put("state", true);
                map.put("message", "学生认证成功");
                map.put("token", token);
            } else {
                map.put("state", false);
                map.put("message", "用户名或者密码错误");
            }
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        System.out.println(map);
        return map;
    }

    @PostMapping("/teacherLogin")
    public Map<String, Object> studentLogin(
            @RequestBody Teachers teachers
    ){
        Map<String, Object> map = new HashMap<>();
        Teachers t = teacherServer.boolTeacher(teachers);
        try {
            if (t != null) {
                Map<String, Object> payLoad = new HashMap<>();
                payLoad.put("email:", t.getEmail());
                payLoad.put("pwd:", t.getPwd());
                String token = JWTUtils.getToken(payLoad);
                map.put("t",t);
                map.put("state", true);
                map.put("message", "学生认证成功");
                map.put("token", token);
            } else {
                map.put("state", false);
                map.put("message", "用户名或者密码错误");
            }
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        System.out.println(map);
        return map;
    }
}

