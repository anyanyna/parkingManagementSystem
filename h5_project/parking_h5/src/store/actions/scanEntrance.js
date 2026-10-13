import { get,post } from "@/lib/http"
export default {
	/* ---------------------- 扫码入场 ---------------------- */
	
	// 获取车场详情
	getYardDetail({ commit }, data) {
		let url = "/:rest/AppBase/yardDetail";
		return post(url, data);
	},
	
	// 无牌入场
	vehicleInYard({ commit }, data) {
		let url = "/:rest/AppBase/vehicleInYard";
		return post(url, data);
	},
	
}


