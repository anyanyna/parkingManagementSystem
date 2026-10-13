<template>
  <div
    style="width: 100%; height: 100%; overflow: hidden; background: #f0f2f5"
    class="rootContainer flexCol spaceEnd"
  >
    <div
      style="height: 1.97%; z-index: 1; transform: translateY(-80%)"
      class="flexRow spaceStart"
    >
      <div
        style="
          position: absolute;
          left: 1.18%;
          top: 0%;
          width: 130px;
          height: 100%;
          z-index: 1;
        "
      >
        <span
          ref="ref1"
          class="webVueAntYtSpan webVueAntYtSpanStyle-gz webVueAntYtSpanStyle"
        >
          <span v-html="'财务管理 / 资金管理'"> </span>
        </span>
      </div>
    </div>

    <div
      style="height: 3.05%; z-index: 2; transform: translateY(2.1%)"
      class="flexRow spaceStart"
    >
      <div
        style="
          z-index: 2;
          width: 24.59%;
          height: 100%;
          transform: translateX(4.89%);
        "
      >
        <yt-horizontal-menu-menu
          ref="ref17"
          @toSelect="
            (key, item, selectedKeys) => {
              switchDynamicPanelState(key, item, selectedKeys);
            }
          "
          class="webVueAntYtMenu webVueAntYtMenuStyle-gz5ze0s webVueAntYtMenuStyle-gz webVueAntYtMenuStyle"
          v-model:openKeys="HorizontalmenuopenKeys1"
          v-model:selectedKeys="HorizontalmenuselectedKeys1"
          :items="Horizontalmenuoptions1.dataSource"
        >
        </yt-horizontal-menu-menu>
      </div>
    </div>

    <div
      style="height: 91.83%; z-index: 3; transform: translateY(-0.01%)"
      class="flexRow spaceAround"
    >
      <div
        style="
          position: absolute;
          left: -0.01%;
          top: 0%;
          width: 100%;
          height: 100%;
          z-index: 4;
        "
      >
        <yt-dynamic-panel ref="ref58" class="webVueAntYtDynamicPanel">
          <div
            style="position: relative; height: 100%; width: 100%"
            backgroundType="color"
            background="#00000000"
            slotWidth="1698"
            slotHeight="931"
            yt-domslot="ytDynamicPanel"
            yt-template
          >
            <div
              style="
                width: 100%;
                height: 100%;
                overflow: hidden;
                background: #00000000;
              "
              class="rootContainer flexCol spaceStart"
            >
              <!-- 修改动态面板的状态到收入流水，对应的是修改DynamicPanelselectKey1为1 -->
              <div
                v-if="DynamicPanelselectKey1 == 1"
                style="width: 100%; height: 100%"
              >
                <div
                  style="height: 12.89%; z-index: 1"
                  class="flexRow spaceAround"
                >
                  <div style="z-index: 1; width: 97.76%; height: 100%">
                    <a-form
                      ref="ref79"
                      :model="SearchBoxform1"
                      :class="[
                        'webVueAntForm',
                        'webVueAntYtFormStyle-gz',
                        'webVueAntYtFormStyle',
                      ]"
                    >
                      <div
                        style="position: relative; height: 100%; width: 100%"
                        backgroundType="color"
                        slotWidth="1658"
                        slotHeight="118"
                        yt-domslot="ytForm"
                        yt-template
                      >
                        <div
                          style="width: 100%; height: 100%; overflow: hidden"
                          class="rootContainer flexCol spaceStart"
                        >
                          <div
                            style="
                              height: 27.12%;
                              z-index: 1;
                              transform: translateY(62.5%);
                            "
                            class="flexRow spaceAround"
                          >
                            <div
                              style="
                                z-index: 1;
                                width: 19.06%;
                                height: 100%;
                                transform: translateX(-4.98%);
                              "
                            >
                              <a-form-item
                                ref="ref80"
                                class="webVueAntInputFormItem webVueAntYtInputFormItem-gzy7qx2 webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['mobilephonenumber']"
                              >
                                <template #label>
                                  <div class="label-content">
                                    <span
                                      class="ant-form-item-content"
                                      v-html="'手机号：'"
                                    >
                                    </span>
                                  </div>
                                </template>
                                <a-input
                                  data-event
                                  class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                                  v-model:value="
                                    SearchBoxform1.mobilephonenumber
                                  "
                                  :maxLength="100"
                                  :placeholder="'请输入'"
                                >
                                </a-input>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 5;
                                width: 18.94%;
                                height: 100%;
                                transform: translateX(-0.11%);
                              "
                            >
                              <a-form-item
                                ref="ref84"
                                class="webVueAntInputFormItem webVueAntYtInputFormItem-gzqthc3 webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['licenseplatenumber']"
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
                                  class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                                  v-model:value="
                                    SearchBoxform1.licenseplatenumber
                                  "
                                  :maxLength="100"
                                  :placeholder="'请输入'"
                                >
                                </a-input>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 7;
                                width: 19.84%;
                                height: 100%;
                                transform: translateX(-0.06%);
                              "
                            >
                              <a-form-item
                                ref="ref86"
                                class="webVueSelectFormItem webVueAntYtSelectFormItem-gzwyinm webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['paymentchannel']"
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
                                <a-select
                                  data-event
                                  class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                                  dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                                  :showArrow="true"
                                  v-model:value="SearchBoxform1.paymentchannel"
                                  :placeholder="'请输入'"
                                  :mode="'single'"
                                  :options="paymentchanneloptions1.dataSource"
                                  :showSearch="true"
                                >
                                </a-select>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 6;
                                width: 18.15%;
                                height: 100%;
                                transform: translateX(10.55%);
                              "
                            >
                              <a-form-item
                                ref="ref85"
                                class="webVueSelectFormItem webVueAntYtSelectFormItem-gz3tgxr webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['type']"
                              >
                                <template #label>
                                  <div class="label-content">
                                    <span
                                      class="ant-form-item-content"
                                      v-html="'类型：'"
                                    >
                                    </span>
                                  </div>
                                </template>
                                <a-select
                                  data-event
                                  class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                                  dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                                  :showArrow="true"
                                  v-model:value="SearchBoxform1.type"
                                  :placeholder="'请输入'"
                                  :mode="'single'"
                                  :options="Typeoptions1.dataSource"
                                  :showSearch="true"
                                >
                                </a-select>
                              </a-form-item>
                            </div>
                          </div>

                          <div
                            style="
                              height: 27.12%;
                              z-index: 2;
                              transform: translateY(112.5%);
                            "
                            class="flexRow spaceBetween"
                          >
                            <div
                              style="
                                z-index: 4;
                                width: 19.9%;
                                height: 100%;
                                transform: translateX(6.06%);
                              "
                            >
                              <a-form-item
                                ref="ref83"
                                class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-gzo0ogm webVueAntYtRangePickerFormItem-gz webVueAntYtRangePickerFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['arrivalTime']"
                              >
                                <template #label>
                                  <div class="label-content">
                                    <span
                                      class="ant-form-item-content"
                                      v-html="'到账时间：'"
                                    >
                                    </span>
                                  </div>
                                </template>
                                <yt-custom-range-picker
                                  data-event
                                  class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-gz webVueAntYtRangePickerStyle"
                                  popupKey="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                                  v-model:value="SearchBoxform1.arrivalTime"
                                >
                                </yt-custom-range-picker>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 9;
                                width: 20.75%;
                                height: 100%;
                                transform: translateX(-5.7%);
                              "
                            >
                              <a-form-item
                                ref="ref113"
                                class="webVueAntInputFormItem webVueAntYtInputFormItem-gzaw3qs webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['platformSerialNumber']"
                              >
                                <template #label>
                                  <div class="label-content">
                                    <span
                                      class="ant-form-item-content"
                                      v-html="'平台流水号：'"
                                    >
                                    </span>
                                  </div>
                                </template>
                                <a-input
                                  data-event
                                  class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                                  v-model:value="
                                    SearchBoxform1.platformSerialNumber
                                  "
                                  :maxLength="100"
                                  :placeholder="'请输入'"
                                >
                                </a-input>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 8;
                                width: 21.59%;
                                height: 100%;
                                transform: translateX(-20.53%);
                              "
                            >
                              <a-form-item
                                ref="ref112"
                                class="webVueAntInputFormItem webVueAntYtInputFormItem-gzxbqoc webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                                :colon="false"
                                :rules="[]"
                                :name="['thirdpartyserialnumber']"
                              >
                                <template #label>
                                  <div class="label-content">
                                    <span
                                      class="ant-form-item-content"
                                      v-html="'第三方流水号：'"
                                    >
                                    </span>
                                  </div>
                                </template>
                                <a-input
                                  data-event
                                  class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                                  v-model:value="
                                    SearchBoxform1.thirdpartyserialnumber
                                  "
                                  :maxLength="100"
                                  :placeholder="'请输入'"
                                >
                                </a-input>
                              </a-form-item>
                            </div>

                            <div
                              style="
                                z-index: 3;
                                width: 3.86%;
                                height: 100%;
                                transform: translateX(147.98%);
                              "
                            >
                              <a-button
                                ref="ref82"
                                @click="
                                  () => {
                                    searchIncomeFlowData();
                                  }
                                "
                                class="webVueAntButton webVueAntYtButtonStyle-gz8wk0z webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                                :loading="Searchloading1"
                              >
                                <span class="yt-button-content" v-html="'搜索'">
                                </span>
                              </a-button>
                            </div>

                            <div
                              style="
                                z-index: 2;
                                width: 3.86%;
                                height: 100%;
                                transform: translateX(-28.13%);
                              "
                            >
                              <a-button
                                ref="ref81"
                                @click="
                                  () => {
                                    resetIncomeFlowData();
                                  }
                                "
                                class="webVueAntButton webVueAntYtButtonStyle-gzx44wt webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                                :loading="Resetloading1"
                              >
                                <span class="yt-button-content" v-html="'重置'">
                                </span>
                              </a-button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </a-form>
                  </div>
                </div>

                <div
                  style="
                    height: 3.44%;
                    z-index: 2;
                    transform: translateY(112.5%);
                  "
                  class="flexRow spaceStart"
                >
                  <div
                    style="
                      z-index: 2;
                      width: 3.77%;
                      height: 100%;
                      transform: translateX(60.94%);
                    "
                  >
                    <a-button
                      ref="ref87"
                      @click="
                        () => {
                          exportIncomeFlowData();
                        }
                      "
                      :loading="Exportloading1"
                      :class="[
                        'webVueAntButton',
                        'webVueAntYtButtonStyle-gz',
                        'webVueAntYtButtonStyle',
                        'center-gz',
                        'center',
                      ]"
                    >
                      <span class="yt-button-content" v-html="'导出'"> </span>
                    </a-button>
                  </div>
                </div>

                <div
                  style="
                    height: 76.26%;
                    z-index: 3;
                    transform: translateY(7.32%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      z-index: 3;
                      width: 95.47%;
                      height: 100%;
                      transform: translateX(0.03%);
                    "
                  >
                    <yt-table
                      ref="ref88"
                      :selectType="'checkbox'"
                      v-model:selectedRows="IncomeFlowWaterMeterselectedRows1"
                      v-model:total="IncomeFlowWaterMetertotal1"
                      v-model:current="IncomeFlowWaterMetercurrent1"
                      v-model:pageSize="IncomeFlowWaterMeterpageSize1"
                      :columns="IncomeFlowWaterMeterdata1.columns"
                      :dataSource="IncomeFlowWaterMeterdata1.dataSource"
                      :scroll="{ y: 320 }"
                      :class="[
                        'webVueAntYtTable',
                        'webVueAntYtTableStyle-gzlcvf5-1',
                        'webVueAntYtTableStyle-gz',
                        'webVueAntYtTableStyle',
                      ]"
                    >
                      <template #cell="{ column, record }">
                        <template
                          v-if="column.dataIndex === 'id'"
                          :forKey="'id'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="id"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'serialNumber1'"
                          :forKey="'serialNumber1'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="serialNumber1"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom5'"
                          :forKey="'custom5'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="mobilephonenumber"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom4'"
                          :forKey="'custom4'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="licenseplatenumber"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom'"
                          :forKey="'custom'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="arrivalTime"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom1'"
                          :forKey="'custom1'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="amount"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom2'"
                          :forKey="'custom2'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="paymentchannel"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom3'"
                          :forKey="'custom3'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="sourceside"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'custom6'"
                          :forKey="'custom6'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            yt-domslot="region"
                            yt-template
                          ></div>
                        </template>
                        <template
                          v-if="column.dataIndex === 'name'"
                          :forKey="'name'"
                        >
                          <div
                            style="
                              position: relative;
                              height: 100%;
                              width: 100%;
                            "
                            params="record"
                            backgroundType="color"
                            class="customTableTemplate"
                            slotWidth="190"
                            slotHeight="46"
                            yt-domslot="name"
                            yt-template
                          ></div>
                        </template>
                      </template>
                    </yt-table>
                  </div>
                </div>
              </div>
              <!-- 修改动态面板的状态到交易查询，对应的是修改DynamicPanelselectKey1为2 -->
              <div
                v-if="DynamicPanelselectKey1 == 2"
                style="width: 100%; height: 100%"
              >
                <div
                  style="
                    z-index: 4;
                    width: 97.76%;
                    height: 12.89%;
                    margin-left: 1.12%;
                  "
                >
                  <a-form
                    ref="ref89"
                    :model="SearchBoxform2"
                    :class="[
                      'webVueAntForm',
                      'webVueAntYtFormStyle-gz',
                      'webVueAntYtFormStyle',
                    ]"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      backgroundType="color"
                      slotWidth="1658"
                      slotHeight="118"
                      yt-domslot="ytForm"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div
                          style="
                            z-index: 1;
                            width: 19%;
                            height: 27.12%;
                            margin-left: 2.11%;
                            transform: translateY(62.5%);
                          "
                        >
                          <a-form-item
                            ref="ref90"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-gzusm78 webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['licenseplatenumber1']"
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
                              class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                              v-model:value="SearchBoxform2.licenseplatenumber1"
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 2;
                            width: 3.86%;
                            height: 27.12%;
                            margin-left: 95.05%;
                            transform: translateY(112.5%);
                          "
                        >
                          <a-button
                            ref="ref91"
                            @click="
                              () => {
                                resetTransactionQueryData();
                              }
                            "
                            class="webVueAntButton webVueAntYtButtonStyle-gzkq4az webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                            :loading="Resetloading2"
                          >
                            <span class="yt-button-content" v-html="'重置'">
                            </span>
                          </a-button>
                        </div>

                        <div
                          style="
                            z-index: 3;
                            width: 3.86%;
                            height: 27.12%;
                            margin-left: 90.48%;
                            transform: translateY(12.5%);
                          "
                        >
                          <a-button
                            ref="ref92"
                            @click="
                              () => {
                                searchTransactionQueryData();
                              }
                            "
                            class="webVueAntButton webVueAntYtButtonStyle-gzrtj52 webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                            :loading="Searchloading2"
                          >
                            <span class="yt-button-content" v-html="'搜索'">
                            </span>
                          </a-button>
                        </div>

                        <div
                          style="
                            z-index: 4;
                            width: 19.06%;
                            height: 27.12%;
                            margin-left: 79.86%;
                            transform: translateY(-237.5%);
                          "
                        >
                          <a-form-item
                            ref="ref96"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gz6atbu webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['sourceside']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'来源端：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform2.sourceside"
                              :placeholder="'请输入'"
                              :mode="'single'"
                              :options="Sourcesideoptions1.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 5;
                            width: 19.9%;
                            height: 27.12%;
                            margin-left: 27.2%;
                            transform: translateY(-184.38%);
                          "
                        >
                          <a-form-item
                            ref="ref97"
                            class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-gzjzwse webVueAntYtRangePickerFormItem-gz webVueAntYtRangePickerFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['transactiontime']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'交易时间：'"
                                >
                                </span>
                              </div>
                            </template>
                            <yt-custom-range-picker
                              data-event
                              class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-gz webVueAntYtRangePickerStyle"
                              popupKey="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              v-model:value="SearchBoxform2.transactiontime"
                            >
                            </yt-custom-range-picker>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 6;
                            width: 19.9%;
                            height: 27.12%;
                            margin-left: 27.17%;
                            transform: translateY(-437.5%);
                          "
                        >
                          <a-form-item
                            ref="ref125"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gzccjsd webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['yardname']"
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
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform2.yardname"
                              :placeholder="'请选择'"
                              :mode="'multiple'"
                              :options="Yardnameoptions1.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 8;
                            width: 19.9%;
                            height: 27.12%;
                            margin-left: 53.08%;
                            transform: translateY(-537.5%);
                          "
                        >
                          <a-form-item
                            ref="ref126"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gz1vwmy webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['paymentType']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'支付类型：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform2.paymentType"
                              :placeholder="'请选择'"
                              :mode="'multiple'"
                              :options="PaymentTypeoptions1.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 7;
                            width: 19.9%;
                            height: 27.12%;
                            margin-left: 1.21%;
                            transform: translateY(-484.38%);
                          "
                        >
                          <a-form-item
                            ref="ref127"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gzcm9zt webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['businessType']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'业务类型：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform2.businessType"
                              :placeholder="'请选择'"
                              :mode="'multiple'"
                              :options="BusinessTypeoptions1.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 9;
                            width: 20.93%;
                            height: 27.12%;
                            margin-left: 52.06%;
                            transform: translateY(-587.5%);
                          "
                        >
                          <a-form-item
                            ref="ref128"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-gzpfmak webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['platformSerialNumber1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'平台流水号：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-input
                              data-event
                              class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                              v-model:value="
                                SearchBoxform2.platformSerialNumber1
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>
                      </div>
                    </div>
                  </a-form>
                </div>

                <div
                  style="
                    z-index: 5;
                    width: 3.77%;
                    height: 3.44%;
                    margin-left: 2.3%;
                    transform: translateY(112.5%);
                  "
                >
                  <a-button
                    ref="ref98"
                    @click="
                      () => {
                        exportTransactionQueryData();
                      }
                    "
                    :loading="Exportloading2"
                    :class="[
                      'webVueAntButton',
                      'webVueAntYtButtonStyle-gz',
                      'webVueAntYtButtonStyle',
                      'center-gz',
                      'center',
                    ]"
                  >
                    <span class="yt-button-content" v-html="'导出'"> </span>
                  </a-button>
                </div>

                <div
                  style="
                    z-index: 6;
                    width: 95.47%;
                    height: 76.26%;
                    margin-left: 2.3%;
                    transform: translateY(7.32%);
                  "
                >
                  <yt-table
                    ref="ref99"
                    :selectType="'checkbox'"
                    v-model:selectedRows="TransactionQueryTableselectedRows1"
                    v-model:total="TransactionQueryTabletotal1"
                    v-model:current="TransactionQueryTablecurrent1"
                    v-model:pageSize="TransactionQueryTablepageSize1"
                    :columns="TransactionQueryTabledata1.columns"
                    :showTotal="true"
                    :showSizeChanger="true"
                    :pageSizeOptions="{
                      dataSource: [
                        { label: '10', value: 10, select: true },
                        { label: '20', value: 20, select: false },
                        { label: '30', value: 30, select: false },
                        { value: 50, label: '50', select: false },
                        { value: 100, label: '100', select: false },
                      ],
                      value: [10],
                    }"
                    :showQuickJumper="true"
                    :dataSource="TransactionQueryTabledata1.dataSource"
                    :scroll="{ y: 597.9999951304252 }"
                    :class="[
                      'webVueAntYtTable',
                      'webVueAntYtTableStyle-gzz7fp9-2',
                      'webVueAntYtTableStyle-gz',
                      'webVueAntYtTableStyle',
                    ]"
                  >
                    <template #cell="{ column, record }">
                      <template v-if="column.dataIndex === 'id'" :forKey="'id'">
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="id"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'serialNumber1'"
                        :forKey="'serialNumber1'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="serialNumber1"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'licenseplatenumber'"
                        :forKey="'licenseplatenumber'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="licenseplatenumber"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'yardname'"
                        :forKey="'yardname'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="yardname"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'transactiontime'"
                        :forKey="'transactiontime'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="transactiontime"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'transactionAmount'"
                        :forKey="'transactionAmount'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="transactionAmount"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'paymentType'"
                        :forKey="'paymentType'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="paymentType"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'sourceside'"
                        :forKey="'sourceside'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="sourceside1"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'custom6'"
                        :forKey="'custom6'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          yt-domslot="businessType"
                          yt-template
                        ></div>
                      </template>
                      <template
                        v-if="column.dataIndex === 'name'"
                        :forKey="'name'"
                      >
                        <div
                          style="position: relative; height: 100%; width: 100%"
                          params="record"
                          backgroundType="color"
                          class="customTableTemplate"
                          slotWidth="190"
                          slotHeight="46"
                          yt-domslot="thirdpartyserialnumber"
                          yt-template
                        ></div>
                      </template>
                    </template>
                  </yt-table>
                </div>
              </div>
              <!-- 修改动态面板的状态到支付日志，对应的是修改DynamicPanelselectKey1为3 -->
              <div
                v-if="DynamicPanelselectKey1 == 3"
                style="width: 100%; height: 100%"
              >
                <div
                  style="
                    z-index: 7;
                    width: 97.76%;
                    height: 12.89%;
                    margin-left: 1.12%;
                  "
                >
                  <a-form
                    ref="ref114"
                    :model="SearchBoxform3"
                    :class="[
                      'webVueAntForm',
                      'webVueAntYtFormStyle-gz',
                      'webVueAntYtFormStyle',
                    ]"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      backgroundType="color"
                      slotWidth="1658"
                      slotHeight="118"
                      yt-domslot="ytForm"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div
                          style="
                            z-index: 1;
                            width: 20.75%;
                            height: 27.12%;
                            margin-left: 26.17%;
                            transform: translateY(215.82%);
                          "
                        >
                          <a-form-item
                            ref="ref115"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-gz0gy7a webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['platformSerialNumber1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'平台流水号：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-input
                              data-event
                              class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                              v-model:value="
                                SearchBoxform3.platformSerialNumber1
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 2;
                            width: 3.86%;
                            height: 27.12%;
                            margin-left: 95.05%;
                            transform: translateY(112.5%);
                          "
                        >
                          <a-button
                            ref="ref116"
                            @click="
                              () => {
                                resetPaymentLogData();
                              }
                            "
                            class="webVueAntButton webVueAntYtButtonStyle-gzp1pru webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                            :loading="Resetloading3"
                          >
                            <span class="yt-button-content" v-html="'重置'">
                            </span>
                          </a-button>
                        </div>

                        <div
                          style="
                            z-index: 3;
                            width: 3.86%;
                            height: 27.12%;
                            margin-left: 90.48%;
                            transform: translateY(12.5%);
                          "
                        >
                          <a-button
                            ref="ref117"
                            @click="
                              () => {
                                searchPaymentLogData();
                              }
                            "
                            class="webVueAntButton webVueAntYtButtonStyle-gzioy5p webVueAntYtButtonStyle-gz webVueAntYtButtonStyle center-gz center"
                            :loading="Searchloading3"
                          >
                            <span class="yt-button-content" v-html="'搜索'">
                            </span>
                          </a-button>
                        </div>

                        <div
                          style="
                            z-index: 4;
                            width: 19.06%;
                            height: 27.12%;
                            margin-left: 1.99%;
                            transform: translateY(-237.5%);
                          "
                        >
                          <a-form-item
                            ref="ref119"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-gz0mnyd webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['licenseplatenumber1']"
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
                              class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                              v-model:value="SearchBoxform3.licenseplatenumber1"
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 5;
                            width: 19%;
                            height: 27.12%;
                            margin-left: 53.99%;
                            transform: translateY(-337.5%);
                          "
                        >
                          <a-form-item
                            ref="ref121"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gz1n47i webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['sourceside1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'来源端：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform3.sourceside1"
                              :placeholder="'请输入'"
                              :mode="'single'"
                              :options="Sourcesideoptions2.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 6;
                            width: 19.72%;
                            height: 27.12%;
                            margin-left: 1.33%;
                            transform: translateY(-284.38%);
                          "
                        >
                          <a-form-item
                            ref="ref122"
                            class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-gza77l0 webVueAntYtRangePickerFormItem-gz webVueAntYtRangePickerFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['transactiontime1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'交易时间：'"
                                >
                                </span>
                              </div>
                            </template>
                            <yt-custom-range-picker
                              data-event
                              class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-gz webVueAntYtRangePickerStyle"
                              popupKey="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              v-model:value="SearchBoxform3.transactiontime1"
                            >
                            </yt-custom-range-picker>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 8;
                            width: 19.84%;
                            height: 27.12%;
                            margin-left: 27.08%;
                            transform: translateY(-537.5%);
                          "
                        >
                          <a-form-item
                            ref="ref129"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gz0xy5o webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['yardname1']"
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
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform3.yardname1"
                              :placeholder="'请输入'"
                              :mode="'single'"
                              :options="Yardnameoptions2.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 7;
                            width: 19.84%;
                            height: 27.12%;
                            margin-left: 79.07%;
                            transform: translateY(-637.5%);
                          "
                        >
                          <a-form-item
                            ref="ref130"
                            class="webVueSelectFormItem webVueAntYtSelectFormItem-gznovsj webVueAntYtSelectFormItem-gz webVueAntYtSelectFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['businessType1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'业务类型：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-select
                              data-event
                              class="webVueSelect webVueAntYtSelectStyle-gz webVueAntYtSelectStyle"
                              dropdownClassName="  popupKey-gz popupKey popupKeyId-gz popupKeyId"
                              :showArrow="true"
                              v-model:value="SearchBoxform3.businessType1"
                              :placeholder="'请输入'"
                              :mode="'single'"
                              :options="BusinessTypeoptions2.dataSource"
                              :showSearch="true"
                            >
                            </a-select>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            z-index: 9;
                            width: 21.65%;
                            height: 27.12%;
                            margin-left: 51.33%;
                            transform: translateY(-587.5%);
                          "
                        >
                          <a-form-item
                            ref="ref131"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-gzn235k webVueAntYtInputFormItem-gz webVueAntYtInputFormItem show-label-gz show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['thirdpartyserialnumber1']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'第三方流水号：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-input
                              data-event
                              class="webVueAntinput webVueAntYtInputStyle-gz webVueAntYtInputStyle"
                              v-model:value="
                                SearchBoxform3.thirdpartyserialnumber1
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>
                      </div>
                    </div>
                  </a-form>
                </div>

                <div
                  style="
                    z-index: 8;
                    width: 3.77%;
                    height: 3.44%;
                    margin-left: 2.3%;
                    transform: translateY(112.5%);
                  "
                >
                  <a-button
                    ref="ref123"
                    @click="
                      () => {
                        exportPaymentLogData();
                      }
                    "
                    :loading="Exportloading3"
                    :class="[
                      'webVueAntButton',
                      'webVueAntYtButtonStyle-gz',
                      'webVueAntYtButtonStyle',
                      'center-gz',
                      'center',
                    ]"
                  >
                    <span class="yt-button-content" v-html="'导出'"> </span>
                  </a-button>
                </div>

                <div
                  style="
                    z-index: 9;
                    width: 95.47%;
                    height: 76.48%;
                    margin-left: 2.3%;
                    transform: translateY(7.3%);
                  "
                >
                  <yt-table
                    ref="ref124"
                    :selectType="'checkbox'"
                    v-model:selectedRows="PaymentLogTableselectedRows1"
                    v-model:total="PaymentLogTabletotal1"
                    v-model:current="PaymentLogTablecurrent1"
                    v-model:pageSize="PaymentLogTablepageSize1"
                    :columns="PaymentLogTabledata1.columns"
                    :showTotal="true"
                    :showSizeChanger="true"
                    :pageSizeOptions="{
                      dataSource: [
                        { label: '10', value: 10, select: true },
                        { label: '20', value: 20, select: false },
                        { label: '30', value: 30, select: false },
                        { value: 50, label: '50', select: false },
                        { value: 100, label: '100', select: false },
                      ],
                      value: [10],
                    }"
                    :showQuickJumper="true"
                    :dataSource="PaymentLogTabledata1.dataSource"
                    :scroll="{ y: 599.9999951304252 }"
                    :class="[
                      'webVueAntYtTable',
                      'webVueAntYtTableStyle-gz7cnuy-3',
                      'webVueAntYtTableStyle-gz',
                      'webVueAntYtTableStyle',
                    ]"
                  >
                    <template #cell="{ column, record }"> </template>
                  </yt-table>
                </div>
              </div>
            </div>
          </div>
        </yt-dynamic-panel>
      </div>

      <div
        style="
          z-index: 3;
          width: 97.65%;
          height: 78.35%;
          transform: translateX(0.03%) translateY(19.16%);
        "
      >
        <div
          ref="ref41"
          class="webVueAntYtRectangle webVueAntYtRectangleStyle-gz61gv8 webVueAntYtRectangleStyle-gz webVueAntYtRectangleStyle"
        ></div>
      </div>
    </div>
  </div>
