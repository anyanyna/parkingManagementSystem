<template>
	<!-- 充值 -->
	<view class="purse">
		<!-- 导航栏 -->
		<navbar class="purse-navbar" title="充值" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="purse-con">
			<view class="purse-con-form">
				<u-form :model="formInfo" :rules="rules" ref="form" labelWidth="auto" :labelStyle="{color: '#1C3148',fontSize: '30rpx',fontWeight: 'bold'}">
					<view class="purse-con-form-item">
						<u-form-item label="充值" borderBottom prop="amount">
							<u-input v-model="formInfo.amount" type="number" border="none" color="#1C3148" placeholder="请输入您要充值的金额" placeholderStyle="color: #687582;" inputAlign="left" prefixIcon="rmb" prefixIconStyle="font-size: 18px;color: #1C3148" clearable />
						</u-form-item>
					</view>
					<view class="purse-con-form-item radio">
						<u-form-item label="充值方式" prop="type">
							<u-radio-group v-model="formInfo.type" placement="column" iconPlacement="right" @change="handleGroupChange">
								<u-radio :customStyle="{marginBottom: '26rpx'}" v-for="(item, index) in typeRadioList" :key="index"
									:label="item.name" :name="item.name">
								</u-radio>
							</u-radio-group>
						</u-form-item>
					</view>
					<view class="purse-con-form-item">
						<u-form-item prop="agreement">
							<u-radio-group v-model="formInfo.agreement" placement="column">
								<u-radio :customStyle="{marginBottom: '26rpx'}" v-for="(item, index) in agreementRadioList" :key="index"
									:label="item.name" :name="item.name">
								</u-radio>
							</u-radio-group>
						</u-form-item>
						<view class="purse-con-form-item-agreement" @click="handleView">《用户服务协议》</view>
					</view>
				</u-form>
			</view>
			<view class="purse-con-btn" @click="handleSubmit">立即充值</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'purseRecharge',
		components: {},
		data() {
			return {
				// 表单
				formInfo: {
					amount: null,
					type: null,
					agreement: null,
				},
				rules: {
					amount: {
						type: 'string',
						required: true,
						message: '请输入您要充值的金额',
						trigger: ['blur', 'change']
					},
					type: {
						type: 'string',
						required: true,
						message: '请选择充值方式',
						trigger: ['blur', 'change']
					},
					agreement: {
						type: 'string',
						required: true,
						message: '请选择用户服务协议',
						trigger: ['blur', 'change']
					},
				},
				// 充值方式 数据
				typeRadioList: [
					{
						name: '微信支付'
					},
					{
						name: '支付宝'
					}
				],
				// 用户服务协议 数据
				agreementRadioList: [
					{
						name: '本人已阅读并同意'
					}
				],
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
			// 提交
			handleSubmit () {
				// 如果有错误，会在catch中返回报错信息数组，校验通过则在then中返回true
				this.$refs.form.validate().then(res => {
					console.log('this.formInfo',this.formInfo)
					
					const params = {
						...this.formInfo,
					}
					console.log('params',params)
					// this.addVisitorReservation(params).then(res => {
					// 	if (res.code == 20000) {
					// 		uni.showToast({
					// 			title: '成功!',
					// 			icon: 'none',
					// 			duration: 2000 //持续的时间
					// 		})
					// 		setTimeout(() => {
					// 			// 取消 返回上一页面
					// 			this.handleBack()
					// 		},500)
					// 	} else {
					// 		uni.showToast({
					// 			title: res.message,
					// 			icon: 'none',
					// 			duration: 2000 //持续的时间
					// 		})
					// 	}
					// })
				}).catch(errors => {
					// uni.$u.toast(errors)
				})
			},
			// 充值方式 单选框 change事件
			handleGroupChange(value) {
				console.log('handleGroupChange-value', value);
				console.log('handleGroupChange-this.formInfo.type', this.formInfo.type);
			},
			// 查看 用户服务协议
			handleView() {
				console.log('查看 用户服务协议')
			},
		}
	}
</script>

<style lang="less" scoped>
	.purse {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 非列表设置
		&-con {
			width: 100%;
			padding: 30rpx;
			
			&-form {
				width: 100%;
				&-item {
					position: relative;
					margin: 0 0 24rpx 0;
					
					&-agreement {
						position: absolute;
						top: 21rpx;
						left: 290rpx;
						font-size: 26rpx;
						color: #1D84FA;
						line-height: 37rpx;
					}
				}
				
				&-item:first-child {
					border-bottom: 0;
				}
				
				/deep/.u-form-item__body {
					display: block;
					padding: 0;
				}
				
				/deep/.u-form-item__body__right {
					padding: 20rpx 0;
				}
				
				.radio {
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
			}
			
			&-btn {
				width: 690rpx;
				height: 80rpx;
				background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
				border-radius: 8rpx;
				font-size: 30rpx;
				color: #FFFFFF;
				line-height: 80rpx;
				text-align: center;
				margin: 60rpx 0 0 0;
			}
		}
	}
</style>