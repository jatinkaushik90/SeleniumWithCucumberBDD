package com.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.webdriver.helper.BrowserHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicsStepDefn {

	private WebDriver driver;
	private BrowserHelper browserHelper;

	@Given("^BrowserFunction I open the chrome browser$")
	public void browserfunction_I_open_the_chrome_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		browserHelper= BrowserHelper.getInstance(driver);
		browserHelper.maximizeBrowser();
//		driver.manage().window().maximize();
	}

	@When("^BrowserFunction I navigate to \"([^\"]*)\"$")
	public void browserfunction_I_navigate_to(String url) throws Throwable {
		driver.get(url);
	}

	@When("^BrowserFunction I quit the browser$")
	public void browserfunction_I_quit_the_browser() throws Throwable {
		if (driver != null) {
			driver.quit();
		}

	}

	@When("^BrowserFunction I open the edge browser$")
	public void browserfunction_I_open_the_edge_browser() throws Throwable {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		browserHelper.maximizeBrowser();
//		driver.manage().window().maximize();
	}

	@When("^BrowserFunction I open the firefox browser$")
	public void browserfunction_I_open_the_firefox_browser() throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		browserHelper.maximizeBrowser();
//		driver.manage().window().maximize();
	}
	
	@When("^BrowserFunction I simulate back button in browser$")
	public void browserfunction_I_simulate_back_button_in_browser() throws Throwable {
//		driver.navigate().back();
		browserHelper.moveBackward();
	}

	@When("^BrowserFunction I simulate refresh button in browser$")
	public void browserfunction_I_simulate_refresh_button_in_browser() throws Throwable {
//		driver.navigate().refresh();
		browserHelper.refresh();
	}

	@When("^BrowserFunction I simulate forward button in browser$")
	public void browserfunction_I_simulate_forward_button_in_browser() throws Throwable {
//		driver.navigate().forward();
		browserHelper.moveForward();
	}
}
