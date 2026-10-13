/**
 * 闭包函数
 *
 * 防抖：对于短时间内连续触发的事件（滚动事件、表单重复提交、页面resize事件，常见于需要做页面适配的时候），让某个时间期限内，事件处理函数只执行一次。
 * 节流：对于短时间内大量触发同一事件（滚动事件、输入框实时搜索），那么在函数执行一次之后，该函数在指定的时间期限内不再工作，直至过了这段时间才重新生效
 */
// 防抖
export const Debounce = (fn, t) => {
	const delay = t || 500
	let timer
	return function() {
		const args = arguments
		if (timer) {
			clearTimeout(timer)
		}
		const callNow = !timer
		timer = setTimeout(() => {
			timer = null
		}, delay)

		if (callNow) fn.apply(this, args)
	}
}
// 节流 定时器 + 时间戳
export const Throttle = (fn, t) => {
	var timer = null
	var startTime = Date.now()
	return function() {
		// 结束时间
		var curTime = Date.now()
		// 间隔时间 = 延迟的时间 - （结束时间戳 - 开始时间戳）
		var interval = t - (curTime - startTime)
		var th = this
		var args = arguments
		clearTimeout(timer)
		if (interval <= 0) {
			// 证明可以触发了
			fn.apply(th, args)
			// 重新计算开始时间
			startTime = Date.now()
		} else {
			// 继续等待
			timer = setTimeout(fn, interval)
		}
	}
}