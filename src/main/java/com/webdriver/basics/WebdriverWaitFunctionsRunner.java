package com.webdriver.basics;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/basics/WebdriverWaitFunctions.feature" }, glue = {
		"com.webdriver.basics" }, dryRun = false, monochrome = true)
public class WebdriverWaitFunctionsRunner extends AbstractTestNGCucumberTests {

}
