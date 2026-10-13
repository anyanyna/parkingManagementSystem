package com.gemcoder.system.bo;

import java.util.List;
import java.util.Map;

/**
 * @project: parkingManagementSystem
 * @description:
 * @author: pengpeng
 * @createTime: 2024-10-22 19:36
 */

public class PagePermissionBo {

    private String pageName;

    private String pageUuid;

    private List<Map<String, Object>> permissionList;

    public PagePermissionBo(String pageName, String pageUuid, List<Map<String, Object>> permissionList) {
        this.pageName = pageName;
        this.pageUuid = pageUuid;
        this.permissionList = permissionList;
    }

    public PagePermissionBo() {
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageUuid() {
        return pageUuid;
    }

    public void setPageUuid(String pageUuid) {
        this.pageUuid = pageUuid;
    }

    public List<Map<String, Object>> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Map<String, Object>> permissionList) {
        this.permissionList = permissionList;
    }
}
