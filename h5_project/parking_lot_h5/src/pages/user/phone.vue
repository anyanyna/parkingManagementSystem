<template>
	<!-- 修改手机 -->
	<view class="user">
		<!-- 导航栏 -->
		<navbar class="user-navbar" title="修改手机" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="user-con">
			<view class="user-con-form">
				<u-form :model="formInfo" :rules="rules" ref="form" labelWidth="auto" :labelStyle="{color: '#343241', fontSize: '32rpx', lineHeight: '45rpx'}">
					<view class="user-con-form-item">
						<u-form-item label="手机号" prop="phone">
							<u-input v-model="formInfo.phone" border="surround" color="#1C3148" placeholder="请输入手机号" placeholderStyle="color: #687582; font-size: 30rpx;" :customStyle="{background: '#EFF2F6', padding: '14rpx 20rpx'}" inputAlign="left" clearable />
						</u-form-item>
					</view>
					<view class="user-con-form-item">
						<u-form-item label="验证码" prop="verify">
							<u-input v-model="formInfo.verify" border="surround" color="#1C3148" placeholder="请输入验证码" placeholderStyle="color: #687582; font-size: 30rpx;" :customStyle="{background: '#EFF2F6', padding: '14rpx 20rpx'}" inputAlign="left" clearable >
								<!-- 验证码 -->
								<template slot="suffix">
									<u-code :seconds="seconds" ref="uCode" @change="handleChangeCode"></u-code>
									<view class="user-con-form-item-code" @tap="handleCode">{{ codeTips }}</view>
								</template>
							</u-input>
						</u-form-item>
					</view>
				</u-form>
			</view>
			<view class="user-con-btn" @click="handleSubmit">确定</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'phone',
		components: {},
		data() {
			return {
				// 表单
				formInfo: {
					phone: null,
					verify: null,
				},
				rules: {
					phone: [
						{
							required: true, 
							message: '请输入手机号',
							trigger: ['change','blur']
						},
						{
							// u-form.vue 源文件修改代码 添加 name字段,手动设置自定义验证函数
							name: 'phone', 
							// 自定义验证函数，见上说明 (注: 嵌套子元素自定义验证函数不生效,源代码进行修改)
							validator: (rule, value, callback) => {
								// 上面有说，返回true表示校验通过，返回false表示不通过
								// uni.$u.test.mobile()就是返回true或者false的
								return uni.$u.test.mobile(value);
							},
							message: '手机号码不正确',
							// 触发器可以同时用blur和change
							trigger: ['change','blur'],
							
						}
					],
					verify: {
					  type: 'string',
					  required: true,
					  message: '请输入验证码',
					  trigger: ['blur', 'change'],
					}
				},
				// 获取验证码 提示 文本
				codeTips: '',
				// 获取验证码 倒计时
				seconds: 60,
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
			// 获取 验证码 接口
			async getVerifyCode() {
				// 通知验证码组件内部开始倒计时
				this.$refs.uCode.start();
				
				// const params = {
				// 	userName: this.userInfo.username || null
				// }
				// console.log('params', params)
				
				// const res = await this.getVerificationCode(params)
				// console.log('获取 验证码-res', res);
				// if (res.code == 20000) {
				// 	uni.showToast({
				// 		title: '发送验证码成功!',
				// 		icon: 'none',
				// 		duration: 2000 //持续的时间
				// 	})
					
				// 	// 通知验证码组件内部开始倒计时
				// 	this.$refs.uCode.start();
				// } else {
				// 	uni.showToast({
				// 		title: res.message,
				// 		icon: 'none',
				// 		duration: 2000 //持续的时间
				// 	})
				// }
			},
			// 获取 验证码
			handleCode() {
				if (!this.formInfo.phone) return uni.showToast({
					title: '请输入手机号!',
					icon: 'none',
					duration: 2000 //持续的时间
				})
			
				// 通知验证码组件内部开始倒计时
				if (this.$refs.uCode.canGetCode) {
					// // 通知验证码组件内部开始倒计时
					// this.$refs.uCode.start();
					
					// 获取 验证码 接口
					this.getVerifyCode()
				} else {
					uni.$u.toast('请勿重复发送！');
				}
			},
			// Code 验证码输入框 change事件
			handleChangeCode(text) {
				// 获取验证码 提示 文本
				this.codeTips = text;
			},
		}
	}
</script>

<style lang="less" scoped>
	.user {
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
					
					&-code {
						font-size: 30rpx;
						color: #1D84FA;
						line-height: 42rpx;
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
					padding: 15rpx 0;
				}
				
				/deep/.u-border {
					border: 0 !important;
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