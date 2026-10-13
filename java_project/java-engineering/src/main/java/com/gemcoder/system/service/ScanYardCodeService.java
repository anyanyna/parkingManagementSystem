package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.OrderMoneyBo;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.CMBMD5Utils;
import com.gemcoder.system.util.OrderPaymentChannelConstant;
import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderRemarkConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.SM2Util;
import com.gemcoder.system.util.CMBPaySecretKeyConstant;
import com.gemcoder.system.util.CMBPayUrlConsant;
import com.gemcoder.system.util.CMBSignatureUtil;
import com.gemcoder.system.util.OrderCodeUtil;
import com.gemcoder.system.util.WsJsonUtil;
import com.gemcoder.system.ws.GlobalMessageCacheManager;
import com.gemcoder.system.ws.VehicleRecord;

@Service
public class ScanYardCodeService {
	/**
	 * 支付是否测试环境
	 */
	@Value("${payment.env.test:true}")
	private boolean isPaymentTest;
	/**
	 * 商户在招行完成商户进件后分配的招行商户号（请在 application.yml 中配置）
	 */
	@Value("${payment.member.id:}")
	private String paymentMemerBerId;
	/**
	 * 虚拟收银员（请在 application.yml 中配置）
	 */
	@Value("${payment.cashier:}")
	private String paymentCashier;
	/**
	 * 支付回调地址（请在 application.yml 中配置，例如 http://你的域名:9071/PaymentNotify/aggregateNotify）
	 */
	@Value("${payment.notify.url:}")
	private String paymentNotifyURL;

	/**
	 * 商户微信公众号appid（请在 application.yml 中配置）
	 */
	@Value("${wexin.appid:}")
	private String wexinAppid;
	@Value("${wexin.secret:}")
	private String wexinSecret;
	
	

	@Value("${app.id:}")
	private String appid;

	@Value("${app.secret:}")
	private String appSecret;

	// 支付相关商户信息（商户号、收银员、微信/支付宝 sid 等）请自行在
	// application.yml 中通过 payment.member.id、payment.cashier、app.id、app.secret 等配置项注入，勿写入代码。

	private static final Logger log = LoggerFactory.getLogger(ScanYardCodeService.class);
	@Resource
	MoneyCaculateService moneyCaculateService;
	@Resource
	ParkingordersService parkingordersService;
	GlobalMessageCacheManager globalMessageCacheManager = GlobalMessageCacheManager.getInstance();


	/**
	 *
	 * @author XueZhongHao
	 * @date 2024/12/31
	 * @param order_source 			订单来源
	 * @param parking_lot_info_id 	停车场id
 	 * @param cam_id
	 * @param advancePay 			是否提前支付
	 * @param plate_num 			车牌
	 * @param payClient 			支付类型
	 * @param clientIP 				支付人ip
	 * @param buyerLogonId 			支付宝信息
	 * @param subOpenId  			微信openid
	 * @return com.gemcoder.system.bo.Result
	 **/
	public Result outYard(String order_source, Integer parking_lot_info_id, String cam_id, Boolean advancePay,
			String plate_num, String payClient, String clientIP, String buyerLogonId,String subOpenId) {

		Result r = _outYard(order_source, parking_lot_info_id, cam_id, advancePay, plate_num, payClient, clientIP,
				null,subOpenId);
		return getPayResultBy(r);

	}

