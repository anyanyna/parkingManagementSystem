package com.gemcoder.system.util;

import java.util.Random;

import org.springframework.util.StringUtils;

/**
 * 生成订单编号
 * @author jiang
 *
 */
public class OrderCodeUtil {
	private static  int USE_VERSION=1;
	public static  final String generateOrderCode(String licensePlate) {
		if(USE_VERSION==0) {
			return generateOrderCode_V0(licensePlate);
		}else {
			return generateOrderCode_V1(licensePlate);
		}
	}
	private static  final String generateOrderCode_V0(String licensePlate) {
		java.util.Date currentTime = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String formattedTime = sdf.format(currentTime);
		String orderCode = formattedTime + (licensePlate != null && licensePlate.length() >= 5 ? licensePlate.substring(licensePlate.length() - 5) : "00000");
		return orderCode;
		//20241104115208-HDZHB
		//2024111909274622500000
	}
	private static  final String generateOrderCode_V1(String licensePlate) {
		//licensePlate=licensePlate==null?(Integer.toString(i)( new Random()).nextInt()):licensePlate;
		java.util.Date currentTime = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String formattedTime = sdf.format(currentTime);
		String lastStr="00000";
		if(!StringUtils.isEmpty(licensePlate)) {
			int  hashcode=Math.abs(licensePlate.hashCode());
			lastStr=Integer.toString(hashcode).substring(0,5);
		}
		String orderCode = formattedTime +lastStr;// "-" + (licensePlate != null && licensePlate.length() >= 5 ? licensePlate.substring(licensePlate.length() - 5) : "00000");
		return orderCode;
	}
	/*public static void main(String[] args) {
		System.out.println(generateOrderCode_V0("浙AUR345"));
		System.out.println(generateOrderCode_V0(""));
		System.out.println(generateOrderCode_V1("浙AUR345"));
		System.out.println(generateOrderCode_V1(""));
	}*/
}
