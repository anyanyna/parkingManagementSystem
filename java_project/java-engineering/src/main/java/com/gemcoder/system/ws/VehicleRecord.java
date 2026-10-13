package com.gemcoder.system.ws;

import com.alibaba.fastjson.JSONObject;

public class VehicleRecord {
	//是否入场
	private boolean inYard;
	private String cam_id;
	private JSONObject msgBody;
	
	private String bodyStr;
	
	private String plate_num;
	
	public VehicleRecord(boolean inYard, String cam_id, JSONObject msgBody) {
		this.inYard = inYard;
		this.cam_id = cam_id;
		this.msgBody = msgBody;
		this.plate_num=msgBody.getString("plate_num");
		this.bodyStr=msgBody==null?null:msgBody.toJSONString();
	}
	public String getCam_id() {
		return cam_id;
	}
	public void setCam_id(String cam_id) {
		this.cam_id = cam_id;
	}
	public JSONObject getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(JSONObject msgBody) {
		this.msgBody = msgBody;
	}
	public boolean isInYard() {
		return inYard;
	}
	public void setInYard(boolean inYard) {
		this.inYard = inYard;
	}
	public String getBodyStr() {
		return bodyStr;
	}
	public String getPlate_num() {
		return plate_num;
	}
}
