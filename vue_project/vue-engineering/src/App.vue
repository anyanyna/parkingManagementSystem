<script setup>
import { ref } from 'vue';
import dayjs from 'dayjs';
import 'dayjs/locale/zh-cn';
import zhCN from 'ant-design-vue/es/locale/zh_CN';
dayjs.locale(window.__$yt_lang)

const currentLocale = ref(zhCN);

</script>

<template>
  <a-config-provider :locale="currentLocale">
    <RouterView/>
  </a-config-provider>
</template>

<style>
#app{
  height: 100%;
}
</style>