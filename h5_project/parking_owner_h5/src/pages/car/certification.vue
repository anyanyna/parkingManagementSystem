<template>
	<!-- 车辆认证 -->
	<view class="car">
		<!-- 导航栏 -->
		<navbar class="car-navbar" title="车辆认证" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="car-con">
			<view class="car-con-form">
				<u-form :model="formInfo" :rules="rules" ref="form" labelWidth="auto">
					<!-- 附件 上传 -->
					<view class="car-con-form-item">
						<u-form-item prop="content">
							<u-upload
								:fileList="fileList1"
								@afterRead="afterRead"
								@delete="deletePic"
								name="1"
								multiple
								:maxCount="1"
								width="690rpx"
								height="400rpx"
							>
								<view class="car-con-form-item-upload">
									<image src="@/static/img/car/上传@2x.png" mode="" />
								</view>
							</u-upload>
						</u-form-item>
					</view>
					<view class="car-con-form-item">
						<u-form-item label="车牌颜色" prop="type" @click="handleSelect('type')">
							<u-input style="pointer-events:none" v-model="formInfo.type" color="#333333" placeholder="请选择" placeholderStyle="color: #BBBBBB;" inputAlign="right" border="none" suffixIcon="arrow-right" disabled />
						</u-form-item>
					</view>
					<view class="car-con-form-item">
						<u-form-item label="车牌号" prop="licence" @click="handleSelect('licence')">
							<u-input style="pointer-events:none" v-model="formInfo.licence" border="none" color="#333333" placeholder="请输入" placeholderStyle="color: #BBBBBB;" inputAlign="right" clearable disabled />
						</u-form-item>
					</view>
				</u-form>
			</view>
			<view class="car-con-btn" @click="handleSubmit">提交车辆</view>
		</view>
		<!-- 选择器 -->
		<u-picker :show="showSelect" title="选择类型" :columns="columns" keyName="orgFullname" @confirm="handleSelectConfirm" @cancel="handleSelectCancel"></u-picker>
		<!-- 车牌号键盘 -->
		<u-keyboard mode="car" autoChange @change="handleKeyboardChange" @backspace="handleKeyboardBackspace" @confirm="handleKeyboardConfirm" @cancel="handleKeyboardCancel"  :show="showKeyboard"></u-keyboard>
	</view>
</template>

