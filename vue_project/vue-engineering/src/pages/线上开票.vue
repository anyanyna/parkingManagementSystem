<template>
  <div
    style="width: 100%; height: 100%; overflow: hidden; background: #f0f2f5"
    class="rootContainer flexCol spaceStart"
  >
    <div
      style="height: 1.97%; z-index: 1; transform: translateY(80%)"
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
          class="webVueAntYtSpan webVueAntYtSpanStyle-jk webVueAntYtSpanStyle"
        >
          <span v-html="'财务管理 / 线上开票'"> </span>
        </span>
      </div>
    </div>

    <div
      style="height: 11.81%; z-index: 2; transform: translateY(22.5%)"
      class="flexRow spaceAround"
    >
      <div style="z-index: 2; width: 97.65%; height: 100%">
        <a-form
          ref="ref3"
          class="webVueAntForm webVueAntYtFormStyle-jk webVueAntYtFormStyle"
          :model="SearchBoxform1"
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
                style="height: 27.12%; z-index: 1; transform: translateY(62.5%)"
                class="flexRow spaceBetween"
              >
                <div
                  style="
                    z-index: 1;
                    width: 19.9%;
                    height: 100%;
                    transform: translateX(6.06%);
                  "
                >
                  <a-form-item
                    ref="ref4"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-jkntw2d webVueAntYtInputFormItem-jk webVueAntYtInputFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['orderNumber']"
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
                      class="webVueAntinput webVueAntYtInputStyle-jk webVueAntYtInputStyle"
                      v-model:value="SearchBoxform1.orderNumber"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 5;
                    width: 19.06%;
                    height: 100%;
                    transform: translateX(5.24%);
                  "
                >
                  <a-form-item
                    ref="ref9"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-jk10cbf webVueAntYtInputFormItem-jk webVueAntYtInputFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['licenseplatenumber']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span class="ant-form-item-content" v-html="'车牌号：'">
                        </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-jk webVueAntYtInputStyle"
                      v-model:value="SearchBoxform1.licenseplatenumber"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 6;
                    width: 19.84%;
                    height: 100%;
                    transform: translateX(-0.22%);
                  "
                >
                  <a-form-item
                    ref="ref10"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-jkja3m8 webVueAntYtInputFormItem-jk webVueAntYtInputFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['invoiceHeader']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'发票抬头：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-jk webVueAntYtInputStyle"
                      v-model:value="SearchBoxform1.invoiceHeader"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 7;
                    width: 19.9%;
                    height: 100%;
                    transform: translateX(-5.45%);
                  "
                >
                  <a-form-item
                    ref="ref12"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-jkrx5bi webVueAntYtSelectFormItem-jk webVueAntYtSelectFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['bailingStatus']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'开票状态：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-jk webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-jk popupKey popupKeyId-jk popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.bailingStatus"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="BailingStatusoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>
              </div>

              <div
                style="
                  height: 27.97%;
                  z-index: 2;
                  transform: translateY(109.09%);
                "
                class="flexRow spaceBetween"
              >
                <div
                  style="
                    z-index: 4;
                    width: 19.84%;
                    height: 96.97%;
                    transform: translateX(6.08%) translateY(3.13%);
                  "
                >
                  <a-form-item
                    ref="ref8"
                    class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-jkp2vga webVueAntYtRangePickerFormItem-jk webVueAntYtRangePickerFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['applicationtime']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'申请时间：'"
                        >
                        </span>
                      </div>
                    </template>
                    <yt-custom-range-picker
                      data-event
                      class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-jk webVueAntYtRangePickerStyle"
                      popupKey="  popupKey-jk popupKey popupKeyId-jk popupKeyId"
                      v-model:value="SearchBoxform1.applicationtime"
                    >
                    </yt-custom-range-picker>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 8;
                    width: 19.78%;
                    height: 96.97%;
                    transform: translateX(-3.81%) translateY(3.13%);
                  "
                >
                  <a-form-item
                    ref="ref13"
                    class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-jkvuc5d webVueAntYtRangePickerFormItem-jk webVueAntYtRangePickerFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['bailingTime']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'开票时间：'"
                        >
                        </span>
                      </div>
                    </template>
                    <yt-custom-range-picker
                      data-event
                      class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-jk webVueAntYtRangePickerStyle"
                      popupKey="  popupKey-jk popupKey popupKeyId-jk popupKeyId"
                      v-model:value="SearchBoxform1.bailingTime"
                    >
                    </yt-custom-range-picker>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 9;
                    width: 19.96%;
                    height: 96.97%;
                    transform: translateX(-14.5%) translateY(3.13%);
                  "
                >
                  <a-form-item
                    ref="ref26"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-jkn8mml webVueAntYtSelectFormItem-jk webVueAntYtSelectFormItem show-label-jk show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['orderType']"
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
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-jk webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-jk popupKey popupKeyId-jk popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.orderType"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="OrderTypeoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 3;
                    width: 3.86%;
                    height: 96.97%;
                    transform: translateX(165.17%);
                  "
                >
                  <a-button
                    ref="ref6"
                    @click="
                      () => {
                        handleSearchClick();
                      }
                    "
                    class="webVueAntButton webVueAntYtButtonStyle-jk7hlz1 webVueAntYtButtonStyle-jk webVueAntYtButtonStyle center-jk center"
                    :loading="Searchloading1"
                  >
                    <span class="yt-button-content" v-html="'搜索'"> </span>
                  </a-button>
                </div>

                <div
                  style="
                    z-index: 2;
                    width: 3.86%;
                    height: 96.97%;
                    transform: translateX(-28.13%);
                  "
                >
                  <a-button
                    ref="ref5"
                    @click="
                      () => {
                        handleResetClick();
                      }
                    "
                    class="webVueAntButton webVueAntYtButtonStyle-jk6um3o webVueAntYtButtonStyle-jk webVueAntYtButtonStyle center-jk center"
                    :loading="Resetloading1"
                  >
                    <span class="yt-button-content" v-html="'重置'"> </span>
                  </a-button>
                </div>
              </div>
            </div>
          </div>
        </a-form>
      </div>
    </div>

    <div
      style="height: 71.95%; z-index: 3; transform: translateY(6.4%)"
      class="flexRow spaceAround"
    >
      <div
        style="
          width: 97.65%;
          height: 100%;
          z-index: 3;
          transform: translateX(-0.06%);
        "
        class="flexCol spaceStart"
      >
        <div style="height: 100%; z-index: 3" class="flexRow spaceAround">
          <div
            style="
              width: 97.47%;
              height: 100%;
              z-index: 3;
              transform: translateX(-0.06%);
            "
            class="flexCol spaceAround"
          >
            <div
              style="
                position: absolute;
                left: -1.23%;
                top: 0%;
                width: 102.6%;
                height: 100%;
                z-index: 3;
              "
            >
              <div
                ref="ref14"
                class="webVueAntYtRectangle webVueAntYtRectangleStyle-jkvg7id webVueAntYtRectangleStyle-jk webVueAntYtRectangleStyle"
              ></div>
            </div>

            <div
              style="
                z-index: 4;
                width: 3.96%;
                height: 4.38%;
                transform: translateY(10.56%);
              "
            >
              <a-button
                ref="ref15"
                @click="
                  () => {
                    handleExportClick();
                  }
                "
                class="webVueAntButton webVueAntYtButtonStyle-jk webVueAntYtButtonStyle center-jk center"
                :loading="Exportloading1"
              >
                <span class="yt-button-content" v-html="'导出'"> </span>
              </a-button>
            </div>

            <div
              style="
                z-index: 5;
                width: 100%;
                height: 88.65%;
                margin-left: 0.01px;
                transform: translateY(-0.92%);
              "
            >
              <yt-table
                ref="ref18"
                @onTableChange="
                  (pagination) => {
                    fetchTableDataOnPageChange(pagination);
                  }
                "
                class="webVueAntYtTable webVueAntYtTableStyle-jkrgqqu webVueAntYtTableStyle-jk webVueAntYtTableStyle"
                :selectType="'checkbox'"
                v-model:selectedRows="Form1selectedRows1"
                v-model:total="Form1total1"
                v-model:current="Form1current1"
                v-model:pageSize="Form1pageSize1"
                :columns="Form1data1.columns"
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
                :dataSource="Form1data1.dataSource"
                :scroll="{ y: 535.9999980143481 }"
                :selectKey="DynamicPanelselectKey1"
              >
                <template
                  #cell="{ column, record }"
                  :selectKey="DynamicPanelselectKey1"
                >
                  <template
                    v-if="column.dataIndex === 'operation'"
                    :forKey="'operation'"
                    :selectKey="DynamicPanelselectKey1"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      params="record"
                      backgroundType="color"
                      class="customTableTemplate"
                      slotWidth="125"
                      slotHeight="46"
                      yt-domslot="operation"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div
                          style="height: 97.83%; z-index: 1"
                          class="flexRow spaceStart"
                        >
                          <div style="z-index: 1; width: 100%; height: 100%">
                            <yt-dynamic-panel
                              ref="ref20"
                              class="webVueAntYtDynamicPanel"
                            >
                              <div
                                style="
                                  position: relative;
                                  height: 100%;
                                  width: 100%;
                                "
                                backgroundType="color"
                                slotWidth="123"
                                slotHeight="43"
                                yt-domslot="ytDynamicPanel"
                                yt-template
                              >
                                <div
                                  style="
                                    width: 100%;
                                    height: 100%;
                                    overflow: hidden;
                                  "
                                  class="rootContainer flexCol spaceStart"
                                >
                                  <!-- 修改动态面板的状态到状态1，对应的是修改DynamicPanelselectKey1为1 -->
                                  <div
                                    v-if="record.bailingStatus1 === '待开票'"
                                    style="width: 100%; height: 100%"
                                  >
                                    <div
                                      style="
                                        height: 74.42%;
                                        z-index: 1;
                                        transform: translateY(18.75%);
                                      "
                                      class="flexRow spaceAround"
                                    >
                                      <div
                                        style="
                                          z-index: 1;
                                          width: 78.05%;
                                          height: 100%;
                                          transform: translateX(0.52%);
                                        "
                                      >
                                        <a-form-item
                                          ref="ref24"
                                          name="UploadInvoicefileList1"
                                          :colon="false"
                                          :class="[
                                            'webVueAntUploadButton',
                                            'webVueAntUploadButtonFormItem-jkg5b70-1',
                                            'webVueAntUploadButtonStyle-jkr8r9a-1',
                                            'webVueAntUploadButtonFormItem-jk',
                                            'webVueAntUploadButtonFormItem',
                                            'webVueAntUploadButtonStyle-jk',
                                            'webVueAntUploadButtonStyle',
                                            'hide-label-jk',
                                            'hide-label',
                                            'row-jk',
                                            'row',
                                          ]"
                                        >
                                          <template #label>
                                            <div class="label-content">
                                              <span
                                                class="ant-form-item-content"
                                                v-html="'标题：'"
                                              ></span>
                                            </div>
                                          </template>
                                          <yt-upload-button-inner
                                            @change="
                                              () => {
                                                handleInvoiceUploadChange();
                                              }
                                            "
                                            v-model:fileList="
                                              UploadInvoicefileList1
                                            "
                                            :maxSize="'5'"
                                            :buttonContent="'上传发票'"
                                            :maxCount="1"
                                          ></yt-upload-button-inner>
                                        </a-form-item>
                                      </div>
                                    </div>
                                  </div>
                                  <!-- 修改动态面板的状态到状态2，对应的是修改DynamicPanelselectKey1为2 -->
                                  <div
                                    v-if="record.bailingStatus1 === '已开票'"
                                    style="width: 100%; height: 100%"
                                  >
                                    <div
                                      style="
                                        z-index: 2;
                                        width: 78.05%;
                                        height: 74.42%;
                                        margin-left: 11.38%;
                                        transform: translateY(18.75%);
                                      "
                                    >
                                      <a-form-item
                                        ref="ref25"
                                        name="UpdateInvoicefileList1"
                                        :colon="false"
                                        :class="[
                                          'webVueAntUploadButton',
                                          'webVueAntUploadButtonFormItem-jk0nzek-2',
                                          'webVueAntUploadButtonStyle-jkswce8-2',
                                          'webVueAntUploadButtonFormItem-jk',
                                          'webVueAntUploadButtonFormItem',
                                          'webVueAntUploadButtonStyle-jk',
                                          'webVueAntUploadButtonStyle',
                                          'hide-label-jk',
                                          'hide-label',
                                          'row-jk',
                                          'row',
                                        ]"
                                      >
                                        <template #label>
                                          <div class="label-content">
                                            <span
                                              class="ant-form-item-content"
                                              v-html="'标题：'"
                                            ></span>
                                          </div>
                                        </template>
                                        <yt-upload-button-inner
                                          @change="
                                            () => {
                                              handleInvoiceUpdateChange();
                                            }
                                          "
                                          v-model:fileList="
                                            UpdateInvoicefileList1
                                          "
                                          :maxSize="'5'"
                                          :buttonContent="'更新发票'"
                                          :maxCount="1"
                                        ></yt-upload-button-inner>
                                      </a-form-item>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </yt-dynamic-panel>
                          </div>
                        </div>
                      </div>
                    </div>
                  </template>
                  <template
                    v-if="column.dataIndex === 'invoiceAttachments'"
                    :forKey="'invoiceAttachments'"
                    :selectKey="DynamicPanelselectKey1"
                  >
                    <div
                      v-for="fileName in typeof record.invoiceAttachments ===
                      'string'
                        ? record.invoiceAttachments.split(',')
                        : record.invoiceAttachments"
                      :key="fileName"
                    >
                      <a-button ref="ref27">
                        <span v-html="fileName"></span>
                      </a-button>
                    </div>
                  </template>
                </template>
              </yt-table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { h } from "vue";
