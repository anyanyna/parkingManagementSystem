package com.gemcoder.system.util;

import java.util.List;
import java.util.Map;

/**
 * @project: parkingManagementSystem
 * @description:
 * @author: pengpeng
 * @createTime: 2024-10-18 17:42
 */
public class RowUtil {

    public static void setRowNumber(List<Map<String, Object>> data, Integer pageSize, Integer pageNumber) {
        int start;
        if (pageSize == null || pageNumber == null) {
            start = 1;
        } else {
            start = (pageNumber - 1) * pageSize + 1;
        }
        //设置行号
        if (data != null && data.size() > 0) {
            for (Map<String, Object> row : data) {
                row.put("row_index", start);
                start++;
            }
        }
    }
}
