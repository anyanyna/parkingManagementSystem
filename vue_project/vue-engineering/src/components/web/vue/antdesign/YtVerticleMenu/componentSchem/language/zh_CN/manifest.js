import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
export default {
  template: `
  <yt-vertical-menu-menu
    ref
    class="webVueAntYtVerticleMenu _$customClassName$_"
    v-model:openKeys="_$openKeys$_"
    v-model:selectedKeys="_$selectedKeys$_"
    :mode="_$mode$_"
    :items="_$options.dataSource$_"
    :singleExpand="_$singleExpand$_"
    :parentSelectAble="_$parentSelectAble$_"
    :inlineIndent="_$inlineIndent$_"
    />`,
  clazzType: 'YtVerticleMenu',
  getRuntimeConfig
}