import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
export default {
  template: `<yt-tree
    ref
    class="webVueAntYtTree _$customClassName$_"
    v-model:expandedKeys="_$expandedKeys$_"
    v-model:selectedKeys="_$selectedKeys$_"
    :showIcon="_$showIcon$_"
    :checkable="_$checkable$_"
    :switcherIcon="_$switcherIcon.src$_"
    :showLine="_$showLine$_"
    :ellipsis="_$ellipsis$_"
    :lineHeight="_$lineHeight$_"
    :blockNode="_$blockNode$_"
    :options="_$options.dataSource$_"
    :selectedBackgroundColor="_$selectedBackgroundColor$_"
    :selectedTextColor="_$selectedTextColor$_"
    :hoverBackgroundColor="_$hoverBackgroundColor$_"
    :hoverTextColor="_$hoverTextColor$_"
    :disabled="_$disabled$_"
    :draggable="_$draggable$_"
    :accordion="_$accordion$_"
    :checkStrictly="_$checkStrictly$_"
     />`,
  clazzType: 'YtTree',
  getRuntimeConfig
}