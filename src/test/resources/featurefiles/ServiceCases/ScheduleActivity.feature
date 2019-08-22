@test
Feature: Validate the Schedule Activity feature.

  Background: Login into the application
    Given Open the browser and navigate to the url
    When I enter username as "CACSR"
    And I enter password as "Rules@1234"
    And I click on Login button
    Then Login should be successful

  #Author U.Ramakrishna
  @Smoke
  Scenario: Launch the interaction with Sarah Connor for Schedule Activity Service Case and create task.
    And Click on New button
    And Hover On Demo Screen Pops
    And Click on "CONNOR"
    And Click on Accept
    Then System launches the interaction portal
    And Click on Add Task button
    And select the "Select         Schedule Activity   " service case
    And click on Add Tasks button
    And Click on Task
    And Select Task Type as "Missing Statements" from Task  Type dropdown
    And Select escalate as "No"
    And Select an  account "Personal Checking : 12457890" from link account dropdown
    And Select "Work queue" from Assign to dropdown
    And Select "Inbound correspondence" from the workbasket
    # And Enter "comments" in note field
    And Click on Submit button
    Then verify  the message case has been created successfully
    And Click on Confirm button
    And Click on Wrap Up
    And Click on Submit button in wrap up sccreen
    And Select "Inbound correspondence" from the View Queue for workbasket
    And Open the required Case Id by clicking on "S-187" link
    And Select "Resolve" in Resolve work screen
    # And Enter "comments" in note field
    And Click on Submit button
    And Click on Confirm button
    When I click on down arrow
    And I click on Logout
    Then Logout should be successful

  # Author U.Ramakrishna
  @Regression
  Scenario Outline: Launch the interaction with John  Brown for Schedule Activity Service Case and create task.
    And Click on New button
    And Hover On Demo Screen Pops
    And Click on "BROWN"
    And Click on Accept
    Then System launches the interaction portal
    And Click on Add Task button
    And select the "Select         Schedule Activity   " service case
    And click on Add Tasks button
    And Click on Task
    And Select Task Type as "<TaskType>" from Task  Type dropdown
    And Select escalate as "No"
    And Select an  account "<LinkAccount>" from link account dropdown
    And Select "Work queue" from Assign to dropdown
    And Select "Inbound correspondence" from the workbasket
  #   And Enter "comments" in note field
    And Click on Submit button
    Then verify  the message case has been created successfully
    And Click on Confirm button
    And Click on Wrap Up
    And Click on Submit button in wrap up sccreen
    And Select "Inbound correspondence" from the View Queue for workbasket
    And Open the required Case Id by clicking on "<CaseId>" link
    And Select "Resolve" in Resolve work screen
   #   And Enter "comments" in note field
    And Click on Submit button
    And Click on Confirm button
    When I click on down arrow
    And I click on Logout
    Then Logout should be successful

    Examples: 
      | TaskType               | LinkAccount                              | CaseId |
      | Incorrect Billing      | Personal Checking : 12345678             | S-188  |
      | Research Credit Issues | Platinum Rewards Card : 7895543245678901 | S-189  |
