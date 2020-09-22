package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnterBugPage extends BasePage {
	
	private WebDriver driver;
	
	public EnterBugPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}
	
//	public By testProduct = By.linkText("TestProduct");
//	public By testNGProduct = By.linkText("testNG");
	
	@FindBy(linkText = "TestProduct")
	public WebElement testProduct_link;
	@FindBy(linkText = "testNG")
	public WebElement testNGProduct_link;
	
	public EnterBugDetailsPage selectTestProduct() {
		EnterBugDetailsPage enterBugDetailsPage = new EnterBugDetailsPage(driver);
		
		testProduct_link.click();
		
//		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(enterBugDetailsPage.submitBug_Btn));
		
		return enterBugDetailsPage;
	}
}
