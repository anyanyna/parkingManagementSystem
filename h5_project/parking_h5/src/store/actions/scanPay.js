import { get,post } from "@/lib/http"
export default {
	/* ---------------------- 扫码缴费 ---------------------- */
	
	// 获取 微信用户唯一标识 openid
	getWxOpenId({ commit }, data) {
		let url = "/:rest/ScanYardCode/wxredirect";
		return post(url, data);
	},
	
	// 查询当前道闸车牌号
	getCurrentPlate({ commit }, data) {
		let url = "/:rest/AppBase/currentPlate";
		return post(url, data);
	},
	
	// 通过车牌号查询对应订单信息
	getUserOrderOutYard({ commit }, data) {
		let url = "/:rest/AppBase/userOrderOutYard";
		return post(url, data);
	},
	
	// 通过订单信息查询订单结算信息
	getSettlement({ commit }, data) {
		let url = "/:rest/AppBase/settlement";
		return post(url, data);
	},
	
	// 出场扫码 支付
	outYardPay({ commit }, data) {
		let url = "/:rest/ScanYardCode/outYard";
		return post(url, data);
	},
	
	// 提前缴费 支付
	advancePay({ commit }, data) {
		let url = "/:rest/ScanYardCode/advancePay";
		return post(url, data);
	},
	
	// 抬杆放行
	openOutBarier({ commit }, data) {
		let url = "/:rest/AppBase/openOutBarier";
		return post(url, data);
	},
}


