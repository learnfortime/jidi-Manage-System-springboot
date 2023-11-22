package com.qzk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qzk.pojo.Students;
import com.qzk.pojo.StudentsExtends;
import com.qzk.server.StudentServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("student")
public class studentController {
    @Resource
    private StudentServer studentServer;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultVO<StudentsExtends> list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize) {
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<=0){
            pageSize=5;
        }
        // 在你的方法中使用 PageHelper 进行分页
        PageHelper.startPage(pageNum, pageSize);
        List<StudentsExtends> students = studentServer.listStudent();
        PageInfo<StudentsExtends> page = new PageInfo<>(students);
        if (students != null) {
            return new ResultVO<StudentsExtends>(page,students);
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
        System.out.println(res);
        if (res == 1) {
            return new ResultVO<Students>();
        } else {
            return new ResultVO<>(500, "服务器异常，update错误！");
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
        @RequestMapping(value = "select/{id}", method = RequestMethod.GET)
        public ResultVO<StudentsExtends> select(@PathVariable("id") int id) {
            System.out.println(id);
            StudentsExtends res = studentServer.selectByPrimaryKeyStudent(id);
            System.out.println(res);
            if (res != null) {
                return new ResultVO<StudentsExtends>(res);
            } else {
                return new ResultVO<>(500, "服务器异常，select错误！");
            }
        }

}
