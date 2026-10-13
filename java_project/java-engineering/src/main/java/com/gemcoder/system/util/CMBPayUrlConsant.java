package com.gemcoder.system.util;

/**
 * 支付url
 * 
 * @author jiang
 *
 */
public class CMBPayUrlConsant {
	// 测试环境地址：
	// 收款码申请：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/qrcodeapply
	// 支付结果查询：
	private static final String testOrderqueryURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/orderquery";
	// 退款申请：
	private static final String testRefundURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/refund";
	// 退款结果查询：
	private static final String testRefundqueryURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/refundquery";
	// 付款码收款：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/pay
	// 微信统一下单：
	private static final String testOnlinepayURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/onlinepay";
	// 付款码收款撤销：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/cancel
	// 关闭订单：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/close
	// 支付宝服务窗支付：
	private static final String testServpayURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/servpay";
	private static final String testNativeServpayURL = "https://api.cmburl.cn:8065/polypay/v1.0/mchorders/zfbqrcode";
	// 支付宝native支付：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/zfbqrcode
	// 微信native支付：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/wxqrcode
	// 对账单下载地址获取：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/statementurl
	// 秘钥设置：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchkey/keyset
	// 订单二维码申请
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/orderqrcodeapply
	// 微信小程序下单：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/MiniAppOrderApply
	// 银联云闪付：
	// https://api.cmburl.cn:8065/polypay/v1.0/mchorders/cloudpay

	// 支付结果查询：
	private static final String realOrderqueryURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/orderquery";
	// 退款申请：
	private static final String realRefundURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/refund";
	// 退款结果查询：
	private static final String realRefundqueryURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/refundquery";
	// 微信统一下单：
	private static final String realOnlinepayURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/onlinepay";
	// 支付宝服务窗支付：
	private static final String realServpayURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/servpay";
	private static final String realNativeServpayURL = "https://api.cmbchina.com/polypay/v1.0/mchorders/zfbqrcode";

	/**
	 * 退款地址
	 * 
	 * @param isTest是否测试环境
	 * @return
	 */
	public static String getRefundURL(boolean isTest) {
		if (isTest) {
			return testRefundURL;
		}
		return realRefundURL;
	}

	/**
	 * 订单查询地址
	 * 
	 * @param isTest是否测试环境
	 * @return
	 */
	public static String getOrderqueryURL(boolean isTest) {
		if (isTest) {
			return testOrderqueryURL;
		}
		return realOrderqueryURL;
	}

	/**
	 * 退款查询地址
	 * 
	 * @param isTest是否测试环境
	 * @return
	 */
	public static String getRefundqueryURL(boolean isTest) {
		if (isTest) {
			return testRefundqueryURL;
		}
		return realRefundqueryURL;
	}

	/**
	 * 微信支付地址
	 * 
	 * @param isTest是否测试环境
	 * @return
	 */
	public static String getOnlinepayURL(boolean isTest) {
		if (isTest) {
			return testOnlinepayURL;
		}
		return realOnlinepayURL;
	}

	/**
	 * 支付宝支付地址
	 * 
	 * @param isTest是否测试环境
	 * @return
	 */
	public static String getServpayURL(boolean isTest) {
		if (isTest) {
			return testServpayURL;
		}
		return realServpayURL;
	}
	/**
	 * 支付宝native
	 * @param isTest
	 * @return
	 */
	public static String getNativeURL(boolean isTest) {
		if (isTest) {
			return testNativeServpayURL;
		}
		return realNativeServpayURL;
	}
}
