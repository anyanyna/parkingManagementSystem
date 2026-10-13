export default {
  template: `
  <yt-vertical-menu-menu
    ref
    class="webVueAntYtVerticleMenu _$customClassName$_"
    v-model:openKeys="_$openKeys$_"
    v-model:selectedKeys="_$selectedKeys$_"
    :items="_$dataSource$_"
  />`,
  clazzType: 'YtVerticleMenu'
}