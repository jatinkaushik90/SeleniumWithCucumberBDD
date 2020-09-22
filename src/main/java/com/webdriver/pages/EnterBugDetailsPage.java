package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webdriver.helper.DropDownHelper;

public class EnterBugDetailsPage extends BasePage {
	
	private WebDriver driver;
	
	public EnterBugDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}
	
//	public By component = By.cssSelector("select#component");
//	public By version = By.cssSelector("select#version");
//	public By severity = By.cssSelector("select#bug_severity");
//	public By hardware = By.cssSelector("select#rep_platform");
//	public By os = By.cssSelector("select#op_sys");
//	public By summary = By.cssSelector("#short_desc");
//	public By description = By.cssSelector("textarea#comment");
//	public By submitBugButton = By.cssSelector("[value='Submit Bug']");
	
	@FindBy(css = "select#component")
	public WebElement component_Dropdown;
	
	@FindBy(css = "select#version")
	public WebElement version_Dropdown;
	
	@FindBy(css = "select#bug_severity")
	public WebElement severity_Dropdown;
	
	@FindBy(css = "select#rep_platform")
	public WebElement hardware_Dropdown;
	
	@FindBy(css = "select#op_sys")
	public WebElement os_Dropdown;
	
	@FindBy(css = "#short_desc")
	public WebElement summary_TextBox;
	
	@FindBy(css = "textarea#comment")
	public WebElement description_TextBox;
	
	@FindBy(css = "[value='Submit Bug']")
	public WebElement submitBug_Btn;
	

	public void provideBugDetails(String comp, String ver, String sev, String hrd, String osys, String sum, String desc) {
		DropDownHelper helper = DropDownHelper.getInstance(driver);
		helper.SelectByValue(component_Dropdown, comp);
		helper.SelectByValue(version_Dropdown, ver);
		helper.SelectByValue(severity_Dropdown, sev);
		helper.SelectByValue(hardware_Dropdown, hrd);
		helper.SelectByValue(os_Dropdown, osys);
		
		summary_TextBox.sendKeys(sum);
		description_TextBox.sendKeys(desc);
	}
	
	public BugSummaryPage clickSubmitBugButton() {
		BugSummaryPage bugSummaryPage = new BugSummaryPage(driver);
		
		submitBug_Btn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(bugSummaryPage.saveChanges_btn));
		
		return bugSummaryPage;
	}
}

