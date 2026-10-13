<template>
    <yt-grid previewType="FixedWH" width="1920" height="1080" background="#fff">

        <yt-grid-item fixedSize="selfAdaption" :isShow="isShow1" :isUseContentWH="false" id="yt-v4lw6lxww0stg"
            underFaceIds="undefined" comWidth="" comHeight="" gridColumnStart="736" gridColumnEnd="1594"
            gridRowStart="224" gridRowEnd="756" zIndex="1" minHeight="unset" marginTop="unset" marginBottom="unset"
            marginLeft="unset" marginRight="unset">
            <yt-custom-modal ref='ref1' class='webVueAntYtModal webVueAntYtModalStyle-2iokw webVueAntYtModalStyle'
                :visible='true' :maskBg='"rgba(0, 0, 0, 0.45)"'>
                <template #content>

                    <div
                        style="display:grid;width:858px;height:532px;grid-template-columns: repeat(auto-fill, 1px);grid-template-rows: repeat(auto-fill, 1px);position: relative;">

                        <yt-grid-item fixedSize="selfAdaption" :isShow="isShow2" :isUseContentWH="false"
                            id="yt-jchh4lxww0yx6" underFaceIds="undefined" comWidth="" comHeight=""
                            gridColumnStart="417" gridColumnEnd="457" gridRowStart="92" gridRowEnd="120" zIndex="1"
                            minHeight="unset" marginTop="unset" marginBottom="unset" marginLeft="unset"
                            marginRight="unset">
                            <span ref='ref2' class='webVueAntYtSpan webVueAntYtSpanStyle-f2t3q webVueAntYtSpanStyle'
                                type='"123".bacs'>
                                {{ content1 }}
                            </span>
                        </yt-grid-item>


                        <yt-grid-item fixedSize="selfAdaption" :isShow="isShow3" :isUseContentWH="false"
                            id="yt-7au8ilxww109b" underFaceIds="undefined" comWidth="" comHeight=""
                            gridColumnStart="236" gridColumnEnd="316" gridRowStart="367" gridRowEnd="397" zIndex="2"
                            minHeight="unset" marginTop="unset" marginBottom="unset" marginLeft="unset"
                            marginRight="unset">
                            <a-button ref='ref3'
                                class='webVueAntButton webVueAntYtButtonStyle-fcc46 webVueAntYtButtonStyle'
                                :disabled='disabled1'>
                                按钮
                            </a-button>
                        </yt-grid-item>

                    </div>

                </template>
            </yt-custom-modal>
        </yt-grid-item>

    </yt-grid>
</template>

<script>
export default {
    data() {
        return (({ isShow1: true, content1: "文本", isShow2: true, stateKey1: "", disabled1: false, isShow3: true }));
    },
    computed:{
        // 动态面板下面只有组件，组件有状态
        spanState1: ()=>{
            switch(this.selectKey1){
                case '1':
                    return {
                    // 以下数据是-------根据动态面板保存下来的组件选中状态去拿组件属性
                    "statusId": '1',
                    "label": "状态1",
                    content: "文本1",
                }
                case '2':
                    return {
                    // 以下数据是-------根据动态面板保存下来的组件选中状态去拿组件属性
                    "statusId": '2',
                    "label": "状态2",
                    content: "文本2"
                }
                default:
                    return {}
            }
        }
    }
}
</script>