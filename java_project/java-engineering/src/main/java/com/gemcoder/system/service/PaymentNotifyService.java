package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.SM2Util;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.CMBPaySecretKeyConstant;
import com.gemcoder.system.util.CMBSignatureUtil;
import com.gemcoder.system.util.OrderPaymentChannelConstant;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.GlobalMessageCacheManager;
import com.gemcoder.system.ws.VehicleRecord;

/**
 * 支付回调处理
 * 
 * @author jiang
 *
 */
@Service
public class PaymentNotifyService {
	private static final Logger log = LoggerFactory.getLogger(PaymentNotifyService.class);
	@Resource
	BusinesslogicService businesslogicService;
	@Resource
	CommandService commandService;
	GlobalMessageCacheManager globalMessageCacheManager = GlobalMessageCacheManager.getInstance();
	@Resource
	ParkingordersService parkingordersService;
	public Map<String, String> onNotify(String requestBodyString) {

		Map<String, String> respData = new HashMap<>();
		respData.put("version", "0.0.1");// 版本号，固定为0.0.1(必传)
		respData.put("encoding", "UTF-8");// 编码方式，固定为UTF-8(必传)
		respData.put("signMethod", "02");// 签名方法，固定为01,表示签名方法为RSA2(必传)

		if (requestBodyString == null || "".equals(requestBodyString.trim())) {
			respData.put("returnCode", "FAIL");
			return respData;
		}

		Map<String, String> requestBodyMap = str2Map(requestBodyString);
		// 解码
		Map<String, String> requestMap = requestBodyMap.entrySet().stream().collect(
				Collectors.toMap(e -> CMBSignatureUtil.decode(e.getKey()), e -> CMBSignatureUtil.decode(e.getValue())));
		if (MapUtil.isEmpty(requestMap)) {
			respData.put("returnCode", "FAIL");
			return respData;
		}


		String sign = requestMap.remove("sign");
		// 对待加签内容进行排序拼接
		String contentStr = CMBSignatureUtil.getSignContent(requestMap);
		// 验证签名-使用招行公钥进行验签
		try {
			boolean flag = SM2Util.sm2Check(contentStr, sign, CMBPaySecretKeyConstant.CMB_PUBLIC_KEY);
			// boolean flag = CMBSignatureUtil.rsaCheck(contentStr, sign, CMBPaySecretKeyConstant.CMB_PUBLIC_KEY, "UTF-8");
			if (!flag) {
				log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，验签失败");
				respData.put("returnCode", "FAIL");
				return respData;
			}
		} catch (Exception e) {
			log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，验签出错了:{}",e.getMessage());
			respData.put("returnCode", "FAIL");
			return respData;
		}
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，验签成功");
		respData.put("returnCode", "SUCCESS");
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，requestMap:{}",JSONObject.toJSONString(requestMap));


		// 根据回调信息处理业务数据
		handleNotify(requestMap, respData);


		// 日志输出结果
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，respData:{}",JSONObject.toJSONString(respData));
		// 对待加签内容进行排序拼接
		String signContent = CMBSignatureUtil.getSignContent(respData);
		// 加签-使用商户私钥加签
		try {
			respData.put("sign", SM2Util.sm2Sign(signContent, CMBPaySecretKeyConstant.PRIVATE_KEY));
			// respData.put("sign", CMBSignatureUtil.rsaSign(signContent, CMBPaySecretKeyConstant.PRIVATE_KEY, "UTF-8"));
		} catch (Exception e1) {
			log.info(e1.getMessage(), e1);
			respData.put("returnCode", "FAIL");
			return respData;
		}
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，加签成功");
		return respData;
	}

