package com.zhang.Mapper;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {
    //分页条件查询
    List<Clazz> page(ClazzQueryParam param);
    //查询所有员工
    List<Clazz> findAll();
    //根据id查询班级
    Clazz findById(Integer id);
    //添加班级
    void add(Clazz clazz);
    //修改班级
    void update(Clazz clazz);
    //删除班级
    void deleteById(Integer id);
    //统计班级人数
    List<Map<String,Object>> getStudentCountData();
}
