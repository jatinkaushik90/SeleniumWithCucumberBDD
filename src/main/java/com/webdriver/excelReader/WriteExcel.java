package com.webdriver.excelReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		File excelFile = new File("C:\\Users\\jai3p\\OneDrive\\Desktop\\Temp\\donotdelete1.xlsx");
		FileOutputStream output = new FileOutputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(); // Create the workbook
		XSSFSheet Sheet = workbook.createSheet("TestDataSheet"); //Create Sheet
		
		XSSFRow row = Sheet.createRow(0); // Create row
		
		XSSFCell cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("My First Value");
		workbook.write(output);
		
		workbook.close();
		output.close();

	}

}
