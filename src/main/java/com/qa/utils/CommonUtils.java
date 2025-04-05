package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.BaseTest;

public class CommonUtils extends BaseTest {

	public static String CaptureScreenshot(String substring, WebDriver driver) {

		//String SSFilePath = null;

		LocalDateTime dt = LocalDateTime.now();

		String Subfoldername = dt.format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));

		System.out.println("Date = " + Subfoldername);
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		String src = ts.getScreenshotAs(OutputType.BASE64);
		
		return src;
	}

}
