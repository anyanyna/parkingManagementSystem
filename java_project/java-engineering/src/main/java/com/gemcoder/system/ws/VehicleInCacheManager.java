package com.gemcoder.system.ws;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class VehicleInCacheManager {
	private static VehicleInCacheManager _self;
	private java.util.concurrent.BlockingQueue<VehicleRecord> vehicleInYardRecordList;
	private java.util.concurrent.BlockingQueue<VehicleRecord> vehicleOutYardRecordList;

	private VehicleInCacheManager() {
		vehicleInYardRecordList = new ArrayBlockingQueue<VehicleRecord>(10_000);
		vehicleOutYardRecordList = new ArrayBlockingQueue<VehicleRecord>(10_000);
	}

	public static VehicleInCacheManager getInstance() {
		synchronized (VehicleInCacheManager.class) {
			if (_self == null) {
				_self = new VehicleInCacheManager();
			}
		}
		return _self;
	}

	public void addInYardRecord(VehicleRecord cmd) {
		vehicleInYardRecordList.add(cmd);
	}

	public VehicleRecord getInYardRecord() {
		try {
			return vehicleInYardRecordList.poll(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			return null;
		}
	}

	public void addOutYardRecord(VehicleRecord cmd) {
		vehicleOutYardRecordList.add(cmd);
	}

	public VehicleRecord getOutYardRecord() {
		try {
			return vehicleOutYardRecordList.poll(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			return null;
		}
	}
}
