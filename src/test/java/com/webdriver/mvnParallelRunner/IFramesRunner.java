package com.webdriver.mvnParallelRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/basics/IFrames.feature" }, glue = { "com.webdriver.basics",
		"com.webdriver.genericHook" }, dryRun = false, monochrome = true, plugin = { "pretty",
				"html:target/HTMLReport" })
public class IFramesRunner extends AbstractTestNGCucumberTests {

}
