<template>
    <div id="webVueAntContentShow">
        <div class="none-select-page" v-if="isNone">{{ content }}</div>
    </div>
</template>

<script setup>
import { defineExpose, defineOptions, ref, watch, onMounted, onBeforeUnmount } from 'vue';
import i18next from 'i18next';
import { createLocaleLang } from '../../../../../../shared/createLocaleLang';
import renderPage from './renderCodeForge'
const resizeableDiv = ref(null);
const props = defineProps({
    selectPage: String
});
i18next.init({
    lng: window.__$yt_lang, // 默认语言
    resources: createLocaleLang(import.meta.globEager('./locales/**/data.json')),
});
const content = i18next.t('content')

const render = (pageInfo, componentsStore, currentComId,bus) => {
    // return document.getElementById('webVueAntContentShow');
    renderPage(pageInfo, componentsStore, currentComId,bus)
}
const setPageList = (ctx, pageList, activeId) => {
    ctx['realOptions'] = pageList.reduce((acc, item) => {
        if (item.pageUuid !== activeId) acc.push(
            {
                value: item.pageUuid,
                label: item.pageName
            }
        );
        return acc;
    }, []);
}
const isNone = ref(!props.selectPage)
watch(() => props.selectPage, (newValue) => {
    isNone.value = !props.selectPage
});

defineExpose({
    render,
    setPageList
})
defineOptions({
    name: 'yt-content-show'
})
</script>
<style lang="less">
#webVueAntContentShow {
    height: 100%;
    width: 100%;
    position: relative;
    overflow: auto;
}
.none-select-page {
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
    font-size: 32px;
}
</style>
