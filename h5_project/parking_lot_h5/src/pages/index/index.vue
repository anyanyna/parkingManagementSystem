<template>
	<!-- 首页 -->
	<view class="index">
		<!-- 导航栏 -->
		<navbar class="index-navbar" title="首页" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="index-menu">
			<view class="index-menu-title">Hi~别来无恙，XXX</view>
			<view class="index-menu-top">
				<view class="index-menu-top-item" v-for="(item, index) in topMenuList" :key="index" @click="handleGo(item)">
					<view class="index-menu-top-item-icon">
						<image :src="item.icon" mode=""></image>
					</view>
					<view class="index-menu-top-item-title">{{ item.title }}</view>
				</view>
			</view>
			<view class="index-menu-center">
				<view class="index-menu-center-item" v-for="(item, index) in centerMenuList" :key="index" @click="handleGo(item)">
					<view class="index-menu-center-item-icon">
						<image :src="item.icon" mode=""></image>
					</view>
					<view class="index-menu-center-item-title">{{ item.title }}</view>
				</view>
			</view>
			<view class="index-menu-footer">
				<view class="index-menu-footer-title">历史欠费</view>
				<view class="index-menu-footer-value">共<span>{{ arrearageList.length || 0 }}</span>笔</view>
			</view>
		</view>
		<!-- 列表 -->
		<view class="index-list">
			<u-checkbox-group @change="handleselect" placement="column" iconPlacement="left">
				<template v-for="(item,index) in arrearageList">
					<view class="index-list-item" :key="item.id">
						<view class="index-list-item-con" v-for="(con, index) in arrearageInfo" :key="index">
							<view class="index-list-item-con-licence" v-if="con.key === 'licence'">
								<u-checkbox :checked="selectStatus" :name="JSON.stringify(item)" :key="item.id" shape="circle" activeColor="#1D84FA"></u-checkbox>
								<view class="index-list-item-con-licence-num" :class=" '' | typeColorFilter(item.type)">
									{{ item.licence ? item.licence.slice(0, 2) : null }}<span></span>{{ item.licence ? item.licence.slice(2) : null }}
								</view>
							</view>
							<template v-else-if="con.key === 'name' || con.key === 'time' || con.key === 'duration'">
								<view class="index-list-item-con-key">{{ con.title }}</view>
								<view class="index-list-item-con-value">{{ item[con.key] }}</view>
							</template>
							<template v-else-if="con.key === 'amount'">
								<view class="index-list-item-con-amount">欠费:<span>￥{{ item[con.key] || 0 }}</span></view>
							</template>
						</view>
					</view>
				</template>
			</u-checkbox-group>
			<view class="index-list-line"></view>
		</view>
		<!-- 一键清欠 -->
		<view class="index-footer">
			<view class="index-footer-info">
				<view class="index-footer-info-select">
					<u-checkbox-group
						v-model="checkboxValue"
						placement="column"
						@change="handleSelectAll"
					>
						<u-checkbox
								:customStyle="{marginBottom: '0px'}"
								v-for="(item, index) in checkboxList"
								:key="index"
								:label="item.name"
								:name="item.name"
								shape="circle"
								activeColor="#1D84FA"
						>
						</u-checkbox>
					</u-checkbox-group>
				</view>
				<view class="index-footer-info-con">
					<view class="index-footer-info-con-amount">订单金额:<span>￥{{ 100 }}</span></view>
					<view class="index-footer-info-con-btn" @click="handleSubmit">一键清欠</view>
				</view>
			</view>
		</view>
		<!-- 上拉加载 -->
		<view v-show="isLoadMore" class="index-load" :class="total === 0 ? 'tip' : ''">
			<u-loadmore :status="status" :line="true" :icon="false" :loading-text="loadingText" :loadmore-text="loadmoreText" :nomore-text="nomoreText" marginTop="0" marginBottom="0" />
		</view>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'index',
		components: {},
		data() {
			return {
				// top 功能菜单
				topMenuList: [
				  {
				    title: '找车位',
				    total: 0,
				    url: '',
				    icon: require('@/static/img/index/找车位@2x.png'),
				  },
				  {
				    title: '找长租',
				    total: 0,
				    url: '/pages/findRent/index',
				    icon: require('@/static/img/index/找长租@2x.png'),
				  },
				  {
				    title: '优惠券',
				    total: 0,
				    url: '',
				    icon: require('@/static/img/index/优惠券@2x.png'),
				  },
				  {
				    title: '扫一扫',
				    total: 0,
				    url: '',
				    icon: require('@/static/img/index/扫一扫@2x.png'),
				  },
				],
				// center 功能菜单
				centerMenuList: [
				  {
				    title: '预约共享',
				    total: 0,
				    url: '',
				    icon: require('@/static/img/index/预约共享@2x.png'),
				  },
				  {
				    title: '预约记录',
				    total: 0,
				    url: '',
				    icon: require('@/static/img/index/预约记录@2x.png'),
				  },
				  {
				    title: '我的车辆',
				    total: 0,
				    url: '/pages/car/index',
				    icon: require('@/static/img/index/我的车辆@2x.png'),
				  },
				  {
				    title: '长租记录',
				    total: 0,
				    url: '/pages/longRent/index',
				    icon: require('@/static/img/index/长租记录@2x.png'),
				  },
				  {
				    title: '停车记录',
				    total: 0,
				    url: '/pages/park/index',
				    icon: require('@/static/img/index/停车记录@2x.png'),
				  },
				  {
				    title: '我的账号',
				    total: 0,
				    url: '/pages/user/index',
				    icon: require('@/static/img/index/我的账号@2x.png'),
				  },
				],
				// 历史欠费 信息
				arrearageInfo: [
				  { key: 'licence', title: '车牌' },
				  { key: 'type', title: '车牌类型' },
				  { key: 'name', title: '停车车场' },
				  { key: 'time', title: '驶出时间' },
				  { key: 'duration', title: '停车时长' },
				  { key: 'amount', title: '欠费' },
				],
				// 历史欠费 列表 数据
				arrearageList: [],
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
				// 列表选择项 checked选择状态
				selectStatus: false,
				// 列表选择项 选择id
				selectId: [],
				// 列表选择项 操作项id
				handleId: null,
				// 全选 复选框 值
				checkboxValue:[],
				// checkboxValue:['全选'],
				// 全选 复选框 数据
				checkboxList: [{
						name: '全选',
						disabled: false
					}
				],
			}
		},
		onLoad(option) {},
		async onShow() {
		  // 获取 列表 数据
		  this.getArrearageList()
		  console.log('userInfo', this.userInfo)
		},
		onPullDownRefresh() {
		  this.current = 1
		  this.getArrearageList()
		  setTimeout(function () {
		    uni.stopPullDownRefresh()
		  }, 1000)
		},
		onReachBottom() {
		  if (!this.isLoadMore) {
		    this.isLoadMore = true
		    this.current = this.current + 1
		    this.getArrearageList()
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
			...mapActions(['']),
			...mapMutations(['setState']),
			// 获取 历史欠费 列表
			async getArrearageList() {
				this.arrearageList = [
					{
						id: 1,
						licence: '浙AVG121',
						type: '蓝牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 2,
						licence: '浙AVG1222',
						type: '绿牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 3,
						licence: '浙AVG123',
						type: '黄牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 4,
						licence: '浙AVG124',
						type: '黑牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 5,
						licence: '浙AVG125',
						type: '黄绿',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 6,
						licence: '浙AVG126',
						type: '白牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
					{
						id: 7,
						licence: '浙AVG127',
						type: '蓝牌',
						name: '永宁路小学南停车场',
						time: '2024-01-09',
						duration: '6小时',
						amount: '15.00'
					},
				]
				// const params = {
				//   name: this.search || '',
				//   userName: this.userInfo.username,
				// 	pageNum: this.current,
				// 	pageSize: this.size,
				// }
			 //  const res = await this.queryMeetingSummaryList(params)
			 //  if (res.code == 20000) {
			 //    if (this.current === 1) {
			 //      this.arrearageList = []
			 //    }
			 //    this.total = res.data.total
			 //    this.arrearageList = this.arrearageList.concat(res.data.records)
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
			handleSubmit () {
				console.log('一键清欠');
			},
			// 复选框 change事件 全选 || !全选
			handleSelectAll (e) {
				console.log('change-e', e);
				this.checkboxValue = e
				console.log('change-checkboxValue', this.checkboxValue);
				if (this.checkboxValue.length !== 0) {
					this.selectStatus = false
					this.$nextTick(() => {
						this.selectStatus = true
					})
					console.log('全选-selectStatus',this.selectStatus)
					this.selectId = this.arrearageList.map(i => {
						return i.id
					})
					console.log('全选-selectId',this.selectId)
				} else {
					this.selectStatus = false
					console.log('!全选-selectStatus',this.selectStatus)
					this.selectId = []
					console.log('!全选-selectId',this.selectId)
				}
			},
			// 复选框 change事件 列表选择项
			handleselect (selectInfo) {
				console.log('selectInfo',selectInfo)
				console.log('selectInfo.length',selectInfo.length)
				console.log('this.arrearageList.length',this.arrearageList.length)
				if (selectInfo.length === this.arrearageList.length) {
					this.checkboxValue = ['全选']
					console.log('全选-checkboxValue',this.checkboxValue)
				} else {
					this.checkboxValue = []
					console.log('!全选-checkboxValue',this.checkboxValue)
				}
				 this.selectId = selectInfo.map(i=>{
					return JSON.parse(i).id
				})
				console.log('selectId',this.selectId)
			},
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
	.index {
		width: 100%;
		// height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;

		// 列表设置
		&-navbar {
			position: fixed;
			top: 0;
			// background: none;
			width: 100%;
			background: url('@/static/img/index/bg1@2x.png') no-repeat;
			background-position: 0 0;
			background-size: cover;
			// background-size: 100% 100%;
		}
				
		&-menu {
			position: fixed;
			top: 88rpx;
			width: 100%;
			height: 630rpx;
			background: url('@/static/img/index/bg@2x.png') no-repeat;
			background-position: 0 0;
			background-size: 100% 339rpx;
			padding: 23rpx 30rpx 0 30rpx;
			z-index: 9999;
			
			&-title {
				font-weight: bold;
				font-size: 40rpx;
				color: #FFFFFF;
				line-height: 56rpx;
			}
			
			&-top {
				display: flex;
				justify-content: space-between;
				width: 100%;
				height: 108rpx;
				margin-top: 44rpx;
				
				&-item {
					display: flex;
					flex-direction: column;
					justify-content: space-between;
					align-items: center;
					&-icon {
					  width: 54rpx;
					  height: 54rpx;
						
					  image {
					    width: 100%;
					    height: 100%;
					  }
					}
					
					&-title {
					  font-size: 30rpx;
						line-height: 42rpx;
					  color: #FFFFFF;
					}
					
				}
			}
			
			&-center {
				display: flex;
				flex-wrap: wrap;
				width: 100%;
				height: 288rpx;
				background: #FFFFFF;
				border-radius: 10rpx;
				margin-top: 20rpx;
				padding: 21rpx 0;
				
				&-item {
					display: flex;
					flex-direction: column;
					justify-content: space-between;
					align-items: center;
					width: 33%;
					height: 110rpx;
					margin-bottom: 26rpx;
					&-icon {
					  width: 56rpx;
					  height: 56rpx;
						
					  image {
					    width: 100%;
					    height: 100%;
					  }
					}
					
					&-title {
					  font-size: 28rpx;
						line-height: 40rpx;
					  color: #1C3148;
					}
					
				}
			}
			
			&-footer {
				display: flex;
				align-items: center;
				column-gap: 10rpx;
				padding: 42rpx 0 15rpx 0;
				background: #f0f2f2;
				
				
				&-title {
					font-weight: bold;
					font-size: 34rpx;
					color: #1C3148;
					line-height: 48rpx;
				}
				
				&-value {
					font-size: 30rpx;
					color: #687582;
					line-height: 42rpx;
					
					span {
						color: #1D84FA;
					}
				}
			}
		}
		
		&-list {
			width: 100%;
			z-index: 1;
			margin-top: 732rpx;
			padding: 0 30rpx 0 30rpx;
			
			&-line {
				width: 100%;
				height: 102rpx;
				margin-top: 20rpx;
			}
			
			&-item {
				width: 100%;
				// height: 348rpx;
				background: #FFFFFF;
				border-radius: 10rpx;
				padding: 20rpx;
				margin-bottom: 24rpx;
				
				&-con {
				  display: flex;
					justify-content: space-between;
				  margin-bottom: 14rpx;
				
				  &-key {
				    // min-width: 170rpx;
				    min-width: 200rpx;
				    font-size: 28rpx;
				    color: #687582;
				    line-height: 40rpx;
				    // white-space:nowrap;
				    // margin-right: 24rpx;
				  }
					
				  &-value {
				    max-width: 450rpx;
				    font-size: 28rpx;
				    color: #1C3148;
				    line-height: 40rpx;
				    word-break: break-all;
				    // white-space:nowrap;
				    // overflow:hidden;
				    // text-overflow:ellipsis;
				  }
					
					&-licence {
						display: flex;
						justify-content: center;
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
					
					&-amount {
						width: 100%;
						font-weight: bold;
						font-size: 30rpx;
						color: #1C3148;
						line-height: 42rpx;
						text-align: right;
						padding: 14rpx 0 0 0;
						border-top: 2rpx solid #e8ecef;
						
						span {
							color: #FF5151;
						}
					}
				}
				
				&-con:nth-child(2) {
					margin-bottom: 0;
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
				
				&-select {
					
				}
				
				&-con {
					display: flex;
					align-items: center;
					
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
		}
		
		
		&-load {
			padding-bottom: 30rpx;
		}
		.tip {
			position: absolute;
			left: 50%;
			top: 50%;
			transform: translate(-50%,-50%);
		}
	}
</style>
