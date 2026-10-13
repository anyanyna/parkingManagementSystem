<template>
  <div class="bg-gradient-to-br from-gray-50 to-gray-100 px-8 py-6 relative">
    <!-- 面包屑导航 -->
    <div class="mb-6">
      <a-breadcrumb>
        <a-breadcrumb-item>运营管理</a-breadcrumb-item>
        <a-breadcrumb-item>黑白名单</a-breadcrumb-item>
      </a-breadcrumb>
    </div>
    <!-- 搜索区域 -->
    <div class="bg-white rounded-xl p-6 mb-6 shadow-lg border border-gray-100 transition-all hover:shadow-xl relative">
      <div class="mb-6 grid grid-cols-4 gap-4">
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">车牌号：</span>
          <a-input v-model:value="searchForm.plateNumber" placeholder="请输入车牌号" class="flex-1" :maxLength="8" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">名单类型：</span>
          <a-select v-model:value="searchForm.listType" placeholder="请选择名单类型" class="flex-1">
            <a-select-option value="white">白名单</a-select-option>
            <a-select-option value="black">黑名单</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">适用车场：</span>
          <!-- <a-input v-model:value="searchForm.parkingLot" placeholder="请输入适用车场" class="flex-1" /> -->
          <a-select v-model:value="searchForm.parkingLot" placeholder="请选择适用车场" mode="multiple" :maxTagCount="2" class="flex-1">
            <a-select-option value="长宁商务中心地下停车场">长宁商务中心地下停车场</a-select-option>
            <a-select-option value="徐家汇广场停车场">徐家汇广场停车场</a-select-option>
            <a-select-option value="陆家嘴中心停车场">陆家嘴中心停车场</a-select-option>
          </a-select>
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">操作人员：</span>
          <a-input v-model:value="searchForm.operator" placeholder="请输入操作人员姓名" class="flex-1" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">生效时间：</span>
          <a-range-picker v-model:value="searchForm.effectiveTime" class="flex-1" :placeholder="['开始时间', '结束时间']" />
        </div>
        <div class="flex items-center">
          <span class="w-24 text-gray-700 font-medium">到期时间：</span>
          <a-range-picker v-model:value="searchForm.expiryTime" class="flex-1" :placeholder="['开始时间', '结束时间']" />
        </div>
        <div class="absolute right-6 bottom-6 flex gap-4">
          <a-button type="primary" @click="handleSearch"
            class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600">搜索</a-button>
          <a-button @click="handleReset" class="!rounded-button px-6 h-10">重置</a-button>
        </div>
      </div>
    </div>
    <!-- 表格工具栏 -->
    <div class="bg-white rounded-xl p-6 shadow-lg border border-gray-100 transition-all hover:shadow-xl overflow-hidden">
      <div class="mb-5">
        <div class="flex gap-4">
          <a-button type="primary" @click="showAddModal = true" class="!rounded-button px-6 h-10 bg-blue-500 hover:bg-blue-600 min-w-[72px]">新增
          </a-button>
          <a-button @click="showImportModal = true" class="!rounded-button px-6 h-10 min-w-[72px]">导入
          </a-button>
          <a-button @click="handleExport" class="!rounded-button px-6 h-10 min-w-[72px]">导出
          </a-button>
          <a-button @click="handleApproveSelected" :disabled="!selectedRows.length"
            class="!rounded-button px-6 h-10 bg-green-500 hover:bg-green-600 text-white min-w-[72px]">
            审批
          </a-button>
          <a-button danger @click="handleBatchDelete" :disabled="!selectedRows.length" class="!rounded-button px-6 h-10 min-w-[72px]">
            移除
          </a-button>
          <a-button @click="showDrawer = true" class="!rounded-button px-6 h-10 min-w-[72px]">
            名单管理
          </a-button>
        </div>
      </div>
      <!-- 表格区域 -->
      <div>
        <a-table :columns="columns" :data-source="tableData"
          :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }" :pagination="pagination"
          @change="handleTableChange" class="custom-table" :locale="{
            emptyText: '暂无数据',
            filterConfirm: '确定',
            filterReset: '重置',
            triggerDesc: '点击降序',
            triggerAsc: '点击升序',
            cancelSort: '取消排序'
          }">
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'action'">
              <a-space>
                <a @click="handleEdit(record)" class="!rounded-button text-blue-600 hover:text-blue-700 px-0 mx-[10px]">编辑</a>
                <template v-if="record.status === '待审核'">
                  <a @click="handleApprove(record)" class="!rounded-button text-green-600 hover:text-green-700 px-0 mx-[10px]">审批</a>
                </template>
                <a-popconfirm title="确定要移除这条记录吗？" ok-text="确定" cancel-text="取消" @confirm="handleDelete(record)">
                  <a class="!rounded-button text-red-600 hover:text-red-700 px-0">移除</a>
                </a-popconfirm>
              </a-space>
            </template>
            <template v-if="column.dataIndex === 'status'">
              <a-tag :color="record.status === '生效中' ? 'success' : 'default'">
                {{ record.status }}
              </a-tag>
            </template>
            <template v-if="column.dataIndex === 'listType'">
              {{ record.listType }}
            </template>
          </template>
        </a-table>
      </div>
    </div>
    <!-- 新增表单模态框 -->
    <a-modal v-model:visible="showAddModal" title="新增车辆名单" ok-text="确定" cancel-text="取消" @ok="handleAddSubmit">
      <a-form :model="addForm" :rules="rules" ref="addFormRef" :label-col="{ span: 6 }" :wrapper-col="{ span: 16 }">
        <a-form-item label="车牌号" name="plateNumber">
          <a-input v-model:value="addForm.plateNumber" placeholder="请输入车牌号" />
        </a-form-item>
        <a-form-item label="车辆类型" name="vehicleType">
          <a-select v-model:value="addForm.vehicleType" placeholder="请选择车辆类型">
            <a-select-option value="蓝牌">蓝牌</a-select-option>
            <a-select-option value="白牌">白牌</a-select-option>
            <a-select-option value="黄牌">黄牌</a-select-option>
            <a-select-option value="绿牌">绿牌</a-select-option>
            <a-select-option value="黑牌">黑牌</a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item label="名单类型" name="listType">
          <a-select v-model:value="addForm.listType" placeholder="请选择名单类型">
            <a-select-option value="white">白名单</a-select-option>
            <a-select-option value="black">黑名单</a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item label="适用车场" name="parkingLot">
          <a-select v-model:value="addForm.parkingLot" placeholder="请选择适用车场" mode="multiple" :maxTagCount="2">
            <a-select-option value="长宁商务中心地下停车场">长宁商务中心地下停车场</a-select-option>
            <a-select-option value="徐家汇广场停车场">徐家汇广场停车场</a-select-option>
            <a-select-option value="陆家嘴中心停车场">陆家嘴中心停车场</a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item label="生效时间" name="startTime">
          <a-date-picker v-model:value="addForm.startTime" style="width: 100%" />
        </a-form-item>
        <a-form-item label="到期时间" name="endTime">
          <a-date-picker v-model:value="addForm.endTime" style="width: 100%" />
        </a-form-item>
        <a-form-item label="备注" name="remark">
          <a-textarea v-model:value="addForm.remark" placeholder="请输入备注信息" :rows="4" />
        </a-form-item>
      </a-form>
    </a-modal>
    <!-- 导入模态框 -->
    <a-modal v-model:visible="showImportModal" title="批量导入车辆名单" ok-text="确定导入" cancel-text="取消"
      @ok="handleImportSubmit">
      <div class="space-y-4">
        <div class="text-gray-600">
          请先下载导入模板，按照模板格式填写数据后上传：
        </div>
        <a-button type="link" @click="downloadTemplate" class="!rounded-button">
          下载导入模板
        </a-button>
        <a-upload-dragger v-model:fileList="fileList" :before-upload="beforeUpload" @drop="handleDrop"
          accept=".xlsx,.xls">
          <p class="ant-upload-drag-icon">
            <InboxOutlined />
          </p>
          <p class="ant-upload-text">点击或拖拽文件到此区域上传</p>
          <p class="ant-upload-hint">
            支持扩展名：.xls, .xlsx
          </p>
        </a-upload-dragger>
        <div v-if="previewData.length" class="mt-4">
          <div class="font-medium mb-2">数据预览：</div>
          <a-table :columns="previewColumns" :data-source="previewData" :pagination="false" size="small" scroll={{ y:
            200 }} />
        </div>
      </div>
    </a-modal>
    <!-- 名单管理抽屉 -->
    <a-drawer v-model:visible="showDrawer" title="名单管理" placement="right" width="400" @close="onDrawerClose">
      <div class="space-y-6">
        <div class="space-y-4">
          <div class="flex items-center mb-4">
            <span class="w-24 text-gray-700 font-medium">名单类型：</span>
            <a-input v-model:value="drawerForm.listTypeName" placeholder="请输入名单类型" class="flex-1" />
          </div>
          <div class="flex items-center mb-4">
            <span class="w-24 text-gray-700 font-medium">计费规则：</span>
            <a-select v-model:value="drawerForm.feeRule" placeholder="请选择计费规则" class="flex-1">
              <a-select-option value="1">免费</a-select-option>
              <a-select-option value="2">标准收费</a-select-option>
              <a-select-option value="3">VIP收费</a-select-option>
            </a-select>
          </div>
          <div class="flex justify-end">
            <a-button type="primary" @click="handleAddListType" class="!rounded-button bg-blue-500 hover:bg-blue-600">
              添加
            </a-button>
          </div>
        </div>
        <a-divider />
        <div class="space-y-4">
          <div class="font-medium text-lg mb-4">名单列表</div>
          <a-table :columns="listTypeColumns" :data-source="listTypeData" :pagination="false" size="middle"
            class="custom-table">
            <template #bodyCell="{ column, record }">
              <template v-if="column.key === 'action'">
                <a-button v-if="!['黑名单', '白名单'].includes(record.listTypeName)" type="link" danger
                  @click="handleDeleteListType(record)" class="!rounded-button">
                  删除
                </a-button>
              </template>
            </template>
          </a-table>
        </div>
      </div>
    </a-drawer>
  </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import type { FormInstance } from 'ant-design-vue';
