<template>
  <a-tree :treeData="treeData" :showIcon="showIcon" :checkable="checkable" :showLine="showLine" :blockNode="blockNode" :disabled="disabled"
    :draggable="draggable" :checkStrictly="checkStrictly" :expandedKeys="expandedKeys" :selectedKeys="selectedKeys" @expand="handleExpand"
          :checkedKeys="checkedKeys"
    @select="handleSelect" :class="{nowrapEllipsis: ellipsis=='ellipsis'}" @drop="handleDragEnd" @check="handleCheck">
    <template #switcherIcon="{ switcherCls, dataRef }">
      <img :class="[switcherCls, {rotate:expandedKeys&&expandedKeys.includes(dataRef.key)}]" :src="showSwitcherIcon" alt="">
    </template>
    <template #icon="{dataRef}">
      <img class="custom-icon" :src="dataRef.iconUrl" alt="">
    </template>
    <template #title="{ dataRef }">
      <span :style="{lineHeight: lineHeight}">{{ dataRef.title }}</span>
    </template>
  </a-tree>
</template>

<script>
import i18next from 'i18next'
import { createLocaleLang } from '../../../../../../shared/createLocaleLang'
i18next.init({
  lng: window.__$yt_lang, // 默认语言
  resources: createLocaleLang(import.meta.globEager('./locales/**/data.json'))
})

export default {
  name: "yt-tree",
  props: {
    expandedKeys: {
      type: Array,
      default: () => ([])
    },
    selectedKeys: {
      type: Array,
      default: () => ([])
    },
  checkedKeys: {
    type: Array,
    default: () => ([])
  },
    showIcon: {
      type: Boolean,
      default: false
    },
    checkable: {
      type: Boolean,
      default: false
    },
    switcherIcon: {
      type: String,
      default: ""
    },
    showLine: {
      type: Boolean,
      default: false
    },
    ellipsis: {
      type: String,
      default: "ellipsis"
    },
    lineHeight: {
      type: String,
      default: "1.5"
    },
    blockNode: {
      type: Boolean,
      default: false
    },
    options: {
      type: Object,
      default: () => ([])
    },
    selectedBackgroundColor: {
      type: Object,
      default: () => ({})
    },
    selectedTextColor: {
      type: Object,
      default: () => ({})
    },
    hoverBackgroundColor: {
      type: Object,
      default: () => ({})
    },
    hoverTextColor: {
      type: Object,
      default: () => ({})
    },
    disabled: {
      type: Boolean,
      default: false
    },
    draggable: {
      type: Boolean,
      default: false
    },
    accordion: {
      type: Boolean,
      default: false
    },
    checkStrictly: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      treeData: this.options,
    }
  },
  watch: {
    options: {
     handler(newVal, oldVal) {
      if(newVal !== oldVal) {
        this.treeData = newVal
      }
     },
     deep: true
    }
  },
  computed: {
    showSwitcherIcon() {
      if(this.switcherIcon && this.switcherIcon.trimStart().startsWith('/staticResource/public/')) {
        return '.'+ this.switcherIcon
      }
      return this.switcherIcon
    }
  },
  mounted () {
    const treeList = this.$el.parentElement.getElementsByClassName("ant-tree-list")[0]
    if (this.draggable && treeList) {
      treeList.onmousedown = (e) => {
        e.stopPropagation()
      }
    }
  },
  methods: {
    getIconUrl(url) {
      if (url) {
        if (url.startsWith("data:")) {
          return url
        } else {
          if (!window.location.port) {
            return window.location.origin + ':8088' + url
          } else {
            return window.location.origin + '/api' + url
          }
        }
      } else {
        return ''
      }
    },
    handleExpand (keys, { expanded, node }) {
      const tempKeys = ((node.parent ? node.parent.children : this.options) || []).map(({ key }) => key)
      if (expanded && this.accordion) {
        function difference(array, value) {
          let index = -1,
          arrayLength = array.length,
          result = [],
          valueLength = value.length
          outer:
          while (++index < arrayLength) {
          var len = valueLength
          while (len--) {
            if (array[index] === value[len]) {
              continue outer
            }
          }
          result.push(array[index])
          }
          return result
        }
        this.$emit("update:expandedKeys", difference(keys, tempKeys).concat(node.key))
      } else {
        this.$emit("update:expandedKeys", keys)
      }
    },
    handleSelect (selectedKeys) {
      this.$emit("update:selectedKeys", selectedKeys)
    },
    handleCheck(checkedKeys) {
      this.$emit("update:checkedKeys", checkedKeys);
    },
    handleDragEnd (info) {
      const dropKey = info.node.key
      const dragKey = info.dragNode.key
      const dropPos = info.node.pos.split('-')
      const dropPosition = info.dropPosition - Number(dropPos[dropPos.length - 1])
      const loop = (data, key, callback) => {
        data.forEach((item, index) => {
          if (item.key === key) {
            return callback(item, index, data)
          }
          if (item.children) {
            return loop(item.children, key, callback)
          }
        })
      }
      const data = [...this.treeData]

      let dragObj
      loop(data, dragKey, (item, index, arr) => {
        arr.splice(index, 1)
        dragObj = item
      })
      if (!info.dropToGap) {
        loop(data, dropKey, item => {
          item.children = item.children || []
          item.children.unshift(dragObj)
        })
      } else if ((info.node.children || []).length > 0 && info.node.expanded && dropPosition === 1) {
        loop(data, dropKey, item => {
          item.children = item.children || []
          item.children.unshift(dragObj)
        })
      } else {
        let ar = []
        let i = 0
        loop(data, dropKey, (_item, index, arr) => {
          ar = arr
          i = index
        })
        if (dropPosition === -1) {
          ar.splice(i, 0, dragObj)
        } else {
          ar.splice(i + 1, 0, dragObj)
        }
      }
      this.treeData = data
      this.$emit("update:options", data)
    }
  }
}
</script>

<style lang="less" scoped>
.ant-tree-switcher-icon {
  width: 12px;
}
.custom-icon {
  width: 12px;
}

</style>
<style>
.webVueAntYtTree .ant-tree-node-content-wrapper .ant-tree-iconEle {
  display: inline-flex;
  align-items: center;
  justify-content: center;
}
</style>