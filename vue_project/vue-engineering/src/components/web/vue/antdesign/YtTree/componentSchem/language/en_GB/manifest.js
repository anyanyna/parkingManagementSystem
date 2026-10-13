export default {
  template: `<a-tree
      ref
      class="webVueAntYtTree _$customClassName$_"
      v-model:expandedKeys="_$expandedKeys$_"
      v-model:selectedKeys="_$selectedKeys$_"
      :showLine="_$showLine$_"
      :treeData="_$dataSource$_"
      :disabled="_$disabled$_"
      blockNode
    >
    </a-tree>`,
  clazzType: 'YtTree'
}