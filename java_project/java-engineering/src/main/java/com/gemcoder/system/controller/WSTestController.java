package com.gemcoder.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.ws.CameraWebSocketHandler;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.ExtendSession;
import com.gemcoder.system.ws.SessionCacheManager;

@Controller
@RequestMapping("/WSTest")
public class WSTestController {
	private static final Logger log = LoggerFactory.getLogger(WSTestController.class);
	@Resource
	CommandService commandService;
	private SessionCacheManager sessionCacheManager = SessionCacheManager.getInstance();
	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/testOpenBarrier")
	@ResponseBody
	public String testOpenBarrier(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		/**
		 * 写死参数
		 */
		String cam_id = (String) paramMap.get("cam_id");
		Object isopen = paramMap.get("isopen");
		Object isInYard = paramMap.get("isInYard");
		String plate = (String) paramMap.get("plate");
		boolean open = true;
		boolean inyard = false;
		if (isopen != null) {
			open = Boolean.parseBoolean(isopen.toString());
		}
		if (isInYard != null) {
			inyard = Boolean.parseBoolean(isInYard.toString());
		}
		String rst = commandService.openBarier(cam_id, plate == null ? "浙A123456" : plate, inyard, open);
		return rst;
	}

	@RequestMapping(value = "/testOpenBarrier1/{camid}")
	@ResponseBody
	public String testOpenBarrier1(@RequestBody(required = false) Map<String, Object> paramMap,
			@PathVariable(value = "camid") String camid) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		/**
		 * 写死参数
		 */
		if (paramMap == null) {
			paramMap = new HashMap<>();
		}
		paramMap.put("cam_id", camid);
		paramMap.put("isopen", true);
		paramMap.put("isInYard", true);
		paramMap.put("plate", "浙A123456");
		return testOpenBarrier(paramMap);
	}

	@RequestMapping(value = "/testOpenBarrier2/{camid}")
	@ResponseBody
	public String testOpenBarrier2(@RequestBody(required = false) Map<String, Object> paramMap,
			@PathVariable(value = "camid") String camid) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		/**
		 * 写死参数
		 */
		if (paramMap == null) {
			paramMap = new HashMap<>();
		}
		paramMap.put("cam_id", camid);
		paramMap.put("isopen", false);
		paramMap.put("isInYard", true);
		paramMap.put("plate", "浙A123456");
		return testOpenBarrier(paramMap);
	}

	@RequestMapping(value = "/testCap/{camid}")
	@ResponseBody
	public String testCap(@RequestBody(required = false) Map<String, Object> paramMap,
			@PathVariable(value = "camid") String camid) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		/**
		 * 写死参数
		 */
		String rst = commandService.capPicture(camid);
		return rst;
	}

	@RequestMapping(value = "/getIOStatus/{camid}")
	@ResponseBody
	public String getIOStatus(@RequestBody(required = false) Map<String, Object> paramMap,
			@PathVariable(value = "camid") String camid) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		/**
		 * 写死参数
		 */
		String rst = commandService.getIOStatus(camid);
		return rst;
	}

	@RequestMapping(value = "/sendRawCmd/{camid}")
	@ResponseBody
	public String sendRawCmd(@PathVariable(value = "camid") String camid,
			@RequestBody(required = false) String paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		try {
			//String str = objectMapper.writeValueAsString(paramMap);
			String rst = commandService.sendRawCmd(camid, paramMap);
			return rst;
		} catch (Exception e) {
			log.warn(e.toString(), e);
			return e.toString();
		}
	}

	@RequestMapping(value = "/createFakeSession")
	@ResponseBody
	public String createFakeSession(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		String cam_id = (String) paramMap.get("cam_id");
		// WebSocketSession session, String cam_ip, String park_id, String cam_id,
		// String msg_id
		ExtendSession extendSession = new ExtendSession(null, "127.0.0.1", "3", cam_id, "12345678");
		String token = "12121212121212121212";
		extendSession.setToken(token);
		sessionCacheManager.put(cam_id, extendSession);
		return "ok";
	}

	@RequestMapping(value = "/getSessions")
	@ResponseBody
	public String getSessions(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		return Integer.toString(SessionCacheManager.getInstance().currentSize());
	}

	@RequestMapping(value = "/getCamInfo")
	@ResponseBody
	public String getCamInfo(@RequestBody(required = false) Map<String, Object> paramMap) {
		// 如果有需要校验的入参, 请在这里补充代码进行校验
		// 调用service层的代码
		StringBuilder strb = new StringBuilder();
		for (int i = CameraWebSocketHandler.rcvCache.size() - 1; i >= 0; --i) {
			strb.append(CameraWebSocketHandler.rcvCache.get(i));
		}

		return strb.toString();
	}

	@RequestMapping(value = "/testip")
	@ResponseBody
	public String testip(HttpServletRequest req) {
		String ip = req.getRemoteAddr().toString();
		return ip;
	}

}
