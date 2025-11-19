package com.zhang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {
    private static final Logger logger= LoggerFactory.getLogger(LogTest.class);
    @Test
    public void test1(){
        logger.debug("开始计算");
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        logger.info("和为" + sum);
        logger.debug("结束计算");
    }
}
