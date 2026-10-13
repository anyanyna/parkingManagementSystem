<template>
	<!-- 订单详情 -->
	<view class="park">
		<!-- 导航栏 -->
		<navbar class="park-navbar" title="订单详情" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="park-con">
			<view class="park-con-info">
				<view class="park-con-info-title">{{ detailInfo.parking_lot }}</view>
				<view class="park-con-info-car">
					<view class="park-con-info-car-item">
						<view class="park-con-info-car-item-icon">
							<image :src="detailInfo.entry_url" mode=""></image>
						</view>
						<view class="park-con-info-car-item-key">入场时间</view>
						<view class="park-con-info-car-item-value">{{ detailInfo.entry_time }}</view>
					</view>
					<view class="park-con-info-car-item">
						<view class="park-con-info-car-item-icon">
							<image :src="detailInfo.exit_url" mode=""></image>
						</view>
						<view class="park-con-info-car-item-key">出场时间</view>
						<view class="park-con-info-car-item-value">{{ detailInfo.exit_time }}</view>
					</view>
				</view>
				<view class="park-con-info-line"></view>
				<view class="park-con-info-item" v-for="(con, index) in orderInfo" :key="index">
					<view class="park-con-info-item-key">{{ con.title }}</view>
					<view v-if="con.key === 'license_plate'" class="park-con-info-item-licence" :class=" '' | typeColorFilter(detailInfo.license_type)">
						{{ detailInfo[con.key] ? detailInfo[con.key].slice(0, 2) : null }}<span></span>{{ detailInfo[con.key] ? detailInfo[con.key].slice(2) : null }}
					</view>
					<view v-else class="park-con-info-item-value" :class="con.key === 'payment_amount' ? 'park-con-info-item-value1' : ''">{{ con.key === 'parking_duration' ? handleFormattedDuration(detailInfo[con.key]) : detailInfo[con.key] }}</view>
				</view>
			</view>
			<view class="park-con-btn">
				<view class="park-con-btn-view" @click="handleView">查看收费明细</view>
				<view class="park-con-btn-pay" @click="handlePay">订单缴费</view>
			</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'parkDetail',
		components: {},
		data() {
			return {
				// 路由传值
				baseInfo: {
					id: 1,
					// 订单编号
					code: 'xxd12233445',
					// 停车场
					parking_lot: '李沧区停车场',
					// 停车场id
					parking_lot_id: 90,
					// 车牌类型 蓝牌 || 黄牌 || 黑牌 || 黄绿 || 白牌 || 绿牌
					license_type: '绿牌',
					// 车牌号
					license_plate: '浙AVG1231',
					// 驶入时间
					entry_time: '2024-11-21 17:29:56',
					// 驶出时间
					exit_time: '2024-11-25 14:05:10',
					// 驶入照片
					entry_url: 'https://i.cdncf.xyz/fedad2a594cd53059a4d811fd5e2894b.jpg',
					// 驶出照片
					exit_url: 'https://i.cdncf.xyz/fedad2a594cd53059a4d811fd5e2894b.jpg',
					// 停车时长
					// parking_duration: '89小时30分钟',
					parking_duration: '5370',
					// 订单金额
					receivable_amount: '20',
					// 优惠金额
					discount_amount: '0',
					// 实付金额
					payment_amount: '20',
					// 支付状态
					payment_status: null,
					// 缴费类型 无牌车缴费 || 有牌车缴费 || 提前缴费
					payType: null,
				},
				// 详情
				detailInfo: {
					id: null,
					// 订单编号
					code: null,
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
					// 驶入照片
					entry_url: null,
					// 驶出照片
					exit_url: null,
					// 停车时长
					parking_duration: null,
					// 订单金额
					receivable_amount: null,
					// 优惠金额
					discount_amount: null,
					// 实付金额
					payment_amount: null,
					// 支付状态
					payment_status: null,
					// 缴费类型 无牌车缴费 || 有牌车缴费 || 提前缴费
					payType: null,
				},
				// 订单信息
				orderInfo: [
					{ key: 'code', title: '订单编号' },
					{ key: 'license_plate', title: '车牌号' },
					{ key: 'parking_duration', title: '停车时长' },
					{ key: 'receivable_amount', title: '订单金额' },
					{ key: 'discount_amount', title: '优惠金额' },
					{ key: 'payment_amount', title: '实时金额' },
				]
			}
		},
		onLoad(option) {
			// if (option.baseInfo) {
			// 	this.baseInfo = option.baseInfo
			// 	console.log('baseInfo', this.baseInfo)
			// 	// 获取 详情
			// 	this.getDetail()
			// }
			
			// 获取 详情
			this.getDetail()
		},
		onShow() {
			console.log('userInfo', this.userInfo)
		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo
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
			...mapActions(['']),
			...mapMutations(['setState']),
			// 获取 详情
			async getDetail() {
				this.detailInfo = this.baseInfo
				console.log('详情-detailInfo', this.detailInfo);
				
			// 	const params = {
			// 		id: this.baseInfo.id || null
			// 	}
			// 	console.log('params', params)
			
			// 	const res = await this.getSettlement(params)
			// 	console.log('获取 订单 详情-res', res)
			// 	if (res.flag == true) {
			// 		if (res.data?.data && res.data?.data.length !== 0) {
			// 			for (let i in this.detailInfo) {
			// 				this.detailInfo[i] = res.data?.data[0][i]
			// 			}
			// 			console.log('详情-detailInfo', this.detailInfo);
			// 		}
			// 	} else {
			// 		uni.showToast({
			// 			title: res.message,
			// 			icon: 'none',
			// 			duration: 2000 //持续的时间
			// 		})
			// 	}
			},
			// 查看 收费明细
			handleView() {
				console.log('订单缴费-baseInfo',this.baseInfo);
				uni.navigateTo({
					url: '/pages/park/chargeDetail?baseInfo='+encodeURIComponent(JSON.stringify(this.baseInfo))
				})
			},
			// 订单缴费
			handlePay() {
				console.log('订单缴费-baseInfo',this.baseInfo);
				uni.navigateTo({
					url: '/pages/index/pay?baseInfo='+encodeURIComponent(JSON.stringify(this.baseInfo))
				})
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
		}
	}
