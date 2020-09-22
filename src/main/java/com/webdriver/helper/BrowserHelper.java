package com.webdriver.helper;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {

	private static BrowserHelper browserhelper;
	private static WebDriver wbDriver;

	private BrowserHelper(WebDriver driver) {
		wbDriver = driver;
	}

	public static BrowserHelper getInstance(WebDriver driver) {

		if (browserhelper == null || wbDriver.hashCode() != driver.hashCode()) {
			browserhelper = new BrowserHelper(driver);
		}
		return browserhelper;
	}

	public void moveForward() {
		wbDriver.navigate().forward();
	}

	public void moveBackward() {
		wbDriver.navigate().back();
	}

	public void refresh() {
		wbDriver.navigate().refresh();
	}

	public void maximizeBrowser() {
		wbDriver.manage().window().maximize();
	}
}
