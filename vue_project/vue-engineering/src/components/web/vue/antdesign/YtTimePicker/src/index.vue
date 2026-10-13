<template>
    <a-time-picker
        class="ytCustomTimePicker"
        v-model:value="truthValue"
        :popupClassName="'dropdownClassName '+ popupKey"
        :placeholder="placeholder"
        :use12Hours="use12Hours"
        :valueFormat="truthFormat"
        :format="truthFormat"
        :hourStep="step.hourStep || 1"
        :minuteStep="step.minuteStep || 1"
        :secondStep="step.secondStep || 1"
        :showNow="showNow"
        :allowClear="allowClear"
        :disabled="disabled"
        :disabledHours="disabledHours"
        :disabledMinutes="disabledMinutes"
        :disabledSeconds="disabledSeconds"
        @change="change"
    />
</template>

<script>
import { ref, watch, onMounted, computed } from 'vue'
import dayjs from 'dayjs'
export default {
    props: {
        popupKey: {
            type: String,
            default: ''
        },
        value: {
            type: String,
            default: ''
        },
        placeholder: {
            type:String,
        },
        use12Hours: {
            type:Boolean
        },
        format: {
            type:String,
            default: 'HH:mm:ss'
        },
        step: {
            type:Object,
            default: {
                hourStep: 1,
                minuteStep: 1,
                hourStep: 1,
            }
        },
        startTime: {
            type:String,
            default: ''
        },
        endTime: {
            type:String,
            default: ''
        },
        showNow: {
            type:Boolean,
            default: true
        },
        allowClear: {
            type:Boolean
        },
        disabled: {
            type:Boolean
        },
    },
    emits: ['update:value', 'change'],
    setup(props, { emit }) {
        const truthValue = ref(props.value)
        const valueObj = ref(dayjs(new Date().toISOString().split('T')[0] + 'T' + props.value))
        const startTime = props.startTime ? dayjs(new Date().toISOString().split('T')[0] + 'T' + props.startTime):dayjs(null)
        const endTime = props.endTime ? dayjs(new Date().toISOString().split('T')[0] + 'T' + props.endTime):dayjs(null)
        const hour = isNaN(startTime.hour()) ? 0 : startTime.hour()
        const hour2 = isNaN(endTime.hour()) ? 24 : endTime.hour()
        const minute = isNaN(startTime.minute()) ? 0 : startTime.minute()
        const minute2 = isNaN(endTime.minute()) ? 59 : endTime.minute()
        const second = isNaN(startTime.second()) ? 0 : startTime.second()
        const second2 = isNaN(endTime.second()) ? 59 : endTime.second()
        const disabledHours = function () {
            // let h = props.startTime.split(':')[0]
            let hours = []
            for (let i = 0; i < hour; i++) {
                hours.push(i)
            }
            for (let i = hour2 + 1; i < 24; i++) {
                hours.push(i)
            }
            return hours
        }
        const disabledMinutes = function (selectedHour)  {
            let minutes = []
            if (selectedHour === hour) {
                for (let q = 0; q < minute; q++) {
                    minutes.push(q)
                }
            }
            if (selectedHour === hour2) {
                for (let w = minute2 + 1; w < 60; w++) {
                    minutes.push(w)
                }
            }
            return minutes
        }
        const disabledSeconds = function (selectedHour, selectedMinute){
            let seconds = []
            if (selectedHour === hour && selectedMinute === minute) {
                for (let j = 0; j < second; j++) {
                seconds.push(j)
                }
            } if (selectedHour === hour2 && selectedMinute === minute2) {
                for (let x = second2 + 1; x < 60; x++) {
                seconds.push(x)
                }
            }
            return seconds
        }
        const change = function (val, valstr) {
            valueObj.value = val
            emit('update:value', valstr)
            emit('change', valstr)
        }
        const to12HourFormat = function(time24) {
            let hours = parseInt(time24.split(':')[0], 10);
            const minutes = time24.split(':')[1];
            const seconds = time24.split(':')[2];
            const am_pm = hours >= 12 ? 'pm' : 'am';
            hours = hours % 12;
            hours = hours ? hours : 12; // the hour '0' should be '12'
            const formattedTime = `${hours}:${seconds}:${seconds} ${am_pm}`;
            return formattedTime;
        }
        const truthFormat = computed(() => {
            if( props.use12Hours) {
                const newFormat =  props.format && props.format.replace('HH', 'h') || 'h:mm:ss a'
                return newFormat + ' a'
            }
            return props.format
        })
        onMounted(() => {
            if( props.use12Hours && props.value ) {
                let newVal = to12HourFormat(props.value)
                truthValue.value = newVal
                emit('update:value', newVal)
            }
        })
        return {
            truthValue,
            truthFormat,
            disabledHours,
            disabledMinutes,
            disabledSeconds,
            change
        }
    },
    name: "yt-custom-time-picker"
}
</script>
<style type='text/css' lang="less">
.ytCustomTimePicker {
    width: 100%;
    height: 100%
}
</style>