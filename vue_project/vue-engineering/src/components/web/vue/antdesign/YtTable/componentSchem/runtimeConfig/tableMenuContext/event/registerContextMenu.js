import {getContextMenu} from '../getContentMunt'
import {getParent} from '../nativeDom'
import itemNodeHelper from '../itemNodeHelper'
const EVENT_NAME = {
    MENU_CLICK:new Set([
        'copy','paste','cut','insertOnTop',
        'insertUnderBottom','deleteRow','insertByLeft','insertByRight','deleteColumn'])
}

export function registerContextMenu(ctx) {
    const contextmenu = getContextMenu();
    if (contextmenu) {
        const registerCollect = contextmenu.getRegisterCollect();
        registerCollect.forEach(({node,config}) => {
            if (config.type.includes("insert")) {
                node.children[1].onkeydown = (e) => {
                    if(e.keyCode == 13){
                        handleChildClick(config, getParent(node), ctx, e)
                    }
                }
            } else {
            }
            node.onmousedown = handleChildClick.bind(null, config, getParent(node),ctx)
            node.onmouseenter = handleMouseover
            node.onmouseleave = hendleMouseout
        })
        // const container = contextmenu.getContainer();
        // container.addEventListener("contextmenu", MenuHandler.contextmenuHandler);
        // container.addEventListener("click", MenuHandler.clickHandler);
        // if (window && window.parent && window.parent.document) {
        //     window.parent.document.body.addEventListener("click", MenuHandler.clickHandler);
        // }
    }
}

function handleChildClick(item,parentNdoe,ctx,event){
    event.stopPropagation();
    const contextmenu = getContextMenu();
    if(contextmenu){
        contextmenu.clickItem(parentNdoe);
    }
    if(item){
        const type = item.type;
        const menuClickTypes = EVENT_NAME.MENU_CLICK;
        if(menuClickTypes.has(type)){
            if(!itemNodeHelper[type]){
                console.warn(`没有${type}方法`);
                return;
            }
            const inputDom = parentNdoe.querySelector(`.${item.type}-input`);
            itemNodeHelper[type](ctx, event, inputDom?.value);
        }
    }else{
        console.warn('没有找到菜单项配置')
    }
}

function handleMouseover(event){
    const contextmenu = getContextMenu();
    if (contextmenu) {
        contextmenu.mouseoverItem(event.target);
    }
}
function hendleMouseout(event){
    const contextmenu = getContextMenu();
    if (contextmenu) {
        contextmenu.mouseoutItem(event.target);
    }
}

export function unRegisterContextMenu() {
    const contextmenu = getContextMenu();
    if(contextmenu){
        const registerCollect = contextmenu.getRegisterCollect();
        registerCollect.forEach(({node,config}) => {
            node.removeEventListener('click', handleChildClick, false)
            node.removeEventListener('mouseenter',handleMouseover);
            node.removeEventListener('mouseleave', hendleMouseout);
        })
        // const container = contextmenu.getContainer();
        // container.removeEventListener('contextmenu', MenuHandler.contextmenuHandler)
        // container.removeEventListener('click', MenuHandler.clickHandler)
        // if (window && window.parent && window.parent.document) {
        //     window.parent.document.body.removeEventListener("click", MenuHandler.clickHandler);
        // }
    }
    // bus.off('clickLayerMenu', clickLayerMenu)
    // bus.off('clickArrangeMode', clickArrangeMode)
}