package com.zhang.Service.impl;

import com.zhang.Mapper.DeptMapper;
import com.zhang.Service.DeptService;
import com.zhang.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    //查询所有部门
    @Override
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }
    //根据id查询部门
    @Override
    public Dept findById(Integer id){
        return deptMapper.findById(id);
    }
    //修改部门
    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
    //添加部门
    @Override
    public void add(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
    @Override
    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }




}
