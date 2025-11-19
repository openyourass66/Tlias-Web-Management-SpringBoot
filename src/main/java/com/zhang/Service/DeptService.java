package com.zhang.Service;

import com.zhang.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询所有部门
    List<Dept> findAll();
    //根据id查询部门
    Dept findById(Integer id);
    //添加部门
    void add(Dept dept);
    //修改部门
    void update(Dept dept);
    //删除部门
    void deleteById(Integer id);


}
