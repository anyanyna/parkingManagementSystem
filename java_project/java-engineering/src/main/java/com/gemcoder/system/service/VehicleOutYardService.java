package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gemcoder.system.util.DateTimeUtil;

/**
 * 车辆出场处理
 * 
 * @author jiang
 *
 */
@Service
public class VehicleOutYardService {
	private static final Logger log = LoggerFactory.getLogger(VehicleOutYardService.class);

	/**
	 * 是否在黑名单
	 * 
	 * @param plate_num
	 * @param yardId
	 * @return 如果在黑名单，返回true
	 */
	public boolean isInBlackList(String plate_num, int yardId) {
		List<Map<String, Object>> vehicle_block_list = executeSQL(
				"select * from vehicle_block_list where plate_num=? and  JSON_CONTAINS(parking_lot_id,?) and status='生效中' and vehicle_list_code !='Whitelist' order by end_time desc limit 1",
				plate_num, "["+yardId+"]");
		if (vehicle_block_list != null && !vehicle_block_list.isEmpty()) {
			Map<String, Object> vehicle_block = vehicle_block_list.get(0);
			Date start_time = (Date) vehicle_block.get("start_time");
			Date end_time = (Date) vehicle_block.get("end_time");
			Date now = new Date();
			if (DateTimeUtil.inRange(now, start_time, end_time)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String timetxt = sdf.format(end_time);
				log.info("{}车辆被拉黑,拉黑截止时间：" + timetxt, plate_num);
				return true;
			}
		}
		return false;
	}
}
