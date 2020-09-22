package com.webdriver.mvnParallelRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver" }, glue = {
		"com.webdriver" }, dryRun = false, monochrome = true,plugin = { "pretty",
		"json:target/report.json" }, tags = {"@ScenarioOutline"})
public class genericRunner extends AbstractTestNGCucumberTests {

}
