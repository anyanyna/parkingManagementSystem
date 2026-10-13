import Vue from 'vue'
import App from '@/App'
import '@/uni.promisify.adaptor'
import store from '@/store'
import util from "@/lib/util"
import uView from '@/uni_modules/uview-ui'
import { router, RouterMount } from '@/router/router.js'

Vue.use(router)
Vue.use(uView)

Vue.prototype.$store = store
Vue.prototype.$util = util
Vue.config.productionTip = false

if (process.env.NODE_ENV == "production") {
	// console.log = () => { }
}


App.mpType = 'app'

const app = new Vue({
	...App
})
// app.$mount()

//v1.3.5起 H5端 你应该去除原有的app.$mount();使用路由自带的渲染方式
// #ifdef H5
RouterMount(app, router, '#app')
// #endif

// #ifndef H5
app.$mount() //为了兼容小程序及app端必须这样写才有效果
// #endif
