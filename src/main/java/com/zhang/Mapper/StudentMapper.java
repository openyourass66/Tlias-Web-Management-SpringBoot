package com.zhang.Mapper;

import com.zhang.pojo.DegreeOption;
import com.zhang.pojo.Student;
import com.zhang.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //分页条件查询
    List<Student> page(StudentQueryParam param);
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
    //统计学员学历
    List<DegreeOption> getStudentDegreeData();

}
