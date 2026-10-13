package com.gemcoder.system.ws;

import org.springframework.web.socket.WebSocketSession;

public class ExtendSession {
	private WebSocketSession webSocketSession;
	private String cam_ip;
	private String park_id;
	private String cam_id;
	private String msg_id;
	private String token;
	public ExtendSession(WebSocketSession session, String cam_ip, String park_id, String cam_id, String msg_id) {
		// TODO Auto-generated constructor stub
		this.webSocketSession=session;
		this.cam_ip=cam_ip;
		this.park_id=park_id;
		this.cam_id=cam_id;
		this.msg_id=msg_id;
	}

	public WebSocketSession getWebSocketSession() {
		return webSocketSession;
	}

	public void setWebSocketSession(WebSocketSession webSocketSession) {
		this.webSocketSession = webSocketSession;
	}

	public String getCam_ip() {
		return cam_ip;
	}

	public void setCam_ip(String cam_ip) {
		this.cam_ip = cam_ip;
	}

	public String getPark_id() {
		return park_id;
	}

	public void setPark_id(String park_id) {
		this.park_id = park_id;
	}

	public String getCam_id() {
		return cam_id;
	}

	public void setCam_id(String cam_id) {
		this.cam_id = cam_id;
	}

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
