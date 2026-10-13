package com.gemcoder.system.service.permission;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.util.PathUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

@Service
public class PermissionSdkService {

    /**
     *
     * 获取功能权限项
     * {
     *   "page_uuid":
     *         [
     *           {
     *             "functionName": "显示当天挂号信息",
     *             "code": "ZmwFZB",
     *             "function": [
     *               {
     *                 "ref": "ytTable7",
     *                 "url": ["/sdk/getPermission"],
     *                 "disabled_variable": "disabled1"
     *               }
     *             ]
     *            }
     *          ]
     *       }
     */
    private static Map<String, List<Map<String, Object>>> functionMap = new HashMap<>();
    private static Map<String, String> pageMap = new HashMap<>();

    static {
        String functionStr = PathUtil.readResourceFile("permission" + File.separator + "function_list.json");
        String pageStr = PathUtil.readResourceFile("permission" + File.separator + "page_list.json");
        try {
            // 创建ObjectMapper实例
            ObjectMapper objectMapper = new ObjectMapper();

            // 使用TypeReference来指定转换的类型
            functionMap = objectMapper.readValue(functionStr, new TypeReference<Map<String, List<Map<String, Object>>>>() {});
            pageMap = objectMapper.readValue(pageStr, new TypeReference<Map<String,String>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前用户的权限项
     * @return [permission_code]
     */
    public static List<String> getPermissionsByUserName(String username){

        String sql = "SELECT rp.permission_code " +
                "FROM users u " +
                "JOIN user_role ur ON u.id = ur.user_id " +
                "JOIN role_permission rp ON ur.role_id = rp.role_id " +
                "WHERE u.user_name = ?";

        List<Object> params = new ArrayList<>();
        params.add(username);
        List<Map<String, Object>> result = executeSQL(sql, params.toArray());

        List<String> permissions = new ArrayList<>();
        for (Map<String, Object> map : result) {
            permissions.add(String.valueOf(map.get("permission_code")));
        }
        return permissions;
    }
    /**
     * 根据页面名称获取组件ref信息
     * @param permissionCodes ["wdwdw,dddd"]
     * @return ["ref1","ref2"]
     */
    public static List<String> getNotRefListByPermissionCodes(List<String> permissionCodes, String pageUuid) {

        //获取当前用户角色的权限项
        List<Map<String, Object>> permissions = getNotContainPermissionsByCodes(permissionCodes);

        //整理成ref字符串列表 ["ref1","ref2"]
        List<String> pageAllRefList = new ArrayList<>();
        //遍历当前用户的权限集合
        permissions.forEach(map -> {
            String currentPageUuid = (String) map.get("pageUuid");
            //只需要当前页面相等的
            if (pageUuid.equals(currentPageUuid)) {

                List<Map<String, Object>> function = (List<Map<String, Object>>) map.get("function");
                function.forEach(functionMap -> {
                    String ref = (String) functionMap.get("ref");
                    //删除权限项的ref
                    pageAllRefList.add(ref);
                });
            }
        });
        return pageAllRefList;
    }

    /**
     * 根据code获取接口的权限项
     * @param codes ["ZmwFZB"]
     * @return [
     *                 {
     *                  "functionName": "显示当天挂号信息",
     *                   "code": "ZmwFZB",
     *                   "pageName": "pageName",
     *                   "pageUuid": "pageUuid",
     *                   "function": [
     *                      {
     *                        "ref": "ytTable7",
     *                        "url": ["/sdk/getPermission"],
     *                        "disabled_variable": "disabled1"
     *                      }
     *                    ]
     *                  }
     *          ]
     */
    public static List<Map<String, Object>> getNotContainPermissionsByCodes(List<String> codes){

        List<Map<String, Object>> functionList = new ArrayList<>();
        for (String key : functionMap.keySet()) {
            List<Map<String, Object>> valueList = functionMap.get(key);
            for (Map<String, Object> map : valueList) {
                //如果包含 判断code是否不包含在其中
                if(!codes.contains((String) map.get("code"))){
                    map.put("pageName", pageMap.get(key));
                    map.put("pageUuid", key);
                    functionList.add(map);
                }
            }
        }

        return functionList;
    }
    /**
     * 获取当前用户的角色
     * @return [role_code]
     */
    public static List<String> getRoleCodesByUserName(String username){

        String sql = "SELECT r.role_code FROM users u JOIN user_role ur ON u.id = ur.user_id JOIN role r ON ur.role_id = r.id WHERE u.user_name = '" + username + "'";

        List<Map<String, Object>> result = (List<Map<String, Object>>)executeSQL(sql);

        List<String> roleCodes = new ArrayList<>();
        for (Map<String, Object> map : result) {
            roleCodes.add(String.valueOf(map.get("role_code")));
        }
        return roleCodes;
    }


    
    /**
     * 获取所有权限项
     * @return ["url"]
     */
    public static Set<String> getAllPermissionsUrl(){

        Set<String> functionList = new HashSet<String>() {
        };
        for (String key : functionMap.keySet()) {
            List<Map<String, Object>> valuelist = functionMap.get(key);
            for (int i = 0; i < valuelist.size(); i++) {
                Map<String, Object> functionValueMap = valuelist.get(i);
                List<Map<String, Object>> function = (List<Map<String, Object>>)functionValueMap.get("function");
                function.forEach(functionMap -> {
                    List<String> url = (List<String>) functionMap.get("url");
                    functionList.addAll(url);
                });
            }
           
        }
        return functionList;
    }


    /**
     * 获取所有权限项
     * @return [
     *                 {
     *                  "functionName": "显示当天挂号信息",
     *                   "code": "ZmwFZB",
     *                   "pageUuid": "1234",
     *                   "pageName": "A页面"
     *                  }
     *                ]
     */
    public static List<Map<String, Object>> sdkOfgetAllPermissions(){

       

        return sdkOfGetAllPermissions();
    }
public static List<Map<String, Object>> sdkOfGetAllPermissions(){

        List<Map<String, Object>> functionList = new ArrayList<>();
        for (String key : functionMap.keySet()) {
            List<Map<String, Object>> valueList = functionMap.get(key);
            for (Map<String, Object> map : valueList) {
                Map<String, Object> item = new HashMap<>(map);
                item.put("pageName", pageMap.get(key));
                item.put("pageUuid", key);
                item.remove("function");
                functionList.add(item);
            }
        }

        return functionList;
    }
    /**
     * 获取当前项目所有的菜单项
     * @return [
     *             {
     *                  "menuCode": "menuCode",
     *                  "menuName": "menuName"
     *              }
     *          ]      
     */
    public static List<Map<String, Object>> sdkOfgetAllMenus(){

       
        return sdkOfGetAllPages();
    }

    public static List<Map<String, Object>> sdkOfGetAllPages(){

       List<Map<String, Object>> pageList = new ArrayList<>();
        for (String key : pageMap.keySet()) {
            String value = pageMap.get(key);
            Map<String, Object> map = new HashMap<>();
            map.put("pageCode", value);
            map.put("pageName", key);
            pageList.add(map);
        }

        return pageList;
    }

    /**
     * 根据code获取接口的权限项
     * @param codes ["ZmwFZB"]
     * @return [
     *                 {
     *                  "functionName": "显示当天挂号信息",
     *                   "code": "ZmwFZB",
     *                   "pageName": "pageName",
     *                   "pageUuid": "pageUuid",
     *                   "function": [
     *                      {
     *                        "ref": "ytTable7",
     *                        "url": ["/sdk/getPermission"],
     *                        "disabled_variable": "disabled1"
     *                      }
     *                    ]
     *                  }
     *          ]
     */
    public static List<Map<String, Object>> getPermissionsByCodes(List<String> codes){

        List<Map<String, Object>> functionList = new ArrayList<>();
        for (String key : functionMap.keySet()) {
            List<Map<String, Object>> valueList = functionMap.get(key);
            for (Map<String, Object> map : valueList) {
                //如果包含 判断code是否包含在其中
                if(codes.contains((String) map.get("code"))){
                    map.put("pageName", pageMap.get(key));
                    map.put("pageUuid", key);
                    functionList.add(map);
                }
            }
        }

        return functionList;
    }


    /**
     * 根据用户角色获取权限
     * @param roleCodes ["wdwdw"]
     * @return ["/sdk/getPermission","/sdk/getList"]
     *
     */
    public static List<String> getUrlPermissionsByRole(List<String> roleCodes) {

        List<Map<String, Object>> permissions = getPermissionsByRole(roleCodes);
        List<String> functionList = new ArrayList<>();
        permissions.forEach(map -> {
            List<Map<String, Object>> function = (List<Map<String, Object>>) map.get("function");
            if (function == null){
                return;
            }
            function.forEach(functionMap -> {
                List<String> url = (List<String>) functionMap.get("url");
                functionList.addAll(url);
                    });
        });

        return functionList;
    }


    /**
     * 根据页面名称获取disabled变量信息
     * @param roleCodes ["wdwdw"]
     * @return ["ytTable7","ytTable8"]
     */
    public static List<String> getNotRefListByRoleCode(List<String> roleCodes, String pageUuid) {

        //获取当前用户角色的权限项
        List<Map<String, Object>> permissions = getPermissionsByRole(roleCodes);

        //整理成ref字符串列表 ["/sdk/getPermission","/sdk/getList"]
        List<Map<String, Object>> pageFunctionList = functionMap.get(pageUuid);
        List<String> pageAllRefList = new ArrayList<>();
        pageFunctionList.forEach(map -> {
            List<Map<String, Object>> function = (List<Map<String, Object>>) map.get("function");
            function.forEach(functionMap -> {
                String isShowVariable = (String) functionMap.get("is_show_variable");
                pageAllRefList.add(isShowVariable);
            });
        });

        //遍历当前用户角色的权限集合
        permissions.forEach(map -> {
            String currentPageUuid = (String) map.get("pageUuid");
            //只需要当前页面相等的
            if (pageUuid.equals(currentPageUuid)) {

                List<Map<String, Object>> function = (List<Map<String, Object>>) map.get("function");
                function.forEach(functionMap -> {
                    String isShowVariable = (String) functionMap.get("is_show_variable");
                    //删除权限项的ref
                    pageAllRefList.remove(isShowVariable);
                });
            }
        });

        return pageAllRefList;

    }

    /**
     * 根据角色获取所有roleCode
     * @param roleCodes ["wdwdw"]
     * @return [
     *                 {
     *                  "functionName": "显示当天挂号信息",
     *                   "code": "ZmwFZB",
     *                   "pageName": "pageName",
     *                   "pageUuid": "pageUuid",
     *                   "function": [
     *                      {
     *                        "ref": "ytTable7",
     *                        "url": "/sdk/getPermission"
     *                      }
     *                    ]
     *                  }
     *                ]
     */
    public static List<Map<String, Object>> getPermissionsByRole(List<String> roleCodes) {

        if (CollUtil.isEmpty(roleCodes)) {
            return new ArrayList<>(0);
        }

        String sql = "select distinct permission_code from role_permission where role_code IN (" + roleCodes.stream().map(id -> "?").collect(Collectors.joining(",")) + ")";
        List<Map<String, Object>> sqlResult = (List<Map<String, Object>>) executeSQL(sql, roleCodes.toArray());
        if (CollUtil.isEmpty(sqlResult)) {
            return new ArrayList<>(0);
        }

        List<String> permissionCodes = sqlResult.stream()
                .map(map -> (String) map.get("permission_code")) // 将每个Map中的"permission_code"键对应的值转换为String
                .collect(Collectors.toList());


        return getPermissionsByCodes(permissionCodes);
    }

}
