package com.qzk.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qzk.pojo.Courses;
import com.qzk.pojo.Students;
import com.qzk.pojo.Teachers;
import com.qzk.server.TeacherServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/teacher")
public class teacherController {
    @Resource
    private TeacherServer teacherServer;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVO<Teachers> list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "2") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "2") int pageSize
    ){
        // 在你的方法中使用 PageHelper 进行分页
//        PageHelper.startPage(pageNum, pageSize);
        List<Teachers> teachers = teacherServer.listTeacher();
//        PageInfo<Teachers> page = new PageInfo<>(teachers);
        if (teachers != null) {
            return new ResultVO<Teachers>(teachers);
        } else {
            return new ResultVO<>(500, "服务器异常，list错误！");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResultVO<Teachers> update( @RequestBody  Teachers teachers) {
        int res = teacherServer.updateTeacher(teachers);
        if (res == 1) {
            return new ResultVO<>();
        }else {
            return new ResultVO<>(500,"teacherUpdate服务器错误！");
        }
    }

    @RequestMapping(value = "delete/{teacher_id}",method = RequestMethod.DELETE)
    public ResultVO<Teachers> delete(
            @PathVariable("teacher_id") int teacher_id
    ){
        int res = teacherServer.deleteTeacher(teacher_id);
        if (res == 1){
            return new ResultVO<>();
        }else {
            return new ResultVO<>(500,"delete导致服务器错误！");
        }
    }

    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    public ResultVO<Teachers> selectById(@RequestParam Integer teacher_id){
        Teachers teacher = teacherServer.selectByPrimaryKey(teacher_id);
        if (teacher != null){
            return new ResultVO<>(teacher);
        }else {
            return new ResultVO<>(500,"selectById导致服务器错误！");
        }
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public ResultVO addTeacher(@RequestBody Teachers teachers){
        int t = teacherServer.add(teachers);
        System.out.println(t);
        if (t == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常,insert错误！");
        }
    }

    @RequestMapping(value = "addCourse",method = RequestMethod.POST)
    public ResultVO<Students> insertCertificate(
            @RequestParam(required = false) Integer teacher_id,
            @RequestParam(required = false) Integer course_ID
//            @RequestParam(required = false) String certificateURL
    ){
//        if ("".equals(certificateURL)) {
//            certificateURL = null;
//        }
        int res = teacherServer.addCource(teacher_id,course_ID);
        if (res == 1){
            return new ResultVO<Students>();
        }else {
            return new ResultVO<>(500,"服务器异常，insertCertificate错误！");
        }
    }
}
