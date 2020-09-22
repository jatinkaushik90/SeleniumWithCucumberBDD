package com.webdriver.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.services.DriverServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class WebElementBasicsStepDefn {

	private WebDriver driver;
	private DriverServices services;
//	private BrowserHelper browserHelper;
//	private TextBoxHelper textBoxHelper;
//	private ButtonHelper buttonHelper;
//	private DropDownHelper dropDownHelper;
	private WebElement webElement;
	private List<WebElement> WebElementList;
	
	public WebElementBasicsStepDefn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	

	@Given("^WebElementFunction I open facebook homepage \"([^\"]*)\"$")
	public void webelementfunction_I_open_facebook_homepage(String url) throws Throwable {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
//		CustomChromeDriver chromeDriver = new CustomChromeDriver();
//		driver = chromeDriver.getChromeDriver();
		
//		CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
//		driver = firefoxDriver.getFirefoxDriver();
		
//		CustomInternetExplorerDriver internetExplorerDriver = new CustomInternetExplorerDriver();
//		driver = internetExplorerDriver.getInternetExplorerDriver();
		
//		browserHelper = BrowserHelper.getInstance(driver);
//		textBoxHelper = TextBoxHelper.getInstance(driver);
//		buttonHelper = ButtonHelper.getInstance(driver);
//		dropDownHelper = DropDownHelper.getInstance(driver);
//		browserHelper.maximizeBrowser();
		driver.get(url);
	}

	@When("^WebElementFunction I provide the unique location to find the element$")
	public void webelementfunction_I_provide_the_unique_location_to_find_the_element() throws Throwable {
		webElement = driver.findElement(By.xpath("//input[@name='firstname']"));
	}

	@When("^WebElementFunction I should get webelement$")
	public void webelementfunction_I_should_get_webelement() throws Throwable {
		System.out.println(webElement.toString());
	}

	@When("^WebElementFunction I provide a non-unique location to find the element$")
	public void webelementfunction_I_provide_a_non_unique_location_to_find_the_element() throws Throwable {
		WebElementList = driver.findElements(By.xpath("//input"));
	}

	@When("^WebElementFunction I should get a list of all webelements$")
	public void webelementfunction_I_should_get_a_list_of_all_webelements() throws Throwable {
		System.out.println("No of elements found: "+WebElementList.size());
		for (WebElement webElement : WebElementList) {
			System.out.println(webElement.getAttribute("name"));
		}
	}
	
	@When("^WebElementFunction I provide location of a Email TextBox$")
	public void webelementfunction_I_provide_location_of_a_Email_TextBox() throws Throwable {
//	   webElement=driver.findElement(By.xpath("//input[@type='email']"));
	}

	@When("^WebElementFunction I enter \"([^\"]*)\" in Email TextBox$")
	public void webelementfunction_I_enter_in_Email_TextBox(String value) throws Throwable {
		services.getTextBoxHelper().setText(By.xpath("//input[@type='email']"), value);
		System.out.println(services.getTextBoxHelper().getText(By.xpath("//input[@type='email']")));
	}

	@When("^WebElementFunction I clear the Email TextBox$")
	public void webelementfunction_I_clear_the_Email_TextBox() throws Throwable {
		services.getTextBoxHelper().clear(By.xpath("//input[@type='email']"));
	}
	
	@When("^WebElementFunction I find the login button & click on it$")
	public void webelementfunction_I_find_the_login_button_click_on_it() throws Throwable {
//		webElement=driver.findElement(By.cssSelector("[data-testid='royal_login_button']"));
//		webElement.click();
		
		services.getButtonHelper().click(By.cssSelector("[data-testid='royal_login_button']"));
		Thread.sleep(1000);
	}
	
	@When("^WebElementFunction I find the Mail radio button & click on it$")
	public void webelementfunction_I_find_the_Mail_radio_button_click_on_it() throws Throwable {
//	    webElement = driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input"));
//	    webElement.click();
		
		services.getButtonHelper().click(By.xpath("//label[text()='Male']/preceding-sibling::input"));
	}

	@When("^WebElementFunction I find the create a page link & click on it$")
	public void webelementfunction_I_find_the_create_a_page_link_click_on_it() throws Throwable {
//	    webElement = driver.findElement(By.xpath("//a[contains(@href,'/pages/create/?ref_type') and @class='_8esh']"));
//	    webElement.click();
		
		services.getButtonHelper().click(By.xpath("//a[contains(@href,'/pages/create/?ref_type') and @class='_8esh']"));
	}
	
	@When("^WebElementFunction I simulate back button in browser$")
	public void webelementfunction_I_simulate_back_button_in_browser() throws Throwable {
		services.getBrowserHelper().moveBackward();
	}
	
	@When("^WebElementFunction I find the dropdown & select its value using value$")
	public void webelementfunction_I_find_the_dropdown_select_its_value_using_value() throws Throwable {
//	    webElement = driver.findElement(By.cssSelector("#day"));
//	    Select select = new Select(webElement);
//	    select.selectByValue("20");
		
		services.getDropDownHelper().SelectByValue(By.cssSelector("#day"), "20");
	}

	@When("^WebElementFunction I find the dropdown & select its value using index$")
	public void webelementfunction_I_find_the_dropdown_select_its_value_using_index() throws Throwable {
//	    webElement = driver.findElement(By.cssSelector("#month"));
//	    Select select = new Select(webElement);
//	    select.selectByIndex(1);
		
		services.getDropDownHelper().SelectByIndex(By.cssSelector("#month"), 1);
	}

	@When("^WebElementFunction I find the dropdown & select its value using UI\\(visibleText\\)$")
	public void webelementfunction_I_find_the_dropdown_select_its_value_using_UI_visibleText() throws Throwable {
//		webElement = driver.findElement(By.cssSelector("#year"));
//	    Select select = new Select(webElement);
//	    select.selectByVisibleText("2007");
		
		services.getDropDownHelper().SelectByVisibleText(By.cssSelector("#year"), "2007");
		Thread.sleep(5000);
	}
	
	@When("^WebElementFunction I print all the available options in the dropdowns$")
	public void webelementfunction_I_print_all_the_available_options_in_the_dropdowns() throws Throwable {
	    List<WebElement> years = services.getDropDownHelper().getAllValues(By.cssSelector("#year"));
	    System.out.println("Total number of years: "+years.size());
	    List<WebElement> months = services.getDropDownHelper().getAllValues(By.cssSelector("#month"));
	    System.out.println("Total number of months: "+months.size());
	    List<WebElement> days = services.getDropDownHelper().getAllValues(By.cssSelector("#day"));
	    System.out.println("Total number of days: "+days.size());
	    
	    for (WebElement webElement : days) {
			System.out.println("Day in dropdown: "+webElement.getText());
		}
	    
	    for (WebElement webElement : months) {
			System.out.println("Month in dropdown: "+webElement.getText());
		}
	    
	    for (WebElement webElement : years) {
			System.out.println("Year in dropdown: "+webElement.getText());
		}
	}
	
	@When("^WebElementFunction I call the quit method to close the browser$")
	public void webelementfunction_I_call_the_quit_method_to_close_the_browser() throws Throwable {
//		if (driver != null) {
//			driver.quit();
//		}
	}
}
