package com.gemcoder.system.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gemcoder.system.bo.OrderMoneyBo;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
@SpringBootTest
public class MoneyCaculateServiceTest {
	@Autowired
	MoneyCaculateService moneyCaculateService;
	@Test
	public void testQeury() {
		
		try {

		String dateStr="2024-12-05 17:31:21";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt=sdf.parse(dateStr);

		OrderMoneyBo rsy=moneyCaculateService._caculateBilllingMoney("鲁B25A7S",9,39, false,  false, dt);
		System.out.println(rsy.getMoney());
		System.out.println(rsy.getDetails().size());
		rsy.getDetails().forEach(r->{
			System.out.print(sdf.format(r.getBeginTime()));
			System.out.print(" ");
			System.out.print(sdf.format(r.getEndTime()));
			System.out.print(" ");
			System.out.print(r.getMoney());
			System.out.print(" ");
			System.out.print(r.getRuleType());
			System.out.print(" ");
			System.out.print("\r\n");
		});
		//moneyCaculateService.saveDetails(1,19,rsy.getDetails());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
