package com.gemcoder.system.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BillingmanagementServiceTest {
	@Autowired
	BillingmanagementService billingmanagementService;

	@Test
	public void testQeury1() {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("current", 1);
		paramMap.put("pageSize", 100);
		billingmanagementService.getBillingManagementList(paramMap);
	}
	//@Test
	public void testQeury() {
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.resetBillingManagementList(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			//billingmanagementService.queryBillingManagementList(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getBillingOperationRecords(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getBillingManagementList(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getRuleInformation(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getOperationRecords(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.openNewBillingModal(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getParkingLotList(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getAssociatedParkingLots(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getFreeTimeRange(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			billingmanagementService.getHolidaysList(paramMap);
		}
	}
	public void testUpdate() {
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ruleName", 1);
			billingmanagementService.getOperationRecords(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ruleName", 1);
			billingmanagementService.changeEditBillingScheme(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ruleName", 1);
			billingmanagementService.saveBillingRule(paramMap);
		}
		{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ruleName", 1);
			billingmanagementService.addHolidayComponent(paramMap);
		}
	}
}
