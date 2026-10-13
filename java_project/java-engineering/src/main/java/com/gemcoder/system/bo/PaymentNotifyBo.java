package com.gemcoder.system.bo;

/**
 * 支付结果通知
 * 
 * @author jiang
 *
 */
public class PaymentNotifyBo {
	String version; // 版本号
	String encoding; // 编码方式
	String sign; // 签名
	String signMethod; // 签名方法
	String returnCode; // 返回码
	// 以下字段仅在returnCode为SUCCESS时返回
	String merId; // 商户号
	String orderId; // 商户订单号
	String cmbOrderId; // 平台订单号
	String respCode; // 响应码
	String errDescription; // 第三方错误描述
	String txnAmt; // 交易金额
	String dscAmt; // 优惠金额
	String couponInfo; // 银联优惠信息
	String promotionDetail; // 优惠券信息
	String issAddnData; // 银联付款方附加数据
	String orderOrigAmt;// 订单原始金额
	String orderCouponAmt;// 订单优惠金额
	String discountGoodsDetail;// 支付宝商品优惠信息
	String currencyCode;// 交易币种
	String payType;// 支付方式
	String openId;// 用户标识
	String payBank;// 付款银行
	String thirdOrderId;// 第三方订单号
	String buyerLogonId;// 支付宝账户
	String tradeState;// 交易状态
	String txnTime;// 订单发送时间
	String endDate;// 订单完成日期
	String endTime;// 订单完成时间
	String mchReserved;// 商户保留域
	// 以下字段仅在returnCode或respCode为FAIL时返回
	String errCode;// 错误码
	String respMsg;// 应答信息

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignMethod() {
		return signMethod;
	}

	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCmbOrderId() {
		return cmbOrderId;
	}

	public void setCmbOrderId(String cmbOrderId) {
		this.cmbOrderId = cmbOrderId;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getErrDescription() {
		return errDescription;
	}

	public void setErrDescription(String errDescription) {
		this.errDescription = errDescription;
	}

	public String getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}

	public String getDscAmt() {
		return dscAmt;
	}

	public void setDscAmt(String dscAmt) {
		this.dscAmt = dscAmt;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}

	public String getPromotionDetail() {
		return promotionDetail;
	}

	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}

	public String getIssAddnData() {
		return issAddnData;
	}

	public void setIssAddnData(String issAddnData) {
		this.issAddnData = issAddnData;
	}

	public String getOrderOrigAmt() {
		return orderOrigAmt;
	}

	public void setOrderOrigAmt(String orderOrigAmt) {
		this.orderOrigAmt = orderOrigAmt;
	}

	public String getOrderCouponAmt() {
		return orderCouponAmt;
	}

	public void setOrderCouponAmt(String orderCouponAmt) {
		this.orderCouponAmt = orderCouponAmt;
	}

	public String getDiscountGoodsDetail() {
		return discountGoodsDetail;
	}

	public void setDiscountGoodsDetail(String discountGoodsDetail) {
		this.discountGoodsDetail = discountGoodsDetail;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPayBank() {
		return payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	public String getThirdOrderId() {
		return thirdOrderId;
	}

	public void setThirdOrderId(String thirdOrderId) {
		this.thirdOrderId = thirdOrderId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMchReserved() {
		return mchReserved;
	}

	public void setMchReserved(String mchReserved) {
		this.mchReserved = mchReserved;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}
