<template>
	<!-- 扫码缴费 -->
	<view class="scan">
		<view class="scan-title">{{ parkName }}</view>
		<view class="scan-con">
			<view class="scan-con-title">停车缴费</view>
			<view class="scan-con-licence">
				<!-- {{ licenceValue }} -->
				<view class="scan-con-licence-info"
					:style="{ backgroundImage: `url(${licenceFlag ? require('@/static/img/index/绿@2x.png') : require('@/static/img/index/蓝@2x.png')})` }"
					@click="handleKeyboard">
					<view class="scan-con-licence-info-num"
						:style="{ width: `${licenceFlag ? '60rpx' : '66rpx'}`, marginRight: `${licenceFlag ? '10rpx' : '14rpx'}` }"
						v-for="(item,index) in licenceList" :key="index">{{ item }}</view>
				</view>
				<view class="scan-con-licence-btn"
					:style="{ backgroundImage: `url(${licenceFlag ? require('@/static/img/index/添加蓝牌@2x.png') : require('@/static/img/index/添加新能源@2x.png')})` }"
					@click="handleChangeType" />
			</view>
			<view class="scan-con-btn" @click="handleScanPay">停车缴费</view>
		</view>
		<!-- 车牌号键盘 -->
		<u-keyboard mode="car" autoChange @change="handleKeyboardChange" @backspace="handleKeyboardBackspace"
			@confirm="handleKeyboardConfirm" @cancel="handleKeyboardCancel" :show="showKeyboard"></u-keyboard>
	</view>
</template>

