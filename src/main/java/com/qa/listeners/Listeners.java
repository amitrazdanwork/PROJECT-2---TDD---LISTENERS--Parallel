package com.qa.listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.base.BaseTest;
import com.qa.utils.CommonUtils;
import com.qa.utils.ConfigReader;

@org.testng.annotations.Listeners
public class Listeners extends BaseTest implements ISuiteListener, ITestListener {

	/* ----------------------- Suite Listener methods----------------------- */

	// Suite Start
	@Override
	public void onStart(ISuite suite) {

		report = new ExtentReports();
		reporter = new ExtentSparkReporter(
				"C:\\Users\\razda\\eclipse-workspace\\TestNG_Projects\\Project2_Practice_Selenium_TestNG2_Parallel\\test-output\\ExtentReports\\extent_report.html");
		report.attachReporter(reporter);

	}

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = report.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		extentTest.assignAuthor(result.getTestContext().getCurrentXmlTest().getParameter("author"));
		extentTest.assignDevice(result.getTestContext().getCurrentXmlTest().getParameter("device"));
		extentTest.assignCategory(result.getMethod().getGroups());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.fail("Test got failed !!!!");
		CommonUtils.CaptureScreenshot(result.getMethod().getMethodName(), getDriver());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip("Test got skipped !!!!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.pass("Test got passed !!!!");
	}

	// Invoked before every <Test>
	@Override
	public void onStart(ITestContext context) {

		config = new ConfigReader();

		String browser = context.getCurrentXmlTest().getParameter("browser");
		String device = context.getCurrentXmlTest().getParameter("device");
          
		System.out.println("Execution type = "+ConfigReader.GetExecutionType());
		
		
		if (ConfigReader.GetExecutionType().equalsIgnoreCase("local")) {

			switch (browser) {

			case "chrome":
				driver = new ChromeDriver();
				threadLocalDriver.set(driver);
				getDriver().get(ConfigReader.GetBaseUrl());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

				break;

			case "edge":
				driver = new EdgeDriver();
				threadLocalDriver.set(driver);
				getDriver().get(ConfigReader.GetBaseUrl());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

				break;
			case "firefox":
				driver = new FirefoxDriver();
				threadLocalDriver.set(driver);
				getDriver().get(ConfigReader.GetBaseUrl());
				wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

				break;

			default:
				System.out.println("Wrong browser!!!!");
				break;
			}

		} else if (ConfigReader.GetExecutionType().equalsIgnoreCase("remote")) {

			// Define the remote hub URL
			String HubUrl = "http://192.168.29.158:4444/";

			// Creating object of desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();

			/* Setting up platform */
			if (device.equals("windows")) {
				cap.setPlatform(Platform.WIN10); // if you are working on Windows 11
				System.out.println("Platform done - Window 10");

			} else if (device.equals("linux")) {
				System.out.println("Platform done - linux");
				cap.setPlatform(Platform.LINUX); // if you are working on Windows 11
			} else {
				System.out.println("Invalid platform");
			}

			/* Setting up browser */
			if (browser.equals("chrome")) {
				cap.setBrowserName("chrome"); // if you want to execute on chrome
				System.out.println("Browser done - Chrome");

			} else if (browser.equals("edge")) {
				cap.setBrowserName("edge"); // if you want to execute on edge
				System.out.println("Browser done - edge");

			} else if (browser.equalsIgnoreCase("firefox")) {
				cap.setBrowserName(browser);
				System.out.println("Browser done - firefox");

			} else {
				System.out.println("Invalid browser");
			}
			// remote driver instantiation
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("Issue with Remote webdriver instantiation.");
				e.printStackTrace();
			}

			threadLocalDriver.set(driver);
			getDriver().get(ConfigReader.GetBaseUrl());

			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			getDriver().manage().timeouts().setScriptTimeout(Duration.ofMinutes(1));

			wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

		}

	}

	// Invoked after every <Test>
	@Override
	public void onFinish(ITestContext context) {

		getDriver().quit();

		System.out.println("After Test Thread ID: " + Thread.currentThread().getId());

		threadLocalDriver.remove();
	}

	// Suite End
	@Override
	public void onFinish(ISuite suite) {

		report.flush();
	}

	// get thread-safe driver
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

}
