<template>
  <div class="arrearage bg-gradient-to-br from-gray-50 to-gray-100 px-8 py-6 relative">
    <!-- 面包屑导航 -->
    <div class="mb-6">
      <a-breadcrumb>
        <a-breadcrumb-item>运营管理</a-breadcrumb-item>
        <a-breadcrumb-item>欠费管理</a-breadcrumb-item>
      </a-breadcrumb>
    </div>
    <!-- 搜索区域 -->
    <div class="bg-white rounded-xl p-6 mb-6 shadow-lg border border-gray-100 transition-all hover:shadow-xl relative">
      <div class="mb-6 grid grid-cols-4 gap-4">
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">手机号：</span>
          <a-input v-model:value="searchForm.phone" placeholder="请输入手机号" class="flex-1" :maxLength="11" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">车牌号：</span>
          <a-input v-model:value="searchForm.plateNumber" placeholder="请输入车牌号" class="flex-1" :maxLength="8" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">逾期时长：</span>
          <a-select v-model:value="searchForm.overdueTime" placeholder="请选择逾期时长" class="flex-1">
            <a-select-option value="7">7天以上</a-select-option>
            <a-select-option value="30">30天以上</a-select-option>
            <a-select-option value="90">90天以上</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">追缴状态：</span>
          <a-select v-model:value="searchForm.status" placeholder="请选择追缴状态" class="flex-1">
            <a-select-option value="pending">待追缴</a-select-option>
            <a-select-option value="partial">部分追缴</a-select-option>
            <a-select-option value="completed">已追缴</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">创建时间：</span>
          <a-range-picker v-model:value="searchForm.createTime" class="flex-1" :placeholder="['开始时间', '结束时间']" />
        </div>
        <div class="absolute right-6 bottom-6 flex gap-4">
          <a-button type="primary" @click="handleSearch"
            class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600">搜索</a-button>
          <a-button @click="handleReset" class="!rounded-button px-6 h-10">重置</a-button>
        </div>
      </div>
    </div>
    <!-- 表格工具栏和表格区域 -->
    <div class="bg-white rounded-xl p-6 shadow-lg border border-gray-100 transition-all hover:shadow-xl overflow-hidden">
      <div class="mb-5">
        <div class="flex gap-4">
          <a-button type="primary" @click="handleExport"
            class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600 min-w-[72px]">
            导出
          </a-button>
        </div>
      </div>
      <!-- 表格区域 -->
      <div>
        <a-table :columns="columns" :data-source="tableData"
          :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }" :pagination="pagination"
          @change="handleTableChange" class="custom-table" :locale="{
            emptyText: '暂无数据'
          }">
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'debtCount'">
              <span class="text-blue-600">{{ record.debtCount }}</span>
            </template>
            <template v-else-if="column.key === 'status'">
              <a-tag :color="getStatusColor(record.status)">{{ getStatusText(record.status) }}</a-tag>
            </template>
            <template v-else-if="column.key === 'action'">
              <div class="flex items-center justify-center">
                <a-button type="link" @click="showCollectionModal(record)"
                  class="!rounded-button text-blue-600 hover:text-blue-700 px-4">
                  追缴
                </a-button>
                <a-popconfirm title="确定要移除这条记录吗？" ok-text="确定" cancel-text="取消" @confirm="handleDelete(record)">
                  <a-button type="link" class="!rounded-button text-red-600 hover:text-red-700 px-4">
                    移除
                  </a-button>
                </a-popconfirm>
              </div>
            </template>
          </template>
        </a-table>
      </div>
    </div>
    <!-- 追缴弹窗 -->
    <a-modal v-model:visible="collectionModalVisible" title="追缴欠费" :confirmLoading="confirmLoading" :footer="null"
      :maskClosable="false" :keyboard="false" :width="480">
      <div class="py-4">
        <div class="mb-4">
          <div class="text-gray-600 mb-2">车牌号</div>
          <div class="text-gray-900 font-medium">{{ currentRecord?.plateNumber }}</div>
        </div>
        <div class="mb-4">
          <div class="text-gray-600 mb-2">欠费金额</div>
          <div class="text-gray-900 font-medium">{{ currentRecord?.debtAmount }}</div>
        </div>
        <div class="mb-4">
          <div class="text-gray-600 mb-2">追缴金额</div>
          <a-input-number v-model:value="collectionAmount" :min="0" :max="9999999" :precision="2" class="w-full"
            placeholder="请输入追缴金额" />
        </div>
        <div class="mb-4">
          <div class="text-gray-600 mb-2">备注</div>
          <a-textarea v-model:value="collectionRemark" :rows="4" placeholder="请输入备注信息" />
        </div>
        <div class="flex justify-end gap-4 mt-8">
          <a-button @click="handleCollectionCancel" size="large" class="!rounded-button px-6">
            取消
          </a-button>
          <a-button @click="handlePartialCollection" type="primary" :loading="confirmLoading" size="large"
            class="!rounded-button px-6 bg-blue-500 hover:bg-blue-600">
            部分追缴
          </a-button>
          <a-button @click="handleFullCollection" type="primary" :loading="confirmLoading" size="large"
            class="!rounded-button px-6 bg-green-600 hover:bg-green-700">
            完成追缴
          </a-button>
        </div>
      </div>
    </a-modal>
  </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import { message } from 'ant-design-vue';
