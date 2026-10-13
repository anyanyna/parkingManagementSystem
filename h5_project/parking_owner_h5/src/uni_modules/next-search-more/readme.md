
## next-search-more --搜索更多，搜索下拉，search-more

> 遇到问题或有建议可以加入QQ群(<font color=#f00>455948571</font>)反馈  
> 如果觉得组件不错，<font color=#f00>给五星鼓励鼓励</font>咯！


## 使用

>[从uniapp插件市场导入](https://ext.dcloud.net.cn/plugin?name=next-search-more)

```html
<template>
	<view class="index">
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>1. mode=more模式</text></view>
		<next-search-more mode="more" :showMore="showMore" @moreClick="moreClick">
			<!--以下demo你可以借助第三方的插件实现你想要的任何复杂功能-->
			<template #more>
				<u--form labelWidth="80" labelAlign="right">
					<u-form-item label="radio:">
						<u-radio-group v-model="searchForm.radio" placement="row">
							<u-radio v-for="(item, index) in optionslist" :key="index" :label="item.name" :name="item.name" />
						</u-radio-group>
					</u-form-item>
					<u-form-item label="checkbox:">
						<u-checkbox-group v-model="searchForm.checkbox" placement="row">
							<u-checkbox v-for="(item, index) in optionslist" :key="index" :label="item.name" :name="item.name" />
						</u-checkbox-group>
					</u-form-item>
					<u-form-item label="rate:">
						<u-rate :count="5" v-model="searchForm.rate" />
					</u-form-item>
					<u-form-item label="switch:">
						<u-switch v-model="searchForm.switch"></u-switch>
					</u-form-item>
					<u-form-item label="other:">
						<next-search-select
							:multiple="false"
							:list="options"
							label-key="projectName"
							value-key="id"
							placeholder=" 请选择报备项目"
							title="选择报备项目"
							v-model:value="searchForm.projectId"
							@search="searchFunc"
							@change="changeCallback"
							clearable
						></next-search-select>
					</u-form-item>
					<view class="flex-row">
						<u-button @click="cancel" :customStyle="{margin: '10rpx'}" text="取消"></u-button>
						<u-button @click="comfirm" :customStyle="{margin: '10rpx'}" type="primary" text="确定"></u-button>
					</view>
				</u--form>
			</template>
		</next-search-more>
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>2. mode=common;button=outside模式</text></view>
		<next-search-more mode="common" button="outside" />
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>3. mode=common;button=inside模式</text></view>
		<next-search-more mode="common" button="inside" />
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>4. mode=center;button=outside模式</text></view>
		<next-search-more mode="center" button="outside" />
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>5. mode=center;button=inside模式</text></view>
		<next-search-more mode="center" button="inside" />
		<view style="padding: 10px 0;background-color:#000000;color: #fff;font-size: 13px;"><text>6. mode=center;button=inside;isFixedSearchBtn=false模式</text></view>
		<next-search-more mode="center" button="inside" :isFixedSearchBtn="false" />
		<view class="content-block"><text>全站ICON图标海量下载iconfont图标大全,为你优选-包图网,全站ICON图标海量下载iconfont图标大全,为你优选-包图网</text></view>
	</view>
</template>
```

### vue3 + ts 使用

```js
<script lang="ts">
import { ref, nextTick, toRefs, toRaw, unref, reactive } from 'vue'

export default {
	setup() {
		const showMore = ref(false)
		const searchForm = reactive({
			radio: '',
			checkbox: '',
			rate: 3,
			switch: false,
			projectId: ''
		})
		let dataLength = 0
		const options = ref<any>([])
		const optionslist = ref([{
            name: '苹果',
            disabled: false
          },
					{
						name: '香蕉',
					},
					{
						name: '橙子',
					}
				])
		function cancel () {
			showMore.value = false
		}
		function comfirm () {
			showMore.value = false
		}
		function moreClick () {
			showMore.value = !unref(showMore)
		}
		function searchFunc(val?) {
			console.log("搜索的关键字：", val)
			uni.showLoading({
				title: '请稍后...',
				icon: 'none'
			})
			// 模拟ajax请求
			setTimeout(() => {
				options.value = []
				dataLength = 0
				if (dataLength < 40) {
					for (let i = 0; i < 40; i++) {
						options.value.push({
							id: `id-${val ? val + '-' : ''}${dataLength + i}`,
							projectName: `项目item-${val ? val + '-' : ''}${dataLength + i}`,
							ohterKey: `test-${i}`
						})
					}
					dataLength = unref(options).length
				}
				uni.hideLoading()
			}, 1000)
		}
		function changeCallback(item) {
			console.log("选中的item：", item)
		}
		searchFunc()
		return {
			showMore,
			moreClick,
			optionslist,
			searchForm,
			searchFunc,
			options,
			changeCallback,
			comfirm,
			cancel
		}
	}
}
</script>
<style lang="scss">

	.flex-row {
		display: flex;
		justify-content: space-around;
	}
	.content-block {
		border-radius: 20rpx;
		border: 1rpx solid #ccc;
		margin: 20rpx;
		padding: 20rpx;
	}
</style>
<style lang="scss">
page {
  background: #ccc;
}
</style>


```
### vue2 同样支持，在这里不再写demo

### 组件按需加载
如果不需要组件全局加载，而已把组件拷贝到项目的components目录下，单独引入进来使用即可达到按需加载的效果
### 预览

***

|                 						功能预览               				   			 					|   |                 						项目中应用演示               				   			 			 |
| :--------------------------------------------------------------------------:|		| :-----------------------------------------------------------------------------:|
| ![](https://lixueshiaa.github.io/webtest/www/static/next-search-more.gif) 	|		| ![](https://lixueshiaa.github.io/webtest/www/static/next-search-more-demo.gif) |


## 参数


### next-search-more Props

可选参数属性列表

|参数名				|说明																																																						|类型														|是否必填	|默认值								|可选值			|
|----				|----																																																							|----														|----			|----									|----				|
|mode				|模式mode，支持common模式 center模式 more模式																																			|String													|否				|common								|center,more|
|button			|搜索按钮的模式，支持outside模式 inside模式				 																																	|String													|否				|outside							|inside			|
|isFixedSearchBtn			|是否固定搜索按钮																																												|Boolean												|否				|true									|false			|
|radius	|搜索控件的radius																																																			|String, Number									|否				|60										|-					|
|placeholder			|	placeholder																																																|String													|否				|请输入搜索内容				|-					|
|backgroundColor			|搜索控件的背景颜色																																											|String													|否				|#fff					 				|-					|
|showMore			|		mode=more模式下，用于控制打开下拉弹层																																					|Boolean												|否				|false				 				|true				|
|border|	border																																																							|String													|否				|1px #f5f5f5 solid		|-					|


# Event 事件
|事件名	|说明																	|类型	|回调参数	|
|----		|----																	|----	|----			|
|input |搜索框输入事件													|emit	|-				|
|search|搜索触发的事件													|emit	|-				|
|moreClick|更多按钮点击触发事件								|emit	|-				|

## Slot 插槽

|名称	|说明									|参数	|
|----	|----									|----	|
|more	|more插槽，在mode=more模式下用于存放下拉框内容	|无		|
