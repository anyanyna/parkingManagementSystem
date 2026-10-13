<template>
  <div class="operate">
    <div class="operate-breadcrumb">
      <span>运营管理/</span><span>运营看板</span>
    </div>
    <!-- 查询 -->
    <div class="operate-search">
      <!-- 表单 -->
      <div class="operate-search-item">
        <!-- 车场 -->
        <a-select style="width: 160px; height: 32px" data-event
          dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow="true"
          v-model:value="operateForm.yardName" :allowClear="true" placeholder="全部车场" :mode="'multiple'"
          :options="optionsParkingLot" :showSearch="true">
        </a-select>
        <!-- 类型 -->
        <a-select style="width: 160px; height: 32px" data-event
          dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow="true" v-model:value="operateForm.type"
          :allowClear="true" placeholder="全部类型" :mode="'multiple'" :options="optionsType" :showSearch="true">
        </a-select>
        <!-- 状态 -->
        <a-select style="width: 160px; height: 32px" data-event
          dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow="true" v-model:value="operateForm.status"
          :allowClear="true" placeholder="全部状态" :mode="'multiple'" :options="optionsStatus" :showSearch="true">
        </a-select>
        <!-- 板块 -->
        <a-select style="width: 160px; height: 32px" data-event
          dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow="true" v-model:value="operateForm.sector"
          :allowClear="true" placeholder="所有板块" :mode="'multiple'" :options="optionsPlate" :showSearch="true">
        </a-select>
        <!-- 年月日 时间选择 -->
        <a-range-picker style="height: 32px" v-model:value="operateForm.dateTime" :picker="picker"
          :valueFormat="valueFormat" />
        <!-- 年月日 单选 -->
        <a-radio-group v-model:value="operateForm.timeType" button-style="solid" @change="() => { handleRadioChange() }">
          <a-radio-button v-for="(item, index) in radioList" :key="item.key" :value="item.key">{{ item.value
            }}</a-radio-button>
        </a-radio-group>
      </div>
      <!-- 按钮 -->
      <div class="operate-search-btn">
        <a-button type="primary" @click="() => { handleSearch() }">查询</a-button>
        <a-button @click="() => { handleRest() }">重置</a-button>
      </div>
    </div>
    <!-- 运营概况 -->
    <div class="operate-general">
      <div class="operate-general-title">运营概况</div>
      <div class="operate-general-con">
        <div class="operate-general-con-item" v-for="(item, index) in generalList" :key="index"
          :style="{ backgroundImage: `url(${item.icon})` }">
          <div class="operate-general-con-item-info">
            <div class="operate-general-con-item-info-title">{{ item.title }}</div>
            <!-- 提示 -->
            <a-tooltip placement="top" color="#FFFFFF">
              <template #title>
                <span style="color: #2B323D;">{{ item.tip }}</span>
              </template>
              <div class="operate-general-con-item-info-tip">
                <img :src="'./staticResource/wzc/operate/问号@2x.png'" alt="">
              </div>
            </a-tooltip>
          </div>
          <div class="operate-general-con-item-value">{{ item.value }}</div>
        </div>
      </div>
    </div>
    <!-- 图表 -->
    <div class="operate-chart">
      <!-- 应收金额 -->
      <div class="operate-chart-con">
        <div class="operate-chart-con-title">应收金额</div>
        <div class="operate-chart-con-info">
          <!-- 图表 -->
          <div v-show="receivableEchartsList.xData.length !== 0 && receivableEchartsList.yData.length !== 0" ref="receivableEcharts" style="width: 820px; height: 290px;"></div>
          <!-- 暂无数据 -->
          <img v-show="receivableEchartsList.xData.length === 0 && receivableEchartsList.yData.length === 0" :src="'./staticResource/wzc/operate/暂无数据@2x.png'" alt="">
        </div>
      </div>
      <!-- 收缴率 -->
      <div class="operate-chart-con">
        <div class="operate-chart-con-title">收缴率</div>
        <div class="operate-chart-con-info">
          <!-- 图表 -->
          <div v-show="captureEchartsList.xData.length !== 0 && captureEchartsList.yData.length !== 0" ref="captureEcharts" style="width: 820px; height: 290px;"></div>
          <!-- 暂无数据 -->
          <img v-show="captureEchartsList.xData.length === 0 && captureEchartsList.yData.length === 0" :src="'./staticResource/wzc/operate/暂无数据@2x.png'" alt="">
        </div>
      </div>
      <!-- 实收金额 -->
      <div class="operate-chart-con">
        <div class="operate-chart-con-title">实收金额</div>
        <div class="operate-chart-con-info">
          <!-- 图表 -->
          <div v-show="receiptsEchartsList.xData.length !== 0 && receiptsEchartsList.yData.length !== 0" ref="receiptsEcharts" style="width: 820px; height: 290px;"></div>
          <!-- 暂无数据 -->
          <img v-show="receiptsEchartsList.xData.length === 0 && receiptsEchartsList.yData.length === 0" :src="'./staticResource/wzc/operate/暂无数据@2x.png'" alt="">
        </div>
      </div>
      <!-- 服务车次 -->
      <div class="operate-chart-con">
        <div class="operate-chart-con-title">服务车次</div>
        <div class="operate-chart-con-info">
          <!-- 图表 -->
          <div v-show="serviceEchartsList.xData.length !== 0 && serviceEchartsList.yData.length !== 0" ref="serviceEcharts" style="width: 820px; height: 290px;"></div>
          <!-- 暂无数据 -->
          <img v-show="serviceEchartsList.xData.length === 0 && serviceEchartsList.yData.length === 0" :src="'./staticResource/wzc/operate/暂无数据@2x.png'" alt="">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import dayjs from 'dayjs'
