import getRuntimeConfig from "../../runtimeConfig/getRuntimeConfig";
export default {
  template: `
    <a-form-item
      ref
      class="webVueAntInputPasswordFormItem _$customFormItemClassName$_ _$showLabel$_"
      name="_$value$_"
      :colon="false"
      :rules="_$rules$_">
      <template #label>
        <div class="label-content">
          <span class="ant-form-item-content" v-html="_$labelName$_"></span>
        </div>
      </template>
      <yt-custom-input-password
        data-event
        class="webVueAntInputPassword _$customClassName$_"
        v-model:value="_$value$_"
        :placeholder="_$placeholder$_"
        :isMd5Value="_$isMd5Value$_"
        :maxlength="_$maxlength$_"
        :allowClear="_$allowClear$_"
        :visibilityToggle="_$visibilityToggle$_"
        :disabled="_$disabled$_"
      />
    </a-form-item>
  `,
  clazzType: 'YtInputPassword',
  getRuntimeConfig
}