<template>
  <div
    style="width: 100%; height: 100%; overflow: hidden; background: #f0f2f5"
    class="rootContainer flexCol spaceCenter"
  >
    <div
      style="height: 1.97%; z-index: 1; transform: translateY(-162.5%)"
      class="flexRow spaceStart"
    >
      <div
        style="
          position: absolute;
          left: 1.18%;
          top: 0%;
          width: 128px;
          height: 100%;
          z-index: 1;
        "
      >
        <span
          ref="ref1"
          class="webVueAntYtSpan webVueAntYtSpanStyle-am webVueAntYtSpanStyle"
        >
          <span v-html="'车场管理 / 车场巡检'"> </span>
        </span>
      </div>
    </div>

    <div
      style="height: 16.54%; z-index: 2; transform: translateY(-12.8%)"
      class="flexRow spaceAround"
    >
      <div style="z-index: 2; width: 97.65%; height: 100%">
        <a-form
          ref="ref3"
          class="webVueAntForm webVueAntYtFormStyle-am webVueAntYtFormStyle"
          :model="SearchBoxform1"
        >
          <div
            style="position: relative; height: 100%; width: 100%"
            backgroundType="color"
            slotWidth="1658"
            slotHeight="166"
            yt-domslot="ytForm"
            yt-template
          >
            <div
              style="width: 100%; height: 100%; overflow: hidden"
              class="rootContainer flexCol spaceStart"
            >
              <div
                style="height: 19.28%; z-index: 1; transform: translateY(62.5%)"
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
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-amm7klv webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['inspectionNo']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'巡检编号：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-am webVueAntYtInputStyle"
                      v-model:value="SearchBoxform1.inspectionNo"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 8;
                    width: 19.9%;
                    height: 100%;
                    transform: translateX(2.02%);
                  "
                >
                  <a-form-item
                    ref="ref27"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-amf038s webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['inspectionyard1']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'巡检车场：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.inspectionyard1"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="Inspectionyardoptions2.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 5;
                    width: 19.84%;
                    height: 100%;
                    transform: translateX(-1.72%);
                  "
                >
                  <a-form-item
                    ref="ref10"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-amude31 webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['patrolpersonnel']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'巡检人员：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-am webVueAntYtInputStyle"
                      v-model:value="SearchBoxform1.patrolpersonnel"
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
                    transform: translateX(-5.78%);
                  "
                >
                  <a-form-item
                    ref="ref12"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-amsrszu webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['patrolinspectionstatus']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'巡检状态：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.patrolinspectionstatus"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="Patrolinspectionstatusoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>
              </div>

              <div
                style="
                  height: 20.48%;
                  z-index: 4;
                  transform: translateY(105.88%);
                "
                class="flexRow spaceBetween"
              >
                <div
                  style="
                    z-index: 4;
                    width: 19.9%;
                    height: 94.12%;
                    transform: translateX(5.76%) translateY(3.13%);
                  "
                >
                  <a-form-item
                    ref="ref8"
                    class="webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-amy60y5 webVueAntYtRangePickerFormItem-am webVueAntYtRangePickerFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['inspectiondate']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'巡检日期：'"
                        >
                        </span>
                      </div>
                    </template>
                    <yt-custom-range-picker
                      data-event
                      class="webVueAntYtRangePicker webVueAntYtRangePickerStyle-am webVueAntYtRangePickerStyle"
                      popupKey="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      v-model:value="SearchBoxform1.inspectiondate"
                    >
                    </yt-custom-range-picker>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 10;
                    width: 19.9%;
                    height: 94.12%;
                    transform: translateX(2.12%);
                  "
                >
                  <a-form-item
                    ref="ref32"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-amws1du webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['inspectionItems']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'检查项目：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.inspectionItems"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="InspectionItemsoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 7;
                    width: 19.9%;
                    height: 94.12%;
                    transform: translateX(-1.52%) translateY(6.25%);
                  "
                >
                  <a-form-item
                    ref="ref28"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-amuu6rf webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['exceptionType']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'异常类型：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.exceptionType"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="ExceptionTypeoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>

                <div
                  style="
                    z-index: 9;
                    width: 19.84%;
                    height: 94.12%;
                    transform: translateX(-5.47%) translateY(3.13%);
                  "
                >
                  <a-form-item
                    ref="ref29"
                    class="webVueSelectFormItem webVueAntYtSelectFormItem-amv560x webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                    :colon="false"
                    :rules="[]"
                    :name="['exceptionHandling']"
                  >
                    <template #label>
                      <div class="label-content">
                        <span
                          class="ant-form-item-content"
                          v-html="'异常处理：'"
                        >
                        </span>
                      </div>
                    </template>
                    <a-select
                      data-event
                      class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                      dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                      :showArrow="true"
                      v-model:value="SearchBoxform1.exceptionHandling"
                      :placeholder="'请输入'"
                      :mode="'single'"
                      :options="ExceptionHandlingoptions1.dataSource"
                      :showSearch="true"
                    >
                    </a-select>
                  </a-form-item>
                </div>
              </div>

              <div
                style="
                  height: 19.28%;
                  z-index: 2;
                  transform: translateY(162.5%);
                "
                class="flexRow spaceEnd"
              >
                <div
                  style="
                    z-index: 3;
                    width: 3.86%;
                    height: 100%;
                    transform: translateX(-113.42%);
                  "
                >
                  <a-button
                    ref="ref6"
                    @click="
                      () => {
                        searchTableRef6();
                      }
                    "
                    class="webVueAntButton webVueAntYtButtonStyle-am5mnl4 webVueAntYtButtonStyle-am webVueAntYtButtonStyle center-am center"
                    :loading="Searchloading1"
                  >
                    <span class="yt-button-content" v-html="'搜索'"> </span>
                  </a-button>
                </div>

                <div
                  style="
                    z-index: 2;
                    width: 3.86%;
                    height: 100%;
                    transform: translateX(-95%);
                  "
                >
                  <a-button
                    ref="ref5"
                    @click="
                      () => {
                        resetSearchAndTableRef5();
                      }
                    "
                    class="webVueAntButton webVueAntYtButtonStyle-am7x38e webVueAntYtButtonStyle-am webVueAntYtButtonStyle center-am center"
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
      style="height: 71.95%; z-index: 3; transform: translateY(-0.26%)"
      class="flexRow spaceAround"
    >
      <div
        style="
          width: 97.65%;
          height: 100%;
          z-index: 3;
          transform: translateX(0.03px);
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
                class="webVueAntYtRectangle webVueAntYtRectangleStyle-am1covf webVueAntYtRectangleStyle-am webVueAntYtRectangleStyle"
              ></div>
            </div>

            <div
              style="height: 4.38%; z-index: 4; transform: translateY(1.97%)"
              class="flexRow spaceStart"
            >
              <div style="z-index: 4; width: 3.96%; height: 100%">
                <a-button
                  ref="ref15"
                  @click="
                    () => {
                      showNewEntryDialogRef15();
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-am webVueAntYtButtonStyle center-am center"
                  :loading="new_loading1"
                >
                  <span class="yt-button-content" v-html="'新建'"> </span>
                </a-button>
              </div>

              <div
                style="
                  z-index: 6;
                  width: 3.96%;
                  height: 100%;
                  transform: translateX(18.75%);
                "
              >
                <a-button
                  ref="ref23"
                  @click="
                    () => {
                      exportTableDataRef23();
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-am webVueAntYtButtonStyle center-am center"
                  :loading="Exportloading1"
                >
                  <span class="yt-button-content" v-html="'导出'"> </span>
                </a-button>
              </div>

              <div
                style="
                  z-index: 7;
                  width: 3.96%;
                  height: 100%;
                  transform: translateX(37.5%);
                "
              >
                <a-button
                  ref="ref24"
                  @click="
                    () => {
                      deleteSelectedRowsRef24();
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-ami94ab webVueAntYtButtonStyle-am webVueAntYtButtonStyle center-am center"
                  :loading="delete_loading1"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </div>
            </div>

            <div
              style="
                z-index: 5;
                width: 100%;
                height: 87.14%;
                margin-left: 0.01px;
                transform: translateY(-2.23%);
              "
            >
              <yt-table
                ref="ref18"
                @onTableChange="
                  (pagination) => {
                    onTableChangeRef18(pagination);
                  }
                "
                class="webVueAntYtTable webVueAntYtTableStyle-amzzc37 webVueAntYtTableStyle-am webVueAntYtTableStyle"
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
                :scroll="{ y: 524.9999980143481 }"
                :selectKey="DynamicPanelselectKey1"
              >
                <template
                  #cell="{ column, record }"
                  :selectKey="DynamicPanelselectKey1"
                >
                  <template
                    v-if="column.dataIndex === 'problemphoto'"
                    :forKey="'problemphoto'"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      params="record"
                      backgroundType="color"
                      class="customTableTemplate"
                      slotWidth="74"
                      slotHeight="46"
                      yt-domslot="problemphoto"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div
                          style="height: 100%; z-index: 1"
                          class="flexRow spaceStart"
                        >
                          <div style="z-index: 1; width: 98.65%; height: 100%">
                            <!-- 状态1 -->
                            <div
                              ref="ref25"
                              @click="
                                () => {
                                  enlargeImageRef25(record);
                                }
                              "
                              class="webVueAntYtPicture webVueAntYtPictureStyle-am webVueAntYtPictureStyle"
                            >
                              <a-image
                                :src="'./staticResource/public/yt-picture.png'"
                                :preview="false"
                                :style="{
                                  transform: 'scaleX(1) scaleY(1)',
                                  objectFit: 'contain',
                                }"
                              >
                              </a-image>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </template>
                  <template
                    v-if="column.dataIndex === 'processingphotos'"
                    :forKey="'processingphotos'"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      params="record"
                      backgroundType="color"
                      class="customTableTemplate"
                      slotWidth="74"
                      slotHeight="46"
                      yt-domslot="processingphotos"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div style="z-index: 1; width: 100%; height: 100%">
                          <!-- 状态1 -->
                          <div
                            ref="ref26"
                            @click="
                              () => {
                                enlargeImageRef26(record);
                              }
                            "
                            class="webVueAntYtPicture webVueAntYtPictureStyle-am webVueAntYtPictureStyle"
                          >
                            <a-image
                              :src="'./staticResource/public/yt-picture.png'"
                              :preview="false"
                              :style="{
                                transform: 'scaleX(1) scaleY(1)',
                                objectFit: 'contain',
                              }"
                            >
                            </a-image>
                          </div>
                        </div>
                      </div>
                    </div>
                  </template>
                  <template
                    v-if="column.dataIndex === 'operation1'"
                    :forKey="'operation1'"
                    :selectKey="DynamicPanelselectKey1"
                  >
                    <div
                      style="position: relative; height: 100%; width: 100%"
                      params="record"
                      backgroundType="color"
                      class="customTableTemplate"
                      slotWidth="103"
                      slotHeight="46"
                      yt-domslot="operation1"
                      yt-template
                    >
                      <div
                        style="width: 100%; height: 100%; overflow: hidden"
                        class="rootContainer flexCol spaceStart"
                      >
                        <div
                          style="
                            z-index: 1;
                            width: 99.03%;
                            height: 97.83%;
                            transform: translateY(2.22%);
                          "
                        >
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
                              slotWidth="100"
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
                                <!-- 修改动态面板的状态到未巡检，对应的是修改DynamicPanelselectKey1为1 -->
                                <div
                                  v-if="
                                    record.patrolinspectionstatus1 === '未巡检'
                                  "
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
                                        width: 32%;
                                        height: 100%;
                                        transform: translateX(3.13%);
                                      "
                                    >
                                      <a-button
                                        ref="ref21"
                                        @click="
                                          () => {
                                            showInspectionReportRef21();
                                          }
                                        "
                                        :loading="Patrolinspectionloading1"
                                        :class="[
                                          'webVueAntButton',
                                          'webVueAntYtButtonStyle-amfwf68-1',
                                          'webVueAntYtButtonStyle-am',
                                          'webVueAntYtButtonStyle',
                                          'center-am',
                                          'center',
                                        ]"
                                      >
                                        <span
                                          class="yt-button-content"
                                          v-html="'巡检'"
                                        >
                                        </span>
                                      </a-button>
                                    </div>
                                    <div
                                      style="
                                        z-index: 2;
                                        width: 32%;
                                        height: 100%;
                                        transform: translateX(-3.13%);
                                      "
                                    >
                                      <a-button
                                        ref="ref30"
                                        @click="
                                          () => {
                                            deleteCurrentRowRef30();
                                          }
                                        "
                                        :loading="Delete1loading2"
                                        :class="[
                                          'webVueAntButton',
                                          'webVueAntYtButtonStyle-amnotcx-1-2-3',
                                          'webVueAntYtButtonStyle-am',
                                          'webVueAntYtButtonStyle',
                                          'center-am',
                                          'center',
                                        ]"
                                      >
                                        <span
                                          class="yt-button-content"
                                          v-html="'删除'"
                                        >
                                        </span>
                                      </a-button>
                                    </div>
                                  </div>
                                </div>
                                <!-- 修改动态面板的状态到未处理，对应的是修改DynamicPanelselectKey1为2 -->
                                <div
                                  v-if="record.exceptionHandling1 === '未处理'"
                                  style="width: 100%; height: 100%"
                                >
                                  <div
                                    style="
                                      z-index: 2;
                                      width: 32%;
                                      height: 74.42%;
                                      margin-left: 58%;
                                      transform: translateY(18.75%);
                                    "
                                  >
                                    <a-button
                                      ref="ref30"
                                      @click="
                                        () => {
                                          deleteCurrentRowRef30();
                                        }
                                      "
                                      :loading="Delete1loading2"
                                      :class="[
                                        'webVueAntButton',
                                        'webVueAntYtButtonStyle-amnotcx-1-2-3',
                                        'webVueAntYtButtonStyle-am',
                                        'webVueAntYtButtonStyle',
                                        'center-am',
                                        'center',
                                      ]"
                                    >
                                      <span
                                        class="yt-button-content"
                                        v-html="'删除'"
                                      >
                                      </span>
                                    </a-button>
                                  </div>
                                  <div
                                    style="
                                      z-index: 3;
                                      width: 32%;
                                      height: 74.42%;
                                      margin-left: 10%;
                                      transform: translateY(-81.25%);
                                    "
                                  >
                                    <a-button
                                      ref="ref31"
                                      @click="
                                        () => {
                                          showProcessingResultRef31();
                                        }
                                      "
                                      :loading="Processingloading1"
                                      :class="[
                                        'webVueAntButton',
                                        'webVueAntYtButtonStyle-amijehr-2',
                                        'webVueAntYtButtonStyle-am',
                                        'webVueAntYtButtonStyle',
                                        'center-am',
                                        'center',
                                      ]"
                                    >
                                      <span
                                        class="yt-button-content"
                                        v-html="'处理<br>'"
                                      >
                                      </span>
                                    </a-button>
                                  </div>
                                </div>
                                <!-- 修改动态面板的状态到状态3，对应的是修改DynamicPanelselectKey1为3 -->
                                <div
                                  v-if="
                                    record.patrolinspectionstatus1 ===
                                      '无异常' ||
                                    record.exceptionHandling1 === '已处理'
                                  "
                                  style="width: 100%; height: 100%"
                                >
                                  <div
                                    style="
                                      z-index: 2;
                                      width: 32%;
                                      height: 74.42%;
                                      margin-left: 34%;
                                      transform: translateY(18.75%);
                                    "
                                  >
                                    <a-button
                                      ref="ref30"
                                      @click="
                                        () => {
                                          deleteCurrentRowRef30();
                                        }
                                      "
                                      :loading="Delete1loading2"
                                      :class="[
                                        'webVueAntButton',
                                        'webVueAntYtButtonStyle-amnotcx-1-2-3',
                                        'webVueAntYtButtonStyle-am',
                                        'webVueAntYtButtonStyle',
                                        'center-am',
                                        'center',
                                      ]"
                                    >
                                      <span
                                        class="yt-button-content"
                                        v-html="'删除'"
                                      >
                                      </span>
                                    </a-button>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </yt-dynamic-panel>
                        </div>
                      </div>
                    </div>
                  </template>
                </template>
              </yt-table>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div
      style="
        position: absolute;
        left: 39.95%;
        top: 30.36%;
        width: 22.35%;
        height: 39.27%;
        z-index: 8;
      "
      v-if="popupwindowisShow1"
    >
      <yt-custom-modal
        ref="ref33"
        @ok="
          () => {
            submitNewEntryDialogRef33();
          }
        "
        @cancel="
          () => {
            cancelNewEntryDialogRef33();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-am webVueAntYtModalStyle"
        v-model:isShow="popupwindowisShow1"
        :title="'新增'"
        :maskKey="'modal_yt-uo3b3m4wi5pyh_mask'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="popupwindowform1"
            ref="ref33_form"
          >
            <div
              style="position: relative; height: 100%; width: 100%"
              backgroundType="color"
              slotWidth="376"
              slotHeight="293"
              yt-domslot="ytForm"
              yt-template
            >
              <div
                style="width: 100%; height: 100%; overflow: hidden"
                class="rootContainer flexCol spaceStart"
              >
                <div
                  style="height: 10.92%; z-index: 1; transform: translateY(75%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 1;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 1; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref34"
                        class="webVueAntInputFormItem webVueAntYtInputFormItem-ameo81b webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionNo1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检编号：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-input
                          data-event
                          class="webVueAntinput webVueAntYtInputStyle-am3eumh webVueAntYtInputStyle-am webVueAntYtInputStyle"
                          v-model:value="popupwindowform1.inspectionNo1"
                          :disabled="true"
                          :maxLength="100"
                          :placeholder="'自动生成'"
                        >
                        </a-input>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 10.92%;
                    z-index: 2;
                    transform: translateY(137.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="width: 88.03%; height: 100%; z-index: 2"
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 2; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref36"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amp846z webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['inspectionyard']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检车场：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform1.inspectionyard"
                          :placeholder="'请输入'"
                          :mode="'single'"
                          :options="Inspectionyardoptions1.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 10.92%;
                    z-index: 3;
                    transform: translateY(200%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="width: 88.03%; height: 100%; z-index: 3"
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 3; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref37"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amkmwhd webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['inspectionitems']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检项目：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform1.inspectionitems"
                          :placeholder="'请输入'"
                          :mode="'single'"
                          :options="Inspectionitemsoptions1.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 10.92%;
                    z-index: 4;
                    transform: translateY(262.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="width: 88.03%; height: 100%; z-index: 4"
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 4; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref38"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amqhivx webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['patrolpersonnel1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检人员：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform1.patrolpersonnel1"
                          :placeholder="'请输入'"
                          :mode="'single'"
                          :options="Patrolpersonneloptions1.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 10.92%;
                    z-index: 5;
                    transform: translateY(325%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="width: 88.03%; height: 100%; z-index: 5"
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 5; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref41"
                        class="webVueAntDatePickerFormItem webVueAntYtDatePickerFormItem-amrvly6 webVueAntYtDatePickerFormItem-am webVueAntYtDatePickerFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['inspectiondate1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检日期：'"
                            >
                            </span>
                          </div>
                        </template>
                        <yt-custom-date-piker
                          data-event
                          class="webVueAntYtDatePickerStyle-am webVueAntYtDatePickerStyle"
                          popupKey="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          v-model:value="popupwindowform1.inspectiondate1"
                          :placeholder="'请输入'"
                        >
                        </yt-custom-date-piker>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 10.92%;
                    z-index: 6;
                    transform: translateY(387.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 6;
                      transform: translateX(1.88%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div
                      style="z-index: 6; width: 100%; height: 100%"
                      v-if="NewInspectionStatusisShow1"
                    >
                      <a-form-item
                        ref="ref61"
                        class="webVueAntInputFormItem webVueAntYtInputFormItem-ambeozq webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['newInspectionStatus']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检状态：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-input
                          data-event
                          class="webVueAntinput webVueAntYtInputStyle-amsri2j webVueAntYtInputStyle-am webVueAntYtInputStyle"
                          v-model:value="popupwindowform1.newInspectionStatus"
                          :disabled="true"
                          :maxLength="100"
                          :placeholder="'自动生成'"
                        >
                        </a-input>
                      </a-form-item>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </div>

    <div
      style="
        position: absolute;
        left: 41.71%;
        top: 24.62%;
        width: 22.35%;
        height: 50.79%;
        z-index: 9;
      "
      v-if="popupwindowisShow2"
    >
      <yt-custom-modal
        ref="ref42"
        @ok="
          () => {
            submitInspectionReportRef42();
          }
        "
        @cancel="
          () => {
            cancelInspectionReportRef42();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-am webVueAntYtModalStyle"
        v-model:isShow="popupwindowisShow2"
        :title="'巡检上报'"
        :maskClosable="true"
        :maskKey="'modal_yt-d2xo2m4wkxzy2_mask'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="popupwindowform2"
            ref="ref42_form"
          >
            <div
              style="position: relative; height: 100%; width: 100%"
              backgroundType="color"
              slotWidth="376"
              slotHeight="410"
              yt-domslot="ytForm"
              yt-template
              zIndex="8"
            >
              <div
                style="width: 100%; height: 100%; overflow: hidden"
                class="rootContainer flexCol spaceStart"
              >
                <div
                  style="height: 7.8%; z-index: 1; transform: translateY(75%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 1;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 1; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref43"
                        class="webVueAntInputFormItem webVueAntYtInputFormItem-amjmjsd webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionNo1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检编号：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-input
                          data-event
                          class="webVueAntinput webVueAntYtInputStyle-amk5g8d webVueAntYtInputStyle-am webVueAntYtInputStyle"
                          v-model:value="popupwindowform2.inspectionNo1"
                          :disabled="true"
                          :maxLength="100"
                          :placeholder="'自动同步'"
                        >
                        </a-input>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 7.8%;
                    z-index: 2;
                    transform: translateY(137.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 2;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 2; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref44"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amowwcd webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionyard1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检车场：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-amov8tb webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform2.inspectionyard1"
                          :placeholder="'自动同步'"
                          :mode="'single'"
                          :options="Inspectionyardoptions3.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 7.8%; z-index: 3; transform: translateY(200%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 3;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 3; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref45"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amfdrgj webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionitems1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检项目：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-amdfyux webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform2.inspectionitems1"
                          :placeholder="'自动同步'"
                          :mode="'single'"
                          :options="Inspectionitemsoptions2.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 7.8%;
                    z-index: 4;
                    transform: translateY(262.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 88.03%;
                      height: 100%;
                      z-index: 4;
                      transform: translateX(0.15%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 4; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref46"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amjk3my webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['exceptionType1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'异常类型：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform2.exceptionType1"
                          :placeholder="'请输入'"
                          :mode="'single'"
                          :options="ExceptionTypeoptions2.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 7.8%; z-index: 5; transform: translateY(325%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 84.31%;
                      height: 100%;
                      z-index: 5;
                      transform: translateX(2.05%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 5; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref48"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amv15ps webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['handleperson']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'处理人：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform2.handleperson"
                          :placeholder="'请输入'"
                          :mode="'single'"
                          :options="Handlepersonoptions1.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 12.2%; z-index: 6; transform: translateY(248%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 84.84%;
                      height: 100%;
                      z-index: 6;
                      transform: translateX(2.04%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 6; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref49"
                        class="webVueAntTextAreaFormItem webVueAntYtTextAreaFormItem-amxeifh webVueAntYtTextAreaFormItem-am webVueAntYtTextAreaFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['problemDescription']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'问题描述：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-textarea
                          data-event
                          class="webVueAntTextarea webVueAntYtTextAreaStyle-amlidk2 webVueAntYtTextAreaStyle-am webVueAntYtTextAreaStyle"
                          v-model:value="popupwindowform2.problemDescription"
                          :placeholder="'请输入'"
                          :maxLength="100"
                        >
                        </a-textarea>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 7.8%; z-index: 7; transform: translateY(450%)"
                  class="flexRow spaceStart"
                >
                  <div
                    style="
                      width: 50%;
                      height: 100%;
                      z-index: 7;
                      transform: translateX(18.62%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 7; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref50"
                        class="webVueAntUploadButton webVueAntUploadButtonFormItem-amtp5cx webVueAntUploadButtonStyle-amthbmh webVueAntUploadButtonFormItem-am webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-am webVueAntUploadButtonStyle show-label-am show-label row-am row"
                        :colon="false"
                        :rules="[]"
                        :name="['problempicture']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'问题图片：'"
                            >
                            </span>
                          </div>
                        </template>
                        <yt-upload-button-inner
                          data-event
                          v-model:fileList="popupwindowform2.problempicture"
                          :maxSize="'5'"
                          :showUploadList="true"
                          :listType="'picture'"
                          :preview="true"
                          :canDownload="true"
                          :accept="'image/*'"
                          :maxCount="9"
                        >
                        </yt-upload-button-inner>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 15.12%;
                    z-index: 8;
                    transform: translateY(264.52%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 86.97%;
                      height: 100%;
                      z-index: 8;
                      transform: translateX(1.07%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div
                      style="height: 100%; z-index: 8"
                      class="flexRow spaceStart"
                    >
                      <div
                        style="width: 97.86%; height: 100%; z-index: 8"
                        class="flexCol spaceEnd"
                      >
                        <div
                          style="z-index: 9; width: 100%; height: 51.61%"
                          v-if="InspectionExceptionHandlingisShow1"
                        >
                          <a-form-item
                            ref="ref63"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-am8wq01 webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['inspectionExceptionHandling']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'异常处理：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-input
                              data-event
                              class="webVueAntinput webVueAntYtInputStyle-amcrwnl webVueAntYtInputStyle-am webVueAntYtInputStyle"
                              v-model:value="
                                popupwindowform2.inspectionExceptionHandling
                              "
                              :disabled="true"
                              :maxLength="100"
                              :placeholder="'自动同步'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>

                        <div
                          style="
                            position: absolute;
                            left: 2.19%;
                            top: 0%;
                            width: 100%;
                            height: 51.61%;
                            z-index: 8;
                          "
                          v-if="InspectionInspectionStatusisShow1"
                        >
                          <a-form-item
                            ref="ref62"
                            class="webVueAntInputFormItem webVueAntYtInputFormItem-amso4j5 webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                            :colon="false"
                            :rules="[]"
                            :name="['inspectionInspectionStatus']"
                          >
                            <template #label>
                              <div class="label-content">
                                <span
                                  class="ant-form-item-content"
                                  v-html="'巡检状态：'"
                                >
                                </span>
                              </div>
                            </template>
                            <a-input
                              data-event
                              class="webVueAntinput webVueAntYtInputStyle-amtrjxa webVueAntYtInputStyle-am webVueAntYtInputStyle"
                              v-model:value="
                                popupwindowform2.inspectionInspectionStatus
                              "
                              :disabled="true"
                              :maxLength="100"
                              :placeholder="'自动同步'"
                            >
                            </a-input>
                          </a-form-item>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </div>

    <div
      style="
        position: absolute;
        left: 43.48%;
        top: 27.57%;
        width: 22.35%;
        height: 44.39%;
        z-index: 10;
      "
      v-if="popupwindowisShow3"
    >
      <yt-custom-modal
        ref="ref52"
        @ok="
          () => {
            submitProcessingResultRef52();
          }
        "
        @cancel="
          () => {
            cancelProcessingResultRef52();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-am webVueAntYtModalStyle"
        v-model:isShow="popupwindowisShow3"
        :title="'处理结果'"
        :maskClosable="true"
        :maskKey="'modal_yt-vdqj8m4wli0oh_mask'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="popupwindowform3"
            ref="ref52_form"
          >
            <div
              style="position: relative; height: 100%; width: 100%"
              backgroundType="color"
              slotWidth="376"
              slotHeight="345"
              yt-domslot="ytForm"
              yt-template
            >
              <div
                style="width: 100%; height: 100%; overflow: hidden"
                class="rootContainer flexCol spaceStart"
              >
                <div
                  style="height: 9.28%; z-index: 1; transform: translateY(75%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 1;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 1; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref53"
                        class="webVueAntInputFormItem webVueAntYtInputFormItem-am7vf7x webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionNo1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检编号：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-input
                          data-event
                          class="webVueAntinput webVueAntYtInputStyle-amdopwq webVueAntYtInputStyle-am webVueAntYtInputStyle"
                          v-model:value="popupwindowform3.inspectionNo1"
                          :disabled="true"
                          :maxLength="100"
                          :placeholder="'自动同步'"
                        >
                        </a-input>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 9.28%;
                    z-index: 2;
                    transform: translateY(137.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 2;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 2; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref54"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amxw1o3 webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionyard1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检车场：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-am4posk webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform3.inspectionyard1"
                          :placeholder="'自动同步'"
                          :mode="'single'"
                          :options="Inspectionyardoptions4.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 9.28%; z-index: 3; transform: translateY(200%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 3;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 3; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref55"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amak02l webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['inspectionitems1']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'巡检项目：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-ambwqoq webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform3.inspectionitems1"
                          :placeholder="'自动同步'"
                          :mode="'single'"
                          :options="Inspectionitemsoptions3.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 9.28%;
                    z-index: 4;
                    transform: translateY(262.5%);
                  "
                  class="flexRow spaceAround"
                >
                  <div
                    style="width: 88.03%; height: 100%; z-index: 4"
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 4; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref57"
                        class="webVueSelectFormItem webVueAntYtSelectFormItem-amhz2l4 webVueAntYtSelectFormItem-am webVueAntYtSelectFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[{ required: true, message: '必填' }]"
                        :name="['handlers']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'处理人员：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-select
                          data-event
                          class="webVueSelect webVueAntYtSelectStyle-amba0yl webVueAntYtSelectStyle-am webVueAntYtSelectStyle"
                          dropdownClassName="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          :showArrow="true"
                          v-model:value="popupwindowform3.handlers"
                          :disabled="true"
                          :placeholder="'自动同步'"
                          :mode="'single'"
                          :options="Handlersoptions1.dataSource"
                          :showSearch="true"
                        >
                        </a-select>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 9.28%; z-index: 5; transform: translateY(325%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 84.84%;
                      height: 100%;
                      z-index: 5;
                      transform: translateX(1.57%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 5; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref60"
                        class="webVueAntDatePickerFormItem webVueAntYtDatePickerFormItem-am0s2pd webVueAntYtDatePickerFormItem-am webVueAntYtDatePickerFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['processingDate']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'处理日期：'"
                            >
                            </span>
                          </div>
                        </template>
                        <yt-custom-date-piker
                          data-event
                          class="webVueAntYtDatePickerStyle-am webVueAntYtDatePickerStyle"
                          popupKey="  popupKey-am popupKey popupKeyId-am popupKeyId"
                          v-model:value="popupwindowform3.processingDate"
                          :placeholder="'请输入'"
                        >
                        </yt-custom-date-piker>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="
                    height: 9.28%;
                    z-index: 6;
                    transform: translateY(387.5%);
                  "
                  class="flexRow spaceStart"
                >
                  <div
                    style="
                      width: 50%;
                      height: 100%;
                      z-index: 6;
                      transform: translateX(17.82%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div style="z-index: 6; width: 100%; height: 100%">
                      <a-form-item
                        ref="ref59"
                        class="webVueAntUploadButton webVueAntUploadButtonFormItem-amzytlu webVueAntUploadButtonStyle-amcyrk2 webVueAntUploadButtonFormItem-am webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-am webVueAntUploadButtonStyle show-label-am show-label row-am row"
                        :colon="false"
                        :rules="[]"
                        :name="['processingPictures']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'处理图片：'"
                            >
                            </span>
                          </div>
                        </template>
                        <yt-upload-button-inner
                          data-event
                          v-model:fileList="popupwindowform3.processingPictures"
                          :maxSize="'5'"
                          :showUploadList="true"
                          :listType="'picture'"
                          :preview="true"
                          :canDownload="true"
                          :accept="'image/*'"
                          :maxCount="9"
                        >
                        </yt-upload-button-inner>
                      </a-form-item>
                    </div>
                  </div>
                </div>

                <div
                  style="height: 9.28%; z-index: 7; transform: translateY(550%)"
                  class="flexRow spaceAround"
                >
                  <div
                    style="
                      width: 85.11%;
                      height: 100%;
                      z-index: 7;
                      transform: translateX(1.72%);
                    "
                    class="flexCol spaceStart"
                  >
                    <div
                      style="z-index: 7; width: 100%; height: 100%"
                      v-if="HandlingExceptionHandlingisShow1"
                    >
                      <a-form-item
                        ref="ref64"
                        class="webVueAntInputFormItem webVueAntYtInputFormItem-amfeow0 webVueAntYtInputFormItem-am webVueAntYtInputFormItem show-label-am show-label"
                        :colon="false"
                        :rules="[]"
                        :name="['handlingExceptionHandling']"
                      >
                        <template #label>
                          <div class="label-content">
                            <span
                              class="ant-form-item-content"
                              v-html="'异常处理：'"
                            >
                            </span>
                          </div>
                        </template>
                        <a-input
                          data-event
                          class="webVueAntinput webVueAntYtInputStyle-amwsyj7 webVueAntYtInputStyle-am webVueAntYtInputStyle"
                          v-model:value="
                            popupwindowform3.handlingExceptionHandling
                          "
                          :disabled="true"
                          :maxLength="100"
                          :placeholder="'自动同步'"
                        >
                        </a-input>
                      </a-form-item>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </a-form>
        </template>
      </yt-custom-modal>
    </div>
  </div>
</template>

<script>
import { Modal, message } from "ant-design-vue";
import axios from "axios";
import { h } from "vue";
export default {
  data() {
    return {
      // method中的函数用到的变量只能使用data中的变量,考虑到输出token限制,data中的变量不需要输出出来
      popupwindowisShow1: false,
      popupwindowform1: {
        id: null,
        inspectionNo1: "",
        inspectionyard: undefined,
        inspectionitems: undefined,
        patrolpersonnel1: undefined,
        inspectiondate1: "",
        newInspectionStatus: "未巡检",
      },
      Resetloading1: false,
      Searchloading1: false,
      SearchBoxform1: {
        id: null /*编辑时,需要给id赋值*/,
        inspectionNo: "",
        inspectiondate: [],
        patrolpersonnel: "",
        patrolinspectionstatus: undefined,
        inspectionyard1: undefined,
        exceptionType: undefined,
        exceptionHandling: undefined,
        inspectionItems: undefined,
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
            key: "inspectionNo",
            title: "巡检编号",
            dataIndex: "inspectionNo",
          },
          {
            key: "inspectionyard1",
            title: "巡检车场",
            dataIndex: "inspectionyard1",
          },
          {
            key: "inspectiondate1",
            title: "巡检日期",
            dataIndex: "inspectiondate1",
          },
          {
            key: "inspectionitems",
            title: "巡检项目",
            dataIndex: "inspectionitems",
          },
          {
            key: "patrolpersonnel1",
            title: "巡检人员",
            dataIndex: "patrolpersonnel1",
          },
          {
            key: "exceptionType",
            title: "异常类型",
            dataIndex: "exceptionType",
          },
          {
            key: "problemphoto",
            title: "问题照片",
            dataIndex: "problemphoto",
            cellType: "slot",
          },
          {
            key: "problemDescription",
            title: "问题描述",
            dataIndex: "problemDescription",
          },
          {
            key: "patrolinspectionstatus1",
            title: "巡检状态",
            dataIndex: "patrolinspectionstatus1",
            customRender: ({ text, record, index, column }) => {
              // 根据巡检状态设置文本颜色
              let textColor = "";
              if (record.patrolinspectionstatus1 === "未巡检") {
                textColor = "red";
              } else if (record.patrolinspectionstatus1 === "已巡检") {
                textColor = "green";
              }

              // 返回渲染的内容
              return h("div", [
                h(
                  "span",
                  {
                    class: "td-text",
                    style: `color: ${textColor};`,
                  },
                  text
                ),
              ]);
            },
          },
          {
            key: "exceptionHandling1",
            title: "异常处理",
            dataIndex: "exceptionHandling1",
            customRender: ({ text, record, index, column }) => {
              // 根据异常处理状态设置文本颜色
              let textColor = "";
              if (record.exceptionHandling1 === "未处理") {
                textColor = "red";
              } else if (record.exceptionHandling1 === "已处理") {
                textColor = "green";
              }

              // 返回渲染的内容
              return h("div", [
                h(
                  "span",
                  {
                    class: "td-text",
                    style: `color: ${textColor};`,
                  },
                  text
                ),
              ]);
            },
          },
          {
            key: "processingphotos",
            title: "处理照片",
            dataIndex: "processingphotos",
            cellType: "slot",
          },
          {
            key: "handleperson",
            title: "处理人",
            dataIndex: "handleperson",
          },
          {
            key: "operation1",
            title: "操作",
            dataIndex: "operation1",
            cellType: "slot",
          },
        ],
        dataSource: [
          {
            id: 1,
            serialNumber1: "1",
            inspectionNo: "20240111131331",
            inspectionitems: "立体车库",
            exceptionType: "状态异常",
            problemphoto: "",
            problemDescription: "",
            inspectiondate1: "2024-03-13",
            inspectionyard1: "永宁路小学停车场",
            patrolpersonnel1: "\n",
            patrolinspectionstatus1: "已巡检",
            exceptionHandling1: "已处理",
          },
          {
            id: 2,
            serialNumber1: "2",
            inspectionNo: "20240111131331",
            exceptionType: "",
            problemphoto: "",
            problemDescription: "\n",
            inspectiondate1: "",
            inspectionitems: "洗车机",
            patrolinspectionstatus1: "未巡检",
            exceptionHandling1: "\n",
          },
          {
            id: 3,
            serialNumber1: "",
            inspectionNo: "",
            exceptionType: "",
            problemphoto: "",
            problemDescription: "",
            inspectiondate1: "",
            inspectionitems: "道闸",
            patrolinspectionstatus1: "已巡检",
            exceptionHandling1: "未处理",
          },
          {
            id: 0,
            serialNumber1: "",
            inspectionNo: "",
            exceptionType: "",
            problemphoto: "",
            problemDescription: "",
            inspectiondate1: "",
            inspectionitems: "充电桩",
            patrolinspectionstatus1: "",
            exceptionHandling1: "",
          },
        ],
      },
      Form1current1: 1,
      Form1total1: 2,
      DynamicPanelpanel1: {},
      DynamicPanelselectKey1: "1",
      Patrolinspectionstatusoptions1: {
        dataSource: [
          {
            label: "已巡检",
            value: "已巡检",
            disabled: false,
            select: false,
          },
          {
            label: "未巡检",
            value: "未巡检",
            disabled: false,
            select: false,
          },
          {
            value: "无异常",
            label: "无异常",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      ExceptionTypeoptions1: {
        dataSource: [
          {
            label: "状态异常",
            value: "状态异常",
            disabled: false,
            select: false,
          },
          {
            label: "外观异常",
            value: "外观异常",
            disabled: false,
            select: false,
          },
          {
            value: "其他",
            label: "其他",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      ExceptionHandlingoptions1: {
        dataSource: [
          {
            label: "已处理",
            value: "已处理",
            disabled: false,
            select: false,
          },
          {
            label: "未处理",
            value: "未处理",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      InspectionItemsoptions1: {
        dataSource: [
          {
            label: "充电桩",
            value: "充电桩",
            disabled: false,
            select: false,
          },
          {
            label: "道闸",
            value: "道闸",
            disabled: false,
            select: false,
          },
          {
            value: "洗车机",
            label: "洗车机",
            disabled: false,
            select: false,
          },
          {
            value: "立体车库",
            label: "立体车库",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Inspectionyardoptions1: {
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
      Inspectionitemsoptions1: {
        dataSource: [
          {
            label: "充电桩",
            value: "充电桩",
            disabled: false,
            select: false,
          },
          {
            label: "道闸",
            value: "道闸",
            disabled: false,
            select: false,
          },
          {
            value: "洗车机",
            label: "洗车机",
            disabled: false,
            select: false,
          },
          {
            value: "立体车库",
            label: "立体车库",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Patrolpersonneloptions1: {
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
      Delete1stateKey2: "2",
      Delete1loading2: false,
      Inspectionyardoptions2: {
        dataSource: [
          {
            label: "-",
            value: "-",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      popupwindowisShow2: false,
      popupwindowform2: {
        id: null /*编辑时,需要给id赋值*/,
        inspectionNo1: "",
        inspectionyard1: undefined,
        inspectionitems1: undefined,
        exceptionType1: undefined,
        handleperson: undefined,
        problemDescription: "",
        problempicture: [],
        inspectionInspectionStatus: "已巡检",
        inspectionExceptionHandling: "未处理",
      },
      Inspectionyardoptions3: {
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
      Inspectionitemsoptions2: {
        dataSource: [
          {
            label: "充电桩",
            value: "充电桩",
            disabled: false,
            select: false,
          },
          {
            label: "道闸",
            value: "道闸",
            disabled: false,
            select: false,
          },
          {
            value: "洗车机",
            label: "洗车机",
            disabled: false,
            select: false,
          },
          {
            value: "立体车库",
            label: "立体车库",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      ExceptionTypeoptions2: {
        dataSource: [
          {
            label: "状态异常",
            value: "状态异常",
            disabled: false,
            select: false,
          },
          {
            label: "外观受损",
            value: "外观受损",
            disabled: false,
            select: false,
          },
          {
            value: "其他",
            label: "其他",
            disabled: false,
            select: false,
          },
          {
            value: "无异常",
            label: "无异常",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Handlepersonoptions1: {
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
      popupwindowisShow3: false,
      popupwindowform3: {
        id: null /*编辑时,需要给id赋值*/,
        inspectionNo1: "",
        inspectionyard1: undefined,
        inspectionitems1: undefined,
        handlers: undefined,
        processingPictures: [],
        processingDate: "",
        handlingExceptionHandling: "已处理",
      },
      Inspectionyardoptions4: {
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
      Inspectionitemsoptions3: {
        dataSource: [
          {
            label: "充电桩",
            value: "充电桩",
            disabled: false,
            select: false,
          },
          {
            label: "道闸",
            value: "道闸",
            disabled: false,
            select: false,
          },
          {
            value: "洗车机",
            label: "洗车机",
            disabled: false,
            select: false,
          },
          {
            value: "立体车库",
            label: "立体车库",
            disabled: false,
            select: false,
          },
        ],
        value: [],
      },
      Handlersoptions1: {
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
      ProcessingstateKey1: "2",
      Processingloading1: false,
      PatrolinspectionstateKey1: "2",
      Patrolinspectionloading1: false,
      Exportloading1: false,
      new_loading1: false,
      delete_loading1: false,
      ProcessingisShow1: false,
      NewInspectionStatusisShow1: false,
      InspectionInspectionStatusisShow1: false,
      InspectionExceptionHandlingisShow1: false,
      HandlingExceptionHandlingisShow1: false,
    };
  },
  watch: {
    "popupwindowform2.exceptionType1": async function (newVal) {
      // 监听异常类型的变化
      if (newVal === "无异常") {
        // 当异常类型为“无异常”时，巡检状态改为“无异常”
        this.popupwindowform2.inspectionInspectionStatus = "无异常";

        // 调用后端接口更新巡检记录的状态
        try {
          const response = await this.executeBackendInterface(
            "listenToExceptionTypeRef62",
            {
              exceptionType1: this.popupwindowform2.exceptionType1,
              id:
                this.popupwindowform2.id !== null
                  ? parseInt(this.popupwindowform2.id)
                  : null, // 确保id为Integer类型
            }
          );

          if (response.flag) {
            message.success(response.message);
          } else {
            message.error(response.message);
          }
        } catch (error) {
          message.error("更新巡检状态失败");
        }
      }
    },
    // 监听异常类型的变化
    "popupwindowform2.exceptionType1": function (newVal) {
      if (newVal === "无异常") {
        this.listenToExceptionTypeRef63();
      }
    },
  },
  methods: {
    enlargeImageRef26(record) {
      /**
      点击放大图片1(ref=ref26) 当前需求和组件(ref=ref26)有关。
      */
      // 检查record.processingphotos是否为空
      const imageUrl = record.processingphotos
        ? record.processingphotos
        : "./staticResource/public/yt-picture.png";

      // 弹出一个对话框显示图片
      Modal.info({
        title: "图片预览",
        content: `<img src="${imageUrl}" style="width: 100%; height: auto;" />`,
        onOk() {},
      });
    },
    enlargeImageRef25(record) {
      /**
       * 点击放大图片(ref=ref25) 当前需求和组件(ref=ref25)有关。
       */
      // 检查 record.problemphoto 是否为空
      if (record.problemphoto) {
        // 弹出一个对话框，显示放大的图片
        Modal.info({
          title: "图片预览",
          content: `<img src="${record.problemphoto}" style="width: 100%; height: auto;" />`,
          onOk() {},
        });
      } else {
        // 如果 problemphoto 为空，显示提示信息
        Modal.info({
          title: "提示",
          content: "没有可预览的图片。",
          onOk() {},
        });
      }
    },
    async initParkingLotRef27() {
      /**
      进入页面后,数据来源于parking_lot_info表中的parking_lot_name字段 当前需求和组件(ref=ref27)有关。
      */
      try {
        // 调用后端接口获取车场信息
        const response = await this.executeBackendInterface(
          "getParkingLotNames",
          {
            parking_lot_code: "", // 确保传递的参数类型为字符串
          }
        );

        // 检查接口返回的数据格式是否正确
        if (response.flag && Array.isArray(response.data)) {
          // 将返回的数据格式化为组件需要的格式
          this.Inspectionyardoptions2.dataSource = response.data.map(
            (item) => ({
              label: item.parking_lot_name,
              value: item.id,
              // 使用 id 作为 value
              disabled: false,
              select: false,
            })
          );
        } else {
          message.error("获取车场信息失败: " + response.message);
        }
      } catch (error) {
        message.error("请求车场信息时发生错误");
      }
    },
    resetSearchAndTableRef5() {
      /**
       * 清空搜索区域(ref=ref3)中的数据,并且初始化表格(ref=ref18) 当前需求和组件(ref=ref5)有关。
       */
      // 清空搜索区域的数据
      this.SearchBoxform1.inspectionNo = "";
      this.SearchBoxform1.inspectiondate = [];
      this.SearchBoxform1.patrolpersonnel = "";
      this.SearchBoxform1.patrolinspectionstatus = undefined;
      this.SearchBoxform1.inspectionyard1 = undefined;
      this.SearchBoxform1.exceptionType = undefined;
      this.SearchBoxform1.exceptionHandling = undefined;
      this.SearchBoxform1.inspectionItems = undefined;

      // 初始化表格数据
      this.Form1current1 = 1;
      this.generalQueryInspectionTableData();
    },
    async generalQueryInspectionTableData() {
      try {
        // 获取搜索条件
        const params = {
          current: parseInt(this.Form1current1),
          // 确保类型为Integer
          pageSize: parseInt(this.Form1pageSize1),
          // 确保类型为Integer
          inspectionNo: this.SearchBoxform1.inspectionNo,
          patrolPersonnel: this.SearchBoxform1.patrolpersonnel,
          inspectionStatus: this.SearchBoxform1.patrolinspectionstatus,
          inspectionYard: this.SearchBoxform1.inspectionyard1,
          exceptionType: this.SearchBoxform1.exceptionType,
          exceptionHandling: this.SearchBoxform1.exceptionHandling,
          inspectionItems: this.SearchBoxform1.inspectionItems,
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryInspectionTableData",
          params
        );
        if (response.flag) {
          // 校验并转换数据格式
          const data = response.data.data.map((item) => ({
            id: item.id,
            inspectionNo: item.inspection_number,
            inspectionyard1: item.parking_lot_name,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1: item.inspector_name,
            exceptionType: item.anomaly_type,
            problemDescription: item.issue_description,
            patrolinspectionstatus1: item.inspection_status,
            exceptionHandling1: item.anomaly_handling,
            handleperson: item.handler_name,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1current1 = response.data.current;
          this.Form1pageSize1 = response.data.pageSize;
          this.Form1total1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    async deleteSelectedRowsRef24() {
      /**
       * 删除表格(ref=ref18)中选中行的数据,并重新查询表格(ref=ref18)的数据加载到表格(ref=ref18)中； 当前需求和组件(ref=ref24)有关。
       */
      // 获取选中的行的ID列表
      const selectedIds = this.Form1selectedRows1.map((row) => row.id);
      if (selectedIds.length === 0) {
        message.warning("请选择要删除的行");
        return;
      }

      // 弹出确认对话框
      Modal.confirm({
        title: "确认删除",
        content: "您确定要删除选中的行吗？",
        onOk: async () => {
          try {
            // 调用后端接口删除选中的行
            const response = await this.executeBackendInterface(
              "deleteSelectedRows",
              {
                selectedIds,
                current: parseInt(this.Form1current1),
                // 确保 current 是 Integer 类型
                pageSize: parseInt(this.Form1pageSize1), // 确保 pageSize 是 Integer 类型
              }
            );

            if (response.flag) {
              message.success("删除成功");
              // 清空选中的行
              this.Form1selectedRows1 = [];
              // 重新查询表格数据
              await this.generalQueryInspectionTableData();
            } else {
              message.error(`删除失败: ${response.message}`);
            }
          } catch (error) {
            message.error("删除失败，请稍后重试");
          }
        },
        onCancel: () => {
          // 取消删除操作
        },
      });
    },
    async deleteCurrentRowRef30() {
      /**
       * 删除当前行的数据,并重新查询表格(ref=ref18)的数据加载到表格(ref=ref18)中 当前需求和组件(ref=ref30)有关。
       */
      // 获取当前选中行的ID
      const currentRowId =
        this.Form1selectedRows1.length > 0 ? this.Form1selectedRows1[0] : null;
      if (currentRowId === null) {
        message.error("未选择任何行");
        return;
      }

      // 弹出确认对话框
      Modal.confirm({
        title: "确认删除",
        content: "您确定要删除这条记录吗？",
        onOk: async () => {
          try {
            // 逻辑删除当前行
            const response = await this.executeBackendInterface(
              "deleteCurrentRow",
              {
                id: parseInt(currentRowId),
                current: parseInt(this.Form1current1),
                pageSize: parseInt(this.Form1pageSize1),
              }
            );
            if (response.flag) {
              // 删除成功，更新前端数据
              this.Form1data1.dataSource = response.data.data.map((item) => ({
                id: item.id,
                serialNumber1: item.serial_number
                  ? item.serial_number.toString()
                  : "",
                inspectionNo: item.inspection_number,
                inspectionitems: item.inspection_item,
                exceptionType: item.anomaly_type,
                problemphoto: item.issue_photo,
                problemDescription: item.issue_description,
                inspectiondate1: item.inspection_date,
                inspectionyard1: item.parking_lot_name,
                patrolpersonnel1: item.inspector_name
                  ? item.inspector_name.toString()
                  : "",
                patrolinspectionstatus1: item.inspection_status,
                exceptionHandling1: item.anomaly_handling,
                processingphotos: item.handling_photo,
                handleperson: item.handler_name
                  ? item.handler_name.toString()
                  : "",
                operation1: item.operation,
              }));
              this.Form1total1 = response.data.total;
              message.success(response.message);

              // 重新加载表格数据
              await this.generalQueryInspectionTableData();
            } else {
              // 删除失败，提示错误信息
              message.error(response.message);
            }
          } catch (error) {
            // 处理请求错误
            message.error("删除失败，请稍后重试");
          }
        },
        onCancel: () => {
          // 取消删除操作
          message.info("已取消删除");
        },
      });
    },
    onTableChangeRef18(pagination) {
      /**
      根据分页信息显示对应页面数据,按照创建时间倒序显示 当前需求和组件(ref=ref18)有关。
      */
      // 更新当前页码和每页大小
      this.Form1current1 = parseInt(pagination.current); // 确保类型为Integer
      this.Form1pageSize1 = parseInt(pagination.pageSize); // 确保类型为Integer

      // 调用通用查询函数以更新表格数据
      this.generalQueryInspectionTableData();
    },
    async generalQueryInspectionTableData3J2() {
      try {
        // 获取搜索条件
        const params = {
          current: parseInt(this.Form1current1),
          // 确保类型为Integer
          pageSize: parseInt(this.Form1pageSize1),
          // 确保类型为Integer
          inspectionNo: this.SearchBoxform1.inspectionNo,
          patrolPersonnel: this.SearchBoxform1.patrolpersonnel,
          inspectionStatus: this.SearchBoxform1.patrolinspectionstatus,
          inspectionYard: this.SearchBoxform1.inspectionyard1,
          exceptionType: this.SearchBoxform1.exceptionType,
          exceptionHandling: this.SearchBoxform1.exceptionHandling,
          inspectionItems: this.SearchBoxform1.inspectionItems,
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryInspectionTableData",
          params
        );
        if (response.flag) {
          // 校验并转换数据格式
          const data = response.data.data.map((item) => ({
            id: item.id,
            inspectionNo: item.inspection_number,
            inspectionyard1: item.parking_lot_name,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1: item.inspector_name,
            exceptionType: item.anomaly_type,
            problemDescription: item.issue_description,
            patrolinspectionstatus1: item.inspection_status,
            exceptionHandling1: item.anomaly_handling,
            handleperson: item.handler_name,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1current1 = response.data.current;
          this.Form1pageSize1 = response.data.pageSize;
          this.Form1total1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询失败，请重试");
      }
    },
    initTableRef18() {
      /**
       * 进入页面后,将表格(ref=ref18)的数据加载到表格(ref=ref18)中；
       * 当前需求和组件(ref=ref18)有关。
       */
      this.generalQueryInspectionTableData();
    },
    async submitInspectionReportRef42() {
      /**
       * 将巡检上报(ref=ref42)填写的信息,对表格(ref=ref18)对应的行进行修改；查询表格(ref=ref18)中的数据加载到表格(ref=ref18) 当前需求和组件(ref=ref42)有关。
       */

      // 获取表单数据
      const formData = this.popupwindowform2;

      // 校验表单数据
      try {
        await this.$refs.ref42_form.validateFields();
      } catch (errorInfo) {
        message.error("表单校验失败，请检查输入");
        return;
      }

      // 准备请求参数
      const params = {
        inspectionNo1: formData.inspectionNo1,
        inspectionyard1: formData.inspectionyard1,
        inspectionitems1: formData.inspectionitems1,
        exceptionType1: formData.exceptionType1,
        handleperson: formData.handleperson
          ? parseInt(formData.handleperson)
          : null,
        // 确保handleperson是Integer类型
        problemDescription: formData.problemDescription,
        problempicture: Array.isArray(formData.problempicture)
          ? formData.problempicture
          : [],
        // 确保problempicture是List<String>类型
        inspectionInspectionStatus: formData.inspectionInspectionStatus,
        inspectionExceptionHandling: formData.inspectionExceptionHandling,
      };
      try {
        // 调用后端接口
        const response = await this.executeBackendInterface(
          "updateTableRowWithInspectionReport",
          params
        );
        if (response.flag) {
          // 更新表格数据
          this.Form1data1.dataSource = response.data.map((item) => ({
            id: item.id,
            serialNumber1:
              item.serial_number !== null ? item.serial_number.toString() : "",
            // 确保serialNumber1是字符串类型
            inspectionNo: item.inspection_number,
            inspectionyard1: item.inspection_site,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1:
              item.inspector_id !== null ? item.inspector_id.toString() : "",
            // 确保patrolpersonnel1是字符串类型
            exceptionType: item.anomaly_type,
            problemphoto: item.issue_photo,
            problemDescription: item.issue_description,
            patrolinspectionstatus1: item.inspection_status,
            exceptionHandling1: item.anomaly_handling,
            processingphotos: item.handling_photo,
            handleperson:
              item.handler_id !== null ? item.handler_id.toString() : "", // 确保handleperson是字符串类型
            // 其他字段根据需要进行映射
          }));

          // 更新总记录数
          this.Form1total1 = response.data.length;

          // 初始化巡检上报表单
          this.popupwindowform2 = {
            id: null,
            inspectionNo1: "",
            inspectionyard1: undefined,
            inspectionitems1: undefined,
            exceptionType1: undefined,
            handleperson: undefined,
            problemDescription: "",
            problempicture: [],
            inspectionInspectionStatus: "已巡检",
            inspectionExceptionHandling: "已处理",
          };
          message.success("更新成功");
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("更新失败，请重试");
      }

      // 重新查询表格数据
      this.generalQueryInspectionTableData();
    },
    async submitNewEntryDialogRef33() {
      /**
      将新增弹窗(ref=ref33)内的数据添加到表格(ref=ref18)中；查询表格(ref=ref18)的数据加载到表格(ref=ref18)中 当前需求和组件(ref=ref33)有关。
      */
      try {
        // 校验表单
        const values = await this.$refs.ref33_form.validateFields();

        // 调用后端接口，添加新记录
        const response = await this.executeBackendInterface(
          "addNewEntryToTable",
          {
            inspectionNo1: this.popupwindowform1.inspectionNo1,
            inspectionyard: this.popupwindowform1.inspectionyard,
            inspectionitems: this.popupwindowform1.inspectionitems,
            patrolpersonnel1: this.popupwindowform1.patrolpersonnel1
              ? parseInt(this.popupwindowform1.patrolpersonnel1)
              : undefined,
            // 确保类型匹配
            inspectiondate1: new Date(this.popupwindowform1.inspectiondate1),
            // 确保类型匹配
            newInspectionStatus: this.popupwindowform1.newInspectionStatus,
          }
        );

        // 检查接口调用结果
        if (response.flag) {
          // 更新表格数据
          this.Form1data1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1:
              item.serial_number !== undefined
                ? item.serial_number.toString()
                : "",
            // 确保serialNumber1是字符串
            inspectionNo: item.inspection_number,
            inspectionyard1: item.inspection_site,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1: item.patrol_personnel,
            patrolinspectionstatus1: item.inspection_status,
          }));

          // 更新总条数
          this.Form1total1 = response.data.total;

          // 初始化表单
          this.popupwindowform1 = {
            id: null,
            inspectionNo1: "",
            inspectionyard: undefined,
            inspectionitems: undefined,
            patrolpersonnel1: undefined,
            inspectiondate1: "",
            newInspectionStatus: "未巡检",
          };

          // 关闭弹窗
          this.popupwindowisShow1 = false;

          // 提示成功信息
          message.success("新增记录成功");

          // 刷新表格数据
          await this.generalQueryInspectionTableData();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        console.error("Failed:", error);
        message.error("表单校验失败或接口调用失败");
      }
    },
    async submitProcessingResultRef52() {
      /**
      将处理结果(ref=ref52)填写的数据,对表格(ref=ref18)中对应的行进行修改,查询表格(ref=ref18)中的数据加载到表格(ref=ref18)中 当前需求和组件(ref=ref52)有关。
      */
      try {
        // 获取表单数据
        const formData = this.popupwindowform3;

        // 检查并转换数据类型
        const inspectionNo1 = formData.inspectionNo1 || "";
        const inspectionyard1 = formData.inspectionyard1 || "";
        const inspectionitems1 = formData.inspectionitems1 || "";
        const handlers = formData.handlers || "";
        const processingPictures = Array.isArray(formData.processingPictures)
          ? formData.processingPictures.join(",")
          : "";
        const processingDate = formData.processingDate || "";
        const handlingExceptionHandling =
          formData.handlingExceptionHandling || "";
        const id = formData.id !== null ? parseInt(formData.id) : 0;
        const current = this.Form1current1;
        const pageSize = this.Form1pageSize1;

        // 调用后端接口更新数据
        const response = await this.executeBackendInterface(
          "updateTableRowWithProcessingResult",
          {
            inspectionNo1,
            inspectionyard1,
            inspectionitems1,
            handlers,
            processingPictures,
            processingDate,
            handlingExceptionHandling,
            id,
            current,
            pageSize,
          }
        );

        // 检查接口调用结果
        if (response.flag) {
          // 更新表格数据
          this.Form1data1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            serialNumber1:
              item.serial_number !== null ? item.serial_number.toString() : "",
            // 转换为字符串
            inspectionNo: item.inspection_number,
            inspectionyard1: item.inspection_site,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1:
              item.inspector_id !== null ? item.inspector_id.toString() : "",
            // 转换为字符串
            exceptionType: item.anomaly_type,
            problemphoto: item.issue_photo,
            problemDescription: item.issue_description,
            patrolinspectionstatus1: item.inspection_status,
            exceptionHandling1: item.anomaly_handling,
            processingphotos: item.handling_photo,
            handleperson:
              item.handler_id !== null ? item.handler_id.toString() : "",
            // 转换为字符串
            operation1: item.operation,
          }));

          // 更新总记录数
          this.Form1total1 = response.data.total;

          // 提示成功信息
          message.success("处理结果更新成功");
        } else {
          // 提示失败信息
          message.error(response.message);
        }
      } catch (error) {
        // 处理异常
        message.error("处理结果更新失败");
        console.error(error);
      }
    },
    searchTableRef6() {
      /**
      根据搜索区域(ref=ref3)中的字段查询表格(ref=ref18)中的数据,并将数据回显到表格(ref=ref18)中；
      巡检编号(ref=ref4)、巡检人员(ref=ref10)支持模糊查询 当前需求和组件(ref=ref6)有关。
      */
      // 获取搜索条件
      const params = {
        current: parseInt(this.Form1current1),
        // 确保类型为Integer
        pageSize: parseInt(this.Form1pageSize1),
        // 确保类型为Integer
        inspectionNo: this.SearchBoxform1.inspectionNo,
        patrolPersonnel: this.SearchBoxform1.patrolpersonnel,
        inspectionStatus: this.SearchBoxform1.patrolinspectionstatus,
        inspectionYard: this.SearchBoxform1.inspectionyard1,
        exceptionType: this.SearchBoxform1.exceptionType,
        exceptionHandling: this.SearchBoxform1.exceptionHandling,
        inspectionItems: this.SearchBoxform1.inspectionItems,
      };

      // 调用后端接口
      this.executeBackendInterface("generalQueryInspectionTableData", params)
        .then((response) => {
          if (response.flag) {
            // 校验并转换数据格式
            const data = response.data.data.map((item) => ({
              id: item.id,
              inspectionNo: item.inspection_number,
              inspectionyard1: item.parking_lot_name,
              inspectiondate1: item.inspection_date,
              inspectionitems: item.inspection_item,
              patrolpersonnel1: item.inspector_name,
              exceptionType: item.anomaly_type,
              problemDescription: item.issue_description,
              patrolinspectionstatus1: item.inspection_status,
              exceptionHandling1: item.anomaly_handling,
              handleperson: item.handler_name,
            }));

            // 更新表格数据
            this.Form1data1.dataSource = data;
            this.Form1current1 = response.data.current;
            this.Form1pageSize1 = response.data.pageSize;
            this.Form1total1 = response.data.total;
          } else {
            message.error(response.message);
          }
        })
        .catch((error) => {
          message.error("查询失败，请重试");
        });
    },
    async initInspectionPersonnelRef38() {
      /**
      进入页面后,数据来源于users表中的nick_name字段 当前需求和组件(ref=ref38)有关。
      */
      try {
        // 调用后端接口获取用户昵称数据
        const response = await this.executeBackendInterface(
          "getUserNickNames",
          {
            current: 1,
            // 假设获取第一页数据
            pageSize: 100,
            // 假设每页获取100条数据
            nickName: "", // 不进行模糊查询
          }
        );

        if (response.flag) {
          // 检查返回数据格式是否符合Patrolpersonneloptions1.dataSource的格式
          if (Array.isArray(response.data.data)) {
            this.Patrolpersonneloptions1.dataSource = response.data.data.map(
              (user) => ({
                label: user.nick_name,
                value: user.id,
                // 使用用户ID作为value
                disabled: false,
                select: false,
              })
            );
          } else {
            message.error("返回数据格式不正确");
          }
        } else {
          message.error("获取用户昵称失败: " + response.message);
        }
      } catch (error) {
        message.error("请求失败，请检查网络连接");
      }
    },
    async initParkingLotRef36() {
      /**
      进入页面后,数据来源于parking_lot_info表中的parking_lot_name字段 当前需求和组件(ref=ref36)有关。
      */
      try {
        // 调用后端接口获取停车场名称数据
        const response = await this.executeBackendInterface(
          "getParkingLotNames_xEw",
          {}
        );

        // 检查接口返回的flag是否为true
        if (response.flag) {
          // 确保接口返回的数据存在且为数组
          if (Array.isArray(response.data)) {
            // 将接口返回的数据格式化为组件需要的格式
            this.Inspectionyardoptions1.dataSource = response.data.map(
              (item) => ({
                label: item.label,
                value: item.key,
                // 确保 value 属性赋值为 key
                disabled: false,
                select: false,
              })
            );
          } else {
            message.error("返回数据格式不正确");
          }
        } else {
          // 如果接口返回失败，显示错误信息
          message.error(response.message);
        }
      } catch (error) {
        // 捕获并处理请求错误
        message.error("获取停车场信息失败");
      }
    },
    showNewEntryDialogRef15() {
      /**
      显示新增弹窗(ref=ref33),并生成当前时间时间戳,填入巡检编号(ref=ref34) 当前需求和组件(ref=ref15)有关。
      */

      // 显示新增弹窗
      this.popupwindowisShow1 = true;

      // 生成当前时间时间戳
      const timestamp = Date.now();

      // 填入巡检编号
      if (timestamp) {
        this.popupwindowform1.inspectionNo1 = timestamp.toString();
      }
    },
    cancelInspectionReportRef42() {
      /**
      不做校验,并关闭巡检上报(ref=ref42) 当前需求和组件(ref=ref42)有关。
      */
      // 弹出确认对话框
      Modal.confirm({
        title: "确认取消",
        content: "您确定要取消该巡检记录吗？",
        onOk: () => {
          // 直接关闭弹窗
          this.popupwindowisShow2 = false;
          message.success("巡检记录已取消");
        },
        onCancel: () => {
          // 取消操作，无需处理
        },
      });
    },
    cancelNewEntryDialogRef33() {
      /**
      不做校验,并关闭当前新增弹窗(ref=ref33) 当前需求和组件(ref=ref33)有关。
      */
      // 关闭弹窗
      this.popupwindowisShow1 = false;

      // 初始化表单数据
      this.popupwindowform1 = {
        id: null,
        inspectionNo1: "",
        inspectionyard: undefined,
        inspectionitems: undefined,
        patrolpersonnel1: undefined,
        inspectiondate1: "",
        newInspectionStatus: "未巡检",
      };
    },
    cancelProcessingResultRef52() {
      /**
      关闭处理结果(ref=ref52) 当前需求和组件(ref=ref52)有关。
      */
      // 弹出确认对话框
      Modal.confirm({
        title: "确认取消",
        content: "您确定要取消处理结果吗？",
        onOk: async () => {
          try {
            // 由于后端接口文档中具体内容为无，因此无需调用后端接口
            // 直接关闭弹窗
            this.popupwindowisShow3 = false;
            message.success("处理结果已取消");
          } catch (error) {
            message.error("操作失败，请稍后重试");
          }
        },
        onCancel: () => {
          // 取消操作
        },
      });
    },
    async showInspectionReportRef21() {
      /**
      显示巡检上报(ref=ref42),并将当前行数据加载到巡检上报(ref=ref42)中 当前需求和组件(ref=ref21)有关。
      */
      try {
        // 调用后端接口获取巡检记录详细信息
        const response = await this.executeBackendInterface(
          "showInspectionReportRef21",
          {
            inspectionNo1: this.popupwindowform2.inspectionNo1 || "",
            inspectionyard1: this.popupwindowform2.inspectionyard1 || "",
            inspectionitems1: this.popupwindowform2.inspectionitems1 || "",
            exceptionType1: this.popupwindowform2.exceptionType1 || "",
            handleperson: this.popupwindowform2.handleperson || "",
          }
        );
        if (response.flag) {
          const data = response.data;
          // 将返回的数据加载到表单中
          this.popupwindowform2 = {
            id: data.id,
            inspectionNo1: data.inspection_number,
            inspectionyard1: data.parking_lot_name,
            // 直接使用车场名称
            inspectionitems1: data.inspection_item,
            exceptionType1: data.anomaly_type,
            handleperson: data.handler_name,
            // 直接使用处理人名称
            problemDescription: data.issue_description,
            problempicture: data.issue_photo ? [data.issue_photo] : [],
            inspectionInspectionStatus: data.inspection_status,
            inspectionExceptionHandling: data.anomaly_handling,
          };
          // 显示巡检上报弹窗
          this.popupwindowisShow2 = true;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取巡检记录失败");
      }
    },
    async showProcessingResultRef31() {
      /**
      显示处理结果(ref=ref52),并将当前行数据加载到处理结果(ref=ref52)中 当前需求和组件(ref=ref31)有关。
      */
      try {
        // 获取当前行的巡检编号
        const inspectionNumber = this.popupwindowform3.inspectionNo1;

        // 调用后端接口获取处理结果
        const response = await this.executeBackendInterface(
          "showProcessingResultRef31",
          {
            inspectionNo: inspectionNumber,
          }
        );
        if (response.flag) {
          const data = response.data;

          // 将返回的数据加载到处理结果中
          this.popupwindowform3.id = data.id;
          this.popupwindowform3.inspectionNo1 = data.inspection_number;
          this.popupwindowform3.inspectionyard1 = data.parking_lot_name; // 使用车场名称
          this.popupwindowform3.inspectionitems1 = data.inspection_item;
          this.popupwindowform3.handlers = data.handler_name; // 使用处理人昵称
          this.popupwindowform3.processingPictures = data.handling_photo
            ? [data.handling_photo]
            : [];
          this.popupwindowform3.processingDate = data.handling_date
            ? new Date(data.handling_date).toISOString().split("T")[0]
            : "";

          // 显示处理结果弹窗
          this.popupwindowisShow3 = true;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取处理结果失败");
      }
    },
    async listenToExceptionTypeRef62() {
      /**
      当异常类型(ref=ref46)中为“无异常”时,巡检-巡检状态(ref=ref62)改为“无异常” 当前需求和组件(ref=ref62)有关。当前需求是个监听类型需求。
      */
      // 该方法的具体实现已在watch中处理
    },
    async listenToExceptionTypeRef63() {
      /**
       * 当异常类型(ref=ref46)中为“无异常”时,巡检-异常处理(ref=ref63)改为空值 当前需求和组件(ref=ref63)有关。当前需求是个监听类型需求。
       */
      try {
        // 确保id为Integer类型
        const id = parseInt(this.popupwindowform2.id, 10);

        // 检查id是否为有效的整数
        if (isNaN(id)) {
          message.error("无效的ID");
          return;
        }

        // 调用后端接口，更新异常处理字段为空
        const response = await this.executeBackendInterface(
          "listenToExceptionTypeRef63",
          {
            exceptionType1: this.popupwindowform2.exceptionType1,
            id: id,
          }
        );
        if (response.flag) {
          // 更新成功，将异常处理字段设置为空
          this.popupwindowform2.inspectionExceptionHandling = "";
          message.success(response.message);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("请求失败，请重试");
      }
    },
    async generalQueryInspectionTableDataIIJ() {
      /**
       * 该接口用于查询巡检表格(ref=ref18)中的数据，支持以下功能：
       * 1. 初始化表格数据：在页面加载时，获取并显示表格的初始数据。
       * 2. 分页查询：支持根据页码(current)和每页大小(pageSize)进行分页查询，并返回总条目数(total)。
       * 3. 条件查询：根据搜索区域(ref=ref3)中的字段进行条件查询，支持巡检编号和巡检人员的模糊查询。
       * 4. 数据刷新：在数据更新(如删除、添加、修改)后，重新查询并刷新表格数据。
       * 5. 排序：查询结果按照巡检时间倒序显示。
       * 6. 数据导出：支持导出表格中前1000条数据为.xlsx格式。
       */

      try {
        // 获取搜索条件
        const params = {
          current: parseInt(this.Form1current1),
          // 确保类型为Integer
          pageSize: parseInt(this.Form1pageSize1),
          // 确保类型为Integer
          inspectionNo: this.SearchBoxform1.inspectionNo,
          patrolPersonnel: this.SearchBoxform1.patrolpersonnel,
          inspectionStatus: this.SearchBoxform1.patrolinspectionstatus,
          inspectionYard: this.SearchBoxform1.inspectionyard1,
          exceptionType: this.SearchBoxform1.exceptionType,
          exceptionHandling: this.SearchBoxform1.exceptionHandling,
          inspectionItems: this.SearchBoxform1.inspectionItems,
        };

        // 调用后端接口
        const response = await this.executeBackendInterface(
          "generalQueryInspectionTableData",
          params
        );
        if (response.flag) {
          // 校验并转换数据格式
          const data = response.data.data.map((item) => ({
            id: item.id,
            inspectionNo: item.inspection_number,
            inspectionyard1: item.parking_lot_name,
            inspectiondate1: item.inspection_date,
            inspectionitems: item.inspection_item,
            patrolpersonnel1: item.inspector_name,
            exceptionType: item.anomaly_type,
            problemDescription: item.issue_description,
            patrolinspectionstatus1: item.inspection_status,
            exceptionHandling1: item.anomaly_handling,
            handleperson: item.handler_name,
          }));

          // 更新表格数据
          this.Form1data1.dataSource = data;
          this.Form1current1 = response.data.current;
          this.Form1pageSize1 = response.data.pageSize;
          this.Form1total1 = response.data.total;
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
        const pageUuid = "1869338166138241024";
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
          .post("./WebInspectionofcaryard/" + funcName, params, {
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
    // 页面加载时调用initParkingLotRef27函数
    this.initParkingLotRef27();
    // 初始化时调用查询函数
    this.generalQueryInspectionTableData();
    // 初始化时调用查询函数
    this.generalQueryInspectionTableData();
    this.initTableRef18();
    this.initInspectionPersonnelRef38();
    // 在组件挂载时调用initParkingLotRef36函数
    this.initParkingLotRef36();
    // 初始化时调用查询函数
    this.generalQueryInspectionTableData();
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
@import "/public/css/web/vue/antdesign/YtPicture/default";
@import "/public/css/web/vue/antdesign/YtModal/default";
@import "/public/css/web/vue/antdesign/YtDatePicker/default";
@import "/public/css/web/vue/antdesign/YtTextArea/default";
@import "/public/css/web/vue/antdesign/YtUploadButton/default";
@import "/public/css/车场巡检/theme";

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amm7klv
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amm7klv
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-am7x38e {
  color: #333333 !important;
  background: #ffffff !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-am5mnl4 {
  background: #1890ff !important;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-amy60y5
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtRangePickerFormItem.webVueAntYtRangePickerFormItem-amy60y5
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amude31
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amude31
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amsrszu
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 .ant-table {
  border-right: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-thead
  tr,
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-thead
  tr
  th
  div:first-child {
  height: 48px;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 48px;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-thead
  tr
  th {
  background: #eaeef3;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-thead
  tr
  span.th-text {
  font-size: 16px;
  font-weight: bold;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 .ant-table tbody tr td {
  height: 48px;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  tbody
  tr
  td
  .ant-checkbox-wrapper {
  line-height: 48px;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  thead
  tr
  th:not(:last-child),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  .ant-table
  .ant-table-tbody
  tr
  td:not(:last-child) {
  border-right: 0px solid #dcdcdc;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(2),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(2),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(2) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(3),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(3),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(3) {
  width: 160px !important;
  min-width: 160px !important;
  max-width: 160px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(4),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(4),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(4) {
  width: 200px !important;
  min-width: 200px !important;
  max-width: 200px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(5),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(5),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(5) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(6),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(6),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(6) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(7),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(7),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(7) {
  width: 90px !important;
  min-width: 90px !important;
  max-width: 90px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(8),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(8),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(8) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(9),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(9),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(9) {
  width: 76px !important;
  min-width: 76px !important;
  max-width: 76px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(10),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(10),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(10) {
  width: 200px !important;
  min-width: 200px !important;
  max-width: 200px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(11),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(11),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(11) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(12),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(12),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(12) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(13),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(13),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(13) {
  width: 76px !important;
  min-width: 76px !important;
  max-width: 76px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(14),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(14),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(14) {
  width: calc((100% - 955px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
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

.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37 tr > th:nth-child(15),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-measure-row
  td:nth-child(15),
.webVueAntYtTableStyle.webVueAntYtTableStyle-amzzc37
  tbody
  tr.ant-table-row
  td:nth-child(15) {
  width: 105px !important;
  min-width: 105px !important;
  max-width: 105px !important;
}

.webVueAntYtRectangleStyle.webVueAntYtRectangleStyle-am1covf {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-amfwf68-1 {
  color: #1890ff !important;
  background: transparent !important;
}

.webVueAntYtButtonStyle-amfwf68-2-3 {
  color: #1890ff !important;
  background: transparent !important;
}

.webVueAntYtButtonStyle.webVueAntYtButtonStyle-ami94ab {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 1px solid #f84c55;
  border-right: 1px solid #f84c55;
  border-bottom: 1px solid #f84c55;
  border-left: 1px solid #f84c55;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amf038s
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amuu6rf
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amv560x
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtButtonStyle-amnotcx-1-2-3 {
  color: #f84c55 !important;
  background: transparent !important;
}

.webVueAntYtButtonStyle-amijehr-1 {
  color: #1890ff !important;
  background: transparent !important;
}

.webVueAntYtButtonStyle-amijehr-2 {
  color: #1890ff !important;
  background: transparent !important;
}

.webVueAntYtButtonStyle-amijehr-3 {
  color: #1890ff !important;
  background: transparent !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amws1du
  .ant-form-item-label
  label {
  width: 81px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-ameo81b
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-am3eumh:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-am3eumh.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amp846z
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amkmwhd
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amqhivx
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtDatePickerFormItem.webVueAntYtDatePickerFormItem-amrvly6
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amjmjsd
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amk5g8d:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amk5g8d.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amowwcd
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtSelectStyle.webVueAntYtSelectStyle-amov8tb .ant-select-selector {
  background: #f0f2f5 !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amfdrgj
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtSelectStyle.webVueAntYtSelectStyle-amdfyux .ant-select-selector {
  background: #f0f2f5 !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amjk3my
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amv15ps
  .ant-form-item-label
  label {
  width: 77px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amv15ps
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtTextAreaFormItem.webVueAntYtTextAreaFormItem-amxeifh
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtTextAreaStyle.webVueAntYtTextAreaStyle-amlidk2.ant-input-textarea,
.webVueAntYtTextAreaStyle.webVueAntYtTextAreaStyle-amlidk2.ant-input {
  background: #ffffff !important;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd !important;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
  box-shadow: 0px 0px 0px 0px transparent !important;
}

.webVueAntUploadButtonFormItem.webVueAntUploadButtonFormItem-amtp5cx
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntUploadButtonFormItem.webVueAntUploadButtonFormItem-amtp5cx.row
  .ant-form-item-control {
  width: calc(100% - 80px);
}

.webVueAntUploadButtonStyle.webVueAntUploadButtonStyle-amthbmh .ant-btn {
  background: #ffffff;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-am7vf7x
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amdopwq:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amdopwq.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amxw1o3
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtSelectStyle.webVueAntYtSelectStyle-am4posk .ant-select-selector {
  background: #f0f2f5 !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amak02l
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtSelectStyle.webVueAntYtSelectStyle-ambwqoq .ant-select-selector {
  background: #f0f2f5 !important;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amhz2l4
  .ant-form-item-label
  label {
  width: 91px;
}

.webVueAntYtSelectFormItem.webVueAntYtSelectFormItem-amhz2l4
  .ant-form-item-label
  label
  .label-content {
  text-align: right;
  text-align-last: right;
}

.webVueAntYtSelectStyle.webVueAntYtSelectStyle-amba0yl .ant-select-selector {
  background: #f0f2f5 !important;
}

.webVueAntUploadButtonFormItem.webVueAntUploadButtonFormItem-amzytlu
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntUploadButtonFormItem.webVueAntUploadButtonFormItem-amzytlu.row
  .ant-form-item-control {
  width: calc(100% - 80px);
}

.webVueAntUploadButtonStyle.webVueAntUploadButtonStyle-amcyrk2 .ant-btn {
  background: #ffffff;
}

.webVueAntYtDatePickerFormItem.webVueAntYtDatePickerFormItem-am0s2pd
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-ambeozq
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amsri2j:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amsri2j.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amso4j5
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amtrjxa:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amtrjxa.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-am8wq01
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amcrwnl:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amcrwnl.ant-input-affix-wrapper {
  background: #f0f2f5;
}

.webVueAntYtInputFormItem.webVueAntYtInputFormItem-amfeow0
  .ant-form-item-label
  label {
  width: 80px;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amwsyj7:not(
    .ant-input-affix-wrapper
  ) {
  background: #f0f2f5 !important;
}

.webVueAntYtInputStyle.webVueAntYtInputStyle-amwsyj7.ant-input-affix-wrapper {
  background: #f0f2f5;
}
</style>
