<template>
  <yt-grid
    style="height: 925px !important;"
    previewType="FitScreen"
    width="1700"
    height="925"
    background="#F0F2F5"
  >
    <yt-grid-item
      fixedSize="width"
      comWidth="57.00px"
      top="19.10000%"
      left="4.40000%"
      bottom="11.90000%"
      right="11.70000%"
      gridColumnStart="2"
      gridColumnEnd="6"
      gridRowStart="2"
      gridRowEnd="5"
      zIndex="1"
      previewType="FitScreen"
    >
      <span
        ref="ref1"
        class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedgzvf7 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle null-undefined null"
      >
        <span v-html="'停车订单'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="3.40000%"
      left="0.10000%"
      bottom="4.60000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="23"
      zIndex="2"
      previewType="FitScreen"
    >
      <div
        ref="ref2"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinedrrtuv webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
      ></div>
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
        ref="ref3"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined9ms5h webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
        name="Licenseplatenumbervalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'车牌号：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-undefined2q6im webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
          v-model:value="Licenseplatenumbervalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

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
      zIndex="4"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref5"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedqndu5 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
        name="Parkingvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'停车场：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-undefinedfu7lg webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
          v-model:value="Parkingvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="CheckisShow1"
      top="18.80000%"
      left="0.00000%"
      bottom="18.10000%"
      right="5.80000%"
      gridColumnStart="90"
      gridColumnEnd="94"
      gridRowStart="16"
      gridRowEnd="21"
      zIndex="5"
      previewType="FitScreen"
    >
      <a-button
        ref="ref6"
        @click="
          () => {
            searchParkingOrders('search')
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-undefinedpw65g webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
        :loading="Checkloading1"
      >
        <span class="yt-button-content" v-html="'查询'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="ResetisShow1"
      top="1.00000%"
      left="0.00000%"
      bottom="20.10000%"
      right="5.80000%"
      gridColumnStart="95"
      gridColumnEnd="99"
      gridRowStart="17"
      gridRowEnd="21"
      zIndex="6"
      previewType="FitScreen"
    >
      <a-button
        ref="ref7"
        @click="
          () => {
            resetParkingOrderFilters()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-undefinedpwmqc webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
        :loading="Resetloading1"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="1.70000%"
      bottom="13.20000%"
      right="1.10000%"
      gridColumnStart="3"
      gridColumnEnd="23"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="7"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref279"
        class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-undefinedp6lkc webVueAntYtRangePickerFormItem-undefined webVueAntYtRangePickerFormItem show-label-undefined show-label"
        name="Driveintimevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'驶入时间：'"> </span>
          </div>
        </template>
        <yt-custom-range-picker
          data-event
          class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-undefined0dqv3 webVueAntYtRangePickerStyle-undefined webVueAntYtRangePickerStyle"
          popupKey='"popup_yt-jxbr2m17gi3ee" "popupKeyId"'
          :mode="'minute'"
          v-model:value="Driveintimevalue1"
          :allowClear="true"
        >
        </yt-custom-range-picker>
      </a-form-item>
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
      zIndex="8"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref11"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-undefinedq8ota webVueAntYtSelectFormItem-undefined webVueAntYtSelectFormItem show-label-undefined show-label"
        name="OrderStatusvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'订单状态：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-undefined webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-p8pfbm17gi3h2" "popupKeyId"'
          :showArrow="true"
          v-model:value="OrderStatusvalue1"
          :allowClear="true"
          :placeholder="'请选择'"
          :mode="'multiple'"
          :options="[
            { label: '车辆入场', value: '车辆入场', disabled: false, select: false },
            { label: '已支付，待离场', value: '已支付，待离场', disabled: false, select: false },
            { label: '已完结', value: '已完结', disabled: false, select: false },
            { label: '异常', value: '异常', disabled: false, select: false },
            { value: '关闭', label: '关闭', disabled: false, select: false },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="3.00000%"
      bottom="13.20000%"
      right="4.40000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="9"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref280"
        class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-undefinedk2c2a webVueAntYtRangePickerFormItem-undefined webVueAntYtRangePickerFormItem show-label-undefined show-label"
        name="DepartureTimevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'驶出时间：'"> </span>
          </div>
        </template>
        <yt-custom-range-picker
          data-event
          class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-undefined7vwcs webVueAntYtRangePickerStyle-undefined webVueAntYtRangePickerStyle"
          popupKey='"popup_yt-exb3fm17gi3hn" "popupKeyId"'
          v-model:value="DepartureTimevalue1"
          :mode="'minute'"
          :allowClear="true"
        >
        </yt-custom-range-picker>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.10000%"
      left="0.10000%"
      bottom="1.20000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="24"
      gridRowEnd="100"
      zIndex="10"
      previewType="FitScreen"
    >
      <div
        ref="ref14"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefined97qc3 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
      ></div>
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
      zIndex="11"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref15"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-undefined8iyax webVueAntYtSelectFormItem-undefined webVueAntYtSelectFormItem show-label-undefined show-label"
        name="Typeoflicenseplatevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'车牌类型：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-undefined webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-hjmdpm17ip26h" "popupKeyId"'
          :showArrow="true"
          v-model:value="Typeoflicenseplatevalue1"
          :allowClear="true"
          :placeholder="'请选择'"
          :mode="'multiple'"
          :options="[
            { label: '蓝牌', value: '蓝牌', disabled: false, select: false },
            { label: '黄牌', value: '黄牌', disabled: false, select: false },
            { value: '黑牌', label: '黑牌', disabled: false, select: false },
            { value: '黄绿', label: '黄绿', disabled: false, select: false },
            { value: '白牌', label: '白牌', disabled: false, select: false },
            { value: '绿牌', label: '绿牌', disabled: false, select: false },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="7.20000%"
      bottom="13.20000%"
      right="6.70000%"
      gridColumnStart="53"
      gridColumnEnd="66"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="12"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref21"
        class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-undefinedago8u webVueAntYtInputNumberFormItem-undefined webVueAntYtInputNumberFormItem show-label-undefined show-label"
        name="MinimumParkingDurationvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'停车时长：'"> </span>
          </div>
        </template>
        <a-input-number
          data-event
          class="webVueAntInputNumber webVueAntYtInputNumberStyle-undefinedetfhj webVueAntYtInputNumberStyle-undefined webVueAntYtInputNumberStyle"
          v-model:value="MinimumParkingDurationvalue1"
          :placeholder="'请输入'"
          :max="1000"
          :min="0"
          :precision="0"
        >
        </a-input-number>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="11.00000%"
      bottom="13.20000%"
      right="8.00000%"
      gridColumnStart="66"
      gridColumnEnd="74"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="13"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref22"
        class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-undefined3841k webVueAntYtInputNumberFormItem-undefined webVueAntYtInputNumberFormItem hide-label-undefined hide-label"
        name="MaximumParkingDurationvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'停车时长：'"> </span>
          </div>
        </template>
        <a-input-number
          data-event
          class="webVueAntInputNumber webVueAntYtInputNumberStyle-undefinedfihpd webVueAntYtInputNumberStyle-undefined webVueAntYtInputNumberStyle"
          v-model:value="MaximumParkingDurationvalue1"
          :placeholder="'请输入'"
          :max="10000"
          :min="0"
          :precision="0"
        >
        </a-input-number>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="8.00px"
      top="30.30000%"
      left="38.20000%"
      bottom="4.00000%"
      right="38.20000%"
      gridColumnStart="65"
      gridColumnEnd="67"
      gridRowStart="12"
      gridRowEnd="15"
      zIndex="15"
      previewType="FitScreen"
    >
      <span
        ref="ref23"
        class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedt7adn webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle null-undefined null"
      >
        <span v-html="'-'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.00000%"
      left="1.70000%"
      bottom="20.10000%"
      right="1.10000%"
      gridColumnStart="3"
      gridColumnEnd="23"
      gridRowStart="17"
      gridRowEnd="21"
      zIndex="14"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref26"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedd2bra webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
        name="OrderAmountvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'订单金额：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-undefinedtt0t4 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
          v-model:value="OrderAmountvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.00000%"
      left="3.00000%"
      bottom="20.10000%"
      right="4.40000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="17"
      gridRowEnd="21"
      zIndex="16"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref27"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-undefined5rxgn webVueAntYtSelectFormItem-undefined webVueAntYtSelectFormItem show-label-undefined show-label"
        name="paymentchannelvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'支付渠道：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-undefined webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-6rsnqm17jh87v" "popupKeyId"'
          :showArrow="true"
          v-model:value="paymentchannelvalue1"
          :allowClear="true"
          :placeholder="'请选择'"
          :mode="'multiple'"
          :options="[
            {
              value: '线上支付',
              label: '线上支付',
              disabled: false,
              select: false,
            },
            {
              value: '线上支付，提前缴费',
              label: '线上支付，提前缴费',
              disabled: false,
              select: false,
            },
            {
              value: '线下缴费',
              label: '线下缴费',
              disabled: false,
              select: false,
            },
            {
              value: '代金券',
              label: '代金券',
              disabled: false,
              select: false,
            },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.00000%"
      left="4.40000%"
      bottom="20.10000%"
      right="3.00000%"
      gridColumnStart="53"
      gridColumnEnd="74"
      gridRowStart="17"
      gridRowEnd="21"
      zIndex="17"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref28"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-undefinedsu1m6 webVueAntYtSelectFormItem-undefined webVueAntYtSelectFormItem show-label-undefined show-label"
        name="preferentialchannelsvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'优惠渠道：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-undefined webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-kt6urm17jhbgr" "popupKeyId"'
          :showArrow="true"
          v-model:value="preferentialchannelsvalue1"
          :allowClear="true"
          :placeholder="'请选择'"
          :mode="'multiple'"
          :options="[
            {
              label: '抵扣额',
              value: '抵扣额',
              disabled: false,
              select: false,
            },
            {
              label: '岗亭减免',
              value: '岗亭减免',
              disabled: false,
              select: false,
            },
            {
              value: '优惠券',
              label: '优惠券',
              disabled: false,
              select: false,
            },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="ExportisShow1"
      top="17.60000%"
      left="7.00000%"
      bottom="3.60000%"
      right="17.60000%"
      gridColumnStart="3"
      gridColumnEnd="8"
      gridRowStart="25"
      gridRowEnd="29"
      zIndex="18"
      previewType="FitScreen"
    >
      <a-button
        ref="ref30"
        @click="
          () => {
            exportParkingOrders()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-undefined9n6f7 webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
        :loading="Exportloading1"
      >
        <span class="yt-button-content" v-html="'导出'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrderDetailsisShow1"
      top="0.50000%"
      left="1.30000%"
      bottom="0.50000%"
      right="1.30000%"
      gridColumnStart="22"
      gridColumnEnd="80"
      gridRowStart="13"
      gridRowEnd="89"
      zIndex="21"
      previewType="FitScreen"
    >
      <yt-custom-modal
        ref="ref31"
        class="webVueAntYtModal webVueAntYtModalStyle-undefineddz7kq webVueAntYtModalStyle-undefined webVueAntYtModalStyle"
        v-model:isShow="OrderDetailsisShow1"
        :title="'订单详情'"
        :showFooter="false"
        :maskClosable="true"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="OrderDetailsform1"
            ref="ref31_form"
          >
            <div
              style="
                display: grid;
                width: 100%;
                height: 100%;
                grid-template-columns: repeat(auto-fill, 1%);
                grid-template-rows: repeat(auto-fill, 1%);
                position: relative;
              "
            >
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="ParkingOrderMenuisShow1"
                marginLeft="-9px"
                top="0.00000%"
                left="0.00000%"
                bottom="0.00000%"
                right="5.80000%"
                gridColumnStart="1"
                gridColumnEnd="15"
                gridRowStart="1"
                gridRowEnd="101"
                zIndex="1"
                previewType="FitScreen"
              >
                <yt-vertical-menu-menu
                  ref="ref32"
                  @click_to_jump="
                    () => {
                      switchOrderPanelState()
                    }
                  "
                  class="webVueAntYtVerticleMenu webVueAntYtVerticleMenuStyle-undefinedqt0zq webVueAntYtVerticleMenuStyle-undefined webVueAntYtVerticleMenuStyle"
                  v-model:openKeys="ParkingOrderMenuopenKeys1"
                  v-model:selectedKeys="ParkingOrderMenuselectedKeys1"
                  :items="ParkingOrderMenuoptions1.dataSource"
                >
                </yt-vertical-menu-menu>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.00000%"
                left="0.20000%"
                bottom="0.00000%"
                right="0.00000%"
                gridColumnStart="14"
                gridColumnEnd="101"
                gridRowStart="1"
                gridRowEnd="101"
                zIndex="2"
                previewType="FitScreen"
              >
                <yt-dynamic-panel
                  ref="ref33"
                  class="webVueAntYtDynamicPanel"
                  mutileStyle='[{"statusId":"1","info":{}},{"statusId":"2","info":{}},{"statusId":"3","info":{}},{"statusId":"4","info":{}}]'
                >
                  <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
                    <!-- 订单信息 -->
                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="ParkingOrdersDynamicPanelselectKey1 == '1'"
                      top="0.00000%"
                      left="0.00000%"
                      bottom="0.00000%"
                      right="0.00000%"
                      gridColumnStart="1"
                      gridColumnEnd="101"
                      gridRowStart="1"
                      gridRowEnd="101"
                      zIndex="1"
                      previewType="AdaptiveWH"
                    >
                      <a-form
                        ref="ref61"
                        :model="OrderInformationform1"
                        :class="[
                          'webVueAntForm',
                          'webVueAntYtFormStyle-undefined',
                          'webVueAntYtFormStyle',
                        ]"
                      >
                        <yt-grid
                          previewType="AdaptiveWH"
                          width="100%"
                          height="100%"
                        >
                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.50000%"
                            left="2.30000%"
                            bottom="12.40000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="7"
                            gridRowEnd="13"
                            zIndex="1"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref62"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedr4pnw webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderNumbervalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单编号：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedftrzv webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.OrderNumbervalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.50000%"
                            left="0.20000%"
                            bottom="12.40000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="7"
                            gridRowEnd="13"
                            zIndex="2"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref63"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedile0i webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Licenseplatenumbervalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'车牌号：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefineduxkwl webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Licenseplatenumbervalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.20000%"
                            left="2.30000%"
                            bottom="8.60000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="15"
                            gridRowEnd="20"
                            zIndex="3"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref64"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined9pjuk webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderStatus1value2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单状态：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinede9zsx webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.OrderStatus1value2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.20000%"
                            left="0.20000%"
                            bottom="8.60000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="15"
                            gridRowEnd="20"
                            zIndex="4"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref65"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedhdlvq webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Typeoflicenseplatevalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'车牌类型：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedl0k4z webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Typeoflicenseplatevalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="8.60000%"
                            left="2.30000%"
                            bottom="16.30000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="22"
                            gridRowEnd="28"
                            zIndex="5"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref66"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedr4kcw webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Refundornotvalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'是否退款：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedpbfif webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Refundornotvalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="8.60000%"
                            left="0.20000%"
                            bottom="16.30000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="22"
                            gridRowEnd="28"
                            zIndex="6"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref67"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined4657j webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderSourcevalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单来源：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefined6wivz webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.OrderSourcevalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="13.80000%"
                            left="2.30000%"
                            bottom="11.10000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="29"
                            gridRowEnd="35"
                            zIndex="7"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref68"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedzz7sm webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderTypevalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单类型：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedqiy2d webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.OrderTypevalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.60000%"
                            left="0.20000%"
                            bottom="8.20000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="41"
                            gridRowEnd="46"
                            zIndex="8"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref69"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedibqha webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="PaymentStatusvalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'付款状态：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedsg12f webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.PaymentStatusvalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="4.50000%"
                            left="2.30000%"
                            bottom="5.40000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="41"
                            gridRowEnd="46"
                            zIndex="9"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref70"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined1vcf3 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderAmount1value2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedewwrc webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.OrderAmount1value2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="7.90000%"
                            left="0.20000%"
                            bottom="2.00000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="48"
                            gridRowEnd="53"
                            zIndex="10"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref71"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined0594y webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Paymentchannel1value2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'支付渠道：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinediu5u2 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Paymentchannel1value2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="14.20000%"
                            left="0.20000%"
                            bottom="10.70000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="55"
                            gridRowEnd="61"
                            zIndex="11"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref72"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedw7bvp webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Preferentialchannel1value2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'优惠渠道：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedgjfgk webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Preferentialchannel1value2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="14.20000%"
                            left="2.30000%"
                            bottom="10.70000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="55"
                            gridRowEnd="61"
                            zIndex="12"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref73"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined17n4p webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Amountpayablevalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'应付金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedgqah7 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Amountpayablevalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="3.30000%"
                            left="2.30000%"
                            bottom="6.60000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="63"
                            gridRowEnd="68"
                            zIndex="13"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref74"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedtwrrv webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Actualamountpaidvalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'实付金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedky5wt webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Actualamountpaidvalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="7.90000%"
                            left="2.30000%"
                            bottom="2.00000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="48"
                            gridRowEnd="53"
                            zIndex="14"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref75"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedhrtqp webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Preferentialamountvalue2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'优惠金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefined4o0bc webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Preferentialamountvalue2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="3.30000%"
                            left="0.20000%"
                            bottom="6.60000%"
                            right="1.50000%"
                            gridColumnStart="60"
                            gridColumnEnd="96"
                            gridRowStart="63"
                            gridRowEnd="68"
                            zIndex="15"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref76"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedl8g1k webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Refundamount1value2"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'退款金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedjwmxz webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  OrderInformationform1.Refundamount1value2
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="27.00000%"
                            left="45.20000%"
                            bottom="7.20000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="3"
                            gridRowEnd="6"
                            zIndex="16"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref77"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinedx3dz9 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="58.00px"
                            top="13.20000%"
                            left="10.50000%"
                            bottom="16.30000%"
                            right="1.60000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="3"
                            gridRowEnd="7"
                            zIndex="17"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref78"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefined9ehj7 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'基本信息'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="28.80000%"
                            left="45.20000%"
                            bottom="5.50000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="36"
                            gridRowEnd="39"
                            zIndex="18"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref79"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinedo10b0 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="21.60000%"
                            left="12.00000%"
                            bottom="8.00000%"
                            right="1.60000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="36"
                            gridRowEnd="40"
                            zIndex="19"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref80"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedde407 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'交易信息'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.40000%"
                            left="45.20000%"
                            bottom="32.90000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="71"
                            gridRowEnd="74"
                            zIndex="20"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref81"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefined4tlpq webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="11.90000%"
                            left="12.00000%"
                            bottom="17.60000%"
                            right="1.60000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="70"
                            gridRowEnd="74"
                            zIndex="21"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref82"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedofv3v webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'支付记录'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            :isShow="OrderPaymentRecordisShow1"
                            top="1.00000%"
                            left="0.90000%"
                            bottom="1.50000%"
                            right="0.00000%"
                            gridColumnStart="3"
                            gridColumnEnd="98"
                            gridRowStart="74"
                            gridRowEnd="101"
                            zIndex="22"
                            previewType="AdaptiveWH"
                          >
                            <yt-table
                              ref="ref83"
                              @click="
                                () => {
                                  initOrderPaymentRecords()
                                  loadOrderPaymentRecords()
                                }
                              "
                              @onTableChange="
                                  (pagination) => {
                                    loadOrderPaymentRecords(pagination)
                                  }
                                "
                              class="webVueAntYtTable webVueAntYtTableStyle-undefinedcrfib webVueAntYtTableStyle-undefined webVueAntYtTableStyle"
                              :canSelect="false"
                              v-model:selectedRows="
                                OrderPaymentRecordselectedRows1
                              "
                              v-model:total="OrderPaymentRecordtotal1"
                              v-model:current="OrderPaymentRecordcurrent2"
                              v-model:pageSize="OrderPaymentRecordpageSize1"
                              :columns="OrderPaymentRecorddata1.columns"
                              :dataSource="OrderPaymentRecorddata1.dataSource"
                              :scroll="{ y: 115 }"
                            >
                              <template #cell="{ column, record }"> </template>
                            </yt-table>
                          </yt-grid-item>
                        </yt-grid>
                      </a-form>
                    </yt-grid-item>
                    <!-- 出入信息 -->
                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="ParkingOrdersDynamicPanelselectKey1 == '2'"
                      top="0.00000%"
                      left="0.00000%"
                      bottom="0.00000%"
                      right="0.00000%"
                      gridColumnStart="1"
                      gridColumnEnd="101"
                      gridRowStart="1"
                      gridRowEnd="101"
                      zIndex="2"
                      previewType="AdaptiveWH"
                    >
                      <a-form
                        ref="ref84"
                        :model="AccessInformationform1"
                        :class="[
                          'webVueAntForm',
                          'webVueAntYtFormStyle-undefined',
                          'webVueAntYtFormStyle',
                        ]"
                      >
                        <yt-grid
                          previewType="AdaptiveWH"
                          width="100%"
                          height="100%"
                        >
                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="6.20000%"
                            left="1.90000%"
                            bottom="3.70000%"
                            right="2.40000%"
                            gridColumnStart="8"
                            gridColumnEnd="46"
                            gridRowStart="8"
                            gridRowEnd="13"
                            zIndex="1"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref85"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefineddok83 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="yardnumbervalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'车场编号：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedj8kav webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.yardnumbervalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="6.20000%"
                            left="1.80000%"
                            bottom="3.70000%"
                            right="2.50000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="8"
                            gridRowEnd="13"
                            zIndex="2"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref86"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedjl3t5 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Nameofyardvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'车场名称：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefined3yrtx webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Nameofyardvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.70000%"
                            left="1.90000%"
                            bottom="12.10000%"
                            right="2.40000%"
                            gridColumnStart="8"
                            gridColumnEnd="46"
                            gridRowStart="15"
                            gridRowEnd="21"
                            zIndex="3"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref87"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined0x3iw webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Typeofyardvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'车场类型：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefined4sffo webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Typeofyardvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.70000%"
                            left="1.80000%"
                            bottom="12.10000%"
                            right="2.50000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="15"
                            gridRowEnd="21"
                            zIndex="4"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref88"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedenk1l webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Areavalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'所属区域：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedjoyp2 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Areavalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.60000%"
                            left="1.90000%"
                            bottom="8.30000%"
                            right="2.40000%"
                            gridColumnStart="8"
                            gridColumnEnd="46"
                            gridRowStart="23"
                            gridRowEnd="28"
                            zIndex="5"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref89"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined9txq3 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="BerthNovalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'泊位编号：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedb8r5c webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.BerthNovalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="1.60000%"
                            left="1.80000%"
                            bottom="8.30000%"
                            right="2.50000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="23"
                            gridRowEnd="28"
                            zIndex="6"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref90"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined8k042 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Releasepersonnelvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'放行人员：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedqqgkt webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Releasepersonnelvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.30000%"
                            left="1.20000%"
                            bottom="12.60000%"
                            right="2.50000%"
                            gridColumnStart="10"
                            gridColumnEnd="46"
                            gridRowStart="35"
                            gridRowEnd="41"
                            zIndex="7"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref92"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedwuv2b webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Driveinvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'驶入口：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedn6sp1 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Driveinvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.30000%"
                            left="1.80000%"
                            bottom="12.60000%"
                            right="2.50000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="35"
                            gridRowEnd="41"
                            zIndex="8"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref93"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedw7xfm webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Exitvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'驶出口：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedh0s65 webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Exitvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="15.20000%"
                            left="1.90000%"
                            bottom="9.70000%"
                            right="2.40000%"
                            gridColumnStart="8"
                            gridColumnEnd="46"
                            gridRowStart="42"
                            gridRowEnd="48"
                            zIndex="9"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref94"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedtorvi webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="Driveintime1value1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'驶入时间：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedbxm4k webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.Driveintime1value1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="15.20000%"
                            left="1.80000%"
                            bottom="9.70000%"
                            right="2.50000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="42"
                            gridRowEnd="48"
                            zIndex="10"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref95"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedks5m7 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="ExitTime1value1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'驶出时间：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefined80d2p webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.ExitTime1value1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.40000%"
                            left="2.20000%"
                            bottom="12.50000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="46"
                            gridRowStart="71"
                            gridRowEnd="77"
                            zIndex="11"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref98"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined9wz0k webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="UserLicensePlatevalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'用户车牌：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinediiu9x webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.UserLicensePlatevalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="12.40000%"
                            left="2.20000%"
                            bottom="12.50000%"
                            right="2.20000%"
                            gridColumnStart="59"
                            gridColumnEnd="97"
                            gridRowStart="71"
                            gridRowEnd="77"
                            zIndex="12"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref99"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedh1oid webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="ContactInformationvalue1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'联系方式：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinedyj0tz webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  AccessInformationform1.ContactInformationvalue1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="31.70000%"
                            left="45.20000%"
                            bottom="2.50000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="3"
                            gridRowEnd="6"
                            zIndex="13"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref100"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinedasnq9 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="13.20000%"
                            left="4.40000%"
                            bottom="16.30000%"
                            right="9.20000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="3"
                            gridRowEnd="7"
                            zIndex="14"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref101"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefined4zsc4 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'车场信息'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="7.90000%"
                            left="45.20000%"
                            bottom="26.30000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="31"
                            gridRowEnd="34"
                            zIndex="15"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref102"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefined4rap9 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="20.40000%"
                            left="4.40000%"
                            bottom="9.20000%"
                            right="9.20000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="30"
                            gridRowEnd="34"
                            zIndex="16"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref103"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedjpl74 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'进出信息'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="22.70000%"
                            left="45.20000%"
                            bottom="11.60000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="66"
                            gridRowEnd="69"
                            zIndex="17"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref104"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefined517rl webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="6.50000%"
                            left="4.40000%"
                            bottom="23.10000%"
                            right="9.20000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="66"
                            gridRowEnd="70"
                            zIndex="18"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref105"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedm7dl4 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'放行信息'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="71.00px"
                            top="23.20000%"
                            left="7.40000%"
                            bottom="6.40000%"
                            right="6.50000%"
                            gridColumnStart="8"
                            gridColumnEnd="18"
                            gridRowStart="50"
                            gridRowEnd="54"
                            zIndex="19"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref179"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefined702m7 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'驶入图片：'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="7.10000%"
                            left="5.00000%"
                            bottom="6.20000%"
                            right="6.90000%"
                            gridColumnStart="18"
                            gridColumnEnd="29"
                            gridRowStart="50"
                            gridRowEnd="63"
                            zIndex="20"
                            previewType="AdaptiveWH"
                          >
                            <div
                              v-if="AccessInformationform1.entryPicture"
                              ref="ref180"
                              class="webVueAntYtPicture webVueAntYtPictureStyle-undefinedj44ke webVueAntYtPictureStyle-undefined webVueAntYtPictureStyle"
                            >
                              <a-image
                                :src="AccessInformationform1.entryPicture"
                                :preview="true"
                                :style="{
                                  transform: 'scaleX(1) scaleY(1)',
                                  objectFit: 'contain',
                                }"
                              >
                              </a-image>
                            </div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="71.00px"
                            top="23.20000%"
                            left="7.10000%"
                            bottom="6.40000%"
                            right="6.80000%"
                            gridColumnStart="59"
                            gridColumnEnd="69"
                            gridRowStart="50"
                            gridRowEnd="54"
                            zIndex="21"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref181"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedq4kav webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'驶出图片：'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="7.10000%"
                            left="4.70000%"
                            bottom="6.20000%"
                            right="7.10000%"
                            gridColumnStart="69"
                            gridColumnEnd="80"
                            gridRowStart="50"
                            gridRowEnd="63"
                            zIndex="22"
                            previewType="AdaptiveWH"
                          >
                            <div
                              v-if="AccessInformationform1.exitPicture"
                              ref="ref183"
                              class="webVueAntYtPicture webVueAntYtPictureStyle-undefined20ro7 webVueAntYtPictureStyle-undefined webVueAntYtPictureStyle"
                            >
                              <a-image
                                :src="AccessInformationform1.exitPicture"
                                :preview="true"
                                :style="{
                                  transform: 'scaleX(1) scaleY(1)',
                                  objectFit: 'contain',
                                }"
                              >
                              </a-image>
                            </div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="71.00px"
                            top="22.50000%"
                            left="7.40000%"
                            bottom="7.10000%"
                            right="6.50000%"
                            gridColumnStart="8"
                            gridColumnEnd="18"
                            gridRowStart="79"
                            gridRowEnd="83"
                            zIndex="24"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref194"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefined3o471 webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'放行凭证：'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="6.90000%"
                            left="5.00000%"
                            bottom="6.50000%"
                            right="6.90000%"
                            gridColumnStart="18"
                            gridColumnEnd="29"
                            gridRowStart="79"
                            gridRowEnd="92"
                            zIndex="23"
                            previewType="AdaptiveWH"
                          >
                            <div
                              v-if="AccessInformationform1.certificate"
                              ref="ref196"
                              class="webVueAntYtPicture webVueAntYtPictureStyle-undefinedj5ff2 webVueAntYtPictureStyle-undefined webVueAntYtPictureStyle"
                            >
                              <a-image
                                :src="AccessInformationform1.certificate"
                                :preview="true"
                                :style="{
                                  transform: 'scaleX(1) scaleY(1)',
                                  objectFit: 'contain',
                                }"
                              >
                              </a-image>
                            </div>
                          </yt-grid-item>
                        </yt-grid>
                      </a-form>
                    </yt-grid-item>
                    <!-- 计费信息 -->
                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="ParkingOrdersDynamicPanelselectKey1 == '3'"
                      top="0.00000%"
                      left="0.00000%"
                      bottom="0.00000%"
                      right="0.00000%"
                      gridColumnStart="1"
                      gridColumnEnd="101"
                      gridRowStart="1"
                      gridRowEnd="101"
                      zIndex="1"
                      previewType="AdaptiveWH"
                    >
                      <a-form
                        ref="ref111"
                        :model="BillingInformationform1"
                        :class="[
                          'webVueAntForm',
                          'webVueAntYtFormStyle-undefined',
                          'webVueAntYtFormStyle',
                        ]"
                      >
                        <yt-grid
                          previewType="AdaptiveWH"
                          width="100%"
                          height="100%"
                        >
                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="6.20000%"
                            left="2.30000%"
                            bottom="3.70000%"
                            right="2.10000%"
                            gridColumnStart="8"
                            gridColumnEnd="45"
                            gridRowStart="8"
                            gridRowEnd="13"
                            zIndex="1"
                            previewType="AdaptiveWH"
                          >
                            <a-form-item
                              ref="ref112"
                              class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined4sfjd webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                              name="OrderAmount1value1"
                              :colon="false"
                              :rules="[]"
                            >
                              <template #label>
                                <div class="label-content">
                                  <span
                                    class="ant-form-item-content"
                                    v-html="'订单金额：'"
                                  >
                                  </span>
                                </div>
                              </template>
                              <a-input
                                data-event
                                class="webVueAntinput webVueAntYtInputStyle-undefinediheza webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                                v-model:value="
                                  BillingInformationform1.OrderAmount1value1
                                "
                                :disabled="true"
                                :maxLength="100"
                                :placeholder="'--'"
                              >
                              </a-input>
                            </a-form-item>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="27.00000%"
                            left="45.20000%"
                            bottom="7.20000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="3"
                            gridRowEnd="6"
                            zIndex="2"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref127"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinedhtsgw webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="13.20000%"
                            left="10.50000%"
                            bottom="9.30000%"
                            right="3.20000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="3"
                            gridRowEnd="7"
                            zIndex="3"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref128"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedaegia webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'订单金额'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="19.80000%"
                            left="2.60000%"
                            bottom="14.40000%"
                            right="61.00000%"
                            gridColumnStart="4"
                            gridColumnEnd="5"
                            gridRowStart="17"
                            gridRowEnd="20"
                            zIndex="4"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref129"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinede13kz webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="5.80000%"
                            left="12.00000%"
                            bottom="0.40000%"
                            right="1.60000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="17"
                            gridRowEnd="20"
                            zIndex="5"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref130"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedq598d webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'计费明细'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            :isShow="BillingDetailsisShow1"
                            top="0.10000%"
                            left="0.90000%"
                            bottom="0.80000%"
                            right="0.20000%"
                            gridColumnStart="3"
                            gridColumnEnd="98"
                            gridRowStart="23"
                            gridRowEnd="97"
                            zIndex="6"
                            previewType="AdaptiveWH"
                          >
                            <yt-table
                              ref="ref133"
                              @click="
                                () => {
                                  initBillingDetails()
                                  loadBillingDetails()
                                }
                              "
                              @onTableChange="
                                  (pagination) => {
                                    loadBillingDetails(pagination)
                                  }
                                "
                              class="webVueAntYtTable webVueAntYtTableStyle-undefinedta8zu webVueAntYtTableStyle-undefined webVueAntYtTableStyle"
                              :canSelect="false"
                              v-model:selectedRows="BillingDetailsselectedRows1"
                              v-model:total="BillingDetailstotal1"
                              v-model:current="BillingDetailscurrent2"
                              v-model:pageSize="BillingDetailspageSize1"
                              :columns="BillingDetailsdata1.columns"
                              :dataSource="BillingDetailsdata1.dataSource"
                              :scroll="{ y: 449 }"
                            >
                              <template #cell="{ column, record }"> </template>
                            </yt-table>
                          </yt-grid-item>
                        </yt-grid>
                      </a-form>
                    </yt-grid-item>
                    <!-- 订单记录 -->
                    <yt-grid-item
                      :isShow="ParkingOrdersDynamicPanelselectKey1 == '4'"
                      fixedSize="selfAdaption"
                      top="0.00000%"
                      left="0.00000%"
                      bottom="0.00000%"
                      right="0.00000%"
                      gridColumnStart="1"
                      gridColumnEnd="101"
                      gridRowStart="1"
                      gridRowEnd="101"
                      zIndex="1"
                      previewType="AdaptiveWH"
                    >
                      <a-form
                        ref="ref134"
                        :model="OrderRecordform1"
                        :class="[
                          'webVueAntForm',
                          'webVueAntYtFormStyle-undefined',
                          'webVueAntYtFormStyle',
                        ]"
                      >
                        <yt-grid
                          previewType="AdaptiveWH"
                          width="100%"
                          height="100%"
                        >
                          <yt-grid-item
                            fixedSize="selfAdaption"
                            top="27.00000%"
                            left="45.20000%"
                            bottom="7.20000%"
                            right="36.50000%"
                            gridColumnStart="3"
                            gridColumnEnd="5"
                            gridRowStart="3"
                            gridRowEnd="6"
                            zIndex="1"
                            previewType="AdaptiveWH"
                          >
                            <div
                              ref="ref136"
                              class="webVueAntYtRectangle webVueAntYtRectangleStyle-undefinednynd4 webVueAntYtRectangleStyle-undefined webVueAntYtRectangleStyle"
                            ></div>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="width"
                            comWidth="57.00px"
                            top="13.20000%"
                            left="10.50000%"
                            bottom="16.30000%"
                            right="3.20000%"
                            gridColumnStart="5"
                            gridColumnEnd="13"
                            gridRowStart="3"
                            gridRowEnd="7"
                            zIndex="2"
                            previewType="AdaptiveWH"
                          >
                            <span
                              ref="ref137"
                              class="webVueAntYtSpan webVueAntYtSpanStyle-undefinedduxpq webVueAntYtSpanStyle-undefined webVueAntYtSpanStyle webVueAntYtSpanBrCount-undefined webVueAntYtSpanBrCount"
                            >
                              <span v-html="'订单记录'"> </span>
                            </span>
                          </yt-grid-item>

                          <yt-grid-item
                            fixedSize="selfAdaption"
                            :isShow="OrderOperationRecordisShow1"
                            top="0.60000%"
                            left="0.90000%"
                            bottom="0.70000%"
                            right="0.70000%"
                            gridColumnStart="3"
                            gridColumnEnd="98"
                            gridRowStart="8"
                            gridRowEnd="99"
                            zIndex="3"
                            previewType="AdaptiveWH"
                          >
                            <yt-table
                              ref="ref140"
                              @click="
                                () => {
                                  initOrderOperationRecords() 
                                }
                              "
                              @onTableChange="
                                (pagination) => {
                                  loadOrderOperationRecords(pagination)
                                }
                              "
                              class="webVueAntYtTable webVueAntYtTableStyle-undefinedsyozj webVueAntYtTableStyle-undefined webVueAntYtTableStyle"
                              :canSelect="false"
                              v-model:selectedRows="
                                OrderOperationRecordselectedRows1
                              "
                              v-model:total="OrderOperationRecordtotal1"
                              v-model:current="OrderOperationRecordcurrent2"
                              v-model:pageSize="OrderOperationRecordpageSize1"
                              :columns="OrderOperationRecorddata1.columns"
                              :dataSource="OrderOperationRecorddata1.dataSource"
                              :scroll="{ y: 534.0000382001598 }"
                            >
                              <template #cell="{ column, record }"> </template>
                            </yt-table>
                          </yt-grid-item>
                        </yt-grid>
                      </a-form>
                    </yt-grid-item>
                  </yt-grid>
                </yt-dynamic-panel>
              </yt-grid-item>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.00000%"
      left="0.40000%"
      bottom="0.00000%"
      right="0.20000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="30"
      gridRowEnd="97"
      zIndex="19"
      previewType="FitScreen"
    >
      <a-form
        ref="ref141"
        class="webVueAntForm webVueAntYtFormStyle-undefined webVueAntYtFormStyle"
        :model="Formform1"
      >
        <yt-grid
          previewType="AdaptiveWH"
          width="125.15451174289245%"
          height="100%"
        >
          <yt-grid-item
            fixedSize="selfAdaption"
            :isShow="ParkingOrderTableisShow1"
            top="0.00000%"
            left="0.00000%"
            bottom="0.00000%"
            right="0.00000%"
            gridColumnStart="1"
            gridColumnEnd="101"
            gridRowStart="1"
            gridRowEnd="101"
            zIndex="1"
            previewType="AdaptiveWH"
          >
            <yt-table
              ref="ref142"
              @click="
                () => {
                  showOrderDetails()
                  loadParkingOrders()
                  initParkingOrders()
                }
              "
              @onRowClick="
                (record) => {
                  showOrderDetails(record)
                }
              "
              class="webVueAntYtTable webVueAntYtTableStyle-undefinedyvi9o webVueAntYtTableStyle-undefined webVueAntYtTableStyle customStyle"
              :selectType="'checkbox'"
              v-model:selectedRows="ParkingOrderTableselectedRows1"
              v-model:total="ParkingOrderTabletotal1"
              v-model:current="ParkingOrderTablecurrent2"
              v-model:pageSize="ParkingOrderTablepageSize1"
              :columns="ParkingOrderTabledata1.columns"
              :showSizeChanger="true"
              :showQuickJumper="true"
              :dataSource="ParkingOrderTabledata1.dataSource"
              :scroll="{ y: 462.9999578285365 }"
              @onTableChange="
                () => {
                  searchParkingOrders()
                  // initParkingOrders()
                }
              "
            >
              <template #cell="{ column, record }">
                <template
                  v-if="column.dataIndex === 'operation'"
                  :forKey="'operation'"
                >
                  <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="record.paymentStatus =='待支付'"
                      top="0.30000%"
                      left="0.80000%"
                      bottom="0.30000%"
                      right="3.20000%"
                      gridColumnStart="29"
                      gridColumnEnd="50"
                      gridRowStart="16"
                      gridRowEnd="86"
                      zIndex="1"
                      previewType="AdaptiveWH"
                    >
                      <a-button
                        ref="ref143"
                        @click="
                          (event) => {
                            event.stopPropagation();
                            completeOrder(record)
                          }
                        "
                        class="webVueAntButton webVueAntYtButtonStyle-undefinedckgl9 webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
                        :loading="Completeloading2"
                      >
                        <span class="yt-button-content" v-html="'完成'"> </span>
                      </a-button>
                    </yt-grid-item>

                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="!record.paymentStatus"
                      top="0.30000%"
                      left="3.20000%"
                      bottom="0.30000%"
                      right="0.80000%"
                      gridColumnStart="52"
                      gridColumnEnd="73"
                      gridRowStart="16"
                      gridRowEnd="86"
                      zIndex="2"
                      previewType="AdaptiveWH"
                    >
                      <a-button
                        ref="ref144"
                        @click="
                          (event) => {
                            event.stopPropagation();
                            closeOrder(record)
                          }
                        "
                        class="webVueAntButton webVueAntYtButtonStyle-undefined80e3o webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
                        :loading="Closeloading1"
                      >
                        <span class="yt-button-content" v-html="'关闭'"> </span>
                      </a-button>
                    </yt-grid-item>

                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="record.paymentStatus=='已支付'"
                      top="0.30000%"
                      left="0.80000%"
                      bottom="0.30000%"
                      right="3.20000%"
                      gridColumnStart="29"
                      gridColumnEnd="50"
                      gridRowStart="16"
                      gridRowEnd="86"
                      zIndex="3"
                      previewType="AdaptiveWH"
                    >
                      <a-button
                        ref="ref145"
                        @click="
                          (event) => {
                            event.stopPropagation();
                            showRefundModal(record)
                          }
                        "
                        class="webVueAntButton webVueAntYtButtonStyle-undefinedixftu webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
                        :loading="Refundloading1"
                      >
                        <span class="yt-button-content" v-html="'退款'"> </span>
                      </a-button>
                    </yt-grid-item>

                    <yt-grid-item
                      fixedSize="selfAdaption"
                      :isShow="!record.paymentStatus"
                      top="0.30000%"
                      left="0.80000%"
                      bottom="0.30000%"
                      right="3.20000%"
                      gridColumnStart="29"
                      gridColumnEnd="50"
                      gridRowStart="16"
                      gridRowEnd="86"
                      zIndex="4"
                      previewType="AdaptiveWH"
                    >
                      <a-button
                        ref="ref156"
                        @click="
                          (event) => {
                            event.stopPropagation();
                            settleOrder(record)
                          }
                        "
                        class="webVueAntButton webVueAntYtButtonStyle-undefined3wjok webVueAntYtButtonStyle-undefined webVueAntYtButtonStyle center-undefined center"
                        :loading="Completeloading1"
                      >
                        <span class="yt-button-content" v-html="'结算'"> </span>
                      </a-button>
                    </yt-grid-item>
                  </yt-grid>
                </template>
              </template>
            </yt-table>
          </yt-grid-item>
        </yt-grid>
      </a-form>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.90000%"
      left="1.10000%"
      bottom="13.20000%"
      right="1.70000%"
      gridColumnStart="79"
      gridColumnEnd="99"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="20"
      previewType="FitScreen"
    >
      <a-form-item
        ref="ref228"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-undefined38klw webVueAntYtSelectFormItem-undefined webVueAntYtSelectFormItem show-label-undefined show-label"
        name="PaymentStatusvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'支付状态：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-undefined webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-p8pfbm17gi3h2" "popupKeyId"'
          :showArrow="true"
          v-model:value="PaymentStatusvalue1"
          :allowClear="true"
          :placeholder="'请选择'"
          :mode="'multiple'"
          :options="[
            {
              label: '支付中',
              value: '支付中',
              disabled: false,
              select: false,
            },
            {
              label: '已支付',
              value: '已支付',
              disabled: false,
              select: false,
            },
            {
              value: '待支付',
              label: '待支付',
              disabled: false,
              select: false,
            },
            {
              value: '已支付，已退款',
              label: '已支付，已退款',
              disabled: false,
              select: false,
            },
          ]"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>

    <!-- 退款弹窗 -->
    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrderRefundisShow1"
      top="2.60000%"
      left="3.40000%"
      bottom="2.60000%"
      right="3.40000%"
      gridColumnStart="39"
      gridColumnEnd="63"
      gridRowStart="38"
      gridRowEnd="64"
      zIndex="22"
      previewType="FitScreen"
    >
      <yt-custom-modal
        ref="ref231"
        @ok="
          () => {
            confirmOrderRefund()
          }
        "
        @cancel="
          () => {
            closeRefundModal()
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-undefined webVueAntYtModalStyle"
        v-model:isShow="OrderRefundisShow1"
        :title="'订单退款'"
        :okText="'退款'"
        :okButtonBg="'#F84C55'"
        :maskClosable="true"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="OrderRefundform1"
            ref="ref231_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.40000%"
                left="0.10000%"
                bottom="3.90000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="21"
                gridRowEnd="45"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref234"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined6fqf9 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                  name="Actualamountpaidvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'实付金额：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-undefinedpdmol webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                    v-model:value="OrderRefundform1.Actualamountpaidvalue1"
                    :disabled="true"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.90000%"
                left="0.10000%"
                bottom="3.40000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="57"
                gridRowEnd="81"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref258"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedbfcdm webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                  name="Refundamountvalue1"
                  :colon="false"
                  :rules="[
                    {
                      message: '退款金额高于实付金额',
                      validator: validateRefundamountcustom,
                    },
                  ]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'退款金额：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-undefinedahcvx webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                    v-model:value="OrderRefundform1.Refundamountvalue1"
                    :disabled="false"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <!-- 完成弹窗 -->
    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrderCompleteShow1"
      top="2.60000%"
      left="3.40000%"
      bottom="2.60000%"
      right="3.40000%"
      gridColumnStart="39"
      gridColumnEnd="63"
      gridRowStart="38"
      gridRowEnd="64"
      zIndex="22"
      previewType="FitScreen"
    >
      <yt-custom-modal
        ref="ref666"
        @ok="
          () => {
            confirmOrderComplete()
          }
        "
        @cancel="
          () => {
            closeCompleteModal()
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-undefined webVueAntYtModalStyle"
        v-model:isShow="OrderCompleteShow1"
        :title="'订单完成'"
        :okText="'确定'"
        :maskClosable="true"
        >
        <!-- :okButtonBg="'#F84C55'" -->
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="OrderRefundform1"
            ref="ref666_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.40000%"
                left="0.10000%"
                bottom="3.90000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="21"
                gridRowEnd="45"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref2341"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-undefined6fqf9 webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                  name="Completeamountvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'应收金额：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-undefinedpdmol webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                    v-model:value="OrderCompleteform1.Completereceivableamountvalue1"
                    :disabled="true"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.90000%"
                left="0.10000%"
                bottom="3.40000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="57"
                gridRowEnd="81"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref2342"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-undefinedbfcdm webVueAntYtInputFormItem-undefined webVueAntYtInputFormItem show-label-undefined show-label"
                  name="Completeamountvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'实收金额：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-undefinedahcvx webVueAntYtInputStyle-undefined webVueAntYtInputStyle"
                    v-model:value="OrderCompleteform1.Completeamountvalue1"
                    :disabled="false"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
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
      // OrderStatusvalue1: '',
      OrderStatusvalue1: [],
      OrderAmountvalue1: '',
      ParkingOrderTablecurrentRow1: {},
      ParkingOrderTableselectedRows1: [],
      ParkingOrderTablepageSize1: 10,
      ParkingOrderTabledata1: {
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
            width: '50px',
          },
          {
            key: 'orderNumber',
            title: '订单编号',
            dataIndex: 'orderNumber',
            width: '150px',
          },
          {
            key: 'licenseplatenumber',
            title: '车牌号',
            dataIndex: 'licenseplatenumber',
          },
          {
            key: 'typeoflicenseplate',
            title: '车牌类型',
            dataIndex: 'typeoflicenseplate',
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
            // width: '100px',
          },
          {
            key: 'departureTime',
            title: '驶出时间',
            dataIndex: 'departureTime',
            // width: '100px',
          },
          {
            key: 'parkingduration',
            title: '停车时长',
            dataIndex: 'parkingduration',
          },
          {
            key: 'orderAmount',
            title: '订单金额(元)',
            dataIndex: 'orderAmount',
          },
          {
            key: 'preferentialamount',
            title: '优惠金额(元)',
            dataIndex: 'preferentialamount',
          },
          {
            key: 'amountreceivable',
            title: '应收金额(元)',
            dataIndex: 'amountreceivable',
          },
          {
            key: 'paidinamount',
            title: '实收金额(元)',
            dataIndex: 'paidinamount',
          },
          {
            key: 'refundamount',
            title: '退款金额(元)',
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
          {
            key: 'operation',
            title: '操作',
            dataIndex: 'operation',
            cellType: 'slot',
            width: '150px',
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
            parkingduration: '',
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
            parkingduration: '',
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
            preferentialamount: '',
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
      ParkingOrderTablecurrent2: 1,
      ParkingOrderTabletotal1: 10,
      ParkingOrderTableisShow1: true,
      Formform1: {
        id: null,
      },
      // PaymentStatusvalue1: '',
      PaymentStatusvalue1: [],
      Completeloading1: false,
      CompleteisShow2: true,
      Licenseplatenumbervalue1: '',
      MaximumParkingDurationvalue1: '',
      Completeloading2: false,
      CompleteisShow1: true,
      MinimumParkingDurationvalue1: '',
      Checkloading1: false,
      CheckisShow1: true,
      Resetloading1: false,
      ResetisShow1: true,
      Refundloading1: false,
      RefundisShow1: true,
      // paymentchannelvalue1: '',
      paymentchannelvalue1: [],
      // preferentialchannelsvalue1: '',
      preferentialchannelsvalue1: [],
      Parkingvalue1: '',
      Typeoflicenseplatevalue1: [],
      // Typeoflicenseplatevalue1: '',
      Exportloading1: false,
      ExportisShow1: true,
      // 退款
      OrderRefundisShow1: false,
      OrderRefundform1: {
        id: null,
        Actualamountpaidvalue1: '',
        Refundamountvalue1: '',
      },
      // 完成
      OrderCompleteShow1: false,
      OrderCompleteform1: {
        id: null,
        Completereceivableamountvalue1: '',
        Completeamountvalue1: '',
      },
      Closeloading1: false,
      CloseisShow1: true,
      Driveintimevalue1: [],
      DepartureTimevalue1: [],
      OrderInformationform1: {
        id: null /*编辑时,需要给id赋值*/,
        OrderNumbervalue1: '',
        Licenseplatenumbervalue2: '',
        OrderStatus1value2: '',
        Typeoflicenseplatevalue2: '',
        Refundornotvalue2: '',
        OrderSourcevalue2: '',
        OrderTypevalue2: '',
        PaymentStatusvalue2: '',
        OrderAmount1value2: '',
        Paymentchannel1value2: '',
        Preferentialchannel1value2: '',
        Amountpayablevalue1: '',
        Actualamountpaidvalue2: '',
        Preferentialamountvalue2: '',
        Refundamount1value2: '',
      },
      OrderInformationstateKey1: '2',
      AccessInformationform1: {
        id: null /*编辑时,需要给id赋值*/,
        yardnumbervalue1: '',
        Nameofyardvalue1: '',
        Typeofyardvalue1: '',
        Areavalue1: '',
        BerthNovalue1: '',
        Releasepersonnelvalue1: '',
        Driveinvalue1: '',
        Exitvalue1: '',
        Driveintime1value1: '',
        ExitTime1value1: '',
        UserLicensePlatevalue1: '',
        ContactInformationvalue1: '',
        certificate: '',
        exitPicture: '',
        entryPicture: '',
      },
      AccessInformationstateKey1: '2',
      BillingInformationform1: {
        id: null /*编辑时,需要给id赋值*/,
        OrderAmount1value1: '',
      },
      BillingInformationstateKey1: '2',
      BillingDetailscurrentRow1: {},
      BillingDetailsselectedRows1: [],
      BillingDetailspageSize1: 10,
      BillingDetailsdata1: {
        columns: [
          {
            key: 'id',
            title: 'id',
            dataIndex: 'id',
          },
          {
            key: 'serialNumber',
            title: '序号',
            dataIndex: 'serialNumber',
          },
          {
            key: 'billingType',
            title: '计费类型',
            dataIndex: 'billingType',
          },
          {
            key: 'billingPeriod1',
            title: '计费时段',
            dataIndex: 'billingPeriod1',
          },
          {
            key: 'startTime',
            title: '开始时间',
            dataIndex: 'startTime',
          },
          {
            key: 'endTime',
            title: '结束时间',
            dataIndex: 'endTime',
          },
          {
            key: 'duration',
            title: '时长',
            dataIndex: 'duration',
            width:100
          },
          {
            key: 'amount',
            title: '计费金额',
            dataIndex: 'amount',
            width:65
          },
        ],
        dataSource: [
          {
            id: 1,
            serialNumber: '1',
            billingType: '',
            amount: '',
          },
          {
            id: 2,
            serialNumber: '2',
            billingType: '',
            amount: '',
          },
          {
            id: 8,
            serialNumber: '3',
            billingType: '',
            amount: '',
          },
          {
            id: 7,
            serialNumber: '4',
            billingType: '',
            amount: '',
          },
          {
            id: 6,
            serialNumber: '5',
            billingType: '',
            amount: '',
          },
        ],
      },
      BillingDetailscurrent2: 1,
      BillingDetailstotal1: 2,
      OrderRecordform1: {
        id: null /*编辑时,需要给id赋值*/,
      },

      OrderRecordstateKey1: '2',
      OrderDetailsisShow1: false,
      OrderDetailsform1: {
        id: null /*编辑时,需要给id赋值*/,
      },

      ParkingOrderMenuopenKeys1: [],
      ParkingOrderMenuselectedKeys1: ['订单信息'],
      ParkingOrdersDynamicPanelselectKey1: '1',
      OrderPaymentRecordcurrentRow1: {},
      OrderPaymentRecordselectedRows1: [],
      OrderPaymentRecordpageSize1: 10,
      OrderPaymentRecorddata1: {
        columns: [
          {
            key: 'id',
            title: 'id',
            dataIndex: 'id',
          },
          {
            key: 'serialNumber',
            title: '序号',
            dataIndex: 'serialNumber',
          },
          {
            key: 'sourceofPayment1',
            title: '支付来源',
            dataIndex: 'sourceofPayment1',
          },
          {
            key: 'paymentMethod',
            title: '支付方式',
            dataIndex: 'paymentMethod',
          },
          {
            key: 'transactionAmount1',
            title: '交易金额',
            dataIndex: 'transactionAmount1',
          },
          {
            key: 'transactiontime',
            title: '交易时间',
            dataIndex: 'transactiontime',
          },
          {
            key: 'transactionStatus',
            title: '交易状态',
            dataIndex: 'transactionStatus',
          },
        ],
        dataSource: [
          {
            id: 1,
            sourceofPayment1: '',
            transactionStatus: '',
            serialNumber: '1',
          },
          {
            id: 2,
            sourceofPayment1: '',
            transactionStatus: '',
            serialNumber: '2',
          },
        ],
      },
      OrderPaymentRecordcurrent2: 1,
      OrderPaymentRecordtotal1: 5,
      OrderOperationRecordcurrentRow1: {},
      OrderOperationRecordselectedRows1: [],
      OrderOperationRecordpageSize1: 10,
      OrderOperationRecorddata1: {
        columns: [
          {
            key: 'id',
            title: 'id',
            dataIndex: 'id',
          },
          {
            key: 'serialNumber',
            title: '序号',
            dataIndex: 'serialNumber',
          },
          {
            key: 'operator',
            title: '操作人员',
            dataIndex: 'operator',
            width:80,
          },
          {
            key: 'operationtype',
            title: '操作类型',
            dataIndex: 'operationtype',
            width:80,
          },
          {
            key: 'operatingInstructions',
            title: '操作说明',
            dataIndex: 'operatingInstructions',
          },
          {
            key: 'operationrecord',
            title: '操作记录',
            dataIndex: 'operationrecord',
          },
          {
            key: 'operationDetails',
            title: '操作详情',
            dataIndex: 'operationDetails',
          },
          {
            key: 'operationtime',
            title: '操作时间',
            dataIndex: 'operationtime',
          },
        ],
        dataSource: [
          {
            id: 1,
            serialNumber: '1',
            amount: '',
            operator: '',
          },
          {
            id: 2,
            serialNumber: '2',
            amount: '',
            operator: '',
          },
          {
            id: 8,
            serialNumber: '3',
            amount: '',
            operator: '',
          },
          {
            id: 7,
            serialNumber: '4',
            amount: '',
            operator: '',
          },
          {
            id: 6,
            serialNumber: '5',
            amount: '',
            operator: '',
          },
          {
            id: 4,
            serialNumber: '6',
            amount: '',
            operator: '',
          },
          {
            id: 3,
            serialNumber: '7',
            amount: '',
            operator: '',
          },
          {
            id: 0,
            serialNumber: '8',
            amount: '',
            operator: '',
          },
          {
            id: 9,
            serialNumber: '9',
            amount: '',
            operator: '',
          },
          {
            id: 5,
            serialNumber: '10',
            amount: '',
            operator: '',
          },
        ],
      },
      OrderOperationRecordcurrent2: 1,
      OrderOperationRecordtotal1: 10,
      ParkingOrderMenuoptions1: {
        dataSource: [
          {
            iconUrl:
              './staticResource/wzc/1833710370078851072/0/gVl3UY6gb0i5SqOZnbV7u.png',
            key: '订单信息',
            label: '一级菜单1',
            title: '订单信息',
            disabled: false,
            select: true,
          },
          {
            iconUrl:
              './staticResource/wzc/1833710370078851072/0/0_2Nt2A07EAEbY6Suq4Yw.png',
            key: '出入信息',
            label: '一级菜单2',
            title: '出入信息',
            disabled: false,
            select: false,
          },
          {
            key: '计费信息',
            label: '',
            title: '计费信息',
            iconUrl:
              './staticResource/wzc/1833710370078851072/0/GY2cykdLmj6ulwptGkwpL.png',
            disabled: false,
            select: false,
          },
          {
            key: '订单记录',
            label: '',
            title: '订单记录',
            iconUrl:
              './staticResource/wzc/1833710370078851072/0/JkKGqaYvkJNeqXXbdU68y.png',
            disabled: false,
            select: false,
          },
        ],
        value: {
          selectActive: '订单信息',
          selectData: ['订单信息'],
          disableData: [],
          disableActive: '',
        },
      },
      ParkingOrderMenuisShow1: true,
      OrderPaymentRecordisShow1: true,
      BillingDetailsisShow1: true,
      OrderOperationRecordisShow1: true,
    }
  },
  watch: {},
  methods: {
    async exportParkingOrders() {
      try {
        const selectedRows = this.ParkingOrderTableselectedRows1
        const current = this.ParkingOrderTablecurrent2
        const pageSize = this.ParkingOrderTablepageSize1

        // const params =
        //   selectedRows.length > 0
        //     ? {
        //         selectedRows,
        //       }
        //     : {
        //         current,
        //         pageSize,
        //       }

        const params =
          selectedRows.length > 0
            ? {
                selectedRows,
              }
            : {
                current,
                pageSize,
                // 车牌号-0
                Licenseplatenumbervalue1: this.Licenseplatenumbervalue1,
                // 车牌类型-0
                Typeoflicenseplatevalue1: this.Typeoflicenseplatevalue1,
                // 停车场-0
                Parkingvalue1: this.Parkingvalue1,
                // 订单状态-0
                OrderStatusvalue1: this.OrderStatusvalue1,
                // 驶入时间
                entry_time: this.Driveintimevalue1,
                // 驶出时间
                exit_time: this.DepartureTimevalue1,
                // 停车时长
                // parking_duration: [this.MinimumParkingDurationvalue1, this.MaximumParkingDurationvalue1],
                // 最小停车时长
                min_parking_duration: this.MinimumParkingDurationvalue1,
                // 最大停车时长
                max_parking_duration: this.MaximumParkingDurationvalue1,
                // 支付状态-0
                PaymentStatusvalue1: this.PaymentStatusvalue1,
                // 订单金额
                order_amount: this.OrderAmountvalue1,
                // 支付渠道
                payment_channel: this.paymentchannelvalue1,
                // 优惠渠道
                discount_channel: this.preferentialchannelsvalue1,
              }

        const response = await this.executeBackendInterface(
          selectedRows.length > 0 ? 'getParkingOrders' : 'queryParkingOrders',
          // 'getParkingOrders',
          params
        )
        if (response.flag) {
          message.success('导出成功')

          // 处理导出文件的下载逻辑
          console.log('🚀 ~ handleExportClick ~ response:', response)
          if (!response.data || response.data.length === 0)
            return message.error('暂无数据，导出失败')
          // let originalData = response.data
          let originalData = selectedRows.length > 0 ? response.data : response.data.data
          let data = [
            [
              '序号',
              '订单编号',
              '车牌号',
              '车牌类型',
              '停车场',
              '订单状态',
              '支付状态',
              '驶入时间',
              '驶出时间',
              '停车时长',
              '订单金额',
              '优惠金额',
              '应收金额',
              '实收金额',
              '退款金额',
              '支付渠道',
              '优惠渠道',
              '收费人员',
            ],
            // ['test', 'aaa', '156', 'ad456', 'cb456', '2024-10-15 16:50:52', 'status'],
          ]
          console.log('🚀 ~ handleExportClick ~ data:', data)

          originalData.forEach((item) => {
            data.push([
              item.row_index, // 序号
              // item.id, // 序号
              item.order_code, // 订单编号
              item.license_plate, // 车牌号
              item.license_type, // 车牌类型
              item.parking_lot, // 停车场
              item.order_status, // 订单状态
              item.payment_status, // 支付状态
              item.entry_time, // 驶入时间
              item.exit_time, // 驶出时间
              this.handleFormattedDuration(item.parking_duration), // 停车时长
              // item.parking_duration, // 停车时长
              item.order_amount, // 订单金额
              item.discount_amount, // 优惠金额
              item.receivable_amount, // 应收金额
              item.received_amount, // 实收金额
              item.refund_amount, // 退款金额
              item.payment_channel, // 支付渠道
              item.discount_channel, // 优惠渠道
              item.cashier, // 收费人员
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

          let fileName = this.getCurrentDateTime() + '-停车订单.xlsx'
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
        message.error('导出过程中发生错误')
      }
    },
    async searchParkingOrders(type) {
      try {
        // 查询 操作
        if (type === 'search') {
          this.ParkingOrderTablecurrent2 = 1
        }
        const params = {
          // 车牌号-0
          Licenseplatenumbervalue1: this.Licenseplatenumbervalue1,
          // 车牌类型-0
          Typeoflicenseplatevalue1: this.Typeoflicenseplatevalue1,
          // 停车场-0
          Parkingvalue1: this.Parkingvalue1,
          // 订单状态-0
          OrderStatusvalue1: this.OrderStatusvalue1,
          // 驶入时间
          entry_time: this.Driveintimevalue1,
          // 驶出时间
          exit_time: this.DepartureTimevalue1,
          // 停车时长
          // parking_duration: [this.MinimumParkingDurationvalue1, this.MaximumParkingDurationvalue1],
          // 最小停车时长
          min_parking_duration: this.MinimumParkingDurationvalue1,
          // 最大停车时长
          max_parking_duration: this.MaximumParkingDurationvalue1,
          // 支付状态-0
          PaymentStatusvalue1: this.PaymentStatusvalue1,
          // 订单金额
          order_amount: this.OrderAmountvalue1,
          // 支付渠道
          payment_channel: this.paymentchannelvalue1,
          // 优惠渠道
          discount_channel: this.preferentialchannelsvalue1,
          current: this.ParkingOrderTablecurrent2,
          pageSize: this.ParkingOrderTablepageSize1,
        }
        const response = await this.executeBackendInterface(
          'queryParkingOrders',
          params
        )
        if (response.flag) {
          const data = response.data.data.map((item) => ({
            id: item.id,
            row_index: item.row_index,
            orderNumber: item.order_code,
            licenseplatenumber: item.license_plate,
            typeoflicenseplate: item.license_type,
            parking: item.parking_lot,
            orderStatus: item.order_status,
            paymentStatus: item.payment_status,
            driveintime: item.entry_time,
            departureTime: item.exit_time,
            parkingduration: this.handleFormattedDuration(item.parking_duration),
            // parkingduration: item.parking_duration,
            orderAmount: item.order_amount,
            preferentialamount: item.discount_amount,
            amountreceivable: item.receivable_amount,
            paidinamount: item.received_amount,
            refundamount: item.refund_amount,
            paymentchannel: item.payment_channel,
            preferentialchannels: item.discount_channel,
            feecollectingpersonnel: item.cashier,
            parkinglotid:item.parking_lot_id,
            operation: item.operation,
          }))
          this.ParkingOrderTabledata1.dataSource = data
          this.ParkingOrderTabletotal1 = response.data.total
          // message.success('查询成功')
        } else {
          message.error(response.message || '查询失败')
        }
      } catch (error) {
        message.error('查询过程中发生错误')
      }
    },
    async resetParkingOrderFilters() {
      try {
        // this.Licenseplatenumbervalue1 = '';
        // this.Typeoflicenseplatevalue1 = '';
        // this.Parkingvalue1 = '';
        // this.OrderStatusvalue1 = '';
        // this.PaymentStatusvalue1 = '';
        // this.MinimumParkingDurationvalue1 = null;
        // this.MaximumParkingDurationvalue1 = null;

        this.Licenseplatenumbervalue1 = ''
        this.Typeoflicenseplatevalue1 = []
        this.Parkingvalue1 = ''
        this.OrderStatusvalue1 = []
        this.PaymentStatusvalue1 = []
        this.MinimumParkingDurationvalue1 = ''
        this.MaximumParkingDurationvalue1 = ''
        this.Driveintimevalue1 = []
        this.DepartureTimevalue1 = []
        this.OrderAmountvalue1 = ''
        this.paymentchannelvalue1 = []
        this.preferentialchannelsvalue1 = []
        this.ParkingOrderTablecurrent2 = 1

        await this.searchParkingOrders()
        message.success('重置成功')
      } catch (error) {
        message.error('重置过程中发生错误')
      }
    },
    // 结算
    async settleOrder(record) {
      // if (record && record.paymentStatus !== undefined) {
      //   record.paymentStatus = '待支付'
      //   message.success('支付状态已更新为待支付')
      // } else {
      //   message.error('无法更新支付状态')
      // }

      try {
        const response = await this.executeBackendInterface(
          'settlementOrder',
          {
            id: record.id
          }
        )
        if (response.flag) {
          message.success('操作成功')
          // 刷新列表
          this.initParkingOrders()
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('Failed to load parking orders.')
      }
    },
    // 完成
    async completeOrder(record) {
      console.log("🚀 ~ completeOrder ~ record:", record)

      // 显示订单完成弹窗
      this.OrderCompleteShow1 = true

      // 赋值 id
      this.OrderCompleteform1.Completereceivableamountvalue1 = record.amountreceivable
      this.OrderCompleteform1.id = record.id

      // 重置 退款金额
      this.OrderCompleteform1.Completeamountvalue1 = null

      // try {
      //   const response = await this.executeBackendInterface(
      //     'completeOrder',
      //     {
      //       id: record.id
      //     }
      //   )
      //   if (response.flag) {
      //     message.success('操作成功')
      //     // 刷新列表
      //     this.initParkingOrders()
      //   } else {
      //     message.error(response.message)
      //   }
      // } catch (error) {
      //   message.error('Failed to load parking orders.')
      // }
    },
    // 关闭
    async closeOrder(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认关闭订单',
        content: '您确定要关闭此订单吗？',
        onOk: async () => {
          // // 更新订单状态和支付状态
          // record.orderStatus = '关闭'
          // record.paymentStatus = '待支付'
          // // 提示用户操作成功
          // message.success('订单已关闭')

          try {
            const response = await this.executeBackendInterface(
              'closeOrder',
              {
                id: record.id
              }
            )
            if (response.flag) {
              message.success('操作成功')
              // 刷新列表
              this.initParkingOrders()
            } else {
              message.error(response.message)
            }
          } catch (error) {
            message.error('Failed to load parking orders.')
          }
        },
        onCancel: () => {
          // 用户取消操作
          message.info('操作已取消')
        },
      })
    },
    // 退款
    showRefundModal(record) {
      console.log('退款 ~ showRefundModal ~ record:', record)
      // 显示订单退款弹窗
      this.OrderRefundisShow1 = true

      // 将当前行实收金额中的值填充到实付金额中
      this.OrderRefundform1.Actualamountpaidvalue1 = record.paidinamount
      this.OrderRefundform1.id = record.id

      // 重置 退款金额
      this.OrderRefundform1.Refundamountvalue1 = null
    },
    switchOrderPanelState() {
      //请在该注释下面编写代码, 根据 selectKey 的值不同，selectKey通常对应菜单组件上的属性 selectedKeys变量 跳转到不同的路由路径。注意如果是第三方页面 请使用window.open('网址', '_blank');
      //例如:
      // const selectKey = this.<变量>
      // if(selectKey === 'user'){
      // 当前是在页面 停车订单 下 所以你push的时候默认需要带上 停车订单 页面的path, 再加上 跳转页面的 path
      //例如(具体path取route中对应的):
      //  this.$router.push('/停车订单path/跳转页面path');
      //}
      //
      const selectKey = this.ParkingOrderMenuselectedKeys1[0]
      switch (selectKey) {
        case '订单信息':
          this.ParkingOrdersDynamicPanelselectKey1 = '1'
          break
        case '出入信息':
          this.ParkingOrdersDynamicPanelselectKey1 = '2'
          break
        case '计费信息':
          this.ParkingOrdersDynamicPanelselectKey1 = '3'
          this.BillingDetailscurrent2=1
          this.initBillingDetails()
          
          break
        case '订单记录':
          this.ParkingOrdersDynamicPanelselectKey1 = '4'
          this.OrderOperationRecordcurrent2=1
          this.initOrderOperationRecords()
          break
        default:
          console.log('未知的菜单选项')
      }
    },
    // 获取订单信息
    async getOrderDetails(id) {
      try {
        const response = await axios.post(
          '/api/Parkingorders/getOrderDetails',
          {
            id,
          }
        )
        if (response.data.flag) {
          let detail = response.data.data.orderDetails
          this.OrderInformationform1 = {
            id: detail.id /*编辑时,需要给id赋值*/,
            OrderNumbervalue1: detail['order_code'],
            Licenseplatenumbervalue2: detail['license_plate'],
            OrderStatus1value2: detail['order_status'],
            Typeoflicenseplatevalue2: detail['license_type'],
            Refundornotvalue2: detail['refund'],
            OrderSourcevalue2: detail['order_source'],
            OrderTypevalue2: detail['order_type'],
            PaymentStatusvalue2: detail['payment_status'],
            OrderAmount1value2: detail['order_amount'],
            Paymentchannel1value2: detail['payment_channel'],
            Preferentialchannel1value2: detail['discount_channel'],
            Amountpayablevalue1: detail['receivable_amount'],
            Actualamountpaidvalue2: detail['received_amount'],
            Preferentialamountvalue2: detail['discount_amount'],
            Refundamount1value2: detail['refund_amount'],
          }
          this.BillingInformationform1.OrderAmount1value1 =
            detail['order_amount']
        } else {
          message.error(response.data.message)
        }
      } catch (error) {
        message.error('Failed to load get Order Details.')
      }
    },
    // 获取车辆进出信息
    async getVehicleList(licensePlateNumber,user_order_id) {
      try {
        const response = await axios.post(
          '/api/Vehiclemanagement/getVehicleList',
          {
            licensePlateNumber,
            user_order_id
          }
        )
        if (response.data.flag) {
          let detail = response.data.data.data[0]
          if (detail) {
            this.AccessInformationform1.BerthNovalue1 = detail['berth_number']
            this.AccessInformationform1.Driveinvalue1 = detail['entry_name']
            this.AccessInformationform1.Exitvalue1 = detail['exit_name']
            this.AccessInformationform1.Driveintime1value1 =
              detail['last_entry_time']
            this.AccessInformationform1.ExitTime1value1 =
              detail['last_exit_time']
            this.AccessInformationform1.UserLicensePlatevalue1 =
              detail['license_plate_number']
            this.AccessInformationform1.ContactInformationvalue1 =
              detail['contact']
            this.AccessInformationform1.entryPicture = detail['entry_picture']
            this.AccessInformationform1.exitPicture = detail['exit_picture']
            this.AccessInformationform1.certificate = detail['certificate']
          }
        } else {
          message.error(response.data.message)
        }
      } catch (error) {
        message.error('Failed to load get Vehicle List.')
      }
    },
    // 获取车场信息
    async getParkingLotDetails(id) {
      try {
        const response = await axios.post(
          '/api/Depotconfiguration/getParkingLotDetails',
          {
            id,
          }
        )
        if (response.data.flag) {
          let detail = response.data.data.parkingLotDetails[0]
          if (detail) {
            this.AccessInformationform1.id = detail.id
            this.AccessInformationform1.yardnumbervalue1 =
              detail['parking_lot_code']
            this.AccessInformationform1.Nameofyardvalue1 =
              detail['parking_lot_name']
            this.AccessInformationform1.Typeofyardvalue1 = detail['parking_lot_type']
            this.AccessInformationform1.Areavalue1 =detail['region'] ? detail['region'].substring(detail['region'].indexOf("[")+1, detail['region'].indexOf("]")) :''
            this.AccessInformationform1.Releasepersonnelvalue1 =
              detail['manager']
          }
        } else {
          message.error(response.data.message)
        }
      } catch (error) {
        console.log(error,'error')
        message.error('Failed to load get Parking Lot Details.')
      }
    },
    async initOrderPaymentRecords() {
      try {
        const response = await this.executeBackendInterface(
          'getOrderPaymentRecords',
          {
            current: this.OrderPaymentRecordcurrent2,
            pageSize: this.OrderPaymentRecordpageSize1,
            orderId: this.OrderInformationform1.id,
          }
        )
        if (response.flag) {
          this.OrderPaymentRecorddata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber: item.row_index,
              sourceofPayment1: item.payment_source,
              paymentMethod: item.payment_method,
              transactionAmount1: item.transaction_amount,
              transactiontime: item.transaction_time,
              transactionStatus: item.transaction_status,
            })
          )
          this.OrderPaymentRecordtotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('Failed to load order payment records.')
      }
    },
    async loadOrderPaymentRecords(pagination) {
      this.OrderPaymentRecordcurrent2 = pagination.current
      this.OrderPaymentRecordpageSize1 = pagination.pageSize
      await this.initOrderPaymentRecords()
    },
    async initBillingDetails() {
      try {
        const response = await this.executeBackendInterface(
          'getBillingDetails',
          {
            current: this.BillingDetailscurrent2,
            pageSize: this.BillingDetailspageSize1,
            orderId: this.OrderInformationform1.id,
          }
        )
        if (response.flag) {
          this.BillingDetailsdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber: item.row_index,
              billingType: item.billing_type,
              billingvehicle: item.billing_vehicle,
              billingPeriod1: item.billing_period,
              startTime: item.start_time,
              endTime: item.end_time,
              duration: item.duration,
              amount: item.amount,
            })
          )
          this.BillingDetailstotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('Failed to load billing details.')
      }
    },
    async loadBillingDetails(pagination) {
      this.BillingDetailscurrent2 = pagination.current
      this.BillingDetailspageSize1 = pagination.pageSize
      await this.initBillingDetails()
    },
    async initOrderOperationRecords() {
      try {
        const response = await this.executeBackendInterface(
          'getOrderOperationRecords',
          {
            current: this.OrderOperationRecordcurrent2,
            pageSize: this.OrderOperationRecordpageSize1,
            orderId: this.OrderInformationform1.id,
          }
        )
        if (response.flag) {
          this.OrderOperationRecorddata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber: item.row_index,
              operator: item.operator,
              operationtype: item.operation_type,
              operatingInstructions: item.operation_description,
              operationrecord: item.operation_record,
              operationDetails: item.operation_detail,
              operationtime: item.operation_time,
            })
          )
          this.OrderOperationRecordtotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('Failed to load order operation records.')
      }
    },
    async loadOrderOperationRecords(pagination) {
      this.OrderOperationRecordcurrent2 = pagination.current
      this.OrderOperationRecordpageSize1 = pagination.pageSize
      await this.initOrderOperationRecords()
    },
  
    async initParkingOrders() {
      try {
        const response = await this.executeBackendInterface(
          'getParkingOrdersZFS',
          {
            current: this.ParkingOrderTablecurrent2,
            pageSize: this.ParkingOrderTablepageSize1,
          }
        )
        if (response.flag) {
          this.ParkingOrderTabledata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              row_index: item.row_index,
              orderNumber: item.order_code,
              licenseplatenumber: item.license_plate,
              typeoflicenseplate: item.license_type,
              parking: item.parking_lot,
              orderStatus: item.order_status,
              paymentStatus: item.payment_status,
              driveintime: item.entry_time,
              departureTime: item.exit_time,
              parkingduration: this.handleFormattedDuration(item.parking_duration),
              // parkingduration: item.parking_duration,
              orderAmount: item.order_amount,
              preferentialamount: item.discount_amount,
              amountreceivable: item.receivable_amount,
              paidinamount: item.received_amount,
              refundamount: item.refund_amount,
              paymentchannel: item.payment_channel,
              preferentialchannels: item.discount_channel,
              feecollectingpersonnel: item.cashier,
              parkinglotid:item.parking_lot_id,
              operation: item.operation,
            })
          )
          this.ParkingOrderTabletotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('Failed to load parking orders.')
      }
    },
    async loadParkingOrders(pagination) {
      this.ParkingOrderTablecurrent2 = pagination.current
      this.ParkingOrderTablepageSize1 = pagination.pageSize
      await this.initParkingOrders()
    },
    async showOrderDetails(record) {
      // 订单详情回显
      this.OrderDetailsisShow1 = true
      this.ParkingOrderMenuselectedKeys1 = ['订单信息']
      this.ParkingOrdersDynamicPanelselectKey1 = '1'
      this.OrderInformationform1.id = record.id
      this.BillingDetailscurrent2=1
      this.OrderOperationRecordcurrent2=1

      await this.getOrderDetails(record.id)
      await this.getVehicleList(record.licenseplatenumber,record.id)
      // await this.getVehicleList(record.licenseplatenumber)
      await this.getParkingLotDetails(record.parkinglotid)
      await this.initOrderPaymentRecords()
      await this.initBillingDetails()
      await this.initOrderOperationRecords()
    },
    // 退款 弹窗 确定
    async confirmOrderRefund() {
      console.log(
        '🚀 ~ onOk: ~ this.OrderInformationform1:',
        this.OrderInformationform1
      )

      // 校验 退款金额
      if (!this.OrderRefundform1.Refundamountvalue1) return message.error('请输入退款金额')
      if (this.OrderRefundform1.Refundamountvalue1 > this.OrderRefundform1.Actualamountpaidvalue1) return message.error('退款金额高于实付金额')

      Modal.confirm({
        title: '确认退款',
        content: '确定要进行退款操作吗？',
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface(
              'updateRefundAmount',
              {
                // orderId: this.OrderInformationform1.id,
                orderId: this.OrderRefundform1.id,
                refundAmount: this.OrderRefundform1.Refundamountvalue1,
              }
            )
            if (response.flag) {
              this.OrderRefundisShow1 = false
              // 刷新列表
              this.initParkingOrders()

              // this.ParkingOrderTabledata1.dataSource =
              //   this.ParkingOrderTabledata1.dataSource.map((item) => {
              //     // if (item.id === this.OrderInformationform1.id) {
              //     if (item.id === this.OrderRefundform1.id) {
              //       return {
              //         ...item,
              //         paymentStatus: '已支付,已退款',
              //         refundamount: this.OrderRefundform1.Refundamountvalue1,
              //       }
              //     }
              //     return item
              //   })
              message.success('退款成功')
            } else {
              message.error(response.message)
            }
          } catch (error) {
            message.error('Failed to process refund.')
          }
        },
        onCancel: () => {
          message.info('取消退款操作')
        },
      })
    },
    // 退款 弹窗 取消
    closeRefundModal() {
      this.OrderRefundisShow1 = false
    },
    // 完成 弹窗 确定
    async confirmOrderComplete() {
      console.log(
        '🚀 ~ onOk: ~ this.OrderInformationform1:',
        this.OrderInformationform1
      )

      // 校验 实收金额
      if (!this.OrderCompleteform1.Completeamountvalue1)
        return message.error('请输入实收金额')

      Modal.confirm({
        title: '确认完成',
        content: '确定要进行完成操作吗？',
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface(
              'completeOrder',
              {
                id: this.OrderCompleteform1.id,
                receivedAmount: this.OrderCompleteform1.Completeamountvalue1,
              }
            )
            if (response.flag) {
              message.success('操作成功')
              this.OrderCompleteShow1 = false

              // 刷新列表
              this.initParkingOrders()
            } else {
              message.error(response.message)
            }
          } catch (error) {
            // message.error('Failed to load parking orders.')
          }
        },
        onCancel: () => {
        },
      })
    },
    // 完成 弹窗 取消
    closeCompleteModal() {
      this.OrderCompleteShow1 = false
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285476613750784'
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
          .post('./Parkingorders/' + funcName, params, {
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
    // 分钟 转化 小时分钟 5370分钟 转化为 89小时30分钟
    handleFormattedDuration(totalMinutes) {
      // 定义总分钟数 totalMinutes 5370分钟
      
      // 计算小时数和剩余的分钟数
      const hours = Math.floor(totalMinutes / 60); // 5370 / 60 = 89 小时余 30 分钟
      const remainingMinutes = totalMinutes % 60;  // 5370 % 60 = 30 分钟
      
      // 格式化输出
      let formattedDuration = `${String(hours).padStart(2, '0')}小时${String(remainingMinutes).padStart(2, '0')}分钟`;
      
      console.log(formattedDuration); // 输出：89小时30分
      if (formattedDuration === '00小时00分钟') {
        formattedDuration = null
      }
      return formattedDuration
    },
  },
  mounted() {
    loadCss('./css/停车订单/theme.css')
    this.initParkingOrders()
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables()
  },
  computed: {
    OrderInformationformState1() {
      switch (this.ParkingOrdersDynamicPanelselectKey1) {
        case '1':
          return {
            statusId: '1',
          }
        case '2':
          return {
            statusId: '2',
          }
        case '3':
          return {
            statusId: '3',
          }
        case '4':
          return {
            statusId: '4',
          }
        default:
          console.log('状态不存在!')
          return {
            statusId: '4',
          }
      }
    },
    AccessInformationformState1() {
      switch (this.ParkingOrdersDynamicPanelselectKey1) {
        case '1':
          return {
            statusId: '1',
          }
        case '2':
          return {
            statusId: '2',
          }
        case '3':
          return {
            statusId: '3',
          }
        case '4':
          return {
            statusId: '4',
          }
        default:
          console.log('状态不存在!')
          return {
            statusId: '4',
          }
      }
    },
    BillingInformationformState1() {
      switch (this.ParkingOrdersDynamicPanelselectKey1) {
        case '1':
          return {
            statusId: '1',
          }
        case '2':
          return {
            statusId: '2',
          }
        case '3':
          return {
            statusId: '3',
          }
        case '4':
          return {
            statusId: '4',
          }
        default:
          console.log('状态不存在!')
          return {
            statusId: '4',
          }
      }
    },
    OrderRecordformState1() {
      switch (this.ParkingOrdersDynamicPanelselectKey1) {
        case '1':
          return {
            statusId: '1',
          }
        case '2':
          return {
            statusId: '2',
          }
        case '3':
          return {
            statusId: '3',
          }
        case '4':
          return {
            statusId: '4',
          }
        default:
          console.log('状态不存在!')
          return {
            statusId: '4',
          }
      }
    },
  },
}
</script>
<style lang="less">
.webVueAntYtSpanStyle-undefined {
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
.webVueAntYtSpanStyle-undefined span {
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

.webVueAntYtSpanStyle-undefinedgzvf7 {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-undefinedgzvf7 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefined {
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

.webVueAntYtRectangleStyle-undefinedrrtuv {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-undefined {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-undefined .ant-form-item-label label {
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
.webVueAntYtInputFormItem-undefined .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-undefined:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-undefined.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-undefined.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-undefined:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-undefined:not(
    .ant-input-affix-wrapper
  )::-webkit-input-placeholder,
.webVueAntYtInputStyle-undefined input::placeholder,
.webVueAntYtInputStyle-undefined input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-undefined9ms5h .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined9ms5h .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined9ms5h
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefined2q6im:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedqndu5 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedqndu5 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedqndu5
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedfu7lg:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-undefined {
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
.webVueAntYtButtonStyle-undefined > span {
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

.webVueAntYtButtonStyle-undefinedpw65g {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefinedpw65g > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-undefinedpwmqc {
  color: #333333 !important;
  background: transparent !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefinedpwmqc > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRangePickerFormItem-undefined {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtRangePickerFormItem-undefined .ant-form-item-label label {
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
.webVueAntYtRangePickerFormItem-undefined
  .ant-form-item-label
  label
  .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtRangePickerStyle-undefined {
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
.webVueAntYtRangePickerStyle-undefined.ant-picker:hover {
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
}
.webVueAntYtRangePickerStyle-undefined.ant-picker-focused,
.webVueAntYtRangePickerStyle-undefined.ant-picker:hover {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtRangePickerStyle-undefined .ant-picker-input > input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtRangePickerStyle-undefined .ant-picker-input > input::placeholder {
  color: #999999;
}
.popup_yt-jxbr2m17gi3ee-undefined.dropdownClassName
  .ant-picker-panel-container {
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
.popup_yt-jxbr2m17gi3ee-undefined.dropdownClassName
  .ant-picker-panel-container
  .ant-picker-header,
.popup_yt-jxbr2m17gi3ee-undefined.dropdownClassName
  .ant-picker-panel-container
  .ant-picker-panel
  table
  tr
  th,
.popup_yt-jxbr2m17gi3ee-undefined.dropdownClassName
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

.webVueAntYtRangePickerFormItem-undefinedp6lkc .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtRangePickerFormItem-undefinedp6lkc .ant-form-item-label label {
  width: 80px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-undefinedp6lkc
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtRangePickerStyle-undefined0dqv3.ant-picker-focused,
.webVueAntYtRangePickerStyle-undefined0dqv3.ant-picker:hover {
  border-right: 1px solid #cdcdcd !important;
}

.webVueAntYtSelectFormItem-undefined {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtSelectFormItem-undefined .ant-form-item-label label {
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
.webVueAntYtSelectFormItem-undefined .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtSelectStyle-undefined .ant-select-selector {
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
.webVueAntYtSelectStyle-undefined.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtSelectStyle-undefined.ant-select-focused:not(
    .ant-select-disabled
  ).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtSelectStyle-undefined
  .ant-select-selector
  .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  line-height: 20px;
}
.webVueAntYtSelectStyle-undefined
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
.webVueAntYtSelectStyle-undefined
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
.ant-select-multiple .ant-select-selector::after {
  display: inline-block;
  width: 0;
  margin: 0px 0;
  line-height: 20px;
  content: '\a0';
}
.ant-select-multiple .ant-select-selection-item {
  height: 20px;
}
.popup_yt-p8pfbm17gi3h2-undefined.ant-select-dropdown {
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
.popup_yt-p8pfbm17gi3h2-undefined.ant-select-dropdown .ant-select-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popup_yt-p8pfbm17gi3h2-undefined.ant-select-dropdown
  .ant-select-item-option-selected {
  background: #e6effe;
  color: #333333;
}
.popup_yt-p8pfbm17gi3h2-undefined.ant-select-dropdown .ant-select-item:hover {
  background: #f0f0f0;
  color: #333333;
}
.popup_yt-p8pfbm17gi3h2-undefined
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

.webVueAntYtSelectFormItem-undefinedq8ota .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-undefinedq8ota .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-undefinedq8ota
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtRangePickerFormItem-undefinedk2c2a .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtRangePickerFormItem-undefinedk2c2a .ant-form-item-label label {
  width: 80px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-undefinedk2c2a
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtRangePickerStyle-undefined7vwcs.ant-picker-focused,
.webVueAntYtRangePickerStyle-undefined7vwcs.ant-picker:hover {
  border-right: 1px solid #cdcdcd !important;
}

.webVueAntYtRectangleStyle-undefined97qc3 {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSelectFormItem-undefined8iyax .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-undefined8iyax .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-undefined8iyax
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputNumberFormItem-undefined {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputNumberFormItem-undefined .ant-form-item-label label {
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
.webVueAntYtInputNumberFormItem-undefined
  .ant-form-item-label
  label
  .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputNumberStyle-undefined {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
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
}
.webVueAntYtInputNumberStyle-undefined input {
  font-weight: Normal;
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 12px;
}
.webVueAntYtInputNumberStyle-undefined input::placeholder,
.webVueAntYtInputNumberStyle-undefined input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntInputNumberFormItem {
  flex-wrap: nowrap;
}
.webVueAntInputNumberFormItem,
.webVueAntInputNumberFormItem .ant-form-item-control-input,
.webVueAntInputNumberFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content,
.webVueAntInputNumber,
.webVueAntInputNumber .ant-input-number-input-wrap,
.webVueAntInputNumber .ant-input-number-input-wrap input {
  width: 100%;
  height: 100%;
}
.webVueAntInputNumberFormItem .ant-form-item-control-input {
  min-height: unset !important;
}
.webVueAntInputNumberFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntInputNumberFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntInputNumberFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(
    .ant-form-item-required-mark-optional
  ):before {
  margin-top: 4px;
}
.webVueAntInputNumberFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputNumberFormItem
  .ant-form-item-label
  > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputNumberFormItem
  .ant-form-item-label
  label
  .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputNumberFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputNumberFormItem .ant-form-item-content:focus {
  outline: none;
}

.webVueAntYtInputNumberFormItem-undefinedago8u .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-undefinedago8u .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-undefinedetfhj {
  background: #ffffff !important;
}

.webVueAntYtInputNumberFormItem-undefined3841k .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-undefined3841k .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-undefinedfihpd {
  background: #ffffff !important;
}

.webVueAntYtSpanStyle-undefinedt7adn {
  color: #3d3d3d !important;
}
.webVueAntYtSpanStyle-undefinedt7adn span {
  text-decoration: none;
}

.webVueAntYtInputFormItem-undefinedd2bra .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedd2bra .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedd2bra
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedtt0t4:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtSelectFormItem-undefined5rxgn .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-undefined5rxgn .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-undefined5rxgn
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectFormItem-undefinedsu1m6 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-undefinedsu1m6 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-undefinedsu1m6
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle-undefined9n6f7 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefined9n6f7 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-undefined .ant-modal-wrap {
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
.webVueAntYtModalStyle-undefined .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-undefined.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-undefined .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-undefined.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtModalStyle-undefineddz7kq .ant-modal-wrap .yt-custom-modal-header {
  font-size: 16px;
  font-weight: bold;
}

.webVueAntYtVerticleMenuStyle-undefined.ant-menu {
  opacity: 1;
  box-shadow: 0px 0px 0px 0px transparent !important;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  font-style: normal;
  background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-undefined.ant-menu
  .ant-menu-submenu-inline
  .ant-menu-inline,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu
  .yt-horizontal-menu-menu-sub-menu
  .ant-menu-item,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu
  .yt-horizontal-menu-menu-sub-menu
  .ant-menu-submenu {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-undefined.ant-menu .ant-menu-vertical {
  background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-undefined.ant-menu .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu
  .yt-horizontal-menu-menu-sub-menu
  .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-undefined
  .ant-menu-submenu-selected
  > .ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu
  .sub-menu-selected
  > .ant-menu-submenu-title
  > .ant-menu-title-content {
  color: #3c8eff;
}
.webVueAntYtVerticleMenuStyle-undefined.webVueAntYtVerticleMenu.ant-menu
  .ant-menu-item.ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-undefined.webVueAntYtVerticleMenu.ant-menu
  .sub-menu-selected
  > .ant-menu-submenu-title {
  background: #e6effe;
}
.webVueAntYtVerticleMenuStyle-undefined
  .ant-menu-submenu:not(.ant-menu-item-selected):hover
  > .ant-menu-submenu-title
  > .ant-menu-submenu-arrow,
.webVueAntYtVerticleMenuStyle-undefined
  .ant-menu-submenu:not(.ant-menu-item-selected):hover
  > .ant-menu-submenu-title
  > .ant-menu-submenu-expand-icon,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu-light
  .ant-menu-item:not(.ant-menu-item-selected):hover,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu-light
  .ant-menu-submenu-title:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ):hover {
  color: #3c8eff;
  background: #ffffff !important;
}
.webVueAntYtVerticleMenuStyle-undefined.ant-menu-light
  .ant-menu-submenu-title:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ):hover,
.webVueAntYtVerticleMenuStyle-undefined.ant-menu-light.ant-menu:not(
    .ant-menu-inline
  )
  .ant-menu-submenu-open:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ) {
  color: #3c8eff;
}
.webVueAntYtVerticleMenuStyle-undefined.webVueAntYtVerticleMenu.ant-menu-light
  .ant-menu-item-active:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ),
.webVueAntYtVerticleMenuStyle-undefined.webVueAntYtVerticleMenu.ant-menu-light
  .ant-menu-submenu-active:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ) {
  color: #3c8eff;
}
.webVueAntYtVerticleMenuStyle-undefined.webVueAntYtVerticleMenu
  .ant-menu-item.ant-menu-item-selected:hover,
.webVueAntYtVerticleMenuStyle-undefined
  .ant-menu-submenu-title.ant-menu-item-selected:hover {
  color: #3c8eff;
}
.webVueAntYtVerticleMenu {
  width: 100%;
  height: 100%;
}
.webVueAntYtVerticleMenu div > li > .ant-menu-submenu-title {
  height: 100%;
}

.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu {
  box-shadow: 0px 0px 0px 0px transparent !important;
}
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  div
  > li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  div
  > li
  > .ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  div
  > li.ant-menu-item.ant-menu-item-only-child {
  height: 32px;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-undefinedqt0zq div > li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq div > li > .ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq
  div
  > li.ant-menu-item.ant-menu-item-only-child {
  height: 32px;
  text-decoration: none;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  .ant-menu-submenu-inline
  .ant-menu-inline
  li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  .ant-menu-submenu-inline
  .ant-menu-inline
  li.ant-menu-item-only-child,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-inline
  .ant-menu-submenu-inline
  .ant-menu-inline
  li
  > .ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-vertical
  .ant-menu-submenu-popup
  .ant-menu-vertical
  li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-vertical
  .ant-menu-submenu-popup
  .ant-menu-vertical
  li.ant-menu-item-only-child,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-vertical
  .ant-menu-submenu-popup
  .ant-menu-vertical
  li
  > .ant-menu-submenu-title {
  height: 32px;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-undefinedqt0zq
  .ant-menu-submenu:not(.ant-menu-item-selected):hover
  > .ant-menu-submenu-title
  > .ant-menu-submenu-arrow,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq
  .ant-menu-submenu:not(.ant-menu-item-selected):hover
  > .ant-menu-submenu-title
  > .ant-menu-submenu-expand-icon,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-light
  .ant-menu-item:not(.ant-menu-item-selected):hover,
.webVueAntYtVerticleMenuStyle-undefinedqt0zq.ant-menu-light
  .ant-menu-submenu-title:not(.ant-menu-item-selected):not(
    .ant-menu-submenu-selected
  ):hover {
  background: #ffffff !important;
}

.webVueAntForm {
  width: 100%;
  height: 100%;
  overflow:hidden;
  overflow-x: auto;
  background-color: var(--web-vue-ant-form-bg-color);
}

.webVueAntYtInputFormItem-undefinedr4pnw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedr4pnw .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedftrzv:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedile0i .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedile0i .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedile0i
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefineduxkwl:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined9pjuk .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined9pjuk .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinede9zsx:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedhdlvq .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedhdlvq .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedhdlvq
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedl0k4z:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedr4kcw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedr4kcw .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedpbfif:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined4657j .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined4657j .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined4657j
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefined6wivz:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedzz7sm .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedzz7sm .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedqiy2d:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedibqha .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedibqha .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedibqha
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedsg12f:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined1vcf3 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined1vcf3 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined1vcf3
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedewwrc:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined0594y .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined0594y .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined0594y
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinediu5u2:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedw7bvp .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedw7bvp .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedw7bvp
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedgjfgk:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined17n4p .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined17n4p .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined17n4p
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedgqah7:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedtwrrv .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedtwrrv .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedtwrrv
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedky5wt:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedhrtqp .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedhrtqp .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedhrtqp
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefined4o0bc:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedl8g1k .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedl8g1k .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedl8g1k
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedjwmxz:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtRectangleStyle-undefinedx3dz9 {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefined9ehj7 {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefined9ehj7 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefinedo10b0 {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedde407 {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedde407 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefined4tlpq {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedofv3v {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedofv3v span {
  text-decoration: none;
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

.webVueAntYtTableStyle-undefinedcrfib {
  opacity: 1;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table {
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
.webVueAntYtTableStyle-undefinedcrfib .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table .ant-table-thead tr th {
  background: #f6f6f6;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
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
.webVueAntYtTableStyle-undefinedcrfib .ant-table tbody tr td {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table thead tr th,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedcrfib.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedcrfib.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-tbody
  tr.ant-table-row-selected
  td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination button,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination li input {
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
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination button,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination li input,
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination li a,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-undefinedcrfib .ant-pagination li a,
.webVueAntYtTableStyle-undefinedcrfib
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
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-undefinedcrfib
  .ant-pagination
  li.ant-pagination-item-active
  a {
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
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(1)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(1),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(1) {
  width: 40px !important;
  min-width: 40px !important;
  max-width: 40px !important;
}
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(2)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(2),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: calc((100% - 40px) / 5) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(3)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(3),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 40px) / 5) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(4)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(4),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 40px) / 5) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(5)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(5),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 40px) / 5) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedcrfib tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedcrfib
  tr
  td:nth-child(6)
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
.webVueAntYtTableStyle-undefinedcrfib tr > th:nth-child(6),
.webVueAntYtTableStyle-undefinedcrfib
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 40px) / 5) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedcrfib {
  width: 100%;
}

.webVueAntYtInputFormItem-undefineddok83 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefineddok83 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedj8kav:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedjl3t5 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedjl3t5 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedjl3t5
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefined3yrtx:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined0x3iw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined0x3iw .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefined4sffo:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedenk1l .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedenk1l .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedenk1l
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedjoyp2:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined9txq3 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined9txq3 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedb8r5c:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined8k042 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined8k042 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefined8k042
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedqqgkt:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedwuv2b .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedwuv2b .ant-form-item-label label {
  width: 66px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedn6sp1:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedw7xfm .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedw7xfm .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-undefinedw7xfm
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-undefinedh0s65:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedtorvi .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedtorvi .ant-form-item-label label {
  width: 81px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedbxm4k:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedks5m7 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedks5m7 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefined80d2p:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefined9wz0k .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined9wz0k .ant-form-item-label label {
  width: 81px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinediiu9x:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedh1oid .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedh1oid .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedyj0tz:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtRectangleStyle-undefinedasnq9 {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefined4zsc4 {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefined4zsc4 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefined4rap9 {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedjpl74 {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedjpl74 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefined517rl {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedm7dl4 {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedm7dl4 span {
  text-decoration: none;
}

.webVueAntYtInputFormItem-undefined4sfjd .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined4sfjd .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinediheza:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtRectangleStyle-undefinedhtsgw {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedaegia {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedaegia span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-undefinede13kz {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedq598d {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedq598d span {
  text-decoration: none;
}

.webVueAntYtTableStyle-undefinedta8zu {
  opacity: 1;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table {
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
.webVueAntYtTableStyle-undefinedta8zu .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table .ant-table-thead tr th {
  background: #f6f6f6;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
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
.webVueAntYtTableStyle-undefinedta8zu .ant-table tbody tr td {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table thead tr th,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedta8zu.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedta8zu.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-tbody
  tr.ant-table-row-selected
  td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination button,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination li input {
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
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination button,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination li input,
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination li a,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-undefinedta8zu .ant-pagination li a,
.webVueAntYtTableStyle-undefinedta8zu
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
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-undefinedta8zu
  .ant-pagination
  li.ant-pagination-item-active
  a {
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
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(1)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(1),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(1) {
  width: 40px !important;
  min-width: 40px !important;
  max-width: 40px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(2)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(2),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(3)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(3),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(4)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(4),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(5)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(5),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(6)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(6),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(7)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(7),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(7) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedta8zu
  tr
  td:nth-child(8)
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
.webVueAntYtTableStyle-undefinedta8zu tr > th:nth-child(8),
.webVueAntYtTableStyle-undefinedta8zu
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(8) {
  width: calc((100% - 40px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedta8zu {
  width: 100%;
}

.webVueAntYtRectangleStyle-undefinednynd4 {
  background: #1890ff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-undefinedduxpq {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-undefinedduxpq span {
  text-decoration: none;
}

.webVueAntYtTableStyle-undefinedsyozj {
  opacity: 1;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table {
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
.webVueAntYtTableStyle-undefinedsyozj .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table .ant-table-thead tr th {
  background: #f6f6f6;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
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
.webVueAntYtTableStyle-undefinedsyozj .ant-table tbody tr td {
  height: 40px;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 40px;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table thead tr th,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedsyozj.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedsyozj.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-tbody
  tr.ant-table-row-selected
  td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination button,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination li input {
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
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination button,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination li input,
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination li a,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-undefinedsyozj .ant-pagination li a,
.webVueAntYtTableStyle-undefinedsyozj
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
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-undefinedsyozj
  .ant-pagination
  li.ant-pagination-item-active
  a {
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
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(1)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(1),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(1) {
  width: 40px !important;
  min-width: 40px !important;
  max-width: 40px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(2)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(2),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(3)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(3),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(4)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(4),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(5)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(5),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(6)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(6),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedsyozj
  tr
  td:nth-child(7)
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
.webVueAntYtTableStyle-undefinedsyozj tr > th:nth-child(7),
.webVueAntYtTableStyle-undefinedsyozj
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(7) {
  width: calc((100% - 40px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedsyozj {
  width: 100%;
}

.webVueAntYtTableStyle-undefinedyvi9o {
  opacity: 1;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table {
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
.webVueAntYtTableStyle-undefinedyvi9o .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
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
.webVueAntYtTableStyle-undefinedyvi9o .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table thead tr th,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  .ant-table-tbody
  tr:not(:last-child)
  td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-undefinedyvi9o.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedyvi9o.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-tbody
  tr.ant-table-row-selected
  td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination button,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination li input {
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
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination button,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li
  .ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination li input,
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination li a,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li
  .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li:not(.ant-pagination-options),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-undefinedyvi9o .ant-pagination li a,
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-pagination
  li.ant-pagination-item-active
  a {
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
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(2)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(2),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(2) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(3)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(3),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(3) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(4)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(4),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(4) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(5)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(5),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(5) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(6)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(6),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(6) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(7)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(7),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(7) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(8)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(8),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(8) {
  // width: calc((100% - 150px) / 17) !important;
  width: calc((100% - 100px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(9)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(9),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(9) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(10),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(10) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(11),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(11) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(12),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(12) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(13) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(13),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(13) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(14) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(14),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(14) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(15) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(15),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(15) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(16) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(16),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(16) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(17) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(17),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(17) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(18) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(18)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(18),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(18) {
  width: calc((100% - 150px) / 17) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o tr td:nth-child(19) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-undefinedyvi9o
  tr
  td:nth-child(19)
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
.webVueAntYtTableStyle-undefinedyvi9o tr > th:nth-child(19),
.webVueAntYtTableStyle-undefinedyvi9o
  .ant-table-body
  tr.ant-table-measure-row
  td:nth-child(19) {
  width: 150px !important;
  min-width: 150px !important;
  max-width: 150px !important;
  // width: 150px !important;
  // min-width: 150px !important;
  // max-width: 150px !important;
}
.webVueAntYtTableStyle-undefinedyvi9o {
  width: 100%;
}

.webVueAntYtButtonStyle-undefinedckgl9 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefinedckgl9 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-undefined80e3o {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefined80e3o > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-undefinedixftu {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefinedixftu > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-undefined3wjok {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-undefined3wjok > span {
  letter-spacing: 0px !important;
}

.webVueAntYtSpanStyle-undefined702m7 {
  color: #3d3d3d !important;
}
.webVueAntYtSpanStyle-undefined702m7 span {
  text-decoration: none;
}

.webVueAntYtPicture {
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.webVueAntYtPicture img,
.webVueAntYtPicture .ant-image {
  width: 100%;
  height: 100%;
}

.webVueAntYtPictureStyle-undefinedj44ke {
  opacity: 1;
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

.webVueAntYtSpanStyle-undefinedq4kav {
  color: #3d3d3d !important;
}
.webVueAntYtSpanStyle-undefinedq4kav span {
  text-decoration: none;
}

.webVueAntYtPictureStyle-undefined20ro7 {
  opacity: 1;
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

.webVueAntYtSpanStyle-undefined3o471 {
  color: #3d3d3d !important;
}
.webVueAntYtSpanStyle-undefined3o471 span {
  text-decoration: none;
}

.webVueAntYtPictureStyle-undefinedj5ff2 {
  opacity: 1;
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

.webVueAntYtSelectFormItem-undefined38klw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-undefined38klw .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtSelectFormItem-undefined38klw
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem-undefined6fqf9 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefined6fqf9 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedpdmol:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-undefinedbfcdm .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-undefinedbfcdm .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-undefinedahcvx:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.customStyle  .ant-table-cell:nth-last-child(2){
    width:150px!important;
  }

  .ant-image-preview-img {
    position: absolute;
    left: 13%;
    top: 10%;
    max-width: 80%;
    max-height: 80%;
  }
</style>
