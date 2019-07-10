Feature: Login feature test

  #Author U.Ramakrishna
  @Regression @Smoke
  Scenario: Login with valid credentials
    Given Steps for login in case of failure
    Given Open the browser and navigate to the url
    When I enter username as "CACSR"
    And I enter password as "Rules@1234"
    And I click on Login button
    Then Login should be successful


