package com.gemcoder.system.util;

import com.gemcoder.system.job.PlateType;

public class WsJsonUtil {
	public static String mapPlateType(String plate_color,Integer plateType) {
		if("绿色".equals(plate_color)) {
			return "绿牌";
		}
		if (plateType == null) {
			return "蓝牌";
		}
		if (plateType == PlateType.ICE_PLATE_POLICE || plateType == PlateType.ICE_PLATE_WUJING
				|| plateType == PlateType.ICE_PLATE_EMERGENCY) {
			return "白牌";
		}
		if (plateType == PlateType.ICE_PLATE_NEWENERGY || plateType == PlateType.ICE_PLATE_NEWENERGYBIG) {
			return "绿牌";
		}
		return "蓝牌";
	}
}
