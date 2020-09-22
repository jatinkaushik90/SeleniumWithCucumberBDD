package com.webdriver.basics;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/basics/Alerts.feature" }, glue = {
		"com.webdriver.basics","com.webdriver.genericHook" }, dryRun = false, monochrome = true)
public class AlertsRunner extends AbstractTestNGCucumberTests {

}
