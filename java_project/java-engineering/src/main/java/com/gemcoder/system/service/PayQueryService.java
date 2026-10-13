package com.gemcoder.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.CMBMD5Utils;
import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.SM2Util;
import com.gemcoder.system.util.CMBPaySecretKeyConstant;
import com.gemcoder.system.util.CMBPayUrlConsant;
import com.gemcoder.system.util.CMBSignatureUtil;
import com.gemcoder.system.util.CMBUtils;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.GlobalMessageCacheManager;
import com.gemcoder.system.ws.VehicleRecord;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
/*
 * 支付主动查询,和notify对应
 */
@Service
public class PayQueryService {
	
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
	 * 支付回调地址（请在 application.yml 中配置）
	 */
	@Value("${payment.notify.url:}")
	private String paymentNotifyURL;

	/**
	 * 商户微信公众号appid（请在 application.yml 中配置）
	 */
	@Value("${wexin.appid:}")
	private String wexinAppid;

	@Value("${app.id:}")
	private String appid;

	@Value("${app.secret:}")
	private String appSecret;
	
	
	@Resource
	BusinesslogicService businesslogicService;
	@Resource
	ParkingordersService parkingordersService;
	@Resource
	CommandService commandService;
	GlobalMessageCacheManager globalMessageCacheManager = GlobalMessageCacheManager.getInstance();
	private static final Logger log = LoggerFactory.getLogger(PayQueryService.class);
	public boolean queryPayStatusByOrderId(int orderId) {
		List<Map<String,Object>>  list=executeSQL("select * from user_order where id=?",orderId);
		if(list==null||list.isEmpty()) {
			log.warn("订单不存在："+orderId);
			return false;
		}
		String payment_status=(String)list.get(0).get("payment_status");
		if(OrderPaymentStatusConstant.payed.equals(payment_status)) {
			log.warn("订单已经支付："+orderId);
			return false;
		}
		if(OrderPaymentStatusConstant.refund.equals(payment_status)) {
			log.warn("订单已经退款："+orderId);
			return false;
		}
		String order_code=(String)list.get(0).get("order_code");
		try {
			return queryPayComplete(order_code,list.get(0));
		} catch (Exception e) {
			log.warn(e.toString(),e);
			return false;
		}
	}
	private boolean queryPayComplete(String order_code,Map<String,Object> userOrder) throws Exception {
		String signResult = signStr(order_code);
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
		
		
		Map<String, String> apiHeader = new HashMap<>();
        apiHeader.put("appid", appid);
        apiHeader.put("timestamp", timestamp);
        apiHeader.put("apisign", apiSignString);

        // 发送HTTP post请求
       String url= CMBPayUrlConsant.getOrderqueryURL(isPaymentTest);
        Map<String,String> response = CMBUtils.postForEntity(url, signResult, apiHeader);
        String responseStr=mapper.writeValueAsString(response);
        log.info(responseStr);
        // 返回结果验签
       // Boolean checkResult1 = checkSign(responseStr);
        //if(!checkResult1){
        //    return false;
        //}

        String returnCode = response.get("returnCode");
        log.info("返回结果：" + returnCode);
        
        if (!"SUCCESS".equalsIgnoreCase(returnCode)) {
			// SUCCESS/FAIL
			return false;
		}
        String respCode = response.get("respCode");
		if (!"SUCCESS".equalsIgnoreCase(respCode)) {
			// 招行返回的业务错误码，成功为SUCCESS，失败为FAIL，
			// 若此时errCode为SYSTERM_ERROR则表示本次请求处理异常，并非交易结果是失败状态，需要商户再次发起查询确认
			String errCode = response.get("errCode");
			if ("SYSTERM_ERROR".equalsIgnoreCase(errCode)) {
				// TODO 发起查询确认
			}
			return false;
		}
        
		
		String payment_channel = (String) userOrder.get("payment_channel");
		Date exitTime = null;
		boolean openBarrier = false;
		String payment_status = OrderPaymentStatusConstant.payed;
		String order_status = OrderStatusConstant.complete;
		// String payment_channel=OrderPaymentChannelConstant.online;
		if (payment_channel != null && payment_channel.contains("提前交费")) {
			order_status = OrderStatusConstant.waitLeft;
		} else {
			exitTime = new Date();
			openBarrier = true;
		}
		
		
		String money = response.get("txnAmt");
		String license_plate = (String) userOrder.get("license_plate");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paymentAmount", (Integer.parseInt(money) + 0.0d) / 100.0d);
		paramMap.put("licensePlate", userOrder.get("license_plate"));
		paramMap.put("payment_status", payment_status);
		paramMap.put("order_status", order_status);
		paramMap.put("payment_channel", payment_channel);
		paramMap.put("operation", "完成支付");
		paramMap.put("exitTime", exitTime);
		paramMap.put("id", userOrder.get("id"));
		businesslogicService.updatePaymentStatus(paramMap);
		
		String content="支付完成。金额：" + money;
		saveOrderOperationRecord(Integer.parseInt(userOrder.get("id").toString()), 1, "system", "支付完成查询", "支付完成查询:金额" + money, content,
				content, new Date());
		
		if (openBarrier) {
			// 查找 vr
			String camId = globalMessageCacheManager.findCameraBarrier(license_plate);
			if (camId == null) {
				log.warn("没有找到车辆对应的相机，{}", license_plate);
				return true;
			}
			VehicleRecord vr = globalMessageCacheManager.getCurrentVehicleRecord(camId);
			if (vr == null) {
				log.warn("没有找到车辆对应的相机记录，{},{}", license_plate, camId);
				return true;
			}
			// 发送开闸命令
			commandService.openBarier(vr, true);
			parkingordersService.updateLiftTime(userOrder.get("id"));
		}
		
		return true;

	}
	private String signStr(String order_code) throws Exception {
		
		Map<String, String> requestPublicParams = new TreeMap<>();
        String requestStr = null;
            //公共请求参数
            requestPublicParams.put("version", "0.0.1");    //版本号，固定为0.0.1(必传字段)
            requestPublicParams.put("encoding", "UTF-8");   //编码方式，固定为UTF-8(必传)
            requestPublicParams.put("signMethod", "02");    //签名方法，固定为01，表示签名方式为RSA2(必传)
            //业务要素
            Map<String, String> requestTransactionParams = new HashMap<>();
            requestTransactionParams.put("merId",paymentMemerBerId);   //商户号(必传)
            requestTransactionParams.put("orderId",order_code); //商户订单号(必传)
            requestTransactionParams.put("userId", paymentCashier);   //收银员
            ObjectMapper mapper = new ObjectMapper();
            requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));

            log.info("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));
            //私钥
            String privateKey =CMBPaySecretKeyConstant.PRIVATE_KEY;
            //对待加签内容进行排序拼接
            String signContent= CMBSignatureUtil.getSignContent(requestPublicParams);
            //加签
           // requestPublicParams.put("sign", CMBSignatureUtil.rsaSign(signContent, privateKey, "UTF-8"));
            requestPublicParams.put("sign",  SM2Util.sm2Sign(signContent, privateKey));
            requestStr = mapper.writeValueAsString(requestPublicParams);
            log.info("加签后的报文内容：" + requestStr);
            return requestStr;
            
	}
    private static Boolean checkSign(String string){
       // System.out.println("要验签的报文内容：" + string);
        try {
            //公钥
            String publicKey = CMBPaySecretKeyConstant.PUBLIC_KEY;
            //验签
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> responseBodyMap = objectMapper.readValue(string, Map.class);
            String sign = responseBodyMap.remove("sign");
            String contentStr = CMBSignatureUtil.getSignContent(responseBodyMap);
           // boolean result = CMBSignatureUtil.rsaCheck(contentStr, sign, publicKey, "UTF-8");
            boolean result = SM2Util.sm2Check(contentStr, sign, publicKey);

            if (result) {
               log.info("报文验签成功!");
            } else {
            	log.info("报文验签失败!");
            }
            return result;
        }catch (Exception e){
        	log.warn(e.toString(),e);
            return false;
        }
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
}
