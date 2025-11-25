package com.zhang.Service;

import com.zhang.pojo.PageResult;
import com.zhang.pojo.Student;
import com.zhang.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    //分页查询
    PageResult<Student> page(StudentQueryParam param);
    //根据id查询学生
    Student findById(Integer id);
    //添加学生
    void add(Student student);
    //修改学生
    void update(Student student);
    //删除学生
    void deleteByIds(List<Integer> ids);
    //违纪处理
    void violation(Integer id, Integer score);
}
