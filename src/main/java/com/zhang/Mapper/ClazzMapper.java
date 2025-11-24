package com.zhang.Mapper;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    //分页查询
    List<Clazz> page(ClazzQueryParam param);
    //根据id查询班级
    Clazz findById(Integer id);
    //添加班级
    void add(Clazz clazz);
    //删除班级
    void deleteById(Integer id);

}
