package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

//	public By login = By.cssSelector("input#Bugzilla_login");
//	public By password = By.cssSelector("input#Bugzilla_password");
//	public By loginButton = By.cssSelector("input#log_in");

	@FindBy(css = "input#Bugzilla_login")
	public WebElement login_txtBox;
	@FindBy(css = "input#Bugzilla_password")
	public WebElement password_txtBox;
	@FindBy(css = "input#log_in")
	public WebElement login_btn;

	public EnterBugPage loginBugzilla(String sLogin, String sPassword) {
		EnterBugPage enterBugPage = new EnterBugPage(driver);

		login_txtBox.sendKeys(sLogin);
		password_txtBox.sendKeys(sPassword);
		login_btn.click();
		
//		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(enterBugPage.testProduct_link));

		return enterBugPage;
	}
}
