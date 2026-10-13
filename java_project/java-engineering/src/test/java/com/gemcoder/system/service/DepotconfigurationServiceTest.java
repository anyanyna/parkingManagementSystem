package com.gemcoder.system.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class DepotconfigurationServiceTest {
	@Autowired
	DepotconfigurationService depotconfigurationService;
	@Test
	public void testQeury() {
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			depotconfigurationService.getPaginatedParkingLots(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			depotconfigurationService.getYardList(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			depotconfigurationService.getYardListJGV(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("current", 1);
			paramMap.put("pageSize", 100);
			paramMap.put("parking_lot_name", "停车场1");
			depotconfigurationService.searchYardList(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("id", 1);
			depotconfigurationService.getYardDetails(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("ruleName", 1);
			depotconfigurationService.searchBillingRules(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("id", 1);
			depotconfigurationService.getParkingLotDetails(paramMap);
		}
		{
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("id", 1);
			depotconfigurationService.deactivateRule(paramMap);
		}
		
	}
	@Test
	public void testUpdate() {
		{
			Map<String, Object> paramMap=new HashMap<>();
			{
				Map<String, Object> parkingLotInfo=new HashMap<>();
				parkingLotInfo.put("id", 1);
				paramMap.put("postManagement", parkingLotInfo);
			}
			{
				Map<String, Object> postManagement=new HashMap<>();
				postManagement.put("idCard", "1");
				paramMap.put("postManagement", postManagement);
			}
			{
				Map<String, Object> extendedInformation=new HashMap<>();
				extendedInformation.put("licenseNumber", "1");
				paramMap.put("extendedInformation", extendedInformation);
			}
			
			depotconfigurationService.updateYardDetails(paramMap);
		}
	}
}
