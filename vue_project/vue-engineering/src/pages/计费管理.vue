<template>
  <yt-grid
    previewType="AdaptiveWH"
    width="1700"
    height="1016"
    background="#F0F2F5"
  >
    <yt-grid-item
      fixedSize="width"
      rotate="0"
      comWidth="58.00px"
      top="19.10000%"
      left="4.40000%"
      bottom="15.20000%"
      right="10.20000%"
      gridColumnStart="2"
      gridColumnEnd="6"
      gridRowStart="2"
      gridRowEnd="5"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref11"
        class="webVueAntYtSpan webVueAntYtSpanStyle-jhau2bu webVueAntYtSpanStyle-jh webVueAntYtSpanStyle null-jh null"
      >
        <span v-html="'计费管理'"> </span>
      </span>
    </yt-grid-item>
    <!-- 搜索 -->
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="4.80000%"
      left="0.10000%"
      bottom="4.30000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="18"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref1"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-jh62ndm webVueAntYtRectangleStyle-jh webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="14.80000%"
      left="1.70000%"
      bottom="6.30000%"
      right="1.10000%"
      gridColumnStart="3"
      gridColumnEnd="23"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref2"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-jh0jmyu webVueAntYtSelectFormItem-jh webVueAntYtSelectFormItem show-label-jh show-label customStyle"
        name="RuleNamevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'规则名称：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-jh79hwx webVueAntYtInputStyle-jh webVueAntYtInputStyle"
          v-model:value="RuleNamevalue1"
          :maxLength="100"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="17.30000%"
      left="3.30000%"
      bottom="3.90000%"
      right="4.20000%"
      gridColumnStart="28"
      gridColumnEnd="49"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref7"
        class="webVueSelectFormItem webVueAntYtSelectFormItem-jh0jmyu webVueAntYtSelectFormItem-jh webVueAntYtSelectFormItem show-label-jh show-label customStyle"
        name="chargingstandardvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'收费方案：'"> </span>
          </div>
        </template>
        <a-select
          data-event
          class="webVueSelect webVueAntYtSelectStyle-jh webVueAntYtSelectStyle"
          dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"'
          :showArrow="true"
          v-model:value="chargingstandardvalue1"
          :allowClear="true"
          :placeholder="'请输入'"
          :options="chargingstandardoptions1.dataSource"
          :showSearch="true"
        >
        </a-select>
      </a-form-item>
    </yt-grid-item>
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="17.30000%"
      left="0.00000%"
      bottom="3.90000%"
      right="2.90000%"
      gridColumnStart="54"
      gridColumnEnd="74"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref12"
        class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-jhtx6cs webVueAntYtRangePickerFormItem-jh webVueAntYtRangePickerFormItem show-label-jh show-label customStyle"
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
          class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-jhxycc0 webVueAntYtRangePickerStyle-jh webVueAntYtRangePickerStyle"
          popupKey='"popupKey" "popupKeyId"'
          v-model:value="Creationtimevalue1"
        >
        </yt-custom-range-picker>
      </a-form-item>
    </yt-grid-item>
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="14.80000%"
      left="1.10000%"
      bottom="6.30000%"
      right="1.70000%"
      gridColumnStart="79"
      gridColumnEnd="99"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref10"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-jhpfywo webVueAntYtInputFormItem-jh webVueAntYtInputFormItem show-label-jh show-label customStyle"
        name="Creatorvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'创建人：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-jhommqm webVueAntYtInputStyle-jh webVueAntYtInputStyle"
          v-model:value="Creatorvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="7.90000%"
      left="8.20000%"
      bottom="13.20000%"
      right="16.40000%"
      gridColumnStart="90"
      gridColumnEnd="95"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="3"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref4"
        @click="
          () => {
            queryBillingManagementList(1)
            BillingManagementListcurrent2 = 1
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-jhtbz99 webVueAntYtButtonStyle-jh webVueAntYtButtonStyle center-jh center"
      >
        <span class="yt-button-content" v-html="'查询'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="7.90000%"
      left="17.60000%"
      bottom="13.20000%"
      right="7.00000%"
      gridColumnStart="94"
      gridColumnEnd="99"
      gridRowStart="12"
      gridRowEnd="16"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref5"
        @click="
          () => {
            resetBillingManagementList()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-jhfo6w0 webVueAntYtButtonStyle-jh webVueAntYtButtonStyle center-jh center"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="0.60000%"
      left="0.10000%"
      bottom="1.10000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="19"
      gridRowEnd="100"
      zIndex="9"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref14"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-jh47gqn webVueAntYtRectangleStyle-jh webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="1.90000%"
      left="7.00000%"
      bottom="19.20000%"
      right="17.60000%"
      gridColumnStart="3"
      gridColumnEnd="8"
      gridRowStart="21"
      gridRowEnd="25"
      zIndex="10"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref15"
        @click="
          () => {
            showAddBillingModal()
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-jhz72sq webVueAntYtButtonStyle-jh webVueAntYtButtonStyle center-jh center"
      >
        <span class="yt-button-content" v-html="'新建'"> </span>
      </a-button>
    </yt-grid-item>
    <!-- 列表 -->
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      top="1.10000%"
      left="0.30000%"
      bottom="1.20000%"
      right="0.30000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="25"
      gridRowEnd="86"
      zIndex="11"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref17"
        @click="
          () => {
            queryBillingManagementList()
          }
        "
        @onTableChange="
          (pagination) => {
            changeBillingManagementListPage(pagination)
          }
        "
        @onRowClick="
          (record) => {
            handleClickRow(record)
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-jh7ykzc webVueAntYtTableStyle-jh webVueAntYtTableStyle"
        :canSelect="false"
        :selectType="'checkbox'"
        v-model:selectedRows="BillingManagementListselectedRows1"
        v-model:total="BillingManagementListtotal1"
        v-model:current="BillingManagementListcurrent2"
        v-model:pageSize="BillingManagementListpageSize1"
        :columns="BillingManagementListdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="BillingManagementListdata1.dataSource"
        :scroll="{ y: 492.9999578285365 }"
      >
        <template #cell="{ column, record, index }">
          <template
            v-if="column.dataIndex === 'operation1'"
            :forKey="'operation1'"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                rotate="0"
                top="0.30000%"
                left="2.20000%"
                bottom="0.30000%"
                right="0.90000%"
                gridColumnStart="60"
                gridColumnEnd="89"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref1688"
                  @click="
                    (event) => {
                      event.stopPropagation()
                      deleteRecord(record)
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-jhi6xee webVueAntYtButtonStyle-jh webVueAntYtButtonStyle center-jh center"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                rotate="0"
                top="0.30000%"
                left="2.70000%"
                bottom="0.30000%"
                right="0.40000%"
                gridColumnStart="16"
                gridColumnEnd="45"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref2367"
                  class="webVueAntButton webVueAntYtButtonStyle-jhhhcdz webVueAntYtButtonStyle-jh webVueAntYtButtonStyle center-jh center"
                  @click="
                    (event) => {
                      event.stopPropagation()
                      handleEdit(record)
                    }
                  "
                >
                  <span class="yt-button-content" v-html="'编辑'"> </span>
                </a-button>
              </yt-grid-item>
            </yt-grid>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>
    <!-- 新增/编辑计费 -->
    <yt-grid-item
      fixedSize="selfAdaption"
      rotate="0"
      :isShow="IncreasebillingisShow1"
      top="0.90000%"
      left="0.50000%"
      bottom="0.30000%"
      right="0.50000%"
      gridColumnStart="16"
      gridColumnEnd="86"
      gridRowStart="10"
      gridRowEnd="92"
      zIndex="14"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref4238"
        @ok="
          () => {
            addBillingRule()
          }
        "
        @cancel="handleCancelAddEdit"
        class="webVueAntYtModal webVueAntYtModalStyle-jh175tv webVueAntYtModalStyle-jh webVueAntYtModalStyle"
        v-model:isShow="IncreasebillingisShow1"
        :title="isDetail == 'add' ? '新增计费' : '编辑计费'"
        :okText="'保存'"
        :showFooter="true"
        :maskClosable="true"
      >
        <template #content>
          <a-form
            ref="formRef"
            name="advanced_search"
            class="ant-advanced-search-form"
            :model="formState"
          >
            <div>
              <span class="spanLable">基本信息</span>
              <a-row :gutter="24">
                <a-col :span="8">
                  <a-form-item name="rule_number" label="规则编号">
                    <a-input
                      v-model:value="formState[`rule_number`]"
                      placeholder="请输入"
                      :disabled="true"
                    ></a-input>
                  </a-form-item>
                </a-col>
                <a-col :span="8">
                  <a-form-item
                    name="rule_name"
                    label="规则名称"
                    :rules="[{ required: true, message: '请输入' }]"
                  >
                    <a-input
                      v-model:value="formState[`rule_name`]"
                      placeholder="请输入"
                      :disabled="isDetail == 'detail'"
                    ></a-input>
                  </a-form-item>
                </a-col>
                <a-col :span="8">
                  <a-form-item
                    name="billing_standard"
                    label="收费方案"
                    :rules="[{ required: true, message: '' }]"
                  >
                    <a-select
                      :showArrow="true"
                      :disabled="isDetail == 'detail'"
                      v-model:value="formState['billing_standard']"
                      :placeholder="'请输入'"
                      :options="chargingstandardoptions1.dataSource"
                      :showSearch="true"
                      @change="handleStandardChange"
                    >
                    </a-select>
                  </a-form-item>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="24">
                  <a-form-item name="rule_description" label="规则描述">
                    <a-input
                      data-event
                      v-model:value="formState['rule_description']"
                      :maxLength="100"
                      :placeholder="'请输入'"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-input>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="formState['billing_standard'] == '节假日/工作日不同费用'"
            >
              <span class="spanLable">收费方案</span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item name="segment_charging" label="分段收费">
                    <a-radio-group
                      data-event
                      v-model:value="formState['segment_charging']"
                      :disabled="isDetail == 'detail'"
                      @change="handleRadioChange"
                      :options="[
                        {
                          label: '开启',
                          value: '开启',
                        },
                        {
                          label: '关闭',
                          value: '关闭',
                        },
                      ]"
                    >
                    </a-radio-group>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="formState['billing_standard'] == '节假日/工作日不同费用'"
            >
              <span class="spanLable">节假日时间</span>
              <a-row :gutter="24" class="jjrsj" v-if="isDetail != 'detail'">
                <a-col :span="12" v-if="!clickAdd">
                  <a-button
                    class="operateBtn"
                    type="primary"
                    @click="clickAdd = true"
                    >新增</a-button
                  >
                  <!-- <a-button class="operateBtn" type="primary">同步</a-button> -->
                  <a-upload
                    action="/api/Billingmanagement/holidayUpload"
                    :showUploadList="false"
                    @change="handleChangeYardIconfileList2"
                  >
                    <a-button
                      class="operateBtn"
                      type="primary"
                      :loading="uploadStatus"
                    >
                      <upload-outlined></upload-outlined>
                      导入
                    </a-button>
                  </a-upload>

                  <a-button
                    class="operateBtn"
                    danger
                    @click="handleHolidayDelete"
                    >删除</a-button
                  >
                </a-col>
                <a-col :span="24" v-else>
                  <div class="addWrap">
                    <a-form-item name="holidayDate" label="日期">
                      <yt-custom-range-picker
                        data-event
                        popupKey='"popupKey" "popupKeyId"'
                        v-model:value="formState['holidayDate']"
                      >
                      </yt-custom-range-picker>
                    </a-form-item>
                    <a-form-item
                      style="margin: 0 10px; width: 40%"
                      name="`holidayRemark`"
                      label="备注"
                    >
                      <a-input
                        data-event
                        v-model:value="formState['holidayRemark']"
                        :maxLength="100"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input>
                    </a-form-item>
                    <a-button
                      class="operateBtn"
                      type="primary"
                      @click="handleddHoliday"
                      >添加</a-button
                    >
                    <a-button class="operateBtn" @click="clickAdd = false"
                      >取消</a-button
                    >
                  </div>
                </a-col>
              </a-row>
              <yt-table
                ref="ref6781"
                class="webVueAntYtTable webVueAntYtTableStyle-jhryqub webVueAntYtTableStyle-jh webVueAntYtTableStyle"
                :selectType="'checkbox'"
                v-model:selectedRows="HolidayScheduleselectedRows6"
                v-model:total="HolidayScheduletotal6"
                v-model:current="HolidaySchedulecurrent6"
                v-model:pageSize="HolidaySchedulepageSize6"
                :columns="HolidayScheduledata6.columns"
                :showQuickJumper="true"
                :dataSource="HolidayScheduledata6.dataSource"
                
              >
                <template #cell="{ column, record, index }">
                  <template v-if="column.key == 'serialNumber'">
                    <span>{{ index + 1 }}</span>
                  </template>
                  <template v-if="column.key == 'operation'">
                    <a-button
                      type="link"
                      danger
                      @click="handleHolidayDelete(record)"
                      >删除</a-button
                    >
                  </template>
                </template>
              </yt-table>
            </div>
            <div
              v-if="
                formState['billing_standard'] != '免费停车' &&
                formState['billing_standard']
              "
            >
              <span class="spanLable">方案配置-免费时长</span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="free_duration"
                    label="免费时长"
                    class="minute"
                  >
                    <a-input-number
                      v-model:value="formState[`free_duration`]"
                      placeholder="请输入"
                      :min="1"
                      :disabled="isDetail == 'detail'"
                    ></a-input-number>
                    <span>分钟</span>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="new_energy_free_duration_reduction"
                    label="新能源免费时长"
                  >
                    <a-radio-group
                      data-event
                      v-model:value="
                        formState['new_energy_free_duration_reduction']
                      "
                      :options="radioOption"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-radio-group>
                  </a-form-item>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="free_duration_reduction"
                    label="免费时长减免"
                  >
                    <a-radio-group
                      data-event
                      v-model:value="formState['free_duration_reduction']"
                      :options="radioOption"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-radio-group>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="new_energy_free_duration"
                    label="新能源免费时长"
                    class="minute"
                  >
                    <a-input-number
                      v-model:value="formState['new_energy_free_duration']"
                      placeholder="请输入"
                      :min="1"
                      :disabled="isDetail == 'detail'"
                    ></a-input-number>
                    <span>分钟</span>
                  </a-form-item>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item name="white_plate_car_free" label="白牌车免费">
                    <a-radio-group
                      data-event
                      v-model:value="formState['white_plate_car_free']"
                      :options="radioOption"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-radio-group>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="new_energy_free_times"
                    label="新能源免费次数"
                  >
                    <a-select
                      data-event
                      :showArrow="true"
                      v-model:value="formState['new_energy_free_times']"
                      :placeholder="'请输入'"
                      :disabled="isDetail == 'detail'"
                      :mode="'single'"
                      :options="[
                        {
                          label: '当日一次',
                          value: 1,
                          disabled: false,
                          select: false,
                        },
                        {
                          label: '不限次数',
                          value: -1,
                          disabled: false,
                          select: false,
                        },
                      ]"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="
                formState['billing_standard'] != '免费停车' &&
                formState['billing_standard']
              "
            >
              <span class="spanLable">方案配置-免费时段</span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-space
                    v-for="(time, index) in formState['timeRange']"
                    :key="time.id"
                    style="display: flex; margin-bottom: 8px"
                    align="baseline"
                  >
                    <a-form-item
                      :name="['timeRange', index, 'free_begin_time']"
                      label="免费时段"
                    >
                      <yt-custom-time-picker
                        class="dateWrap"
                        v-model:value="time['free_begin_time']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <span>-</span>
                    <a-form-item :name="['timeRange', index, 'free_end_time']">
                      <yt-custom-time-picker
                        class="dateWrap"
                        v-model:value="time['free_end_time']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <MinusCircleOutlined
                      v-if="index != 0 && isDetail != 'detail'"
                      @click="removeTime(time)"
                    />
                    <span
                      class="addBtn"
                      v-if="index == 0 && isDetail != 'detail'"
                      @click="addTime(time)"
                      >添加</span
                    >
                  </a-space>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="free_period_reduction"
                    label="免费时段减免"
                  >
                    <a-radio-group
                      data-event
                      v-model:value="formState['free_period_reduction']"
                      :options="radioOption"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-radio-group>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>

            <div
              v-if="
                formState['billing_standard'] == '节假日/工作日不同费用' ||
                formState['billing_standard'] == '分段收费' ||
                formState['billing_standard'] == '自然天收费'
              "
            >
              <span class="spanLable"
                >{{
                  formState['billing_standard'] == '自然天收费'
                    ? '方案配置-收费金额'
                    : formState['billing_standard'] == '分段收费'
                    ? '方案配置-日间收费'
                    : formState['billing_standard'] ==
                        '节假日/工作日不同费用' &&
                      formState['segment_charging'] == '开启'
                    ? '方案配置-工作日收费-日间收费'
                    : '方案配置-工作日收费'
                }}
              </span>
              <a-row
                :gutter="24"
                v-if="
                  formState['billing_standard'] == '分段收费' ||
                  (formState['billing_standard'] == '节假日/工作日不同费用' &&
                    formState['segment_charging'] == '开启')
                "
              >
                <a-col :span="12">
                  <div class="rjsdWrap mfscWrap">
                    <a-form-item name="wd_begin_time_range" label="日间时段">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['wd_begin_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <span>-</span>
                    <a-form-item name="wd_end_time_range" label="">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['wd_end_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_temporary_car_first_ceil"
                      label="临时车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        v-model:value="formState['wd_temporary_car_first_ceil']"
                        :placeholder="'请输入'"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_temporary_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['wd_temporary_car_first_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wd_temporary_car_first_tier"
                      label=" 分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['wd_temporary_car_first_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_stored_value_car_first_ceil"
                      label="储值车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_first_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_stored_value_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_first_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_stored_value_car_first_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_first_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_temporary_car_second_ceil"
                      label="临时车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_temporary_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_temporary_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_temporary_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_temporary_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_temporary_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_stored_value_car_second_ceil"
                      label="储值车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_second_ceil']
                        "
                        :maxLength="100"
                        :disabled="isDetail == 'detail'"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_stored_value_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_stored_value_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wd_stored_value_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_temporary_car_third_ceil"
                      label="临时车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wd_temporary_car_third_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_temporary_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wd_temporary_car_third_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wd_temporary_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wd_temporary_car_third_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wd_stored_value_car_third_ceil"
                      label="储值车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wd_stored_value_car_third_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wd_stored_value_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wd_stored_value_car_third_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wd_stored_value_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wd_stored_value_car_third_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="wd_temporary_car_cap_amount"
                    label="临时车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="formState['wd_temporary_car_cap_amount']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="wd_stored_value_car_cap_amount"
                    label="储值车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="
                        formState['wd_stored_value_car_cap_amount']
                      "
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="
                (formState['billing_standard'] == '节假日/工作日不同费用' &&
                  formState['segment_charging'] == '开启') ||
                formState['billing_standard'] == '分段收费'
              "
            >
              <span class="spanLable">
                {{
                  formState['billing_standard'] == '分段收费'
                    ? '方案配置-夜间收费'
                    : '方案配置-工作日收费-夜间收费'
                }}
              </span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="rjsdWrap mfscWrap">
                    <a-form-item name="wn_begin_time_range" label="夜间时段">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['wn_begin_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <span>-</span>
                    <a-form-item name="wn_end_time_range" label="">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['wn_end_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_temporary_car_first_ceil"
                      label="临时车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['wn_temporary_car_first_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_temporary_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['wn_temporary_car_first_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wn_temporary_car_first_tier"
                      label=" 分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['wn_temporary_car_first_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_stored_value_car_first_ceil"
                      label="储值车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_first_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_stored_value_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_first_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_stored_value_car_first_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_first_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_temporary_car_second_ceil"
                      label="临时车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_temporary_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_temporary_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_temporary_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_temporary_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_temporary_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_stored_value_car_second_ceil"
                      label="储值车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_stored_value_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_stored_value_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['wn_stored_value_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_temporary_car_third_ceil"
                      label="临时车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wn_temporary_car_third_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_temporary_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wn_temporary_car_third_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="wn_temporary_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['wn_temporary_car_third_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="wn_stored_value_car_third_ceil"
                      label="储值车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wn_stored_value_car_third_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wn_stored_value_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wn_stored_value_car_third_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="wn_stored_value_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['wn_stored_value_car_third_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="wn_temporary_car_cap_amount"
                    label="临时车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="formState['wn_temporary_car_cap_amount']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="wn_stored_value_car_cap_amount"
                    label="储值车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="
                        formState['wn_stored_value_car_cap_amount']
                      "
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="formState['billing_standard'] == '节假日/工作日不同费用'"
            >
              <span class="spanLable">
                {{
                  formState['billing_standard'] == '节假日/工作日不同费用' &&
                  formState['segment_charging'] == '开启'
                    ? '方案配置-节假日收费-日间收费'
                    : '方案配置-节假日收费'
                }}
              </span>
              <a-row
                :gutter="24"
                v-if="
                  formState['billing_standard'] == '节假日/工作日不同费用' &&
                  formState['segment_charging'] == '开启'
                "
              >
                <a-col :span="12">
                  <div class="rjsdWrap mfscWrap">
                    <a-form-item name="hd_begin_time_range" label="日间时段">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['hd_begin_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <span>-</span>
                    <a-form-item name="hd_end_time_range" label="">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['hd_end_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_temporary_car_first_ceil"
                      label="临时车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hd_temporary_car_first_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_temporary_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hd_temporary_car_first_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hd_temporary_car_first_tier"
                      label=" 分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hd_temporary_car_first_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_stored_value_car_first_ceil"
                      label="储值车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_first_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_stored_value_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_first_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_stored_value_car_first_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_first_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_temporary_car_second_ceil"
                      label="临时车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_temporary_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_temporary_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_temporary_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_temporary_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_temporary_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_stored_value_car_second_ceil"
                      label="储值车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_stored_value_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_stored_value_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hd_stored_value_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_temporary_car_third_ceil"
                      label="临时车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hd_temporary_car_third_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_temporary_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hd_temporary_car_third_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hd_temporary_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hd_temporary_car_third_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hd_stored_value_car_third_ceil"
                      label="储值车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hd_stored_value_car_third_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hd_stored_value_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hd_stored_value_car_third_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hd_stored_value_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hd_stored_value_car_third_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="hd_temporary_car_cap_amount"
                    label="临时车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="formState['hd_temporary_car_cap_amount']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="hd_stored_value_car_cap_amount"
                    label="储值车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="
                        formState['hd_stored_value_car_cap_amount']
                      "
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div
              v-if="
                formState['billing_standard'] == '节假日/工作日不同费用' &&
                formState['segment_charging'] == '开启'
              "
            >
              <span class="spanLable"> 方案配置-节假日收费-夜间收费</span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="rjsdWrap mfscWrap">
                    <a-form-item name="hn_begin_time_range" label="夜间时段">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['hn_begin_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                    <span>-</span>
                    <a-form-item name="hn_end_time_range" label="">
                      <yt-custom-time-picker
                        data-event
                        class="dateWrap"
                        popupKey='"popupKey" "popupKeyId"_'
                        v-model:value="formState['hn_end_time_range']"
                        :placeholder="'请输入'"
                        :showNow="false"
                        :disabled="isDetail == 'detail'"
                      >
                      </yt-custom-time-picker>
                    </a-form-item>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_temporary_car_first_ceil"
                      label="临时车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hn_temporary_car_first_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_temporary_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hn_temporary_car_first_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hn_temporary_car_first_tier"
                      label=" 分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="formState['hn_temporary_car_first_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_stored_value_car_first_ceil"
                      label="储值车-第一阶梯第"
                      class="jtText"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_first_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_stored_value_car_first_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_first_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_stored_value_car_first_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[{ required: true, message: '请输入' }]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_first_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_temporary_car_second_ceil"
                      label="临时车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_temporary_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_temporary_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_temporary_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_temporary_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_temporary_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                        :disabled="isDetail == 'detail'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_stored_value_car_second_ceil"
                      label="储值车-第二阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_second_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_stored_value_car_second_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_second_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_stored_value_car_second_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        v-model:value="
                          formState['hn_stored_value_car_second_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :disabled="isDetail == 'detail'"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_temporary_car_third_ceil"
                      label="临时车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hn_temporary_car_third_ceil']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_temporary_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hn_temporary_car_third_time']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <a-form-item
                      name="hn_temporary_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="formState['hn_temporary_car_third_tier']"
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
                <a-col :span="12">
                  <div class="jtWrap">
                    <a-form-item
                      name="hn_stored_value_car_third_ceil"
                      label="储值车-第三阶梯第"
                      class="jtText"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hn_stored_value_car_third_ceil']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hn_stored_value_car_third_time"
                      label="分钟内,每"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hn_stored_value_car_third_time']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>

                    <a-form-item
                      name="hn_stored_value_car_third_tier"
                      label="分钟收费"
                      class="fzWrap"
                      :rules="[]"
                    >
                      <a-input-number
                        data-event
                        :disabled="isDetail == 'detail'"
                        v-model:value="
                          formState['hn_stored_value_car_third_tier']
                        "
                        :maxLength="100"
                        :min="1"
                        :placeholder="'请输入'"
                      >
                      </a-input-number>
                    </a-form-item>
                    <span class="yuan">元</span>
                  </div>
                </a-col>
              </a-row>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="hn_temporary_car_cap_amount"
                    label="临时车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="formState['hn_temporary_car_cap_amount']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="hn_stored_value_car_cap_amount"
                    label="储值车-封顶金额"
                    class="jtText"
                    :rules="[]"
                  >
                    <a-input-number
                      data-event
                      :disabled="isDetail == 'detail'"
                      v-model:value="
                        formState['hn_stored_value_car_cap_amount']
                      "
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
            <div v-if="formState['billing_standard'] == '按次收费'">
              <span class="spanLable"> 方案配置-收费金额</span>
              <a-row :gutter="24">
                <a-col :span="12">
                  <a-form-item
                    name="temporary_car"
                    label="临时车"
                    :rules="[{ required: true, message: '请输入' }]"
                  >
                    <a-input-number
                      data-event
                      v-model:value="formState['temporary_car']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
                <a-col :span="12">
                  <a-form-item
                    name="stored_value_car"
                    label="储值车"
                    :rules="[{ required: true, message: '请输入' }]"
                  >
                    <a-input-number
                      data-event
                      v-model:value="formState['stored_value_car']"
                      :maxLength="100"
                      :min="1"
                      :placeholder="'请输入'"
                      :disabled="isDetail == 'detail'"
                    >
                    </a-input-number>
                  </a-form-item>
                </a-col>
              </a-row>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>
    <!-- 计费详情 -->
    <yt-grid-item
      :isShow="billingDetailShow"
      fixedSize="selfAdaption"
      rotate="0"
      top="0.30000%"
      left="0.50000%"
      bottom="0.30000%"
      right="0.50000%"
      gridColumnStart="10"
      gridColumnEnd="86"
      gridRowStart="13"
      gridRowEnd="89"
      zIndex="12"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref48"
        @cancel="
          () => {
            billingDetailShow = false
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-jh175tv webVueAntYtModalStyle-jh webVueAntYtModalStyle billing_detail"
        v-model:isShow="billingDetailShow"
        :title="'计费详情'"
        :okText="''"
        :showFooter="false"
        :maskClosable="true"
      >
        <template #content>
          <a-tabs
            v-model:activeKey="activeKey"
            tab-position="left"
            :style="{ height: '100%' }"
          >
            <a-tab-pane v-for="i in tabList" :key="i" :tab="i"
              ><a-form
                ref="formRef"
                name="advanced_search"
                class="ant-advanced-search-form"
                :model="formState"
              >
                <div v-show="activeKey == '基本信息'">
                  <div>
                    <span class="spanLable">基本信息</span>
                    <a-row :gutter="24">
                      <a-col :span="8">
                        <a-form-item name="rule_number" label="规则编号">
                          <a-input
                            v-model:value="formState[`rule_number`]"
                            placeholder="请输入"
                            :disabled="isDetail == 'detail'"
                          ></a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="8">
                        <a-form-item
                          name="rule_name"
                          label="规则名称"
                          :rules="[{ required: true, message: '请输入' }]"
                        >
                          <a-input
                            v-model:value="formState[`rule_name`]"
                            placeholder="请输入"
                            :disabled="isDetail == 'detail'"
                          ></a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="8">
                        <a-form-item
                          name="billing_standard"
                          label="收费方案"
                          :rules="[{ required: true, message: '' }]"
                        >
                          <a-select
                            :showArrow="true"
                            :disabled="isDetail == 'detail'"
                            v-model:value="formState['billing_standard']"
                            :placeholder="'请输入'"
                            :options="chargingstandardoptions1.dataSource"
                            :showSearch="true"
                          >
                          </a-select>
                        </a-form-item>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="24">
                        <a-form-item name="rule_description" label="规则描述">
                          <a-input
                            data-event
                            v-model:value="formState['rule_description']"
                            :maxLength="100"
                            :placeholder="'请输入'"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div>
                    <span class="spanLable">关联车场</span>
                    <yt-table
                      ref="ref6781"
                      class="webVueAntYtTable webVueAntYtTableStyle-jhryqub webVueAntYtTableStyle-jh webVueAntYtTableStyle"
                      :selectType="'checkbox'"
                      :canSelect="false"
                      v-model:total="relateCarTotal"
                      v-model:current="relateCarCurrent"
                      v-model:pageSize="relateCarpageSize"
                      :columns="relateCar.columns"
                      :showQuickJumper="true"
                      :dataSource="relateCar.dataSource"
                      @onTableChange="
                        (pagination) => {
                          changeRelateCar(pagination, record)
                        }
                      "
                      :scroll="{ y: 240 }"
                    >
                      <template #cell="{ column, record, index }">
                        <template v-if="column.key == 'serialNumber'">
                          <span>{{ index + 1 }}</span>
                        </template>
                      </template>
                    </yt-table>
                  </div>
                </div>
                <div v-show="activeKey == '收费方案'">
                  <div>
                    <span class="spanLable">收费方案</span>
                    <a-row :gutter="24">
                      <a-col :span="8">
                        <a-form-item
                          name="billing_standard"
                          label="收费方案"
                          :rules="[{ required: true, message: '' }]"
                        >
                          <a-select
                            :showArrow="true"
                            :disabled="isDetail == 'detail'"
                            v-model:value="formState['billing_standard']"
                            :placeholder="'请输入'"
                            :options="chargingstandardoptions1.dataSource"
                            :showSearch="true"
                          >
                          </a-select>
                        </a-form-item>
                      </a-col>
                      <a-col
                        :span="12"
                        v-if="
                          formState['billing_standard'] ==
                          '节假日/工作日不同费用'
                        "
                      >
                        <a-form-item name="segment_charging" label="分段收费">
                          <a-radio-group
                            data-event
                            v-model:value="formState['segment_charging']"
                            :disabled="isDetail == 'detail'"
                            :options="[
                              {
                                label: '开启',
                                value: '开启',
                              },
                              {
                                label: '关闭',
                                value: '关闭',
                              },
                            ]"
                          >
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div
                    v-if="
                      formState['billing_standard'] == '节假日/工作日不同费用'
                    "
                  >
                    <span class="spanLable">节假日时间</span>
                    <yt-table
                      ref="ref6781"
                      class="webVueAntYtTable webVueAntYtTableStyle-jhryqub webVueAntYtTableStyle-jh webVueAntYtTableStyle"
                      :selectType="'checkbox'"
                      :canSelect="false"
                      v-model:selectedRows="HolidayScheduleselectedRows6"
                      v-model:total="HolidayScheduletotal6"
                      v-model:current="HolidaySchedulecurrent6"
                      v-model:pageSize="HolidaySchedulepageSize6"
                      :columns="HolidayScheduledata6.columns"
                      :showQuickJumper="true"
                      :dataSource="HolidayScheduledata6.dataSource"
                      
                    >
                      <template #cell="{ column, record, index }">
                        <template v-if="column.key == 'serialNumber'">
                          <span>{{ index + 1 }}</span>
                        </template>
                      </template>
                    </yt-table>
                  </div>
                  <div v-if="formState['billing_standard'] != '免费停车'">
                    <span class="spanLable">方案配置-免费时长</span>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="free_duration"
                          label="免费时长"
                          class="minute"
                        >
                          <a-input
                            data-event
                            v-model:value="formState[`free_duration`]"
                            placeholder="请输入"
                            :maxLength="100"
                            :disabled="isDetail == 'detail'"
                          ></a-input>
                          <span>分钟</span>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="new_energy_free_duration_reduction"
                          label="新能源免费时长"
                        >
                          <a-radio-group
                            data-event
                            v-model:value="
                              formState['new_energy_free_duration_reduction']
                            "
                            :options="radioOption"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="free_duration_reduction"
                          label="免费时长减免"
                        >
                          <a-radio-group
                            data-event
                            v-model:value="formState['free_duration_reduction']"
                            :options="radioOption"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="new_energy_free_duration"
                          label="新能源免费时长"
                          class="minute"
                        >
                          <a-input
                            data-event
                            v-model:value="
                              formState['new_energy_free_duration']
                            "
                            placeholder="请输入"
                            :maxLength="100"
                            :disabled="isDetail == 'detail'"
                          ></a-input>
                          <span>分钟</span>
                        </a-form-item>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="white_plate_car_free"
                          label="白牌车免费"
                        >
                          <a-radio-group
                            data-event
                            v-model:value="formState['white_plate_car_free']"
                            :options="radioOption"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="new_energy_free_times"
                          label="新能源免费次数"
                        >
                          <a-select
                            data-event
                            :showArrow="true"
                            v-model:value="formState['new_energy_free_times']"
                            :placeholder="'请输入'"
                            :disabled="isDetail == 'detail'"
                            :mode="'single'"
                            :options="[
                              {
                                label: '当日一次',
                                value: 1,
                              },
                              {
                                label: '不限次数',
                                value: -1,
                              },
                            ]"
                            :showSearch="true"
                          >
                          </a-select>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div v-if="formState['billing_standard'] != '免费停车'">
                    <span class="spanLable">方案配置-免费时段</span>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-space
                          v-for="(time, index) in formState['timeRange']"
                          :key="time.id"
                          style="display: flex; margin-bottom: 8px"
                          align="baseline"
                        >
                          <a-form-item
                            :name="['timeRange', index, 'free_begin_time']"
                            label="免费时段"
                          >
                            <yt-custom-time-picker
                              class="dateWrap"
                              v-model:value="time['free_begin_time']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                          <span>-</span>
                          <a-form-item
                            :name="['timeRange', index, 'free_end_time']"
                          >
                            <yt-custom-time-picker
                              class="dateWrap"
                              v-model:value="time['free_end_time']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                        </a-space>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="free_period_reduction"
                          label="免费时段减免"
                        >
                          <a-radio-group
                            data-event
                            v-model:value="formState['free_period_reduction']"
                            :options="radioOption"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>

                  <div
                    v-if="
                      formState['billing_standard'] ==
                        '节假日/工作日不同费用' ||
                      formState['billing_standard'] == '分段收费' ||
                      formState['billing_standard'] == '自然天收费'
                    "
                  >
                    <span class="spanLable"
                      >{{
                        formState['billing_standard'] == '自然天收费'
                          ? '方案配置-收费金额'
                          : formState['billing_standard'] == '分段收费'
                          ? '方案配置-日间收费'
                          : formState['billing_standard'] ==
                              '节假日/工作日不同费用' &&
                            formState['segment_charging'] == '开启'
                          ? '方案配置-工作日收费-日间收费'
                          : '方案配置-工作日收费'
                      }}
                    </span>
                    <a-row
                      :gutter="24"
                      v-if="
                        formState['billing_standard'] == '分段收费' ||
                        (formState['billing_standard'] ==
                          '节假日/工作日不同费用' &&
                          formState['segment_charging'] == '开启')
                      "
                    >
                      <a-col :span="12">
                        <div class="rjsdWrap mfscWrap">
                          <a-form-item
                            name="wd_begin_time_range"
                            label="日间时段"
                          >
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['wd_begin_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                          <span>-</span>
                          <a-form-item name="wd_end_time_range" label="">
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['wd_end_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_temporary_car_first_ceil"
                            label="临时车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_temporary_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wd_temporary_car_first_tier"
                            label=" 分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_stored_value_car_first_ceil"
                            label="储值车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_stored_value_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_stored_value_car_first_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_temporary_car_second_ceil"
                            label="临时车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_second_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_temporary_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_second_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_temporary_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_temporary_car_second_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_stored_value_car_second_ceil"
                            label="储值车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_second_ceil']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_stored_value_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_second_time']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_stored_value_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wd_stored_value_car_second_tier']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_temporary_car_third_ceil"
                            label="临时车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_temporary_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_temporary_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_temporary_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wd_temporary_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_temporary_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wd_stored_value_car_third_ceil"
                            label="储值车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_stored_value_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wd_stored_value_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_stored_value_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wd_stored_value_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wd_stored_value_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="wd_temporary_car_cap_amount"
                          label="临时车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['wd_temporary_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="wd_stored_value_car_cap_amount"
                          label="储值车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['wd_stored_value_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div
                    v-if="
                      (formState['billing_standard'] ==
                        '节假日/工作日不同费用' &&
                        formState['segment_charging'] == '开启') ||
                      formState['billing_standard'] == '分段收费'
                    "
                  >
                    <span class="spanLable">
                      {{
                        formState['billing_standard'] == '分段收费'
                          ? '方案配置-夜间收费'
                          : '方案配置-工作日收费-夜间收费'
                      }}
                    </span>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="rjsdWrap mfscWrap">
                          <a-form-item
                            name="wn_begin_time_range"
                            label="夜间时段"
                          >
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['wn_begin_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                          <span>-</span>
                          <a-form-item name="wn_end_time_range" label="">
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['wn_end_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_temporary_car_first_ceil"
                            label="临时车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_temporary_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wn_temporary_car_first_tier"
                            label=" 分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_stored_value_car_first_ceil"
                            label="储值车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_stored_value_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_stored_value_car_first_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_temporary_car_second_ceil"
                            label="临时车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_second_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_temporary_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_second_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_temporary_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_temporary_car_second_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_stored_value_car_second_ceil"
                            label="储值车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_second_ceil']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_stored_value_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_second_time']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_stored_value_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['wn_stored_value_car_second_tier']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_temporary_car_third_ceil"
                            label="临时车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_temporary_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_temporary_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_temporary_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="wn_temporary_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_temporary_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="wn_stored_value_car_third_ceil"
                            label="储值车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_stored_value_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wn_stored_value_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_stored_value_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="wn_stored_value_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['wn_stored_value_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="wn_temporary_car_cap_amount"
                          label="临时车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['wn_temporary_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="wn_stored_value_car_cap_amount"
                          label="储值车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['wn_stored_value_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div
                    v-if="
                      formState['billing_standard'] == '节假日/工作日不同费用'
                    "
                  >
                    <span class="spanLable">
                      {{
                        formState['billing_standard'] ==
                          '节假日/工作日不同费用' &&
                        formState['segment_charging'] == '开启'
                          ? '方案配置-节假日收费-日间收费'
                          : '方案配置-节假日收费'
                      }}
                    </span>
                    <a-row
                      :gutter="24"
                      v-if="
                        formState['billing_standard'] ==
                          '节假日/工作日不同费用' &&
                        formState['segment_charging'] == '开启'
                      "
                    >
                      <a-col :span="12">
                        <div class="rjsdWrap mfscWrap">
                          <a-form-item
                            name="hd_begin_time_range"
                            label="日间时段"
                          >
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['hd_begin_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                          <span>-</span>
                          <a-form-item name="hd_end_time_range" label="">
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['hd_end_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_temporary_car_first_ceil"
                            label="临时车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_temporary_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hd_temporary_car_first_tier"
                            label=" 分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_stored_value_car_first_ceil"
                            label="储值车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_stored_value_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_stored_value_car_first_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_temporary_car_second_ceil"
                            label="临时车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_second_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_temporary_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_second_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_temporary_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_temporary_car_second_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_stored_value_car_second_ceil"
                            label="储值车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_second_ceil']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_stored_value_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_second_time']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_stored_value_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hd_stored_value_car_second_tier']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_temporary_car_third_ceil"
                            label="临时车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_temporary_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_temporary_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_temporary_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hd_temporary_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_temporary_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hd_stored_value_car_third_ceil"
                            label="储值车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_stored_value_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hd_stored_value_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_stored_value_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hd_stored_value_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hd_stored_value_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="hd_temporary_car_cap_amount"
                          label="临时车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['hd_temporary_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="hd_stored_value_car_cap_amount"
                          label="储值车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['hd_stored_value_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div
                    v-if="
                      formState['billing_standard'] ==
                        '节假日/工作日不同费用' &&
                      formState['segment_charging'] == '开启'
                    "
                  >
                    <span class="spanLable"> 方案配置-节假日收费-夜间收费</span>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="rjsdWrap mfscWrap">
                          <a-form-item
                            name="hn_begin_time_range"
                            label="夜间时段"
                          >
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['hn_begin_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                          <span>-</span>
                          <a-form-item name="hn_end_time_range" label="">
                            <yt-custom-time-picker
                              data-event
                              class="dateWrap"
                              popupKey='"popupKey" "popupKeyId"_'
                              v-model:value="formState['hn_end_time_range']"
                              :placeholder="'请输入'"
                              :showNow="false"
                              :disabled="isDetail == 'detail'"
                            >
                            </yt-custom-time-picker>
                          </a-form-item>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_temporary_car_first_ceil"
                            label="临时车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_temporary_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hn_temporary_car_first_tier"
                            label=" 分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_stored_value_car_first_ceil"
                            label="储值车-第一阶梯第"
                            class="jtText"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_first_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_stored_value_car_first_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_first_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_stored_value_car_first_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[{ required: true, message: '请输入' }]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_first_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_temporary_car_second_ceil"
                            label="临时车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_second_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_temporary_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_second_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_temporary_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_temporary_car_second_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                              :disabled="isDetail == 'detail'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_stored_value_car_second_ceil"
                            label="储值车-第二阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_second_ceil']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_stored_value_car_second_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_second_time']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_stored_value_car_second_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              v-model:value="
                                formState['hn_stored_value_car_second_tier']
                              "
                              :maxLength="100"
                              :disabled="isDetail == 'detail'"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_temporary_car_third_ceil"
                            label="临时车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_temporary_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_temporary_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_temporary_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <a-form-item
                            name="hn_temporary_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_temporary_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                      <a-col :span="12">
                        <div class="jtWrap">
                          <a-form-item
                            name="hn_stored_value_car_third_ceil"
                            label="储值车-第三阶梯第"
                            class="jtText"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_stored_value_car_third_ceil']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hn_stored_value_car_third_time"
                            label="分钟内,每"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_stored_value_car_third_time']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>

                          <a-form-item
                            name="hn_stored_value_car_third_tier"
                            label="分钟收费"
                            class="fzWrap"
                            :rules="[]"
                          >
                            <a-input
                              data-event
                              :disabled="isDetail == 'detail'"
                              v-model:value="
                                formState['hn_stored_value_car_third_tier']
                              "
                              :maxLength="100"
                              :placeholder="'请输入'"
                            >
                            </a-input>
                          </a-form-item>
                          <span class="yuan">元</span>
                        </div>
                      </a-col>
                    </a-row>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="hn_temporary_car_cap_amount"
                          label="临时车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['hn_temporary_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="hn_stored_value_car_cap_amount"
                          label="储值车-封顶金额"
                          class="jtText"
                          :rules="[]"
                        >
                          <a-input
                            data-event
                            :disabled="isDetail == 'detail'"
                            v-model:value="
                              formState['hn_stored_value_car_cap_amount']
                            "
                            :maxLength="100"
                            :placeholder="'请输入'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                  <div v-if="formState['billing_standard'] == '按次收费'">
                    <span class="spanLable"> 方案配置-收费金额</span>
                    <a-row :gutter="24">
                      <a-col :span="12">
                        <a-form-item
                          name="temporary_car"
                          label="临时车"
                          :rules="[{ required: true, message: '请输入' }]"
                        >
                          <a-input
                            data-event
                            v-model:value="formState['temporary_car']"
                            :maxLength="100"
                            :placeholder="'请输入'"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                      <a-col :span="12">
                        <a-form-item
                          name="stored_value_car"
                          label="储值车"
                          :rules="[{ required: true, message: '请输入' }]"
                        >
                          <a-input
                            data-event
                            v-model:value="formState['stored_value_car']"
                            :maxLength="100"
                            :placeholder="'请输入'"
                            :disabled="isDetail == 'detail'"
                          >
                          </a-input>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                </div>
                <div v-show="activeKey == '操作记录'">
                  <span class="spanLable">操作记录</span>
                  <yt-table
                    ref="ref6781"
                    class="webVueAntYtTable webVueAntYtTableStyle-jhryqub webVueAntYtTableStyle-jh webVueAntYtTableStyle"
                    :selectType="'checkbox'"
                    :canSelect="false"
                    v-model:total="operateRecordTotal"
                    v-model:current="operateRecordCurrent"
                    v-model:pageSize="operateRecordpageSize"
                    :columns="operateRecord.columns"
                    :showQuickJumper="true"
                    :dataSource="operateRecord.dataSource"
                    @onTableChange="
                      (pagination) => {
                        changeOperateRecord(pagination, record)
                      }
                    "
                    :scroll="{ y: 540 }"
                  >
                    <template #cell="{ column, record, index }">
                      <template v-if="column.key == 'serialNumber'">
                        <span>{{ index + 1 }}</span>
                      </template>
                    </template>
                  </yt-table>
                </div>
              </a-form>
            </a-tab-pane>
          </a-tabs>
        </template>
      </yt-custom-modal>
    </yt-grid-item>
  </yt-grid>
</template>

<script>
import { loadCss } from '../shared/loadTheme'
import axios from 'axios'
import { message, Modal } from 'ant-design-vue'
import { MinusCircleOutlined, UploadOutlined } from '@ant-design/icons-vue'
import { h } from 'vue'
export default {
  components: { MinusCircleOutlined, UploadOutlined },
  data() {
    return {
      // 新增/编辑表单
      formState: {
        // 免费时段
        timeRange: [
          {
            free_begin_time: '',
            free_end_time: '',
          },
        ],
      },
      // 详情弹窗激活的面板
      activeKey: '基本信息',
      // 详情弹窗面板
      tabList: ['基本信息', '收费方案', '操作记录'],
      // 列表搜索
      RuleNamevalue1: '',
      chargingstandardvalue1: '',
      chargingstandardoptions1: {
        dataSource: [
          {
            label: '免费停车',
            value: '免费停车',
          },
          {
            label: '按次收费',
            value: '按次收费',
          },
          {
            value: '自然天收费',
            label: '自然天收费',
          },
          {
            value: '分段收费',
            label: '分段收费',
          },
          {
            value: '节假日/工作日不同费用',
            label: '节假日/工作日不同费用',
          },
        ],
        value: [],
      },
      Creatorvalue1: '',
      Creationtimevalue1: [],
      // 表格数据
      BillingManagementListdata1: {
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
            key: 'ruleNumber',
            title: '规则编号',
            dataIndex: 'ruleNumber',
          },
          {
            key: 'ruleName',
            title: '规则名称',
            dataIndex: 'ruleName',
          },
          {
            key: 'chargingstandard',
            title: '收费方案',
            dataIndex: 'chargingstandard',
          },
          {
            key: 'ruleDescription',
            title: '规则描述',
            dataIndex: 'ruleDescription',
          },
          {
            key: 'numberofassociateddepots',
            title: '关联车场数',
            dataIndex: 'numberofassociateddepots',
          },
          {
            key: 'creationtime',
            title: '创建时间',
            dataIndex: 'creationtime',
          },
          {
            key: 'creator1',
            title: '创建人',
            dataIndex: 'creator1',
          },
          {
            key: 'operation1',
            title: '操作',
            dataIndex: 'operation1',
            cellType: 'slot',
          },
        ],
        dataSource: [],
      },
      BillingManagementListcurrent2: 1,
      BillingManagementListtotal1: 2,
      BillingManagementListselectedRows1: [],
      BillingManagementListpageSize1: 10,
      // 新增/编辑计费弹窗
      IncreasebillingisShow1: false,
      // 节假日时间
      HolidayScheduleselectedRows6: [],
      HolidaySchedulepageSize6: 5,
      HolidayScheduledata6: {
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
            width: 120,
            cellType: 'slot',
          },
          {
            key: 'holiday_start_date',
            title: '开始日期',
            dataIndex: 'holiday_start_date',
          },
          {
            key: 'holiday_end_date',
            title: '结束日期',
            dataIndex: 'holiday_end_date',
          },
          {
            key: 'holiday_remarks',
            title: '备注',
            dataIndex: 'holiday_remarks',
          },
          {
            key: 'operation',
            title: '操作',
            dataIndex: 'operation',
            width: 120,
            cellType: 'slot',
          },
        ],
        dataSource: [],
      },
      HolidaySchedulecurrent6: 1,
      HolidayScheduletotal6: 5,
      // 关联车场
      relateCarpageSize: 10,
      relateCar: {
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
            width: 120,
            cellType: 'slot',
          },
          {
            key: 'parking_lot_code',
            title: '车场编号',
            dataIndex: 'parking_lot_code',
          },
          {
            key: 'parking_lot_name',
            title: '车场名称',
            dataIndex: 'parking_lot_name',
          },
          {
            key: 'relation_time',
            title: '关联时间',
            dataIndex: 'relation_time',
          },
          {
            key: 'enable_status',
            title: '关联状态',
            dataIndex: 'enable_status',
          },
          {
            key: 'relation_username',
            title: '关联人',
            dataIndex: 'relation_username',
          },
        ],
        dataSource: [],
      },
      relateCarCurrent: 1,
      relateCarTotal: 5,
      // 操作记录
      operateRecordpageSize: 10,
      operateRecord: {
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
            width: 60,
            cellType: 'slot',
          },
          {
            key: 'operation_time',
            title: '操作时间',
            dataIndex: 'operation_time',
            width: 160,
          },
          {
            key: 'operation_node',
            title: '操作节点',
            width: 100,
            dataIndex: 'operation_node',
          },
          {
            key: 'operation_content',
            title: '操作内容',
            dataIndex: 'operation_content',
          },
          {
            key: 'operator',
            title: '操作人员',
            width: 100,
            dataIndex: 'operator',
          },
        ],
        dataSource: [],
      },
      operateRecordCurrent: 1,
      operateRecordTotal: 5,
      // 开关
      radioOption: [
        {
          label: '开',
          value: '开',
          disabled: false,
          select: true,
        },
        {
          label: '关',
          value: '关',
          disabled: false,
          select: false,
        },
      ],
      // 是否是详情
      isDetail: '',
      // 节假日时间新增
      clickAdd: false,
      // 文件上传状态
      uploadStatus: false,
      // 计费详情
      billingDetailShow: false,
      editID: '',
      detailObj: {},
    }
  },
  watch: {},
  methods: {
    // 接口请求前缀
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params)
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios
          .post('./Billingmanagement/' + funcName, params, {
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
    // 获取列表数据
    async queryBillingManagementList(current) {
      try {
        const response = await this.executeBackendInterface(
          'searchBillingManagementList',
          {
            RuleNamevalue1: this.RuleNamevalue1,
            chargingstandardvalue1: this.chargingstandardvalue1
              ? [this.chargingstandardvalue1]
              : [],
            Creatorvalue1: this.Creatorvalue1,
            Creationtimevalue1: this.Creationtimevalue1,
            current: current ? current : this.BillingManagementListcurrent2,
            pageSize: this.BillingManagementListpageSize1,
          }
        )
        if (response.flag) {
          this.BillingManagementListdata1.dataSource = response.data.data.map(
            (item, index) => ({
              id: item.id,
              ruleNumber: item.rule_number,
              ruleName: item.rule_name,
              ruleDescription: item.rule_description,
              creationtime: item.create_time,
              creator1: item.create_username,
              chargingstandard: item.billing_standard,
              numberofassociateddepots: item.associated_parking_count,
              serialNumber: index + 1,
            })
          )
          this.BillingManagementListtotal1 = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        console.log(error, 'error')
        message.error('查询失败，请重试')
      }
    },
    // 列表分页切换
    async changeBillingManagementListPage(pagination) {
      this.BillingManagementListcurrent2 = pagination.current
      this.BillingManagementListpageSize1 = pagination.pageSize
      await this.queryBillingManagementList()
    },
    // 列表删除
    async deleteRecord(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认删除',
        content: '确定要删除这条记录吗？',
        onOk: async () => {
          try {
            // 调用后端接口删除记录
            const response = await this.executeBackendInterface(
              'deleteRecord',
              {
                id: record.id,
                current: this.BillingManagementListcurrent2,
                pageSize: this.BillingManagementListpageSize1,
              }
            )
            // 检查删除操作是否成功
            if (response.flag) {
              message.success('删除成功')
              this.queryBillingManagementList()
            } else {
              message.error('删除失败')
            }
          } catch (error) {
            message.error('操作失败')
          }
        },
        onCancel: () => {
          // 取消删除操作
        },
      })
    },
    // 获取详情
    async editBillingDetails(record) {
      try {
        const response = await this.executeBackendInterface('getRuleInfo', {
          id: record.id,
        })
        if (response.flag) {
          this.formState = { ...response.data }
          this.detailObj = { ...response.data }
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('加载计费详情失败')
      }
    },
    // 获取节假日时间
    async getHolidaysList(record) {
      try {
        const response = await this.executeBackendInterface(
          'getHolidaysList ',
          {
            billing_rule_id: record.id,
          }
        )
        if (response.flag) {
          this.HolidayScheduledata6.dataSource = response.data.data || undefined
          this.HolidayScheduletotal6 = response.data.total
          if (this.isDetail == 'detail')
            this.HolidayScheduledata6.columns = [
              {
                key: 'id',
                title: 'id',
                dataIndex: 'id',
              },
              {
                key: 'serialNumber',
                title: '序号',
                dataIndex: 'serialNumber',
                width: 120,
                cellType: 'slot',
              },
              {
                key: 'holiday_start_date',
                title: '开始日期',
                dataIndex: 'holiday_start_date',
              },
              {
                key: 'holiday_end_date',
                title: '结束日期',
                dataIndex: 'holiday_end_date',
              },
              {
                key: 'holiday_remarks',
                title: '备注',
                dataIndex: 'holiday_remarks',
              },
            ]
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('加载节假日时间失败')
      }
    },
    // 获取免费时段
    async getFreeTimeRange(record) {
      try {
        const response = await this.executeBackendInterface(
          'getFreeTimeRange',
          {
            billing_rule_id: record.id,
          }
        )
        if (response.flag) {
          if (response.data.data.length) {
            this.formState.timeRange = response.data.data
          } else {
            this.formState.timeRange = [
              {
                free_begin_time: '',
                free_end_time: '',
              },
            ]
          }
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('加载免费时段失败')
      }
    },
    // 获取关联车场
    async getRelateCarList(record) {
      try {
        const response = await this.executeBackendInterface(
          'getYardListByRule ',
          {
            billing_rule_id: record.id,
            current: this.relateCarCurrent,
            pageSize: this.relateCarpageSize,
          }
        )
        if (response.flag) {
          this.relateCar.dataSource = response.data.data || []
          this.relateCarTotal = response.data.toatl
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('加载关联车场失败')
      }
    },
    // 关联车场分页
    changeRelateCar(pagination, record) {
      this.relateCarCurrent = pagination.current
      this.relateCarpageSize = pagination.pageSize
      this.getRelateCarList(record)
    },
    // 获取操作记录
    async getOperationRecords(record) {
      try {
        const response = await this.executeBackendInterface(
          'getOperationRecords ',
          {
            billing_rule_id: record.id,
            current: this.operateRecordCurrent,
            pageSize: this.operateRecordpageSize,
          }
        )
        if (response.flag) {
          this.operateRecord.dataSource = response.data.data || []
          this.operateRecordTotal = response.data.total
        } else {
          message.error(response.message)
        }
      } catch (error) {
        message.error('加载关联车场失败')
      }
    },
    // 操作记录分页
    changeOperateRecord(pagination, record) {
      this.operateRecordCurrent = pagination.current
      this.operateRecordpageSize = pagination.pageSize
      this.getOperationRecords(record)
    },
    // 列表行点击
    handleClickRow(record) {
      this.isDetail = 'detail'
      this.editBillingDetails(record)
      this.billingDetailShow = true
      this.editBillingDetails(record)
      this.editID = record.id
      this.getHolidaysList(record)
      this.getFreeTimeRange(record)
      this.getRelateCarList(record)
      this.getOperationRecords(record)
      this.activeKey = '基本信息'
    },
    // 编辑
    handleEdit(record) {
      this.isDetail = 'edit'
      this.clickAdd = false
      this.IncreasebillingisShow1 = true
      this.editBillingDetails(record)
      this.editID = record.id
      this.getHolidaysList(record)
      this.getFreeTimeRange(record)
      this.HolidayScheduleselectedRows6 = []
  
    },
    // 重置
    async resetBillingManagementList() {
      try {
        this.RuleNamevalue1 = ''
        this.chargingstandardvalue1 = ''
        this.Creatorvalue1 = ''
        this.Creationtimevalue1 = []
        this.BillingManagementListcurrent2 = 1
        this.queryBillingManagementList()
      } catch (error) {
        message.error('重置失败，请重试')
      } finally {
        this.Resetloading1 = false
      }
    },
    // 新建
    showAddBillingModal() {
      // 显示新增计费弹窗
      this.isDetail = 'add'
      this.clickAdd = false
      this.IncreasebillingisShow1 = true
      this.formState = {
        // 生成规则编号
        rule_number: `RULE-${Date.now()}`,
        timeRange: [
          {
            free_begin_time: '',
            free_end_time: '',
          },
        ],
      }
      this.HolidayScheduledata6.dataSource = []
      this.HolidayScheduleselectedRows6 = []
    },
    // 新增节假日
    async handleddHoliday() {
      try {
        const values = this.formState['holidayDate']
        if (!values) {
          return message.warning('请输入日期')
        }
        this.HolidayScheduledata6.dataSource.push({
          holiday_remarks: this.formState['holidayRemark'],
          holiday_end_date: values[1],
          holiday_start_date: values[0],
          id: Date.now(),
        })
        this.HolidayScheduletotal6 = this.HolidayScheduledata6.dataSource.length
        this.clickAdd = false
        this.formState['holidayDate'] = []
        this.formState['holidayRemark'] = ''
      } catch (errorInfo) {
        console.log('Failed:', errorInfo)
      }
    },
    // 删除节假日
    handleHolidayDelete(item) {
      console.log(this.HolidayScheduleselectedRows6.length,'45678')
      if (this.HolidayScheduleselectedRows6.length==0 && !item.id) {
        return message.warning('请选择要删除的数据')
      }
      // 弹出确认对话框
      Modal.confirm({
        title: '确认删除',
        content: '确定要删除这条记录吗？',
        onOk: async () => {
          if (item.id) {
            let index = this.HolidayScheduledata6.dataSource.indexOf(item)
            if (index !== -1) {
              this.HolidayScheduledata6.dataSource.splice(index, 1)
            }
          } else {
            this.HolidayScheduleselectedRows6.forEach((item) => {
              let index = this.HolidayScheduledata6.dataSource.indexOf(item)
              if (index !== -1) {
                this.HolidayScheduledata6.dataSource.splice(index, 1)
              }
            })
          }
          this.HolidayScheduletotal6 =
            this.HolidayScheduledata6.dataSource.length
            this.HolidayScheduleselectedRows6 = []
        },
        onCancel: () => {
          // 取消删除操作
        },
      })
    },
    // 导入节假日
    handleChangeYardIconfileList2({ file, flieList }) {
      try {
        this.uploadStatus = true

        if (file.status === 'done') {
          this.uploadStatus = false
          file.response.data.forEach((item, index) => {
            item.id = index + Date.now()
            this.HolidayScheduledata6.dataSource.push(item)
          })
        }
        this.HolidayScheduleselectedRows6 = []
        this.HolidayScheduletotal6 = this.HolidayScheduledata6.dataSource.length
      } catch (errorInfo) {
        this.uploadStatus = false
        console.log('Failed:', errorInfo)
      }
    },

    // 新增时段
    addTime() {
      this.formState.timeRange.push({
        free_begin_time: '',
        free_end_time: '',
        id: Date.now(),
      })
    },
    // 移除时段
    removeTime(item) {
      let index = this.formState.timeRange.indexOf(item)
      if (index !== -1) {
        this.formState.timeRange.splice(index, 1)
      }
    },
    // 新增/编辑计费
    async addBillingRule() {
      try {
        // 获取规则信息表单(ref=ref49)的值
        const ruleInfo = await this.$refs.formRef.validateFields()
        let free_Begin_Time = []
        let free_end_time = []
        let holiday_start_date = []
        let holiday_end_date = []
        let holiday_remarks = []
        if (ruleInfo.timeRange) {
          ruleInfo.timeRange.forEach((item) => {
            free_Begin_Time.push(item.free_begin_time)
            free_end_time.push(item.free_end_time)
            ruleInfo.free_end_time = free_end_time
            ruleInfo.free_Begin_Time = free_Begin_Time
          })
        }
        delete ruleInfo.timeRange
        if (this.HolidayScheduledata6.dataSource.length) {
          this.HolidayScheduledata6.dataSource.forEach((item) => {
            holiday_start_date.push(item.holiday_start_date)
            holiday_end_date.push(item.holiday_end_date)
            holiday_remarks.push(item.holiday_remarks)
            ruleInfo.holiday_start_date = holiday_start_date
            ruleInfo.holiday_end_date = holiday_end_date
            ruleInfo.holiday_remarks = holiday_remarks
          })
        }
        if (this.isDetail == 'edit') {
          ruleInfo.id = this.editID
        }
        // 调用后端接口新增计费规则
        const response = await this.executeBackendInterface(
          this.isDetail == 'edit' ? 'updateBillingRule' : 'saveBillingRule',
          ruleInfo
        )
        if (response.flag) {
          this.$refs.formRef.resetFields()
          this.queryBillingManagementList()
          this.IncreasebillingisShow1 = false
          this.HolidayScheduledata6.dataSource = []
          this.formState.timeRange = undefined
          message.success(response.message)
        } else {
          message.error(response.message)
        }
      } catch (error) {
        console.log('Failed:', error)
        message.error('校验失败，请检查输入内容')
      }
    },
    // 新增/编辑取消
    handleCancelAddEdit() {
      this.$refs.formRef.resetFields()
      this.IncreasebillingisShow1 = false
    },
    // 收费方案变化
    handleStandardChange(e) {
      this.formState = {
        rule_number: this.formState.rule_number,
        rule_name: this.formState.rule_name,
        billing_standard: e,
        segment_charging: '关闭',
        timeRange: [
          {
            free_begin_time: '',
            free_end_time: '',
          },
        ],
      }
    },
    handleRadioChange(e) {
      this.formState = {
        rule_number: this.formState.rule_number,
        rule_name: this.formState.rule_name,
        billing_standard: this.formState.billing_standard,
        segment_charging: e.target.value,
        timeRange: [
          {
            free_begin_time: '',
            free_end_time: '',
          },
        ],
      }
    },
  },
  mounted() {
    loadCss('./css/计费管理/theme.css')
    loadCss('./css/计费管理/index.css')
    this.queryBillingManagementList()
  },
  computed: {},
}
</script>
<style lang="less" scoped>
.yt-custom-modal :deep(.ant-modal-body) {
  padding: 20px;
  overflow: hidden;
  overflow-y: auto;
  :deep(.ant-form-item-label) > label {
    min-width: 110px;
    justify-content: flex-end;
  }
}
.customStyle {
  height: 32px !important;
}
.billing_detail {
  :deep(.ant-modal-body) {
    padding: 0 0 0;
  }
  :deep(.ant-tabs-content-holder) {
    padding: 20px 20px 20px 0;
    overflow: hidden;
    overflow-y: auto;
  }
}
.spanLable {
  display: block;
  border-left: solid 3px #1890ff;
  line-height: 1;
  text-indent: 10px;
  font-size: 14px;
  color: #3d3d3d;
  font-weight: bold;
  margin-bottom: 20px;
}
.addWrap {
  display: flex;
  align-items: center;
  :deep(.ant-form-item) {
    margin-bottom: 0;
  }
}
.jjrsj {
  margin-bottom: 20px;
  span {
    display: inline-block;
  }
}

.operateBtn {
  margin-right: 10px;
  border-radius: 4px;
  height: 28px;
  padding: 2px 12px;
}
:deep(.ant-input),
:deep(.ant-picker),
:deep(.ant-select:not(.ant-select-customize-input) .ant-select-selector) {
  border-radius: 4px;
}
.addBtn {
  color: #1890ff;
  cursor: pointer;
  display: inline-block;
  width: 30px;
}
.mfscWrap {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  span {
    margin: 0 5px;
  }
}
.rjsdWrap {
  margin-bottom: 24px;
  .ant-form-item {
    margin-bottom: 0;
  }
}
.jtWrap {
  display: flex;
  align-items: center;
  width: 100%;
  .yuan {
    margin-left: 6px;
    margin-bottom: 24px;
  }
  .fzWrap {
    :deep(.ant-form-item-label) > label {
      min-width: 82px;
      width: 82px !important;
      justify-content: flex-end;
    }
    :deep(.ant-form-item-label)
      > label.ant-form-item-required:not(
        .ant-form-item-required-mark-optional
      )::before {
      content: '';
    }
  }
}
.jtText {
  min-width: 40%;
  :deep(.ant-form-item-label) > label {
    width: 142px;
    justify-content: flex-end;
  }
}
:deep(.ant-input-number) {
  width: 100%;
  border-radius: 4px;
}
:deep(.ant-input[disabled]),
:deep(.ant-picker.ant-picker-disabled) {
  background: transparent;
  color: #000;
  .ant-picker-input > input[disabled] {
    color: #000;
  }
}
:deep(.ant-radio-disabled) + span {
  color: #000;
}
:deep(.ant-radio-disabled .ant-radio-inner) {
  background: transparent;
  color: #000;
}
:deep(
    .ant-select-disabled.ant-select:not(.ant-select-customize-input)
      .ant-select-selector
  ) {
  background: transparent;
  color: #000;
}
.minute {
  :deep(.ant-form-item-control-input-content) {
    display: flex;
    align-items: center;
    span {
      flex-shrink: 0;
      margin-left: 10px;
    }
  }
}
</style>
