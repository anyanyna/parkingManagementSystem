<template>
  <div class="operate">
    <div class="operate-breadcrumb">
      <span>车场管理/</span><span>车场看板</span>
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
        />
        <!-- 年月日 单选 -->
        <a-radio-group v-model:value="timeType" button-style="solid" @change="() => { handleRadioChange() }">
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
    <!-- 停车概况 -->
    <div class="operate-general">
      <div class="operate-general-title">停车概况</div>
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
      <div class="operate-chart-con" v-for="(item, index) in echartsList" :key="index" :style="{flex: item.flex}">
        <div class="operate-chart-con-title" style="column-gap: 6px;">
          {{item.title}}
          <a-tooltip placement="top" color="#FFFFFF" v-if="item.desc">
            <template #title>
              <span style="color: #2B323D;" v-html="item.desc"/>
            </template>
            <div class="operate-general-con-item-info-tip-echarts">
              <img :src="'./staticResource/wzc/operate/问号@2x.png'" alt="">
            </div>
          </a-tooltip>
        </div>
        <div class="operate-chart-con-info">
          <!-- <div :ref="index" v-if="item.option" style="width: 100%; height: 100%;"></div> -->
          <div :ref="index" v-if="item.option && item.option.series[0].data.length !== 0" style="width: 100%; height: 100%;"></div>
          <div v-else-if="item.option && item.option.series[0].data.length === 0" style="width: 100%; height: 100%;display: flex;justify-content: center;align-items: center;">
            <img :src="'./staticResource/wzc/operate/暂无数据@2x.png'" alt="" style="width: 144.98px; height: 198px;">
          </div>
          <div v-else class="operate-con-info" style="width: 100%; height: 100%;">
            <div class="operate-con-info-item" v-for="(item, index) in item.data" :key="index">
              <img :src="item.icon" :key="index" />
              <span class="info-container">
                <a-tooltip placement="top" color="#FFFFFF" >
                  <template #title>
                    <span style="color: #2B323D;">{{item.title}}</span>
                  </template>
                  <span class="title">{{item.title}}</span>
                </a-tooltip>
                <a-tooltip placement="top" color="#FFFFFF">
                  <template #title>
                    <span style="color: #2B323D;">{{item.value}}</span>
                  </template>
                  <span class="value">{{item.value}}</span>
                </a-tooltip>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import axios from "axios";
