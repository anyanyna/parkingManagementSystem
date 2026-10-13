package com.gemcoder.system.ws;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;

/**
 * 抓拍匹配订单服务
 * 
 * @author jiang
 *
 */
@Service
public class CapMatchServcie {
	private static final Logger log = LoggerFactory.getLogger(CapMatchServcie.class);

	/**
	 * 进场手输车牌
	 */
	private ConcurrentHashMap<String, ThreeGroup> cam2plateInMap = new ConcurrentHashMap<>();
	/**
	 * 进场有牌车
	 */
	private static ConcurrentHashMap<String, VehicleRecord> cam2VRInMap = new ConcurrentHashMap<>();
	/**
	 * 进场无牌车
	 */
	private static ConcurrentHashMap<String, VehicleRecord> cam2VRInNullPlateMap = new ConcurrentHashMap<>();
	/**
	 * 出场有牌车
	 */
	//private static ConcurrentHashMap<String, VehicleRecord> cam2VROutMap = new ConcurrentHashMap<>();
	/**
	 * 出场无牌车
	 */
	///private static ConcurrentHashMap<String, VehicleRecord> cam2VROutNullPlateMap = new ConcurrentHashMap<>();
	private static LinkedBlockingQueue<VehicleRecord> blockVrList = new LinkedBlockingQueue<>(999);
	private static LinkedBlockingQueue<Map<String, String>> blockCapList = new LinkedBlockingQueue<>(998);

	static ExecutorService es = java.util.concurrent.Executors.newSingleThreadExecutor();
	static ExecutorService es3UploadPic = java.util.concurrent.Executors.newSingleThreadExecutor();
	static ExecutorService es4UploadLog = java.util.concurrent.Executors.newSingleThreadExecutor();
	static ExecutorService esUploadCapPic = java.util.concurrent.Executors.newSingleThreadExecutor();
	static ExecutorService esDelayUpdateCapPic = java.util.concurrent.Executors.newSingleThreadExecutor();
	// static Object syLock = new Object();
	Map<String, Integer> cam2yardMap = new HashMap<>();
	volatile long lastupdaetime = 0;
	static ArrayBlockingQueue<String> notifyList = new ArrayBlockingQueue<String>(1000);

	@Autowired
	MinioUtil minioUtil;

