package com.gemcoder.system.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemcoder.system.service.PaymentNotifyService;

@Controller
@RequestMapping("/PaymentNotify")
public class PaymentNotifyController {
	private static final Logger log = LoggerFactory.getLogger(PaymentNotifyController.class);
	@Resource
	PaymentNotifyService paymentNotifyService;

	

	/**
	 * 回调接口
	 * @author XueZhongHao
	 * @date 2024/12/31
	 * @param request
	 * @param requestBodyString
	 * @return java.util.Map<java.lang.String,java.lang.String>
	 **/
	@RequestMapping(value = "/aggregateNotify")
	@ResponseBody
	public Map<String, String> aggregateNotify(HttpServletRequest request, @RequestBody String requestBodyString) {
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，remoteHost:{},requestURI:{}",request.getRemoteHost(),request.getRequestURI());
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，接收参数:{}",requestBodyString);
		Map<String, String> json = paymentNotifyService.onNotify(requestBodyString);
		log.info("/PaymentNotify/aggregateNotify=======>支付回调接口，返回参数：{}",json);
		return json;
	}


	
	

	/*
	 * public JSONObject aggregateNotify(HttpServletRequest request,@RequestBody
	 * String requestBodyString) { log.info(request.getRequestURI());
	 * log.info(request.getRemoteHost()); log.info(requestBodyString);
	 * PaymentNotifyBo paymentNotifyBo=new PaymentNotifyBo(); Enumeration<String>
	 * parameterNames = request.getParameterNames(); while
	 * (parameterNames.hasMoreElements()) { String paramName =
	 * parameterNames.nextElement(); String[] paramValues =
	 * request.getParameterValues(paramName); for (String paramValue : paramValues)
	 * { log.info("{}: {}", paramName, paramValue); }
	 * if(paramValues!=null&&paramValues.length>0) { try { Field
	 * fd=PaymentNotifyBo.class.getDeclaredField(paramName); fd.setAccessible(true);
	 * fd.set(paymentNotifyBo, paramValues[0]); }catch(Exception e) {
	 * log.warn("aggregateNotify error:",e); } } }
	 * 
	 * JSONObject json= paymentNotifyService.onNotify(paymentNotifyBo);
	 * log.info(json.toJSONString()); return json; } }
	 */
	
}