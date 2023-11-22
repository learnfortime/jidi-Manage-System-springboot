package com.qzk.server;

import com.qzk.dao.StudentsMapper;
import com.qzk.pojo.Students;
import com.qzk.pojo.StudentsExtends;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"studentService"})
public class StudentServer {
    @Resource
    private StudentsMapper studentsMapper;

//    @Cacheable(key = "'all'")
    public List<StudentsExtends> listStudent(){
        return studentsMapper.selectAll();
    }

    public int insertStudent(Students student){
        return studentsMapper.insert(student);
    }

    @CacheEvict(key ="#id")
    public int deteleStudent(int id ){
        return studentsMapper.deleteByPrimaryKey(id);
    }

    @Cacheable(key = "#id")
    public StudentsExtends selectByPrimaryKeyStudent(int id){
        return studentsMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Students students){
        return studentsMapper.updateByPrimaryKey(students);
    }
}
