package com.qzk.server;

import com.qzk.dao.TeachersMapper;
import com.qzk.pojo.Courses;
import com.qzk.pojo.Teachers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServer {
    @Resource
    private TeachersMapper teachersMapper;

    @Cacheable(value = "teacherCache", key = "'allTeacher'")
    public List<Teachers> listTeacher(){return teachersMapper.selectAll();}

    public int updateTeacher(Teachers teachers){return teachersMapper.update(teachers);}

    public int deleteTeacher(int teacher_id){return teachersMapper.delete(teacher_id);}

    public Teachers selectByPrimaryKey(int teacher_id) {
        return teachersMapper.selectByPrimaryKey(teacher_id);
    }
    public Teachers boolTeacher(Teachers teacher){return teachersMapper.boolTeacher(teacher);}

    public int add(Teachers teachers){return teachersMapper.add(teachers);}

    public int addCource(int teacher_id,int course_ID){return teachersMapper.addCource(teacher_id,course_ID);}
}
