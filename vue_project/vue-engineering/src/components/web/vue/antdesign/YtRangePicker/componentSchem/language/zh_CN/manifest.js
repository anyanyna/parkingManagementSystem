import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";

const template = `
  <a-form-item
    ref
    class="webVueAntRangePickerFormItem _$customFormItemClassName$_ _$showLabel$_"
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
          <yt-custom-range-picker
            data-event
            class="webVueAntYtRangePicker _$customClassName$_"
            popupKey="_$popupKey$_ _$popupKeyId$_"
            v-model:value="_$value$_"
            :placeholderStart="_$placeholderStart$_"
            :placeholderEnd="_$placeholderEnd$_"
            :mode="_$mode$_"
            :startDate="_$startDate$_"
            :endDate="_$endDate$_"
            :disabledDates="_$disabledDates$_"
            :allowClear="_$allowClear$_"
            :disabled="_$disabled$_"
          />
        </a-config-provider>
      </yt-placeholder-item>
      <yt-placeholder-item #key2 isOnlyPorduce='true'>
        <yt-custom-range-picker
          data-event
          class="webVueAntYtRangePicker _$customClassName$_"
          popupKey="_$popupKey$_ _$popupKeyId$_"
          v-model:value="_$value$_"
          :placeholderStart="_$placeholderStart$_"
          :placeholderEnd="_$placeholderEnd$_"
          :mode="_$mode$_"
          :startDate="_$startDate$_"
          :endDate="_$endDate$_"
          :disabledDates="_$disabledDates$_"
          :allowClear="_$allowClear$_"
          :disabled="_$disabled$_"
        />
      </yt-placeholder-item>
    </yt-placeholder>
  </a-form-item>
`
export default {
  template: template,
  clazzType: 'YtRangePicker',
  editConfig: {
    getRuntimeConfig,
    getTemplate:()=>template,
    classKeys: ['class', ':class', 'v-bind:class', 'popupKey']
  }
}