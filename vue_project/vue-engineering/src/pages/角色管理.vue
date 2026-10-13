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
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-nklihb9 webVueAntYtRectangleStyle-nk webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="RoleNameisShow1"
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
        ref="ref3"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-nkkncq4 webVueAntYtInputFormItem-nk webVueAntYtInputFormItem show-label-nk show-label"
        name="RoleNamevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'角色名称：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-nkrvhq6 webVueAntYtInputStyle-nk webVueAntYtInputStyle"
          v-model:value="RoleNamevalue1"
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
        ref="ref8"
        @click="
          () => {
            searchRoles();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-nk26lcj webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
        :loading="Query1loading1"
      >
        <span class="yt-button-content" v-html="'查询'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.80000%"
      left="0.10000%"
      bottom="0.00000%"
      right="0.10000%"
      gridColumnStart="2"
      gridColumnEnd="100"
      gridRowStart="14"
      gridRowEnd="99"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref9"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-nkxwy0q webVueAntYtRectangleStyle-nk webVueAntYtRectangleStyle"
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
        ref="ref10"
        @click="
          () => {
            resetRoleSearch();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-nk9v5i2 webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
        :loading="Resetloading1"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="6.30000%"
      left="7.00000%"
      bottom="14.80000%"
      right="17.60000%"
      gridColumnStart="3"
      gridColumnEnd="8"
      gridRowStart="16"
      gridRowEnd="20"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref11"
        @click="
          () => {
            showAddRoleModal();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-nkj5yt6 webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
        :loading="Add1loading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="RoleListisShow1"
      top="1.20000%"
      left="0.30000%"
      bottom="0.20000%"
      right="0.30000%"
      gridColumnStart="3"
      gridColumnEnd="99"
      gridRowStart="20"
      gridRowEnd="92"
      zIndex="7"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref14"
        @onTableChange="
          (pagination) => {
            handleTableChange(pagination);
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-nkaerik webVueAntYtTableStyle-nk webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="RoleListselectedRows1"
        v-model:total="RoleListtotal1"
        v-model:current="RoleListcurrent2"
        v-model:pageSize="RoleListpageSize1"
        :columns="RoleListdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="RoleListdata1.dataSource"
        :scroll="{ y: 608.9999884007595 }"
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'operation'" :forKey="'operation'">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.30000%"
                left="107%"
                bottom="0.30000%"
                right="1.00000%"
                gridColumnStart="23"
                gridColumnEnd="49"
                gridRowStart="16"
                gridRowEnd="86"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref15"
                  @click="
                    () => {
                      showMenuPermissionsModal(record)
                      showFunctionPermissionsModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-nk4eknc webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
                  :loading="FunctionPermissionsloading1"
                >
                  <span class="yt-button-content" v-html="'权限配置'"> </span>
                </a-button>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.00000%"
                left="0.90000%"
                bottom="0.50000%"
                right="5.00000%"
                gridColumnStart="84"
                gridColumnEnd="98"
                gridRowStart="14"
                gridRowEnd="84"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref16"
                  @click="
                    () => {
                      confirmDeleteRole(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-nkf8x60 webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
                  :loading="Deleteloading1"
                >
                  <span class="yt-button-content" v-html="'删除'"> </span>
                </a-button>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.00000%"
                left="0.80000%"
                bottom="0.50000%"
                right="5.10000%"
                gridColumnStart="5"
                gridColumnEnd="19"
                gridRowStart="14"
                gridRowEnd="84"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-button
                  ref="ref17"
                  @click="
                    () => {
                      showEditModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-nkjvms2 webVueAntYtButtonStyle-nk webVueAntYtButtonStyle center-nk center"
                  :loading="Editloading1"
                >
                  <span class="yt-button-content" v-html="'编辑'"> </span>
                </a-button>
              </yt-grid-item>
            </yt-grid>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="AddedpopupwindowisShow1"
      top="1.00000%"
      left="1.60000%"
      bottom="1.30000%"
      right="1.40000%"
      gridColumnStart="37"
      gridColumnEnd="65"
      gridRowStart="32"
      gridRowEnd="70"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref43"
        @ok="
          () => {
            confirmAddRole();
          }
        "
        @cancel="
          () => {
            cancelAddRole();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-nk webVueAntYtModalStyle"
        v-model:isShow="AddedpopupwindowisShow1"
        :title="'新增角色'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="Addedpopupwindowform1" ref="ref43_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.50000%"
                left="1.10000%"
                bottom="1.00000%"
                right="1.20000%"
                gridColumnStart="10"
                gridColumnEnd="84"
                gridRowStart="12"
                gridRowEnd="24"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref44"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-nkura4z webVueAntYtInputFormItem-nk webVueAntYtInputFormItem show-label-nk show-label"
                  name="RoleName1value1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'角色名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-nkgwv78 webVueAntYtInputStyle-nk webVueAntYtInputStyle"
                    v-model:value="Addedpopupwindowform1.RoleName1value1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.90000%"
                left="1.10000%"
                bottom="7.10000%"
                right="1.20000%"
                gridColumnStart="10"
                gridColumnEnd="84"
                gridRowStart="31"
                gridRowEnd="44"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref45"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-nkgw82m webVueAntYtInputFormItem-nk webVueAntYtInputFormItem show-label-nk show-label"
                  name="RoleCodevalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'角色代号：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-nkwq7j0 webVueAntYtInputStyle-nk webVueAntYtInputStyle"
                    v-model:value="Addedpopupwindowform1.RoleCodevalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.10000%"
                left="0.50000%"
                bottom="1.70000%"
                right="1.40000%"
                gridColumnStart="19"
                gridColumnEnd="84"
                gridRowStart="50"
                gridRowEnd="88"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref46"
                  class="webVueAntTextAreaFormItem webVueAntYtTextAreaFormItem-nk4plmn webVueAntYtTextAreaFormItem-nk webVueAntYtTextAreaFormItem show-label-nk show-label"
                  name="Descriptionvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'描述：'"> </span>
                    </div>
                  </template>
                  <a-textarea
                    data-event
                    class="webVueAntTextarea webVueAntYtTextAreaStyle-nk3kcbd webVueAntYtTextAreaStyle-nk webVueAntYtTextAreaStyle"
                    v-model:value="Addedpopupwindowform1.Descriptionvalue1"
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
      :isShow="EditpopupwindowisShow1"
      top="0.40000%"
      left="1.60000%"
      bottom="1.60000%"
      right="1.40000%"
      gridColumnStart="37"
      gridColumnEnd="65"
      gridRowStart="41"
      gridRowEnd="73"
      zIndex="9"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref47"
        @ok="
          () => {
            confirmEditRole();
          }
        "
        @cancel="
          () => {
            cancelEditRole();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-nk webVueAntYtModalStyle"
        v-model:isShow="EditpopupwindowisShow1"
        :title="'编辑角色'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="Editpopupwindowform1" ref="ref47_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.90000%"
                left="1.10000%"
                bottom="4.70000%"
                right="1.20000%"
                gridColumnStart="10"
                gridColumnEnd="84"
                gridRowStart="15"
                gridRowEnd="31"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref48"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-nkrcm48 webVueAntYtInputFormItem-nk webVueAntYtInputFormItem show-label-nk show-label"
                  name="RoleNamevalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'角色名称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-nkpsskq webVueAntYtInputStyle-nk webVueAntYtInputStyle"
                    v-model:value="Editpopupwindowform1.RoleNamevalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.40000%"
                left="0.50000%"
                bottom="0.30000%"
                right="1.40000%"
                gridColumnStart="19"
                gridColumnEnd="84"
                gridRowStart="39"
                gridRowEnd="87"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref50"
                  class="webVueAntTextAreaFormItem webVueAntYtTextAreaFormItem-nkaj0va webVueAntYtTextAreaFormItem-nk webVueAntYtTextAreaFormItem show-label-nk show-label"
                  name="Descriptionvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'描述：'"> </span>
                    </div>
                  </template>
                  <a-textarea
                    data-event
                    class="webVueAntTextarea webVueAntYtTextAreaStyle-nkrsu2l webVueAntYtTextAreaStyle-nk webVueAntYtTextAreaStyle"
                    v-model:value="Editpopupwindowform1.Descriptionvalue2"
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
      :isShow="FunctionpermissionpopupwindowisShow1"
      top="1.00000%"
      left="2.10000%"
      bottom="1.70000%"
      right="0.70000%"
      gridColumnStart="30"
      gridColumnEnd="70"
      gridRowStart="19"
      gridRowEnd="70"
      zIndex="10"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref52"
        @ok="editPermissions"
        @cancel="
          () => {
            cancelFunctionPermissions();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-nk webVueAntYtModalStyle-nk1 webVueAntYtModalStyle"
        v-model:isShow="FunctionpermissionpopupwindowisShow1"
        :title="'权限配置'"
      >
        <template #content>
          <a-form
            class="webVueAntForm"
            :model="Functionpermissionpopupwindowform1"
            ref="ref52_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.50000%"
                left="0.10000%"
                bottom="1.20000%"
                right="0.90000%"
                gridColumnStart="7"
                gridColumnEnd="96"
                gridRowStart="3"
                gridRowEnd="91"
                zIndex="1"
                previewType="AdaptiveWH"
                style="flex-direction: column;"
              >
                <h3>功能权限</h3>
                <a-checkbox v-model:checked="checkAllAuths" @change="checkedAllAuths">全选</a-checkbox>
                <yt-tree
                  ref="ref60"
                  class="webVueAntYtTree webVueAntYtTreeStyle-nkc2i81 webVueAntYtTreeStyle-nk webVueAntYtTreeStyle"
                  v-model:expandedKeys="TreeexpandedKeys1"
                  v-model:checkedKeys="TreecheckedKeys1"
                  :checkable="true"
                  :switcherIcon="'./staticResource/public/switchIcon.svg'"
                  :showLine="true"
                  :lineHeight="'1.2'"
                  :fieldNames="{
                    children: 'permissionList',
                    title: 'title',
                    key: 'key',
                  }"
                  :options="options"
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
            </yt-grid>
          </a-form>
          <a-form
            class="webVueAntForm"
            :model="Menupermissionpopupwindowform1"
            ref="ref56_form"
          >
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.50000%"
                left="0.90000%"
                bottom="0.60000%"
                right="0.10000%"
                gridColumnStart="6"
                gridColumnEnd="96"
                gridRowStart="3"
                gridRowEnd="92"
                zIndex="1"
                previewType="AdaptiveWH"
                style="flex-direction: column;"
              >
                <h3>菜单权限</h3>
                <a-checkbox v-model:checked="checkAllMenus" @change="checkedAllMenus">全选</a-checkbox>
                <yt-tree
                  ref="ref61"
                  class="webVueAntYtTree webVueAntYtTreeStyle-nkdr0qe webVueAntYtTreeStyle-nk webVueAntYtTreeStyle"
                  checkStrictly
                  v-model:expandedKeys="Tree1expandedKeys1"
                  v-model:checkedKeys="Tree1checkedKeys1"
                  :checkable="true"
                  :switcherIcon="'./staticResource/public/switchIcon.svg'"
                  :showLine="true"
                  :lineHeight="'1.2'"
                  :options="menuTree"
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
      zIndex="12"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref58"
        class="webVueAntYtSpan webVueAntYtSpanStyle-nk5on0q webVueAntYtSpanStyle-nk webVueAntYtSpanStyle null-nk null"
      >
        <span v-html="'角色管理'"> </span>
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
      menuTree: [
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
        {
          title: "一级选项2",
          key: "一级选项2",
          disabled: false,
          select: false,
          iconUrl: "./staticResource/public/folder.svg",
          children: [
            {
              title: "二级选项4",
              key: "二级选项4",
              disabled: false,
              select: false,
              iconUrl: "./staticResource/public/folder.svg",
              children: [
                {
                  title: "三级选项6",
                  key: "三级选项6",
                  disabled: false,
                  select: false,
                  iconUrl: "./staticResource/public/leaf.svg",
                },
                {
                  title: "三级选项7",
                  key: "三级选项7",
                  disabled: false,
                  select: false,
                  iconUrl: "./staticResource/public/leaf.svg",
                },
              ],
            },
          ],
        },
      ],
      Query1loading1: false,
      RoleNamevalue1: "",
      RoleNameisShow1: true,
      Deleteloading1: false,
      Editloading1: false,
      FunctionpermissionpopupwindowisShow1: false,
      Functionpermissionpopupwindowform1: {
        id: null,
      },
      MenupermissionpopupwindowisShow1: false,
      Menupermissionpopupwindowform1: {
        id: null,
      },
      TreecheckedKeys1: [],
      TreeexpandedKeys1: [],
      Resetloading1: false,
      AddedpopupwindowisShow1: false,
      Addedpopupwindowform1: {
        id: null,
        RoleName1value1: "",
        RoleCodevalue1: "",
        Descriptionvalue1: "",
      },
      EditpopupwindowisShow1: false,
      Editpopupwindowform1: {
        id: null,
        RoleNamevalue2: "",
        Descriptionvalue2: "",
      },
      MenuPermissionsloading1: false,
      Tree1checkedKeys1: {checked: []},
      Tree1expandedKeys1: [],
      FunctionPermissionsloading1: false,
      RoleListcurrentRow1: {},
      RoleListselectedRows1: [],
      RoleListpageSize1: 10,
      RoleListdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "roleName",
            title: "角色名称",
            dataIndex: "roleName",
          },
          {
            key: "roleCode",
            title: "角色代号",
            dataIndex: "roleCode",
          },
          {
            key: "roleDescription",
            title: "角色描述",
            dataIndex: "roleDescription",
          },
          {
            key: "operation",
            title: "操作",
            dataIndex: "operation",
            cellType: "slot",
            width: undefined,
          },
        ],
        dataSource: [
          {
            id: 1,
            no: "1",
            status: "停用",
            identityCard: "",
            roleName: "",
            roleCode: "",
            operation: "",
          },
          {
            id: 2,
            no: "2",
            status: "启用",
            roleName: "",
          },
          {
            id: 8,
            no: "3",
            status: "",
            roleName: "",
          },
          {
            id: 7,
            no: "4",
            status: "",
            roleName: "",
          },
          {
            id: 6,
            no: "5",
            status: "",
            roleName: "",
          },
          {
            id: 5,
            no: "6",
            status: "",
            roleName: "",
          },
          {
            id: 4,
            no: "7",
            status: "",
            roleName: "",
          },
          {
            id: 3,
            no: "8",
            status: "",
            roleName: "",
          },
          {
            id: 0,
            no: "9",
            status: "",
            roleName: "",
          },
          {
            id: 9,
            no: "10",
            status: "",
            roleName: "",
          },
        ],
      },
      RoleListcurrent2: 1,
      RoleListtotal1: 10,
      RoleListisShow1: true,
      Add1loading1: false,
      options: [],
      allMenuKeys: [],
      checkAllMenus: false,
      allAuthKeys: [],
      checkAllAuths: false
    };
  },
  watch: {
    Tree1checkedKeys1 (val) {
      if (val.checked.length && val.checked.length === this.allMenuKeys.length) {
        this.checkAllMenus = true
      } else {
        this.checkAllMenus = false
      }
    },
    TreecheckedKeys1 (val) {
      if (val.length && val.length === this.allAuthKeys.length) {
        this.checkAllAuths = true
      } else {
        this.checkAllAuths = false
      }
    }
  },
  methods: {
    checkedAllMenus () {
      this.Tree1checkedKeys1.checked = this.checkAllMenus ? this.allMenuKeys : []
    },
    checkedAllAuths () {
      this.TreecheckedKeys1 = this.checkAllAuths ? this.allAuthKeys : []
    },
    async initializeRoleList() {
      try {
        const response = await this.executeBackendInterface("getRolesByPage", {
          roleName: this.RoleNamevalue1,
          current: this.RoleListcurrent2,
          pageSize: this.RoleListpageSize1,
        });
        if (response.flag) {
          this.RoleListdata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            roleName: item.role_name,
            roleCode: item.role_code,
            roleDescription: item.description,
          }));
          this.RoleListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("Failed to load roles.");
      }
    },
    async handleTableChange(pagination) {
      this.RoleListcurrent2 = pagination.current;
      this.RoleListpageSize1 = pagination.pageSize;
      await this.initializeRoleList();
    },
    async searchRoles() {
      try {
        this.RoleListcurrent2 = 1;
        const response = await this.executeBackendInterface("searchRolesByName", {
          roleName: this.RoleNamevalue1,
          current: this.RoleListcurrent2,
          pageSize: this.RoleListpageSize1,
        });
        if (response.flag) {
          this.RoleListdata1.dataSource = response.data.data.map((item) => ({
            id: item.id,
            roleName: item.role_name,
            roleCode: item.role_code,
            roleDescription: item.description,
          }));
          this.RoleListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("Failed to search roles.");
      }
    },
    async resetRoleSearch() {
      this.RoleListcurrent2 = 1;
      this.RoleNamevalue1 = "";
      await this.initializeRoleList();
    },
    async showEditModal(record) {
      this.Editpopupwindowform1 = {
        id: record.id,
        RoleNamevalue2: record.roleName,
        Descriptionvalue2: record.roleDescription,
      };
      this.EditpopupwindowisShow1 = true;
    },
    async confirmDeleteRole(record) {
      Modal.confirm({
        title: "确认删除",
        content: "确定要删除该角色吗？",
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface("deleteRole", {
              id: record.id,
            });
            if (response.flag) {
              message.success("删除成功");
              this.RoleListcurrent2 = 1
              await this.initializeRoleList();
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("Failed to delete role.");
          }
        },
      });
    },
    handleAllPermissionsResponse(data) {
      return data.map((item) => {
        const permissionList = item.permissionList || [];
        if (!permissionList.length) {
          this.allAuthKeys.push(item.code)
        }
        return {
          ...item,
          checkable: !permissionList.length,
          title: permissionList.length ? item.pageName : item.functionName,
          key: permissionList.length ? item.pageUuid : item.code,
          permissionList: this.handleAllPermissionsResponse(permissionList),
        };
      });
    },
    async showFunctionPermissionsModal(record) {
      try {
        const allPermissionsResponse = await this.executeBackendInterface(
          "getAllPermissions",
          {}
        );
        const rolePermissionsResponse = await this.executeBackendInterface(
          "getRolePermissions",
          {
            roleId: record.id,
          }
        );
        if (allPermissionsResponse.flag && rolePermissionsResponse.flag) {
          this.allAuthKeys = []
          this.options = this.handleAllPermissionsResponse(allPermissionsResponse.data);
          this.Functionpermissionpopupwindowform1.id = record.id;
          this.TreecheckedKeys1 = rolePermissionsResponse.data.map(
            (permission) => permission.code
          );
          this.FunctionpermissionpopupwindowisShow1 = true;
        } else {
          message.error("Failed to load permissions.");
        }
      } catch (error) {
        message.error("Failed to load permissions.");
      }
    },
    async updateFunctionPermissions() {
      try {
        const response = await this.executeBackendInterface("updateRolePermissions", {
          roleId: this.Functionpermissionpopupwindowform1.id,
          permissionIds: this.TreecheckedKeys1,
        });
        if (response.flag) {
          this.FunctionpermissionpopupwindowisShow1 = false;
          await this.initializeRoleList();
          return true
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("Failed to update permissions.");
      }
    },
    async showMenuPermissionsModal(record) {
      try {
        const allMenusResponse = await this.executeBackendInterface("getAllMenus", {});
        //{"title":"一级选项1","key":"一级选项1","disabled":false,"select":false,"iconUrl":"./staticResource/public/folder.svg","children"
        const transformData = (nodes) => {
          return nodes.map((node) => {
            this.allMenuKeys.push(node.id)
            return {
              key: node.id,
              title: node.menu_name,
              iconUrl: "./staticResource/public/folder.svg",
              children: node.children ? transformData(node.children) : [],
            }
          });
        };
        const roleMenusResponse = await this.executeBackendInterface("getRoleMenus", {
          roleId: record.id,
        });
        if (allMenusResponse.flag && roleMenusResponse.flag) {
          this.Menupermissionpopupwindowform1.id = record.id;
          this.Tree1checkedKeys1.checked = roleMenusResponse.data.map((menu) => menu.id);
          this.allMenuKeys = []
          this.menuTree = transformData(allMenusResponse.data);
        } else {
          message.error("Failed to load menus.");
        }
      } catch (error) {
        message.error("Failed to load menus.");
      }
    },
    async updateMenuPermissions() {
      try {
        const response = await this.executeBackendInterface("updateRoleMenus", {
          roleId: this.Menupermissionpopupwindowform1.id,
          menuIds: this.Tree1checkedKeys1.checked,
        });
        if (response.flag) {
          await this.initializeRoleList();
          return true
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("Failed to update menus.");
      }
    },
    async confirmAddRole() {
      try {
        const values = await this.$refs.ref43_form.validateFields();
        const response = await this.executeBackendInterface("addRole", {
          roleName: values.RoleName1value1,
          roleCode: values.RoleCodevalue1,
          description: values.Descriptionvalue1,
        });
        if (response.flag) {
          message.success("角色新增成功");
          this.AddedpopupwindowisShow1 = false;
          this.Addedpopupwindowform1 = {
            id: null,
            RoleName1value1: "",
            RoleCodevalue1: "",
            Descriptionvalue1: "",
          };
          await this.initializeRoleList();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("请检查表单项是否填写正确");
      }
    },
    async confirmEditRole() {
      try {
        const values = await this.$refs.ref47_form.validateFields();
        const response = await this.executeBackendInterface("updateRole", {
          id: this.Editpopupwindowform1.id,
          roleName: values.RoleNamevalue2,
          description: values.Descriptionvalue2,
        });
        if (response.flag) {
          message.success("角色更新成功");
          this.EditpopupwindowisShow1 = false;
          await this.initializeRoleList();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("请检查表单项是否填写正确");
      }
    },
    showAddRoleModal() {
      // 显示新增角色弹窗
      this.AddedpopupwindowisShow1 = true;
    },
    async editPermissions () {
      try {
        const functionData = await this.updateFunctionPermissions();
        const menuData = await this.updateMenuPermissions();
        if (functionData && menuData) {
          message.success("更新成功");
          window.dispatchEvent(new CustomEvent('refreshMenu'))
        } else {
          message.error("更新失败");
        }
      } catch (error) {
        message.error("更新失败");
      }
    },
    cancelAddRole() {
      // 关闭新增弹窗
      this.AddedpopupwindowisShow1 = false;

      // 清空表单项
      this.Addedpopupwindowform1.RoleName1value1 = "";
      this.Addedpopupwindowform1.RoleCodevalue1 = "";
      this.Addedpopupwindowform1.Descriptionvalue1 = "";
    },
    cancelEditRole() {
      // 关闭编辑弹窗
      this.EditpopupwindowisShow1 = false;

      // 清空数据
      this.Editpopupwindowform1.RoleNamevalue2 = "";
      this.Editpopupwindowform1.Descriptionvalue2 = "";
    },
    cancelFunctionPermissions() {
      // 关闭功能权限弹窗
      this.FunctionpermissionpopupwindowisShow1 = false;
    },
    cancelMenuPermissions() {
      // 关闭菜单权限弹窗
      this.MenupermissionpopupwindowisShow1 = false;
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1845285853039951872";
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
          .post("./Rolemanagement/" + funcName, params, {
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
    loadCss("./css/角色管理/theme.css");
    this.initializeRoleList();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
.webVueAntYtRectangleStyle-nk {
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

.webVueAntYtRectangleStyle-nklihb9 {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-nk {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-nk .ant-form-item-label label {
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
.webVueAntYtInputFormItem-nk .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-nk:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-nk.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-nk.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-nk:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-nk:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-nk input::placeholder,
.webVueAntYtInputStyle-nk input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-nkkncq4 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-nkkncq4 .ant-form-item-label label {
  width: 80px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-nkkncq4 .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-nkrvhq6:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-nk {
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
.webVueAntYtButtonStyle-nk > span {
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

.webVueAntYtButtonStyle-nk26lcj {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nk26lcj > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-nkxwy0q {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-nk9v5i2 {
  color: #333333 !important;
  background: transparent !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nk9v5i2 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-nkj5yt6 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nkj5yt6 > span {
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

.webVueAntYtTableStyle-nkaerik {
  opacity: 1;
}
.webVueAntYtTableStyle-nkaerik .ant-table {
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
.webVueAntYtTableStyle-nkaerik .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-nkaerik .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-nkaerik .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-nkaerik .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-nkaerik .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-nkaerik .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-nkaerik .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-nkaerik .ant-table thead tr th,
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-nkaerik .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-nkaerik .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-nkaerik.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-nkaerik.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-nkaerik .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-nkaerik
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-nkaerik .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-nkaerik
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-nkaerik .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-nkaerik .ant-pagination button,
.webVueAntYtTableStyle-nkaerik .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-nkaerik .ant-pagination li input {
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
.webVueAntYtTableStyle-nkaerik .ant-pagination button,
.webVueAntYtTableStyle-nkaerik .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-nkaerik .ant-pagination li input,
.webVueAntYtTableStyle-nkaerik .ant-pagination li a,
.webVueAntYtTableStyle-nkaerik .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-nkaerik .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-nkaerik
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-nkaerik
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-nkaerik .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-nkaerik .ant-pagination li a,
.webVueAntYtTableStyle-nkaerik .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-nkaerik .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-nkaerik .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-nkaerik tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-nkaerik tr > th:nth-child(1),
.webVueAntYtTableStyle-nkaerik .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: calc((100% - 245px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-nkaerik tr > th:nth-child(2),
.webVueAntYtTableStyle-nkaerik .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: calc((100% - 245px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-nkaerik tr > th:nth-child(3),
.webVueAntYtTableStyle-nkaerik .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 245px) / 3) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-nkaerik tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-nkaerik tr > th:nth-child(4),
.webVueAntYtTableStyle-nkaerik .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: 245px !important;
  min-width: 245px !important;
  max-width: 245px !important;
}
.webVueAntYtTableStyle-nkaerik {
  width: 100%;
}

.webVueAntYtButtonStyle-nk4eknc {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nk4eknc > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-nkf8x60 {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nkf8x60 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-nkjvms2 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nkjvms2 > span {
  letter-spacing: 0px !important;
}
.webVueAntYtModalStyle-nk1 .ant-modal-body {
  display: flex;
} 
.webVueAntYtModalStyle-nk .ant-modal-wrap {
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
.webVueAntYtModalStyle-nk .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-nk.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-nk .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-nk.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtInputFormItem-nkura4z .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-nkura4z .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-nkgwv78:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-nkgw82m .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-nkgw82m .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-nkwq7j0:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtTextAreaFormItem-nk {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtTextAreaFormItem-nk .ant-form-item-label label {
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
.webVueAntYtTextAreaFormItem-nk .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtTextAreaStyle-nk.ant-input {
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
.webVueAntYtTextAreaStyle-nk.ant-input,
.webVueAntYtTextAreaStyle-nk:not(.ant-input) .ant-input {
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
.webVueAntYtTextAreaStyle-nk.ant-input::placeholder,
.webVueAntYtTextAreaStyle-nk.ant-input::-webkit-input-placeholder,
.webVueAntYtTextAreaStyle-nk:not(.ant-input) .ant-input::placeholder,
.webVueAntYtTextAreaStyle-nk:not(.ant-input) .ant-input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntYtTextAreaStyle-nk.ant-input:disabled {
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

.webVueAntYtTextAreaFormItem-nk4plmn .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTextAreaFormItem-nk4plmn .ant-form-item-label label {
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtTextAreaStyle-nk3kcbd.ant-input {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-nkrcm48 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-nkrcm48 .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-nkpsskq:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtTextAreaFormItem-nkaj0va .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTextAreaFormItem-nkaj0va .ant-form-item-label label {
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtTextAreaStyle-nkrsu2l.ant-input {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-nkwgwb3 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-nkwgwb3 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtSpanStyle-nk {
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
.webVueAntYtSpanStyle-nk span {
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

.webVueAntYtSpanStyle-nk5on0q {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-nk5on0q span {
  text-decoration: none;
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

.webVueAntYtTreeStyle-nkc2i81.ant-tree {
  opacity: 1;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
}
.webVueAntYtTreeStyle-nkc2i81 .ant-tree-node-selected {
  background-color: #e6effe !important;
  color: #595959;
}
.webVueAntYtTreeStyle-nkc2i81 .ant-tree-node-content-wrapper:hover {
  background-color: #f5f5f5 !important;
  color: rgba(0, 0, 0, 0.88);
}
.webVueAntYtTreeStyle-nkc2i81 .ant-tree-node-content-wrapper {
  padding-left: 0px;
}

.webVueAntYtTreeStyle-nkdr0qe.ant-tree {
  opacity: 1;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
}
.webVueAntYtTreeStyle-nkdr0qe .ant-tree-node-selected {
  background-color: #e6effe !important;
  color: #595959;
}
.webVueAntYtTreeStyle-nkdr0qe .ant-tree-node-content-wrapper:hover {
  background-color: #f5f5f5 !important;
  color: rgba(0, 0, 0, 0.88);
}
.webVueAntYtTreeStyle-nkdr0qe .ant-tree-node-content-wrapper {
  padding-left: 0px;
}
</style>
