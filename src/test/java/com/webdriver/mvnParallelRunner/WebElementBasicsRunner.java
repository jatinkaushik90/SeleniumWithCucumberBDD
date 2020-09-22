package com.webdriver.mvnParallelRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/basics/WebElementBasics.feature" }, glue = {
		"com.webdriver.basics","com.webdriver.genericHook" }, dryRun = false, monochrome = true)
public class WebElementBasicsRunner extends AbstractTestNGCucumberTests {

}