</script>

<style lang="less" scoped>
	.park {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
				
		// 非列表设置
		&-con {
			width: 100%;
			padding: 30rpx;
			
			&-info {
				width: 100%;
				height: 994rpx;
				background: #FFFFFF;
				border-radius: 10rpx;
				padding: 20rpx;
				
				&-title {
					font-weight: bold;
					font-size: 34rpx;
					color: #1C3148;
					line-height: 48rpx;
					margin: 0 0 20rpx 0;
				}
				
				&-car {
					display: flex;
					justify-content: space-between;
					width: 100%;
					height: 446rpx;
					
					&-item {
						width: 310rpx;
						background: #EBEEF1;
						border: 1rpx dashed #687582;
						border-radius: 10rpx;
						padding: 20rpx 22rpx 0rpx 22rpx;
						
						&-icon {
							width: 266rpx;
							height: 261rpx;
							background: #D5C0C0;
							border-radius: 10rpx;
							margin: 0 0 18rpx 0;
							
							image {
							  width: 100%;
							  height: 100%;
							}
						}
						
						&-key {
							font-size: 30rpx;
							color: #687582;
							line-height: 42rpx;
							margin: 0 0 12rpx 0;
						}
						
						&-value {
							color: #1C3148;
							line-height: 39rpx;
						}
						
					}
				}
				
				&-line {
					width: 690rpx;
					height: 2rpx;
					background: #e8ecef;
					margin: 20rpx 0 20rpx -20rpx;
				}
				
				&-item {
					display: flex;
					justify-content: space-between;
					align-items: center;
					margin-bottom: 27rpx;
							
					&-key {
						min-width: 170rpx;
						font-size: 30rpx;
						color: #6A717B;
						line-height: 42rpx;
						// white-space:nowrap;
					}
							
					&-value {
						max-width: 450rpx;
						font-size: 30rpx;
						color: #1C3148;
						line-height: 42rpx;
						word-break: break-all;
						// white-space:nowrap;
						// overflow:hidden;
						// text-overflow:ellipsis;
					}
					
					&-value1 {
						color: #FF5151;
					}
					
					&-licence {
						display: flex;
						justify-content: center;
						align-items: center;
						width: 182rpx;
						height: 58rpx;
						background-image: url('@/static/img/index/蓝牌@2x.png');
						background-repeat: no-repeat;
						background-position: 0 0;
						background-size: contain;
						font-weight: bold;
						font-size: 25rpx;
						color: #FFFFFF;
						letter-spacing: 1rpx;
										
						span {
							width: 7rpx;
							height: 7rpx;
							background: #FFFFFF;
							border-radius: 50%;
							margin: 0 10rpx 0 10rpx;
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
						background-image: url('@/static/img/index/绿牌@2x.png');
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
			}
			
			&-btn {
				display: flex;
				justify-content: space-between;
				column-gap: 30rpx;
				width: 100%;
				margin: 30rpx 0 0 0;
				
				&-view {
					width: 100%;
					height: 80rpx;
					border: 1rpx solid #1D84FA;
					border-radius: 8rpx;
					font-size: 30rpx;
					color: #1D84FA;
					line-height: 80rpx;
					text-align: center;
				}
				
				&-pay {
					width: 100%;
					height: 80rpx;
					background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
					border-radius: 8rpx;
					font-size: 30rpx;
					color: #FFFFFF;
					line-height: 80rpx;
					text-align: center;
				}
				
			}
		}
	}
</style>