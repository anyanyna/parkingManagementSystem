package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

@Service
public class OrderUnusualService {
    private static final Logger log = LoggerFactory.getLogger(OrderUnusualService.class);

    @Autowired
    private VehicleListManagerService vehicleListManagerService;


    /**
     * @param orderCode 订单code
     * @param type      处理类型 0 忽略异常 1欠费追缴
     * @param plateNum  车牌号
     * @return com.gemcoder.system.bo.Result
     * @author XueZhongHao
     * @date 2024/12/20
     **/
    @Transactional
    public Result handleUnusual(String orderCode, String type, String plateNum) {
        String updateOrderSQL = "update user_order\n" +
                "set is_handle = '1' \n" +
                "where order_code = ? ";
        int i = executeSQL(updateOrderSQL, orderCode);
        if("0".equals(type)){
            // 忽略直接返回
            return Result.buildSuccess(i);
        }
        // 生成欠费
        // 查询该车牌的最新一个欠费记录，看是否已处理
        // 若已处理新生成，若未处理添加一个record
        String selectOneByPlateNumSQL = "select *\n" +
                "from vehicle_arrears \n" +
                "where plate_num = ? \n" +
                "order by id desc limit 1";
        List<Map<String,Object>> list = executeSQL(selectOneByPlateNumSQL, plateNum);
        String code = "";
        boolean insertVehicleArrearsFlag = false;
        if(!CollectionUtil.isEmpty(list)){
            Map<String, Object> one = list.get(0);
            String status = (String) one.get("status");
            if(!"0".equals(status) && !"1".equals(status)){
                // 插入欠费记录
                insertVehicleArrearsFlag = true;
            }else{
                code = (String) one.get("code");
            }
        }else{
            insertVehicleArrearsFlag = true;
        }
        // 查询订单
        String selectOrderSQL = "select * from user_order where order_code = ? ";
        List<Map<String,Object>> userOrderList = executeSQL(selectOrderSQL,orderCode);
        String selectParkingLotUserSQL = "select * from parking_lot_user where main_license_plate = ? or secondary_license_plate = ? ";
        List<Map<String,Object>> parkingLotUserList  = executeSQL(selectParkingLotUserSQL, plateNum);
        if(CollectionUtil.isEmpty(parkingLotUserList)){
            throw new RuntimeException("数据异常");
        }
        String phone = (String) parkingLotUserList.get(0).get("contact");
        BigDecimal receivableAmount = (BigDecimal) userOrderList.get(0).get("receivable_amount");
        if(insertVehicleArrearsFlag){
            // 欠费主体插入
            code = "VA" + IdUtil.simpleUUID();
            String insertVehicleArrearsSQL = "INSERT INTO vehicle_arrears\n" +
                    "(code, plate_num, phone, start_time, recovery_amount, status)\n" +
                    "VALUES( ?, ?, ?, now(), ?, '0');";
            executeSQL(insertVehicleArrearsSQL, code, plateNum, phone, BigDecimal.ZERO);
        }
        // 需要生成并且插入车辆欠费详情记录
        String insertVehicleArrearsRecordSQL = "INSERT INTO vehicle_arrears_record\n" +
                "(arrears_code, order_code, plate_num, phone, money_num)\n" +
                "VALUES( ? , ?, ?, ?, ?);";
        executeSQL(insertVehicleArrearsRecordSQL,code,orderCode,plateNum,phone,receivableAmount);
        return Result.buildSuccess(200);
    }

