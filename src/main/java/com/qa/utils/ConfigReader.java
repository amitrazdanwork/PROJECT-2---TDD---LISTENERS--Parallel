package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.base.BaseTest;

public class ConfigReader extends BaseTest {

	FileInputStream fis;
	static Properties prop;

	public ConfigReader() {
		// TODO Auto-generated constructor stub

		try {
			fis = new FileInputStream(new File(
					"C:\\Users\\razda\\eclipse-workspace\\TestNG_Projects\\Project2_Practice_Selenium_TestNG2_Parallel\\src\\main\\resources\\config\\config.properties"));

			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("Problem with location config.properties file.");
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem with loading config.properties file.");
			e.printStackTrace();
		}

		System.out.println("Config properties got loaded successfully!!!!");

	}

	public static String GetBaseUrl() {
		return prop.getProperty("basePageUrl");
	}

	public static String GetSignInPageUrl() {
		return prop.getProperty("signInPageUrl");
	}

	public static String GetCreateAccountPageUrl() {
		return prop.getProperty("createAccountPageUrl");
	}

	public static String GetExecutionType() {
		return prop.getProperty("executionType");
	}

	public static String GetExcelFilePath() {
		return prop.getProperty("excelFilePath");
	}

	public static String GetConfigFilePath() {
		return prop.getProperty("configFilePath");
	}
	
}
