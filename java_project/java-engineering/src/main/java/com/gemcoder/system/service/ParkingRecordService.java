package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

@Service
public class ParkingRecordService {
    public Result getList(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " order by id desc limit ?,?";
        String selectSql = "SELECT id,order_code,parking_lot,exit_time,parking_duration,license_plate,order_amount,order_status FROM `user_order` where 1=1";
        if (jsonObject.getInteger("parkingId") != null) {
            selectSql += " and parking_lot_id=" + jsonObject.getInteger("parkingId");
        }
        if (!StringUtils.isEmpty(jsonObject.getString("plateNum"))) {
            selectSql += " and license_plate like " + "'%" + jsonObject.getString("plateNum") + "%'";
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

    public Result getDetail(Integer id) {
        String parkingSql="SELECT\n" +
                "\tlicense_plate_number,\n" +
                "\tlicense_plate_type,\n" +
                "\tDATE_FORMAT( last_entry_time, '%Y-%m-%d %H:%i:%s' ) AS last_entry_time,\n" +
                "\tDATE_FORMAT( last_exit_time, '%Y-%m-%d %H:%i:%s' ) AS last_exit_time,\n" +
                "\tlast_parking_lot,\n" +
                "\tcertificate,\n" +
                "\tberth_number,\n" +
                "\tmanager,\n" +
                "\torder_code,\n" +
                "\torder_amount,\n" +
                "\tpayment_channel,\n" +
                "\tpayment_amount,\n" +
                "\tdiscount_amount \n" +
                "FROM\n" +
                "\tvehicle_entry_exit_record r\n" +
                "\tLEFT JOIN parking_lot_info p ON r.parking_lot_info_id = p.id\n" +
                "\tLEFT JOIN user_order uo ON r.user_order_id = uo.id \n" +
                "WHERE\n" +
                "\tr.user_order_id=?";
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(parkingSql,id)));
        if (CollectionUtil.isNotEmpty(jsonArray)) {
            return Result.buildSuccess(jsonArray.getJSONObject(0));
        } else {
            return Result.buildSuccess(null);
        }

    }

    public Result getBillingDetail(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " limit ?,?";
        String selectSql = "SELECT\n" +
                "\ta.id,\n" +
                "\ta.serial_number,\n" +
                "\ta.billing_type,\n" +
                "\ta.billing_vehicle,\n" +
                "\ta.billing_period,\n" +
                "\ta.start_time,\n" +
                "\ta.end_time,\n" +
                "\tCONCAT( FLOOR( a.duration / 60 ), '小时', MOD ( a.duration, 60 ), '分钟' ) AS duration,\n" +
                "\ta.billing_rule,\n" +
                "\ta.amount,\n" +
                "\tb.rule_name \n" +
                "FROM\n" +
                "\tbilling_detail a\n" +
                "\tJOIN billing_rules b ON a.billing_rule = b.id \n" +
                "WHERE 1=1";
        if (jsonObject.getInteger("orderId") != null) {
            selectSql += " and order_id=" + jsonObject.getInteger("orderId");
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
}
