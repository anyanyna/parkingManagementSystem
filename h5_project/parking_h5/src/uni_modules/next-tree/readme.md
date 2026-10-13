
## next-tree --下拉树

> 遇到问题或有建议可以加入QQ群(<font color=#f00>455948571</font>)反馈  
> 如果觉得组件不错，<font color=#f00>给五星鼓励鼓励</font>咯！

## 亮点功能说明(打造你不得不用的好插件)

### 本插件自1.5.0版本后支持一下功能    

 >  1.大数据量渲染（本插件智能判断，如果子孙集数据量大于50时，会响应等待渲染视图；）  
 >  2.子节点按需渲染（自动启用，无需配置）  
 >  3.父子级联选择设置  
 >  4.单选多选设置  
 >  5.父节点是否可选设置  
 >  6.回显默认选中值  
 >  7.不可选项disabled设置  
 >  8.增强大数据量体验交互，增加筛选搜索模式  
 >  9.增强样式定制，提供自定义插槽，实现高要求样式定制  
 >  10.增加辅助线模式，外观更加精美  
 >  11.支持动态配置title  
 >  12.支持搜索模式searchModel=depHighlight模式，从属高亮显示模式  
 >  13.支持异步加载子节点，ajax加载子节点  
 >  14.增加可配置主题，自由定制插件主题颜色  
 >  15.支持动态校验，可以进行提示控制校验  
 >  16.支持页面模式/弹层模式，可以进行单页面展示或者弹层展示  
 >  17.支持半选提示状态显示  
 >  18.支持展开项expandedKeys配置  
 >  19.全面支持vue2/vue3  
 >  20.增加无子节点的父节点配置支持（当item[childrenKey]为null时，代表无子节点的父节点）  
 >  21.终极支持超数据量使用，增加展开模式配置单链路配置使用expandedMode=singe，使得ui组件使用进一步不在限制与数据量  
 >  22.功能模式再次增强，支持单选tree，多选tree，编辑tree，展示tree；

## 注意
	
### 作者不介意你对组件源码进行改造使用，为了开源更加高效，谢谢你的配合；为了节省不必要的沟通浪费，以下情况请不要再反馈给作者，请自行解决；
### 在这感各位的理解，我支持开源，但是作者时间有限；谢谢各位的配合；在这里期望我写的小小插件能为你提供便捷；
	
 >  1.如果你对源码进行了修改使用，请不需要对作者做任何的反馈，作者确实没有空陪你做技术分析解答；  
 >  2.如果你引入插件，连插件是否有正常被uniapp框架识别解析都不清楚，请你换个插件使用；  
 >  3.如果你引入插件，针对自己项目进行功能改造的，请自行仔细阅读源码并了解其原理，自行改造；这里作者不愿意浪费过多时间进行技术解答；  
 >  4.如果你不想进行全局加载next-tree，需要按需加载；next-tree中有相关依赖的组件，需要你自行在组件内部单独引入；依赖组件可以在package.json中找到；  
 >  5.理论上作者不再解决由于本地开发环境问题所导致的插件使用问题，请自行到uniapp官网学习解决；	 

## 使用
### 超集功能即将不对外开源；

>[从uniapp插件市场导入](https://ext.dcloud.net.cn/plugin?name=next-tree)

## 关注作者的动态
[点击进入主页，关注作者](https://ask.dcloud.net.cn/people/ponder_7464)

## 关注作者其他开源

npm开源包：[npm](https://www.npmjs.com/~lixueshiaa);
github开源项目：[github](https://github.com/lixueshiaa);


```html
<template>
	<view style="padding:10px;color: #333;font-weight: 500;">
		<view style="padding: 10px 0"><text>1、设置单选和父级不可选</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(false, false)">设置</button>
		<view style="padding: 10px 0"><text>2、设置多选和父级不可选</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, false)">设置</button>
		<view style="padding: 10px 0"><text>3、设置单选和父级可选</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(false, true)">设置</button>
		<view style="padding: 10px 0"><text>4、设置多选和父级可选</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, true)" >设置</button>
		<view style="padding: 10px 0"><text>4、设置多选和父级可选和父级关联子级选择</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, true, true)" >设置</button>
		<view style="padding: 10px 0"><text>5、设置默认回显(默认选中: '上海-2', '黄埔区-35')</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="echoDefault()" >设置</button>
		<!-- 异步加载demo -->
		<view style="padding: 10px 0"><text>6、异步加载渲染demo</text></view>
		<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="openTree()" >设置</button>
	</view>
	
	<!-- 异步加载demo -->
	<next-tree :selectParent="false" :checkStrictly="true" funcMode="checkbox" ref="nextTreeAsyncRef" :treeData="asyncTreeData" :loadData="loadData" />
	
	<next-tree :expandedKeys="['3','3-1']" :changeVerify="changeVerify" :title="getTitle" ref="nextTreeRef" :checkStrictly="checkStrictly" :selectParent="selectParent" :funcMode="funcMode" :treeData="treeData"  @cancel="oncancel" @confirm="onconfirm">
		<!-- label插槽示意代码 -->
		<!-- <template #label="{data: {id, label, iconSrc, prev, post}}">
			<view class="line-block">
				<image class="img" v-if="iconSrc" :src="iconSrc"></image>
				<text space="nbsp" v-if="prev">{{prev}}&nbsp;</text><text>{{label}}</text><text space="nbsp" v-if="post">&nbsp;{{post}}</text>
			</view>
		</template> -->
		<!-- <template #topBar>
			<view style="color: #666;padding:5px;"><text style="font-size: 12px;">历史记录</text></view>
			<view style="display: flex;justify-content: space-between;padding-bottom: 10px;border-bottom: 1rpx solid #f0f0f0;">
				<button @click="checkedFunc('1-3-3-4')"  :style="'background-color:'+ (activeId === '1-3-3-4' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">北京区-4</button>
				<button @click="checkedFunc('3-1-2')"  :style="'background-color:'+ (activeId === '3-1-2' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">海珠区-2</button>
				<button @click="checkedFunc('3-1-6')"  :style="'background-color:'+ (activeId === '3-1-6' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">海珠区-5</button>
			</view>
		</template> -->
	</next-tree>
</template>
```

### vue3 + ts 使用

```ts
<script setup lang="ts">
import { ref, unref } from 'vue'
import nextTree from '@/components/next-tree/next-tree.vue'

const funcMode = ref('radio');
const selectParent = ref(false)
const nextTreeRef = ref()
const nextTreeAsyncRef = ref()
const activeId = ref('')

const localData: any = {
	'a1': [{id: 'a1-1', label: 'a1-1'}, {id: 'a1-2', label: 'a1-2',children: [] },{id: 'a1-3', label: 'a1-3'}],
	'b1': [{id: 'b1-1', label: 'b1-1',children: []}, {id: 'b1-2', label: 'b1-2'},{id: 'b1-3', label: 'b1-3'}],
	'c1': [{id: 'c1-1', label: 'c1-1'}, {id: 'c1-2', label: 'c1-2'},{id: 'c1-3', label: 'c1-3',children: []}],
	'a1-2': [{id: 'a1-2-1', label: 'a1-2-1'}, {id: 'a1-2-2', label: 'a1-2-2'}],
	'b1-1': [{id: 'b1-1-1', label: 'b1-1-1'}, {id: 'b1-1-2', label: 'b1-1-2'}],
	'c1-3': [{id: 'c1-3-1', label: 'c1-3-1'}, {id: 'c1-3-2', label: 'c1-3-2'}]
}

const checkStrictly = ref(false)
const asyncTreeData = ref([{id: 'a1', label: 'a1', children: []},{id: 'b1', label: 'b1', children: []},{id: 'c1', label: 'c1', children: []}])
const treeData = ref([
	{id: '1', label: '北京'},
	{id: '2', label: '上海', children: [
		{id: '2-1', label: '上海-1'},
		{id: '2-2', label: '上海-2'},
		{id: '2-3', label: '上海-3'},
	] },
	{id: '3', label: '广州', children: [
			{id: '3-1', label: '海珠区', children: [
				{id: '3-1-1', label: '海珠区-1'},
				{id: '3-1-2', label: '海珠区-2'},
				{id: '3-1-4', label: '海珠区-3'},
				{id: '3-1-5', label: '海珠区-4'},
				{id: '3-1-6', label: '海珠区-5'},
				{id: '3-1-7', label: '海珠区-6'},
				{id: '3-1-8', label: '海珠区-7'},
				{id: '3-1-9', label: '海珠区-8'},
				{id: '3-1-10', label: '海珠区-9'},
				{id: '3-1-11', label: '海珠区-10'},
			]},
			{id: '3-2', label: '番禺区', children: [
				{id: '3-2-1', label: '番禺区-1'},
				{id: '3-2-2', label: '番禺区-2'},
				{id: '3-2-4', label: '番禺区-3', children: null},	// 注意： 当childrenKey的值设为null，代表无子节点的父节点
				{id: '3-2-5', label: '番禺区-4'},
				{id: '3-2-6', label: '番禺区-5'},
				{id: '3-2-7', label: '番禺区-6'},
				{id: '3-2-8', label: '番禺区-7'},
				{id: '3-2-9', label: '番禺区-8'},
				{id: '3-2-10', label: '番禺区-9'},
				{id: '3-2-11', label: '番禺区-10'},
			]},
			{id: '3-3', label: '黄埔区', children: [
				{id: '3-3-1', label: '黄埔区-1'},
				{id: '3-3-2', label: '黄埔区-2'},
				{id: '3-3-3', label: '黄埔区-3'},
				{id: '3-3-4', label: '黄埔区-4'},
				{id: '3-3-5', label: '黄埔区-5'},
				{id: '3-3-6', label: '黄埔区-6'},
				{id: '3-3-7', label: '黄埔区-7'},
				{id: '3-3-8', label: '黄埔区-8'},
				{id: '3-3-9', label: '黄埔区-9'},
				{id: '3-3-10', label: '黄埔区-10'},
				{id: '3-3-12', label: '黄埔区-11'},
				{id: '3-3-13', label: '黄埔区-12'},
				{id: '3-3-13', label: '黄埔区-13'},
				{id: '3-3-14', label: '黄埔区-14'},
				{id: '3-3-15', label: '黄埔区-15'},
				{id: '3-3-16', label: '黄埔区-16'},
				{id: '3-3-17', label: '黄埔区-17'},
				{id: '3-3-18', label: '黄埔区-18'},
				{id: '3-3-19', label: '黄埔区-19'},
				{id: '3-3-20', label: '黄埔区-20'},
				{id: '3-3-21', label: '黄埔区-21'},
				{id: '3-3-22', label: '黄埔区-22'},
				{id: '3-3-23', label: '黄埔区-23'},
				{id: '3-3-24', label: '黄埔区-24'},
				{id: '3-3-25', label: '黄埔区-25'},
				{id: '3-3-26', label: '黄埔区-26'},
				{id: '3-3-27', label: '黄埔区-27'},
				{id: '3-3-28', label: '黄埔区-28'},
				{id: '3-3-29', label: '黄埔区-29'},
				{id: '3-3-30', label: '黄埔区-30'},
				{id: '3-3-31', label: '黄埔区-31'},
				{id: '3-3-32', label: '黄埔区-32'},
				{id: '3-3-33', label: '黄埔区-33'},
				{id: '3-3-34', label: '黄埔区-34'},
				{id: '3-3-35', label: '黄埔区-35'},
				{id: '3-3-36', label: '黄埔区-36'},
				
			]},
		],
	}])
function getTitle(checked) {
	return `已选：${checked.length}项`
}
function itemclick (_multiple, _selectParent, _checkStrictly = false) {
	funcMode.value = _multiple ? 'checkbox' : 'radio';
	selectParent.value = _selectParent
	checkStrictly.value = _checkStrictly
	unref(nextTreeRef).showTree = true
}
function checkedFunc(id) {
	if(unref(activeId) === id) {
		activeId.value = '';
		unref(nextTreeRef).checkedFunc(id, false)
	} else {
		activeId.value = id;
		unref(nextTreeRef).checkedFunc(id)	
	}
}
function changeVerify(current, chooseList) {
	// 注意：返回非空字符串会阻止原有行为，并提示返回的字符串
	// 如果函数体不做return返回值，即验证通过，控件正常处理业务
	console.log('当前变化的数据', current)
	console.log('已选择的数据', chooseList)
	if(chooseList && chooseList.length > 4) {
		
		return '最多可以选择4个节点'
	}
}
function openTree() {
	unref(nextTreeAsyncRef).showTree = true
}
function echoDefault () {
	const selectIds = ['2-1','3-3-35']
	checkedTreeData(unref(treeData), selectIds)
	console.log('treeData的数据：', unref(treeData))
	funcMode.value = 'checkbox'
	unref(nextTreeRef).showTree = true
}
function loadData(data) {
	const type = data.$type;	// 加载类型
	const source = data.source // 源数据
	// 同步实现的代码处理方式
	
	if (type === 'nodeLoad') {
		const  nodeItem = source;
		// 同步实现的代码处理方式
		// 如果期望子集节点中还存在孙子节点可以打开，请在初始化数据的时候，初始化个空数组的子节点配置值{[this.childrenKey]: []}
		
		// if(nodeItem && localData[nodeItem.id]) {
		// 	return localData[nodeItem.id]
		// } else {
		// 	return []
		// }
		
		// 异步的代码实现方式
		// 如果期望子集节点中还存在孙子节点可以打开，请在初始化数据的时候，初始化个空数组的子节点配置值{[this.childrenKey]: []}
		
		return new Promise((resolve, reject) => {
			setTimeout(() => {
				if(nodeItem && localData[nodeItem.id]) {
					return resolve(localData[nodeItem.id])
				} else {
					return resolve([])
				}
			}, 1000)
		})
	} else if(type === 'remoteSearch') {
		// ...doing
	}
	
}

function checkedTreeData (treeData, selectIds) {
	treeData.map(item => {
		if (selectIds.indexOf(item.id) !== -1) {
			item.checked = true
		} else {
			item.checked = false
		}
		if (item.children && item.children.length) {
			checkedTreeData(item.children, selectIds)
		}
	})
}
function oncancel() {
	// 清除treeData的选中状态
	checkedTreeData(unref(treeData), [])
}
function onconfirm(list) {
	console.log('选中项的数量列表list：', list)
}
</script>
<style lang="scss">
	.line-block {
		display: flex;
		flex-direction: row;
		justify-content: flex-start;
		align-items: center;
		.img {
			width: 40rpx;
			height: 40rpx;
			border-radius: 10rpx;
			margin: 0 20rpx;
		}
	}
</style>

```

### vue2 使用
```html
<template>
	<view>
		<view style="padding:10px;color: #333;font-weight: 500;">
			<view style="padding: 10px 0"><text>1、设置单选和父级不可选</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(false, false)">设置</button>
			<view style="padding: 10px 0"><text>2、设置多选和父级不可选</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, false)">设置</button>
			<view style="padding: 10px 0"><text>3、设置单选和父级可选</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(false, true)">设置</button>
			<view style="padding: 10px 0"><text>4、设置多选和父级可选</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, true)" >设置</button>
			<view style="padding: 10px 0"><text>4、设置多选和父级可选和父级关联子级选择</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="itemclick(true, true, true)" >设置</button>
			<view style="padding: 10px 0"><text>5、设置默认回显(默认选中: '上海-2', '黄埔区-35')</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="echoDefault()" >设置</button>
			<!-- 异步加载demo -->
			<view style="padding: 10px 0"><text>6、异步加载渲染demo</text></view>
			<button style="width: 100%;background-color: #f9ae3d;color:#fff" size="mini" @click="openTree()" >设置</button>
		</view>
		<!-- 异步加载demo -->
		<next-tree :selectParent="false" :checkStrictly="true" funcMode="checkbox" ref="nextTreeAsyncRef" :treeData="asyncTreeData" :loadData="loadData" />
		
		<next-tree :expandedKeys="['3','3-1']" :changeVerify="changeVerify" :title="getTitle" ref="nextTreeRef" :checkStrictly="checkStrictly" :selectParent="selectParent" :funcMode="funcMode" :treeData="treeData" @cancel="oncancel" @confirm="onconfirm">
			<!-- label插槽示意代码 -->
			<!-- <template v-slot:label="{data}">
				<view class="line-block">
					<image class="img" v-if="data.iconSrc" :src="data.iconSrc"></image>
					<text space="nbsp" v-if="data.prev">{{data.prev}}&nbsp;</text><text>{{data.label}}</text><text space="nbsp" v-if="data.post">&nbsp;{{data.post}}</text>
				</view>
			</template> -->
			<!-- <template #topBar>
				<view style="color: #666;padding:5px;"><text style="font-size: 12px;">历史记录</text></view>
				<view style="display: flex;justify-content: space-between;padding-bottom: 10px;border-bottom: 1rpx solid #f0f0f0;">
					<button @click="checkedFunc('1-3-3-4')"  :style="'background-color:'+ (activeId === '1-3-3-4' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">北京区-4</button>
					<button @click="checkedFunc('3-1-2')"  :style="'background-color:'+ (activeId === '3-1-2' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">海珠区-2</button>
					<button @click="checkedFunc('3-1-6')"  :style="'background-color:'+ (activeId === '3-1-6' ? '#f9ae3d' : '#ccc') + ';color:#fff;margin: 5px'" size="mini">海珠区-5</button>
				</view>
			</template> -->
		</next-tree>
	</view>
</template>
```

```js
<script>
let self = null;
export default {
	data () {
		return {
			funcMode: 'radio',
			selectParent: false,
			checkStrictly: false,
			activeId: '',
			localData:{
				'a1': [{id: 'a1-1', label: 'a1-1'}, {id: 'a1-2', label: 'a1-2',children: [] },{id: 'a1-3', label: 'a1-3'}],
				'b1': [{id: 'b1-1', label: 'b1-1',children: []}, {id: 'b1-2', label: 'b1-2'},{id: 'b1-3', label: 'b1-3'}],
				'c1': [{id: 'c1-1', label: 'c1-1'}, {id: 'c1-2', label: 'c1-2'},{id: 'c1-3', label: 'c1-3',children: []}],
				'a1-2': [{id: 'a1-2-1', label: 'a1-2-1'}, {id: 'a1-2-2', label: 'a1-2-2'}],
				'b1-1': [{id: 'b1-1-1', label: 'b1-1-1'}, {id: 'b1-1-2', label: 'b1-1-2'}],
				'c1-3': [{id: 'c1-3-1', label: 'c1-3-1'}, {id: 'c1-3-2', label: 'c1-3-2'}]
			},
			asyncTreeData: [{id: 'a1', label: 'a1', children: []},{id: 'b1', label: 'b1', children: []},{id: 'c1', label: 'c1', children: []}],		
			treeData: [
				{id: '1', label: '北京', checked: false},
				{id: '2', label: '上海', checked: false, children: [
					{id: '2-1', label: '上海-1', checked: false},
					{id: '2-2', label: '上海-2', checked: false},
					{id: '2-3', label: '上海-3', checked: false},
				] },
				{id: '3', label: '广州', children: [
						{id: '3-1', label: '海珠区', checked: false, children: [
							{id: '3-1-1', label: '海珠区-1', checked: false, disabled: true},
							{id: '3-1-2', label: '海珠区-2', checked: false},
							{id: '3-1-4', label: '海珠区-3', checked: false},
							{id: '3-1-5', label: '海珠区-4', checked: false},
							{id: '3-1-6', label: '海珠区-5', checked: false},
							{id: '3-1-7', label: '海珠区-6', checked: false},
							{id: '3-1-8', label: '海珠区-7', checked: false},
							{id: '3-1-9', label: '海珠区-8', checked: false},
							{id: '3-1-10', label: '海珠区-9', checked: false},
							{id: '3-1-11', label: '海珠区-10', checked: false},
						]},
						{id: '3-2', label: '番禺区', checked: false, children: [
							{id: '3-2-1', label: '番禺区-1', checked: false},
							{id: '3-2-2', label: '番禺区-2', checked: false},
							{id: '3-2-4', label: '番禺区-3', checked: false},
							{id: '3-2-5', label: '番禺区-4', checked: false},
							{id: '3-2-6', label: '番禺区-5', checked: false},
							{id: '3-2-7', label: '番禺区-6', checked: false},
							{id: '3-2-8', label: '番禺区-7', checked: false},
							{id: '3-2-9', label: '番禺区-8', checked: false},
							{id: '3-2-10', label: '番禺区-9', checked: false},
							{id: '3-2-11', label: '番禺区-10', checked: false},
						]},
						{id: '3-3', label: '黄埔区', checked: false, children: [
							{id: '3-3-1', label: '黄埔区-1', checked: false},
							{id: '3-3-2', label: '黄埔区-2', checked: false},
							{id: '3-3-3', label: '黄埔区-3', checked: false},
							{id: '3-3-4', label: '黄埔区-4', checked: false},
							{id: '3-3-5', label: '黄埔区-5', checked: false},
							{id: '3-3-6', label: '黄埔区-6', checked: false},
							{id: '3-3-7', label: '黄埔区-7', checked: false},
							{id: '3-3-8', label: '黄埔区-8', checked: false},
							{id: '3-3-9', label: '黄埔区-9', checked: false},
							{id: '3-3-10', label: '黄埔区-10', checked: false},
							{id: '3-3-12', label: '黄埔区-11', checked: false},
							{id: '3-3-13', label: '黄埔区-12', checked: false},
							{id: '3-3-13', label: '黄埔区-13', checked: false},
							{id: '3-3-14', label: '黄埔区-14', checked: false},
							{id: '3-3-15', label: '黄埔区-15', checked: false},
							{id: '3-3-16', label: '黄埔区-16', checked: false},
							{id: '3-3-17', label: '黄埔区-17', checked: false},
							{id: '3-3-18', label: '黄埔区-18', checked: false},
							{id: '3-3-19', label: '黄埔区-19', checked: false},
							{id: '3-3-20', label: '黄埔区-20', checked: false},
							{id: '3-3-21', label: '黄埔区-21', checked: false},
							{id: '3-3-22', label: '黄埔区-22', checked: false},
							{id: '3-3-23', label: '黄埔区-23', checked: false},
							{id: '3-3-24', label: '黄埔区-24', checked: false},
							{id: '3-3-25', label: '黄埔区-25', checked: false},
							{id: '3-3-26', label: '黄埔区-26', checked: false},
							{id: '3-3-27', label: '黄埔区-27', checked: false},
							{id: '3-3-28', label: '黄埔区-28', checked: false},
							{id: '3-3-29', label: '黄埔区-29', checked: false},
							{id: '3-3-30', label: '黄埔区-30', checked: false},
							{id: '3-3-31', label: '黄埔区-31', checked: false},
							{id: '3-3-32', label: '黄埔区-32', checked: false},
							{id: '3-3-33', label: '黄埔区-33', checked: false},
							{id: '3-3-34', label: '黄埔区-34', checked: false},
							{id: '3-3-35', label: '黄埔区-35', checked: false},
							{id: '3-3-36', label: '黄埔区-36', checked: false},					
						]},
					],
				}]
		}
	},
	methods: {
		openTree: function() {
			this.$refs.nextTreeAsyncRef.showTree = true
		},
		changeVerify: function(current, chooseList) {
			// 注意：返回非空字符串会阻止原有行为，并提示返回的字符串
			// 如果函数体不做return返回值，即验证通过，控件正常处理业务
			console.log('当前变化的数据', current)
			console.log('已选择的数据', chooseList)
			if(chooseList && chooseList.length > 4) {
				
				return '最多可以选择4个节点'
			}
		},
		checkedFunc: function(id) {
			if(this.activeId === id) {
				this.activeId = '';
				this.$refs.nextTreeRef.checkedFunc(id, false)
			} else {
				this.activeId = id;
				this.$refs.nextTreeRef.checkedFunc(id)	
			}
		},
		function loadData(data) {
			const type = data.$type;	// 加载类型
			const source = data.source // 源数据
			// 同步实现的代码处理方式
			
			if (type === 'nodeLoad') {
				const  nodeItem = source;
				// 同步实现的代码处理方式 可以返回单个子节点的集合也可以返回子孙节点的集合
				// 如果期望子集节点中还存在孙子节点可以打开，请在初始化数据的时候，初始化个空数组的子节点配置值{[this.childrenKey]: []}
				
				// if(nodeItem && this.localData[nodeItem.id]) {
				// 	return this.localData[nodeItem.id]
				// } else {
				// 	return []
				// }
				// 异步的代码实现方式 可以返回单个子节点的集合也可以返回子孙节点的集合
				// 如果期望子集节点中还存在孙子节点可以打开，请在初始化数据的时候，初始化个空数组的子节点配置值{[this.childrenKey]: []}
				return new Promise((resolve, reject) => {
					setTimeout(() => {
						if(nodeItem && self.localData[nodeItem.id]) {
							return resolve(self.localData[nodeItem.id])
						} else {
							return resolve([])
						}
					}, 1000)
				})	
			} else if(type === 'remoteSearch') {
				// ...doing
			}
			
		},
		
		getTitle: function(checked) {
			return `已选：${checked.length}项`
		},
		echoDefault: function() {
			const selectIds = ['2-1','3-3-35']
			this.checkedTreeData(this.treeData, selectIds)
			console.log('treeData的数据：', this.treeData)
			this.funcMode = 'checkbox'
			this.$refs.nextTreeRef.showTree = true
		},
		itemclick: function(_multiple, _selectParent, _checkStrictly = false) {
			this.funcMode = _multiple ? 'checkbox' : 'radio'
			this.selectParent = _selectParent
			this.checkStrictly = _checkStrictly
			this.$refs.nextTreeRef.showTree = true
		},
		checkedTreeData: function(treeData, selectIds) {
			// 注意 vue2当数据深嵌套时，如果没有在treeData里面初始化checked属性，那在改变数据的时候直接将checked属性赋值为true，这时候ui界面有可能不会更新，
			// 这时候建议使用this.$set去更新checked属性值，或者在初始化this.treeData的时候初始化checked属性
			(treeData || []).map(item => {
				if (selectIds.indexOf(item.id) !== -1) {
					item.checked = true
				} else {
					item.checked = false
				}
				if (item.children && item.children.length) {
					this.checkedTreeData(item.children, selectIds)
				}
			})
		},
		onconfirm: function(list) {
			console.log('选中项的数量列表list：', list)
		},
		oncancel: function() {
			// 清除treeData的选中状态
			this.checkedTreeData(this.treeData, [])
		}
	},
	created() {
		self = this
	}
}
</script>
<style lang="scss">
	.line-block {
		display: flex;
		flex-direction: row;
		justify-content: flex-start;
		align-items: center;
		.img {
			width: 40rpx;
			height: 40rpx;
			border-radius: 10rpx;
			margin: 0 20rpx;
		}
	}
</style>

```

### 个性化自定义样式渲染

如果你的需求对样式需求比较高，请使用插槽模式渲染，本组件提供label插槽供你自定义定制；

```js
<script>
// 提供参考一组自定义渲染数据demo，treeData如下；
const treeData = [
	{id: '1', label: '北京', prev: 'PonderNext-', iconSrc: 'https://img95.699pic.com/xsj/03/fg/hj.jpg%21/fh/300', children: [
		{id: '1-3-3-1', label: '北京区-1', prev: '前置-'},
		{id: '1-3-3-2', label: '北京区-2', post: '-后置'},
		{id: '1-3-3-3', label: '北京区-3', post: '-后置', prev: '前置-'},
		{id: '1-3-3-4', label: '北京区-4'},
		{id: '1-3-3-5', label: '北京区-5'},
		{id: '1-3-3-6', label: '北京区-6'},
		{id: '1-3-3-7', label: '北京区-7'},
		{id: '1-3-3-8', label: '北京区-8'},
		{id: '1-3-3-9', label: '北京区-9'},
		{id: '1-3-3-10', label: '北京区-10'},
		{id: '1-3-3-12', label: '北京区-11'},
		{id: '1-3-3-13', label: '北京区-12'},
		{id: '1-3-3-13', label: '北京区-13'},
		{id: '1-3-3-14', label: '北京区-14'},
		{id: '1-3-3-15', label: '北京区-15'},
		{id: '1-3-3-16', label: '北京区-16'},
		{id: '1-3-3-17', label: '北京区-17'},
		{id: '1-3-3-18', label: '北京区-18'},
		{id: '1-3-3-19', label: '北京区-19'},
		{id: '1-3-3-20', label: '北京区-20'},
		{id: '1-3-3-21', label: '北京区-21'},
		{id: '1-3-3-22', label: '北京区-22'},
		{id: '1-3-3-23', label: '北京区-23'},
		{id: '1-3-3-24', label: '北京区-24'},
		{id: '1-3-3-25', label: '北京区-25'},
		{id: '1-3-3-26', label: '北京区-26'},
		{id: '1-3-3-27', label: '北京区-27'},
		{id: '1-3-3-28', label: '北京区-28'},
		{id: '1-3-3-29', label: '北京区-29'},
		{id: '1-1-3-3-30', label: '北京区-30'},
		{id: '1-3-3-31', label: '北京区-31'},
		{id: '1-3-3-32', label: '北京区-32'},
		{id: '1-3-3-33', label: '北京区-33'},
		{id: '1-3-3-34', label: '北京区-34'},
		{id: '1-3-3-35', label: '北京区-35'},
		{id: '1-3-3-36', label: '北京区-36'},
		{id: '1-3-3-37', label: '北京区-37'},
		{id: '1-3-3-38', label: '北京区-38'},
		{id: '1-3-3-39', label: '北京区-39'},
		{id: '1-3-3-40', label: '北京区-40'},
		{id: '1-3-3-41', label: '北京区-41'},
		{id: '1-3-3-42', label: '北京区-42'},
		{id: '1-3-3-43', label: '北京区-43'},
		{id: '1-3-3-44', label: '北京区-44'},
		{id: '1-3-3-45', label: '北京区-45'},
		{id: '1-3-3-46', label: '北京区-46'},
		{id: '1-3-3-47', label: '北京区-47'},
		{id: '1-3-3-48', label: '北京区-48'},
		{id: '1-3-3-49', label: '北京区-49'},
		{id: '1-3-3-50', label: '北京区-50'},
		{id: '1-3-3-51', label: '北京区-51'},
		{id: '1-3-3-52', label: '北京区-52'},
		{id: '1-3-3-53', label: '北京区-53'},
		{id: '1-3-3-54', label: '北京区-54'},
	]},
	{id: '2', label: '上海', prev: 'PonderNext-',  iconSrc: 'https://img95.699pic.com/xsj/0g/hb/tc.jpg%21/fh/300', children: [
		{id: '2-1', label: '上海-1', iconSrc: 'https://img1.baidu.com/it/u=1997340124,765201109&fm=253&fmt=auto&app=120&f=JPEG?w=285&h=285'},
		{id: '2-2', label: '上海-2', iconSrc: 'https://img1.baidu.com/it/u=1997340124,765201109&fm=253&fmt=auto&app=120&f=JPEG?w=285&h=285'},
		{id: '2-3', label: '上海-3', iconSrc: 'https://img1.baidu.com/it/u=1997340124,765201109&fm=253&fmt=auto&app=120&f=JPEG?w=285&h=285'},
	] },
	{id: '3', label: '广州', prev: 'PonderNext-', iconSrc: 'https://storage-public.zhaopin.cn/user/avatar/1589350028141684980/d00a1afa-e3ec-40a5-a68e-aef1f684b189.jpg', children: [
			{id: '3-1', label: '海珠区', iconSrc: 'https://img95.699pic.com/xsj/0u/f3/5h.jpg%21/fh/300', children: [
				{id: '3-1-1', label: '海珠区-1', disabled: true},
				{id: '3-1-2', label: '海珠区-2', post: '-后置', prev: '前置-'},
				{id: '3-1-4', label: '海珠区-3', post: '-后置',},
				{id: '3-1-5', label: '海珠区-4', children: [
						{ id: '3-1-5-1', label: '海珠区-4-200号'},
						{ id: '3-1-5-2', label: '海珠区-4-201号', children: [
							{ id: '3-1-5-1-1', label: '海珠区-4-200号-2'},
							{ id: '3-1-5-2-1', label: '海珠区-4-201号-3'},
						]},
				]},
				{id: '3-1-6', label: '海珠区-5'},
				{id: '3-1-7', label: '海珠区-6'},
				{id: '3-1-8', label: '海珠区-7', post: '-后置',},
				{id: '3-1-9', label: '海珠区-8'},
				{id: '3-1-10', label: '海珠区-9'},
				{id: '3-1-11', label: '海珠区-10'},
				{id: '3-1-1', label: '海珠区-11', disabled: true},
				{id: '3-1-2', label: '海珠区-12'},
				{id: '3-1-4', label: '海珠区-13'},
				{id: '3-1-5', label: '海珠区-14'},
				{id: '3-1-6', label: '海珠区-15'},
				{id: '3-1-7', label: '海珠区-16'},
				{id: '3-1-8', label: '海珠区-17'},
				{id: '3-1-9', label: '海珠区-18'},
				{id: '3-1-10', label: '海珠区-19', prev: '前置-'},
				{id: '3-1-11', label: '海珠区-20'},
				{id: '3-1-1', label: '海珠区-21', disabled: true},
				{id: '3-1-2', label: '海珠区-22'},
				{id: '3-1-4', label: '海珠区-23'},
				{id: '3-1-5', label: '海珠区-24'},
				{id: '3-1-6', label: '海珠区-25'},
				{id: '3-1-7', label: '海珠区-26'},
				{id: '3-1-8', label: '海珠区-27'},
				{id: '3-1-9', label: '海珠区-28'},
				{id: '3-1-10', label: '海珠区-29'},
				{id: '3-1-11', label: '海珠区-30'},
				{id: '3-1-1', label: '海珠区-31', disabled: true},
				{id: '3-1-2', label: '海珠区-32'},
				{id: '3-1-4', label: '海珠区-33'},
				{id: '3-1-5', label: '海珠区-34'},
				{id: '3-1-6', label: '海珠区-35'},
				{id: '3-1-7', label: '海珠区-36'},
				{id: '3-1-8', label: '海珠区-37'},
				{id: '3-1-9', label: '海珠区-38'},
				{id: '3-1-10', label: '海珠区-39'},
				{id: '3-1-11', label: '海珠区-40'},
				{id: '3-1-1', label: '海珠区-41', disabled: true},
				{id: '3-1-2', label: '海珠区-42'},
				{id: '3-1-4', label: '海珠区-43'},
				{id: '3-1-5', label: '海珠区-44'},
				{id: '3-1-6', label: '海珠区-45'},
				{id: '3-1-7', label: '海珠区-46'},
				{id: '3-1-8', label: '海珠区-47'},
				{id: '3-1-9', label: '海珠区-48'},
				{id: '3-1-10', label: '海珠区-49'},
				{id: '3-1-11', label: '海珠区-50'},
				{id: '3-1-11', label: '海珠区-51'},
			]},
			{id: '3-2', label: '番禺区', iconSrc: 'https://img1.baidu.com/it/u=931648192,3196263841&fm=253&fmt=auto&app=120&f=JPEG?w=285&h=285', disabled: true, checked: true, children: [
				{id: '3-2-1', label: '番禺区-1'},
				{id: '3-2-2', label: '番禺区-2'},
				{id: '3-2-4', label: '番禺区-3'},
				{id: '3-2-5', label: '番禺区-4'},
				{id: '3-2-6', label: '番禺区-5'},
				{id: '3-2-7', label: '番禺区-6'},
				{id: '3-2-8', label: '番禺区-7'},
				{id: '3-2-9', label: '番禺区-8'},
				{id: '3-2-10', label: '番禺区-9'},
				{id: '3-2-11', label: '番禺区-10'},
			]},
			{id: '3-3', label: '黄埔区', iconSrc: 'https://img.jiaoyubao.cn/43423/20210423113959473-20210423114005024.jpeg', children: [
				{id: '3-3-1', label: '黄埔区-1'},
				{id: '3-3-2', label: '黄埔区-2'},
				{id: '3-3-3', label: '黄埔区-3'},
				{id: '3-3-4', label: '黄埔区-4'},
				{id: '3-3-5', label: '黄埔区-5'},
				{id: '3-3-6', label: '黄埔区-6'},
				{id: '3-3-7', label: '黄埔区-7'},
				{id: '3-3-8', label: '黄埔区-8'},
				{id: '3-3-9', label: '黄埔区-9'},
				{id: '3-3-10', label: '黄埔区-10'},
				{id: '3-3-12', label: '黄埔区-11'},
				{id: '3-3-13', label: '黄埔区-12'},
				{id: '3-3-13', label: '黄埔区-13'},
				{id: '3-3-14', label: '黄埔区-14'},
				{id: '3-3-15', label: '黄埔区-15'},
				{id: '3-3-16', label: '黄埔区-16'},
				{id: '3-3-17', label: '黄埔区-17'},
				{id: '3-3-18', label: '黄埔区-18'},
				{id: '3-3-19', label: '黄埔区-19'},
				{id: '3-3-20', label: '黄埔区-20'},
				{id: '3-3-21', label: '黄埔区-21'},
				{id: '3-3-22', label: '黄埔区-22'},
				{id: '3-3-23', label: '黄埔区-23'},
				{id: '3-3-24', label: '黄埔区-24'},
				{id: '3-3-25', label: '黄埔区-25'},
				{id: '3-3-26', label: '黄埔区-26'},
				{id: '3-3-27', label: '黄埔区-27'},
				{id: '3-3-28', label: '黄埔区-28'},
				{id: '3-3-29', label: '黄埔区-29'},
				{id: '3-3-30', label: '黄埔区-30'},
				{id: '3-3-31', label: '黄埔区-31'},
				{id: '3-3-32', label: '黄埔区-32'},
				{id: '3-3-33', label: '黄埔区-33'},
				{id: '3-3-34', label: '黄埔区-34'},
				{id: '3-3-35', label: '黄埔区-35'},
				{id: '3-3-36', label: '黄埔区-36'},
				{id: '3-3-37', label: '黄埔区-37'},
				{id: '3-3-38', label: '黄埔区-38'},
				{id: '3-3-39', label: '黄埔区-39'},
				{id: '3-3-40', label: '黄埔区-40'},
				{id: '3-3-41', label: '黄埔区-41'},
				{id: '3-3-42', label: '黄埔区-42'},
				{id: '3-3-43', label: '黄埔区-43'},
				{id: '3-3-44', label: '黄埔区-44'},
				{id: '3-3-45', label: '黄埔区-45'},
				{id: '3-3-46', label: '黄埔区-46'},
				{id: '3-3-47', label: '黄埔区-47'},
				{id: '3-3-48', label: '黄埔区-48'},
				{id: '3-3-49', label: '黄埔区-49'},
				{id: '3-3-50', label: '黄埔区-50'},
				{id: '3-3-51', label: '黄埔区-51'},
				{id: '3-3-52', label: '黄埔区-52'},
				{id: '3-3-53', label: '黄埔区-53'},
				{id: '3-3-54', label: '黄埔区-54'},		
			]},
		],
	}]
</script>
```

### 预览
### 
***

|                 						功能预览               				   			   |   	                       父子级关联演示               				   			|   	      全面支持大数据量，子孙节点ui按需渲染(按需渲染数据)    	   			  |
| :------------------------------------------------------------------: | :------------------------------------------------------------------:  |  :------------------------------------------------------------------: |
| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree.gif)   | ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-b.gif)  |  ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-d.gif) |



|          增强控件交互能力，增加筛选search模式，全面支持大数据量交互    	   |          超强的样式定制能力，满足你高精美组件的需求                   	    |          打开精美的辅助线模式，让你的控件更加友好                   	      |
| :------------------------------------------------------------------: |  :------------------------------------------------------------------: | :------------------------------------------------------------------:  |
| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-e.gif) |  ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-f.gif) |  ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-u.gif) |


