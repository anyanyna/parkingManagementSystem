<template>
    <div ref="container" class="yt-custom-modal" v-drag-modal="dragModalContent">
        <a-modal
            v-model:visible="isVisible"
            :wrap-style="{ overflow: 'hidden' }"
            :wrapClassName="`wrapClassName ${!showHeader && 'is-hide-header'||''}  ${!showFooter && 'is-hide-footer'||''}`"
            :mask="false"
            :maskClosable="maskClosable"
            :closable="showHeader && closable"
            :destroyOnClose="isEditing ? false : destroyOnClose"
            :forceRender="true"
            :getContainer="() => { 
                return  this.$refs.container
            }"
            @ok="ok"
            @cancel="cancel"
        >
            <slot name="content"></slot>
            <template #title v-if="showHeader">
                <div  class="yt-custom-modal-header">{{title || '标题'}}</div>
            </template>
            <template #footer v-if="showFooter">
                <div class="yt-custom-modal-footer">
                    <a-button v-if="showCancelButton" class="footer-button cancel" :style="{'background': cancelButtonBg, 'color':cancelButtonColor}" @click="cancel">{{cancelText || ''}}</a-button>
                    <a-button v-if="showOkButton" class="footer-button ok" :style="{'background': okButtonBg, 'color':okButtonColor}" @click="ok">{{okText || ''}}</a-button>
                </div>
            </template>
        </a-modal>
    </div>
