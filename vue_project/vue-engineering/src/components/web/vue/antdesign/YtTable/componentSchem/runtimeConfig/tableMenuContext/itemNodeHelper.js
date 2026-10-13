//菜单项事件
export default {
    //复制
    copy:(ctx) => {
        ctx.copyItem()
    },
    //粘贴
    paste:function(ctx){
        if (ctx.contextmenuIsRow) {
            ctx.pasteItem(ctx.contextmenuIndex - 1, 1)
        } else {
            ctx.pasteItem(0, ctx.contextmenuIndex)
        }
    },
    //剪切
    cut:function(ctx){
        ctx.cutItem()
    },
    //上面插入
    insertOnTop:function(ctx, e, num=0){
        ctx.insertRow(parseInt(ctx.contextmenuIndex) - 1, parseInt(e.target.value || num), 'top')
    },
    //下面插入
    insertUnderBottom:function(ctx,e, num=0){
        ctx.insertRow(parseInt(ctx.contextmenuIndex), parseInt(e.target.value || num), 'bottom')
    },
    //删除行
    deleteRow:function(ctx){
        ctx.deleteItem(ctx.contextmenuIndex - 1, ctx.contextmenuIsRow ? 'dataSource' : 'columns')
    },
    //左侧插入
    insertByLeft:function(ctx,e, num=0){
        ctx.insertCol(parseInt(ctx.contextmenuIndex), parseInt(e.target.value || num), 'left')
    },
    //右侧插入
    insertByRight:function(ctx,e, num=0){
        ctx.insertCol(parseInt(ctx.contextmenuIndex), parseInt(e.target.value || num), 'right')
    },
    //删除列
    deleteColumn:function(ctx){
        ctx.deleteItem(ctx.contextmenuIndex, ctx.contextmenuIsRow ? 'dataSource' : 'columns')
    }
}