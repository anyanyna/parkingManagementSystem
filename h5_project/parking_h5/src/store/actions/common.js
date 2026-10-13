import { get,post } from "@/lib/http"
export default {
	/* ---------------------- 公共接口 ---------------------- */
	
	// 文件上传
	fileUpload({ commit }, data) {
		let url = "/:gemapi/resource/fileUpload/a09fe71ca88f44a085076b47be78ecfe/0";
		return post(url, data);
	},
	
	// 获取用户树
	queryUserTree({ commit }, data) {
		let url = "/:rest/gemapi/foranApp/gemSystem/getUserTree";
		return post(url, data);
	},
	
	// 查询组织树-tree
	queryOrgTree({ commit }, data) {
		let url = "/:rest/gemapi/foranApp/securityCheckInfo/getOrgTree";
		return get(url, data);
	},
	
	// 获取数据字典 根据 typeCode
	queryDataDictionary({ commit }, data) {
		let url = "/:rest/gemapi/foranApp/gemSystem/getCodeValue";
		return post(url, data);
	},
	
	// 查询组织树-tree
	// queryOrgTree({ commit }, data) {
	// 	let url = "/:gemapi/api/execute?apicode=bed043522b304c8da491112b3b5977c0";
	// 	let params = {
	// 		"apiTarget": "/api/execute",
	// 		"apitype": "dataBase",
	// 		"apiCode": "bed043522b304c8da491112b3b5977c0",
	// 		"version": 0,
	// 		"needVerificationCode": false,
	// 		"inputparams": "{}",
	// 		"appuuid": "a09fe71ca88f44a085076b47be78ecfe",
	// 		"pageuuid": "46783c54febf40eeb863d479dfdbfb4c",
	// 		"apiName": "查询组织树-tree"
	// 	}
		
	// 	return post(url, params);
	// },
	
}


