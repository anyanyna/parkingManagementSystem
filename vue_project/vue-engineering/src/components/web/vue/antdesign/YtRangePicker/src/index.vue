<template>
    <a-range-picker class="ytCustomRangePicker" v-model:value="truthValue"
        :dropdownClassName="'dropdownClassName ' + popupKey" :placeholder="[placeholderStart, placeholderEnd]"
        :allowClear="allowClear" :disabled="disabled" :disabled-date="disabledDate" :disabled-time="disabledDateTime"
        :format="valueFormat" :valueFormat="valueFormat" :mode="trueMode" :picker="pickerMode" :showTime="showTime"
        @change="change" @panelChange="handlePanelChange" />
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
            type: Array,
            default: []
        },
        placeholderStart: {
            type: String,
            default: "开始日期"
        },
        placeholderEnd: {
            type: String,
            default: "结束日期"
        },
        mode: {
            type: String,
            default: 'day'
        },
        startDate: {
            type: String,
        },
        endDate: {
            type: String,
        },
        disabledDates: {
            type: Array,
            default: []
        },
        allowClear: {
            type: Boolean,
            default: false
        },
        disabled: {
            type: Boolean,
            default: false
        },
    },
    emits: ['update:value', 'change', 'panelChange'],

    setup(props, { emit }) {
        watch(
            () => props.value,
            (newValue) => {
                if ((newValue && newValue.length === 0) || !newValue) {
                    truthValue.value = []
                    return
                }
                if (newValue && newValue[0] && newValue[1]) {
                    truthValue.value = [dayjs(newValue[0]).format(valueFormat.value), dayjs(newValue[1]).format(valueFormat.value)]
                }
            },
            { deep: true }
        );
        const change = function (value) {
            emit('update:value', value)
            emit('change', value)
        }
        const handlePanelChange = function (value, mode) {
            emit('panelChange', value, mode)
        }
        const valueFormat = computed(() => {
            switch (props.mode) {
                default: return 'YYYY-MM-DD HH:mm:ss'
                case 'second': return 'YYYY-MM-DD HH:mm:ss'
                case 'minute': return 'YYYY-MM-DD HH:mm'
                case 'hour': return 'YYYY-MM-DD HH'
                case 'day': return 'YYYY-MM-DD'
                case 'week': return 'YYYY-wo'
                case 'month': return 'YYYY-MM'
                case 'year': return 'YYYY'
            }
        })
        const trueMode = computed(() => {
            switch (props.mode) {
                default: return undefined
                case 'month': return ['month', 'month']
                case 'year': return ['year', 'year']
            }
        })
        const pickerMode = computed(() => {
            switch (props.mode) {
                default: return undefined
                case 'week': return 'week'
                case 'month': return 'month'
                case 'year': return 'year'
            }
        })
        const showTime = computed(() => {
            if (['second', 'minute', 'hour'].includes(props.mode)) {
                return true
            }
            return false
        })
        const truthValue = ref([])
        if (props.value && props.value[0] && props.value[1]) {
            truthValue.value = [dayjs(props.value[0]).format(valueFormat.value), dayjs(props.value[1]).format(valueFormat.value)]
        }
        const disabledDate = (current) => {
            const startDate = dayjs(props.startDate)
            const endDate = dayjs(props.endDate)
            const currentDate = dayjs(current)
            let result = false
            if (!current) {
                result = true
            }
            if (props.startDate && currentDate.isBefore(startDate)) {
                result = true
            }
            if (props.endDate && endDate.isBefore(currentDate)) {
                result = true
            }
            if (props.disabledDates && props.disabledDates.length) {
                let matchIndex = props.disabledDates.findIndex(i => {
                    return dayjs(i).isSame(currentDate, 'day')
                })
                if (matchIndex !== -1) {
                    result = true
                }
            }
            return result
        }
        const range = ({ start, end }) => {
            const result = [];
            for (let i = start; i < end; i++) {
                result.push(i);
            }
            return result;
        }
        const matchTime = (range, currentDate, endDate, startDate, startTime, endTime, type, max) => {
            let newRange = {
                start: 0, end: 0
            }
            let otherRange = {
                start: 0, end: 0
            }
            if (currentDate.isSame(endDate, type) && currentDate.isSame(startDate, type)) {
                newRange.end = startTime
                otherRange.start = endTime + 1
                otherRange.end = max
            } else if (currentDate.isSame(startDate, type)) {
                newRange.end = startTime
                newRange.start = 0
            } else if (currentDate.isSame(endDate, type)) {
                newRange.start = endTime + 1
                newRange.end = max
            }
            return { range: JSON.parse(JSON.stringify(newRange)), otherRange: JSON.parse(JSON.stringify(otherRange)) }
        }
        const disabledDateTime = (date, type) => {
            if (!showTime) {
                return
            }
            const currentDate = dayjs(date)
            const endDate = props.endDate && dayjs(props.endDate) || dayjs(null)
            const startDate = props.startDate && dayjs(props.startDate) || dayjs(null)
            const startTime = startDate
            const endTime = endDate
            const hour = isNaN(startTime.hour()) ? 0 : startTime.hour()
            const hour2 = isNaN(endTime.hour()) ? 24 : endTime.hour()
            const minute = isNaN(startTime.minute()) ? 0 : startTime.minute()
            const minute2 = isNaN(endTime.minute()) ? 59 : endTime.minute()
            const second = isNaN(startTime.second()) ? 0 : startTime.second()
            const second2 = isNaN(endTime.second()) ? 59 : endTime.second()

            let { range: hourRange, otherRange: otherHourRange } = matchTime({ start: 0, end: 24 }, currentDate, endDate, startDate, hour, hour2, 'day', 24)
            let { range: minutesRange, otherRange: otherMinutesRange } = matchTime({ start: 0, end: 60 }, currentDate, endDate, startDate, minute, minute2, 'hour', 60)
            let { range: secondsRange, otherRange: otherSecondsRange } = matchTime({ start: 0, end: 60 }, currentDate, endDate, startDate, second, second2, 'minute', 60)

            if (currentDate.isBefore(startDate, 'hour') || currentDate.isAfter(endDate, 'hour')) {
                hourRange.end = 24
                minutesRange.end = 60
                secondsRange.end = 60
            } else if (currentDate.isBefore(startDate, 'minute') || currentDate.isAfter(endDate, 'minute')) {
                minutesRange.end = 60
                secondsRange.end = 60
            }

            return {
                disabledHours: () => [...range(hourRange), ...range(otherHourRange)],
                disabledMinutes: () => [...range(minutesRange), ...range(otherMinutesRange)],
                disabledSeconds: () => [...range(secondsRange), ...range(otherSecondsRange)],
            }
        }
        return {
            showTime,
            truthValue,
            disabledDate,
            disabledDateTime,
            valueFormat,
            trueMode,
            pickerMode,
            change,
            handlePanelChange
        }
    },
    name: "yt-custom-range-picker"
}
</script>
<style type='text/css' lang="less">
.ytCustomRangePicker {
    width: 100%;
    height: 100%
}
</style>