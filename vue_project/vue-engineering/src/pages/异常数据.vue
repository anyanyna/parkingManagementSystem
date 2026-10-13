<template>
  <div class="abnormal bg-gradient-to-br from-gray-50 to-gray-100 px-8 py-6 relative">
    <!-- 历史订单弹窗 -->
    <a-modal v-model:visible="historyVisible" title="历史订单记录" width="800px" :footer="null">
      <div class="space-y-4">
        <div class="flex items-center justify-between">
          <div class="text-lg font-medium">车牌号：{{ selectedPlate }}</div>
          <div class="text-gray-500">最近10条记录</div>
        </div>
        <a-table :columns="historyColumns" :data-source="historyData" :pagination="false" class="custom-table">
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'status'">
              <a-tag :color="record.status === '已完成' ? 'success' : 'processing'">
                {{ record.status }}
              </a-tag>
            </template>
            <template v-if="column.key === 'amount'">
              <span class="text-red-500">¥{{ record.amount }}</span>
            </template>
          </template>
        </a-table>
      </div>
    </a-modal>
    <!-- 忽略异常弹窗 -->
    <a-modal v-model:visible="ignoreVisible" title="忽略异常" @ok="handleIgnoreConfirm" @cancel="handleIgnoreCancel"
      :okButtonProps="{ class: 'bg-blue-500 hover:bg-blue-600 !rounded-button' }">
      <p class="text-gray-600">您确认要忽略该条异常记录吗？</p>
      <div class="mt-4 bg-gray-50 p-4 rounded-lg">
        <p class="mb-2"><span class="font-medium">订单编号：</span>{{ currentRecord?.orderNo }}</p>
        <p class="mb-2"><span class="font-medium">车牌号：</span>{{ currentRecord?.plateNumber }}</p>
        <p><span class="font-medium">异常类型：</span>{{ currentRecord?.exceptionType }}</p>
      </div>
    </a-modal>
    <!-- 批量忽略异常弹窗 -->
    <a-modal v-model:visible="batchIgnoreVisible" title="批量忽略异常" @ok="handleBatchIgnoreConfirm"
      @cancel="handleBatchIgnoreCancel" :okButtonProps="{ class: 'bg-blue-500 hover:bg-blue-600 !rounded-button' }">
      <p class="text-gray-600">您确认要批量忽略所选异常记录吗？</p>
      <div class="mt-4 bg-gray-50 p-4 rounded-lg">
        <p class="mb-2"><span class="font-medium">已选择条数：</span>{{ selectedRowKeys.length }}</p>
        <p class="text-red-500 text-sm">注意：批量忽略操作不可撤销，请谨慎操作！</p>
      </div>
    </a-modal>
    <!-- 批量追缴弹窗 -->
    <a-modal v-model:visible="batchDebtVisible" title="批量欠费追缴" @ok="handleBatchDebtConfirm"
      @cancel="handleBatchDebtCancel" :okButtonProps="{ class: 'bg-blue-500 hover:bg-blue-600 !rounded-button' }">
      <p class="text-gray-600">您确认要对所选记录进行批量追缴吗？</p>
      <div class="mt-4 bg-gray-50 p-4 rounded-lg">
        <p class="mb-2"><span class="font-medium">已选择条数：</span>{{ selectedRowKeys.length }}</p>
        <p class="text-yellow-500 text-sm">提示：系统将对选中的记录进行欠费追缴处理</p>
        <p class="text-red-500 text-sm">注意：批量追缴操作将同时向用户发送追缴通知！</p>
      </div>
    </a-modal>
    <!-- 修改备注弹窗 -->
    <a-modal v-model:visible="noteVisible" title="修改备注" @ok="handleNoteConfirm" @cancel="handleNoteCancel"
      :okButtonProps="{ class: 'bg-blue-500 hover:bg-blue-600 !rounded-button' }">
      <div class="space-y-4">
        <p class="text-gray-600 mb-2">请输入新的备注内容：</p>
        <a-textarea v-model:value="newNote" :rows="4" :maxlength="200" show-count placeholder="请输入备注内容（最多200字）"
          class="w-full rounded-lg" />
        <div class="bg-gray-50 p-4 rounded-lg">
          <p class="mb-2"><span class="font-medium">订单编号：</span>{{ currentRecord?.orderNo }}</p>
          <p class="mb-2"><span class="font-medium">车牌号：</span>{{ currentRecord?.plateNumber }}</p>
          <p class="mb-2"><span class="font-medium">原备注：</span>{{ currentRecord?.note }}</p>
        </div>
      </div>
    </a-modal>
    <!-- 单条追缴弹窗 -->
    <a-modal v-model:visible="debtVisible" title="欠费追缴确认" @ok="handleDebtConfirm" @cancel="handleDebtCancel"
      :okButtonProps="{ class: 'bg-blue-500 hover:bg-blue-600 !rounded-button' }">
      <p class="text-gray-600">您确认要对该记录进行欠费追缴吗？</p>
      <div class="mt-4 bg-gray-50 p-4 rounded-lg">
        <p class="mb-2"><span class="font-medium">订单编号：</span>{{ currentRecord?.orderNo }}</p>
        <p class="mb-2"><span class="font-medium">车牌号：</span>{{ currentRecord?.plateNumber }}</p>
        <p class="text-yellow-500 text-sm">提示：系统将对该记录进行欠费追缴处理</p>
        <p class="text-red-500 text-sm">注意：追缴操作将同时向用户发送追缴通知！</p>
      </div>
    </a-modal>
    <!-- 面包屑导航 -->
    <div class="mb-6">
      <a-breadcrumb>
        <a-breadcrumb-item><a href="#">运营管理</a></a-breadcrumb-item>
        <a-breadcrumb-item>异常数据</a-breadcrumb-item>
      </a-breadcrumb>
    </div>
    <!-- 搜索区域 -->
    <div class="bg-white rounded-xl p-6 mb-6 shadow-lg border border-gray-100 transition-all hover:shadow-xl relative">
      <div class="mb-6 grid grid-cols-4 gap-4">
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">手机号：</span>
          <a-input v-model:value="searchForm.phoneNumber" placeholder="请输入手机号" :maxLength="11" size="large"
            class="flex-1" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">车牌号：</span>
          <a-input v-model:value="searchForm.plateNumber" placeholder="请输入车牌号" :maxLength="8" size="large"
            class="flex-1" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">停车场：</span>
          <a-select v-model:value="searchForm.gate" placeholder="请选择停车场" size="large" class="flex-1">
            <a-select-option value="parking1">中心广场停车场</a-select-option>
            <a-select-option value="parking2">商业中心停车场</a-select-option>
            <a-select-option value="parking3">写字楼停车场</a-select-option>
            <a-select-option value="parking4">地下停车场</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">异常类型：</span>
          <a-select v-model:value="searchForm.exceptionType" placeholder="请选择异常类型" size="large" class="flex-1">
            <a-select-option value="type1">支付异常</a-select-option>
            <a-select-option value="type2">车牌识别异常</a-select-option>
            <a-select-option value="type3">设备故障</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">订单类型：</span>
          <a-select v-model:value="searchForm.orderType" placeholder="请选择订单类型" size="large" class="flex-1">
            <a-select-option value="normal">临时车辆</a-select-option>
            <a-select-option value="monthly">月卡车辆</a-select-option>
            <a-select-option value="vip">VIP车辆</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">创建时间：</span>
          <a-range-picker v-model:value="searchForm.entryTime" class="flex-1" size="large"
            :placeholder="['开始时间', '结束时间']" />
        </div>
      </div>
      <div class="absolute right-6 bottom-6 flex gap-4">
        <a-button type="primary" @click="handleSearch"
          class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600">搜索</a-button>
        <a-button @click="handleReset" class="!rounded-button px-6 h-10">重置</a-button>
      </div>
    </div>
    <!-- 表格工具栏和表格区域 -->
    <div class="bg-white rounded-xl p-6 shadow-lg border border-gray-100">
      <div class="mb-5 flex gap-4">
        <a-button type="primary"
          class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600 min-w-[72px]">导出</a-button>
        <a-button type="primary" :disabled="!selectedRowKeys.length" @click="handleBatchIgnore"
          class="!rounded-button px-6 h-10 bg-red-500 min-w-[72px]">忽略</a-button>
        <a-button type="primary" :disabled="!selectedRowKeys.length" @click="handleBatchDebt"
          class="!rounded-button px-6 h-10 bg-yellow-500 min-w-[72px]">追缴</a-button>
      </div>
      <!-- 表格区域 -->
      <div class="table-container custom-scrollbar">
        <a-table :columns="columns" :data-source="tableData" :pagination="pagination" @change="handleTableChange"
          :row-key="(record: TableItem) => record.id" :row-selection="{ selectedRowKeys, onChange: onSelectChange }"
          :row-class-name="getRowClassName" class="custom-table" :scroll="{ x: 1500 }">
          <!-- :row-class-name="getRowClassName" class="custom-table" :scroll="{ x: 1500, y: 600 }"> -->
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'action'">
              <a-space>
                <a @click="handleNote(record)" class="text-blue-500 hover:text-blue-600">修改备注</a>
                <a @click="handleIgnore(record)" class="text-green-500 hover:text-green-600">忽略异常</a>
                <a @click="handleDebtCollection(record)" class="text-red-500 hover:text-red-600">欠费追缴</a>
              </a-space>
            </template>
            <template v-else-if="column.key === 'inImage'">
              <img :src="record.inImage" alt="车辆图片" class="t-img w-20 h-16 object-cover rounded-lg" />
            </template>
            <template v-else-if="column.key === 'outImage'">
              <img :src="record.outImage" alt="车辆图片" class="t-img w-20 h-16 object-cover rounded-lg" />
            </template>
          </template>
        </a-table>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import { message } from 'ant-design-vue';
