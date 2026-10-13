
<template>
            <yt-grid previewType="AdaptiveWH">
                
            <yt-grid-item fixedSize='selfAdaption' top="20.30000%" left="11.60000%" bottom="5.50000%" right="5.00000%" gridColumnStart="15" gridColumnEnd="20" gridRowStart="10" gridRowEnd="14" zIndex="1" previewType="AdaptiveWH">
                <a-button ref='ref1' @click="()=> { generateOrderInterface(); }" class='webVueAntButton webVueAntYtButtonStyle-yq460r0  webVueAntYtButtonStyle-yq webVueAntYtButtonStyle center-yq center' :loading='GenerateOrderloading1'>
                            <span class='yt-button-content ' v-html='"生成订单"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.90000%" left="11.60000%" bottom="12.90000%" right="5.00000%" gridColumnStart="15" gridColumnEnd="20" gridRowStart="19" gridRowEnd="23" zIndex="4" previewType="AdaptiveWH">
                <a-button ref='ref4' @click="()=> { completePaymentInterface(); }" class='webVueAntButton webVueAntYtButtonStyle-yq01ohe  webVueAntYtButtonStyle-yq webVueAntYtButtonStyle center-yq center' :loading='Paymentcompletedloading1'>
                            <span class='yt-button-content ' v-html='"付费完成"'>
                            
                        </span>
                        </a-button>
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
      GenerateOrderloading1: false,
      Paymentcompletedloading1: false
    };
  },
  watch: {},
  methods: {
    async generateOrderInterface() {
      try {
        // Set loading state
        this.GenerateOrderloading1 = true;

        // Generate a random license plate
        const response = await this.executeBackendInterface('generateLicensePlate', {});
        if (response.flag) {
          const licensePlate = response.data.licensePlate;
          const orderNumber = `${new Date().toISOString()}-${licensePlate.slice(-5)}`;

          // Create a parking order
          const createOrderResponse = await this.executeBackendInterface('createParkingOrder', {
            licensePlate: licensePlate
          });
          if (createOrderResponse.flag) {
            message.success('订单创建成功');
          } else {
            message.error(`订单创建失败: ${createOrderResponse.message}`);
          }
        } else {
          message.error(`车牌生成失败: ${response.message}`);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      } finally {
        // Reset loading state
        this.GenerateOrderloading1 = false;
      }
    },
    async completePaymentInterface() {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认支付',
        content: "确定要将支付状态改为已支付吗？",
        onOk: async () => {
          try {
            // 查询车辆订单信息
            const queryResponse = await this.executeBackendInterface('queryVehicleOrder', {
              license_plate: '浙·A12345'
            });
            if (queryResponse.flag) {
              const orders = queryResponse.data;
              // 遍历订单，更新支付状态
              for (let order of orders) {
                if (order.payment_status !== '已支付') {
                  // 更新支付状态
                  const updateResponse = await this.executeBackendInterface('updatePaymentStatus', {
                    license_plate: order.license_plate
                  });
                  if (updateResponse.flag) {
                    message.success('支付状态更新成功');
                  } else {
                    message.error('支付状态更新失败: ' + updateResponse.message);
                  }
                }
              }
            } else {
              message.error('查询订单失败: ' + queryResponse.message);
            }
          } catch (error) {
            message.error('操作失败: ' + error.message);
          }
        },
        onCancel: () => {
          message.info('操作已取消');
        }
      });
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845286161157718016';
        const response = await axios.get(`./system/permission/getCurrentPageNotShowVariable?pageUuid=${pageUuid}`);
        const variablesArray = response.data; // 后端直接返回变量数组

        if (variablesArray && Array.isArray(variablesArray))
          // 遍历数组，将每个变量设置为true
          variablesArray.forEach(variable => {
            this[variable] = true;
          });
      } catch (error) {
        console.error('获取变量失败:', error);
      }
    },
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios.post('./Businesslogic/' + funcName, params, {
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => {
          resolve(response.data);
        }).catch(error => {
          reject(error);
        });
      });
    }
  },
  mounted() {
    loadCss('./css/业务逻辑/theme.css');
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {}
};

</script>
<style lang="less">

.webVueAntYtButtonStyle-yq{
opacity: 1;
color: #FFFFFF;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #4A90E2;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 0px solid #D9D9D9;
border-right: 0px solid #D9D9D9;
border-bottom: 0px solid #D9D9D9;
border-left: 0px solid #D9D9D9;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 2px;
padding-right: 0px;
padding-bottom: 2px;
padding-left: 0px;
}
.webVueAntYtButtonStyle-yq>span{
line-height: 28px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
text-align: center;
text-align-last: center;
}
.webVueAntButton  {
  width: 100%;
  height:100%;
  display: flex;
}
.webVueAntButton .span:first-child{
  flex: 0 0 8px;
}
.webVueAntButton .yt-button-content{
  display: inline-block;
  flex: 1;
}

.webVueAntButton.ant-btn-loading.center .yt-button-content,
.webVueAntButton.ant-btn-loading.right .yt-button-content,
.webVueAntButton.ant-btn-loading.left .yt-button-content {
  flex: 0 0 auto;
}
.webVueAntButton span:focus{
  outline: none;
}
.webVueAntButton.ant-btn-two-chinese-chars>:not(.anticon) {
  margin-right: 0;
}

.webVueAntYtButtonStyle-yq460r0{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-yq460r0>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-yq01ohe{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-yq01ohe>span{
letter-spacing: 0px !important;
}
</style>