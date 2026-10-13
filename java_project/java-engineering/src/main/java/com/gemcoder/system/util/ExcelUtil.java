package com.gemcoder.system.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static List<Map<String,Object>> batchUpload(File excelFile) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,Object>> result=new ArrayList<>();
		try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(excelFile));
				Workbook workbook = WorkbookFactory.create(inputStream);) {
			int allSheets = workbook.getNumberOfSheets();
			for (int index = 0; index < allSheets; ++index) {
				Sheet onSheet = workbook.getSheetAt(index);
				
				onSheet.forEach(row -> {
					Map<String,Object> map=new HashMap<>();
					Cell cell0 = row.getCell(0);
					Cell cell1 = row.getCell(1);
					Cell cell2 = row.getCell(2);
					
					String value0 =sdf.format(cell0.getDateCellValue());
					String value1 =sdf.format(cell1.getDateCellValue());// cell1.getStringCellValue();
					String value2 = cell2.getStringCellValue();
					map.put("holiday_start_date", value0);
					map.put("holiday_end_date", value1);
					map.put("holiday_remarks", value2);
					result.add(map);
				});

			}
		}
		return result;
	}

}