import type { TablePaginationConfig } from 'ant-design-vue';
interface SearchForm {
  phoneNumber: string;
  plateNumber: string;
  gate: string;
  exceptionType: string;
  orderType: string;
  entryTime: [string, string] | null;
}

interface HistoryRecord {
  id: string;
  orderNo: string;
  plateNumber: string;
  entryTime: string;
  exitTime: string;
  duration: string;
  amount: number;
  status: string;
}

const historyVisible = ref(false);
const selectedPlate = ref('');
const historyColumns = [
  {
    title: '订单编号',
    dataIndex: 'orderNo',
    key: 'orderNo',
    width: 160,
  },
  {
    title: '入场时间',
    dataIndex: 'entryTime',
    key: 'entryTime',
    width: 160,
  },
  {
    title: '出场时间',
    dataIndex: 'exitTime',
    key: 'exitTime',
    width: 160,
  },
  {
    title: '停车时长',
    dataIndex: 'duration',
    key: 'duration',
    width: 100,
  },
  {
    title: '金额',
    dataIndex: 'amount',
    key: 'amount',
    width: 100,
  },
  {
    title: '状态',
    dataIndex: 'status',
    key: 'status',
    width: 100,
  },
];

const historyData = ref<HistoryRecord[]>([]);

const openHistory = (plateNumber: string) => {
  selectedPlate.value = plateNumber;
  historyVisible.value = true;
  fetchHistoryData(plateNumber);
};

