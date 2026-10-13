package com.gemcoder.system.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.util.CMBUtils;
import com.gemcoder.system.util.CMBMD5Utils;
import com.gemcoder.system.util.CMBPaySecretKeyConstant;
import com.gemcoder.system.util.CMBSignatureUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
public class PaymentNotifyServiceTest {
	
    //private static final String url = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/onlinepay";

    private static final String appId = "YOUR_CMB_APP_ID";
    private static final String appSecret = "YOUR_CMB_APP_SECRET";
    private static final String notifyUrl = "http://127.0.0.1:9071/PaymentNotify/aggregateNotify";


    public static void main(String[] args){
        // 组装requestBody并加签
        Map<String,String> signResult= pyaResultMethod();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Map<String,String> signResultMap = mapper.readValue(signResult, Map.class);

            // 组apiSign加密Map
           // Map<String,String> apiSign = new TreeMap<>();
            //apiSign.put("appid", appId);
            //apiSign.put("secret", appSecret);
            //apiSign.put("sign", signResultMap.get("sign"));
            //apiSign.put("timestamp", "" + System.currentTimeMillis()/1000);

            // MD5加密
           // String MD5Content = SignatureUtil.getSignContent(apiSign);
           // String apiSignString = MD5Utils.getMD5Content(MD5Content).toLowerCase();

            // 组request头部Map
           // Map<String, String> apiHeader = new HashMap<>();
           // apiHeader.put("appid", appId);
           // apiHeader.put("apisign", apiSignString);

            // 发送HTTP post请求
            StringBuilder body=new StringBuilder();
            signResult.forEach((k,v)->{
            	body.append(k).append("=").append(v).append("&");
            });
            
            RestTemplate client = new RestTemplate();
    		client.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    		HttpHeaders headers = new HttpHeaders();

    		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    		//headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    		// 将请求头部和参数合成一个请求
    		System.out.println("___________________________");
    		System.out.println(body.toString());
    		HttpEntity<String> requestEntity = new HttpEntity<>(body.toString(), headers);
    		// 执行HTTP请求
    		Map<String, String> response = client.postForEntity(notifyUrl, requestEntity, Map.class).getBody();
    	
            
            
            
            System.out.println("@@@@@@@");
            System.out.println(response.toString());
            // 返回结果验签
            Boolean checkResult1 = checkSign(mapper.writeValueAsString(response));
            if(!checkResult1){
                return;
            }

            String success = response.get("returnCode");
            System.out.println("返回结果：" + success);
        } catch (Exception e) {
        	e.printStackTrace();
            return;
        }

    }

    private static Map<String, String> pyaResultMethod(){
        Map<String, String> requestPublicParams = new TreeMap<>();
        String requestStr = null;
        try {
            //公共请求参数
            requestPublicParams.put("version", "0.0.1");    //版本号，固定为0.0.1(必传字段)
            requestPublicParams.put("encoding", "UTF-8");   //编码方式，固定为UTF-8(必传)
            requestPublicParams.put("signMethod", "01");    //签名方法，固定为01，表示签名方式为RSA2(必传)
            //业务要素
            Map<String, String> requestTransactionParams = new HashMap<>();
            requestTransactionParams.put("merId", "30899917012000T");   //商户号(必传)
            requestTransactionParams.put("deviceInfo", "WEB");   //设备号
            requestTransactionParams.put("orderId", "1562036392778"); //商户订单号(必传)
            requestTransactionParams.put("cmbOrderId", "1234567890"); //商户订单号(必传)
            requestTransactionParams.put("userId", "N002852494");   //收银员(必传)
            requestTransactionParams.put("notifyUrl", notifyUrl); //交易通知地址（必传）
            requestTransactionParams.put("txnAmt", "1"); //交易金额，单位为分（必传）
            requestTransactionParams.put("dscAmt", "0"); //交易金额，单位为分（必传）
            requestTransactionParams.put("currencyCode", "156"); //交易金额，单位为分（必传）
            requestTransactionParams.put("payType", "WX"); //交易金额，单位为分（必传）
            ObjectMapper mapper = new ObjectMapper();
            requestPublicParams.put("biz_content", mapper.writeValueAsString(requestTransactionParams));

            System.out.println("加签前的报文内容：" + mapper.writeValueAsString(requestPublicParams));

            //私钥
            String privateKey =CMBPaySecretKeyConstant.PRIVATE_KEY;
            //对待加签内容进行排序拼接
            String signContent= CMBSignatureUtil.getSignContent(requestPublicParams);
            //加签
            requestPublicParams.put("sign", CMBSignatureUtil.rsaSign(signContent, privateKey, "UTF-8"));

            requestStr = mapper.writeValueAsString(requestPublicParams);

            System.out.println("加签后的报文内容：" + requestStr);
            return requestPublicParams;

        }catch (Exception e){
            System.out.println("加签发生异常！");
            e.printStackTrace();
            return null;
        }
    }

    private static Boolean checkSign(String string){
        System.out.println("要验签的报文内容：" + string);
        try {
            //公钥
            String publicKey =CMBPaySecretKeyConstant.PUBLIC_KEY;
            //验签
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> responseBodyMap = objectMapper.readValue(string, Map.class);
            String sign = responseBodyMap.remove("sign");
            String contentStr = CMBSignatureUtil.getSignContent(responseBodyMap);
            boolean result = CMBSignatureUtil.rsaCheck(contentStr, sign, publicKey, "UTF-8");

            if (result) {
                System.out.println("报文验签成功!");
            } else {
                System.out.println("报文验签失败!");
            }
            return result;
        }catch (Exception e){
            System.out.println("验签发生异常！");
            e.printStackTrace();
            return false;
        }
    }
}
