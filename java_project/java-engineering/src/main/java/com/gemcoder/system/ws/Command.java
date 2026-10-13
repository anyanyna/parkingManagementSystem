package com.gemcoder.system.ws;

public class Command {
	private String cameraId;//相机ID
	private String content;//消息内容
	private boolean broadcast;//广播消息

	public Command(String cameraId, String content, boolean broadcast) {
		this.cameraId = cameraId;
		this.content = content;
		this.broadcast = broadcast;
	}

	public Command(String cameraId, String content) {
		this(cameraId, content, false);
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isBroadcast() {
		return broadcast;
	}

	public void setBroadcast(boolean broadcast) {
		this.broadcast = broadcast;
	}

}