interface TableItem {
  id: string;
  index: number;
  orderNo: string;
  plateNumber: string;
  phoneNumber: string;
  exceptionType: string;
  inImage: string;
  outImage: string;
  orderType: string;
  entryTime: string;
  exitTime: string;
  createTime: string;
  inGate: string;
  outGate: string;
  note: string;
}
const searchForm = reactive<SearchForm>({
  phoneNumber: '',
  plateNumber: '',
  gate: '',
  exceptionType: '',
  orderType: '',
  entryTime: null
});
const ignoreVisible = ref(false);
const noteVisible = ref(false);
const batchIgnoreVisible = ref(false);
const batchDebtVisible = ref(false);
const debtVisible = ref(false);
const selectedRowKeys = ref<string[]>([]);
const currentRecord = ref<TableItem | null>(null);
const newNote = ref('');
const columns = [
  {
    title: '序号',
    dataIndex: 'index',
    key: 'index',
    width: 80,
    align: 'center',
    render: (_: any, __: any, index: number) => index + 1
  },
  {
    title: '订单编号',
    dataIndex: 'orderNo',
    key: 'orderNo',
    width: 160,
    align: 'center'
  },
  {
    title: '车牌号',
    dataIndex: 'plateNumber',
    key: 'plateNumber',
    width: 100,
    align: 'center',
    render: (text: string) => `<a class="text-blue-500 hover:text-blue-600">${text}</a>`
  },
  {
    title: '手机号',
    dataIndex: 'phoneNumber',
    key: 'phoneNumber',
    width: 120,
    align: 'center'
  },
  {
    title: '异常类型',
    dataIndex: 'exceptionType',
    key: 'exceptionType',
    width: 120,
    align: 'center'
  },
  {
    title: '入场图片',
    key: 'inImage',
    width: 150,
    align: 'center'
  },
  {
    title: '出场图片',
    key: 'outImage',
    width: 150,
    align: 'center'
  },
  {
    title: '订单类型',
    dataIndex: 'orderType',
    key: 'orderType',
    width: 100,
    align: 'center'
  },
  {
    title: '驶入时间',
    dataIndex: 'entryTime',
    key: 'entryTime',
    width: 160,
    align: 'center'
  },
  {
    title: '驶出时间',
    dataIndex: 'exitTime',
    key: 'exitTime',
    width: 160,
    align: 'center'
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
    key: 'createTime',
    width: 160,
    align: 'center'
  },
  {
    title: '入口',
    dataIndex: 'inGate',
    key: 'inGate',
    width: 120,
    align: 'center'
  },
  {
    title: '出口',
    dataIndex: 'outGate',
    key: 'outGate',
    width: 120,
    align: 'center'
  },
  {
    title: '备注',
    dataIndex: 'note',
    key: 'note',
    width: 200,
    ellipsis: true,
    align: 'center'
  },
  {
    title: '操作',
    key: 'action',
    fixed: 'right',
    width: 250,
    align: 'center'
  }
];
const tableData = ref<TableItem[]>([
  {
    id: '1',
    index: 1,
    orderNo: 'ORD20240115152000',
    plateNumber: '沪B54321',
    phoneNumber: '13912345678',
    exceptionType: '车牌识别异常',
    inImage: 'https://ai-public.mastergo.com/ai/img_res/ecc24b357bf5acbbf3489e5d0b53b62b.jpg',
    outImage: 'https://ai-public.mastergo.com/ai/img_res/ecc24b357bf5acbbf3489e5d0b53b62b.jpg',
    orderType: '临时车辆',
    entryTime: '2024-01-15 13:20:00',
    exitTime: '2024-01-15 15:20:00',
    createTime: '2024-01-15 15:20:00',
    inGate: '东门入口',
    outGate: '东门出口',
    note: '车牌识别系统未能正确识别'
  },
  {
    id: '2',
    index: 2,
    orderNo: 'ORD20240115143000',
    plateNumber: '沪A12345',
    phoneNumber: '13812345678',
    exceptionType: '支付异常',
    inImage: 'https://ai-public.mastergo.com/ai/img_res/0216872800e7a93f57084a599787545e.jpg',
    outImage: 'https://ai-public.mastergo.com/ai/img_res/0216872800e7a93f57084a599787545e.jpg',
    orderType: '月卡车辆',
    entryTime: '2024-01-15 12:30:00',
    exitTime: '2024-01-15 14:30:00',
    createTime: '2024-01-15 14:30:00',
    inGate: '南门入口',
    outGate: '南门出口',
    note: '支付失败需要重新处理'
  }
]);
const pagination = reactive<TablePaginationConfig>({
  total: 100,
  current: 1,
  pageSize: 10,
  showSizeChanger: true,
  showQuickJumper: true
});
const handleSearch = () => {
  console.log('Search form:', searchForm);
  message.success('搜索成功');
};
const handleReset = () => {
  Object.assign(searchForm, {
    phoneNumber: '',
    plateNumber: '',
    gate: '',
    exceptionType: '',
    orderType: '',
    entryTime: null
  });
  message.success('重置成功');
};
const handleTableChange = (pag: TablePaginationConfig) => {
  pagination.current = pag.current || 1;
  pagination.pageSize = pag.pageSize || 10;
  console.log("🚀 ~ handleTableChange ~ handleTableChange:", pagination.current)
};

