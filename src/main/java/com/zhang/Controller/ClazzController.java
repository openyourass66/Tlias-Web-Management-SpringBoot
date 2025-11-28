package com.zhang.Controller;

import com.zhang.Anno.Log;
import com.zhang.Service.ClazzService;
import com.zhang.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    //分页条件查询
    @GetMapping()
    public Result  page(ClazzQueryParam param){
        log.info("分页查询,参数:{}", param);
        PageResult<Clazz> pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }
    //查询所有班级
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }
    //根据id查询班级
    @GetMapping("/{id}")
    public Result get(@PathVariable("id") Integer id){
        log.info("根据id查询班级,id:{}", id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }
    //添加班级
    @Log
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级,参数:{}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }
    //修改班级
    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级,参数:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    //删除班级
    @Log
    @DeleteMapping(("{id}"))
    public Result delete(@PathVariable("id") Integer id){
        log.info("删除部门id为{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }
}
