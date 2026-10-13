import { get, post } from "@/lib/http"
export default {
	// 捷码登录-用户名&密码
	loginGemapi ({ commit }, data) {
		let url = "/:gemapi/login"
		return post(url, data)
	},

	// 获取当前登录用户的信息
	getUserInfoDetail ({ commit }, data) {
		let url = "/:gemapi/api/execute?apicode=26854029900383000"
		let params = {
			"apiTarget": "/api/execute",
			"apitype": "system",
			"apiCode": "26854029900383000",
			"version": 0,
			"needVerificationCode": false,
			"inputparams": "{\"projectuuid\":\"a09fe71ca88f44a085076b47be78ecfe\"}",
			"appuuid": "a09fe71ca88f44a085076b47be78ecfe",
			"pageuuid": "gmPageMenu",
			"apiName": "获取当前登录用户的信息-新版"
		}
		return post(url, params)
	},

	// 捷码登录-用户名 （测试用-非企业微信环境）
	loginSystemGemapiTest ({ commit }, data) {
		let url = "/:rest/gemapi/foranApp/gemSystem/testLogin"
		return get(url, data)
	},

	// 捷码登录-code （企业微信环境）
	loginSystemGemapi ({ commit }, data) {
		let url = "/:rest/gemapi/foranApp/gemSystem/login"
		return get(url, data)
	},
}