// 模拟获取历史数据
const fetchHistoryData = (plateNumber: string) => {
  historyData.value = [
    { id: '1', orderNo: 'ORD20240115152001', plateNumber, entryTime: '2024-01-15 13:20:00', exitTime: '2024-01-15 15:20:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '2', orderNo: 'ORD20240114143002', plateNumber, entryTime: '2024-01-14 12:30:00', exitTime: '2024-01-14 14:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '3', orderNo: 'ORD20240113133003', plateNumber, entryTime: '2024-01-13 11:30:00', exitTime: '2024-01-13 13:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '4', orderNo: 'ORD20240112123004', plateNumber, entryTime: '2024-01-12 10:30:00', exitTime: '2024-01-12 12:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '5', orderNo: 'ORD20240111113005', plateNumber, entryTime: '2024-01-11 09:30:00', exitTime: '2024-01-11 11:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '6', orderNo: 'ORD20240110103006', plateNumber, entryTime: '2024-01-10 08:30:00', exitTime: '2024-01-10 10:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '7', orderNo: 'ORD20240109093007', plateNumber, entryTime: '2024-01-09 07:30:00', exitTime: '2024-01-09 09:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '8', orderNo: 'ORD20240108083008', plateNumber, entryTime: '2024-01-08 06:30:00', exitTime: '2024-01-08 08:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '9', orderNo: 'ORD20240107073009', plateNumber, entryTime: '2024-01-07 05:30:00', exitTime: '2024-01-07 07:30:00', duration: '2小时', amount: 15, status: '已完成' },
    { id: '10', orderNo: 'ORD20240106063010', plateNumber, entryTime: '2024-01-06 04:30:00', exitTime: '2024-01-06 06:30:00', duration: '2小时', amount: 15, status: '已完成' }
  ];
};

