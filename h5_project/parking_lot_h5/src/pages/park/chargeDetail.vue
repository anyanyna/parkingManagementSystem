<template>
	<!-- 收费明细 -->
	<view class="park">
		<!-- 导航栏 -->
		<navbar class="park-navbar" title="收费明细" :isShowBack="true"></navbar>
		<view class="park-line"></view>
		<!-- 列表 -->
		<view class="park-list">
			<view class="park-list-item" v-for="(item,index) in parkList" :key="item.id">
				<view class="park-list-item-con" v-for="(con, index) in parkInfo" :key="index">
					<template v-if="con.key === 'name'">
						<view class="park-list-item-con-title">{{ item[con.key] }}</view>
					</template>
					<template v-else>
						<view class="park-list-item-con-key">{{ con.title }}</view>
						<view class="park-list-item-con-value" :class="con.key === 'amount' ? 'park-list-item-con-value1' : ''">{{ con.key === 'amount' ? '￥' + item[con.key] : item[con.key] }}</view>
					</template>
				</view>
			</view>
			<view class="park-list-line"></view>
		</view>
		<!-- 订单缴费 -->
		<view class="park-footer">
			<view class="park-footer-info">
				<view class="park-footer-info-amount">总计:<span>￥{{ 100 }}</span></view>
				<view class="park-footer-info-btn" @click="handlePay">订单缴费</view>
			</view>
		</view>
		<!-- 上拉加载 -->
		<view v-show="isLoadMore" class="park-load" :class="total === 0 ? 'tip' : ''">
			<u-loadmore :status="status" :line="true" :icon="false" :loading-text="loadingText" :loadmore-text="loadmoreText" :nomore-text="nomoreText" marginTop="0" marginBottom="0" />
		</view>
	</view>
</template>

<script>
	import {mapActions,mapMutations,mapState} from 'vuex';
	export default {
		name: 'chargeDetail',
		components: {},
		data() {
			return {
				// 收费明细 信息
				parkInfo: [
					{ key: 'name', title: '停车车场' },
					{ key: 'startTime', title: '开始时间' },
					{ key: 'endTime', title: '结束时间' },
					{ key: 'duration', title: '停车时长' },
					{ key: 'amount', title: '金额' },
				],
				// 收费明细 列表
				parkList: [
					{
						id: 1,
						name: '免费时长',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 2,
						name: '免费时段：60分钟',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 3,
						name: '夜间-临时车-第一阶梯',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 4,
						name: '永宁路小学南停车场',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 5,
						name: '夜间-临时车-第二阶梯',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 6,
						name: '夜间-临时车-第三阶梯',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 7,
						name: '夜间-临时车-第四阶梯',
						startTime: '2024-01-09 05:00:01',
						endTime: '2024-01-09 11：00：23',
						duration: '6小时',
						amount: '15.00'
					},
				],
				// 列表数量
				total: 0,
				current: 1,
				size: 10,
				status: 'loading',
				//是否加载中
				isLoadMore: false,
				loadingText: '努力加载中',
				loadmoreText: '轻轻上拉',
				nomoreText: '暂无数据',
			}
		},
		onLoad(option) {},
		async onShow () {
			// 获取 收费明细 数据
			// this.getParkList()
		  console.log('userInfo', this.userInfo)
		},
		onPullDownRefresh() {
			this.current = 1
			this.getParkList()
			setTimeout(function() {
				uni.stopPullDownRefresh()
			}, 1000);
		},
		onReachBottom() {
			if (!this.isLoadMore) {
				this.isLoadMore = true
				this.current = this.current + 1
				this.getParkList()
			}
		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo
			}),
		},
		filters: {
			// 车牌类型 车牌样式
			typeColorFilter(val, license_type) {
				// console.log('车牌类型 车牌样式-licenceType', license_type);
				if (license_type === '蓝牌') return 'blue'
				if (license_type === '黄牌') return 'yellow'
				if (license_type === '黑牌') return 'black'
				if (license_type === '黄绿' || license_type === '绿牌') return 'green'
				if (license_type === '白牌') return 'white'
			}
		},
		methods: {
			...mapActions(['queryparkList','queryPartyMemberList','queryPartyAreaList','queryDeptTree','queryPartyAreaAll','queryPartyOrgAll','queryDataDictionaryList']),
			...mapMutations(['setState']),
			// 获取 收费明细 列表
			async getParkList() {
				// const params = {
				//   name: this.search || '',
				//   userName: this.userInfo.username,
				// 	pageNum: this.current,
				// 	pageSize: this.size,
				// }
			 //  const res = await this.queryMeetingSummaryList(params)
			 //  if (res.code == 20000) {
			 //    if (this.current === 1) {
			 //      this.parkList = []
			 //    }
			 //    this.total = res.data.total
			 //    this.parkList = this.parkList.concat(res.data.records)
			 //    if (res.data.records.length < this.size) {
			 //      //判断接口返回数据量小于请求数据量，则表示此为最后一页
			 //      this.isLoadMore = true
			 //      this.status = 'nomore'
			 //      this.nomoreText = '已经是最后了'
			 //      if (this.total == 0) {
			 //        this.nomoreText = '暂无数据'
			 //      }
			 //    } else {
			 //      this.isLoadMore = false
			 //    }
			 //  } else {
			 //    uni.showToast({
			 //      title: res.message,
			 //      icon: 'none',
			 //      duration: 2000, //持续的时间
			 //    })
			 //  }
			},
			// 切换 标签
			handleTab(item) {
				// 重置加载状态
				this.nomoreText = '努力加载中'
				if (item.name === '全部') {
					// 全部
					this.tabKey = '全部'
				} else if (item.name === '未支付') {
					// 未支付
					this.tabKey = '未支付'
				} else if (item.name === '已支付') {
					// 已支付
					this.tabKey = '已支付'
				}
				
				// 在切换tab后滚动到顶部
				this.$nextTick(() => {
					uni.pageScrollTo({
						scrollTop: 0,
						duration: 300 // 滚动动画时长，默认300ms
					});
				});
				this.current = 1
				this.getParkList()
			},
			// 订单缴费
			handlePay(item) {
				console.log('订单缴费-item',item);
				uni.navigateTo({
					url: '/pages/index/pay?baseInfo='+encodeURIComponent(JSON.stringify(item))
				})
			},
		}
	}
