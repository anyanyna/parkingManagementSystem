import getLabelEdit from '../../../../../../../edit/vue/labelEdit.js'
import ruleEdit from '../../../../../../../edit/vue/rule.js'
import genGetLangConfig from '../../../../../../../edit/vue/getLanguage.js'
export default function getRuntimeConfig(config) {
    const LabelMixin = getLabelEdit(config)
    const ruleMixin = ruleEdit(config)
    const getLangConfig = genGetLangConfig(config)
    const {setPannelValue,parseValue,getDataValue,getPropOfKey, getClassName} = config;
    const getZoom = () => {
        return window.$$Freelayout.utils.getFreeLayout()._infiniteViewer._zoom
    }
    return ({
        mixins: [LabelMixin,ruleMixin,getLangConfig],
        mounted(){
        },
        methods: {
            openChange(open) {
                if(!open) {
                    return
                }
                this.scaleDom('.ant-picker-dropdown')
            },
            async scaleDom() {
                const iframeDocument = await document.querySelector('#iframe').contentDocument
                const popupKeyId = getClassName('popupKeyId')
                let dom = iframeDocument.querySelector(`.${popupKeyId}`)
                if(!dom) {
                    return
                }
                dom.style['transform-origin'] = '0 0'  
                dom.style['scale'] = getZoom() 
            }
        },
        __getEditorAttrs__(tagName,attribute) {
            if(['yt-custom-dsate-piker', 'yt-custom-range-picker', 'yt-custom-time-picker'].includes(tagName)) {
                return {
                    "@openChange": 'openChange'
                }
            }
        }
    })
}
