export default {
  template: `
  <yt-table
    ref
    class="webVueAntYtTable _$customClassName$_"
    :select="_$select$_"
    :showHead="_$showHead$_"
    v-model:currentRow="_$currentRow$_"
    v-model:selectRows="_$selectRows$_"
    :columns="_$data.columns$_"
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
  </yt-table>`,
  clazzType: 'YtTable'
}