package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.DateTimeUtil;

import javax.annotation.Resource;


/**
 * 车场看板
 * 
 * @author jiang
 *
 */
@Service
public class DepotBoardService {
	@Resource
	UserSdkService userSdkService;
	private static final Logger log = LoggerFactory.getLogger(DepotBoardService.class);
	/*
	 * static final SimpleDateFormat yyyyMMddSdf=new SimpleDateFormat("yyyy-MM-dd");
	 * static final SimpleDateFormat yyyyMMddHHmmssSdf=new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 */
	public Result getSummary(Map<String, Object> paramMap) {
		BigDecimal parkReceive = parkReceive(paramMap);
		BigDecimal longTimeIntantReceive = longTimeIntantReceive(paramMap);
		int serveVehicleCount = serveVehicleCount(paramMap);
		String exitTimeEfficiency = exitTimeEfficiency(paramMap);
		BigDecimal singleParkMoney = singleParkMoney(paramMap);
		int errorOrdersCount = errorOrdersCount(paramMap);
		Map<String, Object> result = new HashMap<>();
		result.put("received_amount", parkReceive);// 实收
		result.put("long_intent_amount", longTimeIntantReceive);// 长租实收
		result.put("vehicle_number", serveVehicleCount);// 服务车次
		result.put("unit_parking_amount", singleParkMoney);// 单位泊车收益
		result.put("exit_efficiency", exitTimeEfficiency);// 离场效率
		result.put("error_order_count", errorOrdersCount);// 计费异常
		return new Result(true, "Success", result);
	}



