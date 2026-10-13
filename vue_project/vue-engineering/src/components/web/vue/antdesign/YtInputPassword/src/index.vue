<template>
    <a-input-password
        class="ytCustomInputPassword"
        v-model:value="showValue"
        :disabled="disabled"
        :maxLength="maxLength"
        :allowClear="allowClear"
        :placeholder="placeholder"
        :visibilityToggle="visibilityToggle"
        @change="change"
    ></a-input-password>
</template>

<script>
import { ref, watch, onMounted } from 'vue'
import SparkMD5 from 'spark-md5';
export default {
    props: {
        value: {
            type: String,
            default: ''
        },
        isMd5Value: {
            type: Boolean,
            default: true
        },
        disabled: {
            type: Boolean
        },
        maxLength: {
            type: Number
        },
        allowClear: {
            type: Boolean
        },
        placeholder: {
            type: String,
            default: ''
        },
        visibilityToggle: {
            type: Boolean,
            default: true
        }
    },
    emits: ['update:value', 'change', 'input'],
    setup(props, { emit }) {
        const container = ref(null)
        const showValue = ref(props.value)
        const disabled = ref(props.disabled)
        const maxLength = ref(props.maxLength)
        const placeholder = ref(props.placeholder)
        const allowClear = ref(props.allowClear)
        const visibilityToggle = ref(props.visibilityToggle)
        const changeMd5Value = function (value) {
            if(props.isMd5Value) {
                emit('update:value', SparkMD5.hash(value))
            }
        }
        const change = function (e) {
            const newValue = e.target.value
            showValue.value = newValue
            if(props.isMd5Value && newValue) {
                emit('update:value', SparkMD5.hash(newValue))
            }else {
                emit('update:value', newValue)
            }
            emit('change',e)
            emit('input',e)
        }
        watch(
            () => props.value,
            (newVal) => {
                if(newVal !== showValue.value && newVal !== SparkMD5.hash(showValue.value)) {
                    changeMd5Value(newVal)
                    showValue.value = newVal
                }
        })
        onMounted(() => {
            changeMd5Value(showValue.value)
        })
        return {
            showValue,
            disabled,
            maxLength,
            placeholder,
            allowClear,
            visibilityToggle,
            change
        }
    },
    name: "yt-custom-input-password"
}
</script>
<style type='text/css' lang="less">
.ytCustomInputPassword {
    width: 100%;
    height: 100%
}
</style>