	private Result _outYard(String order_source, Integer parking_lot_info_id, String cam_id, Boolean advancePay,
			String plate_num, String payClient, String clientIP, String buyerLogonId,String subOpenId) {
		// 流程：
		// 后台接口收到二维码编号，根据编号查找车场，出入口。
		// 从出入口获取相机上报缓存数据，如果没有缓存数据，反馈前台没有车牌结果。
		// 根据车牌提取订单数据。如果没有找到订单，进入无订单流程。
		// 如果有订单，计算费用，将费用和支付url，返回给页面。

		// JSONObject json = (JSONObject) JSONObject.parse(codeStr);
		// Object parking_lot_info_id_obj = json.get("parking_lot_info_id");
		// String camid = json.getString("cam_id");
		// String plate_num = null;
		// int parking_lot_info_id =
		// Integer.parseInt(parking_lot_info_id_obj.toString());
		/**
		 * 提前交费
		 */
		// Boolean advancePay = json.getBoolean("advancePay");
		VehicleRecord vr = null;
		advancePay = advancePay == null ? false : advancePay;
		if (advancePay) {
			// plate_num = json.getString("plate_num");
			if (plate_num == null) {
				return new Result(false, "提前交费需要车牌号", "提前交费需要车牌号");
			}
		} else {
			vr = globalMessageCacheManager.getCurrentVehicleRecord(cam_id);
		}

		if (vr == null && !advancePay) {
			// TODO
			// 从出入口获取相机上报缓存数据，如果没有缓存数据，反馈前台没有车牌结果。
			return new Result(false, "没有识别到车牌", "没有识别到车牌，" + cam_id);
		}
		if (!advancePay) {
			plate_num = vr.getMsgBody().getString("plate_num");
		}
		if (plate_num == null || "".equals(plate_num) || "null".equals(plate_num)) {
			return new Result(false, "没有识别到车牌", "没有识别到车牌，" + cam_id + "," + plate_num);
		}
		// 根据车牌提取订单数据。如果没有找到订单，进入无订单流程。
		String sql = "SELECT * FROM user_order where license_plate=? and parking_lot_id=? and (order_status='车辆入场' ) order by create_time desc";
		List<Map<String, Object>> orderResult = executeSQL(sql, plate_num, parking_lot_info_id);

		if (advancePay && (orderResult == null || orderResult.isEmpty())) {
			return new Result(false, "没有订单", "没有订单，" + plate_num);
		}
		if (!advancePay && (orderResult == null || orderResult.isEmpty())) {
			// 如果没有找到订单，进入无订单流程。
			return handleNoOrder(order_source, false, parking_lot_info_id, cam_id, plate_num, vr);
		}
		// 如果有订单，计算费用，将费用和支付url，返回给页面。
		Map<String, Object> orderInfo = orderResult.get(0);

		String order_status = (String) orderInfo.get("order_status");
		if (OrderStatusConstant.exception.equals(order_status)) {
			return new Result(true, "异常订单", orderInfo);
		}
		// if(advancePay) {
		String license_type = (String) orderInfo.get("license_type");
		boolean newEnergy = "绿牌".equals(license_type) || "黄绿".equals(license_type);
		boolean white = "白牌".equals(license_type);
		
		//车场名称 -停车费-车牌号
		String goodsDesc="-停车费-"+plate_num;
		{
			String sqlparking = "SELECT * FROM parking_lot_info where id=?";
			List<Map<String, Object>> parkingInfo = executeSQL(sqlparking, parking_lot_info_id);
			if(!parkingInfo.isEmpty()) {
				String parking_lot_name=(String)parkingInfo.get(0).get("parking_lot_name");
				if(parking_lot_name!=null) {
					goodsDesc=parking_lot_name+goodsDesc;
				}
			}
		}
		return generatePaymentInfoResult(advancePay, orderInfo, parking_lot_info_id, plate_num, newEnergy, white,
				payClient, clientIP, buyerLogonId,subOpenId,goodsDesc);
		// }else {
		// Integer plate_type = vr.getMsgBody().getInteger("plate_type");
		// String platetype = WsJsonUtil.mapPlateType(plate_type);
		// boolean newEnergy = "绿牌".equals(platetype);
		// boolean white = "白牌".equals(platetype);
		// return
		// generatePaymentInfoResult(advancePay,orderInfo,parking_lot_info_id,plate_num,newEnergy,white,payChannel,clientIP);
		// }
	}

