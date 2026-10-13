package com.gemcoder.system.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.OrderPaymentChannelConstant;

@SpringBootTest
@MockBean(ScheduledAnnotationBeanPostProcessor.class)
public class AppBaseServiceTest {
	@Autowired
	AppBaseService appBaseService;
	
	@Test
	public void testQeury1() {
		appBaseService.currentPlate("12345");
		appBaseService.settlement(1, OrderPaymentChannelConstant.offline);
		appBaseService.vehicleInYard(90, "12345", "浙A121212", "蓝牌");
		appBaseService.yardDetail(90);
		Result r=appBaseService.userOrderOutYard(90, "浙A777777");
		System.out.println(r.isFlag());
	}
}
