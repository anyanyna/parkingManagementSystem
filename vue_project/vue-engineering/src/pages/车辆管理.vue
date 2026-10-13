
<template>
            <yt-grid width="1700" height="1016" background="#F0F2F5">
                
            <yt-grid-item fixedSize='width' comWidth='58.00px' id="yt-93t1em1alecyj" gridColumnStart="20" gridColumnEnd="78" gridRowStart="16" gridRowEnd="36" zIndex="1" previewType="FixedWH">
                <span ref='ref49' class='webVueAntYtSpan webVueAntYtSpanStyle-rzfvc8h  webVueAntYtSpanStyle-rz webVueAntYtSpanStyle webVueAntYtSpanBrCount-rz webVueAntYtSpanBrCount'>
                            <span v-html='"车辆管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-xh2iwm1alecyn" gridColumnStart="20" gridColumnEnd="1680" gridRowStart="47" gridRowEnd="167" zIndex="2" previewType="FixedWH">
                <div ref='ref50' class='webVueAntYtRectangle webVueAntYtRectangleStyle-rzvkinb webVueAntYtRectangleStyle-rz webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='LicenseplatenumberisShow1' id="yt-bk7vom1alecyp" gridColumnStart="40" gridColumnEnd="370" gridRowStart="67" gridRowEnd="99" zIndex="3" previewType="FixedWH">
                <a-form-item ref='ref51' class='webVueAntInputFormItem webVueAntYtInputFormItem-rz90huh  webVueAntYtInputFormItem-rz webVueAntYtInputFormItem show-label-rz show-label' name='Licenseplatenumbervalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车牌号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-rzmrs9i webVueAntYtInputStyle-rz webVueAntYtInputStyle' v-model:value='Licenseplatenumbervalue1' :maxLength='100' :placeholder='"请输入"' :allowClear='true'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-s83xzm1alecyv" gridColumnStart="1521" gridColumnEnd="1585" gridRowStart="120" gridRowEnd="152" zIndex="4" previewType="FixedWH">
                <a-button ref='ref52' @click="()=> { queryVehicleList('search'); }" class='webVueAntButton webVueAntYtButtonStyle-rzxtrc8  webVueAntYtButtonStyle-rz webVueAntYtButtonStyle center-rz center' :loading='Query1loading1'>
                            <span class='yt-button-content ' v-html='"查询"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-h16oqm1alecyy" gridColumnStart="1597" gridColumnEnd="1661" gridRowStart="120" gridRowEnd="152" zIndex="5" previewType="FixedWH">
                <a-button ref='ref53' @click="()=> { resetFiltersAndRefreshList(); }" class='webVueAntButton webVueAntYtButtonStyle-rz3ujqd  webVueAntYtButtonStyle-rz webVueAntYtButtonStyle center-rz center' :loading='Resetloading1'>
                            <span class='yt-button-content ' v-html='"重置"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-bgixlm1alecz0" gridColumnStart="20" gridColumnEnd="1680" gridRowStart="187" gridRowEnd="993" zIndex="6" previewType="FixedWH">
                <div ref='ref54' class='webVueAntYtRectangle webVueAntYtRectangleStyle-rzt110k webVueAntYtRectangleStyle-rz webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-zlgn7m1alecz1" gridColumnStart="40" gridColumnEnd="104" gridRowStart="204" gridRowEnd="236" zIndex="7" previewType="FixedWH">
                <a-button ref='ref55' @click="()=> { exportVehicleData(); }" class='webVueAntButton webVueAntYtButtonStyle-rzw2sw1  webVueAntYtButtonStyle-rz webVueAntYtButtonStyle center-rz center' :loading='Exportloading1'>
                            <span class='yt-button-content ' v-html='"导出"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='RecentappearancetimeisShow1' id="yt-ah19bm1aled0v" gridColumnStart="1300" gridColumnEnd="1660" gridRowStart="67" gridRowEnd="99" zIndex="8" previewType="FixedWH">
                <a-form-item ref='ref58' class='webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-rzaze91  webVueAntYtRangePickerFormItem-rz webVueAntYtRangePickerFormItem show-label-rz show-label' name='Recentappearancetimevalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"最近出场时间："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-range-picker data-event class='webVueAntYtRangePicker webVueAntYtRangePickerStyle-rzvcm47 webVueAntYtRangePickerStyle-rz webVueAntYtRangePickerStyle' popupKey='"popup_yt-dm86im17fr3yj" "popupKeyId"' v-model:value='Recentappearancetimevalue1' :mode="'second'" :showTime="true" :allowClear='true'>
                            
                        </yt-custom-range-picker>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='RecentaccesstoparkinglotisShow1' id="yt-sroxlm1aled16" gridColumnStart="435" gridColumnEnd="815" gridRowStart="67" gridRowEnd="99" zIndex="9" previewType="FixedWH">
                <a-form-item ref='ref59' class='webVueSelectFormItem webVueAntYtSelectFormItem-rzzllyg  webVueAntYtSelectFormItem-rz webVueAntYtSelectFormItem show-label-rz show-label' name='Recentaccesstoparkinglotvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"最近出入停车场："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-rz webVueAntYtSelectStyle' dropdownClassName='"popup_yt-rftarm17frhhn" "popupKeyId"' :showArrow='true' v-model:value='Recentaccesstoparkinglotvalue1' :placeholder='"请输入"' :mode='"single"' :options='Recentaccesstoparkinglotoptions1.dataSource' :showSearch='true' :allowClear='true'>
  
                            
                        </a-select>
                        <!-- <a-input data-event class='webVueAntinput webVueAntYtInputStyle-rzmrs9i webVueAntYtInputStyle-rz webVueAntYtInputStyle' v-model:value='Recentaccesstoparkinglotvalue1' :maxLength='100' :placeholder='"请输入"' :allowClear='true'> -->
                        <!-- </a-input> -->
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='RecentEntryTimeisShow1' id="yt-7ywd8m1aled1r" gridColumnStart="871" gridColumnEnd="1231" gridRowStart="67" gridRowEnd="99" zIndex="10" previewType="FixedWH">
                <a-form-item ref='ref61' class='webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-rztizfz  webVueAntYtRangePickerFormItem-rz webVueAntYtRangePickerFormItem show-label-rz show-label' name='RecentEntryTimevalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"最近入场时间："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-range-picker data-event class='webVueAntYtRangePicker webVueAntYtRangePickerStyle-rzvlkjk webVueAntYtRangePickerStyle-rz webVueAntYtRangePickerStyle' popupKey='"popup_yt-2g72wm17floo8" "popupKeyId"' v-model:value='RecentEntryTimevalue1' :allowClear='true' :mode="'second'" :showTime="true">
                            
                        </yt-custom-range-picker>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='TypeoflicenseplateisShow1' id="yt-8rnmim1aled2g" gridColumnStart="40" gridColumnEnd="370" gridRowStart="119" gridRowEnd="151" zIndex="11" previewType="FixedWH">
                <a-form-item ref='ref64' class='webVueSelectFormItem webVueAntYtSelectFormItem-rzkynp1  webVueAntYtSelectFormItem-rz webVueAntYtSelectFormItem show-label-rz show-label' name='Typeoflicenseplatevalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车牌类型："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-rz webVueAntYtSelectStyle' dropdownClassName='"popup_yt-jph57m17iin72" "popupKeyId"' :showArrow='true' v-model:value='Typeoflicenseplatevalue1' :placeholder='"请输入"' :mode='"single"' :options='Typeoflicenseplateoptions1.dataSource' :showSearch='true' :allowClear='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='VehicleListisShow1' id="yt-7e7kum1allh74" gridColumnStart="40" gridColumnEnd="1660" gridRowStart="252" gridRowEnd="924" zIndex="12" previewType="FixedWH">
                <yt-table ref='ref65' @click="()=> { paginateVehicleList(); initializeVehicleList(); }" class='webVueAntYtTable webVueAntYtTableStyle-rzi2fly webVueAntYtTableStyle-rz webVueAntYtTableStyle' :selectType='"checkbox"' v-model:selectedRows='VehicleListselectedRows1' v-model:total='VehicleListtotal1' v-model:current='VehicleListcurrent2' v-model:pageSize='VehicleListpageSize1' :columns='VehicleListdata1.columns' :showSizeChanger='true' :showQuickJumper='true' :dataSource='VehicleListdata1.dataSource' :scroll='{y:560.0000382001598}' @onTableChange="() => { queryVehicleList(); }">
                            <template #cell='{ column, record }'>
                            
                        </template>
                        </yt-table>
            </yt-grid-item>
        
            </yt-grid>
        </template>

