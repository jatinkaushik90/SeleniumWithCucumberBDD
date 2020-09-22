package com.webdriver.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;

public class ExcelDataToDataTableTransform extends Transformer<DataTable> {

	@Override
	public DataTable transform(String fileName) {

		// 1. Loading Excel data into the excelData List of List
		ExcelReader reader = new ExcelReader();
		List<List<String>> excelData = getExcelData(fileName, reader);

		// 2. Converting excelRow from excelData to dataTableRows
		List<DataTableRow> dataTableRows = getDataTableRows(excelData);

		// 3. Making dataTable from the dataTableRows
		DataTable dataTable = getDataTable(dataTableRows);

		return dataTable;
	}

	private DataTable getDataTable(List<DataTableRow> dataTableRows) {
		ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
		TableConverter tableConverter = new TableConverter(
				new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()),
				parameterInfo);

		DataTable dataTable = new DataTable(dataTableRows, tableConverter);
		return dataTable;
	}

	private List<DataTableRow> getDataTableRows(List<List<String>> excelData) {
		List<DataTableRow> dataTableRows = new LinkedList<>();
		int line = 1;

		for (List<String> excelRow : excelData) {
			Comment comment = new Comment("", line);
			DataTableRow dataTableRow = new DataTableRow(Arrays.asList(comment), excelRow, line++);
			dataTableRows.add(dataTableRow);

		}
		return dataTableRows;
	}

	private List<List<String>> getExcelData(String fileName, ExcelReader reader) {
		List<List<String>> excelData = new LinkedList<>();

		try {
			excelData = reader.getExcelData(fileName, 0);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}

}
