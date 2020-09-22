package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

//	public By fileABug = By.id("enter_bug");
//	public By search = By.cssSelector("#query");
//	public By openANewAccount = By.cssSelector("#account");
//	public By quickSearchTextBox = By.cssSelector("input#quicksearch_main");
	
	@FindBy(id ="enter_bug" )
	public WebElement fileABug_link;
	@FindBy(css ="#query" )
	public WebElement search_txtBox;
	@FindBy(css = "#account")
	public WebElement openANewAccount_link;
	@FindBy(css = "input#quicksearch_main")
	public WebElement quickSearch_txtBox;

	public LoginPage fileABug() {
		LoginPage loginPage = new LoginPage(driver);
		
		fileABug_link.click();
		
//		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.login_btn));
		return loginPage;
	}

//	private WebDriverWait getWait() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.pollingEvery(Duration.of(250, ChronoUnit.MILLIS));
//		wait.ignoring(NoSuchElementException.class);
//		return wait;
//	}
}
