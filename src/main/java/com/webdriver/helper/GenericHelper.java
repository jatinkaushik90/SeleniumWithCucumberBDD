package com.webdriver.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericHelper {

	private static GenericHelper genericHelper;
	private static WebDriver wbDriver;

	private GenericHelper(WebDriver driver) {
		wbDriver = driver;
	}

	public static GenericHelper getInstance(WebDriver driver) {
		if (genericHelper == null || wbDriver.hashCode() != driver.hashCode()) {
			genericHelper = new GenericHelper(driver);
		}
		return genericHelper;
	}

	public void takeScreenshot(String Dir, String Filename) {
//		String timeStamp = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace(":", "_").replace(".", "_");
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File directory = new File(Dir);

		if (!directory.exists()) {
			directory.mkdir();
		}
		
		File screenshot = ((TakesScreenshot) wbDriver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println(Filename + timeStamp + ".png");
			FileUtils.copyFile(screenshot,
					new File(directory.getAbsolutePath() + File.separator + Filename + "_" + timeStamp + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] takeScreenshot() {
		byte[] screenshot= ((TakesScreenshot) wbDriver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}
}
