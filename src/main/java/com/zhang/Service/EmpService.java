package com.zhang.Service;

import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import com.zhang.pojo.PageResult;

import java.util.List;

public interface EmpService {
    //分页查询
    PageResult<Emp> page(EmpQueryParam  param);
    //根据id查询员工
    Emp findById(Integer id);
    //添加员工
    void add(Emp emp);
    //删除员工
    void deleteByIds(List<Integer> ids);
    //修改员工
    void update(Emp emp);
}
