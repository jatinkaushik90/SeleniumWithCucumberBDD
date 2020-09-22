package com.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.services.DriverServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertsStepDefn {

	private DriverServices services;
	private WebDriver driver;
	private WebElement webElement;
	
	public AlertsStepDefn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}

	@Given("^Alerts I navigate to the url \"([^\"]*)\"$")
	public void alerts_I_navigate_to_the_url(String url) throws Throwable {
		driver.get(url);
	}

	@When("^Alerts I click on Try It button, the alert should be shown$")
	public void alerts_I_click_on_Try_It_button_the_alert_should_be_shown() throws Throwable {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a#tryhome")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[name='iframeResult']")));
		services.getButtonHelper().click(By.xpath("//button[text()='Try it']"));
	}

	@When("^Alerts I switch to Alert & accept the alert$")
	public void alerts_I_switch_to_Alert_accept_the_alert() throws Throwable {
//	    Alert alert = driver.switchTo().alert();
//		WebDriverWait wait = getWait();
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.accept();
		services.getAlertHelper().acceptAlert();
	}

	@When("^Alerts I switch to confirm pop-up & accept it$")
	public void alerts_I_switch_to_confirm_pop_up_accept_it() throws Throwable {
//		WebDriverWait wait = getWait();
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.accept();
		services.getAlertHelper().acceptAlert();
	}

	@When("^Alerts I switch to confirm pop-up & dismiss it$")
	public void alerts_I_switch_to_confirm_pop_up_dismiss_it() throws Throwable {
//		WebDriverWait wait = getWait();
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		alert.dismiss();
		services.getAlertHelper().dismissAlert();
	}

	@When("^Alerts I switch back to the default content$")
	public void alerts_I_switch_back_to_the_default_content() throws Throwable {
		driver.switchTo().defaultContent();
	}

	@When("^Alerts I enter \"([^\"]*)\" in prompt pop-up & accept it$")
	public void alerts_I_enter_in_prompt_pop_up_accept_it(String arg1) throws Throwable {
//	    WebDriverWait wait = getWait();
//	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	    alert.sendKeys(arg1);
//	    alert.accept();
		services.getAlertHelper().setAlertText(arg1);
	}

	@When("^Alerts I get text from the prompt pop-up & dismiss it$")
	public void alerts_I_get_text_from_the_prompt_pop_up_dismiss_it() throws Throwable {
//		WebDriverWait wait = getWait();
//	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//	    System.out.println("Prompt pop-up text:"+alert.getText());
//	    alert.dismiss();
		System.out.println(services.getAlertHelper().getAlertText());
		services.getAlertHelper().dismissAlert();
	}

	@When("^Alerts I click on open modal button$")
	public void alerts_I_click_on_open_modal_button() throws Throwable {
		services.getButtonHelper().click(By.cssSelector(".btn-success"));
	}

	@When("^Alerts bootstrap pop-up should appear$")
	public void alerts_bootstrap_pop_up_should_appear() throws Throwable {
		WebDriverWait wait = getWait();
		webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Close']")));
	}

	@When("^Alerts I click on close button present inside the pop-up$")
	public void alerts_I_click_on_close_button_present_inside_the_pop_up() throws Throwable {
		services.getButtonHelper().click(webElement);
	}

	@Then("^Alerts I call the quit method to close the browser$")
	public void alerts_I_call_the_quit_method_to_close_the_browser() throws Throwable {
//		if (driver != null) {
//			driver.quit();
//		}
	}

	@SuppressWarnings("deprecation")
	private WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
}
