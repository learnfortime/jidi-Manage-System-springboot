package com.qzk.controller;

import com.qzk.pojo.Courses;
import com.qzk.pojo.Students;
import com.qzk.pojo.Teachers;
import com.qzk.server.CourseServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/course")
public class courseController {
    @Resource
    private CourseServer courseServer;
    @GetMapping("/list")
    public ResultVO listCourse(){
        List<Courses> courses = courseServer.selectAll();
        if (courses!=null){
            return new ResultVO<>(courses);
        }else {
            return new ResultVO<>(500,"服务器错误");
        }
    }

    @RequestMapping(value = "delete/{course_ID}",method = RequestMethod.DELETE)
    public ResultVO<Teachers> delete(
            @PathVariable("course_ID") int course_ID
    ){
        int res = courseServer.deleteByPrimaryKey(course_ID);
        if (res == 1){
            return new ResultVO<>();
        }else {
            return new ResultVO<>(500,"delete导致服务器错误！");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResultVO<Teachers> update( @RequestBody  Courses courses) {
        int res = courseServer.updateByPrimaryKey(courses);
        if (res == 1) {
            return new ResultVO<>();
        }else {
            return new ResultVO<>(500,"teacherUpdate服务器错误！");
        }
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public ResultVO addTeacher(Courses courses){
        int t = courseServer.insert(courses);
        System.out.println(t);
        if (t == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常,insert错误！");
        }
    }
}
