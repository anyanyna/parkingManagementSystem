import {appendNode,appendNodes, createElement, removeElement} from "./nativeDom";
export default class MenuHelper {
    static itemClassPrefix = 'component-tool-item-';
    static createSpan(style,text){
        const span = createElement('span', { style: style, classNames: '' })
        span.innerHTML = text;
        return span;
    }
    static createInput(config){
        const input = createElement('input', { type:'text',style: { width: '40px', height: '20px', border: 'none', outline: 'none',color:'black', backgroundColor: '#f5f5f5', textAlign: 'center', borderRadius: '4px'}, classNames: `jm-tool-input ${config.type}-input` })
        return input;
    }
    static createInputSpan(style,text) {
        const span = createElement('span', { style: style, classNames: '' })
        span.innerHTML = text;
        return span;
    }
    static createByConfig(configs,shaderStyle,processHandler) {
        const itemNodes = [];
        for(let i=0,len=configs.length;i<len;i++) {
            const config = configs[i];
            const itemNode = createElement('div', { style: shaderStyle.div, classNames: ['jm-tool-item', MenuHelper.itemClassPrefix + config.type], attribute: {roworcol: config.roworcol} });
            if (config.border) {itemNode.style.borderBottom = `1px solid #EDEDED`}
            if (config.icon) {itemNode.appendChild(MenuHelper.createIcon(config.icon))}
            appendNode(itemNode, MenuHelper.createSpan(shaderStyle.span, config.name));
            if(config.hasInput){
                const input = MenuHelper.createInput(config)
                input.value = 1
                appendNode(itemNode, input);
                input.onclick = (e) => {
                    e.stopPropagation()
                    // e.preventDefault()
                }
                input.onmousedown = (e) => {
                    // e.preventDefault()
                    e.stopPropagation()
                }
            }
            if(config.spanText){
                appendNode(itemNode,MenuHelper.createInputSpan(shaderStyle.span, config.spanText));
            }
            if(processHandler && typeof processHandler == 'function'){processHandler(config,itemNode);}
            itemNodes.push(itemNode);
        }
        return itemNodes;
    }
    constructor(menuConfig) {
        this._menuConfig = menuConfig || {};
        this._menuContent = null
    }
    getDomByType(type) {
        const doms = this._menuContent.querySelector('.' + MenuHelper.itemClassPrefix + type);
        return doms;
    }
    createMenuContent(processHandler, registerCollect) {
        let dom = document.querySelector('.component-tools');
        if (!registerCollect.length && dom) {
            dom.remove()
            dom = null
        }
        if(dom){
            return dom
        }
        const parentStyle = {
            style: {
                position:'fixed',
                backgroundColor: 'white',
                // 暂时写死
                top:'200px',
                left:'300px',
                boxShadow: '0 0 5px 2px rgba(0, 0, 0, 0.1)',
                borderRadius: '4px'
            }, 
            classNames: 'component-tools'
        }
        const parent = createElement('div', parentStyle)
        parent.addEventListener('contextmenu', e => e.preventDefault())
        const itemNodes = MenuHelper.createByConfig(this._menuConfig,{
            div: {
                lineHeight: '33.6px',
                color: '#333',
                padding: '0px 10px 0px 10px',
                fontSize: '12px',
                display: 'flex',
                alignItems: 'center',
                cursor: 'pointer',
            },
            span: {
                marginLeft: '10px',
                marginRight:'6px',
            }
        },processHandler)
        appendNodes(parent, itemNodes);
        this._menuContent  = parent;
        return parent;
    }
    destory(){
        removeElement(this._menuContent)
        this._menuContent = null;
    }
}