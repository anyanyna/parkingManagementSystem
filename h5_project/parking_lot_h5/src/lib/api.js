var api = {
	// 开发环境
	// rest: 'http://127.0.0.1:9071',
	// 测试环境
	rest: 'http://127.0.0.1:9071',
	gemapi: 'http://127.0.0.1:9001/api'
	// 正式环境
	// rest: 'http://127.0.0.1:9071',
}
console.log(process.env.NODE_ENV)
// 开发环境 打开 || 生产环境 关闭
if (process.env.NODE_ENV == 'development') {
	api.rest = '/rest'
	api.gemapi = '/gemapi'
}
export default (url) => {
	for (let key in api) {
		const reg = new RegExp(`^/?:${key}`)
		console.log('reg', reg)
		if (reg.test(url)) {
			console.log('url', url)
			return url.replace(reg, api[key])
		}
	}
	return url
}