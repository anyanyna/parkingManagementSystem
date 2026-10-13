package com.gemcoder.system.ws;

import java.util.concurrent.ConcurrentHashMap;
//暂时没用到，抓拍等后续可能用到
public class GlobalMessageCacheManager {
	/**
	 * 3分钟
	 */
	public static final long maxduration=1000L*60*5;
	private static GlobalMessageCacheManager _self;
	//private ConcurrentHashMap<String,String> jsoncache=new ConcurrentHashMap<>();
	/**
	 * 相机当前车缓存，
	 * 相机id-->当前车记录
	 */
	private ConcurrentHashMap<String,Pair0> cam2RecordCache=new ConcurrentHashMap<>();
	/**
	 * 车辆-->相机 记录
	 */
	private ConcurrentHashMap<String,Pair1> vehicle2CameraBarrierCache=new ConcurrentHashMap<>();

	
	
	
	private GlobalMessageCacheManager() {
	}
	public static GlobalMessageCacheManager getInstance() {
		synchronized (GlobalMessageCacheManager.class) {
			if (_self == null) {
				_self = new GlobalMessageCacheManager();
			}
		}
		return _self;
	}
	public void putCurrentVehicleRecord(String camid,VehicleRecord vr) {
		cam2RecordCache.put(camid,new Pair0( vr));
		String plate_num=vr.getMsgBody().getString("plate_num");
		if(plate_num!=null) {
			vehicle2CameraBarrierCache.put(plate_num,new Pair1( camid));
		}
	}
	public VehicleRecord getCurrentVehicleRecord(String camid) {
		Pair0 p0= cam2RecordCache.get(camid);
		if(p0==null) {
			return null;
		}
		if(p0.isOvertime()) {
			return null;
		}
		return p0.vr;
	}
	public String findCameraBarrier(String plate_num) {
		Pair1 p1= vehicle2CameraBarrierCache.get(plate_num);
		if(p1==null) {
			return null;
		}
		if(p1.isOvertime()) {
			return null;
		}
		return p1.camid;
	}
	/**
	 * 出场后需要清理
	 * @param camid
	 * @param plateNum
	 */
	public void clear(String camid,String plateNum) {
		cam2RecordCache.remove(camid);
		vehicle2CameraBarrierCache.remove(plateNum);
	}
	static class Pair0{
		VehicleRecord  vr;
		long createtime;
		public Pair0(VehicleRecord  vr) {
			this.vr=vr;
			createtime=System.currentTimeMillis();
		}
		public boolean isOvertime() {
			return System.currentTimeMillis()-createtime>0;
		}
	}
	static class Pair1{
		String  camid;
		long createtime;
		public Pair1(String  camid) {
			this.camid=camid;
			createtime=System.currentTimeMillis();
		}
		public boolean isOvertime() {
			return System.currentTimeMillis()-createtime>0;
		}
	}
}
