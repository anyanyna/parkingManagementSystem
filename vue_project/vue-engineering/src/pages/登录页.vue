
<template>
            <yt-grid previewType="FitScreen" style="width: 100%;">
                
            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="FitScreen">
                <div ref='ref1' class='webVueAntYtPicture webVueAntYtPictureStyle-qheh6os webVueAntYtPictureStyle-qh webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/wzc/1833710370078851072/0/sOwWQMSPmITe2Aah66w4I.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        width: "100%",         /* 使宽度占满容器 */
      height:"100%",        /* 使高度占满容器 */
      objectFit:"cover"
      }'>
                            
                        </a-image>
                        </div>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='width' comWidth='529.00px' top="5.70000%" left="3%" bottom="9.70000%" right="0.80000%" gridColumnStart="34" gridColumnEnd="65" gridRowStart="16" gridRowEnd="24" zIndex="2" previewType="FitScreen"> -->
            <yt-grid-item style="transform: translateX(-50%);left: 51%;" fixedSize='width' comWidth='529.00px' top="5.70000%" left="0.70000%" bottom="9.70000%" right="0.80000%" gridColumnStart="37" gridColumnEnd="65" gridRowStart="16" gridRowEnd="24" zIndex="2" previewType="FitScreen">
                <span ref='ref2' class='webVueAntYtSpan webVueAntYtSpanStyle-qhbwgd6  webVueAntYtSpanStyle-qh webVueAntYtSpanStyle webVueAntYtSpanBrCount-qh webVueAntYtSpanBrCount'>
                            <span v-html='"停 车 场 运 营 管 理 平 台"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.30000%" left="3.10000%" bottom="10.40000%" right="3.10000%" gridColumnStart="41" gridColumnEnd="61" gridRowStart="46" gridRowEnd="52" zIndex="3" previewType="FitScreen">
                <a-form-item ref='ref5' class='webVueAntInputFormItem webVueAntYtInputFormItem-qh5gg6k  webVueAntYtInputFormItem-qh webVueAntYtInputFormItem hide-label-qh hide-label' name='AccountNumbervalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"标题："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-qhpcen1 webVueAntYtInputStyle-qh webVueAntYtInputStyle' v-model:value='AccountNumbervalue1' :maxLength='100' :placeholder='"请输入账号"' @pressEnter="handleLoginRequest">
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="2.90000%" left="3.10000%" bottom="4.40000%" right="3.10000%" gridColumnStart="41" gridColumnEnd="61" gridRowStart="54" gridRowEnd="59" zIndex="4" previewType="FitScreen">
                <a-form-item ref='ref6' class='webVueAntInputFormItem webVueAntYtInputFormItem-qhf7zdl  webVueAntYtInputFormItem-qh webVueAntYtInputFormItem hide-label-qh hide-label' name='Passwordvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"标题："'>
                            
                        </span>
                        </div>
                        </template>
