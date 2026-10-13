package com.gemcoder.system.util;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SM2UtilTest {
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		String str="{\"version\":\"0.0.1\",\"encoding\":\"UTF-8\",\"sign\":\"MEUCIQC+ehmOedNZAJJrX02NF5qBGiEnb3dmHYmYb7B8AhZ2PgIgM1ZIjOmBvGJ4xRLgRAp6keAW8WJiEpnUBcmyXnh7Xk4=\",\"signMethod\":\"02\",\"returnCode\":\"SUCCESS\",\"respCode\":\"FAIL\",\"errCode\":\"CMBORDERID_NOT_EXIST\",\"respMsg\":\"平台订单号不存在:PCMBTBG\",\"biz_content\":\"{\\\"merId\\\":\\\"308999172730292\\\",\\\"orderId\\\":\\\"2024120909572088114668\\\"}\"}";
		 ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> responseBodyMap = objectMapper.readValue(str, Map.class);
        String sign = responseBodyMap.remove("sign");
        String contentStr = CMBSignatureUtil.getSignContent(responseBodyMap);
       // boolean result = CMBSignatureUtil.rsaCheck(contentStr, sign, publicKey, "UTF-8");
        boolean result = SM2Util.sm2Check(contentStr, sign, CMBPaySecretKeyConstant.PUBLIC_KEY);
		System.out.println(result);
	}
	//@Test
	public void test2() throws JsonMappingException, JsonProcessingException {
		String str="{\"version\":\"0.0.1\",\"encoding\":\"UTF-8\",\"sign\":\"MEUCIQC+ehmOedNZAJJrX02NF5qBGiEnb3dmHYmYb7B8AhZ2PgIgM1ZIjOmBvGJ4xRLgRAp6keAW8WJiEpnUBcmyXnh7Xk4=\",\"signMethod\":\"02\",\"returnCode\":\"SUCCESS\",\"respCode\":\"FAIL\",\"errCode\":\"CMBORDERID_NOT_EXIST\",\"respMsg\":\"平台订单号不存在:PCMBTBG\",\"biz_content\":\"{\\\"merId\\\":\\\"308999172730292\\\",\\\"orderId\\\":\\\"2024120909572088114668\\\"}\"}";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> responseBodyMap = objectMapper.readValue(str, Map.class);
		String sign = responseBodyMap.remove("sign");
		String contentStr =responseBodyMap.get("biz_content");
		// boolean result = CMBSignatureUtil.rsaCheck(contentStr, sign, publicKey, "UTF-8");
		boolean result = SM2Util.sm2Check(contentStr, sign, CMBPaySecretKeyConstant.PUBLIC_KEY);
		System.out.println(result);
	}
}
