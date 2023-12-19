package com.qzk.server;

import com.qzk.dao.AdminMapper;
import com.qzk.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Service
public class AdminServer {

    @Resource
    private AdminMapper adminMapper;
    public Admin boolAdmin(Admin admin) {
        return adminMapper.boolAdmin(admin);
    }
}
