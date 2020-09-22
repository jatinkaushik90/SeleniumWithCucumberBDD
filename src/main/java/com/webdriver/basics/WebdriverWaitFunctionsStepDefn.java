package com.webdriver.basics;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.BrowserHelper;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.TextBoxHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebdriverWaitFunctionsStepDefn {

	private WebDriver driver;
	private ButtonHelper buttonhelper;
	private BrowserHelper browserhelper;
	private TextBoxHelper textBoxHelper;

	@Given("^WebdriverWaitFunction I open facebook homepage \"([^\"]*)\"$")
	public void webdriverwaitfunction_I_open_facebook_homepage(String url) throws Throwable {
		CustomChromeDriver chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		buttonhelper = ButtonHelper.getInstance(driver);
		browserhelper = BrowserHelper.getInstance(driver);
		textBoxHelper = TextBoxHelper.getInstance(driver);
		browserhelper.maximizeBrowser();
		driver.get(url);

	}

	@When("^WebdriverWaitFunction I wait for \"([^\"]*)\" ms, the execution stops for this much time$")
	public void webdriverwaitfunction_I_wait_for_ms_the_execution_stops_for_this_much_time(String delay)
			throws Throwable {
		Thread.sleep(Integer.parseInt(delay));
	}

	@When("^WebdriverWaitFunction I click on the login button$")
	public void webdriverwaitfunction_I_click_on_the_login_button() throws Throwable {
		buttonhelper.click(By.xpath("//input[@value='Log In']"));
	}

	@When("^WebdriverWaitFunction I set implict wait as \"([^\"]*)\" seconds, the execution waits for this much seconds before throwing no such element exception$")
	public void webdriverwaitfunction_I_set_implict_wait_as_seconds_the_execution_waits_for_this_much_seconds_before_throwing_no_such_element_exception(
			String implicitWait) throws Throwable {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitWait), TimeUnit.SECONDS);
	}

	@When("^WebdriverWaitFunction I send \"([^\"]*)\" to username field$")
	public void webdriverwaitfunction_I_send_to_username_field(String email) throws Throwable {
		textBoxHelper.setText(By.xpath("//input[@id='email']"), email);
	}

	@SuppressWarnings("deprecation")
	@When("^WebdriverWaitFunction I set explict wait with polling duration as (\\d+) milliseconds & max timeout as (\\d+) seconds$")
	public void webdriverwaitfunction_I_set_explict_wait_with_polling_duration_as_milliseconds_max_timeout_as_seconds(
			int pollingDuration, int maxTimeOut) throws Throwable {

		driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
		wait.pollingEvery(pollingDuration, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Log In']")));
		wait.until(ExpectedConditions.urlToBe("https://www.messenger.com/"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Log In']")));
		wait.until(customWait());
		WebElement element = wait.until(customWaitOnElement());
		System.out.println(element.getText());
		wait.until(customWaitWithParameter(By.xpath("//input[@value='Log In']")));
	}

	@Then("^WebdriverWaitFunction I call the quit method to close the browser$")
	public void webdriverwaitfunction_I_call_the_quit_method_to_close_the_browser() throws Throwable {
		if (driver != null) {
			driver.quit();
		}
	}

	private Function<WebDriver, Boolean> customWait() {
		Function<WebDriver, Boolean> wait = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver t) {
				if (t.findElements(By.xpath("//input[@value='Log In']")).size() >= 1) {
					System.err.println("Element Found!!");
					return true;
				}
				System.out.println("Waiting..");
				return false;
			}
		};

		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitOnElement() {
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if (t.findElements(By.xpath("//input[@value='Log In']")).size() >=1) {
					System.err.println("Element Found!");
					return t.findElement(By.xpath("//input[@value='Log In']"));
				}
				System.out.println("Waiting for element...");
				return null;
			}
		};
		
		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitWithParameter(By locator) {
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if(t.findElements(locator).size() >= 1)
					return t.findElement(locator);
				return null;
			}
		};
		return wait;
	}

}
