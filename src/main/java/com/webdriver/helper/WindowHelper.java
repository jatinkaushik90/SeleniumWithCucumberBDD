package com.webdriver.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class WindowHelper {

	private static WebDriver wbDriver;
	private static WindowHelper windowHelper;

	private WindowHelper(WebDriver driver) {
		wbDriver = driver;
	}

	public static WindowHelper getInstance(WebDriver driver) {

		if (windowHelper == null || wbDriver.hashCode() != driver.hashCode()) {
			windowHelper = new WindowHelper(driver);
		}
		return windowHelper;
	}

	private List<String> getWindowIDs() {
		List<String> windowIds = new ArrayList<>(wbDriver.getWindowHandles());
		return Collections.unmodifiableList(windowIds);
	}

	public void SwitchToWindow(int index) {

		List<String> windowIds = getWindowIDs();

		if (index < 0 || index > windowIds.size()) {
			throw new IllegalArgumentException("Invalid Index..." + index);
		}

		wbDriver.switchTo().window(windowIds.get(index));
	}

	public void SwitchToParent() {
		List<String> windowIds = getWindowIDs();

		wbDriver.switchTo().window(windowIds.get(0));
	}

	public void SwitchToParentWithClose() {
		List<String> windowIds = getWindowIDs();

		for (int i = 1; i < windowIds.size(); i++) {
			wbDriver.switchTo().window(windowIds.get(i));
			wbDriver.close();
		}

		SwitchToParent();
	}
}