<script>
	import api from '@/lib/api.js'
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'carCertification',
		components: {},
		data() {
			return {
				// 表单
				formInfo: {
					licence: '',
					type: null,
					attachments: null,
				},
				rules: {
					licence: {
						type: 'string',
						required: true,
						message: '请输入车牌号',
						trigger: ['blur', 'change']
					},
					type: {
						type: 'string',
						required: true,
						message: '请选择车牌颜色',
						trigger: ['blur', 'change']
					},
				},
				// 选择类型
				selectType: '',
				// 选择器 数据
				columns: [],
				licenceTypeList: [[
					'蓝牌','绿牌','黄牌','黑牌','黄绿','白牌'
				]],
				// 显示 选择器
				showSelect: false,
				// 车牌号键盘 显示/隐藏
				showKeyboard: false,
				// 附件
				fileList1: [
					// {
					// 	"url": "https://cdn.uviewui.com/uview/swiper/1.jpg",
					// },
					// {
					// 	"url": "https://cdn.uviewui.com/uview/swiper/1.jpg",
					// },
				],
			}
		},
		onLoad(option) {},
		onShow() {
			console.log('userInfo', this.userInfo)
		},
		computed: {
			...mapState({
				userInfo: state => state.userInfo,
				fileUploadUrl: state => state.fileUploadUrl,
			}),
		},
		methods: {
			...mapActions(['']),
			...mapMutations(['setState']),
			// 提交
			handleSubmit () {
				// 如果有错误，会在catch中返回报错信息数组，校验通过则在then中返回true
				this.$refs.form.validate().then(res => {
					console.log('this.formInfo',this.formInfo)
					
					// 文件是否上传完成 校验
					let count = 0
					for(let i in this.fileList1){
						if(this.fileList1[i].status === 'uploading'){
							count++
							break
						}
					}
					if(count > 0) return uni.showToast({
						title: '文件上传中，请等待',
						icon: 'none',
						duration: 1000 //持续的时间
					})
					
					let attachments = null
					// 附件 attachments
					if (this.fileList1.length !== 0) {
						attachments = this.fileList1.map(i => {
							return {
								name: i.name || null,
								url: this.extractResourcePartRegex(i.url) || null
							}
						})
					}
					
					console.log('附件-fileList1', this.fileList1)
					console.log('attachments', attachments)
					
					const params = {
						...this.formInfo,
						attachments: attachments ? JSON.stringify(attachments) : null,
					}
					console.log('params',params)
					// this.addVisitorReservation(params).then(res => {
					// 	if (res.code == 20000) {
					// 		uni.showToast({
					// 			title: '成功!',
					// 			icon: 'none',
					// 			duration: 2000 //持续的时间
					// 		})
					// 		setTimeout(() => {
					// 			// 取消 返回上一页面
					// 			this.handleBack()
					// 		},500)
					// 	} else {
					// 		uni.showToast({
					// 			title: res.message,
					// 			icon: 'none',
					// 			duration: 2000 //持续的时间
					// 		})
					// 	}
					// })
				}).catch(errors => {
					// uni.$u.toast(errors)
				})
			},
			// 下拉选择 显示 赋值
			handleSelect (type) {
				console.log('type',type);
				if (type === 'licence') {
					// 车牌号
					if (!this.formInfo.type) return uni.showToast({
						title: '请选择车牌颜色',
						icon: 'none',
						duration: 1000 //持续的时间
					})
					this.selectType = type
					// 打开 车牌号键盘
					this.showKeyboard = true
				} else if (type === 'type') {
					// 车牌颜色
					this.showSelect = true
					this.selectType = type
					this.columns = this.licenceTypeList
				}
			},
			// 下拉选择 确认
			handleSelectConfirm(e) {
				console.log('下拉选择-确认',e);
				if (this.selectType === 'type') {
					// 车牌颜色
					this.formInfo.type = e.value[0]
					console.log('车牌颜色-type',this.formInfo.type);
				}
				this.showSelect = false
			},
			// 下拉选择 取消
			handleSelectCancel() {
				this.showSelect = false
				this.selectType = ''
			},
			// 键盘 按键被点击(点击退格键不会触发此事件)
			handleKeyboardChange(val) {
				console.log('键盘 点击-val',val);
				console.log('键盘 点击-this.formInfo.licence-0',this.formInfo.licence);
				// 将每次按键的值拼接到formInfo.licence变量中，注意+=写法
				// 蓝牌
				if (this.formInfo.type !== '绿牌' && this.formInfo.licence?.length >= 7) return
				// 绿牌
				if (this.formInfo.type === '绿牌' && this.formInfo.licence?.length >= 8) return
				this.formInfo.licence += val;
				// this.licenceList = this.formInfo.licence.split('')
				console.log('键盘 点击-this.formInfo.licence',this.formInfo.licence);
				console.log('键盘 点击-this.formInfo.licence.length',this.formInfo.licence.length);
				// console.log('键盘 点击-this.licenceList',this.licenceList);
			},
			// 键盘 退格键被点击
			handleKeyboardBackspace() {
				// 删除formInfo.licence的最后一个字符
				if(this.formInfo.licence.length) {
					this.formInfo.licence = this.formInfo.licence.substr(0, this.formInfo.licence.length - 1)
					this.licenceList = this.formInfo.licence.split('')
				} 
				console.log('键盘 退格-this.formInfo.licence',this.formInfo.licence);
				// console.log('键盘 退格-this.licenceList',this.licenceList);
			},
			// 键盘 完成
			handleKeyboardConfirm() {
				this.showKeyboard = false
				console.log('键盘 完成-this.formInfo.licence',this.formInfo.licence);
				// console.log('键盘 完成-this.licenceList',this.licenceList);
			},
			// 键盘 取消
			handleKeyboardCancel() {
				this.showKeyboard = false
				console.log('键盘 取消-this.formInfo.licence',this.formInfo.licence);
				// console.log('键盘 取消-this.licenceList',this.licenceList);
			},
			// 删除图片
			deletePic(event) {
				this[`fileList${event.name}`].splice(event.index, 1)
			},
			// 新增图片
			async afterRead(event) {
				console.log('event',event);
				// 当设置 multiple 为 true 时, file 为数组格式，否则为对象格式
				let lists = [].concat(event.file)
				let fileListLen = this[`fileList${event.name}`].length
				lists.map((item) => {
					this[`fileList${event.name}`].push({
						...item,
						status: 'uploading',
						message: '上传中'
					})
				})
				for (let i = 0; i < lists.length; i++) {
					const result = await this.uploadFilePromise(lists[i].url)
					let item = this[`fileList${event.name}`][fileListLen]
					this[`fileList${event.name}`].splice(fileListLen, 1, Object.assign(item, {
						status: 'success',
						message: '',
						url: result
					}))
					fileListLen++
				}
			},
			uploadFilePromise(url) {
				return new Promise((resolve, reject) => {
					let a = uni.uploadFile({
						url: api('/:gemapi/resource/fileUpload/a09fe71ca88f44a085076b47be78ecfe/0'), // 接口地址
						// url: api('/:rest/image/upload'), // 接口地址
						filePath: url,
						name: 'file',
						header: {
							token: this.token,
						},
						formData: {
							// user: 'test'
						},
						success: (res) => {
							console.log('res',res);
							setTimeout(() => {
								if (res.statusCode === 200) {
									// let response = JSON.parse(res.data)
									let response = JSON.parse(res.data)
									console.log('response',response);
									let fileUrl = this.fileUploadUrl + response.data
									console.log('fileUrl',fileUrl);
									resolve(fileUrl)
									// resolve(response.data)
								}
							}, 1000)
						}
					});
				})
			},
			// 附件 截取 /resource后部分
			extractResourcePartRegex(url) {  
				// 使用正则表达式匹配'/resource'及其后的所有内容  
				const regex = /\/resource(.*)$/;  
				const match = url.match(regex);  
			
				// 如果找到了匹配项，则返回匹配到的字符串（去掉前面的'/'）  
				// 注意：match[1]获取的是第一个括号内的匹配内容  
				if (match && match[1]) {  
						return '/resource' + match[1];  
				}  
			
				// 如果没有找到匹配项，则返回null或相应的错误消息  
				return null;  
			},
			// 取消 返回上一页面
			handleBack () {
				uni.navigateBack({
					delta: 1
				})
			},
		}
	}
