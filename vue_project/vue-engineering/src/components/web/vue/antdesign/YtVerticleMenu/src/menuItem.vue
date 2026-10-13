<template>
    <div>
        <template v-if="!menu.children" key="menu">
            <a-menu-item @click="() => titleClick(menu)" :key="menu.key" :class="[selectedKeys.includes(menu.key)?'ant-menu-item-selected':'']" :disabled="menu.disabled">
                <span :style="{'margin-left': menu.iconUrl? 0 : `${currInlineIndent}px`}">{{ menu.title }}</span>  
                <template #icon>
                    <img v-show="menu.iconUrl" :style="{'margin-left': menu.iconUrl? `${currInlineIndent}px`: 0}" class="custom-icon" :src="menu.iconUrl" alt="">
                </template>
            </a-menu-item>
        </template>
        <template v-else key="subMenu">
            <a-sub-menu
                :key="menu.key"
                :disabled="menu.disabled"
                :class="[selectedKeys.includes(menu.key)?'sub-menu-selected':'']"
                :popupClassName="'yt-horizontal-menu-menu-sub-menu submenu-'+ menu.key"
                @titleClick="() => titleClick(menu)">  
                <template #icon>
                    <img v-show="menu.iconUrl" :style="{'margin-left': menu.iconUrl? `${currInlineIndent}px`: 0}" class="custom-icon" :src="menu.iconUrl" alt="">
                </template>
                <template #title>  
                    <span :style="{'margin-left': menu.iconUrl? 0 : `${currInlineIndent}px`}">{{ menu.title }}</span>  
                </template>
                <menu-item
                    :selectedKeys="selectedKeys"
                    v-for="submenu in menu.children"
                    :key="submenu.key"
                    :menu="submenu"
                    :inlineIndent="inlineIndent"
                    :currInlineIndent="currInlineIndent + inlineIndent"
                    @select="select"
                />
            </a-sub-menu>  
        </template>
    </div>
</template>
<script>

export default {
    props: {
        menu: {
            type: Object,
            required: true
        },
        menuKey: {
            type: String,
            required: false
        },
        selectedKeys: {
            type: Array,
            required: []
        },
        inlineIndent: {
            type: Number,
            default: 24
        },
        currInlineIndent: {
            type: Number,
            default: 0
        }
    },
    data() {
        return {
        }
    },
    methods: {
        select (selectObject) {
            this.$emit('select',{ item: selectObject.item, key:selectObject.key})
        },
        titleClick (selectObject){
            this.$emit('select',{ item: selectObject, key:selectObject.key})
        }
    },
    mounted() {
    },
    name: "menu-item",
};
</script>
<style lang="less" scoped>
    .custom-icon {
        width: 12px;
    }
</style>
