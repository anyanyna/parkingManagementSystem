import api from './api.js'
import store from '@/store'
var request = function(url, method, data, header, complete) {
	let urlWhite = ['/:gemapi/login']

	let promise = new Promise(function(resolve, reject) {
		if (urlWhite.includes(url)) {
			// gemapi 登录 form-data形式
			header['content-type'] = 'application/x-www-form-urlencoded'
		} else {
			header['content-type'] = 'application/json'
		}
		header['token'] = store.state.token
		console.log('api(url)', api(url))
		console.log('url-1', url)
		uni.request({
			url: api(url),
			method: method,
			header: header,
			// header: {'content-type': 'application/x-www-form-urlencoded'},
			data: data,
			// 携带cookie
			withCredentials: true,
			success: res => {
				if (res.data.code == 401) { // 未登录
					store.state.token = null
					uni.showToast({
						title: '未登录,请先登录',
						icon: 'none',
						duration: 2000
					})
					setTimeout(function() {
						uni.reLaunch({
							url: '/pages/login/index',
							complete(e) {
								console.log(e)
							}
						})
					}, 1000)
					reject(res.data)
				} else {
					resolve(res.data)
				}
			},
			fail: err => {
				reject(err)
				// uni.hideLoading()
			},
			complete: res => {
				res.data = res.data || {}
				complete(res)
			}
		})
	})
	return promise
}
let fn = function() {}

export const get = function(url, data = {}, header = {}, complete = fn) {
	return request(url, 'GET', data, header, complete)
}
export const post = function(url, data = {}, header = {}, complete = fn) {
	return request(url, 'POST', data, header, complete)
}