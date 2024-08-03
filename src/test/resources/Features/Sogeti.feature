@tag
Feature: Sogeti landing page

  @tag1 @smoke
  Scenario: Verify services and automation selected
    Given user is on Sogeti landing page
    When user selects services and automation
    Then user verifies services and automation is selected

  @tag1 @smoke
  Scenario: Verify services and automation selected
    Given user is on Sogeti landing page
    When user selects services and automation
    And user enters First Name, Last Name, Email, Phone, company and Message
    Then user selects country from dropdown and taps on submit
