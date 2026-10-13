package com.gemcoder.system.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单金额
 * 
 * @author jiang
 *
 */

public class OrderMoneyBo {
	BigDecimal money=BigDecimal.ZERO;
	String licensePlate=null;
	List<OrderMoneyRuleDetailBo> details = new ArrayList<>();

	public void addOrderMoneyRuleDetailBo(OrderMoneyRuleDetailBo bo) {
		details.add(bo);
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money =new BigDecimal(money.toString());
	}

	public List<OrderMoneyRuleDetailBo> getDetails() {
		return details;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void addNewDetail(int ruleId, Date beginTime, Date endTime, String type, String licensePlate,
			BigDecimal money, String ruleName,int durMinutes) {
		OrderMoneyRuleDetailBo orderMoneyRuleDetailBo = new OrderMoneyRuleDetailBo(ruleId, beginTime, endTime, type,
				licensePlate, money, ruleName,durMinutes);
		details.add(orderMoneyRuleDetailBo);
		if (money == null) {
			money = BigDecimal.ZERO;
		}
		money = money.add(money);
	}
	
	 public static void main(String[] args) { 
		 BigDecimal money=BigDecimal.ZERO;
	 BigDecimal m2=new BigDecimal("11.11"); 
	 System.out.print(m2);
	 }
	 
}