// 修改customRow配置
const customRow = (record: TableItem) => {
  return {
    onClick: (event: Event) => {
      if ((event.target as HTMLElement).tagName.toLowerCase() === 'a') {
        openHistory(record.plateNumber);
      }
    }
  };
};
const handleNote = (record: TableItem) => {
  currentRecord.value = record;
  newNote.value = record.note;
  noteVisible.value = true;
};
const handleNoteConfirm = () => {
  if (!newNote.value.trim()) {
    message.warning('备注内容不能为空');
    return;
  }
  if (currentRecord.value) {
    currentRecord.value.note = newNote.value.trim();
    message.success('备注修改成功');
    noteVisible.value = false;
    currentRecord.value = null;
    newNote.value = '';
  }
};
const handleNoteCancel = () => {
  noteVisible.value = false;
  currentRecord.value = null;
  newNote.value = '';
};
const handleIgnore = (record: TableItem) => {
  currentRecord.value = record;
  ignoreVisible.value = true;
};
const handleIgnoreConfirm = () => {
  message.success('已忽略异常');
  ignoreVisible.value = false;
  currentRecord.value = null;
};
const handleIgnoreCancel = () => {
  ignoreVisible.value = false;
  currentRecord.value = null;
};
const handleBatchIgnore = () => {
  batchIgnoreVisible.value = true;
};
const handleBatchIgnoreConfirm = () => {
  message.success(`已批量忽略${selectedRowKeys.value.length}条异常记录`);
  selectedRowKeys.value = [];
  batchIgnoreVisible.value = false;
};
const handleBatchIgnoreCancel = () => {
  batchIgnoreVisible.value = false;
};
const onSelectChange = (keys: string[]) => {
  selectedRowKeys.value = keys;
};
const getRowClassName = (record: TableItem) => {
  return selectedRowKeys.value.includes(record.id) ? 'bg-blue-50' : '';
};
const handleDebtCollection = (record: TableItem) => {
  currentRecord.value = record;
  debtVisible.value = true;
};
const handleDebtConfirm = () => {
  message.success('已发起欠费追缴');
  debtVisible.value = false;
  currentRecord.value = null;
};
const handleDebtCancel = () => {
  debtVisible.value = false;
  currentRecord.value = null;
};
const handleBatchDebt = () => {
  batchDebtVisible.value = true;
};
const handleBatchDebtConfirm = () => {
  message.success(`已对${selectedRowKeys.value.length}条记录发起追缴`);
  selectedRowKeys.value = [];
  batchDebtVisible.value = false;
};
const handleBatchDebtCancel = () => {
  batchDebtVisible.value = false;
};
</script>
<style scoped lang="less">
.abnormal {
  width: 100%;
}

.custom-table {
  @apply rounded-lg;
}

.ant-table-thead>tr>th {
  @apply bg-gray-50 text-gray-700 font-medium;
}

.ant-table-tbody>tr>td {
  @apply border-b border-gray-100;
}

.ant-table-tbody>tr.bg-blue-50>td {
  /* @apply bg-blue-50; */
}

.ant-table-tbody>tr:hover {
  @apply bg-blue-50/50;
}

.ant-pagination-item-active {
  @apply border-blue-500 bg-blue-500;
}

.ant-pagination-item-active a {
  @apply text-white;
}

.ant-select-selector {
  @apply rounded-lg;
}

.ant-input {
  @apply rounded-lg;
}

.ant-picker {
  @apply rounded-lg w-full;
}

.table-container {
  overflow: auto;
}

.t-img {
  display: inline-block;
}

.custom-scrollbar::-webkit-scrollbar {
  width: 6px;
  height: 6px;
}

.custom-scrollbar::-webkit-scrollbar-track {
  background: #f1f1f1;
  border-radius: 3px;
}

.custom-scrollbar::-webkit-scrollbar-thumb {
  background: #c1c1c1;
  border-radius: 3px;
}

.custom-scrollbar::-webkit-scrollbar-thumb:hover {
  background: #a8a8a8;
}
</style>
