import { get,post } from "@/lib/http"
export default {
	/* ---------------------- 接口demo ---------------------- */
	// rest服务
	queryRepairList({ commit }, data) {
		let url = "/:rest/gemapi/workOrder/getWorkOrderInfo";
		return post(url, data);
	},

	// 捷码api
	queryDeviceAddress({ commit }, data) {
		let url = "/:gemapi/api/execute?apicode=8c61666e9aeb49d8905b25473268024b";
		let params = {
			apiTarget: "/api/execute",
			apitype: "dataBase",
			apiCode: "8c61666e9aeb49d8905b25473268024b",
			appuuid: "614b3cbb0a21437686f7e33484bda33b",
			version: 0,
			pageuuid: "e282eeb7c75f4ee9a7a08d2e1bbf01d7",
			inputparams: JSON.stringify(data),
			apiName: "lnzy地址信息"
		}
		return post(url, params);
	},
}
