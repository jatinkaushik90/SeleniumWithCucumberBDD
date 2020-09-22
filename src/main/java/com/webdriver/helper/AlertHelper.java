package com.webdriver.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHelper {
	
	private static WebDriver wbDriver;
	private static AlertHelper alertHelper;
	
	private AlertHelper(WebDriver driver) {
		wbDriver = driver;
	}
	
	public static AlertHelper getInstance(WebDriver driver) {
		if (alertHelper == null || wbDriver.hashCode() != driver.hashCode()) {
			alertHelper = new AlertHelper(driver);
		}
		return alertHelper;
	}
	
	@SuppressWarnings("deprecation")
	private WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(wbDriver, 10);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	public void acceptAlert() {
		Alert alert = waitForAlert();
		alert.accept();
	}
	
	public void dismissAlert() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}
	
	public void setAlertText(String value) {
		Alert alert = waitForAlert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	public String getAlertText() {
		Alert alert = waitForAlert();
		return alert.getText();
	}

	private Alert waitForAlert() {
		WebDriverWait wait = getWait();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
}
