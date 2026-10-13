<template>
    <div>
        <template v-if="!menu.children" key="menu">
            <a-menu-item :key="menu.key" :disabled="menu.disabled">
                <span>{{ menu.title }}</span>  
                <template #icon>
                    <img v-show="menu.iconUrl" class="custom-icon" :src="menu.iconUrl" alt="">
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
                    <img v-show="menu.iconUrl" class="custom-icon" :src="menu.iconUrl" alt="">
                </template>
                <template #title>  
                    <span>{{ menu.title }}</span>  
                </template>
                <menu-item
                    :selectedKeys="selectedKeys"
                    v-for="submenu in menu.children"
                    :key="submenu.key"
                    :menu="submenu"  
                    @select="titleClick"
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
    },
    data() {
        return {
        }
    },
    methods: {
        titleClick (selectObject){
            this.$emit('select', selectObject)
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
        margin-right: 8px;
    }
</style>
