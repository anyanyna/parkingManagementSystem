<template>
	<!-- 停车记录 -->
	<view class="park">
		<!-- 导航栏 -->
		<navbar class="park-navbar" title="停车记录" :isShowBack="true"></navbar>
		<view class="park-nav">
			<!-- tab栏 -->
			<view class="park-nav-tabs">
				<u-tabs :list="tabsList" lineWidth="60" lineColor="#1D84FA" :activeStyle="{
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
		</view>
		<!-- 列表 -->
		<view class="park-list">
			<view class="park-list-item" v-for="(item,index) in parkList" :key="item.id" @click="handleView(item)">
				<view class="park-list-item-con" :class="item.status === '已支付' ? 'park-list-item-con1' : ''" v-for="(con, index) in parkInfo" :key="index">
					<view class="park-list-item-con-licence" v-if="con.key === 'licence'">
						<view class="park-list-item-con-licence-num" :class=" '' | typeColorFilter(item.type)">
							{{ item.licence ? item.licence.slice(0, 2) : null }}<span></span>{{ item.licence ? item.licence.slice(2) : null }}
						</view>
						<view class="park-list-item-con-licence-amount">￥{{ item.amount || 0 }}</view>
					</view>
					<template v-else-if="con.key === 'name' || con.key === 'time' || con.key === 'duration'">
						<view class="park-list-item-con-key">{{ con.title }}</view>
						<view class="park-list-item-con-value">{{ item[con.key] }}</view>
					</template>
					<!-- 未支付 -->
					<template v-else-if="con.key === 'status' && item.status === '未支付'">
						<view class="park-list-item-con-btn">
							<view class="park-list-item-con-btn-pay" @click.stop="handlePay(item)">立即缴费</view>
						</view>
					</template>
					<!-- 已支付 -->
					<template v-else-if="con.key === 'status' && item.status === '已支付'">
						<view class="park-list-item-con-status">
							<image src="@/static/img/park/已支付@2x.png" mode=""></image>
						</view>
					</template>
				</view>
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
		name: 'park',
		components: {},
		data() {
			return {
				// 类型 全部 未支付 已支付
				tabKey: '全部',
				tabsList: [{
						name: '全部'
					},
					{
						name: '未支付'
					},
					{
						name: '已支付'
					}
				],
				// 停车记录 信息
				parkInfo: [
					{ key: 'licence', title: '车牌' },
					// { key: 'type', title: '车牌类型' },
					{ key: 'name', title: '停车车场' },
					{ key: 'time', title: '驶出时间' },
					{ key: 'duration', title: '停车时长' },
					{ key: 'amount', title: '金额' },
					{ key: 'status', title: '支付状态' },
				],
				// 停车记录 列表
				parkList: [
					{
						id: 1,
						status: '已支付',
						licence: '浙AVG121',
						type: '蓝牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 2,
						status: '未支付',
						licence: '浙AVG1222',
						type: '绿牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 3,
						status: '已支付',
						licence: '浙AVG123',
						type: '黄牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 4,
						status: '未支付',
						licence: '浙AVG124',
						type: '黑牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 5,
						status: '已支付',
						licence: '浙AVG125',
						type: '黄绿',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 6,
						status: '未支付',
						licence: '浙AVG126',
						type: '白牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 7,
						status: '已支付',
						licence: '浙AVG127',
						type: '蓝牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
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
			// 获取 停车记录 数据
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
			// 获取 停车记录 列表
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
			// 查看 详情
			handleView(item) {
				console.log('查看 详情-tabKey',this.tabKey);
				console.log('查看 详情-item',item);
				uni.navigateTo({
					url: '/pages/park/detail?baseInfo='+encodeURIComponent(JSON.stringify(item))
				})
			},
			// 立即缴费
			handlePay(item) {
				console.log('立即缴费-item',item);
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
		
		&-nav {
			position: fixed;
			top: 88rpx;
			width: 100%;
			background: #EFF2F5;
			z-index: 999;
		
			&-tabs {
				width: 100%;
				height: 88rpx;
				// background: #FFFFFF;
				/deep/.u-tabs__wrapper__nav__item__text {
					white-space: nowrap;
				}
			}
		}
		
		&-list {
			z-index: 1;
			width: 100%;
			padding: 203rpx 28rpx 30rpx 28rpx;
		
			&-item {
				position: relative;
				width: 100%;
				background: #FFFFFF;
				border-radius: 10rpx;
				padding: 20rpx;
				margin-bottom: 24rpx;
				
				&-con {
				  display: flex;
					justify-content: space-between;
				  margin-bottom: 14rpx;
				
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
										
					&-licence {
						width: 100%;
						display: flex;
						justify-content: space-between;
						align-items: center;
						column-gap: 18rpx;
					
						&-num {
							display: flex;
							justify-content: center;
							align-items: center;
							width: 182rpx;
							height: 58rpx;
							background-image: url('@/static/img/index/蓝牌@2x.png');
							background-repeat: no-repeat;
							background-position: 0 0;
							background-size: contain;
							font-weight: bold;
							font-size: 25rpx;
							color: #FFFFFF;
							letter-spacing: 1rpx;
					
							span {
								width: 7rpx;
								height: 7rpx;
								background: #FFFFFF;
								border-radius: 50%;
								margin: 0 10rpx 0 10rpx;
							}
						}
						
						&-amount {
							font-size: 32rpx;
							color: #FF5151;
						}
					
						// 蓝牌
						.blue {
							background-image: url('@/static/img/index/蓝牌@2x.png');
							color: #FFFFFF;
					
							span {
								background: #FFFFFF;
							}
						}
					
						// 黄牌
						.yellow {
							background-image: url('@/static/img/index/黄牌@2x.png');
							color: #333333;
					
							span {
								background: #333333;
							}
						}
					
						// 黑牌
						.black {
							background-image: url('@/static/img/index/黑牌@2x.png');
							color: #FFFFFF;
					
							span {
								background: #FFFFFF;
							}
						}
					
						// 黄绿 绿牌
						.green {
							background-image: url('@/static/img/index/绿牌@2x.png');
							color: #333333;
					
							span {
								background: #333333;
								margin: 0 7rpx 0 7rpx;
							}
						}
					
						// 白牌
						.white {
							background-image: url('@/static/img/index/白牌@2x.png');
							color: #333333;
					
							span {
								background: #333333;
							}
						}
					}
					
					&-btn {
						display: flex;
						justify-content: flex-end;
						align-items: center;
						width: 100%;
						padding: 20rpx 0 0 0;
						border-top: 2rpx solid #e8ecef;
						
						&-pay {
							width: 230rpx;
							height: 62rpx;
							background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
							border-radius: 8rpx;
							color: #FFFFFF;
							line-height: 62rpx;
							text-align: center;
						}
					}
					
					&-status {
						position: absolute;
						top: 150rpx;
						right: 20rpx;
						width: 128rpx;
						height: 112rpx;
						
						image {
						  width: 100%;
						  height: 100%;
						}
					}
				}
				
				&-con1 {
					display: flex;
					justify-content: flex-start;
				}
															
				&-con:last-child {
				  margin-bottom: 0rpx;
				}
			}
			&-item:last-child {
				margin-bottom: 0;
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