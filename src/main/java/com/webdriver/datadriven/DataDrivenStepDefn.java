package com.webdriver.datadriven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.webdriver.pages.BugSummaryPage;
import com.webdriver.pages.EnterBugDetailsPage;
import com.webdriver.pages.EnterBugPage;
import com.webdriver.pages.HomePage;
import com.webdriver.pages.LoginPage;
import com.webdriver.pages.factory.PageName;
import com.webdriver.services.DriverServices;
import com.webdriver.utils.ExcelDataToDataTableTransform;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DataDrivenStepDefn {
	
	private WebDriver driver;
	private DriverServices services;
	private HomePage homePage;
	private LoginPage loginPage;
	private EnterBugPage enterBugPage;
	private EnterBugDetailsPage enterBugDetailsPage;
	private BugSummaryPage bugSummaryPage;
	
	public DataDrivenStepDefn(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@Given("^datadriven I am on bugzilla homepage$")
	public void datadriven_I_am_on_bugzilla_homepage() throws Throwable {
	    driver.get(services.getReader().getApplicationUrl());
	    homePage = new HomePage(driver);
//	    int j = 1/0; //to intenially fail the scenario
	}

	@When("^datadriven I click on File a Bug page & navigate to login page$")
	public void datadriven_I_click_on_File_a_Bug_page_navigate_to_login_page() throws Throwable {
	    homePage.fileABug_link.click();
	    loginPage = (LoginPage) homePage.navigateTo(PageName.LoginPage, driver, homePage.home);
	}

	@When("^datadriven The title of login page should be \"([^\"]*)\"$")
	public void datadriven_The_title_of_login_page_should_be(String title) throws Throwable {
		try {
			assertEquals(driver.getTitle(), title);
		} catch (AssertionError e) {
			throw new RuntimeException("Title doesn't match: "+e.getMessage());
		}
	}

	@When("^datadriven I log into the application  & navigate to enter bug page$")
	public void datadriven_I_log_into_the_application_navigate_to_enter_bug_page() throws Throwable {
//	    enterBugPage = loginPage.loginBugzilla(services.getReader().getUserName(), services.getReader().getPassword());
		
		loginPage.login_txtBox.sendKeys(services.getReader().getUserName());
		loginPage.password_txtBox.sendKeys(services.getReader().getPassword());
		loginPage.login_btn.click();
		enterBugPage = (EnterBugPage) loginPage.navigateTo(PageName.EnterBugPage, driver, loginPage.home);

	}

	@When("^datadriven I click on TestProduct link & naviagte to enter bug details page$")
	public void datadriven_I_click_on_TestProduct_link_naviagte_to_enter_bug_details_page() throws Throwable {
	    enterBugPage.testProduct_link.click();
	    enterBugDetailsPage = (EnterBugDetailsPage) enterBugPage.navigateTo(PageName.EnterBugDetailsPage, driver, enterBugPage.home);
	}

	@When("^datadriven I provide the following information in bug enter bug details page$")
	public void datadriven_I_provide_the_following_information_in_bug_enter_bug_details_page(DataTable dt) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<Map<String, String>> dtListAsMaps = dt.asMaps(String.class, String.class);
		Map<String, String> dataMap = dtListAsMaps.get(1);
		enterBugDetailsPage.provideBugDetails(dataMap.get("component"), dataMap.get("version"), dataMap.get("severity"), dataMap.get("hardware"), dataMap.get("OS"), dataMap.get("summary"), dataMap.get("Description"));
	    
	}
	
	@When("^datadriven I provide the following information in bug enter bug details page from excel file \"([^\"]*)\"$")
	public void datadriven_I_provide_the_following_information_in_bug_enter_bug_details_page_from_excel_file(@Transform(ExcelDataToDataTableTransform.class)DataTable dataTable) throws Throwable {
		List<Map<String, String>> dtListAsMaps = dataTable.asMaps(String.class, String.class);
		Map<String, String> dataMap = dtListAsMaps.get(1);
		enterBugDetailsPage.provideBugDetails(dataMap.get("component"), dataMap.get("version"), dataMap.get("severity"), dataMap.get("hardware"), dataMap.get("OS"), dataMap.get("summary"), dataMap.get("Description"));
	}
	
	@When("^datadriven I provide the following information in bug enter bug details page from excel file \"([^\"]*)\" for the row number (\\d+)$")
	public void datadriven_I_provide_the_following_information_in_bug_enter_bug_details_page_from_excel_file_for_the_row_number(@Transform(ExcelDataToDataTableTransform.class)DataTable dataTable, int rowNumber) throws Throwable {
		List<Map<String, String>> dtListAsMaps = dataTable.asMaps(String.class, String.class);
		Map<String, String> dataMap = dtListAsMaps.get(rowNumber-1);
		enterBugDetailsPage.provideBugDetails(dataMap.get("component"), dataMap.get("version"), dataMap.get("severity"), dataMap.get("hardware"), dataMap.get("OS"), dataMap.get("summary"), dataMap.get("Description"));
	}

	@When("^datadriven I click on submit bug button$")
	public void datadriven_I_click_on_submit_bug_button() throws Throwable {
	    enterBugDetailsPage.submitBug_Btn.click();
	    bugSummaryPage = (BugSummaryPage) enterBugDetailsPage.navigateTo(PageName.BugSummaryPage, driver, enterBugDetailsPage.home);
	}
	
	@When("^datadriven The title should contain \"([^\"]*)\"$")
	public void datadriven_The_title_should_contain(String expectedTitle) throws Throwable {
	    assertTrue(driver.getTitle().contains(expectedTitle),"Title Mis-Match");
	}

	@When("^datadriven I am at the summary page & I click the logout button$")
	public void datadriven_I_am_at_the_summary_page_I_click_the_logout_button() throws Throwable {
	    bugSummaryPage.logout.click();
	}
}