import {
  UploadOutlined,
  DownloadOutlined,
  DeleteOutlined,
  EditOutlined,
  CheckCircleOutlined,
  SearchOutlined,
  ReloadOutlined,
  InboxOutlined
} from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import type { UploadProps } from 'ant-design-vue';
interface SearchForm {
  plateNumber: string;
  listType: string;
  parkingLot: [];
  operator: string;
  effectiveTime: [string, string] | null;
  expiryTime: [string, string] | null;
}
const showImportModal = ref(false);
const fileList = ref<any[]>([]);
const previewData = ref<any[]>([]);
// 抽屉相关数据
const showDrawer = ref(false);
const drawerForm = reactive({
  listTypeName: '',
  feeRule: undefined
});
const listTypeColumns = [
  { title: '名单类型', dataIndex: 'listTypeName', width: 120 },
  { title: '计费规则', dataIndex: 'feeRuleName', width: 120 },
  { title: '操作', key: 'action', width: 80 }
];
const listTypeData = ref([
  { key: '1', listTypeName: '黑名单', feeRuleName: '禁止通行' },
  { key: '2', listTypeName: '白名单', feeRuleName: '免费' },
  { key: '3', listTypeName: 'VIP名单', feeRuleName: 'VIP收费' },
  { key: '4', listTypeName: '临时名单', feeRuleName: '标准收费' }
]);
const handleAddListType = () => {
  if (!drawerForm.listTypeName || !drawerForm.feeRule) {
    message.error('请填写完整信息');
    return;
  }
  message.success('添加成功');
};
const handleDeleteListType = (record: any) => {
  message.success(`删除成功：${record.listTypeName}`);
};
const previewColumns = [
  { title: '车牌号', dataIndex: 'plateNumber', width: 100 },
  { title: '车辆类型', dataIndex: 'vehicleType', width: 100 },
  { title: '名单类型', dataIndex: 'listType', width: 100 },
  { title: '适用车场', dataIndex: 'parkingLot', width: 150 },
  { title: '生效时间', dataIndex: 'startTime', width: 120 },
  { title: '到期时间', dataIndex: 'endTime', width: 120 }
];
const searchForm = reactive<SearchForm>({
  plateNumber: '',
  listType: '',
  parkingLot: [],
  operator: '',
  effectiveTime: null,
  expiryTime: null
});
const showAddModal = ref(false);
const addFormRef = ref<FormInstance>();
const addForm = reactive({
  plateNumber: '',
  vehicleType: '',
  listType: '',
  parkingLot: [],
  startTime: null,
  endTime: null,
  remark: ''
});
const rules = {
  plateNumber: [{ required: true, message: '请输入车牌号', trigger: 'blur' }],
  vehicleType: [{ required: true, message: '请选择车辆类型', trigger: 'change' }],
  listType: [{ required: true, message: '请选择名单类型', trigger: 'change' }],
  parkingLot: [{ required: true, message: '请输入适用车场', trigger: 'blur' }],
  startTime: [{ required: true, message: '请选择生效时间', trigger: 'change' }],
  endTime: [{ required: true, message: '请选择到期时间', trigger: 'change' }]
};
const selectedRowKeys = ref<string[]>([]);
const selectedRows = ref<any[]>([]);
const columns = [
  { title: '序号', dataIndex: 'index', width: 60, align: 'center' },
  { title: '车牌号', dataIndex: 'plateNumber', width: 100, align: 'center' },
  { title: '车辆类型', dataIndex: 'vehicleType', width: 100, align: 'center' },
  { title: '名单类型', dataIndex: 'listType', width: 100, align: 'center' },
  { title: '适用车场', dataIndex: 'parkingLot', width: 160, align: 'center' },
  { title: '生效时间', dataIndex: 'startTime', width: 100, align: 'center' },
  { title: '到期时间', dataIndex: 'endTime', width: 100, align: 'center' },
  { title: '操作人员', dataIndex: 'operator', width: 90, align: 'center' },
  { title: '备注信息', dataIndex: 'remark', width: 160, align: 'center' },
  { title: '状态', dataIndex: 'status', width: 80, align: 'center' },
  { title: '创建时间', dataIndex: 'createTime', width: 140, align: 'center' },
  { title: '操作', key: 'action', fixed: 'right', width: 180, align: 'center' }
];
const tableData = ref([
  {
    key: '1',
    index: 1,
    plateNumber: '沪A12345',
    vehicleType: '蓝牌',
    listType: '白名单',
    parkingLot: '长宁商务中心地下停车场',
    startTime: '2024-01-01',
    endTime: '2024-12-31',
    operator: '李经理',
    remark: '固定车位用户',
    status: '生效中',
    createTime: '2024-01-01 09:00:00'
  },
  {
    key: '2',
    index: 2,
    plateNumber: '沪B98765',
    vehicleType: '绿牌',
    listType: '白名单',
    parkingLot: '徐家汇广场停车场',
    startTime: '2024-01-15',
    endTime: '2024-06-30',
    operator: '王主管',
    remark: '月卡用户',
    status: '生效中',
    createTime: '2024-01-15 14:30:00'
  },
  {
    key: '3',
    index: 3,
    plateNumber: '沪C24680',
    vehicleType: '黄牌',
    listType: '黑名单',
    parkingLot: '所有车场',
    startTime: '2024-02-01',
    endTime: '2024-12-31',
    operator: '陈安保',
    remark: '多次违规停放',
    status: '待审核',
    createTime: '2024-02-01 16:45:00'
  }
]);
const pagination = reactive({
  total: 100,
  current: 1,
  pageSize: 10,
  showSizeChanger: true,
  showQuickJumper: true,
  showTotal: (total: number) => `共 ${total} 条记录`,
  align: 'right',
  locale: {
    items_per_page: '条/页',
    jump_to: '跳至',
    page: '页',
    prev_page: '上一页',
    next_page: '下一页',
    prev_5: '向前 5 页',
    next_5: '向后 5 页'
  }
});
const handleSearch = () => {
  message.success('搜索执行成功');
};
const handleReset = () => {
  Object.assign(searchForm, {
    plateNumber: '',
    listType: '',
    parkingLot: [],
    operator: '',
    effectiveTime: null,
    expiryTime: null
  });
  message.success('重置成功');
};
const handleAddSubmit = () => {
  addFormRef.value?.validate().then(() => {
    message.success('添加成功');
    showAddModal.value = false;
  }).catch(() => {
    message.error('请完善表单信息');
  });
};
const downloadTemplate = () => {
  message.success('模板下载中...');
};
const beforeUpload: UploadProps['beforeUpload'] = (file) => {
  const isExcel = file.type === 'application/vnd.ms-excel' || file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
  if (!isExcel) {
    message.error('请上传 Excel 文件！');
    return false;
  }
  return false;
};
const handleDrop = (e: DragEvent) => {
  e.preventDefault();
};
const handleImportSubmit = () => {
  if (fileList.value.length === 0) {
    message.error('请先上传文件');
    return;
  }
  message.success('导入成功');
  showImportModal.value = false;
};
const handleExport = () => {
  message.success('数据导出中，请稍候...');
};
const handleBatchDelete = () => {
  message.error(`已移除 ${selectedRows.value.length} 条记录`);
};
const handleEdit = (record: any) => {
  message.info(`正在编辑：${record.plateNumber}`);
};
const handleApprove = (record: any) => {
  message.success(`审批通过：${record.plateNumber}`);
};
const handleApproveSelected = () => {
  message.success(`批量审批通过 ${selectedRows.value.length} 条记录`);
};
const onDrawerClose = () => {
  showDrawer.value = false
  message.success(`关闭成功`);
};
const handleDelete = (record: any) => {
  message.error(`已移除：${record.plateNumber}`);
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
.ant-table-wrapper {
  width: 100%;
}

.ant-input,
.ant-select,
.ant-picker {
  border-radius: 6px !important;
  height: 40px;
}

.ant-select-selector {
  background-color: white !important;
  border: 1px solid #d9d9d9 !important;
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

:deep(.ant-select-selector) {
  height: 40px !important;
  // line-height: 38px !important;
  overflow: auto;
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

.ant-upload-drag {
  border-radius: 8px;
}

.ant-modal-content {
  border-radius: 12px;
  overflow: hidden;
}

.ant-upload-list {
  margin-top: 16px;
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
