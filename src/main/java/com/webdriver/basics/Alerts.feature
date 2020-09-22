Feature: Javascript Alerts Testing

  Scenario: Alert Handling
    Given Alerts I navigate to the url "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert"
    When Alerts I click on Try It button, the alert should be shown
    And Alerts I switch to Alert & accept the alert
    And Alerts I switch back to the default content
    Then Alerts I call the quit method to close the browser

  Scenario: Confirm pop-up Handling
    Given Alerts I navigate to the url "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm"
    When Alerts I click on Try It button, the alert should be shown
    And Alerts I switch to confirm pop-up & accept it
    And Alerts I switch back to the default content
    When Alerts I click on Try It button, the alert should be shown
    And Alerts I switch to confirm pop-up & dismiss it
    Then Alerts I call the quit method to close the browser

  Scenario: Prompt pop-up handling
    Given Alerts I navigate to the url "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"
    When Alerts I click on Try It button, the alert should be shown
    And Alerts I enter "Hello" in prompt pop-up & accept it
    And Alerts I switch back to the default content
    When Alerts I click on Try It button, the alert should be shown
    And Alerts I get text from the prompt pop-up & dismiss it
    Then Alerts I call the quit method to close the browser

  Scenario: BootStrap Pop-up handling
    Given Alerts I navigate to the url "https://www.w3schools.com/bootstrap/bootstrap_modal.asp"
    When Alerts I click on open modal button
    And Alerts bootstrap pop-up should appear
    And Alerts I click on close button present inside the pop-up
    Then Alerts I call the quit method to close the browser