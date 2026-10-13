var api = {
	// 后端服务地址，按本地环境修改
	rest: 'http://127.0.0.1:9071',
}
console.log(process.env.NODE_ENV)
// 开发环境 打开 || 生产环境 关闭
if (process.env.NODE_ENV == 'development') {
	api.rest = '/rest'
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