<script>
	import {
		mapActions,
		mapMutations,
		mapState
	} from 'vuex';
	export default {
		name: 'scanPay',
		components: {},
		data() {
			return {
				// 微信 appid
				appid: 'wxff2c0e2c2f665a17',
				// 微信 域名
				redirect_uri: 'http://www.wx.lczhparking.com',
				// 微信 传参
				state: null,
				// state: '/pages/scanPay/index?parkId=94',
				// 订单信息
				baseInfo: {
					id: 1
				},
				// 缴费类型 无牌车缴费 || 有牌车缴费 || 提前缴费
				payType: null,
				// 车场名称
				parkName: null,
				// 车场ID
				parkId: null,
				// 道闸ID
				camId: null,
				// 车牌号 类型 false:蓝 true:绿
				licenceFlag: false,
				// 车牌号
				licenceValue: '',
				// licenceValue: '浙A12345',
				// 车牌号 数组
				licenceList: [],
				// licenceList: ['浙','A','1','2','3','4','5'],
				// 车牌号键盘 显示/隐藏
				showKeyboard: false,
				// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单'
				type: null,
			}
		},
		onLoad(option) {
			if (option.parkId && option.camId) {
				// 无牌扫码缴费 || 有牌扫码缴费

				// 车场ID
				this.parkId = option.parkId
				// 道闸ID
				this.camId = option.camId
				console.log('无牌扫码缴费 || 有牌扫码缴费-车场ID', this.parkId);
				console.log('无牌扫码缴费 || 有牌扫码缴费-道闸ID', this.camId);

				// 通过 道闸ID 查询 车牌号
				this.getLicenceInfo()
			} else {
				// 提前缴费

				// 车场ID
				this.parkId = option.parkId
				console.log('提前缴费-车场ID', this.parkId);

				// 缴费类型
				this.payType = '提前缴费'
				console.log('缴费类型-payType', this.payType);

			}

			if (this.parkId) {
				// 获取 车场 详情
				this.getDetail()
			}
		},
		async onShow() {
			let url = window.location.href
			console.log('路由-url', url)
			
			// 路由传参
			this.state = window.location.href.split('#')[1] || null
			
			console.log('state', this.state)
			console.log('openid', this.openid)
			console.log('当前平台:', this.detectPlatform());
			// 判断 微信环境 || 支付宝环境 || 其它
			if (this.state && this.detectPlatform() === 'WeChat' && !this.openid) {
				console.log('微信授权-openid', this.openid)
				// let url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirec`
				let url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=${this.appid}&redirect_uri=${encodeURIComponent(this.redirect_uri)}&response_type=code&scope=snsapi_base&state=${encodeURIComponent(this.state)}#wechat_redirec`
				console.log('微信授权链接-url', url);
				// 打开 微信授权页面
				window.location.href = url
			}
		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo,
				openid: state => state.openid,
			}),
		},
		methods: {
			...mapActions(['getYardDetail', 'getCurrentPlate', 'getUserOrderOutYard']),
			...mapMutations(['setState']),
			// 获取 车场 详情
			async getDetail() {
				const params = {
					id: Number(this.parkId) || null
				}
				console.log('params', params)

				const res = await this.getYardDetail(params)
				console.log('获取 车场 详情-res', res)
				if (res.flag == true) {
					if (res.data?.data && res.data?.data.length !== 0) {
						// 车场名称
						this.parkName = res.data?.data[0].parking_lot_name
						console.log('车场名称-parkName', this.parkName)
					}
				} else {
					uni.showToast({
						title: res.message,
						icon: 'none',
						duration: 2000 //持续的时间
					})
				}
			},
			// 通过 道闸ID 查询 车牌号
			async getLicenceInfo() {
				const params = {
					cam_id: this.camId || null,
				}

				const res = await this.getCurrentPlate(params)
				console.log('通过 道闸ID 查询 车牌号-res', res);
				if (res.flag == true) {
					// 有牌车缴费
					// 车牌号
					this.licenceValue = res.data?.data
					// 车牌号 数组
					this.licenceList = this.licenceValue.split('')
					// 车牌号 类型 false:蓝 true:绿
					this.licenceFlag = this.licenceValue.length === 8 ? true : false
					this.payType = '有牌车缴费'
					console.log('有牌车缴费 车牌号-this.licenceValue', this.licenceValue);
					console.log('有牌车缴费 车牌号-this.licenceValue.length', this.licenceValue.length);
					console.log('有牌车缴费 车牌号-this.licenceList', this.licenceList);
					console.log('有牌车缴费 车牌号类型-this.licenceFlag', this.licenceFlag);

					console.log('缴费类型-payType', this.payType)

					// 通过 车牌号 查询 订单
					this.getOrderInfo()
				} else {
					// 无牌车缴费
					this.payType = '无牌车缴费'
					console.log('缴费类型-payType', this.payType)
					// uni.showToast({
					// 	title: res.message,
					// 	icon: 'none',
					// 	duration: 2000 //持续的时间
					// })
				}
			},
			// 通过 车牌号 查询 订单
			async getOrderInfo() {
				const params = {
					id: Number(this.parkId) || null,
					plate_num: this.licenceValue || null,
				}

				const res = await this.getUserOrderOutYard(params)
				console.log('通过 车牌号 查询 订单-res', res);
				if (res.flag == true) {
					// 有订单
					if (res.data?.data) {
						this.baseInfo = res.data?.data[0]
						this.baseInfo.payType = this.payType
						this.baseInfo.camId = this.camId || null

						if (res.data?.data[0] && res.data?.data[0].order_status === '异常') {
							// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单'
							this.type = '异常订单'
							// 跳转页面 车场提示 异常订单
							uni.navigateTo({
								url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.parkName}`,
								// url: '/pages/scanPay/tip?type=' + this.type,
							})
						} else {
							console.log('通过 车牌号 查询 订单-baseInfo', this.baseInfo);
							// 跳转页面 支付页面
							uni.navigateTo({
								url: '/pages/scanPay/pay?baseInfo=' + encodeURIComponent(JSON.stringify(this.baseInfo)),
							})
						}
					}
				} else {
					// 无订单
					// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单'
					this.type = '无当前车牌订单'
					// 跳转页面 车场提示 无当前车牌订单
					uni.navigateTo({
						url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.parkName}`,
						// url: '/pages/scanPay/tip?type=' + this.type,
					})

					// uni.showToast({
					// 	title: res.message,
					// 	icon: 'none',
					// 	duration: 2000 //持续的时间
					// })
				}
			},
			// 停车缴费
			handleScanPay() {
				console.log('车牌号 类型-this.licenceFlag', this.licenceFlag);
				// 蓝牌
				if (!this.licenceFlag && this.licenceValue.length !== 7) return uni.showToast({
					title: '请输入车牌号！',
					icon: 'none',
					duration: 2000,
				})
				// 绿牌
				if (this.licenceFlag && this.licenceValue.length !== 8) return uni.showToast({
					title: '请输入车牌号！',
					icon: 'none',
					duration: 2000,
				})
				console.log('键盘 点击-this.licenceValue', this.licenceValue);
				console.log('键盘 点击-this.licenceValue.length', this.licenceValue.length);
				console.log('键盘 点击-this.licenceList', this.licenceList);

				// 通过 车牌号 查询 订单
				this.getOrderInfo()
			},
			// 点击图标 切换 车牌号 类型
			handleChangeType() {
				console.log('缴费类型-payType', this.payType)
				// 缴费类型 无牌车缴费 || 提前缴费 打开 车牌号键盘
				if (this.payType === '有牌车缴费') return
				console.log('切换 车牌号 类型-this.licenceFlag', this.licenceFlag);
				this.licenceFlag = !this.licenceFlag
				// 重置 车牌号
				this.licenceValue = ''
				this.licenceList = []
			},
			// 打开 车牌号键盘
			handleKeyboard() {
				console.log('缴费类型-payType', this.payType)
				// 缴费类型 无牌车缴费 || 提前缴费 打开 车牌号键盘
				if (this.payType === '有牌车缴费') return
				console.log('打开 车牌号键盘');
				this.showKeyboard = true
				// 重置 车牌号
				// this.licenceValue = ''
				// this.licenceList = []
			},
			// 键盘 按键被点击(点击退格键不会触发此事件)
			handleKeyboardChange(val) {
				console.log('键盘 点击-val', val);
				// 将每次按键的值拼接到licenceValue变量中，注意+=写法
				// 蓝牌
				if (!this.licenceFlag && this.licenceValue.length >= 7) return
				// 绿牌
				if (this.licenceFlag && this.licenceValue.length >= 8) return
				this.licenceValue += val;
				this.licenceList = this.licenceValue.split('')
				console.log('键盘 点击-this.licenceValue', this.licenceValue);
				console.log('键盘 点击-this.licenceValue.length', this.licenceValue.length);
				console.log('键盘 点击-this.licenceList', this.licenceList);
			},
			// 键盘 退格键被点击
			handleKeyboardBackspace() {
				// 删除licenceValue的最后一个字符
				if (this.licenceValue.length) {
					this.licenceValue = this.licenceValue.substr(0, this.licenceValue.length - 1)
					this.licenceList = this.licenceValue.split('')
				}
				console.log('键盘 退格-this.licenceValue', this.licenceValue);
				console.log('键盘 退格-this.licenceList', this.licenceList);
			},
			// 键盘 完成
			handleKeyboardConfirm() {
				this.showKeyboard = false
				console.log('键盘 完成-this.licenceValue', this.licenceValue);
				console.log('键盘 完成-this.licenceList', this.licenceList);
			},
			// 键盘 取消
			handleKeyboardCancel() {
				this.showKeyboard = false
				console.log('键盘 取消-this.licenceValue', this.licenceValue);
				console.log('键盘 取消-this.licenceList', this.licenceList);
			},
			// 判断 微信环境 || 支付宝环境 || 其它
			detectPlatform() {
				const userAgent = navigator.userAgent || navigator.vendor || window.opera;
				
				// 平台
				let platform = null
				if (/MicroMessenger/i.test(userAgent)) {
					platform = 'WeChat'; // 微信
				} else if (/AlipayClient/i.test(userAgent)) {
					platform = 'Alipay'; // 支付宝
				} else {
					platform = 'Unknown'; // 其他浏览器
				}

				// 你可以在这里根据 platform 的值执行相应的逻辑
				console.log('当前平台:', platform);
				return platform
			}
		}
	}
