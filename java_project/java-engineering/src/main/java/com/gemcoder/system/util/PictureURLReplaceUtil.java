package com.gemcoder.system.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.gemcoder.system.ws.VehicleRecord;

/**
 * 将道闸返回的图片URL替换为 minIO的URL
 * 
 * @author jiang
 *
 */
public class PictureURLReplaceUtil {
	@Value("${minIO.url}")
	String minIOURL;
	/**
	 * 传minIO
	 * @param vehicleRecord
	 */
/*	public static void replaceVehicleRecordPicture(VehicleRecord vehicleRecord) {
		TODO: 需要时实现道闸图片URL到MinIO的替换逻辑
	}*/
	/**
	 * 替换 vehicle_entry_exit_record 中的图片URL
	 * 
	 * @param vehicle_entry_exit_record
	 */
	@Deprecated
	public static void replace_vehicle_entry_exit_record(Map<String, Object> vehicle_entry_exit_record) {
		if (vehicle_entry_exit_record == null) {
			return;
		}
		String entry_picture = (String) vehicle_entry_exit_record.get("entry_picture");
		String exit_picture = (String) vehicle_entry_exit_record.get("exit_picture");
		if (entry_picture != null && entry_picture.length() > 1) {
			entry_picture = replacePicURL(entry_picture);
			vehicle_entry_exit_record.put("entry_picture", entry_picture);
		}
		if (exit_picture != null && exit_picture.length() > 1) {
			exit_picture = replacePicURL(exit_picture);
			vehicle_entry_exit_record.put("exit_picture", exit_picture);
		}
	}

	public static String replacePicURL(String url) {
		// TODO: 按 minio.echoUrl 配置拼接图片预览地址
		return url;
	}
}
