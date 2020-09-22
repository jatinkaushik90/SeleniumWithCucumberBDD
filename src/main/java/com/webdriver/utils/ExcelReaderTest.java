package com.webdriver.utils;

import java.io.IOException;
import java.util.List;

public class ExcelReaderTest {
	
	public static void main(String[] args) throws IOException {
		ExcelReader reader = new ExcelReader();
		List<List<String>> excelData = reader.getExcelData("TestData.xlsx", 0);
		
		for (List<String> row : excelData) {
			for (String cellValue : row) {
				System.err.println(cellValue);
			}
		}
	}
}
