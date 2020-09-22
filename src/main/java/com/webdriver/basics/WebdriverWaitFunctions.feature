Feature: Webdriver Wait Functions

  Background: Common Execution Steps
    Given WebdriverWaitFunction I open facebook homepage "https://mbasic.facebook.com/login/"

  #Wait amount is fixed i.e; wait is constant like 5 sec etc
  Scenario: Webdriver Fixed Wait - Thread.sleep(in ns)
    When WebdriverWaitFunction I wait for "5000" ms, the execution stops for this much time
    And WebdriverWaitFunction I click on the login button
    Then WebdriverWaitFunction I call the quit method to close the browser

  #Implict Wait - applies to all driver instances.
  Scenario: Webdriver Implict Wait
    When WebdriverWaitFunction I set implict wait as "10" seconds, the execution waits for this much seconds before throwing no such element exception
    And WebdriverWaitFunction I click on the login button
    #And WebdriverWaitFunction I send "email@gmail.com" to username field
    Then WebdriverWaitFunction I call the quit method to close the browser

  #Explicity Wait - applies to a block of code & implict wait should not used with the explict wait otherwise it might slow the execution
  Scenario: Webdriver Wait - Explict Wait (Dynamic Wait)
    When WebdriverWaitFunction I set explict wait with polling duration as 250 milliseconds & max timeout as 60 seconds
    And WebdriverWaitFunction I click on the login button
    # And WebdriverWaitFunction I send "email@gmail.com" to username field
    Then WebdriverWaitFunction I call the quit method to close the browser