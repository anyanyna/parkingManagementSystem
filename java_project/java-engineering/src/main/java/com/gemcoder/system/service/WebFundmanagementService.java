package com.gemcoder.system.service;

import com.gemcoder.system.bo.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

@Service
public class WebFundmanagementService {

    public Result initializePaymentLogData(Map<String, Object> paramMap) {
        // 清空搜索区域-支付日志(ref=ref114)中的数据
        paramMap.put("platformSerialNumber1", "");
        paramMap.put("licenseplatenumber1", "");
        paramMap.put("sourceside1", null);
        paramMap.put("transactiontime1", new ArrayList<>());
        paramMap.put("yardname1", null);
        paramMap.put("businessType1", null);
        paramMap.put("thirdpartyserialnumber1", "");
        // 初始化支付日志表(ref=ref124)
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        StringBuilder sql = new StringBuilder("SELECT id, serial_number, phone_number, license_plate, transaction_time, amount, parking_lot_name, source_terminal, business_type, platform_serial_number, third_party_serial_number FROM finance_management WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 查询总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页
        sql.append(" LIMIT ?, ?");
        // 创建新的参数列表用于分页
        List<Object> paginationParams = new ArrayList<>(params);
        paginationParams.add((current - 1) * pageSize);
        paginationParams.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), paginationParams.toArray());
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "初始化成功", resultData);
    }

    public Result initializeTransactionQueryData(Map<String, Object> paramMap) {
        // 初始化返回结果
        Result result = new Result();
        result.setFlag(false);
        result.setMessage("初始化失败");
        try {
            // 清空搜索区域-交易查询(ref=ref89)中的数据
            paramMap.put("licenseplatenumber1", "");
            paramMap.put("sourceside", null);
            paramMap.put("transactiontime", new ArrayList<>());
            paramMap.put("yardname", new ArrayList<>());
            paramMap.put("paymentType", new ArrayList<>());
            paramMap.put("businessType", new ArrayList<>());
            paramMap.put("platformSerialNumber1", "");
            // 初始化交易查询表(ref=ref99)
            Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
            Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
            // 构建查询SQL
            StringBuilder sql = new StringBuilder("SELECT id, serial_number AS serialNumber1, license_plate AS licenseplatenumber1, parking_lot_name AS yardname, transaction_time, transaction_amount, payment_channel AS paymentType, source_terminal AS sourceside, business_type AS businessType, settlement_party, platform_serial_number, third_party_serial_number FROM finance_management WHERE 1=1");
            List<Object> params = new ArrayList<>();
            // 查询总条数
            int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
            // 添加分页
            sql.append(" LIMIT ?, ?");
            params.add((current - 1) * pageSize);
            params.add(pageSize);
            // 执行查询
            List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
            // 设置返回结果
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("total", total);
            dataMap.put("data", data);
            result.setFlag(true);
            result.setMessage("初始化成功");
            result.setData(dataMap);
        } catch (Exception e) {
            result.setMessage("初始化异常: " + e.getMessage());
        }
        return result;
    }

    public Result initializeIncomeFlowData(Map<String, Object> paramMap) {
        // 清空搜索区域-收入流水中的数据
        paramMap.put("mobilephonenumber", "");
        paramMap.put("arrivalTime", new ArrayList<>());
        paramMap.put("licenseplatenumber", "");
        paramMap.put("type", null);
        paramMap.put("paymentchannel", null);
        paramMap.put("thirdpartyserialnumber", "");
        paramMap.put("platformSerialNumber", "");
        // 初始化收入流水表中的数据
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        StringBuilder sql = new StringBuilder("SELECT id, serial_number, phone_number, license_plate, arrival_time, amount, payment_channel, source_terminal, type, user_payment_method, region, platform_serial_number, third_party_serial_number FROM finance_management WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 查询总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页
        sql.append(" LIMIT ?, ?");
        // 创建新的参数列表用于分页
        List<Object> paginationParams = new ArrayList<>(params);
        paginationParams.add((current - 1) * pageSize);
        paginationParams.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), paginationParams.toArray());
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "初始化成功", resultData);
    }

    public Result generalQueryIncomeFlowList(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, serial_number, phone_number, license_plate, arrival_time, amount, payment_channel, source_terminal, type, user_payment_method, region, platform_serial_number, third_party_serial_number FROM finance_management WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 模糊查询条件
        String phoneNumber = paramMap.get("phone_number") != null ? String.valueOf(paramMap.get("phone_number")) : null;
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            sql.append(" AND phone_number LIKE ?");
            params.add("%" + phoneNumber + "%");
        }
        String licensePlate = paramMap.get("license_plate") != null ? String.valueOf(paramMap.get("license_plate")) : null;
        if (licensePlate != null && !licensePlate.isEmpty()) {
            sql.append(" AND license_plate LIKE ?");
            params.add("%" + licensePlate + "%");
        }
        String thirdPartySerialNumber = paramMap.get("third_party_serial_number") != null ? String.valueOf(paramMap.get("third_party_serial_number")) : null;
        if (thirdPartySerialNumber != null && !thirdPartySerialNumber.isEmpty()) {
            sql.append(" AND third_party_serial_number LIKE ?");
            params.add("%" + thirdPartySerialNumber + "%");
        }
        String platformSerialNumber = paramMap.get("platform_serial_number") != null ? String.valueOf(paramMap.get("platform_serial_number")) : null;
        if (platformSerialNumber != null && !platformSerialNumber.isEmpty()) {
            sql.append(" AND platform_serial_number LIKE ?");
            params.add("%" + platformSerialNumber + "%");
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
        return new Result(true, "查询成功", resultData);
    }

    public Result generalQueryTransactionListData(Map<String, Object> paramMap) {
        // 获取查询参数
        String licensePlateNumber = paramMap.get("licensePlate") != null ? String.valueOf(paramMap.get("licensePlate")) : null;
        String platformSerialNumber = paramMap.get("platformSerialNumber") != null ? String.valueOf(paramMap.get("platformSerialNumber")) : null;
        String sourceSide = paramMap.get("sourceTerminal") != null ? String.valueOf(paramMap.get("sourceTerminal")) : null;
        String yardName = paramMap.get("parkingLotName") != null ? String.valueOf(paramMap.get("parkingLotName")) : null;
        String paymentType = paramMap.get("paymentChannel") != null ? String.valueOf(paramMap.get("paymentChannel")) : null;
        String businessType = paramMap.get("businessType") != null ? String.valueOf(paramMap.get("businessType")) : null;
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, serial_number AS serialNumber, license_plate AS licensePlate, parking_lot_name AS parkingLotName, transaction_time, amount AS transactionAmount, payment_channel AS paymentChannel, source_terminal AS sourceTerminal, business_type, settlement_party, platform_serial_number, third_party_serial_number FROM finance_management WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 添加模糊查询条件
        if (licensePlateNumber != null && !licensePlateNumber.isEmpty()) {
            sql.append(" AND license_plate LIKE ?");
            params.add("%" + licensePlateNumber + "%");
        }
        if (platformSerialNumber != null && !platformSerialNumber.isEmpty()) {
            sql.append(" AND platform_serial_number LIKE ?");
            params.add("%" + platformSerialNumber + "%");
        }
        if (sourceSide != null && !sourceSide.isEmpty()) {
            sql.append(" AND source_terminal = ?");
            params.add(sourceSide);
        }
        if (yardName != null && !yardName.isEmpty()) {
            sql.append(" AND parking_lot_name = ?");
            params.add(yardName);
        }
        if (paymentType != null && !paymentType.isEmpty()) {
            sql.append(" AND payment_channel = ?");
            params.add(paymentType);
        }
        if (businessType != null && !businessType.isEmpty()) {
            sql.append(" AND business_type = ?");
            params.add(businessType);
        }
        // 查询总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页条件
        sql.append(" LIMIT ?, ?");
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "查询成功", resultData);
    }

    public Result generalQueryPaymentLogList(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, serial_number, phone_number, license_plate, transaction_time, amount, parking_lot_name, source_terminal, business_type, platform_serial_number, third_party_serial_number, payment_channel, type, user_payment_method, region, settlement_party, create_username, create_time, update_time, update_username, arrival_time, payment_type, transaction_amount, sequence_number FROM finance_management WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 模糊查询条件
        String licensePlate = paramMap.get("licensePlate") != null ? String.valueOf(paramMap.get("licensePlate")) : null;
        if (licensePlate != null && !licensePlate.isEmpty()) {
            sql.append(" AND license_plate LIKE ?");
            params.add("%" + licensePlate + "%");
        }
        String platformSerialNumber = paramMap.get("platformSerialNumber") != null ? String.valueOf(paramMap.get("platformSerialNumber")) : null;
        if (platformSerialNumber != null && !platformSerialNumber.isEmpty()) {
            sql.append(" AND platform_serial_number LIKE ?");
            params.add("%" + platformSerialNumber + "%");
        }
        String thirdPartySerialNumber = paramMap.get("thirdPartySerialNumber") != null ? String.valueOf(paramMap.get("thirdPartySerialNumber")) : null;
        if (thirdPartySerialNumber != null && !thirdPartySerialNumber.isEmpty()) {
            sql.append(" AND third_party_serial_number LIKE ?");
            params.add("%" + thirdPartySerialNumber + "%");
        }
        // 精确查询条件
        String sourceTerminal = paramMap.get("sourceTerminal") != null ? String.valueOf(paramMap.get("sourceTerminal")) : null;
        if (sourceTerminal != null && !sourceTerminal.isEmpty()) {
            sql.append(" AND source_terminal = ?");
            params.add(sourceTerminal);
        }
        String businessType = paramMap.get("businessType") != null ? String.valueOf(paramMap.get("businessType")) : null;
        if (businessType != null && !businessType.isEmpty()) {
            sql.append(" AND business_type = ?");
            params.add(businessType);
        }
        String parkingLotName = paramMap.get("parkingLotName") != null ? String.valueOf(paramMap.get("parkingLotName")) : null;
        if (parkingLotName != null && !parkingLotName.isEmpty()) {
            sql.append(" AND parking_lot_name = ?");
            params.add(parkingLotName);
        }
        // 交易时间范围查询
        List<Object> transactionTime = paramMap.get("transactionTime") != null ? (List<Object>) paramMap.get("transactionTime") : null;
        if (transactionTime != null && transactionTime.size() == 2) {
            sql.append(" AND transaction_time BETWEEN ? AND ?");
            params.add(transactionTime.get(0));
            params.add(transactionTime.get(1));
        }
        // 获取总条数
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
        return new Result(true, "查询成功", resultData);
    }
}
