package com.gemcoder.system.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import org.apache.http.HttpResponse;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.MultipartEntityBuilder;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * pyun支付
 * @author jiang
 *
 */
@Service
public class PYunService {
	private static final Logger log = LoggerFactory.getLogger(PYunService.class);
	static final String url="https://api.4pyun.com/gate/1.0/payment/trade/create";
	static final String urltest="http://localhost:8282/gate/1.0/payment/trade/create";
	public void test() {
		Map<String, String> map = new HashMap<>();
		  // app_id平台分配
		  map.put("app_id", "YOUR_PYUN_APP_ID");
		  // 停车场商户号
		  map.put("merchant", "YOUR_PYUN_MERCHANT");
		  // 发起支付订单号同一个app_id下唯一不能重复
		  map.put("pay_order", "11111111111");
		  // 商品名称
		  map.put("subject","停车支付3.00元(川A12345)");
		  // 商品描述
		  map.put("body","【川A12345】在【XXXXX-停车场】于【2021-07-01 00:00:00】支付费0.10元");
		  // 支付金额, 单位分
		  map.put("value","10");
		  // 扫码得到的值
		  map.put("auth_code", "135680596336872323");
		  // 后端支付回调地址
		  map.put("notify_url", "https://a.b.c/notify");
		  StringBuilder builder = new StringBuilder();
		  for (String key : map.keySet() ){
		      builder.append(key + "=" + map.get(key) + "&");
		  }
		  String appSecret = "YOUR_PYUN_APP_SECRET";
		  String encriptStr = builder.toString() + "app_secret=" + appSecret;
		  System.out.println(encriptStr);
		  String sign = DigestUtils.md5Hex(encriptStr);  
		  String keyStr = builder.toString() + "sign=" + sign;
		  System.out.println(keyStr);
		  try (CloseableHttpClient httpClient = HttpClients.createDefault()) { 
			  HttpPost post = new HttpPost(urltest);
			  StringEntity entity=new StringEntity(keyStr, ContentType.TEXT_PLAIN);
			  post.setEntity(entity);  
			  
			  try (CloseableHttpResponse response = httpClient.execute(post)) {  
		            System.out.println(response.getStatusLine());  
		            String text = EntityUtils.toString(response.getEntity(), "utf-8");  
		           // System.out.println(text);  
		            log.info(text);
		        }  
		  }catch(Exception e) {
			  log.error(e.toString(),e);
		  }
	}
	/**
	 * 发起交易预请求
	 */
	public void tradePrepare() {
		final String url ="https://api.4pyun.com/gate/1.0/payment/trade/prepare";
		Map<String, String> map = new HashMap<>();
		  // app_id平台分配
		  map.put("app_id", "YOUR_PYUN_APP_ID");
		  // 停车场商户号
		  map.put("merchant", "YOUR_PYUN_MERCHANT");
		  // 发起支付订单号同一个app_id下唯一不能重复
		  map.put("pay_order", "11111111118");
		  // 商品名称
		  map.put("subject","停车支付3.00元(川A12345)");
		  // 商品描述
		  map.put("body","【川A12345】在【XXXXX-停车场】于【2021-07-01 00:00:00】支付费1.00元");
		  // 支付金额, 单位分
		  map.put("value","10");
		  // 支付成功返回前端页面
		  map.put("callback_url", "https://a.b.c/backurl");
		  // 后端支付回调地址
		  map.put("notify_url", "https://a.b.c/notify");
		  Map<String, String> extraMap = new HashMap<>();
		  extraMap.put("plate", "川AA37K2");
		  extraMap.put("plate_color", "-1");
		  extraMap.put("parking_serial", "01009970545516206225805859659");
		  extraMap.put("park_name", "P云支付体验-停车场");
		  extraMap.put("enter_time", "1620621689000");
		  extraMap.put("parking_time", "175");
		  map.put("extra", JSON.toJSONString(extraMap));
		  StringBuilder builder = new StringBuilder();
		  for (String key : map.keySet()) {
			  builder.append(key + "=" + map.get(key) + "&");
		  }
		  String appSecret = "YOUR_PYUN_APP_SECRET";
		  String encriptStr = builder.toString( )+ "app_secret=" + appSecret;
		  System.out.println(encriptStr);
		  String sign = DigestUtils.md5Hex(encriptStr);  
		  String keyStr = builder.toString() + "sign=" + sign;
		  System.out.println(keyStr);
		  
		  try (CloseableHttpClient httpClient = HttpClients.createDefault()) { 
			  HttpPost post = new HttpPost(url);
			  StringEntity entity=new StringEntity(keyStr, ContentType.TEXT_PLAIN);
			  post.setEntity(entity);  
			  
			  try (CloseableHttpResponse response = httpClient.execute(post)) {  
		            System.out.println(response.getStatusLine());  
		            String text = EntityUtils.toString(response.getEntity(), "utf-8");  
		           // System.out.println(text);  
		            log.info(text);
		        }  
		  }catch(Exception e) {
			  log.error(e.toString(),e);
		  }
	}
	/**
	 * 订单退款
	 */
	public void tradeRefund() {
		final String url="https://api.4pyun.com/gate/1.0/payment/trade/refund";
		String appId = "YOUR_PYUN_APP_ID";
        String appSecret = "YOUR_PYUN_APP_SECRET";

        Map<String, String> paramMap = new HashMap();
        // 应用ID
        paramMap.put("app_id", appId);
        // 退款请求单号
        paramMap.put("order", "R2024032114351106991");
        // 平台支付订单号
        paramMap.put("pay_serial", "20220721143511066066610042");
        // 退款金额
        paramMap.put("value", "1");
        // 退款原因
        paramMap.put("reason", "接口测试退款");
        // 转成Json参数格式
        String jsonStr = JSON.toJSONString(paramMap);
        // 生成待签名参数
        String encryptStr = jsonStr + "&app_secret=" + appSecret;
        //
        System.out.println("encryptStr: " + encryptStr);
        
        String sign = DigestUtils.md5Hex(encryptStr);  
        System.out.println("sign: " + sign);

        
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) { 
			  HttpPost post = new HttpPost(url);
			  post.setHeader("Authorization", sign);
			  StringEntity entity=new StringEntity(jsonStr, ContentType.TEXT_PLAIN);
			  post.setEntity(entity);  
			  
			  try (CloseableHttpResponse response = httpClient.execute(post)) {  
		            System.out.println(response.getStatusLine());  
		            String text = EntityUtils.toString(response.getEntity(), "utf-8");  
		           // System.out.println(text);  
		            log.info(text);
		        }  
		  }catch(Exception e) {
			  log.error(e.toString(),e);
		  }
	}
	public  static void main(String[] args) {
		PYunService p=new PYunService();
		p.test();
	}
}
