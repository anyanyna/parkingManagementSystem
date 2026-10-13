<template>
  <yt-grid previewType="AdaptiveWH">

    <yt-grid-item fixedSize='selfAdaption' :isUseContentWH='true' top="0.90000%" left="0.50000%" bottom="0.00000%"
      right="0.00000%" gridColumnStart="12" gridColumnEnd="101" gridRowStart="6" gridRowEnd="101" zIndex="1"
      previewType="AdaptiveWH">
      <RouterView name="second_route" />
    </yt-grid-item>


    <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="0.00000%" bottom="1.20000%" right="0.00000%"
      gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
      <div ref='ref3'
        class='webVueAntYtRectangle webVueAntYtRectangleStyle-qjseaik webVueAntYtRectangleStyle-qj webVueAntYtRectangleStyle'>

      </div>
    </yt-grid-item>


    <yt-grid-item fixedSize='width' comWidth='209.00px' top="9.70000%" left="7.60000%" bottom="9.20000%"
      right="1.60000%" gridColumnStart="3" gridColumnEnd="15" gridRowStart="2" gridRowEnd="6" zIndex="3"
      previewType="AdaptiveWH">
      <span ref='ref4'
        class='webVueAntYtSpan webVueAntYtSpanStyle-qjtcag3  webVueAntYtSpanStyle-qj webVueAntYtSpanStyle null-qj null'>
        <span v-html='"停车运营管理平台"'>

        </span>
      </span>
    </yt-grid-item>


    <yt-grid-item fixedSize='selfAdaption' :isShow='MenuBarisShow1' top="0.90000%" left="0.00000%" bottom="0.00000%"
      right="4.50000%" gridColumnStart="1" gridColumnEnd="13" gridRowStart="6" gridRowEnd="101" zIndex="4"
      previewType="AdaptiveWH">
      <yt-vertical-menu-menu ref='ref5' @click_to_jump="(key, item) => { handleMenuSelection(key, item); }"
        class='webVueAntYtVerticleMenu webVueAntYtVerticleMenuStyle-qjdon8l webVueAntYtVerticleMenuStyle-qj webVueAntYtVerticleMenuStyle'
        v-model:openKeys='MenuBaropenKeys1' v-model:selectedKeys='MenuBarselectedKeys1'
        :items='MenuBaroptions1.dataSource'>

      </yt-vertical-menu-menu>
    </yt-grid-item>


    <yt-grid-item fixedSize='selfAdaption' top="7.40000%" left="19.00000%" bottom="4.60000%" right="20.10000%"
      gridColumnStart="1" gridColumnEnd="4" gridRowStart="2" gridRowEnd="6" zIndex="5" previewType="AdaptiveWH">
      <div ref='ref9408'
        class='webVueAntYtIcon webVueAntYtPictureStyle-qjz9z90 webVueAntYtPictureStyle-qj webVueAntYtPictureStyle'>
        <img :src='"./staticResource/wzc/1845284868271898624/0/CbNqpU3nVl2JmaY36XWlM.png"'
          class=' yt-static-qj yt-static' />
      </div>
    </yt-grid-item>
    <a-popover :overlayClassName="'user-popover'">
      <yt-grid-item fixedSize='width' comWidth='44.00px' top="31.40000%" left="19.00000%" bottom="3.70000%"
        right="4.50000%" gridColumnStart="96" gridColumnEnd="99" gridRowStart="2" gridRowEnd="5" zIndex="6"
        previewType="AdaptiveWH">
        <span ref='ref9409'
          class='webVueAntYtSpan webVueAntYtSpanStyle-qj68ygk  webVueAntYtSpanStyle-qj webVueAntYtSpanStyle webVueAntYtSpanBrCount-qj webVueAntYtSpanBrCount'>
          <span>
            {{ userName }}
          </span>
        </span>
      </yt-grid-item>


      <yt-grid-item fixedSize='selfAdaption' top="16.60000%" left="19.70000%" bottom="18.50000%" right="31.50000%"
        gridColumnStart="94" gridColumnEnd="97" gridRowStart="2" gridRowEnd="6" zIndex="7" previewType="AdaptiveWH">
        <div ref='ref9410'
          class='webVueAntYtIcon webVueAntYtPictureStyle-qjg6ttn webVueAntYtPictureStyle-qj webVueAntYtPictureStyle'>
          <img :src='"./staticResource/wzc/1845284868271898624/0/BxA_v153eZhEGBo_P6Cqb.png"'
            class=' yt-static-qj yt-static' />
        </div>
      </yt-grid-item>
      <template #content>
        <yt-grid-item fixedSize='selfAdaption' top="6%" left="0%" bottom="48%" right="0%" gridColumnStart="93"
          gridColumnEnd="98" gridRowStart="5" gridRowEnd="9" zIndex="9" previewType="AdaptiveWH">
          <a-button ref='ref9413' @click="() => { navigateToPersonalCenter(); }"
            class='webVueAntButton webVueAntYtButtonStyle-qj67t6l  webVueAntYtButtonStyle-qj webVueAntYtButtonStyle center-qj center'
            :loading='PersonalCenterloading1'>
            <span class='yt-button-content ' v-html='"个人中心"'>
            </span>
          </a-button>
        </yt-grid-item>
        <yt-grid-item fixedSize='selfAdaption' top="50%" left="0%" bottom="5%" right="0%" gridColumnStart="93"
          gridColumnEnd="98" gridRowStart="8" gridRowEnd="12" zIndex="10" previewType="AdaptiveWH">
          <a-button ref='ref9414' @click="() => { logoutUser(); }"
            class='webVueAntButton webVueAntYtButtonStyle-qjmcwrp  webVueAntYtButtonStyle-qj webVueAntYtButtonStyle center-qj center'
            :loading='Writeoffloading1'>
            <span class='yt-button-content ' v-html='"退出"'>
            </span>
          </a-button>
        </yt-grid-item>
      </template>
    </a-popover>
    <yt-grid-item fixedSize='selfAdaption' top="18.90000%" left="32.90000%" bottom="20.80000%" right="21.80000%"
      gridColumnStart="91" gridColumnEnd="94" gridRowStart="2" gridRowEnd="6" zIndex="8" previewType="AdaptiveWH">
      <div ref='ref9411' @click="() => { navigateToPersonalCenterFromMessage(); }"
        class='webVueAntYtIcon webVueAntYtPictureStyle-qjgbbzj webVueAntYtPictureStyle-qj webVueAntYtPictureStyle'>
        <img :src='"./staticResource/wzc/1845284868271898624/0/jwGqUGOwaMiQQ8HkdJVap.png"'
          class=' yt-static-qj yt-static' />
      </div>
    </yt-grid-item>
  </yt-grid>
