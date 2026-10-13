<template>
    <div class="webVueAntGrid" :style="computedStyles">
        <slot></slot>
    </div>
</template>
<script>
import i18next from 'i18next';
import getParentDomWH from './getParentDomWH'
import { createLocaleLang } from '../../../../../../shared/createLocaleLang'
// console.log(window.__$yt_theme, window.__$yt_lang)
i18next.init({
    lng: window.__$yt_lang, // 默认语言
    resources: createLocaleLang(import.meta.globEager('./locales/**/data.json'))
});
export default {
    data() {
        return {
            content: i18next.t('content'),
            computedStyles: {
                'width': '100%',
                'height': '100%',
                'grid-template-columns': 'repeat(auto-fill, 1%)',
                'grid-template-rows': 'repeat(auto-fill, 1%)',
                "background": ""
            }
        }
    },
    props: {
        previewType: {
            type: String,
            default: 'FixedWH'
        },
        width: {
            type: String || Number,
            default : '1920'
        },
        height: {
            type: String || Number,
            default : '1080'
        },
        background: {
            type: String,
            default : '#fff'
        }
    },
    name: "yt-grid",
    watch: {
        previewType: {
            handler(newValue, oldValue) {
                switch (newValue) {
                    case 'FixedWH':
                        this.computedStyles = {
                            'width': this.width + 'px',
                            'height': this.height + 'px',
                            'grid-template-columns': `repeat(${this.width}, 1fr)`,
                            'grid-template-rows': `repeat(${this.height}, 1fr)`,
                            "background": this.background
                        };
                        break;
                    case 'AdaptiveWH':
                        this.computedStyles = {
                            'width': this.width.indexOf('%')>0 ? this.width : '100%',
                            'height': this.height.indexOf('%')>0 ? this.height : '100%',
                            'grid-template-columns': 'repeat(auto-fill, 1%)',
                            'grid-template-rows': 'repeat(auto-fill, 1%)',
                            "background": this.background
                        };
                        break;
                    case 'FixedHAdaptiveW':
                        this.computedStyles = {
                            'width': this.width.indexOf('%')>0 ? this.width : '100%',
                            'height': this.height + 'px',
                            'grid-template-columns': 'repeat(auto-fill, 1%)',
                            'grid-template-rows': `repeat(${this.height}, 1fr)`,
                            "background": this.background
                        };
                        break;
                    case 'FixedWAdaptiveH':
                        this.computedStyles = {
                            'width': this.width + 'px',
                            'height': this.height.indexOf('%')>0 ? this.height : '100%',
                            'grid-template-columns': `repeat(${this.width}, 1fr)`,
                            'grid-template-rows': 'repeat(auto-fill, 1%)',
                            "background": this.background
                        };
                        break;
                    case 'FitScreen':
                        const { width, height } = getParentDomWH(this.parentId)
                        //宽度缩放比例 = 屏幕宽度 / 页面宽度
                        const widthRate = width / this.width
                        //宽度缩放比例 = 屏幕宽度 / 页面宽度
                        const heightRate = height / this.height
                        let realHeight = ''
                        let realWidth = ''
                        //取较小的缩放比例，即页面内容需要的比例进行缩放。
                        if (widthRate < heightRate) {
                            realWidth = this.width * widthRate
                            realHeight = this.height * widthRate
                        } else {
                            realWidth = this.width * heightRate
                            realHeight = this.height * heightRate
                        }
                        this.computedStyles = {
                            // 需要算出具体的值
                            'width': realWidth + 'px',
                            'height': realHeight + 'px',
                            'grid-template-columns': 'repeat(auto-fill, 1%)',
                            'grid-template-rows': 'repeat(auto-fill, 1%)',
                            "background": this.background
                        };
                        break;
                }
            },
            immediate: true
        },
        background: {
            handler(newValue, oldValue) {
                this.computedStyles.background = newValue
            },
            immediate: true
        }
    }
};
</script>
<style>
.webVueAntGrid {
    display: grid;
    position: relative;
}
</style>