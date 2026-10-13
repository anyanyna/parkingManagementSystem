<template>
  <view class="login">
		<view class="login-con">
			<view class="login-con-info">
				<view class="login-con-info-tabs">
					<u-tabs :list="tabsList" :current="tabKey" lineWidth="60" lineColor="#1D84FA" :activeStyle="{
							color: '#1D84FA',
							lineHeight: '88rpx',
							fontSize: '32rpx',
							fontWeight: 'bold'
						}" :inactiveStyle="{
							color: '#1C3148',
							lineHeight: '88rpx',
							fontSize: '32rpx',
						}" :scrollable="false" @click="handleTab">
					</u-tabs>
				</view>
				<view class="login-con-info-form">
				  <u-form
				    labelPosition="left"
				    :model="formInfo"
				    ref="loginForm"
				    :rules="rules"
				  >
						<!-- 验证码登录 -->
						<u-form-item v-if="tabKey === 0" prop="phone" borderBottom class="login-con-info-form-item">
						  <u-input
						    v-model="formInfo.phone"
						    border="surround"
								shape="circle"
						    type="text"
								prefixIcon="account-fill"
								prefixIconStyle="font-size: 24px;color: #8A97B7;padding-right: 10rpx"
						    placeholder="请输入手机号"
								placeholderStyle="font-size: 32rpx;color: #687582"
						    clearable
						  >
						  </u-input>
						</u-form-item>
						<u-form-item v-if="tabKey === 0" prop="verify" borderBottom class="login-con-info-form-item">
						  <u-input
						    v-model="formInfo.verify"
						    border="surround"
								shape="circle"
						    type="text"
								prefixIcon="lock-fill"
								prefixIconStyle="font-size: 24px;color: #8A97B7;padding-right: 10rpx"
						    placeholder="请输入验证码"
								placeholderStyle="font-size: 32rpx;color: #687582"
						    :password="true"
						    clearable
						  >
								<!-- 验证码 -->
								<template slot="suffix">
									<u-code :seconds="seconds" ref="uCode" @change="handleChangeCode"></u-code>
									<view class="login-con-info-form-item-code" @tap="handleCode">{{ codeTips }}</view>
								</template>
						  </u-input>
						</u-form-item>
						<!-- 密码登录 -->
				    <u-form-item v-if="tabKey === 1" prop="username" borderBottom class="login-con-info-form-item">
				      <u-input
				        v-model="formInfo.username"
				        border="surround"
								shape="circle"
				        type="text"
								prefixIcon="account-fill"
								prefixIconStyle="font-size: 24px;color: #8A97B7;padding-right: 10rpx;"
				        placeholder="请输入账号"
								placeholderStyle="font-size: 32rpx;color: #687582"
				        clearable
				      >
				      </u-input>
				    </u-form-item>
				    <u-form-item v-if="tabKey === 1" prop="password" borderBottom class="login-con-info-form-item">
				      <u-input
				        v-model="formInfo.password"
				        border="surround"
								shape="circle"
				        type="text"
								prefixIcon="lock-fill"
								prefixIconStyle="font-size: 24px;color: #8A97B7;padding-right: 10rpx"
				        placeholder="请输入密码"
								placeholderStyle="font-size: 32rpx;color: #687582"
				        :password="true"
				        clearable
				      >
				      </u-input>
				    </u-form-item>
				  </u-form>
				</view>
				<view class="login-con-info-btn">
					<u-button
						color="linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%)"
						type="primary"
						:text="tabKey === 0 ? '登录/注册' : '登录'"
						shape="circle"
						@click="handleLogin"
					></u-button>
				</view>
				<view v-if="tabKey === 1" class="login-con-info-footer">
					<view class="login-con-info-footer-forget" @click="handleForget">忘记密码?</view>
					<view class="login-con-info-footer-register" @click="handleForget">新用户注册</view>
				</view>
			</view>
		</view>
		
  </view>
</template>

