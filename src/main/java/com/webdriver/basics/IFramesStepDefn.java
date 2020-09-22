package com.webdriver.basics;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.helper.ButtonHelper;
import com.webdriver.helper.TextBoxHelper;
import com.webdriver.helper.WindowHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IFramesStepDefn {
	
	private WebDriver driver;
	private CustomChromeDriver chromeDriver;
	private ButtonHelper buttonHelper;
	private TextBoxHelper textBoxHelper;
	private WebElement webElement;
	private WindowHelper windowHelper;
	@SuppressWarnings("unused")
	private ArrayList<String> windowID;
	
	@Given("^Iframe I navigate to the \"([^\"]*)\"$")
	public void iframe_I_navigate_to_the(String url) throws Throwable {
		chromeDriver = new CustomChromeDriver();
		driver = chromeDriver.getChromeDriver();
		buttonHelper = ButtonHelper.getInstance(driver);
		textBoxHelper = TextBoxHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("^Iframe I click on the search icon inside the iframe element$")
	public void iframe_I_click_on_the_search_icon_inside_the_iframe_element() throws Throwable {
	    WebDriverWait wait = getWait(driver, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tryhome")));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("[src='https://www.w3schools.com']")));
//		driver.switchTo().frame("iframeResult");
//		webElement = driver.findElement(By.cssSelector("[src='https://www.w3schools.com']"));
//		driver.switchTo().frame(webElement);
		webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Search W3Schools']")));
	    //buttonHelper.click(By.xpath("//a[@title='Search W3Schools']"));
	    buttonHelper.click(webElement);
	    
	}

	@When("^Iframe I enter text as \"([^\"]*)\" inside the textbox$")
	public void iframe_I_enter_text_as_inside_the_textbox(String value) throws Throwable {
	    textBoxHelper.setText(By.xpath("//input[@name='search']"), value);
	}
	
	@When("^Iframe I perform the click action on home button$")
	public void iframe_I_peerform_the_click_action_on_home_button() throws Throwable {
		driver.switchTo().defaultContent();
	    buttonHelper.click(By.cssSelector("a#tryhome"));
	}
	
	@Given("^MultipleWindows I navigate to the \"([^\"]*)\"$")
	public void multiplewindows_I_navigate_to_the(String url) throws Throwable {
	    driver.get(url);
	}

	@When("^MultipleWindows I click on try it yourself button & it will open a child browser window$")
	public void multiplewindows_I_click_on_try_it_yourself_button_it_will_open_a_child_browser_window() throws Throwable {
	    WebDriverWait wait = getWait(driver, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='tryit.asp?filename=tryjs_alert']")));
	    buttonHelper.click(By.xpath("//a[@href='tryit.asp?filename=tryjs_alert']"));
	}

	@When("^MultipleWindows I switch to child browser window & click on home button$")
	public void multiplewindows_I_switch_to_child_browser_window_click_on_home_button() throws Throwable {
//		windowID = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(windowID.get(1));
		windowHelper.SwitchToWindow(1);
		WebDriverWait wait = getWait(driver, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a#tryhome")));
	    buttonHelper.click(By.cssSelector("a#tryhome"));
//	    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	    windowHelper.SwitchToWindow(1);
//	    windowHelper.SwitchToWindow(5); error scenario
	}
	
	@When("^MultipleWindows I click on a element present in a parent window$")
	public void multiplewindows_I_click_on_a_element_present_in_a_parent_window() throws Throwable {
//		driver.switchTo().window(windowID.get(0));
		windowHelper.SwitchToParent();
		buttonHelper.click(By.xpath("//a[@href='tryit.asp?filename=tryjs_alert']"));
	}


	@Then("^Iframe I call the quit method to close the browser$")
	public void iframe_I_call_the_quit_method_to_close_the_browser() throws Throwable {
	    if(driver!=null)
	    	windowHelper.SwitchToParentWithClose();
	    	driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	private WebDriverWait getWait(WebDriver driver, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
}
