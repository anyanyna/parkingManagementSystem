<template>
  <yt-grid previewType="AdaptiveWH" width="1700" height="1016" background="#F0F2F5">
    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.60000%"
      left="1.20000%"
      bottom="1.00000%"
      right="2.50000%"
      gridColumnStart="2"
      gridColumnEnd="16"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref4"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-inga5ez webVueAntYtRectangleStyle-in webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="5.00000%"
      left="16.40000%"
      bottom="12.50000%"
      right="8.20000%"
      gridColumnStart="17"
      gridColumnEnd="22"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref6"
        @click="
          () => {
            showAddOrganizationModal();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-in7jdz4 webVueAntYtButtonStyle-in webVueAntYtButtonStyle center-in center"
        :loading="Newloading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="AddedOrganizationPopupWindowisShow1"
      top="0.60000%"
      left="1.60000%"
      bottom="0.50000%"
      right="1.40000%"
      gridColumnStart="37"
      gridColumnEnd="65"
      gridRowStart="19"
      gridRowEnd="78"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref11"
        @ok="
          () => {
            handleAddOrganization();
          }
        "
        @cancel="
          () => {
            closeAddOrganizationModal();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-in webVueAntYtModalStyle"
        v-model:isShow="AddedOrganizationPopupWindowisShow1"
        :title="'新增组织机构'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="AddedOrganizationPopupWindowform1"
            ref="ref11_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="ParentorganizationisShow1"
                top="12.20000%"
                left="0.50000%"
                bottom="5.50000%"
                right="1.00000%"
                gridColumnStart="6"
                gridColumnEnd="87"
                gridRowStart="7"
                gridRowEnd="15"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref12"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-in1pvzb webVueAntYtTreeSelectFormItem-in webVueAntYtTreeSelectFormItem show-label-in show-label"
                  name="Parentorganizationvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'上级组织机构：'">
                      </span>
                    </div>
                  </template>
                  <a-tree-select
                    @click="
                      () => {
                        initParentOrganizationSelect();
                      }
                    "
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-in webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="
                      AddedOrganizationPopupWindowform1.Parentorganizationvalue1
                    "
                    :placeholder="'请输入'"
                    :treeData="ParentorganizationtreeData1.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="11.40000%"
                left="0.00000%"
                bottom="6.30000%"
                right="0.70000%"
                gridColumnStart="4"
                gridColumnEnd="87"
                gridRowStart="20"
                gridRowEnd="28"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref13"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-in8h3dy webVueAntYtInputFormItem-in webVueAntYtInputFormItem show-label-in show-label"
                  name="OrganizationNamevalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构名称：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-inauzg7 webVueAntYtInputStyle-in webVueAntYtInputStyle"
                    v-model:value="
                      AddedOrganizationPopupWindowform1.OrganizationNamevalue1
                    "
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="PersoninchargeoforganizationisShow1"
                top="10.60000%"
                left="0.00000%"
                bottom="7.10000%"
                right="0.70000%"
                gridColumnStart="4"
                gridColumnEnd="87"
                gridRowStart="33"
                gridRowEnd="41"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref15"
                  class="webVueSelectFormItem webVueAntYtSelectFormItem-inxcrdw webVueAntYtSelectFormItem-in webVueAntYtSelectFormItem show-label-in show-label"
                  name="Personinchargeoforganizationvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构负责人：'">
                      </span>
                    </div>
                  </template>
                  <a-select
                    @click="
                      () => {
                        initPersonInChargeSelect();
                      }
                    "
                    class="webVueSelect webVueAntYtSelectStyle-in webVueAntYtSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="
                      AddedOrganizationPopupWindowform1.Personinchargeoforganizationvalue1
                    "
                    :placeholder="'请输入'"
                    :mode="'single'"
                    :options="Personinchargeoforganizationoptions1.dataSource"
                    :showSearch="true"
                  >
                  </a-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="9.80000%"
                left="1.10000%"
                bottom="7.90000%"
                right="0.80000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="46"
                gridRowEnd="54"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref16"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-ink97xk webVueAntYtInputNumberFormItem-in webVueAntYtInputNumberFormItem show-label-in show-label"
                  name="Sortvalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'排序：'"> </span>
                    </div>
                  </template>
                  <a-input-number
                    data-event
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-ineyekt webVueAntYtInputNumberStyle-in webVueAntYtInputNumberStyle"
                    v-model:value="AddedOrganizationPopupWindowform1.Sortvalue1"
                    :placeholder="'请输入'"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.00000%"
                left="1.10000%"
                bottom="0.90000%"
                right="1.20000%"
                gridColumnStart="17"
                gridColumnEnd="87"
                gridRowStart="59"
                gridRowEnd="90"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref28"
                  class="webVueAntTextAreaFormItem webVueAntYtTextAreaFormItem-init3hd webVueAntYtTextAreaFormItem-in webVueAntYtTextAreaFormItem show-label-in show-label"
                  name="Remarkvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'备注：'"> </span>
                    </div>
                  </template>
                  <a-textarea
                    data-event
                    class="webVueAntTextarea webVueAntYtTextAreaStyle-in5k9s1 webVueAntYtTextAreaStyle-in webVueAntYtTextAreaStyle"
                    v-model:value="AddedOrganizationPopupWindowform1.Remarkvalue1"
                    :placeholder="'请输入'"
                    :maxLength="100"
                  >
                  </a-textarea>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrganizationisShow1"
      top="0.80000%"
      left="2.90000%"
      bottom="0.00000%"
      right="4.40000%"
      gridColumnStart="3"
      gridColumnEnd="15"
      gridRowStart="9"
      gridRowEnd="95"
      zIndex="2"
      previewType="AdaptiveWH"
    >
      <yt-tree
        ref="ref23"
        @select="
          () => {
            Listoforganizationscurrent2 = 1
            initOrganizationTree();
            loadChildOrganizations();
          }
        "
        class="webVueAntYtTree webVueAntYtTreeStyle-intbcuh webVueAntYtTreeStyle-in webVueAntYtTreeStyle"
        v-model:expandedKeys="OrganizationexpandedKeys1"
        v-model:selectedKeys="OrganizationselectedKeys1"
        :showIcon="true"
        :switcherIcon="'./staticResource/public/switchIcon.svg'"
        :lineHeight="'1.2'"
        :options="Organizationoptions1.dataSource"
        :selectedBackgroundColor="{
          type: 'pure',
          color: '#E6EFFE',
          image: 'none',
          repeat: 'no-repeat',
          align: 'center',
        }"
        :selectedTextColor="{
          type: 'pure',
          color: '#595959',
          image: 'none',
          repeat: 'no-repeat',
          align: 'center',
        }"
        :hoverBackgroundColor="{
          type: 'pure',
          color: '#f5f5f5',
          image: 'none',
          repeat: 'no-repeat',
          align: 'center',
        }"
        :hoverTextColor="{
          type: 'pure',
          color: 'rgba(0, 0, 0, 0.88)',
          image: 'none',
          repeat: 'no-repeat',
          align: 'center',
        }"
      >
      </yt-tree>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="EditOrganizationpopupwindowisShow1"
      top="0.60000%"
      left="0.80000%"
      bottom="0.60000%"
      right="2.30000%"
      gridColumnStart="39"
      gridColumnEnd="67"
      gridRowStart="22"
      gridRowEnd="81"
      zIndex="9"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref29"
        @ok="
          () => {
            handleEditOrganization();
          }
        "
        @cancel="
          () => {
            closeEditOrganizationModal();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-in webVueAntYtModalStyle"
        v-model:isShow="EditOrganizationpopupwindowisShow1"
        :title="'编辑组织机构'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="EditOrganizationpopupwindowform1"
            ref="ref29_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="ParentorganizationisShow2"
                top="12.20000%"
                left="0.50000%"
                bottom="5.50000%"
                right="1.00000%"
                gridColumnStart="6"
                gridColumnEnd="87"
                gridRowStart="7"
                gridRowEnd="15"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref30"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-inp8avp webVueAntYtTreeSelectFormItem-in webVueAntYtTreeSelectFormItem show-label-in show-label"
                  name="Parentorganizationvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'上级组织机构：'">
                      </span>
                    </div>
                  </template>
                  <a-tree-select
                    @click="
                      () => {
                        initEditParentOrganizationSelect();
                      }
                    "
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-in webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="
                      EditOrganizationpopupwindowform1.Parentorganizationvalue2
                    "
                    :placeholder="'请输入'"
                    :treeData="ParentorganizationtreeData2.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="11.40000%"
                left="0.00000%"
                bottom="6.30000%"
                right="0.70000%"
                gridColumnStart="4"
                gridColumnEnd="87"
                gridRowStart="20"
                gridRowEnd="28"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref31"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-in1bmfx webVueAntYtInputFormItem-in webVueAntYtInputFormItem show-label-in show-label"
                  name="OrganizationNamevalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构名称：'">
                      </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-inl4l80 webVueAntYtInputStyle-in webVueAntYtInputStyle"
                    v-model:value="
                      EditOrganizationpopupwindowform1.OrganizationNamevalue2
                    "
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="PersoninchargeoforganizationisShow2"
                top="10.60000%"
                left="0.00000%"
                bottom="7.10000%"
                right="0.70000%"
                gridColumnStart="4"
                gridColumnEnd="87"
                gridRowStart="33"
                gridRowEnd="41"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref32"
                  class="webVueSelectFormItem webVueAntYtSelectFormItem-in6sgfv webVueAntYtSelectFormItem-in webVueAntYtSelectFormItem show-label-in show-label"
                  name="Personinchargeoforganizationvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构负责人：'">
                      </span>
                    </div>
                  </template>
                  <a-select
                    @click="
                      () => {
                        loadSystemUsersForSelect();
                      }
                    "
                    class="webVueSelect webVueAntYtSelectStyle-in webVueAntYtSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="
                      EditOrganizationpopupwindowform1.Personinchargeoforganizationvalue2
                    "
                    :placeholder="'请输入'"
                    :mode="'single'"
                    :options="Personinchargeoforganizationoptions2.dataSource"
                    :showSearch="true"
                  >
                  </a-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="9.80000%"
                left="1.10000%"
                bottom="7.90000%"
                right="0.80000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="46"
                gridRowEnd="54"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref33"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-intaho2 webVueAntYtInputNumberFormItem-in webVueAntYtInputNumberFormItem show-label-in show-label"
                  name="Sortvalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'排序：'"> </span>
                    </div>
                  </template>
                  <a-input-number
                    data-event
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-incuu63 webVueAntYtInputNumberStyle-in webVueAntYtInputNumberStyle"
                    v-model:value="EditOrganizationpopupwindowform1.Sortvalue2"
                    :placeholder="'请输入'"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="3.00000%"
                left="1.10000%"
                bottom="0.90000%"
                right="1.20000%"
                gridColumnStart="17"
                gridColumnEnd="87"
                gridRowStart="59"
                gridRowEnd="90"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref34"
                  class="webVueAntTextAreaFormItem webVueAntYtTextAreaFormItem-inkscyi webVueAntYtTextAreaFormItem-in webVueAntYtTextAreaFormItem show-label-in show-label"
                  name="Remarkvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'备注：'"> </span>
                    </div>
                  </template>
                  <a-textarea
                    data-event
                    class="webVueAntTextarea webVueAntYtTextAreaStyle-in90cit webVueAntYtTextAreaStyle-in webVueAntYtTextAreaStyle"
                    v-model:value="EditOrganizationpopupwindowform1.Remarkvalue2"
                    :placeholder="'请输入'"
                    :maxLength="100"
                  >
                  </a-textarea>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="58.00px"
      top="19.10000%"
      left="4.40000%"
      bottom="15.20000%"
      right="10.20000%"
      gridColumnStart="2"
      gridColumnEnd="6"
      gridRowStart="2"
      gridRowEnd="5"
      zIndex="3"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref35"
        class="webVueAntYtSpan webVueAntYtSpanStyle-inxepf2 webVueAntYtSpanStyle-in webVueAntYtSpanStyle null-in null"
      >
        <span v-html="'组织机构'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.60000%"
      left="0.90000%"
      bottom="0.90000%"
      right="0.90000%"
      gridColumnStart="16"
      gridColumnEnd="101"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref39"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-inx6oeq webVueAntYtRectangleStyle-in webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="ListoforganizationsisShow1"
      top="0.90000%"
      left="0.90000%"
      bottom="1.00000%"
      right="0.90000%"
      gridColumnStart="17"
      gridColumnEnd="100"
      gridRowStart="11"
      gridRowEnd="98"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref42"
        @onTableChange="
          (pagination) => {
            Listoforganizationscurrent2 = pagination.current
            refreshTable();
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-indhu88 webVueAntYtTableStyle-in webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="ListoforganizationsselectedRows1"
        v-model:total="Listoforganizationstotal1"
        v-model:current="Listoforganizationscurrent2"
        v-model:pageSize="ListoforganizationspageSize1"
        :columns="Listoforganizationsdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="Listoforganizationsdata1.dataSource"
        :scroll="{ y: 753.9999829446688 }"
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'operation1'" :forKey="'operation1'">
            <div style="width: 100%; height: 100%; background: #fff; display: flex">
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6.5px;
                  width: 32.65%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref44"
                  @click="
                    () => {
                      deleteOrganization(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-inhcadp webVueAntYtButtonStyle center"
                  :loading="Deleteloading2"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </div>

              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6.5px;
                  width: 35.71%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref45"
                  @click="
                    () => {
                      showEditOrganizationModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-insd96s webVueAntYtButtonStyle center"
                  :loading="Editloading2"
                >
                  <span class="yt-button-content" v-html="'编辑'"> </span>
                </a-button>
              </div>
            </div>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="58.00px"
      top="30.10000%"
      left="8.80000%"
      bottom="4.10000%"
      right="5.80000%"
      gridColumnStart="3"
      gridColumnEnd="7"
      gridRowStart="6"
      gridRowEnd="9"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref46"
        class="webVueAntYtSpan webVueAntYtSpanStyle-ingr0os webVueAntYtSpanStyle-in webVueAntYtSpanStyle webVueAntYtSpanBrCount-in webVueAntYtSpanBrCount"
      >
        <span v-html="'组织机构'"> </span>
      </span>
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
      AddedOrganizationPopupWindowisShow1: false,
      AddedOrganizationPopupWindowform1: {
        id: null,
        Parentorganizationvalue1: "",
        OrganizationNamevalue1: "",
        Personinchargeoforganizationvalue1: undefined,
        Sortvalue1: null,
        Remarkvalue1: "",
      },
      ParentorganizationtreeData1: {
        dataSource: [
          {
            label: "一级选项1",
            value: "一级选项1",
            disabled: false,
            select: false,
            children: [
              {
                label: "二级选项1",
                value: "二级选项1",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项1",
                    value: "三级选项1",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项2",
                    value: "三级选项2",
                    disabled: false,
                    select: false,
                  },
                ],
              },
              {
                label: "二级选项2",
                value: "二级选项2",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项3",
                    value: "三级选项3",
                    disabled: false,
                    select: false,
                  },
                ],
              },
              {
                label: "二级选项3",
                value: "二级选项3",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项4",
                    value: "三级选项4",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项5",
                    value: "三级选项5",
                    disabled: false,
                    select: false,
                  },
                ],
              },
            ],
          },
        ],
        value: {
          selectActive: "",
          selectData: [],
          disableData: [],
          disableActive: "",
        },
      },
      ParentorganizationisShow1: true,
      Personinchargeoforganizationoptions1: {
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
      PersoninchargeoforganizationisShow1: true,
      OrganizationselectedKeys1: [],
      OrganizationexpandedKeys1: [],
      Organizationoptions1: {
        dataSource: [
          {
            title: "一级选项1",
            key: "一级选项1",
            disabled: false,
            select: false,
            iconUrl: "./staticResource/public/folder.svg",
            children: [
              {
                title: "二级选项1",
                key: "二级选项1",
                disabled: false,
                select: false,
                iconUrl: "./staticResource/public/folder.svg",
                children: [
                  {
                    title: "三级选项1",
                    key: "三级选项1",
                    disabled: false,
                    select: false,
                    iconUrl: "./staticResource/public/leaf.svg",
                  },
                  {
                    title: "三级选项2",
                    key: "三级选项2",
                    disabled: false,
                    select: false,
                    iconUrl: "./staticResource/public/leaf.svg",
                  },
                ],
              },
              {
                title: "二级选项2",
                key: "二级选项2",
                disabled: false,
                select: false,
                iconUrl: "./staticResource/public/folder.svg",
                children: [
                  {
                    title: "三级选项3",
                    key: "三级选项3",
                    disabled: false,
                    select: false,
                    iconUrl: "./staticResource/public/leaf.svg",
                  },
                ],
              },
              {
                title: "二级选项3",
                key: "二级选项3",
                disabled: false,
                select: false,
                iconUrl: "./staticResource/public/folder.svg",
                children: [
                  {
                    title: "三级选项4",
                    key: "三级选项4",
                    disabled: false,
                    select: false,
                    iconUrl: "./staticResource/public/leaf.svg",
                  },
                  {
                    title: "三级选项5",
                    key: "三级选项5",
                    disabled: false,
                    select: false,
                    iconUrl: "./staticResource/public/leaf.svg",
                  },
                ],
              },
            ],
          },
        ],
        value: {
          selectActive: "",
          selectData: [],
          disableData: [],
          disableActive: "",
        },
      },
      OrganizationisShow1: true,
      Newloading1: false,
      ParentorganizationtreeData2: {
        dataSource: [
          {
            label: "一级选项1",
            value: "一级选项1",
            disabled: false,
            select: false,
            children: [
              {
                label: "二级选项1",
                value: "二级选项1",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项1",
                    value: "三级选项1",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项2",
                    value: "三级选项2",
                    disabled: false,
                    select: false,
                  },
                ],
              },
              {
                label: "二级选项2",
                value: "二级选项2",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项3",
                    value: "三级选项3",
                    disabled: false,
                    select: false,
                  },
                ],
              },
              {
                label: "二级选项3",
                value: "二级选项3",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项4",
                    value: "三级选项4",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项5",
                    value: "三级选项5",
                    disabled: false,
                    select: false,
                  },
                ],
              },
            ],
          },
        ],
        value: {
          selectActive: "",
          selectData: [],
          disableData: [],
          disableActive: "",
        },
      },
      ParentorganizationisShow2: true,
      Personinchargeoforganizationoptions2: {
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
      PersoninchargeoforganizationisShow2: true,
      EditOrganizationpopupwindowisShow1: false,
      EditOrganizationpopupwindowform1: {
        id: null,
        Parentorganizationvalue2: [],
        OrganizationNamevalue2: "",
        Personinchargeoforganizationvalue2: undefined,
        Sortvalue2: null,
        Remarkvalue2: "",
      },
      ListoforganizationscurrentRow1: {},
      ListoforganizationsselectedRows1: [],
      ListoforganizationspageSize1: 10,
      Listoforganizationsdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "sort",
            title: "排序",
            dataIndex: "sort",
            width: undefined,
          },
          {
            key: "organizationName",
            title: "组织机构名称",
            dataIndex: "organizationName",
          },
          {
            key: "personinchargeoforganization",
            title: "组织机构负责人",
            dataIndex: "personinchargeoforganization",
          },
          {
            key: "remarks",
            title: "备注",
            dataIndex: "remarks",
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
            no: "1",
            identityCard: "",
            operation1: "",
            sort: "",
            organizationName: "",
          },
          {
            id: 2,
            no: "2",
            sort: "",
          },
          {
            id: 8,
            no: "3",
            sort: "",
          },
          {
            id: 7,
            no: "4",
            sort: "",
          },
          {
            id: 6,
            no: "5",
            sort: "",
          },
          {
            id: 5,
            no: "6",
            sort: "",
          },
          {
            id: 4,
            no: "7",
            sort: "",
          },
          {
            id: 3,
            no: "8",
            sort: "",
          },
          {
            id: 0,
            no: "9",
            sort: "",
          },
          {
            id: 9,
            no: "10",
            sort: "",
          },
        ],
      },
      Listoforganizationscurrent2: 1,
      Listoforganizationstotal1: 10,
      ListoforganizationsisShow1: true,
      Editloading2: false,
      Deleteloading2: false,
    };
  },
  watch: {},
  methods: {
    async initParentOrganizationSelect() {
      try {
        // 调用后端接口获取组织机构数据
        const response = await this.executeBackendInterface("getOrganizationsRTB", {});

        // 检查请求是否成功
        if (response.flag) {
          // 将返回的数据转换为组件需要的格式
          this.ParentorganizationtreeData1.dataSource = this.handleParentorganizationtreeData2(
            response.data
          );
        } else {
          message.error(response.message || "获取组织机构数据失败");
        }
      } catch (error) {
        message.error("请求失败，请检查网络连接");
      }
    },
    async initPersonInChargeSelect() {
      try {
        // 调用后端接口获取系统用户列表
        const response = await this.executeBackendInterface("getSystemUsers", {});

        // 检查接口调用是否成功
        if (response.flag) {
          // 将返回的数据格式化为组件需要的格式
          this.Personinchargeoforganizationoptions1.dataSource = response.data.map(
            (user) => ({
              label: user.nick_name,
              value: user.id,
              disabled: false,
              select: false,
            })
          );
        } else {
          // 如果接口调用失败，显示错误信息
          message.error(response.message);
        }
      } catch (error) {
        // 捕获并处理任何错误
        message.error("获取系统用户列表失败");
      }
    },
    async refreshTable() {
      const response = await this.executeBackendInterface("getChildOrganizations", {
        parentId: this.OrganizationselectedKeys1[0],
        current: this.Listoforganizationscurrent2,
        pageSize: this.ListoforganizationspageSize1,
      });
      if (response.flag) {
        this.Listoforganizationsdata1.dataSource = response.data.data.map((item) => ({
          ...item,
          id: item.id,
          sort: item.sort_order,
          organizationName: item.name,
          personinchargeoforganization: item.leader_id,
          remarks: item.remarks,
          operation1: "",
        }));
        this.Listoforganizationstotal1 = response.data.total;
      } else {
        message.error(response.message);
      }
    },
    async handleAddOrganization() {
      // 获取表单引用
      const formRef = this.$refs.ref11_form;
      try {
        // 校验表单
        const values = await formRef.validateFields();
        // 调用后端接口，新增组织机构
        const response = await this.executeBackendInterface("addOrganization", {
          Parentorganizationvalue1: values.Parentorganizationvalue1 || null,
          OrganizationNamevalue1: values.OrganizationNamevalue1,
          Personinchargeoforganizationvalue1: values.Personinchargeoforganizationvalue1,
          Sortvalue1: values.Sortvalue1,
          Remarkvalue1: values.Remarkvalue1,
        });

        // 检查接口调用结果
        if (response.flag) {
          // 显示成功信息
          message.success(response.message);

          // 关闭弹窗
          this.AddedOrganizationPopupWindowisShow1 = false;

          // 刷新组织机构
          await this.initOrganizationTree();
          await this.refreshTable();
        } else {
          // 显示错误信息
          message.error(response.message);
        }
      } catch (errorInfo) {
        // 表单校验失败
        console.log("Failed:", errorInfo);
      }
    },
    closeAddOrganizationModal() {
      this.AddedOrganizationPopupWindowisShow1 = false;
    },
    handleOrganizationoptions1(data) {
      return data.map((item) => ({
        title: item.name,
        key: item.id.toString(),
        disabled: false,
        select: false,
        iconUrl: "./staticResource/public/folder.svg",
        children: this.handleOrganizationoptions1(item.children || []),
      }));
    },
    getAllExpandKey(data) {
      data.forEach((item) => {
        this.OrganizationexpandedKeys1.push(item.key);
        if (item.children && item.children.length) {
          this.getAllExpandKey(item.children);
        }
      });
    },
    async initOrganizationTree() {
      try {
        // 调用后端接口获取组织机构信息
        const response = await this.executeBackendInterface("getOrganizationsUVU", {});
        if (response.flag) {
          // 对返回数据进行排序
          const sortedData = response.data.sort((a, b) => a.sort_order - b.sort_order);

          // 将返回的数据格式转换为组件所需的格式
          this.Organizationoptions1.dataSource = this.handleOrganizationoptions1(
            sortedData
          );
          // 默认展开所有节点
          this.OrganizationexpandedKeys1 = [];
          this.getAllExpandKey(this.Organizationoptions1.dataSource);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取组织机构信息失败");
      }
    },
    showAddOrganizationModal() {
      this.AddedOrganizationPopupWindowisShow1 = true;
      this.AddedOrganizationPopupWindowform1 = {
        id: null,
        Parentorganizationvalue1: "",
        OrganizationNamevalue1: "",
        Personinchargeoforganizationvalue1: undefined,
        Sortvalue1: null,
        Remarkvalue1: "",
      }
    },
    async handleEditOrganization() {
      try {
        // 校验表单
        const values = await this.$refs.ref29_form.validateFields();

        // 调用后端接口更新组织机构
        const response = await this.executeBackendInterface("updateOrganization", {
          id: this.EditOrganizationpopupwindowform1.id,
          Parentorganizationvalue2: this.EditOrganizationpopupwindowform1.Parentorganizationvalue2 instanceof Array ? this.EditOrganizationpopupwindowform1.Parentorganizationvalue2[0] : null,
          OrganizationNamevalue2: this.EditOrganizationpopupwindowform1
            .OrganizationNamevalue2,
          Personinchargeoforganizationvalue2: this.EditOrganizationpopupwindowform1
            .Personinchargeoforganizationvalue2,
          Sortvalue2: this.EditOrganizationpopupwindowform1.Sortvalue2,
          Remarkvalue2: this.EditOrganizationpopupwindowform1.Remarkvalue2,
        });
        if (response.flag) {
          // 更新成功，关闭弹窗
          this.EditOrganizationpopupwindowisShow1 = false;
          message.success("组织机构更新成功");

          // 刷新组织机构
          await this.initOrganizationTree();
          await this.refreshTable();
        } else {
          message.error(response.message || "组织机构更新失败");
        }
      } catch (errorInfo) {
        console.log("Failed:", errorInfo);
        message.error("请检查表单项是否填写正确");
      }
    },
    closeEditOrganizationModal() {
      this.EditOrganizationpopupwindowisShow1 = false;
    },
    showEditOrganizationModal(record) {
      // 将当前行中的组织机构信息回显到编辑组织机构弹窗
      this.EditOrganizationpopupwindowform1.id = record.id;
      this.EditOrganizationpopupwindowform1.Parentorganizationvalue2 =
        record.parent_id || [];
      this.EditOrganizationpopupwindowform1.OrganizationNamevalue2 =
        record.organizationName || "";
      this.EditOrganizationpopupwindowform1.Personinchargeoforganizationvalue2 =
        record.personinchargeoforganization || undefined;
      this.EditOrganizationpopupwindowform1.Sortvalue2 = record.sort || null;
      this.EditOrganizationpopupwindowform1.Remarkvalue2 = record.remarks || "";

      // 显示编辑组织机构弹窗
      this.EditOrganizationpopupwindowisShow1 = true;
    },
    async deleteOrganization(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: "确认删除",
        content: `确定要删除组织机构名为${record.name}的记录吗？`,
        onOk: async () => {
          this.Deleteloading2 = true; // 设置删除按钮加载状态
          try {
            // 调用后端接口删除组织机构
            const response = await this.executeBackendInterface("deleteOrganization", {
              id: record.id,
            });
            if (response.flag) {
              message.success(response.message); // 显示成功消息
              // 在此处添加删除成功后的逻辑，例如刷新表格数据
              this.Listoforganizationscurrent2 = 1
              await this.initOrganizationTree();
              await this.refreshTable();
            } else {
              message.error(response.message); // 显示错误消息
            }
          } catch (error) {
            message.error("删除失败，请重试"); // 显示请求失败消息
          } finally {
            this.Deleteloading2 = false; // 恢复删除按钮状态
          }
        },

        onCancel: () => {
          // 取消删除操作
        },
      });
    },
    async initRootOrganizationsList() {
      try {
        const response = await this.executeBackendInterface("getRootOrganizations", {
          current: this.Listoforganizationscurrent2,
          pageSize: this.ListoforganizationspageSize1,
        });
        if (response.flag) {
          this.Listoforganizationsdata1.dataSource = response.data.data.map((item) => ({
            ...item,
            id: item.id,
            sort: item.sort_order,
            organizationName: item.name,
            personinchargeoforganization: item.leader_id,
            remarks: item.remarks,
            operation1: "",
          }));
          this.Listoforganizationstotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("加载根组织机构列表失败");
      }
    },
    async loadChildOrganizations() {
      try {
        await this.refreshTable();
      } catch (error) {
        message.error("加载子组织机构列表失败");
      }
    },
    handleParentorganizationtreeData2(data) {
      return data.map((org) => {
        const children = org.children || [];
        return {
          label: org.name,
          value: org.id,
          disabled: false,
          select: false,
          children: this.handleParentorganizationtreeData2(children),
        };
      });
    },
    async initEditParentOrganizationSelect() {
      try {
        // 调用后端接口获取组织结构数据
        const response = await this.executeBackendInterface("getOrganizationsRTB", {});

        // 检查请求是否成功
        if (response.flag) {
          // 将返回的数据格式化为组件需要的格式
          this.ParentorganizationtreeData2.dataSource = this.handleParentorganizationtreeData2(
            response.data
          );
        } else {
          // 如果请求失败，显示错误信息
          message.error(response.message);
        }
      } catch (error) {
        // 捕获并处理请求错误
        message.error("加载组织结构数据失败");
        console.error(error);
      }
    },
    async loadSystemUsersForSelect() {
      try {
        // 调用后端接口获取系统用户
        const response = await this.executeBackendInterface("getSystemUsersDB2", {});

        // 检查接口调用是否成功
        if (response.flag) {
          // 将返回的数据格式化为组件需要的格式
          this.Personinchargeoforganizationoptions2.dataSource = response.data.map(
            (user) => ({
              label: user.user_name,
              value: user.user_name,
              disabled: false,
              select: false,
            })
          );
        } else {
          // 如果接口调用失败，显示错误信息
          message.error(response.message);
        }
      } catch (error) {
        // 捕获并处理任何错误
        message.error("加载用户列表失败");
        console.error(error);
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1845286022938624000";
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
          .post("./Organizationmanagement/" + funcName, params, {
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
    loadCss("./css/组织机构管理/theme.css");
    // 在组件挂载时初始化上级组织机构选择框
    this.initParentOrganizationSelect();
    // 在组件挂载时调用initPersonInChargeSelect方法
    this.initPersonInChargeSelect();
    this.initOrganizationTree();
    this.initRootOrganizationsList();
    // 在组件挂载时调用初始化函数
    this.initEditParentOrganizationSelect();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
.webVueAntYtRectangleStyle-in {
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

.webVueAntYtRectangleStyle-inga5ez {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-in {
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
.webVueAntYtButtonStyle-in > span {
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

.webVueAntYtButtonStyle-in7jdz4 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-in7jdz4 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-in .ant-modal-wrap {
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
.webVueAntYtModalStyle-in .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-in.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-in .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-in.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtTreeSelectFormItem-in {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtTreeSelectFormItem-in .ant-form-item-label label {
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
.webVueAntYtTreeSelectFormItem-in .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtTreeSelectStyle-in .ant-select-selector {
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
.webVueAntYtTreeSelectStyle-in.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtTreeSelectStyle-in.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtTreeSelectStyle-in .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-in .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-in .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-in.ant-select-multiple
  .ant-select-selector
  .ant-select-selection-placeholder {
  left: 12px !important;
}
.popupKey-in.ant-select-dropdown {
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
.popupKey-in.ant-select-dropdown .ant-select-tree {
  background: #ffffff !important;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-in.ant-select-dropdown
  .ant-select-tree-treenode-checkbox-checked
  .ant-select-tree-node-content-wrapper {
  background: #e6effe;
  color: #333333;
}
.popupKey-in.ant-select-dropdown .ant-select-tree-node-content-wrapper:hover {
  background-color: #f0f0f0 !important;
  color: #333333;
}
.webVueTreeSelectFormItem {
  flex-wrap: nowrap;
}
.webVueTreeSelectFormItem,
.webVueTreeSelectFormItem .ant-form-item-control-input,
.webVueTreeSelectFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content,
.webVueTreeSelectFormItem
  .ant-form-item-control-input
  .ant-select-selector
  .ant-select-selection-search
  input {
  width: 100%;
  height: 100%;
}
.webVueTreeSelectFormItem .ant-form-item-control-input {
  min-height: unset;
}
.webVueTreeSelectFormItem .ant-form-item-control {
  min-width: 0;
}
.webVueTreeSelectFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueTreeSelectFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueTreeSelectFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueTreeSelectFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueTreeSelectFormItem .ant-form-item-label > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueTreeSelectFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueTreeSelectFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueTreeSelectFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueTreeSelect {
  width: 100%;
  height: 100%;
}
.webVueTreeSelect .ant-select-selector {
  width: 100% !important;
  height: 100% !important;
}
.webVueTreeSelect.ant-select-single
  .ant-select-selector
  .ant-select-selection-placeholder,
.webVueTreeSelect.ant-select-single .ant-select-selector {
  display: flex;
  align-items: center;
}

.webVueAntYtTreeSelectFormItem-in1pvzb .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-in1pvzb .ant-form-item-label label {
  width: 108px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-in {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-in .ant-form-item-label label {
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
.webVueAntYtInputFormItem-in .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-in:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-in.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-in.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-in:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-in:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-in input::placeholder,
.webVueAntYtInputStyle-in input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-in8h3dy .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-in8h3dy .ant-form-item-label label {
  width: 120px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-inauzg7:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtSelectFormItem-in {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtSelectFormItem-in .ant-form-item-label label {
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
.webVueAntYtSelectFormItem-in .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtSelectStyle-in .ant-select-selector {
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
.webVueAntYtSelectStyle-in.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtSelectStyle-in.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtSelectStyle-in .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-in .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-in .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-in.ant-select-dropdown {
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
.popupKey-in.ant-select-dropdown .ant-select-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-in.ant-select-dropdown .ant-select-item-option-selected {
  background: #e6effe;
  color: #333333;
}
.popupKey-in.ant-select-dropdown .ant-select-item:hover {
  background: #f0f0f0;
  color: #333333;
}
.popupKey-in .ant-select-item-option-active:not(.ant-select-item-option-disabled) {
  background: #f0f0f0;
  color: #333333;
}
.webVueSelectFormItem {
  flex-wrap: nowrap;
}
.webVueSelectFormItem,
.webVueSelectFormItem .ant-form-item-control-input,
.webVueSelectFormItem .ant-form-item-control-input .ant-form-item-control-input-content,
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
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueSelectFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueSelectFormItem .ant-form-item-label > label.ant-form-item-no-colon:after {
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
.webVueSelect.ant-select-single .ant-select-selector .ant-select-selection-placeholder,
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
}

.webVueAntYtSelectFormItem-inxcrdw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-inxcrdw .ant-form-item-label label {
  width: 122px;
  padding-right: 10px;
}

.webVueAntYtInputNumberFormItem-in {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputNumberFormItem-in .ant-form-item-label label {
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
.webVueAntYtInputNumberFormItem-in .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputNumberStyle-in {
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
.webVueAntYtInputNumberStyle-in input {
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
.webVueAntYtInputNumberStyle-in input::placeholder,
.webVueAntYtInputNumberStyle-in input::-webkit-input-placeholder {
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

.webVueAntYtInputNumberFormItem-ink97xk .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-ink97xk .ant-form-item-label label {
  width: 64px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-ineyekt {
  background: #ffffff !important;
}

.webVueAntYtTree {
  width: 100%;
  height: 100%;
}
.webVueAntYtTree .ant-tree-treenode {
  width: 100%;
}
.webVueAntYtTree.ant-tree-show-line .ant-tree-switcher {
  background-color: transparent;
}
.nowrapEllipsis .ant-tree-node-content-wrapper {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.ant-tree-switcher-icon.rotate {
  transform: rotate(90deg);
}
.webVueAntYtTree .ant-tree-switcher {
  display: inline-flex;
  align-items: center;
  justify-content: center;
}

.webVueAntYtTreeStyle-intbcuh.ant-tree {
  opacity: 1;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
}
.webVueAntYtTreeStyle-intbcuh .ant-tree-node-selected {
  background-color: #e6effe !important;
  color: #595959;
}
.webVueAntYtTreeStyle-intbcuh .ant-tree-node-content-wrapper:hover {
  background-color: #f5f5f5 !important;
  color: rgba(0, 0, 0, 0.88);
}
.webVueAntYtTreeStyle-intbcuh .ant-tree-node-content-wrapper {
  padding-left: 0px;
}

.webVueAntYtTextAreaFormItem-in {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtTextAreaFormItem-in .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 52px;
  padding-top: 4px;
  padding-right: 0px;
  padding-bottom: 6px;
  padding-left: 0px;
}
.webVueAntYtTextAreaFormItem-in .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtTextAreaStyle-in.ant-input {
  background: #ffffff;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid #cdcdcd;
  border-right: 1px solid #cdcdcd;
  border-bottom: 1px solid #cdcdcd;
  border-left: 1px solid #cdcdcd;
  box-shadow: 0px 0px 0px 0px transparent !important;
}
.webVueAntYtTextAreaStyle-in.ant-input,
.webVueAntYtTextAreaStyle-in:not(.ant-input) .ant-input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 32px;
  letter-spacing: 0px;
  vertical-align: undefined;
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 12px;
}
.webVueAntYtTextAreaStyle-in.ant-input::placeholder,
.webVueAntYtTextAreaStyle-in.ant-input::-webkit-input-placeholder,
.webVueAntYtTextAreaStyle-in:not(.ant-input) .ant-input::placeholder,
.webVueAntYtTextAreaStyle-in:not(.ant-input) .ant-input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntYtTextAreaStyle-in.ant-input:disabled {
  background: #ffffff;
}
.webVueAntTextAreaFormItem {
  flex-wrap: nowrap;
}
.webVueAntTextAreaFormItem,
.webVueAntTextAreaFormItem .ant-form-item-control-input,
.webVueAntTextAreaFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntTextAreaFormItem .ant-form-item-control-input {
  min-height: unset;
}
.webVueAntTextAreaFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntTextAreaFormItem label {
  width: 100%;
  height: 100%;
  align-items: flex-start;
  line-height: 32px;
}
.webVueAntTextAreaFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntTextAreaFormItem .ant-form-item-label label .label-content {
  flex: 1;
  height: 100%;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntTextAreaFormItem .ant-form-item-label > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntTextAreaFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntTextAreaFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntTextAreaFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueAntTextarea {
  width: 100%;
  height: 100% !important;
}
.webVueAntTextarea .ant-input {
  background-color: transparent;
}

.webVueAntYtTextAreaFormItem-init3hd .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTextAreaFormItem-init3hd .ant-form-item-label label {
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtTextAreaStyle-in5k9s1.ant-input {
  background: #ffffff !important;
}

.webVueAntYtTreeSelectFormItem-inp8avp .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-inp8avp .ant-form-item-label label {
  width: 108px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-in1bmfx .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-in1bmfx .ant-form-item-label label {
  width: 120px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-inl4l80:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtSelectFormItem-in6sgfv .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-in6sgfv .ant-form-item-label label {
  width: 122px;
  padding-right: 10px;
}

.webVueAntYtInputNumberFormItem-intaho2 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-intaho2 .ant-form-item-label label {
  width: 64px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-incuu63 {
  background: #ffffff !important;
}

.webVueAntYtTextAreaFormItem-inkscyi .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTextAreaFormItem-inkscyi .ant-form-item-label label {
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtTextAreaStyle-in90cit.ant-input {
  background: #ffffff !important;
}

.webVueAntYtSpanStyle-in {
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
.webVueAntYtSpanStyle-in span {
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

.webVueAntYtSpanStyle-inxepf2 {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-inxepf2 span {
  text-decoration: none;
}

.webVueAntYtRectangleStyle-inx6oeq {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
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

.webVueAntYtTableStyle-indhu88 {
  opacity: 1;
}
.webVueAntYtTableStyle-indhu88 .ant-table {
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
.webVueAntYtTableStyle-indhu88 .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-indhu88 .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-indhu88 .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-indhu88 .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-indhu88 .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-indhu88 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-indhu88 .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-indhu88 .ant-table thead tr th,
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-indhu88 .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-indhu88 .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-indhu88.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-indhu88.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-indhu88 .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-indhu88
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-indhu88 .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-indhu88
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-indhu88 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-indhu88 .ant-pagination button,
.webVueAntYtTableStyle-indhu88 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-indhu88 .ant-pagination li input {
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
.webVueAntYtTableStyle-indhu88 .ant-pagination button,
.webVueAntYtTableStyle-indhu88 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-indhu88 .ant-pagination li input,
.webVueAntYtTableStyle-indhu88 .ant-pagination li a,
.webVueAntYtTableStyle-indhu88 .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-indhu88
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-indhu88
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-indhu88 .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-indhu88 .ant-pagination li a,
.webVueAntYtTableStyle-indhu88 .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-indhu88 .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-indhu88 .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-indhu88 tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-indhu88 tr > th:nth-child(1),
.webVueAntYtTableStyle-indhu88 .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-indhu88 tr > th:nth-child(2),
.webVueAntYtTableStyle-indhu88 .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: calc((100% - 148px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-indhu88 tr > th:nth-child(3),
.webVueAntYtTableStyle-indhu88 .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 148px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-indhu88 tr > th:nth-child(4),
.webVueAntYtTableStyle-indhu88 .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: calc((100% - 148px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-indhu88 tr td:nth-child(5) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-indhu88 tr > th:nth-child(5),
.webVueAntYtTableStyle-indhu88 .ant-table-body tr.ant-table-measure-row td:nth-child(5) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-indhu88 {
  width: 100%;
}

.webVueAntYtButtonStyle-inhcadp {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-inhcadp > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-insd96s {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-insd96s > span {
  letter-spacing: 0px !important;
}

.webVueAntYtSpanStyle-ingr0os {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-ingr0os span {
  text-decoration: none;
}
</style>
