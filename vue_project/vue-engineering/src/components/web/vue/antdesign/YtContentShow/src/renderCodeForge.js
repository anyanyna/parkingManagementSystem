
import resetGetRuntimeonfig from './resertGetRuntimeonfig'
const promiseArr = []
//Freelayout.utils.getFreeLayout()
function getCurrentFreelayoutIns(Freelayout){
    return Freelayout.utils.getFreeLayout()
}
export default function renderPage(pageInfo,componentsStore,currentComId,bus){
    const componentInfo = pageInfo.componentInfo ? JSON.parse(pageInfo.componentInfo) : []
    Object.keys(componentInfo).forEach(key => {
        let comInfo = componentInfo[key]
        const { _supportLang, _supportTheme, _hasCustomStyle, _custom } = componentsStore.getSupportInfo(comInfo.platform, comInfo.type, comInfo.uiType, comInfo.clazzType);
        comInfo.supportLang = _supportLang;
        comInfo.supportTheme = _supportTheme;
        comInfo.hasCustomStyle = _hasCustomStyle;
        comInfo.custom = _custom
    })
    const resource = window.parent.$$resource
    //根据页面信息里的组件classType去加载组件
    promiseArr.push(resource.loadComponents(Object.values(componentInfo)))
    Promise.all(promiseArr).then(async (res1) => {
        const frontEndEcho = pageInfo.frontEndEcho ? { ...JSON.parse(pageInfo.frontEndEcho), groups: JSON.parse(pageInfo.layerInfoEcho) } : {}
        let promises = []
        if (frontEndEcho.componentInfo) {
            promises = Object.keys(frontEndEcho.componentInfo).map(async id => {
                const { platform, type, uiType, clazzType } = frontEndEcho.componentInfo[id];
                const defaultValue = await resource.getResource(platform, type, uiType, clazzType, 'defaultValue');
                const dataValue = await resource.getResource(platform, type, uiType, clazzType, 'dataValue');
                const formDataVars = await resource.getResource(platform, type, uiType, clazzType, 'formDataVars');
                const statesVars = await resource.getResource(platform, type, uiType, clazzType, 'statesVars');
                frontEndEcho.componentInfo[id].defaultValue = defaultValue;
                frontEndEcho.componentInfo[id].dataValue = dataValue;
                frontEndEcho.componentInfo[id].formDataVars = formDataVars;
                frontEndEcho.componentInfo[id].statesVars = statesVars;
                const {getRuntimeConfig,editConfig} = resource.getResource(platform, type, uiType, clazzType, 'manifest');
                frontEndEcho.componentInfo[id].getRuntimeConfig = resetGetRuntimeonfig(getRuntimeConfig,bus);
                frontEndEcho.componentInfo[id].editConfig = editConfig
            });
        }
        await Promise.all(promises);
        // 需要根据platForm来决定是哪个类
        const freelayout = getCurrentFreelayoutIns(window.parent.$$Freelayout)
        const RunTimeAdapter = freelayout.getRunTimeAdapter()
        // 获取组件div
        const contentDom = document.getElementById('webVueAntContentShow');
        const _runTimeAdapter = new RunTimeAdapter({ ...frontEndEcho, contentDom: contentDom, data: frontEndEcho.dataFunction },freelayout.constructor.getRunTimeClazz(),{ pTag: "", parentId: null })
        _runTimeAdapter.disabledRegisterYtTemplate()
        await _runTimeAdapter.render()
        // 找到class名称是yt-codeForge-moveable的dom,删掉这个calss名称，因为加上的话会导致点击组件报错
        const elementsWithClass = contentDom.querySelectorAll('.yt-codeForge-moveable');
        elementsWithClass.forEach((element) => {
            element.classList.remove('yt-codeForge-moveable');
        });
    })
}