package com.gemcoder.system.service;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gemcoder.system.bo.Result;

@SpringBootTest
public class BusinesslogicServiceTest {
	@Autowired
	BusinesslogicService businesslogicService;

    @Test
    void testRecord() {
    	businesslogicService.saveOrderOperationRecord(1,1,"1","创建订单","创建订单","创建订单","创建订单",new Date());
    }
}