</script>

<style lang="less" scoped>
	.park {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		&-navbar {
			position: fixed;
		}
		
		&-line {
			position: fixed;
			top: 88rpx;
			width: 100%;
			height: 30rpx;
			background: #F0F2F5;
			z-index: 999;
		}
				
		&-list {
			z-index: 1;
			width: 100%;
			padding: 118rpx 28rpx 30rpx 28rpx;
			
			&-line {
				width: 100%;
				height: 102rpx;
				// margin-top: 20rpx;
			}
		
			&-item {
				position: relative;
				width: 100%;
				background: #FFFFFF;
				border-radius: 10rpx;
				padding: 0 20rpx 20rpx 20rpx;
				margin-bottom: 24rpx;
				
				&-con {
				  display: flex;
					justify-content: space-between;
				  margin-bottom: 14rpx;
					
					&-title {
						position: relative;
						width: 100%;
						height: 95rpx;
						font-weight: bold;
						font-size: 32rpx;
						color: #1D84FA;
						line-height: 95rpx;
						margin: 0 0 8rpx 0;
					}
					
					&-title::after {
						position: absolute;
						left: -20rpx;
						bottom: 0;
						content: '';
						display: inline-block;
						width: 696rpx;
						height: 2rpx;
						background: #e8ecef;
					}
				
				  &-key {
				    min-width: 132rpx;
				    font-size: 28rpx;
				    color: #687582;
				    line-height: 40rpx;
				    // white-space:nowrap;
				    // margin-right: 24rpx;
				  }
					
				  &-value {
				    max-width: 510rpx;
				    font-size: 28rpx;
				    color: #1C3148;
				    line-height: 40rpx;
				    word-break: break-all;
				    white-space:nowrap;
				    overflow:hidden;
				    text-overflow:ellipsis;
				  }
					
					&-value1 {
						font-weight: bold;
						color: #FF5151;
					}
				}
																									
				&-con:last-child {
				  margin-bottom: 0rpx;
				}
			}
			&-item:last-child {
				margin-bottom: 0;
			}
						
		}

		&-footer {
			position: fixed;
			left: 0;
			bottom: 0;
			width: 100%;
			height: 122rpx;
			background: #F0F2F5;
			padding: 20rpx 0 0 0;
			z-index: 9999999;
			
			&-info {
				display: flex;
				align-items: center;
				justify-content: space-between;
				width: 100%;
				height: 102rpx;
				background: #FFFFFF;
				padding: 0 30rpx 0 30rpx;
				
				&-amount {
					font-weight: bold;
					font-size: 28rpx;
					color: #1C3148;
					line-height: 40rpx;
					margin-right: 20rpx;
					
					span {
						color: #FF5151;
					}
				}
				
				&-btn {
					width: 200rpx;
					height: 62rpx;
					background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
					border-radius: 8rpx;
					font-size: 30rpx;
					color: #FFFFFF;
					line-height: 62rpx;
					text-align: center;
				}
			}
		}	
		
		&-load {
			padding-bottom: 30rpx;
		}
		
		.tip {
			position: absolute;
			left: 50%;
			top: 50%;
			transform: translate(-50%, -50%);
		}
		
	}
</style>