interface SearchForm {
  phone: string;
  plateNumber: string;
  overdueTime: string;
  status: string;
  createTime: [string, string] | null;
}
const searchForm = reactive<SearchForm>({
  phone: '',
  plateNumber: '',
  overdueTime: '',
  status: '',
  createTime: null
});
const columns = [
  { title: '序号', key: 'index', dataIndex: 'index', width: 80, align: 'center' },
  { title: '车牌号', key: 'plateNumber', dataIndex: 'plateNumber', width: 120, align: 'center' },
  { title: '手机号', key: 'phone', dataIndex: 'phone', width: 120, align: 'center' },
  { title: '欠费金额', key: 'debtAmount', dataIndex: 'debtAmount', width: 120, align: 'center' },
  { title: '欠费笔数', key: 'debtCount', dataIndex: 'debtCount', width: 120, align: 'center' },
  { title: '逾期时长', key: 'overdueTime', dataIndex: 'overdueTime', width: 120, align: 'center' },
  { title: '追缴金额', key: 'collectedAmount', dataIndex: 'collectedAmount', width: 120, align: 'center' },
  { title: '追缴状态', key: 'status', dataIndex: 'status', width: 120, align: 'center' },
  { title: '创建时间', key: 'createTime', dataIndex: 'createTime', width: 160, align: 'center' },
  { title: '备注', key: 'remark', dataIndex: 'remark', width: 200, align: 'center' },
  { title: '操作', key: 'action', width: 160, align: 'center', fixed: 'right' }
];
const tableData = ref([
  {
    key: '1',
    index: 1,
    plateNumber: '沪A12345',
    phone: '13812345678',
    debtAmount: '￥150.00',
    debtCount: 3,
    overdueTime: '45天',
    collectedAmount: '￥0.00',
    status: 'pending',
    remark: '已电话通知车主，承诺本周内缴费',
    createTime: '2024-01-15 14:30:00'
  },
  {
    key: '2',
    index: 2,
    plateNumber: '沪B98765',
    phone: '13987654321',
    debtAmount: '￥280.00',
    debtCount: 5,
    overdueTime: '60天',
    collectedAmount: '￥180.00',
    status: 'partial',
    remark: '分两次缴纳，第一次已缴纳180元',
    createTime: '2024-01-01 09:00:00'
  },
  {
    key: '3',
    index: 3,
    plateNumber: '沪C24680',
    phone: '13600001111',
    debtAmount: '￥90.00',
    debtCount: 2,
    overdueTime: '30天',
    collectedAmount: '￥90.00',
    status: 'completed',
    remark: '已全额缴纳',
    createTime: '2024-02-01 16:45:00'
  }
]);
const collectionModalVisible = ref(false);
const confirmLoading = ref(false);
const collectionAmount = ref<number>();
const collectionRemark = ref('');
const currentRecord = ref<any>(null);
const getStatusColor = (status: string) => {
  const statusColors: Record<string, string> = {
    pending: 'orange',
    partial: 'blue',
    completed: 'green'
  };
  return statusColors[status] || 'default';
};
const getStatusText = (status: string) => {
  const statusTexts: Record<string, string> = {
    pending: '待追缴',
    partial: '部分追缴',
    completed: '已追缴'
  };
  return statusTexts[status] || '未知状态';
};
const selectedRowKeys = ref<string[]>([]);
const selectedRows = ref<any[]>([]);
const pagination = reactive({
  total: 100,
  current: 1,
  pageSize: 10,
  showSizeChanger: true,
  showQuickJumper: true,
  showTotal: (total: number) => `共 ${total} 条记录`
});
const handleSearch = () => {
  message.success('搜索执行成功');
};
const handleReset = () => {
  Object.assign(searchForm, {
    phone: '',
    plateNumber: '',
    overdueTime: '',
    status: '',
    createTime: null
  });
  message.success('重置成功');
};
const showCollectionModal = (record: any) => {
  currentRecord.value = record;
  collectionAmount.value = undefined;
  collectionRemark.value = '';
  collectionModalVisible.value = true;
};
const handlePartialCollection = () => {
  if (!collectionAmount.value) {
    message.error('请输入追缴金额');
    return;
  }
  confirmLoading.value = true;
  setTimeout(() => {
    message.success(`成功部分追缴 ${currentRecord.value.plateNumber} 的欠费`);
    confirmLoading.value = false;
    collectionModalVisible.value = false;
  }, 1500);
};
const handleFullCollection = () => {
  if (!collectionAmount.value) {
    message.error('请输入追缴金额');
    return;
  }
  confirmLoading.value = true;
  setTimeout(() => {
    message.success(`完成追缴 ${currentRecord.value.plateNumber} 的全部欠费`);
    confirmLoading.value = false;
    collectionModalVisible.value = false;
    currentRecord.value.status = 'completed';
  }, 1500);
};
const handleCollectionCancel = () => {
  collectionModalVisible.value = false;
};
const handleDelete = (record: any) => {
  message.success(`已移除：${record.plateNumber}的欠费记录`);
};
const handleExport = () => {
  message.success('数据导出中，请稍候...');
};
const onSelectChange = (selectedKeys: string[], rows: any[]) => {
  selectedRowKeys.value = selectedKeys;
  selectedRows.value = rows;
};
const handleTableChange = (pag: any) => {
  pagination.current = pag.current;
  pagination.pageSize = pag.pageSize;
};
</script>
<style scoped lang="less">
.arrearage {
  width: 100%;
}

