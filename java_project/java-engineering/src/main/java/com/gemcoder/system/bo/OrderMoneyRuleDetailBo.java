package com.gemcoder.system.bo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 计费详情
 * @author jiang
 *
 */
public class OrderMoneyRuleDetailBo {
	int ruleId;
	Date beginTime;
	Date endTime;
	int minutes;
	String ruleType;
	String licensePlate;
	BigDecimal money;
	String ruleName;
	public OrderMoneyRuleDetailBo() {
		
	}
	public OrderMoneyRuleDetailBo(int ruleId,Date beginTime,Date endTime,String ruleType,String licensePlate,BigDecimal money,String ruleName,int durMinutes) {
		this.ruleId=ruleId;
		this.beginTime=new Date(beginTime.getTime());
		this.endTime=new Date(endTime.getTime());
		this.ruleType=ruleType;
		this.licensePlate=licensePlate;
		this.money=new BigDecimal(money.toString());
		this.ruleName=ruleName;
		minutes=durMinutes;//(int)(this.endTime.getTime()- this.beginTime.getTime())/1000/60;
	}
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
}
