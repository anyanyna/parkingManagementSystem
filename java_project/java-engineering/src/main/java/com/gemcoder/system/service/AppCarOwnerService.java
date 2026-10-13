package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

@Service
public class AppCarOwnerService {
    private static final Logger log = LoggerFactory.getLogger(AppCarOwnerService.class);

    @Autowired
    private VehicleListManagerService vehicleListManagerService;


    /**
     * 根据用户名查询我的车辆信息
     * @author XueZhongHao
     * @date 2024/12/27
     * @param userName
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getMyCar(String userName) {
        // 两个车牌的信息，然后有无欠费
        List<Map<String, Object>> myCarByUserName = getMyCarByUserName(userName);
        // 欠费的信息
        myCarByUserName.forEach(this::getArrearsByVehicle);

        return Result.buildSuccess(myCarByUserName);
    }



    /**
     * 新增一个车辆
     * @author XueZhongHao
     * @date 2024/12/27
     * @param userName
     * @param plateNum
     * @param plateType
     * @param mainType
     * @param img
     * @return com.gemcoder.system.bo.Result
     **/
    public Result addVehicle(String userName, String plateNum, String plateType, String mainType, String img) {
        // 查询是否有改类型车牌，有就删除
        List<Map<String, Object>> myCarByUserNameMainType = getMyCarByUserNameMainType(userName, mainType);
        if(CollectionUtil.isNotEmpty(myCarByUserNameMainType)){
            String deleteSQL = "delete from parking_lot_user_vehicle where user_code = ? and main_type = ? ;";
            int deleteSize = executeSQL(deleteSQL,userName,mainType);
        }
        String insertSQL = "INSERT INTO parking_lot_user_vehicle\n" +
                "(user_code, license_plate, main_type, vehicle_license, plate_type, creator)\n" +
                "VALUES( ? , ? , ? , ? , ? , ? );";
        int insertSize = executeSQL(insertSQL,userName,plateNum,mainType,img,plateType,userName);
        return Result.buildSuccess(insertSize);
    }


