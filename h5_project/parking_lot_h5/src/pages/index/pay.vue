<template>
	<!-- 缴费 -->
	<view class="pay">
		<!-- 导航栏 -->
		<navbar class="pay-navbar" title="缴费" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="pay-con">
			<view class="pay-con-title">缴费金额</view>
			<view class="pay-con-amount">{{ 4.50 }}元</view>
			<view class="pay-con-select">
				<view class="pay-con-select-left">选择优惠券</view>
				<view class="pay-con-select-right">-2.00</view>
			</view>
			<!-- 支付类型 -->
			<view class="pay-con-type">
				<u-radio-group v-model="payClient" placement="column" iconPlacement="right" @change="handleGroupChange">
					<u-radio :customStyle="{marginBottom: '26rpx'}" v-for="(item, index) in radioList" :key="index"
						:label="item.name" :name="item.name">
					</u-radio>
				</u-radio-group>
				<view class="pay-con-type-amount">当前余额<span>2.50</span>元</view>
			</view>
			<view class="pay-con-btn" @click="handlePay">立即支付</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'pay',
		components: {},
		data() {
			return {
				// 支付类型 数据
				radioList: [
					{
						name: '钱包支付'
					},
					{
						name: '微信支付'
					},
					{
						name: '支付宝'
					}
				],
				// u-radio-group的v-model绑定的值如果设置为某个radio的name，就会被默认选中
				// 支付类型 钱包支付 || 微信支付 || 支付宝
				payClient: '钱包支付',
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
			// 立即支付
			handlePay() {
				console.log('立即支付-payClient', this.payClient);
			},
			// 支付类型 单选框 change事件
			handleGroupChange(value) {
				console.log('handleGroupChange-value', value);
				console.log('handleGroupChange-payClient', this.payClient);
			},
		}
	}
</script>

<style lang="less" scoped>
	.pay {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;


		// 非列表设置
		&-con {
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			width: 100%;
			padding: 30rpx;
			
			&-title {
				font-size: 32rpx;
				color: #1C3148;
				line-height: 45rpx;
				margin: 0 0 16rpx 0;
			}
			
			&-amount {
				font-weight: bold;
				font-size: 36rpx;
				color: #FF5151;
				line-height: 50rpx;
				margin: 0 0 57rpx 0;
			}
			
			&-select {
				width: 100%;
				height: 48rpx;
				display: flex;
				align-items: center;
				justify-content: space-between;
				margin: 0 0 24rpx 0;
				
				&-left {
					display: flex;
					align-items: center;
					font-size: 30rpx;
					color: #1C3148;
					line-height: 42rpx;
				}
				
				&-left::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/pay/优惠券@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}
				
				&-right {
					display: flex;
					align-items: center;
					font-weight: bold;
					font-size: 30rpx;
					color: #FF5151;
					line-height: 42rpx;
				}
				
				&-right::after {
					content: '';
					display: inline-block;
					width: 16.67rpx;
					height: 30.12rpx;
					background: url('@/static/img/pay/返回@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 0 0 20rpx;
				}
			}
			
			&-type {
				position: relative;
				width: 100%;
				
				&-amount {
					position: absolute;
					top: 3rpx;
					right: 56rpx;
					color: #687582;
					line-height: 40rpx;
					
					span {
						color: #FF5151;
					}
				}
				
			
				/deep/.u-radio__text {
					display: flex;
					font-family: PingFang SC, PingFang SC;
					font-weight: 400;
					font-size: 30rpx !important;
					color: #333333 !important;
					line-height: 48rpx !important;
				}
			
				/deep/.u-radio:first-child .u-radio__text::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/pay/钱包@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}
				
				/deep/.u-radio:nth-child(2) .u-radio__text::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/pay/微信@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}
			
				/deep/.u-radio:last-child .u-radio__text::before {
					content: '';
					display: inline-block;
					width: 48rpx;
					height: 48rpx;
					background: url('@/static/img/pay/支付宝@2x.png') no-repeat;
					background-position: 0 0;
					background-size: contain;
					margin: 0 14rpx 0 0;
				}
			}
			
			&-btn {
				width: 100%;
				height: 80rpx;
				background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
				border-radius: 8rpx;
				font-size: 30rpx;
				color: #FFFFFF;
				line-height: 80rpx;
				text-align: center;
				margin: 64rpx 0 0 0;
			}
		}
	}
</style>
