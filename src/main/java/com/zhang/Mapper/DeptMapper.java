package com.zhang.Mapper;

import com.zhang.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    //查询所有部门
    @Select("select * from dept")
    List<Dept> findAll();
    //根据id查询部门
    @Select("select * from dept where id=#{id}")
    Dept findById(Integer id);
    //添加部门
    @Insert("insert into dept(name,createTime,updateTime) vazlues(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
    //修改部门
    @Update("update dept set name=#{name},updateTime=#{updateTime} where id=#{id}")
    void update(Dept dept);
    //删除部门
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);


}
