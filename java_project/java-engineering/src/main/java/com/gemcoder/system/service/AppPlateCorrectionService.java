package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;
import com.gemcoder.system.ws.CapMatchServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppPlateCorrectionService {
    private static final Logger log = LoggerFactory.getLogger(CapMatchServcie.class);
    @Autowired
    private MinioUtil minioUtil;
    @Value("${minio.echoUrl}")
    private String minIoEchoUrl;

    public Result getList(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " order by id desc limit ?,?";
        String selectSql = "SELECT id, order_code, license_plate, entry_time, parking_duration secondDiff FROM user_order  where order_status='车辆入场'";
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
    public String getGapTime(Date date1,Date date2){
        // 相差的毫秒值
        Long milliseconds = date1.getTime() - date2.getTime();

        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数

        long day = milliseconds / nd; // 计算相差多少天
        long hour = milliseconds % nd / nh; // 计算相差剩余多少小时
        long min = milliseconds % nd % nh / nm; // 计算相差剩余多少分钟
        long sec = milliseconds % nd % nh % nm / ns; // 计算相差剩余多少秒
//        System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒");
        long hourAll = milliseconds / nh; // 计算相差多少小时
//        System.out.println("时间相差：" + hourAll + "小时" + min + "分钟" + sec + "秒");
        long min2 = milliseconds / nm; // 计算相差多少分钟
//        System.out.println("时间相差：" + min2 + "分钟" + sec + "秒");
        String overTime = hourAll+"小时"+min+"分";
        return overTime;
    }

    public Result getDetail(Integer id) {
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL("SELECT order_code,license_plate,entry_picture,entry_name,v.id vid,license_plate_type FROM user_order u LEFT JOIN vehicle_entry_exit_record v on u.id=v.user_order_id where u.id=?", id)));
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        jsonObject.put("entry_picture",minIoEchoUrl+jsonObject.getString("entry_picture"));
        if (CollectionUtil.isNotEmpty(jsonArray)) {
            return Result.buildSuccess(jsonObject);
        } else {
            return Result.buildSuccess(null);
        }
    }

    public Result update(MultipartFile file, Integer vid) {
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL("SELECT order_code,license_plate,entry_picture,entry_name,v.id vid,license_plate_type FROM user_order u LEFT JOIN vehicle_entry_exit_record v on u.id=v.user_order_id where v.id=?", vid)));
        String licensePlate = jsonArray.getJSONObject(0).getString("license_plate");
        String fileName="phoneUpdate/phoneUpdate_"+ System.currentTimeMillis()+"_"+licensePlate+"_"+file.getOriginalFilename();;
        minioUtil.uploadMultipartFile(file,fileName, MinIOConfig.pitureBucket);
        Object o = executeSQL("update vehicle_entry_exit_record set entry_picture=? where id=?", fileName, vid);
        log.info("更新入场图片地址:{},车牌->{},ID->{}", fileName, licensePlate, vid);
        return Result.buildSuccess(o);
    }
}
