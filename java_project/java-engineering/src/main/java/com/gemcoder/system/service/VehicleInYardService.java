package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.DateTimeUtil;
import com.gemcoder.system.util.OrderRemarkConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.ws.CapMatchServcie;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.GlobalMessageCacheManager;

/**
 * 车辆入场处理
 * 
 * @author jiang
 *
 */
@Service
public class VehicleInYardService {
	@Resource
	CommandService commandService;
	@Resource
	BusinesslogicService businesslogicService;
	
	@Resource
	CapMatchServcie capMatchServcie;
	
	GlobalMessageCacheManager globalMessageCacheManager=GlobalMessageCacheManager.getInstance(); 
	private static final Logger log = LoggerFactory.getLogger(VehicleInYardService.class);

	/**
	 * 创建订单，开启道闸
	 * 
	 * @param yardId
	 * @param cam_id
	 * @param plate_num
	 * @param plateType
	 * @return
	 */
	public Result vehicleInYard(String order_source,Integer yardId, String cam_id, String plate_num, String plateType) {

		Result b = _vehicleInYard(order_source,yardId, cam_id, plate_num, plateType,true,null);
		/**
		 * 抬杆放行
		 */
		
		if (b.isFlag()) {
			log.info("抬杆放行,yardId->{},cam_id->{},plate_num->{}", yardId, cam_id, plate_num);
			try {
				///commandService.capPicture(cam_id);
				capMatchServcie.manualInputPlateNum(plate_num, cam_id);
			}catch(Exception e) {
				//log.info("抓拍失败,");
			}
			try {
				commandService.openBarier(cam_id, plate_num, true, true);
			}catch(Exception e) {
				log.warn("抬杆失败",e);
				return new Result(false,"抬杆失败，请联系岗亭","抬杆失败，请联系岗亭");
			}
			
		}
		return b;
	}
	/**
	 * 创建订单，开启道闸
	 *
	 * @param yardId
	 * @param cam_id
	 * @param plate_num
	 * @param plateType
	 * @param executeMasking 是否处理黑名单数据
	 * @param isOpen 是否抬杆
	 * @param entryTime 入场时间
	 * @return
	 */
	public Result vehicleInYard(String order_source,Integer yardId, String cam_id, String plate_num, String plateType,boolean executeMasking,boolean isOpen,Date entryTime) {

		Result b = _vehicleInYard(order_source,yardId, cam_id, plate_num, plateType,executeMasking,entryTime);
		/**
		 * 抬杆放行
		 */

		if (b.isFlag()&&isOpen) {
			log.info("抬杆放行,yardId->{},cam_id->{},plate_num->{}", yardId, cam_id, plate_num);
			try {
				///commandService.capPicture(cam_id);
				capMatchServcie.manualInputPlateNum(plate_num, cam_id);
			}catch(Exception e) {
				//log.info("抓拍失败,");
			}
			try {
				commandService.openBarier(cam_id, plate_num, true, true);
			}catch(Exception e) {
				log.warn("抬杆失败",e);
				return new Result(false,"抬杆失败，请联系岗亭","抬杆失败，请联系岗亭");
			}

		}
		return b;
	}