	@PostConstruct
	public void init() {
		es4UploadLog.submit(new Runnable() {

			@Override
			public void run() {
				try {
					/*
					 * 等加载结束再执行
					 */
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				while (true) {
					try {
						/**
						 * 上传到MinIO
						 */
						handleuploadMinIOJSON();
					} catch (Throwable e) {
						log.warn(e.toString(), e);
					}
				}
			}
		});
		esUploadCapPic.submit(new Runnable() {
			@Override
			public void run() {
				try {
					/*
					 * 等加载结束再执行
					 */
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				while (true) {
					try {
						/**
						 * 上传到MinIO
						 */
						handleUploadCapPic();
					} catch (Throwable e) {
						log.warn(e.toString(), e);
					}
				}
			}
		});
	}

	/**
	 * 手动输入车牌
	 */
	public void manualInputPlateNum(final String plate_num, String cam_id) {
		ThreeGroup threeGroup = new ThreeGroup();
		threeGroup.cam_id = cam_id;
		threeGroup.plate_num = plate_num;
		threeGroup.time = System.currentTimeMillis();
		cam2plateInMap.put(cam_id, threeGroup);
		es.submit(new Runnable() {
			@Override
			public void run() {
				try {
					handleNewManualPlateIn(cam_id);
				} catch (Throwable e) {
					log.warn(e.toString(), e);
				}
			}

		});
	}

	/**
	 * 
	 * @param vr
	 */
	// @Deprecated
	public static void newCapPictureLog(VehicleRecord vr) {
		// cam2VRMap.put(vr.getCam_id(), vr);
		try {
			blockVrList.add(vr);
		} catch (Throwable e) {
			log.warn("队列溢出。" + vr);
		}


	}

	public static void newCapPicture(String full_pic, String filename) {
		Map<String, String> cap = new HashMap<>();
		cap.put("full_pic", full_pic);
		cap.put("filename", filename);
		blockCapList.add(cap);
	}

	/**
	 * 抓拍
	 */
	private void handleUploadCapPic() {
		try {
			Map<String, String> cap = blockCapList.poll(10, TimeUnit.SECONDS);
			if (cap == null) {
				return;
			}
			String full_pic = cap.get("full_pic");
			String filename = cap.get("filename");
			byte[] imageBytes = Base64.getDecoder().decode(full_pic);
			minioUtil.uploadJPEG(imageBytes, filename, MinIOConfig.pitureBucket);
		} catch (Exception e) {
			log.warn("handleUploadCapPic error", e);
		}
	}

	/**
	 * 处理手动输入车牌进场
	 * 
	 * @param cam_id
	 */
	private void handleNewManualPlateIn(String cam_id) {
		// TODO Auto-generated method stub
		// synchronized (syLock) {

		updateCaminfo();
		ThreeGroup tr = cam2plateInMap.get(cam_id);
		VehicleRecord vr = cam2VRInNullPlateMap.get(cam_id);
		if (vr == null || vr == null) {
			return;
		}
		cam2plateInMap.remove(cam_id);
		cam2VRInNullPlateMap.remove(cam_id);
		/**
		 * 上传并替换文件路径
		 */
		saveMinIOPic(vr);
		String full_pic_path = vr.getMsgBody().getString("full_pic_path");
		String plate_num = tr.plate_num;
		updateInPic(plate_num, full_pic_path, 2);
		// TODO
		// }

	}

	private void updateInPic(String plate_num, String full_pic_path, int delaycount) {
		List<Map<String, Object>> list = executeSQL(
				"select * from vehicle_entry_exit_record where entry_picture is null and license_plate_number=? order by id desc limit 10",
				plate_num);
		if (list.isEmpty()) {

			if (delaycount > 0) {
				final int delayC = delaycount--;
				esDelayUpdateCapPic.submit(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							Thread.sleep(1000);
							updateInPic(plate_num, full_pic_path, delayC);
						} catch (Exception e) {

						}
					}
				});
				log.info("没有相关出入场记录，更新入场图片地址失败。{},{},{}", plate_num, full_pic_path);
			}
			return;
		}
		Map<String, Object> map = list.get(0);
		Object id = map.get("id");
		executeSQL("update vehicle_entry_exit_record set entry_picture=? where id=?", full_pic_path, id);
		log.info("更新入场图片地址:{},车牌->{},ID->{}", full_pic_path, plate_num, id);
	}


	private void _updateCaminfo() {
		List<Map<String, Object>> list = executeSQL("select * from barrier_gate_equipment");
		list.forEach(mp -> {
			if (mp.get("cam_id") != null) {
				cam2yardMap.put((String) mp.get("cam_id"), (Integer) mp.get("parking_lot_info_id"));
			}
		});
	}

	private void updateCaminfo() {
		long maxspan = 1000 * 60 * 5;
		long now = System.currentTimeMillis();
		if (cam2yardMap == null || cam2yardMap.isEmpty() || lastupdaetime + maxspan < now) {
			_updateCaminfo();
		}
	}

	static class ThreeGroup {
		String plate_num;
		String cam_id;
		long time;
	}

	private void saveMinIOPic(VehicleRecord vr) {
		String full_pic = vr.getMsgBody().getString("full_pic");
		if (full_pic == null || full_pic.isBlank() || full_pic.length() < 10) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuilder pathBuilder = new StringBuilder();
		String plate_num = vr.getPlate_num();
		String nowStr = sdf.format(new Date());
		pathBuilder.append(vr.getCam_id()).append("_").append(plate_num).append("_").append(nowStr).append(".jpg");

		String filename = pathBuilder.toString();
		final String fullfilename = vr.getCam_id() + "/" + filename;
		vr.getMsgBody().put("full_pic_path", fullfilename);
		es3UploadPic.submit(new Runnable() {
			@Override
			public void run() {
				try {
					byte[] imageBytes = Base64.getDecoder().decode(full_pic);
					minioUtil.uploadJPEG(imageBytes, fullfilename, MinIOConfig.pitureBucket);
				} catch (Throwable e) {
					log.warn("上传图片失败：" + full_pic, e);
				}
			}
		});
	}

	private void handleuploadMinIOJSON() throws InterruptedException {
		VehicleRecord vr = blockVrList.poll(5, TimeUnit.SECONDS);
		if (vr == null) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuilder pathBuilder = new StringBuilder();
		String nowStr = sdf.format(new Date());
		String plate_num = vr.getPlate_num();
		pathBuilder.append(vr.getCam_id()).append("_").append(plate_num).append("_").append(nowStr).append(".json");
		String filename = pathBuilder.toString();
		final String finalfilename = vr.getCam_id() + "/" + filename;
		final String jonsstr = vr.getBodyStr();
		// log.info("saveMinIOJson:{}", finalfilename);
		try {
			minioUtil.uploadLog(jonsstr.getBytes(), finalfilename, MinIOConfig.logBucket);
		} catch (Throwable e) {
			log.warn("上传json失败：", e);
		}
	}

}
