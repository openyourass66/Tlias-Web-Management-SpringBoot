package com.zhang.Mapper;

import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    //条件查询员工
    List<Emp> page(EmpQueryParam  param);
    //根据id查询员工
    Emp findById(Integer id);
    //添加员工
//    @Options(useGeneratedKeys = true,keyColumn = "id")
    void add(Emp emp);
    //修改员工
    void update(Emp emp);
    //删除员工
    void deleteByIds(List<Integer> ids);
    //统计职位人数
    List<Map<String,Object>> getEmpJobData();
    //统计性别数据
    List<Map<String,Object>> getEmpGenderData();
}