|          增加搜索模式searchModel=depHighlight模式，从属高亮显示模式    	 |          支持异步加载子节点，子树集，ajax远程加载数据等    	              |          支持不同主题的切换，ui定制更简单    	                            |
| :------------------------------------------------------------------: |  :------------------------------------------------------------------: | :------------------------------------------------------------------:  |
| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-p.gif) | ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-k.gif)  | ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-n.gif)  |

|          增加验证函数和topBar插槽使得更加容易和组件进行交互    	         |          增加页面模式，支持整页ui展示模式    	                          |  增加展开模式expandedMode配置，支持单链路展开，理论上支持几万数据量  	     |
| :------------------------------------------------------------------: | :------------------------------------------------------------------: | :------------------------------------------------------------------:   |
| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-cc.gif)| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-uu.gif)| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-aab.gif) |



### 超集功能预览(增值功能)
### 
|          实现tree的功能模式扩展，让你的tree组件实现可编辑态     	         |
| :--------------------------------------------------------------------: |
| ![](https://lixueshiaa.github.io/webtest/www/static/next-tree-eeee.gif)|

## 参数
可选参数属性列表

|参数名				|说明																																																						                                                       |类型		            |是否必填	|默认值		|可选值	                      |
|----				|----																																																							                                                       |----		          |----			|----			|-----------------------      |
|uiMode			  |ui表现方式；popup<弹窗>， page<页面>；默认是	popup																																					                                             |String	          |是				|popup		|page			                    |
|funcMode			 |功能模式配置；display<展示模式>， edit<编辑模式>，checkbox<多选模式>， radio<单选模式>；默认是	radio																																			 |String	          |是				|radio		|dispaly,edit,checkbox		    |
|treeData			|树源数据列表																																																		                                                       |Array	            |是				|[]				|-			                      |
|valueKey			|绑定value的键属性(项的唯一key标识)																																							                                                         |String	          |否				|id				|-			                      |
|labelKey			|用于显示的字段																																																	                					                               |String	          |否				|label		|-			                      |
|disabledKey	|禁用节点绑定属性																																																                                                         |String	          |否				|disabled	|-  		                      |
|childrenKey	|子节点绑定属性	(注意：当item[childrenKey]的值设为null时，代表是无下级数据的父节点，即非叶子节点)											                                                         |String	          |否				|children	|-			                      |
|title			|	弹出标题(如果是函数时会返回所选项的值作为回调参数如；title: (checked):String => {})																													                               |String, Function	|否				|''				|-			                      |
|selectParent			|作用于funcMode=display模式下；是否可以选父级																																													                               |Boolean           |否				|false		|true		                      |
|foldAll|	折叠时关闭所有已经打开的子集，再次打开时需要一级一级打开																																                                                         |Boolean           |否				|false		|true		                      |
|themeColor				|主题颜色																																															                                                             |String	          |否				|#f9ae3d	|-			                      |
|cancelColor				|取消按钮颜色																																															                                                       |String	          |否				|#757575	|-			                      |
|titleColor				|标题颜色																																																		                                                       |String	          |否				|#757575	|-			                      |
|border				|是否有分割线																																																		                                                       |Boolean           |否				|false		|true		                      |
|checkStrictly|作用于funcMode=checkbox模式下； 状态下节点选择完全受控（父子节点选中状态不再关联）																                             |Boolean           |否				|false		|true		                      |
|checkStrictlyModel|作用于funcMode=checkbox模式下；父子节点关联模式：strong:强关联（不再受限节点的disabled控制），weak：弱关联（节点关联受disabled控制）	       |String            |是				  |weak   |strong	                      |
|showHalfCheckedTips|作用于funcMode=checkbox模式下； checkStrictly为false的状态下生效；父子节点选中状态不再关联，是否展示半选提示；                             |Boolean           |否				|false		|true		                      |
|ifSearch| 筛选search模式																																																	                                                           |Boolean           |否				|true		  |false		                    |
|searchModel| 搜索模式配置		depHighlight: 从属高亮（显示层级并高亮显示）；common: 一般																													                                         |String            |否				|common	  |depHighlight		              |
|showAuxiliaryLine| 是否打开辅助线																																														                                                         |Boolean           |否				|false		|true		                      |
|loadData| 异步加载函数  (node):Promise([childData]) => {} // demo有说明																																								                               |Function          |否				|-		    |-		                        |
|height| 只在uiMode=popup时生效；弹层容器的高度，默认是500																																										                                           |Number            |否				|500		  |-		                        |
|changeVerify|作用于funcMode=display模式下； 验证函数  (current as any, chooseList as any []):String => {} // 验证函数会把当前控件的选择值作为参数返给函数体，demo有说明									   |Function          |否				|-		    |-		                        |
|expandedKeys| (Controlled) Specifies the keys of the expanded treeNodes 展开配置项，格式为[valueKey]									   																	                             |Array          |否					|[]		    |-		                        |
|expandedMode| 展开模式配置： common:  一般模式；singe: 单一模式；									   																	                                                                 |String          |否				|common		    |singe	                    |


# Event 事件
|事件名	|说明						|类型	|回调参数	|
|----	|----						|----	|----		|
|confirm|菜单收起时返回的筛选结果	|emit	|array		|
|clear|点击清除按钮时触发	|emit	|-		|
|cancel|关闭弹层和点击取消时触发	|emit	|-		|
|change|选项改变时触发	|emit	|array		|

## Slot 插槽

|名称		        |说明									|参数																          |
|----		        |----									|----																          |
|label	        |label插槽  						|data(当前项对于treeData里面的数据)		          |
|topBar	        |topBar插槽  					|----滚动区域顶部topBar插槽                     |
|bottomBar	    |bottomBar插槽  				|----滚动区域底部bottomBar插槽                  |
|fixedBottomBar	|fixedBottomBar插槽  	|----固定在页面的底部，使用fixed进行定位          |
|empty	        |empty插槽  	          |----数据为空的插槽                             |

