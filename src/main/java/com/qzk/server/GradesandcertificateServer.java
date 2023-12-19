package com.qzk.server;

import com.qzk.dao.GradesandcertificatesMapper;
import com.qzk.pojo.Gradesandcertificates;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradesandcertificateServer {
    @Resource
    private GradesandcertificatesMapper gradesandcertificatesMapper;

    public List<Gradesandcertificates> selectAll(){
        return gradesandcertificatesMapper.selectAll();
    }
}
