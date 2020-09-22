package com.webdriver.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.webdriver.utils.ResourceUtils;

public class ReadExcel {

	/*
	 * WorkBook -> Sheet -> Row -> Column -> Value
	 * http://poi.apache.org/components/index.html#components
	 */

	public static void main(String[] args) throws IOException {
		String path = ReadExcel.class.getClassLoader().getResource(".").getPath();
		System.err.println(path);
		File excelFile = new File("C:\\Users\\jai3p\\OneDrive\\Desktop\\Temp\\donotdelete.xlsx");
		FileInputStream input = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		List<List<String>> excelRow = new LinkedList<>();

		for (Row row : sheet) {
			List<String> excelCellValue = new LinkedList<>();
			if (row.getRowNum() == 0) {
				System.err.println("Skipping Row : " + (row.getRowNum() + 1));
			}

			else {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.println(cell.getStringCellValue());
						excelCellValue.add(cell.getStringCellValue());
						break;
					case BLANK:
						System.out.println("");
						excelCellValue.add("");
						break;
					case NUMERIC:
						System.out.println(cell.getNumericCellValue());
						excelCellValue.add(cell.getNumericCellValue()+"");
					default:
						break;
					}
				}
			}
			excelRow.add(Collections.unmodifiableList(excelCellValue));
		}
		
		workbook.close();
		
		for (List<String> row : excelRow) {
			for (String cellValue : row) {
				System.err.println(cellValue);
			}
		}
		
//		List<List<String>> excelRowData = new LinkedList<>();
//		
//		
//		for (int rowNum = sheet.getFirstRowNum(); rowNum <= sheet.getLastRowNum(); rowNum++) {
//			List<String> excelCellValue = new LinkedList<>();
//			XSSFRow row = sheet.getRow(rowNum);
//
//			for (int colNum = row.getFirstCellNum(); colNum <row.getLastCellNum(); colNum++) {
//				XSSFCell cell = row.getCell(colNum);
//
//				switch (cell.getCellType()) {
//				case STRING:
//					System.out.println(cell.getStringCellValue());
//					excelCellValue.add(cell.getStringCellValue());
//					break;
//				case BLANK:
//					System.out.println("");
//					excelCellValue.add("");
//					break;
//				case NUMERIC:
//					System.out.println(cell.getNumericCellValue());
//					excelCellValue.add(cell.getNumericCellValue()+"");
//					break;
//				default:
//					break;
//				}
//			}
//			excelRowData.add(Collections.unmodifiableList(excelCellValue));
//		}
//
//		workbook.close();
//		
//		for (List<String> row : excelRowData) {
//			for (String cellValue : row) {
//				System.err.println(cellValue);
//			}
//		}

	}
}
