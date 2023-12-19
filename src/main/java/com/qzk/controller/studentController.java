package com.qzk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qzk.pojo.Students;
import com.qzk.pojo.Students;
import com.qzk.server.StudentServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/student")
public class studentController {
    @Resource
    private StudentServer studentServer;

    @GetMapping("/list")
    public ResultVO<Students> list(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize
    ) {
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<=0){
            pageSize=5;
        }
        // 在你的方法中使用 PageHelper 进行分页
        List<Students> students = studentServer.listStudent(pageNum, pageSize);
        PageInfo<Students> page = new PageInfo<>(students);
        if (students != null) {
            return new ResultVO<Students>(page,students);
        } else {
            return new ResultVO<>(500, "服务器异常，list错误！");
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResultVO<Students> insert(Students student) {
        int s = studentServer.insertStudent(student);
        System.out.println(s);
        if (s == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常,insert错误！");
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultVO<Students> update(Students student) {
        int res = studentServer.updateByPrimaryKey(student);
        if (res == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常，update错误！");
        }
    }
    @RequestMapping(value = "insertCertificate",method = RequestMethod.POST)
    public ResultVO<Students> insertCertificate(
            @RequestParam(required = false) Integer student_id,
            @RequestParam(required = false) Integer gradeAndCertificateID
//            @RequestParam(required = false) String certificateURL
    ){
//        if ("".equals(certificateURL)) {
//            certificateURL = null;
//        }
        int res = studentServer.insertCertificate(student_id,gradeAndCertificateID);
        if (res == 1){
            return new ResultVO<Students>();
        }else {
            return new ResultVO<>(500,"服务器异常，insertCertificate错误！");
        }
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResultVO<Students> delete(@PathVariable("id") int id) {
        int res = studentServer.deteleStudent(id);
        System.out.println(res);
        if (res == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常，detele错误！");
        }
    }
        @RequestMapping(value = "/select/", method = RequestMethod.POST)
        public ResultVO<Students> select(
//                @RequestBody Students students
                @RequestParam(required = false) Integer student_id,
                @RequestParam(required = false) String student_name,
                @RequestParam(required = false) String email,
                @RequestParam(required = false) String phoneNumber,
                @RequestParam(required = false) Integer progress,
                @RequestParam(required = false) Integer gradeAndCertificateID,
                @RequestParam(required = false) String certificateURL,
                @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize
        ) {
            if ("".equals(student_name)) {
                student_name = null;
            }
            if ("".equals(email)) {
                email = null;
            }
            if ("".equals(phoneNumber)) {
                phoneNumber = null;
            }
            try{
                PageHelper.startPage(pageNum, pageSize);
                List<Students> students= studentServer.selectByPrimaryKey(student_id,student_name,email,phoneNumber,progress,gradeAndCertificateID,certificateURL);
                PageInfo<Students> page = new PageInfo<>(students);
//                Students res = studentServer.selectByPrimaryKey(students);
                if (students != null) {
                    return new ResultVO<Students>(page,students);
                } else {
                    return new ResultVO<>(500, "服务器异常，select错误！");
                }
            }catch (Exception e){
                e.printStackTrace();
                return new ResultVO<>(500, "服务器异常，select错误：" + e.getMessage());
            }

        }

}