    /**
     *
     * @author XueZhongHao
     * @date 2024/12/23
     * @param phone
     * @param plateNum
     * @param type
     * @param orderType
     * @param parkingLot
     * @param createTime1
     * @param createTime2
     * @param currentPage
     * @param pageSize
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getPageInfo(String userName, String phone, String plateNum, String type, String orderType, String parkingLot, Date createTime1, Date createTime2, Integer currentPage, Integer pageSize) throws JSONException {
        String selectLastSql = " order by a.id desc limit ?,?";
        Result parkingRes = vehicleListManagerService.getParkingList(userName, 0);
        List<Map<String,Object>> parkingData = (List<Map<String,Object>>) parkingRes.getData();
        if(CollectionUtil.isEmpty(parkingData)){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        StringBuilder parkingIds = new StringBuilder(" (");
        for(Map<String,Object> parking:parkingData){
            int id = (int) parking.get("id");
            parkingIds.append(id).append(",");
        }
        parkingIds = new StringBuilder(parkingIds.substring(0, parkingIds.length() - 1) + ") ");
        Map<String, Object> stringObjectMap = selectPageSQL(parkingIds.toString(), phone, plateNum, type, orderType, parkingLot, createTime1, createTime2);
        List<Object> params = (List<Object>) stringObjectMap.get("params");
        String sql = String.valueOf(stringObjectMap.get("sql"));
        JSONObject res = new JSONObject();
        Integer count = sdkOfPaginationQueryCount(sql, params);
        params.add((currentPage-1)*pageSize);
        params.add(pageSize);
        Object o = executeSQL(sql + selectLastSql, params);
        res.put("total",count);
        res.put("data",o);
        return Result.buildSuccess(res);

    }


    private Map<String, Object> selectPageSQL(String ids, String phone, String plateNum, String type, String orderType, String parkingLot, Date createTime1, Date createTime2){
        Map<String, Object> map = new HashMap<>();
        List<Object> params = new ArrayList<>();
        String selectSQL = "select a.order_code ,a.license_plate ,b.contact ,a.remark,c.entry_picture ,c.exit_picture ,a.order_status ,c.last_entry_time ,c.last_exit_time ,\n" +
                "a.create_time ,c.entry_name ,c.exit_name ,a.remark\n" +
                "from user_order a left join parking_lot_user b on a.license_plate =b.main_license_plate \n" +
                "left join vehicle_entry_exit_record c on a.id = c.user_order_id \n" +
                "where a.order_status in ('异常','关闭') a.parking_lot_id in ";
        selectSQL = selectSQL + ids;
        if(!StringUtils.isEmpty(phone)){
            selectSQL += " and b.contact like concat ('%', ? ,'%') ";
            params.add(phone);
        }
        if(!StringUtils.isEmpty(plateNum)){
            selectSQL += " and a.license_plate like concat ('%', ? ,'%') ";
            params.add(plateNum);
        }
        if(!StringUtils.isEmpty(type)){
            selectSQL += " and a.order_status = ? ";
            params.add(type);
        }
        if(!StringUtils.isEmpty(orderType)){
            selectSQL += " and a.order_type = ? ";
            params.add(orderType);
        }
        if(!StringUtils.isEmpty(parkingLot)){
            selectSQL += "a.parking_lot like concat ('%', ? ,'%') ";
            params.add(parkingLot);
        }
        if(Objects.nonNull(createTime1) && Objects.nonNull(createTime2)){
            selectSQL += " and ( a.create_time >= ? and a.create_time <= ? ) ";
            params.add(createTime1);
            params.add(createTime2);
        }
        map.put("sql",selectSQL);
        map.put("params",params);
        return map;


    }

    /**
     * 根据车牌号查询最近5条订单信息
     * @author XueZhongHao
     * @date 2024/12/24
     * @param plateNum
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getFiveUserOrderBy(String plateNum) {
        String selectSQL = " SELECT *\n" +
                "FROM user_order\n" +
                "WHERE license_plate = ? \n" +
                "order by id desc limit 5 ";
        List<Map<String,Object>> list  = executeSQL(selectSQL, plateNum);
        return Result.buildSuccess(list);
    }

    public Result updateRemark(String code, String remark) {
        String updateRemarkSQL = "update user_order \n" +
                "set remark = ? \n" +
                "where order_code = ? ";
        int i = executeSQL(updateRemarkSQL,remark,code);
        return Result.buildSuccess(i);
    }
}
