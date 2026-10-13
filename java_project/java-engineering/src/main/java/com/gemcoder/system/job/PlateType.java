package com.gemcoder.system.job;

public class PlateType {
	public static final int ICE_PLATE_UNCERTAIN = 0; // !< 不确定的
	public static final int ICE_PLATE_BLUE = 1; // !< 蓝牌车
	public static final int ICE_PLATE_YELLOW = 2; // !< 单层黄牌车
	public static final int ICE_PLATE_POLICE = 4; // !< 警车
	public static final int ICE_PLATE_WUJING = 8; // !< 武警车辆
	public static final int ICE_PLATE_DBYELLOW = 16; // !< 双层黄牌
	public static final int ICE_PLATE_MOTOR = 32; // !< 摩托车
	public static final int ICE_PLATE_INSTRUCTIONCAR = 64; // !< 教练车
	public static final int ICE_PLATE_MILITARY = 128; // !< 军车
	public static final int ICE_PLATE_PERSONAL = 256; // !< 个性化车
	public static final int ICE_PLATE_GANGAO = 512; // !< 港澳车(粤 Z 开头)
	public static final int ICE_PLATE_EMBASSY = 1024; // !< 使馆车
	public static final int ICE_PLATE_NONGLARE = 2048; // !< 老式车牌(不反光)
	public static final int ICE_PLATE_AVIATION = 4096; // !< 民航车牌
	public static final int ICE_PLATE_NEWENERGY = 8192; // !< 新能源车牌
	public static final int ICE_PLATE_NEWENERGYBIG = 0x00004000;// !< 新能源车牌大车
	public static final int ICE_PLATE_EMERGENCY = 0x00008000;// !< 应急车
	public static final int ICE_PLATE_AIRPORT = 0x00010000;// !< 机场车牌
	public static final int ICE_PLATE_DIAN = 0x00020000;// !< 电字车牌
	public static final int ICE_PLATE_CHANG = 0x00040000;// !< 厂内车牌
	public static final int ICE_PLATE_CHANG_V = 0x00080000;// !< 厂/场内车牌(竖)
	public static final int ICE_PLATE_YUEDDDD = 0x00100000;// !< 粤+4 位数字
	public static final int ICE_PLATE_MACAU = 0x01000000; // !< 澳门本地车牌
	public static final int ICE_PLATE_HONGKONG = 0x02000000; // !< 香港本地车牌
}
