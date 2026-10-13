export default {
  template: `<yt-custom-modal
    ref
    class="webVueAntYtModal _$customClassName$_"
    :visible="_$visible$_"
    :mask="_$mask$_"
    :maskBg="_$maskStyleBg.background$_"
  >
    <template #content>
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
        #ytModal
      ></yt-template>
    </template>
  </yt-custom-modal>`,
  clazzType: 'YtModal'
}