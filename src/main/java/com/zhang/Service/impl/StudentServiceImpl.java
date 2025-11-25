package com.zhang.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.Mapper.StudentMapper;
import com.zhang.Service.StudentService;
import com.zhang.pojo.PageResult;
import com.zhang.pojo.Student;
import com.zhang.pojo.StudentQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    //分页条件查询
    @Override
    public PageResult<Student> page(StudentQueryParam param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Student> list = studentMapper.page(param);
        Page<Student> p =(Page<Student>) list;
        return new PageResult<Student>(p.getTotal(),p.getResult());
    }
    //根据id查询学生
    @Override
    public Student findById(Integer id){
        return studentMapper.findById(id);
    }
    //添加学生
    @Override
    public void add(Student student){
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.add(student);
    }
    //修改学生
    @Override
    public void update(Student student){
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }
    //删除学生
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids){
        studentMapper.deleteByIds(ids);
    }
    //违纪处理
    @Override
    public void violation(Integer id, Integer score){
        studentMapper.violation(id,score);
    }

}