</template>

<script>

import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";

export default {
  data() {
    return {
      MenuBaropenKeys1: [],
      MenuBarselectedKeys1: ["运营看板"],
      MenuBaroptions1: {
        dataSource: [{
          iconUrl: "./staticResource/wzc/1833710370078851072/0/nozrlZx0uL9N1SCVTZqIw.png",
          key: "运营看板",
          label: "一级菜单1",
          title: "运营看板",
          disabled: false,
          select: true,
          requirementCode: "8srjF2"
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/Bhdu0xwlKDkwy-u7XMSgu.png",
          key: "车场看板",
          label: "一级菜单2",
          title: "车场看板",
          disabled: false,
          select: false,
          requirementCode: "8srjF2"
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/So4lKxWzOFauHvnylj3GV.png",
          key: "停车运营",
          label: "一级菜单3",
          title: "停车运营",
          disabled: false,
          select: false,
          children: [{
            key: "停车订单",
            label: "",
            title: "停车订单",
            iconUrl: "",
            disabled: false,
            select: false,
            requirementCode: "8srjF2",
            selectPage: "1836282343027900416",
            groupCode: "2SfRsi"
          }, {
            key: "计费管理",
            label: "",
            title: "计费管理",
            iconUrl: "",
            disabled: false,
            select: false,
            requirementCode: "8srjF2",
            selectPage: "1836615577620185088",
            groupCode: "BfquWy"
          }],
          requirementCode: "8srjF2"
        }, {
          key: "车场配置",
          label: "",
          title: "车场配置",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/Rnv-3qkQjiQzegeXOZ6QX.png",
          disabled: false,
          select: false,
          selectPage: "1836286534215532544",
          groupCode: "bx2GXD",
          requirementCode: "8srjF2"
        }, {
          key: "APP用户管理",
          label: "",
          title: "APP用户管理",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/Vq3j6dWz-455CdDVv90V0.png",
          disabled: false,
          select: false,
          requirementCode: "8srjF2",
          selectPage: "1834532148560789504",
          groupCode: "yJBLmy"
        }, {
          key: "车辆管理",
          label: "",
          title: "车辆管理",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/8XxfaALkpT-oNgO6qeQUn.png",
          disabled: false,
          select: false,
          requirementCode: "8srjF2",
          selectPage: "1837079328194560000",
          groupCode: "kJm2vo"
        }, {
          key: "系统设置",
          label: "",
          title: "系统设置",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/LJfiz3bYg6oQMMaTWMoBa.png",
          disabled: false,
          select: false,
          requirementCode: "8srjF2"
        }],
        value: {
          selectActive: "运营看板",
          selectData: ["运营看板"],
          disableData: [],
          disableActive: "停车运营"
        }
      },
      MenuBarisShow1: true,
      PersonalCenterloading1: false,
      Writeoffloading1: false,
      userName: ''
    };
  },
  watch: {
    '$route.path'(val) {
      const id = this.getId(this.MenuBaroptions1.dataSource, val)
      this.MenuBarselectedKeys1 = [id]
    }
  },
  methods: {
    async getUserName() {
      const { data } = await this.executeBackendInterface("getUserInformation", {}, './Personalcenter/')
      this.userName = data.Nicknamevalue1
    },
    handleMenuSelection(key, item) {
      // 获取当前选中的菜单项
      this.$router.push(item.path);
    },
    async initializeMenuBar() {
      try {
        // 调用后端接口获取用户菜单权限
        const response = await this.executeBackendInterface('getUserMenuPermissions', {});
        if (response.flag) {
          const transformData = (nodes) => {
            return nodes.map(item => ({
              key: item.id,

              title: item.menu_name,
              iconUrl: `/api/staticCommonUpload/${item.icon}`,
              path: item.path,
              disabled: false,
              select: false,
              children: item.children ? transformData(item.children) : null
            }));
          };
          // 对返回的数据进行格式转换
          console.log("🚀 ~ initializeMenuBar ~ response.data:", response.data)
          // 调用排序函数
          let sortedData = this.sortMenuData(response.data);

          // 打印排序后的数据
          console.log('sortedData', sortedData);

          this.MenuBaroptions1.dataSource = transformData(sortedData);
          // this.MenuBaroptions1.dataSource = transformData(response.data);
          console.log("🚀 ~ initializeMenuBar ~ this.MenuBaroptions1.dataSource:", this.MenuBaroptions1.dataSource)
        } else {
          this.$router.replace('/dengluye');
        }
      } catch (error) {
        message.error('获取菜单权限失败');
      }
    },
    // 菜单数据 根据 sort_order 排序
    sortMenuData(data) {
      // 定义一个辅助函数来排序子菜单项
      function sortChildren(children) {
        if (children && children.length > 0) {
          children.sort((a, b) => a.sort_order - b.sort_order);
          // 递归地对每个子菜单项的子菜单项进行排序（虽然当前数据结构中未显示嵌套更深的情况）
          children.forEach(child => {
            if (child.children) {
              sortChildren(child.children);
            }
          });
        }
      }

      // 对每个主菜单项的子菜单项进行排序
      data.forEach(item => {
        sortChildren(item.children);
      });

      // 对主菜单项进行排序
      data.sort((a, b) => a.sort_order - b.sort_order);

      return data;
    },
    getId(data, path) {
      for (let item of data) {
        if (item.path === path) {
          return item.key;
        } else if (item.children?.length) {
          const result = this.getId(item.children, path);
          if (result) return result; // 返回找到的结果
        }
      }
    },
    async showPersonalCenterAndLogoutFromText() {
      try {
        // 调用后端接口获取个人中心和退出信息
        const response = await this.executeBackendInterface('showPersonalCenterAndLogoutFromText', {});
        if (response.flag) {
          const data = response.data;

          // 遍历返回的数据，设置对应按钮的加载状态
          data.forEach(item => {
            if (item.ref === 'ref9413') {
              this.PersonalCenterloading1 = true;
              // 处理个人中心相关逻辑
              // 例如：显示个人中心信息
              console.log('个人中心信息:', item);
            } else if (item.ref === 'ref9414') {
              this.Writeoffloading1 = true;
              // 处理退出相关逻辑
              // 例如：执行退出操作
              console.log('退出信息:', item);
            }
          });

          // 提示成功信息
          message.success(response.message);
        } else {
          // 提示失败信息
          message.error(response.message);
        }
      } catch (error) {
        // 处理请求错误
        message.error('请求失败，请稍后重试');
        console.error('请求错误:', error);
      } finally {
        // 重置按钮加载状态
        this.PersonalCenterloading1 = false;
        this.Writeoffloading1 = false;
      }
    },
    async showPersonalCenterAndLogout() {
      try {
        // 调用后端接口获取个人中心和退出信息
        const response = await this.executeBackendInterface('showPersonalCenterAndLogout', {});
        if (response.flag) {
          const {
            personalCenter,
            logout
          } = response.data;

          // 更新个人中心和退出按钮的状态
          if (personalCenter && personalCenter.length > 0) {
            this.PersonalCenterloading1 = false; // 假设需要根据返回数据更新状态
          }

          if (logout && logout.length > 0) {
            this.Writeoffloading1 = false; // 假设需要根据返回数据更新状态
          }

          message.success(response.message);
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    async logoutUser() {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认退出',
        content: "您确定要退出吗？",
        onOk: async () => {
          this.Writeoffloading1 = true; // 设置按钮加载状态为true
          try {
            // 调用后端接口进行退出操作
            await this.executeBackendInterface('logout', {});
            this.$router.push('/dengluye')
          } catch (error) {
            message.error('退出失败，请稍后重试'); // 显示错误消息
          } finally {
            this.Writeoffloading1 = false; // 恢复按钮加载状态
          }
        },

        onCancel: () => {
          // 取消操作，无需处理
        }
      });
    },
    async navigateToPersonalCenter() {
      // 跳转到个人中心页面
      this.$router.push({ path: '/daohangye/gerenzhongxin' });
      window.dispatchEvent(new CustomEvent('showPerson'))
    },
    async navigateToPersonalCenterFromMessage() {
      this.$router.push({ path: '/daohangye/gerenzhongxin', query: { showMessage: true } });
      window.dispatchEvent(new CustomEvent('showMessage'))
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285077223735296';
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
    executeBackendInterface(funcName, params, prefix = './Navigationpage/') {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios.post(prefix + funcName, params, {
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
  created() {
    window.addEventListener('refreshMenu', this.initializeMenuBar)
  },
  async mounted() {
    this.getUserName()
    loadCss('./css/导航页面/theme.css');
    await this.initializeMenuBar();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();
    const { data } = await this.executeBackendInterface('getIndexMenu', {});
    if (data.length) {
      const path = this.$route.path
      const currentKey = this.getId(this.MenuBaroptions1.dataSource, path)
      if (!currentKey) {
        this.$router.push(data[0].path);
        this.MenuBarselectedKeys1 = data.map((item) => item.id)
      } else {
        this.MenuBarselectedKeys1 = [currentKey]
      }
    }
  },
  computed: {}
};

</script>
<style lang="less">
.webVueAntYtRectangleStyle-qj {
  opacity: 1;
  box-shadow: 0px 0px 0px 0px transparent;
  background: transparent;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 1px solid #CDCDCD;
  border-right: 1px solid #CDCDCD;
  border-bottom: 1px solid #CDCDCD;
  border-left: 1px solid #CDCDCD;
}

.webVueAntYtRectangle {
  width: 100%;
  height: 100%;

}

.webVueAntYtRectangleStyle-qjseaik {
  background: #001529;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-qj {
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

.webVueAntYtSpanStyle-qj span {
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
  vertical-align: top;
  /* 根据需要调整 */
}

.webVueAntYtSpan span:focus {
  outline: none;
}

.webVueAntYtSpanStyle-qjtcag3 {
  color: #FFFFFF !important;
  font-size: 22px;
  font-weight: bold;
  letter-spacing: 1px;
}

.webVueAntYtSpanStyle-qjtcag3 span {
  text-decoration: none;
}

.webVueAntYtVerticleMenuStyle-qj.ant-menu {
  opacity: 1;
  box-shadow: 0px 0px 0px 0px transparent !important;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 1px solid transparent;
  border-right: 1px solid transparent;
  border-bottom: 1px solid transparent;
  border-left: 1px solid transparent;
  color: #000000A6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  font-style: normal;
  background: #ffffff;
}

.webVueAntYtVerticleMenuStyle-qj.ant-menu .ant-menu-submenu-inline .ant-menu-inline,
.webVueAntYtVerticleMenuStyle-qj.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item,
.webVueAntYtVerticleMenuStyle-qj.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-submenu {
  color: #000000A6;
  font-family: Microsoft YaHei;
  font-size: 14px;
  font-weight: Normal;
  letter-spacing: 0px;
  text-decoration: none;
  font-style: normal;
  background: #ffffff;
}

.webVueAntYtVerticleMenuStyle-qj.ant-menu .ant-menu-vertical {
  background: #ffffff;
}

.webVueAntYtVerticleMenuStyle-qj.ant-menu .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qj.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qj .ant-menu-submenu-selected>.ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-qj.ant-menu .sub-menu-selected>.ant-menu-submenu-title>.ant-menu-title-content {
  color: #3C8EFF;
}

.webVueAntYtVerticleMenuStyle-qj.webVueAntYtVerticleMenu.ant-menu .ant-menu-item.ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qj.webVueAntYtVerticleMenu.ant-menu .sub-menu-selected>.ant-menu-submenu-title {
  background: #E6EFFE;
}

.webVueAntYtVerticleMenuStyle-qj .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,
.webVueAntYtVerticleMenuStyle-qj .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,
.webVueAntYtVerticleMenuStyle-qj.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,
.webVueAntYtVerticleMenuStyle-qj.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover {
  color: #3C8EFF;
  background: #ffffff !important;
}

.webVueAntYtVerticleMenuStyle-qj.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover,
.webVueAntYtVerticleMenuStyle-qj.ant-menu-light.ant-menu:not(.ant-menu-inline) .ant-menu-submenu-open:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected) {
  color: #3C8EFF;
}

.webVueAntYtVerticleMenuStyle-qj.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-item-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected),
.webVueAntYtVerticleMenuStyle-qj.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-submenu-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected) {
  color: #3C8EFF;
}

.webVueAntYtVerticleMenuStyle-qj.webVueAntYtVerticleMenu .ant-menu-item.ant-menu-item-selected:hover,
.webVueAntYtVerticleMenuStyle-qj .ant-menu-submenu-title.ant-menu-item-selected:hover {
  color: #3C8EFF;
}

.webVueAntYtVerticleMenu {
  width: 100%;
  height: 100%;
}

.webVueAntYtVerticleMenu div>li>.ant-menu-submenu-title {
  height: 100%;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu {
  box-shadow: 0px 0px 0px 0px transparent !important;
  color: #C9CED4;
  background: #000C17;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline div>li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline div>li>.ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline div>li.ant-menu-item.ant-menu-item-only-child {
  height: 44px;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}

.webVueAntYtVerticleMenuStyle-qjdon8l div>li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-qjdon8l div>li>.ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-qjdon8l div>li.ant-menu-item.ant-menu-item-only-child {
  height: 44px;
  text-decoration: none;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .ant-menu-submenu-inline .ant-menu-inline,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-submenu {
  color: #C9CED4;
  background: #000C17;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .ant-menu-vertical {
  background: #000C17;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item-only-child,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li>.ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item-only-child,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li>.ant-menu-submenu-title {
  height: 44px;
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 20px !important;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qjdon8l .ant-menu-submenu-selected>.ant-menu-submenu-title,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu .sub-menu-selected>.ant-menu-submenu-title>.ant-menu-title-content {
  color: #FFFFFF !important;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.webVueAntYtVerticleMenu.ant-menu .ant-menu-item.ant-menu-item-selected,
.webVueAntYtVerticleMenuStyle-qjdon8l.webVueAntYtVerticleMenu.ant-menu .sub-menu-selected>.ant-menu-submenu-title {
  background: #1890FF;
}

.webVueAntYtVerticleMenuStyle-qjdon8l .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,
.webVueAntYtVerticleMenuStyle-qjdon8l .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover {
  color: #FFFFFF;
  background: #1890FF99 !important;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover,
.webVueAntYtVerticleMenuStyle-qjdon8l.ant-menu-light.ant-menu:not(.ant-menu-inline) .ant-menu-submenu-open:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected) {
  color: #FFFFFF;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-item-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected),
.webVueAntYtVerticleMenuStyle-qjdon8l.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-submenu-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected) {
  color: #FFFFFF;
}

.webVueAntYtVerticleMenuStyle-qjdon8l.webVueAntYtVerticleMenu .ant-menu-item.ant-menu-item-selected:hover,
.webVueAntYtVerticleMenuStyle-qjdon8l .ant-menu-submenu-title.ant-menu-item-selected:hover {
  color: #FFFFFF;
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

.webVueAntYtPictureStyle-qjz9z90 {
  opacity: 1;
}

.webVueAntYtPictureStyle-qjz9z90 img {
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

.webVueAntYtSpanStyle-qj68ygk {
  color: #FFFFFF !important;
}

.webVueAntYtSpanStyle-qj68ygk span {
  text-decoration: none;
}

.webVueAntYtPictureStyle-qjg6ttn {
  opacity: 1;
}

.webVueAntYtPictureStyle-qjg6ttn img {
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

.webVueAntYtPictureStyle-qjgbbzj {
  opacity: 1;
}

.webVueAntYtPictureStyle-qjgbbzj img {
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

.webVueAntYtButtonStyle-qj {
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

.webVueAntYtButtonStyle-qj>span {
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

.webVueAntButton.ant-btn-two-chinese-chars>:not(.anticon) {
  margin-right: 0;
}

.webVueAntYtButtonStyle-qj67t6l {
  color: #000000 !important;
  background: #FFFFFF !important;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 0px solid transparent;
  border-right: 0px solid transparent;
  border-left: 0px solid transparent;
  align-items: center;
  justify-content: center;
}

.webVueAntYtButtonStyle-qj67t6l>span {
  letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-qjmcwrp {
  color: #F84C55 !important;
  background: #FFFFFF !important;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
  border-top: 0px solid #9B9B9B;
  border-right: 0px solid #9B9B9B;
  border-bottom: 0px solid #9B9B9B;
  border-left: 0px solid #9B9B9B;
  align-items: center;
  justify-content: center;
}

.webVueAntYtButtonStyle-qjmcwrp>span {
  letter-spacing: 0px !important;
}

.ant-popover.user-popover {
  width: 105px !important;
  height: 80px !important;
  top: 55px !important;
  left: 93% !important;
  z-index: 999;

  .ant-popover-content,
  .ant-popover-inner,
  .ant-popover-inner-content {
    height: 100%;
  }

  .ant-popover-content {
    position: relative;
  }
}
</style>