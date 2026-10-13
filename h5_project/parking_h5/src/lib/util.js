const util = {
	formatTime(time) {
		if (typeof time !== 'number' || time < 0) {
			return time
		}

		var hour = parseInt(time / 3600)
		time = time % 3600
		var minute = parseInt(time / 60)
		time = time % 60
		var second = time

		return ([hour, minute, second]).map(function(n) {
			n = n.toString()
			return n[1] ? n : '0' + n
		}).join(':')
	},

	formatLocation(longitude, latitude) {
		if (typeof longitude === 'string' && typeof latitude === 'string') {
			longitude = parseFloat(longitude)
			latitude = parseFloat(latitude)
		}

		longitude = longitude.toFixed(2)
		latitude = latitude.toFixed(2)

		return {
			longitude: longitude.toString().split('.'),
			latitude: latitude.toString().split('.')
		}
	},


	humanize: function(milliseconds) {
		var humanize = '';
		for (var key in this.UNITS) {
			if (milliseconds >= this.UNITS[key]) {
				humanize = Math.floor(milliseconds / this.UNITS[key]) + key + '前';
				break;
			}
		}
		return humanize || '刚刚';
	},
	format: function(dateStr) {
		var date = this.parse(dateStr)
		var diff = Date.now() - date.getTime();
		if (diff < this.UNITS['天']) {
			return this.humanize(diff);
		}
		var _format = function(number) {
			return (number < 10 ? ('0' + number) : number);
		};
		return date.getFullYear() + '/' + _format(date.getMonth() + 1) + '/' + _format(date.getDay()) + '-' +
			_format(date.getHours()) + ':' + _format(date.getMinutes());
	},
	parse: function(str) { //将"yyyy-mm-dd HH:MM:ss"格式的字符串，转化为一个Date对象
		var a = str.split(/[^0-9]/);
		return new Date(a[0], a[1] - 1, a[2], a[3], a[4], a[5]);
	},

	throttle(fn, gapTime) {
		if (gapTime == null || gapTime == undefined) {
			gapTime = 1500
		}

		let _lastTime = null

		// 返回新的函数
		return function() {
			let _nowTime = +new Date()
			if (_nowTime - _lastTime > gapTime || !_lastTime) {
				fn.apply(this, arguments) //将this和参数传给原函数
				_lastTime = _nowTime
			}
		}
	},

	isPhone(phone) {
		var myreg = /^[1][0-9]{10}$/
		if (!myreg.test(phone)) {
			return false
		} else {
			return true
		}
	},
	// 判断身份证是否正确
	isIdCard(IdCard) {
		let myreg =
			/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/
		if (!myreg.test(IdCard)) {
			return false
		} else {
			return true
		}
	},
	// 判断出生在1965-2004之间 16-55岁
	idCardAge(IdCard) {
		let year = `${IdCard[6]}${IdCard[7]}${IdCard[8]}${IdCard[9]}`
		if (year >= 1965 && year <= 2004) {
			return true
		} else {
			return false
		}
	},

	htmlFormat(string) {
		let l = string.split('<img')
		string = l.map((i, index) => {
			if (index >= 0 && index < l.length - 1) {
				i += '<img width="100%" height="100%"'
			}
			return i
		}).join('')
		return string.split('height="100"').join('')
	},

	// 数组转树结构
	baseToTree(data, key) {
		let result = []
		if (!Array.isArray(data)) {
			return result
		}
		data.forEach((item) => {
			delete item.children
		})
		let map = {}
		data.forEach((item) => {
			map[item.code] = item
			// map[item.importButaoId] = item
		})
		data.forEach((item) => {
			let parent
			if (key) {
				parent = map[item[key]]
			} else {
				parent = map[item.parent_code]
			}

			// let parent = map[item.importButaoPid]
			if (parent) {
				;
				(parent.children || (parent.children = [])).push(item)
			} else {
				result.push(item)
			}
		})
		return result
	},

	// 数组转树结构 可传 子key 父key
	baseToTreeKey(data, key, pKey) {
		let result = []
		if (!Array.isArray(data)) {
			return result
		}
		data.forEach((item) => {
			delete item.children
		})
		let map = {}
		data.forEach((item) => {
			map[item[key]] = item
			// map[item.code] = item
		})
		data.forEach((item) => {

			let parent = map[item[pKey]]
			// let parent = map[item.parent_code]
			if (parent) {
				;
				(parent.children || (parent.children = [])).push(item)
			} else {
				result.push(item)
			}
		})
		return result
	},

	// 数组转树结构 父子字段不同
	baseToTrees(data) {
		let result = []
		if (!Array.isArray(data)) {
			return result
		}
		data.forEach((item) => {
			delete item.children
		})
		let map = {}
		data.forEach((item) => {
			map[item.key] = item
			// map[item.orgcode] = item
			// map[item.importButaoId] = item
		})
		data.forEach((item) => {
			let parent = map[item.p_key]
			// let parent = map[item.orgparentcode]
			// let parent = map[item.importButaoPid]
			if (parent) {
				;
				(parent.children || (parent.children = [])).push(item)
			} else {
				result.push(item)
			}
		})
		return result
	},

	// 树形结构数据 每一个层级 添加 level 标识 从 1 开始
	arrayTreeAddLevel(array, levelName = 'level', childrenName = 'children') {
		if (!Array.isArray(array)) return []
		const recursive = (array, level = 0) => {
			level++
			return array.map(v => {
				v[levelName] = level
				const child = v[childrenName]
				if (child && child.length) recursive(child, level)
				return v
			})
		}
		return recursive(array)
	},

	// 获取当前时间 年月日时分秒
	getCurrentDateTime() {
		const now = new Date();
		const year = now.getFullYear();
		const month = now.getMonth() + 1; // 月份是从0开始的，所以需要加1
		const day = now.getDate();
		const hours = now.getHours();
		const minutes = now.getMinutes();
		const seconds = now.getSeconds();

		// 返回格式化的时间字符串
		return `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')} ${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
	},

	// 获取当前时间 年月日
	getCurrentDate() {
		const now = new Date();
		const year = now.getFullYear();
		const month = now.getMonth() + 1; // 月份是从0开始的，所以需要加1
		const day = now.getDate();

		// 返回格式化的时间字符串
		return `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}`;
	},

	// 捷码api 参数转化
	getApiParams(data, childParams) {
		// data: 接口参数对象 key value
		// childParams: 接口参数数组结构
		if (data && Object.keys(data).length !== 0) {
			for (let i in childParams) {
				for (let j in data) {
					if (childParams[i].paramKey === j) {
						childParams[i].value = data[j]
					}
				}
			}
			return JSON.stringify(childParams)
		} else {
			return null
		}
	},

	// 树转数组 (树结构数组)
	treeListToArray(treeData) {
		const result = [];
		const flatten = (node) => {
			result.push(node);
			if (node.children) {
				for (const child of node.children) {
					flatten(child);
				}
			}
		}
		for (const node of treeData) {
			flatten(node);
		}
		return result;
	},

	// 树转数组 (树结构对象)
	treeToArray(tree) {
		const result = [];

		function traverse(node) {
			result.push(node);
			if (node.children) {
				node.children.forEach(traverse);
				// delete node.children
			}
		}

		traverse(tree);
		return result;
	}
}

export default util