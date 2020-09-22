package com.webdriver.mvnParallelRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver" }, glue = {
		"com.webdriver" }, dryRun = false, monochrome = true,plugin = { "pretty",
		"html:target/HTMLReport" }, tags = {"@ScenarioOutline"})
public class genericRunner extends AbstractTestNGCucumberTests {

}
