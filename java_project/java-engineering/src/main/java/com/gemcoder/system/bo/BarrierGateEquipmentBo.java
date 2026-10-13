package com.gemcoder.system.bo;

import java.util.Date;

public class BarrierGateEquipmentBo {
	private int id;
	private String cam_id;
	private String cam_ip;
	private String gate_id;
	private int  parking_lot_info_id;
	private String  in_out;
	private String  create_username;
	private Date create_time;
	private String update_username;
	private Date update_time;
	private String cam_status;
	private String yardName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCam_id() {
		return cam_id;
	}
	public void setCam_id(String cam_id) {
		this.cam_id = cam_id;
	}
	public String getCam_ip() {
		return cam_ip;
	}
	public void setCam_ip(String cam_ip) {
		this.cam_ip = cam_ip;
	}
	public String getGate_id() {
		return gate_id;
	}
	public void setGate_id(String gate_id) {
		this.gate_id = gate_id;
	}
	public int getParking_lot_info_id() {
		return parking_lot_info_id;
	}
	public void setParking_lot_info_id(int parking_lot_info_id) {
		this.parking_lot_info_id = parking_lot_info_id;
	}
	
	public String getCreate_username() {
		return create_username;
	}
	public void setCreate_username(String create_username) {
		this.create_username = create_username;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_username() {
		return update_username;
	}
	public void setUpdate_username(String update_username) {
		this.update_username = update_username;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public String getYardName() {
		return yardName;
	}
	public void setYardName(String yardName) {
		this.yardName = yardName;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public String getCam_status() {
		return cam_status;
	}
	public void setCam_status(String cam_status) {
		this.cam_status = cam_status;
	}

}
