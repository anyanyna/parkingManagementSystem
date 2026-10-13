<template>
  <yt-grid previewType="AdaptiveWH" width="1700" height="1016" background="#F0F2F5">
    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.80000%"
      left="0.10000%"
      bottom="3.50000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="13"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref1"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-rbtlb08 webVueAntYtRectangleStyle-rb webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="MenuNameisShow1"
      top="14.80000%"
      left="1.70000%"
      bottom="6.30000%"
      right="1.10000%"
      gridColumnStart="3"
      gridColumnEnd="23"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="2"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref2"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-rbu9uxs webVueAntYtInputFormItem-rb webVueAntYtInputFormItem show-label-rb show-label"
        name="MenuNamevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'菜单名称：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-rbpew5n webVueAntYtInputStyle-rb webVueAntYtInputStyle"
          v-model:value="MenuNamevalue1"
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
      left="8.20000%"
      bottom="6.30000%"
      right="16.40000%"
      gridColumnStart="90"
      gridColumnEnd="95"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="3"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref3"
        @click="
          () => {
            searchMenuList();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-rbt9fnr webVueAntYtButtonStyle-rb webVueAntYtButtonStyle center-rb center"
        :loading="Queryloading1"
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
      gridRowStart="14"
      gridRowEnd="100"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref4"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-rbcviml webVueAntYtRectangleStyle-rb webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="17.60000%"
      bottom="6.30000%"
      right="7.00000%"
      gridColumnStart="94"
      gridColumnEnd="99"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref5"
        @click="
          () => {
            resetMenuList();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-rbfoef6 webVueAntYtButtonStyle-rb webVueAntYtButtonStyle center-rb center"
        :loading="Resetloading1"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="3.90000%"
      left="7.00000%"
      bottom="17.30000%"
      right="17.60000%"
      gridColumnStart="3"
      gridColumnEnd="8"
      gridRowStart="16"
      gridRowEnd="20"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref6"
        @click="
          () => {
            showAddMenuPopup();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-rb832ya webVueAntYtButtonStyle-rb webVueAntYtButtonStyle center-rb center"
        :loading="Newloading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="MenuListisShow1"
      top="1.10000%"
      left="0.30000%"
      bottom="1.00000%"
      right="0.30000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="20"
      gridRowEnd="98"
      zIndex="7"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref7"
        @onTableChange="
          (pagination) => {
            changeMenuPage(pagination);
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-rbglrgl webVueAntYtTableStyle-rb webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="MenuListselectedRows1"
        v-model:total="MenuListtotal1"
        v-model:current="MenuListcurrent2"
        v-model:pageSize="MenuListpageSize1"
        :columns="MenuListdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="MenuListdata1.dataSource"
        :scroll="{ y: 663.0000382001598 }"
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'icons1'">
            <div style="width: 100%; height: 100%; background: #fff; display: flex">
                <div
                  ref="ref25"
                  class="webVueAntYtIcon webVueAntYtPictureStyle-rbsx9ht webVueAntYtPictureStyle"
                >
                  <img v-if="record.icons1 && record.icon !== 'null'" :src="record.icons1" class="yt-static" />
                </div>
            </div>
          </template>
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
                <a-button
                  ref="ref9"
                  @click="
                    () => {
                      deleteMenu(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-rbr22oy webVueAntYtButtonStyle center"
                  :loading="Deleteloading1"
                >
                  <span class="yt-button-content" v-html="'删除'"></span>
                </a-button>
              </div>
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
                <a-button
                  ref="ref10"
                  @click="
                    () => {
                      showEditMenuModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-rbdxp4i webVueAntYtButtonStyle center"
                  :loading="Editloading1"
                >
                  <span class="yt-button-content" v-html="'编辑'"></span>
                </a-button>
              </div>
            </div>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="AddedmenupopupwindowisShow1"
      top="0.90000%"
      left="2.50000%"
      bottom="1.00000%"
      right="0.60000%"
      gridColumnStart="35"
      gridColumnEnd="63"
      gridRowStart="16"
      gridRowEnd="64"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref12"
        @ok="
          () => {
            addMenu();
          }
        "
        @cancel="
          () => {
            cancelAddMenuPopup();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-rb webVueAntYtModalStyle"
        v-model:isShow="AddedmenupopupwindowisShow1"
        :title="'新增菜单'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="Addedmenupopupwindowform1"
            ref="ref12_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="SuperiorMenuisShow1"
                top="-45.50000%"
                left="0.70000%"
                bottom="49.80000%"
                right="0.80000%"
                gridColumnStart="12"
                gridColumnEnd="87"
                gridRowStart="10"
                gridRowEnd="19"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref23"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-rbt158s webVueAntYtTreeSelectFormItem-rb webVueAntYtTreeSelectFormItem show-label-rb show-label"
                  name="SuperiorMenuvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'上级菜单：'"> </span>
                    </div>
                  </template>
                  <a-tree-select
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-rb webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="Addedmenupopupwindowform1.SuperiorMenuvalue1"
                    :placeholder="'请输入'"
                    :treeData="SuperiorMenutreeData1.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-55.20000%"
                left="0.20000%"
                bottom="59.50000%"
                right="0.80000%"
                gridColumnStart="10"
                gridColumnEnd="87"
                gridRowStart="27"
                gridRowEnd="36"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref24"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-rbqvok3 webVueAntYtInputFormItem-rb webVueAntYtInputFormItem show-label-rb show-label"
                  name="MenuName1value1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'菜单名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-rbm9jff webVueAntYtInputStyle-rb webVueAntYtInputStyle"
                    v-model:value="Addedmenupopupwindowform1.MenuName1value1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-28.40000%"
                left="1.70000%"
                bottom="44.50000%"
                right="2.10000%"
                gridColumnStart="21"
                gridColumnEnd="54"
                gridRowStart="77"
                gridRowEnd="87"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref26"
                  class="webVueAntUploadButton webVueAntUploadButtonFormItem-rbbw9n7 webVueAntUploadButtonStyle-rbed4gh webVueAntUploadButtonFormItem-rb webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-rb webVueAntUploadButtonStyle show-label-rb show-label"
                  name="IconsfileList1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'图标'"> </span>
                    </div>
                  </template>
                  <yt-upload-button-inner
                    data-event
                    :showUploadList="true"
                    :accept="'image/*'"
                    :multiple="false"
                    :maxCount="1"
                    @change="upload"
                  >
                  </yt-upload-button-inner>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="PageisShow1"
                top="-45.90000%"
                left="0.70000%"
                bottom="50.30000%"
                right="0.60000%"
                gridColumnStart="18"
                gridColumnEnd="87"
                gridRowStart="44"
                gridRowEnd="53"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref27"
                  class="webVueSelectFormItem webVueAntYtSelectFormItem-rbzseiu webVueAntYtSelectFormItem-rb webVueAntYtSelectFormItem show-label-rb show-label"
                  name="path"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'页面：'"> </span>
                    </div>
                  </template>
                  <a-select
                    class="webVueSelect webVueAntYtSelectStyle-rb webVueAntYtSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="Addedmenupopupwindowform1.path"
                    :placeholder="'请输入'"
                    :mode="'single'"
                    :options="Pageoptions1.dataSource"
                    :showSearch="true"
                  >
                  </a-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-22.630000%"
                left="1.20000%"
                bottom="36.50000%"
                right="0.90000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="60"
                gridRowEnd="70"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref28"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-rbhk3wq webVueAntYtInputNumberFormItem-rb webVueAntYtInputNumberFormItem show-label-rb show-label"
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
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-rbxro3g webVueAntYtInputNumberStyle-rb webVueAntYtInputNumberStyle"
                    v-model:value="Addedmenupopupwindowform1.Sortvalue1"
                    :placeholder="'请输入'"
                    :max="99999"
                    :min="0"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>
              <yt-grid-item
                fixedSize="selfAdaption"
                top="296.40000%"
                left="-7.60000%"
                bottom="-282.50000%"
                right="0.90000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="60"
                gridRowEnd="70"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref38"
                  class="webVueAntSwitchFormItem webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-rb6tsmw webVueAntYtInputNumberFormItem-rb webVueAntYtInputNumberFormItem show-label-rb show-label"
                  name="Sortvalue2"
                  :colon="false"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'设为初始页：'"> </span>
                    </div>
                  </template>
                  <a-switch :unCheckedValue="0" :checkedValue="1" v-model:checked="Addedmenupopupwindowform1.index_status"/>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="EditmenupopupisShow1"
      top="0.80000%"
      left="1.60000%"
      bottom="1.10000%"
      right="1.40000%"
      gridColumnStart="37"
      gridColumnEnd="65"
      gridRowStart="19"
      gridRowEnd="67"
      zIndex="9"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref31"
        @ok="
          () => {
            updateMenu();
          }
        "
        @cancel="
          () => {
            cancelEditMenuPopup();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-rb webVueAntYtModalStyle"
        v-model:isShow="EditmenupopupisShow1"
        :title="'编辑菜单'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="Editmenupopupform1" ref="ref31_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="-45.50000%"
                left="0.70000%"
                bottom="49.80000%"
                right="0.80000%"
                gridColumnStart="12"
                gridColumnEnd="87"
                gridRowStart="10"
                gridRowEnd="19"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref32"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-rbae10h webVueAntYtTreeSelectFormItem-rb webVueAntYtTreeSelectFormItem show-label-rb show-label"
                  name="SuperiorMenuvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'上级菜单：'"> </span>
                    </div>
                  </template>
                  <a-tree-select
                    data-event
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-rb webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="Editmenupopupform1.SuperiorMenuvalue2"
                    :placeholder="'请输入'"
                    :treeData="SuperiorMenutreeData1.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-55.20000%"
                left="0.20000%"
                bottom="59.50000%"
                right="0.80000%"
                gridColumnStart="10"
                gridColumnEnd="87"
                gridRowStart="27"
                gridRowEnd="36"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref33"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-rbaxmb5 webVueAntYtInputFormItem-rb webVueAntYtInputFormItem show-label-rb show-label"
                  name="MenuName1value2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'菜单名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-rb4c6mi webVueAntYtInputStyle-rb webVueAntYtInputStyle"
                    v-model:value="Editmenupopupform1.MenuName1value2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-28.40000%"
                left="1.70000%"
                bottom="44.50000%"
                right="2.10000%"
                gridColumnStart="21"
                gridColumnEnd="54"
                gridRowStart="77"
                gridRowEnd="87"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref34"
                  class="webVueAntUploadButton webVueAntUploadButtonFormItem-rbudesz webVueAntUploadButtonStyle-rbns2w1 webVueAntUploadButtonFormItem-rb webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-rb webVueAntUploadButtonStyle show-label-rb show-label"
                  name="IconsfileList2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'图标'"> </span>
                    </div>
                  </template>
                  <yt-upload-button-inner
                    data-event
                    :showUploadList="true"
                    :accept="'image/*'"
                    :multiple="false"
                    :maxCount="1"
                    @change="upload"
                  >
                  </yt-upload-button-inner>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-45.90000%"
                left="0.70000%"
                bottom="50.30000%"
                right="0.60000%"
                gridColumnStart="18"
                gridColumnEnd="87"
                gridRowStart="44"
                gridRowEnd="53"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref35"
                  class="webVueSelectFormItem webVueAntYtSelectFormItem-rbqzril webVueAntYtSelectFormItem-rb webVueAntYtSelectFormItem show-label-rb show-label"
                  name="path2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'页面：'"> </span>
                    </div>
                  </template>
                  <a-select
                    data-event
                    class="webVueSelect webVueAntYtSelectStyle-rb webVueAntYtSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="Editmenupopupform1.path2"
                    :placeholder="'请输入'"
                    :mode="'single'"
                    :options="Pageoptions1.dataSource"
                    :showSearch="true"
                  >
                  </a-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="-22.630000%"
                left="1.20000%"
                bottom="36.50000%"
                right="0.90000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="60"
                gridRowEnd="70"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref36"
                  class="webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-rb6tsmw webVueAntYtInputNumberFormItem-rb webVueAntYtInputNumberFormItem show-label-rb show-label"
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
                    class="webVueAntInputNumber webVueAntYtInputNumberStyle-rb488pu webVueAntYtInputNumberStyle-rb webVueAntYtInputNumberStyle"
                    v-model:value="Editmenupopupform1.Sortvalue2"
                    :placeholder="'请输入'"
                    :max="9999"
                    :min="0"
                    :precision="0"
                  >
                  </a-input-number>
                </a-form-item>
              </yt-grid-item>
              <yt-grid-item
                fixedSize="selfAdaption"
                top="296.40000%"
                left="-7.60000%"
                bottom="-282.50000%"
                right="0.90000%"
                gridColumnStart="15"
                gridColumnEnd="87"
                gridRowStart="60"
                gridRowEnd="70"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref38"
                  class="webVueAntSwitchFormItem webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-rb6tsmw webVueAntYtInputNumberFormItem-rb webVueAntYtInputNumberFormItem show-label-rb show-label"
                  name="Sortvalue2"
                  :colon="false"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'设为初始页：'"> </span>
                    </div>
                  </template>
                  <a-switch :unCheckedValue="0" :checkedValue="1" v-model:checked="Editmenupopupform1.index_status"/>
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
      zIndex="10"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref37"
        class="webVueAntYtSpan webVueAntYtSpanStyle-rbec7l7 webVueAntYtSpanStyle-rb webVueAntYtSpanStyle null-rb null"
      >
        <span v-html="'菜单管理'"> </span>
      </span>
    </yt-grid-item>
  </yt-grid>
</template>

<script>
import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { useRouter } from "vue-router";
import { ref } from "vue";

export default {
  data() {
    return {
      Deleteloading1: false,
      Editloading1: false,
      Queryloading1: false,
      MenuListcurrentRow1: {},
      MenuListselectedRows1: [],
      MenuListpageSize1: 10,
      MenuListdata1: {
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
          },
          {
            key: "menuName",
            title: "菜单名称",
            dataIndex: "menuName",
            width: undefined,
          },
          {
            key: "path",
            title: "路径",
            dataIndex: "path",
          },
          {
            key: "icons1",
            title: "图标",
            dataIndex: "icons1",
            cellType: "slot",
            ellipsis: true
          },
          {
            key: "operation1",
            title: "操作",
            dataIndex: "operation1",
            cellType: "slot",
          }
        ],
        dataSource: [
          {
            id: 1,
            no: "1",
            status: "停用",
            identityCard: "",
            operation1: "",
            sort: "",
            menuName: "",
            path: "",
          },
          {
            id: 2,
            no: "2",
            status: "启用",
            sort: "",
          },
          {
            id: 8,
            no: "3",
            status: "",
            sort: "",
          },
          {
            id: 7,
            no: "4",
            status: "",
            sort: "",
          },
          {
            id: 6,
            no: "5",
            status: "",
            sort: "",
          },
          {
            id: 5,
            no: "6",
            status: "",
            sort: "",
          },
          {
            id: 4,
            no: "7",
            status: "",
            sort: "",
          },
          {
            id: 3,
            no: "8",
            status: "",
            sort: "",
          },
          {
            id: 0,
            no: "9",
            status: "",
            sort: "",
          },
          {
            id: 9,
            no: "10",
            status: "",
            sort: "",
          },
        ],
      },
      MenuListcurrent2: 1,
      MenuListtotal1: 10,
      MenuListisShow1: true,
      EditmenupopupisShow1: false,
      Editmenupopupform1: {
        id: null,
        SuperiorMenuvalue2: null,
        MenuName1value2: "",
        icon2: [],
        path2: undefined,
        Sortvalue2: null,
        index_status: 0
      },
      Resetloading1: false,
      MenuNamevalue1: "",
      MenuNameisShow1: true,
      SuperiorMenuisShow1: true,
      AddedmenupopupwindowisShow1: false,
      Addedmenupopupwindowform1: {
        id: null,
        SuperiorMenuvalue1: null,
        MenuName1value1: "",
        icon1: "",
        path: undefined,
        Sortvalue1: null,
        index_status: 0
      },
      Newloading1: false,
      Pageoptions1: {
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
      PageisShow1: true,
      SuperiorMenutreeData1: {
        dataSource: [],
        value: {
          selectActive: "",
          selectData: [],
          disableData: [],
          disableActive: "",
        },
      },
    };
  },
  watch: {},
  methods: {
    upload(fileList) {
      if (fileList[0]?.originFileObj) {
        const formData = new FormData();
        formData.append("file", fileList[0].originFileObj);
        new Promise((resolve, reject) => {
          axios
            .post("/api/common/uploadFile", formData, {
              headers: {
                "Content-Type": "multipart/form-data",
              }
            })
            .then((response) => {
              if (this.AddedmenupopupwindowisShow1) {
                this.Addedmenupopupwindowform1.icon1 = response.data.data
              } else {
                this.Editmenupopupform1.icon2 = response.data.data
              }
              resolve(response.data);
            })
            .catch((error) => {
              reject(error);
            });
        });
      }
    },
    async resetMenuList() {
      this.MenuNamevalue1 = "";
      this.MenuListcurrent2 = 1;
      await this.initMenuList();
    },
    async searchMenuList() {
      try {
        this.MenuListcurrent2 = 1;
        const response = await this.executeBackendInterface("searchMenus", {
          current: this.MenuListcurrent2,
          pageSize: this.MenuListpageSize1,
          menuName: this.MenuNamevalue1,
        });
        if (response.flag) {
          this.MenuListdata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            menuName: item.menu_name,
            path: item.path,
            icons1: item.icon && item.icon !== 'null' ? `/api/staticCommonUpload/${item.icon}` : '',
            // icons1: `/api/staticCommonUpload/${item.icon}`,
            operation1: "",
            sort: item.sort_order,
            parentId: item.parent_id,
            index_status: item.index_status
          }));
          this.MenuListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询菜单列表失败");
      }
    },
    async initMenuList() {
      try {
        const response = await this.executeBackendInterface("getMenus", {
          current: this.MenuListcurrent2,
          pageSize: this.MenuListpageSize1,
          menuName: this.MenuNamevalue1,
        });
        if (response.flag) {
          this.MenuListdata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            menuName: item.menu_name,
            path: item.path,
            icons1: item.icon && item.icon !== 'null' ? `/api/staticCommonUpload/${item.icon}` : '',
            // icons1: `/api/staticCommonUpload/${item.icon}`,
            operation1: "",
            sort: item.sort_order,
            parentId: item.parent_id,
            index_status: item.index_status
          }));
          this.MenuListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("初始化菜单列表失败");
      }
    },
    async changeMenuPage(pagination) {
      this.MenuListcurrent2 = pagination.current;
      this.MenuListpageSize1 = pagination.pageSize;
      await this.initMenuList();
    },
    async updateMenu() {
      console.log("🚀 ~ updateMenu ~ this.Editmenupopupform1.icon2:", this.Editmenupopupform1.icon2)
      try {
        const response = await this.executeBackendInterface("updateMenu", {
          id: this.Editmenupopupform1.id,
          menuName: this.Editmenupopupform1.MenuName1value2,
          // Assuming path is not part of the form
          icon: this.Editmenupopupform1.icon2.replace('/api/staticCommonUpload/', ''),
          path: this.Editmenupopupform1.path2,
          parentId: this.Editmenupopupform1.SuperiorMenuvalue2,
          sortOrder: this.Editmenupopupform1.Sortvalue2,
          index_status: this.Editmenupopupform1.index_status
        });
        if (response.flag) {
          message.success("菜单更新成功");
          this.EditmenupopupisShow1 = false;
          await this.initMenuList();
          window.dispatchEvent(new CustomEvent('refreshMenu'))
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("更新菜单失败");
      }
    },
    async showEditMenuModal(record) {
      this.initSuperiorMenuDropdown();
      this.Editmenupopupform1 = {
        id: record.id,
        SuperiorMenuvalue2: record.parentId,
        MenuName1value2: record.menuName,
        icon2: record.icons1,
        path2: record.path,
        Sortvalue2: record.sort,
        index_status: record.index_status
      };
      console.log("🚀 ~ showEditMenuModal ~ this.Editmenupopupform1:", this.Editmenupopupform1)
      this.EditmenupopupisShow1 = true;
    },
    async deleteMenu(record) {
      Modal.confirm({
        title: "确认删除",
        content: "确定要删除该菜单吗？",
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface("deleteMenu", {
              id: record.id,
            });
            if (response.flag) {
              message.success("菜单删除成功");
              this.MenuListcurrent2 = 1;
              await this.initMenuList();
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("删除菜单失败");
          }
        },
        onCancel: () => {
          // 取消删除
        },
      });
    },
    showAddMenuPopup() {
      // 显示新增菜单弹窗
      this.AddedmenupopupwindowisShow1 = true;
      this.initSuperiorMenuDropdown();
    },
    async initSuperiorMenuDropdown() {
      // 初始化上级菜单下拉框，默认显示所有菜单
      try {
        const response = await this.executeBackendInterface("getMenuTree", {});
        if (response.flag) {
          const transformData = (nodes) => {
            return nodes.map((node) => ({
              value: node.id,
              label: node.menu_name,
              children: node.children ? transformData(node.children) : [],
            }));
          };
          this.SuperiorMenutreeData1.dataSource = transformData(response.data);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("查询菜单列表失败", error);
      }
    },
    async initPageDropdown() {
      try {
        const router = useRouter();
        const navPageChildren = ref([]);
        // 获取导航页面的子路由
        const navPageRoute = router
          .getRoutes()
          .find((route) => route.name === "导航页面");
        if (navPageRoute && navPageRoute.children) {
          navPageChildren.value = navPageRoute.children;
        }
        this.Pageoptions1.dataSource = navPageChildren.value.map((item) => ({
          value: navPageRoute.path + "/" + item.path,
          label: item.name.replace("_child", ""),
        }));
      } catch (error) {
        message.error("查询页面列表失败", error);
      }
    },
    async addMenu() {
      try {
        // 如果校验通过，新增菜单数据
        const newMenu = {
          id: Date.now(),
          // 假设使用当前时间戳作为ID
          menuName: this.Addedmenupopupwindowform1.MenuName1value1,
          parentId: this.Addedmenupopupwindowform1.SuperiorMenuvalue1,
          sortOrder: this.Addedmenupopupwindowform1.Sortvalue1,
          icon: this.Addedmenupopupwindowform1.icon1,
          path: this.Addedmenupopupwindowform1.path,
          index_status: this.Addedmenupopupwindowform1.index_status
        };
        try {
          const response = await this.executeBackendInterface("addMenu", newMenu);
          if (response.flag) {
            // 清空表单
            this.Addedmenupopupwindowform1 = {
              id: null,
              SuperiorMenuvalue1: null,
              MenuName1value1: "",
              icon1: "",
              path: null,
              Sortvalue1: null,
              index_status: 0
            };

            // 关闭弹窗
            this.AddedmenupopupwindowisShow1 = false;

            // 刷新表格
            this.MenuListcurrent2 = 1; // 重置分页到第一页
            this.initMenuList();
            message.success("菜单新增成功");
          } else {
            message.error(response.message);
          }
        } catch (error) {
          message.error("查询页面列表失败", error);
        }
        // 更新表格数据
      } catch (errorInfo) {
        // 如果校验未通过，不进行任何操作
        console.log("Failed:", errorInfo);
      }
    },
    cancelAddMenuPopup() {
      // 关闭弹窗
      this.AddedmenupopupwindowisShow1 = false;

      // 清空弹窗内容
      this.Addedmenupopupwindowform1 = {
        id: null,
        SuperiorMenuvalue1: null,
        MenuName1value1: "",
        icon1: "",
        path: undefined,
        Sortvalue1: null,
      };
    },
    cancelEditMenuPopup() {
      // 关闭编辑菜单弹窗
      this.EditmenupopupisShow1 = false;
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1845286105574801408";
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
          .post("./Menumanagement/" + funcName, params, {
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
    loadCss("./css/菜单管理/theme.css");
    this.initMenuList();
    this.initSuperiorMenuDropdown();
    // 在组件挂载时调用initPageDropdown方法
    this.initPageDropdown();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
.webVueAntYtRectangleStyle-rb {
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

.webVueAntYtRectangleStyle-rbtlb08 {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-rb {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-rb .ant-form-item-label label {
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
.webVueAntYtInputFormItem-rb .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-rb:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-rb.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-rb.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-rb:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-rb:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-rb input::placeholder,
.webVueAntYtInputStyle-rb input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-rbu9uxs .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-rbu9uxs .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-rbu9uxs .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-rbpew5n:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-rb {
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
.webVueAntYtButtonStyle-rb > span {
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

.webVueAntYtButtonStyle-rbt9fnr {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-rbt9fnr > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-rbcviml {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-rbfoef6 {
  color: #333333 !important;
  background: transparent !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-rbfoef6 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-rb832ya {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-rb832ya > span {
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

.webVueAntYtTableStyle-rbglrgl {
  opacity: 1;
}
.webVueAntYtTableStyle-rbglrgl .ant-table {
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
.webVueAntYtTableStyle-rbglrgl .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-rbglrgl .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-rbglrgl .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-rbglrgl .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-rbglrgl .ant-table thead tr th,
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-rbglrgl .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-rbglrgl .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-rbglrgl.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-rbglrgl.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-rbglrgl .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-rbglrgl
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-rbglrgl
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-rbglrgl .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-rbglrgl .ant-pagination button,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li input {
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
.webVueAntYtTableStyle-rbglrgl .ant-pagination button,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li input,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li a,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-rbglrgl
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-rbglrgl
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-rbglrgl .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-rbglrgl .ant-pagination li a,
.webVueAntYtTableStyle-rbglrgl .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-rbglrgl .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-rbglrgl .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-rbglrgl tr > th:nth-child(1),
.webVueAntYtTableStyle-rbglrgl .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-rbglrgl tr > th:nth-child(2),
.webVueAntYtTableStyle-rbglrgl .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: 180px !important;
  min-width: 180px !important;
  max-width: 180px !important;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-rbglrgl tr > th:nth-child(3),
.webVueAntYtTableStyle-rbglrgl .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 376px) / 1) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-rbglrgl tr > th:nth-child(4),
.webVueAntYtTableStyle-rbglrgl .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: 48px !important;
  min-width: 48px !important;
  max-width: 48px !important;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-rbglrgl tr td:nth-child(5) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-rbglrgl tr > th:nth-child(5),
.webVueAntYtTableStyle-rbglrgl .ant-table-body tr.ant-table-measure-row td:nth-child(5) {
  width: 100px !important;
  min-width: 100px !important;
  max-width: 100px !important;
}
.webVueAntYtTableStyle-rbglrgl {
  width: 100%;
}

.webVueAntYtButtonStyle-rbr22oy {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-rbr22oy > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-rbdxp4i {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-rbdxp4i > span {
  letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-rb .ant-modal-wrap {
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
.webVueAntYtModalStyle-rb .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-rb.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-rb .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-rb.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtTreeSelectFormItem-rb {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtTreeSelectFormItem-rb .ant-form-item-label label {
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
.webVueAntYtTreeSelectFormItem-rb .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtTreeSelectStyle-rb .ant-select-selector {
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
.webVueAntYtTreeSelectStyle-rb.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtTreeSelectStyle-rb.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtTreeSelectStyle-rb .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-rb .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-rb .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-rb.ant-select-multiple
  .ant-select-selector
  .ant-select-selection-placeholder {
  left: 12px !important;
}
.popupKey-rb.ant-select-dropdown {
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
.popupKey-rb.ant-select-dropdown .ant-select-tree {
  background: #ffffff !important;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-rb.ant-select-dropdown
  .ant-select-tree-treenode-checkbox-checked
  .ant-select-tree-node-content-wrapper {
  background: #e6effe;
  color: #333333;
}
.popupKey-rb.ant-select-dropdown .ant-select-tree-node-content-wrapper:hover {
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
.webVueTreeSelect,
.webVueTreeSelect.ant-select-single:not(.ant-select-customize-input) .ant-select-selector:after,
.webVueTreeSelect.ant-select-multiple .ant-select-selection-search-input,
.webVueTreeSelect.ant-select-multiple .ant-select-selection-search-mirror{
  line-height: 1;
}
.webVueSelect.ant-select-single:not(.ant-select-customize-input) .ant-select-selector:after,
.webVueSelect.ant-select-single .ant-select-selector .ant-select-selection-item,
.webVueSelect.ant-select-single .ant-select-selector .ant-select-selection-placeholder {
  line-height: 1;
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

.webVueAntYtTreeSelectFormItem-rbt158s .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-rbt158s .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-rbqvok3 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-rbqvok3 .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-rbm9jff:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtIcon {
  width: 100%;
  height: 100%;
}

.webVueAntYtIcon img {
  width: 100%;
  height: 100%;
  max-width: 47px;
  max-height: 47px;
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

.webVueAntYtPictureStyle-rbsx9ht {
  opacity: 1;
}
.webVueAntYtPictureStyle-rbsx9ht img {
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

.webVueAntUploadButton {
  flex-wrap: nowrap;
}
.webVueAntUploadButton,
.webVueAntUploadButton .ant-form-item-control-input,
.webVueAntUploadButton .ant-form-item-control-input .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntUploadButton .ant-form-item-control-input {
  min-height: unset;
}
.webVueAntUploadButton .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntUploadButton .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntUploadButton
  .ant-form-item-label
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntUploadButton .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntUploadButton .ant-form-item-label > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntUploadButton .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntUploadButton.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntUploadButton .ant-form-item-content:focus {
  outline: none;
}
.webVueAntUploadButton .ant-btn,
.webVueAntUploadButton .ant-upload {
  width: 100%;
  height: 100%;
}

.webVueAntUploadButtonFormItem-rbbw9n7 {
  opacity: 1;
  flex-direction: row;
}
.webVueAntUploadButtonFormItem-rbbw9n7 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntUploadButtonFormItem-rbbw9n7 .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 38px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntUploadButtonFormItem-rbbw9n7 .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntUploadButtonFormItem-rbbw9n7 .ant-upload-list {
  max-width: 208px;
  max-height: 88px;
}
.webVueAntUploadButtonStyle-rbed4gh .ant-btn {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-weight: Normal;
  font-size: 14px;
  text-align: center;
  font-style: normal;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  background-color: #ffffff;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  box-shadow: 0px 0px 0px 0px transparent;
}
.webVueAntUploadButtonStyle-rbed4gh .ant-btn span {
  text-decoration: none;
}

.webVueAntYtSelectFormItem-rb {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtSelectFormItem-rb .ant-form-item-label label {
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
.webVueAntYtSelectFormItem-rb .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtSelectStyle-rb .ant-select-selector {
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
.webVueAntYtSelectStyle-rb.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtSelectStyle-rb.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtSelectStyle-rb .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-rb .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-rb .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-rb.ant-select-dropdown {
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
.popupKey-rb.ant-select-dropdown .ant-select-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-rb.ant-select-dropdown .ant-select-item-option-selected {
  background: #e6effe;
  color: #333333;
}
.popupKey-rb.ant-select-dropdown .ant-select-item:hover {
  background: #f0f0f0;
  color: #333333;
}
.popupKey-rb .ant-select-item-option-active:not(.ant-select-item-option-disabled) {
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

.webVueAntYtSelectFormItem-rbzseiu .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-rbzseiu .ant-form-item-label label {
  padding-right: 10px;
}

.webVueAntYtInputNumberFormItem-rb {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputNumberFormItem-rb .ant-form-item-label label {
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
.webVueAntYtInputNumberFormItem-rb .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputNumberStyle-rb {
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
.webVueAntYtInputNumberStyle-rb input {
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
.webVueAntYtInputNumberStyle-rb input::placeholder,
.webVueAntYtInputNumberStyle-rb input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntInputNumberFormItem {
  flex-wrap: nowrap;
}
.webVueAntSwitchFormItem .ant-form-item-control-input-content{
  display: flex;
  align-items: center;
}
.webVueAntSwitchFormItem .ant-form-item-label label {
  width: 96px !important;
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

.webVueAntYtInputNumberFormItem-rbhk3wq .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-rbhk3wq .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-rbxro3g {
  background: #ffffff !important;
}

.webVueAntYtTreeSelectFormItem-rbae10h .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-rbae10h .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-rbaxmb5 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-rbaxmb5 .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-rb4c6mi:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntUploadButtonFormItem-rbudesz {
  opacity: 1;
  flex-direction: row;
}
.webVueAntUploadButtonFormItem-rbudesz .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntUploadButtonFormItem-rbudesz .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 38px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntUploadButtonFormItem-rbudesz .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntUploadButtonFormItem-rbudesz .ant-upload-list {
  max-width: 208px;
  max-height: 88px;
}
.webVueAntUploadButtonStyle-rbns2w1 .ant-btn {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-weight: Normal;
  font-size: 14px;
  text-align: center;
  font-style: normal;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  background-color: #ffffff;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  box-shadow: 0px 0px 0px 0px transparent;
}
.webVueAntUploadButtonStyle-rbns2w1 .ant-btn span {
  text-decoration: none;
}

.webVueAntYtSelectFormItem-rbqzril .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-rbqzril .ant-form-item-label label {
  padding-right: 10px;
}

.webVueAntYtInputNumberFormItem-rb6tsmw .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputNumberFormItem-rb6tsmw .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputNumberStyle-rb488pu {
  background: #ffffff !important;
}

.webVueAntYtSpanStyle-rb {
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
.webVueAntYtSpanStyle-rb span {
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

.webVueAntYtSpanStyle-rbec7l7 {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-rbec7l7 span {
  text-decoration: none;
}
</style>
