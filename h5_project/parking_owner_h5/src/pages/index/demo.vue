<template>
	<!-- demo -->
	<view class="demo">
		<!-- 导航栏 -->
		<navbar class="demo-navbar" title="demo" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="demo-con">demo</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'demo',
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
	.demo {
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