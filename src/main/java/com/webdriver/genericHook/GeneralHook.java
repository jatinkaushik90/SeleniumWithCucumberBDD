package com.webdriver.genericHook;

import org.openqa.selenium.WebDriver;

import com.webdriver.services.DriverServices;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GeneralHook {

	@SuppressWarnings("unused")
	private DriverServices driverServices;
	private WebDriver driver;

	public GeneralHook(DriverServices driverServices) {

		this.driverServices = driverServices;
		this.driver = driverServices.getDriver();
	}
	
	@Before(value = "@ScenarioOutline")
	public void setupForScenarioOutline() {
		System.out.println("This method will run before all the scenarios, tagged with '@ScenarioOutline'");
	}
	
	@After(value = "@ScenarioOutline")
	public void tearDownForScenarioOutline() {
		System.out.println("This method will run after all the scenarios, tagged with '@ScenarioOutline'");
	}

	@Before
	public void setup() {

	}
	
	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			driverServices.getGenericHelper().takeScreenshot("OnFailureScreenshot", scenario.getName()+"_src_");
			scenario.embed(driverServices.getGenericHelper().takeScreenshot(), "image/png");
		}
		if (driver != null) {
			driver.quit();
		}
	}
}
