package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;
import com.gemcoder.system.util.*;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.VehicleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class AppSentryBoxService {
    private static final Logger log = LoggerFactory.getLogger(AppSentryBoxService.class);
    @Autowired
    private MinioUtil minioUtil;
    @Resource
    private CommandService commandService;
    @Value("${minio.echoUrl}")
    private String minIoEchoUrl;
    @Resource
    private VehicleInYardService vehicleInYardService;
    @Resource
    private VehicleOutYardService vehicleOutYardService;
    @Resource
    private ParkingordersService parkingordersService;
    @Resource
    private ScanYardCodeService scanYardCodeService;

    public Result open(String camId) {
        return openOrClose(camId, true);
    }

    private Result openOrClose(String camId, boolean openClose) {
        if (StringUtils.isEmpty(camId)) return new Result(false, "camId必填");
        try {
            String s = commandService.openBarier(camId, null, true, openClose);
        } catch (Exception e) {
            log.warn("操作杆子失败", e);
            return new Result(false, "操作失败，请联系岗亭", "操作失败，请联系岗亭");
        }
        String selectSql = "SELECT\n" +
                "\tb.parking_lot_info_id,\n" +
                "\tb.cam_id,\n" +
                "\tin_out,\n" +
                "\tchannels,\n" +
                "\tparking_lot_name \n" +
                "FROM\n" +
                "\tbarrier_gate_equipment b\n" +
                "\tLEFT JOIN parking_lot_info p ON b.parking_lot_info_id = p.id\n" +
                "\twhere cam_id=?";
        String open_close = openClose ? "抬杆" : "落杆";
        String userName = sdkOfGetCurrentUserName();
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, camId)));
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String parkingLotInfoId = jsonObject.getString("parking_lot_info_id");
        String inOut = jsonObject.getString("in_out");
        String channels = jsonObject.getString("channels");
        String parkingLotName = jsonObject.getString("parking_lot_name");
        String executeInsertSql = "INSERT INTO `guard_box_record` (  `parking_lot_info_id`, `cam_id`, `in_out`, `open_close`, `create_username`,  `channels`, `parking_name` ) VALUES (  ?, ?, ?, ?, ?,  ?, ?)";
        Object o = executeSQL(executeInsertSql, parkingLotInfoId, camId, inOut, open_close, userName, channels, parkingLotName);
        return Result.buildSuccess(o);
    }

    public Result close(String camId) {
        return openOrClose(camId, false);
    }

    public Result capPicture(String camId) {
        if (StringUtils.isEmpty(camId)) return new Result(false, "camId必填");
        String s = commandService.capPicture(camId);
        return Result.buildSuccess(s);
    }

    public Result getPic(String camId) {
        if (StringUtils.isEmpty(camId)) return new Result(false, "camId必填");
        String sql = "select * from camera_cap_pic_record where cam_id=? and date(create_time)=date(now()) order by create_time desc limit 1";
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(sql, camId)));
        if (CollectionUtil.isNotEmpty(jsonArray)) {
            String picPath = jsonArray.getJSONObject(0).getString("pic_path");
            return Result.buildSuccess(minIoEchoUrl + picPath);
        }
        return new Result(false, "未找到对应图片");
    }

    public Result getSelect(Integer parkingId) {
        if (StringUtils.isEmpty(parkingId)) return new Result(false, "parkingId必填");
        return Result.buildSuccess(executeSQL("select cam_id `key`,concat(channels,in_out) as `value` from barrier_gate_equipment where parking_lot_info_id=?", parkingId));
    }

    public Result getList(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " order by id desc limit ?,?";
        String selectSql = "SELECT id,parking_name,create_username,create_time,in_out,channels,open_close FROM `guard_box_record` where 1=1";
        if (jsonObject.getInteger("parkingId") != null) {
            selectSql += " and parking_lot_info_id=" + jsonObject.getInteger("parkingId");
        }
        if (!com.alibaba.druid.util.StringUtils.isEmpty(jsonObject.getString("channels"))) {
            selectSql += " and channels like " + "'%" + jsonObject.getString("channels") + "%'";
        }
        List<Object> params = new ArrayList<>();
        JSONObject jsonObject1 = new JSONObject();
        Integer integer = sdkOfPaginationQueryCount(selectSql);
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        Object o = executeSQL(selectSql + selectLastSql, params.toArray());
        jsonObject1.put("total", integer);
        jsonObject1.put("data", o);
        return Result.buildSuccess(jsonObject1);
    }

    public Result saveOrderCar(JSONObject jsonObject, boolean isOpen) {
        String userName = sdkOfGetCurrentUserName();
        Integer parkingId = jsonObject.getInteger("parkingId");
        String camId = jsonObject.getString("camId");
        String plateNum = jsonObject.getString("plateNum");
        String platType = jsonObject.getString("platType");
        String entryPicture = jsonObject.getString("entryPicture");
        entryPicture = entryPicture.replace(minIoEchoUrl, "");
        Date entryTime = jsonObject.getDate("entryTime");
        if (parkingId == null) {
            return new Result(false, "parkingId 必填");
        }
        if (entryTime == null) {
            return new Result(false, "entryTime 必填");
        }
        if (StringUtils.isEmpty(camId)) {
            return new Result(false, "camId 必填");
        }
        if (StringUtils.isEmpty(plateNum)) {
            return new Result(false, "plateNum 必填");
        }
        if (StringUtils.isEmpty(platType)) {
            return new Result(false, "platType 必填");
        }
        if (StringUtils.isEmpty(entryPicture)) {
            return new Result(false, "entryPicture 必填");
        }
        Result result = vehicleInYardService.vehicleInYard("人工", parkingId, camId, plateNum, platType, false, isOpen, entryTime);
        if (result.flag) {
            JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.toJSONString(result.data));
            String selectSql = "SELECT id FROM  vehicle_entry_exit_record where  user_order_id=? ";
            JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, jsonObject1.getInteger("id"))));
            Integer id = jsonArray.getJSONObject(0).getInteger("id");
            if (id == null) {
                return new Result(false, "未找到对应进出场记录,更新图片失败");
            }
            String updatePicSql = "update vehicle_entry_exit_record set entry_picture=? where id=?";
            Object o = executeSQL(updatePicSql, entryPicture, id);
        }
        return result;
    }

    public Result uploadCamPic(MultipartFile file, String camId, String plateNum) {
        if (file == null) {
            return new Result(false, "file 必填");
        }
        if (camId == null) {
            return new Result(false, "camId 必填");
        }
        if (StringUtils.isEmpty(plateNum)) {
            return new Result(false, "plateNum 必填");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        StringBuilder pathBuilder = new StringBuilder();
        String nowStr = sdf.format(new Date());
        StringBuilder append = pathBuilder.append(camId).append("_").append(plateNum).append("_").append(nowStr).append(file.getOriginalFilename());
        String s = camId + "/" + append;
        minioUtil.uploadMultipartFile(file, s, MinIOConfig.pitureBucket);
        return Result.buildSuccess(minIoEchoUrl + s);
    }

    public Result getChannelSelect(Integer parkingId, String inOut) {
        if (StringUtils.isEmpty(parkingId)) return new Result(false, "parkingId必填");
        return Result.buildSuccess(executeSQL("select cam_id `key`,channels as `value` from barrier_gate_equipment where parking_lot_info_id=? and in_out=?", parkingId, inOut));
    }

    public Result getPlateIsBlacklist(String plateNum, Integer parkingId) {
        boolean inBlackList = vehicleOutYardService.isInBlackList(plateNum, parkingId);
        return Result.buildSuccess(inBlackList);
    }

    public Result getOrderByPlateNum(String plateNum, Integer parkingId) {
        String selectSql="SELECT\n" +
                "\tuo.order_code,\n" +
                "\tuo.id,\n" +
                "\tuo.license_plate,\n" +
                "\tuo.license_type,\n" +
                "\trr.entry_name,\n" +
                "\trr.entry_picture,\n" +
                "\trr.exit_name,\n" +
                "\trr.exit_picture\n" +
                "FROM\n" +
                "\tuser_order uo \n" +
                "\tleft JOIN\n" +
                "\tvehicle_entry_exit_record rr \n" +
                "\tON uo.id=rr.user_order_id\n" +
                "WHERE\n" +
                "\tuo.license_plate =?\n" +
                "\tAND uo.parking_lot_id =?\n" +
                "\tAND uo.order_status = '车辆入场' \n" +
                "\tAND  uo.payment_status IS NULL \n" +
                "ORDER BY\n" +
                "\tuo.create_time DESC \n" +
                "\tLIMIT 1";
        Object o = executeSQL(selectSql, plateNum, parkingId);
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(o));
        if (CollectionUtil.isNotEmpty(jsonArray)){
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            if (jsonObject.containsKey("entry_picture")){
                jsonObject.put("entry_picture",minIoEchoUrl+jsonObject.getString("entry_picture"));
            }
            return Result.buildSuccess(jsonObject);
        }
        return new Result(false,"车辆订单信息未找到");
    }

    public Result orderSettlement(JSONObject jsonObject, boolean b) {
        String licensePlate = jsonObject.getString("plateNum");
        String license_plate_type = jsonObject.getString("plateColor");
        String exitPicture = jsonObject.getString("exitPicture");
        exitPicture=exitPicture.replace(minIoEchoUrl,"");
        String camId = jsonObject.getString("camId");
        Integer parking_lot_info_id = jsonObject.getInteger("parkingId");
        if (StringUtils.isEmpty(licensePlate))return new Result(false,"车牌号必填");
        if (parking_lot_info_id==null)return new Result(false,"停车场id必填");
        List<Map<String, Object>> userOrderlist = parkingordersService.getLatestParkingOrdersList(
                licensePlate, parking_lot_info_id, OrderStatusConstant.inYard);
        if (CollectionUtil.isEmpty(userOrderlist)){
            // TODO 生成异常订单。
            // 异常订单是使用订单表
            List<Map<String, Object>> yardlist = executeSQL("select * from parking_lot_info where id=?", parking_lot_info_id);
            String parking_lot_name = (String) yardlist.get(0).get("parking_lot_name");
            List<Map<String, Object>> camList = executeSQL("select * from barrier_gate_equipment where cam_id=?", camId);
            String channels = null;
            if (!camList.isEmpty()) {
                // return new Result(false, "没有找到道闸设备", "没有找到道闸设备");
                log.warn("没有找到道闸设备:{}", licensePlate);
                channels = (String) camList.get(0).get("channels");
            }
            ////////////////////////////运营规则
            List<Map<String, Object>> operation_rulesList = executeSQL(
                    "select * from operation_rules where parking_lot_id=?", parking_lot_info_id);
            String remark="无驶入车";
            if (operation_rulesList != null &&! operation_rulesList.isEmpty()) {
                String abnormal_handling_duplicate = (String) operation_rulesList.get(0).get("abnormal_handling_no_in_car");
                if(abnormal_handling_duplicate!=null) {
                    remark= OrderRemarkConstant.noInYardRecord;
                }
            }
            // TODO 处理通知
            String createUsername = sdkOfGetCurrentUserName();
            String orderCode = OrderCodeUtil.generateOrderCode(licensePlate);
            Date now = new Date();
            Object parking_lot = null;
            List<Map<String, Object>> list = executeSQL("select * from parking_lot_info where id=?", parking_lot_info_id);
            if (list != null && !list.isEmpty()) {
                parking_lot = list.get(0).get("parking_lot_name");
            }
            StringBuilder insertSql = new StringBuilder(
                    "INSERT INTO user_order (order_type,order_source,order_code, license_plate,license_type, order_status,payment_status,operation,parking_lot,parking_lot_id ,exit_time,remark, create_username, create_time) VALUES (?,?,?,?, ?, ?,?,?,?, ?, ?, ?, ?,?)");
            List<Object> params = new ArrayList<>();
            params.add("临停");
            params.add("人工");
            params.add(orderCode);
            params.add(licensePlate);
            params.add(license_plate_type);
            params.add(OrderStatusConstant.exception);
            params.add(null);//OrderPaymentStatusConstant.waitpay);
            params.add("创建异常订单");
            params.add(parking_lot);
            params.add(parking_lot_info_id);
            params.add(now);
            params.add(remark);
            params.add(createUsername);
            params.add(now);

            // 执行SQL插入语句
            int insertRows = executeSQL(insertSql.toString(), params.toArray());
            StringBuilder maxIdSql = new StringBuilder("select max(id) as id from user_order");
            List<Map<String, Object>> li = executeSQL(maxIdSql.toString(), null);
            Integer orderId = (Integer) li.get(0).get("id");
            JSONObject json = new JSONObject();
            json.put("order_code", orderCode);

            {
                // 插入停车记录

                // String license_plate_type=(String)paramMap.get("license_plate_type");
                // Object entry_name=(Object) paramMap.get("entry_name");

                StringBuilder sql = new StringBuilder(
                        "insert into vehicle_entry_exit_record (last_exit_time,last_parking_lot,license_plate_number,license_plate_type,exit_name,contact,berth_number ,create_username,create_time,update_username,update_time,parking_lot_info_id,user_order_id,exit_picture) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                List<Object> paramsVEER = new ArrayList<>();
                paramsVEER.add(now);
                paramsVEER.add(parking_lot);
                paramsVEER.add(licensePlate);
                paramsVEER.add(license_plate_type);
                paramsVEER.add(channels);
                paramsVEER.add("");
                paramsVEER.add((new Random()).nextInt(32));
                paramsVEER.add(createUsername);
                paramsVEER.add(now);
                paramsVEER.add(createUsername);
                paramsVEER.add(now);
                paramsVEER.add(parking_lot_info_id);
                paramsVEER.add(orderId);
                paramsVEER.add(exitPicture);
                executeSQL(sql.toString(), paramsVEER.toArray());
            }

            scanYardCodeService.saveOrderOperationRecord(orderId, 1, createUsername, "创建订单", "创建异常订单:" + orderCode, "创建异常订单:" + orderCode,
                    "创建异常订单:" + orderCode + ",车牌：" + licensePlate, new Date());
            log.info("创建异常订单：{},{}", licensePlate, parking_lot_info_id);
            if (b){
                try {
                    String s = commandService.openBarier(camId+"", licensePlate, false, true);
                    return Result.buildSuccess(null);
                } catch (Exception e) {
                    log.warn("操作杆子失败", e);
                    return new Result(false, "操作失败，请联系岗亭", "操作失败，请联系岗亭");
                }
            }
            return new Result(true, "异常订单创建成功", json);
        }else {
            Map<String, Object> uorder = userOrderlist.get(0);
            LocalDateTime now = LocalDateTime.now();
            JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.toJSONString(uorder));
            Integer id = jsonObject1.getInteger("id");
            String orderSql="update user_order set order_status=? where id=?";
            String entryExitRecordSql="update vehicle_entry_exit_record set last_exit_time=?, update_username=?,update_time=?,exit_name=?,exit_picture=? where user_order_id=?";
            String selectCamName="select channels from barrier_gate_equipment where cam_id=?";
            JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectCamName, camId)));
            if (CollectionUtil.isNotEmpty(jsonArray)){
                String channels = jsonArray.getJSONObject(0).getString("channels");
                Object o = executeSQL(orderSql, OrderStatusConstant.complete, id);
                System.out.println("o = " + o);
                Object o1 = executeSQL(entryExitRecordSql, now, sdkOfGetCurrentUserName(),now,channels,exitPicture,id);
                System.out.println("o1 = " + o1);
                if (b){
                    try {
                        String s = commandService.openBarier(camId+"", licensePlate, false, true);
                        return Result.buildSuccess(null);
                    } catch (Exception e) {
                        log.warn("操作杆子失败", e);
                        return new Result(false, "操作失败，请联系岗亭", "操作失败，请联系岗亭");
                    }
                }
            }else {
                return new Result(false,"没有找到道闸设备");
            }
        }
        return new Result(false,"异常");
    }
}
