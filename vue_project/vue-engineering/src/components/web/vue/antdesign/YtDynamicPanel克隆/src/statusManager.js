const status = new Map();
const activeStatusId = '1';
export function getDynamicPanelData(id){
    if(status.has(id)){
        return status.get(id)
    }
    return null
}
export function setDynamicPanelData(id,addComObj){
    if(status.has(id)){
        const data = status.get(id)
        data.components.push(addComObj)
        status.set(id,data)
    }else{
        status.set(id,{components:[addComObj],label:'默认状态'})
    }
}
export function resetDynamicPanelDataMap(){
    status = new Map()
}
export function getMap(){
    return status
}
export function setActiveStatusId(value){
    activeStatusId = value
}
export function getActiveStatusId(){
    return activeStatusId
}
export function setMap(statusList){
    resetDynamicPanelDataMap()
    if(statusList){
        statusList && Object.keys(statusList).forEach(id => {
            status.set(id,statusList[id])
        })
    }
}
export function getDynamicData(id,comkey){
    let realValue = ''
    const components = getDynamicPanelData(activeStatusId).components || []
    for(let i=0;i<components.length;i++){
        const comInfo = components[i]
        if(comInfo.id === id){
            Object.keys(comInfo).forEach(key => {
                if(Object.keys(comInfo[key]).includes(comkey)){
                    realValue = comInfo[key][comkey]
                }
            })
        }
    }
    return realValue
}