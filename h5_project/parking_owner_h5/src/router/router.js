// router.js
import { RouterMount, createRouter } from 'uni-simple-router'
import store from '@/store'

const router = createRouter({
	platform: process.env.VUE_APP_PLATFORM,
	routes: [...ROUTES]
})
const whiteList = ['/pages/login/index']
// 全局路由前置守卫
router.beforeEach((to, from, next) => {
	// token 信息
	let token = store.state.token
	console.log('全局路由前置守卫-token', token)
	// 登录页 访客信息填写 直接跳转
	// if (whiteList.includes(to.path)) {
	// 	console.log('全局路由前置守卫-直接跳转-token', token)
	// 	next()
	// } else {
	// 	if (token) {
	// 		// 有token 直接跳转
	// 		next()
	// 	} else {
	// 		// 无token 返回登录页
	// 		next({
	// 			path: '/pages/login/index'
	// 		})
	// 	}
	// }
	next();
})
// 全局路由后置守卫
router.afterEach((to, from) => {
	console.log('跳转结束')
})

export {
	router,
	RouterMount
}
