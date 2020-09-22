package com.webdriver.pages;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/java/com/webdriver/pages/Bugzilla.feature" }, glue = { "com.webdriver.pages",
		"com.webdriver.genericHook" }, dryRun = false, monochrome = true)
public class BugzillaRunner extends AbstractTestNGCucumberTests {

}