	private Result _vehicleInYard(String order_source,Integer yardId, String cam_id, String plate_num, String platType,boolean executeMasking,Date entryTime) {
		// TODO Auto-generated method stub
		String createUsername = sdkOfGetCurrentUserName();
		List<Map<String, Object>> yardlist = executeSQL("select * from parking_lot_info where id=?", yardId);
		String parking_lot_name = (String) yardlist.get(0).get("parking_lot_name");
		List<Map<String, Object>> camList = executeSQL("select * from barrier_gate_equipment where cam_id=?", cam_id);
		if(camList.isEmpty()) {
			return new Result(false, "没有找到道闸设备", "没有找到道闸设备");
		}
		Date enterTime=entryTime!=null?entryTime:new Date();
		String channels = (String) camList.get(0).get("channels");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("licensePlate", plate_num);
		paramMap.put("parking_lot_id", yardId);
		paramMap.put("parking_lot", parking_lot_name);
		paramMap.put("entry_time", enterTime);
		paramMap.put("license_plate_type", platType==null?"蓝牌":platType);
		paramMap.put("entry_name", channels);
		paramMap.put("order_source", order_source);
		//判断是否处理拉黑数据 人工补录不处理拉黑
		if (executeMasking){
			// 是否在拉黑时间范围之内，如果是则不放行
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
					log.info("{}车辆被拉黑,拉黑截止时间：" + timetxt,plate_num);
					return new Result(false, "车辆被拉黑", "车辆被拉黑,拉黑截止时间：" + timetxt);
				}
			}

		}
		// 根据规则判断是否允许重复入场
		List<Map<String, Object>> list = executeSQL(
				"select * from user_order where license_plate=? and parking_lot_id=?  and exit_time is null   and order_status='车辆入场'  order by create_time desc limit 1",
				plate_num, yardId);
		if (list == null || list.isEmpty()) {
			return businesslogicService.createParkingOrder(paramMap);
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timetxt = sdf.format(enterTime);
			list.forEach(mp->{
				int oid=Integer.parseInt(mp.get("id").toString());
				String orderCode=(String)mp.get("order_code");
				executeSQL("update user_order set order_status=? ,remark=? where id=?",OrderStatusConstant.exception,OrderRemarkConstant.duplicateInYard,oid);
				StringBuilder detail=new StringBuilder();
				detail.append("异常订单，重复入场。时间"+timetxt);
				saveOrderOperationRecord(oid,1,createUsername,"异常订单","异常订单:"+orderCode,"异常订单:"+orderCode,detail.toString(),new Date());
		        
			});
		}
		List<Map<String, Object>> operation_rulesList = executeSQL(
				"select * from operation_rules where parking_lot_id=?", yardId);
		if (operation_rulesList == null || operation_rulesList.isEmpty()) {
			return businesslogicService.createParkingOrder(paramMap);
		}
		// TODO 处理通知
		String abnormal_handling_duplicate = (String) operation_rulesList.get(0).get("abnormal_handling_duplicate");
		if (StringUtils.isEmpty(abnormal_handling_duplicate) || "车辆放行".equals(abnormal_handling_duplicate)
				|| "其他".equals(abnormal_handling_duplicate)) {
			log.info("重复入场,车辆放行,yardId->{},cam_id->{},plate_num->{}", yardId, cam_id, plate_num);
			Result r = businesslogicService.createParkingOrder(paramMap);
			return r;
		}
		if ("放行拉黑".equals(abnormal_handling_duplicate)) {
			Integer abnormal_duplicate_block_time = (Integer) operation_rulesList.get(0)
					.get("abnormal_duplicate_block_time");
			Date endTime = new Date();
			if(abnormal_duplicate_block_time==null) {
				abnormal_duplicate_block_time=0;
			}
			endTime.setTime(endTime.getTime() + abnormal_duplicate_block_time * 24 * 60 * 60 * 1000L);
			executeSQL("insert into vehicle_block_list (parking_lot_id,plate_num,start_time,end_time,plate_type,status,remark,create_username,update_username,vehicle_list_code) values(?,?,?,?,?,?,?,?)",
					"["+yardId+"]", plate_num, new Date(), endTime, plate_num,platType,"生效中","车场配置:放行拉黑","sysAdmin","sysAdmin","Blacklist");
			log.info("重复入场,放行拉黑,yardId->{},cam_id->{},plate_num->{}", yardId, cam_id);
			Result r = businesslogicService.createParkingOrder(paramMap);
			return r;
		}
		if ("禁止通行".equals(abnormal_handling_duplicate)) {
			log.warn("重复入场,禁止通行,yardId->{},cam_id->{},plate_num->{}", yardId, cam_id, plate_num);
			return new Result(false, "重复入场", "重复入场,禁止通行");
		}
		log.warn("重复入场,{},yardId->{},cam_id->{},plate_num->{}", abnormal_handling_duplicate, yardId, cam_id, plate_num);
		return businesslogicService.createParkingOrder(paramMap);
	}
    protected Result saveOrderOperationRecord(int orderId,int serialNumber,String operator,String operationType,String operationDescription,String operationRecord,String operationDetail,Date operationTime) {
        String createUsername = sdkOfGetCurrentUserName();
        // 构建SQL插入语句
        StringBuilder insertSql = new StringBuilder("INSERT INTO order_operation_record (order_id, serial_number, operator, operation_type, operation_description,operation_record,operation_detail,operation_time,create_username, create_time,update_username,update_time) "
        		+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)");
        List<Object> params = new ArrayList<>();
        params.add(orderId);
        params.add(serialNumber);
        params.add(operator);
        params.add(operationType);
        params.add(operationDescription);
        params.add(operationRecord);
        params.add(operationDetail);
        params.add(operationTime);
        params.add(createUsername);
        params.add(new Date());
        params.add(createUsername);
        params.add(new Date());
        // 执行SQL插入语句
        int insertRows = executeSQL(insertSql.toString(), params.toArray());
        // 返回结果
        if (insertRows > 0) {
            return new Result(true, "order operation record created successfully", null);
        } else {
            return new Result(false, "Failed to create order operation record", null);
        }
    	
    }
}
