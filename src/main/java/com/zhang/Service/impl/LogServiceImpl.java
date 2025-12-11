package com.zhang.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.Mapper.LogMapper;
import com.zhang.Service.LogService;
import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.Log;
import com.zhang.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<Log> page(LogQueryParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        List<Log> logList=logMapper.page(param);
        Page<Log> p =(Page<Log>) logList;
        return new PageResult<Log>(p.getTotal(),p.getResult());
    }
}
