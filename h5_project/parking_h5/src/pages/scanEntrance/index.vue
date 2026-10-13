<template>
	<!-- 扫码入场 -->
	<view class="scan">
		<view class="scan-title">{{ parkName }}</view>
		<view class="scan-con">
			<view class="scan-con-title">停车缴费</view>
			<view class="scan-con-licence">
				<!-- {{ licenceValue }} -->
				<view class="scan-con-licence-info" :style="{ backgroundImage: `url(${licenceFlag ? require('@/static/img/index/绿@2x.png') : require('@/static/img/index/蓝@2x.png')})` }" @click="handleKeyboard">
					<view class="scan-con-licence-info-num" :style="{ width: `${licenceFlag ? '60rpx' : '66rpx'}`, marginRight: `${licenceFlag ? '10rpx' : '14rpx'}` }" v-for="(item,index) in licenceList" :key="index">{{ item }}</view>
				</view>
				<view class="scan-con-licence-btn" :style="{ backgroundImage: `url(${licenceFlag ? require('@/static/img/index/添加蓝牌@2x.png') : require('@/static/img/index/添加新能源@2x.png')})` }" @click="handleChangeType" />
			</view>
			<view class="scan-con-btn" @click="handleScanEntrance">无牌入场</view>
		</view>
		<!-- 车牌号键盘 -->
		<u-keyboard mode="car" autoChange @change="handleKeyboardChange" @backspace="handleKeyboardBackspace" @confirm="handleKeyboardConfirm" @cancel="handleKeyboardCancel"  :show="showKeyboard"></u-keyboard>
	</view>
</template>

<script>
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'scanEntrance',
		components: {},
		data() {
			return {
				// 车场名称
				parkName: null,
				// 车场ID
				parkId: null,
				// 道闸ID
				camId: null,
				// 车牌号 类型 false:蓝 true:绿
				licenceFlag: false,
				// 车牌号
				licenceValue: '',
				// licenceValue: '浙A12345',
				// 车牌号
				licenceList: [],
				// licenceList: ['浙','A','1','2','3','4','5'],
				// 车牌号键盘 显示/隐藏
				showKeyboard: false
			}
		},
		onLoad(option) {
			// 车场ID
			this.parkId = option.parkId
			// 道闸ID
			this.camId = option.camId
			console.log('扫码入场-车场ID',this.parkId);
			console.log('扫码入场-道闸ID',this.camId);
			
			if (this.parkId) {
				// 获取 车场 详情
				this.getDetail()
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
			...mapActions(['getYardDetail','vehicleInYard']),
			...mapMutations(['setState']),
			// 获取 车场 详情
			async getDetail() {
				const params = {
					id: Number(this.parkId) || null
				}
				console.log('params', params)
				
				const res = await this.getYardDetail(params)
				console.log('获取 车场 详情-res', res)
				if (res.flag == true) {
					if (res.data?.data && res.data?.data.length !== 0) {
						// 车场名称
						this.parkName = res.data?.data[0].parking_lot_name
						console.log('车场名称-parkName', this.parkName)
					}
				} else {
					uni.showToast({
						title: res.message,
						icon: 'none',
						duration: 2000 //持续的时间
					})
				}
			},
			// 无牌入场
			async handleScanEntrance() {
				console.log('车牌号 类型-this.licenceFlag',this.licenceFlag);
				// 蓝牌
				if (!this.licenceFlag && this.licenceValue.length !== 7) return uni.showToast({
					title: '请输入车牌号！',
					icon: 'none',
					duration: 2000,
				})
				// 绿牌
				if (this.licenceFlag && this.licenceValue.length !== 8) return uni.showToast({
					title: '请输入车牌号！',
					icon: 'none',
					duration: 2000,
				})
				console.log('键盘 点击-this.licenceValue',this.licenceValue);
				console.log('键盘 点击-this.licenceValue.length',this.licenceValue.length);
				console.log('键盘 点击-this.licenceList',this.licenceList);
				console.log('this.camId', this.camId)
				// 交互处理
				const params = {
					id: Number(this.parkId) || null,
					cam_id: this.camId || null,
					plate_num: this.licenceValue || null,
				}
				console.log('params', params)
				
				const res = await this.vehicleInYard(params)
				console.log('无牌入场-res', res)
				if (res.flag == true) {
					uni.showToast({
						title: '入场成功',
						icon: 'none',
						duration: 2000 //持续的时间
					})
					
					// 跳转页面
					setTimeout(() => {
						uni.navigateTo({
							url: `/pages/scanEntrance/tip?parkName=${this.parkName}`,
						})
					},500)
				} else {
					uni.showToast({
						title: res.message,
						icon: 'none',
						duration: 2000 //持续的时间
					})
				}
			},
			// 点击图标 切换 车牌号 类型
			handleChangeType() {
				console.log('切换 车牌号 类型-this.licenceFlag',this.licenceFlag);
				this.licenceFlag = !this.licenceFlag
				// 重置 车牌号
				this.licenceValue = ''
				this.licenceList = []
			},
			// 打开 车牌号键盘
			handleKeyboard() {
				console.log('打开 车牌号键盘');
				this.showKeyboard = true
				// 重置 车牌号
				// this.licenceValue = ''
				// this.licenceList = []
			},
			// 键盘 按键被点击(点击退格键不会触发此事件)
			handleKeyboardChange(val) {
				console.log('键盘 点击-val',val);
				// 将每次按键的值拼接到licenceValue变量中，注意+=写法
				// 蓝牌
				if (!this.licenceFlag && this.licenceValue.length >= 7) return
				// 绿牌
				if (this.licenceFlag && this.licenceValue.length >= 8) return
				this.licenceValue += val;
				this.licenceList = this.licenceValue.split('')
				console.log('键盘 点击-this.licenceValue',this.licenceValue);
				console.log('键盘 点击-this.licenceValue.length',this.licenceValue.length);
				console.log('键盘 点击-this.licenceList',this.licenceList);
			},
			// 键盘 退格键被点击
			handleKeyboardBackspace() {
				// 删除licenceValue的最后一个字符
				if(this.licenceValue.length) {
					this.licenceValue = this.licenceValue.substr(0, this.licenceValue.length - 1)
					this.licenceList = this.licenceValue.split('')
				} 
				console.log('键盘 退格-this.licenceValue',this.licenceValue);
				console.log('键盘 退格-this.licenceList',this.licenceList);
			},
			// 键盘 完成
			handleKeyboardConfirm() {
				this.showKeyboard = false
				console.log('键盘 完成-this.licenceValue',this.licenceValue);
				console.log('键盘 完成-this.licenceList',this.licenceList);
			},
			// 键盘 取消
			handleKeyboardCancel() {
				this.showKeyboard = false
				console.log('键盘 取消-this.licenceValue',this.licenceValue);
				console.log('键盘 取消-this.licenceList',this.licenceList);
			},
		}
	}
