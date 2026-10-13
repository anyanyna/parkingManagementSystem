import {
	mapActions,
	mapMutations,
	mapState
} from 'vuex';
// var QQMapWX = require('qqmap-wx-jssdk');
var QQMapWX = require('./qqmap-wx-jssdk.js');
import store from '../store';
// 获取小程序授权信息
export function getAuthInfo(token) {
	// let that = this;
	handleScan(token);
	// uni.getProvider({
	// 	service: 'oauth',
	// 	success: function(res) {
	// 		uni.login({
	// 			provider: res.provider,
	// 			success: function(loginRes) {
	// 				let loginInfo = store.dispatch('login', {
	// 					"code": loginRes.code,
	// 					"icon": userInfo.avatarUrl,
	// 					"name": userInfo.nickName
	// 				});
	// 				loginInfo.then(res => {
	// 					store.commit('setState', {
	// 						token: res.result.token
	// 					})
	// 					handleScan(res.result.token);
	// 				}).catch(error => {
	// 					console.log(error);
	// 				})
	// 			}
	// 		});
	// 	}
	// });

}
// 扫码操作
function handleScan(token) {
	let that = this;
	// 启动扫码
	// 允许从相机和相册扫码
	uni.scanCode({
		success: function(res) {
			console.log(res.result)
			var result = res.result ? res.result.split('&') : null;
			let goodsInfo = {};
			let resultArray = {}
			if (result) {
				for (let i in result) {
					if (result[i]) {
						let subItem = result[i].split('=');
						resultArray[subItem[0]] = subItem[1]
					}
				}
			}
			// if(resultArray.)
			// if (result.split("&")[0].split('=')[1] == 'psdCode') {
			// 	goodsInfo.code_index = Number(result.split("&")[3].split('=')[1]);
			// 	goodsInfo.type = result.split("&")[0].split('=')[1];
			// 	goodsInfo.count = Number(result.split("&")[2].split('=')[1]);
			// 	goodsInfo.psd = result.split("&")[4].split('=')[1];
			// 	goodsInfo.mark = result.split("&")[5].split('=')[1];
			// } else {
			// 	goodsInfo.code_index = Number(result.split("&")[3].split('=')[1]);
			// 	goodsInfo.type = result.split("&")[0].split('=')[1];
			// 	goodsInfo.count = Number(result.split("&")[2].split('=')[1]);
			// 	goodsInfo.psd = '';
			// 	goodsInfo.mark = result.split("&")[4].split('=')[1];
			// }resultArray
			getScanGoodsInfo({
				codeIndex: resultArray.code_index,
				recordId: resultArray.record_id,
				type: resultArray.type
			}, token);
		}
	});
}
// 获取扫码信息
export function getScanGoodsInfo(goodsInfo, token) {
	console.log("goodsInfo1", goodsInfo)
	let that = this;
	uni.authorize({
		scope: 'scope.userLocation',
		success(res) {
			console.log('ccm111', res)
		},
		fail(error) {
			console.log('ccm2222', JSON.stringify(error))
		}
	})
	uni.getLocation({
		type: "gcj02", //返回坐标
		success: function(res) {
			console.log('当前位置的经度：' + res.longitude);
			console.log('当前位置的纬度：' + res.latitude);
			let qqmapsdk = new QQMapWX({
				key: 'RCUBZ-WF3KW-NRQRL-RZEMI-FKDHK-HJFNT'
			})
			qqmapsdk.reverseGeocoder({
				location: {
					latitude: res.latitude,
					longitude: res.longitude,
				},
				success: ((res) => {
					let params = getScanParams(goodsInfo, res.result.address, token);
					let saveScanInfo = store.dispatch('saveScanInfo', params)
					saveScanInfo.then(res => {
						if (res.retCode == 1) {
							store.commit('setState', {
								batchNo: res.data.batchNo
							})
							uni.navigateTo({
								url: '../project/index'
							});
						} else {
							uni.showToast({
								title: res.message,
								icon: 'none',
								duration: 2000 //持续的时间
							})
						}
					}).catch(e => {
						uni.showToast({
							title: e.retMsg,
							icon: 'none',
							duration: 2000 //持续的时间
						})
					})
					// let appScanRes = store.dispatch('appScan', params);
					// appScanRes.then(res => {
					// 	if (res.code == 0) {
					// 		store.commit('setState', {
					// 			scanData: res.result
					// 		})
					// 		uni.setStorage({
					// 			key: 'scanData',
					// 			data: res.result,
					// 			success: function() {
					// 				console.log('success');
					// 			}
					// 		});
					// 		uni.navigateTo({
					// 			url: '../project/index'
					// 		});
					// 	} else {
					// 		uni.showToast({
					// 			title: res.message,
					// 			icon: 'none',
					// 			duration: 2000 //持续的时间
					// 		})
					// 	}
					// }).catch(error => {})
				})
			})
		},
		fail(error) {
			console.log('ccm2222', JSON.stringify(error))
		}
	});
}
// 处理扫码参数
export function getScanParams(goodsInfo, address, token) {
	console.log('goodsInfo23444', goodsInfo)
	var regex =
		"(?<province>[^省]+省|.+自治区)(?<city>[^自治州]+自治州|[^市]+市|[^盟]+盟|[^地区]+地区|.+区划)(?<county>[^市]+市|[^县]+县|[^旗]+旗|.+区)?(?<village>.*)";
	// var regex =
	// 	"(?<province>[^省]+省|.+自治区)(?<city>[^自治州]+自治州|[^市]+市|[^盟]+盟|[^地区]+地区|.+区划)(?<county>[^市]+市|[^县]+县|[^旗]+旗|.+区)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
	console.log(address.match(regex))
	var scandata = {
		"address": address ? address.match(regex)[4] : '未获取到地址',
		"area": address ? address.match(regex)[3] : '',
		"city": address ? address.match(regex)[2] : '',
		"province": address ? address.match(regex)[1] : '',
		"codeIndex": goodsInfo.codeIndex,
		'recordId': goodsInfo.recordId,
		// "count": parseInt(goodsInfo.count),
		// "mark": goodsInfo.mark,
		"type": goodsInfo.type,
		// "psd": goodsInfo.psd

	}
	store.commit('setState', {
		codeIndex: goodsInfo.codeIndex,
		recordId: goodsInfo.recordId,
		codeType: goodsInfo.type
	})
	uni.setStorage({
		key: 'goodsInfo',
		data: {
			codeIndex: goodsInfo.codeIndex,
			recordId: goodsInfo.recordId,
			codeType: goodsInfo.type
		},
		success: function() {}
	});
	console.log('ccm333', token)
	let header = {
		"Cookie": `South_Authorization_Trace_Mp_=South_Bearer_Trace_Mp_${token}`,
	};
	let params = {
		data: scandata,
		header: header
	}
	return params;
}