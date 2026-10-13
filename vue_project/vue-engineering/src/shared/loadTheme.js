import isDEV from './isDEV'
import {createElement,setAttribute,getElementById,removeElement} from './nativeDom'
import getuuid from './uuid'
import {setThemeIns} from './getJsThemeVar'

export function loadCss(href) {
    if(href){
        const id = href.replaceAll('/','-')
        let link = document.createElement("link");  
        link.type = "text/css";  
        link.rel = "stylesheet";  
        link.href = href;
        link.id = id;
        const currentElement = document.getElementById(id)
            if(currentElement) {
                currentElement.remove()
            }
            document.head.appendChild(link)
    }
}