package com.gemcoder.system.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.ws.CmdCachemanager;

/**
 * websocket 命令下发
 * @author jiang
 *
 */
@Service
public class WsCommandService {
	
	/**
	 * 开闸
	 * @param cameraId
	 */
	public void sendOpenGateCmd(String cameraId) {
		//TODO
		//CmdCachemanager.getInstance().putCmd(null);
	}
}
