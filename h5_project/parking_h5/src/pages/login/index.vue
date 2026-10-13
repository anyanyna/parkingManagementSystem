<template>
  <view class="login">
    <view class="login-text">Hello！</view>
    <view class="login-title">欢迎登录停车场运营管理平台</view>
    <view class="login-form">
      <u-form
        labelPosition="left"
        :model="formInfo"
        ref="loginForm"
        :rules="rules"
      >
        <u-form-item prop="username" borderBottom class="login-form-item">
          <u-input
            v-model="formInfo.username"
            border="none"
            type="text"
            placeholder="请输入用户名"
            clearable
          >
          </u-input>
        </u-form-item>
        <u-form-item prop="password" borderBottom class="login-form-item">
          <u-input
            v-model="formInfo.password"
            border="none"
            type="text"
            placeholder="请输入密码"
            :password="true"
            clearable
          >
          </u-input>
        </u-form-item>
      </u-form>
    </view>
    <view class="login-btn">
      <u-button
        color="#1D84FA"
        type="primary"
        text="登录"
        shape="circle"
        @click="handleLogin"
      ></u-button>
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
      formInfo: {
        username: 'admin', // admin
        password: 'admin', // admin
      },
      rules: {
        username: {
          type: 'string',
          required: true,
          message: '请输入用户名',
          trigger: ['blur', 'change'],
        },
        password: {
          type: 'string',
          required: true,
          message: '请输入密码',
          trigger: ['blur', 'change'],
        },
      },
    }
  },
  onLoad() {},
  onShow() {
    // this.$nextTick(() => {
    // 	this.handleLogin()
    // })
    // 登录
    // this.handleSystemLogin()
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
    // 登录-用户名 （测试用-非企业微信环境）
    handleSystemLogin() {
      const params = {
        openId: this.formInfo.username || null,
        // openId: 'admin',
      }
      this.loginSystemGemapiTest(params).then((res) => {
        console.log('登录-res', res)
        if (res.code == 20000) {
          // 获取用户信息
          this.getUserInfo()
        } else {
          uni.showToast({
            title: res.message,
            icon: 'none',
            duration: 2000,
          })
        }
      })
    },
    // 登录-用户名&&密码
    handleLogin() {
      this.$refs.loginForm
        .validate()
        .then((res) => {
          const params = {
            username: this.formInfo.username || null,
            password: md5(this.formInfo.password) || null,
            projectuuid: 'a09fe71ca88f44a085076b47be78ecfe',
          }
          this.loginGemapi(params).then((res) => {
            console.log('res', res)
            // if (res.flag == 'true') {
            if (res.flag == true) {
              // 获取用户信息
              this.getUserInfo()
            } else {
              uni.showToast({
                title: res.message,
                icon: 'none',
                duration: 2000,
              })
            }
          })
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
  padding-top: 80rpx;

  &-text {
    font-size: 56rpx;
    font-weight: bold;
    color: #333333;
    line-height: 78rpx;
    margin-left: 50rpx;
  }

  &-title {
    font-size: 36rpx;
    font-weight: bold;
    color: #333333;
    line-height: 50rpx;
    margin-left: 50rpx;
    margin-top: 20rpx;
    margin-bottom: 100rpx;
  }

  &-form {
    width: 100%;
    margin: auto;
    padding: 0 52rpx;
    box-sizing: border-box;

    /deep/.u-form-item__body__right__message {
      margin-left: 0 !important;
    }

    &-item {
      position: relative;
      margin-bottom: 16rpx;

      &-code {
        background: #1677ff;
        line-height: 88rpx;
        padding: 0 24rpx;
        border-radius: 8rpx;
        color: #ffffff;
        font-size: 28rpx;
        position: absolute;
        right: 0;
      }
    }
  }

  &-btn {
    width: 100%;
    line-height: 88rpx;
    border-radius: 41rpx;
    margin: 54rpx auto;
    padding: 0 52rpx;

    /deep/.u-button--normal {
      font-size: 32rpx;
      line-height: 36rpx;
    }
  }

  &-handle {
    color: #1677ff;
    line-height: 42px;
    padding: 0 16px;
    text-align: center;
    cursor: pointer;

    &:hover {
      opacity: 0.9;
    }
  }
}
</style>