</script>

<style lang="less" scoped>
	.scan {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		background: url('@/static/img/index/bg@2x.png') no-repeat;
		background-position: 0 0;
		background-size: 100% 595rpx;
		padding: 20rpx;

		&-title {
			font-weight: bold;
			font-size: 32rpx;
			color: #333333;
			line-height: 45rpx;
			margin: 0 0 201rpx 0;
		}

		&-con {
			width: 690rpx;
			height: 800rpx;
			background: linear-gradient(180deg, #FFFFFF 0%, rgba(255, 255, 255, 0) 100%);
			border-radius: 20rpx 20rpx 0rpx 0rpx;
			margin-left: 10rpx;
			padding: 30rpx 20rpx 0 20rpx;

			&-title {
				font-weight: bold;
				font-size: 36rpx;
				color: #333333;
				line-height: 50rpx;
			}

			&-licence {
				display: flex;
				justify-content: space-between;
				width: 100%;
				margin-top: 24rpx;

				&-info {
					display: flex;
					// justify-content: space-between;
					// column-gap: 14rpx;
					// width: 544rpx;
					width: 540rpx;
					height: 74rpx;
					// background: url('@/static/img/index/蓝@2x.png') no-repeat;
					background-image: url('@/static/img/index/蓝@2x.png');
					background-repeat: no-repeat;
					background-position: 0 0;
					background-size: contain;

					&-num {
						width: 66rpx;
						height: 74rpx;
						// background: #E8EFF8;
						border-radius: 5rpx;
						font-weight: bold;
						font-size: 40rpx;
						color: #333333;
						line-height: 74rpx;
						text-align: center;
						margin-right: 14rpx;
					}

					&-num:nth-child(1) {
						color: #FFFFFF;
					}

					// &-num:nth-child(7) {
					// 	margin-right: 0rpx;
					// }
					&-num:last-child {
						margin-right: 0rpx !important;
					}
				}

				&-btn {
					width: 66rpx;
					height: 74rpx;
					// background: url('@/static/img/index/添加新能源@2x.png') no-repeat;
					background-image: url('@/static/img/index/添加新能源@2x.png');
					background-repeat: no-repeat;
					background-position: center;
					background-size: contain;
				}
			}

			&-btn {
				width: 650rpx;
				height: 80rpx;
				background: #1D84FA;
				border-radius: 10rpx;
				font-size: 32rpx;
				color: #FFFFFF;
				line-height: 80rpx;
				text-align: center;
				margin-top: 62rpx;
			}
		}
	}
</style>