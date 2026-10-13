package com.gemcoder.system.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class AppPatrolInspectionService {
    @Autowired
    private MinioUtil minioUtil;
    @Value("${minio.echoUrl}")
    private String minIoEchoUrl;

    public Result getList(JSONObject jsonObject) {
        String userName = sdkOfGetCurrentUserName();
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " order by id desc limit ?,?";
        String selectSql = "SELECT `id`, `inspection_number`, `parking_lot_id`, `inspection_date`, `inspection_item`, `inspector`, `anomaly_type`, `issue_description`, IFNULL(CONCAT('" + minIoEchoUrl + "',issue_photo),`issue_photo`) `issue_photo`, `inspection_status`, `anomaly_handling`,IFNULL(CONCAT('" + minIoEchoUrl + "',handling_photo),`handling_photo`)  `handling_photo`, `handler`, `handling_date` FROM `inspection_records` where 1=1 ";
//        String selectSql = "SELECT * FROM `inspection_records` where 1=1 ";
        selectSql+=" and ((inspector=? and inspection_status=?) or (handler=? and anomaly_handling=?))";
        List<Object> params = new ArrayList<>();
        params.add(userName);
        params.add("未巡检");
        params.add(userName);
        params.add("未处理");
        if (!jsonObject.getString("inspectionItem").isEmpty()) {
            selectSql += " and inspection_item=?";
            params.add(jsonObject.getString("inspectionItem"));
        }
        if (!jsonObject.getString("anomalyType").isEmpty()) {
            selectSql += " and anomaly_type=?";
            params.add(jsonObject.getString("anomalyType"));
        }
        if (!jsonObject.getString("inspectionStatus").isEmpty()) {
            selectSql += " and inspection_status=?";
            params.add(jsonObject.getString("inspectionStatus"));
        }
        if (!jsonObject.getString("anomalyHandling").isEmpty()) {
            selectSql += " and anomaly_handling=?";
            params.add(jsonObject.getString("anomalyHandling"));
        }
        if (!jsonObject.getString("inspectionNumber").isEmpty()) {
            selectSql += " and inspection_number like ?";
            params.add("%"+jsonObject.getString("inspectionNumber")+"%");
        }
        if (jsonObject.getInteger("parkingLotId")!=null) {
            selectSql += " and parking_lot_id=?";
            params.add(jsonObject.getInteger("parkingLotId"));
        }
//        List<Object> params = new ArrayList<>();
        JSONObject jsonObject1 = new JSONObject();
        Integer integer = sdkOfPaginationQueryCount(selectSql,params.toArray());
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        Object o = executeSQL(selectSql + selectLastSql, params.toArray());
        jsonObject1.put("total", integer);
        jsonObject1.put("data", o);
        return Result.buildSuccess(jsonObject1);
    }

    public Result uploadPic(MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        StringBuilder pathBuilder = new StringBuilder();
        String nowStr = sdf.format(new Date());
        StringBuilder append = pathBuilder.append(nowStr).append("_").append(file.getOriginalFilename());
        String s = "check" + "/" + append;
        minioUtil.uploadMultipartFile(file, s, MinIOConfig.pitureBucket);
        return Result.buildSuccess(minIoEchoUrl + s);
    }

    public Result check(JSONObject jsonObject) {
        String userName = sdkOfGetCurrentUserName();
        String anomalyType = jsonObject.getString("anomalyType");
        if (anomalyType.isEmpty())return new Result(false,"anomalyType 必填");
        String handler = jsonObject.getString("handler");
        String picUrl = jsonObject.getString("picUrl");
        String issueDescription = jsonObject.getString("issueDescription");
        Integer id = jsonObject.getInteger("id");
        if (id==null)return new Result(false,"id 必填");
        List<Object> params=new ArrayList<>();
        String updateSql="update inspection_records set anomaly_type=? , update_username=?,update_time=now() ,";
        params.add(anomalyType);
        params.add(userName);
        if (anomalyType.equals("无异常")){
            updateSql+="inspection_status=null ,";
            updateSql+="issue_description=null ,";
            updateSql+="issue_photo=null ,";
            updateSql+="anomaly_handling=null ,";
            updateSql+="handling_photo=null ,";
            updateSql+="handler=null ,";
            updateSql+="handling_date=null ,";
        }else {
            updateSql+="inspection_status='已巡检' ,";
            if (!handler.isEmpty()){
                updateSql+="handler=? ,";
                params.add(handler);
            }
            if (!issueDescription.isEmpty()){
                updateSql+="issue_description=? ,";
                params.add(issueDescription);
            }
            if (!picUrl.isEmpty()){
                picUrl=picUrl.replace(minIoEchoUrl,"");
                updateSql+="issue_photo=? ,";
                params.add(picUrl);
            }
        }
        updateSql=updateSql.substring(0,updateSql.length()-2);
        updateSql+=" where id=?";
        params.add(id);
        return Result.buildSuccess(executeSQL(updateSql,params.toArray()));
    }

    public Result processing(JSONObject jsonObject) {
        String userName = sdkOfGetCurrentUserName();
        String picUrl = jsonObject.getString("picUrl");
        Integer id = jsonObject.getInteger("id");
        String issueDescription = jsonObject.getString("issueDescription");
        if (id==null)return new Result(false,"id 必填");
        List<Object> params=new ArrayList<>();
        String updateSql="update inspection_records set update_username=?,update_time=now() ,handling_date=date(now()) ,anomaly_handling='已处理',handler=?,";
        params.add(userName);
        params.add(userName);
        if (!issueDescription.isEmpty()){
            updateSql+="issue_description=? ,";
            params.add(issueDescription);
        }
        if (!picUrl.isEmpty()){
            picUrl=picUrl.replace(minIoEchoUrl,"");
            updateSql+="handling_photo=? ,";
            params.add(picUrl);
        }
        updateSql=updateSql.substring(0,updateSql.length()-2);
        updateSql+=" where id=?";
        params.add(id);
        return Result.buildSuccess(executeSQL(updateSql,params.toArray()));
    }
}
