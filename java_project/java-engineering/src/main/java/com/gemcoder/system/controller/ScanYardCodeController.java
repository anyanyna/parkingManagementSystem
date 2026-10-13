package com.gemcoder.system.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 扫码进出场
 * @author jiang
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.ScanYardCodeService;
import com.gemcoder.system.util.*;
@CrossOrigin
@Controller
@RequestMapping("/ScanYardCode")
public class ScanYardCodeController {
	private static final Logger log = LoggerFactory.getLogger(ScanYardCodeController.class);
	@Resource
	ScanYardCodeService scanYardCodeService;

	/**
	 * 非提前付费
	 * @author XueZhongHao
	 * @date 2024/12/30
	 * @param paramMap
	 * @param req
	 * @return com.gemcoder.system.bo.Result
	 **/
	@CrossOrigin
	@RequestMapping(value = "/outYard")
	@ResponseBody
	public Result outYard(@RequestBody(required = false) Map<String, Object> paramMap, HttpServletRequest req) {
		// 后台接口收到二维码编号，根据编号查找车场，出入口。
		// 从出入口获取相机上报缓存数据，如果没有缓存数据，反馈前台没有车牌结果。
		// 根据车牌提取订单数据。如果没有找到订单，进入无订单流程。
		// 如果有订单，计算费用，将费用和支付url，返回给页面。
		/**
		 * 二维码信息
		 */
		// String codeStr=(String)paramMap.get("code");
		String payClient = (String) paramMap.get("payClient");
		// if(codeStr==null) {
		// return new Result(false,"缺少二维码信息");
		// }
		if (payClient == null) {
			payClient = "微信";
		}
		String buyerLogonId = (String) paramMap.get("buyerLogonId");
		String ip = req.getRemoteAddr().toString();
		Integer parking_lot_info_id = (Integer) paramMap.get("parking_lot_info_id");
		String cam_id = (String) paramMap.get("cam_id");
		// Boolean advancePay=(Boolean)paramMap.get("advancePay");
		String plate_num = (String) paramMap.get("plate_num");
		String subOpenId = (String) paramMap.get("subOpenId");
		Result r = scanYardCodeService.outYard(OrderSourceConstants.scanCode, parking_lot_info_id, cam_id, false,
				plate_num, payClient, ip, buyerLogonId, subOpenId);
		log.info("" + r.getData());
		return r;
	}

	/**
	 * 提前付费
	 * 
	 * @param paramMap
	 * @param req
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/advancePay")
	@ResponseBody
	public Result advancePay(@RequestBody(required = false) Map<String, Object> paramMap, HttpServletRequest req) {
		// String codeStr=(String)paramMap.get("code");
		String payClient = (String) paramMap.get("payClient");
		// if(codeStr==null) {
		// return new Result(false,"缺少二维码信息");
		// }
		if (payClient == null) {
			payClient = "微信";
		}
		String ip = req.getRemoteAddr().toString();
		paramMap.put("advancePay", true);
		String buyerLogonId = (String) paramMap.get("buyerLogonId");
		Integer parking_lot_info_id = (Integer) paramMap.get("parking_lot_info_id");
		String cam_id = (String) paramMap.get("cam_id");
		// Boolean advancePay=(Boolean)paramMap.get("advancePay");
		String plate_num = (String) paramMap.get("plate_num");
		String subOpenId = (String) paramMap.get("subOpenId");
		Result r = scanYardCodeService.outYard(OrderSourceConstants.scanCode, parking_lot_info_id, cam_id, true,
				plate_num, payClient, ip, buyerLogonId, subOpenId);
		log.info("" + r.getData());
		return r;
	}

	@CrossOrigin
	@RequestMapping(value = "/getAppid")
	@ResponseBody
	public Result getAppid() {
		Result r = new Result();
		String appId = scanYardCodeService.getAppid();
		r.setFlag(true);
		Map<String, String> data = new HashMap<>();
		data.put("appid", appId);
		r.setData(data);
		return r;
	}

	@CrossOrigin
	@RequestMapping(value = "/getAppsecret")
	@ResponseBody
	public Result getAppsecret() {
		Result r = new Result();
		String appsecret = scanYardCodeService.getAppsecret();
		r.setFlag(true);
		Map<String, String> data = new HashMap<>();
		data.put("appsecret", appsecret);
		r.setData(data);
		return r;
	}

	@CrossOrigin
	@RequestMapping(value = "/wxredirect")
	@ResponseBody
	public Result wxredirect(@RequestBody(required = false) Map<String, Object> paramMap,HttpServletRequest req) {
		String code =(String)paramMap.get("code");
		if(code==null) {
			code = req.getParameter("code");
		}
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=${appid}&secret=${secret}&code=${code}&grant_type=authorization_code";

		url=url.replace("${appid}", scanYardCodeService.getAppid());
		url=url.replace("${secret}", scanYardCodeService.getAppsecret());
		url=url.replace("${code}", code);
		RestTemplate client = new RestTemplate();
		client.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = new HttpHeaders();
		// 以json的方式提交
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 将请求头部和参数合成一个请求
		// HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
		// 执行HTTP请求
		// Map<String,String> response=
		// client.postForEntity(url,requestEntity,Map.class).getBody();
		String response = client.getForEntity(url, String.class).getBody();
		log.info("######");
		log.info(response);
		if (response == null) {
			return new Result(false, "接口调用失败");
		}
		/*
		 * ObjectMapper mapper = new ObjectMapper(); try {
		 * log.info(mapper.writeValueAsString(response)); } catch
		 * (JsonProcessingException e) { log.info(e.toString()); }
		 */
		JSONObject responseJSON=(JSONObject)JSONObject.parse(response);
		Object openid = responseJSON.getString("openid");
		if (openid == null) {
			return new Result(false, "未获取到openid");
		}
		log.info("openid:"+openid);
		Result r = new Result();
		// String appsecret = scanYardCodeService.getAppsecret();
		r.setFlag(true);
		Map<String, String> data = new HashMap<>();
		data.put("openid", openid.toString());
		r.setData(data);
		return r;
		/**
		 * { "access_token":"ACCESS_TOKEN", "expires_in":7200,
		 * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE",
		 * "is_snapshotuser": 1, "unionid": "UNIONID" }
		 */

	}

	/*
	 * @RequestMapping(value = "/testip")
	 * 
	 * @ResponseBody public String testip(HttpServletRequest req ) { String
	 * ip=req.getRemoteAddr().toString(); return ip; }
	 */

}
