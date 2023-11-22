package com.qzk.springboot03;

import com.qzk.dao.AdminMapper;
import com.qzk.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03ApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Test
    void contextLoads() {
        Admin admin = new Admin("admin","123");
        int n = adminMapper.boolAdmin(admin);
        System.out.println(n);
    }

}