	private Result generatePaymentInfoResult(boolean advancePay, Map<String, Object> orderInfo,
			Integer parking_lot_info_id, String plate_num, boolean newEnergy, boolean white, String payClient,
			String clientIP, String buyerLogonId,String subOpenId,String goodsSecription) {
		try {
			Date now = new Date();
			String order_code = (String) orderInfo.get("order_code");
			// BigDecimal order_amount = (BigDecimal) orderInfo.get("order_amount");
			Integer id = Integer.parseInt(orderInfo.get("id").toString());
			OrderMoneyBo omb = moneyCaculateService.caculateBilllingMoney(plate_num, parking_lot_info_id, newEnergy,
					white, now);
			/**
			 * 支付渠道
			 */
			String pay_channel = advancePay ? OrderPaymentChannelConstant.onlineAdvance
					: OrderPaymentChannelConstant.online;
			parkingordersService._settlementOrder(id, advancePay, pay_channel, now, orderInfo, omb);
			// JSONObject moneyandUrl = new JSONObject();
			// moneyandUrl.put("amount", omb.getMoney());
			// String pay_url = generatePayUrl(payChannel);
			// ,String orderId,String ip,BigDecimal money
			BigDecimal money = omb.getMoney();
			if (BigDecimal.ZERO.equals(money)) {
				money = BigDecimal.valueOf(1);
			}
			// TODO test
			if (isPaymentTest) {
				money = BigDecimal.valueOf(0.01);
			}
			return generatePayResult(payClient, order_code, clientIP, money, buyerLogonId,subOpenId,goodsSecription);
		} catch (Exception e) {
			log.warn(e.toString(), e);
			return new Result(false, "订单计算出错", e.toString());
		}
	}

