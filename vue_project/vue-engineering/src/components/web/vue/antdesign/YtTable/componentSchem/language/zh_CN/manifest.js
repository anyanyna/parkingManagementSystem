import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
const template = `
  <yt-table
    ref
    class="webVueAntYtTable _$customClassName$_"
    :selectType="_$selectType$_"
    :canSelect="_$canSelect$_"
    :emptyText="_$emptyText$_"
    v-model:selectedRows="_$selectedRows$_"
    v-model:total="_$total$_"
    v-model:current="_$current$_"
    v-model:pageSize="_$pageSize$_"
    :columns="_$data.columns$_"
    :showSizeChanger="_$showSizeChanger$_"
    :pageSizeOptions="_$pageSizeOptions$_"
    :showQuickJumper="_$showQuickJumper$_"
    :disabled="_$disabled$_"
    :dataSource="_$data.dataSource$_">
      <template #cell="{ column, record }">
        <yt-for :data="item in _$data.columns$_" uniqueKey="_&item.dataIndex&_">
          <yt-for-template>
            <template v-if="column.dataIndex === _&item.dataIndex&_" :forKey="_&item.dataIndex&_">
              <yt-template params="record" backgroundType="color" background="" previewType=""  contentHeight="" contentWidth="" customWidth="" customHeight="" minWidth="" maxWidth="" minHeight="" maxHeight="" width="100%" height="100%" yt-dynamicTag="_&item.dataIndex&_" class="customTableTemplate"></yt-template>
            </template>
          </yt-for-template>
        </yt-for>
      </template>
  </yt-table>`
export default {
  template: template,
  clazzType: 'YtTable',
  editConfig:{
    getRuntimeConfig,
    getTemplate:()=>template,
    replaceComkeys:[{
      oldKey: 'currentRow',  // 原来的comkey
      newKey: undefined  // 更新后的comkey，如果newKey为undefined，就是要删除oldKey
    },
    {
      oldKey: 'hideOnSinglePage',  // 原来的comkey
      newKey: undefined  // 更新后的comkey，如果newKey为undefined，就是要删除oldKey
    }],
    // 属性静态和动态之间的转换
    convertData:[{
      comkey:'total',
      type:'toDynamic'  // 静态转成动态。type的值可以是toDynamic、toStatic
    },{
      comkey:'current',
      type:'toDynamic'
    }],
    machTemplateAst:(node)=>{
      const nodeInfo = node[Object.keys(node)[0]] || {};
      const attributes = nodeInfo['attributes'] || {};
      const tagName = Object.keys(node)[0];
      if(attributes && attributes['#cell'] == "{ column, record }" ){
        return true
      }
      return false
    },
    requirementField:()=>{
      return 'colStyleArr'
    },
    _$isAddScroll:(tagName)=>{
      return tagName === 'yt-table'
    }
  }
}