<!-- <a-input data-event class='webVueAntinput webVueAntYtInputStyle-qhzau2u webVueAntYtInputStyle-qh webVueAntYtInputStyle' v-model:value='Passwordvalue1' :maxLength='100' :placeholder='"       请输入密码"'>
                            
                        </a-input> -->
                        <yt-custom-input-password data-event class='webVueAntinput webVueAntYtInputStyle-qhzau2u webVueAntYtInputStyle-qh webVueAntYtInputStyle' v-model:value='Passwordvalue1' :placeholder='"请输入密码"' :maxlength='100' @pressEnter="handleLoginRequest">
                            
                          </yt-custom-input-password>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='145.00px' top="12.90000%" left="2.40000%" bottom="3.70000%" right="3.10000%" gridColumnStart="47" gridColumnEnd="55" gridRowStart="39" gridRowEnd="43" zIndex="5" previewType="FitScreen">
                <span ref='ref7' class='webVueAntYtSpan webVueAntYtSpanStyle-qhy86jl  webVueAntYtSpanStyle-qh webVueAntYtSpanStyle webVueAntYtSpanBrCount-qh webVueAntYtSpanBrCount'>
                            <span v-html='"欢迎登录"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='LoginisShow1' top="6.60000%" left="3.10000%" bottom="0.70000%" right="3.10000%" gridColumnStart="41" gridColumnEnd="61" gridRowStart="64" gridRowEnd="69" zIndex="6" previewType="FitScreen">
                <a-button ref='ref8' @click="()=> { handleLoginRequest(); }" class='webVueAntButton webVueAntYtButtonStyle-qhsp8va  webVueAntYtButtonStyle-qh webVueAntYtButtonStyle center-qh center' :loading='Loginloading1'>
                            <span class='yt-button-content ' v-html='"登录"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="28.30000%" left="25.50000%" bottom="16.00000%" right="27.60000%" gridColumnStart="42" gridColumnEnd="44" gridRowStart="47" gridRowEnd="50" zIndex="7" previewType="FitScreen"> -->
            <yt-grid-item fixedSize='selfAdaption' top="28.30000%" left="25.50000%" bottom="16.00000%" right="27.60000%" gridColumnStart="42" gridColumnEnd="44" gridRowStart="48" gridRowEnd="51" zIndex="7" previewType="FitScreen">
                <div ref='ref10' class='webVueAntYtIcon webVueAntYtPictureStyle-qhlhhny webVueAntYtPictureStyle-qh webVueAntYtPictureStyle'>
                            <img :src='"./staticResource/wzc/1833710370078851072/0/vcYkLfkTZTrt6SY82l8qQ.png"' class=' yt-static-qh yt-static'/>
                        </div>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="12.90000%" left="28.10000%" bottom="3.70000%" right="25.00000%" gridColumnStart="42" gridColumnEnd="44" gridRowStart="55" gridRowEnd="57" zIndex="8" previewType="FitScreen"> -->
            <yt-grid-item fixedSize='selfAdaption' top="12.90000%" left="28.10000%" bottom="3.70000%" right="25.00000%" gridColumnStart="42" gridColumnEnd="44" gridRowStart="56" gridRowEnd="58" zIndex="8" previewType="FitScreen">
                <div ref='ref11' class='webVueAntYtIcon webVueAntYtPictureStyle-qhq5q3q webVueAntYtPictureStyle-qh webVueAntYtPictureStyle'>
                            <img :src='"./staticResource/wzc/1833710370078851072/0/pdbiI0v-umWZs8sR5JgFm.png"' class=' yt-static-qh yt-static'/>
                        </div>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="11.70000%" left="43.20000%" bottom="32.70000%" right="9.80000%" gridColumnStart="58" gridColumnEnd="60" gridRowStart="55" gridRowEnd="58" zIndex="9" previewType="FitScreen">
                <div ref='ref12' :class='["webVueAntYtIcon","webVueAntYtPictureStyle-qh3ysns-"+ShowHiddenPasswordsstateKey1,"webVueAntYtPictureStyle-qh","webVueAntYtPictureStyle"]'>
                            <img :src='"./staticResource/wzc/1833710370078851072/0/pUle2Xj3mm5SBWsW-XiV1.png"' :class='["yt-static-qh","yt-static"]'/>
                        </div>
            </yt-grid-item> -->
        
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
      Passwordvalue1: "",
      AccountNumbervalue1: "",
      Loginloading1: false,
      LoginisShow1: true,
      ShowHiddenPasswordsstateKey1: "1"
    };
  },
  watch: {},
  methods: {
    async handleLoginRequest() {
      // 设置登录按钮为加载状态
      this.Loginloading1 = true;

      // 创建FormData对象并添加用户名和密码
      const formData = new FormData();
      formData.append('username', this.AccountNumbervalue1);
      formData.append('password', this.Passwordvalue1);
      console.log("🚀 ~ handleLoginRequest ~ this.Passwordvalue1:", this.Passwordvalue1)
      try {
        // 发送登录请求
        const response = await axios.post('./login', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        });

        // 检查响应结果
        if (response.data.flag) {
          // 登录成功，跳转到首页
          this.$router.push(response.data.data);
        } else {
          // 登录失败，显示错误信息
          message.error(response.data.message);
        }
      } catch (error) {
        // 请求失败，显示错误信息
        message.error('登录请求失败，请稍后重试');
      } finally {
        // 恢复登录按钮的加载状态
        this.Loginloading1 = false;
      }
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285002984554496';
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
        axios.post('./Loginpage/' + funcName, params, {
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
    loadCss('./css/登录页/theme.css');
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
  },
  computed: {
    ShowHiddenPasswordsiconState1() {
      switch (this.ShowHiddenPasswordsstateKey1) {
        case '1':
          return {
            "statusId": "1",
            "label": "状态1"
          };
        case '2':
          return {
            "statusId": "2",
            "label": "状态2"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "2",
            "label": "状态2"
          };
      }
    }
  }
};

</script>
<style lang="less">

.webVueAntYtPicture {
    width: 100%;
    height:100%;
    overflow: hidden;
}
.webVueAntYtPicture img, .webVueAntYtPicture .ant-image {
    width: 100%;
    height:100%;
}

.webVueAntYtPictureStyle-qheh6os{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtSpanStyle-qh{
opacity: 1;
color: #3D3D3D;
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
.webVueAntYtSpanStyle-qh span{
text-shadow: 0px 0px 0px transparent;
}
.webVueAntYtSpan {
    display: block;
    height:100%;
    width:100%;
}
.webVueAntYtSpan span{
    word-break: break-all;
    width: auto;
    display: inline-block;
    vertical-align: top; /* 根据需要调整 */
}
.webVueAntYtSpan span:focus{
    outline: none;
}

.webVueAntYtSpanStyle-qhbwgd6{
color: #FFFFFF !important;
font-size: 45px;
font-weight: bold;
}
.webVueAntYtSpanStyle-qhbwgd6 span{
text-decoration: none;
}

.webVueAntYtInputFormItem-qh{
flex-direction: row;
opacity: 1;
}
.webVueAntYtInputFormItem-qh .ant-form-item-label label{
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
.webVueAntYtInputFormItem-qh .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtInputStyle-qh:not(.ant-input-affix-wrapper){
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
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
.webVueAntYtInputStyle-qh.ant-input-affix-wrapper{
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
// padding-left: 12px;
padding-left: 40px;
}
.webVueAntYtInputStyle-qh.ant-input-affix-wrapper input{
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtInputStyle-qh:not(.ant-input-affix-wrapper)::placeholder,.webVueAntYtInputStyle-qh:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,.webVueAntYtInputStyle-qh input::placeholder,.webVueAntYtInputStyle-qh input::-webkit-input-placeholder{
color: #999999;
}
.webVueAntInputFormItem  {
  flex-wrap: nowrap;
}
.webVueAntInputFormItem ,
.webVueAntinput,
.webVueAntInputFormItem .ant-form-item-control-input,
.webVueAntInputFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-control-input{
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
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-content:focus{
  outline: none;
}
.webVueAntinput.ant-input-affix-wrapper input {
  background-color: transparent;
}


.webVueAntYtInputFormItem-qh5gg6k .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-qh5gg6k .ant-form-item-label label{
width: 53px;
padding-right: 10px;
}
.webVueAntYtInputStyle-qhpcen1:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
border-top-left-radius: 9px;
border-top-right-radius: 9px;
border-bottom-left-radius: 9px;
border-bottom-right-radius: 9px;
padding-left: 40px;
}
.webVueAntYtInputStyle-qhpcen1.ant-input-affix-wrapper{
border-top-left-radius: 9px;
border-top-right-radius: 9px;
border-bottom-left-radius: 9px;
border-bottom-right-radius: 9px;
}

.webVueAntYtInputFormItem-qhf7zdl .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-qhf7zdl .ant-form-item-label label{
width: 53px;
padding-right: 10px;
}
.webVueAntYtInputStyle-qhzau2u:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
border-top-left-radius: 9px;
border-top-right-radius: 9px;
border-bottom-left-radius: 9px;
border-bottom-right-radius: 9px;
// padding-left: 40px;
}
.webVueAntYtInputStyle-qhzau2u.ant-input-affix-wrapper{
border-top-left-radius: 9px;
border-top-right-radius: 9px;
border-bottom-left-radius: 9px;
border-bottom-right-radius: 9px;
}

.webVueAntYtSpanStyle-qhy86jl{
color: #4288C6 !important;
font-size: 30px;
font-weight: 600;
letter-spacing: 5px;
}
.webVueAntYtSpanStyle-qhy86jl span{
text-decoration: none;
}

.webVueAntYtButtonStyle-qh{
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
.webVueAntYtButtonStyle-qh>span{
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

.webVueAntYtButtonStyle-qhsp8va{
color: #FFFFFF !important;
font-size: 18px;
font-weight: bold;
background: linear-gradient(0deg,rgba(61, 145, 247, 1) 0%,rgba(56, 178, 255, 1) 98.02188513413915%) !important;
border-top-left-radius: 25px;
border-top-right-radius: 25px;
border-bottom-left-radius: 25px;
border-bottom-right-radius: 25px;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-qhsp8va>span{
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

.webVueAntYtPictureStyle-qhlhhny{
opacity: 1;
}
.webVueAntYtPictureStyle-qhlhhny img{
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
margin-top: -6px;
}

.webVueAntYtPictureStyle-qhq5q3q{
opacity: 1;
}
.webVueAntYtPictureStyle-qhq5q3q img{
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
margin-top: -6px;
}

.webVueAntYtPictureStyle-qh3ysns-1{
opacity: 1;
}
.webVueAntYtPictureStyle-qh3ysns-1 img{
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
.webVueAntYtPictureStyle-qh3ysns-2{
opacity: 1;
}
.webVueAntYtPictureStyle-qh3ysns-2 img{
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
</style>