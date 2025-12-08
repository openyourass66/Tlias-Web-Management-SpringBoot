package com.zhang.Controller;

import com.zhang.Anno.Log;
import com.zhang.Service.EmpService;
import com.zhang.pojo.Emp;
import com.zhang.pojo.EmpQueryParam;
import com.zhang.pojo.PageResult;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/emps")
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;

    //分页条件查询
    @GetMapping()
    public Result page(EmpQueryParam  param) {
        log.info("分页查询,参数:{}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }
    //查询所有员工
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有员工");
        List<Emp> empList = empService.findAll();
        return Result.success(empList);
    }
    //根据id查询员工
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        log.info("根据id查询员工,id:{}", id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }
    //添加员工
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工,参数:{}", emp);
        empService.add(emp);
        return Result.success(emp);
    }

    //修改员工
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工,参数:{}", emp);
        empService.update(emp);
        return Result.success();
    }
    //删除员工
    @Log
    @DeleteMapping()
    public Result delete(@RequestParam("ids") List<Integer> ids){
        log.info("删除员工,参数:{}", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }
}
