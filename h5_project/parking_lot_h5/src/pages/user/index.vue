<template>
	<!-- 我的账户 -->
	<view class="user">
		<view class="user-con">
			<!-- 导航栏 -->
			<navbar class="user-con-navbar" title="我的账户" :isShowBack="true"></navbar>
			<view class="user-con-info">
				<view class="user-con-info-item" v-for="(item, index) in menuList" :key="index" @click="handleGo(item)">
					<view class="user-con-info-item-left">
						<view class="user-con-info-item-left-icon">
							<image :src="item.icon" mode=""></image>
						</view>
						<view class="user-con-info-item-left-title">{{ item.title }}</view>
					</view>
					<view class="user-con-info-item-right">
						<image src="@/static/img/user/箭头@2x.png" mode=""></image>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'user',
		components: {},
		data() {
			return {
				// menu 功能菜单
				menuList: [
				  {
				    title: '我的钱包',
				    total: 0,
				    url: '/pages/purse/index',
				    icon: require('@/static/img/user/我的钱包@2x.png'),
				  },
				  {
				    title: '我的认证',
				    total: 0,
				    url: '/pages/user/identity',
				    icon: require('@/static/img/user/我的认证@2x.png'),
				  },
				  {
				    title: '我的发票',
				    total: 0,
				    url: '/pages/invoice/index',
				    icon: require('@/static/img/user/我的发票@2x.png'),
				  },
				  {
				    title: '修改手机',
				    total: 0,
				    url: '/pages/user/phone',
				    icon: require('@/static/img/user/修改手机@2x.png'),
				  },
				  {
				    title: '修改密码',
				    total: 0,
				    url: '/pages/user/password',
				    icon: require('@/static/img/user/修改密码@2x.png'),
				  },
				  {
				    title: '意见反馈',
				    total: 0,
				    url: '/pages/user/suggest',
				    icon: require('@/static/img/user/意见反馈@2x.png'),
				  },
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
			// 菜单功能 跳转
			handleGo(item) {
			  console.log('item', item)
			  if (Object.keys(item).length !== 0) {
			    console.log('跳转-item', item)
			    if (item.url) {
			      uni.navigateTo({
			        url: item.url,
			      })
			    } else {
			      uni.showToast({
			        title: '功能待开发！',
			        icon: 'none',
			        duration: 2000,
			      })
			    }
			  }
			},
		}
	}
</script>

<style lang="less" scoped>
	.user {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
				
		&-con {
			width: 100%;
			height: 100%;
			background: url('@/static/img/user/bg@2x.png') no-repeat;
			background-position: 0 0;
			background-size: 100% 432rpx;
			
			// 列表设置
			&-navbar {
				// position: fixed;
				background: none;
			}
			
			&-info {
				width: 690rpx;
				height: 900rpx;
				background: linear-gradient( 180deg, #FFFFFF 0%, #F0F2F5 100%);
				border-radius: 30rpx 30rpx 0rpx 0rpx;
				margin: 123rpx 30rpx 0 30rpx;
				padding: 30rpx;
				
				&-item {
					display: flex;
					align-items: center;
					justify-content: space-between;
					width: 100%;
					margin: 0 0 42rpx 0;
					
					&-left {
						display: flex;
						align-items: center;
						
						&-icon {
							width: 40rpx;
							height: 40rpx;
							margin: 0 20rpx 0 0;
							
							image {
								width: 100%;
								height: 100%;
							}
						}
						
						&-title {
							font-size: 32rpx;
							color: #1C3148;
							line-height: 45rpx;
							letter-spacing: 2rpx;
						}
					}
					
					&-right {
						width: 16.67rpx;
						height: 30.12rpx;
						
						image {
							width: 100%;
							height: 100%;
						}
					}
				}
			}
		}
	}
</style>