package com.zhang.Service;

import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzQueryParam;
import com.zhang.pojo.PageResult;

public interface ClazzService {
    //分页查询
    PageResult<Clazz> page(ClazzQueryParam param);
    //根据id查询班级
    Clazz findById(Integer id);
    //添加班级
    void add(Clazz clazz);
    //删除班级
    void deleteById(Integer id);

}
