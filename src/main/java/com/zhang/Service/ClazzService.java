package com.zhang.Service;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import com.zhang.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    //分页查询
    PageResult<Clazz> page(ClazzQueryParam param);
    //根据id查询班级
    Clazz findById(Integer id);
    //查询所有员工
    List<Clazz> findAll();
    //添加班级
    void add(Clazz clazz);
    //修改班级
    void update(Clazz clazz);
    //删除班级
    void deleteById(Integer id);

}
