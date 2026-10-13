export default {
  template: `
    <a-range-picker
      ref
      class="webVueAntYtRangePicker _$customClassName$_"
      v-model:value="_$value$_"
      :getPopupContainer="(triggerNode) => {
        return triggerNode.parentNode
      }"
      :placeholder="[_$placeholderStart$_, _$placeholderEnd$_]"
      :format="_$format$_"
      :mode="_$mode$_"
      :disabled="_$disabled$_"/>
  `,
  clazzType: 'YtRangePicker'
}