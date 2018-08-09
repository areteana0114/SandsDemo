Feature: Validate the Pre-Assessment feature

  #Author U.Ramakrishna
  #  @smoke @Regression
  #  Scenario: Validate the case status when benefit is Life,Make Decision is Outcome and Decision is Standard.
  #    Given Open the browser and navigate to the url
  #    When I enter username as "UWServices"
  #    And I enter password as "Welcome1@"
  #    And I click on Login button
  #    Then Login should be successful
  #    Given Click on create button
  #    When Click on Pre-assessment button
  #    Then New Pre-assessment page should be displayed
  #    When User enters firstname and lastname
  #    And Selects Smoker status as "Smoker"
  #    And Adviser Name as "10026"
  #    And Default line of business selected is Retail
  #    And User enters disclosure
  #    And selects benefit as life
  #    And Make Decision as "Outcome"
  #    And Decision as "Standard Accept"
  #    And Enters Sum Insured under life as "0"
  #    And Clicks on Create button
  #    Then status of the case should be "Resolved-Completed"
  #Author U.Ramakrishna
  #  @smoke @Regression
  #  Scenario: Validate the case status when benefit is Life,Make Decision is Outcome and Decision is Non-Standard.
  #    Given Open the browser and navigate to the url
  #    When I enter username as "UWServices"
  #    And I enter password as "Welcome1@"
  #    And I click on Login button
  #    Then Login should be successful
  #    Given Click on create button
  #    When Click on Pre-assessment button
  #    Then New Pre-assessment page should be displayed
  #    When User enters firstname and lastname
  #    And Selects Smoker status as "Smoker"
  #    And Adviser Name as "10026"
  #    And Default line of business selected is Retail
  #    And User enters disclosure
  #    And selects benefit as life
  #    And Make Decision as "Outcome"
  #    And Decision as "Non-Standard"
  #    And Enters Sum Insured under life as "1000"
  #    And Clicks on Create button
  #    Then status of the case should be "Resolved-Completed"
  #Author U.Ramakrishna
  #  @smoke @Regression
  #  Scenario: Validate the case status when benefit is Life,Make Decision is Outcome and Decision is Awaiting Further Requirements.
  #    Given Open the browser and navigate to the url
  #    When I enter username as "UWServices"
  #    And I enter password as "Welcome1@"
  #    And I click on Login button
  #    Then Login should be successful
  #    Given Click on create button
  #    When Click on Pre-assessment button
  #    Then New Pre-assessment page should be displayed
  #    When User enters firstname and lastname
  #    And Selects Smoker status as "Smoker"
  #    And Adviser Name as "10026"
  #    And Default line of business selected is Retail
  #    And User enters disclosure
  #    And selects benefit as life
  #    And Make Decision as "Outcome"
  #    And Decision as "Awaiting Further Requirements"
  #    And Enters Sum Insured under life as "1100"
  #    And Clicks on Create button
  #    Then status of the case should be "Resolved-Completed"
  #Author U.Ramakrishna
  @smoke @Regression
  Scenario: Validate the case status when benefit is Life,Make Decision is Outcome and Decision is Decline.
    Given Open the browser and navigate to the url
    When I enter username as "UWServices"
    And I enter password as "Welcome1@"
    And I click on Login button
    Then Login should be successful
    Given Click on create button
    When Click on Pre-assessment button
    Then New Pre-assessment page should be displayed
    When User enters firstname and lastname
    And Selects Smoker status as "Smoker"
    And Adviser Name as "10026"
    And Default line of business selected is Retail
    And User enters disclosure
    And selects benefit as life
    And Make Decision as "Outcome"
    And Decision as "Decline"
    And Enters Sum Insured under life as "2000"
    And Clicks on Create button
    Then status of the case should be "Resolved-Declined"

  #Author U.Ramakrishna
  @smoke @Regression
  Scenario: Validate the case status when benefit is Life,Make Decision is Refer to underwriter.
    Given Open the browser and navigate to the url
    When I enter username as "UWServices"
    And I enter password as "Welcome1@"
    And I click on Login button
    Then Login should be successful
    Given Click on create button
    When Click on Pre-assessment button
    Then New Pre-assessment page should be displayed
    When User enters firstname and lastname
    And Selects Smoker status as "Smoker"
    And Adviser Name as "10026"
    And Default line of business selected is Retail
    And User enters disclosure
    And selects benefit as life
    And Make Decision as "Refer To Underwriter"
    And Enters Sum Insured under life as "2000"
    And Clicks on Create button
    Then status of the case should be "Open-Submitted"
    And capture the case id
    And capture the Log PA Decison operator id
    And logout of the portal
    When I enter username as "mgoh"
    And I enter password as "Welcome1@"
    And I click on Login button
    And Resolve the case
    Then status of the case should be "Resolved-Completed"
    And logout of the portal LogPA Operator
