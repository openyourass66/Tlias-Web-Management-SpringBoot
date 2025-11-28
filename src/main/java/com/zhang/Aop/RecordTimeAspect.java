package com.zhang.Aop;

import com.zhang.Mapper.OperateLogMapper;
import com.zhang.Utils.CurrentHolder;
import com.zhang.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class RecordTimeAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.zhang.Anno.Log)")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //执行原始方法
        Object result =pjp.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        //计算耗时
        long costTime = end-begin;
        //
        //构建日志实体
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(pjp.getTarget().getClass().getName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setReturnValue(result!=null?result.toString():"void");
        operateLog.setCostTime(costTime);
        //保存日记
        log.info("记录操作日志:{}",operateLog);
        operateLogMapper.insert(operateLog);
        return result;
    }
    //获取当前用户id
    private Integer getCurrentId(){
        return CurrentHolder.getCurrentId();
    }
}