</script>

<style lang="less" scoped>
	.scan {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		background: url('@/static/img/index/bg@2x.png') no-repeat;
		background-position: 0 0;
		background-size: 100% 595rpx;
		padding: 20rpx;
		
		&-title {
			font-weight: bold;
			font-size: 32rpx;
			color: #333333;
			line-height: 45rpx;
			margin: 0 0 201rpx 0;
		}
		
		&-con {
			width: 690rpx;
			height: 800rpx;
			background: linear-gradient( 180deg, #FFFFFF 0%, rgba(255,255,255,0) 100%);
			border-radius: 20rpx 20rpx 0rpx 0rpx;
			margin-left: 10rpx;
			padding: 30rpx 20rpx 0 20rpx;
			
			&-title {
				font-weight: bold;
				font-size: 36rpx;
				color: #333333;
				line-height: 50rpx;
			}
			
			&-licence {
				display: flex;
				justify-content: space-between;
				width: 100%;
				margin-top: 24rpx;
				
				&-info {
					display: flex;
					// justify-content: space-between;
					// column-gap: 14rpx;
					// width: 544rpx;
					width: 540rpx;
					height: 74rpx;
					// background: url('@/static/img/index/蓝@2x.png') no-repeat;
					background-image: url('@/static/img/index/蓝@2x.png');
					background-repeat: no-repeat;
					background-position: 0 0;
					background-size: contain;
						
					&-num {
						width: 66rpx;
						height: 74rpx;
						// background: #E8EFF8;
						border-radius: 5rpx;
						font-weight: bold;
						font-size: 40rpx;
						color: #333333;
						line-height: 74rpx;
						text-align: center;
						margin-right: 14rpx;
					}
					
					&-num:nth-child(1) {
						color: #FFFFFF;
					}
					// &-num:nth-child(7) {
					// 	margin-right: 0rpx;
					// }
					&-num:last-child {
						margin-right: 0rpx !important;
					}
				}
					
				&-btn {
					width: 66rpx;
					height: 74rpx;
					// background: url('@/static/img/index/添加新能源@2x.png') no-repeat;
					background-image: url('@/static/img/index/添加新能源@2x.png');
					background-repeat: no-repeat;
					background-position: center;
					background-size: contain;
				}
			}
							
			&-btn {
				width: 650rpx;
				height: 80rpx;
				background: #1D84FA;
				border-radius: 10rpx;
				font-size: 32rpx;
				color: #FFFFFF;
				line-height: 80rpx;
				text-align: center;
				margin-top: 62rpx;
			}
		}
	}
</style>