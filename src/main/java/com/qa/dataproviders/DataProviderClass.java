package com.qa.dataproviders;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.qa.utils.ConfigReader;
import com.qa.utils.ExcelUtil;

public class DataProviderClass {
	
	@DataProvider(name = "TestData")
	public String[][] GetDataForTestCase(Method m) throws InvalidFormatException, IOException {

		System.out.println("Method name = " + m.getName() + ", Excel file path = " + ConfigReader.GetExcelFilePath());

		String[][] data = ExcelUtil.GetSheetData(ConfigReader.GetExcelFilePath(), m.getName());

		return data;

	}
}
