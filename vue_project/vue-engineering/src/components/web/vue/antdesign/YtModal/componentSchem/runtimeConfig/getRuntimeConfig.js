import Framebus from 'framebus';
let timer = null
let needUpData = false
let preSelectIds = undefined
export default function getRuntimeConfig(config) {
    const {setPannelValue, getPropOfKey, parseValue, getDataValue, toUpdataData } = config
    const bus  = new Framebus()
    return ({
        mounted() {
            this.initData()
            bus.on('executeSelectComponent',this.executeSelectComponent)
            bus.on('executeToTop',this.setZIndex)
            bus.on('undoToTop',this.setZIndex)
            bus.on('executeToBottom',this.setZIndex)
            bus.on('undoToBottom',this.setZIndex)
            bus.on('executeToTopOneLevel',this.setZIndex)
            bus.on('undoToTopOneLevel',this.setZIndex)
            bus.on('executeToBottomOneLevel',this.setZIndex)
            bus.on('undoToBottomOneLevel',this.setZIndex)
            bus.on('renderPannelFinished',this.renderPannelFinished)
        },
        beforeDestroy() {
            bus.off('executeSelectComponent',this.executeSelectComponent)
            bus.off('executeToTop',this.setZIndex)
            bus.off('undoToTop',this.setZIndex)
            bus.off('executeToBottom',this.setZIndex)
            bus.off('undoToBottom',this.setZIndex)
            bus.off('executeToTopOneLevel',this.setZIndex)
            bus.off('undoToTopOneLevel',this.setZIndex)
            bus.off('executeToBottomOneLevel',this.setZIndex)
            bus.off('undoToBottomOneLevel',this.setZIndex)
            bus.off('renderPannelFinished',this.renderPannelFinished)
        },
        methods: {
            initData() {
                const id = this._$$$_componentId
                const footerBg = JSON.parse(parseValue(id, 'footerBg', '_$footerBg$_'))
                if (footerBg && footerBg.allow === undefined) {
                    const tempBg = { "allow": true, "background": "#ffffff", "fillStyle": { "type": "pure", "color": "#ffffff", "image": "none", "repeat": "no-repeat", "align": "auto", "fillMode": "auto" } }
                    Object.assign(tempBg.fillStyle, footerBg)
                    tempBg.background = footerBg.color
                    toUpdataData(id, 'footerBg', tempBg, true,false)
                }
                const headerBg = JSON.parse(parseValue(id, 'headerBg', '_$headerBg$_'))
                if (headerBg && headerBg.allow === undefined) {
                    const tempBg = { "allow": true, "background": "#ffffff", "fillStyle": { "type": "pure", "color": "#ffffff", "image": "none", "repeat": "no-repeat", "align": "auto", "fillMode": "auto" } }
                    Object.assign(tempBg.fillStyle, headerBg)
                    tempBg.background = headerBg.color
                    toUpdataData(id, 'headerBg', tempBg, true,false)
                }
            },
            async setZIndex() {
                const pDom = await this.$el.parentNode
                if(!pDom) {
                    return
                }
                const zIndex = pDom.style.zIndex
                const oldMoskDom = pDom.parentNode.querySelector(`.modal_${pDom.id}_mask`)
                oldMoskDom && (oldMoskDom.style.zIndex = Number(zIndex) - 1)
            },
            changeState(state) {
                if(state === 'edit') {
                    window.$$Freelayout.utils.getFreeLayout()._movaAble.hideDirections()
                    window.$$Freelayout.utils.getFreeLayout()._movaAble.hideDefaultLine()
                }else {
                    window.$$Freelayout.utils.getFreeLayout()._movaAble.showDirections()
                    window.$$Freelayout.utils.getFreeLayout()._movaAble.showDefaultLine()
                }
            },
            // 取消的时候清空选中
            changeVisible(val, e) {
                if (val) {
                    return
                }
                if (e) {
                    e.preventDefault()
                    e.preventDefault()
                    e.stopImmediatePropagation()
                }
                if (!this.$el) {
                    return
                }
                this.$nextTick(() => {
                    this.$el.parentNode.style['pointer-events'] = 'unset'
                })
                this.clearStyle()
                this.changeState('edit')
                // 300是画布选中有一个300ms的用来判断单击双击
                timer && clearTimeout(timer)
                timer = setTimeout(() => {
                    this.clearStyle()
                    if(this.$el && this.$el.parentNode) {
                        this.$el.parentNode.style['pointer-events'] = 'none'
                        this.$el.parentNode.style.display='none'
                        this.$el.parentNode.classList.add('temporarily-hide')
                        this.$el.style.display='none'
                    }
                    // 避免渲染面板先出现
                    setTimeout(() => {
                        if(this.$el && this.$el.parentNode) {
                            this.$el.parentNode.style.display='block'
                        }
                        bus.emit('showPageComponent')
                        timer = null
                    },0)
                }, 301)
                this.updatePanel('editShow', false)
            },
            clearStyle() {
                const iframeDocument = document.querySelector('#iframe').contentDocument
                let doms = iframeDocument.querySelectorAll(`.outline[id="${this._$$$_componentId}"]`)
                if(doms && doms.length) {
                    doms.forEach(dom => {
                        dom.className = dom.className.replace('outline','').trim();
                    })
                }
            },
            // 监听选中
            executeSelectComponent({ids}) {
                const eitShow = parseValue(this._$$$_componentId, ':editShow', '_$editShow$_')
                const isShow = getDataValue(parseValue(this._$$$_componentId, ':isShow', '_$isShow$_'))
                if (isShow && timer === null && eitShow ==='false' && ids.length === 1 && ids[0] === this._$$$_componentId) {
                    this.handleVisible()
                }
                if (preSelectIds && ids.length === 1 && preSelectIds.length === 1 && ids[0] !== preSelectIds[0] ) {
                    this.changeState()
                }
                preSelectIds = ids
            },
            handleVisible() {
                if(!this.$refs) {
                    return
                }
                needUpData = true
                this.changeState()
                if(this.$el && this.$el.parentNode && this.$el.parentNode.style ) {
                    this.$el.parentNode.style.display='block'
                    this.$el.parentNode.classList.remove('temporarily-hide')
                }
                if(this.$el) {
                    this.$el.style.display='block'
                }
                Object.keys(this.$refs).forEach(ref => {
                    this.$refs[ref].changeVisible(true)
                })
            },
            renderPannelFinished ({comId, comInfo}) {
                if( comId === this._$$$_componentId && needUpData){
                    this.updatePanel('editShow', true, true)
                    needUpData = false
                }
            },
            updatePanel(comkey, value, isRefresh = false) {
                setPannelValue(this._$$$_componentId,comkey, value, isRefresh)
            },
        },
        __getEditorAttrs__(tagName,attribute) {
            if(tagName === 'yt-custom-modal') {
                return {
                    "@changeVisible": 'changeVisible'
                }
            }
        },
        _$isShowToDynamicData:true,
        _$isModal:true,
        _$formTag:'a-form'
    })
}
