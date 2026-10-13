package com.gemcoder.system.bo;


import com.alibaba.excel.annotation.ExcelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class VehicleBlockListDownloadBo {
    @ExcelProperty("车牌号")
    private String plateNum;
    @ExcelProperty("车牌类型")
    private String plateType;
    @ExcelProperty("生效时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime startTime;
    @ExcelProperty("到期时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime endTime;
    @ExcelProperty("适用车场")
    private String parkingLotId;
    @ExcelProperty("名单类型")
    private String vehicleListCode;
    @ExcelProperty("备注")
    private String remark;
    @ExcelProperty("状态")
    private String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
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

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getPlateType() {
        return plateType;
    }

    public void setPlateType(String plateType) {
        this.plateType = plateType;
    }

    public String getVehicleListCode() {
        return vehicleListCode;
    }

    public void setVehicleListCode(String vehicleListCode) {
        this.vehicleListCode = vehicleListCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