<script>
import XLSX from 'xlsx';  
import { saveAs } from 'file-saver';
import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { h } from "vue";
export default {
  data() {
    return {
      VehicleListcurrentRow1: {},
      VehicleListselectedRows1: [],
      VehicleListpageSize1: 10,
      VehicleListdata1: {
        columns: [
        // {
        //   key: "id",
        //   title: "序号",
        //   dataIndex: "id"
        // },
        {
          key: "row_index",
          title: "序号",
          dataIndex: "row_index"
        },
        // {
        //   key: "serialNumber",
        //   title: "序号",
        //   dataIndex: "serialNumber"
        // },
        {
          key: "licenseplatenumber",
          title: "车牌号",
          dataIndex: "licenseplatenumber"
        }, {
          key: "typeoflicenseplate",
          title: "车牌类型",
          dataIndex: "typeoflicenseplate"
        }, {
          key: "recentEntryTime",
          title: "最近入场时间",
          dataIndex: "recentEntryTime"
        }, {
          key: "recentappearancetime",
          title: "最近出场时间",
          dataIndex: "recentappearancetime"
        }, {
          key: "closestaccesstoparkinglot",
          title: "最近出入停车场",
          dataIndex: "closestaccesstoparkinglot"
        }],
        dataSource: []
      },
      VehicleListcurrent2: 1,
      VehicleListtotal1: 0,
      VehicleListisShow1: true,
      Resetloading1: false,
      Typeoflicenseplatevalue1: undefined,
      Typeoflicenseplateoptions1: {
        dataSource: [{
          label: "蓝牌",
          value: "蓝牌",
          disabled: false,
          select: false
        }, {
          label: "黄牌",
          value: "黄牌",
          disabled: false,
          select: false
        }, {
          value: "黑牌",
          label: "黑牌",
          disabled: false,
          select: false
        }, {
          value: "黄绿",
          label: "黄绿",
          disabled: false,
          select: false
        }, {
          value: "白牌",
          label: "白牌",
          disabled: false,
          select: false
        }],
        value: []
      },
      TypeoflicenseplateisShow1: true,
      Exportloading1: false,
      Query1loading1: false,
      Recentappearancetimevalue1: [],
      RecentappearancetimeisShow1: true,
      Recentaccesstoparkinglotvalue1: undefined,
      Recentaccesstoparkinglotoptions1: {
        dataSource: [{
          label: "停车场T",
          value: "停车场T",
          disabled: false,
          select: false
        }, {
          label: "停车场S",
          value: "停车场S",
          disabled: false,
          select: false
        }],
        value: []
      },
      RecentaccesstoparkinglotisShow1: true,
      RecentEntryTimevalue1: [],
      RecentEntryTimeisShow1: true,
      Licenseplatenumbervalue1: "",
      LicenseplatenumberisShow1: true
    };
  },
  watch: {},
  methods: {
    async resetFiltersAndRefreshList() {
      // 清空过滤条件
      this.Licenseplatenumbervalue1 = "";
      this.Recentaccesstoparkinglotvalue1 = undefined;
      this.RecentEntryTimevalue1 = [];
      this.Recentappearancetimevalue1 = [];
      this.Typeoflicenseplatevalue1 = undefined;
      this.VehicleListcurrent2 = 1

      // 刷新车辆列表
      await this.queryVehicleList();
    },
    // 导出
    async exportVehicleData() {
      const selectedIds = this.VehicleListselectedRows1.map(row => row.id);
      const current = this.VehicleListcurrent2;
      const pageSize = this.VehicleListpageSize1;
      // const response = await this.executeBackendInterface('exportVehicleList', {
      // const response = await this.executeBackendInterface('./Vehiclemanagement/exportVehicleList', {
      //   selectedIds: selectedIds.length ? selectedIds : undefined,
      //   current,
      //   pageSize
      // });

      const params =
        selectedIds.length > 0
          ? {
              selectedIds: selectedIds.length ? selectedIds : undefined,
              current: this.VehicleListcurrent2,
              pageSize: this.VehicleListpageSize1,
            }
          : {
            licensePlateNumber: this.Licenseplatenumbervalue1,
            licensePlateType: this.Typeoflicenseplatevalue1,
            recentEntryTime: this.RecentEntryTimevalue1.join(','),
            recentExitTime: this.Recentappearancetimevalue1.join(','),
            recentAccessToParkingLot: this.Recentaccesstoparkinglotvalue1,
            current: this.VehicleListcurrent2,
            pageSize: this.VehicleListpageSize1
            }

      const response = await this.executeBackendInterface(
        selectedIds.length > 0 ? './Vehiclemanagement/exportVehicleList' : './Vehiclemanagement/getVehicleList',
        params
      );
      if (response.flag) {
        // const fileName = `${new Date().toISOString()}-APP用户列表.xlsx`;
        // 处理导出文件逻辑
        // message.success(`导出成功: ${fileName}`);
        message.success(`导出成功`);
        console.log("🚀 ~ handleExportClick ~ response:", response)
        if (!response.data || response.data.length === 0) return message.error('暂无数据，导出失败');
        // let originalData = response.data;
        let originalData = selectedIds.length > 0 ? response.data : response.data.data
        let data = [
          ['序号', '车牌号', '车牌类型', '最近入场时间', '最近出场时间', '最近出入停车场'],  
          // ['test', 'aaa', '156', 'ad456', 'cb456', '2024-10-15 16:50:52'],  
        ]
        console.log("🚀 ~ handleExportClick ~ data:", data)

        originalData.forEach(item => {
          data.push([
            // item.serial_number, // 序号
            item.row_index, // 序号
            item.license_plate_number,      // 车牌号
            item.license_plate_type,   // 车牌类型
            item.last_entry_time, // 最近入场时间
            item.last_exit_time, // 最近出场时间
            item.last_parking_lot, // 最近出入停车场
          ]);
        });

        // 创建一个工作簿
        const ws = XLSX.utils.aoa_to_sheet(data);
        const wb = XLSX.utils.book_new();

        // 将工作表添加到工作簿
        XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

        // 生成Excel文件并触发下载
        const wbout = XLSX.write(wb, { bookType: 'xlsx', type: 'array' });  
        const blob = new Blob([wbout], { type: 'application/octet-stream' });  

        let fileName = this.getCurrentDateTime() + '-车辆管理列表.xlsx'
        console.log("🚀 ~ handleExportClick ~ fileName:", fileName)
        console.log("🚀 ~ handleExportClick ~ this.getCurrentDateTime():", JSON.stringify(this.getCurrentDateTime()))
        saveAs(blob, fileName);
        // saveAs(blob, '导出数据.xlsx');
      } else {
        message.error(`导出失败: ${response.message}`);
      }
    },
    async queryVehicleList(type) {
      // 查询 操作
      if (type === 'search') {
          this.VehicleListcurrent2 = 1
        }
      // const response = await this.executeBackendInterface('getVehicleList', {
      const response = await this.executeBackendInterface('./Vehiclemanagement/getVehicleList', {
        licensePlateNumber: this.Licenseplatenumbervalue1,
        licensePlateType: this.Typeoflicenseplatevalue1,
        recentEntryTime: this.RecentEntryTimevalue1.join(','),
        recentExitTime: this.Recentappearancetimevalue1.join(','),
        recentAccessToParkingLot: this.Recentaccesstoparkinglotvalue1,
        current: this.VehicleListcurrent2,
        pageSize: this.VehicleListpageSize1
      });
      if (response.flag) {
        this.VehicleListdata1.dataSource = response.data.data.map(item => ({
          id: item.id,
          row_index: item.row_index,
          serialNumber: item.serialNumber,
          licenseplatenumber: item.license_plate_number,
          typeoflicenseplate: item.license_plate_type,
          recentEntryTime: item.last_entry_time,
          recentappearancetime: item.last_exit_time,
          closestaccesstoparkinglot: item.last_parking_lot
        }));
        this.VehicleListtotal1 = response.data.total;
      } else {
        message.error(`查询失败: ${response.message}`);
      }
    },
    async initializeVehicleList() {
      // const response = await this.executeBackendInterface('getAllVehicleEntries', {});
      const response = await this.executeBackendInterface('./Vehiclemanagement/getAllVehicleEntries', {});
      if (response.flag) {
        this.VehicleListdata1.dataSource = response.data.map(item => ({
          id: item.id,
          row_index: item.row_index,
          serialNumber: item.serialNumber,
          licenseplatenumber: item.license_plate_number,
          typeoflicenseplate: item.license_plate_type,
          recentEntryTime: item.last_entry_time,
          recentappearancetime: item.last_exit_time,
          closestaccesstoparkinglot: item.last_parking_lot
        })).sort((a, b) => new Date(b.recentappearancetime) - new Date(a.recentappearancetime));
        this.VehicleListtotal1 = response.data.length;
      } else {
        message.error(`初始化失败: ${response.message}`);
      }
    },
    async paginateVehicleList(pagination) {
      this.VehicleListcurrent2 = pagination.current;
      this.VehicleListpageSize1 = pagination.pageSize;
      await this.queryVehicleList();
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285698345631744';
        const response = await axios.get(`./system/permission/getCurrentPageNotShowVariable?pageUuid=${pageUuid}`);
        const variablesArray = response.data; // 后端直接返回变量数组

        if (variablesArray && Array.isArray(variablesArray))
          // 遍历数组，将每个变量设置为true
          variablesArray.forEach(variable => {
            this[variable] = true;
          });
      } catch (error) {
        console.error('获取变量失败:', error);
      }
    },
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios.post(funcName, params, {
        // axios.post('./Vehiclemanagement/' + funcName, params, {
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => {
          resolve(response.data);
        }).catch(error => {
          reject(error);
        });
      });
    },
    // 最近出入停车场 options 数据
    async getoptionsParkingLot() {
      try {
        const response = await this.executeBackendInterface(
          "./OperationBoard/getYardList",
          {}
        );
        if (response.flag) {
          console.log("🚀 ~ getoptionsParkingLot-最近出入停车场 ~ response:", response)
          if (response.data && response.data.length !== 0) {
            this.Recentaccesstoparkinglotoptions1.dataSource = response.data.map(i => {
              return {
                // value: i.id,
                value: i.parking_lot_name,
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
    // 获取当前时间 年月日时分秒
    getCurrentDateTime() {
      const now = new Date();
      const year = now.getFullYear();
      const month = now.getMonth() + 1; // 月份是从0开始的，所以需要加1
      const day = now.getDate();
      const hours = now.getHours();
      const minutes = now.getMinutes();
      const seconds = now.getSeconds();

      // 返回格式化的时间字符串
      return `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')} ${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
    },
  },
  mounted() {
    loadCss('./css/车辆管理/theme.css');
    // 最近出入停车场 options 数据
    this.getoptionsParkingLot()
    this.queryVehicleList();
    // this.initializeVehicleList();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {}
};

</script>
<style lang="less">

.webVueAntYtSpanStyle-rz{
opacity: 1;
color: #3D3D3D;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 20px;
letter-spacing: 0px;
align-content: center;
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
}
.webVueAntYtSpanStyle-rz span{
text-shadow: 0px 0px 0px transparent;
}
.webVueAntYtSpan {
    display: block;
    height:100%;
    width:100%;
}
.webVueAntYtSpan span{
    word-break: break-all;
    width: auto;
    display: inline-block;
    vertical-align: top; /* 根据需要调整 */
}
.webVueAntYtSpan span:focus{
    outline: none;
}

.webVueAntYtSpanStyle-rzfvc8h{
color: #999999 !important;
}
.webVueAntYtSpanStyle-rzfvc8h span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-rz{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
background: transparent;
border-top-left-radius: 0px;
border-top-right-radius: 0px;
border-bottom-left-radius: 0px;
border-bottom-right-radius: 0px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
}
.webVueAntYtRectangle {
    width: 100%;
    height:100%;

}

.webVueAntYtRectangleStyle-rzvkinb{
background: #ffffff;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-rz{
flex-direction: row;
opacity: 1;
}
.webVueAntYtInputFormItem-rz .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtInputFormItem-rz .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtInputStyle-rz:not(.ant-input-affix-wrapper){
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtInputStyle-rz.ant-input-affix-wrapper{
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtInputStyle-rz.ant-input-affix-wrapper input{
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtInputStyle-rz:not(.ant-input-affix-wrapper)::placeholder,.webVueAntYtInputStyle-rz:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,.webVueAntYtInputStyle-rz input::placeholder,.webVueAntYtInputStyle-rz input::-webkit-input-placeholder{
color: #999999;
}
.webVueAntInputFormItem  {
  flex-wrap: nowrap;
}
.webVueAntInputFormItem ,
.webVueAntinput,
.webVueAntInputFormItem .ant-form-item-control-input,
.webVueAntInputFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-control-input{
  min-height: unset !important;
}
.webVueAntInputFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntInputFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-content:focus{
  outline: none;
}
.webVueAntinput.ant-input-affix-wrapper input {
  background-color: transparent;
}


.webVueAntYtInputFormItem-rz90huh .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-rz90huh .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-rz90huh .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-rzmrs9i:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtButtonStyle-rz{
opacity: 1;
color: #FFFFFF;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #4A90E2;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 0px solid #D9D9D9;
border-right: 0px solid #D9D9D9;
border-bottom: 0px solid #D9D9D9;
border-left: 0px solid #D9D9D9;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 2px;
padding-right: 0px;
padding-bottom: 2px;
padding-left: 0px;
}
.webVueAntYtButtonStyle-rz>span{
line-height: 28px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
text-align: center;
text-align-last: center;
}
.webVueAntButton  {
  width: 100%;
  height:100%;
  display: flex;
}
.webVueAntButton .span:first-child{
  flex: 0 0 8px;
}
.webVueAntButton .yt-button-content{
  display: inline-block;
  flex: 1;
}

.webVueAntButton.ant-btn-loading.center .yt-button-content,
.webVueAntButton.ant-btn-loading.right .yt-button-content,
.webVueAntButton.ant-btn-loading.left .yt-button-content {
  flex: 0 0 auto;
}
.webVueAntButton span:focus{
  outline: none;
}
.webVueAntButton.ant-btn-two-chinese-chars>:not(.anticon) {
  margin-right: 0;
}

.webVueAntYtButtonStyle-rzxtrc8{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-rzxtrc8>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-rz3ujqd{
color: #333333 !important;
background: transparent !important;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-rz3ujqd>span{
letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-rzt110k{
background: #ffffff;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-rzw2sw1{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-rzw2sw1>span{
letter-spacing: 0px !important;
}

.webVueAntYtRangePickerFormItem-rz{
flex-direction: row;
opacity: 1;
}
.webVueAntYtRangePickerFormItem-rz .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
padding-top: 4px;
padding-right: 0px;
padding-bottom: 6px;
padding-left: 0px;
}
.webVueAntYtRangePickerFormItem-rz .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtRangePickerStyle-rz{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
box-shadow: 0px 0px 0px 0px transparent;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtRangePickerStyle-rz.ant-picker:hover{
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
}
.webVueAntYtRangePickerStyle-rz.ant-picker-focused,.webVueAntYtRangePickerStyle-rz.ant-picker:hover{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtRangePickerStyle-rz .ant-picker-input>input{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtRangePickerStyle-rz .ant-picker-input>input::placeholder{
color: #999999;
}
.popup_yt-dm86im17fr3yj-rz.dropdownClassName .ant-picker-panel-container{
background: #ffffff;
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
border-top-left-radius: 2px;
border-top-right-radius: 2px;
border-bottom-left-radius: 2px;
border-bottom-right-radius: 2px;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}
.popup_yt-dm86im17fr3yj-rz.dropdownClassName .ant-picker-panel-container .ant-picker-header,.popup_yt-dm86im17fr3yj-rz.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr th,.popup_yt-dm86im17fr3yj-rz.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr td{
color: #333333;
}
.webVueAntRangePickerFormItem  {
    flex-wrap: nowrap;
}
.webVueAntYtRangePicker,
.webVueAntRangePickerFormItem,
.webVueAntRangePickerFormItem .ant-form-item-control-input,
.webVueAntRangePickerFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
    width: 100%;
    height: 100%;
}
.webVueAntRangePickerFormItem .ant-form-item-control-input{
    min-height: unset !important;
}
.webVueAntRangePickerFormItem .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntRangePickerFormItem .ant-form-item-label label {
    width: 100%;
    height: 100%;
}
.webVueAntRangePickerFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntRangePickerFormItem .ant-form-item-label label .label-content{
    flex: 1;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntRangePickerFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntRangePickerFormItem .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntRangePickerFormItem.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntRangePickerFormItem .ant-form-item-content:focus{
    outline: none;
}
.webVueAntYtRangePicker .ant-picker-dropdown {
    text-align-last: auto;
}


.webVueAntYtRangePickerFormItem-rzaze91 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtRangePickerFormItem-rzaze91 .ant-form-item-label label{
width: 110px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-rzaze91 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtRangePickerStyle-rzvcm47.ant-picker-focused,.webVueAntYtRangePickerStyle-rzvcm47.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtSelectFormItem-rz{
flex-direction: row;
opacity: 1;
}
.webVueAntYtSelectFormItem-rz .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtSelectFormItem-rz .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtSelectStyle-rz .ant-select-selector{
background: #FFFFFF !important;
border-top-left-radius: 4px !important;
border-top-right-radius: 4px !important;
border-bottom-left-radius: 4px !important;
border-bottom-right-radius: 4px !important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px !important;
padding-right: 10px !important;
padding-bottom: 0px !important;
padding-left: 12px !important;
}
.webVueAntYtSelectStyle-rz.ant-select:not(.ant-select-disabled):hover .ant-select-selector,.webVueAntYtSelectStyle-rz.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input) .ant-select-selector{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtSelectStyle-rz .ant-select-selector .ant-select-selection-item{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal !important;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtSelectStyle-rz .ant-select-selector .ant-select-selection-search input{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal !important;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtSelectStyle-rz .ant-select-selector .ant-select-selection-placeholder{
color: #999999;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popup_yt-rftarm17frhhn-rz.ant-select-dropdown{
border-top-left-radius: 2px !important;
border-top-right-radius: 2px !important;
border-bottom-left-radius: 2px !important;
border-bottom-right-radius: 2px !important;
background: #ffffff !important;
border-top: 1px solid transparent !important;
border-right: 1px solid transparent !important;
border-bottom: 1px solid transparent !important;
border-left: 1px solid transparent !important;
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
padding-top: 0px !important;
padding-right: 0px !important;
padding-bottom: 0px !important;
padding-left: 0px !important;
}
.popup_yt-rftarm17frhhn-rz.ant-select-dropdown .ant-select-item{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popup_yt-rftarm17frhhn-rz.ant-select-dropdown .ant-select-item-option-selected{
background: #E6EFFE;
color: #333333;
}
.popup_yt-rftarm17frhhn-rz.ant-select-dropdown .ant-select-item:hover{
background: #F0F0F0;
color: #333333;
}
.popup_yt-rftarm17frhhn-rz .ant-select-item-option-active:not(.ant-select-item-option-disabled){
background: #F0F0F0;
color: #333333;
}
.webVueSelectFormItem  {
  flex-wrap: nowrap;
}
.webVueSelectFormItem ,
.webVueSelectFormItem .ant-form-item-control-input,
.webVueSelectFormItem .ant-form-item-control-input .ant-form-item-control-input-content,
.webVueSelectFormItem .ant-form-item-control-input  .ant-select-selector .ant-select-selection-search input{
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem .ant-form-item-control-input{
  min-height: unset !important;
}
.webVueSelectFormItem .ant-form-item-control {
  min-width: 0;
}
.webVueSelectFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueSelectFormItem  .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueSelectFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueSelectFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueSelectFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueSelectFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueSelectFormItem .ant-form-item-content:focus{
  outline: none;
}
.webVueSelect.ant-select-single .ant-select-selector .ant-select-selection-placeholder,
.webVueSelect.ant-select-single .ant-select-selector{
  display: flex;
  align-items: center;
}

.webVueSelect {
  width: 100%;
  height:100%;
}
.webVueSelect .ant-select-selector {
  width: 100% !important;
  height: 100% !important;
  overflow: auto;
}

.webVueAntYtSelectFormItem-rzzllyg .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-rzzllyg .ant-form-item-label label{
width: 130px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-rzzllyg .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtRangePickerFormItem-rztizfz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtRangePickerFormItem-rztizfz .ant-form-item-label label{
width: 110px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-rztizfz .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtRangePickerStyle-rzvlkjk.ant-picker-focused,.webVueAntYtRangePickerStyle-rzvlkjk.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtSelectFormItem-rzkynp1 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-rzkynp1 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-rzkynp1 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtTable {
    display: inline-block;
}
.webVueAntYtTable .ant-radio-input {
    display: none;
}
.webVueAntYtTable thead tr th div:first-child {
    display: flex !important;
    align-items: center;
}
.webVueAntYtTable thead tr th:before {
    content: none !important;
}
.webVueAntYtTable thead tr th:not(.ant-table-selection-column), .webVueAntYtTable .ant-table-tbody tr td:not(.ant-table-selection-column) {
    padding: 0 !important;
}
.webVueAntYtTable thead tr th.ant-table-selection-column, .webVueAntYtTable .ant-table-tbody tr td.ant-table-selection-column {
    padding-top: 0 !important;
    padding-bottom: 0 !important;
}
.webVueAntYtTable .ant-table-tbody tr td, .webVueAntYtTable thead tr th {
    position: relative;
}
.webVueAntYtTable .ant-table-tbody tr td .td-text, .webVueAntYtTable thead tr th .th-text {
    width: 100%;
    display: inline-block;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
.webVueAntYtTable tr td .td-text {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntYtTable .ant-table-tbody tr td {
    border-top: 0 !important;
    position: relative !important;
}
.webVueAntYtTable .ant-table-tbody tr td .ant-radio-wrapper {
    align-items: center;
}
.webVueAntYtTable .ant-table-tbody tr:last-child td {
    border-bottom: 0 !important;
}
.webVueAntYtTable .ant-pagination {
    display: flex;
}

.webVueAntYtTable .add-pointer {
    display: flex !important;
}
.webVueAntYtTable .ant-table-thead .ant-table-cell-scrollbar {
    width: 6px;
}
.webVueAntYtTable .ant-table-header colgroup col:not(.ant-table-selection-col) {
    width: auto !important;
}
:focus-visible {
    outline: none;
}
.webVueAntYtTable .ant-table-body::-webkit-scrollbar {
    width: 6px;
    height: 6px;
    border-radius: 2px;
}
.webVueAntYtTable .ant-table-body::-webkit-scrollbar-thumb {
    background-color: #ccc;
}
.webVueAntYtTable.custom-table .ant-table-content {
    overflow: hidden !important;
    max-height: unset !important;
}
.webVueAntYtTable td .customTableTemplate {
    position: absolute !important;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
}
.webVueAntYtTable .ant-table thead tr th:last-of-type,.webVueAntYtTable .ant-table .ant-table-tbody tr td:last-of-type {
   border-right: 0 !important; 
}

.webVueAntYtTableStyle-rzi2fly{
opacity: 1;
}
.webVueAntYtTableStyle-rzi2fly .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-rzi2fly .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-thead tr th div:first-child{
height: 48px;
}
.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 48px;
}
.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-thead tr th{
background: #EAEEF3;
}
.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: bold;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tbody tr td{
height: 48px;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 48px;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-rzi2fly .ant-table thead tr th,.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-rzi2fly .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-rzi2fly .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-rzi2fly.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-rzi2fly.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-rzi2fly .ant-pagination button,.webVueAntYtTableStyle-rzi2fly .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-rzi2fly .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination button,.webVueAntYtTableStyle-rzi2fly .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-rzi2fly .ant-pagination li input,.webVueAntYtTableStyle-rzi2fly .ant-pagination li a,.webVueAntYtTableStyle-rzi2fly .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-rzi2fly .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-rzi2fly .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li a,.webVueAntYtTableStyle-rzi2fly .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-rzi2fly .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(2), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: 48px !important;
min-width: 48px !important;
max-width: 48px !important;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(3), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 48px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(4), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 48px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(5), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 48px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(6), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 48px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(7) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-rzi2fly tr td:nth-child(7) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-rzi2fly tr > th:nth-child(7), .webVueAntYtTableStyle-rzi2fly .ant-table-body tr.ant-table-measure-row td:nth-child(7){
width: calc((100% - 48px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-rzi2fly{
width: 100%;
}
</style>