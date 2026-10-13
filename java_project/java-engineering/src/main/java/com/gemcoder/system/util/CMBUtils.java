package com.gemcoder.system.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * 招商银行支付工具
 * 
 * @author jiang
 *
 */

public class CMBUtils {

	public static Map<String, String> postForEntity(String url, String requestBody, Map<String, String> apiHeader) {
		RestTemplate client = getRestTemplate();
		client.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = getHttpHeaders();

		// 以json的方式提交
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("appid", apiHeader.get("appid"));
		headers.add("timestamp", apiHeader.get("timestamp"));
		headers.add("apisign", apiHeader.get("apisign"));

		// 将请求头部和参数合成一个请求
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		// 执行HTTP请求
		Map<String, String> response = client.postForEntity(url, requestEntity, Map.class).getBody();

		return response;
	}

	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static HttpHeaders getHttpHeaders() {
		return new HttpHeaders();
	}

}
