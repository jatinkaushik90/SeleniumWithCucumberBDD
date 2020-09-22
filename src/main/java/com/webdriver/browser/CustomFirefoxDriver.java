package com.webdriver.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomFirefoxDriver implements IBrowserConfiguration {
	
	private void setDriverExecutable() {
		WebDriverManager.firefoxdriver().setup();
	}
	
	private FirefoxOptions getFirefoxOptions(FirefoxProfile profile) {
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		options.setAcceptInsecureCerts(true);
		options.setHeadless(false);
		return options;
	}
	
	private FirefoxProfile getFirefoxProfile() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		return profile;
	}
	
	public WebDriver getFirefoxDriver() {
		setDriverExecutable();
		FirefoxProfile profile = getFirefoxProfile();
		FirefoxOptions options = getFirefoxOptions(profile);
		WebDriver driver = new FirefoxDriver(options);
		return driver;
	}

	@Override
	public WebDriver getBrowserDriver() {
		// TODO Auto-generated method stub
		return getFirefoxDriver();
	}
}
