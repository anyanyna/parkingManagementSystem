<template>
	<!-- 新增编辑开票信息 -->
	<view class="invoice">
		<!-- 导航栏 -->
		<navbar class="invoice-navbar" title="开票信息" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="invoice-con">
			<view class="invoice-con-form">
				<u-form :model="formInfo" :rules="rules" ref="form" labelWidth="auto" :labelStyle="{color: '#343241', fontSize: '28rpx', lineHeight: '40rpx'}">
					<!-- 表单 -->
					<view class="invoice-con-form-info">
						<view class="invoice-con-form-item">
							<u-form-item label="抬头类型" prop="headerType">
								<u-radio-group v-model="formInfo.headerType" placement="row" @change="handleGroupChange">
									<u-radio :customStyle="{marginRight: '50rpx'}" v-for="(item, index) in headerRadioList" :key="index" :label="item.name" :name="item.name">
									</u-radio>
								</u-radio-group>
							</u-form-item>
						</view>
						<view class="invoice-con-form-item">
							<u-form-item :label="formInfo.headerType === '企业单位' ? '公司名称' : '抬头名称'" prop="name">
								<u-input v-model="formInfo.name" border="surround" color="#1C3148" :placeholder="formInfo.headerType === '企业单位' ? '请输入公司名称' : '请输入抬头名称'" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
						<view v-if="formInfo.headerType === '企业单位'" class="invoice-con-form-item">
							<u-form-item label="公司税号" prop="duty">
								<u-input v-model="formInfo.duty" border="surround" color="#1C3148" placeholder="请输入公司税号" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
						<view v-if="formInfo.headerType === '企业单位'" class="invoice-con-form-item">
							<u-form-item label="注册地址" prop="address">
								<u-input v-model="formInfo.address" border="surround" color="#1C3148" placeholder="请输入注册地址" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
						<view v-if="formInfo.headerType === '企业单位'" class="invoice-con-form-item">
							<u-form-item label="注册电话" prop="telephone">
								<u-input v-model="formInfo.telephone" border="surround" color="#1C3148" placeholder="请输入注册电话" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
						<view v-if="formInfo.headerType === '企业单位'" class="invoice-con-form-item">
							<u-form-item label="开户银行" prop="bank">
								<u-input v-model="formInfo.bank" border="surround" color="#1C3148" placeholder="请输入开户银行" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
						<view v-if="formInfo.headerType === '企业单位'" class="invoice-con-form-item">
							<u-form-item label="银行账号" prop="bankAccount">
								<u-input v-model="formInfo.bankAccount" border="surround" color="#1C3148" placeholder="请输入银行账号" placeholderStyle="color: #687582; font-size: 28rpx;" :customStyle="{fontSize: '28rpx', lineHeight: '40rpx', background: '#FFFFFF', padding: '0 0 0 44rpx'}" inputAlign="left" clearable />
							</u-form-item>
						</view>
					</view>
				</u-form>
			</view>
			<view class="invoice-con-btn" @click="handleSubmit">保存</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'addOrEditInvoiceList',
		components: {},
		data() {
			return {
				// 路由传值
				baseInfo: {},
				// 表单
				formInfo: {
					headerType: '企业单位',
					name: null,
					duty: null,
					address: null,
					telephone: null,
					bank: null,
					bankAccount: null,
				},
				rules: {
					headerType: {
					  type: 'string',
					  required: true,
					  message: '请选择抬头类型',
					  trigger: ['blur', 'change'],
					},
					name: {
					  type: 'string',
					  required: true,
					  message: '请输入抬头名称',
					  trigger: ['blur', 'change'],
					},
					duty: {
					  type: 'string',
					  required: true,
					  message: '请输入公司税号',
					  trigger: ['blur', 'change'],
					},
					address: {
					  type: 'string',
					  required: true,
					  message: '请输入注册地址',
					  trigger: ['blur', 'change'],
					},
					telephone: {
					  type: 'string',
					  required: true,
					  message: '请输入注册电话',
					  trigger: ['blur', 'change'],
					},
					bank: {
					  type: 'string',
					  required: true,
					  message: '请输入开户银行',
					  trigger: ['blur', 'change'],
					},
					bankAccount: {
					  type: 'string',
					  required: true,
					  message: '请输入银行账号',
					  trigger: ['blur', 'change'],
					},
				},
				// 抬头类型 数据
				headerRadioList: [
					{
						name: '企业单位'
					},
					{
						name: '个人/事业单位'
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
			// 支付类型 单选框 change事件
			handleGroupChange(value) {
				console.log('handleGroupChange-value', value);
				// this.$refs.form.resetFields()
				this.$refs.form.clearValidate()
			},
			// 取消 返回上一页面
			handleBack () {
				uni.navigateBack({
					delta: 1
				})
			},
		}
	}
</script>

<style lang="less" scoped>
	.invoice {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		&-navbar {
			position: fixed;
		}
		
		// 非列表设置
		&-con {
			width: 100%;
			// padding: 30rpx;
			padding: 118rpx 30rpx 30rpx 30rpx;
			
			&-line {
				width: 100%;
				height: 102rpx;
			}
			
			&-form {
				width: 100%;
				
				&-info {
					background: #FFFFFF;
					border-radius: 10rpx;
					padding: 30rpx;
					margin: 0 0 30rpx 0;
				}
				
				
				&-item {
					// background: #FFFFFF;
					// border-radius: 10rpx;
					// padding: 20rpx;
					margin: 0 0 30rpx 0;
					
				}
				
				&-item:first-child {
					border-bottom: 0;
				}
				
				&-item:last-child {
					margin: 0;
				}
				
				/deep/.u-form-item__body {
					// display: block;
					padding: 0;
				}
				
				/deep/.u-form-item__body__right {
					// padding: 15rpx 0;
				}
				
				/deep/.u-border {
					border: 0 !important;
				}
				
				/deep/.u-input {
					// padding: 0 !important;
				}
				
				/deep/.u-input__content__field-wrapper__field {
					line-height: 40rpx;
					font-size: 28rpx;
				}
				
				/deep/.u-radio-group--row {
				   padding: 0 0 0 44rpx;
				}
				
				/deep/.u-textarea {
					padding: 0 !important;
				}
			}
			
			&-btn {
				position: fixed;
				left: 30rpx;
				bottom: 60rpx;
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