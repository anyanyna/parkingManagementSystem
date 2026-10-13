<template>
    <a-menu
        v-model:openKeys="truthOpenKeys"
        v-model:selectedKeys="truthSelectedKeys"
        :mode="mode"
        @openChange="openChange"
        v-bind="filteredProps"
    >
        <recursive-menu-item
            :selectedKeys="selectedKeys"
            v-for="menu in items"
            :key="menu.key"
            :inlineIndent="mode === 'inline' ? inlineIndent : 0"
            :currInlineIndent="currInlineIndent"
            :menu="menu"
            @select="selectedChange"
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
        mode: {
            type: String,
            default: 'inline'
        },
        inlineIndent: {
            type: Number,
            default: 24
        },
        singleExpand: {
            type: Boolean
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
            oldOpenKeys:[],
            truthSelectedKeys: [],
            currInlineIndent: 0
        }
    },
    watch: {
        selectedKeys (val) {
            this.truthSelectedKeys = val
        }
    },
    computed: {
        filteredProps() {
            // 创建一个不包含prop2的新对象
            const { onSelect, onOpenChange, ['onUpdate:selectedKeys']: updateSelectedKeys, ['onUpdate:openKeys']: updateOpenKeysKeys, ...rest } = this.$attrs;
            return rest;
        },
        subMenuKeys() {
            return this.items.map(item => {
                return item.key
            })
        }
    },
    methods: {
        openChange(openKeys) {
            let currOpenKeys = openKeys
            if(this.singleExpand) {
                const latestOpenKey = openKeys.find(key => this.oldOpenKeys.indexOf(key) === -1)
                if (this.subMenuKeys.indexOf(latestOpenKey) === -1) {
                    currOpenKeys = openKeys
                } else {
                    currOpenKeys = latestOpenKey ? [latestOpenKey] : []
                }
                
            }else {}
            this.oldOpenKeys = currOpenKeys
            this.truthOpenKeys = currOpenKeys
            this.$emit('openChange', currOpenKeys);
            this.$emit('update:openKeys', currOpenKeys);
        },
        selectedChange({item, key}) {
            if(this.parentSelectAble && item.children) {
                this.truthSelectedKeys = [item.key]
                this.$emit('update:selectedKeys', [key]);
                this.$emit('click_to_jump', key, item,  [key]);
                this.$emit('select', key, item, [key]);
            }else if(!item.children) {
                this.$emit('update:selectedKeys', [key]);
                this.$emit('click_to_jump', key, item,  [key]);
                this.$emit('select', key, item, [key]);
            }

        }
    },
    name: "yt-vertical-menu-menu",
};
</script>
<style lang="less" scoped>
    .webVueAntYtVerticleMenu.ant-menu-vertical :deep(div>li.ant-menu-item),
    .webVueAntYtVerticleMenu.ant-menu-vertical :deep(div>li>.ant-menu-submenu-title),
    .webVueAntYtVerticleMenu.ant-menu-vertical :deep(div>li.ant-menu-item.ant-menu-item-only-child) {
        display: flex;
        align-items: center
    }
</style>
