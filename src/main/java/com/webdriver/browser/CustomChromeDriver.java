package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomChromeDriver implements IBrowserConfiguration {
	
	private void setDriverExecutable() {
		WebDriverManager.chromedriver().setup();
	}
	
	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setHeadless(false);
		// confirgure cmd line arguments
		// configure headless mode for browser
		// many other options
		return options;
	}
	
	public WebDriver getChromeDriver() {
		setDriverExecutable();
		WebDriver driver = new ChromeDriver(getChromeOptions());
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return getChromeDriver();
	}
}
