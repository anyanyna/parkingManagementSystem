package com.gemcoder.system.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;
import com.gemcoder.system.util.InvoiceStatusConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class InvoiceService {
    @Autowired
    private MinioUtil minioUtil;
    @Value("${minio.echoUrl}")
    private String minIoEchoUrl;

    public Result getList(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String status = jsonObject.getString("status");
        String selectLastSql = " order by uo.id desc limit ?,?";
        String userName = sdkOfGetCurrentUserName();
        String selectSql = "SELECT\n" +
                "\tuo.parking_lot,\n" +
                "\tuo.license_plate,\n" +
                "\tuo.order_code,\n" +
                "\tuo.parking_lot_id,\n" +
                "\tDATE_FORMAT(uo.entry_time,'%Y-%m-%d %h:%i:%s') entry_time,\n" +
                "\tuo.parking_duration,\n" +
                "\tuo.payment_amount,\n" +
                "\tir.invoice_attachment,\n" +
                "\tIFNULL(ir.invoice_status,\"待申请开票\") invoice_status\n" +
                "FROM\n" +
                "\tuser_order uo \n" +
                "\tleft JOIN\n" +
                "\tinvoice_records ir \n" +
                "\ton uo.order_code=ir.order_number\n" +
                "WHERE\n" +
                "\tuo.license_plate IN ( SELECT license_plate FROM `parking_lot_user_vehicle` WHERE user_code = ? ) \n" +
                "\tAND order_status = '已完结' \n" +
                "\tAND payment_status = '已支付'\n";
        if (!StringUtils.isEmpty(status)) {
            selectSql += " and invoice_status= ?";
        }
        List<Object> params = new ArrayList<>();
        JSONObject jsonObject1 = new JSONObject();
        Integer integer = sdkOfPaginationQueryCount(selectSql,userName);
        params.add(userName);
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql + selectLastSql, params.toArray())));
        for (Object o : jsonArray) {
            JSONObject jsonObject2=(JSONObject) o;
            if (jsonObject2.containsKey("invoice_attachment")){
                jsonObject2.put("invoice_attachment",minIoEchoUrl+jsonObject2.getString("invoice_attachment"));
            }
        }
        jsonObject1.put("total", integer);
        jsonObject1.put("data", jsonArray);
        return Result.buildSuccess(jsonObject1);
    }

    public Result applyInvoice(JSONObject jsonObject) {
        String userName = sdkOfGetCurrentUserName();
        String orderCode=jsonObject.getString("orderCode");
        if (StringUtils.isEmpty(orderCode))return new Result(false,"orderCode 必填");
        String selectAmountSql="select payment_amount,license_plate from user_order where order_code=?";
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectAmountSql, orderCode)));
        BigDecimal paymentAmount = jsonArray.getJSONObject(0).getBigDecimal("payment_amount");
        String licensePlate = jsonArray.getJSONObject(0).getString("license_plate");
        Integer parkingLotId=jsonObject.getInteger("parkingLotId");
        if (StringUtils.isEmpty(parkingLotId))return new Result(false,"parkingLotId 必填");
        String titleType=jsonObject.getString("titleType");
        if (StringUtils.isEmpty(titleType))return new Result(false,"titleType 必填");
        String titleName=jsonObject.getString("titleName");
        if (StringUtils.isEmpty(titleName))return new Result(false,"titleName 必填");
        String taxIdNumber=jsonObject.getString("taxIdNumber");
        String invoiceType=jsonObject.getString("invoiceType");
        if (StringUtils.isEmpty(invoiceType))return new Result(false,"invoiceType 必填");
        String registerAddr=jsonObject.getString("registerAddr");
        String registerPhone=jsonObject.getString("registerPhone");
        String bank=jsonObject.getString("bank");
        String bankAccount=jsonObject.getString("bankAccount");
        String eMail=jsonObject.getString("eMail");
        String phone=jsonObject.getString("phone");
        LocalDateTime now = LocalDateTime.now();
        String insertSql="INSERT INTO `invoice_records` (\n" +
                "\t`order_number`,\n" +
                "\t`license_plate`,\n" +
                "\t`application_time`,\n" +
                "\t`actual_payment`,\n" +
                "\t`order_type`,\n" +
                "\t`invoice_type`,\n" +
                "\t`title_type`,\n" +
                "\t`invoice_status`,\n" +
                "\t`create_username`,\n" +
                "\t`create_time`,\n" +
                "\t`title_name`,\n" +
                "\t`tax_id_number`,\n" +
                "\t`register_addr`,\n" +
                "\t`register_phone`,\n" +
                "\t`bank`,\n" +
                "\t`bank_account`,\n" +
                "\t`e_mail`,\n" +
                "\t`phone`,\n" +
                "\t`parking_lot_id` \n" +
                ")\n" +
                "VALUES\n" +
                "\t(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> params = Arrays.asList(orderCode, licensePlate, now, paymentAmount, "停车订单", invoiceType, titleType, InvoiceStatusConstant.Billed, userName, now, titleName, taxIdNumber, registerAddr, registerPhone, bank, bankAccount, eMail, phone, parkingLotId);
        Object o = executeSQL(insertSql, params.toArray());
        return Result.buildSuccess(o);
    }

    public Result getHeadUpList() {
        String userName = sdkOfGetCurrentUserName();
        String sql="select * from user_invoice where create_username=? order by id desc";
        return Result.buildSuccess(executeSQL(sql,userName));
    }

    public Result insertHeadUp(JSONObject jsonObject) {
        String userName = sdkOfGetCurrentUserName();
        String titleType=jsonObject.getString("titleType");
        if (StringUtils.isEmpty(titleType))return new Result(false,"titleType 必填");
        String titleName=jsonObject.getString("titleName");
        if (StringUtils.isEmpty(titleName))return new Result(false,"titleName 必填");
        String taxIdNumber=jsonObject.getString("taxIdNumber");
        String registerAddr=jsonObject.getString("registerAddr");
        String registerPhone=jsonObject.getString("registerPhone");
        String bank=jsonObject.getString("bank");
        String bankAccount=jsonObject.getString("bankAccount");
        String insertSql="INSERT INTO `user_invoice` ( `title_type`, `create_username`, `create_time`, `title_name`, `tax_id_number`, `register_addr`, `bank`, `register_phone`, `bank_account` )\n" +
                "VALUES\n" +
                "\t(?,?,?,?,?,?,?,?,?)";
        List<Object> params = Arrays.asList(titleType, userName, LocalDateTime.now(), titleName, taxIdNumber, registerAddr, bank, registerPhone, bankAccount);
        return Result.buildSuccess(executeSQL(insertSql,params.toArray()));
    }

    public Result deleteHeadUp(Integer id) {
        if (id==null) return new Result(false,"id 必填");
        return Result.buildSuccess(executeSQL("delete from user_invoice where id=?",id));
    }

    public Result uploadFile(MultipartFile file, Integer id) {
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL("select * from invoice_records where id=?", id)));
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String fileName="invoice/invoice_"+ jsonObject.getString("order_number")+"_"+jsonObject.getString("license_plate")+"_"+file.getOriginalFilename();;
        minioUtil.uploadMultipartFile(file,fileName, MinIOConfig.pitureBucket);
        String updateSql="update invoice_records set invoice_attachment=?,invoice_status=? where id=?";
        return Result.buildSuccess(executeSQL(updateSql,fileName,InvoiceStatusConstant.InvoicedOut,id));
    }
}
