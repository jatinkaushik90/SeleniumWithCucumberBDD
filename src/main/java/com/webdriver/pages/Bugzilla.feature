Feature: Bugzilla - Bugs

  Scenario: Creation of the Bug
    Given bugzilla I am on bugzilla homepage
    When bugzilla I click on File a Bug page & navigate to login page
    And bugzilla The title of login page should be "Log in to Bugzilla"
    And bugzilla I log into the application  & navigate to enter bug page
    And bugzilla I click on TestProduct link & naviagte to enter bug details page
    And bugzilla I provide the details component as "TestComponent" version as "unspecified" severity as "major" hardware as "Macintosh" OS as "Mac OS" summary as "Test Summary" Description as "This is a demo for the bug creation"
    And bugzilla I click on submit bug button
    And bugzilla I am at the summary page & I click the logout button

  Scenario: Usgae of Custom Factory
    Given bugzilla I am on bugzilla homepage
    When bugzilla I click on File a Bug page & navigate to login page
    And bugzilla I log into the application  & navigate to enter bug page
    And bugzilla I navigate back to the HomePage
    And bugzilla I navigate back to the Enter bug page
    And bugzilla I click on TestProduct link & naviagte to enter bug details page
    And bugzilla I provide the details component as "TestComponent" version as "unspecified" severity as "major" hardware as "Macintosh" OS as "Mac OS" summary as "Test Summary" Description as "This is a demo for the bug creation"
    And bugzilla I click on submit bug button
    And bugzilla I am at the summary page & I click the logout button
