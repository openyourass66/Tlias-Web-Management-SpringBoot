package com.zhang.Service.impl;

import com.zhang.Mapper.ClazzMapper;
import com.zhang.Mapper.EmpMapper;
import com.zhang.Mapper.StudentMapper;
import com.zhang.Service.ReportService;
import com.zhang.pojo.Clazz;
import com.zhang.pojo.ClazzOption;
import com.zhang.pojo.DegreeOption;
import com.zhang.pojo.JobOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    //统计员工职位
    @Override
    public JobOption getEmpJobData(){
        List<Map<String,Object>> list = empMapper.getEmpJobData();
        List<Object> jobList = list.stream().map(dataMap->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap->dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);
    }
    //统计性别数据
    @Override
    public List<Map<String,Object>> getEmpGenderData(){
        return empMapper.getEmpGenderData();
    }
    //统计学员学历
    @Override
    public List<DegreeOption> getStudentDegreeData(){
        return studentMapper.getStudentDegreeData();
    }
    //统计班级人数
    @Override
    public ClazzOption getStudentCountData(){
    List<Map<String,Object>> list = clazzMapper.getStudentCountData();
    List<Object> classList = list.stream().map(dataMap->dataMap.get("clazzName")).toList();
    List<Object> dataList = list.stream().map(dataMap->dataMap.get("num")).toList();
    return new ClazzOption(classList,dataList);
    }

}
