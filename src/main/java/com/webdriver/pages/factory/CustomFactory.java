package com.webdriver.pages.factory;

import org.openqa.selenium.WebDriver;

import com.webdriver.pages.BasePage;
import com.webdriver.pages.BugSummaryPage;
import com.webdriver.pages.EnterBugDetailsPage;
import com.webdriver.pages.EnterBugPage;
import com.webdriver.pages.HomePage;
import com.webdriver.pages.LoginPage;
import com.webdriver.pages.menu.NewCasePage;
import com.webdriver.pages.menu.NewRunPage;
import com.webdriver.pages.menu.ProductDashboardPage;
import com.webdriver.pages.menu.SearchPage;

public class CustomFactory {

	public static BasePage getInstance(PageName name, WebDriver driver) {

		switch (name) {
		case BugSummaryPage:
			return new BugSummaryPage(driver);
		case EnterBugDetailsPage:
			return new EnterBugDetailsPage(driver);
		case EnterBugPage:
			return new EnterBugPage(driver);
		case HomePage:
			return new HomePage(driver);
		case LoginPage:
			return new LoginPage(driver);
		case NewCasePage:
			return new NewCasePage(driver);
		case NewRunPage:
			return new NewRunPage(driver);
		case ProductDashboardPage:
			return new ProductDashboardPage(driver);
		case SearchPage:
			return new SearchPage(driver);

		default:
			throw new RuntimeException("Invalid Page Name: " + name);
		}

	}
}
