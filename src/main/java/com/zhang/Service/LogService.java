package com.zhang.Service;

import com.zhang.pojo.LogQueryParam;
import com.zhang.pojo.Log;
import com.zhang.pojo.PageResult;

public interface LogService {
    PageResult<Log> page(LogQueryParam param);
}
