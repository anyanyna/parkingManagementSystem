<template>
	<!-- 入场提示 -->
	<view class="tip">
		<view class="tip-title">{{ parkName }}</view>
		<view class="tip-con">
			<image src="@/static/img/index/车辆入场@2x.png" mode=""></image>
			<view class="tip-con-title">车辆入场</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'tipEntrance',
		components: {},
		data() {
			return {
				// 车场名称
				parkName: null,
			}
		},
		onLoad(option) {
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
				width: 318.85rpx;
				height: 295.34rpx;
			}
			
			&-title {
				font-weight: bold;
				font-size: 36rpx;
				color: #333333;
				line-height: 50rpx;
				margin-top: 41rpx;
			}
			
		}
	}
</style>