.ant-table-wrapper {
  width: 100%;
}

.ant-input,
.ant-select,
.ant-picker {
  border-radius: 6px;
  height: 40px;
}

.ant-input-number {
  width: 100%;
  border-radius: 6px;
}

:deep(.ant-select-selector) {
  background-color: white !important;
  border: 1px solid #d9d9d9 !important;
  height: 40px !important;
  display: flex !important;
  align-items: center !important;
}

.ant-input {
  border: 1px solid #d9d9d9 !important;
  background-color: white !important;
}

.ant-picker {
  border: 1px solid #d9d9d9 !important;
  background-color: white !important;
}

.ant-select:hover .ant-select-selector,
.ant-input:hover,
.ant-picker:hover {
  border-color: #4096ff !important;
}

.ant-select-selection-search-input {
  height: 38px !important;
}

.ant-select-selection-item {
  line-height: 32px !important;
}

.ant-btn {
  // display: inline-flex;
  // align-items: center;
  // justify-content: center;
  // height: 40px;
  // padding: 0 20px;
  // transition: all 0.3s ease;
}

.ant-table-pagination {
  margin: 16px 24px !important;
  display: flex;
  justify-content: flex-end !important;
}

.ant-pagination-options {
  margin-left: 16px !important;
}

.custom-table .ant-table-thead>tr>th {
  background-color: #f8fafc;
  color: #1f2937;
  font-weight: 600;
  font-size: 14px;
  border-bottom: 1px solid #e5e7eb;
}

.custom-table .ant-table-tbody>tr>td {
  border-bottom: 1px solid #f1f5f9;
}

.custom-table .ant-table-tbody>tr:hover>td {
  background-color: #f8fafc;
}

.ant-tag {
  border-radius: 4px;
  padding: 2px 8px;
  font-size: 13px;
}

.ant-table {
  border-radius: 12px;
  overflow: hidden;
}

.ant-pagination-options-quick-jumper input {
  height: 32px !important;
  line-height: 32px !important;
}

.ant-pagination-item-link {
  display: flex !important;
  align-items: center !important;
  justify-content: center !important;
}
</style>
