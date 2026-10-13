<template>
	<!-- 首页 -->
	<view class="index" style="display: flex;flex-direction: column;gap: 20rpx;padding: 20rpx;">
<!-- 		<u-button type="primary" text="扫码入场" @click="handleSanc('扫码入场')"></u-button>
		<u-button type="primary" text="无牌扫码缴费" @click="handleSanc('无牌扫码缴费')"></u-button>
		<u-button type="primary" text="有牌扫码缴费" @click="handleSanc('有牌扫码缴费')"></u-button>
		<u-button type="primary" text="提前缴费" @click="handleSanc('提前缴费')"></u-button>
		<u-button type="primary" text="微信授权" @click="handleWX"></u-button> -->
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'index',
		components: {},
		data() {
			return {
				// 车场ID
				parkId: 1,
				// 道闸ID
				camId: 2,
				appid: 'wxff2c0e2c2f665a17',
				redirect_uri: 'http://www.wx.lczhparking.com',
				// state: '/pages/scanPay/index?parkId=94',
				state: null,
				// 微信 code
				code: null,
			}
		},
		onLoad(option) {
			if (option && option.code && option.state) {
				// 方式一: 链接有 /#/ 参数就可以获取到code
				this.code = option.code
				this.state = option.state
				console.log('方式一-code',this.code)
				console.log('方式一-state',this.state)
				console.log('方式一-state-解码',decodeURIComponent(this.state))
				
				// 获取 微信用户唯一标识 openid				this.getWxOpenIdInfo()
			} else {
				// 方式二: 链接没有 /#/ 参数就可以获取到code
				this.code = this.getUrlParameter('code')
				this.state = this.getUrlParameter('state')
				console.log('方式二-code',this.code)
				console.log('方式二-state',this.state)
				console.log('方式二-state-解码',decodeURIComponent(this.state))
				
				// 获取 微信用户唯一标识 openid
				this.getWxOpenIdInfo()
			}
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
			...mapActions(['getWxOpenId']),
			...mapMutations(['setState']),
			// 获取 微信用户唯一标识 openid
			async getWxOpenIdInfo() {
				const params = {
					code: this.code || null
				}
				console.log('params', params)
				
				const res = await this.getWxOpenId(params)
				console.log('获取 微信用户唯一标识 openid-res', res)
				if (res.flag == true) {
					console.log('微信用户唯一标识 openid-res.data', res.data);
					console.log('微信用户唯一标识 openid-res.data.openid', res.data.openid);
					this.setState({'openid': res.data.openid || null})
					
					if (this.state) {
						// 跳转页面
						uni.navigateTo({
							url: this.state,
							// url: `/pages/scanPay/index?parkId=94`,
						})
					}
				} else {
					uni.showToast({
						title: res.message,
						icon: 'none',
						duration: 2000 //持续的时间
					})
				}
			},
			// 微信授权
			handleWX () {
				let url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=${this.appid}&redirect_uri=${encodeURIComponent(this.redirect_uri)}&response_type=code&scope=snsapi_base&state=${encodeURIComponent(this.state)}#wechat_redirec`
				// let url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=${this.appid}&redirect_uri=${this.redirect_uri}&response_type=code&scope=snsapi_base&state=${this.state}#wechat_redirec`
				// let url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirec`
				console.log('微信授权链接-url',url);
				// 打开 微信授权页面
				window.location.href = url
			},
			// 扫码
			handleSanc (type) {
				console.log('扫码-type',type)
				
				if (type === '扫码入场') {	// 扫码入场
					// 跳转页面
					uni.navigateTo({
					  url: `/pages/scanEntrance/index?parkId=${this.parkId}&camId=${this.camId}`,
					})
				} else if (type === '无牌扫码缴费') {	// 无牌扫码缴费
					// 跳转页面
					uni.navigateTo({
					  url: `/pages/scanPay/index?parkId=${this.parkId}&camId=${this.camId}`,
					})
				} else if (type === '有牌扫码缴费') {	// 有牌扫码缴费
					// 跳转页面
					uni.navigateTo({
					  url: `/pages/scanPay/index?parkId=${this.parkId}&camId=${this.camId}`,
					})
				} else if (type === '提前缴费') {	// 提前缴费
					// 跳转页面
					uni.navigateTo({
					  url: `/pages/scanPay/index?parkId=${this.parkId}`,
					})
				}
			},
			// 微信code 截取
			getUrlParameter(name) {
				console.log("路径",window.location);
				var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
				var r = window.location.search.substr(1).match(reg);
				if (r != null) {
					return unescape(r[2]);
				}
				return null;
			}
		}
	}
</script>

<style lang="less" scoped>
	.index {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
	}
</style>