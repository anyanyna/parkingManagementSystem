<template>
	<!-- 入场提示 -->
	<view class="tip">
		<view class="tip-title">{{ parkName }}</view>
		<view class="tip-con">
			<image :style="type === '支付成功' ? 'width: 284.37rpx; height: 266.67rpx;' : 'width: 273.3rpx; height: 286.4rpx;'" :src="type === '支付成功' ? require('@/static/img/index/支付成功@2x.png') : require('@/static/img/index/暂无订单@2x.png')" mode=""></image>
			<view class="tip-con-title" :style="type === '支付成功' ? 'color: #0ECB91' : 'color: #7D90A7'">{{ typeTextFilter(type) }}</view>
<!-- 			<view class="tip-con-title" :style="type === '支付成功' ? 'color: #0ECB91' : 'color: #7D90A7'">{{ type === '支付成功' ? '支付成功' : (type === '无当前车牌订单' ? '无当前车牌订单' : '异常订单') }}</view> -->
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'tipPay',
		components: {},
		data() {
			return {
				// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
				type: null,
				// 车场名称
				parkName: null,
			}
		},
		onLoad(option) {
			// 车场ID
			this.type = option.type
			console.log('车场提示 类型-type',this.type);
			// 车场名称
			this.parkName = option.parkName
			console.log('车场名称-parkName', this.parkName)
		},
		onShow() {
			console.log('userInfo', this.userInfo)
		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo
			}),
		},
		methods: {
			...mapActions(['']),
			...mapMutations(['setState']),
			// 车场提示 类型 无当前车牌订单 || 支付成功 || '异常订单' || '免费时段'
			typeTextFilter (type) {
				console.log('车场提示 类型-type',type);
				if (type === '无当前车牌订单') return '无当前车牌订单'
				if (type === '支付成功') return '支付成功'
				if (type === '异常订单') return '异常订单，请联系车场管理员'
				if (type === '免费时段') return '当前车辆再免费停车时段内'
			}
		}
	}
</script>

<style lang="less" scoped>
	.tip {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		padding: 30rpx;
		
		&-title {
			font-weight: bold;
			font-size: 32rpx;
			color: #333333;
			line-height: 45rpx;
			margin: 0 0 87rpx 0;
		}
		
		&-con {
			display: flex;
			flex-direction: column;
			// justify-content: center;
			align-items: center;
			width: 100%;
			
			image {
				width: 273.3rpx;
				height: 286.4rpx;
			}
			
			&-title {
				font-weight: bold;
				font-size: 36rpx;
				color: #7D90A7;
				line-height: 50rpx;
				margin-top: 41rpx;
			}
			
		}
	}
</style>