    /**
     * 解绑车辆
     * @author XueZhongHao
     * @date 2024/12/27
     * @param plateNum
     * @return com.gemcoder.system.bo.Result
     **/
    public Result unbindVehicle(String userName, String plateNum) {
        Map<String, Object> arrearsByPlateNum = getArrearsByPlateNum(plateNum);
        if(Objects.nonNull(arrearsByPlateNum)){
            log.info("/appUser/getMyCar=======>车主端，解绑车牌：{}有欠费不允许解绑",plateNum);
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        String deleteSQL = "delete from parking_lot_user_vehicle where user_code = ? and license_plate = ? ;";
        int i = executeSQL(deleteSQL,userName,plateNum);
        return Result.buildSuccess(i);
    }




    /**
     * 查询我的停车记录
     * @author XueZhongHao
     * @date 2024/12/30
     * @param userName
     * @param selectType
     * @param currentPage
     * @param pageSize
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getMyParkRecord(String userName, String selectType, Integer currentPage, Integer pageSize) {

        // 查询我的车牌
        List<Map<String, Object>> myCarByUserName = getMyCarByUserName(userName);
        if(CollectionUtil.isEmpty(myCarByUserName)){
            return Result.buildSuccess("未绑定车牌");
        }
        StringBuilder plateParam = new StringBuilder(" (");
        for (Map<String, Object> car : myCarByUserName){
            String plateNum = (String)car.get("license_plate");
            plateParam.append("'").append(plateNum).append("',");
        }
        plateParam = new StringBuilder(plateParam.substring(0, plateParam.length() - 1) + ") ");


        String pageSQL = "order by id desc limit ?,?";
        String selectSQL = "select * \n" +
                "from user_order \n" +
                "where license_plate in ";
        selectSQL += plateParam;
        if("0".equals(selectType)){
            selectSQL += " and payment_status != '已支付' ";
        }else if("1".equals(selectType)){
            selectSQL += " and payment_status = '已支付' ";
        }
        List<Map<String, Object>> res = executeSQL(selectSQL + pageSQL, (currentPage - 1) * pageSize, pageSize);
        return Result.buildSuccess(res);
    }


    /**
     * 获取订单详情，包括进出图片等
     * @author XueZhongHao
     * @date 2024/12/30
     * @param orderCode
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getMyOrderInfo(String orderCode) {

        String selectSQL = "select a.*,b.entry_picture ,b.exit_picture \n" +
                "from user_order a join vehicle_entry_exit_record b on a.id = b.user_order_id \n" +
                "where order_code = ? ;";
        List<Map<String,Object>> list = executeSQL(selectSQL, orderCode);
        if(CollectionUtil.isEmpty(list)){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        return Result.buildSuccess(list.get(0));

    }



    /**
     * 获取自己的欠费订单
     * @author XueZhongHao
     * @date 2024/12/30
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getArrearsRecord(String userName) {
        List<Map<String, Object>> arrearsRecordsByUserName = getArrearsRecordsByUserName(userName);
        return Result.buildSuccess(Objects.requireNonNullElse(arrearsRecordsByUserName, "暂无欠费"));
    }

    /**
     * 计费详情，直接从别处移过来的
     * @author XueZhongHao
     * @date 2024/12/30
     * @param currentPage
     * @param pageSize
     * @param orderId
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getChargeDetails(Integer currentPage, Integer pageSize, Integer orderId) {
        StringBuilder sql = new StringBuilder(
                "SELECT a.id, a.serial_number, a.billing_type, a.billing_vehicle, a.billing_period, a.start_time, a.end_time, CONCAT(FLOOR(a.duration / 60), '小时',  MOD(a.duration, 60),'分钟' ) AS duration , a.billing_rule,a.amount,b.rule_name FROM billing_detail a join billing_rules b on a.billing_rule=b.id WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (orderId != null) {
            sql.append(" AND a.order_id = ?");
            params.add(orderId);
        }
        sql.append(" ORDER BY a.id DESC LIMIT ?, ?");
        params.add((currentPage - 1) * pageSize);
        params.add(pageSize);
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_detail a WHERE 1=1");
        List<Object> countParams = new ArrayList<>();
        if (orderId != null) {
            countSql.append(" AND a.order_id = ?");
            countParams.add(orderId);
        }
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        Integer total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        Map<String, Object> result = new HashMap<>();
        RowUtil.setRowNumber(data, pageSize, currentPage);
        result.put("total", total);
        result.put("data", data);
        return new Result(true, "查询完成", result);
    }



    /**
     * 保存用户的意见反馈
     * @author XueZhongHao
     * @date 2024/12/30
     * @param userName
     * @param content
     * @param pic
     * @return com.gemcoder.system.bo.Result
     **/
    public Result saveSuggest(String userName, String content, String pic) {
        String insertSQL = "INSERT INTO parking_lot_user_suggest\n" +
                "(user_code, start_time, content, pic, status)\n" +
                "VALUES( ? , ? , ? , ? , ? ); ";
        int i = executeSQL(insertSQL,userName,new Date(),content,pic,"0");
        if(i==0){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }else{
            return Result.buildSuccess(i);
        }
    }




    public List<Map<String, Object>> getMyCarByUserNameMainType(String userName, String mainType){
        String selectSQL = "select * from parking_lot_user_vehicle where user_code = ? and main_type = ?";

        return executeSQL(selectSQL,userName,mainType);
    }

    public List<Map<String, Object>> getMyCarByUserName(String userName){

        String selectSQL = "select *\n" +
                "from parking_lot_user_vehicle\n" +
                "where user_code = ? ;";
        return executeSQL(selectSQL, userName);

    }

    public void getArrearsByVehicle(Map<String, Object> vehicle){

        String plateNum = (String) vehicle.get("license_plate");
        Map<String, Object> arrearsByPlateNum = getArrearsByPlateNum(plateNum);
        if(!Objects.isNull(arrearsByPlateNum)){
            vehicle.put("isArrears","1");
            BigDecimal total = (BigDecimal) arrearsByPlateNum.get("total");
            vehicle.put("arrearsTotal",total);
        }else{
            vehicle.put("isArrears","0");
        }
    }

    public JSONObject getCarInfoByPlateNum(String plateNum){
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> arrearsByPlateNum = getArrearsByPlateNum(plateNum);
        if(Objects.isNull(arrearsByPlateNum)){
            jsonObject.put("isArrears","1");
            BigDecimal total = (BigDecimal) arrearsByPlateNum.get("total");
            jsonObject.put("arrearsTotal",total);
        }
        jsonObject.put("isArrears","0");
        jsonObject.put("plateNum",plateNum);
        return jsonObject;
    }


    public Map<String,Object> getParkingLotUser(String userCode){
        String selectSQL = "select *\n" +
                "from parking_lot_user\n" +
                "where user_code = ? ";
        List<Map<String, Object>> list = executeSQL(selectSQL, userCode);
        if(CollectionUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
    }


    public Map<String,Object> getArrearsByPlateNum(String plateNum){
        String selectArrearsByPlateNumSQL = "select a.*,sum(b.money_num) as total\n" +
                "from vehicle_arrears a\n" +
                "join vehicle_arrears_record b on a.code = b.arrears_code \n" +
                "where a.plate_num = ? and a.status in (0,1)\n" +
                "group by a.code ";
        List<Map<String, Object>> list = executeSQL(selectArrearsByPlateNumSQL, plateNum);
        if(CollectionUtil.isEmpty(list) || list.size() == 0){
            return null;
        }else{
            return list.get(0);
        }
    }


    public List<Map<String, Object>> getArrearsRecordsByUserName(String userName){
        String selectArrearsPlateNumSQL = "select a.user_code, a.license_plate ,b.code as arrears_code, b.status \n" +
                "from parking_lot_user_vehicle a left join vehicle_arrears b on a.license_plate =b.plate_num \n" +
                "where b.status in ('0','1') and a.user_code = ? ";
        List<Map<String, Object>> list = executeSQL(selectArrearsPlateNumSQL, userName);
        if(CollectionUtil.isEmpty(list)){
            return null;
        }

        String selectArrearsOrderSQL = "select b.*, a.money_num,a.phone \n" +
                "from vehicle_arrears_record a left join user_order b on a.order_code = b.order_code \n" +
                "where a.arrears_code in ";
        StringBuilder arrearsCodes = new StringBuilder(" (");

        for(Map<String, Object> map : list){
            String arrearsCode = (String)map.get("arrears_code");
            arrearsCodes.append("'").append(arrearsCode).append("',");
        }
        arrearsCodes = new StringBuilder(arrearsCodes.substring(0, arrearsCodes.length() - 1) + ") ; ");
        selectArrearsOrderSQL+=arrearsCodes;
        return executeSQL(selectArrearsOrderSQL);
    }



}
