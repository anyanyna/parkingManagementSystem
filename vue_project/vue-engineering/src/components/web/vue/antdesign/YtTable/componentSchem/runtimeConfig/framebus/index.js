import Framebus from 'framebus'
export function registerFramebus (tableVar, currentId, callback) {
  const changePannelValue = (changedValue) => {
    const { comkey, value, comId } = changedValue
    // 导航组件切换页面
    if(comkey === 'selectPage'){
      changePage()
    }
    if (comkey !== 'currentColKey' && comId === currentId) {
      const tableItem = tableVar[currentId]
      if (tableItem) {
        const excludeKeys = ['states', 'scrollY']
        if (!excludeKeys.includes(comkey) && tableItem.instance.parseValue(comkey) !== 'null') {
          tableItem.instance.createDom()
        }
        if (comkey === 'data') {
          tableItem.instance.initHeight()
        }
        if (tableItem.selectHandlerDom) {
          tableItem.instance.clickHandler(tableItem.selectHandlerDom, false)
          if (tableItem.selectHandlerDom.classList.contains('add-col-handler')) {
            tableItem.instance.handleCol(comkey, value)
            tableItem.isCreated = true
          }
        }
        if (comkey === 'canSelect' || comkey === 'selectType') {
          tableItem.isCreated = true
          tableItem.instance.initCss().then(() => {
            tableItem.instance.createDom()
          })
        }
      }
    }
  }

  const executeSelectComponent = ({ ids }) => {
    const tableItem = tableVar[currentId]
    const moveableDom = document.querySelector('#iframe').contentDocument.querySelector('.moveable-control-box')
    if (tableItem && !ids.includes(currentId)) {
      tableItem.instance.removeDom()
    }
    if (ids.length === 1 && ids[0] in tableVar) {
      const contentWindow = document.querySelector('#iframe')?.contentWindow
      if (contentWindow && contentWindow?.getSelection && !contentWindow.getSelection().isCollapsed) {
        contentWindow.getSelection().removeAllRanges() // 清除所有选择范围
      }
      const tableItem = tableVar[ids[0]]
      if (tableItem) {
        if (!tableItem.promise && !tableItem.resolve) {
          tableItem.selectHandlerDom = null
        } else {
          tableItem.resolve = null
          tableItem.promise = null
        }
        if (!tableItem.isCreated) {
          tableItem.isCreated = true
        }
        tableItem.instance.createDom()
        currentId = ids[0]
        tableItem.currentId = ids[0]
        tableItem.instance.initHeight()
        moveableDom.onmousedown = () => {
          moveableDom.onmousemove = () => {
            tableItem.instance.initSelect()
            moveableDom.onmousemove = null
          }
          moveableDom.onmouseup = () => {
            moveableDom.onmousemove = null
          }
        }
      }
    } else {
      currentId = -1
    }
    callback(currentId)
  }

  const exitSubCanvas = () => {
    Object.keys(tableVar).forEach((key) => {
      tableVar[key].isCreated = true
    })
  }

  const enterSubCanvas = () => {
    Object.keys(tableVar).forEach((key) => {
      tableVar[key].isCreated = true
    })
  }

  const pannelCreated = () => {
    const tableItem = tableVar[currentId]
    if (tableItem) {
      tableItem.instance.closeAllPannel('baseConfig')
    }
  }

  const changePage = () => {
    Object.keys(tableVar).forEach((key) => {
      tableVar[key].isCreated = true
    })
  }

  const changeData = () => {
    const tableItem = tableVar[currentId]
    if (tableItem && !tableItem.isCreated) {
      tableItem.isCreated = true
      tableItem.instance.initCss().then(() => {
        tableItem.instance.createDom()
      })
    }
  }

  const processRemoveComponent = () => {
    currentId = -1
    changeData()
  }

  const resizeEnd = ({selectIds}) => {
    if (currentId && selectIds.length  && selectIds.includes(currentId)) {
      const tableItem = tableVar[currentId]
      if (tableItem) {
        tableItem.instance.initScroll()
      }
    }
  }

  const bus = new Framebus()
  bus.on('changePannelValue', changePannelValue)
  bus.on('executeSelectComponent', executeSelectComponent)
  bus.on('domExitSubCanvas', exitSubCanvas)
  bus.on('domEnterSubCanvas', enterSubCanvas)
  bus.on('pannelCreated', pannelCreated)
  bus.on('changePage', changePage)
  bus.on('executeUpdateDynamicStaticProps', changeData)
  bus.on('undoUpdateDynamicStaticProps', changeData)
  bus.on('executeRemoveComponent', processRemoveComponent)
  bus.on('resizeEnd', resizeEnd)
}