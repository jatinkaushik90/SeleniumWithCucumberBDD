package com.webdriver.datadriven;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/datadriven/datadriven.feature" }, glue = {
		"com.webdriver.datadriven","com.webdriver.genericHook" }, dryRun = false, monochrome = true, plugin = {"pretty","html:target/HTMLReport"})
public class DataDrivenRunner extends AbstractTestNGCucumberTests {

}
