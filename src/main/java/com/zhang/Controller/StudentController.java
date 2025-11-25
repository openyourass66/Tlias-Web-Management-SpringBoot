package com.zhang.Controller;

import com.zhang.Service.StudentService;
import com.zhang.pojo.PageResult;
import com.zhang.pojo.Result;
import com.zhang.pojo.Student;
import com.zhang.pojo.StudentQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
    //分页条件查询
    @GetMapping
    public Result page(StudentQueryParam param){
        log.info("分页查询,参数:{}", param);
        PageResult<Student> pageResult = studentService.page(param);
        return Result.success(pageResult);
    }
    //根据id查询学生
    @GetMapping("/{ids}")
    public Result findById(@PathVariable("ids") Integer id){
        log.info("根据id查询学生,id:{}", id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }
    //添加学生
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学生,参数:{}", student);
        studentService.add(student);
        return Result.success();
    }
    //修改学生
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学生,参数:{}", student);
        studentService.update(student);
        return Result.success();
    }
    //删除学生
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids){
        log.info("删除学生,参数:{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
    //违纪处理
    @PutMapping("violation/{id}/{score}")
    public Result violation(@PathVariable("id") Integer id,@PathVariable("score") Integer score){
        log.info("违纪处理,参数:{}", id);
        studentService.violation(id,score);
        return Result.success();
    }
}
