Feature: Login feature test

  #Author U.Ramakrishna
  @smoke @Regression
  Scenario: Login with valid credentials
    Given Steps for login in case of failure
    Given Open the browser and navigate to the url
    When I enter username as "UWServices"
    And I enter password as "Welcome1@"
    And I click on Login button
    Then Login should be successful