import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
const template = `
<a-form-item
    ref
    class="webVueAntTimePickerFormItem _$customFormItemClassName$_ _$showLabel$_"
    name="_$value$_"
    :colon="false"
    :rules="_$rules$_">
      <template #label>
        <div class="label-content">
          <span class="ant-form-item-content" v-html="_$labelName$_"></span>
        </div>
      </template>
      <yt-placeholder #timePickerLocale>
        <yt-placeholder-item #key1 isOnlyEdit='true'>
          <a-config-provider :locale='getLangConfig()'>
            <yt-custom-time-picker
              data-event
              class="webVueAntYtTimePicker _$customClassName$_"
              popupKey="_$popupKey$_ _$popupKeyId$__"
              v-model:value="_$value$_"
              :placeholder="_$placeholder$_"
              :use12Hours="_$use12Hours$_"
              :format="_$format$_"
              :step="_$step$_"
              :startTime="_$startTime$_"
              :endTime="_$endTime$_"
              :showNow="_$showNow$_"
              :allowClear="_$allowClear$_"
              :disabled="_$disabled$_"
            />
            </a-config-provider>
        </yt-placeholder-item>
        <yt-placeholder-item #key2 isOnlyPorduce='true'>
          <yt-custom-time-picker
            data-event
            class="webVueAntYtTimePicker _$customClassName$_"
            popupKey="_$popupKey$_ _$popupKeyId$__"
            v-model:value="_$value$_"
            :placeholder="_$placeholder$_"
            :use12Hours="_$use12Hours$_"
            :format="_$format$_"
            :step="_$step$_"
            :startTime="_$startTime$_"
            :endTime="_$endTime$_"
            :showNow="_$showNow$_"
            :allowClear="_$allowClear$_"
            :disabled="_$disabled$_"
          />
        </yt-placeholder-item>
      </yt-placeholder>
    </a-form-item>

`
export default {
  template: template,
  clazzType: 'YtTimePicker',
  editConfig: {
    getRuntimeConfig,
    getTemplate:()=>template,
    classKeys: ['class', ':class', 'v-bind:class', 'popupKey']
  }
}