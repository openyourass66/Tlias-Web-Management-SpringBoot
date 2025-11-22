package com.zhang.Mapper;

import com.zhang.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //批量添加员工工作经历
    void addBatch(List<EmpExpr> exprList);
    //删除员工工作经历
    void deleteByEmpIds(List<Integer> empIds);
}
