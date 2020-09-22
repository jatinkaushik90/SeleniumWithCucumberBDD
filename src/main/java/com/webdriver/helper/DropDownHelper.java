package com.webdriver.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

	private static DropDownHelper dropDownHelper;
	private static WebDriver wbDriver;
	private WebElement webElement;

	private DropDownHelper(WebDriver driver) {
		wbDriver = driver;
	}

	public static DropDownHelper getInstance(WebDriver driver) {
		if (dropDownHelper == null || wbDriver.hashCode() != driver.hashCode()) {
			dropDownHelper = new DropDownHelper(driver);
		}
		return dropDownHelper;
	}

	public void SelectByVisibleText(By locator, String value) {
		webElement = wbDriver.findElement(locator);
		Select select = new Select(webElement);
		select.selectByVisibleText(value);
	}

	public void SelectByValue(By locator, String value) {
		webElement = wbDriver.findElement(locator);
		Select select = new Select(webElement);
		select.selectByValue(value);
	}
	
	public void SelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void SelectByIndex(By locator, int index) {
		webElement = wbDriver.findElement(locator);
		Select select = new Select(webElement);
		select.selectByIndex(index);
	}
	
	public List<WebElement> getAllValues(By locator) {
		webElement = wbDriver.findElement(locator);
		Select select = new Select(webElement);
		return select.getOptions();
	}
}