	/**
	 * 
	 * @param createByCam
	 *            是否由道闸创建
	 * @param parking_lot_id
	 * @param cam_id
	 * @param licensePlate
	 * @param vr
	 * @return
	 */
	public Result handleNoOrder(String order_source, boolean createByCam, int parking_lot_id, String cam_id,
			String licensePlate, VehicleRecord vr) {
		// TODO 生成异常订单。
		// 异常订单是使用订单表
		String license_plate_type = "蓝牌";
		if (vr != null) {
			JSONObject jsonObj = JSONObject.parseObject(vr.getBodyStr());
			Integer plate_type = (Integer) jsonObj.getInteger("plate_type");
			String plate_color = (String) jsonObj.getString("plate_color");
			license_plate_type = WsJsonUtil.mapPlateType(plate_color, plate_type);
		}
		List<Map<String, Object>> yardlist = executeSQL("select * from parking_lot_info where id=?", parking_lot_id);
		String parking_lot_name = (String) yardlist.get(0).get("parking_lot_name");
		List<Map<String, Object>> camList = executeSQL("select * from barrier_gate_equipment where cam_id=?", cam_id);
		String channels = null;
		if (!camList.isEmpty()) {
			// return new Result(false, "没有找到道闸设备", "没有找到道闸设备");
			log.warn("没有找到道闸设备:{}", licensePlate);
			channels = (String) camList.get(0).get("channels");
		}
		////////////////////////////运营规则
		List<Map<String, Object>> operation_rulesList = executeSQL(
				"select * from operation_rules where parking_lot_id=?", parking_lot_id);
		String remark="无驶入车";
		if (operation_rulesList != null &&! operation_rulesList.isEmpty()) {
			String abnormal_handling_duplicate = (String) operation_rulesList.get(0).get("abnormal_handling_no_in_car");
			if(abnormal_handling_duplicate!=null) {
				remark=OrderRemarkConstant.noInYardRecord;
			}
		}
		// TODO 处理通知
		String createUsername = sdkOfGetCurrentUserName();
		String orderCode = OrderCodeUtil.generateOrderCode(licensePlate);
		Date now = new Date();
		Object parking_lot = null;
		List<Map<String, Object>> list = executeSQL("select * from parking_lot_info where id=?", parking_lot_id);
		if (list != null && !list.isEmpty()) {
			parking_lot = list.get(0).get("parking_lot_name");
		}
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO user_order (order_type,order_source,order_code, license_plate,license_type, order_status,payment_status,operation,parking_lot,parking_lot_id ,exit_time,remark, create_username, create_time) VALUES (?,?,?,?, ?, ?,?,?,?, ?, ?, ?, ?,?)");
		List<Object> params = new ArrayList<>();
		params.add("临停");
		params.add(order_source);
		params.add(orderCode);
		params.add(licensePlate);
		params.add(license_plate_type);
		params.add(OrderStatusConstant.exception);
		params.add(null);//OrderPaymentStatusConstant.waitpay);
		params.add("创建异常订单");
		params.add(parking_lot);
		params.add(parking_lot_id);
		params.add(now);
		params.add(remark);
		params.add(createUsername);
		params.add(now);
		
		// 执行SQL插入语句
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		StringBuilder maxIdSql = new StringBuilder("select max(id) as id from user_order");
		List<Map<String, Object>> li = executeSQL(maxIdSql.toString(), null);
		Integer orderId = (Integer) li.get(0).get("id");
		JSONObject json = new JSONObject();
		json.put("order_code", orderCode);

		{
			// 插入停车记录

			// String license_plate_type=(String)paramMap.get("license_plate_type");
			// Object entry_name=(Object) paramMap.get("entry_name");

			StringBuilder sql = new StringBuilder(
					"insert into vehicle_entry_exit_record (last_exit_time,last_parking_lot,license_plate_number,license_plate_type,exit_name,contact,berth_number ,create_username,create_time,update_username,update_time,parking_lot_info_id,user_order_id,exit_picture) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			List<Object> paramsVEER = new ArrayList<>();
			paramsVEER.add(now);
			paramsVEER.add(parking_lot);
			paramsVEER.add(licensePlate);
			paramsVEER.add(license_plate_type);
			paramsVEER.add(channels);
			paramsVEER.add("");
			paramsVEER.add((new Random()).nextInt(32));
			paramsVEER.add(createUsername);
			paramsVEER.add(now);
			paramsVEER.add(createUsername);
			paramsVEER.add(now);
			paramsVEER.add(parking_lot_id);
			paramsVEER.add(orderId);
			String full_pic_path = vr.getMsgBody().getString("full_pic_path");
			paramsVEER.add(full_pic_path);
			executeSQL(sql.toString(), paramsVEER.toArray());
		}
		
		saveOrderOperationRecord(orderId, 1, createUsername, "创建订单", "创建异常订单:" + orderCode, "创建异常订单:" + orderCode,
				"创建异常订单:" + orderCode + ",车牌：" + licensePlate, new Date());
		log.info("创建异常订单：{},{}", licensePlate, parking_lot_id);
		return new Result(false, "异常订单", json);
	}

	/*
	 * private String generatePayUrl(String payChannel) { if
	 * (isZhifubao(payChannel)) { return PayUrlConsant.getServpayURL(isPaymentTest);
	 * } else { return PayUrlConsant.getOnlinepayURL(isPaymentTest); } }
	 */

	/**
	 * 获取支付相关信息
	 * @author XueZhongHao
	 * @date 2024/12/31
	 * @param payClient 		支付类型
	 * @param orderId 			订单order_code
	 * @param ip 				ip
	 * @param money 			金额
	 * @param buyerLogonId 		支付宝信息（没有用）
	 * @param subOpenId 		微信信息
	 * @param goodsSecription 	商品描述
	 * @return com.gemcoder.system.bo.Result
	 **/
	public Result generatePayResult(String payClient, String orderId, String ip, BigDecimal money, String buyerLogonId,String subOpenId,String goodsSecription)
			throws Exception {
		if (isZhifubao(payClient)) {
			// TODO支付宝
			return generateZhifubaoNativeResult(orderId, ip, money, buyerLogonId,goodsSecription);
			// return generateZhifubaoResult(orderId, ip, money,buyerLogonId);
		} else {
			// 微信
			return generateWeixinPayResult(orderId, ip, money,subOpenId,goodsSecription);
		}
	}


	public Result getPayResultBy(Result res){
		if (!res.isFlag()) {
			return res;
		}
		JSONObject data = (JSONObject) res.getData();
		String pay_url = (String) data.get("pay_url");
		String timestamp = (String) data.get("timestamp");
		String apisign = (String) data.get("apisign");
		String signResult = (String) data.get("params");

		Map<String, String> apiHeader = new HashMap<>();
		apiHeader.put("appid", appid);
		apiHeader.put("timestamp", timestamp);
		apiHeader.put("apisign", apisign);
		Map response = postForEntity(pay_url, signResult, apiHeader);
		Result rst = new Result(true, "调用完成", response);
		return rst;
	}

	/**
	 * 支付宝native
	 * 
	 * @param orderId
	 * @param clientIp
	 * @param money
	 * @param buyerLogonId
	 * @return
	 * @throws Exception
	 */
	private Result generateZhifubaoNativeResult(String orderId, String clientIp, BigDecimal money, String buyerLogonId,String goodsSecription)
			throws Exception {
		int txnAmt = (int) (money.doubleValue() * 100);
		String signResult = signZhifubaoNativeMethod(orderId, clientIp, Integer.toString(txnAmt), buyerLogonId,goodsSecription);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> signResultMap = mapper.readValue(signResult, Map.class);
		String timestamp = "" + System.currentTimeMillis() / 1000;
		// 组apiSign加密Map
		Map<String, String> apiSign = new TreeMap<>();
		apiSign.put("appid", appid);
		apiSign.put("secret", appSecret);
		apiSign.put("sign", signResultMap.get("sign"));
		apiSign.put("timestamp", timestamp);

		// MD5加密
		String MD5Content = CMBSignatureUtil.getSignContent(apiSign);
		String apiSignString = CMBMD5Utils.getMD5Content(MD5Content).toLowerCase();

		JSONObject data = new JSONObject();
		data.put("pay_url", CMBPayUrlConsant.getNativeURL(isPaymentTest));
		data.put("params", signResult);
		data.put("timestamp", timestamp);
		data.put("apisign", apiSignString);
		Result r = new Result(true, "支付地址信息", data);
		return r;

	}

	/*
	 * private Result generateZhifubaoFuwuchuangResult(String orderId, String
	 * clientIp, BigDecimal money, String buyerLogonId) throws Exception { int
	 * txnAmt = (int) (money.doubleValue() * 100); String signResult =
	 * signZhifubaoMethod(orderId, clientIp, Integer.toString(txnAmt),
	 * buyerLogonId); ObjectMapper mapper = new ObjectMapper(); Map<String, String>
	 * signResultMap = mapper.readValue(signResult, Map.class); String timestamp =
	 * "" + System.currentTimeMillis() / 1000; // 组apiSign加密Map Map<String, String>
	 * apiSign = new TreeMap<>(); apiSign.put("appid", appid); apiSign.put("secret",
	 * appSecret); apiSign.put("sign", signResultMap.get("sign"));
	 * apiSign.put("timestamp", timestamp);
	 * 
	 * // MD5加密 String MD5Content = CMBSignatureUtil.getSignContent(apiSign); String
	 * apiSignString = CMBMD5Utils.getMD5Content(MD5Content).toLowerCase();
	 * 
	 * JSONObject data = new JSONObject(); data.put("pay_url",
	 * CMBPayUrlConsant.getServpayURL(isPaymentTest)); data.put("params",
	 * signResult); data.put("timestamp", timestamp); data.put("apisign",
	 * apiSignString); Result r = new Result(true, "支付地址信息", data); return r;
	 * 
	 * }
	 */

	private Result generateWeixinPayResult(String orderId, String clientIp, BigDecimal money,String subOpenId,String goodsSecription) throws Exception {
		int txnAmt = (int) (money.doubleValue() * 100);
		String signResult = signWeixinMethod(orderId, clientIp, Integer.toString(txnAmt),subOpenId,goodsSecription);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> signResultMap = mapper.readValue(signResult, Map.class);
		String timestamp = "" + System.currentTimeMillis() / 1000;

		// 组apiSign加密Map
		Map<String, String> apiSign = new TreeMap<>();
		apiSign.put("appid", appid);
		apiSign.put("secret", appSecret);
		apiSign.put("sign", signResultMap.get("sign"));
		apiSign.put("timestamp", timestamp);

		// MD5加密
		String MD5Content = CMBSignatureUtil.getSignContent(apiSign);
		String apiSignString = CMBMD5Utils.getMD5Content(MD5Content).toLowerCase();
		JSONObject data = new JSONObject();
		data.put("pay_url", CMBPayUrlConsant.getOnlinepayURL(isPaymentTest));
		data.put("params", signResult);
		data.put("timestamp", timestamp);
		data.put("apisign", apiSignString);
		Result r = new Result(true, "支付地址信息", data);
		return r;
	}

	private String signZhifubaoMethod(String orderId, String clientIp, String money, String buyerLogonId)
			throws Exception {
		// 支付回调地址从配置 payment.notify.url 注入，勿硬编码

		Map<String, String> requestPublicParams = new TreeMap<>();
		String requestStr = null;
		// 公共请求参数
		requestPublicParams.put("version", "0.0.1"); // 版本号，固定为0.0.1(必传字段)
		requestPublicParams.put("encoding", "UTF-8"); // 编码方式，固定为UTF-8(必传)
		requestPublicParams.put("signMethod", "01"); // 签名方法，固定为01，表示签名方式为RSA2(必传)
		// 业务要素
		Map<String, String> requestTransactionParams = new HashMap<>();
		requestTransactionParams.put("merId", paymentMemerBerId); // 商户号(必传)
		requestTransactionParams.put("orderId", orderId); // 商户订单号(必传)
		requestTransactionParams.put("userId", paymentCashier); // 收银员
		requestTransactionParams.put("notifyUrl", paymentNotifyURL); // 交易通知地址(必传)
		requestTransactionParams.put("txnAmt", money); // 交易金额,单位为分(必传)
		requestTransactionParams.put("currencyCode", "156"); // 交易币种，默认156，目前只支持人民币（156）
		requestTransactionParams.put("buyerLogonId", buyerLogonId);// "1234567890@qq.com");
																	// //买家支付宝帐号（非必传，但buyerLogonId和buyerId不能同时为空）
		// requestTransactionParams.put("buyerId", "2088522115115513");
		// //买家支付宝用户ID（非必传，但buyerLogonId和buyerId不能同时为空）
		ObjectMapper mapper = new ObjectMapper();
		requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));

