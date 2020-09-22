Feature: IFrames testing

  Background: Common Steps
    Given Iframe I navigate to the "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe"

  Scenario: Iframes handling
    When Iframe I click on the search icon inside the iframe element
    And Iframe I enter text as "Demo" inside the textbox
    And Iframe I perform the click action on home button
    Then Iframe I call the quit method to close the browser

  Scenario: Working with multiple browser windows
    Given MultipleWindows I navigate to the "https://www.w3schools.com/js/js_popup.asp"
    When MultipleWindows I click on try it yourself button & it will open a child browser window
    And MultipleWindows I switch to child browser window & click on home button
    And MultipleWindows I click on a element present in a parent window
    Then Iframe I call the quit method to close the browser