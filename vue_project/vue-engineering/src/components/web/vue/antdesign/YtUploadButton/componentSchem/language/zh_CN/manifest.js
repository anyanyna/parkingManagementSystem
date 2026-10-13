import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
export default {
  template: `
  <a-form-item
    ref
    class="webVueAntUploadButton _$customFormItemClassName$_ _$customUploadButtonClassName$_ _$showLabel$_"
    name="_$fileList$_"
    :colon="false"
    :rules="_$rules$_">
    <template #label>
      <div class="label-content">
        <span class="ant-form-item-content" v-html="_$labelName$_"></span>
      </div>
    </template>
    <yt-upload-button-inner data-event v-model:fileList="_$fileList$_" :showUploadList="_$showUploadList$_" :listType="_$listType$_" :buttonContent="_$buttonContent$_"
      :preview="_$preview$_" :canDownload="_$canDownload$_" :accept="_$accept$_" :maxCount="_$maxCount$_" :multiple="_$multiple$_"
      :disabled="_$disabled$_" />
  </a-form-item>
  `,
  clazzType: 'YtUploadButton',
  getRuntimeConfig
}
