package com.gemcoder.system.service;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.InvoiceTitleTypeConstant;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.util.PathUtil.sdkOfGetRootPath;

@Service
public class WebOnlineinvoicingService {

    public ResponseEntity<Resource> exportTableData(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        List<Map<String, Object>> data;
        // 判断是否有勾选数据
        List<Integer> selectedIds = paramMap.get("selectedIds") != null ? (List<Integer>) paramMap.get("selectedIds") : new ArrayList<>();
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, sequence_number, order_number, license_plate, application_time, actual_payment, order_type, invoice_type, title_type, invoice_info, invoice_status, invoice_time, invoice_attachment, handler, operation FROM invoice_records WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (!selectedIds.isEmpty()) {
            // 如果有勾选数据，则只导出勾选的数据
            sql.append(" AND id IN (");
            for (int i = 0; i < selectedIds.size(); i++) {
                sql.append("?");
                if (i < selectedIds.size() - 1) {
                    sql.append(", ");
                }
                params.add(selectedIds.get(i));
            }
            sql.append(")");
            data = executeSQL(sql.toString(), params.toArray());
        } else {
            // 如果没有勾选数据，则导出前1000条数据
            int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
            sql.append(" LIMIT ?, ?");
            params.add((current - 1) * pageSize);
            params.add(pageSize);
            data = executeSQL(sql.toString(), params.toArray());
        }
        // 创建Excel文件
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Invoice Records");
        Row headerRow = sheet.createRow(0);
        String[] headersArray = { "ID", "序号", "订单编号", "车牌号", "申请时间", "实付金额", "订单类型", "发票类型", "抬头类型", "发票信息", "开票状态", "开票时间", "发票附件", "处理人", "操作" };
        for (int i = 0; i < headersArray.length; i++) {
            headerRow.createCell(i).setCellValue(headersArray[i]);
        }
        // 填充数据
        int rowNum = 1;
        for (Map<String, Object> record : data) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(record.get("id") != null ? String.valueOf(record.get("id")) : "");
            row.createCell(1).setCellValue(record.get("sequence_number") != null ? String.valueOf(record.get("sequence_number")) : "");
            row.createCell(2).setCellValue(record.get("order_number") != null ? String.valueOf(record.get("order_number")) : "");
            row.createCell(3).setCellValue(record.get("license_plate") != null ? String.valueOf(record.get("license_plate")) : "");
            row.createCell(4).setCellValue(record.get("application_time") != null ? String.valueOf(record.get("application_time")) : "");
            row.createCell(5).setCellValue(record.get("actual_payment") != null ? String.valueOf(record.get("actual_payment")) : "");
            row.createCell(6).setCellValue(record.get("order_type") != null ? String.valueOf(record.get("order_type")) : "");
            row.createCell(7).setCellValue(record.get("invoice_type") != null ? String.valueOf(record.get("invoice_type")) : "");
            row.createCell(8).setCellValue(record.get("title_type") != null ? String.valueOf(record.get("title_type")) : "");
            row.createCell(9).setCellValue(record.get("invoice_info") != null ? String.valueOf(record.get("invoice_info")) : "");
            row.createCell(10).setCellValue(record.get("invoice_status") != null ? String.valueOf(record.get("invoice_status")) : "");
            row.createCell(11).setCellValue(record.get("invoice_time") != null ? String.valueOf(record.get("invoice_time")) : "");
            row.createCell(12).setCellValue(record.get("invoice_attachment") != null ? String.valueOf(record.get("invoice_attachment")) : "");
            row.createCell(13).setCellValue(record.get("handler") != null ? String.valueOf(record.get("handler")) : "");
            row.createCell(14).setCellValue(record.get("operation") != null ? String.valueOf(record.get("operation")) : "");
        }
        // 保存Excel文件
        String rootPath = sdkOfGetRootPath();
        String filePath = File.separator + "upload" + File.separator + "InvoiceRecords.xlsx";
        File file = new File(rootPath + filePath);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        // 返回文件资源
        Resource resource = new FileSystemResource(file);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=InvoiceRecords.xlsx");
        return ResponseEntity.ok().headers(responseHeaders).body(resource);
    }

    public Result handleInvoiceUploadChange(Map<String, Object> paramMap) {
        // 获取上传的文件路径
        String invoiceAttachment = paramMap.get("invoiceAttachment") != null ? String.valueOf(paramMap.get("invoiceAttachment")) : null;
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查必要参数是否存在
        if (invoiceAttachment == null || id == null) {
            return new Result(false, "缺少必要参数", null);
        }
        // 获取项目系统路径
        String rootPath = sdkOfGetRootPath();
        String filePath = "." + File.separator + "staticResource" + File.separator + "upload" + File.separator + invoiceAttachment;
        // 更新数据库中的发票附件字段和开票状态
        StringBuilder sql = new StringBuilder("UPDATE invoice_records SET invoice_attachment = ?, invoice_status = ? WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(filePath);
        params.add("已开票");
        params.add(id);
        // 执行SQL更新操作
        int updateCount = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        if (updateCount > 0) {
            return new Result(true, "更新成功", null);
        } else {
            return new Result(false, "更新失败", null);
        }
    }

    public Result handleInvoiceUpdateChange(Map<String, Object> paramMap) {
        // 获取参数
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        String newAttachmentPath = paramMap.get("newAttachmentPath") != null ? String.valueOf(paramMap.get("newAttachmentPath")) : null;
        // 检查参数是否为空
        if (id == null || newAttachmentPath == null) {
            return new Result(false, "参数不能为空", null);
        }
        // 获取项目系统路径
        String rootPath = sdkOfGetRootPath();
        String filePath = File.separator + "upload" + File.separator + newAttachmentPath;
        String storagePath = "." + File.separator + "staticResource" + filePath;
        // 获取当前用户名
        String currentUsername = sdkOfGetCurrentUserName();
        // 获取当前时间
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 更新发票附件路径
        StringBuilder sql = new StringBuilder("UPDATE invoice_records SET invoice_attachment = ?, update_time = ?, update_username = ? WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(storagePath);
        params.add(currentTime);
        params.add(currentUsername);
        params.add(id);
        // 执行SQL更新操作
        int updateCount = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        if (updateCount > 0) {
            return new Result(true, "发票附件更新成功", null);
        } else {
            return new Result(false, "发票附件更新失败", null);
        }
    }

    public Result generalFetchTableData(Map<String, Object> paramMap) {
        // 从paramMap中获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 从paramMap中获取查询条件
        String orderNumber = paramMap.get("orderNumber") != null ? String.valueOf(paramMap.get("orderNumber")) : null;
        String licensePlate = paramMap.get("licensePlate") != null ? String.valueOf(paramMap.get("licensePlate")) : null;
        String invoiceHeader = paramMap.get("invoiceHeader") != null ? String.valueOf(paramMap.get("invoiceHeader")) : null;
        String applicationTimeStart = paramMap.get("applicationTimeStart") != null ? String.valueOf(paramMap.get("applicationTimeStart")) : null;
        String applicationTimeEnd = paramMap.get("applicationTimeEnd") != null ? String.valueOf(paramMap.get("applicationTimeEnd")) : null;
        String bailingStatus = paramMap.get("bailingStatus") != null ? String.valueOf(paramMap.get("bailingStatus")) : null;
        String bailingTimeStart = paramMap.get("bailingTimeStart") != null ? String.valueOf(paramMap.get("bailingTimeStart")) : null;
        String bailingTimeEnd = paramMap.get("bailingTimeEnd") != null ? String.valueOf(paramMap.get("bailingTimeEnd")) : null;
        String orderType = paramMap.get("orderType") != null ? String.valueOf(paramMap.get("orderType")) : null;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT * FROM invoice_records WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 添加模糊查询条件
        if (orderNumber != null && !orderNumber.isEmpty()) {
            sql.append(" AND order_number LIKE ?");
            params.add("%" + orderNumber + "%");
        }
        if (licensePlate != null && !licensePlate.isEmpty()) {
            sql.append(" AND license_plate LIKE ?");
            params.add("%" + licensePlate + "%");
        }
        if (invoiceHeader != null && !invoiceHeader.isEmpty()) {
            sql.append(" AND title_type LIKE ?");
            params.add("%" + invoiceHeader + "%");
        }
        // 添加精确查询条件
        if (applicationTimeStart != null && !applicationTimeStart.isEmpty() && applicationTimeEnd != null && !applicationTimeEnd.isEmpty()) {
            sql.append(" AND application_time BETWEEN ? AND ?");
            params.add(applicationTimeStart);
            params.add(applicationTimeEnd);
        }
        if (bailingStatus != null && !bailingStatus.isEmpty()) {
            sql.append(" AND invoice_status = ?");
            params.add(bailingStatus);
        }
        if (bailingTimeStart != null && !bailingTimeStart.isEmpty() && bailingTimeEnd != null && !bailingTimeEnd.isEmpty()) {
            sql.append(" AND invoice_time BETWEEN ? AND ?");
            params.add(bailingTimeStart);
            params.add(bailingTimeEnd);
        }
        if (orderType != null && !orderType.isEmpty()) {
            sql.append(" AND order_type = ?");
            params.add(orderType);
        }
        // 查询总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页
        sql.append(" LIMIT ?, ?");
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        for (Map<String, Object> datum : data) {
            JSONObject jsonObject =JSONObject.parseObject(JSONObject.toJSONString(datum));
            String str="";
            if (jsonObject.containsKey("invoice_type")){
                str+="发票类型:"+jsonObject.getString("invoice_type");
            }
            if (jsonObject.containsKey("title_type")){
                str+="\n抬头类型:"+jsonObject.getString("title_type");
            }
            String titleType = jsonObject.getString("title_type");
            if (titleType.equals(InvoiceTitleTypeConstant.Enterprise)){
                if (jsonObject.containsKey("title_name")){
                    str+="\n公司名称:"+jsonObject.getString("title_name");
                }else {
                    str+="\n公司名称:";
                }
                if (jsonObject.containsKey("tax_id_number")){
                    str+="\n税号:"+jsonObject.getString("tax_id_number");
                }else {
                    str+="\n税号:";

                }
                if (jsonObject.containsKey("register_addr")){
                    str+="\n注册地址:"+jsonObject.getString("register_addr");
                }else {
                    str+="\n注册地址:";
                }
                if (jsonObject.containsKey("register_phone")){
                    str+="\n注册电话:"+jsonObject.getString("register_phone");
                }else {
                    str+="\n注册电话:";
                }
                if (jsonObject.containsKey("bank")){
                    str+="\n开户银行:"+jsonObject.getString("bank");
                }else {
                    str+="\n开户银行:";
                }
                if (jsonObject.containsKey("bank_account")){
                    str+="\n银行账户:"+jsonObject.getString("bank_account");
                }else {
                    str+="\n银行账户:";

                }
            }else {
                if (jsonObject.containsKey("title_name")){
                    str+="\n抬头名称:"+jsonObject.getString("title_name");
                }else {
                    str+="\n抬头名称:";
                }
            }
            if (jsonObject.containsKey("e_mail")){
                str+="\n接收邮箱:"+jsonObject.getString("e_mail");
            }
            if (jsonObject.containsKey("phone")){
                str+="\n联系方式:"+jsonObject.getString("phone");
            }
            datum.put("invoice_info",str);
        }
        return new Result(true, "查询成功", resultData);
    }
}
