<template>
  <yt-grid
    previewType="FitScreen"
    width="1700"
    height="1016"
    background="#F0F2F5"
  >
    <yt-grid-item
      fixedSize="selfAdaption"
      top="4.80000%"
      left="0.10000%"
      bottom="4.30000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="18"
      zIndex="1"
      previewType="FitScreen"
    >
      <div
        ref="ref1"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-wocrktx webVueAntYtRectangleStyle-wo webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="84.00px"
      top="19.10000%"
      left="2.90000%"
      bottom="31.60000%"
      right="14.70000%"
      gridColumnStart="2"
      gridColumnEnd="8"
      gridRowStart="2"
      gridRowEnd="5"
      zIndex="2"
      previewType="FitScreen"
    >
      <span
        ref="ref2"
        class="webVueAntYtSpan webVueAntYtSpanStyle-wo81xp3 webVueAntYtSpanStyle-wo webVueAntYtSpanStyle webVueAntYtSpanBrCount-wo webVueAntYtSpanBrCount"
      >
        <span v-html="'APP用户管理'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="1.70000%"
      bottom="6.30000%"
      right="1.10000%"
      gridColumnStart="3"
      gridColumnEnd="23"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="3"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref4"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-wowef5p webVueAntYtInputFormItem-wo webVueAntYtInputFormItem show-label-wo show-label"
        name="Namevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'姓名：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-woori5f webVueAntYtInputStyle-wo webVueAntYtInputStyle"
          v-model:value="Namevalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <!-- <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="3.00000%"
      bottom="6.30000%"
      right="4.40000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="4"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref5"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-wokrzxi webVueAntYtInputFormItem-wo webVueAntYtInputFormItem show-label-wo show-label"
        name="IdentityCardvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'身份证：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-wo7i33e webVueAntYtInputStyle-wo webVueAntYtInputStyle"
          v-model:value="IdentityCardvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item> -->

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="4.40000%"
      bottom="6.30000%"
      right="3.00000%"
      gridColumnStart="53"
      gridColumnEnd="74"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="5"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref6"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-wo7zq9p webVueAntYtInputFormItem-wo webVueAntYtInputFormItem show-label-wo show-label"
        name="ContactInformationvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'联系方式：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-woc437p webVueAntYtInputStyle-wo webVueAntYtInputStyle"
          v-model:value="ContactInformationvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="3.60000%"
      bottom="13.20000%"
      right="1.10000%"
      gridColumnStart="2"
      gridColumnEnd="23"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="6"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref8"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-wogy1ib webVueAntYtInputFormItem-wo webVueAntYtInputFormItem show-label-wo show-label"
        name="Licenseplatenumbermainvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'车牌号(主)：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-wob7fd6 webVueAntYtInputStyle-wo webVueAntYtInputStyle"
          v-model:value="Licenseplatenumbermainvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="0.20000%"
      bottom="13.20000%"
      right="4.40000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="7"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref9"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-woxaia2 webVueAntYtInputFormItem-wo webVueAntYtInputFormItem show-label-wo show-label"
        name="Licenseplatenumberpairvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'车牌号(副)：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-wod90za webVueAntYtInputStyle-wo webVueAntYtInputStyle"
          v-model:value="Licenseplatenumberpairvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="8.20000%"
      bottom="13.20000%"
      right="16.40000%"
      gridColumnStart="90"
      gridColumnEnd="95"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="8"
      previewType="FitScreen"
    >
      <a-button
        ref="ref10"
        @click="
          () => {
            handleSearchClick('search')
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-woxnhic webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
        :loading="Query1loading1"
      >
        <span class="yt-button-content" v-html="'查询'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.60000%"
      left="0.10000%"
      bottom="1.10000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="19"
      gridRowEnd="100"
      zIndex="9"
      previewType="FitScreen"
    >
      <div
        ref="ref14"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-wo79lga webVueAntYtRectangleStyle-wo webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.90000%"
      left="7.00000%"
      bottom="19.20000%"
      right="17.60000%"
      gridColumnStart="3"
      gridColumnEnd="8"
      gridRowStart="21"
      gridRowEnd="25"
      zIndex="11"
      previewType="FitScreen"
    >
      <a-button
        ref="ref15"
        @click="
          () => {
            handleExportClick()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-wo98ann webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
        :loading="Exportloading1"
      >
        <span class="yt-button-content" v-html="'导出'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.90000%"
      left="5.80000%"
      bottom="19.20000%"
      right="18.80000%"
      gridColumnStart="12"
      gridColumnEnd="17"
      gridRowStart="21"
      gridRowEnd="25"
      zIndex="12"
      previewType="FitScreen"
    >
      <a-button
        ref="ref16"
        @click="
          () => {
            handleDeactivateClick()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-wovcdep webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
        :loading="Deactivateloading1"
      >
        <span class="yt-button-content" v-html="'停用'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="1.10000%"
      bottom="6.30000%"
      right="1.70000%"
      gridColumnStart="79"
      gridColumnEnd="99"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="13"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref619"
        class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-wodwhq6 webVueAntYtRangePickerFormItem-wo webVueAntYtRangePickerFormItem show-label-wo show-label"
        name="Creationtimevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'创建时间：'"> </span>
          </div>
        </template>
        <yt-custom-range-picker
          data-event
          class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-woz77r6 webVueAntYtRangePickerStyle-wo webVueAntYtRangePickerStyle"
          popupKey='"popup_yt-72xttm17oh3zp" "popupKeyId"'
          v-model:value="Creationtimevalue1"
          :allowClear="true"
          :mode="'second'"
          :showTime="true"
        >
        </yt-custom-range-picker>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="ParkingusersisShow1"
      top="0.90000%"
      left="0.30000%"
      bottom="0.40000%"
      right="0.30000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="25"
      gridRowEnd="97"
      zIndex="14"
      previewType="FitScreen"
    >
      <yt-table
        ref="ref20"
        @click="
          () => {
            initParkingUsersTable()
            handleTableChange()
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-wo58xh4 webVueAntYtTableStyle-wo webVueAntYtTableStyle"
        :selectType="'checkbox'"
        v-model:selectedRows="ParkingusersselectedRows1"
        v-model:total="Parkinguserstotal1"
        v-model:current="Parkinguserscurrent2"
        v-model:pageSize="ParkinguserspageSize1"
        :columns="Parkingusersdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="Parkingusersdata1.dataSource"
        :scroll="{ y: 609.0000256580912 }"
        @onTableChange="handleSearchClick"
        >
        <!-- @onTableChange="refreshTableData" -->
        <template #cell="{ column, record }">
          <template
            v-if="column.dataIndex === 'operation'"
            :forKey="'operation'"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <!-- <yt-grid-item v-if="record.status === '停用'" fixedSize='selfAdaption' top="0.30000%" left="5.20000%" bottom="0.30000%" right="3.00000%" gridColumnStart="52" gridColumnEnd="68" gridRowStart="16" gridRowEnd="86" zIndex="1" previewType="AdaptiveWH"> -->
              <yt-grid-item
                v-if="record.status === '停用'"
                fixedSize="selfAdaption"
                top="0.30000%"
                left="5.20000%"
                bottom="0.30000%"
                right="3.00000%"
                gridColumnStart="66"
                gridColumnEnd="68"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref37"
                  @click="
                    () => {
                      handleRowEnableClick(record)
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wofwj08 webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
                  :loading="Enableloading1"
                >
                  <span class="yt-button-content" v-html="'启用'"> </span>
                </a-button>
              </yt-grid-item>

              <!-- <yt-grid-item v-if="record.status === '启用'" fixedSize='selfAdaption' top="0.30000%" left="3.20000%" bottom="0.30000%" right="4.90000%" gridColumnStart="78" gridColumnEnd="94" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH"> -->
              <yt-grid-item
                v-if="record.status === '启用'"
                fixedSize="selfAdaption"
                top="0.30000%"
                left="5.20000%"
                bottom="0.30000%"
                right="3.00000%"
                gridColumnStart="66"
                gridColumnEnd="68"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref38"
                  @click="
                    () => {
                      handleRowDeactivateClick(record)
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wok2909 webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
                  :loading="Deactivateloading2"
                >
                  <span class="yt-button-content" v-html="'停用'"> </span>
                  <!-- {{record.status}} -->
                </a-button>
              </yt-grid-item>

              <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.70000%" bottom="0.30000%" right="1.90000%" gridColumnStart="9" gridColumnEnd="42" gridRowStart="16" gridRowEnd="86" zIndex="3" previewType="AdaptiveWH"> -->
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.30000%"
                left="0.70000%"
                bottom="0.30000%"
                right="1.90000%"
                gridColumnStart="19"
                gridColumnEnd="42"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref618"
                  @click="
                    () => {
                      handleOrderDetailsClick(record)
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wonamoa webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
                  :loading="OrderDetails1loading1"
                >
                  <span class="yt-button-content" v-html="'订单明细'"> </span>
                </a-button>
              </yt-grid-item>
            </yt-grid>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="3.00000%"
      bottom="6.30000%"
      right="4.40000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="4"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref21"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-woiioh6 webVueAntYtSelectFormItem-wo webVueAntYtSelectFormItem show-label-wo show-label"
        name="Statusvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'状态：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-wo webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-eitqum17pnwcp" "popupKeyId"'
          :showArrow="true"
          v-model:value="Statusvalue1"
          :allowClear="true"
          :placeholder="'请输入'"
          :mode="'single'"
          :options="[
            { label: '启用', value: '启用', disabled: false, select: false },
            { label: '停用', value: '停用', disabled: false, select: false },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <!-- <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="4.40000%"
      bottom="13.20000%"
      right="3.00000%"
      gridColumnStart="53"
      gridColumnEnd="74"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="15"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref21"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-woiioh6 webVueAntYtSelectFormItem-wo webVueAntYtSelectFormItem show-label-wo show-label"
        name="Statusvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'状态：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-wo webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-eitqum17pnwcp" "popupKeyId"'
          :showArrow="true"
          v-model:value="Statusvalue1"
          :allowClear="true"
          :placeholder="'请输入'"
          :mode="'single'"
          :options="[
            { label: '启用', value: '启用', disabled: false, select: false },
            { label: '停用', value: '停用', disabled: false, select: false },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item> -->

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.90000%"
      left="16.40000%"
      bottom="19.20000%"
      right="8.20000%"
      gridColumnStart="7"
      gridColumnEnd="12"
      gridRowStart="21"
      gridRowEnd="25"
      zIndex="16"
      previewType="FitScreen"
    >
      <a-button
        ref="ref26"
        @click="
          () => {
            handleEnableClick()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-woaktkn webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
        :loading="Enableloading2"
      >
        <span class="yt-button-content" v-html="'启用'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="17.60000%"
      bottom="13.20000%"
      right="7.00000%"
      gridColumnStart="94"
      gridColumnEnd="99"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="10"
      previewType="FitScreen"
    >
      <a-button
        ref="ref12"
        @click="
          () => {
            handleResetClick()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-woh7nt2 webVueAntYtButtonStyle-wo webVueAntYtButtonStyle center-wo center"
        :loading="Resetloading1"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrderDetailsisShow1"
      top="0.40000%"
      left="0.30000%"
      bottom="1.10000%"
      right="0.00000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="18"
      gridRowEnd="86"
      zIndex="17"
      previewType="FitScreen"
    >
      <yt-custom-modal
        ref="ref40"
        class="webVueAntYtModal webVueAntYtModalStyle-wo8hicj webVueAntYtModalStyle-wo webVueAntYtModalStyle"
        v-model:isShow="OrderDetailsisShow1"
        :title="'订单明细'"
        :showFooter="false"
        :maskClosable="true"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="OrderDetailsform1"
            ref="ref40_form"
          >
            <div
              style="
                display: grid;
                width: 112%;
                height: 90%;
                grid-template-columns: repeat(auto-fill, 1%);
                grid-template-rows: repeat(auto-fill, 1%);
                position: relative;
              "
            >
              <yt-grid-item
                fixedSize="selfAdaption"
                marginBottom="-4px"
                top="0.40000%"
                left="0.70000%"
                bottom="0.00000%"
                right="0.50000%"
                gridColumnStart="1"
                gridColumnEnd="101"
                gridRowStart="2"
                gridRowEnd="101"
                zIndex="1"
                previewType="FitScreen"
              >
                <yt-table
                  ref="ref615"
                  class="webVueAntYtTable webVueAntYtTableStyle-wour12h webVueAntYtTableStyle-wo webVueAntYtTableStyle ddmx"
                  :canSelect="false"
                  v-model:selectedRows="UserOrdersselectedRows1"
                  v-model:total="UserOrderstotal1"
                  v-model:current="UserOrderscurrent2"
                  v-model:pageSize="UserOrderspageSize1"
                  :columns="UserOrdersdata1.columns"
                  :showSizeChanger="true"
                  :showQuickJumper="true"
                  :dataSource="UserOrdersdata1.dataSource"
                  :scroll="{ y: 492.9999578285365 }"
                  @onTableChange="
                    () => {
                      refreshTableData()
                    }
                  "
                >
                  <template #cell="{ column, record }"> </template>
                </yt-table>
              </yt-grid-item>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>
  </yt-grid>
</template>

<script>
import XLSX from 'xlsx'
import { saveAs } from 'file-saver'
import { loadCss } from '../shared/loadTheme'
import axios from 'axios'
import { message, Modal } from 'ant-design-vue'
import { h } from 'vue'
export default {
  data() {
    return {
      ParkinguserscurrentRow1: {},
      ParkingusersselectedRows1: [],
      ParkinguserspageSize1: 10,
      Parkingusersdata1: {
        columns: [
          // {
          //   key: "id",
          //   title: "序号",
          //   dataIndex: "id"
          // },
          {
            key: 'row_index',
            title: '序号',
            dataIndex: 'row_index',
          },
          // {
          //   key: "no",
          //   title: "编号",
          //   dataIndex: "no"
          // },
          {
            key: 'name1',
            title: '姓名',
            dataIndex: 'name1',
          },
          {
            key: 'contactInformation',
            title: '联系方式',
            dataIndex: 'contactInformation',
          },
          {
            key: 'licenseplatenumbermain',
            title: '车牌号（主）',
            dataIndex: 'licenseplatenumbermain',
          },
          {
            key: 'licenseplatenumberpair',
            title: '车牌号（副）',
            dataIndex: 'licenseplatenumberpair',
          },
          {
            key: 'creationtime',
            title: '创建时间',
            dataIndex: 'creationtime',
          },
          {
            key: 'status',
            title: '状态',
            dataIndex: 'status',
          },
          {
            key: 'operation',
            title: '操作',
            dataIndex: 'operation',
            cellType: 'slot',
          },
        ],
        dataSource: [],
      },
      Parkinguserscurrent2: 1,
      Parkinguserstotal1: 10,
      ParkingusersisShow1: true,
      Licenseplatenumberpairvalue1: '',
      ContactInformationvalue1: '',
      Enableloading1: false,
      Enableloading2: false,
      Licenseplatenumbermainvalue1: '',
      Statusvalue1: undefined,
      Deactivateloading2: false,
      Resetloading1: false,
      IdentityCardvalue1: '',
      OrderDetails1loading1: false,
      Query1loading1: false,
      Exportloading1: false,
      Deactivateloading1: false,
      Creationtimevalue1: [],
      // Creationtimevalue1: "2024-09-18 18:22:14",
      Namevalue1: '',
      UserOrderscurrentRow1: {},
      UserOrdersselectedRows1: [],
      UserOrderspageSize1: 10,
      UserOrdersdata1: {
        columns: [
          {
            key: 'id',
            title: 'id',
            dataIndex: 'id',
          },
          {
            key: 'orderNumber',
            title: '订单编号',
            dataIndex: 'orderNumber',
          },
          {
            key: 'licenseplatenumber',
            title: '车牌号',
            dataIndex: 'licenseplatenumber',
          },
          {
            key: 'parking',
            title: '停车场',
            dataIndex: 'parking',
          },
          {
            key: 'orderStatus',
            title: '订单状态',
            dataIndex: 'orderStatus',
          },
          {
            key: 'paymentStatus',
            title: '支付状态',
            dataIndex: 'paymentStatus',
          },
          {
            key: 'driveintime',
            title: '驶入时间',
            dataIndex: 'driveintime',
          },
          {
            key: 'departureTime',
            title: '驶出时间',
            dataIndex: 'departureTime',
          },
          {
            key: 'parkingduration',
            title: '停车时长',
            dataIndex: 'parkingduration',
          },
          {
            key: 'orderAmount',
            title: '订单金额',
            dataIndex: 'orderAmount',
          },
          {
            key: 'preferentialamount',
            title: '优惠金额',
            dataIndex: 'preferentialamount',
          },
          {
            key: 'amountreceivable',
            title: '应收金额',
            dataIndex: 'amountreceivable',
          },
          {
            key: 'paidinamount',
            title: '实收金额',
            dataIndex: 'paidinamount',
          },
          {
            key: 'refundamount',
            title: '退款金额',
            dataIndex: 'refundamount',
          },
          {
            key: 'paymentchannel',
            title: '支付渠道',
            dataIndex: 'paymentchannel',
          },
          {
            key: 'preferentialchannels',
            title: '优惠渠道',
            dataIndex: 'preferentialchannels',
          },
          {
            key: 'feecollectingpersonnel',
            title: '收费人员',
            dataIndex: 'feecollectingpersonnel',
          },
        ],
        dataSource: [
          {
            id: 1,
            orderNumber: '20240918',
            licenseplatenumber: '浙A·123456',
            typeoflicenseplate: '蓝牌',
            parking: '永宁路停车场',
            orderStatus: '正常',
            paymentchannel: '线上支付',
            preferentialchannels: '抵扣额',
            operation: '',
            paymentStatus: '支付中',
          },
          {
            id: 2,
            orderNumber: '20240919',
            licenseplatenumber: '',
            typeoflicenseplate: '绿牌',
            parking: 'XXX停车场',
            orderStatus: '异常',
            paymentchannel: '线下缴费',
            preferentialchannels: '岗亭减免',
            paymentStatus: '已支付',
          },
          {
            id: 0,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '黄牌',
            parking: '',
            orderStatus: '关闭',
            paymentchannel: '代金券',
            preferentialchannels: '优惠券',
            paymentStatus: '待支付',
          },
          {
            id: 4,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '黑牌 ',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
            paymentStatus: '已支付，已退款',
          },
          {
            id: 3,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '白牌',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
          {
            id: 5,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '黄绿',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
          {
            id: 9,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
          {
            id: 8,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
          {
            id: 7,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
          {
            id: 6,
            orderNumber: '',
            licenseplatenumber: '',
            typeoflicenseplate: '',
            parking: '',
            orderStatus: '',
            paymentchannel: '',
            preferentialchannels: '',
          },
        ],
      },
      UserOrderscurrent2: 1,
      UserOrderstotal1: 10,
      OrderDetailsisShow1: false,
      OrderDetailsform1: {
        id: null,
      },
    }
  },
  watch: {},
  methods: {
    async handleExportClick() {
      try {
        const selectedIds = this.ParkingusersselectedRows1.map((row) => row.id)
        // const params = {
        //   selectedIds: selectedIds.length ? selectedIds : undefined,
        //   current: this.Parkinguserscurrent2,
        //   pageSize: this.ParkinguserspageSize1,
        // }

        const params =
          selectedIds.length > 0
            ? {
                selectedIds: selectedIds.length ? selectedIds : undefined,
                current: this.Parkinguserscurrent2,
                pageSize: this.ParkinguserspageSize1,
              }
            : {
                name: this.Namevalue1,
                identityCard: this.IdentityCardvalue1,
                contact: this.ContactInformationvalue1,
                mainLicensePlate: this.Licenseplatenumbermainvalue1,
                secondaryLicensePlate: this.Licenseplatenumberpairvalue1,
                status: this.Statusvalue1,
                creationTime: this.Creationtimevalue1,
                current: this.Parkinguserscurrent2,
                pageSize: this.ParkinguserspageSize1,
              }

        const response = await this.executeBackendInterface(
          selectedIds.length > 0 ? 'exportParkingUsers' : 'searchParkingUsers',
          // 'exportParkingUsers',
          params
        )
        if (response.flag) {
          message.success('导出成功')
          // 处理导出文件的下载逻辑
          console.log('🚀 ~ handleExportClick ~ response:', response)
          if (!response.data || response.data.length === 0)
            return message.error('暂无数据，导出失败')
          // let originalData = response.data
          let originalData = selectedIds.length > 0 ? response.data : response.data.data
          let data = [
            [
              '编号',
              '姓名',
              '联系方式',
              '车牌号（主）',
              '车牌号（副）',
              '创建时间',
              '状态',
            ],
            // ['test', 'aaa', '156', 'ad456', 'cb456', '2024-10-15 16:50:52', 'status'],
          ]
          console.log('🚀 ~ handleExportClick ~ data:', data)

          originalData.forEach((item) => {
            data.push([
              // item.user_code, // 编号
              // item.id, // 编号
              item.row_index, // 编号
              item.name, // 姓名
              item.contact, // 联系方式
              item.main_license_plate, // 车牌号（主）
              item.secondary_license_plate, // 车牌号（副）
              item.created_at, // 创建时间
              item.status, // 状态
            ])
          })

          // 创建一个工作簿
          const ws = XLSX.utils.aoa_to_sheet(data)
          const wb = XLSX.utils.book_new()

          // 将工作表添加到工作簿
          XLSX.utils.book_append_sheet(wb, ws, 'Sheet1')

          // 生成Excel文件并触发下载
          const wbout = XLSX.write(wb, { bookType: 'xlsx', type: 'array' })
          const blob = new Blob([wbout], { type: 'application/octet-stream' })

          let fileName = this.getCurrentDateTime() + '-APP用户列表.xlsx'
          console.log('🚀 ~ handleExportClick ~ fileName:', fileName)
          console.log(
            '🚀 ~ handleExportClick ~ this.getCurrentDateTime():',
            JSON.stringify(this.getCurrentDateTime())
          )
          saveAs(blob, fileName)
          // saveAs(blob, '导出数据.xlsx');
        } else {
          message.error(response.message || '导出失败')
        }
      } catch (error) {
        message.error('导出失败')
      }
    },
    async handleDeactivateClick() {
      if (!this.ParkingusersselectedRows1.length) {
        message.warning('请选择至少一行')
        return
      }
      Modal.confirm({
        title: '确认停用',
        content: '确定要停用选中的用户吗？',
        onOk: async () => {
          try {
            const selectedIds = this.ParkingusersselectedRows1.map(
              (row) => row.id
            )
            const response = await this.executeBackendInterface(
              'deactivateParkingUsers',
              {
                selectedIds,
              }
            )
            if (response.flag) {
              message.success('停用成功')
              await this.initParkingUsersTable()
            } else {
              message.error(response.message || '停用失败')
            }
          } catch (error) {
            message.error('停用失败')
          }
        },
      })
    },
    async handleSearchClick(type) {

      try {
        // 查询 操作
        if (type === 'search') {
          this.Parkinguserscurrent2 = 1
        }
        const params = {
          name: this.Namevalue1,
          identityCard: this.IdentityCardvalue1,
          contact: this.ContactInformationvalue1,
          mainLicensePlate: this.Licenseplatenumbermainvalue1,
          secondaryLicensePlate: this.Licenseplatenumberpairvalue1,
          status: this.Statusvalue1,
          creationTime: this.Creationtimevalue1,
          current: this.Parkinguserscurrent2,
          pageSize: this.ParkinguserspageSize1,
        }
        const response = await this.executeBackendInterface(
          'searchParkingUsers',
          params
        )
        if (response.flag) {
          this.Parkingusersdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              row_index: item.row_index,
              no: item.user_code,
              name1: item.name,
              contactInformation: item.contact,
              licenseplatenumbermain: item.main_license_plate,
              licenseplatenumberpair: item.secondary_license_plate,
              creationtime: item.created_at,
              status: item.status,
            })
          )
          this.Parkinguserstotal1 = response.data.total
        } else {
          message.error(response.message || '查询失败')
        }
      } catch (error) {
        message.error('查询失败')
      }
    },
    async initParkingUsersTable() {
      try {
        const params = {
          current: this.Parkinguserscurrent2,
          pageSize: this.ParkinguserspageSize1,
        }
        const response = await this.executeBackendInterface(
          'getParkingUsers',
          params
        )
        if (response.flag) {
          this.Parkingusersdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              row_index: item.row_index,
              no: item.user_code,
              name1: item.name,
              contactInformation: item.contact,
              licenseplatenumbermain: item.main_license_plate,
              licenseplatenumberpair: item.secondary_license_plate,
              creationtime: item.created_at,
              status: item.status,
            })
          )
          this.Parkinguserstotal1 = response.data.total
        } else {
          message.error(response.message || '初始化失败')
        }
      } catch (error) {
        message.error('初始化失败')
      }
    },
    async handleTableChange(pagination) {
      this.Parkinguserscurrent2 = pagination.current
      this.ParkinguserspageSize1 = pagination.pageSize
      await this.initParkingUsersTable()
    },
    async handleEnableClick() {
      if (!this.ParkingusersselectedRows1.length) {
        message.warning('请选择至少一行')
        return
      }
      Modal.confirm({
        title: '确认启用',
        content: '确定要启用选中的用户吗？',
        onOk: async () => {
          try {
            const selectedIds = this.ParkingusersselectedRows1.map(
              (row) => row.id
            )
            const response = await this.executeBackendInterface(
              'enableParkingUsers',
              {
                selectedIds,
              }
            )
            if (response.flag) {
              message.success('启用成功')
              await this.initParkingUsersTable()
            } else {
              message.error(response.message || '启用失败')
            }
          } catch (error) {
            message.error('启用失败')
          }
        },
      })
    },
    async handleResetClick() {
      console.log('Reset')
      console.log(
        'this.ContactInformationvalue1',
        this.ContactInformationvalue1
      )
      this.Namevalue1 = ''
      this.IdentityCardvalue1 = ''
      this.ContactInformationvalue1 = ''
      // this.Creationtimevalue1 = '';
      this.Creationtimevalue1 = []
      this.Licenseplatenumbermainvalue1 = ''
      this.Licenseplatenumberpairvalue1 = ''
      this.Statusvalue1 = undefined
      this.Parkinguserscurrent2 = 1
      await this.handleSearchClick()
      // await this.initParkingUsersTable()
    },
    // 订单明细
    async handleOrderDetailsClick(record) {
      this.OrderDetailsisShow1 = true
      const mainLicensePlate = record.licenseplatenumbermain || ''
      const secondaryLicensePlate = record.licenseplatenumberpair || ''
      try {
        const response = await this.executeBackendInterface(
          'getParkingOrderDetails',
          {
            current: this.UserOrderscurrent2,
            pageSize: this.UserOrderspageSize1,
            mainLicensePlate,
            secondaryLicensePlate,
          }
        )
        if (response.flag) {
          const data = response.data.data.map((item) => ({
            id: item.id,
            orderNumber: item.order_code,
            licenseplatenumber: item.license_plate,
            parking: item.parking_lot,
            orderStatus: item.order_status,
            paymentStatus: item.payment_status,
            driveintime: item.entry_time,
            departureTime: item.exit_time,
            parkingduration: item.parking_duration,
            orderAmount: item.order_amount,
            preferentialamount: item.discount_amount,
            amountreceivable: item.receivable_amount,
            paidinamount: item.received_amount,
            refundamount: item.refund_amount,
            paymentchannel: item.payment_channel,
            preferentialchannels: item.discount_channel,
            feecollectingpersonnel: item.cashier,
          }))
          this.UserOrdersdata1.dataSource = data
          this.UserOrderstotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('获取订单详情失败')
      }
    },
    async handleRowEnableClick(record) {
      Modal.confirm({
        title: '确认启用',
        content: '您确定要启用该用户吗？',
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface(
              'enableParkingUser',
              {
                id: record.id,
              }
            )
            if (response.flag) {
              record.status = '启用'
              message.success('用户已启用')
              await this.refreshTableData()
            } else {
              message.error(response.message || '启用失败')
            }
          } catch (error) {
            message.error('请求失败，请重试')
          }
        },
        onCancel: () => {},
      })
    },
    async refreshTableData() {
      console.log('🚀 ~ refreshTableData ~ refreshTableData:')
      // debugger
      try {
        const response = await this.executeBackendInterface(
          'getParkingUsersJK1',
          {
            current: this.Parkinguserscurrent2,
            pageSize: this.ParkinguserspageSize1,
          }
        )
        if (response.flag) {
          this.Parkingusersdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              row_index: item.row_index,
              no: item.user_code,
              name1: item.name,
              contactInformation: item.contact,
              licenseplatenumbermain: item.main_license_plate,
              licenseplatenumberpair: item.secondary_license_plate,
              creationtime: item.created_at,
              status: item.status,
            })
          )
          this.Parkinguserstotal1 = response.data.total
        } else {
          message.error(response.message || '刷新数据失败')
        }
      } catch (error) {
        message.error('请求失败，请重试')
      }
    },
    async handleRowDeactivateClick(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认停用',
        content: `确定要停用用户ID为${record.id}的账号吗？`,
        onOk: async () => {
          try {
            // 调用后端接口停用用户
            const response = await this.executeBackendInterface(
              'deactivateParkingUser',
              {
                id: record.id,
              }
            )
            if (response.flag) {
              message.success('用户停用成功')
              // 更新当前行的状态为停用
              record.status = '停用'
              // 刷新表格数据
              await this.refreshTableData()
            } else {
              message.error(`停用失败: ${response.message}`)
            }
          } catch (error) {
            message.error('停用过程中发生错误')
          }
        },
        onCancel: () => {
          message.info('取消停用操作')
        },
      })
    },
    async refreshTableDataO8Y() {
      try {
        // 调用后端接口获取最新的表格数据
        const response = await this.executeBackendInterface(
          'getParkingUsersE6W',
          {
            current: this.Parkinguserscurrent2,
            pageSize: this.ParkinguserspageSize1,
          }
        )
        if (response.flag) {
          // 更新表格数据
          this.Parkingusersdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              no: item.id.toString(),
              name1: item.user_name,
              status: item.status === 1 ? '启用' : '停用',
              contactInformation: item.mobile,
            })
          )
          this.Parkinguserstotal1 = response.data.total
        } else {
          message.error(`获取数据失败: ${response.message}`)
        }
      } catch (error) {
        message.error('获取数据过程中发生错误')
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285301862268928'
        const response = await axios.get(
          `./system/permission/getCurrentPageNotShowVariable?pageUuid=${pageUuid}`
        )
        const variablesArray = response.data // 后端直接返回变量数组

        if (variablesArray && Array.isArray(variablesArray))
          // 遍历数组，将每个变量设置为true
          variablesArray.forEach((variable) => {
            this[variable] = true
          })
      } catch (error) {
        console.error('获取变量失败:', error)
      }
    },
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params)
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios
          .post('./Appusermanagement/' + funcName, params, {
            headers: {
              'Content-Type': 'application/json',
            },
          })
          .then((response) => {
            resolve(response.data)
          })
          .catch((error) => {
            reject(error)
          })
      })
    },
    // 获取当前时间 年月日时分秒
    getCurrentDateTime() {
      const now = new Date()
      const year = now.getFullYear()
      const month = now.getMonth() + 1 // 月份是从0开始的，所以需要加1
      const day = now.getDate()
      const hours = now.getHours()
      const minutes = now.getMinutes()
      const seconds = now.getSeconds()

      // 返回格式化的时间字符串
      return `${year}-${month.toString().padStart(2, '0')}-${day
        .toString()
        .padStart(2, '0')} ${hours.toString().padStart(2, '0')}:${minutes
        .toString()
        .padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`
    },
  },
  mounted() {
    loadCss('./css/APP用户管理/theme.css')
    this.initParkingUsersTable()
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables()
  },
  computed: {},
}
</script>
<style lang="less">
.webVueAntYtRectangleStyle-wo {
  opacity: 1;
  box-shadow: 0px 0px 0px 0px transparent;
  background: transparent;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
}
.webVueAntYtRectangle {
  width: 100%;
  height: 100%;
}

