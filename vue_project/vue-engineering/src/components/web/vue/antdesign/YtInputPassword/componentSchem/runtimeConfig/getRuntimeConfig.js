import getLabelEdit from '../../../../../../../edit/vue/labelEdit.js'
import ruleEdit from '../../../../../../../edit/vue/rule.js'
export default function getRuntimeConfig(config) {
    const LabelMixin = getLabelEdit(config)
    const ruleMixin = ruleEdit(config)
    return ({
        mixins: [LabelMixin,ruleMixin],
    })
}
