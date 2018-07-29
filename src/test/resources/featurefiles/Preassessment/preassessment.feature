Feature: Validate the Pre-Assessment feature

  #Author U.Ramakrishna
  @smoke @Regression
  Scenario: Validate the case status when benefit is Life,Make Decision is Outcome and Decision is Standard.
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
    And Decision as "Standard Accept"
    And Enters Sum Insured under life as "0"
    And Clicks on Create button
    Then status of the case should be "Resolved-Completed"
