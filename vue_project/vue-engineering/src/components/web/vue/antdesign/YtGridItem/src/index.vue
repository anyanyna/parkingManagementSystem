<template>
    <div class="webVueAntGridItem" v-bind:data-componentId="id" v-if="isShow" :style="computedStyles">
        <slot></slot>
    </div>
</template>

<script>
import i18next from 'i18next';
import { createLocaleLang } from '../../../../../../shared/createLocaleLang';

export default {
    name: "yt-grid-item",
    props: {
        previewType:{
            type: String,
            default:''
        },
        top: {
            type: String,
            default:'0%'
        },
        left: {
            type: String,
            default:'0%'
        },
        bottom: {
            type: String,
            default:'0%'
        },
        right: {
            type: String,
            default:'0%'
        },
        gridColumnStart: [String, Number],
        gridColumnEnd: [String, Number],
        gridRowStart: [String, Number],
        gridRowEnd: [String, Number],
        pointerCss: String,
        comWidth: {
            type: String,
            default:''
        },
        comHeight: {
            type: String,
            default:''
        },
        zIndex: [String, Number],
        minHeight: {
            type: String,
            default:'unset'
        },
        margin: Object,
        isShow:  {
            type: Boolean,
            default:true
        },
        fixedSize: String,
        underFaceIds: {
            type: Array,
            default: []
        },
        id:String,
        isUseContentWH: {
            type: Boolean,
            default:false
        },
        marginTop: {
            type: String,
            default:'unset'
        },
        marginBottom: {
            type: String,
            default:'unset'
        },
        marginLeft: {
            type: String,
            default:'unset'
        },
        marginRight: {
            type: String,
            default:'unset'
        }
    },
    computed: {
        computedStyles() {
            let defaults = {
                top: this.top || '0',
                left: this.left || '0',
                bottom: this.bottom || '0',
                right: this.right || '0',
                gridColumnStart: this.gridColumnStart,
                gridColumnEnd: this.gridColumnEnd,
                gridRowStart: this.gridRowStart,
                gridRowEnd: this.gridRowEnd,
                pointerEvents: 'unset',
                zIndex: this.zIndex,
                minHeight: this.minHeight,
                width: this.comWidth ? this.comWidth : 'auto',
                height: this.comHeight ? this.comHeight : 'auto',
                marginTop:this.marginTop,
                marginBottom:this.marginBottom,
                marginLeft:this.marginLeft,
                marginRight:this.marginRight,
                position: this.previewType === 'FixedWH' ? 'relative' : 'absolute'
            };
            if(this.isUseContentWH){
                defaults = {
                    top: this.top || '0',
                    left: this.left || '0',
                    bottom: this.bottom || '0',
                    right: this.right || '0',
                    pointerEvents: 'unset',
                    zIndex: this.zIndex,
                    minHeight: this.minHeight,
                    width: this.comWidth ? this.comWidth : 'auto',
                    height: this.comHeight ? this.comHeight : 'auto',
                    marginTop:this.marginTop,
                    marginBottom:this.marginBottom,
                    marginLeft:this.marginLeft,
                    marginRight:this.marginRight,
                    gridColumnStart: this.gridColumnStart,
                    gridRowStart: this.gridRowStart,
                    position: 'absolute'
                };
            }
            return {
                ...defaults,
                pointerEvents: this.pointerCss, // 特殊处理pointerEvents
                zIndex: this.zIndex, // 确保zIndex是字符串形式
            };
        }
    },
    created() {
        // 初始化国际化，确保在需要的地方调用
        i18next.init({
            lng: window.__$yt_lang, // 默认语言
            resources: createLocaleLang(import.meta.globEager('./locales/**/data.json')),
        });
    },
    mounted() {
        // 自适应高度
        if (this.fixedSize && this.fixedSize === 'contentHeight') {
            this.$nextTick(() => {
                const doms = this.$el.childNodes[0]
                const computedStyle = getComputedStyle(this.$el);
                const oldHeight = Number(computedStyle.getPropertyValue('min-height').split('px')[0]);
                const rowEnd = Number(computedStyle.getPropertyValue('grid-row-end'));
                const rowStart = Number(computedStyle.getPropertyValue('grid-row-start'));
                const rate = (rowEnd - rowStart) / oldHeight
                const underFaceIds = this.underFaceIds || []
                const freeLayoutType = this.freeLayoutType || ''
                const that = this
                this.$el.style.gridRowEnd = 'auto;'
                let watchDom = null
                // 这里需要改根据class名称去拿dom
                if (this.ytComponent.renderManager.getComponentById(doms.id).getScrollHeight) {
                    watchDom = this.ytComponent.renderManager.getComponentById(doms.id)?.getScrollHeight().watchDom
                }
                if (!watchDom) {
                    return
                }
                const scrollHeight = watchDom.scrollHeight;
                this.$el.style.height = watchDom.scrollHeight + "px";
                let value = ''
                // if(freeLayoutType && (freeLayoutType === 'FixedWH' || freeLayoutType === 'FixedHAdaptiveW')){
                //   value = Number(watchDom.scrollHeight) - Number(oldHeight)
                // }else{
                //   value = ((Number(watchDom.scrollHeight) - Number(oldHeight))*rate).toFixed(0)
                // }
                value = Number(watchDom.scrollHeight) - Number(oldHeight)
                if (scrollHeight > Number(oldHeight)) {
                    //修改收到影响的dom的start_y和end_y
                    if (underFaceIds && underFaceIds.length > 0) {
                        saverowX(this.id, underFaceIds, value)
                        updateDom(value, underFaceIds, that.ytComponent.renderManager, rate)
                    }
                    if (Number(scrollHeight) !== Number(oldHeight)) {
                        if ((freeLayoutType === 'FixedWH' || freeLayoutType === 'FixedHAdaptiveW')) {
                            //修改外面的高度
                            const pageDom = document.getElementById('page')
                            pageDom.style.height = (Number(scrollHeight) - Number(oldHeight)) + Number(this.layoutInfoHeight) + 'px'
                            pageDom.childNodes[0].style.height = (Number(scrollHeight) - Number(oldHeight)) + Number(this.layoutInfoHeight) + 'px'
                        }
                    }
                }
                watchDom.addEventListener('scroll', () => {
                    that.$el.style.height = watchDom.scrollHeight + "px";
                    let value = ''
                    // if(freeLayoutType && (freeLayoutType === 'FixedWH' || freeLayoutType === 'FixedHAdaptiveW')){
                    //   value = Number(watchDom.scrollHeight) - Number(oldHeight)
                    // }else{
                    //   value = ((Number(watchDom.scrollHeight) - Number(oldHeight))*rate).toFixed(0)
                    // }
                    value = Number(watchDom.scrollHeight) - Number(oldHeight)
                    if (watchDom.scrollHeight > Number(oldHeight)) {
                        //修改收到影响的dom的start_y和end_y
                        if (underFaceIds && underFaceIds.length > 0) {
                            saverowX(that.id, underFaceIds, value)
                            updateDom(value, underFaceIds, that.ytComponent.renderManager, rate)
                        }
                        if ((Number(watchDom.scrollHeight) !== Number(oldHeight))) {
                            if ((freeLayoutType === 'FixedWH' || freeLayoutType === 'FixedHAdaptiveW')) {
                                //修改外面的高度
                                const pageDom = document.getElementById('page')
                                pageDom.style.height = (Number(watchDom.scrollHeight) - Number(oldHeight)) + Number(that.layoutInfoHeight) + 'px'
                                pageDom.childNodes[0].style.height = (Number(watchDom.scrollHeight) - Number(oldHeight)) + Number(that.layoutInfoHeight) + 'px'
                            }
                        }
                    }
                });
                const observer = new MutationObserver(this.checkScrollbar.bind(this, watchDom, oldHeight, rate)); // 创建 MutationObserver 实例
                observer.observe(watchDom, { attributes: true, subtree: true, childList: true }); // 监视 textarea 内容变化
                this.checkScrollbar(watchDom, oldHeight, rate); // 初始化时检测一次
            })
        }
    },
    methods: {
        checkScrollbar(watchDom, oldHeight, rate, mutationsList, observer) {
            this.$el.style.height = watchDom.scrollHeight + "px";
            let value = ''
            // if(freeLayoutType && (freeLayoutType === 'FixedWH' || freeLayoutType === 'FixedHAdaptiveW')){
            //   value = Number(watchDom.scrollHeight) - Number(oldHeight)
            // }else{
            //   value = ((Number(watchDom.scrollHeight) - Number(oldHeight))*rate).toFixed(0)
            // }
            value = Number(watchDom.scrollHeight) - Number(oldHeight)
            if (watchDom.scrollHeight > Number(oldHeight)) {
                //修改收到影响的dom的start_y和end_y
                const underFaceIds = getUnderFaceIds(this.ytComponent.renderManager, this.underFaceIds)
                if (underFaceIds && underFaceIds.length > 0) {
                    saverowX(this.id, underFaceIds, value)
                    updateDom(value, underFaceIds, this.ytComponent.renderManager, rate)
                }
                if ((Number(watchDom.scrollHeight) !== Number(oldHeight))) {
                    if ((this.freeLayoutType === 'FixedWH' || this.freeLayoutType === 'FixedHAdaptiveW')) {
                        //修改外面的高度
                        const pageDom = document.getElementById('page')
                        pageDom.style.height = (Number(watchDom.scrollHeight) - Number(oldHeight)) + Number(this.layoutInfoHeight) + 'px'
                        pageDom.childNodes[0].style.height = (Number(watchDom.scrollHeight) - Number(oldHeight)) + Number(this.layoutInfoHeight) + 'px'
                    }
                }
            }
        }
    }
};
</script>

<style>
.webVueAntGridItem {
    display: flex;
}
</style>