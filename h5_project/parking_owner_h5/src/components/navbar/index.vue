<template>
	<!-- navbar-导航栏 -->
  <view class="nav">
		<view v-if="isShowBack" class="nav-icon" @click="handleBack"><u-icon name="arrow-left" size="22" color="#FFFFFF"></u-icon></view>
    <view class="nav-title">{{ title }}</view>
  </view>
</template>
 
<script>
export default {
  props: {
		// 导航栏 标题
    title: String,
		// 是否显示icon 返回图标
    isShowBack: {
			default:true,
		}
  },
	methods: {
		// 返回上一页面
		handleBack () {
			uni.navigateBack({
				delta: 1
			})
		},
	}
}
</script>
 
<style lang="less" scoped>
.nav {
  position: relative;
  width: 100%;
  height: 88rpx;
	font-size: 28rpx;
	font-family: PingFang SC, PingFang SC;
	font-weight: 400;
	background: linear-gradient( 90deg, #1DC5FA 0%, #1D84FA 100%);
	z-index: 999;
	
	&-icon {
		position: absolute;
		top: 22rpx;
		left: 30rpx;
		z-index: 100;
	}
	
	&-title {
	  position: absolute;
	  width: 100%;
	  line-height: 88rpx;
	  text-align: center;
	  font-size: 36rpx;
	  color: #FFFFFF;
		font-weight: bold;
	}
}
</style>