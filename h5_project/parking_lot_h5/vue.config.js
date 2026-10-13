const TransformPages = require('uni-read-pages')
const { webpack } = new TransformPages()
module.exports = {
	configureWebpack: {
		plugins: [
			new webpack.DefinePlugin({
				ROUTES: webpack.DefinePlugin.runtimeValue(() => {
					const tfPages = new TransformPages({
						includes: ['path', 'name', 'aliasPath', 'meta']
					})
					return JSON.stringify(tfPages.routes)
				}, true)
			})
		],
		module: {
			rules: [
				{
					test: /\.swf$/,
					use: [
						{
							loader: 'file-loader',
							options: {
								name: '[name].[ext]',
								outputPath: 'swf/'
							}
						}
					]
				},
				// ... 其他规则
			]
		},
	},
	devServer: {
		open: process.platform === 'darwin',
		host: '0.0.0.0', // 允许外部ip访问
		// public: "127.0.0.1:8080", // 此处是自己电脑IP地址！
		// port: 8080, // 端口
		// https: false, // 启用https
		client: {
			overlay: {
				warnings: false,
				errors: true
			}
		},
		proxy: {
			'/rest': {
				target: 'http://127.0.0.1:9071', // 后端服务地址，按本地环境修改
				changeOrigin: true, // 允许websockets跨域
				// ws: true,`
				pathRewrite: {
					'^/rest': ''
				}
			},
			'/gemapi': {
				target: 'http://127.0.0.1:7779', // 文件/网关服务地址，按本地环境修改
				changeOrigin: true, // 允许websockets跨域
				// ws: true,
				pathRewrite: {
					'^/gemapi': ''
				}
			}
		} // 代理转发配置，用于调试环境
	},

}