	private void handleNotify(Map<String, String> requestMap1, Map<String, String> respData) {
		// 记录数据
		// 后台接收到银行回调数据。
		// 判断支付成功、修改订单状态。
		// 判断是否提前交费，如果不是则发送抬杆命令。
		/*String returnCode = requestMap.get("returnCode");
		if (!"SUCCESS".equalsIgnoreCase(returnCode)) {
			// SUCCESS/FAIL
			log.info("returnCode不是SUCCESS");
			respData.put("respCode", "FAIL");
			respData.put("respMsg", "returnCode不是SUCCESS");
			return;
		}*/
		/*String respCode = requestMap.get("respCode");
		if (!"SUCCESS".equalsIgnoreCase(respCode)) {
			// 招行返回的业务错误码，成功为SUCCESS，失败为FAIL，
			// 若此时errCode为SYSTERM_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认
			String errCode = requestMap.get("errCode");
			if ("SYSTERM_ERROR".equalsIgnoreCase(errCode)) {
				// TODO 发起查询确认
			}
			log.info("respCode不是SUCCESS");
			respData.put("respCode", "FAIL");
			respData.put("respMsg", "respCode不是SUCCESS");
			return;
		}*/
		String biz_contentStr =requestMap1.get("biz_content");
		JSONObject json_biz_content=(JSONObject) JSONObject.parse(biz_contentStr);
		// 保存支付回调原始记录
		int i = insertDataOrderPaymentNotification(json_biz_content);
		String orderCode = json_biz_content.getString("orderId");// getOpenId();

		List<Map<String, Object>> orderList = executeSQL("select * from user_order where order_code=?", orderCode);
		if (orderList == null || orderList.isEmpty()) {
			respData.put("respCode", "FAIL");
			log.info("没有查到订单：" + orderCode);
			respData.put("respMsg", "没有查到订单：" + orderCode);
			return;
		}
		Map<String, Object> userOrder = orderList.get(0);
		String old_payment_status = (String) userOrder.get("payment_status");
		if (old_payment_status != null) {
			if (OrderPaymentStatusConstant.payed.equals(old_payment_status)
					|| OrderPaymentStatusConstant.refund.equals(old_payment_status)) {
				respData.put("respCode", "SUCESS");
				respData.put("respMsg", "重复通知");
				log.warn("重复通知 orderCode->{}", orderCode);
				return;
			}
		}

		String payment_channel = (String) userOrder.get("payment_channel");
		Date exitTime = null;
		boolean openBarrier = false;
		String payment_status = OrderPaymentStatusConstant.payed;
		String order_status = OrderStatusConstant.complete;
		// String payment_channel=OrderPaymentChannelConstant.online;
		if (payment_channel != null && OrderPaymentChannelConstant.onlineAdvance.equals(payment_channel)) {
			order_status = OrderStatusConstant.waitLeft;
		} else {
			exitTime = new Date();
			openBarrier = true;
		}
		// 更新订单状态
		// Double paymentAmount =(Double) paramMap.get("paymentAmount");
		// String licensePlate =(String) paramMap.get("licensePlate");
		// String exitTime =(String) paramMap.get("exitTime");
		String money = json_biz_content.getString("txnAmt");
		Double dmoney=(Integer.parseInt(money) + 0.0d) / 100.0d;
		//BigDecimal bmoney=new BigDecimal(dmoney);
		String license_plate = (String) userOrder.get("license_plate");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paymentAmount",dmoney );
		paramMap.put("licensePlate", userOrder.get("license_plate"));
		paramMap.put("payment_status", payment_status);
		paramMap.put("order_status", order_status);
		paramMap.put("payment_channel", payment_channel);
		paramMap.put("operation", "完成支付");
		paramMap.put("exitTime", exitTime);
		paramMap.put("id", userOrder.get("id"));
		businesslogicService.updatePaymentStatus(paramMap);

		String content = "支付完成。金额：" + money;
		saveOrderOperationRecord(Integer.parseInt(userOrder.get("id").toString()), 1, "system", "支付完成通知",
				"支付完成通知:金额" + money, content, content, new Date());

		// 已支付完成同时保存支付日志
		insertUserPayLog((String) userOrder.get("order_code"),json_biz_content.getString("cmbOrderId"),
				(String) userOrder.get("phone"),(String) userOrder.get("license_plate"),null,BigDecimal.valueOf(dmoney),null,null,null);

		/**
		 * 
		 */

		if (openBarrier) {
			log.info("支付完成下发开闸指令");
			// 查找 vr
			String camId = globalMessageCacheManager.findCameraBarrier(license_plate);
			if (camId == null) {
				log.warn("没有找到车辆对应的相机，{}", license_plate);
				respData.put("respCode", "SUCESS");
				return;
			}
			VehicleRecord vr = globalMessageCacheManager.getCurrentVehicleRecord(camId);
			if (vr == null) {
				log.warn("没有找到车辆对应的相机记录，{},{}", license_plate, camId);
				respData.put("respCode", "SUCESS");
				return;
			}
			// 发送开闸命令
			commandService.openBarier(vr, true);
			parkingordersService.updateLiftTime(userOrder.get("id"));
		}
		respData.put("respCode", "SUCESS");
	}

	/**
	 * 单个支付后的支付日志
	 * @author XueZhongHao
	 * @date 2024/12/31
	 * @return int
	 **/
	public int insertUserPayLog(String orderCode,String cmbOrderId,String phone,String plateNum,Date date, BigDecimal amount,String parkingLotName,String source,String businessType){
		String insertSQL = "INSERT INTO user_pay_log\n" +
				"(platform_serial_number, order_code, serial_number, phone_number, license_plate, transaction_time, amount, parking_lot_name, source_terminal, business_type)\n" +
				"VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
		return executeSQL(insertSQL,orderCode,orderCode,cmbOrderId,phone,plateNum,date,amount,parkingLotName,source,businessType);
	}

	/**
	 * 保存支付回调的原始记录
	 * @author XueZhongHao
	 * @date 2024/12/31
	 * @return int
	 **/
	public int insertDataOrderPaymentNotification(JSONObject jsonObject){
		String insertSQL = "INSERT INTO data_order_payment_notification\n" +
				"(mer_id, order_id, cmbOrder_id, user_id, txn_amt, dsc_amt, currency_code, pay_type, open_id, txn_time, end_date, end_time, third_order_id, pay_bank, pay_channel)\n" +
				"VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		return executeSQL(insertSQL,jsonObject.getString("merId"));//
	}

	private static Map<String, String> str2Map(String str) {
		Map<String, String> result = new HashMap<>();
		String[] results = str.split("&");
		if (results != null && results.length > 0) {
			for (int var = 0; var < results.length; ++var) {
				String pair = results[var];
				String[] kv = pair.split("=", 2);
				if (kv != null && kv.length == 2) {
					result.put(kv[0], kv[1]);
				}
			}
		}
		return result;
	}

	private static String[] split(String str, char splitChar) {
		ArrayList<String> mid = new ArrayList<>();
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (c == splitChar) {
				end = i;
				mid.add(str.substring(start, end));
				start = end + 1;
				continue;
			} else if (i == str.length() - 1) {
				mid.add(str.substring(start, str.length()));
			}
		}
		String[] rst = new String[mid.size()];
		return mid.toArray(rst);
	}

	public Result saveOrderOperationRecord(int orderId, int serialNumber, String operator, String operationType,
			String operationDescription, String operationRecord, String operationDetail, Date operationTime) {
		String createUsername = sdkOfGetCurrentUserName();
		// 构建SQL插入语句
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO order_operation_record (order_id, serial_number, operator, operation_type, operation_description,operation_record,operation_detail,operation_time,create_username, create_time,update_username,update_time) "
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
	// 回调报文解析调试代码请在本地自行补充，勿将真实交易报文提交到仓库
}
