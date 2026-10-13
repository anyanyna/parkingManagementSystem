<template>
	<!-- 反馈建议 -->
	<view class="user">
		<!-- 导航栏 -->
		<navbar class="user-navbar" title="反馈建议" :isShowBack="true"></navbar>
		<!-- 内容 -->
		<view class="user-con">
			<view class="user-con-form">
				<u-form :model="formInfo" :rules="rules" ref="form" labelWidth="auto" :labelStyle="{color: '#343241', fontSize: '32rpx', lineHeight: '45rpx', fontWeight: 'bold'}">
					<view class="user-con-form-item">
						<u-form-item label="问题反馈" prop="problem">
							<u-textarea v-model="formInfo.problem" border="none" color="#1C3148" placeholder="请填写10字以内的问题/建议描述，我们会根据您的反馈为您提供更好的服务。" placeholderStyle="color: #687582; font-size: 30rpx;" :customStyle="{background: '#FFFFFF', padding: '14rpx 0rpx'}" maxlength="-1" />
						</u-form-item>
					</view>
					<view class="user-con-form-item">
						<u-form-item label="上传凭证或截图" prop="files">
							<u-upload
								:fileList="fileList1"
								@afterRead="afterRead"
								@delete="deletePic"
								name="1"
								multiple
								:maxCount="10"
								accept="file"
								uploadIcon="plus"
							>
							</u-upload>
						</u-form-item>
					</view>
				</u-form>
			</view>
			<view class="user-con-btn" @click="handleSubmit">提交</view>
		</view>
	</view>
</template>

<script>
	import api from '@/lib/api.js'
	import { mapActions, mapMutations, mapState } from 'vuex';
	export default {
		name: 'suggest',
		components: {},
		data() {
			return {
				// 表单
				formInfo: {
					problem: null,
					files: null,
				},
				rules: {
					problem: {
					  type: 'string',
					  required: true,
					  message: '请输入问题',
					  trigger: ['blur', 'change'],
					}
				},
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
				fileUploadUrl: state => state.fileUploadUrl
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
					
					// 附件 校验
					if (this.fileList1.length === 0) return uni.showToast({
						title: '请上传附件!',
						icon: 'none',
						duration: 2000 //持续的时间
					})
					console.log('表单-校验通过-res',res);
					
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
					
					let files = null
					// 检查结果附件 files
					if (this.fileList1.length !== 0) {
						files = this.fileList1.map(i => {
							return {
								name: i.name || null,
								url: this.extractResourcePartRegex(i.url) || null
							}
						})
						console.log('附件-fileList1', this.fileList1)
						console.log('files', files)
					}
					
					const params = {
						...this.formInfo,
						files: files ? JSON.stringify(files) : null,
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
	.user {
		width: 100%;
		height: 100%;
		background: #F0F2F5;
		font-size: 28rpx;
		font-family: PingFangSC-Regular, PingFang SC;
		font-weight: 400;
		
		// 非列表设置
		&-con {
			width: 100%;
			padding: 30rpx;
			
			&-form {
				width: 100%;
				&-item {
					position: relative;
					background: #FFFFFF;
					border-radius: 10rpx;
					padding: 20rpx;
					margin: 0 0 30rpx 0;
					
					&-code {
						font-size: 30rpx;
						color: #1D84FA;
						line-height: 42rpx;
					}
				}
				
				&-item:first-child {
					border-bottom: 0;
				}
				
				/deep/.u-form-item__body {
					display: block;
					padding: 0;
				}
				
				/deep/.u-form-item__body__right {
					padding: 15rpx 0;
				}
				
				/deep/.u-border {
					border: 0 !important;
				}
				
				/deep/.u-textarea {
					padding: 0 !important;
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
				margin: 60rpx 0 0 0;
			}
		}
	}
</style>