export default {
  data() {
    return {
      // method中的函数用到的变量只能使用data中的变量,考虑到输出token限制,data中的变量不需要输出出来
      invoiceId: null, // 假设这是当前发票的ID
      Resetloading1: false,
      Searchloading1: false,
      BailingStatusoptions1: {
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
      SearchBoxform1: {
        id: null /*编辑时,需要给id赋值*/,
        orderNumber: "",
        applicationtime: [],
        licenseplatenumber: "",
        invoiceHeader: "",
        bailingStatus: undefined,
        bailingTime: [],
        orderType: undefined,
      },
      Form1selectedRows1: [],
      Form1pageSize1: 10,
      Form1data1: {
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
            key: "orderNumber",
            title: "订单编号",
            dataIndex: "orderNumber",
          },
          {
            key: "licenseplatenumber",
            title: "车牌号",
            dataIndex: "licenseplatenumber",
          },
          {
            key: "applicationtime",
            title: "申请时间",
            dataIndex: "applicationtime",
          },
          {
            key: "actualamountpaid",
            title: "实付金额",
            dataIndex: "actualamountpaid",
          },
          {
            key: "orderType",
            title: "订单类型",
            dataIndex: "orderType",
          },
          {
            key: "invoiceType1",
            title: "发票类型",
            dataIndex: "invoiceType1",
          },
          {
            key: "headerType",
            title: "抬头类型",
            dataIndex: "headerType",
          },
          {
            key: "invoiceInformation1",
            title: "发票信息",
            dataIndex: "invoiceInformation1",
          },
          {
            key: "bailingStatus1",
            title: "开票状态",
            dataIndex: "bailingStatus1",
            customRender: ({ text, record, index, column }) => {
              // 根据bailingStatus1字段的值设置文本颜色
              let color = "";
              if (record.bailingStatus1 === "待开票") {
                color = "red"; // 待开票时文本标红
              } else if (record.bailingStatus1 === "已开票") {
                color = "green"; // 已开票时文本标绿
              }

              // 返回渲染的元素
              return h("div", [
                h(
                  "span",
                  {
                    class: "td-text",
                    style: `color: ${color};`,
                  },
                  text
                ),
              ]);
            },
          },
          {
            key: "bailingTime",
            title: "开票时间",
            dataIndex: "bailingTime",
          },
          {
            key: "invoiceAttachments",
            title: "发票附件",
            dataIndex: "invoiceAttachments",
            cellType: "default",
          },
          {
            key: "handleperson",
            title: "处理人",
            dataIndex: "handleperson",
          },
          {
            key: "operation",
            title: "操作",
            dataIndex: "operation",
            cellType: "slot",
          },
        ],
        dataSource: [
          {
            id: 1,
            orderNumber: "标题1",
            headerType: "个人或事业单位",
            serialNumber1: "1",
            licenseplatenumber: "粤B67890",
            applicationtime: "2024-03-13 10:17",
            actualamountpaid: "",
            invoiceType1: "普通电子发票",
            orderType: "停车订单",
            invoiceInformation1: "",
            bailingStatus1: "待开票",
          },
          {
            id: 2,
            orderNumber: "标题2",
            serialNumber1: "2",
            applicationtime: "",
            headerType: "",
            orderType: "洗车订单",
            invoiceAttachments: "",
            invoiceInformation1: "",
            bailingStatus1: "已开票",
          },
          {
            id: 0,
            orderNumber: "",
            serialNumber1: "",
            applicationtime: "",
            headerType: "",
            orderType: "充电订单",
            invoiceInformation1: "",
            bailingStatus1: "",
          },
        ],
      },
      Form1current1: 1,
      Form1total1: 2,
      DynamicPanelpanel1: {},
      DynamicPanelselectKey1: "1",
      UpdateInvoicefileList1: [],
      UpdateInvoicestateKey1: "2",
      UploadInvoicefileList1: [],
      UploadInvoicestateKey1: "2",
      Exportloading1: false,
      OrderTypeoptions1: {
        dataSource: [
          {
            label: "停车订单",
            value: "停车订单",
            disabled: false,
            select: false,
          },
          {
            label: "充电订单",
            value: "充电订单",
            disabled: false,
            select: false,
          },
          {
            value: "洗车订单",
            label: "洗车订单",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      UpdateInvoiceisShow1: false,
    };
  },
  watch: {},
  methods: {
    fetchTableDataOnPageChange(pagination) {
      /**
      根据分页信息显示对应页面数据 当前需求和组件(ref=ref18)有关。
      */
      // 获取当前页码和每页大小
      const currentPage = parseInt(pagination.current); // 确保类型匹配
      const pageSize = parseInt(pagination.pageSize); // 确保类型匹配

      // 调用后端接口获取数据
      this.executeBackendInterface("generalFetchTableData", {
        current: currentPage,
        pageSize: pageSize,
        orderNumber: this.SearchBoxform1.orderNumber,
        // 订单编号
        licensePlate: this.SearchBoxform1.licenseplatenumber,
        // 车牌号
        invoiceHeader: this.SearchBoxform1.invoiceHeader,
        // 发票抬头
        applicationTimeStart:
          this.SearchBoxform1.applicationtime.length > 0
            ? this.SearchBoxform1.applicationtime[0]
            : "",
        // 申请时间开始
        applicationTimeEnd:
          this.SearchBoxform1.applicationtime.length > 1
            ? this.SearchBoxform1.applicationtime[1]
            : "",
        // 申请时间结束
        bailingStatus: this.SearchBoxform1.bailingStatus,
        // 开票状态
        bailingTimeStart:
          this.SearchBoxform1.bailingTime.length > 0
            ? this.SearchBoxform1.bailingTime[0]
            : "",
        // 开票时间开始
        bailingTimeEnd:
          this.SearchBoxform1.bailingTime.length > 1
            ? this.SearchBoxform1.bailingTime[1]
            : "",
        // 开票时间结束
        orderType: this.SearchBoxform1.orderType, // 订单类型
      })
        .then((response) => {
          if (response.flag) {
            // 校验返回数据格式并赋值
            const data = response.data.data.map((item) => ({
              id: item.id,
              serialNumber1: item.sequence_number,
              orderNumber: item.order_number,
              licenseplatenumber: item.license_plate,
              applicationtime: item.application_time,
              actualamountpaid: item.actual_payment,
              orderType: item.order_type,
              invoiceType1: item.invoice_type,
              headerType: item.title_type,
              invoiceInformation1: item.invoice_info,
              bailingStatus1: item.invoice_status,
              bailingTime: item.invoice_time,
              invoiceAttachments: item.invoice_attachment,
              handleperson: item.handler,
              operation: item.operation,
            }));

            // 更新表格数据
            this.Form1data1.dataSource = data;
            this.Form1total1 = response.data.total;
          } else {
            message.error(response.message);
          }
        })
        .catch((error) => {
          message.error("数据加载失败");
        });
    },
    handleSearchClick() {
      /**
       * 根据搜索区域(ref=ref3)中的字段查询表格(ref=ref18)中的数据；
       * 订单编号(ref=ref4)、车牌号(ref=ref9)、发票抬头(ref=ref10)支持模糊查询。 当前需求和组件(ref=ref6)有关。
       */
      this.generalFetchTableData();
    },
    async generalFetchTableData() {
      try {
        // 调用后端接口获取数据
        const response = await this.executeBackendInterface(
          "generalFetchTableData",
          {
            current: parseInt(this.Form1current1),
            // 确保类型匹配
            pageSize: parseInt(this.Form1pageSize1),
            // 确保类型匹配
            orderNumber: this.SearchBoxform1.orderNumber,
            // 订单编号
            licensePlate: this.SearchBoxform1.licenseplatenumber,
            // 车牌号
            invoiceHeader: this.SearchBoxform1.invoiceHeader,
            // 发票抬头
            applicationTimeStart:
              this.SearchBoxform1.applicationtime.length > 0
                ? this.SearchBoxform1.applicationtime[0]
                : "",
            // 申请时间开始
            applicationTimeEnd:
              this.SearchBoxform1.applicationtime.length > 1
                ? this.SearchBoxform1.applicationtime[1]
                : "",
            // 申请时间结束
            bailingStatus: this.SearchBoxform1.bailingStatus,
            // 开票状态
            bailingTimeStart:
              this.SearchBoxform1.bailingTime.length > 0
                ? this.SearchBoxform1.bailingTime[0]
                : "",
            // 开票时间开始
            bailingTimeEnd:
              this.SearchBoxform1.bailingTime.length > 1
                ? this.SearchBoxform1.bailingTime[1]
                : "",
            // 开票时间结束
            orderType: this.SearchBoxform1.orderType, // 订单类型
          }
        );

        if (response.flag) {
          // 校验返回数据格式并赋值
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.sequence_number,
            orderNumber: item.order_number,
            licenseplatenumber: item.license_plate,
            applicationtime: item.application_time,
            actualamountpaid: item.actual_payment,
            orderType: item.order_type,
            invoiceType1: item.invoice_type,
            headerType: item.title_type,
            invoiceInformation1: item.invoice_info,
            bailingStatus1: item.invoice_status,
            bailingTime: item.invoice_time,
            invoiceAttachments: item.invoice_attachment,
            handleperson: item.handler,
            operation: item.operation,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1total1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("数据加载失败");
      }
    },
    handleResetClick() {
      /**
       * 清空搜索区域(ref=ref3)中的数据,并初始化表格(ref=ref18) 当前需求和组件(ref=ref5)有关。
       */
      // 清空搜索区域中的数据
      this.SearchBoxform1.orderNumber = "";
      this.SearchBoxform1.applicationtime = [];
      this.SearchBoxform1.licenseplatenumber = "";
      this.SearchBoxform1.invoiceHeader = "";
      this.SearchBoxform1.bailingStatus = ""; // 修改为''以匹配接口文档
      this.SearchBoxform1.bailingTime = [];
      this.SearchBoxform1.orderType = ""; // 修改为''以匹配接口文档

      // 初始化表格数据
      this.Form1current1 = 1; // 重置页码为1
      this.generalFetchTableData(); // 调用通用查询函数刷新表格数据
    },

    async generalFetchTableDataP3L() {
      try {
        // 调用后端接口获取数据
        const response = await this.executeBackendInterface(
          "generalFetchTableData",
          {
            current: parseInt(this.Form1current1),
            // 确保类型匹配
            pageSize: parseInt(this.Form1pageSize1),
            // 确保类型匹配
            orderNumber: this.SearchBoxform1.orderNumber,
            // 订单编号
            licensePlate: this.SearchBoxform1.licenseplatenumber,
            // 车牌号
            invoiceHeader: this.SearchBoxform1.invoiceHeader,
            // 发票抬头
            applicationTimeStart:
              this.SearchBoxform1.applicationtime.length > 0
                ? this.SearchBoxform1.applicationtime[0]
                : "",
            // 申请时间开始
            applicationTimeEnd:
              this.SearchBoxform1.applicationtime.length > 1
                ? this.SearchBoxform1.applicationtime[1]
                : "",
            // 申请时间结束
            bailingStatus: this.SearchBoxform1.bailingStatus,
            // 开票状态
            bailingTimeStart:
              this.SearchBoxform1.bailingTime.length > 0
                ? this.SearchBoxform1.bailingTime[0]
                : "",
            // 开票时间开始
            bailingTimeEnd:
              this.SearchBoxform1.bailingTime.length > 1
                ? this.SearchBoxform1.bailingTime[1]
                : "",
            // 开票时间结束
            orderType: this.SearchBoxform1.orderType, // 订单类型
          }
        );

        if (response.flag) {
          // 校验返回数据格式并赋值
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.sequence_number,
            orderNumber: item.order_number,
            licenseplatenumber: item.license_plate,
            applicationtime: item.application_time,
            actualamountpaid: item.actual_payment,
            orderType: item.order_type,
            invoiceType1: item.invoice_type,
            headerType: item.title_type,
            invoiceInformation1: item.invoice_info,
            bailingStatus1: item.invoice_status,
            bailingTime: item.invoice_time,
            invoiceAttachments: item.invoice_attachment,
            handleperson: item.handler,
            operation: item.operation,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1total1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("数据加载失败");
      }
    },
    initializeTableOnPageLoad() {
      /**
      进入页面后,将表格(ref=ref18)中的数据显示在表格(ref=ref18)中 当前需求和组件(ref=ref18)有关。
      */
      this.generalFetchTableData(); // 调用通用查询函数以初始化表格数据
    },

    async handleExportClick() {
      /**
       * 用.xlsx的格式,当未勾选时导出表格(ref=ref18)中前1000条数据；当表格(ref=ref18)已勾选内容是,导出勾选的数据 当前需求和组件(ref=ref15)有关。
       */
      try {
        // 判断是否有勾选的行
        const selectedIds = this.Form1selectedRows1.map((row) => row.id);

        // 设置请求参数
        const params = {
          current: 1,
          // 确保current是整数类型
          pageSize: 1000, // 确保pageSize是整数类型
        };

        // 如果有勾选的行，则只导出勾选的行
        if (selectedIds.length > 0) {
          params.selectedIds = selectedIds;
        }

        // 调用后端接口，获取导出数据的文件流
        const response = await this.download_executeBackendInterface(
          "exportTableData",
          params
        );

        // 创建一个Blob对象来处理文件流
        const blob = new Blob([response], {
          type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        });

        // 创建一个隐藏的a标签用于下载文件
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);
        link.download = "导出数据.xlsx";
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
        message.success("导出成功");
      } catch (error) {
        message.error("导出过程中发生错误");
        console.error(error);
      }
    },
    async handleInvoiceUploadChange() {
      /**
      将开票状态改为“已开票”,并将上传的文件地址写当前行发票附件字段中, 当前需求和组件(ref=ref24)有关。
      */

      // 获取上传的文件路径和发票记录的唯一标识符
      const fileList = this.$refs.ref24.fileList;
      if (!fileList || fileList.length === 0) {
        message.error("没有上传的文件");
        return;
      }
      const invoiceAttachment = fileList[0].url; // 假设上传的文件路径在fileList的第一个文件中
      const id = parseInt(this.$refs.ref24.id, 10); // 确保id是整数类型

      // 调用后端接口更新发票附件字段和开票状态
      try {
        const response = await this.executeBackendInterface(
          "handleInvoiceUploadChange",
          {
            invoiceAttachment: invoiceAttachment.toString(),
            // 确保invoiceAttachment是字符串类型
            id,
          }
        );
        if (response.flag) {
          message.success("发票上传成功，状态已更新为“已开票”");
        } else {
          message.error(`发票上传失败: ${response.message}`);
        }
      } catch (error) {
        message.error("发票上传过程中发生错误");
      }
    },
    async handleInvoiceUpdateChange() {
      /**
      替换发票附件的文件地址 当前需求和组件(ref=ref25)有关。
      */
      try {
        // 弹出确认对话框
        Modal.confirm({
          title: "确认更新",
          content: "您确定要更新发票附件吗？",
          onOk: async () => {
            // 假设ref25是一个上传组件，获取新的文件路径
            const fileList = this.$refs.ref25.fileList;
            const newAttachmentPath =
              fileList && fileList.length > 0 ? fileList[0].url || "" : "";

            // 确保this.invoiceId是整数类型
            const invoiceId = parseInt(this.invoiceId, 10);

            // 调用后端接口更新发票附件路径
            const response = await this.executeBackendInterface(
              "handleInvoiceUpdateChange",
              {
                id: invoiceId,
                // 确保类型匹配
                newAttachmentPath: newAttachmentPath,
              }
            );

            // 检查接口调用结果
            if (response.flag) {
              message.success("发票附件更新成功");
            } else {
              message.error(`更新失败: ${response.message}`);
            }
          },
          onCancel: () => {
            message.info("取消更新");
          },
        });
      } catch (error) {
        message.error("更新过程中发生错误");
      }
    },
    async generalFetchTableData30X() {
      /**
       * 该接口用于表格(ref=ref18)的数据查询操作，支持以下功能：
       * 1. 初始化表格数据：在页面加载时，自动获取并显示表格中的数据。
       * 2. 条件查询：根据搜索区域(ref=ref3)中的字段进行查询，支持订单编号(ref=ref4)、车牌号(ref=ref9)、发票抬头(ref=ref10)的模糊查询。
       * 3. 分页查询：根据分页信息(页码current，每页大小pageSize)获取对应页面的数据，并返回总条目数(total)。
       * 4. 数据刷新：在搜索条件变更或重置时，重新获取并显示表格数据。
       * 5. 数据导出：支持将表格中前1000条数据或已勾选的数据导出为.xlsx格式。
       */
      try {
        // 调用后端接口获取数据
        const response = await this.executeBackendInterface(
          "generalFetchTableData",
          {
            current: parseInt(this.Form1current1),
            // 确保类型匹配
            pageSize: parseInt(this.Form1pageSize1),
            // 确保类型匹配
            orderNumber: this.SearchBoxform1.orderNumber,
            // 订单编号
            licensePlate: this.SearchBoxform1.licenseplatenumber,
            // 车牌号
            invoiceHeader: this.SearchBoxform1.invoiceHeader,
            // 发票抬头
            applicationTimeStart:
              this.SearchBoxform1.applicationtime.length > 0
                ? this.SearchBoxform1.applicationtime[0]
                : "",
            // 申请时间开始
            applicationTimeEnd:
              this.SearchBoxform1.applicationtime.length > 1
                ? this.SearchBoxform1.applicationtime[1]
                : "",
            // 申请时间结束
            bailingStatus: this.SearchBoxform1.bailingStatus,
            // 开票状态
            bailingTimeStart:
              this.SearchBoxform1.bailingTime.length > 0
                ? this.SearchBoxform1.bailingTime[0]
                : "",
            // 开票时间开始
            bailingTimeEnd:
              this.SearchBoxform1.bailingTime.length > 1
                ? this.SearchBoxform1.bailingTime[1]
                : "",
            // 开票时间结束
            orderType: this.SearchBoxform1.orderType, // 订单类型
          }
        );

        if (response.flag) {
          // 校验返回数据格式并赋值
          const data = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1: item.sequence_number,
            orderNumber: item.order_number,
            licenseplatenumber: item.license_plate,
            applicationtime: item.application_time,
            actualamountpaid: item.actual_payment,
            orderType: item.order_type,
            invoiceType1: item.invoice_type,
            headerType: item.title_type,
            invoiceInformation1: item.invoice_info,
            bailingStatus1: item.invoice_status,
            bailingTime: item.invoice_time,
            invoiceAttachments: item.invoice_attachment,
            handleperson: item.handler,
            operation: item.operation,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1total1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("数据加载失败");
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1867445615403728896";
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
          .post("./WebOnlineinvoicing/" + funcName, params, {
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
    download_executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios
          .post("./WebOnlineinvoicing/" + funcName, params, {
            headers: {
              "Content-Type": "application/json",
            },
            responseType: "blob", // 添加 responseType 为 blob
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
    // 在组件挂载时初始化表格数据
    this.generalFetchTableData();
    // 在组件挂载时初始化表格数据
    this.generalFetchTableData();
    this.initializeTableOnPageLoad(); // 页面加载时初始化表格数据
    // 在组件挂载时初始化表格数据
    this.generalFetchTableData();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
@import "/public/css/web/vue/antdesign/YtSpan/default";
@import "/public/css/web/vue/antdesign/YtForm/default";
@import "/public/css/web/vue/antdesign/YtInput/default";
@import "/public/css/web/vue/antdesign/YtButton/default";
@import "/public/css/web/vue/antdesign/YtRangePicker/default";
@import "/public/css/web/vue/antdesign/YtSelect/default";
@import "/public/css/web/vue/antdesign/YtTable/default";
@import "/public/css/web/vue/antdesign/YtRectangle/default";
@import "/public/css/web/vue/antdesign/YtUploadButton/default";
@import "/public/css/线上开票/theme";

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jkntw2d
  .ant-form-item-label
  label {
  width: 80px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jkntw2d
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-jk6um3o {
  color: #333333 !important;
  background: #ffffff !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-jk7hlz1 {
  background: #1890ff !important;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-jkp2vga
  .ant-form-item-label
  label {
  width: 81px;
}
.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-jkp2vga
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jk10cbf
  .ant-form-item-label
  label {
  width: 67px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jk10cbf
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jkja3m8
  .ant-form-item-label
  label {
  width: 80px;
}
.webVueAntYtInputFormItem.webVueAntYtInputFormItem-jkja3m8
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-jkrx5bi
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-jkvuc5d
  .ant-form-item-label
  label {
  width: 81px;
}
.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-jkvuc5d
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu .ant-table {
  border-right: 1px solid transparent;
  border-left: 1px solid transparent;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-thead
  tr,
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-thead
  tr
  th {
  background: #eaeef3;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
  font-size: 16px;
  font-weight: bold;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  thead
  tr
  th:not(:last-child),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 0px solid #dcdcdc;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(2)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(2),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(2),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(3)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(3),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(3),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(3) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(4)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(4),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(4),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(4) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(5)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(5),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(5),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(5) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(6)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(6),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(6),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(6) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(7)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(7),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(7),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(7) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(8)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(8),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(8),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(8) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(9)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(9),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(9),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(9) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(10)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(10),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(10) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(11)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(11),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(11) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(12)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(12),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(12) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(13)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(13),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(13),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(13) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(14)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(14),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(14),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(14) {
  width: calc((100% - 475px) / 9) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tr
  td:nth-child(15)
  div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
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
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu tr > th:nth-child(15),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-measure-row
  td:nth-child(15),
.webVueAntYtTableStyle.webVueAntYtTableStyle-jkrgqqu
  tbody
  tr.ant-table-row
  td:nth-child(15) {
  width: 127px !important;
  min-width: 127px !important;
  max-width: 127px !important;
}

.webVueAntYtRectangleStyle.webVueAntYtRectangleStyle-jkvg7id {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntUploadButtonFormItem-jkg5b70-1 .ant-form-item-label label {
  color: #1890ff;
}
.webVueAntUploadButtonStyle-jkr8r9a-1 .ant-btn {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
.webVueAntUploadButtonStyle-jkr8r9a-2 .ant-btn {
  background: #ffffff;
}

.webVueAntUploadButtonFormItem-jk0nzek-1 .ant-form-item-label label {
  color: #1890ff;
}
.webVueAntUploadButtonStyle-jkswce8-1 .ant-btn {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
.webVueAntUploadButtonFormItem-jk0nzek-2 .ant-form-item-label label {
  color: #1890ff;
}
.webVueAntUploadButtonStyle-jkswce8-2 .ant-btn {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-jkn8mml
  .ant-form-item-label
  label {
  width: 80px;
}
</style>
