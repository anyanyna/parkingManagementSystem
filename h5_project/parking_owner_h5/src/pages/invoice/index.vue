<template>
	<!-- 我的发票 -->
	<view class="invoice">
		<!-- 导航栏 -->
		<navbar class="invoice-navbar" title="我的发票" :isShowBack="true"></navbar>
		<view class="invoice-nav">
			<!-- tab栏 -->
			<view class="invoice-nav-tabs">
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
		<view class="invoice-list">
			<view class="invoice-list-item" v-for="(item,index) in invoiceList" :key="item.id" @click="handleView(item)">
				<view class="invoice-list-item-con" v-for="(con, index) in invoiceInfo" :key="index">
					<view class="invoice-list-item-con-licence" v-if="con.key === 'licence'">
						<view class="invoice-list-item-con-licence-num" :class=" '' | typeColorFilter(item.type)">
							{{ item.licence ? item.licence.slice(0, 2) : null }}<span></span>{{ item.licence ? item.licence.slice(2) : null }}
						</view>
						<view class="invoice-list-item-con-licence-amount">￥{{ item.amount || 0 }}</view>
					</view>
					<template v-else-if="con.key === 'name' || con.key === 'time' || con.key === 'duration'">
						<view class="invoice-list-item-con-key">{{ con.title }}</view>
						<view class="invoice-list-item-con-value">{{ item[con.key] }}</view>
					</template>
					<!-- 按钮 -->
					<template v-else-if="con.key === 'status'">
						<view class="invoice-list-item-con-btn">
							<view v-if="item.status === '待开票'" class="invoice-list-item-con-btn-make" @click.stop="handleInvoice(item)">申请开票</view>
							<view v-if="item.status === '已开票'" class="invoice-list-item-con-btn-download" @click.stop="handleDownload(item)">下载发票</view>
						</view>
					</template>
				</view>
			</view>
		</view>
		<!-- 上拉加载 -->
		<view v-show="isLoadMore" class="invoice-load" :class="total === 0 ? 'tip' : ''">
			<u-loadmore :status="status" :line="true" :icon="false" :loading-text="loadingText" :loadmore-text="loadmoreText" :nomore-text="nomoreText" marginTop="0" marginBottom="0" />
		</view>
	</view>
</template>

<script>
	import {mapActions,mapMutations,mapState} from 'vuex';
	export default {
		name: 'invoice',
		components: {},
		data() {
			return {
				// 类型 全部 待开票 已开票
				tabKey: '全部',
				tabsList: [{
						name: '全部'
					},
					{
						name: '待开票'
					},
					{
						name: '已开票'
					}
				],
				// 我的发票 信息
				invoiceInfo: [
					{ key: 'licence', title: '车牌' },
					// { key: 'type', title: '车牌类型' },
					{ key: 'name', title: '停车车场' },
					{ key: 'time', title: '驶出时间' },
					{ key: 'duration', title: '停车时长' },
					{ key: 'amount', title: '金额' },
					{ key: 'status', title: '支付状态' },
				],
				// 我的发票 列表
				invoiceList: [
					{
						id: 1,
						status: '已开票',
						licence: '浙AVG121',
						type: '蓝牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 2,
						status: '待开票',
						licence: '浙AVG1222',
						type: '绿牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 3,
						status: '已开票',
						licence: '浙AVG123',
						type: '黄牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 4,
						status: '待开票',
						licence: '浙AVG124',
						type: '黑牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 5,
						status: '已开票',
						licence: '浙AVG125',
						type: '黄绿',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 6,
						status: '待开票',
						licence: '浙AVG126',
						type: '白牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09 11:00:23',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 7,
						status: '已开票',
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
			// 获取 我的发票 数据
			// this.getInvoiceList()
		  console.log('userInfo', this.userInfo)
		},
		onPullDownRefresh() {
			this.current = 1
			this.getInvoiceList()
			setTimeout(function() {
				uni.stopPullDownRefresh()
			}, 1000);
		},
		onReachBottom() {
			if (!this.isLoadMore) {
				this.isLoadMore = true
				this.current = this.current + 1
				this.getInvoiceList()
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
			...mapActions(['queryinvoiceList','queryPartyMemberList','queryPartyAreaList','queryDeptTree','queryPartyAreaAll','queryPartyOrgAll','queryDataDictionaryList']),
			...mapMutations(['setState']),
			// 获取 我的发票 列表
			async getInvoiceList() {
				// const params = {
				//   name: this.search || '',
				//   userName: this.userInfo.username,
				// 	pageNum: this.current,
				// 	pageSize: this.size,
				// }
			 //  const res = await this.queryMeetingSummaryList(params)
			 //  if (res.code == 20000) {
			 //    if (this.current === 1) {
			 //      this.invoiceList = []
			 //    }
			 //    this.total = res.data.total
			 //    this.invoiceList = this.invoiceList.concat(res.data.records)
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
				} else if (item.name === '待开票') {
					// 待开票
					this.tabKey = '待开票'
				} else if (item.name === '已开票') {
					// 已开票
					this.tabKey = '已开票'
				}
				
				// 在切换tab后滚动到顶部
				this.$nextTick(() => {
					uni.pageScrollTo({
						scrollTop: 0,
						duration: 300 // 滚动动画时长，默认300ms
					});
				});
				this.current = 1
				this.getInvoiceList()
			},
			// 查看 详情
			handleView(item) {
				console.log('查看 详情-tabKey',this.tabKey);
				console.log('查看 详情-item',item);
				// uni.navigateTo({
				// 	url: '/pages/invoice/detail?baseInfo='+encodeURIComponent(JSON.stringify(item))
				// })
			},
			// 申请开票
			handleInvoice(item) {
				console.log('申请开票-item',item);
				uni.navigateTo({
					url: '/pages/invoice/apply?baseInfo='+encodeURIComponent(JSON.stringify(item))
				})
			},
			// 下载发票
			handleDownload(item) {
				console.log('下载发票-item',item);
				// uni.navigateTo({
				// 	url: '/pages/index/pay?baseInfo='+encodeURIComponent(JSON.stringify(item))
				// })
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
						
						&-make {
							width: 230rpx;
							height: 62rpx;
							background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
							border-radius: 8rpx;
							color: #FFFFFF;
							line-height: 62rpx;
							text-align: center;
						}
						
						&-download {
							width: 230rpx;
							height: 62rpx;
							border: 1rpx solid #1D84FA;
							border-radius: 8rpx;
							color: #1D84FA;
							line-height: 60rpx;
							text-align: center;
							margin: 0 0 0 24rpx;
						}
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