export default function resetGetRuntimeonfig(getRuntimeConfig,bus) {
    if(!getRuntimeConfig){
        return null
    }
    let getRuntimeConfig1 = getRuntimeConfig || null
    getRuntimeConfig = function (config) {
        config.setPannelValue = (id,comkey, value,refresh) => {
            bus.emit('setPannelValue', {id, comkey, value,refresh })
        }
        config.updateDynamicStaticProps = (commandParams) => {
            commandParams.forEach(item => {
                bus.emit('setStaticPannelValue', {id:item.id, comkey:item.comkey, value:item.value })
            })
            bus.emit('updateDynamicStaticProps',commandParams)
        }
        config.setStaticPannelValue = (id,comkey, value) => {
            bus.emit('setStaticPannelValue', {id, comkey, value })
        }
        config.toUpdataData = (id,comkey,value,flush) => {
            bus.emit('toUpdataData', { id,comkey, value,flush })
        }
        config.hideComponentTool = () => {
            bus.emit('hideComponentTool')
        }
        // 因为表格的data数据理由函数，通信会将函数丢失-----提供一个更新表格数据的方法
        config.setTablePannelValue = (id,comkey,index,field1,field2,value) => {
            bus.emit('setTablePannelValue', {id,comkey,index,field1,field2,value })
        }
        config.removeComponent = (ids) => {
            bus.emit('removeComponent', ids)
        }
        return getRuntimeConfig1(config)
    }
    return getRuntimeConfig
}