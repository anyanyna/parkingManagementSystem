package com.gemcoder.system.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OperationBoardServiceTest {
	@Autowired
	OperationBoardService operationBoardService;
	@Test
	public void test() {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		operationBoardService.getSummary(paramMap);
	}

}
