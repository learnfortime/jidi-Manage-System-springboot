package com.qzk.controller;

import com.qzk.pojo.Gradesandcertificates;
import com.qzk.server.GradesandcertificateServer;
import com.qzk.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/gradesandcertificate")
public class GradesandcertificateController {
    @Resource
    private GradesandcertificateServer gradesandcertificateServer;
    @GetMapping("/list")
    public ResultVO list(){
        List<Gradesandcertificates> g = gradesandcertificateServer.selectAll();
        if (g!=null){
            return new ResultVO<>(g);
        }else {
            return new ResultVO<>(500,"服务器错误");
        }
    }
}
