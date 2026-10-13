export const ytComInstance = '__ytCom__'
export function isString(value) {
    return typeof value === "string";
}

export function isNumber(value) {
    if(isString(value)){
        value = Number(value);
    }
    return Object.prototype.toString.apply(value) === '[object Number]';
}
export function isObj(val) {
    return Object.prototype.toString.call(val)==='[object Object]'
}
export function isObjStr(str) {
    if (typeof str != 'string') return false
    let temp = str;
    temp = temp.trim();//去空格
    return (temp.indexOf("{") == 0) && temp.endsWith("}");
}
export function isArrStr(str) {
    let temp = str;
    temp = temp.trim();//去空格
    return (temp.indexOf("[") == 0)&& temp.endsWith("]");
}
export function isNull(value) {
    let temp = value;
    if(isString(temp)){temp = temp.trim().toLowerCase();}
    return temp === 'null' || temp === null
}
export function isUndefined(value) {
    let temp = value;
    if(isString(temp)){temp = temp.trim().toLowerCase();}
    return temp === undefined || temp === 'undefined'
}
export function isArray(value) {
    return Array.isArray(value);
}
export function isTrue(value) {
    return value === true || value === "true"
}
export function isFalse(value){
    return value === false || value === "false"
}

export function isVueDom(dom) {
    return dom['__vue__']
  }

export function isComponentDom(dom) {
    if(dom[ytComInstance]) {
      return dom[ytComInstance]
    } else if(isVueDom(dom)) {
      return findComponentByVueDom(dom)
    } else {
      return null
    }
}

export function findComponentByVueDom(dom) {
    return dom['__vue__'].$root[ytComInstance]
  }
