import Framebus from 'framebus';
let oldOptions = {}
let paramMap = new Map() // 对比数据
const upDateParam = function (id) {
    // 处理需要对比的数据
    let MatchParam = {
        oldOptions: {},
    }
    if(paramMap.has(id)) {
        MatchParam = paramMap.get(id)
    }
    oldOptions = MatchParam.oldOptions
}
const setMatchParam = function (id, newData = {}) {
    if(paramMap.has(id) && newData) {
        const oldData = paramMap.get(id)
        const data = Object.assign(oldData, newData)
        paramMap.set(id, data)
    }else  {
        const data = Object.assign({
            oldOptions: {},
        }, newData)
        paramMap.set(id, data)
    }
    upDateParam(id)
}
const removeMatchParam = function (id) {
    if(paramMap.has(id)) {
        paramMap.delete(id)
        return
    }
    return
}
export default function getRuntimeConfig(config) {
    const {setPannelValue,parseValue,getDataValue,getPropOfKey} = config;
    const bus  = new Framebus()
    return ({
        mounted(){
            const id = this._$$$_componentId
            const options = JSON.parse(parseValue(id, ':options', '_$options$_'))
            upDateParam(id)
            if (JSON.stringify(oldOptions) !== JSON.stringify(options)) {
                setPannelValue(id, 'selectedKeys', this.getValue(), true, false)
                const newOptions = { dataSource: this.handleDataSource(options.dataSource, options.value), value: options.value }
                setMatchParam(id, { oldOptions:newOptions })
                setPannelValue(id, 'options', newOptions, true)
            }
            bus.on('executeRemoveComponent',this.executeRemoveComponent)
        },
        beforeDestroy() {
            bus.off('executeRemoveComponent',this.executeRemoveComponent)
        },
        methods:{
            getValue () {
                const options = JSON.parse(parseValue(this._$$$_componentId, ':options', '_$options$_'))
                const value = options.value || {}
                return value?.selectData || []
            },
            handleValue () {
                const options = JSON.parse(parseValue(this._$$$_componentId, ':options', '_$options$_'))
                const value = options.value
                return value
            },
            handleDataSource (data, value) {
                return data.map((item) => {
                    if (value.selectData.includes(item.key)) {
                        item.select = true
                    } else {
                        item.select = false
                    }
                    return item
                })
            },
            // 删除的组件删掉map
            executeRemoveComponent({comIds}) {
                if(comIds && comIds.length) {
                    comIds.forEach(id => {
                        removeMatchParam(id)
                    })
                }
            },
        }
    })
}
