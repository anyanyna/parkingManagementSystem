import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
export default {
  template: `<yt-custom-modal
    ref
    class="webVueAntYtModal _$customClassName$_"
    v-model:isShow="_$isShow$_"
    :showHeader="_$showHeader$_"
    :closable="_$closable$_"
    :title="_$title$_"
    :showFooter="_$showFooter$_"
    :showCancelButton="_$showCancelButton$_"
    :cancelText="_$cancelText$_"
    :cancelButtonBg="_$cancelButtonBg.color$_"
    :cancelButtonColor="_$cancelButtonColor.color$_"
    :showOkButton="_$showOkButton$_"
    :okText="_$okText$_"
    :okButtonBg="_$okButtonBg.color$_"
    :okButtonColor="_$okButtonColor.color$_"
    :maskClosable="_$maskClosable$_"
    :destroyOnClose="_$destroyOnClose$_"
    :mask="_$mask$_"
    :maskBg="_$maskStyleBg.background$_"
  >
    <template #content>
    <a-form
    class="webVueAntForm"
    :model="_$form$_"
    :validate-trigger="_$triggerMode$_">
      <yt-template
        backgroundType="color"
        background=""
        previewType=""
        contentHeight=""
        contentWidth=""
        customWidth=""
        customHeight=""
        minWidth=""
        maxWidth=""
        minHeight=""
        maxHeight=""
        width="100%"
        height="100%"
        #ytForm>
      </yt-template>
    </a-form>
    </template>
  </yt-custom-modal>`,
  clazzType: 'YtModal',
  getRuntimeConfig
}