<template>
    <a-menu
        v-model:openKeys="truthOpenKeys"
        v-model:selectedKeys="truthSelectedKeys"
        @openChange="openChange"
        @select="selectedChange"
        mode="horizontal"
        :getPopupContainer="(triggerNode) => {
            return triggerNode.parentNode
        }"
        v-bind="filteredProps"
    >
        <recursive-menu-item  
            :selectedKeys="selectedKeys"
            v-for="menu in items"  
            :menuKey="menu.key"  
            :menu="menu"  
            @select="parentSelectedChange"
            /> 
    </a-menu>
</template>
<script>
import i18next from 'i18next';
import {createLocaleLang} from '../../../../../../shared/createLocaleLang'
import menuItem from './menuItem.vue'
// console.log(window.__$yt_theme,window.__$yt_lang)
i18next.init({
    lng: window.__$yt_lang, // 默认语言
    resources: createLocaleLang(import.meta.globEager('./locales/**/data.json'))
});
export default {
    inheritAttrs: false,
    props: {
        items: {
            type: Array,
            required: true
        },
        openKeys: {
            type: Array,
            default: []
        },
        selectedKeys: {
            type: Array,
            default: []
        },
        parentSelectAble: {
            type: Boolean
        }
    },
    components: {  
        // 递归组件  
        RecursiveMenuItem: menuItem
    }, 
    data() {
        return {
            content: i18next.t('content'),
            truthOpenKeys:[],
            truthSelectedKeys: this.selectedKeys
        }
    },
    computed: {
        filteredProps() {
            // 创建一个不包含prop2的新对象
            const { onSelect, onOpenChange, ['onUpdate:selectedKeys']: updateSelectedKeys, ['onUpdate:openKeys']: updateOpenKeysKeys, ...rest } = this.$attrs;
            return rest;
        },
    },
    methods: {
        openChange(openKeys) {
            this.$emit('update:openKeys', openKeys);
        },
        selectedChange({item, key}) {
            if(this.parentSelectAble && item.children || !item.children) {
                this.$emit('update:selectedKeys', [key]);
                this.$emit('click_to_jump', key, item,  [key]);
                this.$emit('select', key, item, [key]);
                this.$emit('toSelect', key, item, [key]);
            }
        }
    },
    name: "yt-horizontal-menu-menu",
};
</script>
<style lang="less" scoped>
.ant-menu {
    display: flex;
}
.ant-menu>div {
    flex:1;
}
.ant-menu-horizontal {
    line-height: unset
}

.ant-menu-horizontal :deep(.ant-menu-vertical .ant-menu-item),
.ant-menu-horizontal :deep(.ant-menu-vertical .ant-menu-submenu-title),
.ant-menu-horizontal :deep(.ant-menu-vertical-left .ant-menu-item),
.ant-menu-horizontal :deep(.ant-menu-vertical-left .ant-menu-submenu-title),
.ant-menu-horizontal :deep(.ant-menu-vertical-right .ant-menu-item),
.ant-menu-horizontal :deep(.ant-menu-vertical-right .ant-menu-submenu-title ){
    line-height: unset;
    padding: 0;
}
.ant-menu-horizontal :deep(div>li.ant-menu-item),
.ant-menu-horizontal :deep(div>li>.ant-menu-submenu-title),
.ant-menu-horizontal :deep(div>li.ant-menu-item.ant-menu-item-only-child) {
    display: flex;
    align-items: center;
}
.ant-menu-horizontal :deep(div>li.ant-menu-item .ant-menu-title-content),
.ant-menu-horizontal :deep(div>li>.ant-menu-submenu-title .ant-menu-title-content),
.ant-menu-horizontal :deep(div>li.ant-menu-item.ant-menu-item-only-child .ant-menu-title-content) {
    margin-left: 0!important;
}
</style>