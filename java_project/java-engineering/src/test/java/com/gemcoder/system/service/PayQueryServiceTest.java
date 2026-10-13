package com.gemcoder.system.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@SpringBootTest
@MockBean(ScheduledAnnotationBeanPostProcessor.class)
public class PayQueryServiceTest {
	@Autowired
	PayQueryService payQueryService;

	@Test
	public void testQeury1() {
		boolean b=payQueryService.queryPayStatusByOrderId(221);
		System.out.println("result:"+b);
	}
}
