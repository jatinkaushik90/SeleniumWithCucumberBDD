package com.webdriver.basics;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/basics/IFrames.feature" }, glue = {
		"com.webdriver.basics" }, dryRun = false, monochrome = true)
public class IFramesRunner extends AbstractTestNGCucumberTests {

}
