<template>
	<!-- 扫码缴费支付 -->
	<view class="pay">
		<view class="pay-title">{{ detailInfo.parking_lot }}</view>
		<view class="pay-con">
			<view class="pay-con-licence">
				<view class="pay-con-licence-num" :class=" '' | typeColorFilter(detailInfo.license_type)">
					{{ detailInfo.license_plate ? detailInfo.license_plate.slice(0, 2) : null }}<span></span>{{ detailInfo.license_plate ? detailInfo.license_plate.slice(2) : null }}
				</view>
			</view>
			<view class="pay-con-item">
				<view class="pay-con-item-key">驶入时间</view>
				<view class="pay-con-item-value">{{ detailInfo.entry_time }}</view>
			</view>
			<view class="pay-con-item">
				<view class="pay-con-item-key">停车时长</view>
				<view class="pay-con-item-value">{{ handleFormattedDuration(detailInfo.parking_duration) }}</view>
			</view>
			<view class="pay-con-amount">
				<view class="pay-con-amount-deal">
					<view class="pay-con-amount-deal-key">应付金额</view>
					<view class="pay-con-amount-deal-value">￥{{ detailInfo.receivable_amount || 0 }}</view>
				</view>
				<view class="pay-con-amount-subtract">
					<view class="pay-con-amount-subtract-key">
						<view class="pay-con-amount-subtract-key-left">减</view>
						<view class="pay-con-amount-subtract-key-right">商家减免</view>
					</view>
					<view class="pay-con-amount-subtract-value">无可用</view>
				</view>
				<view class="pay-con-amount-subtract">
					<view class="pay-con-amount-subtract-key">
						<view class="pay-con-amount-subtract-key-left">券</view>
						<view class="pay-con-amount-subtract-key-right">停车券</view>
					</view>
					<view class="pay-con-amount-subtract-value">无可用</view>
				</view>
				<view class="pay-con-amount-give">
					<view class="pay-con-amount-give-key">已优惠<span>￥{{ detailInfo.discount_amount || 0 }}</span></view>
					<view class="pay-con-amount-give-key">
						实付<span>￥{{ detailInfo.receivable_amount - detailInfo.discount_amount || 0 }}</span></view>
				</view>
			</view>
			<!-- 支付类型 -->
			<view class="pay-con-type">
				<u-radio-group v-model="payClient" placement="column" iconPlacement="right" @change="handleGroupChange">
					<u-radio :customStyle="{marginBottom: '22rpx'}" v-for="(item, index) in radioList" :key="index"
						:label="item.name" :name="item.name">
					</u-radio>
				</u-radio-group>
			</view>
		</view>
		<view class="pay-footer">
			<view class="pay-footer-left">
				<view class="pay-footer-left-total">合计:￥{{ detailInfo.receivable_amount - detailInfo.discount_amount || 0 }}
				</view>
				<view class="pay-footer-left-tip">超时未付款，将重新计算费用</view>
			</view>
			<view class="pay-footer-right" @click="handlePay">立即支付</view>
		</view>
	</view>
</template>

