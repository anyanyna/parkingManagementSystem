package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

@Service
public class AppHomePageService {
    public Result getOrderStatus(Integer parkingId) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startTime = LocalDateTime.of(now, LocalTime.MIN).format(dateTimeFormatter);
        String endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);
        JSONObject result = new JSONObject();
        result.put("countOrder", getCountOrder(parkingId, startTime, endTime));
        result.put("normalOrder", getNormalOrder(parkingId, startTime, endTime));
        result.put("exceptionOrder", getExceptionOrder(parkingId, startTime, endTime));
        return new Result(true, "Success", result);
    }

    public Result getIncome(Integer parkingId) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startTime = LocalDateTime.of(now, LocalTime.MIN).format(dateTimeFormatter);
        String endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);
        JSONObject result = new JSONObject();
        result.put("parkReceive", getActualAmount(parkingId, startTime, endTime));
        result.put("receivableAmount", getReceivableAmountByParkingLotId(parkingId, startTime, endTime));
        result.put("offlineAmount", getOfflineAmount(parkingId, startTime, endTime));
        result.put("onlineAmount", getOnlineAmount(parkingId, startTime, endTime));
        return new Result(true, "Success", result);
    }

    /**
     * 今日异常订单
     */
    private BigDecimal getExceptionOrder(Integer id, String statTime, String endTime) {
        String selectSql = "select count(1) receivableAmount from user_order where 1=1 and order_status in ('关闭','异常') ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, statTime, endTime);
    }

    /**
     * 今日正常订单
     *
     * @param id
     * @return
     */
    private BigDecimal getNormalOrder(Integer id, String statTime, String endTime) {
        String selectSql = "select count(1) receivableAmount from user_order where 1=1 and order_status in ('已完结','已支付，待离场','车辆入场') ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, statTime, endTime);
    }

    /**
     * 今日总订单
     *
     * @param id
     * @return
     */
    private BigDecimal getCountOrder(Integer id, String statTime, String endTime) {
        String selectSql = "select count(1) receivableAmount from user_order where 1=1 and order_status in ('关闭','异常','已完结','已支付，待离场','车辆入场') ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, statTime, endTime);
    }

    /**
     * 今日实收
     *
     * @param id
     * @return
     */
    private BigDecimal getReceivableAmountByParkingLotId(Integer id, String startTime, String endTime) {
        String selectSql = "select sum(receivable_amount) receivableAmount from user_order where 1=1 ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, startTime, endTime);
    }

    /**
     * 今日线上收费
     *
     * @param id
     * @return
     */
    private BigDecimal getOnlineAmount(Integer id, String startTime, String endTime) {
        String selectSql = "select sum(received_amount) receivableAmount from user_order where 1=1 and payment_channel !='线下缴费' ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, startTime, endTime);
    }

    /**
     * 今日线下收费
     *
     * @param id
     * @return
     */
    private BigDecimal getOfflineAmount(Integer id, String startTime, String endTime) {
        String selectSql = "select sum(received_amount) receivableAmount from user_order where 1=1 and payment_channel='线下缴费' ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, startTime, endTime);

    }

    private BigDecimal getValueByParkingLotId(String sql, String filedName, Integer id) {
        JSONArray jsonArray;
        if (id != null) {
            sql += "and parking_lot_id=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(sql, id)));
        } else {
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(sql)));
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        if (CollectionUtil.isNotEmpty(jsonObject)) {
            return jsonObject.getBigDecimal(filedName);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getValueByParkingLotIdAndDate(String sql, String filedName, Integer id, String startTime, String endTime) {
        JSONArray jsonArray;
        if (id != null) {
            sql += "and parking_lot_id=? and exit_time>=? and exit_time<=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(sql, id, startTime, endTime)));
        } else {
            sql += " and exit_time>=? and exit_time<=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(sql, startTime, endTime)));
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        if (CollectionUtil.isNotEmpty(jsonObject)) {
            return jsonObject.getBigDecimal(filedName);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 今日应收
     *
     * @param id
     * @return
     */
    private BigDecimal getActualAmount(Integer id, String startTime, String endTime) {
        String selectSql = "select sum(received_amount) receivableAmount from user_order where 1=1 ";
        return getValueByParkingLotIdAndDate(selectSql, "receivableAmount", id, startTime, endTime);
    }

    /**
     * 应收实收echarts数据
     *
     * @param id
     * @return
     */
    private JSONArray getReceivableAndPaid(Integer id, String startTime, String endTime) {
        List<Object> array = new ArrayList<>();
        array.add(startTime);
        array.add(endTime);
        String selectSql = "select sum(received_amount) receivedAmount,sum(receivable_amount) receivableAmount,DATE_FORMAT(exit_time,'%y-%m-%d') `date` from user_order where 1=1 and exit_time>=? and exit_time<=? ";
        if (id != null) {
            selectSql += " and parking_lot_id=?";
            array.add(id);
        }
        selectSql += " group by `date`";
        return JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, array.toArray())));

    }

    /**
     * 获取时间范围内的使用率 每天
     *
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    private JSONArray getUsageRateArray(Integer id, String startTime, String endTime) {
        List<Object> array = new ArrayList<>();
        array.add(startTime);
        array.add(endTime);
        String selectSql = "select (count(1)+0.0)/sum(b.parking_spaces) as ratio,DATE_FORMAT(exit_time,'%y-%m-%d') `date` from user_order a join parking_lot_info  b on a.parking_lot_id=b.id where 1=1  and a.create_time>=? and a.create_time<=? ";
        if (id != null) {
            selectSql += " and parking_lot_id=?";
            array.add(id);
        }
        selectSql += " group by `date`";
        return JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, array.toArray())));
    }

    /**
     * 获取时间范围内的周转 每天
     *
     * @param id
     * @param startTime
     * @param endTime
     * @return
     */
    private JSONArray getTurnoverRateArray(Integer id, String startTime, String endTime) {
        List<Object> array = new ArrayList<>();
        array.add(startTime);
        array.add(endTime);
        String selectSql = "select (count(1)+0.0)/sum(b.parking_spaces) as ratio,DATE_FORMAT(exit_time,'%y-%m-%d') `date` from user_order a join parking_lot_info  b on a.parking_lot_id=b.id where 1=1  and exit_time>=? and exit_time<=? ";
        if (id != null) {
            selectSql += " and parking_lot_id=?";
            array.add(id);
        }
        selectSql += " group by `date`";
        return JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, array.toArray())));
    }

    /**
     * 今日车位使用率
     *
     * @param id
     * @return
     */
    private BigDecimal getUsageRate(Integer id, String startTime, String endTime) {
        String selectSql = "select (count(1)+0.0)/sum(b.parking_spaces) as ratio from user_order a join parking_lot_info  b on a.parking_lot_id=b.id where 1=1  ";
        JSONArray jsonArray;
        if (id != null) {
            selectSql += "and parking_lot_id=? and a.create_time>=? and a.create_time<=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, id, startTime, endTime)));
        } else {
            selectSql += " and a.create_time>=? and a.create_time<=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, startTime, endTime)));
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        if (CollectionUtil.isNotEmpty(jsonObject)) {
            return jsonObject.getBigDecimal("ratio");
        }
        return BigDecimal.ZERO;
    }
    /**
     * 今日车位周转率
     *
     * @param id
     * @return
     */
    private BigDecimal getTurnoverRate(Integer id, String startTime, String endTime) {
        String selectSql = "select (count(1)+0.0)/sum(b.parking_spaces) as ratio from user_order a join parking_lot_info  b on a.parking_lot_id=b.id where 1=1  ";
        return getValueByParkingLotIdAndDate(selectSql, "ratio", id, startTime, endTime);
    }

    /**
     * 今日入口流量
     *
     * @param id
     * @return
     */
    private BigDecimal getInRate(Integer id) {
        String selectSql = "SELECT COUNT(*) as inNum FROM vehicle_raw_inout_record where DATE(create_time)=DATE(NOW()) and in_out='in' ";
        return getValueByParkingLotId(selectSql, "inNum", id);
    }

    /**
     * 今日出口流量
     *
     * @param id
     * @return
     */
    private BigDecimal getOutRate(Integer id) {
        String selectSql = "SELECT COUNT(*) as outNum FROM vehicle_raw_inout_record where DATE(create_time)=DATE(NOW()) and in_out='out' ";
        return getValueByParkingLotId(selectSql, "outNum", id);
    }

    /**
     * 获取车位总数
     *
     * @param id
     * @return
     */
    private BigDecimal getTotalParkingSpace(Integer id) {
        String selectSql = "select  sum(parking_spaces) as parking_total from parking_lot_info where 1=1";
        JSONArray jsonArray;
        if (id != null) {
            selectSql += " and id=?";
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql, id)));
        } else {
            jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql)));
        }
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        if (CollectionUtil.isNotEmpty(jsonObject)) {
            return jsonObject.getBigDecimal("parking_total");
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getUseSpace(Integer id) {
        String selectSql = "select  count(1) as use_space from user_order where 1=1 and exit_time is null and order_status in ('已支付，待离场','车辆入场') ";
        return getValueByParkingLotId(selectSql, "use_space", id);
    }

    public Result getFlowRate(Integer parkingId) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startTime = LocalDateTime.of(now, LocalTime.MIN).format(dateTimeFormatter);
        String endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);
        JSONObject result = new JSONObject();
        result.put("usageRate", getUsageRate(parkingId, startTime, endTime));
        result.put("inRate", getInRate(parkingId));
        result.put("outRate", getOutRate(parkingId));
        BigDecimal totalParkingSpace = getTotalParkingSpace(parkingId);
        BigDecimal useSpace = getUseSpace(parkingId);
        BigDecimal subtract = totalParkingSpace.subtract(useSpace);
        int i = subtract.intValue();
        result.put("useSpace", useSpace);
        result.put("idle", Math.max(i, 0));
        return new Result(true, "Success", result);
    }

    /**
     * @param type 0今日 1昨日 2本周 3本月 4近7天 5上周
     * @return
     */

    private JSONObject getStartAndEndTIme(Integer type) {
        //type 0 1  2 3 0今日 1昨日 2本周 3本月 4过去7天
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startTime = "";
        String endTime = "";
        if (type.equals(0)) {
            startTime = LocalDateTime.of(now, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);
        } else if (type.equals(1)) {
            LocalDate localDate = now.minusDays(1);
            startTime = LocalDateTime.of(localDate, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);
        } else if (type.equals(2)) {
            // 本周第一天（周一）
            LocalDate firstDayOfWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            // 本周最后一天（周日）
            LocalDate lastDayOfWeek = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            startTime = LocalDateTime.of(firstDayOfWeek, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(lastDayOfWeek, LocalTime.MAX).format(dateTimeFormatter);
        } else if (type.equals(3)) {
            // 本周第一天（周一）
            LocalDate firstDayOfWeek = now.with(TemporalAdjusters.firstDayOfMonth());
            // 本周最后一天（周日）
            LocalDate lastDayOfWeek = now.with(TemporalAdjusters.lastDayOfMonth());
            startTime = LocalDateTime.of(firstDayOfWeek, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(lastDayOfWeek, LocalTime.MAX).format(dateTimeFormatter);
        } else if (type.equals(4)) {
            LocalDate localDate = now.minusDays(6);
            startTime = LocalDateTime.of(localDate, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(now, LocalTime.MAX).format(dateTimeFormatter);

        } else if (type.equals(5)) {
            // 上周第一天（周一）
            LocalDate localDate = now.minusWeeks(1);
            LocalDate firstDayOfWeek = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            // 上周最后一天（周日）
            LocalDate lastDayOfWeek = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            startTime = LocalDateTime.of(firstDayOfWeek, LocalTime.MIN).format(dateTimeFormatter);
            endTime = LocalDateTime.of(lastDayOfWeek, LocalTime.MAX).format(dateTimeFormatter);

        }
        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)) {
            return null;
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("startTime", startTime);
            jsonObject.put("endTime", endTime);
            return jsonObject;
        }
    }

    public Result getIncomeByType(Integer parkingId, Integer type) {
        JSONObject startAndEndTIme = getStartAndEndTIme(type);
        if (CollectionUtil.isNotEmpty(startAndEndTIme)) {
            String startTime = startAndEndTIme.getString("startTime");
            String endTime = startAndEndTIme.getString("endTime");
            JSONObject result = new JSONObject();
            result.put("parkReceive", getActualAmount(parkingId, startTime, endTime));
            result.put("receivableAmount", getReceivableAmountByParkingLotId(parkingId, startTime, endTime));
            result.put("offlineAmount", getOfflineAmount(parkingId, startTime, endTime));
            result.put("onlineAmount", getOnlineAmount(parkingId, startTime, endTime));
            return new Result(true, "Success", result);
        } else {
            return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
        }
    }

    public Result get7DayIncome(Integer parkingId) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        JSONObject startAndEndTIme = getStartAndEndTIme(4);
        if (CollectionUtil.isNotEmpty(startAndEndTIme)) {
            String startTime = startAndEndTIme.getString("startTime");
            String endTime = startAndEndTIme.getString("endTime");
            LocalDateTime parse = LocalDateTime.parse(startTime, dateTimeFormatter);
            parse = parse.minusDays(1);
            JSONObject result = new JSONObject();
            result.put("parkReceive", getActualAmount(parkingId, startTime, endTime).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
            result.put("receivableAmount", getReceivableAmountByParkingLotId(parkingId, startTime, endTime).divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
            JSONArray receivableAndPaid = getReceivableAndPaid(parkingId, startTime, endTime);
            JSONArray resultJson = new JSONArray();
            for (int i = 1; i <= 7; i++) {
                LocalDateTime localDateTime = parse.plusDays(i);
                LocalDate localDate = localDateTime.toLocalDate();
                String format = localDate.format(DateTimeFormatter.ofPattern("yy-MM-dd"));
                JSONObject resultobj = new JSONObject();
                resultobj.put("date", format);
                resultobj.put("receivableAmount", BigDecimal.ZERO);
                resultobj.put("receivedAmount", BigDecimal.ZERO);
                for (Object o : receivableAndPaid) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    if (format.equals(obj.getString("date"))) {
                        resultobj.put("receivableAmount", obj.getBigDecimal("receivableAmount").divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        resultobj.put("receivedAmount", obj.getBigDecimal("receivedAmount").divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
                    }
                }
                resultJson.add(resultobj);
            }
            result.put("echartsValue", resultJson);
            return new Result(true, "Success", result);
        } else {
            return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
        }
    }

    public Result getOrderCount(Integer parkingId, Integer type) {
        JSONObject startAndEndTIme = getStartAndEndTIme(type);
        if (CollectionUtil.isNotEmpty(startAndEndTIme)) {
            String startTime = startAndEndTIme.getString("startTime");
            String endTime = startAndEndTIme.getString("endTime");
            JSONObject result = new JSONObject();
            result.put("countOrder", getCountOrder(parkingId, startTime, endTime));
            result.put("normalOrder", getNormalOrder(parkingId, startTime, endTime));
            result.put("exceptionOrder", getExceptionOrder(parkingId, startTime, endTime));
            return new Result(true, "Success", result);
        } else {
            return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
        }
    }

    public Result get7DayUtilizationRate(Integer parkingId) {
        JSONObject startAndEndTIme = getStartAndEndTIme(4);
        if (CollectionUtil.isNotEmpty(startAndEndTIme)) {
            String startTime = startAndEndTIme.getString("startTime");
            String endTime = startAndEndTIme.getString("endTime");
            JSONObject firstWeek = getStartAndEndTIme(5);
            String firstWeekStartTime = firstWeek.getString("startTime");
            String firstWeekEndTime = firstWeek.getString("endTime");
            JSONObject weekTime = getStartAndEndTIme(2);
            String weekStartTime = weekTime.getString("startTime");
            String weekEndTime = weekTime.getString("endTime");
            JSONObject result = new JSONObject();
            result.put("usageRate", getUsageRate(parkingId, startTime, endTime));
            JSONArray usageRateArray = getUsageRateArray(parkingId, weekStartTime, weekEndTime);
            JSONArray usageRateArray1 = getUsageRateArray(parkingId, firstWeekStartTime, firstWeekEndTime);
            JSONArray resultJson = new JSONArray();
            for (int i = 0; i < 7; i++) {
                //本周开始的第一天
                LocalDate weekStartDate = LocalDate.parse(weekStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusDays(i);
                JSONObject resultobj = new JSONObject();
                resultobj.put("index", weekStartDate.getDayOfMonth());
                resultobj.put("week", 0);
                resultobj.put("lastWeek", 0);
                for (Object o : usageRateArray) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    String date = obj.getString("date");
                    LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yy-MM-dd"));
                    if (weekStartDate.isEqual(parse)) {
                        resultobj.put("week", obj.getBigDecimal("ratio").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        break;
                    }
                }
                for (Object o : usageRateArray1) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    String date = obj.getString("date");
                    LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yy-MM-dd")).plusDays(7);
                    if (weekStartDate.isEqual(parse)) {
                        resultobj.put("week", obj.getBigDecimal("ratio").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        break;
                    }
                }
                resultJson.add(resultobj);
            }
            result.put("echartsValue", resultJson);
            return new Result(true, "Success", result);
        } else {
            return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
        }
    }

    public Result get7DayTurnoverRate(Integer parkingId) {
        JSONObject startAndEndTIme = getStartAndEndTIme(4);
        if (CollectionUtil.isNotEmpty(startAndEndTIme)) {
            String startTime = startAndEndTIme.getString("startTime");
            String endTime = startAndEndTIme.getString("endTime");
            JSONObject firstWeek = getStartAndEndTIme(5);
            String firstWeekStartTime = firstWeek.getString("startTime");
            String firstWeekEndTime = firstWeek.getString("endTime");
            JSONObject weekTime = getStartAndEndTIme(2);
            String weekStartTime = weekTime.getString("startTime");
            String weekEndTime = weekTime.getString("endTime");
            JSONObject result = new JSONObject();
            result.put("turnoverRate", getTurnoverRate(parkingId, startTime, endTime));
            JSONArray usageRateArray = getTurnoverRateArray(parkingId, weekStartTime, weekEndTime);
            JSONArray usageRateArray1 = getTurnoverRateArray(parkingId, firstWeekStartTime, firstWeekEndTime);
            JSONArray resultJson = new JSONArray();
            for (int i = 0; i < 7; i++) {
                //本周开始的第一天
                LocalDate weekStartDate = LocalDate.parse(weekStartTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusDays(i);
                JSONObject resultobj = new JSONObject();
                resultobj.put("index", weekStartDate.getDayOfMonth());
                resultobj.put("week", 0);
                resultobj.put("lastWeek", 0);
                for (Object o : usageRateArray) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    String date = obj.getString("date");
                    LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yy-MM-dd"));
                    if (weekStartDate.isEqual(parse)) {
                        resultobj.put("week", obj.getBigDecimal("ratio").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        break;
                    }
                }
                for (Object o : usageRateArray1) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    String date = obj.getString("date");
                    LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yy-MM-dd")).plusDays(7);
                    if (weekStartDate.isEqual(parse)) {
                        resultobj.put("week", obj.getBigDecimal("ratio").multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        break;
                    }
                }
                resultJson.add(resultobj);
            }
            result.put("echartsValue", resultJson);
            return new Result(true, "Success", result);
        } else {
            return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
        }
    }
}