</template>

<script>
import { message, Modal } from "ant-design-vue";
import axios from "axios";
import { h } from "vue";
export default {
  data() {
    return {
      HorizontalmenuopenKeys1: [],
      HorizontalmenuselectedKeys1: ["收入流水"],
      Horizontalmenuoptions1: {
        dataSource: [
          {
            iconUrl:
              "./staticResource/wzc/1867405941272477696/0/O_Z0AyzPkFgL9auaiKUu2.png",
            key: "收入流水",
            label: "一级菜单1",
            title: "收入流水",
            disabled: false,
            select: true,
          },
          {
            iconUrl:
              "./staticResource/wzc/1867405941272477696/0/nb0mCOqJWrCgui2urcuwm.png",
            key: "交易查询",
            label: "一级菜单2",
            title: "交易查询",
            disabled: false,
            select: false,
          },
          {
            key: "支付日志",
            label: "",
            title: "支付日志",
            iconUrl:
              "./staticResource/wzc/1867405941272477696/0/f8Ky7NAp6ZLwJth4x2iC8.png",
            disabled: false,
            select: false,
          },
        ],
        value: {
          selectActive: "收入流水",
          selectData: ["收入流水"],
          disableData: [],
          disableActive: "",
        },
      },
      DynamicPanelselectKey1: "1",
      SearchBoxform1: {
        id: null /*编辑时,需要给id赋值*/,
        mobilephonenumber: "",
        arrivalTime: [],
        licenseplatenumber: "",
        type: undefined,
        paymentchannel: undefined,
        thirdpartyserialnumber: "",
        platformSerialNumber: "",
      },
      SearchBoxstateKey1: "2",
      Resetloading1: false,
      Searchloading1: false,
      Typeoptions1: {
        dataSource: [
          {
            label: "类型一",
            value: "类型一",
            disabled: false,
            select: false,
          },
          {
            label: "类型二",
            value: "类型二",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      paymentchanneloptions1: {
        dataSource: [
          {
            label: "微信",
            value: "微信",
            disabled: false,
            select: false,
          },
          {
            label: "支付宝",
            value: "支付宝",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      SearchBoxform2: {
        id: null /*编辑时,需要给id赋值*/,
        licenseplatenumber1: "",
        sourceside: undefined,
        transactiontime: [],
        yardname: [],
        paymentType: [],
        businessType: [],
        platformSerialNumber1: "",
      },
      SearchBoxstateKey2: "2",
      Resetloading2: false,
      Searchloading2: false,
      SearchBoxform3: {
        id: null /*编辑时,需要给id赋值*/,
        platformSerialNumber1: "",
        licenseplatenumber1: "",
        sourceside1: undefined,
        transactiontime1: [],
        yardname1: undefined,
        businessType1: undefined,
        thirdpartyserialnumber1: "",
      },
      SearchBoxstateKey3: "2",
      Resetloading3: false,
      Searchloading3: false,
      ExportstateKey3: "2",
      Exportloading3: false,
      Yardnameoptions1: {
        dataSource: [
          {
            label: "选项1",
            value: "选项1",
            disabled: false,
            select: false,
          },
          {
            label: "选项2",
            value: "选项2",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      PaymentTypeoptions1: {
        dataSource: [
          {
            label: "微信支付",
            value: "微信支付",
            disabled: false,
            select: false,
          },
          {
            label: "支付宝支付",
            value: "支付宝支付",
            disabled: false,
            select: false,
          },
          {
            value: "青岛市统一支付",
            label: "青岛市统一支付",
            disabled: false,
            select: false,
          },
          {
            value: "钱包支付",
            label: "钱包支付",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      BusinessTypeoptions1: {
        dataSource: [
          {
            label: "停车支付",
            value: "停车支付",
            disabled: false,
            select: false,
          },
          {
            label: "充电支付",
            value: "充电支付",
            disabled: false,
            select: false,
          },
          {
            value: "洗车支付",
            label: "洗车支付",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Sourcesideoptions1: {
        dataSource: [
          {
            label: "移动端",
            value: "移动端",
            disabled: false,
            select: false,
          },
          {
            label: "PC端",
            value: "PC端",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Yardnameoptions2: {
        dataSource: [
          {
            label: "待开票",
            value: "待开票",
            disabled: false,
            select: false,
          },
          {
            label: "已开票",
            value: "已开票",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Sourcesideoptions2: {
        dataSource: [
          {
            label: "待开票",
            value: "待开票",
            disabled: false,
            select: false,
          },
          {
            label: "已开票",
            value: "已开票",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      BusinessTypeoptions2: {
        dataSource: [
          {
            label: "待开票",
            value: "待开票",
            disabled: false,
            select: false,
          },
          {
            label: "已开票",
            value: "已开票",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      TransactionQueryTableselectedRows1: [],
      TransactionQueryTablepageSize1: 10,
      TransactionQueryTablestateKey1: "1",
      TransactionQueryTabledata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "serialNumber1",
            title: "序号",
            dataIndex: "serialNumber1",
          },
          {
            key: "licenseplatenumber",
            title: "车牌号",
            dataIndex: "licenseplatenumber",
          },
          {
            key: "yardname",
            title: "车场名称",
            dataIndex: "yardname",
          },
          {
            key: "transactiontime",
            title: "交易时间",
            dataIndex: "transactiontime",
          },
          {
            key: "transactionAmount",
            title: "交易金额",
            dataIndex: "transactionAmount",
          },
          {
            key: "paymentType",
            title: "支付类型",
            dataIndex: "paymentType",
          },
          {
            key: "sourceside1",
            title: "来源端",
            dataIndex: "sourceside1",
          },
          {
            key: "businessType",
            title: "业务类型",
            dataIndex: "businessType",
          },
          {
            key: "settlementparty",
            title: "结算方",
            dataIndex: "settlementparty",
          },
          {
            key: "platformSerialNumber",
            title: "平台流水号",
            dataIndex: "platformSerialNumber",
          },
          {
            key: "thirdpartyserialnumber",
            title: "第三方流水号",
            dataIndex: "thirdpartyserialnumber",
            cellType: "default",
          },
        ],
        dataSource: [
          {
            id: 1,
            serialNumber1: "1",
            thirdpartyserialnumber: "\n",
            yardname: "",
            paymentType: "微信支付",
            licenseplatenumber: "浙A·12345",
          },
          {
            id: 2,
            serialNumber1: "2",
            thirdpartyserialnumber: "\n",
            paymentType: "支付宝支付",
          },
          {
            id: 0,
            serialNumber1: "",
            thirdpartyserialnumber: "",
            paymentType: "钱包支付",
          },
          {
            id: 3,
            serialNumber1: "",
            thirdpartyserialnumber: "",
            paymentType: "青岛市统一支付",
          },
        ],
      },
      TransactionQueryTablecurrent1: 1,
      TransactionQueryTabletotal1: 2,
      PaymentLogTableselectedRows1: [],
      PaymentLogTablepageSize1: 10,
      PaymentLogTablestateKey1: "1",
      PaymentLogTabledata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "serialNumber1",
            title: "序号",
            dataIndex: "serialNumber1",
          },
          {
            key: "mobilephonenumber",
            title: "手机号",
            dataIndex: "mobilephonenumber",
          },
          {
            key: "licenseplatenumber",
            title: "车牌号",
            dataIndex: "licenseplatenumber",
          },
          {
            key: "transactiontime",
            title: "交易时间",
            dataIndex: "transactiontime",
          },
          {
            key: "transactionAmount",
            title: "交易金额",
            dataIndex: "transactionAmount",
          },
          {
            key: "yardname",
            title: "车场名称",
            dataIndex: "yardname",
          },
          {
            key: "sourceside",
            title: "来源端",
            dataIndex: "sourceside",
          },
          {
            key: "businessType1",
            title: "业务类型",
            dataIndex: "businessType1",
          },
          {
            key: "platformSerialNumber",
            title: "平台流水号",
            dataIndex: "platformSerialNumber",
          },
          {
            key: "thirdpartyserialnumber1",
            title: "第三方流水号",
            dataIndex: "thirdpartyserialnumber1",
            cellType: "default",
          },
        ],
        dataSource: [
          {
            id: 1,
            serialNumber1: "1",
            thirdpartyserialnumber1: "标题1",
          },
          {
            id: 2,
            serialNumber1: "2",
            thirdpartyserialnumber1: "标题2",
          },
        ],
      },
      PaymentLogTablecurrent1: 1,
      PaymentLogTabletotal1: 2,
      ExportstateKey2: "2",
      Exportloading2: false,
      ExportstateKey1: "2",
      Exportloading1: false,
      IncomeFlowWaterMeterselectedRows1: [],
      IncomeFlowWaterMeterpageSize1: 10,
      IncomeFlowWaterMeterstateKey1: "1",
      IncomeFlowWaterMeterdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "serialNumber1",
            title: "序号",
            dataIndex: "serialNumber1",
          },
          {
            key: "mobilephonenumber",
            title: "手机号",
            dataIndex: "mobilephonenumber",
          },
          {
            key: "licenseplatenumber",
            title: "车牌号",
            dataIndex: "licenseplatenumber",
          },
          {
            key: "arrivalTime",
            title: "到账时间",
            dataIndex: "arrivalTime",
          },
          {
            key: "amount",
            title: "金额",
            dataIndex: "amount",
          },
          {
            key: "paymentchannel",
            title: "支付渠道",
            dataIndex: "paymentchannel",
          },
          {
            key: "sourceside",
            title: "来源端",
            dataIndex: "sourceside",
          },
          {
            key: "type",
            title: "类型",
            dataIndex: "type",
          },
          {
            key: "userPaymentMethod",
            title: "用户付款方式",
            dataIndex: "userPaymentMethod",
          },
          {
            key: "region",
            title: "地区",
            dataIndex: "region",
          },
          {
            key: "platformSerialNumber",
            title: "平台流水号",
            dataIndex: "platformSerialNumber",
            cellType: "custom9",
          },
          {
            key: "thirdpartyserialnumber",
            title: "第三方流水号",
            dataIndex: "thirdpartyserialnumber",
          },
        ],
        dataSource: [
          {
            id: 1,
            name: "标题1",
            serialNumber1: "1",
            licenseplatenumber: "浙A·12345",
            mobilephonenumber: "19223438213",
            paymentchannel: "微信",
            sourceside: "移动端",
          },
          {
            id: 2,
            name: "标题2",
            serialNumber1: "2",
            paymentchannel: "青岛市统一支付",
            licenseplatenumber: "",
          },
          {
            id: 0,
            name: "",
            serialNumber1: "",
            paymentchannel: "支付宝",
            licenseplatenumber: "",
          },
        ],
      },
      IncomeFlowWaterMetercurrent1: 1,
      IncomeFlowWaterMetertotal1: 2,
      SearchBoxisShow1: false,
      SearchBoxisShow2: false,
      ExportisShow1: false,
      PaymentLogTableisShow1: false,
      ExportisShow2: false,
      TransactionQueryTableisShow1: false,
    };
  },
  watch: {},
  methods: {
    switchDynamicPanelState(key, item, selectedKeys) {
      /**
      选中收入流水后,动态面板(ref=ref58)切换为收入流水状态；​
      选中交易查询后,动态面板(ref=ref58)切换为交易查询状态；​
      选中支付日志后,动态面板(ref=ref58)切换为支付日志状态； 当前需求和组件(ref=ref17)有关。
      */

      // 获取当前选中的菜单项
      const selectKey = selectedKeys[0];

      // 根据选中的菜单项切换动态面板状态
      if (selectKey === "收入流水") {
        this.DynamicPanelselectKey1 = "1"; // 切换为收入流水状态
      } else if (selectKey === "交易查询") {
        this.DynamicPanelselectKey1 = "2"; // 切换为交易查询状态
      } else if (selectKey === "支付日志") {
        this.DynamicPanelselectKey1 = "3"; // 切换为支付日志状态
      } else {
        message.error("未知的菜单项");
      }
    },
    async exportPaymentLogData() {
      /**
       * 用.xlsx的格式,导出支付日志表(ref=ref124)中的前1000条数据 当前需求和组件(ref=ref123)有关。
       */
      try {
        // 调用后端接口，传递导出参数
        const response = await this.executeBackendInterface(
          "exportPaymentLogData",
          {
            current: 1,
            pageSize: 1000,
            platformSerialNumber: this.SearchBoxform3.platformSerialNumber1,
            licensePlate: this.SearchBoxform3.licenseplatenumber1,
            thirdPartySerialNumber: this.SearchBoxform3.thirdpartyserialnumber1,
            sourceTerminal: this.SearchBoxform3.sourceside1,
            transactionTime: this.SearchBoxform3.transactiontime1
              ? [
                  this.SearchBoxform3.transactiontime1[0],
                  this.SearchBoxform3.transactiontime1[1],
                ]
              : undefined,
            parkingLotName: this.SearchBoxform3.yardname1,
            businessType: this.SearchBoxform3.businessType1,
          }
        );
        if (response.flag) {
          // 处理文件流并触发浏览器下载
          const blob = new Blob([response.data], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
          });
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement("a");
          a.href = url;
          a.download = "支付日志.xlsx";
          document.body.appendChild(a);
          a.click();
          window.URL.revokeObjectURL(url);
          document.body.removeChild(a);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("导出失败，请重试");
      }
    },
    async searchPaymentLogData() {
      /**
       * 根据搜索区域-支付日志(ref=ref114)中的查询条件,查询支付日志表(ref=ref124)中的数据；
       * 拷贝_车牌号1(ref=ref119)、平台流水号(ref=ref115)、第三方流水号(ref=ref131)支持模糊查询；
       * 当前需求和组件(ref=ref117)有关。
       */

      try {
        // 准备请求参数
        const params = {
          current: this.PaymentLogTablecurrent1,
          pageSize: this.PaymentLogTablepageSize1,
          platformSerialNumber: this.SearchBoxform3.platformSerialNumber1,
          licensePlate: this.SearchBoxform3.licenseplatenumber1,
          thirdPartySerialNumber: this.SearchBoxform3.thirdpartyserialnumber1,
          sourceTerminal: this.SearchBoxform3.sourceside1,
          transactionTime: this.SearchBoxform3.transactiontime1 || [],
          // 确保是数组
          parkingLotName: this.SearchBoxform3.yardname1 || "",
          // 确保是字符串
          businessType: this.SearchBoxform3.businessType1 || "", // 确保是字符串
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryPaymentLogList",
          params
        );
        if (response.flag) {
          // 校验并赋值返回数据
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serial_number,
            mobilephonenumber: item.phone_number,
            licenseplatenumber: item.license_plate,
            transactiontime: item.transaction_time,
            transactionAmount: item.amount,
            // 修正为接口文档中的字段名
            yardname: item.parking_lot_name,
            sourceside: item.source_terminal,
            businessType1: item.business_type,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber1: item.third_party_serial_number,
          }));
          this.PaymentLogTabledata1.dataSource = data;
          this.PaymentLogTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async resetPaymentLogData() {
      /**
       * 清空搜索区域-支付日志(ref=ref114)中的数据,并初始化支付日志表(ref=ref124) 当前需求和组件(ref=ref116)有关。
       */

      // 清空搜索区域的数据
      this.SearchBoxform3.platformSerialNumber1 = "";
      this.SearchBoxform3.licenseplatenumber1 = "";
      this.SearchBoxform3.sourceside1 = ""; // 确保与接口文档一致
      this.SearchBoxform3.transactiontime1 = [];
      this.SearchBoxform3.yardname1 = ""; // 确保与接口文档一致
      this.SearchBoxform3.businessType1 = ""; // 确保与接口文档一致
      this.SearchBoxform3.thirdpartyserialnumber1 = "";

      // 调用后端接口初始化支付日志表数据
      try {
        const response = await this.executeBackendInterface(
          "initializePaymentLogData",
          {
            current: this.PaymentLogTablecurrent1,
            pageSize: this.PaymentLogTablepageSize1,
            platformSerialNumber1: this.SearchBoxform3.platformSerialNumber1,
            licenseplatenumber1: this.SearchBoxform3.licenseplatenumber1,
            sourceside1: this.SearchBoxform3.sourceside1,
            transactiontime1: this.SearchBoxform3.transactiontime1,
            yardname1: this.SearchBoxform3.yardname1,
            businessType1: this.SearchBoxform3.businessType1,
            thirdpartyserialnumber1:
              this.SearchBoxform3.thirdpartyserialnumber1,
          }
        );
        if (response.flag) {
          // 更新支付日志表数据
          this.PaymentLogTabledata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber1: item.serial_number,
              mobilephonenumber: item.phone_number,
              licenseplatenumber: item.license_plate,
              transactiontime: item.transaction_time,
              transactionAmount: item.amount,
              yardname: item.parking_lot_name,
              sourceside: item.source_terminal,
              businessType1: item.business_type,
              platformSerialNumber: item.platform_serial_number,
              thirdpartyserialnumber1: item.third_party_serial_number,
            })
          );
          this.PaymentLogTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("初始化支付日志数据失败");
      }
    },
    async exportTransactionQueryData() {
      /**
      用.xlsx的格式,导出交易查询表(ref=ref99)中前1000条数据   当前需求和组件(ref=ref98)有关。
      */
      try {
        // 调用后端接口获取数据
        const response = await this.executeBackendInterface(
          "generalQueryTransactionListData",
          {
            licensePlate: this.SearchBoxform2.licenseplatenumber1,
            platformSerialNumber: this.SearchBoxform2.platformSerialNumber1,
            sourceTerminal: this.SearchBoxform2.sourceside,
            parkingLotName:
              this.SearchBoxform2.yardname.length > 0
                ? this.SearchBoxform2.yardname[0]
                : "",
            paymentChannel:
              this.SearchBoxform2.paymentType.length > 0
                ? this.SearchBoxform2.paymentType[0]
                : "",
            businessType:
              this.SearchBoxform2.businessType.length > 0
                ? this.SearchBoxform2.businessType[0]
                : "",
            current: this.TransactionQueryTablecurrent1,
            pageSize: this.TransactionQueryTablepageSize1,
          }
        );
        if (response.flag) {
          // 处理后端返回的文件流
          const blob = new Blob([response.data], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
          });
          const downloadUrl = window.URL.createObjectURL(blob);
          const a = document.createElement("a");
          a.href = downloadUrl;
          a.download = "TransactionQueryData.xlsx";
          document.body.appendChild(a);
          a.click();
          window.URL.revokeObjectURL(downloadUrl);
          document.body.removeChild(a);
          message.success("导出成功");
        } else {
          message.error("导出失败: " + response.message);
        }
      } catch (error) {
        message.error("导出过程中发生错误");
        console.error(error);
      }
    },
    async searchTransactionQueryData() {
      /**
       * 根据搜索区域-交易查询(ref=ref89)中的查询条件,查询交易查询表(ref=ref99)中的数据；
       * 车牌号(ref=ref90)、平台流水号(ref=ref128)支持模糊查询； 当前需求和组件(ref=ref92)有关。
       */

      // 调用通用查询函数
      await this.generalQueryTransactionListData();
    },
    async generalQueryTransactionListData() {
      try {
        // 获取查询条件
        const licensePlate = this.SearchBoxform2.licenseplatenumber1;
        const platformSerialNumber = this.SearchBoxform2.platformSerialNumber1;
        const sourceTerminal = this.SearchBoxform2.sourceside;
        const parkingLotName = this.SearchBoxform2.yardname;
        const paymentChannel = this.SearchBoxform2.paymentType;
        const businessType = this.SearchBoxform2.businessType;
        const current = this.TransactionQueryTablecurrent1;
        const pageSize = this.TransactionQueryTablepageSize1;

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryTransactionListData",
          {
            licensePlate,
            platformSerialNumber,
            sourceTerminal,
            parkingLotName,
            paymentChannel,
            businessType,
            current,
            pageSize,
          }
        );

        // 检查接口调用结果
        if (response.flag) {
          // 处理返回数据
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serialNumber,
            licenseplatenumber: item.licensePlate,
            yardname: item.parkingLotName,
            transactiontime: item.transaction_time,
            transactionAmount: item.transactionAmount,
            paymentType: item.paymentChannel,
            sourceside: item.sourceTerminal,
            businessType: item.business_type,
            settlementparty: item.settlement_party,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber: item.third_party_serial_number,
          }));

          // 更新表格数据
          this.TransactionQueryTabledata1.dataSource = data;
          this.TransactionQueryTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async resetTransactionQueryData() {
      /**
      清空搜索区域-交易查询(ref=ref89)中的数据,并初始化交易查询表(ref=ref99) 当前需求和组件(ref=ref91)有关。
      */

      // 清空搜索区域的数据
      this.SearchBoxform2.licenseplatenumber1 = "";
      this.SearchBoxform2.sourceside = undefined;
      this.SearchBoxform2.transactiontime = [];
      this.SearchBoxform2.yardname = [];
      this.SearchBoxform2.paymentType = [];
      this.SearchBoxform2.businessType = [];
      this.SearchBoxform2.platformSerialNumber1 = "";

      // 初始化交易查询表
      try {
        const response = await this.executeBackendInterface(
          "initializeTransactionQueryData",
          {
            licenseplatenumber1: this.SearchBoxform2.licenseplatenumber1,
            sourceside: this.SearchBoxform2.sourceside,
            transactiontime: this.SearchBoxform2.transactiontime,
            yardname: this.SearchBoxform2.yardname,
            paymentType: this.SearchBoxform2.paymentType,
            businessType: this.SearchBoxform2.businessType,
            platformSerialNumber1: this.SearchBoxform2.platformSerialNumber1,
            current: this.TransactionQueryTablecurrent1,
            pageSize: this.TransactionQueryTablepageSize1,
          }
        );
        if (response.flag) {
          // 更新交易查询表的数据
          this.TransactionQueryTabledata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber1: item.serialNumber1,
              licenseplatenumber1: item.licenseplatenumber1,
              yardname: item.yardname,
              transactiontime: item.transaction_time,
              transactionAmount: item.transaction_amount,
              paymentType: item.paymentType,
              sourceside: item.sourceside,
              businessType: item.businessType,
              settlementparty: item.settlement_party,
              platformSerialNumber: item.platform_serial_number,
              thirdpartyserialnumber: item.third_party_serial_number,
            })
          );
          this.TransactionQueryTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("初始化交易查询数据失败");
      }
    },
    exportIncomeFlowData() {
      /**
       * 用.xlsx的格式,导出收入流水表(ref=ref88)中前1000条数据 当前需求和组件(ref=ref87)有关。
       */
      Modal.confirm({
        title: "确认导出",
        content: "确定要导出收入流水表的前1000条数据吗？",
        onOk: async () => {
          try {
            // 调用后端接口，获取前1000条数据
            const response = await this.executeBackendInterface(
              "generalQueryIncomeFlowList",
              {
                current: 1,
                pageSize: 1000,
                phone_number: this.SearchBoxform1.mobilephonenumber,
                license_plate: this.SearchBoxform1.licenseplatenumber,
                third_party_serial_number:
                  this.SearchBoxform1.thirdpartyserialnumber,
                platform_serial_number:
                  this.SearchBoxform1.platformSerialNumber,
              }
            );
            if (response.flag) {
              // 假设后端返回的是文件流
              const blob = new Blob([response.data], {
                type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
              });
              const url = window.URL.createObjectURL(blob);
              const a = document.createElement("a");
              a.href = url;
              a.download = "收入流水表.xlsx";
              document.body.appendChild(a);
              a.click();
              window.URL.revokeObjectURL(url);
              document.body.removeChild(a);
              message.success("导出成功");
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("导出失败，请重试");
          }
        },
        onCancel: () => {
          message.info("已取消导出");
        },
      });
    },
    async searchIncomeFlowData() {
      /**
      根据搜索区域-收入流水(ref=ref79)中的查询条件,查询收入流水表(ref=ref88)中对应的数据；​
      手机号(ref=ref80)、车牌号(ref=ref84)、第三方流水号(ref=ref112)、平台流水号(ref=ref113)支持模糊查询； 当前需求和组件(ref=ref82)有关。
      */

      try {
        // 调用后端接口，传递查询条件
        const response = await this.executeBackendInterface(
          "generalQueryIncomeFlowList",
          {
            current: this.IncomeFlowWaterMetercurrent1,
            pageSize: this.IncomeFlowWaterMeterpageSize1,
            phone_number: this.SearchBoxform1.mobilephonenumber,
            license_plate: this.SearchBoxform1.licenseplatenumber,
            third_party_serial_number:
              this.SearchBoxform1.thirdpartyserialnumber,
            platform_serial_number: this.SearchBoxform1.platformSerialNumber,
          }
        );
        if (response.flag) {
          // 校验返回数据格式，并赋值给组件变量
          const data = response.data;
          this.IncomeFlowWaterMetertotal1 = data.total;
          this.IncomeFlowWaterMeterdata1.dataSource = data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serial_number,
            mobilephonenumber: item.phone_number,
            licenseplatenumber: item.license_plate,
            arrivalTime: item.arrival_time,
            amount: item.amount,
            paymentchannel: item.payment_channel,
            sourceside: item.source_terminal,
            type: item.type,
            userPaymentMethod: item.user_payment_method,
            region: item.region,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber: item.third_party_serial_number,
          }));
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async resetIncomeFlowData() {
      /**
      清空搜索区域-收入流水(ref=ref79)中的数据,并初始化收入流水表(ref=ref88)中的数据 当前需求和组件(ref=ref81)有关。
      */

      // 清空搜索区域的数据
      this.SearchBoxform1 = {
        mobilephonenumber: "",
        arrivalTime: [],
        licenseplatenumber: "",
        type: null,
        // 确保类型匹配
        paymentchannel: null,
        // 确保类型匹配
        thirdpartyserialnumber: "",
        platformSerialNumber: "",
      };

      // 调用后端接口初始化收入流水数据
      try {
        const response = await this.executeBackendInterface(
          "initializeIncomeFlowData",
          {
            current: this.IncomeFlowWaterMetercurrent1,
            pageSize: this.IncomeFlowWaterMeterpageSize1,
            mobilephonenumber: this.SearchBoxform1.mobilephonenumber,
            arrivalTime: this.SearchBoxform1.arrivalTime,
            licenseplatenumber: this.SearchBoxform1.licenseplatenumber,
            type: this.SearchBoxform1.type,
            // 确保类型匹配
            paymentchannel: this.SearchBoxform1.paymentchannel,
            // 确保类型匹配
            thirdpartyserialnumber: this.SearchBoxform1.thirdpartyserialnumber,
            platformSerialNumber: this.SearchBoxform1.platformSerialNumber,
          }
        );
        if (response.flag) {
          // 更新收入流水表的数据
          this.IncomeFlowWaterMeterdata1.dataSource = response.data.data.map(
            (item) => ({
              id: item.id,
              serialNumber1: item.serial_number,
              mobilephonenumber: item.phone_number,
              licenseplatenumber: item.license_plate,
              arrivalTime: item.arrival_time,
              amount: item.amount,
              paymentchannel: item.payment_channel,
              sourceside: item.source_terminal,
              type: item.type,
              userPaymentMethod: item.user_payment_method,
              region: item.region,
              platformSerialNumber: item.platform_serial_number,
              thirdpartyserialnumber: item.third_party_serial_number,
            })
          );
          this.IncomeFlowWaterMetertotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("初始化收入流水数据失败");
      }
    },
    async generalQueryIncomeFlowList() {
      /**
      根据搜索区域-收入流水(ref=ref79)中的查询条件，查询收入流水表(ref=ref88)中对应的数据。支持手机号(ref=ref80)、车牌号(ref=ref84)、第三方流水号(ref=ref112)、平台流水号(ref=ref113)的模糊查询。查询结果需要支持分页功能，包括页码(current)、每页大小(pageSize)、返回的总条目数(total)。
      */
      try {
        // 准备请求参数
        const params = {
          current: this.IncomeFlowWaterMetercurrent1,
          pageSize: this.IncomeFlowWaterMeterpageSize1,
          phone_number: this.SearchBoxform1.mobilephonenumber,
          license_plate: this.SearchBoxform1.licenseplatenumber,
          third_party_serial_number: this.SearchBoxform1.thirdpartyserialnumber,
          platform_serial_number: this.SearchBoxform1.platformSerialNumber,
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryIncomeFlowList",
          params
        );

        // 检查请求是否成功
        if (response.flag) {
          // 处理返回的数据
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serial_number,
            mobilephonenumber: item.phone_number,
            licenseplatenumber: item.license_plate,
            arrivalTime: item.arrival_time,
            amount: item.amount,
            paymentchannel: item.payment_channel,
            sourceside: item.source_terminal,
            type: item.type,
            userPaymentMethod: item.user_payment_method,
            region: item.region,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber: item.third_party_serial_number,
          }));

          // 更新表格数据和分页信息
          this.IncomeFlowWaterMeterdata1.dataSource = data;
          this.IncomeFlowWaterMetertotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        console.error("请求失败:", error);
        message.error("查询失败，请重试");
      }
    },
    async generalQueryTransactionListData8KS() {
      /**
       * 根据搜索区域-交易查询(ref=ref89)中的查询条件，查询交易查询表(ref=ref99)中的数据。支持模糊查询的字段包括车牌号(ref=ref90)和平台流水号(ref=ref128)。查询结果需要支持分页功能，包括页码(current)、每页大小(pageSize)和返回的总条目数(total)。此外，接口还需支持数据的初始化和刷新操作。
       */
      try {
        // 获取查询条件
        const licensePlate = this.SearchBoxform2.licenseplatenumber1;
        const platformSerialNumber = this.SearchBoxform2.platformSerialNumber1;
        const sourceTerminal = this.SearchBoxform2.sourceside;
        const parkingLotName = this.SearchBoxform2.yardname;
        const paymentChannel = this.SearchBoxform2.paymentType;
        const businessType = this.SearchBoxform2.businessType;
        const current = this.TransactionQueryTablecurrent1;
        const pageSize = this.TransactionQueryTablepageSize1;

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryTransactionListData",
          {
            licensePlate,
            platformSerialNumber,
            sourceTerminal,
            parkingLotName,
            paymentChannel,
            businessType,
            current,
            pageSize,
          }
        );

        // 检查接口调用结果
        if (response.flag) {
          // 处理返回数据
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serialNumber,
            licenseplatenumber: item.licensePlate,
            yardname: item.parkingLotName,
            transactiontime: item.transaction_time,
            transactionAmount: item.transactionAmount,
            paymentType: item.paymentChannel,
            sourceside: item.sourceTerminal,
            businessType: item.business_type,
            settlementparty: item.settlement_party,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber: item.third_party_serial_number,
          }));

          // 更新表格数据
          this.TransactionQueryTabledata1.dataSource = data;
          this.TransactionQueryTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async exportTransactionData() {
      /**
       * 导出前1000条交易数据为.xlsx格式
       */
      try {
        // 获取查询条件
        const licensePlate = this.SearchBoxform2.licenseplatenumber1;
        const platformSerialNumber = this.SearchBoxform2.platformSerialNumber1;
        const sourceTerminal = this.SearchBoxform2.sourceside;
        const parkingLotName = this.SearchBoxform2.yardname;
        const paymentChannel = this.SearchBoxform2.paymentType;
        const businessType = this.SearchBoxform2.businessType;

        // 调用后端接口，获取前1000条数据
        const response = await this.executeBackendInterface(
          "exportTransactionData",
          {
            licensePlate,
            platformSerialNumber,
            sourceTerminal,
            parkingLotName,
            paymentChannel,
            businessType,
            current: 1,
            pageSize: 1000,
          }
        );

        // 检查接口调用结果
        if (response.flag) {
          // 处理文件流并触发下载
          const blob = new Blob([response.data], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
          });
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement("a");
          a.href = url;
          a.download = "交易数据.xlsx";
          document.body.appendChild(a);
          a.click();
          window.URL.revokeObjectURL(url);
          document.body.removeChild(a);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("导出失败，请重试");
      }
    },
    async generalQueryPaymentLogList() {
      /**
      根据支付日志表(ref=ref124)中的查询条件，查询支付日志表中的数据。支持模糊查询的字段包括：车牌号、平台流水号、第三方流水号。查询时需要支持分页功能，包括页码(current)、每页大小(pageSize)、返回的总条目数(total)。此外，查询条件还包括来源端、交易时间、车场名称、业务类型等。
      */
      try {
        // 准备请求参数
        const params = {
          current: this.PaymentLogTablecurrent1,
          pageSize: this.PaymentLogTablepageSize1,
          licensePlate: this.SearchBoxform1.licenseplatenumber,
          platformSerialNumber: this.SearchBoxform1.platformSerialNumber,
          thirdPartySerialNumber: this.SearchBoxform1.thirdpartyserialnumber,
          sourceTerminal: this.SearchBoxform1.sourceside,
          businessType: this.SearchBoxform1.type,
          // 修正为正确的变量名
          parkingLotName: this.SearchBoxform1.yardname,
          transactionTime: this.SearchBoxform1.arrivalTime, // 修正为正确的变量名
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryPaymentLogList",
          params
        );

        // 检查响应结果
        if (response.flag) {
          // 处理返回的数据
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.serial_number,
            mobilephonenumber: item.phone_number,
            licenseplatenumber: item.license_plate,
            transactiontime: item.transaction_time,
            transactionAmount: item.transaction_amount,
            yardname: item.parking_lot_name,
            sourceside: item.source_terminal,
            businessType1: item.business_type,
            platformSerialNumber: item.platform_serial_number,
            thirdpartyserialnumber1: item.third_party_serial_number,
          }));

          // 更新表格数据
          this.PaymentLogTabledata1.dataSource = data;
          this.PaymentLogTabletotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1869272361639870464";
        const response = await axios.get(
          `./system/permission/getCurrentPageNotShowRef?pageUuid=${pageUuid}`
        );
        const refNamesArray = response.data.data; // 后端直接返回变量数组
        if (refNamesArray && Array.isArray(refNamesArray))
          // 遍历数组，设置这些不显示
          refNamesArray.forEach((refName) => {
            const ref = this.$refs[refName];
            if (ref && ref.$el) {
              const parent = ref.$el.parentElement;
              if (parent) {
                parent.style.display = "none";
              } else {
                ref.$el.style.display = "none";
              }
            }
          });
      } catch (error) {
        console.error("获取变量失败:", error);
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
          .post("./WebFundmanagement/" + funcName, params, {
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
    },
  },
  mounted() {
    // 初始化时查询交易数据
    this.generalQueryTransactionListData();
    // 初始化时查询交易数据
    this.generalQueryTransactionListData();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
@import "/public/css/web/vue/antdesign/YtSpan/default";
@import "/public/css/web/vue/antdesign/YtMenu/default";
@import "/public/css/web/vue/antdesign/YtRectangle/default";
@import "/public/css/web/vue/antdesign/YtForm/default";
@import "/public/css/web/vue/antdesign/YtInput/default";
@import "/public/css/web/vue/antdesign/YtButton/default";
@import "/public/css/web/vue/antdesign/YtRangePicker/default";
@import "/public/css/web/vue/antdesign/YtSelect/default";
@import "/public/css/web/vue/antdesign/YtTable/default";
@import "/public/css/资金管理/theme";

.webVueAntYtMenuStyle.webVueAntYtMenuStyle-gz5ze0s
  .yt-horizontal-menu-menu-sub-menu.ant-menu
  .ant-menu-item,
.webVueAntYtMenuStyle.webVueAntYtMenuStyle-gz5ze0s
  .yt-horizontal-menu-menu-sub-menu.ant-menu
  .ant-menu-submenu:not(.ant-menu-submenu-popup)
  .ant-menu-submenu-title {
  height: 18px;
}

.webVueAntYtRectangleStyle.webVueAntYtRectangleStyle-gz61gv8 {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzy7qx2
  .ant-form-item-label
  label {
  width: 66px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzy7qx2
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gzx44wt {
  color: #333333 !important;
  background: #ffffff !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gz8wk0z {
  background: #1890ff !important;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gzo0ogm
  .ant-form-item-label
  label {
  width: 80px;
}
.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gzo0ogm
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzqthc3
  .ant-form-item-label
  label {
  width: 67px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzqthc3
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gz3tgxr
  .ant-form-item-label
  label {
  width: 52px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gzwyinm
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtTableStyle-gzlcvf5-1 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gzlcvf5-1
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-1
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-1 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gzlcvf5-1 .ant-table .ant-table-thead tr span.th-text {
  font-weight: bold;
  line-height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-1 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-1 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(2),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(3),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(3) {
  width: 120px !important;
  min-width: 120px !important;
  max-width: 120px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(4),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(4) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(5),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(6),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(7),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(7) {
  width: 130px !important;
  min-width: 130px !important;
  max-width: 130px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(8),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(8) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(9),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(10),
.webVueAntYtTableStyle-gzlcvf5-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(11),
.webVueAntYtTableStyle-gzlcvf5-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(12),
.webVueAntYtTableStyle-gzlcvf5-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(12) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-1 tr td:nth-child(13) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-1
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
.webVueAntYtTableStyle-gzlcvf5-1 tr > th:nth-child(13),
.webVueAntYtTableStyle-gzlcvf5-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(13),
.webVueAntYtTableStyle-gzlcvf5-1 tbody tr.ant-table-row td:nth-child(13) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gzlcvf5-2-3
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 .ant-table .ant-table-thead tr span.th-text {
  font-weight: bold;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(2),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(2),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(3),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(3),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(3) {
  width: 120px !important;
  min-width: 120px !important;
  max-width: 120px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(4),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(4),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(4) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(5),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(5),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(6),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(6),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(7),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(7),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(7) {
  width: 130px !important;
  min-width: 130px !important;
  max-width: 130px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(8),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(8),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(8) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(9),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(9),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(10),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(11),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(12),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(12) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzlcvf5-2-3 tr td:nth-child(13) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzlcvf5-2-3
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
.webVueAntYtTableStyle-gzlcvf5-2-3 tr > th:nth-child(13),
.webVueAntYtTableStyle-gzlcvf5-2-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(13),
.webVueAntYtTableStyle-gzlcvf5-2-3 tbody tr.ant-table-row td:nth-child(13) {
  width: calc((100% - 498px) / 7) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzusm78
  .ant-form-item-label
  label {
  width: 66px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzusm78
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gzkq4az {
  color: #333333 !important;
  background: #ffffff !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gzrtj52 {
  background: #1890ff !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gz6atbu
  .ant-form-item-label
  label {
  width: 66px;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gzjzwse
  .ant-form-item-label
  label {
  width: 80px;
}
.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gzjzwse
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzxbqoc
  .ant-form-item-label
  label {
  width: 109px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzxbqoc
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzaw3qs
  .ant-form-item-label
  label {
  width: 94px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzaw3qs
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gz0gy7a
  .ant-form-item-label
  label {
  width: 95px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gz0gy7a
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gzp1pru {
  color: #333333 !important;
  background: #ffffff !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-gzioy5p {
  background: #1890ff !important;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gz0mnyd
  .ant-form-item-label
  label {
  width: 67px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gz0mnyd
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gz1n47i
  .ant-form-item-label
  label {
  width: 66px;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gza77l0
  .ant-form-item-label
  label {
  width: 81px;
}
.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-gza77l0
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtTableStyle-gz7cnuy-1 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gz7cnuy-1
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-1
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-1 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-1 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(3) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(4) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-1 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-1
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
.webVueAntYtTableStyle-gz7cnuy-1 tr > th:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-1 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gz7cnuy-2
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-2
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-2 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-2 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(3) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(4) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-2
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-2 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-2
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
.webVueAntYtTableStyle-gz7cnuy-2 tr > th:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-2
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-2 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gz7cnuy-3
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-3
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-3 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gz7cnuy-3 .ant-table .ant-table-thead tr span.th-text {
  font-size: 16px;
  font-weight: bold;
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-3 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-3 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(3) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(4) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gz7cnuy-3 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gz7cnuy-3
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
.webVueAntYtTableStyle-gz7cnuy-3 tr > th:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gz7cnuy-3 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 48px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gzccjsd
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gz1vwmy
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gzcm9zt
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzpfmak
  .ant-form-item-label
  label {
  width: 95px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzpfmak
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtTableStyle-gzz7fp9-1 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gzz7fp9-1
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-1
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-1 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gzz7fp9-1 .ant-table .ant-table-thead tr span.th-text {
  font-size: 16px;
  font-weight: bold;
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-1 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-1 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(3) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(4) {
  width: 200px !important;
  min-width: 200px !important;
  max-width: 200px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-1 tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-1
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
.webVueAntYtTableStyle-gzz7fp9-1 tr > th:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-1
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-1 tbody tr.ant-table-row td:nth-child(12) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gzz7fp9-2
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-2
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-2 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gzz7fp9-2 .ant-table .ant-table-thead tr span.th-text {
  font-size: 16px;
  font-weight: bold;
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-2 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-2 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(3) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(4) {
  width: 200px !important;
  min-width: 200px !important;
  max-width: 200px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-2
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-2
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-2 tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-2
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
.webVueAntYtTableStyle-gzz7fp9-2 tr > th:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-2
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-2 tbody tr.ant-table-row td:nth-child(12) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-gzz7fp9-3
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-3
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-3 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-gzz7fp9-3 .ant-table .ant-table-thead tr span.th-text {
  font-size: 16px;
  font-weight: bold;
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-3 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-3 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(2),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(3),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(3) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(4),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(4) {
  width: 200px !important;
  min-width: 200px !important;
  max-width: 200px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(5),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(5) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(6),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(6) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(7),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(7) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(8) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(8),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(8) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(9) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-measure-row td:nth-child(9),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(9) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(10) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(10) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(11) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(11) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-gzz7fp9-3 tr td:nth-child(12) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-gzz7fp9-3
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
.webVueAntYtTableStyle-gzz7fp9-3 tr > th:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-3
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle-gzz7fp9-3 tbody tr.ant-table-row td:nth-child(12) {
  width: calc((100% - 348px) / 8) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gz0xy5o
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-gznovsj
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzn235k
  .ant-form-item-label
  label {
  width: 108px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-gzn235k
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}
</style>
