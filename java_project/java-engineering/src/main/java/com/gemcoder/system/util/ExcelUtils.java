package com.gemcoder.system.util;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.gemcoder.system.converter.ExcelFillCellMergeStrategy;
import com.gemcoder.system.converter.LocalDateConverter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Excel 工具类
 */
public class ExcelUtils {

    /**
     * 将列表以 Excel 响应给前端
     *
     * @param response  响应
     * @param filename  文件名
     * @param sheetName Excel sheet 名
     * @param head      Excel head 头
     * @param data      数据列表哦
     * @param <T>       泛型，保证 head 和 data 类型的一致性
     * @throws IOException 写入失败的情况
     */
    public static <T> void write(HttpServletResponse response, String filename, String sheetName,
                                 Class<T> head, List<T> data, int[] mergeColumnIndex) throws IOException {
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        WriteCellStyle writeCellStyle = new WriteCellStyle();
        writeCellStyle.setBorderBottom(BorderStyle.THIN);
        writeCellStyle.setBorderLeft(BorderStyle.THIN);
        writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        writeCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        writeCellStyle.setBorderRight(BorderStyle.THIN);
        writeCellStyle.setBorderTop(BorderStyle.THIN);
        // 输出 Excel
        EasyExcel.write(response.getOutputStream(), head)
                .autoCloseStream(false) // 不要自动关闭，交给 Servlet 自己处理
                .registerConverter(new LocalDateConverter())
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .registerWriteHandler(new HorizontalCellStyleStrategy(writeCellStyle, writeCellStyle))
                .registerWriteHandler(new ExcelFillCellMergeStrategy(1, mergeColumnIndex))// 基于 column 长度，自动适配。最大 255 宽度
                .sheet(sheetName).doWrite(data);
        // 设置 header 和 contentType。写在最后的原因是，避免报错时，响应 contentType 已经被修改了
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
    }

    public static void write(HttpServletResponse response, List<List<String>> headMap, String fileName, List<List<Object>> dataList, int[] mergeColumnIndex) {
        try {
            WriteCellStyle writeCellStyle = new WriteCellStyle();
            writeCellStyle.setBorderBottom(BorderStyle.THIN);
            writeCellStyle.setBorderLeft(BorderStyle.THIN);
            writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            writeCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            writeCellStyle.setBorderRight(BorderStyle.THIN);
            writeCellStyle.setBorderTop(BorderStyle.THIN);
            EasyExcel.write(response.getOutputStream())
                    .autoCloseStream(false) // 不要自动关闭，交给 Servlet 自己处理
                    .head(headMap)
                    .sheet("sheet1")
                    .registerConverter(new LocalDateConverter())
                    .registerWriteHandler(new HorizontalCellStyleStrategy(writeCellStyle, writeCellStyle))
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    .registerWriteHandler(new ExcelFillCellMergeStrategy(1, mergeColumnIndex))
                    .doWrite(dataList);// 基于 column 长度，自动适配。最大 255 宽度.doWrite(dataList);
            // 设置 header 和 contentType。写在最后的原因是，避免报错时，响应 contentType 已经被修改了
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public static <T> List<T> read(MultipartFile file, Class<T> head) throws IOException {
        return EasyExcel.read(file.getInputStream(), head, null)
                .autoCloseStream(false)  // 不要自动关闭，交给 Servlet 自己处理
                .doReadAllSync();
    }

    /**
     * @param response
     * @param data             表格数据
     * @param replaceMap       表头数据
     * @param templateFilePath 模板路径
     * @throws IOException
     */
    public static void tempWrite(HttpServletResponse response, List data, Map<String, String> replaceMap, String templateFilePath) throws IOException {
        WriteSheet sheet = EasyExcel.writerSheet().build();
        // 设置表头样式
        WriteCellStyle headStyle = new WriteCellStyle();
        // 设置表头数据居中
        headStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 设置表格内容样式
        WriteCellStyle bodyStyle = new WriteCellStyle();
        // 设置表格内容水平居中
        bodyStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        // 设置表格内容垂直居中
        bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置自动换行
        bodyStyle.setWrapped(true);
        // 创建 ExcelWriter 实例
        ExcelWriter writer = EasyExcel.write(response.getOutputStream())
                // 指定模板
                .withTemplate(templateFilePath).registerWriteHandler(new HorizontalCellStyleStrategy(headStyle, bodyStyle)).build();

        // 执行填充普通占位符操作
        writer.fill(replaceMap, sheet);
        FillConfig fillConfig = FillConfig.builder()
                // 开启填充换行
                .forceNewRow(true)
                .build();
        // 执行填充列表操作
        if (CollectionUtil.isNotEmpty(data)) {
            writer.fill(data, fillConfig, sheet);
        }
        // 结束
        writer.finish();
        // 设置 header 和 contentType。写在最后的原因是，避免报错时，响应 contentType 已经被修改了
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("wenjian", "UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
    }

}
