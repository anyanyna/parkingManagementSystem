<template>
	<!-- 长租信息记录 -->
	<view class="rent">
		<!-- 导航栏 -->
		<navbar class="rent-navbar" title="长租信息记录" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="rent-con">长租信息记录</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'longRent',
		components: {},
		data() {
			return {
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
		}
	}
</script>

<style lang="less" scoped>
	.rent {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 列表设置
		&-navbar {
			position: fixed;
		}
		
		// 列表设置
		&-con {
			position: fixed;
			top: 88rpx;
			width: 100%;
			background: #F0F2F5;
			z-index: 999;
		}
		
		// 非列表设置
		&-con {
			
		}
	}
</style>