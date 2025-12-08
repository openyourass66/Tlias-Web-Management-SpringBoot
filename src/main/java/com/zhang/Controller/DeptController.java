package com.zhang.Controller;

import com.zhang.Anno.Log;
import com.zhang.Service.DeptService;
import com.zhang.pojo.Dept;
import com.zhang.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
@CrossOrigin
public class DeptController {
    @Autowired
    private DeptService deptService;
    //查询所有部门
    @GetMapping()
    public Result findAll(){
        List<Dept> deptList =deptService.findAll();
        log.info("查询所有部门");
        return Result.success(deptList);
    }
    //根据id查询部门
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        Dept dept =deptService.findById(id);
        log.info("查询部门id为{}",id);
        return Result.success(dept);
    }
    //修改部门
    @Log
    @PutMapping()
     public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        log.info("修改部门{}",dept);
        return Result.success();
    }
    //添加部门
    @Log
    @PostMapping()
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        log.info("添加部门{}",dept);
        return Result.success();
    }
    //删除部门
    @Log
    @DeleteMapping()
    public Result delete(@RequestParam("id") Integer id){
        deptService.deleteById(id);
        log.info("删除部门id为{}",id);
        return Result.success();
    }



}
