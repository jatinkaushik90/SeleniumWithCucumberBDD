package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import com.webdriver.pages.factory.PageName;
import com.webdriver.services.DriverServices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BugzillaStepDefn {

	private WebDriver driver;
	private DriverServices services;
	private HomePage homePage;
	private LoginPage loginPage;
	private EnterBugPage enterBugPage;
	private EnterBugDetailsPage enterBugDetailsPage;
	private BugSummaryPage bugSummaryPage;

	public BugzillaStepDefn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}

	@Given("^bugzilla I am on bugzilla homepage$")
	public void bugzilla_I_am_on_bugzilla_homepage() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		homePage = new HomePage(driver);
	}

	@When("^bugzilla I click on File a Bug page & navigate to login page$")
	public void bugzilla_I_click_on_File_a_Bug_page_navigate_to_login_page() throws Throwable {
//		loginPage = homePage.fileABug(); OR below approch
		homePage.fileABug_link.click();
		loginPage = (LoginPage) homePage.navigateTo(PageName.LoginPage, driver, homePage.home);
	}

	@When("^bugzilla The title of login page should be \"([^\"]*)\"$")
	public void bugzilla_The_title_of_login_page_should_be(String title) throws Throwable {
		assertEquals(driver.getTitle(), title);

		try {
			fail("Failing it to take screenshot");
		} catch (AssertionError e) {
		}

//		fail("Failing it to take screenshot");
	}

	@When("^bugzilla I log into the application  & navigate to enter bug page$")
	public void bugzilla_I_log_into_the_application_navigate_to_enter_bug_page() throws Throwable {
		enterBugPage = loginPage.loginBugzilla(services.getReader().getUserName(), services.getReader().getPassword());
	}

	@When("^bugzilla I click on TestProduct link & naviagte to enter bug details page$")
	public void bugzilla_I_click_on_TestProduct_link_naviagte_to_enter_bug_details_page() throws Throwable {
		enterBugDetailsPage = enterBugPage.selectTestProduct();
	}

	@When("^bugzilla I provide the details component as \"([^\"]*)\" version as \"([^\"]*)\" severity as \"([^\"]*)\" hardware as \"([^\"]*)\" OS as \"([^\"]*)\" summary as \"([^\"]*)\" Description as \"([^\"]*)\"$")
	public void bugzilla_I_provide_the_details_component_as_version_as_severity_as_hardware_as_OS_as_summary_as_Description_as(
			String component, String version, String severity, String hardware, String OS, String summary,
			String description) throws Throwable {
		enterBugDetailsPage.provideBugDetails(component, version, severity, hardware, OS, summary, description);
	}

	@When("^bugzilla I click on submit bug button$")
	public void bugzilla_I_click_on_submit_bug_button() throws Throwable {
		bugSummaryPage = enterBugDetailsPage.clickSubmitBugButton();
	}
	
	@When("^bugzilla I navigate back to the HomePage$")
	public void bugzilla_I_navigate_back_to_the_HomePage() throws Throwable {
	    enterBugPage.home.click();
	    homePage = (HomePage) enterBugPage.navigateTo(PageName.HomePage, driver, homePage.home);
	}

	@When("^bugzilla I navigate back to the Enter bug page$")
	public void bugzilla_I_navigate_back_to_the_Enter_bug_page() throws Throwable {
	    homePage.newLink.click();
	    enterBugPage = (EnterBugPage) homePage.navigateTo(PageName.EnterBugPage, driver, enterBugPage.testProduct_link);
	}

	@When("^bugzilla I am at the summary page & I click the logout button$")
	public void bugzilla_I_am_at_the_summary_page_I_click_the_logout_button() throws Throwable {
		bugSummaryPage.logoutFromApplication();
	}
}