<script>
import { mapActions, mapMutations, mapState } from 'vuex'
import md5 from 'js-md5'
export default {
  name: 'login',
  components: {},
  data() {
    return {
			// 类型 验证码登录：0 密码登录：1
			tabKey: 1,
			tabsList: [
				{
					name: '验证码登录'
				},
				{
					name: '密码登录'
				}
			],
      formInfo: {
        phone: '',
        verify: '',
        username: 'admin', // admin
        password: 'admin', // admin
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
				},
        username: {
          type: 'string',
          required: true,
          message: '请输入账号',
          trigger: ['blur', 'change'],
        },
        password: {
          type: 'string',
          required: true,
          message: '请输入密码',
          trigger: ['blur', 'change'],
        },
      },
			// 获取验证码 提示 文本
			codeTips: '',
			// 获取验证码 倒计时
			seconds: 60,
    }
  },
  onLoad() {},
  onShow() {
    // this.$nextTick(() => {
    // 	this.handleLogin()
    // })
  },
  computed: {
    ...mapState({
      userInfo: (state) => state.userInfo,
      token: (state) => state.token,
    }),
  },
  methods: {
    ...mapActions([
      'loginGemapi',
      'getUserInfoDetail',
      'loginSystemGemapiTest',
    ]),
    ...mapMutations(['setState']),
    // 验证码登录 || 密码登录
    handleLogin() {
      this.$refs.loginForm.validate().then((res) => {
				let params = null
				if (this.tabKey === 0) { // 验证码登录
					params = {
						phone: this.formInfo.phone || null,
						verify: this.formInfo.verify || null,
					}
				} else if (this.tabKey === 1) { // 密码登录
					params = {
						username: this.formInfo.username || null,
						password: md5(this.formInfo.password) || null,
					}
				}
				
				console.log('params', params)
				
				// 跳转 页面
				setTimeout(() => {
				  // 跳转首页
				  uni.navigateTo({
				    url: '/pages/index/index',
				  })
				}, 500)
				
				// this.loginGemapi(params).then((res) => {
				// 	console.log('res', res)
				// 	// if (res.flag == 'true') {
				// 	if (res.flag == true) {
				// 		// 获取用户信息
				// 		this.getUserInfo()
				// 	} else {
				// 		uni.showToast({
				// 			title: res.message,
				// 			icon: 'none',
				// 			duration: 2000,
				// 		})
				// 	}
				// })
			})
			.catch((errors) => {
				console.log(errors)
			})
    },
    // 获取用户信息
    getUserInfo() {
      this.getUserInfoDetail().then((res) => {
        console.log('用户信息-res', res)
        if (res.flag == 'true') {
          console.log('用户信息-res.data', res.data)
          this.setState({ userInfo: res.data || null })

          // 跳转 页面
          setTimeout(() => {
            // 跳转首页
            uni.navigateTo({
              url: '/pages/index/index',
            })
          }, 500)
        } else {
          uni.showToast({
            title: res.message,
            icon: 'none',
            duration: 2000,
          })
        }
      })
    },
		// 获取 验证码 接口
		async getVerifyCode() {
			const params = {
				userName: this.userInfo.username || null
			}
			console.log('params', params)
			
			const res = await this.getVerificationCode(params)
			console.log('获取 验证码-res', res);
			if (res.code == 20000) {
				uni.showToast({
					title: '发送验证码成功!',
					icon: 'none',
					duration: 2000 //持续的时间
				})
				
				// 通知验证码组件内部开始倒计时
				this.$refs.uCode.start();
			} else {
				uni.showToast({
					title: res.message,
					icon: 'none',
					duration: 2000 //持续的时间
				})
			}
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
		// 切换 标签
		handleTab(item) {
			// 类型 验证码登录：0 密码登录：1
			if (item.name === '验证码登录') {
				// 验证码登录
				this.tabKey = 0
			} else if (item.name === '密码登录') {
				// 密码登录
				this.tabKey = 1
			}
			this.$refs.loginForm.resetFields()
			this.$refs.loginForm.clearValidate()
		},
		// 忘记密码 || 新用户注册
		handleForget(item) {
			// 验证码登录
			this.tabKey = 0
			this.$refs.loginForm.resetFields()
			this.$refs.loginForm.clearValidate()
		},
  },
}
</script>

<style scoped="scoped" lang="less">
.login {
  position: fixed;
  width: 750rpx;
  height: 100vh;
  background: #ffffff;
  font-size: 28rpx;
  font-family: PingFangSC-Regular, PingFang SC;
  font-weight: 400;
	
	&-con {
		width: 100%;
		height: 100%;
		background: url('@/static/img/login/bg@2x.png') no-repeat;
		background-position: 0 0;
		background-size: 100% 560rpx;
		padding: 360rpx 30rpx 0 30rpx;
		
		&-info {
			width: 100%;
			height: 628rpx;
			background: #FFFFFF;
			border-radius: 40rpx 40rpx 0rpx 0rpx;
			
			&-tabs {
				width: 100%;
				height: 88rpx;
				margin-bottom: 50rpx;
				
				/deep/.u-tabs__wrapper__nav__item__text {
					white-space: nowrap;
				}
			}
			
			&-form {
			  width: 100%;
			  margin: auto;
			  padding: 0 20rpx;
			  box-sizing: border-box;
				
				/deep/.u-form-item__body {
					padding: 0;
				}
			
			  /deep/.u-form-item__body__right__message {
			    margin-left: 0 !important;
			  }
				
				/deep/.u-line {
					border: 0 !important;
				}
				
				/deep/.u-input {
					padding: 10px 9px !important;
					background: #EFF2F6;
				}
				
				/deep/.uni-input-input {
					font-size: 32rpx;
				}
				
				/deep/.u-input--circle {
					border-radius: 128rpx;
				}
			
			  &-item {
			    position: relative;
			    margin-bottom: 50rpx;
					
					&-code {
						font-size: 32rpx;
						color: #1D84FA;
						line-height: 42rpx;
						margin-top: -4rpx;
					}
			
			  }
			}
			
			&-btn {
			  width: 100%;
			  border-radius: 41rpx;
			  margin-top: 80rpx;
				padding: 0 20rpx;
			
			  /deep/.u-button--normal {
			    font-size: 32rpx;
					height: 90rpx;
			  }
			}
			
			&-footer {
				display: flex;
				justify-content: space-between;
				width: 100%;
				padding: 0 20rpx;
				margin-top: 32rpx;
				
				&-forget {
					color: #687582;
					font-size: 30rpx;
					line-height: 42rpx;
				}
				
				&-register {
					color: #1D84FA;
					font-size: 30rpx;
					line-height: 42rpx;
				}
			}
		}
	}
}
</style>
