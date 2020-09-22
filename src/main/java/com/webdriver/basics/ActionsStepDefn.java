package com.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdriver.services.DriverServices;
import com.webdriver.utils.IReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionsStepDefn {

	
//	private CustomChromeDriver customChromeDriver;
//	private BrowserHelper browserHelper;
	private WebDriver driver;
	private WebElement webElement;
	@SuppressWarnings("unused")
	private IReader readConfigProperties;
	private DriverServices services;
	
	public ActionsStepDefn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
		this.readConfigProperties = services.getReader();
	}

	@Given("^Actions I navigate to the url \"([^\"]*)\"$")
	public void actions_I_navigate_to_the_url(String url) throws Throwable {
//		customChromeDriver = new CustomChromeDriver();
//		driver = customChromeDriver.getChromeDriver();
//		browserHelper = BrowserHelper.getInstance(driver);
//		browserHelper.maximizeBrowser();
		driver.get(url);
//		driver.get(readConfigProperties.getApplicationUrl());
	}

	@When("^Actions I perform the context click$")
	public void actions_I_perform_the_context_click() throws Throwable {
		webElement = driver.findElement(By.cssSelector("[data-role='droptarget']"));
		Actions actions = new Actions(driver);
		actions.contextClick(webElement).build().perform();
	}

	@When("^Actions I perform the drag & drop action$")
	public void actions_I_perform_the_drag_drop_action() throws Throwable {
		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement target = driver.findElement(By.cssSelector("div#droptarget"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}

	@When("^Actions I perform the click & hold action$")
	public void actions_I_perform_the_click_hold_action() throws Throwable {
		webElement = driver.findElement(By.cssSelector("div#draggable"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(webElement).build().perform();
	}

	@When("^Actions I perform the Keyboard actions$")
	public void actions_I_perform_the_Keyboard_actions() throws Throwable {
		webElement = driver.findElement(By.cssSelector("input#example-search"));
		Actions actions = new Actions(driver);
		actions.keyDown(webElement, Keys.LEFT_SHIFT).sendKeys(webElement, "selenium").keyUp(webElement, Keys.LEFT_SHIFT)
				.build().perform();
	}
	
	@When("^Actions I take the screenshot$")
	public void actions_I_take_the_screenshot() throws Throwable {
//	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(screenshot, new File("src.png"));
		services.getGenericHelper().takeScreenshot("screenshot", "src");
	}

	@Then("^Actions I call the quit method to close the browser$")
	public void actions_I_call_the_quit_method_to_close_the_browser() throws Throwable {
//		if (driver != null) {
//			driver.quit();
//		}
		// TO be done by teardown method in hooks
	}
}
