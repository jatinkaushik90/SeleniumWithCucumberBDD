package com.webdriver.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.browser.CustomFirefoxDriver;
import com.webdriver.browser.IBrowserConfiguration;
import com.webdriver.helper.AlertHelper;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.DropDownHelper;
import com.webdriver.helper.GenericHelper;
import com.webdriver.helper.TextBoxHelper;
import com.webdriver.helper.WindowHelper;
import com.webdriver.utils.IReader;
import com.webdriver.utils.ReadConfigProperties;

public class DriverServices {

	public DriverServices() {
		launchBrowser(); // As soon as the object of this class is created launch browser method is
							// called
	}

	private WebDriver driver;
	private IBrowserConfiguration browserConfiguration;
//	private CustomChromeDriver customChromeDriver;
//	private CustomFirefoxDriver customFireFoxDriver;
	private AlertHelper alertHelper;
	private BrowserHelper browserHelper;
	private ButtonHelper buttonHelper;
	private DropDownHelper dropDownHelper;
	private TextBoxHelper textBoxHelper;
	private WindowHelper windowHelper;
	private GenericHelper genericHelper;
	private IReader reader;

	public void launchBrowser() {
//		customChromeDriver = new CustomChromeDriver();
//		driver = customChromeDriver.getChromeDriver();
		reader = new ReadConfigProperties();
		reader.setBrowserType();
		driver = getBrowserDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		alertHelper = AlertHelper.getInstance(driver);
		buttonHelper = ButtonHelper.getInstance(driver);
		dropDownHelper = DropDownHelper.getInstance(driver);
		textBoxHelper = TextBoxHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		genericHelper = GenericHelper.getInstance(driver);
		browserHelper.maximizeBrowser();
	}

	private WebDriver getBrowserDriver() {
		switch (reader.getBrowserName()) {
		case BrowserType.CHROME:
//			customChromeDriver = new CustomChromeDriver();
//			return customChromeDriver.getChromeDriver();
			browserConfiguration = new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();
			
		case BrowserType.FIREFOX:
//			customFireFoxDriver = new CustomFirefoxDriver();
//			return customFireFoxDriver.getFirefoxDriver();
			browserConfiguration = new CustomFirefoxDriver();
			return browserConfiguration.getBrowserDriver();
			
		default:
			throw new RuntimeException("Invalid Browser Type: " + reader.getBrowserName());
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

//	public CustomChromeDriver getCustomChromeDriver() {
//		return customChromeDriver;
//	}

	public AlertHelper getAlertHelper() {
		return alertHelper;
	}

	public BrowserHelper getBrowserHelper() {
		return browserHelper;
	}

	public ButtonHelper getButtonHelper() {
		return buttonHelper;
	}

	public DropDownHelper getDropDownHelper() {
		return dropDownHelper;
	}

	public TextBoxHelper getTextBoxHelper() {
		return textBoxHelper;
	}

	public WindowHelper getWindowHelper() {
		return windowHelper;
	}

	public IReader getReader() {
		return reader;
	}

	public GenericHelper getGenericHelper() {
		return genericHelper;
	}

}
