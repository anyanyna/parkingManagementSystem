<template>
  <a-table ref="tableRef" :scroll="scrollValue" :class="{'custom-table': scroll.y !== undefined}"  :rowKey="(rowItem) => rowItem.id" :locale="{emptyText}" :columns="columnsWithOutId" :dataSource="dataSource" :rowSelection="rowSelection" :pagination="pagination" :customRow="customRow" @change="onChange">
    <template #headerCell="record">
      <div>
        <span class="th-text">{{record.title}}</span>
      </div>
    </template>
    <template #bodyCell="{ record, column, text,index }">
      <slot v-if="column && column.cellType === 'slot'" name="cell" :column="column" :record="record" :index="index"></slot>
      <div v-else-if="column && !column.customRender">
        <span class="td-text" :title='text'>{{text}}</span>
      </div>
    </template>
  </a-table>
</template>

<script>
import i18next from 'i18next';
import { createLocaleLang } from '../../../../../../shared/createLocaleLang';
import { computed, ref, onMounted, nextTick, watch } from 'vue';

export default {
  name: 'YtTable',
  props: {
    scroll: {
      type: Object,
      default: {}
    },
    selectType: {
      type: String,
      default: 'radio'
    },
    canSelect: {
      type: Boolean,
      default: true
    },
    emptyText: {
      type: String,
      default: '暂无数据'
    },
    columns: {
      type: Array,
      default: []
    },
    dataSource: {
      type: Array,
      default: []
    },
    selectedRows: {
      type: Array,
      default: () => {
        return []
      }
    },
    showSizeChanger: {
      type: Boolean,
      default: false
    },
    showQuickJumper: {
      type: Boolean,
      default: false
    },
    total: {
      type: Number,
      default: 0
    },
    hideOnSinglePage: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    },
    current: {
      type: Number,
      default: 1
    },
    pageSizeOptions: {
      type: Object,
      default: () => {
        return {"dataSource": [{"label":"10","value":10,"select":true}, {"label":"20","value":20,"select":false}, {"label":"30","value":30,"select":false}], "value": [10]}
      }
    },
    pageSize: {
      type: Number,
      default: 10
    }
  },
  setup (props, { emit }) {
    const tableRef = ref(null)
    const scrollValue = ref({})
    const items_per_page = ref('')
    const jump_to = ref('')
    const jump_to_confirm = ref('')
    const page = ref('')
    const prev_page = ref('')
    const next_page = ref('')
    const prev_5 = ref('')
    const next_5 = ref('')
    const prev_3 = ref('')
    const next_3 = ref('')

    onMounted(() => {
      i18next.init({
        lng: window.__$yt_lang, // 默认语言
        resources: createLocaleLang(import.meta.globEager('./locales/**/data.json')),
      })
      items_per_page.value = i18next.t('items_per_page'),
      jump_to.value = i18next.t('jump_to'),
      jump_to_confirm.value = i18next.t('jump_to_confirm'),
      page.value = i18next.t('page'),
      prev_page.value = i18next.t('prev_page'),
      next_page.value = i18next.t('next_page'),
      prev_5.value = i18next.t('prev_5'),
      next_5.value = i18next.t('next_5'),
      prev_3.value = i18next.t('prev_3'),
      next_3.value = i18next.t('next_3')
    })

    const rowSelection = computed(() => {
      if (props.canSelect) {
        return {
          type: props.selectType,
          hideSelectAll: false,
          selectedRowKeys: props.selectedRowKeys,
          onChange: (selectedRowKeys, selectedRows) => {
            emit('update:selectedRows', selectedRows)
            emit('onRowSelect', selectedRows)
          }
        }
      } else {
        return null
      }
    })
    const customRow = (record) => {
      return{
        onClick: (e) => {
          if (e.target.classList.contains('ant-radio-inner') && e.target.closest('.ant-table-selection-column')) {
            return false
          } else {
            emit('onRowClick', record)
          }
        }
      }
    }
    watch([() => props.dataSource, () => props.current, () => props.pageSize], async () => {
      await nextTick
      const { scroll, dataSource } = props
      if (tableRef && dataSource.length && scroll && scroll.y !== undefined) {
        const dom = tableRef.value?.$el?.querySelector('.ant-table-tbody')
        if (dom) {
          const { height } = dom.getBoundingClientRect()
          if (height > scroll.y) {
            scrollValue.value.y = scroll.y
            return
          }
        }
      }
      scrollValue.value = {}
    }, {immediate: true, deep: true})
    const columnsWithOutId = computed(() => {
      const { columns } = props
      return columns.map((item) => {
        // delete item.width
        if (item.dataIndex !== 'id') {
          return item
        }
        // return item
      }).filter((item) => item)
    })
    const pagination = computed(() => {
      const { total, current, showSizeChanger, showQuickJumper, hideOnSinglePage, disabled, pageSizeOptions, pageSize } = props
      return {
        pageSize,
        current,
        total,
        showSizeChanger,
        showQuickJumper,
        hideOnSinglePage,
        disabled,
        locale: {
          items_per_page: items_per_page.value,
          jump_to: jump_to.value,
          jump_to_confirm: jump_to_confirm.value,
          page: page.value,
          prev_page: prev_page.value,
          next_page: next_page.value,
          prev_5: prev_5.value,
          next_5: next_5.value,
          prev_3: prev_3.value,
          next_3: next_3.value
        },
        pageSizeOptions: pageSizeOptions.dataSource.map((item) => {
          if (typeof item.value === 'string') {
            return item.value
          } else {
            return JSON.stringify(item.value)
          }
        })
      }
    })
    const onChange = (page) => {
      if (page.total !== pagination.value.total) {
        const data = {
          value: page.total,
          comkey: 'total',
          superExecute: false,
          flush: true
        }
        emit('toUpdataData', data) 
      }
      if (page.current !== pagination.value.current) {
        const data = {
          value: page.current,
          comkey: 'current',
          superExecute: false,
          flush: true
        }
        emit('toUpdataData', data) 
      }
      if (page.pageSize !== pagination.value.pageSize) {
        const data = {
          value: page.pageSize,
          comkey: 'pageSize',
          superExecute: false,
          flush: true
        }
        emit('toUpdataData', data) 
      }
      emit('update:total', page.total)
      emit('update:current', page.current)
      emit('update:pageSize', page.pageSize)
      emit('onTableChange', page)
    }
    return { rowSelection, customRow, pagination, columnsWithOutId, onChange, tableRef, scrollValue }
  }
};
</script>

<style lang="less" scoped>
</style>