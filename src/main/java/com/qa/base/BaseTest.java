package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.utils.ConfigReader;

public class BaseTest {

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public WebDriver driver;
	public static ConfigReader config;
	public static ExtentReports report;
	public static ExtentSparkReporter reporter;
	public static ExtentTest extentTest;
	public static WebDriverWait wait;
	public static String reportName;

}
