package com.gemcoder.system.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.ws.VehicleRecord;

@SpringBootTest
public class VehiclemanagementServiceTest {
	@Autowired
	VehiclemanagementService vehiclemanagementService;
	@Test
	public void test() {
		VehicleRecord vr=new VehicleRecord(false, "111", new JSONObject());
		vehiclemanagementService.saveVehicleRawInoutRecord(vr);
	}
}
