
import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.less'
import router from './pages/main.js'
import setupInterceptors from './interceptors/axiosInterceptor.js';
import YtContentShow from "@/components/web/vue/antdesign/YtContentShow/src/index.vue";
import YtVerticleMenu from "@/components/web/vue/antdesign/YtVerticleMenu/src/index.vue";
import YtRangePicker from "@/components/web/vue/antdesign/YtRangePicker/src/index.vue";
import YtTable from "@/components/web/vue/antdesign/YtTable/src/index.vue";
import YtModal from "@/components/web/vue/antdesign/YtModal/src/index.vue";
import YtDynamicPanel from "@/components/web/vue/antdesign/YtDynamicPanel/src/index.vue";
import YtDatePicker from "@/components/web/vue/antdesign/YtDatePicker/src/index.vue";
import YtUploadButton from "@/components/web/vue/antdesign/YtUploadButton/src/index.vue";
import YtTimePicker from "@/components/web/vue/antdesign/YtTimePicker/src/index.vue";
import YtTree from "@/components/web/vue/antdesign/YtTree/src/index.vue";
import YtInputPassword from "@/components/web/vue/antdesign/YtInputPassword/src/index.vue";
import YtGrid from "@/components/web/vue/antdesign/YtGrid/src/index.vue";
import YtGridItem from "@/components/web/vue/antdesign/YtGridItem/src/index.vue";

setupInterceptors();

const app = createApp(App)

app.component(YtContentShow.name, YtContentShow);
app.component(YtVerticleMenu.name, YtVerticleMenu);
app.component(YtRangePicker.name, YtRangePicker);
app.component(YtTable.name, YtTable);
app.component(YtModal.name, YtModal);
app.component(YtDynamicPanel.name, YtDynamicPanel);
app.component(YtDatePicker.name, YtDatePicker);
app.component(YtUploadButton.name, YtUploadButton);
app.component(YtTimePicker.name, YtTimePicker);
app.component(YtTree.name, YtTree);
app.component(YtInputPassword.name, YtInputPassword);
app.component(YtGrid.name, YtGrid);
app.component(YtGridItem.name, YtGridItem);

app.use(Antd)
app.use(router)
window.__$yt_lang = 'zh_CN'
app.mount('#app')