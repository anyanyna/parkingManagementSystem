const Vfilters = {
	toMoney(value) {
		if (!isNaN(value * 1)) {
			var intPart = Number(value).toFixed(0) // 获取整数部分
			var intPartFormat = intPart.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,') // 将整数部分逢三一断
			var floatPart = '.00' // 预定义小数部分
			var value2Array = value.toString().split('.')
			if (value2Array.length === 2) {
				floatPart = value2Array[1].toString() // 拿到小数部分
				if (floatPart.length === 1) { // 补0,实际上用不着
					return intPartFormat + '.' + floatPart + '0'
				} else {
					return intPartFormat + '.' + floatPart
				}
			} else {
				return intPartFormat + floatPart
			}
		} else {
			return value
		}
	},
	formatDuring1(val) {
		let timer = val
		if (timer > 0) {
			let endTime = parseInt(timer / 1000)
			let h = Math.floor(endTime / 3600)
			let m = Math.floor((endTime - h * 60 * 60) / 60)
			let s = endTime - h * 3600 - m * 60
			if (h < 10) {
				h = '0' + h
			}
			if (m < 10) {
				m = '0' + m
			}
			if (s < 10) {
				s = '0' + s
			}
			if (h > 0) {
				return h + '小时' + m + '分' + s + '秒'
			} else {
				return m + '分' + s + '秒'
			}
		}
	},
	sex(val) {
		switch (val) {
			case 1:
				return '男'
			case 2:
				return '女'
		}
	},
	status(val) {
		switch (val) {
			case 1:
				return '可用'
			case 2:
				return '禁用'
			case 3:
				return '已删除'
		}
	},
	projectStatus(val) {
		switch (val) {
			case 1:
				return '待提交'
			case 2:
				return '待审核'
			case 3:
				return '上线中'
			case 4:
				return '已下线'
			case 5:
				return '审核失败'
		}
	},
	projectCoilor(val) {
		switch (val) {
			case 1:
				return '#FF8B3C'
			case 2:
				return '#1A85FF'
			case 3:
				return '#31BC0E'
			case 4:
				return '#FD7259'
			case 5:
				return '#f50'
		}
	},
	budgetUnit(val) {
		switch (val) {
			case 1:
				return '元'
			case 2:
				return '万元'
		}
	},
	staffSize(val) {
		switch (val) {
			case 0:
				return '****'
			case 1:
				return '10人以内'
			case 2:
				return '10~50人'
			case 3:
				return '50~100人'
			case 4:
				return '100人以上'
		}
	},
	payStatus(val) {
		switch (val) {
			case 0:
				return '进行中'
			case 1:
				return '成功'
			case 2:
				return '失败'
		}
	},
	payType(val) {
		switch (val) {
			case 0:
				return '微信支付'
			case 1:
				return '支付宝'
			case 2:
				return '余额'
			case 3:
				return '线下'
		}
	},
	transactionType(val) {
		switch (val) {
			case 0:
				return '提现'
			case 1:
				return '充值'
			case 2:
				return '购买视频课程次数'
			case 3:
				return '购买项目vip'
			case 4:
				return '购买人才教育vip'
			case 5:
				return '购买项目信息'
			case 6:
				return '购买用工信息'
			case 7:
				return '购买项目报名信息'
			case 8:
				return '购买短期用工报名信息'
			case 9:
				return '购买企业档案信息'
			case 10:
				return '购买人才档案信息'
			case 11:
				return '购买线上课程'
		}
	},
	timeFormat(val) { // author: meizz
		val = val.split(' ')[0]
		let date = new Date(val)
		let fmt = 'yyyy-MM-dd'
		console.log('timeFormat', date)
		var o = {
			"M+": date.getMonth() + 1, //月份
			"d+": date.getDate(), //日
			"h+": date.getHours(), //小时
			"m+": date.getMinutes(), //分
			"s+": date.getSeconds(), //秒
			"q+": Math.floor((date.getMonth() + 3) / 3), //季度
			"S": date.getMilliseconds() //毫秒
		};
		if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
		for (var k in o)
			if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : ((
				"00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	},
	workTime(val) {
		let date
		if (val) {
			date = new Date(val || '')
		} else {
			date = new Date()
		}
		let n = new Date()
		return parseInt((n.getTime() - date.getTime()) / 31536000000) + '年工作经验'
	},
	age(val) {
		let date
		if (val) {
			date = new Date(val || '')
		} else {
			date = new Date()
		}
		let n = new Date()
		return parseInt((n.getTime() - date.getTime()) / 31536000000)
	},
	jobEducation(val) {
		switch (val) {
			case 0:
				return '不限'
			case 1:
				return '大专以下'
			case 2:
				return '大专'
			case 3:
				return '本科'
			case 4:
				return '本科以上'
		}
	},
	personStatus(val) {
		switch (val) {
			case 1:
				return '在职'
			case 2:
				return '离职'
		}
	},
	carStatus(val) {
		switch (val) {
			case 1:
				return '在库'
			case 2:
				return '待出库'
			case 3:
				return '已出库'
			case 4:
				return '已售'
		}
	},
	jobExperience(val) {
		switch (val) {
			case 0:
				return '经验不限'
			case 1:
				return '1年以下'
			case 2:
				return '1~3年'
			case 3:
				return '3~5年'
			case 4:
				return '5~10年'
			case 5:
				return '10年以上'
		}
	},
	orderStatus(val) {
		switch (val) {
			case 0:
				return '待支付'
			case 1:
				return '已支付/待确认'
			case 2:
				return '已支付/待发货'
			case 3:
				return '已发货'
			case 4:
				return '已签收'
			case 5:
				return '已取消'
			case 6:
				return '支付失败/待重新支付'
			case 7:
				return '已提交售后'
			case 8:
				return '已处理'
			case 9:
				return '已关闭'
			case 10:
				return '退款/售后'
		}
	},
	jobStatus(val) {
		switch (val) {
			case 1:
				return '待提交'
			case 2:
				return '待审核'
			case 3:
				return '发布中'
			case 4:
				return '已下线'
			case 5:
				return '审核失败'
		}
	},
	projectType(val) {
		switch (val) {
			case 1:
				return '新制'
			case 2:
				return '改造'
		}
	},
	rentStatus(val) {
		switch (val) {
			case 1:
				return '正常'
			case 2:
				return '即将逾期'
			case 3:
				return '已缴纳'
			case 4:
				return '已逾期'
		}
	},
	rentColor(val) {
		switch (val) {
			case 1:
				return 'primary'
			case 2:
				return 'warning'
			case 3:
				return 'success'
			case 4:
				return 'error'
		}
	},
	type(val) {
		switch (val) {
			case 1:
				return '自营车辆'
			case 2:
				return '外租车辆'
			case 3:
				return '加盟车辆'
		}
	}
}

export default Vfilters