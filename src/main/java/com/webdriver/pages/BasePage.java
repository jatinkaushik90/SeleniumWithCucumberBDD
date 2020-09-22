package com.webdriver.pages;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.pages.factory.CustomFactory;
import com.webdriver.pages.factory.PageName;

public class BasePage {
	
	private WebDriver driver;
	protected WebDriverWait wait;
	
	@FindBy(css = "div#header > .links > li:nth-of-type(11) > a")
	public WebElement logout;
	
	//Adding all the webElements which are common across the pages
	@FindBy(xpath = "(//a[@href='./'][contains(.,'Home')])[1]")
	public WebElement home;
	
	@FindBy(xpath = "(//a[@href='enter_bug.cgi'][contains(.,'New')])[1]")
	public WebElement newLink;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = getWait();
	}
	
	protected WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(Duration.of(250, ChronoUnit.MILLIS));
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	protected HomePage logoutFromApplication() {
		HomePage homePage = new HomePage(driver);
		
		logout.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(homePage.fileABug_link));
		
		return homePage;
	}
	
	public BasePage navigateTo(PageName name, WebDriver driver, WebElement element) { //For navigating to all the pages
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return CustomFactory.getInstance(name, driver);
		
	}
}
