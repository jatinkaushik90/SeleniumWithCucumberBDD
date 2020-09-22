package com.webdriver.pages.menu;

import org.openqa.selenium.WebDriver;

import com.webdriver.pages.BasePage;

public class SearchPage extends BasePage {
	
	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
