<template>
	<!-- 我的钱包 -->
	<view class="purse">
		<!-- 导航栏 -->
		<navbar class="purse-navbar" title="我的钱包" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="purse-con">
			<view class="purse-con-info">
				<view class="purse-con-info-title">当前账户余额</view>
				<view class="purse-con-info-amount"><span>￥</span>201.05</view>
				<view class="purse-con-info-btn" @click="handlePay">充值</view>
			</view>
		</view>
		<!-- 列表 -->
		<view class="purse-list">
			<view class="purse-list-item" v-for="(item,index) in purseList" :key="item.id">
				<view class="purse-list-item-con">
					<view class="purse-list-item-con-key">{{ item.name }}</view>
					<view class="purse-list-item-con-key">{{ item.amount }}</view>
				</view>
				<view class="purse-list-item-con">
					<view class="purse-list-item-con-value">{{ item.time }}</view>
					<view class="purse-list-item-con-value">余额:{{ item.balance || 0.00 }}</view>
				</view>
			</view>
		</view>
		<!-- 上拉加载 -->
		<view v-show="isLoadMore" class="purse-load" :class="total === 0 ? 'tip' : ''">
			<u-loadmore :status="status" :line="true" :icon="false" :loading-text="loadingText" :loadmore-text="loadmoreText" :nomore-text="nomoreText" marginTop="0" marginBottom="0" />
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'purse',
		components: {},
		data() {
			return {
				// 路由传值
				baseInfo: {},
				// 列表数量
				total: 0,
				current: 1,
				size: 10,
				status: 'loading',
				//是否加载中
				isLoadMore: false,
				loadingText: '努力加载中',
				loadmoreText: '轻轻上拉',
				nomoreText: '暂无数据',
				// 充值明细 列表
				purseList: [
					{
						id: 1,
						name: '充值',
						time: '2024-01-09 05:00:01',
						amount: '+100.00',
						balance: '100.00'
					},
					{
						id: 2,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '-5.00',
						balance: '15.00'
					},
					{
						id: 3,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '-5.00',
						balance: '0'
					},
					{
						id: 4,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 5,
						name: '充值',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 6,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 7,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 8,
						name: '充值',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 9,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 10,
						name: '充值',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
					},
					{
						id: 11,
						name: '停车缴费',
						time: '2024-01-09 05:00:01',
						amount: '15.00',
						balance: '15.00'
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
		methods: {
			...mapActions(['']),
			...mapMutations(['setState']),
			// 充值
			handlePay() {
				console.log('订单缴费-baseInfo',this.baseInfo);
				uni.navigateTo({
					url: '/pages/purse/recharge?baseInfo='+encodeURIComponent(JSON.stringify(this.baseInfo))
				})
			},
		}
	}
</script>

<style lang="less" scoped>
	.purse {
		width: 100%;
		// height: 100vh;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 列表设置
		&-navbar {
			position: fixed;
			top: 0;
			width: 100%;
			background: url('@/static/img/purse/bg1@2x.png') no-repeat;
			background-position: 0 0;
			background-size: cover;
		}
		
		// 列表设置
		&-con {
			position: fixed;
			top: 88rpx;
			width: 100%;
			height: 306rpx;
			background: url('@/static/img/purse/bg2@2x.png') no-repeat;
			background-position: 0 0;
			background-size: 100% 216rpx;
			padding: 65rpx 30rpx 0 30rpx;
			z-index: 9999;
			
			&-info {
				position: relative;
				width: 100%;
				height: 211rpx;
				background: url('@/static/img/purse/bg3@2x.png') no-repeat;
				background-position: 0 0;
				background-size: cover;
				padding: 34rpx 30rpx 0 30rpx;
				
				&-title {
					font-size: 32rpx;
					color: #1C3148;
					line-height: 45rpx;
					margin: 0 0 14rpx 0;
				}
				
				&-amount {
					font-weight: bold;
					font-size: 60rpx;
					color: #1C3148;
					line-height: 84rpx;
					
					span {
						font-size: 26rpx;
					}
				}
				
				&-btn {
					position: absolute;
					top: 73rpx;
					right: 40rpx;
					width: 222rpx;
					height: 66rpx;
					background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
					border-radius: 300rpx;
					font-size: 32rpx;
					color: #FFFFFF;
					line-height: 66rpx;
					text-align: center;
				}
			}
		}
		
		&-list {
			position: fixed;
			width: 690rpx;
			height: calc(100% - 424rpx);
			z-index: 1;
			background: #FFFFFF;
			border-radius: 10rpx;
			margin: 394rpx 30rpx 0 30rpx;
			padding: 30rpx;
			overflow: auto;
			
			&-item {
				width: 100%;
				margin: 0 0 30rpx 0;
				
				&-con {
					display: flex;
					align-items: center;
					justify-content: space-between;
					width: 100%;
					margin: 0 0 12rpx 0;
					
					&-key {
						font-weight: bold;
						font-size: 30rpx;
						color: #1C3148;
						line-height: 42rpx;
					}
					
					&-value {
						font-size: 26rpx;
						color: #687582;
						line-height: 37rpx;
					}
				}
				
				&-con:last-child {
					margin-bottom: 0;
				}
			}
			
			&-item:last-child {
				margin-bottom: 0;
			}
		}
		
		&-load {
			padding-bottom: 30rpx;
		}
		.tip {
			position: absolute;
			left: 50%;
			top: 50%;
			transform: translate(-50%,-50%);
		}
	}
</style>