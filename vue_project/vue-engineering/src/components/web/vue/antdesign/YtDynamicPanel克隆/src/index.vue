<template>
    <div id="webVueAntDynamicPanel" ref="webVueAntDynamicPanel">
        <slot></slot>
    </div>
</template>

<script setup>
import { defineExpose, defineOptions,watch, onMounted,ref } from 'vue';
import i18next from 'i18next';
import { createLocaleLang } from '../../../../../../shared/createLocaleLang';
i18next.init({
    lng: window.__$yt_lang, // 默认语言
    resources: createLocaleLang(import.meta.globEager('./locales/**/data.json')),
});
const props = defineProps({
    mutileStyle:String,
    selectKey:String
})
const webVueAntDynamicPanel = ref(null);
onMounted(() => {
    updateStyles();
})
const updateStyles = () => {
    const info = props.mutileStyle ? JSON.parse(props.mutileStyle):[]
    let currentStyle = {}
    if(info && Array.isArray(info)){
        currentStyle = info.find(item => item.statusId === props.selectKey) || {}
    }
    // 获取该dom下的所有item
    const elementsWithComponentId = webVueAntDynamicPanel.value.querySelectorAll('[componentId]');
    elementsWithComponentId.forEach(element => {
      const id = element.getAttribute('componentId');
      element.style.gridColumnStart = currentStyle[id].gridColumnStart
      element.style.gridColumnEnd = currentStyle[id].gridColumnEnd
      element.style.gridRowStart = currentStyle[id].gridRowStart
      element.style.gridRowEnd = currentStyle[id].gridRowEnd
    });
}
watch(() => props.selectKey, updateStyles);

const setStatusList = (ctx, StatusList) => {
    let arr = []
    Array.isArray(StatusList) && StatusList.forEach(item => {
        arr.push({
            label:item.label,
            value:item.statusId.toString()
        })
    });
    ctx['realOptions'] = arr
}
defineExpose({
    setStatusList
})
defineOptions({
    name: 'yt-dynamic-panel'
})
</script>
<style>
#webVueAntDynamicPanel {
    height: 100%;
    width: 100%;
    overflow: auto;
}
</style>
