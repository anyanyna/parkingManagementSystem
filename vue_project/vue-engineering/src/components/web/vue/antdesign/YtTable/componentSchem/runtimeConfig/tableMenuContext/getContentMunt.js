let _contextMenu;
export function setContextMenu(content) {
    _contextMenu = content;
}
export function getContextMenu() {
    if (!_contextMenu) {
        console.error('请先创建ContextMenu实例');
        return null;
    }
    return _contextMenu;
}