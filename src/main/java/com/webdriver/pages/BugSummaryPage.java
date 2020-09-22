package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BugSummaryPage extends BasePage {
	
	@SuppressWarnings("unused")
	private WebDriver driver;

	public BugSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css = "textarea#comment")
	public WebElement additionalComments_txtBox;
	@FindBy(css = "input#commit")
	public WebElement saveChanges_btn;
	@FindBy(css = "select#bug_status")
	public WebElement bugStatus_dropDown;
}
