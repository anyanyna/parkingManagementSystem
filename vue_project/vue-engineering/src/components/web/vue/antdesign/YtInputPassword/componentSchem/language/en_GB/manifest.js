export default {
  template: `
    <yt-custom-input-password
      ref
      class="webVueAntinputPassword _$customClassName$_"
      :value="_$value$_"
      :placeholder="_$placeholder$_"
      :md5Value="_$md5Value$_"
      :isMd5Value="_$isMd5Value$_"
      :maxlength="_$maxlength$_"
      :allowClear="_$allowClear$_"
      :visibilityToggle="_$visibilityToggle$_"
      :disabled="_$disabled$_"
    />
`,
  clazzType: 'YtInputPassword'
}