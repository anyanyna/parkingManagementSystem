import isDEV from './isDEV'
const nativeCacheDom = {
    'div':document.createElement('div'),
};
const supportTag = 'div,span,img,p,video,h1,h2,h3,h4,h5'.split(',');
export function createElementOfTag(tag) {
    if(supportTag.indexOf(tag)<0){return document.createElement(tag);}
    let content = nativeCacheDom[tag];
    if(!content){
        nativeCacheDom[tag] = document.createElement(tag);
    }
    return nativeCacheDom[tag].cloneNode();
}
export function isDom(dom) {
    return ( typeof HTMLElement === 'object' )?
        (dom instanceof HTMLElement):
        (dom && typeof dom === 'object' && dom.nodeType===1 && typeof dom.tagName === 'string')
}
export function setStyle(dom,style) {
    if(!isDom(dom)){return false;}
    for (let key in style){
        dom.style[key] = style[key];
    }
    return true;
}
export function getClassNames(classNames) {
    let strClassNames = classNames || "";
    if(Array.isArray(classNames)){
        strClassNames = classNames.join(' ');
    }
    return strClassNames.trim();
}
export function removeClassNames(dom,classNames) {
    if(!isDom(dom)){return false;}
    let strClassNames = getClassNames(classNames);
    dom.className = dom.className.replace(strClassNames,'').trim();
    return true;
}
export function addClassNames(dom,classNames) {
    if(!isDom(dom)){return false;}
    let strClassNames = getClassNames(classNames).trim();
    let domClassList = dom.className.trim().split(/\s+/);
    // 检查要添加的类名是否已经存在于 DOM 元素的类列表中
    let classNamesToAdd = strClassNames.split(/\s+/).filter(className => !domClassList.includes(className));
    // 添加类名到 DOM 元素
    dom.className += " " + classNamesToAdd.join(" ");
    
    return true;
}
export function setClassNames(dom,classNames) {
    if(!isDom(dom)){return false;}
    let strClassNames = getClassNames(classNames);
    dom.className = strClassNames.trim();
    return true;
}
export function createElement(tag,{style,classNames,type}) {
    let content = createElementOfTag(tag);
    setStyle(content,style);
    setClassNames(content,classNames);
    if(type){
        setAttribute(content,'type',type)
    }
    return content;
}
export function appendNodes(parent,eles){
    if(!Array.isArray(eles)){eles=[eles]}
    for(let i=0;i<eles.length;i++){
        appendNode(parent,eles[i]);
    }
}
export function appendNode(parent,ele) {
    if(!(isDom(parent) && isDom(ele))){return false}
    parent.appendChild(ele);
    return true;
}
export function getElementById(id) {
    return document.getElementById(id) || null;
}
export function getParent(dom) {
    return dom?dom.parentNode:null;
}
export function getParentElementById(id) {
    let dom = getElementById(id);
    return dom?dom.parentNode:null;
}
export function getAttribute(node,key) {
    if(!node){return null;}
    return node.getAttribute(key) || null;
}
export function hasAttribute(node, key) {
  if (!node) { return false; }
  return node.hasAttribute(key);
}
export function setAttribute(node,key,value) {
    if(!node){return null;}
    node.setAttribute(key, value)
    return 
}
export function createContent(dom,classNames) {
    let content = createElement('div',{classNames});
    appendNode(dom,content);
    return content;
}

export function removeElement(dom) {
    const parent =  getParent(dom)
    if(!parent){
        return false
    }
    parent.removeChild(dom)
    return true
}

export function pointerStyle(dom,key,value){
    if(!isDom(dom)){
        if(isDEV()){
            console.error('dom is not dom')
        }
        return 
    }
    dom.style[key] = value
}


export function getBoundingClientRect(dom) {
    if(!isDom(dom)){
        if(isDEV()){
            console.error('dom is not dom')
        }
        return 
    }
    return dom.getBoundingClientRect()
}

export function getDomByAttribute(dom,attribute) {
    return dom.querySelector(attribute);
}