Feature: Data Driven Testing

  @Normal
  Scenario: Data Driven using DataTabe
    Given datadriven I am on bugzilla homepage
    When datadriven I click on File a Bug page & navigate to login page
    And datadriven The title of login page should be "Log in to Bugzilla"
    And datadriven I log into the application  & navigate to enter bug page
    And datadriven I click on TestProduct link & naviagte to enter bug details page
    And datadriven I provide the following information in bug enter bug details page
      | component     | version     | severity    | hardware  | OS     | summary      | Description                                      |
      | TestComponent | unspecified | major       | Macintosh | Mac OS | Test Summary | This is a data-driven demo0 for the bug creation |
      | TestComponent | unspecified | enhancement | PC        | Linux  | Test Summary | This is a data-driven demo1 for the bug creation |
    #   And datadriven I provide the details component as "TestComponent" version as "unspecified" severity as "major" hardware as "Macintosh" OS as "Mac OS" summary as "Test Summary" Description as "This is a demo for the bug creation"
    And datadriven I click on submit bug button
    And datadriven The title should contain "Test Summary"
    And datadriven I am at the summary page & I click the logout button

  @Normal
  Scenario: Data Driven using Excel File
    Given datadriven I am on bugzilla homepage
    When datadriven I click on File a Bug page & navigate to login page
    And datadriven The title of login page should be "Log in to Bugzilla"
    And datadriven I log into the application  & navigate to enter bug page
    And datadriven I click on TestProduct link & naviagte to enter bug details page
    And datadriven I provide the following information in bug enter bug details page from excel file "TestData.xlsx"
    #   And datadriven I provide the details component as "TestComponent" version as "unspecified" severity as "major" hardware as "Macintosh" OS as "Mac OS" summary as "Test Summary" Description as "This is a demo for the bug creation"
    And datadriven I click on submit bug button
    And datadriven The title should contain "Test Summary"
    And datadriven I am at the summary page & I click the logout button

  @ScenarioOutline
  Scenario Outline: Multiple round of Data Driven testing using Excel File
    Given datadriven I am on bugzilla homepage
    When datadriven I click on File a Bug page & navigate to login page
    And datadriven The title of login page should be "Log in to Bugzilla"
    And datadriven I log into the application  & navigate to enter bug page
    And datadriven I click on TestProduct link & naviagte to enter bug details page
    And datadriven I provide the following information in bug enter bug details page from excel file "TestData.xlsx" for the row number <RowNumber>
    #   And datadriven I provide the details component as "TestComponent" version as "unspecified" severity as "major" hardware as "Macintosh" OS as "Mac OS" summary as "Test Summary" Description as "This is a demo for the bug creation"
    And datadriven I click on submit bug button
    And datadriven The title should contain "Test Summary"
    And datadriven I am at the summary page & I click the logout button

    Examples: 
      | RowNumber |
      |         1 |
      |         2 |
