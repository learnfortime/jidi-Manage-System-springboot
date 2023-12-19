package com.qzk.server;

import com.github.pagehelper.PageHelper;
import com.qzk.dao.StudentsMapper;
import com.qzk.pojo.Students;
import com.qzk.pojo.Students;
import com.qzk.pojo.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
//import java.io.Serializable;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"studentService"})
public class StudentServer {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private StudentsMapper studentsMapper;

//    @Cacheable(key = "'all'")
    public List<Students> listStudent(int page, int size){

        // 缓存未命中，从数据库获取数据
        PageHelper.startPage(page, size); // 假设使用 PageHelper 进行分页
        List<Students> students = studentsMapper.selectAll(); // 这将返回分页数据
        return students;
    }

    public int insertStudent(Students student){
        return studentsMapper.insert(student);
    }

    @CacheEvict(key ="#id")
    public int deteleStudent(int id ){
        return studentsMapper.deleteByPrimaryKey(id);
    }

   @Cacheable(value = "studentsCache", key = "{#student_id, #student_name, #email, #phoneNumber, #progress, #gradeAndCertificateID, #certificateURL}")
    public List<Students> selectByPrimaryKey(Integer student_id,String student_name,String email,String phoneNumber,Integer progress,Integer gradeAndCertificateID,String certificateURL){
        System.out.println("student_id:"+student_id);
        return studentsMapper.selectByPrimaryKey(student_id,student_name,email,phoneNumber,progress,gradeAndCertificateID,certificateURL);
    }

    public int updateByPrimaryKey(Students students){
        return studentsMapper.updateByPrimaryKey(students);
    }

    public int insertCertificate(Integer student_id,Integer gradeAndCertificateID){return studentsMapper.insertCertificate(student_id,gradeAndCertificateID);};

    public Students boolStudent(Students students){
        return studentsMapper.boolStudent(students);
    }

    // 添加这个字段来提供一个版本号
    private static final long serialVersionUID = 1L;
}