.webVueAntYtRectangleStyle-wocrktx {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-wo {
  opacity: 1;
  color: #3d3d3d;
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
.webVueAntYtSpanStyle-wo span {
  text-shadow: 0px 0px 0px transparent;
}
.webVueAntYtSpan {
  display: block;
  height: 100%;
  width: 100%;
}
.webVueAntYtSpan span {
  word-break: break-all;
  width: auto;
  display: inline-block;
  vertical-align: top; /* 根据需要调整 */
}
.webVueAntYtSpan span:focus {
  outline: none;
}

.webVueAntYtSpanStyle-wo81xp3 {
  color: #3d3d3d !important;
}
.webVueAntYtSpanStyle-wo81xp3 span {
  text-decoration: none;
}

.webVueAntYtInputFormItem-wo {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-wo .ant-form-item-label label {
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
.webVueAntYtInputFormItem-wo .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-wo:not(.ant-input-affix-wrapper) {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  background: #ffffff;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
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
.webVueAntYtInputStyle-wo.ant-input-affix-wrapper {
  background: #ffffff;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
  box-shadow: 0px 0px 0px 0px transparent;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 12px;
}
.webVueAntYtInputStyle-wo.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-wo:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-wo:not(
    .ant-input-affix-wrapper
  )::-webkit-input-placeholder,
.webVueAntYtInputStyle-wo input::placeholder,
.webVueAntYtInputStyle-wo input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntInputFormItem {
  flex-wrap: nowrap;
}
.webVueAntInputFormItem,
.webVueAntinput,
.webVueAntInputFormItem .ant-form-item-control-input,
.webVueAntInputFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-control-input {
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
.webVueAntInputFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(
    .ant-form-item-required-mark-optional
  ):before {
  margin-top: 4px;
}
.webVueAntInputFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputFormItem
  .ant-form-item-label
  > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueAntinput.ant-input-affix-wrapper input {
  background-color: transparent;
}

.webVueAntYtInputFormItem-wowef5p .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wowef5p .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wowef5p .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-woori5f:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wokrzxi .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wokrzxi .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wokrzxi .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wo7i33e:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wo7zq9p .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wo7zq9p .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-woc437p:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wogy1ib .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wogy1ib .ant-form-item-label label {
  width: 90px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wogy1ib .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wob7fd6:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-woxaia2 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-woxaia2 .ant-form-item-label label {
  width: 90px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-woxaia2 .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wod90za:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-wo {
  opacity: 1;
  color: #ffffff;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  background: #4a90e2;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 0px solid #d9d9d9;
  border-right: 0px solid #d9d9d9;
  border-bottom: 0px solid #d9d9d9;
  border-left: 0px solid #d9d9d9;
  box-shadow: 0px 0px 0px 0px transparent;
  padding-top: 2px;
  padding-right: 0px;
  padding-bottom: 2px;
  padding-left: 0px;
}
.webVueAntYtButtonStyle-wo > span {
  line-height: 28px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  text-align: center;
  text-align-last: center;
}
.webVueAntButton {
  width: 100%;
  height: 100%;
  display: flex;
}
.webVueAntButton .span:first-child {
  flex: 0 0 8px;
}
.webVueAntButton .yt-button-content {
  display: inline-block;
  flex: 1;
}

.webVueAntButton.ant-btn-loading.center .yt-button-content,
.webVueAntButton.ant-btn-loading.right .yt-button-content,
.webVueAntButton.ant-btn-loading.left .yt-button-content {
  flex: 0 0 auto;
}
.webVueAntButton span:focus {
  outline: none;
}
.webVueAntButton.ant-btn-two-chinese-chars > :not(.anticon) {
  margin-right: 0;
}

.webVueAntYtButtonStyle-woxnhic {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-woxnhic > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-wo79lga {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-wo98ann {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wo98ann > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wovcdep {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 1px solid #f84c55;
  border-right: 1px solid #f84c55;
  border-bottom: 1px solid #f84c55;
  border-left: 1px solid #f84c55;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wovcdep > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRangePickerFormItem-wo {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtRangePickerFormItem-wo .ant-form-item-label label {
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
.webVueAntYtRangePickerFormItem-wo .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtRangePickerStyle-wo {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  box-shadow: 0px 0px 0px 0px transparent;
  background: #ffffff;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 12px;
}
.webVueAntYtRangePickerStyle-wo.ant-picker:hover {
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
}
.webVueAntYtRangePickerStyle-wo.ant-picker-focused,
.webVueAntYtRangePickerStyle-wo.ant-picker:hover {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtRangePickerStyle-wo .ant-picker-input > input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtRangePickerStyle-wo .ant-picker-input > input::placeholder {
  color: #999999;
}
.popup_yt-72xttm17oh3zp-wo.dropdownClassName .ant-picker-panel-container {
  background: #ffffff;
  box-shadow: 0px 0px 10px 0px rgba(153, 153, 153, 0.3);
  border-top-left-radius: 2px;
  border-top-right-radius: 2px;
  border-bottom-left-radius: 2px;
  border-bottom-right-radius: 2px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
.popup_yt-72xttm17oh3zp-wo.dropdownClassName
  .ant-picker-panel-container
  .ant-picker-header,
.popup_yt-72xttm17oh3zp-wo.dropdownClassName
  .ant-picker-panel-container
  .ant-picker-panel
  table
  tr
  th,
.popup_yt-72xttm17oh3zp-wo.dropdownClassName
  .ant-picker-panel-container
  .ant-picker-panel
  table
  tr
  td {
  color: #333333;
}
.webVueAntRangePickerFormItem {
  flex-wrap: nowrap;
}
.webVueAntYtRangePicker,
.webVueAntRangePickerFormItem,
.webVueAntRangePickerFormItem .ant-form-item-control-input,
.webVueAntRangePickerFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntRangePickerFormItem .ant-form-item-control-input {
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
.webVueAntRangePickerFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(
    .ant-form-item-required-mark-optional
  ):before {
  margin-top: 4px;
}
.webVueAntRangePickerFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntRangePickerFormItem
  .ant-form-item-label
  > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntRangePickerFormItem
  .ant-form-item-label
  label
  .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntRangePickerFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntRangePickerFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueAntYtRangePicker .ant-picker-dropdown {
  text-align-last: auto;
}

.webVueAntYtRangePickerFormItem-wodwhq6 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtRangePickerFormItem-wodwhq6 .ant-form-item-label label {
  width: 80px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-wodwhq6
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtRangePickerStyle-woz77r6.ant-picker-focused,
.webVueAntYtRangePickerStyle-woz77r6.ant-picker:hover {
  border-right: 1px solid #cdcdcd !important;
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
.webVueAntYtTable thead tr th:not(.ant-table-selection-column),
.webVueAntYtTable .ant-table-tbody tr td:not(.ant-table-selection-column) {
  padding: 0 !important;
}
.webVueAntYtTable thead tr th.ant-table-selection-column,
.webVueAntYtTable .ant-table-tbody tr td.ant-table-selection-column {
  padding-top: 0 !important;
  padding-bottom: 0 !important;
}
.webVueAntYtTable .ant-table-tbody tr td,
.webVueAntYtTable thead tr th {
  position: relative;
}
.webVueAntYtTable .ant-table-tbody tr td .td-text,
.webVueAntYtTable thead tr th .th-text {
  width: 100%;
  display: inline-block;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}
.ddmx .ant-table-tbody tr td .td-text {
  position: static;
  min-width: 110px;
  text-align: center;
  padding: 0 6px;
}
.ddmx .ant-pagination-options-size-changer.ant-select {
  min-width: 100px !important;
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
.webVueAntYtTable .ant-table thead tr th:last-of-type,
.webVueAntYtTable .ant-table .ant-table-tbody tr td:last-of-type {
  border-right: 0 !important;
}

.webVueAntYtTableStyle-wo58xh4 {
  opacity: 1;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table {
  box-shadow: 0px 0px 0px 0px transparent;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table .ant-table-thead tr span.th-text {
  color: #000000a6;
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
.webVueAntYtTableStyle-wo58xh4 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table thead tr th,
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-wo58xh4.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wo58xh4.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-wo58xh4
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-wo58xh4
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wo58xh4 .ant-pagination button,
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li input {
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  background: #ffffff;
  color: #000000a6;
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
.webVueAntYtTableStyle-wo58xh4 .ant-pagination button,
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li input,
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li a,
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li a,
.webVueAntYtTableStyle-wo58xh4
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  color: #000000a6;
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
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-wo58xh4 .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(2),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(3),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(4),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(5) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(5),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(6) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(6),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(7) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(7),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(7) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(8) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(8),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(8) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wo58xh4 tr td:nth-child(9) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wo58xh4 tr > th:nth-child(9),
.webVueAntYtTableStyle-wo58xh4
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(9) {
  width: calc((100% - 48px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wo58xh4 {
  width: 100%;
}

.webVueAntYtSelectFormItem-wo {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtSelectFormItem-wo .ant-form-item-label label {
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
.webVueAntYtSelectFormItem-wo .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtSelectStyle-wo .ant-select-selector {
  background: #ffffff !important;
  border-top-left-radius: 4px !important;
  border-top-right-radius: 4px !important;
  border-bottom-left-radius: 4px !important;
  border-bottom-right-radius: 4px !important;
  border-top: 1px solid #cdcdcd !important;
  border-right: 1px solid #cdcdcd !important;
  border-bottom: 1px solid #cdcdcd !important;
  border-left: 1px solid #cdcdcd !important;
  box-shadow: 0px 0px 0px 0px transparent;
  padding-top: 0px !important;
  padding-right: 10px !important;
  padding-bottom: 0px !important;
  padding-left: 12px !important;
}
.webVueAntYtSelectStyle-wo.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtSelectStyle-wo.ant-select-focused:not(
    .ant-select-disabled
  ).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtSelectStyle-wo .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  line-height: 20px;
}
.webVueAntYtSelectStyle-wo
  .ant-select-selector
  .ant-select-selection-search
  input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-wo
  .ant-select-selector
  .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  line-height: 20px;
}
.ant-select-single:not(.ant-select-customize-input)
  .ant-select-selector::after {
  line-height: 20px;
}
.popup_yt-eitqum17pnwcp-wo.ant-select-dropdown {
  border-top-left-radius: 2px !important;
  border-top-right-radius: 2px !important;
  border-bottom-left-radius: 2px !important;
  border-bottom-right-radius: 2px !important;
  background: #ffffff !important;
  border-top: 1px solid transparent !important;
  border-right: 1px solid transparent !important;
  border-bottom: 1px solid transparent !important;
  border-left: 1px solid transparent !important;
  box-shadow: 0px 0px 10px 0px rgba(153, 153, 153, 0.3);
  padding-top: 0px !important;
  padding-right: 0px !important;
  padding-bottom: 0px !important;
  padding-left: 0px !important;
}
.popup_yt-eitqum17pnwcp-wo.ant-select-dropdown .ant-select-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popup_yt-eitqum17pnwcp-wo.ant-select-dropdown
  .ant-select-item-option-selected {
  background: #e6effe;
  color: #333333;
}
.popup_yt-eitqum17pnwcp-wo.ant-select-dropdown .ant-select-item:hover {
  background: #f0f0f0;
  color: #333333;
}
.popup_yt-eitqum17pnwcp-wo
  .ant-select-item-option-active:not(.ant-select-item-option-disabled) {
  background: #f0f0f0;
  color: #333333;
}
.webVueSelectFormItem {
  flex-wrap: nowrap;
}
.webVueSelectFormItem,
.webVueSelectFormItem .ant-form-item-control-input,
.webVueSelectFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content,
.webVueSelectFormItem
  .ant-form-item-control-input
  .ant-select-selector
  .ant-select-selection-search
  input {
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem .ant-form-item-control-input {
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
.webVueSelectFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(
    .ant-form-item-required-mark-optional
  ):before {
  margin-top: 4px;
}
.webVueSelectFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueSelectFormItem
  .ant-form-item-label
  > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueSelectFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueSelectFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueSelectFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueSelect.ant-select-single
  .ant-select-selector
  .ant-select-selection-placeholder,
.webVueSelect.ant-select-single .ant-select-selector {
  display: flex;
  align-items: center;
}

.webVueSelect {
  width: 100%;
  height: 100%;
}
.webVueSelect .ant-select-selector {
  width: 100% !important;
  height: 100% !important;
  overflow: auto;
}

.webVueAntYtSelectFormItem-woiioh6 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-woiioh6 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-woiioh6 .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle-woaktkn {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-woaktkn > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wofwj08 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wofwj08 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wok2909 {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wok2909 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-woh7nt2 {
  color: #333333 !important;
  background: transparent !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-woh7nt2 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-wo .ant-modal-wrap {
  opacity: 1;
  box-shadow: 0px 0px 0px 0px transparent;
  border-top-left-radius: 6px;
  border-top-right-radius: 6px;
  border-bottom-left-radius: 6px;
  border-bottom-right-radius: 6px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
.webVueAntYtModalStyle-wo .ant-modal-wrap .yt-custom-modal-header {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  padding-top: 12px;
  padding-right: 0px;
  padding-bottom: 12px;
  padding-left: 21px;
}
.webVueAntYtModalStyle-wo.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-wo .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-wo.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtModalStyle-wo8hicj .ant-modal-wrap .yt-custom-modal-header {
  font-size: 16px;
  font-weight: bold;
  padding-left: 20px;
}

.webVueAntYtTableStyle-wour12h {
  opacity: 1;
}
.webVueAntYtTableStyle-wour12h .ant-table {
  box-shadow: 0px 0px 0px 0px transparent;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wour12h .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wour12h .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wour12h .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wour12h .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wour12h .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-wour12h
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-wour12h
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-wour12h .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-wour12h .ant-table .ant-table-thead tr span.th-text {
  color: #000000a6;
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
.webVueAntYtTableStyle-wour12h .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-wour12h .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-wour12h .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wour12h .ant-table thead tr th,
.webVueAntYtTableStyle-wour12h
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-wour12h .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-wour12h
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-wour12h.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wour12h.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wour12h
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-wour12h
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-wour12h .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-wour12h
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-wour12h .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wour12h .ant-pagination button,
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wour12h .ant-pagination li input {
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  background: #ffffff;
  color: #000000a6;
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
.webVueAntYtTableStyle-wour12h .ant-pagination button,
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wour12h .ant-pagination li input,
.webVueAntYtTableStyle-wour12h .ant-pagination li a,
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wour12h .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-wour12h .ant-pagination li a,
.webVueAntYtTableStyle-wour12h
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  color: #000000a6;
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
.webVueAntYtTableStyle-wour12h .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-wour12h .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-wour12h tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(2),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(3),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(4),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(5) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(5),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(6) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(6),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(7) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(7),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(7) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(8) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(8),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(8) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(9) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(9),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(9) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(10)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(10),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(10) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(11)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(11),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(11) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(12)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(12),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(12) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(13) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(13)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(13),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(13) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(14) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(14)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(14),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(14) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(15) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(15)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(15),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(15) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(16) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(16)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(16),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(16) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h tr td:nth-child(17) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wour12h
  tr
  td:nth-child(17)
  div:first-child
  span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wour12h tr > th:nth-child(17),
.webVueAntYtTableStyle-wour12h
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(17) {
  width: calc((100% - 0px) / 16) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wour12h {
  width: 100%;
}

.webVueAntYtButtonStyle-wonamoa {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wonamoa > span {
  letter-spacing: 0px !important;
}
</style>
