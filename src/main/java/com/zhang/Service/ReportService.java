package com.zhang.Service;

import com.zhang.pojo.ClazzOption;
import com.zhang.pojo.DegreeOption;
import com.zhang.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    //统计职位数据
    JobOption getEmpJobData();
    //统计性别数据
    List<Map<String, Object>> getEmpGenderData();
    //统计学员学历数据
    List<DegreeOption> getStudentDegreeData();
    //统计班级人数
    ClazzOption getStudentCountData();
}
