
import { appendNode, removeElement } from "./nativeDom";
import { configDefault } from './data'
import MenuHelper from './menuHelper'
import {setContextMenu} from './getContentMunt'
export default class ContextMenu {
    constructor() {
        setContextMenu(this)
        this._menuHelper = new MenuHelper(configDefault);
        this._registerCollect = [];
        this._menuContent = this._menuHelper.createMenuContent((config,node)=>{
            this._registerCollect.push({node,config});
        }, this._registerCollect)
        this._menuContent && (this._menuContent.style.display = 'none')
        document.onclick = (e) => {
            if (!this._menuContent.contains(e.target)) {
                this.hide()
            }
        }
        document.getElementById('iframe').contentWindow.onclick = (e) => {
            if (!this._menuContent.contains(e.target)) {
                this.hide()
            }
        }
    }
    getRegisterCollect(){
        return this._registerCollect;
    }
    //根据items展示
    show(e){
        this._menuContent.style.display = 'block';
        const isRow = e.target.classList.contains('add-row-handler')
        const children = this._menuContent.children;
        for (let index = 0; index < children.length; index++) {
            const element = children[index];
            if (element.getAttribute('roworcol') === 'row') {
                element.style.display = isRow ? 'block' : 'none';
            } else if (element.getAttribute('roworcol') === 'col') {
                element.style.display = isRow ? 'none' : 'block';
            }
        }
        return this;
    }
    hide(){
        this._menuContent.style.display = 'none';
        return this;
    }
    //点击菜单项
    clickItem(parent){
        let parentNode = parent
        while (parentNode.className !== 'component-tools') {
            parentNode = parentNode.parentNode
        }
        parentNode.style.display = 'none'
    }
    //鼠标移出菜单项
    mouseoutItem(node){
        node.style.background = ''
        return this;
    }
    //鼠标移入菜单项
    mouseoverItem(node){
        if(node){
            node.style.background = '#e4efff'
        }
        return this;
    }
    //菜单位置更新，支持遮住调整
    updatePosition(event){
        const {clientY,clientX} = event;//相对于iframe的位置
        const menuHeight = this._menuContent.clientHeight;
        const menuWidth = this._menuContent.clientWidth;
        const pageHeight = window.innerHeight;
        const pageWidth = window.innerWidth;
        const disBottom = 5;//往上多走disBottom距离，防止贴着下边
        const disRight = 5;//往左多走disRight距离，防止贴着右边
        let top = clientY;
        let left = clientX;
        if((clientY+menuHeight)>pageHeight){
            const dis  = pageHeight-(clientY+menuHeight);
            top = (clientY+dis-disBottom)>0?(clientY+dis-disBottom):0;  
        }
        if((clientX+menuWidth)>pageWidth){
            const dis  = pageWidth-(clientX+menuWidth);
            left = (clientX+dis-disRight)>0?(clientX+dis-disRight):0;
        }
        this._menuContent.style.top = top+60+'px';
        this._menuContent.style.left = left+284 + 'px'
    }
    render() {
        appendNode(document.body, this._menuContent);
    }
    destroy() {
        this._registerCollect = [];
        this._menuHelper.destory();
        this._menuHelper = null;
    }
}