import * as echarts from 'echarts';
import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { h } from "vue";
export default {
  data() {
    return {
      // 查询 表单
      operateForm: {
        // 车场
        yardName: [],
        // 类型
        type: [],
        // 状态
        status: [],
        // 板块
        sector: [],
        // 年月日 时间选择器
        dateTime: [],
        // 年月日 单选按钮
        timeType : 'month',
      },
      // 时间选择器 类型
      picker: "month", // year month date
      // 时间选择器 年 月 日 格式
      // 'year': 'YYYY'
      // 'month': 'YYYY-MM'
      // 'day': 'YYYY-MM-DD'
      valueFormat: 'YYYY-MM',
      // 下拉选择框 大小
      size: "middle",
      // 年月日 单选
      // timeType: "month",
      // 年月日 单选 数据
      radioList: [
        {
          key: "year",
          value: "年",
        },
        {
          key: "month",
          value: "月",
        },
        {
          key: "date",
          value: "日",
        },
      ],
      // 车场名称 options
      optionsParkingLot: [
        // { value: 1, label: "车场1" },
        // { value: 2, label: "车场2" },
        // { value: 3, label: "车场3" },
      ],
      // 车场类型 options
      optionsType: [
        // { value: 1, label: "类型1" },
        // { value: 2, label: "类型2" },
        // { value: 3, label: "类型3" },
      ],
      // 车场状态 options
      optionsStatus: [
        // { value: 1, label: "状态1" },
        // { value: 2, label: "状态2" },
        // { value: 3, label: "状态3" },
      ],
      // 所属板块 options
      optionsPlate: [
        // { value: 1, label: "板块1" },
        // { value: 2, label: "板块2" },
        // { value: 3, label: "板块3" },
      ],
      // 运营概况 数据
      generalList: [
        {
          title: '应收金额(元)',
          value: 0,
          tip: '应收金额: 统计时间范围内停车订单应收金额总和',
          icon: './staticResource/wzc/operate/应收金额@2x.png'
        },
        {
          title: '实收金额(元)',
          value: 0,
          tip: '实收金额: 统计时间范围内停车订单实收金额总和',
          icon: './staticResource/wzc/operate/实收金额@2x.png'
        },
        {
          title: '收缴率',
          value: 0,
          tip: '收缴率: 实收金额/应收金额x100%',
          icon: './staticResource/wzc/operate/收缴率@2x.png'
        },
        {
          title: '单泊位停车收益(元)',
          value: 0,
          tip: '服务车次: 统计时间范围内停车订单总数',
          icon: './staticResource/wzc/operate/单泊位停车收益@2x.png'
        },
      ],
      // 应收金额 折线 数据
      receivableEchartsList: {
        // xData: ['1月', '2月', '3月', '4月', '5月', '6月'],
        // yData: [820, 932, 901, 934, 1290, 1330],
        xData: [],
        yData: [],
      },
      // 收缴率 折线 数据
      captureEchartsList: {
        // xData: ['1月', '2月', '3月', '4月', '5月', '6月'],
        // yData: [820, 932, 901, 934, 1290, 1330],
        xData: [],
        yData: [],
      },
      // 实收金额 折线 数据
      receiptsEchartsList: {
        // xData: ['1月', '2月', '3月', '4月', '5月', '6月'],
        // yData: [820, 932, 901, 934, 1290, 1330],
        xData: [],
        yData: [],
      },
      // 服务车次 柱状图 数据
      serviceEchartsList: {
        // xData: ['1月', '2月', '3月', '4月', '5月', '6月'],
        // yData: [820, 932, 901, 934, 1290, 1330],
        xData: [],
        yData: [],
      },
    };
  },
  watch: {},
  methods: {
    // 年月日 单选 设置 年月日 时间选择
    handleRadioChange() {
      this.operateForm.dateTime = []
      if (this.operateForm.timeType == 'year') return this.picker = 'year', this.valueFormat = 'YYYY'
      if (this.operateForm.timeType == 'month') return this.picker = 'month', this.valueFormat = 'YYYY-MM'
      if (this.operateForm.timeType == 'date') return this.picker = 'date', this.valueFormat = 'YYYY-MM-DD'
    },
    // 查询
    handleSearch() {
      console.log("查询");
      // 年月日 时间选择 值 格式转化
      if (this.operateForm.dateTime && this.operateForm.dateTime.length !== 0) {
        this.operateForm.dateTime = [dayjs(this.operateForm.dateTime[0]).format(this.valueFormat), dayjs(this.operateForm.dateTime[1]).format(this.valueFormat)]
        console.log('operateForm.dateTime', this.operateForm.dateTime);
      }
      console.log('operateForm', this.operateForm);

      const params = {
        ...this.operateForm,
        beginDate: this.operateForm.dateTime[0] || null,
        endDate: this.operateForm.dateTime[1] || null,
      }
      delete params.dateTime

      console.log("🚀 ~ handleSearch ~ params:", params)

      // 运营概况 数据
      this.getGeneralList(params)
      // 应收金额 数据
      this.getReceivableEcharts(params)
      // 收缴率 数据
      this.getCaptureEcharts(params)
      // 实收金额 数据
      this.getReceiptsEcharts(params)
      // 服务车次 数据
      this.getServiceEcharts(params)
    },
    // 重置
    handleRest() {
      console.log("handleRest");
      // 表单 operateForm
      for (let key in this.operateForm) {
        if (key === 'timeType') {
          // 年月日 单选按钮
          this.operateForm[key] = 'month'
        } else {
          this.operateForm[key] = []
        }
      }

      // 查询
      this.handleSearch()
    },
    // 运营概况 数据
    async getGeneralList(params) {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getSummary",
          {
            ...params,
            beginDate: params.beginDate || this.getCurrentMonthFormatted(),
            endDate: params.endDate || this.getCurrentMonthFormatted(),
          }
        );
        if (response.flag) {
          console.log("🚀 ~ getGeneralList ~ response:", response)
          if (response.data && response.data.length !== 0) {
            // 应收金额
            this.generalList[0].value = response.data.receivable_amount || 0
            // 实收金额
            this.generalList[1].value = response.data.received_amount || 0
            // 收缴率
            this.generalList[2].value = response.data.received_ratio || 0
            // 单泊位停车收益
            this.generalList[3].value = response.data.unit_parking_amount.toFixed(2) || 0
          }
          
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 应收金额 数据
    async getReceivableEcharts(params) {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getAmountReceivable",
          {
            ...params,
            beginDate: params.beginDate || this.getCurrentAndFifthMonthBeforeFormatted()[0],
            endDate: params.endDate || this.getCurrentAndFifthMonthBeforeFormatted()[1],
          }
        );
        if (response.flag) {
          if (response.data && response.data.length !== 0) {
            console.log("🚀 ~ getReceivableEcharts ~ response:", response)
            // 应收金额 折线
            // this.receivableEchartsList.xData = ['1月', '2月', '3月', '4月', '5月', '6月']
            // this.receivableEchartsList.yData = [220, 332, 401, 334, 290, 130]
            // this.receivableEcharts()

            // 应收金额 折线
            this.receivableEchartsList.xData = response.data.map(i => {
              return i.query_time
            })
            this.receivableEchartsList.yData = response.data.map(i => {
              return i.receivable_amount
            })
            this.receivableEcharts()
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 收缴率 数据
    async getCaptureEcharts(params) {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getReceiveAmountRatio",
          {
            ...params,
            beginDate: params.beginDate || this.getCurrentAndFifthMonthBeforeFormatted()[0],
            endDate: params.endDate || this.getCurrentAndFifthMonthBeforeFormatted()[1],
          }
        );
        if (response.flag) {
          if (response.data && response.data.length !== 0) {
            console.log("🚀 ~ getCaptureEcharts ~ response:", response)
            // 收缴率 折线
            // this.captureEchartsList.xData = ['1月', '2月', '3月', '4月', '5月', '6月']
            // this.captureEchartsList.yData = [220, 332, 401, 334, 290, 130]
            // this.captureEcharts()


            // 收缴率 折线
            this.captureEchartsList.xData = response.data.map(i => {
              return i.query_time
            })
            this.captureEchartsList.yData = response.data.map(i => {
              return i.ratio
            })
            this.captureEcharts()
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 实收金额 数据
    async getReceiptsEcharts(params) {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getAmountReceived",
          {
            ...params,
            beginDate: params.beginDate || this.getCurrentAndFifthMonthBeforeFormatted()[0],
            endDate: params.endDate || this.getCurrentAndFifthMonthBeforeFormatted()[1],
          }
        );
        if (response.flag) {
          if (response.data && response.data.length !== 0) {
            console.log("🚀 ~ getReceiptsEcharts ~ response:", response)
            // 实收金额 折线
            // this.receiptsEchartsList.xData = ['1月', '2月', '3月', '4月', '5月', '6月']
            // this.receiptsEchartsList.yData = [220, 332, 401, 334, 290, 130]
            // this.receiptsEcharts()

            // 实收金额 折线
            this.receiptsEchartsList.xData = response.data.map(i => {
              return i.query_time
            })
            this.receiptsEchartsList.yData = response.data.map(i => {
              return i.received_amount
            })
            this.receiptsEcharts()
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 服务车次 数据
    async getServiceEcharts(params) {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getServVehicleCount",
          {
            ...params,
            beginDate: params.beginDate || this.getCurrentAndFifthMonthBeforeFormatted()[0],
            endDate: params.endDate || this.getCurrentAndFifthMonthBeforeFormatted()[1],
          }
        );
        if (response.flag) {
          if (response.data && response.data.length !== 0) {
            console.log("🚀 ~ getServiceEcharts ~ response:", response)
            // 服务车次 柱状图
            // this.serviceEchartsList.xData = ['1月', '2月', '3月', '4月', '5月', '6月']
            // this.serviceEchartsList.yData = [220, 332, 401, 334, 290, 130]
            // this.serviceEcharts()

            // 服务车次 柱状图
            this.serviceEchartsList.xData = response.data.map(i => {
              return i.query_time
            })
            this.serviceEchartsList.yData = response.data.map(i => {
              return i.vehicle_count
            })
            this.serviceEcharts()
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 应收金额 折线
    receivableEcharts() {
      var receivable = echarts.init(this.$refs.receivableEcharts)
      var option = {
        grid: {
          top: '40',    // 图表与顶部的间距  
          bottom: '40', // 图表与底部的间距  
          left: '60',   // 图表与左侧的间距  
          right: '40'   // 图表与右侧的间距  
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // boundaryGap: true,
          axisLine: {
            // 自定义轴线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)'   // 可选：设置轴线颜色，默认为黑色  
              // 其他样式属性，如 width, opacity 等  
            }
          },
          // 设置 x 轴标签的颜色为 #999999  
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          // 变量 x轴 数据
          // data: ['1月', '2月', '3月', '4月', '5月', '6月']
          data: this.receivableEchartsList.xData
        },
        yAxis: {
          type: 'value',
          name: '单位：元', // 在这里设置单位
          splitLine: {
            // 自定义网格线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)' // 设置网格线颜色  
              // 其他样式属性，如 width, type, opacity 等  
            }
          },
          nameTextStyle: {
            // 可选：自定义名称的文本样式  
            align: 'center', // 对齐方式，可以是 'left', 'center', 'right'  
            verticalAlign: 'bottom', // 垂直对齐方式，可以是 'top', 'middle', 'bottom'  
            // 其他样式属性，如 fontSize, fontWeight, color 等  
          },
          // 设置 y 轴标签的颜色为 #999999  
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
        },
        // legend: {  
        //   data: ['应收金额'] // 图例的名称，与 series 中的 name 属性对应  
        // },  
        tooltip: {
          trigger: 'axis', // 触发类型，'axis' 表示坐标轴触发，即在坐标轴上显示提示框  
        },
        series: [
          {
            name: '应收金额', // 这个名称会与 legend.data 中的名称对应  
            // 变量 y轴 数据
            // data: [820, 932, 901, 934, 1290, 1330],
            data: this.receivableEchartsList.yData,
            type: 'line',
            lineStyle: {
              color: '#1890FF' // 折线颜色  
            },
            itemStyle: {
              // 设置数据点样式  
              // 使用圆形标记点  
              symbol: 'circle',  // rect circle
              // 设置标记点半径  
              symbolSize: 10, // 根据需要调整半径大小  
              // 设置标记点颜色
              color: '#1890FF' // 根据需要调整标记点颜色  
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0, 0,   // 渐变起点（左上角）  
                  0, 1,   // 渐变终点（左下角，但由于是垂直渐变，所以理解为底部）  
                  [
                    { offset: 0, color: 'rgba(24,144,255,0.5)' }, // 起始颜色和位置（半透明蓝色）  
                    { offset: 1, color: 'rgba(24,144,255,0)' }    // 结束颜色和位置（完全透明蓝色，实际上是透明）  
                  ]
                )
              }
            }
          }
        ]
      }
      receivable.setOption(option)
    },
    // 收缴率 折线
    captureEcharts() {
      var capture = echarts.init(this.$refs.captureEcharts)
      var option = {
        grid: {
          top: '40',    // 图表与顶部的间距  
          bottom: '40', // 图表与底部的间距  
          left: '60',   // 图表与左侧的间距  
          right: '40'   // 图表与右侧的间距  
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // boundaryGap: true,
          axisLine: {
            // 自定义轴线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)'   // 可选：设置轴线颜色，默认为黑色  
              // 其他样式属性，如 width, opacity 等  
            }
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          // 变量 x轴 数据
          // data: ['1月', '2月', '3月', '4月', '5月', '6月']
          data: this.captureEchartsList.xData
        },
        yAxis: {
          type: 'value',
          // name: '单位：元', // 在这里设置单位
          splitLine: {
            // 自定义网格线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)' // 设置网格线颜色  
              // 其他样式属性，如 width, type, opacity 等  
            }
          },
          nameTextStyle: {
            // 可选：自定义名称的文本样式  
            align: 'center', // 对齐方式，可以是 'left', 'center', 'right'  
            verticalAlign: 'bottom', // 垂直对齐方式，可以是 'top', 'middle', 'bottom'  
            // 其他样式属性，如 fontSize, fontWeight, color 等  
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
        },
        // legend: {  
        //   data: ['收缴率'] // 图例的名称，与 series 中的 name 属性对应  
        // },  
        tooltip: {
          trigger: 'axis', // 触发类型，'axis' 表示坐标轴触发，即在坐标轴上显示提示框  
        },
        series: [
          {
            name: '收缴率', // 这个名称会与 legend.data 中的名称对应  
            // 变量 y轴 数据
            // data: [820, 932, 901, 934, 1290, 1330],
            data: this.captureEchartsList.yData,
            type: 'line',
            smooth: true,
            lineStyle: {
              color: '#FD9843' // 折线颜色  
            },
            itemStyle: {
              // 设置数据点样式  
              // 使用圆形标记点  
              symbol: 'circle',  // rect circle
              // 设置标记点半径  
              symbolSize: 10, // 根据需要调整半径大小  
              // 设置标记点颜色
              color: '#FD9843' // 根据需要调整标记点颜色  
            },
          }
        ]
      }
      capture.setOption(option)
    },
    // 实收金额 折线
    receiptsEcharts() {
      var receipts = echarts.init(this.$refs.receiptsEcharts)
      var option = {
        grid: {
          top: '40',    // 图表与顶部的间距  
          bottom: '40', // 图表与底部的间距  
          left: '60',   // 图表与左侧的间距  
          right: '40'   // 图表与右侧的间距  
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // boundaryGap: true,
          axisLine: {
            // 自定义轴线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)'   // 可选：设置轴线颜色，默认为黑色  
              // 其他样式属性，如 width, opacity 等  
            }
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          // 变量 x轴 数据
          // data: ['1月', '2月', '3月', '4月', '5月', '6月']
          data: this.receiptsEchartsList.xData,
        },
        yAxis: {
          type: 'value',
          name: '单位：元', // 在这里设置单位
          splitLine: {
            // 自定义网格线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)' // 设置网格线颜色  
              // 其他样式属性，如 width, type, opacity 等  
            }
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          nameTextStyle: {
            // 可选：自定义名称的文本样式  
            align: 'center', // 对齐方式，可以是 'left', 'center', 'right'  
            verticalAlign: 'bottom', // 垂直对齐方式，可以是 'top', 'middle', 'bottom'  
            // 其他样式属性，如 fontSize, fontWeight, color 等  
          }
        },
        // legend: {  
        //   data: ['实收金额'] // 图例的名称，与 series 中的 name 属性对应  
        // },  
        tooltip: {
          trigger: 'axis', // 触发类型，'axis' 表示坐标轴触发，即在坐标轴上显示提示框  
        },
        series: [
          {
            name: '实收金额', // 这个名称会与 legend.data 中的名称对应  
            // 变量 y轴 数据
            // data: [820, 932, 901, 934, 1290, 1330],
            data: this.receiptsEchartsList.yData,
            type: 'line',
            lineStyle: {
              color: '#45CE85' // 折线颜色  
            },
            itemStyle: {
              // 设置数据点样式  
              // 使用圆形标记点  
              symbol: 'circle',  // rect circle
              // 设置标记点半径  
              symbolSize: 10, // 根据需要调整半径大小  
              // 设置标记点颜色
              color: '#45CE85' // 根据需要调整标记点颜色  
            },
            areaStyle: {
              normal: {
                color: new echarts.graphic.LinearGradient(
                  0, 0,   // 渐变起点（左上角）  
                  0, 1,   // 渐变终点（左下角，但由于是垂直渐变，所以理解为底部）  
                  [
                    { offset: 0, color: 'rgba(69, 206, 133, 0.50)' }, // 起始颜色和位置（半透明蓝色）  
                    { offset: 1, color: 'rgba(69, 206, 133, 0)' }    // 结束颜色和位置（完全透明蓝色，实际上是透明）  
                  ]
                )
              }
            }
          }
        ]
      }
      receipts.setOption(option)
    },
    // 服务车次 柱状图
    serviceEcharts() {
      var service = echarts.init(this.$refs.serviceEcharts)
      var option = {
        grid: {
          top: '40',    // 图表与顶部的间距  
          bottom: '40', // 图表与底部的间距  
          left: '60',   // 图表与左侧的间距  
          right: '40'   // 图表与右侧的间距  
        },
        xAxis: {
          type: 'category',
          // boundaryGap: false,
          boundaryGap: true,
          axisLine: {
            // 自定义轴线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)'   // 可选：设置轴线颜色，默认为黑色  
              // 其他样式属性，如 width, opacity 等  
            }
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          // 变量 x轴 数据
          // data: ['1月', '2月', '3月', '4月', '5月', '6月']
          data: this.serviceEchartsList.xData,
        },
        yAxis: {
          type: 'value',
          name: '单位：元', // 在这里设置单位
          splitLine: {
            // 自定义网格线样式  
            lineStyle: {
              type: 'dashed', // 设置为虚线  
              color: 'rgba(150, 155, 180, 0.5)' // 设置网格线颜色  
              // 其他样式属性，如 width, type, opacity 等  
            }
          },
          axisLabel: {  
            color: '#999999'  // 指定标签颜色  
          }, 
          nameTextStyle: {
            // 可选：自定义名称的文本样式  单位
            align: 'center', // 对齐方式，可以是 'left', 'center', 'right'  
            verticalAlign: 'bottom', // 垂直对齐方式，可以是 'top', 'middle', 'bottom'  
            // 其他样式属性，如 fontSize, fontWeight, color 等  
          }
        },
        // legend: {  
        //   data: ['服务车次'] // 图例的名称，与 series 中的 name 属性对应  
        // },  
        tooltip: {
          trigger: 'axis', // 触发类型，'axis' 表示坐标轴触发，即在坐标轴上显示提示框  
        },
        series: [
          {
            name: '服务车次', // 这个名称会与 legend.data 中的名称对应  
            // 变量 y轴 数据
            // data: [820, 932, 901, 934, 1290, 1330],
            data: this.serviceEchartsList.yData,
            type: 'bar',
            barWidth: '25%', // 设置柱子宽度为类目轴宽度的30%  
            // 或者使用具体像素值，例如 barWidth: 50，但这通常不如百分比灵活
            itemStyle: {
              // 设置渐变颜色  
              color: new echarts.graphic.LinearGradient(
                0, 0, 0, 1, // 渐变方向：从左上到右下  
                [
                  { offset: 0, color: '#8BC3F6' }, // 起始颜色  
                  { offset: 1, color: '#1890FF' }  // 结束颜色  
                ]
              )
            }
          }
        ]
      }
      service.setOption(option)
    },
    // 获取 当月 '2024-08'
    getCurrentMonthFormatted() {
      const now = new Date();
      const year = now.getFullYear();
      const month = String(now.getMonth() + 1).padStart(2, '0'); // Months are zero-based, so add 1  
      return `${year}-${month}`;
    },
    // 获取当前月和前六个月的第一个月，['2024-5','2024-10']
    getCurrentAndFifthMonthBeforeFormatted() {  
      const now = new Date();  
      const currentYear = now.getFullYear();  
      const currentMonth = now.getMonth(); // 注意：月份是从0开始的  
    
      // 计算前六个月的第一个月  
      let fifthMonthBeforeYear = currentYear;  
      let fifthMonthBeforeMonth = currentMonth - 5;  
      if (fifthMonthBeforeMonth < 0) {  
          fifthMonthBeforeMonth += 12;  
          fifthMonthBeforeYear -= 1;  
      }  
    
      // 格式化为 'YYYY-MM'  
      const currentMonthFormatted = `${currentYear}-${String(currentMonth + 1).padStart(2, '0')}`;  
      const fifthMonthBeforeFormatted = `${fifthMonthBeforeYear}-${String(fifthMonthBeforeMonth + 1).padStart(2, '0')}`;  
    
      return [fifthMonthBeforeFormatted, currentMonthFormatted];  
    },
    // 车场名称 options 数据
    async getoptionsParkingLot() {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getYardList",
          {}
        );
        if (response.flag) {
          console.log("🚀 ~ getoptionsParkingLot-车场名称 ~ response:", response)
          if (response.data && response.data.length !== 0) {
            this.optionsParkingLot = response.data.map(i => {
              return {
                value: i.id,
                label: i.parking_lot_name
              }
            })
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 车场类型 options 数据
    async getOptionsType() {
      try {
        const response = await this.executeBackendInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_type') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeBackendInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsType = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 车场状态 options 数据
    async getOptionsStatus() {
      try {
        const response = await this.executeBackendInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_status') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeBackendInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsStatus = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 所属板块 options 数据
    async getOptionsPlate() {
      try {
        const response = await this.executeBackendInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_section') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeBackendInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsPlate = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios
          // .post("./Personalcenter/" + funcName, params, {
          .post(funcName, params, {
            headers: {
              "Content-Type": "application/json",
            },
          })
          .then((response) => {
            resolve(response.data);
          })
          .catch((error) => {
            reject(error);
          });
      });
    }
  },
  created() {
  },
  async mounted() {
    loadCss("./css/个人中心/theme.css");

    // 应收金额 折线
    // await this.receivableEcharts();
    // // 收缴率 折线
    // await this.captureEcharts();
    // // 实收金额 折线
    // await this.receiptsEcharts();
    // // 服务车次 柱状图
    // await this.serviceEcharts();

    // 查询
    await this.handleSearch()

    // 车场名称 options 数据
    this.getoptionsParkingLot()
    // 车场类型 options 数据
    this.getOptionsType()
    // 车场状态 options 数据
    this.getOptionsStatus()
    // 所属板块 options 数据
    this.getOptionsPlate()

  },
  computed: {
  },
};
</script>
<style scoped lang="less">
.operate {
  width: 100%;
  height: 100%;
  background: #f0f2f5;
  font-size: 14px;
  font-family: Source Han Sans CN, Source Han Sans CN;
  font-weight: 400;
  padding: 14px 20px 20px 20px;
  overflow: auto;

  &-breadcrumb {
    font-size: 16px;
    color: #999999;

    span:nth-child(2) {
      color: #1890ff;
    }
  }

  &-search {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1660px;
    height: 72px;
    background: #ffffff;
    margin-top: 16px;
    padding: 20px;

    :deep(.ant-select-selection-overflow) {
      flex-wrap: nowrap;
      overflow: hidden;
    }

    :deep(.ant-select-multiple .ant-select-selection-search-input) {
      height: 29px;
      line-height: 29px;
    }

    &-item {
      display: flex;
      gap: 14px;
    }

    &-btn {
      display: flex;
      gap: 12px;
    }
  }

  &-general {
    width: 1660px;
    height: 218px;
    background: #FFFFFF;
    margin-top: 20px;

    &-title {
      position: relative;
      display: flex;
      align-items: center;
      width: 100%;
      height: 58px;
      font-weight: bold;
      font-size: 16px;
      color: #2B323D;
      border-bottom: 1px solid #E6E6E6;
      padding-left: 29px;
    }

    &-title::before {
      position: absolute;
      left: 20px;
      content: '';
      display: inline-block;
      width: 3px;
      height: 18px;
      background: #1890FF;
    }

    &-con {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
      height: calc(100% - 58px);
      padding: 20px;

      &-item {
        width: 390px;
        height: 120px;
        background: url('./staticResource/wzc/operate/应收金额@2x.png') no-repeat;
        background-position: center;
        background-size: contain;
        padding: 32px 0 0 40px;

        &-info {
          display: flex;
          align-items: center;

          &-title {
            font-size: 16px;
            color: #5F6877;
            line-height: 17px;
            margin-top: 1px;
            margin-right: 10px;
          }

          &-tip {
            position: relative;
            width: 20px;
            height: 20px;
            // margin-top: -1px;

            img {
              position: absolute;
              top: 1px;
              width: 100%;
              height: 100%;
            }
          }
        }

        &-value {
          font-weight: bold;
          font-size: 26px;
          color: #2B323D;
          line-height: 26px;
          margin-top: 20px;
        }
      }
    }
  }

  &-chart {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    width: 1660px;
    margin-top: 20px;

    &-con {
      width: 820px;
      height: 340px;
      background: #FFFFFF;
      margin-bottom: 20px;

      &-title {
        position: relative;
        display: flex;
        align-items: center;
        width: 100%;
        height: 58px;
        font-weight: bold;
        font-size: 16px;
        color: #2B323D;
        border-bottom: 1px solid #E6E6E6;
        padding-left: 29px;
      }

      &-title::before {
        position: absolute;
        left: 20px;
        content: '';
        display: inline-block;
        width: 3px;
        height: 18px;
        background: #1890FF;
      }

      &-info {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: calc(100% - 58px);

        img {
          width: 145px;
          height: 198px;
        }
      }
    }

    &-con:nth-child(3),
    &-con:nth-child(4) {
      margin-bottom: 0;
    }
  }
}
</style>
