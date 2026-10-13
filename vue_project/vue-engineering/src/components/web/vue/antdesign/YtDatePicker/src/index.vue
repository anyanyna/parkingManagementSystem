<template>
    <a-date-picker
        class="ytCustomDatePicker"
        v-model:value="truthValue"
        :dropdownClassName="'dropdownClassName '+ popupKey"
        :showToday="showToday"
        :placeholder="placeholder"
        :allowClear="allowClear"
        :disabled="disabled"
        :disabled-date="disabledDate"
        :disabled-time="disabledDateTime"
        :format="valueFormat"
        :valueFormat="valueFormat"
        :picker="trueMode"
        :showTime="showTime"
        @change="change"
        @openChange="handleOpenChange"
        @panelChange="handlePanelChange"
  
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
            default: ''
        },
        mode: {
            type:String,
            default: 'day'
        },
        startDate: {
            type:String,
            default: ''
        },
        endDate: {
            type:String,
            default: ''
        },
        disabledDates: {
            type:Array,
            default: []
        },
        showToday: {
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
    emits: ['update:value', 'change', 'openChange', 'panelChange'],
    setup(props, { emit }) {
        const handlePanelChange = function (value, mode) {
            emit('panelChange', value, mode)
        }
        const handleOpenChange = function (status) {
            emit('openChange', status)
        }
        const change = function (value) {
            emit('update:value', value)
            emit('change', value)
        }
        const valueFormat = computed(()=> {
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
        const trueMode = computed(()=> {
          switch (props.mode) {
            default: return undefined
            case 'month': return 'month'
            case 'year': return 'year'
          }
        })
        const showTime = computed(()=> {
            if (['second','minute','hour'].includes(props.mode)) {
              return true
            }
            return false
        })
        const startDate = dayjs(props.startDate)
        const endDate = dayjs(props.endDate)
        const hour = isNaN(startDate.hour()) ? 0 : startDate.hour()
        const hour2 = isNaN(endDate.hour()) ? 24 : endDate.hour()
        const minute = isNaN(startDate.minute()) ? 0 : startDate.minute()
        const minute2 = isNaN(endDate.minute()) ? 59 : endDate.minute()
        const second = isNaN(startDate.second()) ? 0 : startDate.second()
        const second2 = isNaN(endDate.second()) ? 59 : endDate.second()
        const disabledDate = (current) => {
            const startDate = dayjs(props.startDate)
            const endDate = dayjs(props.endDate)
            const currentDate = dayjs(current)
            let result = false
            if(!current) {
                result =  true
            }
            if( !isNaN(startDate) && currentDate.isBefore(startDate, 'day') ) {
                result =  true
            }
            if( !isNaN(endDate) && endDate.isBefore(currentDate, 'day')) {
                result =  true
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
        const range = ({start, end}) => {
            const result = [];
            for (let i = start; i < end; i++) {
                result.push(i);
            }
            return result;
        }
        const matchTime = (range, currentDate, endDate, startDate, startTime, endTime,  type, max) => {
            let newRange = {
                start:0, end:0
            }
            let otherRange = {
                start: 0,
                end: 0
            }
            if (currentDate.isSame(endDate, type) && currentDate.isSame(startDate, type)) {
                newRange.end = startTime
                otherRange.start = endTime + 1
                otherRange.end = max
            }else if ( currentDate.isSame(startDate, type)) {
                newRange.end = startTime
                newRange.start = 0
            }else if (currentDate.isSame(endDate, type)) {
                newRange.start = endTime + 1
                newRange.end = max
            }
            return {range:JSON.parse(JSON.stringify(newRange)), otherRange: JSON.parse(JSON.stringify(otherRange))}
        }
        const disabledDateTime = (date) => {
            if(!showTime) {
                return
            }
            const currentDate = dayjs(date)
            
            let {range: hourRange, otherRange: otherHourRange } = matchTime({ start:0, end:24 }, currentDate, endDate, startDate, hour, hour2, 'day', 24)
            let {range: minutesRange, otherRange: otherMinutesRange } = matchTime({ start:0, end:60 }, currentDate, endDate, startDate, minute, minute2,'hour', 60)
            let {range: secondsRange, otherRange :otherSecondsRange } = matchTime({ start:0, end:60 }, currentDate, endDate, startDate, second, second2,'minute', 60)
        
            return {
                disabledHours: () => [...range(hourRange), ...range(otherHourRange)] ,
                disabledMinutes: () => [...range(minutesRange), ...range(otherMinutesRange)],
                disabledSeconds: () =>  [...range(secondsRange), ...range(otherSecondsRange)],
            }
        }
        const truthValue = ref()
        if(props.value) {
            truthValue.value= dayjs(props.value).format(valueFormat.value)
        }
        return {
            truthValue,
            disabledDate,
            disabledDateTime,
            valueFormat,
            trueMode,
            showTime,
            change,
            handleOpenChange,
            handlePanelChange
        }
    },
    name: "yt-custom-date-piker"
}
</script>
<style type='text/css' lang="less">
.ytCustomDatePicker {
    width: 100%;
    height: 100%
}
</style>