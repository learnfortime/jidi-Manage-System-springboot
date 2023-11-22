package com.qzk.server;

import com.qzk.dao.CoursesMapper;
import com.qzk.pojo.Courses;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServer {
    @Resource
    private CoursesMapper coursesMapper;

    public int deleteByPrimaryKey(int id){
        return coursesMapper.deleteByPrimaryKey(id);
    }

    public int insert(Courses courses){
        return coursesMapper.insert(courses);
    }

    public Courses selectByPrimaryKey(int id){
        return coursesMapper.selectByPrimaryKey(id);
    }

    public List<Courses> selectAll(){
        return coursesMapper.selectAll();
    }

    public int updateByPrimaryKey(Courses courses){
        return coursesMapper.updateByPrimaryKey(courses);
    }
}
