<template>
  <yt-grid previewType="AdaptiveWH" width="1700" height="1016" background="#F0F2F5">
    <yt-grid-item
      fixedSize="width"
      comWidth="57.00px"
      top="19.10000%"
      left="4.40000%"
      bottom="15.20000%"
      right="11.70000%"
      gridColumnStart="2"
      gridColumnEnd="6"
      gridRowStart="2"
      gridRowEnd="5"
      zIndex="2"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref16"
        class="webVueAntYtSpan webVueAntYtSpanStyle-wnntevl webVueAntYtSpanStyle-wn webVueAntYtSpanStyle null-wn null"
      >
        <span v-html="'数据字典'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.20000%"
      left="0.40000%"
      bottom="0.60000%"
      right="0.70000%"
      gridColumnStart="2"
      gridColumnEnd="51"
      gridRowStart="5"
      gridRowEnd="99"
      zIndex="3"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref17"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-wnigpmx webVueAntYtRectangleStyle-wn webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="20.10000%"
      left="9.40000%"
      bottom="1.00000%"
      right="15.20000%"
      gridColumnStart="95"
      gridColumnEnd="100"
      gridRowStart="6"
      gridRowEnd="10"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref18"
        @click="
          () => {
            showAddCategoryModal();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-wn1107x webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
        :loading="AddCategoryloading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.50000%"
      left="1.80000%"
      bottom="0.00000%"
      right="1.50000%"
      gridColumnStart="52"
      gridColumnEnd="100"
      gridRowStart="11"
      gridRowEnd="96"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref20"
        class="webVueAntYtTable webVueAntYtTableStyle-wnynhr6 webVueAntYtTableStyle-wn webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="DictionaryDetailsselectedRows1"
        v-model:total="DictionaryDetailstotal1"
        v-model:current="DictionaryDetailscurrent2"
        v-model:pageSize="DictionaryDetailspageSize1"
        :columns="DictionaryDetailsdata1.columns"
        :showQuickJumper="true"
        :dataSource="DictionaryDetailsdata1.dataSource"
        :scroll="{ y: 747.0000382001598 }"
        @onTableChange="
          (pagination) => {
            handleRightTableChange(pagination);
          }
        "
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'operation1'" :forKey="'operation1'">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.00000%"
                left="2.00000%"
                bottom="0.50000%"
                right="2.30000%"
                gridColumnStart="11"
                gridColumnEnd="47"
                gridRowStart="14"
                gridRowEnd="84"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref21"
                  @click="
                    () => {
                      showEditDetailModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wnf9avg webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
                  :loading="Editloading1"
                >
                  <span class="yt-button-content" v-html="'编辑'"> </span>
                </a-button>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.00000%"
                left="2.30000%"
                bottom="0.50000%"
                right="2.00000%"
                gridColumnStart="55"
                gridColumnEnd="91"
                gridRowStart="14"
                gridRowEnd="84"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref22"
                  @click="
                    () => {
                      handleDeleteDictionaryDetail(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wnm91bi webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
                  :loading="Deleteloading2"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </yt-grid-item>
            </yt-grid>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.50000%"
      left="1.90000%"
      bottom="0.00000%"
      right="0.20000%"
      gridColumnStart="2"
      gridColumnEnd="50"
      gridRowStart="11"
      gridRowEnd="96"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref28"
        @onTableChange="
          (pagination) => {
            handleLeftTableChange(pagination);
          }
        "
        @onRowClick="handleRowClick"
        class="webVueAntYtTable webVueAntYtTableStyle-wnxmuk5 webVueAntYtTableStyle-wn webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="BusinessDictionaryselectedRows1"
        v-model:total="BusinessDictionarytotal1"
        v-model:current="BusinessDictionarycurrent2"
        v-model:pageSize="BusinessDictionarypageSize1"
        :columns="BusinessDictionarydata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="BusinessDictionarydata1.dataSource"
        :scroll="{ y: 746.9999578285365 }"
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'operation'" :forKey="'operation'">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.30000%"
                left="2.00000%"
                bottom="0.30000%"
                right="2.30000%"
                gridColumnStart="11"
                gridColumnEnd="47"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref29"
                  @click="
                    () => {
                      showEditModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wnccs86 webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
                  :loading="Editloading2"
                >
                  <span class="yt-button-content" v-html="'编辑'"> </span>
                </a-button>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.30000%"
                left="2.50000%"
                bottom="0.30000%"
                right="1.80000%"
                gridColumnStart="56"
                gridColumnEnd="92"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref30"
                  @click="
                    () => {
                      handleDeleteBusinessDictionary(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-wn4a1m3 webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
                  :loading="Deleteloading1"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </yt-grid-item>
            </yt-grid>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="20.10000%"
      left="2.90000%"
      bottom="1.00000%"
      right="2.90000%"
      gridColumnStart="46"
      gridColumnEnd="50"
      gridRowStart="6"
      gridRowEnd="10"
      zIndex="7"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref32"
        @click="
          () => {
            showAddDictionaryModal();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-wnhoy02 webVueAntYtButtonStyle-wn webVueAntYtButtonStyle center-wn center"
        :loading="NewDictionaryloading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="20.10000%"
      left="0.50000%"
      bottom="1.00000%"
      right="5.20000%"
      gridColumnStart="36"
      gridColumnEnd="46"
      gridRowStart="6"
      gridRowEnd="10"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref33"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-wnr80bu webVueAntYtInputFormItem-wn webVueAntYtInputFormItem hide-label-wn hide-label"
        name="SearchBoxvalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'标题：'"> </span>
          </div>
        </template>
        <a-input
          @pressEnter="
            () => {
              BusinessDictionarycurrent2 = 1;
              handleSearchChange();
            }
          "
          class="webVueAntinput webVueAntYtInputStyle-wnyy175 webVueAntYtInputStyle-wn webVueAntYtInputStyle"
          v-model:value="SearchBoxvalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入名称或键值'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="6.60000%"
      left="29.40000%"
      bottom="21.10000%"
      right="27.40000%"
      gridColumnStart="43"
      gridColumnEnd="46"
      gridRowStart="7"
      gridRowEnd="10"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref34"
        class="webVueAntYtIcon webVueAntYtPictureStyle-wn1dry7 webVueAntYtPictureStyle-wn webVueAntYtPictureStyle"
      >
        <img
          :src="'./staticResource/wzc/1845284868271898624/0/QBwVIgdJCk-xCCiod886r.png'"
          class="yt-static-wn yt-static"
        />
      </div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="75.00px"
      top="9.90000%"
      left="14.70000%"
      bottom="24.40000%"
      right="11.70000%"
      gridColumnStart="2"
      gridColumnEnd="8"
      gridRowStart="7"
      gridRowEnd="10"
      zIndex="10"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref35"
        class="webVueAntYtSpan webVueAntYtSpanStyle-wnyvlgy webVueAntYtSpanStyle-wn webVueAntYtSpanStyle webVueAntYtSpanBrCount-wn webVueAntYtSpanBrCount"
      >
        <span v-html="'业务字典'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="75.00px"
      top="9.90000%"
      left="14.70000%"
      bottom="24.40000%"
      right="11.70000%"
      gridColumnStart="52"
      gridColumnEnd="58"
      gridRowStart="7"
      gridRowEnd="10"
      zIndex="11"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref36"
        class="webVueAntYtSpan webVueAntYtSpanStyle-wnqfbv8 webVueAntYtSpanStyle-wn webVueAntYtSpanStyle webVueAntYtSpanBrCount-wn webVueAntYtSpanBrCount"
      >
        <span v-html="'字典详情'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="9.10000%"
      left="32.30000%"
      bottom="4.20000%"
      right="2.90000%"
      gridColumnStart="50"
      gridColumnEnd="52"
      gridRowStart="47"
      gridRowEnd="52"
      zIndex="12"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref37"
        class="webVueAntYtIcon webVueAntYtPictureStyle-wnu7j2s webVueAntYtPictureStyle-wn webVueAntYtPictureStyle"
      >
        <img
          :src="'./staticResource/wzc/1845284868271898624/0/LQtwHi8ukCNChmIiPW_RM.png'"
          class="yt-static-wn yt-static"
        />
      </div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="NewisShow1"
      top="0.70000%"
      left="3.10000%"
      bottom="0.70000%"
      right="3.60000%"
      gridColumnStart="39"
      gridColumnEnd="63"
      gridRowStart="37"
      gridRowEnd="65"
      zIndex="13"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref38"
        @ok="
          () => {
            handleAddOk();
          }
        "
        @cancel="
          () => {
            handleAddCancel();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-wn webVueAntYtModalStyle"
        v-model:isShow="NewisShow1"
        :title="'新增'"
        :maskClosable="true"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="Newform1" ref="ref38_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.50000%"
                left="0.40000%"
                bottom="3.40000%"
                right="1.00000%"
                gridColumnStart="11"
                gridColumnEnd="92"
                gridRowStart="11"
                gridRowEnd="31"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref39"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-wnj6pds webVueAntYtInputFormItem-wn webVueAntYtInputFormItem show-label-wn show-label"
                  name="KeyValuevalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'键值：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-wncsnk5 webVueAntYtInputStyle-wn webVueAntYtInputStyle"
                    v-model:value="Newform1.KeyValuevalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.00000%"
                left="0.40000%"
                bottom="4.00000%"
                right="1.00000%"
                gridColumnStart="11"
                gridColumnEnd="92"
                gridRowStart="41"
                gridRowEnd="61"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref40"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-wny0fbl webVueAntYtInputFormItem-wn webVueAntYtInputFormItem show-label-wn show-label"
                  name="Namevalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-wnqssgo webVueAntYtInputStyle-wn webVueAntYtInputStyle"
                    v-model:value="Newform1.Namevalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.30000%"
                left="0.10000%"
                bottom="1.80000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="72"
                gridRowEnd="91"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref44"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-wnid637 webVueAntYtInputNumberFormItem-wn webVueAntYtInputNumberFormItem show-label-wn show-label"
                  name="Sequencevalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'顺序：'"> </span>
                    </div>
                  </template>
                  <a-input-number
                    data-event
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-wnfwvhg webVueAntYtInputNumberStyle-wn webVueAntYtInputNumberStyle"
                    v-model:value="Newform1.Sequencevalue1"
                    :placeholder="'请输入'"
                    :max="100"
                    :min="0"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="EditisShow1"
      top="0.70000%"
      left="3.10000%"
      bottom="0.70000%"
      right="3.60000%"
      gridColumnStart="39"
      gridColumnEnd="63"
      gridRowStart="37"
      gridRowEnd="65"
      zIndex="14"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref45"
        @ok="
          () => {
            handleEditOk();
          }
        "
        @cancel="
          () => {
            handleEditCancel();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-wn webVueAntYtModalStyle"
        v-model:isShow="EditisShow1"
        :title="'编辑'"
        :maskClosable="true"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="Editform1" ref="ref45_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.50000%"
                left="0.40000%"
                bottom="3.40000%"
                right="1.00000%"
                gridColumnStart="11"
                gridColumnEnd="92"
                gridRowStart="11"
                gridRowEnd="31"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref46"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-wnly36s webVueAntYtInputFormItem-wn webVueAntYtInputFormItem show-label-wn show-label"
                  name="KeyValuevalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'键值：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-wn74ma2 webVueAntYtInputStyle-wn webVueAntYtInputStyle"
                    v-model:value="Editform1.KeyValuevalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.00000%"
                left="0.40000%"
                bottom="4.00000%"
                right="1.00000%"
                gridColumnStart="11"
                gridColumnEnd="92"
                gridRowStart="41"
                gridRowEnd="61"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref47"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-wn9zjgb webVueAntYtInputFormItem-wn webVueAntYtInputFormItem show-label-wn show-label"
                  name="Namevalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-wnn9llb webVueAntYtInputStyle-wn webVueAntYtInputStyle"
                    v-model:value="Editform1.Namevalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.30000%"
                left="0.10000%"
                bottom="1.80000%"
                right="0.10000%"
                gridColumnStart="11"
                gridColumnEnd="91"
                gridRowStart="72"
                gridRowEnd="91"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref48"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-wnmof3f webVueAntYtInputNumberFormItem-wn webVueAntYtInputNumberFormItem show-label-wn show-label"
                  name="Sequencevalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'顺序：'"> </span>
                    </div>
                  </template>
                  <a-input-number
                    data-event
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-wnp20fn webVueAntYtInputNumberStyle-wn webVueAntYtInputNumberStyle"
                    v-model:value="Editform1.Sequencevalue2"
                    :placeholder="'请输入'"
                    :max="100"
                    :min="0"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.20000%"
      left="1.80000%"
      bottom="0.60000%"
      right="1.20000%"
      gridColumnStart="51"
      gridColumnEnd="101"
      gridRowStart="5"
      gridRowEnd="99"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref49"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-wn1r87u webVueAntYtRectangleStyle-wn webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>
  </yt-grid>
</template>

<script>
import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { h } from "vue";
export default {
  data() {
    return {
      NewisShow1: false,
      Newform1: {
        id: null,
        KeyValuevalue1: "",
        Namevalue1: "",
        Sequencevalue1: null,
      },
      Deleteloading1: false,
      NewDictionaryloading1: false,
      Editloading1: false,
      DictionaryDetailscurrentRow1: {},
      DictionaryDetailsselectedRows1: [],
      DictionaryDetailspageSize1: 10,
      DictionaryDetailsdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "sequence",
            title: "顺序",
            dataIndex: "sequence",
          },
          {
            key: "keyValue",
            title: "键值",
            dataIndex: "keyValue",
          },
          {
            key: "name",
            title: "名称",
            dataIndex: "name",
          },
          {
            key: "operation1",
            title: "操作",
            dataIndex: "operation1",
            cellType: "slot",
            width: undefined,
          },
        ],
        dataSource: [],
      },
      DictionaryDetailscurrent2: 1,
      DictionaryDetailstotal1: 10,
      Editloading2: false,
      EditisShow1: false,
      Editform1: {
        id: null,
        KeyValuevalue2: "",
        Namevalue2: "",
        Sequencevalue2: null,
      },
      SearchBoxvalue1: "",
      AddCategoryloading1: false,
      BusinessDictionarycurrentRow1: {},
      BusinessDictionaryselectedRows1: [],
      BusinessDictionarypageSize1: 10,
      BusinessDictionarydata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "sequence",
            title: "顺序",
            dataIndex: "sequence",
          },
          {
            key: "keyValue",
            title: "键值",
            dataIndex: "keyValue",
          },
          {
            key: "name",
            title: "名称",
            dataIndex: "name",
          },
          {
            key: "operation",
            title: "操作",
            dataIndex: "operation",
            cellType: "slot",
          },
        ],
        dataSource: [],
      },
      BusinessDictionarycurrent2: 1,
      BusinessDictionarytotal1: 10,
      Deleteloading2: false,
      detail: null,
      showDetail: false,
    };
  },
  watch: {
    detail (val) {
      const { id } = val
      if (id) {
        const findIndex = this.BusinessDictionarydata1.dataSource.findIndex((item) => item.id === id)
        window.event.target.closest('table').querySelectorAll('tbody tr').forEach((item, index) => {
          if (findIndex === index) {
            item.classList.add('click-tr')
          } else {
            item.classList.remove('click-tr')
          }
        })
      }
    }
  },
  methods: {
    async initBusinessDictionaries() {
      try {
        const response = await this.executeBackendInterface("getBusinessDictionaries", {
          current: this.BusinessDictionarycurrent2,
          pageSize: this.BusinessDictionarypageSize1,
        });
        if (response.flag) {
          this.BusinessDictionarydata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            sequence: item.order,
            keyValue: item.key,
            name: item.name,
            operation: item.operation,
          }));
          this.BusinessDictionarytotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取业务字典数据失败");
      }
    },
    handleRightTableChange(pagination) {
      this.DictionaryDetailscurrent2 = pagination.current;
      this.DictionaryDetailspageSize1 = pagination.pageSize;
      this.handleRowClick(this.detail);
    },
    handleLeftTableChange(pagination) {
      this.BusinessDictionarycurrent2 = pagination.current;
      this.BusinessDictionarypageSize1 = pagination.pageSize;
      this.handleSearchChange();
    },
    async handleRowClick(record) {
      if (record) {
        this.detail = record;
        const selectedRow = record;
        try {
          const response = await this.executeBackendInterface("getDictionaryDetails", {
            businessDictionaryId: selectedRow.id,
            current: this.DictionaryDetailscurrent2,
            pageSize: this.DictionaryDetailspageSize1,
          });
          if (response.flag) {
            this.DictionaryDetailsdata1.dataSource = response.data.data.map((item) => ({
              id: item.id,
              sequence: item.order,
              keyValue: item.key,
              name: item.name,
              operation1: item.operation,
            }));
            this.DictionaryDetailstotal1 = response.data.total;
          } else {
            message.error(response.message);
          }
        } catch (error) {
          message.error("获取字典详情数据失败");
        }
      }
    },
    async handleSearchChange() {
      try {
        const response = await this.executeBackendInterface(
          "searchBusinessDictionaries",
          {
            keyValue: this.SearchBoxvalue1,
            name: this.SearchBoxvalue1,
            current: this.BusinessDictionarycurrent2,
            pageSize: this.BusinessDictionarypageSize1,
          }
        );
        if (response.flag) {
          this.BusinessDictionarydata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            sequence: item.order,
            keyValue: item.key,
            name: item.name,
            operation: item.operation,
          }));
          this.BusinessDictionarytotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("搜索业务字典失败");
      }
    },
    async handleDeleteBusinessDictionary(record) {
      Modal.confirm({
        title: "确认删除",
        content: "确定要删除该业务字典吗？",
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface(
              "deleteBusinessDictionary",
              {
                id: record.id,
              }
            );
            if (response.flag) {
              message.success("删除成功");
              this.BusinessDictionarycurrent2 = 1
              this.initBusinessDictionaries();
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("删除业务字典失败");
          }
        },
      });
    },
    async handleDeleteDictionaryDetail(record) {
      Modal.confirm({
        title: "确认删除",
        content: "确定要删除该字典详情吗？",
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface(
              "deleteDictionaryDetail",
              {
                id: record.id,
              }
            );
            if (response.flag) {
              message.success("删除成功");
              this.DictionaryDetailscurrent2 = 1
              this.handleRowClick(this.detail);
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("删除字典详情失败");
          }
        },
      });
    },
    async handleEditOk() {
      try {
        const values = await this.$refs.ref45_form.validateFields();
        if (this.showDetail) {
          const response = await this.executeBackendInterface("updateDictionaryDetail", {
            id: this.Editform1.id,
            keyValue: values.KeyValuevalue2,
            name: values.Namevalue2,
            order: values.Sequencevalue2,
          });
          if (response.flag) {
            message.success("更新成功");
            this.EditisShow1 = false;
            this.handleRowClick(this.detail);
            this.handleEditCancel();
          } else {
            message.error(response.message);
          }
        } else {
          const response = await this.executeBackendInterface(
            "updateBusinessDictionary",
            {
              id: this.Editform1.id,
              keyValue: values.KeyValuevalue2,
              name: values.Namevalue2,
              orderNumber: values.Sequencevalue2,
            }
          );
          if (response.flag) {
            message.success("更新成功");
            this.EditisShow1 = false;
            this.initBusinessDictionaries();
            this.handleEditCancel();
          } else {
            message.error(response.message);
          }
        }
      } catch (error) {
        message.error("更新业务字典失败");
      }
    },
    async handleAddOk() {
      try {
        const values = await this.$refs.ref38_form.validateFields();
        if (this.showDetail) {
          const response = await this.executeBackendInterface("saveDictionaryDetail", {
            businessDictionaryId: this.detail.id,
            keyValue: values.KeyValuevalue1,
            name: values.Namevalue1,
            order: values.Sequencevalue1,
          });
          if (response.flag) {
            message.success("新增成功");
            this.handleRowClick(this.detail);
            this.handleAddCancel();
          } else {
            message.error(response.message);
          }
        } else {
          const response = await this.executeBackendInterface("addBusinessDictionary", {
            keyValue: values.KeyValuevalue1,
            name: values.Namevalue1,
            orderNumber: values.Sequencevalue1,
          });
          if (response.flag) {
            message.success("新增成功");
            this.handleAddCancel();
            this.initBusinessDictionaries();
          } else {
            message.error(response.message);
          }
        }
      } catch (error) {
        message.error("新增业务字典失败");
      }
    },
    showAddDictionaryModal() {
      // 显示新增字典的模态框
      this.NewisShow1 = true;
      this.Newform1 = {
        id: null,
        KeyValuevalue1: "",
        Namevalue1: "",
        Sequencevalue1: null,
      };
    },
    showAddCategoryModal() {
      // 显示新增分类的模态框
      this.NewisShow1 = true;
      this.showDetail = true;
      this.Newform1 = {
        id: null,
        KeyValuevalue1: "",
        Namevalue1: "",
        Sequencevalue1: null,
      };
    },
    handleAddCancel() {
      // 关闭弹窗
      this.NewisShow1 = false;
      this.showDetail = false;
    },
    handleEditCancel() {
      // 关闭弹窗
      this.EditisShow1 = false;
      this.showDetail = false;
    },
    async showEditModal(record) {
      this.EditisShow1 = true;
      this.Editloading2 = true;
      try {
        const response = await this.executeBackendInterface("showEditModal", {
          id: record.id,
        });
        if (response.flag) {
          const data = response.data;
          this.Editform1 = {
            id: data.id,
            KeyValuevalue2: data.key,
            Namevalue2: data.name,
            Sequencevalue2: data.order,
          };
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("请求失败，请重试");
      } finally {
        this.Editloading2 = false;
      }
    },
    async showEditDetailModal(record) {
      // 显示编辑弹框
      this.EditisShow1 = true;
      this.showDetail = true;

      // 调用后端接口获取当前行数据
      try {
        const response = await this.executeBackendInterface("showEditDetailModal", {
          id: record.id,
        });
        if (response.flag) {
          // 校验返回数据格式
          const { id, order, key, name } = response.data;

          // 将数据加载到编辑表单
          this.Editform1 = {
            id: id,
            KeyValuevalue2: key,
            Namevalue2: name,
            Sequencevalue2: order,
          };
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("加载数据失败");
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1846358324254081024";
        const response = await axios.get(
          `./system/permission/getCurrentPageNotShowVariable?pageUuid=${pageUuid}`
        );
        const variablesArray = response.data; // 后端直接返回变量数组

        if (variablesArray && Array.isArray(variablesArray))
          // 遍历数组，将每个变量设置为true
          variablesArray.forEach((variable) => {
            this[variable] = true;
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
          .post("./Datadictionary/" + funcName, params, {
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
    loadCss("./css/数据字典/theme.css");
    this.initBusinessDictionaries();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
.webVueAntYtSpanStyle-wn {
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
.webVueAntYtSpanStyle-wn span {
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

.webVueAntYtSpanStyle-wnntevl {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-wnntevl span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-wn {
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

.webVueAntYtRectangleStyle-wnigpmx {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-wn {
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
.webVueAntYtButtonStyle-wn > span {
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

.webVueAntYtButtonStyle-wn1107x {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wn1107x > span {
  letter-spacing: 0px !important;
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

.webVueAntYtTableStyle-wnynhr6 {
  opacity: 1;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table {
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
.webVueAntYtTableStyle-wnynhr6 .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-wnynhr6 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table thead tr th,
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-wnynhr6 .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-wnynhr6.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnynhr6.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-wnynhr6
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-wnynhr6
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wnynhr6 .ant-pagination button,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li input {
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
.webVueAntYtTableStyle-wnynhr6 .ant-pagination button,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li input,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li a,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wnynhr6
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wnynhr6
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li a,
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-wnynhr6 .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnynhr6 tr > th:nth-child(1),
.webVueAntYtTableStyle-wnynhr6 .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnynhr6 tr > th:nth-child(2),
.webVueAntYtTableStyle-wnynhr6 .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: calc((100% - 143px) / 2) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnynhr6 tr > th:nth-child(3),
.webVueAntYtTableStyle-wnynhr6 .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 143px) / 2) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnynhr6 tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnynhr6 tr > th:nth-child(4),
.webVueAntYtTableStyle-wnynhr6 .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: 95px !important;
  min-width: 95px !important;
  max-width: 95px !important;
}
.webVueAntYtTableStyle-wnynhr6 {
  width: 100%;
}

.webVueAntYtButtonStyle-wnf9avg {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wnf9avg > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wnm91bi {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wnm91bi > span {
  letter-spacing: 0px !important;
}

.webVueAntYtTableStyle-wnxmuk5 {
  opacity: 1;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table {
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
.webVueAntYtTableStyle-wnxmuk5 .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-wnxmuk5 .ant-table tbody tr.click-tr td{
  background: #e4efff;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table thead tr th,
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-wnxmuk5 .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-wnxmuk5.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnxmuk5.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-wnxmuk5
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-wnxmuk5
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination button,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li input {
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
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination button,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li input,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li a,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-wnxmuk5
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-wnxmuk5
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li a,
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-wnxmuk5 .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnxmuk5 tr > th:nth-child(1),
.webVueAntYtTableStyle-wnxmuk5 .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnxmuk5 tr > th:nth-child(2),
.webVueAntYtTableStyle-wnxmuk5 .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: calc((100% - 143px) / 2) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnxmuk5 tr > th:nth-child(3),
.webVueAntYtTableStyle-wnxmuk5 .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 143px) / 2) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-wnxmuk5 tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-wnxmuk5 tr > th:nth-child(4),
.webVueAntYtTableStyle-wnxmuk5 .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: 95px !important;
  min-width: 95px !important;
  max-width: 95px !important;
}
.webVueAntYtTableStyle-wnxmuk5 {
  width: 100%;
}

.webVueAntYtButtonStyle-wnccs86 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wnccs86 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wn4a1m3 {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wn4a1m3 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-wnhoy02 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-wnhoy02 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtInputFormItem-wn {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-wn .ant-form-item-label label {
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
.webVueAntYtInputFormItem-wn .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-wn:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-wn.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-wn.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-wn:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-wn:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-wn input::placeholder,
.webVueAntYtInputStyle-wn input::-webkit-input-placeholder {
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
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputFormItem .ant-form-item-label > label.ant-form-item-no-colon:after {
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

.webVueAntYtInputFormItem-wnr80bu .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wnr80bu .ant-form-item-label label {
  width: 53px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-wnyy175:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}
.webVueAntYtInputStyle-wnyy175.ant-input-affix-wrapper {
  background: transparent !important;
}

.webVueAntYtIcon {
  width: 100%;
  height: 100%;
}

.webVueAntYtIcon img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

@keyframes rotate-animation {
  from {
    transform: rotate(0deg);
  }

  to {
    transform: rotate(360deg);
  }
}

.yt-icon-rotate {
  animation: rotate-animation 1s linear infinite;
}

.webVueAntYtPictureStyle-wn1dry7 {
  opacity: 1;
}
.webVueAntYtPictureStyle-wn1dry7 img {
  box-shadow: 0px 0px 5px 2px transparent;
  transform: scale(1, 1);
  opacity: 1;
  background: transparent;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-wnyvlgy {
  color: #3d3d3d !important;
  font-size: 18px;
  font-weight: bold;
}
.webVueAntYtSpanStyle-wnyvlgy span {
  text-decoration: none;
}

.webVueAntYtSpanStyle-wnqfbv8 {
  color: #3d3d3d !important;
  font-size: 18px;
  font-weight: bold;
}
.webVueAntYtSpanStyle-wnqfbv8 span {
  text-decoration: none;
}

.webVueAntYtPictureStyle-wnu7j2s {
  opacity: 1;
}
.webVueAntYtPictureStyle-wnu7j2s img {
  box-shadow: 0px 0px 5px 2px transparent;
  transform: scale(-1, 1);
  opacity: 1;
  background: transparent;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtModalStyle-wn .ant-modal-wrap {
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
.webVueAntYtModalStyle-wn .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-wn.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-wn .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-wn.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtInputFormItem-wnj6pds .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wnj6pds .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wnj6pds .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wncsnk5:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wny0fbl .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wny0fbl .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wny0fbl .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wnqssgo:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputNumberFormItem-wn {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputNumberFormItem-wn .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 63px !important;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtInputNumberFormItem-wn .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputNumberStyle-wn {
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
.webVueAntYtInputNumberStyle-wn input {
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
.webVueAntYtInputNumberStyle-wn input::placeholder,
.webVueAntYtInputNumberStyle-wn input::-webkit-input-placeholder {
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
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputNumberFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputNumberFormItem .ant-form-item-label > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputNumberFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputNumberFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputNumberFormItem .ant-form-item-content:focus {
  outline: none;
}

.webVueAntYtInputNumberFormItem-wnid637 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-wnid637 .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputNumberFormItem-wnid637 .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputNumberStyle-wnfwvhg {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wnly36s .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wnly36s .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wnly36s .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wn74ma2:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-wn9zjgb .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-wn9zjgb .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-wn9zjgb .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-wnn9llb:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputNumberFormItem-wnmof3f .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-wnmof3f .ant-form-item-label label {
  padding-right: 10px;
}
.webVueAntYtInputNumberFormItem-wnmof3f .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputNumberStyle-wnp20fn {
  background: #ffffff !important;
}

.webVueAntYtRectangleStyle-wn1r87u {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
</style>
