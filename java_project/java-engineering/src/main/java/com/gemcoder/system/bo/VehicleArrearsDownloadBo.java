package com.gemcoder.system.bo;


import com.alibaba.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class VehicleArrearsDownloadBo {

    @ExcelProperty("车牌号")
    private String plateNum;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("欠费笔数")
    private Integer total;

    @ExcelProperty("欠费金额")
    private BigDecimal moneyAmount;
    @ExcelProperty("逾期时长（天）")
    private Integer daySum;

    @ExcelProperty("生效时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime startTime;


    @ExcelProperty("到期时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime endTime;
    @ExcelProperty("状态")
    private String status;

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Integer getDaySum() {
        return daySum;
    }

    public void setDaySum(Integer daySum) {
        this.daySum = daySum;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
