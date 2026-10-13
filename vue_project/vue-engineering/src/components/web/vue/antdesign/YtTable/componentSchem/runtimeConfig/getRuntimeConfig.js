import ContextMenu from './tableMenuContext/index'
import { registerFramebus } from './framebus/index'
import { registerContextMenu } from './tableMenuContext/event/registerContextMenu'
import Framebus from 'framebus';

const excludes = ['colType', 'colStyleArr', 'data']
const defalutColStyle = { "colType": "default", "colText": { "fontStyle": { "type": "pure", "color": "#000000A6", "image": "none", "repeat": "no-repeat", "align": "center" }, "fontFamily": "Microsoft YaHei", "fontSize": "14px", "fontWeight": "Normal", "lineHeight": "50px", "letterSpacing": "0px", "textAlign": "center", "paddingTop": "0px", "paddingRight": "0px", "paddingBottom": "0px", "paddingLeft": "0px", "textDecoration": "none", "textStyle": "normal" }, "colWidth": "281", "autoSize": {"autoWidth": true}, "aiColStyle":[],"aiRequirementStyle":[] }

let state = null, tableVar = {}, currentId = -1
let contextMenu = null;
contextMenu = new ContextMenu();
contextMenu.render();
registerFramebus(tableVar, currentId, (val) => {
    currentId = val
});
const bus = new Framebus()

