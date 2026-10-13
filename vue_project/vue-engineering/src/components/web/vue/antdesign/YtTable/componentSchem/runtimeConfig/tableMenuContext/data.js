
export const configDefault = [
    {
        type: 'copy',
        name: '复制',
    },
    {
        type: 'paste',
        name: '粘贴',
    }, {
        type: 'cut',
        name: '剪切',
        border: true
    }, {
        type: 'insertOnTop',
        name: '在上方插入',
        hasInput: true,
        spanText:'行',
        roworcol: 'row'
    }, {
        type: 'insertUnderBottom',
        name: '在下方插入',
        hasInput: true,
        spanText:'行',
        roworcol: 'row'
    }, {
        type: 'deleteRow',
        name: '删除行',
        border: true,
        roworcol: 'row'
    }, {
        type: 'insertByLeft',
        name: '在左侧插入',
        hasInput: true,
        spanText:'列',
        roworcol: 'col'
    }, {
        type: 'insertByRight',
        name: '在右侧插入',
        hasInput: true,
        spanText:'列',
        roworcol: 'col'
    }, {
        type: 'deleteColumn',
        name: '删除列',
        roworcol: 'col'
    }
]