package com.gemcoder.system.service;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.CMBPayUrlConsant;
import com.gemcoder.system.util.OrderSourceConstants;
@SpringBootTest
public class ScanYardCodeServiceTest {
	@Resource
	ScanYardCodeService scanYardCodeService;
	@Test
	public void test() {
		//Result r=scanYardCodeService.outYard(OrderSourceConstants.scanCode, 3, null, true, "DMF5TV7",null, "127.0.0.1",null);
		 Result r=scanYardCodeService.outYard(OrderSourceConstants.scanCode, 3, null, true, "0YR3B6H", "支付宝", "127.0.0.1","test@example.com",null);
		 
		 System.out.println(r.getData());
		 
		
		 JSONObject data=(JSONObject)r.getData();
		String pay_url=(String)	data.get("pay_url");
		String timestamp=(String)	data.get("timestamp");
		String apisign=(String)	data.get("apisign");
		String signResult=(String)	data.get("params");
 
		 Map<String, String> apiHeader = new HashMap<>();
         apiHeader.put("appid", "8ab74856-8772-45c9-96db-54cb30ab9f74");
         apiHeader.put("timestamp", timestamp);
         apiHeader.put("apisign", apisign);
//data.put("params", signResult);
         // 发送HTTP post请求
         String response = postForEntity(pay_url, signResult, apiHeader);
         
         System.out.println("################");
         System.out.println(response);
	}
	public static String postForEntity(String url,String requestBody, Map<String, String> apiHeader){
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
       // Map<String,String> response= client.postForEntity(url,requestEntity,Map.class).getBody();
        String response= client.postForEntity(url,requestEntity,String.class).getBody();

        return response;
    }
}
