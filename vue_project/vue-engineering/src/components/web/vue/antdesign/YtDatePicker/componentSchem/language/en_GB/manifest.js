export default {
  template: `
    <a-date-picker
      ref
      class="webVueAntYtDatePicker _$customClassName$_"
      v-model:value="_$value$_"
      :getPopupContainer="(triggerNode) => {
        return triggerNode.parentNode
      }"
      :placeholder="_$placeholder$_"
      :format="_$format$_"
      :mode="_$mode$_"
      :disabled="_$disabled$_"
    />
  `,
  clazzType: 'YtDatePicker'
}