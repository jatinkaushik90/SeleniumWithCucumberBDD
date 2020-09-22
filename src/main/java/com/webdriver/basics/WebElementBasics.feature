Feature: Selenium WebElement Basics

Background: Common Step for Web Element Function
Given WebElementFunction I open facebook homepage "http://www.facebook.com"

Scenario: Webelement function for single element
When WebElementFunction I provide the unique location to find the element
And WebElementFunction I should get webelement
And WebElementFunction I call the quit method to close the browser

Scenario: Webelement function for multiple element
When WebElementFunction I provide a non-unique location to find the element
And WebElementFunction I should get a list of all webelements
And WebElementFunction I call the quit method to close the browser

Scenario: Working with TextBox
When WebElementFunction I provide location of a Email TextBox
And WebElementFunction I enter "email@gmail.com" in Email TextBox
And WebElementFunction I clear the Email TextBox
And WebElementFunction I call the quit method to close the browser

Scenario: Working with Button
When WebElementFunction I find the login button & click on it
And WebElementFunction I simulate back button in browser
And WebElementFunction I find the Mail radio button & click on it
And WebElementFunction I find the create a page link & click on it
And WebElementFunction I simulate back button in browser
And WebElementFunction I call the quit method to close the browser

Scenario: Working with Dropdown using select class
When WebElementFunction I find the dropdown & select its value using value
And WebElementFunction I find the dropdown & select its value using index
And WebElementFunction I find the dropdown & select its value using UI(visibleText)
And WebElementFunction I print all the available options in the dropdowns
And WebElementFunction I call the quit method to close the browser