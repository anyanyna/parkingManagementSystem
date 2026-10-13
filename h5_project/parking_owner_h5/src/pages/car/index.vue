<template>
	<!-- 我的车辆 -->
	<view class="car">
		<!-- 导航栏 -->
		<navbar class="car-navbar" title="我的车辆" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="car-con">
			<view class="car-con-card" v-for="(item,index) in carList" :key="item.id">
				<view class="car-con-card-licence">
					<view class="car-con-card-licence-title">{{ item.name }}</view>
					<view v-if="item.status === '已绑定'" class="car-con-card-licence-num" :class=" '' | typeColorFilter(item.type)">
						{{ item.licence ? item.licence.slice(0, 2) : null }}<span></span>{{ item.licence ? item.licence.slice(2) : null }}
					</view>
					<view v-if="item.status === '待绑定'" class="car-con-card-licence-status">待绑定</view>
				</view>
				<view class="car-con-card-amount">
					<template v-if="item.amount && item.amount != 0">欠费<span>￥{{ item.amount }}</span></template>
					<template v-else>暂无欠费</template>
				</view>
				<view v-if="item.status === '已绑定'" class="car-con-card-handle">
					<view class="car-con-card-handle-item" @click="handleRelieve(item)">解绑车辆</view>
					<view class="car-con-card-handle-item" @click="handlePay(item)">一键清欠</view>
				</view>
				<view v-if="item.status === '待绑定'" class="car-con-card-btn" @click="handleBind(item)">绑定车辆</view>
			</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'car',
		components: {},
		data() {
			return {
				carList: [
					{
						id: 1,
						licence: '浙AVG1211',
						type: '绿牌',
						name: '主',
						status: '已绑定',
						// amount: null
						// amount: '0'
						amount: '15.00'
					},
					{
						id: 2,
						licence: '浙AVG1222',
						type: '绿牌',
						name: '副',
						status: '待绑定',
						amount: null
					}
				]
			}
		},
		onLoad(option) {},
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
				// console.log('车牌类型 车牌样式-licenceType', license_type);
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
			// 解绑车辆
			handleRelieve(item) {
				console.log('解绑车辆-item',item);
			},
			// 一键清欠
			handlePay(item) {
				console.log('一键清欠-item',item);
				if (!item.amount || item.amount == 0) return uni.showToast({
					title: '暂无欠费！',
					icon: 'none',
					duration: 2000,
				})
				uni.navigateTo({
					url: '/pages/index/pay?baseInfo='+encodeURIComponent(JSON.stringify(item))
				})
			},
			// 绑定车辆
			handleBind(item) {
				console.log('绑定车辆-item',item);
				uni.navigateTo({
					url: '/pages/car/certification?baseInfo='+encodeURIComponent(JSON.stringify(item))
				})
			},
		}
	}
</script>

<style lang="less" scoped>
	.car {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 列表设置
		// &-navbar {
		// 	position: fixed;
		// }
		
		// 列表设置
		// &-con {
		// 	position: fixed;
		// 	top: 88rpx;
		// 	width: 100%;
		// 	background: #F0F2F5;
		// 	z-index: 999;
		// }
		
		// 非列表设置
		&-con {
			width: 100%;
			padding: 30rpx;
			
			&-card {
				display: flex;
				flex-direction: column;
				align-items: center;
				width: 100%;
				height: 262rpx;
				background: #FFFFFF;
				border-radius: 10rpx;
				padding: 20rpx 0 0 0;
				margin-bottom: 30rpx;
				
				&-licence {
					display: flex;
					justify-content: center;
					align-items: center;
					column-gap: 18rpx;
					margin: 0 0 21rpx 0;
					
					&-title {
						font-weight: bold;
						font-size: 30rpx;
						color: #1C3148;
						line-height: 42rpx;
					}
					
					&-status {
						width: 182rpx;
						height: 58rpx;
						background: #B8C9DB;
						border-radius: 6rpx;
						color: #FFFFFF;
						line-height: 58rpx;
						text-align: center;
					}
				
					&-num {
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
				
				&-amount {
					color: #687582;
					line-height: 40rpx;
					margin: 0 0 38rpx 0;
					
					span {
						font-weight: bold;
						color: #FF5151;
					}
				}
				
				&-handle {
					display: flex;
					// justify-content: center;
					align-items: center;
					width: 100%;
					height: 82rpx;
					border-top: 2rpx solid #e8ecef;
					
					&-item {
						width: 50%;
						font-size: 30rpx;
						color: #1D84FA;
						line-height: 50rpx;
						// line-height: 42rpx;
						text-align: center;
					}
					
					&-item:first-child {
						border-right: 2rpx solid #e8ecef;
					}
				}
				
				&-btn {
					width: 630rpx;
					height: 70rpx;
					background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
					border-radius: 8rpx;
					font-size: 30rpx;
					color: #FFFFFF;
					line-height: 70rpx;
					text-align: center;
				}
			}
		}
	}
</style>