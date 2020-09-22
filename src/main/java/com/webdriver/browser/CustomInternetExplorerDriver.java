package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomInternetExplorerDriver implements IBrowserConfiguration {
	
	private void setDriverExecutable() {
		WebDriverManager.iedriver().setup();
	}
	
	private InternetExplorerOptions getInternetExplorerOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.destructivelyEnsureCleanSession();
		options.ignoreZoomSettings();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.elementScrollTo(ElementScrollBehavior.BOTTOM);
		return options;
	}
	
	public WebDriver getInternetExplorerDriver() {
		setDriverExecutable();
		InternetExplorerOptions options = getInternetExplorerOptions();
		WebDriver driver = new InternetExplorerDriver(options);
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return getBrowserDriver();
	}
}
