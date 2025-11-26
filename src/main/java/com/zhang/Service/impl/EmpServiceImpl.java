package com.zhang.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.Mapper.EmpExprMapper;
import com.zhang.Mapper.EmpMapper;
import com.zhang.Service.EmpService;
import com.zhang.Utils.JwtUtils;
import com.zhang.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    //分页条件查询
    @Override
    public PageResult<Emp> page(EmpQueryParam  param){
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Emp> empList=empMapper.page(param);
        Page<Emp> p =(Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());

    }
    //查询所有员工
    public List<Emp> findAll(){
        return empMapper.findAll();
    }
    //根据id查询员工
    @Override
    public Emp findById(Integer id){
        return empMapper.findById(id);
    }
    //添加员工
    @Transactional (rollbackFor = {Exception.class})
    //事务控制 默认出现RuntimeException时回滚，现在有任何异常都会回滚
    @Override
    public void add(Emp emp){
        //保存员工基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
        //保存员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.addBatch(exprList);
        }
    }

    //修改员工
    @Transactional (rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp){
        emp.setUpdateTime(LocalDateTime.now());
         empMapper.update(emp);
         //员工经理先删后改
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.addBatch(exprList);
        }
    }
    //删除员工
    @Transactional (rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids){
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }
    //登录
    @Override
    public LoginInfo login(Emp emp){
        Emp e= empMapper.selectByUsernameAndPassword(emp);
        if (e != null){
            log.info("登录成功,用户:{}",e);
            //生成jwt令牌
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return new LoginInfo(e.getId(),e.getUsername(),e.getName(),jwt);
        }
        return null;
    }

}