		log.info("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));
		// 私钥
		String privateKey = CMBPaySecretKeyConstant.PRIVATE_KEY;
		// 对待加签内容进行排序拼接
		String signContent = CMBSignatureUtil.getSignContent(requestPublicParams);
		// 加签
		requestPublicParams.put("sign", SM2Util.sm2Sign(signContent, privateKey));
		// requestPublicParams.put("sign", CMBSignatureUtil.rsaSign(signContent,
		// privateKey, "UTF-8"));
		requestStr = mapper.writeValueAsString(requestPublicParams);
		log.info("加签后的报文内容：" + requestStr);
		return requestStr;
	}

	private String signZhifubaoNativeMethod(String orderId, String clientIp, String money, String buyerLogonId,String goodsSecription)
			throws Exception {
		Map<String, String> requestPublicParams = new TreeMap<>();

		// 支付回调地址从配置 payment.notify.url 注入，勿硬编码
		String requestStr = null;
		// 公共请求参数
		requestPublicParams.put("version", "0.0.1"); // 版本号，固定为0.0.1(必传字段)
		requestPublicParams.put("encoding", "UTF-8"); // 编码方式，固定为UTF-8(必传)
		// TODO 是01 还是02
		requestPublicParams.put("signMethod", "02"); // 签名方法，固定为01，表示签名方式为RSA2(必传)
		// 业务要素
		Map<String, String> requestTransactionParams = new HashMap<>();
		requestTransactionParams.put("merId", paymentMemerBerId); // 商户号(必传)
		requestTransactionParams.put("orderId", orderId); // 商户订单号(必传)
		// requestTransactionParams.put("userId", paymentCashier); //收银员
		// requestTransactionParams.put("timeoutExpress", NULL); //支付有效时间
		// requestTransactionParams.put("qrCodeTimeoutExpress", NULL); //二维码有效时间
		requestTransactionParams.put("notifyUrl", paymentNotifyURL); // 交易通知地址(必传)
		requestTransactionParams.put("txnAmt", money); // 交易金额,单位为分(必传)
		requestTransactionParams.put("body", goodsSecription==null?"停车费用":goodsSecription); // 商品描述
		requestTransactionParams.put("currencyCode", "156"); // 交易币种，默认156，目前只支持人民币（156）
		// requestTransactionParams.put("buyerLogonId",buyerLogonId);//
		// "1234567890@qq.com"); //买家支付宝帐号（非必传，但buyerLogonId和buyerId不能同时为空）
		// requestTransactionParams.put("buyerId", "2088522115115513");
		// //买家支付宝用户ID（非必传，但buyerLogonId和buyerId不能同时为空）
		ObjectMapper mapper = new ObjectMapper();
		requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));

		log.info("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));
		// 私钥
		String privateKey = CMBPaySecretKeyConstant.PRIVATE_KEY;
		// 对待加签内容进行排序拼接
		String signContent = CMBSignatureUtil.getSignContent(requestPublicParams);
		// 加签
		requestPublicParams.put("sign", SM2Util.sm2Sign(signContent, privateKey));
		// requestPublicParams.put("sign", CMBSignatureUtil.rsaSign(signContent,
		// privateKey, "UTF-8"));
		requestStr = mapper.writeValueAsString(requestPublicParams);
		log.info("加签后的报文内容：" + requestStr);
		return requestStr;
	}

	private String signWeixinMethod(String orderId, String clientIp, String money,String subOpenId,String goodsSecription) throws Exception {
		// 支付回调地址从配置 payment.notify.url 注入，勿硬编码
		Map<String, String> requestPublicParams = new TreeMap<>();
		String requestStr = null;
		// 公共请求参数
		requestPublicParams.put("version", "0.0.1"); // 版本号，固定为0.0.1(必传字段)
		requestPublicParams.put("encoding", "UTF-8"); // 编码方式，固定为UTF-8(必传)
		requestPublicParams.put("signMethod", "02"); // 签名方法，固定为01，表示签名方式为RSA2(必传)
		// 业务要素
		Map<String, String> requestTransactionParams = new HashMap<>();
		requestTransactionParams.put("merId", paymentMemerBerId); // 商户号(必传)
		// requestTransactionParams.put("deviceInfo", "WEB"); // 设备号
		requestTransactionParams.put("subAppId", wexinAppid); // 子公众帐号ID（必传）
		requestTransactionParams.put("subOpenId",subOpenId);// wexinAppid); // 子公众帐号ID（必传）
		requestTransactionParams.put("orderId", orderId); // 商户订单号(必传)
		requestTransactionParams.put("tradeType", "JSAPI"); // 交易类型 APP/MWEB/JSAPI（必传）
		// requestTransactionParams.put("payValidTime", "1200"); //支付有效时间
		requestTransactionParams.put("tradeScene", "OFFLINE"); // 交易场景
		// userId :APP支付：需传入应用市场上的APP名字-实际商品名称，如 “天天爱消除-游戏充值”
		requestTransactionParams.put("userId", paymentCashier); // 收银员(必传)
		requestTransactionParams.put("body", goodsSecription==null?"停车费用":goodsSecription);//"停车场应用-停车费"); // 商品描述（必传）
		requestTransactionParams.put("notifyUrl", paymentNotifyURL); // 交易通知地址（必传）
		requestTransactionParams.put("txnAmt", money); // 交易金额，单位为分（必传）
		requestTransactionParams.put("currencyCode", "156"); // 交易币种，默认156，目前只支持人民币（156）
		requestTransactionParams.put("spbillCreateIp", clientIp); // 终端IP（必传）
		// TODO 需要传吗
		// requestTransactionParams.put("sceneInfo", "{\"store_info\" : {\"id\":
		// \"SZTX001\",\"name\": \"腾大餐厅\",\"area_code\": \"440305\",\"address\":
		// \"科技园中一路腾讯大厦\" }}"); //场景信息，H5支付时必传
		ObjectMapper mapper = new ObjectMapper();
		requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));
		log.info("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));
		// 私钥
		String privateKey = CMBPaySecretKeyConstant.PRIVATE_KEY;
		// 对待加签内容进行排序拼接
		String signContent = CMBSignatureUtil.getSignContent(requestPublicParams);
		// 加签
		requestPublicParams.put("sign", SM2Util.sm2Sign(signContent, privateKey));
		// requestPublicParams.put("sign", CMBSignatureUtil.rsaSign(signContent,
		// privateKey, "UTF-8"));
		requestStr = mapper.writeValueAsString(requestPublicParams);
		log.info("加签后的报文内容：" + requestStr);
		return requestStr;

	}

	private boolean isZhifubao(String payClientType) {
		if (payClientType != null && ("支付宝".equals(payClientType.trim()) || "zhifubao".equals(payClientType.trim()))) {
			return true;
		}
		return false;
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

	public static Map postForEntity(String url, String requestBody, Map<String, String> apiHeader) {
		RestTemplate client = new RestTemplate();
		client.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = new HttpHeaders();

		// 以json的方式提交
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("appid", apiHeader.get("appid"));
		headers.add("timestamp", apiHeader.get("timestamp"));
		headers.add("apisign", apiHeader.get("apisign"));

		// 将请求头部和参数合成一个请求
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		// 执行HTTP请求
		// Map<String,String> response=
		// client.postForEntity(url,requestEntity,Map.class).getBody();
		Map<String, Object> response = client.postForEntity(url, requestEntity, Map.class).getBody();
		//
		if (response != null) {
			JSONObject jo = new JSONObject();
			response.forEach((k, v) -> {
				jo.put(k, v);
			});
			log.info(jo.toJSONString());
		} else {
			log.warn("postForEntity 返回结果为空");
		}
		return response;
	}
	/*
	 * StringBuilder params = new StringBuilder();
	 * params.append("version").append("=").append("0.0.1").append("&");
	 * params.append("encoding").append("=").append("UTF-8").append("&");
	 * params.append("signMethod").append("=").append("01").append("&");
	 * params.append("merId").append("=").append(paymentMemerBerId).append("&");
	 * params.append("deviceInfo").append("=").append("WEB").append("&");
	 * params.append("subAppId").append("=").append(wexinAppid).append("&");
	 * params.append("orderId").append("=").append(orderId).append("&");
	 * params.append("tradeType").append("=").append("APP").append("&");
	 * params.append("tradeScene").append("=").append("OFFLINE").append("&");
	 * params.append("userId").append("=").append(paymentCashier).append("&");
	 * params.append("body").append("=").append("停车场应用-停车费").append("&");
	 * params.append("notifyUrl").append("=").append(paymentNotifyURL).append("&");
	 * params.append("txnAmt").append("=").append(txnAmt).append("&");
	 * params.append("spbillCreateIp").append("=").append(ip).append("&");
	 * 
	 * JSONObject sceneInfo = new JSONObject(); JSONObject h5_info = new
	 * JSONObject(); h5_info.put("type", ""); h5_info.put("app_name", "停车场");
	 * h5_info.put("package_name", "com.gemcoder.system"); sceneInfo.put("h5_info",
	 * h5_info);
	 * params.append("sceneInfo").append("=").append(sceneInfo.toJSONString()).
	 * append("&"); return params.toString();
	 */
	/*
	 * public void main(String[] args) { BigDecimal bg=new BigDecimal(1);
	 * Integer.toString(bg.); }
	 */

	public String getAppid() {
		// TODO Auto-generated method stub
		return wexinAppid;
	}

	public String getAppsecret() {
		return wexinSecret;
	}
}
