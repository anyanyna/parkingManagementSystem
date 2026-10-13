package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.bo.VehicleArrearsDownloadBo;
import com.gemcoder.system.bo.VehicleBlockListDownloadBo;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

@Service
public class VehicleArrearsService {
    private static final Logger log = LoggerFactory.getLogger(VehicleInYardService.class);

    @Resource
    UserSdkService userSdkService;




    /**
     * 根据条件查询分页数据
     * @author XueZhongHao
     * @date 2024/12/20
     * @param phone 手机号
     * @param plateNum 车牌
     * @param status 状态   0 待追缴  1 部分追缴 2 完成追缴 3 移除
     * @param overDay 0 1 2 单个数字精确查   1-2  2-4  横杠连接就查询范围
     * @param startTime1 创建时间范围1
     * @param startTime2 创建时间范围2
     * @param currentPage 当前页码
     * @param pageSize    每页大小
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getPageBy(String phone, String plateNum, String status, String overDay, Date startTime1, Date startTime2, Integer currentPage, Integer pageSize) {
        String selectLastSql = " order by a.id desc limit ?,?";
        Map<String, Object> selectPageSql = getSelectPageSql(phone, plateNum, status, overDay, startTime1, startTime2);
        List<Object> params = (List<Object>) selectPageSql.get("params");
        String sql = String.valueOf(selectPageSql.get("sql"));
        JSONObject res = new JSONObject();
        Integer count = sdkOfPaginationQueryCount(sql,params.toArray());
        params.add((currentPage-1)*pageSize);
        params.add(pageSize);
        Object o = executeSQL(sql + selectLastSql, params);
        res.put("total",count);
        res.put("data",o);
        return Result.buildSuccess(res);
    }

    /**
     * 保存追缴
     * @author XueZhongHao
     * @date 2024/12/20
     * @param code
     * @param recoveryNum
     * @param type
     * @return com.gemcoder.system.bo.Result
     **/
    public Result saveRecovery(String code, BigDecimal recoveryNum, String type) {
        JSONObject oneByCode = getOneByCode(code);
        if(oneByCode == null){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        String status = oneByCode.getString("status");
        if("2".equals(status) || "3".equals(status)){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        BigDecimal recoveryAmount = oneByCode.getBigDecimal("recovery_amount");
        if(Objects.isNull(recoveryAmount)){
            recoveryAmount=BigDecimal.ZERO;
        }
        recoveryAmount = recoveryAmount.add(recoveryNum);
        int i = updateOneByCode(code,recoveryAmount,"1".equals(type) ? "2":"1");
        if(i!=-1){
            return Result.buildSuccess(i);
        }else{
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }


    /**
     * 根据code移除一个记录
     * @author XueZhongHao
     * @date 2024/12/20
     * @param code
     * @return com.gemcoder.system.bo.Result
     **/
    public Result removeOneByCode(String code) {
        String updateSql = "update vehicle_arrears\n" +
                "set status = ?  \n" +
                "where code = ? ";
        int i = executeSQL(updateSql, "3", code);
        if(i!=-1){
            return Result.buildSuccess(i);
        }else{
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }


    /**
     * 根据条件获取下载文件
     * @author XueZhongHao
     * @date 2024/12/20
     **/
    public void download(HttpServletResponse response, String phone, String plateNum, String status, String overDay, Date startTime1, Date startTime2) throws IOException {
        List<VehicleArrearsDownloadBo> list = null;
        Map<String, Object> selectPageSql = getSelectPageSql(phone, plateNum, status, overDay, startTime1, startTime2);
        List<Object> params = (List<Object>) selectPageSql.get("params");
        String sql = String.valueOf(selectPageSql.get("sql"));
        Object o = executeSQL(sql + " order by a.id desc limit 1000 ", params.toArray());
        list = JSONObject.parseArray(JSONObject.toJSONString(o),VehicleArrearsDownloadBo.class);
        log.info("/VehicleArrears/download=======>导出数据，查出的数据size：{}",list.size());
        list.forEach(t->{
            String nowStatus = t.getStatus();
            t.setStatus("0".equals(nowStatus) ? "待追缴":"1".equals(nowStatus)?"部分追缴":"2".equals(nowStatus)?"完成追缴":"移除");
        });
        ExcelUtils.write(response, "车辆欠费.xlsx", "sheet1", VehicleArrearsDownloadBo.class, list, new int[]{});
    }


    /**
     * 根据code查询对应的订单信息
     * @author XueZhongHao
     * @date 2024/12/20
     * @param code
     * @return com.gemcoder.system.bo.Result
     **/
    public Result getRecordByCode(String code) {
        String selectSql = "select c.*\n" +
                "from vehicle_arrears a \n" +
                "join vehicle_arrears_record b on a.code = b.arrears_code \n" +
                "join user_order c on b.order_code =c.order_code \n" +
                "where a.code = ? order by b.id desc ";
        List<Map<String,Object>> list = executeSQL(selectSql, code);
        if(CollectionUtil.isEmpty(list)){
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
        return Result.buildSuccess(list);
    }



    private Map<String,Object> getSelectPageSql(String phone, String plateNum, String status, String overDay, Date startTime1, Date startTime2) {
        Map<String, Object> map = new HashMap<>();
        List<Object> params = new ArrayList<>();
        String selectSql = " select a.id,a.code,a.plate_num ,a.phone ,count(b.id) as total,sum(b.money_num) as moneyAmount, a.status,a.start_time,\n" +
                            "DATEDIFF(CURDATE(), DATE(a.start_time)) AS day_sum\n" +
                            "from vehicle_arrears a join vehicle_arrears_record b on a.code = b.arrears_code \n" +
                            "group by a.code \n" +
                            "having 1=1 ";
        if(!StringUtils.isEmpty(phone)){
            selectSql += " and a.phone like ? ";
            params.add("%" + phone +"%");
        }
        if(!StringUtils.isEmpty(plateNum)){
            selectSql += " and a.plate_num like ? ";
            params.add("%" + plateNum +"%");
        }
        if(!StringUtils.isEmpty(status)){
            selectSql += " and a.status = ? ";
            params.add(status);
        }
        if(!StringUtils.isEmpty(overDay)){
            if(overDay.contains("-")){
                String[] split = overDay.split("-");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                selectSql += " and ( day_sum >= ? and day_sum <= ? ) ";
                params.add(start);
                params.add(end);
            }else{
                selectSql += " and day_sum = ? ";
                params.add(overDay);
            }
        }
        if(Objects.nonNull(startTime1) && Objects.nonNull(startTime2)){
            selectSql += " and ( a.start_time >= ? and a.start_time <= ? ) ";
            params.add(startTime1);
            params.add(startTime2);
        }
        map.put("sql",selectSql);
        map.put("params",params);
        return map;
    }


    public JSONObject getOneByCode(String code){
        String selectSql = "select *\n" +
                            "from vehicle_arrears \n" +
                            "where 1=1 and code = ? ";
        List<Map<String,Object>> o = executeSQL(selectSql, code);
        if(Objects.isNull(o)){
            return null;
        }
        Map<String, Object> stringObjectMap = o.get(0);
        return JSONObject.parseObject(JSONObject.toJSONString(stringObjectMap));
    }

    public int updateOneByCode(String code,BigDecimal recoveryAmount, String status){
        String updateSql = "update vehicle_arrears\n" +
                            "set status = ? ,recovery_amount = ? \n" +
                            "where code = ? ";
        Integer i = executeSQL(updateSql, status, recoveryAmount, code);
        return i;
    }



}
