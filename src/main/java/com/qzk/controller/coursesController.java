package com.qzk.controller;

import com.github.pagehelper.PageInfo;
import com.qzk.pojo.Courses;
import com.qzk.server.CourseServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("course")
public class coursesController {
    @Resource
    private CourseServer courseServer;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultVO<Courses> list(){
        List<Courses> courses = courseServer.selectAll();
        if (courses != null) {
            return new ResultVO<Courses>(courses);
        } else {
            return new ResultVO<>(500, "服务器异常，list错误！");
        }
    }
}