export default {
  data() {
    return {
      operateForm: {
        // 车场
        yardName: [],
        // 类型
        type: [],
        // 状态
        status: [],
        // 板块
        sector: [],
        // 年月日
        dateTime: []
      },
      // 数据选择器 类型
      picker: "date", // year date month
      // 下拉选择框 大小
      size: "middle",
      // 年月日 单选
      timeType: "date",
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
      // 车场 options
      optionsParkingLot: [
        { value: "车场1", label: "车场1" },
        { value: "车场2", label: "车场2" },
        { value: "车场3", label: "车场3" },
      ],
      // 类型 options
      optionsType: [
        { value: "类型1", label: "类型1" },
        { value: "类型2", label: "类型2" },
        { value: "类型3", label: "类型3" },
      ],
      // 状态 options
      optionsStatus: [
        { value: "状态1", label: "状态1" },
        { value: "状态2", label: "状态2" },
        { value: "状态3", label: "状态3" },
      ],
      // 板块 options
      optionsPlate: [
        { value: "板块1", label: "板块1" },
        { value: "板块2", label: "板块2" },
        { value: "板块3", label: "板块3" },
      ],
      // 停车概况 数据
      generalList: [
        {
          // key: 'unit_parking_amount',
          key: 'received_amount',
          title: '停车交易实收(元)',
          value: '0',
          tip: '停车交易实收：统计时间范围内停车订单实收金额总和',
          icon: './staticResource/wzc/operate/停车交易实收@2x.png'
        },
        {
          key: 'long_intent_amount',
          title: '长租交易实收(元)',
          value: '0',
          tip: '长租交易实收：统计时间范围内长租订单实收金额总和',
          icon: './staticResource/wzc/operate/长租交易实收@2x.png'
        },
        {
          key: 'vehicle_number',
          title: '服务车次(次)',
          value: '0',
          tip: '服务车次：统计时间范围内停车订单总数',
          icon: './staticResource/wzc/operate/服务车次@2x.png'
        },
        {
          // key: 'received_amount',
          key: 'unit_parking_amount',
          title: '单泊位停车收益(元)',
          value: '0',
          tip: '单泊位停车收益：停车交易实收/总车位数',
          icon: './staticResource/wzc/operate/单泊位停车收益_看板@2x.png'
        },
        {
          key: 'exit_efficiency',
          title: '离场效率(秒)',
          value: '0',
          tip: '离场效率：（道闸抬杠时间-车辆到达出口时间）/出场车总数',
          icon: './staticResource/wzc/operate/离场效率@2x.png'
        },
        {
          key: 'error_order_count',
          title: '计费异常(笔)',
          value: '0',
          tip: '计费异常：停车订单中订单状态为异常的订单数',
          icon: './staticResource/wzc/operate/计费异常@2x.png'
        },
      ],
      echartsList: [
        {
          title: '车辆业务分析',
          flex: '1 1 30%',
          // grid: {
          //   top: '40',    // 图表与顶部的间距  
          //   bottom: '40', // 图表与底部的间距  
          //   left: '60',   // 图表与左侧的间距  
          //   right: '40'   // 图表与右侧的间距  
          // },
          option: {
            color: ['#3EADFC', '#F9A554', '#3ECD7C', '#F98481'],
            tooltip: {
              trigger: 'item',
              formatter: '{a} <br/>{b} : ({d}% {c})'
            },
            legend: {
              orient: 'vertical',
              top: 'center',
              right: '15%',
              // right: '0%',
              itemGap: 20, // 调整这个值来尝试改变行间距
              formatter: (name) => {
                  const seriesData = this.echartsList[0].option.series[0].data;
                  const total = seriesData.reduce((sum, item) => sum + item.value, 0);
                  const item = seriesData.find(item => item.name === name);
                  // const total = seriesData.reduce((sum, item) => sum + item.type_count, 0);
                  // const item = seriesData.find(item => item.license_type === license_type);
                  if (item) {
                    const percent = item ? ((item.value / total) * 100).toFixed(0) + '%' : '0%';
                    return `${name}       ${percent}       ${item.value}`;
                    // const percent = item ? ((item.type_count / total) * 100).toFixed(0) + '%' : '0%';
                    // return `${name}  ${percent}  ${item.type_count}`;
                  }
              },
              textStyle: {
                fontWeight: 'bold',
                fontSize: '16'
              }
            },
            series: [
              {
                name: '车辆业务分析',
                type: 'pie',
                center: ['25%', '50%'],
                radius: ['45%', '60%'],
                avoidLabelOverlap: false,
                label: {
                  show: false,
                  position: 'center'
                },
                emphasis: {
                  label: {
                    show: true,
                    fontSize: 20,
                    fontWeight: 'bold'
                  }
                },
                labelLine: {
                  show: false
                },
                data: []
              }
            ]
          }
        },
        {
          title: '停留时长分析',
          flex: '1 1 30%',
          option:{
            // color: [ // 设置渐变色到 color 属性
            //   new echarts.graphic.LinearGradient(0, 0, 0, 1, [
            //     { offset: 0, color: '#60F6E6' },  // 渐变开始颜色
            //     { offset: 1, color: '#00C8B3' }   // 渐变结束颜色
            //   ])
            // ],
            grid: {
              top: '40',    // 图表与顶部的间距  
              bottom: '40', // 图表与底部的间距  
              left: '60',   // 图表与左侧的间距  
              right: '40'   // 图表与右侧的间距  
            },
            tooltip: {
              show: true,
              trigger: 'axis',
            },
            xAxis: {
              type: 'category',
              boundaryGap: true,
              data: [],
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              axisLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                  // width: 2
                }
              }
            },
            yAxis: {
              type: 'value',
              name: '单位：笔',
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              splitLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                }
              }
            },
            series: [
              {
                name: '停留时长', // 这个名称会与 legend.data 中的名称对应  
                // barWidth: '20',
                barWidth: '30%  ', // 设置柱子宽度为类目轴宽度的30%  
                data: [],
                type: 'bar',
                itemStyle: {
                  // 设置渐变颜色  
                  color: new echarts.graphic.LinearGradient(
                    0, 0, 0, 1, // 渐变方向：从左上到右下  
                    [
                      { offset: 0, color: '#60F6E6' }, // 起始颜色  
                      { offset: 1, color: '#00C8B3' }  // 结束颜色  
                    ]
                  )
                }
              }
            ]
          }
        },
        {
          title: '车辆资源数据',
          flex: '1 1 30%',
          data: [
            {
              key: 'enter_count',
              icon: './staticResource/wzc/operate/出入口个数@2x.png',
              title: '出入口个数',
              value: '0'
            },
            {
              key: 'last_total_count',
              icon: './staticResource/wzc/operate/剩余泊位／总数@2x.png',
              title: '剩余泊位/总数',
              value: '0/0'
            },
            {
              key: 'person_count',
              icon: './staticResource/wzc/operate/岗亭人员@2x.png',
              title: '岗亭人员',
              value: '0'
            },
            {
              key: 'monitor_device_count',
              icon: './staticResource/wzc/operate/设备监控@2x.png',
              title: '设备监控(个)',
              value: '0'
            }
          ]
        },
        {
          title: '出入口流量分析',
          flex: '1 1 65.3%',
          option: {
            legend: {
              data: ['入口', '出口']
            },
            grid: {
              top: '40',    // 图表与顶部的间距  
              bottom: '40', // 图表与底部的间距  
              left: '80',   // 图表与左侧的间距  
              right: '40'   // 图表与右侧的间距  
            },
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                type: 'cross',
                label: {
                  backgroundColor: '#6a7985'
                }
              }
            },
            xAxis: {
              type: 'category',
              boundaryGap: false,
              data: [],
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              axisLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                  // width: 2
                }
              }
            },
            yAxis: {
              type: 'value',
              name: '单位：次', // 在这里设置单位
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              splitLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                }
              }
            },
            series: [
              {
                name: '入口',
                data: [],
                type: 'line',
                areaStyle: {
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    { offset: 0, color: 'rgba(24, 144, 255, 0.5)' }, // 渐变开始颜色
                    { offset: 1, color: 'rgba(24, 144, 255, 0)' }    // 渐变结束颜色
                  ])
                }
              },
              {
                name: '出口',
                data: [],
                type: 'line',
                areaStyle: {
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    { offset: 0, color: 'rgba(70, 206, 133, 0.5)' }, // 渐变开始颜色
                    { offset: 1, color: 'rgba(69, 206, 133, 0)' }    // 渐变结束颜色
                  ])
                }
              }
            ]
          }
        },
        {
          title: '异常订单分析',
          flex: '1 1 31.5%',
          option:{
            // color: [ // 设置渐变色到 color 属性
            //   new echarts.graphic.LinearGradient(0, 0, 0, 1, [
            //     { offset: 0, color: '#8BC3F6' }, // 渐变开始颜色
            //     { offset: 1, color: '#1890FF' }  // 渐变结束颜色
            //   ])
            // ],
            grid: {
              top: '40',    // 图表与顶部的间距  
              bottom: '40', // 图表与底部的间距  
              left: '60',   // 图表与左侧的间距  
              right: '40'   // 图表与右侧的间距  
            },
            tooltip: {
              show: true,
              trigger: 'axis',
            },
            xAxis: {
              type: 'category',
              data: [],
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              axisLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                  // width: 2
                }
              }
            },
            yAxis: {
              type: 'value',
              name: '单位：笔',
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              splitLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                }
              }
            },
            series: [
              {
                name: '异常订单', // 这个名称会与 legend.data 中的名称对应  
                // barWidth: '20',
                barWidth: '30%  ', // 设置柱子宽度为类目轴宽度的30%  
                data: [],
                type: 'bar',
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
        },
        {
          title: '有效利用率趋势',
          flex: '1 1 65.3%',
          desc: '默认显示近24小时的利用率</br>1、有效利用率趋势：统计时间节点泊车位数/总车位数</br>2、筛选选择年度对应年坐标、月度显示月坐标、日显示日坐标',
          option: {
            grid: {
              top: '40',    // 图表与顶部的间距  
              bottom: '40', // 图表与底部的间距  
              left: '80',   // 图表与左侧的间距  
              right: '40'   // 图表与右侧的间距  
            },
            xAxis: {
              type: 'category',
              boundaryGap: false,
              data: [],
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              axisLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                  // width: 2
                }
              }
            },
            tooltip: {
              trigger: 'axis',
              axisPointer: {
                type: 'cross',
                label: {
                  backgroundColor: '#6a7985'
                }
              }
            },
            yAxis: {
              type: 'value',
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              splitLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                }
              }
            },
            series: [
              {
                name: '有效利用率', // 这个名称会与 legend.data 中的名称对应  
                data: [],
                type: 'line',
                areaStyle: {
                  color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                    { offset: 0, color: 'rgba(253, 152, 67, 1)' }, // 渐变开始颜色
                    { offset: 1, color: 'rgba(253, 152, 67, 0)' }    // 渐变结束颜色
                  ])
                },
                itemStyle: {
                  color: 'rgba(253, 152, 67, 1)' // 设置线条颜色
                }
              },
            ]
          }
        },
        {
          title: '周转率趋势',
          flex: '1 1 31.5%',
          desc: '默认显示近7天的周转率</br>1、周转率趋势：统计时间节点停车订单数/车位总数；</br>2、筛选选择年度对应年坐标、月度显示月坐标、日显示日坐标',
          option:{
            grid: {
              top: '40',    // 图表与顶部的间距  
              bottom: '40', // 图表与底部的间距  
              left: '60',   // 图表与左侧的间距  
              right: '40'   // 图表与右侧的间距  
            },
            xAxis: {
              type: 'category',
              data: [],
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              axisLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                  // width: 2
                }
              }
            },
            tooltip: {
              show: true,
              trigger: 'axis',
            },
            yAxis: {
              type: 'value',
              axisLabel: {
                color: '#999999'  // 指定标签颜色  
              },
              splitLine: {
                show: true,
                lineStyle: {
                  type: 'dashed',
                  color: 'rgba(150, 155, 180, 0.5)',
                }
              }
            },
            series: [
              {
                name: '周转率', // 这个名称会与 legend.data 中的名称对应  
                // barWidth: '20',
                barWidth: '30%  ', // 设置柱子宽度为类目轴宽度的30%  
                data: [],
                type: 'bar',
                itemStyle: {
                  // 设置渐变颜色  
                  color: new echarts.graphic.LinearGradient(
                    0, 0, 0, 1, // 渐变方向：从左上到右下  
                    [
                      { offset: 0, color: '#88EDB7' }, // 起始颜色  
                      { offset: 1, color: '#48CF87' }  // 结束颜色  
                    ]
                  )
                }
              }
            ]
          }
        }
      ]
    };
  },
  watch: {},
  methods: {
    // 年月日 单选 设置 年月日 时间选择
    handleRadioChange() {
      this.operateForm.dateTime = []
      if (this.timeType == 'year') return this.picker = 'year'
      if (this.timeType == 'month') return this.picker = 'month'
      if (this.timeType == 'date') return this.picker = 'date'
    },
    getTime (time) {
      const date = new Date(time);
      if (time) {
        switch (this.timeType) {
          case 'year':
            return date.getFullYear().toString();
          case 'month':
            return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}`; // 返回 "YYYY-MM" 格式
          case 'date':
            return `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')}`;
          default:
            return time;
        }
      } else {
        return ''
      }
    },
    // 查询
    async handleSearch() {
      const params = {
        yardName: this.operateForm.yardName,
        beginDate: this.operateForm.dateTime ? this.getTime(this.operateForm.dateTime[0]) : '',
        endDate: this.operateForm.dateTime ? this.getTime(this.operateForm.dateTime[1]) : '',
        timeType: this.timeType,
        type: this.operateForm.type,
        status: this.operateForm.status,
        sector: this.operateForm.sector
      }
      await this.handleSummaryData(params)
      await this.handleVehicleTypePieData(params)
      await this.handleStatTimeBarData(params)
      await this.handleParkResourceData(params)
      await this.handleInOutFlowData(params)
      await this.handleErrorOrderBarData(params)
      await this.handleEfficiencyRatioData(params)
      await this.handleTurnoverRatioawaitoData(params)
      this.initEcharts()
    },
    // 概要
    async handleSummaryData (params) {
      // const { data } = await this.executeBackendInterface('getSummary', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getSummary', params)
      Object.keys(data).forEach((key) => {
        const index = this.generalList.findIndex((item) => item.key === key)
        if (index >= 0) {
          this.generalList[index].value = data[key] || 0
        } 
      })
    },
    // 车辆业务分析饼图
    async handleVehicleTypePieData (params) {
      const { data } = await this.executeBackendInterface('./DepotBoard/getVehicleTypePie', params)
      
      // this.echartsList[0].option.series[0].data = Object.keys(data).map((key) => {
      //   return {
      //     value: data[key] || 0,
      //     name: key
      //   }
      // })
      this.echartsList[0].option.series[0].data = data.map((key) => {
        return {
          value: key.type_count || 0,
          name: key.license_type
        }
      })

    },
    // 停留时长柱状图
    async handleStatTimeBarData (params) {
      // const { data } = await this.executeBackendInterface('getStatTimeBar', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getStatTimeBar', params)
      this.echartsList[1].option.xAxis.data = data.map((item) => item.query_time)
      this.echartsList[1].option.series[0].data = data.map((item) => item.duration)
    },
    // 车场资源
    async handleParkResourceData (params) {
      // const { data } = await this.executeBackendInterface('getParkResource', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getParkResource', params)
      Object.keys(data).forEach((key) => {
        const index = this.echartsList[2].data.findIndex((item) => item.key === key)
        if (index >= 0) {
          this.echartsList[2].data[index].value = data[key]
        } else {
          const last_total_count_index = this.echartsList[2].data.findIndex((item) => item.key === 'last_total_count')
          if (last_total_count_index >= 0) {
            const lastValue = data['parking_free']
            const totalValue = data['parking_total']
            this.echartsList[2].data[last_total_count_index].value = `${lastValue}/${totalValue}`
          }
        }
      })
    },
    // 车辆流入流出折线图
    async handleInOutFlowData (params) {
      // const { data } = await this.executeBackendInterface('getInOutFlow', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getInOutFlow', params)
      if (data) {
        const { enterList, exitList } = data
        this.echartsList[3].option.series[0].data = enterList.map((item) => item.enter_count)
        this.echartsList[3].option.series[1].data = exitList.map((item) => item.exit_count)
        this.echartsList[3].option.xAxis.data = enterList.map((item) => item.query_time)
      }
    },
    // 异常订单柱状图
    async handleErrorOrderBarData (params) {
      // const { data } = await this.executeBackendInterface('getErrorOrderBar', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getErrorOrderBar', params)
      this.echartsList[4].option.xAxis.data = data.map((item) => item.query_time)
      this.echartsList[4].option.series[0].data = data.map((item) => item.error_count)
    },
    // 有效利用率趋势
    async handleEfficiencyRatioData (params) {
      // const { data } = await this.executeBackendInterface('getEfficiencyRatio', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getEfficiencyRatio', params)
      this.echartsList[5].option.xAxis.data = data.map((item) => item.query_time)
      this.echartsList[5].option.series[0].data = data.map((item) => item.ratio)
    },
    // 周转率趋势
    async handleTurnoverRatioawaitoData (params) {
      // const { data } = await this.executeBackendInterface('getTurnoverRatio', params)
      const { data } = await this.executeBackendInterface('./DepotBoard/getTurnoverRatio', params)
      this.echartsList[6].option.xAxis.data = data.map((item) => item.query_time)
      this.echartsList[6].option.series[0].data = data.map((item) => item.ratio)
    },
    // 重置
    handleRest() {
      for (let key in this.operateForm) {
        this.operateForm[key] = undefined
      }
      this.timeType = 'date'
      this.handleRadioChange()
      this.handleSearch()
    },
    initEcharts() {
      this.echartsList.forEach((item, index) => {
        const refArr = this.$refs[index] || []
        if (refArr.length) {
          const myChart = echarts.init(refArr[0])
          if (item.option) {
            myChart.setOption(item.option)
          }
        }
      })
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
          // .post("./DepotBoard/" + funcName, params, {
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
  mounted() {
    this.handleSearch()

    // 车场名称 options 数据
    this.getoptionsParkingLot()
    // 车场类型 options 数据
    this.getOptionsType()
    // 车场状态 options 数据
    this.getOptionsStatus()
    // 所属板块 options 数据
    this.getOptionsPlate()
  }
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
      justify-content: space-evenly;
      align-items: center;
      width: 100%;
      height: calc(100% - 58px);
      padding: 20px;
      column-gap: 20px;

      &-item {
        width: 390px;
        height: 120px;
        background: url('./staticResource/wzc/operate/应收金额@2x.png') no-repeat;
        background-position: center;
        background-size: contain;
        position: relative;

        &-info {
          display: flex;

          &-title {
            font-size: 16px;
            color: #5F6877;
            line-height: 17px;
            position: absolute;
            top: 28px;
            left: 96px;
          }

          &-tip {
            width: 20px;
            height: 20px;
            position: absolute;
            top: 8px;
            right: 8px;
            img {
              width: 100%;
              height: 100%;
            }
            &-echarts {
              position: relative;
            }
            &-echarts img{
              position: absolute;
              top: -9px;
              width: 19px;
              object-fit: contain;
            }
          }
        }

        &-value {
          font-weight: bold;
          font-size: 26px;
          color: #2B323D;
          line-height: 26px;
          position: absolute;
          top: 65px;
          left: 96px;
        }
      }
    }
  }

  &-chart {
    display: flex;
    flex-wrap: wrap;
    width: 1660px;
    margin-top: 20px;
    gap: 20px;

    &-con {
      height: 340px;
      background: #FFFFFF;

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
        width: 100%;
        height: calc(100% - 58px);
        .operate-con-info {
          padding: 20px;
          display: flex;
          align-items: center;
          flex-wrap: wrap;
          &-item {
            height: 50%;
            border: 1px solid #E4E7E9;
            display: flex;
            justify-content: center;
            align-items: center;
            column-gap: 14px;
            flex: 1 0 50%;
            &:nth-child(1) {
              border-left: 0;
              border-top: 0;
              border-right: 0;
            }
            &:nth-child(2) {
              border-top: 0;
              border-right: 0;
            }
            &:nth-child(3) {
              border-left: 0;
              border-top: 0;
              border-right: 0;
              border-bottom: 0;
            }
            &:nth-child(4) {
              border-top: 0;
              border-right: 0;
              border-bottom: 0;
            }
            img {
              width: 56px;
              object-fit: contain;
            }
            .info-container {
              display: inline-flex;
              justify-content: center;
              flex-direction: column;
              row-gap: 14px;
              .title {
                // width: 96px;
                display: inline-block;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
                font-weight: 400;
                font-size: 16px;
                color: #666666;
              }
              .value {
                // width: 96px;
                display: inline-block;
                overflow: hidden;
                text-overflow: ellipsis;
                white-space: nowrap;
                font-weight: bold;
                // font-size: 26px;
                font-size: 22px;
                color: #2B323D;
                line-height: 1;
              }
            }
          }
        }
      }
    }
  }
}
</style>
