<template>
  <yt-grid previewType="AdaptiveWH" width="1700" height="1016" background="#F0F2F5">
    <yt-grid-item
      fixedSize="selfAdaption"
      top="7.80000%"
      left="0.50000%"
      bottom="3.50000%"
      right="0.20000%"
      gridColumnStart="16"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="13"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref1"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-ax972je webVueAntYtRectangleStyle-ax webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="3.00000%"
      bottom="6.30000%"
      right="0.20000%"
      gridColumnStart="17"
      gridColumnEnd="38"
      gridRowStart="7"
      gridRowEnd="11"
      zIndex="2"
      previewType="AdaptiveWH"
    >
      <a-form-item
        ref="ref2"
        class="webVueAntInputFormItem webVueAntYtInputFormItem-axh09un webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
        name="UserNamevalue1"
        :colon="false"
      >
        <template #label>
          <div class="label-content">
            <span class="ant-form-item-content" v-html="'用户名：'"> </span>
          </div>
        </template>
        <a-input
          data-event
          class="webVueAntinput webVueAntYtInputStyle-axlwxxj webVueAntYtInputStyle-ax webVueAntYtInputStyle"
          v-model:value="UserNamevalue1"
          :maxLength="100"
          :allowClear="true"
          :placeholder="'请输入'"
        >
        </a-input>
      </a-form-item>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="17.30000%"
      left="2.30000%"
      bottom="3.90000%"
      right="17.60000%"
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
            this.UserListcurrent2 = 1;
            queryUsersByNameAndOrg();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-axncajj webVueAntYtButtonStyle-ax webVueAntYtButtonStyle center-ax center"
        :loading="Queryloading1"
      >
        <span class="yt-button-content" v-html="'查询'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.70000%"
      left="0.50000%"
      bottom="1.10000%"
      right="0.20000%"
      gridColumnStart="16"
      gridColumnEnd="100"
      gridRowStart="14"
      gridRowEnd="100"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref4"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-axnazda webVueAntYtRectangleStyle-ax webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="14.80000%"
      left="16.40000%"
      bottom="6.30000%"
      right="3.50000%"
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
            resetAndQueryUsers();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-axf38uk webVueAntYtButtonStyle-ax webVueAntYtButtonStyle center-ax center"
        :loading="Reset1loading1"
      >
        <span class="yt-button-content" v-html="'重置'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="6.30000%"
      left="9.40000%"
      bottom="14.80000%"
      right="10.50000%"
      gridColumnStart="17"
      gridColumnEnd="22"
      gridRowStart="16"
      gridRowEnd="20"
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <a-button
        ref="ref6"
        @click="
          () => {
            showAddUserModal();
          }
        "
        class="webVueAntButton webVueAntYtButtonStyle-ax4b5ur webVueAntYtButtonStyle-ax webVueAntYtButtonStyle center-ax center"
        :loading="Newloading1"
      >
        <span class="yt-button-content" v-html="'新增'"> </span>
      </a-button>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="UserListisShow1"
      top="1.10000%"
      left="0.50000%"
      bottom="0.00000%"
      right="0.20000%"
      gridColumnStart="17"
      gridColumnEnd="99"
      gridRowStart="20"
      gridRowEnd="97"
      zIndex="7"
      previewType="AdaptiveWH"
    >
      <yt-table
        ref="ref7"
        @onTableChange="
          (pagination) => {
            onUserTableChange(pagination);
          }
        "
        class="webVueAntYtTable webVueAntYtTableStyle-axr877x webVueAntYtTableStyle-ax webVueAntYtTableStyle"
        :selectType="'checkbox'"
        :canSelect="false"
        v-model:selectedRows="UserListselectedRows1"
        v-model:total="UserListtotal1"
        v-model:current="UserListcurrent2"
        v-model:pageSize="UserListpageSize1"
        :columns="UserListdata1.columns"
        :showSizeChanger="true"
        :showQuickJumper="true"
        :dataSource="UserListdata1.dataSource"
        :scroll="{ y: 661.0000382001598 }"
      >
        <template #cell="{ column, record }">
          <template v-if="column.dataIndex === 'operation1'" :forKey="'operation1'">
            <div style="width: 100%; height: 100%; background: #fff; display: flex">
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6px;
                  width: 20.81%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref8"
                  @click="
                    () => {
                      showAssignRoleModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-axyuyat webVueAntYtButtonStyle center"
                  :loading="AssignRolesloading1"
                >
                  <span class="yt-button-content" v-html="'分配角色'"></span>
                </a-button>
              </div>
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6px;
                  width: 10.74%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref9"
                  @click="
                    () => {
                      deleteUser(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-axpwaev webVueAntYtButtonStyle center"
                  :loading="Deleteloading1"
                >
                  <span class="yt-button-content" v-html="'删除'"></span>
                </a-button>
              </div>
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6px;
                  width: 11.74%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref10"
                  @click="
                    () => {
                      showEditUserModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-axt82ab webVueAntYtButtonStyle center"
                  :loading="Editloading1"
                >
                  <span class="yt-button-content" v-html="'编辑'"></span>
                </a-button>
              </div>
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6px;
                  width: 20.81%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref11"
                  @click="
                    () => {
                      showResetPasswordModal(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-ax0l3ci webVueAntYtButtonStyle center"
                  :loading="ResetPasswordloading1"
                >
                  <span class="yt-button-content" v-html="'重置密码'"></span>
                </a-button>
              </div>
              <div
                style="
                  display: flex;
                  margin-left: 10px;
                  margin-top: 6px;
                  width: 11.74%;
                  height: 69.57%;
                  float: left;
                "
              >
                <!-- 状态1 -->
                <a-button
                  ref="ref24"
                  @click="
                    () => {
                      toggleUserStatusAndRefreshList(record);
                    }
                  "
                  class="webVueAntButton webVueAntYtButtonStyle-axamtc6 webVueAntYtButtonStyle center"
                  :loading="Unlockloading1"
                >
                  <span
                    class="yt-button-content"
                    v-if="record.status === '启用'"
                    v-html="'停用'"
                  ></span>
                  <span
                    class="yt-button-content"
                    v-else-if="record.status === '停用'"
                    v-html="'启用'"
                  ></span>
                </a-button>
              </div>
            </div>
          </template>
        </template>
      </yt-table>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="NewUserisShow1"
      top="1.20000%"
      left="2.50000%"
      bottom="0.10000%"
      right="0.60000%"
      gridColumnStart="38"
      gridColumnEnd="66"
      gridRowStart="11"
      gridRowEnd="75"
      zIndex="11"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref12"
        @ok="
          () => {
            addUserAndRefreshList();
          }
        "
        @cancel="
          () => {
            cancelAddUser();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-ax webVueAntYtModalStyle"
        v-model:isShow="NewUserisShow1"
        :title="'新增用户'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="NewUserform1" ref="ref12_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="OrganizationisShow1"
                top="9.20000%"
                left="0.70000%"
                bottom="5.40000%"
                right="1.30000%"
                gridColumnStart="14"
                gridColumnEnd="88"
                gridRowStart="8"
                gridRowEnd="15"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref28"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-axlbfxi webVueAntYtTreeSelectFormItem-ax webVueAntYtTreeSelectFormItem show-label-ax show-label"
                  name="Organizationvalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构：'"> </span>
                    </div>
                  </template>
                  <a-tree-select
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-ax webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="NewUserform1.Organizationvalue1"
                    :placeholder="'请输入'"
                    :treeCheckable="false"
                    :multiple="false"
                    :treeData="OrganizationtreeData1.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="9.30000%"
                left="0.00000%"
                bottom="5.30000%"
                right="1.30000%"
                gridColumnStart="21"
                gridColumnEnd="88"
                gridRowStart="19"
                gridRowEnd="26"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref29"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axd65w0 webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="AccountNumber1value1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'账号：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-ax1xuau webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="NewUserform1.AccountNumber1value1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="6.80000%"
                left="0.10000%"
                bottom="7.80000%"
                right="1.40000%"
                gridColumnStart="21"
                gridColumnEnd="88"
                gridRowStart="30"
                gridRowEnd="37"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref30"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axrfqix webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Nicknamevalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'昵称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axwuxdj webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="NewUserform1.Nicknamevalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="6.90000%"
                left="0.10000%"
                bottom="7.70000%"
                right="1.40000%"
                gridColumnStart="21"
                gridColumnEnd="88"
                gridRowStart="41"
                gridRowEnd="48"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref32"
                  class="webVueAntInputPasswordFormItem webVueAntYtInputPasswordFormItem-ax54pre webVueAntYtInputPasswordFormItem-ax webVueAntYtInputPasswordFormItem show-label-ax show-label"
                  name="Passwordvalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'密码：'"> </span>
                    </div>
                  </template>
                  <yt-custom-input-password
                    data-event
                    class="webVueAntInputPassword webVueAntYtInputPasswordStyle-axi26n1 webVueAntYtInputPasswordStyle-ax webVueAntYtInputPasswordStyle"
                    v-model:value="NewUserform1.Passwordvalue1"
                    :placeholder="'请输入'"
                    :maxlength="100"
                  >
                  </yt-custom-input-password>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.30000%"
                left="0.70000%"
                bottom="10.30000%"
                right="1.40000%"
                gridColumnStart="23"
                gridColumnEnd="88"
                gridRowStart="52"
                gridRowEnd="59"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref33"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axg38sv webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Emailvalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'邮箱：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axllrpr webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="NewUserform1.Emailvalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.40000%"
                left="0.90000%"
                bottom="10.20000%"
                right="1.40000%"
                gridColumnStart="20"
                gridColumnEnd="88"
                gridRowStart="63"
                gridRowEnd="70"
                zIndex="6"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref39"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axergnr webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Mobilephonenumbervalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'手机号：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axcug2w webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="NewUserform1.Mobilephonenumbervalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="1.90000%"
                left="0.70000%"
                bottom="12.70000%"
                right="1.40000%"
                gridColumnStart="23"
                gridColumnEnd="88"
                gridRowStart="74"
                gridRowEnd="81"
                zIndex="7"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref40"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axv6b23 webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Telephonevalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'电话：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axaijtp webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="NewUserform1.Telephonevalue1"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="9.20000%"
                left="1.30000%"
                bottom="5.40000%"
                right="2.20000%"
                gridColumnStart="23"
                gridColumnEnd="59"
                gridRowStart="83"
                gridRowEnd="90"
                zIndex="8"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref42"
                  class="webVueAntUploadButton webVueAntUploadButtonFormItem-axx4iw1 webVueAntUploadButtonStyle-axi8ovq webVueAntUploadButtonFormItem-ax webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-ax webVueAntUploadButtonStyle show-label-ax show-label"
                  name="AvatarfileList1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'头像：'"> </span>
                    </div>
                  </template>
                  <yt-upload-button-inner
                    data-event
                    :showUploadList="true"
                    :listType="'picture'"
                    :accept="'image/*'"
                    :multiple="false"
                    :maxCount="1"
                    @change="upload"
                  >
                  </yt-upload-button-inner>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="ResetPasswordPopupisShow1"
      top="0.80000%"
      left="1.10000%"
      bottom="1.90000%"
      right="1.60000%"
      gridColumnStart="39"
      gridColumnEnd="64"
      gridRowStart="27"
      gridRowEnd="59"
      zIndex="10"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref19"
        @ok="
          () => {
            resetPasswordAndRefreshList();
          }
        "
        @cancel="
          () => {
            cancelResetPassword();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-ax webVueAntYtModalStyle"
        v-model:isShow="ResetPasswordPopupisShow1"
        :title="'重置密码'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="ResetPasswordPopupform1" ref="ref19_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.70000%"
                left="0.90000%"
                bottom="0.00000%"
                right="0.00000%"
                gridColumnStart="13"
                gridColumnEnd="91"
                gridRowStart="35"
                gridRowEnd="51"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref53"
                  class="webVueAntInputPasswordFormItem webVueAntYtInputPasswordFormItem-axw2f4f webVueAntYtInputPasswordFormItem-ax webVueAntYtInputPasswordFormItem show-label-ax show-label"
                  name="NewPasswordvalue1"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'新密码：'"> </span>
                    </div>
                  </template>
                  <yt-custom-input-password
                    data-event
                    class="webVueAntInputPassword webVueAntYtInputPasswordStyle-axx7ew7 webVueAntYtInputPasswordStyle-ax webVueAntYtInputPasswordStyle"
                    v-model:value="ResetPasswordPopupform1.NewPasswordvalue1"
                    :placeholder="'请输入'"
                    :maxlength="100"
                  >
                  </yt-custom-input-password>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="AssignRolePopupisShow1"
      top="0.80000%"
      left="1.10000%"
      bottom="1.90000%"
      right="1.60000%"
      gridColumnStart="39"
      gridColumnEnd="64"
      gridRowStart="27"
      gridRowEnd="59"
      zIndex="12"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref21"
        @ok="
          () => {
            updateUserRoleAndRefreshList();
          }
        "
        @cancel="
          () => {
            cancelAssignRole();
          }
        "
        class="webVueAntYtModal webVueAntYtModalStyle-ax webVueAntYtModalStyle"
        v-model:isShow="AssignRolePopupisShow1"
        :title="'分配角色'"
      >
        <template #content>
          <a-form class="webVueAntForm" :model="AssignRolePopupform1" ref="ref21_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="RoleisShow1"
                top="4.70000%"
                left="1.00000%"
                bottom="0.00000%"
                right="0.80000%"
                gridColumnStart="7"
                gridColumnEnd="90"
                gridRowStart="35"
                gridRowEnd="51"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref22"
                  class="webVueSelectFormItem webVueAntYtSelectFormItem-axw4mi3 webVueAntYtSelectFormItem-ax webVueAntYtSelectFormItem show-label-ax show-label"
                  name="Rolevalue1"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'角色：'"> </span>
                    </div>
                  </template>
                  <a-select
                    data-event
                    class="webVueSelect webVueAntYtSelectStyle-ax webVueAntYtSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="AssignRolePopupform1.Rolevalue1"
                    :placeholder="'请输入'"
                    :mode="'multiple'"
                    :options="Roleoptions1.dataSource"
                    :showSearch="true"
                  >
                  </a-select>
                </a-form-item>
              </yt-grid-item>
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.60000%"
      left="1.20000%"
      bottom="0.00000%"
      right="2.50000%"
      gridColumnStart="2"
      gridColumnEnd="16"
      gridRowStart="5"
      gridRowEnd="99"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref23"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-axp4dh0 webVueAntYtRectangleStyle-ax webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="OrganizationTreeisShow1"
      top="0.70000%"
      left="5.80000%"
      bottom="0.70000%"
      right="0.00000%"
      gridColumnStart="2"
      gridColumnEnd="15"
      gridRowStart="9"
      gridRowEnd="98"
      zIndex="9"
      previewType="AdaptiveWH"
    >
      <yt-tree
        ref="ref26"
        @select="
          () => {
            this.UserListcurrent2 = 1;
            queryUsersByOrgTree();
            initOrgTree();
          }
        "
        class="webVueAntYtTree webVueAntYtTreeStyle-ax9t2pu webVueAntYtTreeStyle-ax webVueAntYtTreeStyle"
        v-model:expandedKeys="OrganizationTreeexpandedKeys1"
        v-model:selectedKeys="OrganizationTreeselectedKeys1"
        :switcherIcon="'./staticResource/public/switchIcon.svg'"
        :lineHeight="'1.2'"
        :options="OrganizationTreeoptions1.dataSource"
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
      :isShow="EditUserPopupisShow1"
      top="0.60000%"
      left="1.60000%"
      bottom="1.20000%"
      right="1.40000%"
      gridColumnStart="40"
      gridColumnEnd="68"
      gridRowStart="9"
      gridRowEnd="67"
      zIndex="13"
      previewType="AdaptiveWH"
    >
      <yt-custom-modal
        ref="ref43"
        class="webVueAntYtModal webVueAntYtModalStyle-ax webVueAntYtModalStyle"
        v-model:isShow="EditUserPopupisShow1"
        :title="'编辑用户'"
        @ok="
          () => {
            editUser();
          }
        "
        @cancel="
          () => {
            cancelEditUser();
          }
        "
      >
        <template #content>
          <a-form class="webVueAntForm" :model="EditUserPopupform1" ref="ref43_form">
            <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
              <yt-grid-item
                fixedSize="selfAdaption"
                :isShow="OrganizationisShow2"
                top="8.30000%"
                left="0.00000%"
                bottom="7.00000%"
                right="0.60000%"
                gridColumnStart="16"
                gridColumnEnd="89"
                gridRowStart="9"
                gridRowEnd="17"
                zIndex="1"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref44"
                  class="webVueTreeSelectFormItem webVueAntYtTreeSelectFormItem-axl580p webVueAntYtTreeSelectFormItem-ax webVueAntYtTreeSelectFormItem show-label-ax show-label"
                  name="Organizationvalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'组织机构：'"> </span>
                    </div>
                  </template>
                  <a-tree-select
                    class="webVueTreeSelect webVueAntYtTreeSelectStyle-ax webVueAntYtTreeSelectStyle"
                    dropdownClassName='"popupKey" "popupKeyId"'
                    :showArrow="true"
                    v-model:value="EditUserPopupform1.Organizationvalue2"
                    :placeholder="'请输入'"
                    :treeCheckable="false"
                    :multiple="false"
                    :treeData="OrganizationtreeData2.dataSource"
                    :showSearch="true"
                  >
                  </a-tree-select>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="4.40000%"
                left="0.90000%"
                bottom="11.00000%"
                right="0.60000%"
                gridColumnStart="22"
                gridColumnEnd="89"
                gridRowStart="22"
                gridRowEnd="30"
                zIndex="2"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref46"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-ax16tkm webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Nicknamevalue2"
                  :colon="false"
                  :rules="[{ required: true, message: '必填' }]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'昵称：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axljv8b webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="EditUserPopupform1.Nicknamevalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="0.50000%"
                left="0.00000%"
                bottom="2.80000%"
                right="0.60000%"
                gridColumnStart="25"
                gridColumnEnd="89"
                gridRowStart="35"
                gridRowEnd="42"
                zIndex="3"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref48"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axsbgsu webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Emailvalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'邮箱：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-axcn8u9 webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="EditUserPopupform1.Emailvalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="6.30000%"
                left="0.20000%"
                bottom="9.00000%"
                right="0.60000%"
                gridColumnStart="22"
                gridColumnEnd="89"
                gridRowStart="47"
                gridRowEnd="55"
                zIndex="4"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref49"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-axtyvmo webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Mobilephonenumbervalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'手机号：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-ax5vmb2 webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="EditUserPopupform1.Mobilephonenumbervalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="2.80000%"
                left="0.00000%"
                bottom="0.50000%"
                right="0.60000%"
                gridColumnStart="25"
                gridColumnEnd="89"
                gridRowStart="60"
                gridRowEnd="67"
                zIndex="5"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref50"
                  class="webVueAntInputFormItem webVueAntYtInputFormItem-ax6rieb webVueAntYtInputFormItem-ax webVueAntYtInputFormItem show-label-ax show-label"
                  name="Telephonevalue2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'电话：'"> </span>
                    </div>
                  </template>
                  <a-input
                    data-event
                    class="webVueAntinput webVueAntYtInputStyle-ax3rmn9 webVueAntYtInputStyle-ax webVueAntYtInputStyle"
                    v-model:value="EditUserPopupform1.Telephonevalue2"
                    :maxLength="100"
                    :placeholder="'请输入'"
                  >
                  </a-input>
                </a-form-item>
              </yt-grid-item>

              <yt-grid-item
                fixedSize="selfAdaption"
                top="8.30000%"
                left="0.00000%"
                bottom="7.00000%"
                right="0.70000%"
                gridColumnStart="25"
                gridColumnEnd="60"
                gridRowStart="72"
                gridRowEnd="80"
                zIndex="6"
                previewType="AdaptiveWH"
              >
                <a-form-item
                  ref="ref51"
                  class="webVueAntUploadButton webVueAntUploadButtonFormItem-axxii5j webVueAntUploadButtonStyle-axiukg6 webVueAntUploadButtonFormItem-ax webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-ax webVueAntUploadButtonStyle show-label-ax show-label"
                  name="AvatarfileList2"
                  :colon="false"
                  :rules="[]"
                >
                  <template #label>
                    <div class="label-content">
                      <span class="ant-form-item-content" v-html="'头像：'"> </span>
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
            </yt-grid>
          </a-form>
        </template>
      </yt-custom-modal>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="width"
      comWidth="58.00px"
      top="20.30000%"
      left="16.40000%"
      bottom="14.00000%"
      right="15.20000%"
      gridColumnStart="2"
      gridColumnEnd="7"
      gridRowStart="6"
      gridRowEnd="9"
      zIndex="14"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref54"
        class="webVueAntYtSpan webVueAntYtSpanStyle-ax7yvjk webVueAntYtSpanStyle-ax webVueAntYtSpanStyle webVueAntYtSpanBrCount-ax webVueAntYtSpanBrCount"
      >
        <span v-html="'组织机构'"> </span>
      </span>
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
      zIndex="15"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref55"
        class="webVueAntYtSpan webVueAntYtSpanStyle-ax9mwrl webVueAntYtSpanStyle-ax webVueAntYtSpanStyle null-ax null"
      >
        <span v-html="'用户管理'"> </span>
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
      Reset1loading1: false,
      EditUserPopupisShow1: false,
      EditUserPopupform1: {
        id: null,
        Organizationvalue2: [],
        Nicknamevalue2: "",
        Emailvalue2: "",
        Mobilephonenumbervalue2: "",
        Telephonevalue2: "",
        avatar: "",
      },
      UserNamevalue1: "",
      Deleteloading1: false,
      Editloading1: false,
      Unlockloading1: false,
      Queryloading1: false,
      OrganizationtreeData2: {
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
          {
            label: "一级选项2",
            value: "一级选项2",
            disabled: false,
            select: false,
            children: [
              {
                label: "二级选项4",
                value: "二级选项4",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项6",
                    value: "三级选项6",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项7",
                    value: "三级选项7",
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
      OrganizationisShow2: true,
      OrganizationTreeselectedKeys1: [],
      OrganizationTreeexpandedKeys1: [],
      OrganizationTreeoptions1: {
        dataSource: [
          {
            title: "系统",
            key: "系统",
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
      OrganizationTreeisShow1: true,
      AssignRolePopupisShow1: false,
      AssignRolePopupform1: {
        id: null,
        Rolevalue1: [],
      },
      OrganizationtreeData1: {
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
          {
            label: "一级选项2",
            value: "一级选项2",
            disabled: false,
            select: false,
            children: [
              {
                label: "二级选项4",
                value: "二级选项4",
                disabled: false,
                select: false,
                children: [
                  {
                    label: "三级选项6",
                    value: "三级选项6",
                    disabled: false,
                    select: false,
                  },
                  {
                    label: "三级选项7",
                    value: "三级选项7",
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
      OrganizationisShow1: true,
      UserListcurrentRow1: {},
      UserListselectedRows1: [],
      UserListpageSize1: 10,
      UserListdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "accountNumber",
            title: "账号",
            dataIndex: "accountNumber",
          },
          {
            key: "nickname",
            title: "昵称",
            dataIndex: "nickname",
          },
          {
            key: "email",
            title: "邮箱",
            dataIndex: "email",
          },
          {
            key: "mobilephonenumber",
            title: "手机号",
            dataIndex: "mobilephonenumber",
          },
          {
            key: "telephone",
            title: "电话",
            dataIndex: "telephone",
          },
          {
            key: "status",
            title: "状态",
            dataIndex: "status",
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
            nickname: "",
            operation1: "",
            accountNumber: "",
          },
          {
            id: 2,
            no: "2",
            accountNumber: "",
          },
          {
            id: 8,
            no: "3",
            accountNumber: "",
          },
          {
            id: 7,
            no: "4",
            accountNumber: "",
          },
          {
            id: 6,
            no: "5",
            accountNumber: "",
          },
          {
            id: 5,
            no: "6",
            accountNumber: "",
          },
          {
            id: 4,
            no: "7",
            accountNumber: "",
          },
          {
            id: 3,
            no: "8",
            accountNumber: "",
          },
          {
            id: 0,
            no: "9",
            accountNumber: "",
          },
          {
            id: 9,
            no: "10",
            accountNumber: "",
          },
        ],
      },
      UserListcurrent2: 1,
      UserListtotal1: 10,
      UserListisShow1: true,
      ResetPasswordPopupisShow1: false,
      ResetPasswordPopupform1: {
        id: null,
        NewPasswordvalue1: "",
      },
      Roleoptions1: {
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
      RoleisShow1: true,
      AssignRolesloading1: false,
      ResetPasswordloading1: false,
      NewUserisShow1: false,
      NewUserform1: {
        id: null,
        Organizationvalue1: [],
        AccountNumber1value1: "",
        Nicknamevalue1: "",
        Passwordvalue1: "",
        Emailvalue1: "",
        Mobilephonenumbervalue1: "",
        Telephonevalue1: "",
        avatar: "",
      },
      Newloading1: false,
    };
  },
  watch: {},
  methods: {
    upload(fileList) {
      if (fileList[0].originFileObj) {
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
              if (this.NewUserisShow1) {
                this.NewUserform1.avatar = response.data.data
              } else {
                this.EditUserPopupform1.avatar = response.data.data
              }
              resolve(response.data);
            })
            .catch((error) => {
              reject(error);
            });
        });
      }
    },
    async updateUserRoleAndRefreshList() {
      try {
        const response = await this.executeBackendInterface("updateUserRoles", {
          userId: this.UserListcurrentRow1.id,
          roleIds: this.AssignRolePopupform1.Rolevalue1,
        });
        if (response.flag) {
          message.success("角色更新成功");
          this.AssignRolePopupisShow1 = false;
          await this.queryUsersByNameAndOrg();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("角色更新失败");
      }
    },
    async resetAndQueryUsers() {
      this.UserNamevalue1 = "";
      this.UserListcurrent2 = 1;
      await this.queryUsersByOrgTree();
    },
    async queryUsersByNameAndOrg() {
      try {
        const response = await this.executeBackendInterface("getUsers", {
          userName: this.UserNamevalue1,
          orgIds: this.OrganizationTreeselectedKeys1,
          current: this.UserListcurrent2,
          pageSize: this.UserListpageSize1,
        });
        if (response.flag) {
          this.UserListdata1.dataSource = response.data.data.map((user) => ({
            id: user.id,
            accountNumber: user.user_name,
            nickname: user.nick_name,
            email: user.email,
            mobilephonenumber: user.mobile,
            telephone: user.phone,
            status: this.getStatus(user.status),
          }));
          this.UserListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("用户查询失败");
      }
    },
    getStatus (code) {
      if (code === 0) {
        return '启用'
      } else if (code === 1) {
        return '删除'
      } else if (code === 2) {
        return '停用'
      }
    },
    async initUserList() {
      await this.queryUsersByNameAndOrg();
    },
    async onUserTableChange(pagination) {
      this.UserListcurrent2 = pagination.current;
      this.UserListpageSize1 = pagination.pageSize;
      await this.queryUsersByNameAndOrg();
    },
    async showEditUserModal(record) {
      try {
        const response = await this.executeBackendInterface("showEditUserModal", {
          userId: record.id,
        });
        if (response.flag) {
          this.EditUserPopupform1 = {
            id: response.data.id,
            Organizationvalue2: response.data.organization_id,
            Nicknamevalue2: response.data.nick_name,
            Emailvalue2: response.data.email,
            Mobilephonenumbervalue2: response.data.mobile,
            Telephonevalue2: response.data.phone,
            avatar: response.data.avatar,
          };
          this.EditUserPopupisShow1 = true;
          this.initEditOrgDropdown();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取用户信息失败");
      }
    },
    async deleteUser(record) {
      Modal.confirm({
        title: "确认删除",
        content: "确定要删除该用户吗？",
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface("deleteUser", {
              userId: record.id,
            });
            if (response.flag) {
              message.success("用户删除成功");
              this.UserListcurrent2 = 1;
              await this.queryUsersByNameAndOrg();
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("用户删除失败");
          }
        },
      });
    },
    async addUserAndRefreshList() {
      try {
        const values = await this.$refs.ref12_form.validateFields();
        const response = await this.executeBackendInterface("addUser", {
          userName: values.AccountNumber1value1,
          nickName: values.Nicknamevalue1,
          email: values.Emailvalue1,
          mobile: values.Mobilephonenumbervalue1,
          phone: values.Telephonevalue1,
          password: values.Passwordvalue1,
          avatar: this.NewUserform1.avatar,
          orgId: values.Organizationvalue1[0],
        });
        if (response.flag) {
          message.success("用户添加成功");
          this.NewUserisShow1 = false;
          await this.queryUsersByNameAndOrg();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("用户添加失败");
      }
    },
    async resetPasswordAndRefreshList() {
      // 弹出确认对话框
      Modal.confirm({
        title: "确认重置密码",
        content: "您确定要重置该用户的密码吗？",
        onOk: async () => {
          try {
            // 调用后端接口重置密码
            const response = await this.executeBackendInterface(
              "showResetPasswordModal",
              {
                id: this.ResetPasswordPopupform1.id,
                NewPasswordvalue1: this.ResetPasswordPopupform1.NewPasswordvalue1,
              }
            );

            // 检查接口调用结果
            if (response.flag) {
              message.success(response.message);
              this.ResetPasswordPopupisShow1 = false; // 关闭弹窗
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("重置密码失败，请稍后重试");
          }
        },
        onCancel: () => {
          // 取消操作
          this.ResetPasswordPopupisShow1 = false; // 关闭弹窗
        },
      });
    },
    async queryUsersByOrgTree() {
      try {
        const response = await this.executeBackendInterface("getUsers", {
          userName: "",
          orgIds: this.OrganizationTreeselectedKeys1,
          current: this.UserListcurrent2,
          pageSize: this.UserListpageSize1,
        });
        if (response.flag) {
          this.UserListdata1.dataSource = response.data.data.map((user) => ({
            id: user.id,
            accountNumber: user.user_name,
            nickname: user.nick_name,
            email: user.email,
            mobilephonenumber: user.mobile,
            telephone: user.phone,
            status: this.getStatus(user.status),
          }));
          this.UserListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("用户查询失败");
      }
    },
    cancelAssignRole() {
      this.AssignRolePopupisShow1 = false;
    },
    handleOrgData(data) {
      return data.map((item) => {
        const children = item.children || [];
        this.OrganizationTreeexpandedKeys1.push(item.key.toString());
        return {
          title: item.title,
          key: item.key.toString(),
          // 确保key是字符串类型
          disabled: false,
          select: false,
          iconUrl: "./staticResource/public/folder.svg",
          children: this.handleOrgData(children),
        };
      });
    },
    async initOrgTree() {
      try {
        // 调用后端接口获取组织机构树数据
        const response = await this.executeBackendInterface("getOrgTreeData", {});

        // 检查接口调用是否成功
        if (response.flag) {
          // 将返回的数据格式化为组件所需的格式
          // 默认展开所有树节点
          this.OrganizationTreeexpandedKeys1 = [];
          this.OrganizationTreeoptions1.dataSource = this.handleOrgData(response.data);
        } else {
          // 如果接口调用失败，显示错误信息
          message.error(response.message);
        }
      } catch (error) {
        // 捕获并处理任何错误
        message.error("获取组织机构树数据失败");
      }
    },
    showAddUserModal() {
      // 显示新增用户弹窗
      this.NewUserisShow1 = true;

      // 将组织机构树的选中的组织结构作为组织机构的值
      this.NewUserform1 = {
        id: null,
        Organizationvalue1: this.OrganizationTreeselectedKeys1,
        AccountNumber1value1: "",
        Nicknamevalue1: "",
        Passwordvalue1: "",
        Emailvalue1: "",
        Mobilephonenumbervalue1: "",
        Telephonevalue1: "",
        avatar: "",
      };
      this.initOrgDropdown();
    },
    async editUser() {
      try {
        const response = await this.executeBackendInterface("updateUser", {
          userName: this.EditUserPopupform1.AccountNumber1value2,
          nickName: this.EditUserPopupform1.Nicknamevalue2,
          email: this.EditUserPopupform1.Emailvalue2,
          mobile: this.EditUserPopupform1.Mobilephonenumbervalue2,
          phone: this.EditUserPopupform1.Telephonevalue2,
          password: this.EditUserPopupform1.Passwordvalue2,
          avatar: this.EditUserPopupform1.avatar,
          orgId: this.EditUserPopupform1.Organizationvalue2,
          id: this.EditUserPopupform1.id,
        });
        if (response.flag) {
          message.success("用户修改成功");
          this.EditUserPopupisShow1 = false;
          await this.queryUsersByNameAndOrg();
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("用户修改失败");
      }
    },
    cancelEditUser() {
      this.EditUserPopupisShow1 = false;
      this.EditUserPopupform1 = {
        id: null,
        Organizationvalue2: [],
        Nicknamevalue2: "",
        Emailvalue2: "",
        Mobilephonenumbervalue2: "",
        Telephonevalue2: "",
        avatar: "",
      };
    },
    cancelAddUser() {
      // 关闭新增用户弹窗
      this.NewUserisShow1 = false;

      // 清空表单项
      this.NewUserform1 = {
        id: null,
        Organizationvalue1: [],
        AccountNumber1value1: "",
        Nicknamevalue1: "",
        Passwordvalue1: "",
        Emailvalue1: "",
        Mobilephonenumbervalue1: "",
        Telephonevalue1: "",
        avatar: "",
      };
    },
    async toggleUserStatusAndRefreshList(record) {
      Modal.confirm({
        title: "确认操作",
        content: `确定要切换用户状态吗？`,
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface("toggleUserStatus", {
              id: record.id,
            });
            if (response.flag) {
              message.success("用户状态切换成功");
              await this.refreshUserList();
            } else {
              message.error(`操作失败: ${response.message}`);
            }
          } catch (error) {
            message.error("操作失败，请重试");
          }
        },
        onCancel: () => {},
      });
    },
    async refreshUserList() {
      try {
        const response = await this.executeBackendInterface("getUsersL12", {
          current: this.UserListcurrent2,
          pageSize: this.UserListpageSize1,
        });
        if (response.flag) {
          this.UserListdata1.dataSource = response.data.data.map((user) => ({
            id: user.id,
            accountNumber: user.user_name,
            nickname: user.nick_name,
            email: user.email,
            mobilephonenumber: user.mobile,
            telephone: user.phone,
            status: this.getStatus(user.status),
            operation1: "",
          }));
          this.UserListtotal1 = response.data.total;
        } else {
          message.error(`获取用户列表失败: ${response.message}`);
        }
      } catch (error) {
        message.error("获取用户列表失败，请重试");
      }
    },
    async showAssignRoleModal(record) {
      // 打开分配角色弹窗
      this.AssignRolePopupisShow1 = true;
      this.UserListcurrentRow1 = record;
      // 获取当前行用户的角色信息
      try {
        const response = await this.executeBackendInterface("getUserRoles", {
          userId: record.id,
        });
        if (response.flag) {
          // 将用户拥有的角色设置为选中
          const userRoles = response.data.map((role) => role.id.toString());
          this.AssignRolePopupform1.Rolevalue1 = userRoles;
          this.AssignRolePopupform1.id = record.id;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取用户角色信息失败");
      }

      // 获取所有角色信息
      try {
        const response = await this.executeBackendInterface("getAllRoles", {});
        if (response.flag) {
          // 显示所有角色
          this.Roleoptions1.dataSource = response.data.map((role) => ({
            label: role.role_name,
            value: role.id.toString(),
          }));
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取所有角色信息失败");
      }
    },
    cancelResetPassword() {
      // 关闭重置密码弹窗
      this.ResetPasswordPopupisShow1 = false;

      // 清空弹窗内容
      this.ResetPasswordPopupform1.NewPasswordvalue1 = "";
    },
    async showResetPasswordModal(record) {
      // 显示重置密码弹窗
      this.ResetPasswordPopupisShow1 = true;

      // 将表格当前行用户的id赋值给表单
      this.ResetPasswordPopupform1.id = record.id;
      this.ResetPasswordPopupform1.NewPasswordvalue1 = "";
    },
    handleOrganizationTreeoptions1(data) {
      return data.map((item) => {
        const children = item.children || [];
        return {
          label: item.title,
          value: item.key,
          disabled: item.disabled,
          select: item.select,
          children: this.handleOrganizationTreeoptions1(children),
        };
      });
    },
    initOrgDropdown() {
      // 将组织机构树的树数据作为下拉树的选项
      this.OrganizationtreeData1.dataSource = this.handleOrganizationTreeoptions1(
        this.OrganizationTreeoptions1.dataSource
      );
    },
    initEditOrgDropdown() {
      this.OrganizationtreeData2.dataSource = this.OrganizationTreeoptions1.dataSource.map(
        (item) => ({
          label: item.title,
          value: item.key,
          disabled: item.disabled,
          select: item.select,
          children: item.children
            ? item.children.map((child) => ({
                label: child.title,
                value: child.key,
                disabled: child.disabled,
                select: child.select,
                children: child.children
                  ? child.children.map((grandchild) => ({
                      label: grandchild.title,
                      value: grandchild.key,
                      disabled: grandchild.disabled,
                      select: grandchild.select,
                    }))
                  : [],
              }))
            : [],
        })
      );
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1845285953279623168";
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
          .post("./Usermanagement/" + funcName, params, {
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
    loadCss("./css/用户管理/theme.css");
    this.initUserList();
    // 在组件挂载时初始化组织机构树
    this.initOrgTree();
    this.initOrgDropdown();
    this.initEditOrgDropdown();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {},
};
</script>
<style lang="less">
.webVueAntYtRectangleStyle-ax {
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

.webVueAntYtRectangleStyle-ax972je {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-ax {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-ax .ant-form-item-label label {
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
.webVueAntYtInputFormItem-ax .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-ax:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-ax.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-ax.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-ax:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-ax:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-ax input::placeholder,
.webVueAntYtInputStyle-ax input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-axh09un .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axh09un .ant-form-item-label label {
  width: 100px;
  padding-right: 10px;
}
.webVueAntYtInputFormItem-axh09un .ant-form-item-label label .label-content {
  text-align: right;
  text-align-last: right;
}
.webVueAntYtInputStyle-axlwxxj:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtButtonStyle-ax {
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
.webVueAntYtButtonStyle-ax > span {
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

.webVueAntYtButtonStyle-axncajj {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axncajj > span {
  letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-axnazda {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-axf38uk {
  color: #333333 !important;
  background: transparent !important;
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axf38uk > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-ax4b5ur {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-ax4b5ur > span {
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

.webVueAntYtTableStyle-axr877x {
  opacity: 1;
}
.webVueAntYtTableStyle-axr877x .ant-table {
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
.webVueAntYtTableStyle-axr877x .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-axr877x .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-axr877x .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-axr877x .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-thead tr th div:first-child {
  height: 48px;
}
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-thead tr th div.ant-table-selection {
  line-height: 48px;
}
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-thead tr th {
  background: #eaeef3;
}
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-thead tr span.th-text {
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
.webVueAntYtTableStyle-axr877x .ant-table tbody tr td {
  height: 48px;
}
.webVueAntYtTableStyle-axr877x .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 48px;
}
.webVueAntYtTableStyle-axr877x .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-axr877x .ant-table thead tr th,
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-axr877x .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-axr877x .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-axr877x.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-axr877x.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-axr877x .ant-table tbody tr:not(.ant-table-row-selected):hover td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-axr877x
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-axr877x .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-axr877x
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-axr877x .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-axr877x .ant-pagination button,
.webVueAntYtTableStyle-axr877x .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-axr877x .ant-pagination li input {
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
.webVueAntYtTableStyle-axr877x .ant-pagination button,
.webVueAntYtTableStyle-axr877x .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-axr877x .ant-pagination li input,
.webVueAntYtTableStyle-axr877x .ant-pagination li a,
.webVueAntYtTableStyle-axr877x .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-axr877x
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-axr877x
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-axr877x .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-axr877x .ant-pagination li a,
.webVueAntYtTableStyle-axr877x .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-axr877x .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-axr877x .ant-pagination li.ant-pagination-item-active a {
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
.webVueAntYtTableStyle-axr877x tr td:nth-child(1) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(1) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(1),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(1) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(2) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(2) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(2),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(2) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(3) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(3) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(3),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(3) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(4) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(4) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(4),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(4) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(5) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(5) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(5),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(5) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(6) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(6) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(6),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(6) {
  width: calc((100% - 300px) / 6) !important;
  min-width: 1px !important;
  max-width: 1px !important;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(7) div:first-child {
  text-align: center;
  text-align-last: center;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-axr877x tr td:nth-child(7) div:first-child span.td-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: 50px;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTableStyle-axr877x tr > th:nth-child(7),
.webVueAntYtTableStyle-axr877x .ant-table-body tr.ant-table-measure-row td:nth-child(7) {
  width: 300px !important;
  min-width: 300px !important;
  max-width: 300px !important;
}
.webVueAntYtTableStyle-axr877x {
  width: 100%;
}

.webVueAntYtButtonStyle-axyuyat {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axyuyat > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-axpwaev {
  color: #f84c55 !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axpwaev > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-axt82ab {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axt82ab > span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-ax0l3ci {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-ax0l3ci > span {
  letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-ax .ant-modal-wrap {
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
.webVueAntYtModalStyle-ax .ant-modal-wrap .yt-custom-modal-header {
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
.webVueAntYtModalStyle-ax.yt-custom-modal .ant-modal-header {
  height: 45px;
  background: #ffffff;
}
.webVueAntYtModalStyle-ax .ant-modal-wrap .ant-modal-close-x {
  height: 45px;
  line-height: 45px;
}
.webVueAntYtModalStyle-ax.yt-custom-modal .ant-modal-footer {
  height: 57px;
  background: #ffffff;
}
.webVueAntYtModal {
  width: 100%;
  height: 100%;
}

.webVueAntYtSelectFormItem-ax {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtSelectFormItem-ax .ant-form-item-label label {
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
.webVueAntYtSelectFormItem-ax .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtSelectStyle-ax .ant-select-selector {
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
.webVueAntYtSelectStyle-ax.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtSelectStyle-ax.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtSelectStyle-ax .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-ax .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtSelectStyle-ax .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-ax.ant-select-dropdown {
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
.popupKey-ax.ant-select-dropdown .ant-select-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-ax.ant-select-dropdown .ant-select-item-option-selected {
  background: #e6effe;
  color: #333333;
}
.popupKey-ax.ant-select-dropdown .ant-select-item:hover {
  background: #f0f0f0;
  color: #333333;
}
.popupKey-ax .ant-select-item-option-active:not(.ant-select-item-option-disabled) {
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
  overflow: auto;
}

.webVueAntYtSelectFormItem-axw4mi3 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtSelectFormItem-axw4mi3 .ant-form-item-label label {
  padding-right: 10px;
}

.webVueAntYtRectangleStyle-axp4dh0 {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-axamtc6 {
  color: #1890ff !important;
  background: transparent !important;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-bottom: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-axamtc6 > span {
  letter-spacing: 0px !important;
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

.webVueAntYtTreeStyle-ax9t2pu.ant-tree {
  opacity: 1;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
}
.webVueAntYtTreeStyle-ax9t2pu .ant-tree-node-selected {
  background-color: #e6effe !important;
  color: #595959;
}
.webVueAntYtTreeStyle-ax9t2pu .ant-tree-node-content-wrapper:hover {
  background-color: #f5f5f5 !important;
  color: rgba(0, 0, 0, 0.88);
}
.webVueAntYtTreeStyle-ax9t2pu .ant-tree-node-content-wrapper {
  padding-left: 0px;
}

.webVueAntYtTreeSelectFormItem-ax {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtTreeSelectFormItem-ax .ant-form-item-label label {
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
.webVueAntYtTreeSelectFormItem-ax .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtTreeSelectStyle-ax .ant-select-selector {
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
.webVueAntYtTreeSelectStyle-ax.ant-select:not(.ant-select-disabled):hover
  .ant-select-selector,
.webVueAntYtTreeSelectStyle-ax.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input)
  .ant-select-selector {
  border-right: 1px solid #cdcdcd !important;
}
.webVueAntYtTreeSelectStyle-ax .ant-select-selector .ant-select-selection-item {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-ax .ant-select-selector .ant-select-selection-search input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal !important;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-ax .ant-select-selector .ant-select-selection-placeholder {
  color: #999999;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.webVueAntYtTreeSelectStyle-ax.ant-select-multiple
  .ant-select-selector
  .ant-select-selection-placeholder {
  left: 12px !important;
}
.popupKey-ax.ant-select-dropdown {
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
.popupKey-ax.ant-select-dropdown .ant-select-tree {
  background: #ffffff !important;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
}
.popupKey-ax.ant-select-dropdown
  .ant-select-tree-treenode-checkbox-checked
  .ant-select-tree-node-content-wrapper {
  background: #e6effe;
  color: #333333;
}
.popupKey-ax.ant-select-dropdown .ant-select-tree-node-content-wrapper:hover {
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
  overflow: auto;
}
.webVueTreeSelect.ant-select-single
  .ant-select-selector
  .ant-select-selection-placeholder,
.webVueTreeSelect.ant-select-single .ant-select-selector {
  display: flex;
  align-items: center;
}

.webVueAntYtTreeSelectFormItem-axlbfxi .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-axlbfxi .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-axd65w0 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axd65w0 .ant-form-item-label label {
  width: 64px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-ax1xuau:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axrfqix .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axrfqix .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-axwuxdj:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputPasswordFormItem-ax {
  opacity: 1;
  flex-direction: row;
}
.webVueAntYtInputPasswordFormItem-ax .ant-form-item-label label {
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
.webVueAntYtInputPasswordFormItem-ax .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputPasswordStyle-ax {
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
.webVueAntYtInputPasswordStyle-ax input.ant-input {
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  line-height: undefined;
  letter-spacing: undefined;
  vertical-align: undefined;
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputPasswordStyle-ax input::placeholder,
.webVueAntYtInputPasswordStyle-ax input::-webkit-input-placeholder {
  color: #999999;
}
.webVueAntInputPasswordFormItem {
  flex-wrap: nowrap;
}
.webVueAntInputPasswordFormItem,
.webVueAntInputPassword,
.webVueAntInputPasswordFormItem .ant-form-item-control-input,
.webVueAntInputPasswordFormItem
  .ant-form-item-control-input
  .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntInputPasswordFormItem .ant-form-item-control-input {
  min-height: unset !important;
}
.webVueAntInputPasswordFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntInputPasswordFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntInputPasswordFormItem
  .ant-form-item-label
  > label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputPasswordFormItem .ant-form-item-label label .label-content {
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputPasswordFormItem
  .ant-form-item-label
  > label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputPasswordFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputPasswordFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputPasswordFormItem .ant-form-item-content:focus {
  outline: none;
}
.webVueAntInputPassword .ant-input {
  background-color: transparent;
}

.webVueAntYtInputPasswordFormItem-ax54pre .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputPasswordFormItem-ax54pre .ant-form-item-label label {
  width: 63px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtInputPasswordStyle-axi26n1 {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axg38sv .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axg38sv .ant-form-item-label label {
  padding-right: 10px;
}
.webVueAntYtInputStyle-axllrpr:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axergnr .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axergnr .ant-form-item-label label {
  width: 66px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-axcug2w:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axv6b23 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axv6b23 .ant-form-item-label label {
  padding-right: 10px;
}
.webVueAntYtInputStyle-axaijtp:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
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

.webVueAntUploadButtonFormItem-axx4iw1 {
  opacity: 1;
  flex-direction: row;
}
.webVueAntUploadButtonFormItem-axx4iw1 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntUploadButtonFormItem-axx4iw1 .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 52px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntUploadButtonFormItem-axx4iw1 .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntUploadButtonFormItem-axx4iw1 .ant-upload-list {
  max-width: 208px;
  max-height: 88px;
}
.webVueAntUploadButtonStyle-axi8ovq .ant-btn {
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
.webVueAntUploadButtonStyle-axi8ovq .ant-btn span {
  text-decoration: none;
}

.webVueAntYtTreeSelectFormItem-axl580p .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtTreeSelectFormItem-axl580p .ant-form-item-label label {
  width: 91px;
  padding-right: 10px;
}

.webVueAntYtInputFormItem-ax16tkm .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-ax16tkm .ant-form-item-label label {
  width: 63px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-axljv8b:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axsbgsu .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axsbgsu .ant-form-item-label label {
  padding-right: 10px;
}
.webVueAntYtInputStyle-axcn8u9:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-axtyvmo .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-axtyvmo .ant-form-item-label label {
  width: 66px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-ax5vmb2:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-ax6rieb .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-ax6rieb .ant-form-item-label label {
  padding-right: 10px;
}
.webVueAntYtInputStyle-ax3rmn9:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntUploadButtonFormItem-axxii5j {
  opacity: 1;
  flex-direction: row;
}
.webVueAntUploadButtonFormItem-axxii5j .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntUploadButtonFormItem-axxii5j .ant-form-item-label label {
  text-decoration: none;
  font-style: normal;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  width: 52px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntUploadButtonFormItem-axxii5j .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntUploadButtonFormItem-axxii5j .ant-upload-list {
  max-width: 208px;
  max-height: 88px;
}
.webVueAntUploadButtonStyle-axiukg6 .ant-btn {
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
.webVueAntUploadButtonStyle-axiukg6 .ant-btn span {
  text-decoration: none;
}

.webVueAntYtInputPasswordFormItem-axw2f4f .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputPasswordFormItem-axw2f4f .ant-form-item-label label {
  width: 77px;
  padding-top: 0px;
  padding-right: 10px;
  padding-bottom: 0px;
}
.webVueAntYtInputPasswordStyle-axx7ew7 {
  background: #ffffff !important;
}

.webVueAntYtSpanStyle-ax {
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
.webVueAntYtSpanStyle-ax span {
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

.webVueAntYtSpanStyle-ax7yvjk {
  color: #3d3d3d !important;
  font-weight: bold;
}
.webVueAntYtSpanStyle-ax7yvjk span {
  text-decoration: none;
}

.webVueAntYtSpanStyle-ax9mwrl {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-ax9mwrl span {
  text-decoration: none;
}
</style>
