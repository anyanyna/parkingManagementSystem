package com.gemcoder.system.util;

/**
 * 招行支付密钥常量。
 * 商户私钥属于敏感信息，请通过环境变量 CMB_PRIVATE_KEY 注入，切勿将真实密钥提交到仓库。
 * 商户公钥/招行公钥为非敏感信息，可按需保留或替换为你自己进件后的公钥。
 */
public class CMBPaySecretKeyConstant {
	//商户私钥（环境变量注入）
	public static final String PRIVATE_KEY = System.getenv().getOrDefault("CMB_PRIVATE_KEY", "");
	//商户公钥
	public static final String PUBLIC_KEY = System.getenv().getOrDefault("CMB_PUBLIC_KEY", "");
	//招行公钥
	public static final String CMB_PUBLIC_KEY = System.getenv().getOrDefault("CMB_BANK_PUBLIC_KEY", "");
}