</script>

<style lang="less" scoped>
	.car {
		width: 100%;
		height: 100%;
		background: #FFFFFF;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 列表设置
		// &-navbar {
		// 	position: fixed;
		// }
		
		// // 列表设置
		// &-con {
		// 	position: fixed;
		// 	top: 88rpx;
		// 	width: 100%;
		// 	background: #F0F2F5;
		// 	z-index: 999;
		// }
		
		// 非列表设置
		&-con {
			width: 100%;
			padding: 0 30rpx 30rpx 30rpx;
			
			&-form {
				width: 100%;
				&-item {
					padding: 24rpx 0;
					border-bottom: 1rpx solid #E1E1E1;
					
					&-upload {
						width: 100%;
						height: 400rpx;
						
						image {
							width: 690rpx;
							height: 400rpx;
							// width: 100%;
							// height: 100%;
						}
						
					}
				}
				
				&-item:first-child {
					border-bottom: 0;
				}
				
				/deep/.u-form-item__body__left__content__required {
					position: static;
				}
				/deep/.u-form-item__body__left__content__label {
					color: #666666;
				}
				/deep/.u-form-item__body {
					padding: 0;
				}
				/deep/.u-form-item__body__left {
					margin-right: 24rpx;
				}
				/deep/.u-input {
					background: #FFFFFF !important;
					padding: 0 !important;
				}
				/deep/.u-input__content__subfix-icon {
					margin-top: 6rpx;
				}
				
				.textarea {
					/deep/.u-form-item__body__left {
						display: block;
					}
					/deep/.u-textarea {
						padding: 0;
					}
				}
			}
			
			&-btn {
				position: fixed;
				left: 30rpx;
				bottom: 60rpx;
				width: 690rpx;
				height: 80rpx;
				background: linear-gradient( 180deg, #1DC5FA 0%, #1D84FA 100%);
				border-radius: 8rpx;
				font-size: 30rpx;
				color: #FFFFFF;
				line-height: 80rpx;
				text-align: center;
			}
		}
	}
</style>