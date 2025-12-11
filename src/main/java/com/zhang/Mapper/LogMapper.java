package com.zhang.Mapper;

import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    //插入日志数据
    @Insert("insert into operatelog (operateEmpId, operateTime, className, methodName, methodParams, returnValue, costTime) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(Log log);
    //查询日志数据
    @Select("select o.*,e.name empName from operatelog o left join emp e on o.operateEmpId=e.id order by o.operateTime desc")
    List<Log> page(LogQueryParam param);
}