<script>
	import {
		mapActions,
		mapMutations,
		mapState
	} from 'vuex';
	export default {
		name: 'pay',
		components: {},
		data() {
			return {
				// 路由传值
				baseInfo: {
					// id: 1,
					// // 停车场
					// parking_lot: '李沧区停车场',
					// // 停车场id
					// parking_lot_id: 90,
					// // 车牌类型 蓝牌 || 黄牌 || 黑牌 || 黄绿 || 白牌 || 绿牌
					// license_type: '蓝牌',
					// // 车牌号
					// license_plate: '浙AVG123',
					// // 驶入时间
					// entry_time: '2024-11-21 17:29:56',
					// // 驶出时间
					// exit_time: '2024-11-25 14:05:10',
					// // 停车时长
					// parking_duration: '89小时30分钟',
					// // 应付金额
					// receivable_amount: '20',
					// // 已优惠
					// discount_amount: '0',
					// // 实付
					// payment_amount: '20',
					// // 支付状态
					// payment_status: null,
					// // 缴费类型 无牌车缴费 || 有牌车缴费 || 提前缴费
					// payType: null,
				},
				// 详情
				detailInfo: {
					id: null,
					// 停车场
					parking_lot: null,
					// 停车场id
					parking_lot_id: null,
					// 车牌类型 蓝牌 || 黄牌 || 黑牌 || 黄绿 || 白牌 || 绿牌
					license_type: null,
					// 车牌号
					license_plate: null,
					// 驶入时间
					entry_time: null,
					// 驶出时间
					exit_time: null,
					// 停车时长
					parking_duration: null,
					// 应付金额
					receivable_amount: null,
					// 已优惠
					discount_amount: null,
					// 实付
					payment_amount: null,
					// 支付状态
					payment_status: null,
					// 缴费类型 无牌车缴费 || 有牌车缴费 || 提前缴费
					payType: null,
				},
				// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
				type: null,
				// 支付类型 数据
				radioList: [{
						name: '微信支付'
					},
					{
						name: '支付宝'
					}
				],
				// u-radio-group的v-model绑定的值如果设置为某个radio的name，就会被默认选中
				// 支付类型 微信支付 || 支付宝
				payClient: '微信支付',
			}
		},
		onLoad(option) {
			if (option.baseInfo) {
				this.baseInfo = option.baseInfo
				console.log('baseInfo', this.baseInfo)
				// 获取 详情
				this.getDetail()
			}
		},
		onShow() {
			// 判断 微信环境 || 支付宝环境 || 其它 选择 支付类型 微信支付 || 支付宝
			this.payClient = this.detectPlatform() 
			console.log('onShow-payClient', this.payClient)
			console.log('userInfo', this.userInfo)
			console.log('openid', this.openid)

		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo,
				openid: state => state.openid,
			}),
		},
		filters: {
			// 车牌类型 车牌样式
			typeColorFilter(val, license_type) {
				console.log('车牌类型 车牌样式-val', val);
				console.log('车牌类型 车牌样式-licenceType', license_type);
				if (license_type === '蓝牌') return 'blue'
				if (license_type === '黄牌') return 'yellow'
				if (license_type === '黑牌') return 'black'
				if (license_type === '黄绿' || license_type === '绿牌') return 'green'
				if (license_type === '白牌') return 'white'
			}
		},
		methods: {
			...mapActions(['getSettlement', 'outYardPay', 'advancePay', 'openOutBarier']),
			...mapMutations(['setState']),
			// 获取 详情
			async getDetail() {
				const params = {
					id: Number(this.baseInfo.id) || null
					// id: Number(this.baseInfo.id) || 159
				}
				console.log('params', params)

				const res = await this.getSettlement(params)
				console.log('获取 订单 详情-res', res)
				console.log('获取 订单 详情-res.data', res.data)
				console.log('获取 订单 详情-res.data?.data', res.data?.data)
				if (res.flag == true) {
					if (res.data?.data && res.data?.data.length !== 0) {
						for (let i in this.detailInfo) {
							this.detailInfo[i] = res.data?.data[0][i]
						}
						console.log('详情-detailInfo', this.detailInfo);
						console.log('详情-detailInfo.payment_status', this.detailInfo.payment_status);

						if (this.detailInfo.payment_status === '已支付') { // 订单状态 已支付
							// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
							this.type = '支付成功'
							// 跳转页面 车场提示 支付成功
							uni.navigateTo({
								url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.detailInfo.parking_lot}`,
							})
						}
					}
				} else {
					uni.showToast({
						title: res.message,
						icon: 'none',
						duration: 2000 //持续的时间
					})
				}
			},
			// 立即支付
			async handlePay() {
				console.log('立即支付-payType', this.baseInfo.payType);
				console.log('立即支付-payClient', this.payClient);

				if (this.baseInfo.payType === '提前缴费') { // 提前缴费 支付
					if (this.detailInfo.receivable_amount - this.detailInfo.discount_amount === 0) { // 订单费用 0 元
						// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
						this.type = '免费时段'
						// 跳转页面 车场提示 免费时段
						uni.navigateTo({
							url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.detailInfo.parking_lot}`,
						})
					} else { // 订单费用 不为 0 元
						// 调用 支付
						const params = {
							payClient: this.payClient || null,
							parking_lot_info_id: this.detailInfo.parking_lot_id || null,
							plate_num: this.detailInfo.license_plate || null,
							subOpenId: this.openid || null,
						}

						const res = await this.advancePay(params)
						console.log('提前缴费 支付-res', res);
						console.log('提前缴费 支付-res.data', res.data)
						if (res.flag == true) {
							// 支付调用
							if (res.data?.respCode === 'SUCCESS' && res.data?.biz_content) {
								console.log('提前缴费 支付-biz_content', JSON.parse(res.data.biz_content));
								if (this.payClient === '支付宝') { // 支付宝 支付
									let url = JSON.parse(res.data.biz_content)?.qrCode
									console.log('支付宝链接-url', url);
									if (url) {
										// 打开 支付宝
										window.location.href = url
									}
								} else if (this.payClient === '微信支付') { // 微信 支付
									let payData = JSON.parse(res.data.biz_content).payData
									console.log('微信支付信息-payData', payData)
									if (payData) {
										if (typeof WeixinJSBridge == "undefined") {
											if (document.addEventListener) {
												document.addEventListener('WeixinJSBridgeReady', this.onBridgeReady(payData), false);
											} else if (document.attachEvent) {
												document.attachEvent('WeixinJSBridgeReady', this.onBridgeReady(payData));
												document.attachEvent('onWeixinJSBridgeReady', this.onBridgeReady(payData));
											}
										} else {
											this.onBridgeReady(payData);
										}
									}
								}
							} else {
								uni.showToast({
									title: res.data?.respMsg || '请求失败，请稍后重试',
									icon: 'none',
									duration: 2000 //持续的时间
								})
							}
						} else {
							uni.showToast({
								title: res.message,
								icon: 'none',
								duration: 2000 //持续的时间
							})
						}
					}
				} else { // 无牌车缴费 || 有牌车缴费 支付
					if (this.detailInfo.receivable_amount - this.detailInfo.discount_amount === 0) { // 订单费用 0 元
						// 调用 抬杆放行
						const params = {
							id: this.detailInfo.id || null,
							cam_id: this.baseInfo.camId || null,
							plate_num: this.detailInfo.license_plate || null,
						}

						const res = await this.openOutBarier(params)
						console.log('抬杆放行-res', res);
						if (res.flag == true) {
							// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
							this.type = '支付成功'
							// 跳转页面 车场提示 支付成功
							uni.navigateTo({
								url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.detailInfo.parking_lot}`,
							})
						} else {
							uni.showToast({
								title: res.message,
								icon: 'none',
								duration: 2000 //持续的时间
							})
						}
					} else { // 订单费用 不为 0 元
						// 调用 支付
						const params = {
							payClient: this.payClient || null,
							parking_lot_info_id: this.detailInfo.parking_lot_id || null,
							cam_id: this.baseInfo.camId || null,
							plate_num: this.detailInfo.license_plate || null,
							subOpenId: this.openid || null,
						}

						const res = await this.outYardPay(params)
						console.log('扫码出场 支付-res', res);
						if (res.flag == true) {
							// 支付调用
							if (res.data?.respCode === 'SUCCESS' && res.data?.biz_content) {
								console.log('扫码出场 支付-biz_content', JSON.parse(res.data.biz_content));
								if (this.payClient === '支付宝') { // 支付宝 支付
									let url = JSON.parse(res.data.biz_content)?.qrCode
									console.log('支付宝链接-url', url);
									if (url) {
										// 打开 支付宝
										window.location.href = url
									}
								} else if (this.payClient === '微信支付') { // 微信 支付
									let payData = JSON.parse(res.data.biz_content).payData
									console.log('微信支付信息-payData', payData)
									if (payData) {
										if (typeof WeixinJSBridge == "undefined") {
											if (document.addEventListener) {
												document.addEventListener('WeixinJSBridgeReady', this.onBridgeReady(payData), false);
											} else if (document.attachEvent) {
												document.attachEvent('WeixinJSBridgeReady', this.onBridgeReady(payData));
												document.attachEvent('onWeixinJSBridgeReady', this.onBridgeReady(payData));
											}
										} else {
											this.onBridgeReady(payData);
										}
									}
								}
							} else {
								uni.showToast({
									title: res.data?.respMsg || '请求失败，请稍后重试',
									icon: 'none',
									duration: 2000 //持续的时间
								})
							}
						} else {
							uni.showToast({
								title: res.message,
								icon: 'none',
								duration: 2000 //持续的时间
							})
						}
					}
				}

				// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
				// this.type = '支付成功'
				// // 跳转页面 车场提示 支付成功
				// uni.navigateTo({
				// 	url: `/pages/scanPay/tip?type=${this.type}&parkName=${this.detailInfo.parking_lot}`,
				// })
			},
			// JSAPI调起支付 微信支付
			onBridgeReady(payData) {
				console.log('JSAPI调起支付 微信支付-payData', payData);
				WeixinJSBridge.invoke(
					'getBrandWCPayRequest',
					payData,
					// {
					// 	"appId": "wx2421b1c4370ec43b", //公众号ID，由商户传入     
					// 	"timeStamp": "1395712654", //时间戳，自1970年以来的秒数     
					// 	"nonceStr": "e61463f8efa94090b1f366cccfbbb444", //随机串     
					// 	"package": "prepay_id=u802345jgfjsdfgsdg888",
					// 	"signType": "MD5", //微信签名方式：     
					// 	"paySign": "70EA570631E4BB79628FBCA90534C63FF7FADD89" //微信签名 
					// },
					function(res) {
						if (res.err_msg == "get_brand_wcpay_request:ok") {
							// 使用以上方式判断前端返回,微信团队郑重提示：
							//res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
						}
					});
			},
			// 支付类型 单选框 change事件
			handleGroupChange(value) {
				console.log('handleGroupChange-value', value);
				console.log('handleGroupChange-payClient', this.payClient);
			},
			// 分钟 转化 小时分钟 5370分钟 转化为 89小时30分钟
			handleFormattedDuration(totalMinutes) {
				// 定义总分钟数 totalMinutes 5370分钟

				// 计算小时数和剩余的分钟数
				const hours = Math.floor(totalMinutes / 60); // 5370 / 60 = 89 小时余 30 分钟
				const remainingMinutes = totalMinutes % 60; // 5370 % 60 = 30 分钟

				// 格式化输出
				let formattedDuration = `${String(hours).padStart(2, '0')}小时${String(remainingMinutes).padStart(2, '0')}分钟`;

				console.log(formattedDuration); // 输出：89小时30分
				if (formattedDuration === '00小时00分钟') {
					formattedDuration = null
				}
				return formattedDuration
			},
			// 判断 微信环境 || 支付宝环境 || 其它
			detectPlatform() {
				const userAgent = navigator.userAgent || navigator.vendor || window.opera;
				
				// 平台
				let platform = null
				if (/MicroMessenger/i.test(userAgent)) {
					// platform = 'WeChat'; // 微信
					platform = '微信支付'; // 微信
				} else if (/AlipayClient/i.test(userAgent)) {
					// platform = 'Alipay'; // 支付宝
					platform = '支付宝'; // 支付宝
				} else {
					// platform = 'Unknown'; // 其他浏览器
					platform = '微信支付'; // 其他浏览器
				}
			
				// 你可以在这里根据 platform 的值执行相应的逻辑
				console.log('当前平台:', platform);
				return platform
			}
		}
	}
</script>

<style lang="less" scoped>
	.pay {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		padding: 30rpx 0 0 0;

		&-title {
			font-weight: bold;
			font-size: 32rpx;
			color: #333333;
			line-height: 45rpx;
			margin: 0 0 20rpx 30rpx;
		}

		&-con {
			width: 690rpx;
			height: 820rpx;
			background: #FFFFFF;
			border-radius: 20rpx;
			margin: 0 0 0 30rpx;
			padding: 30rpx 0;

			&-licence {
				display: flex;
				justify-content: center;
				align-items: center;
				width: 630rpx;
				height: 90rpx;
				background: url('@/static/img/index/元素@2x.png') no-repeat;
				background-position: center;
				background-size: 100% 20rpx;
				margin: 0 30rpx;

				&-num {
					display: flex;
					justify-content: center;
					align-items: center;
					width: 220rpx;
					height: 70rpx;
					background-image: url('@/static/img/index/蓝牌@2x.png');
					background-repeat: no-repeat;
					background-position: 0 0;
					background-size: contain;
					font-weight: bold;
					font-size: 31rpx;
					color: #FFFFFF;
					letter-spacing: 1rpx;

					span {
						width: 8rpx;
						height: 8rpx;
						background: #FFFFFF;
						border-radius: 50%;
						margin: 0 12rpx 0 12rpx;
					}
				}

				// 蓝牌
				.blue {
					background-image: url('@/static/img/index/蓝牌@2x.png');
					color: #FFFFFF;

					span {
						background: #FFFFFF;
					}
				}

				// 黄牌
				.yellow {
					background-image: url('@/static/img/index/黄牌@2x.png');
					color: #333333;

					span {
						background: #333333;
					}
				}

				// 黑牌
				.black {
					background-image: url('@/static/img/index/黑牌@2x.png');
					color: #FFFFFF;

					span {
						background: #FFFFFF;
					}
				}

				// 黄绿 绿牌
				.green {
					background-image: url('@/static/img/index/新能源@2x.png');
					color: #333333;

					span {
						background: #333333;
						margin: 0 7rpx 0 7rpx;
					}
				}

				// 白牌
				.white {
					background-image: url('@/static/img/index/白牌@2x.png');
					color: #333333;

					span {
						background: #333333;
					}
				}
			}

			&-item {
				width: 100%;
				display: flex;
				justify-content: space-between;
				align-items: center;
				border-bottom: 1rpx solid #D1DFEC;
				padding: 30rpx;

				&-key {
					font-size: 30rpx;
					color: #333333;
					line-height: 42rpx;
				}

				&-value {
					font-size: 30rpx;
					color: #333333;
					line-height: 42rpx;
				}
			}

			&-amount {
				width: 100%;
				border-bottom: 1rpx solid #D1DFEC;
				padding: 30rpx;

				&-deal {
					width: 100%;
					display: flex;
					justify-content: space-between;
					align-items: center;
					margin: 0 0 30rpx 0;

					&-key {
						font-size: 30rpx;
						color: #333333;
						line-height: 42rpx;
					}

					&-value {
						font-size: 30rpx;
						font-weight: bold;
						color: #FF5151;
						line-height: 42rpx;
					}
				}

				&-subtract {
					width: 100%;
					display: flex;
					justify-content: space-between;
					align-items: center;
					margin: 0 0 30rpx 0;

					&-key {
						display: flex;
						align-items: center;
						font-size: 30rpx;
						color: #333333;
						line-height: 42rpx;

						&-left {
							width: 40rpx;
							height: 42rpx;
							background: #FF5151;
							border-radius: 4rpx;
							font-weight: bold;
							font-size: 30rpx;
							color: #FFFFFF;
							line-height: 42rpx;
							text-align: center;
							margin: 0 14rpx 0 0;
						}
					}

					&-value {
						font-size: 30rpx;
						color: #83909F;
						line-height: 42rpx;
					}
				}

				&-give {
					width: 100%;
					display: flex;
					justify-content: right;
					align-items: center;

					&-key {
						display: flex;
						align-items: center;
						font-size: 30rpx;
						color: #333333;
						line-height: 42rpx;
						margin: 0 0 0 54rpx;

						span {
							font-weight: bold;
							color: #FF5151;
						}
					}
				}
			}

			&-type {
				width: 100%;
				padding: 30rpx;

				/deep/.u-radio__text {
					display: flex;
					font-family: PingFang SC, PingFang SC;
					font-weight: 400;
					font-size: 30rpx !important;
					color: #333333 !important;
					line-height: 48rpx !important;
				}

				/deep/.u-radio__text::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/index/微信@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}

				/deep/.u-radio:last-child .u-radio__text::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/index/支付宝@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}
			}
		}

		&-footer {
			display: flex;
			position: fixed;
			left: 0;
			bottom: 0;
			width: 750rpx;
			height: 100rpx;
			background: #FFFFFF;
			border-radius: 0rpx 0rpx 0rpx 0rpx;

			&-left {
				width: calc(100% - 258rpx);
				height: 100rpx;
				padding: 4rpx 0 0 30rpx;

				&-total {
					font-weight: bold;
					font-size: 32rpx;
					color: #FF5151;
					line-height: 45rpx;
					margin: 0 0 9rpx 0;
				}

				&-tip {
					font-size: 26rpx;
					color: #83909F;
					line-height: 37rpx;
				}
			}

			&-right {
				width: 258rpx;
				height: 100rpx;
				background: #1D84FA;
				font-size: 34rpx;
				color: #FFFFFF;
				line-height: 100rpx;
				text-align: center;
			}
		}
	}
</style>