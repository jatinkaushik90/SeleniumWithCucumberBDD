Feature: Selenium Webdriver Basics

  Scenario: Opening the browsers
    Given BrowserFunction I open the chrome browser
    When BrowserFunction I navigate to "https://www.youtube.com"
    And BrowserFunction I navigate to "https://www.google.com"
    And BrowserFunction I simulate back button in browser
    And BrowserFunction I simulate refresh button in browser
    And BrowserFunction I simulate forward button in browser
    And BrowserFunction I quit the browser
    And BrowserFunction I open the edge browser
    And BrowserFunction I navigate to "https://www.youtube.com"
    And BrowserFunction I navigate to "https://www.google.com"
    And BrowserFunction I simulate back button in browser
    And BrowserFunction I simulate refresh button in browser
    And BrowserFunction I simulate forward button in browser
    And BrowserFunction I quit the browser
    And BrowserFunction I open the firefox browser
    And BrowserFunction I navigate to "https://www.youtube.com"
    And BrowserFunction I navigate to "https://www.google.com"
    And BrowserFunction I simulate back button in browser
    And BrowserFunction I simulate refresh button in browser
    And BrowserFunction I simulate forward button in browser
    And BrowserFunction I quit the browser