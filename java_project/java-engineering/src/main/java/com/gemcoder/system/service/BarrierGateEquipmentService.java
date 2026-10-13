package com.gemcoder.system.service;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BarrierGateEquipmentService {
	public List<Map<String,Object>> loadAllCameras(){
		return executeSQL("select * from barrier_gate_equipment");
	}
	public int deleteBarrierGateEquipment(Map<String, Object> paramMap) {
		Object id = paramMap.get("id");
		return executeSQL("delete from barrier_gate_equipment where id=" + id);
	}
}
