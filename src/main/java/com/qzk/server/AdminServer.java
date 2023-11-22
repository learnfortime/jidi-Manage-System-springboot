package com.qzk.server;

import com.qzk.dao.AdminMapper;
import com.qzk.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminServer {
    private AdminMapper adminMapper;

    public int boolAdmin(Admin admin) {
        return adminMapper.boolAdmin(admin);
    }
}
