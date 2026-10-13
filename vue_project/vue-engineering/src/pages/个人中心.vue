<template>
  <yt-grid previewType="AdaptiveWH" width="1700" height="1016" background="#F0F2F5">
    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.60000%"
      left="0.80000%"
      bottom="0.90000%"
      right="3.90000%"
      gridColumnStart="2"
      gridColumnEnd="23"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="1"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref1"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-qubmz5i webVueAntYtRectangleStyle-qu webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="0.70000%"
      left="0.40000%"
      bottom="0.90000%"
      right="0.20000%"
      gridColumnStart="23"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="2"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref2"
        class="webVueAntYtRectangle webVueAntYtRectangleStyle-qusirjr webVueAntYtRectangleStyle-qu webVueAntYtRectangleStyle"
      ></div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.70000%"
      left="0.90000%"
      bottom="3.10000%"
      right="0.00000%"
      gridColumnStart="2"
      gridColumnEnd="21"
      gridRowStart="43"
      gridRowEnd="72"
      zIndex="3"
      previewType="AdaptiveWH"
    >
      <yt-tree
        ref="ref5"
        @select="
          (selectedKeys) => {
            this.TreeselectedKeys1 = selectedKeys;
            handleTreeSelect();
          }
        "
        class="webVueAntYtTree webVueAntYtTreeStyle-quinjl1 webVueAntYtTreeStyle-qu webVueAntYtTreeStyle"
        v-model:expandedKeys="TreeexpandedKeys1"
        v-model:selectedKeys="TreeselectedKeys1"
        :switcherIcon="'./staticResource/public/switchIcon.svg'"
        :lineHeight="'1.5'"
        :blockNode="true"
        :options="[
          {
            title: '个人信息',
            key: '个人信息',
            disabled: false,
            select: true,
            iconUrl:
              './staticResource/wzc/1845284868271898624/0/x1NGd7ORwdxrXLKx4rs4o.png',
          },
          {
            title: '个人消息',
            key: '个人消息',
            disabled: false,
            select: false,
            iconUrl:
              './staticResource/wzc/1845284868271898624/0/yBIkArl03aTcGzH7VUbcD.png',
          },
        ]"
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
      fixedSize="width"
      comWidth="144.00px"
      top="18.70000%"
      left="6.40000%"
      bottom="2.50000%"
      right="8.80000%"
      gridColumnStart="7"
      gridColumnEnd="17"
      gridRowStart="29"
      gridRowEnd="34"
      zIndex="4"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref8"
        class="webVueAntYtSpan webVueAntYtSpanStyle-qu4rej8 webVueAntYtSpanStyle-qu webVueAntYtSpanStyle webVueAntYtSpanBrCount-qu webVueAntYtSpanBrCount"
      >
        <span v-html="'系统管理员'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="MessageListisShow2"
      top="0.60000%"
      left="0.40000%"
      bottom="0.90000%"
      right="0.20000%"
      gridColumnStart="23"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="5"
      previewType="AdaptiveWH"
    >
      <yt-dynamic-panel
        ref="ref9"
        class="webVueAntYtDynamicPanel"
        mutileStyle='[{"statusId":"3","info":{}}]'
      >
        <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
          <yt-grid-item
            fixedSize="selfAdaption"
            top="0.00000%"
            left="0.70000%"
            bottom="0.90000%"
            right="0.70000%"
            gridColumnStart="2"
            gridColumnEnd="100"
            gridRowStart="10"
            gridRowEnd="99"
            zIndex="1"
            previewType="AdaptiveWH"
          >
            <yt-table
              ref="ref11"
              @onTableChange="
                (pagination) => {
                  handleTableChange(pagination);
                }
              "
              :canSelect="false"
              v-model:selectedRows="MessageListselectedRows1"
              v-model:total="MessageListtotal1"
              v-model:current="MessageListcurrent1"
              v-model:pageSize="MessageListpageSize1"
              :columns="MessageListdata1.columns"
              :showSizeChanger="true"
              :showQuickJumper="true"
              :dataSource="MessageListdata1.dataSource"
              :scroll="{ y: 500 }"
              :class="[
                'webVueAntYtTable',
                'webVueAntYtTableStyle-qu9qy11-' + MessageListselectKey1,
                'webVueAntYtTableStyle-qu',
                'webVueAntYtTableStyle',
              ]"
            >
              <template #cell="{ column, record }">
                <template v-if="column.dataIndex === 'status'" :forKey="'status'">
                  <yt-grid
                    previewType="AdaptiveWH"
                    width="100%"
                    height="100%"
                  >
                    <yt-grid-item
                      fixedSize="width"
                      rotate="0"
                      comWidth="84.00px"
                      top="0.30000%"
                      left="2.70000%"
                      bottom="0.30000%"
                      right="0.40000%"
                      gridColumnStart="18"
                      gridColumnEnd="49"
                      gridRowStart="43"
                      gridRowEnd="72"
                      zIndex="1"
                      previewType="AdaptiveWH"
                    >
                      <span
                        v-if="record.status !== '已读'"
                        ref="ref14"
                        class="webVueAntYtSpan webVueAntYtSpanStyle-bh1fxm0 webVueAntYtSpanStyle-bh webVueAntYtSpanStyle webVueAntYtSpanBrCount-bh webVueAntYtSpanBrCount"
                      >
                      </span>
                    </yt-grid-item>
                  </yt-grid>
                </template>
              </template>
            </yt-table>
          </yt-grid-item>

          <yt-grid-item
            :isShow="!!MessageListdata1.dataSource.length"
            fixedSize="selfAdaption"
            top="132.40000%"
            left="-63.730000%"
            bottom="-103.90000%"
            right="46.50000%"
            gridColumnStart="91"
            gridColumnEnd="99"
            gridRowStart="5"
            gridRowEnd="9"
            zIndex="2"
            previewType="AdaptiveWH"
          >
            <a-button
              ref="ref13"
              @click="
                () => {
                  markAllMessagesAsRead();
                }
              "
              :loading="AllReadloading1"
              :class="[
                'webVueAntButton',
                'webVueAntYtButtonStyle-qumxgo5-' + MessageListselectKey1,
                'webVueAntYtButtonStyle-qu',
                'webVueAntYtButtonStyle',
                'center-qu',
                'center',
              ]"
            >
              <span class="yt-button-content" v-html="AllReadbuttonState1.content">
              </span>
            </a-button>
          </yt-grid-item>
        </yt-grid>
      </yt-dynamic-panel>
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
      zIndex="6"
      previewType="AdaptiveWH"
    >
      <span
        ref="ref10"
        class="webVueAntYtSpan webVueAntYtSpanStyle-qud9vz5 webVueAntYtSpanStyle-qu webVueAntYtSpanStyle null-qu null"
      >
        <span v-html="'个人中心'"> </span>
      </span>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      top="1.20000%"
      left="0.50000%"
      bottom="5.40000%"
      right="4.70000%"
      gridColumnStart="7"
      gridColumnEnd="17"
      gridRowStart="12"
      gridRowEnd="29"
      zIndex="7"
      previewType="AdaptiveWH"
    >
      <div
        ref="ref20"
        class="webVueAntYtIcon webVueAntYtPictureStyle-quqe3bg webVueAntYtPictureStyle-qu webVueAntYtPictureStyle"
      >
        <img
          :src="'./staticResource/wzc/1845284868271898624/0/fi04tr8ms_faCBGzJ5x2w.png'"
          class="yt-static-qu yt-static"
        />
      </div>
    </yt-grid-item>

    <yt-grid-item
      fixedSize="selfAdaption"
      :isShow="PersonalInformationFormisShow1"
      top="0.60000%"
      left="0.40000%"
      bottom="0.90000%"
      right="0.20000%"
      gridColumnStart="23"
      gridColumnEnd="100"
      gridRowStart="5"
      gridRowEnd="100"
      zIndex="8"
      previewType="AdaptiveWH"
    >
      <yt-dynamic-panel
        ref="ref25"
        class="webVueAntYtDynamicPanel"
        mutileStyle='[{"statusId":"1","info":{}}]'
      >
        <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
          <yt-grid-item
            fixedSize="selfAdaption"
            top="0.00000%"
            left="2.20000%"
            bottom="15.60000%"
            right="9.60000%"
            gridColumnStart="4"
            gridColumnEnd="11"
            gridRowStart="51"
            gridRowEnd="55"
            zIndex="2"
            previewType="AdaptiveWH"
          >
            <a-button
              ref="ref34"
              @click="
                () => {
                  submitUserInformation();
                }
              "
              :loading="UpdateInformationloading1"
              :class="[
                'webVueAntButton',
                'webVueAntYtButtonStyle-qu8821k-' + PersonalInformationselectKey1,
                'webVueAntYtButtonStyle-qu',
                'webVueAntYtButtonStyle',
                'center-qu',
                'center',
              ]"
            >
              <span
                class="yt-button-content"
                v-html="UpdateInformationbuttonState1.content"
              >
              </span>
            </a-button>
          </yt-grid-item>

          <yt-grid-item
            fixedSize="selfAdaption"
            top="0.80000%"
            left="1.50000%"
            bottom="1.40000%"
            right="0.60000%"
            gridColumnStart="2"
            gridColumnEnd="63"
            gridRowStart="2"
            gridRowEnd="56"
            zIndex="1"
            previewType="AdaptiveWH"
          >
            <a-form
              ref="ref36"
              :model="PersonalInformationFormform1"
              :class="[
                'webVueAntForm',
                'webVueAntYtFormStyle-qu',
                'webVueAntYtFormStyle',
              ]"
            >
              <yt-grid previewType="AdaptiveWH" width="100%" height="100%">
                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="3.30000%"
                  left="1.10000%"
                  bottom="6.20000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="2"
                  gridRowEnd="14"
                  zIndex="1"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref37"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-quuyojf webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
                    name="AccountNumbervalue1"
                    :colon="false"
                    :rules="[]"
                  >
                    <template #label>
                      <div class="label-content">
                        <span class="ant-form-item-content" v-html="'账号：'"> </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-qu0np0m webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.AccountNumbervalue1"
                      :disabled="true"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </yt-grid-item>

                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="3.80000%"
                  left="1.10000%"
                  bottom="5.70000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="17"
                  gridRowEnd="29"
                  zIndex="2"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref38"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-qusdq73 webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
                    name="Nicknamevalue1"
                    :colon="false"
                    :rules="[]"
                  >
                    <template #label>
                      <div class="label-content">
                        <span class="ant-form-item-content" v-html="'昵称：'"> </span>
                      </div>
                    </template>
                    <a-input
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-qujreqq webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.Nicknamevalue1"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </yt-grid-item>

                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="2.70000%"
                  left="1.10000%"
                  bottom="6.90000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="32"
                  gridRowEnd="44"
                  zIndex="3"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref39"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-quvswho webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
                    name="Passwordvalue1"
                    :colon="false"
                    :rules="[]"
                  >
                    <template #label>
                      <div class="label-content">
                        <span class="ant-form-item-content" v-html="'密码：'"> </span>
                      </div>
                    </template>
                    <yt-custom-input-password
                      data-event
                      class="webVueAntinput webVueAntYtInputStyle-qusv0up webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.Passwordvalue1"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </yt-custom-input-password>
                  </a-form-item>
                </yt-grid-item>

                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="1.60000%"
                  left="1.10000%"
                  bottom="3.30000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="47"
                  gridRowEnd="58"
                  zIndex="4"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref40"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-quprywk webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
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
                      class="webVueAntinput webVueAntYtInputStyle-qunb72u webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.Emailvalue1"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </yt-grid-item>

                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="5.30000%"
                  left="1.10000%"
                  bottom="7.60000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="61"
                  gridRowEnd="73"
                  zIndex="5"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref41"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-qu2jhuc webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
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
                      class="webVueAntinput webVueAntYtInputStyle-qutru9f webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.Mobilephonenumbervalue1"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </yt-grid-item>

                <yt-grid-item
                  fixedSize="selfAdaption"
                  top="0.90000%"
                  left="1.10000%"
                  bottom="4.10000%"
                  right="0.30000%"
                  gridColumnStart="1"
                  gridColumnEnd="81"
                  gridRowStart="76"
                  gridRowEnd="87"
                  zIndex="6"
                  previewType="AdaptiveWH"
                >
                  <a-form-item
                    ref="ref42"
                    class="webVueAntInputFormItem webVueAntYtInputFormItem-qurf28f webVueAntYtInputFormItem-qu webVueAntYtInputFormItem show-label-qu show-label"
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
                      class="webVueAntinput webVueAntYtInputStyle-qu6bixm webVueAntYtInputStyle-qu webVueAntYtInputStyle"
                      v-model:value="PersonalInformationFormform1.Telephonevalue1"
                      :maxLength="100"
                      :placeholder="'请输入'"
                    >
                    </a-input>
                  </a-form-item>
                </yt-grid-item>
              </yt-grid>
            </a-form>
          </yt-grid-item>
        </yt-grid>
      </yt-dynamic-panel>
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
      PersonalInformationFormform1: {
        id: null,
        AccountNumbervalue1: "",
        Nicknamevalue1: "",
        Passwordvalue1: "",
        Emailvalue1: "",
        Mobilephonenumbervalue1: "",
        Telephonevalue1: "",
      },
      PersonalInformationFormstateKey1: "2",
      PersonalInformationFormisShow1: true,
      PersonalInformationselectKey1: "1",
      PersonalInformationisShow1: true,
      MessageListselectedRows1: [],
      MessageListpageSize1: 10,
      MessageListstateKey1: "1",
      MessageListdata1: {
        columns: [
          {
            key: "id",
            title: "id",
            dataIndex: "id",
          },
          {
            key: "status",
            title: " ",
            dataIndex: "status",
            cellType: "slot",
          },
          {
            key: "messageContent",
            title: "消息内容",
            dataIndex: "messageContent",
          },
          {
            key: "creationtime1",
            title: "",
            dataIndex: "creationtime1",
          },
        ],
        dataSource: [
          {
            id: 1,
            name: "标题1",
            messageContent: "标题1",
            creationtime1: "2024-10-10",
          },
          {
            id: 2,
            name: "标题2",
            messageContent: "标题2",
          },
        ],
      },
      MessageListcurrent1: 1,
      MessageListtotal1: 10,
      MessageListisShow2: true,
      MessageListselectKey1: "3",
      MessageListisShow1: false,
      UpdateInformationstateKey1: "2",
      UpdateInformationloading1: false,
      AllReadstateKey1: "2",
      AllReadloading1: false,
      AllReadisShow1: true,
      TreeselectedKeys1: ["个人信息"],
      TreeexpandedKeys1: []
    };
  },
  watch: {},
  methods: {
    async handleTreeSelect() {
      // 获取当前选中的树节点
      const selectedKeys = this.TreeselectedKeys1;

      // 调用后端接口
      const response = await this.executeBackendInterface("handleTreeSelect", {
        selectedKeys: selectedKeys,
      });

      // 检查接口调用是否成功
      if (response.flag) {
        // 根据返回的数据更新前端状态
        const data = response.data;
        this.MessageListisShow2 = data.MessageListisShow2;
        this.PersonalInformationFormisShow1 = data.PersonalInformationFormisShow1;
      } else {
        // 接口调用失败，显示错误信息
        message.error(response.message);
      }
    },
    async initializeMessageList() {
      try {
        const response = await this.executeBackendInterface("getUserMessagesByPage", {
          current: this.MessageListcurrent1,
          pageSize: this.MessageListpageSize1,
        });
        if (response.flag) {
          const data = response.data.data.map((item) => ({
            id: item.id,
            status: item.status,
            messageContent: item.message_content,
            creationtime1: item.created_at,
          }));
          this.MessageListdata1.dataSource = data;
          this.MessageListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("加载消息列表失败");
      }
    },
    async handleTableChange(pagination) {
      this.MessageListcurrent1 = pagination.current;
      this.MessageListpageSize1 = pagination.pageSize;
      await this.initializeMessageList();
    },
    async markAllMessagesAsRead() {
      // 弹出确认对话框
      Modal.confirm({
        title: "确认操作",
        content: "确定将所有未读消息标记为已读吗？",
        onOk: async () => {
          // 设置加载状态
          this.AllReadloading1 = true;
          try {
            // 调用后端接口
            const response = await this.executeBackendInterface(
              "updateAllMessagesToRead",
              {}
            );
            if (response.flag) {
              // 更新消息列表中的状态
              this.MessageListdata1.dataSource = this.MessageListdata1.dataSource.map(
                (item) => {
                  return {
                    ...item,
                    status: "已读",
                  };
                }
              );
              message.success("所有消息已标记为已读");
            } else {
              message.error(response.message || "操作失败");
            }
          } catch (error) {
            message.error("请求失败，请稍后重试");
          } finally {
            // 取消加载状态
            this.AllReadloading1 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        },
      });
    },
    async initializeUserInformation() {
      try {
        const response = await this.executeBackendInterface("getUserInformation", {});
        if (response.flag) {
          const data = response.data;
          this.PersonalInformationFormform1 = {
            id: data.id || null,
            AccountNumbervalue1: data.AccountNumbervalue1 || "",
            Nicknamevalue1: data.Nicknamevalue1 || "",
            Passwordvalue1: "",
            Emailvalue1: data.Emailvalue1 || "",
            Mobilephonenumbervalue1: data.Mobilephonenumbervalue1 || "",
            Telephonevalue1: data.Telephonevalue1 || "",
          };
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error("获取用户信息失败");
      }
    },
    async submitUserInformation() {
      // 显示确认对话框
      Modal.confirm({
        title: "确认更新",
        content: "您确定要更新个人信息吗？",
        onOk: async () => {
          try {
            // 设置加载状态
            this.UpdateInformationloading1 = true;

            // 调用后端接口更新用户信息
            const response = await this.executeBackendInterface("updateUserInformation", {
              AccountNumbervalue1: this.PersonalInformationFormform1.AccountNumbervalue1,
              Nicknamevalue1: this.PersonalInformationFormform1.Nicknamevalue1,
              Passwordvalue1: this.PersonalInformationFormform1.Passwordvalue1,
              Emailvalue1: this.PersonalInformationFormform1.Emailvalue1,
              Mobilephonenumbervalue1: this.PersonalInformationFormform1
                .Mobilephonenumbervalue1,
              Telephonevalue1: this.PersonalInformationFormform1.Telephonevalue1,
            });

            // 检查接口调用结果
            if (response.flag) {
              message.success(response.message);
            } else {
              message.error(response.message);
            }
          } catch (error) {
            message.error("更新失败，请稍后重试");
          } finally {
            // 取消加载状态
            this.UpdateInformationloading1 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        },
      });
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = "1846750856301510656";
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
          .post("./Personalcenter/" + funcName, params, {
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
    showPerson () {
      this.TreeselectedKeys1 = ['个人信息'];
      this.MessageListisShow2 = false;
      this.PersonalInformationFormisShow1 = true;
    },
    showMessage () {
      this.TreeselectedKeys1 = ["个人消息"];
      this.MessageListisShow2 = true;
      this.PersonalInformationFormisShow1 = false;
    }
  },
  created () {
    window.addEventListener('showPerson', this.showPerson)
    window.addEventListener('showMessage', this.showMessage)
  },
  mounted() {
    loadCss("./css/个人中心/theme.css");
    this.initializeMessageList();
    this.initializeUserInformation();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  beforeRouteEnter(to, from, next) {
    next((vm) => {
      if (to?.query?.showMessage === 'true') {
        vm.showMessage()
      } else {
        vm.showPerson()
      }
    });
  },
  computed: {
    MessageListmodalState1() {
      switch (this.MessageListselectKey1) {
        case "3":
          return {
            statusId: "3",
          };
        default:
          console.log("状态不存在!");
          return {
            statusId: "3",
          };
      }
    },
    AllReadbuttonState1() {
      switch (this.MessageListselectKey1) {
        case "3":
          return {
            content: "全部已读",
            statusId: "3",
          };
        default:
          console.log("状态不存在!");
          return {
            content: "全部已读",
            statusId: "3",
          };
      }
    },
    UpdateInformationbuttonState1() {
      switch (this.PersonalInformationselectKey1) {
        case "1":
          return {
            content: "更新信息<br>",
            statusId: "1",
          };
        default:
          console.log("状态不存在!");
          return {
            content: "更新信息<br>",
            statusId: "1",
          };
      }
    },
    PersonalInformationFormformState1() {
      switch (this.PersonalInformationselectKey1) {
        case "1":
          return {
            statusId: "1",
          };
        default:
          console.log("状态不存在!");
          return {
            statusId: "1",
          };
      }
    },
  },
};
</script>
<style lang="less">
.webVueAntYtRectangleStyle-qu {
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

.webVueAntYtRectangleStyle-qubmz5i {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtRectangleStyle-qusirjr {
  background: #ffffff;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
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

.webVueAntYtTreeStyle-quinjl1.ant-tree {
  opacity: 1;
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 20px;
  font-weight: 500;
  letter-spacing: 0px;
}
.webVueAntYtTreeStyle-quinjl1 .ant-tree-node-selected {
  background-color: #e6effe !important;
  color: #595959;
}
.webVueAntYtTreeStyle-quinjl1 .ant-tree-node-content-wrapper:hover {
  background-color: #f5f5f5 !important;
  color: rgba(0, 0, 0, 0.88);
}
.webVueAntYtTreeStyle-quinjl1 .ant-tree-node-content-wrapper {
  padding-left: 0px;
}

.webVueAntYtSpanStyle-qu {
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
.webVueAntYtSpanStyle-qu span {
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

.webVueAntYtSpanStyle-qu4rej8 {
  color: #3d3d3d !important;
  font-size: 25px;
  text-align: center;
  text-align-last: center;
}
.webVueAntYtSpanStyle-qu4rej8 span {
  text-decoration: none;
}

.webVueAntYtSpanStyle-qud9vz5 {
  color: #999999 !important;
}
.webVueAntYtSpanStyle-qud9vz5 span {
  text-decoration: none;
}

.webVueAntYtTable {
  display: inline-block;
  flex: 1;
}
.webVueAntYtTable thead tr th:nth-child(1) {
  width: 15px;
}
.webVueAntYtTable thead tr th:nth-child(3) {
  width: 180px;
}
.webVueAntYtTable tbody tr.ant-table-measure-row td:nth-child(1) {
  width: 15px;
}
.webVueAntYtTable tbody tr.ant-table-measure-row td:nth-child(3) {
  width: 180px;
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
  line-height: 50px;
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

.webVueAntYtTableStyle-qu9qy11-3 {
  opacity: 1;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table {
  box-shadow: 0px 0px 0px 0px transparent;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table th:first-child {
  border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table th:last-child {
  border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table tr:last-child td:first-child {
  border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table tr:last-child td:last-child {
  border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-thead tr,
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-thead tr th div:first-child {
  height: 50px;
}
.webVueAntYtTableStyle-qu9qy11-3
  .ant-table
  .ant-table-thead
  tr
  th
  div.ant-table-selection {
  line-height: 50px;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-thead tr th {
  background: #ffffff;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-thead tr span.th-text {
  color: #000000a6;
  font-family: Microsoft YaHei;
  font-size: 20px;
  font-weight: bold;
  line-height: 50px;
  letter-spacing: 0px;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  text-decoration: none;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table tbody tr td {
  height: 50px;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table tbody tr td .ant-checkbox-wrapper {
  line-height: 50px;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table tbody tr td {
  background: #ffffff;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table thead tr th,
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-tbody tr:not(:last-child) td {
  border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table thead tr th:not(:last-child),
.webVueAntYtTableStyle-qu9qy11-3 .ant-table .ant-table-tbody tr td:not(:last-child) {
  border-right: 0px solid #dcdcdc;
}
.webVueAntYtTableStyle-qu9qy11-3.ant-table-striped
  .ant-table
  tbody
  tr:nth-child(2n-1)
  td {
  background: #ffffff;
}
.webVueAntYtTableStyle-qu9qy11-3.ant-table-striped .ant-table tbody tr:nth-child(2n) td {
  background: #ffffff;
}
.webVueAntYtTableStyle-qu9qy11-3
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td {
  background: #e4efff !important;
}
.webVueAntYtTableStyle-qu9qy11-3
  .ant-table
  tbody
  tr:not(.ant-table-row-selected):hover
  td
  span.td-text {
  color: #000000 !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-table-tbody tr.ant-table-row-selected td {
  background: #3c8eff !important;
}
.webVueAntYtTableStyle-qu9qy11-3
  .ant-table-tbody
  tr.ant-table-row-selected
  td
  span.td-text {
  color: #ffffff !important;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination button,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li input {
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
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination button,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li .ant-select .ant-select-selector,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li input,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li a,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li .ant-pagination-options-quick-jumper {
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li:not(.ant-pagination-options),
.webVueAntYtTableStyle-qu9qy11-3
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-size-changer.ant-select
  .ant-select-selector,
.webVueAntYtTableStyle-qu9qy11-3
  .ant-pagination
  li.ant-pagination-options
  .ant-pagination-options-quick-jumper
  input {
  border-top: 1px solid #d9d9d9;
  border-right: 1px solid #d9d9d9;
  border-bottom: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li button {
  border: none;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li a,
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li .ant-pagination-options-quick-jumper {
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
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li.ant-pagination-item-active {
  background: #ffffff;
  border-top: 1px solid #1890ff;
  border-right: 1px solid #1890ff;
  border-bottom: 1px solid #1890ff;
  border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-qu9qy11-3 .ant-pagination li.ant-pagination-item-active a {
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

.webVueAntYtButtonStyle-qu {
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
.webVueAntYtButtonStyle-qu > span {
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

.webVueAntYtButtonStyle-qumxgo5-3 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-qumxgo5-3 > span {
  letter-spacing: 0px !important;
}

.webVueAntYtIcon {
  width: 100%;
  height: 100%;
}

.webVueAntYtIcon img {
  width: 100%;
  height: 100%;
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

.webVueAntYtPictureStyle-quqe3bg {
  opacity: 1;
}
.webVueAntYtPictureStyle-quqe3bg img {
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

.webVueAntYtButtonStyle-qu8821k-1 {
  color: #ffffff !important;
  background: #3c8eff !important;
  align-items: center;
  justify-content: center;
}
.webVueAntYtButtonStyle-qu8821k-1 > span {
  letter-spacing: 0px !important;
}

.webVueAntForm {
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: var(--web-vue-ant-form-bg-color);
}

.webVueAntYtInputFormItem-qu {
  flex-direction: row;
  opacity: 1;
}
.webVueAntYtInputFormItem-qu .ant-form-item-label label {
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
.webVueAntYtInputFormItem-qu .ant-form-item-label label .label-content {
  text-align: left;
  text-align-last: left;
}
.webVueAntYtInputStyle-qu:not(.ant-input-affix-wrapper) {
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
.webVueAntYtInputStyle-qu.ant-input-affix-wrapper {
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
.webVueAntYtInputStyle-qu.ant-input-affix-wrapper input {
  text-decoration: none;
  font-style: normal;
  text-align: left;
  text-align-last: left;
  color: #333333;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
}
.webVueAntYtInputStyle-qu:not(.ant-input-affix-wrapper)::placeholder,
.webVueAntYtInputStyle-qu:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,
.webVueAntYtInputStyle-qu input::placeholder,
.webVueAntYtInputStyle-qu input::-webkit-input-placeholder {
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

.webVueAntYtInputFormItem-quuyojf {
  flex-direction: column;
}
.webVueAntYtInputFormItem-quuyojf .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-quuyojf .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qu0np0m:not(.ant-input-affix-wrapper) {
  background: #f6f6f6 !important;
}
.webVueAntYtInputStyle-qu0np0m.ant-input-affix-wrapper {
  background: #f6f6f6;
}

.webVueAntYtInputFormItem-qusdq73 {
  flex-direction: column;
}
.webVueAntYtInputFormItem-qusdq73 .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-qusdq73 .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qujreqq:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-quvswho {
  flex-direction: column;
}
.webVueAntYtInputFormItem-quvswho .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-quvswho .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qusv0up:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-quprywk {
  flex-direction: column;
}
.webVueAntYtInputFormItem-quprywk .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-quprywk .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qunb72u:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-qu2jhuc {
  flex-direction: column;
}
.webVueAntYtInputFormItem-qu2jhuc .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-qu2jhuc .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qutru9f:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}

.webVueAntYtInputFormItem-qurf28f {
  flex-direction: column;
}
.webVueAntYtInputFormItem-qurf28f .ant-form-item-explain {
  position: absolute;
  top: 100%;
  z-index: -1;
}
.webVueAntYtInputFormItem-qurf28f .ant-form-item-label label {
  width: 609px;
  padding-right: 10px;
}
.webVueAntYtInputStyle-qu6bixm:not(.ant-input-affix-wrapper) {
  background: #ffffff !important;
}
.webVueAntYtSpanStyle-bh1fxm0 {
  width: 8px !important;
  height: 8px !important;
  border-radius: 50%;
  background: red;
}
</style>
