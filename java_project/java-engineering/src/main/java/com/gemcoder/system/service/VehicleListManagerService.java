package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.bo.VehicleBlockListBo;
import com.gemcoder.system.bo.VehicleBlockListDownloadBo;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;

@Service
public class VehicleListManagerService {
    @Resource
    UserSdkService userSdkService;
    private static final Logger log = LoggerFactory.getLogger(VehicleInYardService.class);

    public Result getList() {
        List<Map<String, Object>> vehicle_list_manager = executeSQL("SELECT `code`,rule_number,type_name,is_delete FROM vehicle_list_manager");
        return Result.buildSuccess(vehicle_list_manager);
    }

    public Result insertVehicleList(JSONObject jsonObject) {
        String userName = UserSdkService.sdkOfGetCurrentUserName();
        Integer i = executeSQL("INSERT INTO `vehicle_list_manager` ( `rule_number`, `type_name`, `code`, `create_username`, `update_username`, `is_delete`) VALUES ( ?, ?, ?, ?, ?, ?)",
                jsonObject.getString("ruleNumber"),
                jsonObject.getString("typeName"),
                UUID.randomUUID().toString().replaceAll("-", ""),
                userName,
                userName,
                1
        );
        if (i != -1) {
            return Result.buildSuccess(true);
        } else {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }

    public Result deleteVehicleList(String code) {
        Integer i = executeSQL("DELETE FROM vehicle_list_manager where `code`=?", code);
        if (i != -1) {
            return Result.buildSuccess(true);
        } else {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }

    }

    public Result getBillingRulesSelect() {
        List<Map<String, Object>> billing_rules = executeSQL("SELECT `rule_number`,rule_name FROM billing_rules");
        return Result.buildSuccess(billing_rules);
    }

    public Result selectList(JSONObject jsonObject) {
        Integer current = jsonObject.get("current") != null ? Integer.valueOf(String.valueOf(jsonObject.get("current"))) : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? Integer.valueOf(String.valueOf(jsonObject.get("pageSize"))) : 10;
        String selectLastSql = " order by ll.id desc limit ?,?";
        Map querySql = getQuerySql(jsonObject);
        if (querySql == null) return Result.buildError(ErrorCodeEnum.NO_USER);
        List<Object> params = (List<Object>) querySql.get("params");
        JSONObject jsonObject1 = new JSONObject();
        Integer integer = sdkOfPaginationQueryCount(String.valueOf(querySql.get("sql")), params.toArray());
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        Object o = executeSQL(querySql.get("sql") + selectLastSql, params.toArray());
        jsonObject1.put("total", integer);
        jsonObject1.put("data", o);
        return Result.buildSuccess(jsonObject1);
    }

    // 递归查找最父级节点ID
    private int findRootParentId(Map<Integer, JSONObject> orgMap, int childId) {
        JSONObject currentNode = orgMap.get(childId);
        if (currentNode == null || currentNode.getInteger("parent_id") == null) { // 假设parentId为0表示根节点
            return currentNode == null ? -1 : currentNode.getInteger("id");
        }
        return findRootParentId(orgMap, currentNode.getInteger("parent_id"));
    }

    public Result getParkingList(String userName, Integer type) {
        if (StringUtils.isEmpty(userName)) userName = UserSdkService.sdkOfGetCurrentUserName();
        if (StringUtils.isEmpty(userName)) return Result.buildError(ErrorCodeEnum.NO_USER);
        List<String> userRole = userSdkService.getUserRole(userName);
        String selectSql = "SELECT id,parking_lot_name FROM parking_lot_info ";
        if (CollectionUtil.isEmpty(userRole)) return Result.buildError(ErrorCodeEnum.NO_USER);
        if (userRole.contains("super_admin")) {
            JSONArray jsonArray = new JSONArray();
            if (type == 1) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", null);
                jsonObject.put("parking_lot_name", "全部停车场");
                jsonArray.add(jsonObject);
            }
            jsonArray.addAll(JSONArray.parseArray(JSONArray.toJSONString(executeSQL(selectSql))));
            return Result.buildSuccess(jsonArray);
        } else if (userRole.contains("company_operating_personnel")) {
            String orgSql = "select id,name,parent_id from organization";
            String userOrgSql = "select * from users where user_name=?";
            JSONArray userOrg = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(userOrgSql, userName)));
            Integer organizationId = userOrg.getJSONObject(0).getInteger("organization_id");
            JSONArray orgList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(orgSql)));
            Map<Integer, JSONObject> orgMap = new HashMap<>();
            for (Object o : orgList) {
                JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                orgMap.put(obj.getInteger("id"), obj);
            }
            int rootParentId = findRootParentId(orgMap, organizationId);
            String parkingSql = "select id,parking_lot_name from parking_lot_info where id in (select parking_lot_id from  platform_info where operating_company=?)";
            return Result.buildSuccess(executeSQL(parkingSql, rootParentId));
        } else if (userRole.contains("car_park_adin")) {
            return Result.buildSuccess(executeSQL(selectSql + "where  id in (SELECT parking_lot_id FROM platform_info where conservator=?)", userName));
        } else {
            return Result.buildSuccess(null);
        }
    }

    public Result insert(JSONObject jsonObject) {
        String userName = jsonObject.getString("userName");
        if (StringUtils.isEmpty(jsonObject.getString("userName"))) userName = UserSdkService.sdkOfGetCurrentUserName();
        if (StringUtils.isEmpty(jsonObject.getString("plate_num")) ||
                StringUtils.isEmpty(jsonObject.getString("plate_type")) ||
                StringUtils.isEmpty(jsonObject.getString("vehicle_list_code")) ||
                CollectionUtil.isEmpty(jsonObject.getJSONArray("parking_lot_id")) ||
                StringUtils.isEmpty(jsonObject.getString("start_time")) ||
                StringUtils.isEmpty(jsonObject.getString("end_time"))
        ) {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        } else {
            List<Object> params = new ArrayList<>();
            String insertSql = "INSERT INTO `vehicle_block_list` ( `plate_num`, `start_time`, `end_time`, `parking_lot_id`, `create_username`,  `update_username`, `remark`, `status`, `plate_type`,`vehicle_list_code`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            params.add(jsonObject.getString("plate_num"));
            params.add(jsonObject.getString("start_time"));
            params.add(jsonObject.getString("end_time"));
            params.add(jsonObject.getJSONArray("parking_lot_id").toJSONString());
            params.add(userName);
            params.add(userName);
            params.add(jsonObject.getString("remark"));
            params.add("待审批");
            params.add(jsonObject.getString("plate_type"));
            params.add(jsonObject.getString("vehicle_list_code"));
            Integer integer = (Integer) executeSQL(insertSql, params.toArray());
            if (integer != -1) {
                return Result.buildSuccess(integer);
            } else {
                return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);

            }
        }
    }

    public Result update(JSONObject jsonObject) {
        String userName = jsonObject.getString("userName");
        if (StringUtils.isEmpty(jsonObject.getString("userName"))) userName = UserSdkService.sdkOfGetCurrentUserName();
        if (StringUtils.isEmpty(jsonObject.getString("plate_num")) ||
                StringUtils.isEmpty(jsonObject.getString("plate_type")) ||
                StringUtils.isEmpty(jsonObject.getString("vehicle_list_code")) ||
                CollectionUtil.isEmpty(jsonObject.getJSONArray("parking_lot_id")) ||
                StringUtils.isEmpty(jsonObject.getString("start_time")) ||
                StringUtils.isEmpty(jsonObject.getString("end_time")) ||
                StringUtils.isEmpty(jsonObject.getString("id"))
        ) {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        } else {
            List<Object> params = new ArrayList<>();
            String udpateSql = "UPDATE `vehicle_block_list` SET `plate_num` = ?, `start_time` = ?, `end_time` = ?, `parking_lot_id` = ? ,`update_username` = ?, `remark` = ?,  `plate_type` = ?, `vehicle_list_code` = ? WHERE `id` = ?;";
            params.add(jsonObject.getString("plate_num"));
            params.add(jsonObject.getString("start_time"));
            params.add(jsonObject.getString("end_time"));
            params.add(jsonObject.getJSONArray("parking_lot_id").toJSONString());
            params.add(userName);
            params.add(jsonObject.getString("remark"));
            params.add(jsonObject.getString("plate_type"));
            params.add(jsonObject.getString("vehicle_list_code"));
            params.add(jsonObject.getInteger("id"));
            Integer integer = (Integer) executeSQL(udpateSql, params.toArray());
            if (integer != -1) {
                return Result.buildSuccess(integer);
            } else {
                return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);

            }
        }
    }

    public Result approval(JSONArray jsonArray) {
        if (CollectionUtil.isEmpty(jsonArray)) return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        String udpateSql = "UPDATE `vehicle_block_list` SET  `status` = '生效中' WHERE `id` = ?;";
        List<Integer> integers = jsonArray.toJavaList(Integer.class);
        for (Integer integer : integers) {
            executeSQL(udpateSql, integer);
        }
        return Result.buildSuccess(1);

    }

    public Result delete(JSONArray jsonArray) {
        if (CollectionUtil.isEmpty(jsonArray)) return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        String deleteSql = "delete from vehicle_block_list where id in(" + CollectionUtil.join(jsonArray, ",") + ")";
        return Result.buildSuccess(executeSQL(deleteSql));
    }

    private Map getQuerySql(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        List<Object> params = new ArrayList<>();
        String selectSql = "SELECT * FROM vehicle_block_list ll left join users u on ll.update_username=u.user_name where 1=1";
        if (CollectionUtil.isNotEmpty(jsonObject.getJSONArray("ids"))) {
            selectSql += " and ll.id in (" + CollectionUtil.join(jsonObject.getJSONArray("ids"), ",") + ")";
        }
        if (!StringUtils.isEmpty(jsonObject.getString("plate_num"))) {
            selectSql += " and ll.plate_num like ?";
            params.add("%" + jsonObject.getString("plate_num") + "%");
        }
        if (!StringUtils.isEmpty(jsonObject.getString("vehicle_list_code"))) {
            selectSql += " and ll.vehicle_list_code = ?";
            params.add(jsonObject.getString("vehicle_list_code"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("update_username"))) {
            selectSql += " and u.nick_name like ?";
            params.add("%" + jsonObject.getString("update_username") + "%");
        }
        if (!StringUtils.isEmpty(jsonObject.getString("s_s_time")) && !StringUtils.isEmpty(jsonObject.getString("s_e_time"))) {
            selectSql += " and ll.start_time >= ? and ll.start_time <= ?";
            params.add(jsonObject.getString("s_s_time"));
            params.add(jsonObject.getString("s_e_time"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("e_s_time")) && !StringUtils.isEmpty(jsonObject.getString("e_e_time"))) {
            selectSql += " and ll.end_time >= ? and ll.end_time <= ?";
            params.add(jsonObject.getString("e_s_time"));
            params.add(jsonObject.getString("e_e_time"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("c_s_time")) && !StringUtils.isEmpty(jsonObject.getString("c_e_time"))) {
            selectSql += " and ll.create_time >= ? and ll.create_time <= ?";
            params.add(jsonObject.getString("c_s_time"));
            params.add(jsonObject.getString("c_e_time"));
        }
        String userName = "";
        if (StringUtils.isEmpty(jsonObject.getString("userName"))) {
            userName = UserSdkService.sdkOfGetCurrentUserName();
        } else {
            userName = jsonObject.getString("userName");
        }
        List<String> userRole = userSdkService.getUserRole(userName);
        if (CollectionUtil.isEmpty(userRole)) return null;
        //管理员 所有数据权限
        if (userRole.contains("super_admin")) {
            if (CollectionUtil.isNotEmpty(jsonObject.getJSONArray("parking_lot_id"))) {
                List<String> arraySql = new ArrayList<>();
                List<Integer> parkingLotId = jsonObject.getJSONArray("parking_lot_id").toJavaList(Integer.class);
                for (Integer integer : parkingLotId) {
                    arraySql.add("JSON_CONTAINS(parking_lot_id,?)");
                    params.add("[" + integer + "]");
                }
                String sql = " and (" + CollectionUtil.join(arraySql, " or ") + ")";
                selectSql += sql;
            }
        } else if (userRole.contains("company_operating_personnel")) {
            List<String> arraySql = new ArrayList<>();
            List<Integer> parkingLotId = new ArrayList<>();
            if (CollectionUtil.isNotEmpty(jsonObject.getJSONArray("parking_lot_id"))) {
                parkingLotId = jsonObject.getJSONArray("parking_lot_id").toJavaList(Integer.class);
            } else {
                String orgSql = "select id,name,parent_id from organization";
                String userOrgSql = "select * from users where user_name=?";
                JSONArray userOrg = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(userOrgSql, userName)));
                Integer organizationId = userOrg.getJSONObject(0).getInteger("organization_id");
                JSONArray orgList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(orgSql)));
                Map<Integer, JSONObject> orgMap = new HashMap<>();
                for (Object o : orgList) {
                    JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(o));
                    orgMap.put(obj.getInteger("id"), obj);
                }
                int rootParentId = findRootParentId(orgMap, organizationId);
                String parkingSql = "select id from parking_lot_info where operating_company=?";
                JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(parkingSql, rootParentId)));
                Set<Integer> id1 = jsonArray.stream().map(item -> {
                    JSONObject obj = (JSONObject) item;
                    Integer id = obj.getInteger("id");
                    return id;
                }).collect(Collectors.toSet());
                parkingLotId = new ArrayList<>(id1);
            }
            for (Integer integer : parkingLotId) {
                arraySql.add("JSON_CONTAINS(parking_lot_id,?)");
                params.add("[" + integer + "]");
            }
            String sql = " and (" + CollectionUtil.join(arraySql, " or ") + ")";
            selectSql += sql;
            //公司运营人员 只能看该公司下的所有停车场数据
        } else if (userRole.contains("car_park_adin")) {
            //停车场管理人员 只能看自己管理的停车场数据
            List<String> arraySql = new ArrayList<>();
            String parkingSql = "select id from platform_info where conservator=?";
            JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(parkingSql, userName)));
            Set<Integer> id1 = jsonArray.stream().map(item -> {
                JSONObject obj = (JSONObject) item;
                Integer id = obj.getInteger("id");
                return id;
            }).collect(Collectors.toSet());
            for (Integer integer : id1) {
                arraySql.add("JSON_CONTAINS(parking_lot_id,?)");
                params.add("[" + integer + "]");
            }
            String sql = " and (" + CollectionUtil.join(arraySql, " or ") + ")";
            selectSql += sql;
        }
        map.put("params", params);
        map.put("sql", selectSql);
        return map;
    }

    public void download(HttpServletResponse response, JSONObject jsonObject) throws IOException {
        List<VehicleBlockListDownloadBo> list = new ArrayList<>();
        String selectLastSql = " order by ll.id desc ";
        Map querySql = getQuerySql(jsonObject);
        if (querySql == null) return;
        List<Object> params = (List<Object>) querySql.get("params");
        list = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(querySql.get("sql") + selectLastSql, params.toArray())), VehicleBlockListDownloadBo.class);

        //数据转换
        String parkingLotSql = "select id,parking_lot_name from parking_lot_info";
        JSONArray parkingLotList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(parkingLotSql)));
        Map<Integer, String> collect = parkingLotList.stream().collect(Collectors.toMap(item -> {
            JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item));
            return j.getInteger("id");
        }, item2 -> {
            JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item2));
            return j.getString("parking_lot_name");
        }));
        String vehicleListManagerSql = "select code,type_name from vehicle_list_manager";
        JSONArray vehicleListManagerList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(vehicleListManagerSql)));
        Map<String, String> collect2 = vehicleListManagerList.stream().collect(Collectors.toMap(item -> {
            JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item));
            return j.getString("code");
        }, item2 -> {
            JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item2));
            return j.getString("type_name");
        }));
        for (VehicleBlockListDownloadBo vehicleBlockListBo : list) {
            vehicleBlockListBo.setVehicleListCode(collect2.get(vehicleBlockListBo.getVehicleListCode()));
            List<String> nameList = new ArrayList<>();
            List<Integer> integers = JSONArray.parseArray(vehicleBlockListBo.getParkingLotId(), Integer.class);
            for (Integer integer : integers) {
                if (collect.containsKey(integer)) nameList.add(collect.get(integer));
            }
            vehicleBlockListBo.setParkingLotId(CollectionUtil.join(nameList, ","));
        }
        ExcelUtils.write(response, "黑白名单.xlsx", "sheet1", VehicleBlockListDownloadBo.class, list, new int[]{});
    }

    public Result importExcel(MultipartFile file, String userName) {
        if (StringUtils.isEmpty(userName)) userName = UserSdkService.sdkOfGetCurrentUserName();
        try {
            List<Integer> successIndex = new ArrayList<>();
            List<Integer> failIndex = new ArrayList<>();
            List<VehicleBlockListBo> read = ExcelUtils.read(file, VehicleBlockListBo.class);
            String parkingLotSql = "select id,parking_lot_name from parking_lot_info";
            JSONArray parkingLotList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(parkingLotSql)));
            Map<String, List<Object>> parkingLotName = parkingLotList.stream().collect(Collectors.groupingBy(item -> {
                JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item));
                return j.getString("parking_lot_name");
            }));
            String vehicleListManagerSql = "select code,type_name from vehicle_list_manager";
            JSONArray vehicleListManagerList = JSONArray.parseArray(JSONArray.toJSONString(executeSQL(vehicleListManagerSql)));
            Map<String, List<Object>> typeName = vehicleListManagerList.stream().collect(Collectors.groupingBy(item -> {
                JSONObject j = JSONObject.parseObject(JSONObject.toJSONString(item));
                return j.getString("type_name");
            }));
            List<VehicleBlockListBo> importBo = new ArrayList<>();
            for (int i = 0; i < read.size(); i++) {
                VehicleBlockListBo bo = read.get(i);
                if (bo.getEndTime() != null && bo.getStartTime() != null && !StringUtils.isEmpty(bo.getPlateNum()) && !StringUtils.isEmpty(bo.getParkingLotId())) {
                    if (!typeName.containsKey(bo.getVehicleListCode())) {
                        failIndex.add(i + 1);
                        continue;
                    } else {
                        Object o = typeName.get(bo.getVehicleListCode()).get(0);
                        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(o));
                        bo.setVehicleListCode(jsonObject.getString("code"));
                    }
                    List<Integer> integers = new ArrayList<>();
                    String[] split = bo.getParkingLotId().split(",");
                    if (split.length == 0 || split == null) {
                        failIndex.add(i + 1);
                    } else {
                        for (String s : split) {
                            if (!parkingLotName.containsKey(s)) {
                                failIndex.add(i + 1);
                                break;
                            } else {
                                Object o = parkingLotName.get(s).get(0);
                                JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(o));
                                integers.add(jsonObject.getInteger("id"));
                            }
                        }
                        if (!failIndex.contains(i + 1)) {
                            bo.setParkingLotId(JSONObject.toJSONString(integers));
                            importBo.add(bo);
                            successIndex.add(i + 1);
                        }
                    }
                } else {
                    failIndex.add(i + 1);
                }
            }
            if (CollectionUtil.isNotEmpty(importBo)) {
                List<Object> params = new ArrayList<>();
                String insertSql = "INSERT INTO `vehicle_block_list` (`plate_num`, `start_time`, `end_time`, `parking_lot_id`, `create_username`, `update_username`,  `remark`, `status`, `plate_type`, `vehicle_list_code`) VALUES ";
                for (VehicleBlockListBo bo : importBo) {
                    insertSql += "(?,?,?,?,?,?,?,?,?,?),";
                    params.add(bo.getPlateNum());
                    params.add(bo.getStartTime());
                    params.add(bo.getEndTime());
                    params.add(bo.getParkingLotId());
                    params.add(userName);
                    params.add(userName);
                    params.add(bo.getRemark());
                    params.add("待审批");
                    params.add(bo.getPlateType());
                    params.add(bo.getVehicleListCode());
                }
                insertSql = insertSql.substring(0, insertSql.length() - 1);
                Object o = executeSQL(insertSql, params.toArray());
                Integer num = (Integer) o;
                if (num != -1) {
                    String success = "导入成功共" + num + "条。";
                    String fail = "导入失败共" + failIndex.size() + "条，失败的行为" + CollectionUtil.join(failIndex, ",") + "。";
                    return new Result(true, "读取到数据共" + read.size() + "条" + success + " " + fail, null);
                } else {
                    return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
                }
            } else {
                return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
            }
        } catch (IOException e) {
            log.error("导入文件错误---{}", new RuntimeException(e));
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }
}