	/**
	 * 车辆业务分析饼图
	 * 
	 * @return
	 */
	public Result getVehicleTypePie(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select count(1) as type_count,license_type from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by license_type");
		List<Map<String, Object>> countResult = executeSQL(sql.toString(),
				params);
		// TODO 补充缺失的数据
		replaceNaN(countResult,"type_count");
		try {
			//fillEmpty(countResult, beginDate, endDate, timeType, "type_count", 0);
		}catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 停留时长柱状图
	 * 
	 * @return
	 */
	public Result getStatTimeBar(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select count(1) AS duration,TIMESTAMPDIFF(minute, entry_time, exit_time) query_time from user_order where 1=1 and entry_time is not null and  exit_time is not null");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		String sqlstr=sql.toString().replace("${dateType}", mapDateType(timeType,"exit_time"));
		List<Map<String, Object>> countResult = executeSQL(sqlstr,
				params);
		// TODO 补充缺失的数据
		//,15分钟,60分钟，3小时，10小时，24小时，24小时以上
		
		int[] array=new int[] {15,60,60*3,60*10,60*24,Integer.MAX_VALUE};
		int[] result=new int[] {0,0,0,0,0,0};
		String[] axis=new String[] {"0~15分钟","15~60分钟","1~3小时","3~10小时","10~24小时","24小时以上"};
		countResult.forEach(mp->{
			int duration=Integer.parseInt(mp.get("duration").toString());
			int query_time=Integer.parseInt(mp.get("query_time").toString());
			for(int idex=0;idex<array.length;++idex) {
				if(query_time<array[idex]) {
					result[idex]+=duration;
					break;
				}
			}
		});
		List<Map<String, Object>> formResult=new ArrayList<>();
		for(int jdex=0;jdex<axis.length;++jdex) {
			Map<String, Object> mp=new HashMap<String, Object>();
			mp.put("query_time", axis[jdex]);
			mp.put("duration", result[jdex]);
			formResult.add(mp);
		}
		//replaceNaN(countResult,"duration");
		//try {
		//	//fillEmpty(countResult, beginDate, endDate, timeType, "duration", 0);
		//}catch (Exception e) {
		//	//e.printStackTrace();
		//}
		return new Result(true, "Success", formResult);
	}
	@Deprecated
	public Result getStatTimeBar_old(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select TIMESTAMPDIFF(MINUTE, entry_time, exit_time) AS duration,${dateType} query_time from user_order where 1=1 and exit_time is not null and entry_time is not null ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		List<Map<String, Object>> countResult = executeSQL(sql.toString().replace("${dateType}", mapDateType(timeType,"exit_time")),
				params);
		// TODO 补充缺失的数据
		replaceNaN(countResult,"duration");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "duration", 0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 车场资源
	 * 
	 * @return
	 */
	public Result getParkResource(Map<String, Object> paramMap) {
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		
		Map<String, Object> result = new HashMap<>();
		{
			StringBuilder sql = new StringBuilder("select  sum(parking_spaces) as parking_total from parking_lot_info where 1=1 ");
			StringBuilder sql2 = new StringBuilder("select  count(1) as use_space from user_order where 1=1 and exit_time is null and order_status!='异常' ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and id=?");
				sql2.append(" and parking_lot_id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and id in(?");
				sql2.append(" and parking_lot_id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					sql2.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				sql2.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			
			List<Map<String, Object>> singleResult = executeSQL(sql.toString(),params.toArray());
			String parking_total =  singleResult.get(0).get("parking_total").toString();
			
			List<Map<String, Object>> singleResult2 = executeSQL(sql2.toString(),params.toArray());
			int use_space = Integer.parseInt((singleResult2.get(0)==null?"0":singleResult2.get(0).get("use_space")==null?"0":singleResult2.get(0).get("use_space").toString()));
			int left=Integer.parseInt(parking_total)-use_space;
			left=left<0?0:left;
			result.put("parking_free",left); // 空闲泊位总数
			
		}
		{
			StringBuilder sql = new StringBuilder("select count(1) as inOutCount from barrier_gate_equipment where 1=1 ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and parking_lot_info_id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and parking_lot_info_id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			List<Map<String, Object>> singleResult = executeSQL(sql.toString(),params.toArray());
			int rst = Integer.parseInt((singleResult.get(0)==null?"0":singleResult.get(0).get("inOutCount")==null?"0":singleResult.get(0).get("inOutCount").toString()));
			result.put("enter_count", rst);// 出入口总数
		}
		{
			StringBuilder sql = new StringBuilder("select sum(parking_spaces) as parking_total from parking_lot_info where 1=1 ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			
			List<Map<String, Object>> singleResult = executeSQL(sql.toString(),params.toArray());
			int rst = Integer.parseInt((singleResult.get(0)==null?"0":singleResult.get(0).get("parking_total")==null?"0":singleResult.get(0).get("parking_total").toString()));
			result.put("parking_total", rst);// 泊位总数
			
		}
		{
			StringBuilder sql = new StringBuilder("select count(1) as person_count from booth_management where 1=1 and status!='离职' ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and parking_lot_id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and parking_lot_id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			
			List<Map<String, Object>> singleResult = executeSQL(sql.toString(),params.toArray());
			int rst = Integer.parseInt((singleResult.get(0)==null?"0":singleResult.get(0).get("person_count")==null?"0":singleResult.get(0).get("person_count").toString()));
			result.put("person_count", rst);// 岗亭总数
			
		}
		
		{
			
			StringBuilder sql = new StringBuilder("select count(1) as monitor_device_count from camera_equipment where 1=1 ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and parking_lot_info_id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and parking_lot_info_id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			
			List<Map<String, Object>> singleResult = executeSQL(sql.toString(),params.toArray());
			int rst = Integer.parseInt((singleResult.get(0)==null?"0":singleResult.get(0).get("monitor_device_count")==null?"0":singleResult.get(0).get("monitor_device_count").toString()));
			result.put("monitor_device_count", rst);//监控设备总数
			
		}
		return new Result(true, "Success", result);
	}

	/**
	 * 车辆流入流出折线图
	 * 
	 * @return
	 */
	public Result getInOutFlow(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		Map<String, List<Map<String, Object>>> result = new HashMap<>();
		// 入口
		{
			StringBuilder sql = new StringBuilder(
					"select count(1) as enter_count,${dateType}  query_time from vehicle_entry_exit_record where 1=1 ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
					sql.append(" and parking_lot_info_id=?");
					params.add(trimStr(yardName));

			}else if(yardName!=null&&yardName.size()>1) {
					sql.append(" and parking_lot_info_id in(?");
					params.add(yardName.get(0));
					for(int i=1;i<yardName.size()-1;++i) {
						sql.append(",? ");
						params.add(yardName.get(i));
					}
					sql.append(" ,?) ");
					params.add(yardName.get(yardName.size()-1));
			}
			if (beginDate != null) {
				sql.append(" and last_entry_time>=?");
				params.add(beginDate);
			}
			if (endDate != null) {
				sql.append(" and last_entry_time<=?");
				params.add(endDate);
			}
			//appendYardListParams(sql, params, yardNames, "last_parking_lot");
			sql.append(" group by query_time");
			List<Map<String, Object>> countResult = executeSQL(
					sql.toString().replace("${dateType}", mapDateType(timeType,"last_entry_time")), params);
			// TODO 补充缺失的数据
			log.info("countResult->{}",countResult.size());
			replaceNaN(countResult,"enter_count");
			try {
				fillEmpty(countResult, beginDate, endDate, timeType, "enter_count", 0);
			} catch (Exception e) {
			}
			result.put("enterList", countResult);
		}
		// 出口
		{
			StringBuilder sql = new StringBuilder(
					"select count(1) as exit_count,${dateType} query_time from vehicle_entry_exit_record where 1=1 ");
			List<Object> params = new ArrayList<>();
			if(yardName!=null&&yardName.size()==1) {
				sql.append(" and parking_lot_info_id=?");
				params.add(trimStr(yardName));
			}else if(yardName!=null&&yardName.size()>1) {
				sql.append(" and parking_lot_info_id in(?");
				params.add(yardName.get(0));
				for(int i=1;i<yardName.size()-1;++i) {
					sql.append(",? ");
					params.add(yardName.get(i));
				}
				sql.append(" ,?) ");
				params.add(yardName.get(yardName.size()-1));
			}
			
			if (beginDate != null) {
				sql.append(" and last_exit_time>=?");
				params.add(beginDate);
			}
			if (endDate != null) {
				sql.append(" and last_exit_time<=?");
				params.add(endDate);
			}
			appendYardListParams(sql, params, yardNames, "last_parking_lot");
			sql.append(" group by query_time");
			List<Map<String, Object>> countResult = executeSQL(
					sql.toString().replace("${dateType}", mapDateType(timeType,"last_exit_time")), params);
			// TODO 补充缺失的数据
			log.info("countResult->{}",countResult.size());
			replaceNaN(countResult,"exit_count");
			try {
				fillEmpty(countResult, beginDate, endDate, timeType, "exit_count", 0);
			} catch (Exception e) {
			}
			result.put("exitList", countResult);
		}

		return new Result(true, "Success", result);
	}

	/**
	 * 异常订单柱状图
	 * 
	 * @return
	 */
	public Result getErrorOrderBar(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select count(1) AS error_count,${dateType} query_time from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		sql.append(" and order_status='异常'");
		//sql.append(" and order_type='异常'");
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and create_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and create_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time");
		List<Map<String, Object>> countResult = executeSQL(sql.toString().replace("${dateType}", mapDateType(timeType,"create_time")),
				params);
		// TODO 补充缺失的数据
		replaceNaN(countResult,"error_count");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "error_count", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 有效利用率趋势
	 * 
	 * @return
	 */
	public Result getEfficiencyRatio(Map<String, Object> paramMap) {
		// TODO 和getTurnoverRatio区别在时间取的是create time
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(new Date());
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="hour";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select (count(1)+0.0)/sum(b.parking_spaces) as ratio,${dateType} query_time from user_order a join parking_lot_info  b on a.parking_lot=b.parking_lot_name where 1=1 ");
		List<Object> params = new ArrayList<>();
		//sql.append(" and a.exit_time is not null'");
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and a.create_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and a.create_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		String sqlStr=sql.toString().replace("${dateType}", mapDateType(timeType,"a.create_time"));
		List<Map<String, Object>> countResult = executeSQL(sqlStr,
				params);
		// TODO 补充缺失的数据
		replaceNaN(countResult,"ratio");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "ratio", 0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 周转率趋势
	 * 
	 * @return
	 */
	public Result getTurnoverRatio(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddSdf.format(DateTimeUtil.addDay(new Date(), -7) );
			endDate=yyyyMMddHHmmssSdf.format(new Date());
			timeType="day";
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select (count(1)+0.0)/sum(b.parking_spaces) as ratio,${dateType} query_time from user_order a join parking_lot_info  b on a.parking_lot=b.parking_lot_name where 1=1 ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and a.exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and a.exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		List<Map<String, Object>> countResult = executeSQL(sql.toString().replace("${dateType}", mapDateType(timeType,"a.exit_time")),
				params);
		// TODO 补充缺失的数据
		replaceNaN(countResult,"ratio");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "ratio", 0);
		} catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
		
	}

	/**
	 * 停车交易实际收款
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return 金额
	 */
	private BigDecimal parkReceive(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select sum(received_amount) received_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()||singleResult.get(0).get("received_amount")==null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("received_amount");
		return rst;
	}

	/**
	 * 长租交易实收
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return
	 */
	private BigDecimal longTimeIntantReceive(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select sum(received_amount) received_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		sql.append(" and order_type='长租'");
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()||singleResult.get(0).get("received_amount")==null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("received_amount");
		return rst;
	}

	/**
	 * 服务车次
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return
	 */
	private int serveVehicleCount(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select count(1) vehicle_count from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()) {
			return 0;
		}
		long rst = (long) singleResult.get(0).get("vehicle_count");
		return (int)rst;
	}

	/**
	 * 单泊位停车收益
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return
	 */
	private BigDecimal singleParkMoney(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select avg(received_amount) avg_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()||singleResult.get(0).get("avg_amount")==null) {
			return BigDecimal.ZERO;
		}
		
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("avg_amount");
		return rst;
	}

	/**
	 * 离场效率
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return
	 */
	private String exitTimeEfficiency(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select avg(abs(TIMESTAMPDIFF(SECOND,exit_time, lift_time ))) AS exittime_efficiency from user_order where 1=1  and exit_time is not null and lift_time is not null ");
		List<Object> params = new ArrayList<>();
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()||singleResult.get(0).get("exittime_efficiency")==null) {
			return "0.0";
		}
		Double rst = Double.parseDouble( singleResult.get(0).get("exittime_efficiency").toString());
		if(Double.isNaN(rst)||Double.isInfinite(rst)) {
			return "0.0";
		}
		return String.format("%.2f", rst);
	}

	/**
	 * 计费异常
	 * 
	 * @param yardId
	 * @param type
	 * @param status
	 * @param board
	 * @param beginDate
	 * @param endDate
	 * @param timeType
	 * @return
	 */
	private int errorOrdersCount(Map<String, Object> paramMap) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;
		
		if(StringUtils.isEmpty(beginDate)&&StringUtils.isEmpty(endDate)) {
			beginDate=yyyyMMddHHmmssSdf.format(new Date());
			endDate=yyyyMMddSdf.format(new Date());
		}
		String[] formDate=formalTimeFormat(beginDate,endDate);
		beginDate=formDate[0];
		endDate=formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select count(1) as vehicle_count from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		sql.append(" and order_status='异常'");
		//sql.append(" and order_type='异常'");
		if(yardName!=null&&yardName.size()==1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		}else if(yardName!=null&&yardName.size()>1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for(int i=1;i<yardName.size()-1;++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size()-1));
		}
		/**
		 * 使用创建时间
		 */
		if (beginDate != null) {
			sql.append(" and create_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and create_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(
				sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty()||singleResult.get(0).get("vehicle_count")==null) {
			return 0;
		}
		int rst = Integer.parseInt(singleResult.get(0).get("vehicle_count").toString());
		return (int)rst;
	}

	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	private void appendYardListParams(StringBuilder sql, List<Object> params, List<String> yardNames,
			String yardNameField) {
		if (yardNames != null && !yardNames.isEmpty()) {
			if (yardNames.size() == 1) {
				sql.append(" and " + yardNameField + "=?");
				params.add(yardNames.get(0));
			} else {
				sql.append(" and " + yardNameField + " in(?");
				params.add(yardNames.get(0));
				for (int i = 1; i < yardNames.size() - 1; ++i) {
					sql.append(",?");
					params.add(yardNames.get(i));
				}
				sql.append(",?) ");
				params.add(yardNames.get(yardNames.size() - 1));
			}
		}
	}

	private List<String> getYardNameList(List<Map<String, Object>> yardList) {
		List<String> yardnames = new ArrayList<>();
		if (yardList == null || yardList.isEmpty()) {
			return yardnames;
		}
		yardList.forEach(m -> {
			String parking_lot_name = (String) m.get("parking_lot_name");
			if (parking_lot_name != null) {
				yardnames.add(parking_lot_name);
			}
		});
		return yardnames;
	}

	private List<Map<String, Object>> loadYards(Map<String, Object> paramMap) {
		List<String> type = paramMap.get("type") != null ? (List<String>) (paramMap.get("type")) : null;
		List<String> status = paramMap.get("status") != null ? (List<String>) (paramMap.get("status")) : null;
		List<String> sector = paramMap.get("sector") != null ? (List<String>) (paramMap.get("sector")) : null;
		return loadYards(type, status, sector);
	}

	private List<Map<String, Object>> loadYards(List<String> type, List<String> status, List<String> sector) {
		StringBuilder sql = new StringBuilder(
				"select id,parking_lot_code,parking_lot_name from parking_lot_info where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (type != null && type.size() == 1) {
			sql.append(" and parking_lot_type=?");
			params.add(type);
		} else if (type != null && type.size() > 1) {
			sql.append(" and parking_lot_type in(?");
			params.add(type.get(0));
			for (int i = 1; i < type.size() - 1; ++i) {
				sql.append(",? ");
				params.add(type.get(i));
			}
			sql.append(" ,?) ");
			params.add(type.get(type.size() - 1));
		}

		if (status != null && status.size() == 1) {
			sql.append(" and parking_lot_status=?");
			params.add(status);
		} else if (status != null && status.size() > 1) {
			sql.append(" and parking_lot_status in(?");
			params.add(status.get(0));
			for (int i = 1; i < status.size() - 1; ++i) {
				sql.append(",? ");
				params.add(status.get(i));
			}
			sql.append(" ,?) ");
			params.add(status.get(status.size() - 1));
		}

		if (sector != null && sector.size() == 1) {
			sql.append(" and parking_lot_status=?");
			params.add(sector);
		} else if (sector != null && sector.size() > 1) {
			sql.append(" and parking_lot_status in(?");
			params.add(sector.get(0));
			for (int i = 1; i < sector.size() - 1; ++i) {
				sql.append(",? ");
				params.add(sector.get(i));
			}
			sql.append(" ,?) ");
			params.add(sector.get(sector.size() - 1));
		}

		List<Map<String, Object>> yardResult = executeSQL(sql.toString(), params);
		return yardResult;
	}

	
	private void fillEmptyByDay(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue, long step) throws Exception {
		// TODO Auto-generated method stub
		if(begin.length()>10) {
			begin=begin.substring(0,10);
		}
		if(end.length()>10) {
			end=end.substring(0,10);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//list.sort((o1, o2) -> ((Date) o1.get("query_time")).compareTo((Date) o2.get("query_time")));
		Date currentDate = sdf.parse(begin);
		Date endDate = sdf.parse(end);
		while (!currentDate.after(endDate)) {
			boolean find=false;
			for(Map<String, Object> m:list) {
				if(m.get("query_time").toString().equals((sdf.format(currentDate)))){
					find=true;
					break;
				}
			}
			if(!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", sdf.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}
		list.sort((o1, o2) ->{
			try {
				Date  s1=sdf.parse( (String)o1.get("query_time"));
				Date  s2=sdf.parse(  (String)o2.get("query_time")); 
				return s1.compareTo(s2);
			}catch(Exception e) {
				return 0;
			}
		} );
	}

	private void fillEmptyByMonth(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) throws Exception {
		// TODO Auto-generated method stub
		if(begin.length()>10) {
			begin=begin.substring(0,10);
		}
		if(end.length()>10) {
			end=end.substring(0,10);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM");
		//Date currentDate = new Date(begin.getTime());
		//Date endDate = new Date(end.getTime());
		Date currentDate = sdf.parse(begin);
		Date endDate = sdf.parse(end);
		
		
		while (!currentDate.after(endDate)) {
			boolean find=false;
			for(Map<String, Object> m:list) {
				if(m.get("query_time").equals((sdf2.format(currentDate)))){
					find=true;
					break;
				}
			}
			if(!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", sdf2.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.MONTH, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}
		
		list.sort((o1, o2) ->{
			try {
				Date  s1=sdf.parse( (String)o1.get("query_time")+"-01");
				Date  s2=sdf.parse(  (String)o2.get("query_time")+"-01"); 
				return s1.compareTo(s2);
			}catch(Exception e) {
				return 0;
			}
		} );
	}

	//yyyy-MN-dd HH:mm:ss
	private void fillEmptyByHour(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//list.sort((o1, o2) -> ((Date) o1.get("create_time")).compareTo((Date) o2.get("create_time")));
		Date currentDate = sdf.parse(begin);//new Date(begin.getTime());
		Date endDate = sdf.parse(end); //new Date(end.getTime());
		while (!currentDate.after(endDate)) {
			boolean find=false;
			for(Map<String, Object> m:list) {
				if(m.get("query_time").toString().equals(sdf.format(currentDate))){
					find=true;
					break;
				}
			}
			if(!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time",sdf.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.HOUR, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}
		
		list.sort((o1, o2) ->{
			try {
				Date  s1=sdf.parse( (String)o1.get("query_time"));
				Date  s2=sdf.parse(  (String)o2.get("query_time")); 
				return s1.compareTo(s2);
			}catch(Exception e) {
				return 0;
			}
		} );
	}
	private void fillEmptyByYear(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) {
		// TODO Auto-generated method stub
		if(begin.length()>4) {
			begin=begin.substring(0,4);
		}
		if(end.length()>4) {
			end=end.substring(0,4);
		}
		//list.sort((o1, o2) -> ((Date) o1.get("query_time")).compareTo((Date) o2.get("query_time")));
		AtomicInteger currentDate = new AtomicInteger(Integer.parseInt(begin));
		AtomicInteger endDate =new AtomicInteger( Integer.parseInt(end));
		while (!(currentDate.intValue()>endDate.intValue())) {
			boolean find=false;
			for(Map<String, Object> m:list) {
				if(m.get("query_time").toString().equals((String.valueOf(currentDate)))){
					find=true;
					break;
				}
			}
			if(!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", String.valueOf(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			currentDate.addAndGet(1);
		}
		list.sort((o1, o2) ->{
			try {
				Integer  s1=Integer.parseInt( (String)o1.get("query_time"));
				Integer  s2=Integer.parseInt(  (String)o2.get("query_time")); 
				return s1.compareTo(s2);
			}catch(Exception e) {
				return 0;
			}
		} );
	}

	private void fillEmpty(List<Map<String, Object>> list, String begin, String end, String timeType, String defaultKey,
			Object defaultValue) throws Exception {
		if(1==1) {
		//	return;
		}
		if ("日".equals(timeType) || "day".equals(timeType)|| "date".equals(timeType)) {
			fillEmptyByDay(list, begin, end, defaultKey, defaultValue, 1000L * 60 * 60 * 24);
		} else if ("月".equals(timeType) || "month".equals(timeType)) {
			fillEmptyByMonth(list, begin, end, defaultKey, defaultValue);
		} else if ("年".equals(timeType) || "year".equals(timeType)) {
			fillEmptyByYear(list, begin, end, defaultKey, defaultValue);
		} else  {
			fillEmptyByHour(list, begin, end, defaultKey, defaultValue);
		}
	}

	
	
	private void replaceNaN(List<Map<String, Object>> list,String fieldName) {
		list.forEach(m->{
			Object obj=m.get(fieldName);
			if(obj==null) {
				m.put(fieldName, 0);
			}else if(obj instanceof Double) {
				double d=(double)obj;
				if(Double.isInfinite(d)||Double.isNaN(d)) {
					m.put(fieldName, 0);
				}
			}
		});
	}
	private String mapDateType(String dateType,String field) {
		if (dateType == null) {
			return   "DATE_FORMAT("+field+", '%Y-%m-%d') "; 
		}
		if ("hour".equals(dateType) || "小时".equals(dateType) || "时".equals(dateType)) {
			//return "hour("+field+") ";
			return   "DATE_FORMAT("+field+", '%Y-%m-%d %H:00:00') "; 
		}
		if ("day".equals(dateType)||"date".equals(dateType) || "日".equals(dateType)) {
			return   "DATE_FORMAT("+field+", '%Y-%m-%d') "; 
		}
		if ("month".equals(dateType) || "月".equals(dateType)) {
			return   "DATE_FORMAT("+field+", '%Y-%m') ";
		}
		if ("year".equals(dateType) || "年".equals(dateType)) {
			return  "DATE_FORMAT("+field+", '%Y') "; 
		}
		return   "DATE_FORMAT("+field+", '%Y-%m-%d') "; 
	}
	
	/**
	 * 处理 yyyy yyyy-MM yyyy-MM-dd 不同形式数据
	 * @param beginDate
	 * @param endDate
	 * @param sqlBuilder
	 * @param params
	 * @param dateField
	 */
	private String[] formalTimeFormat(String beginDate,String endDate) {
		 SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(beginDate==null||endDate==null) {
			return new String[] {beginDate,endDate};
		}
		if(beginDate!=null&&beginDate.trim().length()<=4) {
			//年
			beginDate=beginDate.trim()+"-01-01 00:00:00";
			endDate=endDate.trim()+"-12-31 23:59:59";
		}else if(beginDate!=null&&beginDate.trim().length()<=7) {
			//月
			beginDate=beginDate.trim()+"-01 00:00:00";
			String ed=endDate.trim()+"-01 23:59:59";
			try {
				Date dt=yyyyMMddSdf.parse(ed);
				dt=DateTimeUtil.monthEnd(dt);
				endDate=yyyyMMddHHmmssSdf.format(dt);
			} catch (ParseException e) {
			}
			//endDate=endDate+"-31 23:59:59";
		}else {
			if(beginDate.length()<19) {
				beginDate=beginDate.trim()+" 00:00:00";
			}
			Date endtime=new Date();
			try {
				endtime = yyyyMMddSdf.parse(endDate);
			} catch (ParseException e) {
			}
			endtime.setHours(23);
			endtime.setMinutes(59);
			endtime.setSeconds(59);
			endDate=yyyyMMddHHmmssSdf.format(endtime);
		}
		return new String[] {beginDate,endDate};
	}
	private String trimStr(Object str) {
		if(str==null) {
			return null;
		}
		return str.toString().replace('[', ' ').replace(']', ' ').replace(',', ' ').trim();
	}

}
