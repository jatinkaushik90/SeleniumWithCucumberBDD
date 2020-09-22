package com.webdriver.utils;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public List<List<String>> getExcelData(String fileName, Object sheetInfo) throws IOException {

		String path = getFilePath(fileName);
		return getSheetData(path, sheetInfo);

	}

	private List<List<String>> getSheetData(String path, Object sheetInfo) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = getSheet(sheetInfo, workbook);

		return getData(workbook, sheet);

	}

	private List<List<String>> getData(XSSFWorkbook workbook, XSSFSheet sheet) throws IOException {
		List<List<String>> excelRow = new LinkedList<>();

		prepareOuterList(workbook, sheet, excelRow);

		return Collections.unmodifiableList(excelRow);
	}

	private void prepareOuterList(XSSFWorkbook workbook, XSSFSheet sheet, List<List<String>> excelRow)
			throws IOException {

		for (Row row : sheet) {

			List<String> excelCellValue = new LinkedList<>();
			prepareInnerList(row, excelCellValue);

			excelRow.add(Collections.unmodifiableList(excelCellValue));
		}
		workbook.close();
	}

	private void prepareInnerList(Row row, List<String> excelCellValue) {
		for (Cell cell : row) {
			switch (cell.getCellType()) {
			case STRING:
				excelCellValue.add(cell.getStringCellValue());
				break;
			case BLANK:
				excelCellValue.add("");
				break;
			case NUMERIC:
				excelCellValue.add(cell.getNumericCellValue() + "");
			default:
				break;
			}
		}
	}

	private XSSFSheet getSheet(Object sheetInfo, XSSFWorkbook workbook) throws IOException {

		XSSFSheet sheet;

		if (sheetInfo instanceof String) {
			sheet = workbook.getSheet((String) sheetInfo);
		} else if (sheetInfo instanceof Integer) {
			sheet = workbook.getSheetAt((int) sheetInfo);
		} else {
			workbook.close();
			throw new RuntimeException("Invalid Sheet detail passed: " + sheetInfo);
		}
		return sheet;
	}

	private String getFilePath(String fileName) {
		String path = ResourceUtils.getResourcePath(fileName);
		if (path != null)
			return path;
		throw new RuntimeException("Invalid FileName: " + fileName);
	}
}
