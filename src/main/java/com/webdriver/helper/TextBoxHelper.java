package com.webdriver.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {

	private static TextBoxHelper textBoxHelper;
	private static WebDriver wbDriver;
	private WebElement webElement;

	private TextBoxHelper(WebDriver driver) {
		wbDriver = driver;
	}

	public static TextBoxHelper getInstance(WebDriver driver) {
		if (textBoxHelper == null || wbDriver.hashCode() != driver.hashCode()) {
			textBoxHelper = new TextBoxHelper(driver);
		}
		return textBoxHelper;
	}
	
	public void setText(By locator, String value) {
		wbDriver.findElement(locator).sendKeys(value);
	}
	
	public String getText(By locator) {
		webElement=wbDriver.findElement(locator);
		return webElement.getText();
	}
	
	public void clear(By locator) {
		wbDriver.findElement(locator).clear();
	}
}