</template>
<script>
import { ref, computed, watch, onMounted, onBeforeUnmount } from 'vue'
const dragModal = {
    mounted(el, bindings, vnode) {
       setTimeout(() => {
            if(document.defaultView.parent !== document.defaultView) {
                return
            }
            let { isShow, destroyOnClose, centered } = bindings.value
            // 防止未定义 destroyOnClose 关闭弹窗时dom未被销毁，指令被重复调用
            if (!isShow) return
            let modal = el.getElementsByClassName('ant-modal')[0]
            let modalBody = el.getElementsByClassName('ant-modal-body')[0]
            let content = modalBody && modalBody.childNodes[0] || undefined
            let closeDom = modal && modal.getElementsByClassName('ant-modal-close')[0] || undefined
            let header = el.getElementsByClassName('ant-modal-header')[0]
            let footer = el.getElementsByClassName('ant-modal-footer')[0]
            footer = footer && footer.childNodes[0] || undefined
            let left = 0
            let top = 0
            // 未定义 destroyOnClose 时，dom未被销毁，关闭弹窗再次打开，弹窗会停留在上一次拖动的位置
            if (!destroyOnClose) {
                left = modal.left || 0
                top = modal.top || 0
            }
            // top 初始值为 offsetTop
            top = top || modal.offsetTop
            if (centered) {
                top = 0
            }
            if (header) {
                header.onmousedown = e => {
                    if (bindings.value.draggable && bindings.value.dragArea !== 'all') {
                        let startX = e.clientX
                        let startY = e.clientY
                        header.left = header.offsetLeft
                        header.top = header.offsetTop
                        el.onmousemove = event => {
                            let endX = event.clientX
                            let endY = event.clientY
                            modal.left = header.left + (endX - startX) + left
                            modal.top = header.top + (endY - startY) + top
                            modal.style.left = modal.left + 'px'
                            modal.style.top = modal.top + 'px'
                            el.onmouseup = event => {
                                left = modal.left
                                top = modal.top
                                el.onmousemove = null
                                el.onmouseup = null
                                header.releaseCapture && header.releaseCapture()
                            }
                        }
                        header.setCapture && header.setCapture()
                    } else {
                        return false
                    }
                }
            }
            if (modal) {
                modal.onmousedown = e => {
                    if (bindings.value.draggable && bindings.value.dragArea === 'all') {
                    // 不是底部自定义内容子组件、关闭按钮、自定义内容的组件
                        if (!(footer && footer !== e.target && footer.contains(e.target))
                            && !(closeDom && closeDom.contains(e.target))
                            && !(content && content !== e.target && content.contains(e.target))) {
                            let startX = e.clientX
                            let startY = e.clientY
                            modal.left = modal.offsetLeft
                            modal.top = modal.offsetTop
                            el.onmousemove = event => {
                            let endX = event.clientX
                            let endY = event.clientY
                            modal.left = left + (endX - startX)
                            modal.style.left = left + (endX - startX) + 'px'
                            modal.style.top = top + (endY - startY) + 'px'
                            el.onmouseup = event => {
                                left = modal.left
                                top = modal.offsetTop || modal.top
                                el.onmousemove = null
                                el.onmouseup = null
                                modal.releaseCapture && modal.releaseCapture()
                            }
                            }
                            modal.setCapture && modal.setCapture()
                        }
                    } else {
                    // return false
                    }
                }
            }

        }, 0)
    }
}
export default {
    props: {
        maskBg: {
            type: String,
            default: 'rgba(114,114,114,0.4)'
        },
        isShow: {
            type: Boolean
        },
        showHeader: {
            type: Boolean,
            default: true
        },
        closable: {
            type: Boolean,
            default: true
        },
        title: {
            type: String,
            default: '标题'
        },
        showFooter: {
            type: Boolean,
            default: true
        },
        showCancelButton: {
            type: Boolean,
            default: true
        },
        cancelText: {
            type: String,
            default: '取消'
        },
        cancelButtonBg: {
            type: String,
            default: '#ffffff'
        },
        cancelButtonColor: {
            type: String,
            default: '#333333'
        },
        showOkButton: {
            type: Boolean,
            default: true
        },
        okText: {
            type: String,
            default: '确定'
        },
        okButtonBg: {
            type: String,
            default: '#3C8EFF'
        },
        okButtonColor: {
            type: String,
            default: '#fff'
        },
        draggable: {
            type: Boolean,
            default: false
        },
        maskClosable: {
            type: Boolean,
            default: false
        },
        destroyOnClose: {
            type: Boolean,
            default: true
        },
        mask: {
            type: Boolean,
            default: true
        }
    },
    emits: ['update:isShow', 'ok', 'cancel', 'show', 'close', 'changeVisible'],
    directives: {
        'drag-modal': dragModal
    },
    setup(props, { emit }) {
        const container = ref(null)
        const isVisible = ref(props.isShow)
        const dragModalContent = ref({...props, isVisible})
        const isEditing = ref(document.defaultView.parent !== document.defaultView && !!window.parent.$$Freelayout)
        const ok = function (e) {
            // changeVisible(false, e)
            emit('ok')
        }
        const cancel = function (e) {
            const closeDom = container.value && container.value.querySelector('.ant-modal-close')
            if(container.value && (closeDom === e.target  || closeDom.contains(e.target))) {
                changeVisible(false, e)
            }
            emit('cancel')
            return
        }
        const changeVisible = function (isShow, e) {
            isVisible.value = isShow
            emit('update:isShow', isShow)
            emit('changeVisible', isShow, e)
        }
        const maskStyle = computed(() =>{
                return {
                'background': props.maskBg
                }
            }
        )
        watch(isVisible, async (isShow, oldVisible) => {
            if(isShow === oldVisible) {
                return
            }else if(isShow){
                emit('show')
            }else {
                emit('close')
            }
            const pDom = container.value.parentNode
            if(!pDom) {
                return
            }
            if(!pDom.parentNode) {
                return
            }
            const oldMoskDom = pDom.parentNode.querySelector(`.modal_${pDom.id || pDom.dataset.componentid}_mask`)
            if(!oldMoskDom) {
                pDom.style['pointer-events'] = isShow ? 'unset' : 'none'
                return
            }
            if(!isShow) {
                pDom.style['pointer-events'] = 'none'
                oldMoskDom.style.display = 'none'
            }else {
                const zIndex = pDom.style.zIndex
                oldMoskDom.style.zIndex = Number(zIndex) - 1
                oldMoskDom.style.display = 'block'
                pDom.style['pointer-events'] = 'unset'
            }
        })
        onMounted(() => {
            // 加遮罩maskStyle.value
            setTimeout(() => {
                if(!container.value) {
                    return
                }
                const pDom = container.value.parentNode
                if(!pDom) {
                    return
                }
                const iframe = pDom.parentNode
                if(!iframe) {
                    return
                }
                const oldMoskDom = iframe.querySelector(`.modal_${pDom.id || pDom.dataset.componentid}_mask`)
                if ( oldMoskDom && (!props.mask || pDom.style.display === 'none'|| !isVisible.value)) {
                    oldMoskDom.remove()
                    return
                }else if( oldMoskDom || !props.mask || pDom.style.display === 'none') {
                    return
                }else if(props.mask && oldMoskDom) {
                    const zIndex = pDom.style.zIndex
                    oldMoskDom.style.zIndex = Number(zIndex) - 1
                    return
                }else if(props.mask) {
                    const moskDom = document.createElement('div')
                    moskDom.setAttribute("class",  `modal_${pDom.id || pDom.dataset.componentid}_mask`);
                    let zIndex = pDom.style.zIndex
                    moskDom.style.zIndex = Number(zIndex) - 1
                    moskDom.style.position = 'absolute'
                    moskDom.style.width = '100%'
                    moskDom.style.height = '100%'
                    moskDom.style.background = maskStyle.value.background
                    moskDom.style.display = isVisible.value ? 'block' : 'none'
                    moskDom.addEventListener('click', function(e) {
                        if (props.maskClosable) {
                            changeVisible(false, e)
                        }
                    });
                    pDom.parentNode.appendChild(moskDom)                    
                }                
            }, 0)
        })
        onBeforeUnmount(() => {
            if(!container.value) {
                return
            }
            let oldMoskDom = container.value.parentNode.parentNode.querySelector(`.modal_${container.value.parentNode.id || container.value.parentNode.dataset.componentid }_mask`)
            oldMoskDom && oldMoskDom.remove()
        })
        return {
            dragModalContent,
            isVisible,
            changeVisible,
            ok,
            cancel,
            maskStyle,
            container,
            isEditing
        }
    },
    name: "yt-custom-modal",
}
</script>
<style type='text/css' lang="less">
.yt-custom-modal {
    width: 100%;
    height: 100%;
}
.yt-custom-modal .ant-modal-wrap{
    position: absolute;
}
.yt-custom-modal .ant-modal {
    max-width: 100%;
    width: 100% !important;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
    padding:0;
    margin: 0;
    transform-origin: center !important;
}
.yt-custom-modal .is-hide-footer .ant-modal-footer {
    display:none
}
.yt-custom-modal .ant-modal-content {
    height: 100%;
    display: flex;
    flex-direction: column;
}
.yt-custom-modal .ant-modal-body{
    flex:1;
    padding: 0;
    overflow: auto;
}
.yt-custom-modal .yt-custom-modal-header::after{
    content:'';
    width: 100%;
    height: 1px;
}
.yt-custom-modal .ant-modal-header {
    padding: 0;
    display: flex;
    align-items: center;
    height: 45px;
}
.yt-custom-modal .yt-custom-modal-header{
    width: 100%;
    cursor: move;
    background: transparent;
}
.yt-custom-modal .ant-modal-header .ant-modal-title{
    width: 100%;
}
.yt-custom-modal .ant-modal-footer {
    padding: 0;
    height: 57px;
    display: flex;
    align-items: center;
    justify-content: end;
}
.yt-custom-modal .yt-custom-modal-footer {
    padding: 0 16px 0 0;
}
</style>
<style>
.yt-custom-modal .ant-modal div[aria-hidden="true"] {
    display: none !important;
}
</style>