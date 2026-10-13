import isDEV from './isDEV'
let _themeIns = null;
export function setThemeIns(themeIns){
    _themeIns = themeIns
}

export default function getJsThemeVar(key){
    if(!_themeIns){
        if(isDEV()){
            console.error('请先设置主题实例')
        }
        return
    }
    return _themeIns.getJsValue(key)
}