export default function getRuntimeConfig (config) {
    return ({
        mounted () {
            this.initData()
            this.initPagination()
            this.addTableVarItem()
            this.handlePageSizeOptions()
            this.handleRowBgDom()
            this.hanleAiCustome()
            this.initCss()
            this.initScroll()
            this.$nextTick(() => {
                if (this.$el.parentNode) {
                    this.$el.parentNode.onmousedown = (e) => {
                        this.initSelect()
                        contextMenu.hide(e)
                    }
                }
            })
        },
        beforeDestory () {
            this.removeTableVarItem()
        },
        methods: {
            initData () {
                this.data = config.getDataValue(config.parseValue(this._$$$_componentId, ':data', '_$data$_'))
                this.rowBackgroundType = config.parseValue(this._$$$_componentId, ':rowBackgroundType', '_$rowBackgroundType$_').replace("'", '').replace("'", '')
                this.colType = config.parseValue(this._$$$_componentId, ':colType', '_$colType$_').replace("'", '').replace("'", '')
                this.pageSizeOptions = JSON.parse(config.parseValue(this._$$$_componentId, ':pageSizeOptions', '_$pageSizeOptions$_'))
                this.colStyleArr = JSON.parse(config.parseValue(this._$$$_componentId, ':colStyleArr', '_$colStyleArr$_'))
                this.canSelect = config.parseValue(this._$$$_componentId, ':canSelect', '_$canSelect$_') === 'true'
                this.setStaticPannelValue = config.setStaticPannelValue
                this.setPannelValue = config.setPannelValue
                this.hideComponentTool = config.hideComponentTool
                this.toUpdataData = config.toUpdataData
                this.updateDynamicStaticProps = config.updateDynamicStaticProps
                config.updateAttributesKey(this._$$$_componentId,'selectRows','selectedRows')
            },
            parseValue (comkey) {
                return config.parseValue(this._$$$_componentId, `:${comkey}`, `_$${comkey}$_`)
            },
            getDataValue (data) {
                return config.getDataValue(data)
            },
            initScroll () {
                this.$nextTick(() => {
                    let height = parseInt(config.getPropOfKey(this._$$$_componentId, 'height'))
                    let headerHeight = config.parseValue(this._$$$_componentId, ':headerHeight', '_$headerHeight$_')
                    const pageDom = this.$el.querySelector('.ant-pagination')
                    height -= parseInt(headerHeight.replace(/'/g, ''))
                    if (pageDom) {
                        const rect = pageDom.getBoundingClientRect()
                        const style = window.getComputedStyle(pageDom)
                        if (style) {
                            height -= parseInt(style.marginTop) * 2
                        }
                        if (rect) {
                            height -= rect.height / window.$$Freelayout.utils.getFreeLayout().getZoom()
                        }
                    }
                    if (!isNaN(height)) {
                        this.toUpdataData(this._$$$_componentId, 'scrollY', height, false, false)
                    }
                })
            },
            initPagination () {
                const dom = this.$el.querySelector('.ant-pagination')
                if (dom) {
                    dom.onmousedown = () => {
                        tableVar[this._$$$_componentId].clickPagination = true
                        if (currentId === this._$$$_componentId) {
                            const input = dom.querySelector('.ant-pagination-options-quick-jumper input')
                            if (input) {
                                dom.querySelector('.ant-pagination-options-quick-jumper input').onclick = (e) => {
                                    e.stopPropagation()
                                    input.focus()
                                }
                            }
                        }
                    }
                    dom.onmouseup = (e) => {
                        tableVar[this._$$$_componentId].clickPagination = false
                        if (currentId === this._$$$_componentId) {
                            this.initSelect(false)
                            if (dom.style.display !== 'block') {
                                this.closeAllPannel('tablePagination')
                            }
                        }
                    }
                }
            },
            initHeight () {
                this.$nextTick(() => {
                    const h = parseInt((this.$el.getBoundingClientRect().height.toFixed(0) / window.$$Freelayout.utils.getFreeLayout().getZoom()).toFixed(0))
                    const height = parseInt(config.getPropOfKey(this._$$$_componentId, 'height'))
                    if (height < h) {
                        const x = parseInt(config.getPropOfKey(this._$$$_componentId, 'left')).toFixed(0)
                        const y = parseInt(config.getPropOfKey(this._$$$_componentId, 'top')).toFixed(0)
                        const w = config.getPropOfKey(this._$$$_componentId, 'width')
                        this.setPannelValue(this._$$$_componentId, 'positionSize', { x, y, w, h }, true)
                    }
                })
            },
            addTableVarItem () {
                const id = this._$$$_componentId
                if (!(id in tableVar)) {
                    tableVar[id] = {
                        isCreated: true,
                        selectHandlerDom: undefined,
                        oldPageSizeOptions: [],
                        clickPagination: false,
                        instance: this,
                        resolve: null,
                        promise: null
                    }
                } else {
                    tableVar[id].instance = this
                }
            },
            removeTableVarItem () {
                delete tableVar[this._$$$_componentId]
            },
            initCss () {
                return new Promise((resolve) => {
                    this.$nextTick(async () => {
                        const id = this._$$$_componentId
                        const tableItem = tableVar[id]
                        if (tableItem && tableItem.isCreated) {
                            const cssInfos = []
                            const autoWidthArr = this.colStyleArr.map((item, index) => {
                                cssInfos.push(...this.getColPannel(Object.keys(item).filter((key) => !excludes.includes(key)), index))
                                if (item && item.autoSize && item.autoSize.autoWidth) {
                                    return item.autoSize.autoWidth
                                }
                            }).filter((item) => item)
                            if (!autoWidthArr.length) {
                                cssInfos.push(
                                    {
                                        key: `.__customClassName__`,
                                        properties: {
                                            width: 'auto'
                                        }
                                    }
                                )
                            } else {
                                cssInfos.push(
                                    {
                                        key: `.__customClassName__`,
                                        properties: {
                                            width: '100%'
                                        }
                                    }
                                )
                            }
                            tableItem.isCreated = false
                            await config.addCodeCss(id, cssInfos)
                        }
                        resolve()
                    })
                })
            },
            handlePageSizeOptions () {
                const id = this._$$$_componentId
                const tableItem = tableVar[id]
                if (JSON.stringify(tableItem.oldPageSizeOptions) !== JSON.stringify(this.pageSizeOptions)) {
                    let hasSelect = false
                    this.pageSizeOptions.value.splice(0, this.pageSizeOptions.value.length - 1)
                    this.pageSizeOptions.dataSource = this.pageSizeOptions.dataSource.map((item) => {
                        if (this.pageSizeOptions.value.length && this.pageSizeOptions.value[0] === item.value) {
                            item.select = true
                            hasSelect = true
                        } else {
                            item.select = false
                        }
                        item.value = parseInt(item.label)
                        return item
                    })
                    if (!hasSelect) {
                        this.pageSizeOptions.value = this.pageSizeOptions.dataSource.length ? [this.pageSizeOptions.dataSource[0].value] : []
                    }
                    tableItem.oldPageSizeOptions = this.pageSizeOptions
                    this.setPannelValue(id, 'pageSize', this.pageSizeOptions.value.length ? this.pageSizeOptions.value[0] : 10)
                    this.setPannelValue(id, 'pageSizeOptions', this.pageSizeOptions, true)
                }
            },
            handleCol (comkey, value) {
                const id = this._$$$_componentId
                const tableItem = tableVar[id]
                const clickIndex = this.getIndex(tableItem.selectHandlerDom)
                if (comkey !== 'colStyleArr') {
                    if (comkey === 'colType') {
                        if (this.data.columns[clickIndex]?.cellType !== value) {
                            this.data.columns[clickIndex].cellType = value
                            config.setTablePannelValue(id, 'data', clickIndex, 'columns', 'cellType', value)
                        }
                    }
                    if (comkey === 'colWidth') {
                        if (this.data.columns[clickIndex]?.width !== value) {
                            delete this.data.columns[clickIndex]
                            config.setTablePannelValue(id, 'data', clickIndex, 'columns', 'width', undefined)
                        }
                        if (this.colStyleArr[clickIndex - 1]?.autoSize?.autoWidth) {
                            this.colStyleArr[clickIndex - 1].autoSize = {autoWidth: false}
                        }
                    }
                    if (Object.keys(this.colStyleArr[clickIndex - 1]).includes(comkey) && this.colStyleArr[clickIndex - 1][comkey] !== value) {
                        this.colStyleArr[clickIndex - 1][comkey] = value
                        this.setPannelValue(id, 'colStyleArr', this.colStyleArr, true)
                    }
                }
            },
            closeAllPannel (exclude) {
                const id = this._$$$_componentId
                const tableItem = tableVar[id]
                if (tableItem && !tableItem.clickPagination) {
                    document.querySelectorAll('.hidePannel').forEach((item) => {
                        if (item.classList.contains(exclude)) {
                            item.style.display = 'block'
                        } else {
                            item.style.display = 'none'
                        }
                    })
                    if (tableItem.resolve) {
                        tableItem.resolve()
                    }
                }
            },
            addVerticalLine () {
                const div = document.createElement('div')
                div.classList.add('hoverVerticalBorder')
                div.style.position = 'absolute'
                div.style.top = '0'
                div.style.bottom = '0'
                div.style.width = '2px'
                div.style.background = '#3F82F9'
                div.style.display = 'none'
                this.$el.querySelector('.ant-table').appendChild(div)
            },
            addhorizontallLine () {
                const div = document.createElement('div')
                div.classList.add('hoverHorizontalBorder')
                div.style.position = 'absolute'
                div.style.left = '0'
                div.style.right = '0'
                div.style.height = '2px'
                div.style.background = '#3F82F9'
                div.style.display = 'none'
                this.$el.querySelector('.ant-table').appendChild(div)
            },
            addArea () {
                const div = document.createElement('div')
                div.classList.add('tableArea')
                div.style.position = 'absolute'
                div.style.top = '0'
                div.style.right = '0'
                div.style.bottom = '0'
                div.style.left = '0'
                div.style.border = '2px solid #3F82F9'
                div.style.background = 'rgba(63,130,249,0.1)'
                div.style.display = 'none'
                div.style.pointerEvents = 'none'
                this.$el.querySelector('.ant-table').appendChild(div)
            },
            initSelect (reset = true) {
                const id = this._$$$_componentId
                if (this.$el.querySelector('.tableArea')) {
                    this.$el.querySelector('.tableArea').style.display = 'none'
                }
                this.$el.querySelectorAll('.add-handler').forEach((item) => {
                    item.style.background = '#DCDCDC'
                })
                if (reset) {
                    this.closeAllPannel('baseConfig')
                }
                tableVar[id].selectHandlerDom = null
            },
            cellKeyDown (e) {
                if (e.ctrlKey && e.key === 's') {
                    return
                }
                e.stopPropagation()
            },
            createDom () {
                const doms = this.$el.querySelectorAll('.add-handler, .add-pointer, .tableArea, .hoverHorizontalBorder, .hoverVerticalBorder') || []
                if (!doms.length) {
                    this.addVerticalLine()
                    this.addhorizontallLine()
                    this.addArea()
                    this.$el.querySelectorAll('.ant-table th').forEach((item, index) => {
                        if (!this.canSelect || (this.canSelect && index > 0)) {
                            if (!this.canSelect) {
                                index += 1
                            }
                            this.createPoint(item, index, 'add-col-pointer')
                            this.createHandler(item, index, 'add-col-handler')
                            item.style.position = "relative"
                            const dom = item.querySelector('.th-text')
                            item.ondblclick = (e) => {
                                e.stopPropagation()
                                item.addEventListener('keydown', this.cellKeyDown)
                                item.onmousedown = (evt) => {
                                    evt.stopPropagation()
                                }
                                if (dom) {
                                    window.$$Freelayout.utils.getFreeLayout()._selectAble.clearSelectedId()
                                    dom.setAttribute('contenteditable', true)
                                    dom.focus()
                                }
                            }
                            if (dom) {
                                dom.addEventListener('keydown', function (e) {
                                    // 判断按下了回车键
                                    if (e.key === 'Enter') {
                                        e.preventDefault()
                                        dom.blur()
                                    }
                                })
                                dom.onblur = () => {
                                    item.removeEventListener('keydown', this.cellKeyDown)
                                    const innerText = item.querySelector('span.th-text').innerText.replace(/\n/g, '')
                                    window.translatePromise = new Promise((resolve) => {
                                        bus.emit('getTransLate', innerText, (englishStr) => {
                                            const newEnglishName = /^-?\d*\.?\d+$/.test(innerText) ? innerText : getNewName(makeFirstLetterLowercase(englishStr), this.data.columns.map(item => item.dataIndex))
                                            this.data.dataSource = this.data.dataSource.map((child) => {
                                                if (newEnglishName) {
                                                    child[newEnglishName] = child[this.data.columns[index].dataIndex]
                                                    delete child[this.data.columns[index].dataIndex]
                                                }
                                                return child
                                            })
                                            const oldTag = this.data.columns[index].dataIndex
                                            this.data.columns[index].title = innerText
                                            if (newEnglishName) {
                                                this.data.columns[index].dataIndex = newEnglishName
                                                this.data.columns[index].key = newEnglishName
                                            }
                                            const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                                            // 要去修改子组件tag
                                            if(newEnglishName){
                                                const childs = window.$$Freelayout.utils.getFreeLayout().getRuntime().getChildrenOfTag(this._$$$_componentId, oldTag) || []
                                                childs.forEach(child => {
                                                    child.setPTag(newEnglishName)
                                                    window.$$Freelayout.utils.getFreeLayout().updateGroupPtag(child.getId(),newEnglishName)
                                                })
                                            }
                                            window.$$Freelayout.utils.getFreeLayout().getRuntime().updateYtTemplate(this._$$$_componentId,oldTag,newEnglishName)
                                            this.setPannelValue(params.id, params.comkey, params.value,params.refresh)
                                            setTimeout(() => {
                                                resolve(true)
                                            }, 5)
                                        })
                                    }).finally(() => {
                                        window.translatePromise = null
                                    })
                                    item.onmousedown = null
                                    dom.setAttribute('contenteditable', false)
                                }
                            }
                        }
                    })
                    this.$el.querySelectorAll('.ant-table tr').forEach((item, index) => {
                        if (index > 0) {
                            this.createPoint(item, index, 'add-row-pointer')
                        }
                        this.createHandler(item, index, 'add-row-handler')
                        item.style.position = "relative"
                        item.querySelectorAll('td').forEach((child, childIndex) => {
                            if (!this.canSelect || (this.canSelect && childIndex > 0)) {
                                const dom = child.querySelector('.td-text')
                                child.ondblclick = (e) => {
                                    e.stopPropagation()
                                    item.addEventListener('keydown', this.cellKeyDown)
                                    child.onmousedown = (evt) => {
                                        evt.stopPropagation()
                                        // evt.preventDefault()
                                        const row = child.parentElement.getAttribute("data-row-key")
                                        const col = getChildIndex(child)
                                        state = [[row, col, child]]
                                    }
                                    if (dom) {
                                        window.$$Freelayout.utils.getFreeLayout()._selectAble.clearSelectedId()
                                        dom.setAttribute('contenteditable', true)
                                        dom.focus()
                                    }
                                }
                                child.onmouseenter = (evt) => {
                                    const row = child.parentElement.getAttribute("data-row-key")
                                    const col = getChildIndex(evt.target)
                                    if (state) {
                                        state[1] = [row, col, evt.target]
                                        this.setSelectRowCol()
                                    }
                                }
                                if (dom) {
                                    dom.onblur = () => {
                                        item.removeEventListener('keydown', this.cellKeyDown)
                                        let columnIndex = childIndex
                                        if (!this.canSelect) {
                                            columnIndex += 1
                                        }
                                        const dataIndex = this.data.columns[columnIndex].dataIndex
                                        this.data.dataSource[index - 1][dataIndex] = child.innerText
                                        child.onmousedown = null
                                        dom.setAttribute('contenteditable', false)
                                        const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                                        this.setPannelValue(params.id, params.comkey, params.value)
                                    }
                                }

                                this.$el.onmouseup = () => {
                                    state = null
                                }
                            }
                        })
                    })
                }
            },
            removeDom () {
                const id = this._$$$_componentId
                tableVar[id].selectHandlerDom = null
                this.$el.querySelectorAll('.add-handler, .add-pointer, .tableArea, .hoverHorizontalBorder, .hoverVerticalBorder').forEach((item) => {
                    item.remove()
                })
            },
            createPoint (parent, index, className) {
                let firstPointer = document.createElement('div')
                let otherPointer = document.createElement('div')
                if (index === 1) {
                    const span = document.createElement('span')
                    span.innerText = '+'
                    span.style.fontSize = '6px'
                    span.style.color = '#DCDCDC'
                    span.style.transform = `rotate(45deg)`
                    this.setPointerAttr(firstPointer, 0, className)
                    firstPointer.appendChild(span)
                    parent.appendChild(firstPointer)
                }
                const span = document.createElement('span')
                span.innerText = '+'
                span.style.fontSize = '6px'
                span.style.color = '#DCDCDC'
                span.style.transform = `rotate(45deg)`;
                this.setPointerAttr(otherPointer, index, className)
                otherPointer.appendChild(span)
                parent.appendChild(otherPointer)
            },
            setPointerAttr (dom, index, className) {
                dom.setAttribute('index', index)
                dom.classList.add('add-pointer', className, `${className}-${index}`)
                dom.style.position = 'absolute'
                dom.style.width = '5px'
                dom.style.height = '5px'
                dom.style.borderRadius = '50%'
                dom.style.background = '#DCDCDC'
                dom.style.cursor = 'pointer'
                dom.style.transform = className === 'add-row-pointer' ? 'rotate(-45deg)' : 'rotate(45deg)'
                dom.style.transition = 'all .4s'
                dom.style.alignItems = 'center'
                dom.style.justifyContent = 'center'
                dom.style.zIndex = '999'
                dom.style.display = 'flex'
                if (className === 'add-row-pointer') {
                    dom.style.left = '-24px'
                    if (index === 0) {
                        dom.style.top = '-2.5px'
                    } else {
                        dom.style.bottom = '-2.5px'
                    }
                } else {
                    dom.style.top = '-24px'
                    if (index === 0) {
                        dom.style.left = '-2.5px'
                    } else {
                        dom.style.right = '-2.5px'
                    }
                }
                dom.onmouseover = () => this.mouseoverPoint(dom)
                dom.onmouseleave = () => this.mouseleavePoint(dom)
                dom.onmousedown = (e) => {
                    e.stopPropagation()
                }
                dom.onclick = async (e) => {
                    e.stopPropagation()
                    if (window.translatePromise) {
                        await window.translatePromise
                    }
                    this.handleClickPoint(dom)
                }
            },
            mouseoverPoint (dom) {
                const hoverIndex = parseInt(dom.getAttribute('index'))
                let offsetLeft = -1
                dom.style.transform = dom.classList.contains('add-row-pointer') ? 'rotate(-45deg) scale(3.3)' : 'rotate(45deg) scale(3.3)'
                dom.style.background = '#3F82F9'
                dom.style.borderRadius = '50% 50% 8% 50%'
                dom.querySelector('span').style.color = 'white'
                if (dom.classList.contains('add-col-pointer')) {
                    const hoverBorder = this.$el.querySelector('.hoverVerticalBorder')
                    this.$el.querySelectorAll(`.ant-table tr:first-child td`).forEach((item, index) => {
                        if (index < hoverIndex + 1) {
                            offsetLeft += item.getBoundingClientRect().width / window.$$Freelayout.utils.getFreeLayout().getZoom()
                        }
                    })
                    hoverBorder.style.display = 'block'
                    hoverBorder.style.left = offsetLeft + 'px'
                } else {
                    const hoverBorder = this.$el.querySelector('.hoverHorizontalBorder')
                    this.$el.querySelectorAll(`.ant-table tr`).forEach((item, index) => {
                        if (index < hoverIndex + 1) {
                            offsetLeft += item.getBoundingClientRect().height / window.$$Freelayout.utils.getFreeLayout().getZoom()
                        }
                    })
                    hoverBorder.style.display = 'block'
                    hoverBorder.style.top = offsetLeft + 'px'
                }
            },
            mouseleavePoint (dom) {
                dom.style.transform = dom.classList.contains('add-row-pointer') ? 'rotate(-45deg)' : 'rotate(45deg)'
                dom.style.background = '#DCDCDC'
                dom.style.borderRadius = '50%'
                dom.querySelector('span').style.color = '#DCDCDC'
                const hoverVerticalBorder = this.$el.querySelector('.hoverVerticalBorder')
                const hoverHorizontalBorder = this.$el.querySelector('.hoverHorizontalBorder')
                hoverVerticalBorder.style.display = 'none'
                hoverHorizontalBorder.style.display = 'none'
            },
            batchSetPannelValue (commandValue) {
                this.updateDynamicStaticProps(commandValue)
                tableVar[this._$$$_componentId].isCreated = true
            },
            handleClickPoint (dom) {
                const index = parseInt(dom.getAttribute('index'))
                const isRow = dom.classList.contains('add-row-pointer')
                if (isRow) {
                    const dataSource = this.data.dataSource
                    const ids = dataSource.map(item => item.id).sort((a, b) => a - b)
                    let id = 0
                    while (ids.includes(id)) {
                        id++
                    }
                    const item = dataSource[index - 1] ? dataSource[index - 1] : dataSource[index] || {}
                    const itemClone = JSON.parse(JSON.stringify(item))
                    Object.keys(itemClone).forEach(key => {
                        itemClone[key] = ''
                    })
                    itemClone.id = id
                    dataSource.splice(index, 0, itemClone)
                    const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                    this.setPannelValue(params.id, params.comkey, params.value, true)
                } else {
                    const columns = this.data.columns
                    const item = columns[index - 1] ? columns[index - 1] : columns[index]
                    const dataIndex = this.getDataIndex(columns)
                    const itemClone = JSON.parse(JSON.stringify({ ...item, width: undefined }))
                    Object.keys(itemClone).forEach(key => {
                        if (key !== 'width') {
                            itemClone[key] = dataIndex
                        }
                    })
                    columns.splice(index + 1, 0, itemClone)
                    this.initSelect()
                    this.colStyleArr.splice(index, 0, defalutColStyle)

                    const commandValue = [
                        {id: this._$$$_componentId, comkey: 'colStyleArr', value: this.colStyleArr, flush: false},
                        {id: this._$$$_componentId, comkey: 'data', value: this.data, flush: true}
                    ]
                    this.batchSetPannelValue(commandValue)
                }
            },
            getDataIndex (columns, name = 'custom', nameNumber = 0) {
                const currentName = nameNumber > 0 ? name + nameNumber : name
                const result = columns.find((item) => item.dataIndex === currentName)
                if (result) {
                    return this.getDataIndex(columns, name, ++nameNumber)
                } else {
                    return nameNumber > 0 ? name + nameNumber : name
                }
            },
            copyItem () {
                let startRow, startCol, endRow, endCol, tempData
                if (this.contextmenuIsRow) {
                    startRow = this.contextmenuIndex - 1
                    startCol = 1
                    endRow = this.contextmenuIndex
                    endCol = this.data.columns.length
                } else {
                    startRow = 0
                    startCol = this.contextmenuIndex
                    endRow = this.data.dataSource.length - 1
                    endCol = this.contextmenuIndex
                }
                const keys = this.data.columns.slice(startCol, endCol + 1).map(item => item.dataIndex)
                if (this.contextmenuIsRow) {
                    tempData = this.data.dataSource.slice(startRow, endRow).map(item => {
                        const tempItem = []
                        keys.forEach(key => {
                            tempItem.push(item[key])
                        })
                        return tempItem
                    })
                } else {
                    tempData = [this.data.dataSource.map(item => item[keys[0]])]
                }

                copyToClipboard(JSON.stringify(tempData))
            },
            async pasteItem (startRow, startCol) {
                const text = await getClipboardContent()
                if (text && text.startsWith('yt-com:')) {
                    const str = text.slice(7)
                    if (str) {
                        try {
                            const arr = JSON.parse(str).flat()
                            if (this.contextmenuIsRow) {
                                this.data.columns.forEach((item, index) => {
                                    if (item.dataIndex !== 'id') {
                                        this.data.dataSource[startRow][item.dataIndex] = arr[index - 1]
                                    }
                                })
                            } else {
                                const key = this.data.columns[startCol].dataIndex
                                this.data.dataSource = this.data.dataSource.map((item, index) => {
                                    item[key] = arr[index]
                                    return item
                                })
                            }
                            const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                            this.setPannelValue(params.id, params.comkey, params.value, true)
                        } catch { }
                    }
                }
            },
            cutItem () {
                this.copyItem()
                let startRow, startCol, endRow, endCol
                if (this.contextmenuIsRow) {
                    startRow = this.contextmenuIndex - 1
                    startCol = 0
                    endRow = this.contextmenuIndex
                    endCol = this.data.columns.length

                    this.data.columns.forEach((item) => {
                        if (item.dataIndex !== 'id') {
                            this.data.dataSource[startRow][item.dataIndex] = ''
                        }
                    })
                } else {
                    startRow = 0
                    startCol = this.contextmenuIndex
                    endRow = this.data.dataSource.length - 1
                    endCol = this.contextmenuIndex

                    const keys = this.data.columns.slice(startCol, parseInt(endCol) + 1).map(item => item.dataIndex)
                    for (let row = startRow; row <= endRow; row++) {
                        for (const key of keys) {
                            this.data.dataSource[row][key] = ''
                        }
                    }
                }

                const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                this.setPannelValue(params.id, params.comkey, params.value, true)
            },
            insertRow (index, count, topOrBottom) {
                const dataSource = this.data.dataSource
                const item = dataSource[0] || {}
                const itemClone = JSON.parse(JSON.stringify(item))
                Object.keys(itemClone).forEach(key => {
                    itemClone[key] = ''
                })
                if (topOrBottom === 'bottom') {
                    index++
                }
                const ids = dataSource.map(item => item.id).sort((a, b) => a - b)
                let insertIndex = index - 1
                for (let i = 0; i < count; i++) {
                    let id = 1
                    while (ids.includes(id)) {
                        id++
                    }
                    if (!ids.includes(id)) {
                        ids.push(id)
                    }
                    dataSource.splice(insertIndex, 0, {
                        ...itemClone,
                        id
                    })
                    insertIndex += 1
                }
                const params = { id: this._$$$_componentId, comkey: 'data', value: this.data, refresh: true }
                this.setPannelValue(params.id, params.comkey, params.value, true)
            },
            insertCol (index, count, leftOrRight) {
                if (leftOrRight === 'right') {
                    index++
                }
                const columns = this.data.columns
                const item = columns[0]
                const itemClone = JSON.parse(JSON.stringify({ ...item, width: undefined }))
                for (let i = 0; i < count; i++) {
                    const newName = getNewName('custom', columns.map(item => item.dataIndex))
                    for (const key in itemClone) {
                        if (key !== 'width') {
                            itemClone[key] = newName
                        }
                    }
                    this.data.columns.splice(index + i, 0, JSON.parse(JSON.stringify(itemClone)))
                    this.colStyleArr.splice(index - 1, 0, defalutColStyle)
                }

                const commandValue = [
                    {id: this._$$$_componentId, comkey: 'colStyleArr', value: this.colStyleArr, flush: false},
                    {id: this._$$$_componentId, comkey: 'data', value: this.data, flush: true}
                ]
                this.batchSetPannelValue(commandValue)
                this.initSelect()
            },
            deleteItem (index, key) {
                const id = this._$$$_componentId
                this.data[key].splice(index, 1)
                this.initSelect()
                if (!this.contextmenuIsRow) {
                    this.colStyleArr.splice(parseInt(index) - 1, 1)
                }
                if (key === 'columns') {
                    let tagIndex = index
                    if (this.canSelect) {
                        tagIndex += 1
                    }
                    const dom = this.$el.querySelector(`.ant-table .ant-table-tbody tr:first-child td:nth-child(${tagIndex}) div`)
                    if (dom) {
                        const tag = dom.getAttribute('yt-domslot')
                        if (tag) {
                            const tags = window.$$Freelayout.utils.getFreeLayout().getRuntime().getChildrenOfTag(id, tag) || []
                            const ids = tags.map((item) => item.getId()) || []
                            config.removeComponent(ids)
                        }
                    }
                }

                const commandValue = [
                    {id: this._$$$_componentId, comkey: 'colStyleArr', value: this.colStyleArr, flush: false},
                    {id: this._$$$_componentId, comkey: 'data', value: this.data, flush: true}
                ]
                this.batchSetPannelValue(commandValue)
            },
            setHandlerAttr (dom, index, className) {
                dom.setAttribute('index', index)
                dom.style.position = 'absolute'
                dom.style.cursor = 'pointer'
                dom.style.background = '#DCDCDC'
                if (className === 'add-row-handler') {
                    dom.style.width = '11px'
                    dom.style.left = '-11px'
                    dom.style.top = '0'
                    dom.style.bottom = '0'
                    if (index === 1) {
                        if (this.data.dataSource.length === 1) {
                            dom.style.borderTopLeftRadius = '2px'
                            dom.style.borderBottomLeftRadius = '2px'
                        } else {
                            dom.style.borderTopLeftRadius = '2px'
                        }
                    } else if (index === this.data.dataSource.length) {
                        dom.style.borderBottomLeftRadius = '2px'
                    }
                } else {
                    dom.style.height = '11px'
                    dom.style.top = '-11px'
                    dom.style.left = ' 0'
                    dom.style.right = '0'
                    if (index === 1) {
                        if (this.data.columns.length === 2) {
                            dom.style.borderTopLeftRadius = '2px'
                            dom.style.borderTopRightRadius = '2px'
                        } else {
                            dom.style.borderTopLeftRadius = '2px'
                        }
                    } else if (index === this.data.columns.length - 1) {
                        dom.style.borderTopRightRadius = '2px'
                    }
                }
            },
            createHandler (item, index, className) {
                const handlerDom = document.createElement('div')
                this.setHandlerAttr(handlerDom, index, className)
                handlerDom.classList.add('add-handler', className, `add-handler-${index}`)
                handlerDom.oncontextmenu = (e) => {
                    e.preventDefault();
                    e.stopPropagation();
                    contextMenu.show(e)
                    contextMenu.updatePosition(e)
                    this.hideComponentTool()
                    this.contextmenuIndex = parseInt(e.target.getAttribute("index"));
                    this.contextmenuIsRow = e.target.classList.contains('add-row-handler')
                    registerContextMenu(this)
                }
                handlerDom.onmouseover = () => { this.mouseoverHandler(handlerDom) }
                handlerDom.onmouseleave = () => { this.mouseleaveHandler(handlerDom) }
                handlerDom.onmousedown = (e) => {
                    e.stopPropagation()
                }
                handlerDom.onclick = (e) => {
                    e.stopPropagation()
                    this.clickHandler(handlerDom)
                }
                handlerDom.onmouseover = (e) => {
                    if (handlerDom.style.background !== 'rgb(63, 130, 249)') {
                        handlerDom.style.background = '#BCBCBC'
                    }
                }
                handlerDom.onmouseleave = (e) => {
                    if (handlerDom.style.background !== 'rgb(63, 130, 249)') {
                        handlerDom.style.background = '#DCDCDC'
                    }
                }
                item.appendChild(handlerDom)
            },
            setColData (index) {
                Object.keys(this.colStyleArr[index - 1]).forEach((key) => {
                    this.setStaticPannelValue(null, key, this.colStyleArr[index - 1][key])
                })
            },
            mouseoverHandler (dom) {
                dom.classList.add('hoverHandler')
            },
            mouseleaveHandler (dom) {
                dom.classList.remove('hoverHandler')
            },
            async clickHandler (dom, needSet = true) {
                let top = 0, right = 0, bottom = 0, left = 0
                const tableArea = this.$el.querySelector('.tableArea')
                if (!tableArea) {
                    return false
                }
                const clickIndex = parseInt(dom.getAttribute('index'))
                const id = this._$$$_componentId
                if (document.querySelector('.baseConfig').style.display === '') {
                    tableVar[id].promise = new Promise((resolve) => {
                        tableVar[id].resolve = resolve
                    })
                    await tableVar[id].promise
                }
                tableVar[id].selectHandlerDom = dom
                this.$el.querySelectorAll('.add-row-handler').forEach((item, index) => {
                    if (index === clickIndex && dom.classList.contains('add-row-handler')) {
                        item.style.background = '#3F82F9'
                    } else {
                        item.style.background = '#DCDCDC'
                    }
                })
                this.$el.querySelectorAll('.add-col-handler').forEach((item, index) => {
                    if (index + 1 === clickIndex && dom.classList.contains('add-col-handler')) {
                        item.style.background = '#3F82F9'
                    } else {
                        item.style.background = '#DCDCDC'
                    }
                })
                if (dom.classList.contains('add-col-handler')) {
                    if (needSet) {
                        this.setColData(clickIndex)
                    }
                    this.closeAllPannel('tableCol')
                    const domIndex = this.canSelect ? clickIndex : clickIndex - 1
                    const currentColKey = this.data.columns[domIndex]?.key
                    if (currentColKey) {
                        this.toUpdataData(id, 'currentColKey', currentColKey, false)
                    }
                    // 更新组件的属性currentColKey为当前选中列的key
                    this.$el.querySelectorAll('th').forEach((item, index) => {
                        if (index <= domIndex) {
                            if (index < domIndex) {
                                left += item.getBoundingClientRect().width / window.$$Freelayout.utils.getFreeLayout().getZoom()
                            } else {
                                right = left + item.getBoundingClientRect().width / window.$$Freelayout.utils.getFreeLayout().getZoom()
                                tableArea.style.top = top + 'px'
                                tableArea.style.right = `calc(100% - ${right}px)`
                                tableArea.style.bottom = bottom + 'px'
                                tableArea.style.left = left + 'px'
                                tableArea.style.display = 'block'
                                tableArea.style.zIndex = '999'
                            }
                        }
                    })
                    this.hanleAiCustome(clickIndex - 1)
                } else {
                    if (clickIndex === 0) {
                        this.closeAllPannel('tableHeader')
                    } else {
                        this.closeAllPannel('tableRow')
                        this.handleRowBgDom()
                    }
                    this.$el.querySelectorAll('tr').forEach((item, index) => {
                        if (index <= clickIndex) {
                            if (index < clickIndex) {
                                top += item.getBoundingClientRect().height / window.$$Freelayout.utils.getFreeLayout().getZoom().toFixed(2)
                            } else {
                                bottom = top + item.getBoundingClientRect().height / window.$$Freelayout.utils.getFreeLayout().getZoom().toFixed(2)
                                tableArea.style.top = top + 'px'
                                tableArea.style.right = right + 'px'
                                tableArea.style.bottom = `calc(100% - ${bottom}px)`
                                tableArea.style.left = left + 'px'
                                tableArea.style.display = 'block'
                                tableArea.style.zIndex = '999'
                            }
                        }
                    })
                }
            },
            handleRowBgDom () {
                if (this.rowBackgroundType === 'zebra') {
                    this.$el.classList.add('ant-table-striped')
                    const dom = document.querySelector('.rowBackground')
                    if (dom) {
                        dom.style.display = 'none'
                        document.querySelectorAll('.zebraBackground').forEach((item) => {
                            item.style.display = 'flex'
                        })
                    }
                } else if (this.rowBackgroundType === 'solid') {
                    this.$el.classList.remove('ant-table-striped')
                    const dom = document.querySelector('.rowBackground')
                    if (dom) {
                        dom.style.display = 'flex'
                        document.querySelectorAll('.zebraBackground').forEach((item) => {
                            item.style.display = 'none'
                        })
                    }
                }
            },
            hanleAiCustome(index){
                if (index >= 0) {
                    this.colType = this.colStyleArr[index]?.colType
                    if (this.colType === 'default') {
                        const dom = document.querySelector('.requirementStyle')
                        if (dom) {
                            dom.style.display = 'none'
                            document.querySelectorAll('.cunstomeColStyle').forEach((item) => {
                                item.style.display = 'flex'
                            })
                        }
                    } else if (this.colType === 'slot') {
                        const dom = document.querySelector('.cunstomeColStyle')
                        if (dom) {
                            dom.style.display = 'none'
                            document.querySelectorAll('.requirementStyle').forEach((item) => {
                                item.style.display = 'flex'
                            })
                        }
                    }
                }
            },
            getIndex (dom) {
                return parseInt(dom.getAttribute('index'))
            },
            getWidth () {
                let count = 0
                const widthNumber = this.colStyleArr.reduce((acc, cur) => {
                    if (cur.autoSize && cur.autoSize.autoWidth) {
                        ++count
                    } else {
                        acc += parseInt(cur.colWidth)
                    }
                    return acc
                }, 0)
                return {
                    count,
                    widthNumber
                }
            },
            getColPannel (keys, clickIndex, callback) {
                const baseObj = {}
                const divObj = {}
                const spanObj = {}
                const thObj = {}
                keys.forEach((key) => {
                    const value = this.colStyleArr[clickIndex][key]
                    if (key.toLowerCase().includes('autosize')) {
                        if (value && value.autoWidth) {
                            const { count, widthNumber } = this.getWidth()
                            if (count) {
                                thObj.width = `calc((100% - ${widthNumber}px) / ${count}) !important`
                                thObj['min-width'] = '1px !important'
                                thObj['max-width'] = '1px !important'
                            } else {
                                thObj.width = `calc((100% - ${widthNumber}px) / ${this.colStyleArr.length}) !important`
                                thObj['min-width'] = '1px !important'
                                thObj['max-width'] = '1px !important'
                            }
                        } else {
                            thObj.width = `${parseInt(this.colStyleArr[clickIndex].colWidth)}px !important`
                            thObj['min-width'] = `${parseInt(this.colStyleArr[clickIndex].colWidth)}px !important`
                            thObj['max-width'] = `${parseInt(this.colStyleArr[clickIndex].colWidth)}px !important`
                        }
                    } else if (typeof value === 'object') {
                        if (key.toLowerCase().includes('text')) {
                            spanObj.color = value.fontStyle.color
                            spanObj['font-family'] = value.fontFamily
                            spanObj['font-size'] = value.fontSize
                            spanObj['font-weight'] = value.fontWeight
                            spanObj['line-height'] = value.lineHeight
                            spanObj['letter-spacing'] = value.letterSpacing
                            spanObj['text-decoration'] = value.textDecoration
                            spanObj['font-style'] = value.textStyle
                            divObj['text-align'] = value.textAlign
                            divObj['text-align-last'] = value.textAlign
                            divObj['padding-top'] = value.paddingTop
                            divObj['padding-right'] = value.paddingRight
                            divObj['padding-bottom'] = value.paddingBottom
                            divObj['padding-left'] = value.paddingLeft
                        }
                    } else {
                        if (key.toLowerCase().includes('width')) {
                            baseObj.width = value
                        } else {
                            baseObj[key] = value
                        }
                    }
                    if (callback instanceof Function) {
                        callback(key, value)
                    }
                })
                const index = this.canSelect ? clickIndex + 2 : clickIndex + 1
                return ([
                    {
                        key: `.__customClassName__ tr td:nth-child(${index}) div:first-child`,
                        properties: divObj
                    },
                    {
                        key: `.__customClassName__ tr td:nth-child(${index}) div:first-child span.td-text`,
                        properties: spanObj
                    },
                    {
                        key: `.__customClassName__ tr > th:nth-child(${index}), .__customClassName__ .ant-table-body tr.ant-table-measure-row td:nth-child(${index})`,
                        properties: thObj
                    }
                ]);
            },
            setSelectRowCol () {
                let left = 0, right = 0, top = 0, bottom = 0;
                const startDom = state[0][2]
                const endDom = state[1][2]
                const tableArea = this.$el.querySelector('.tableArea')
                const startRect = startDom.getBoundingClientRect()
                const endRect = endDom.getBoundingClientRect()
                const elRect = this.$el.getBoundingClientRect()
                const zoom = window.$$Freelayout.utils.getFreeLayout().getZoom().toFixed(2)

                if (startRect.top > endRect.top) {
                    bottom = elRect.top + elRect.height - startRect.top - startRect.height
                } else {
                    bottom = elRect.top + elRect.height - endRect.top - endRect.height
                }
                if (startRect.left > endRect.left) {
                    right = elRect.left + elRect.width - startRect.left - startRect.width
                } else {
                    right = elRect.left + elRect.width - endRect.left - endRect.width
                }

                top = Math.min(startRect.top - elRect.top, endRect.top - elRect.top)
                left = Math.min(startRect.left - elRect.left, endRect.left - elRect.left)

                tableArea.style.top = top / zoom + 'px'
                tableArea.style.right = `${right / zoom}px`
                tableArea.style.bottom = `${bottom / zoom}px`
                tableArea.style.left = left / zoom + 'px'
                tableArea.style.display = 'block'
            },
            toUpdataData(data){
                bus.emit('toUpdataData',data)
            }
        },
        __getEditorAttrs__(tagName,attribute) {
            if(tagName === 'yt-table') {
                return {
                    "@toUpdataData": 'toUpdataData'
                }
            }
        }
    });
}

function getNewName (name, arr, index = 0) {
    let newName = name + (index || '')
    while (arr.includes(newName)) {
        newName = name + (++index || '')
    }
    return newName
}

async function getClipboardContent () {
    return localStorage.getItem('yt-com')
}

function copyToClipboard (content) {
    localStorage.setItem('yt-com', 'yt-com:' + content)
}

function getChildIndex (child) {
    let index = 0
    let sibling = child
    while (sibling.previousElementSibling) {
        sibling = sibling.previousElementSibling
        index++
    }
    return index + 1 // 如果需要从1开始计数
}

function makeFirstLetterLowercase (str) {
    if (str === null || str === undefined || str.length === 0) {
        return str
    }
    return str.charAt(0).toLowerCase() + str.slice(1)
}
