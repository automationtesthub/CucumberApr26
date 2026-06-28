Feature: Accounts feature

  @acc
  Scenario: Create_Account_mandatory_fields_TC06
    Given user should be on login page
    When user enters the valid credentials and click on login button
    And click on new account link and fill mandatory fields
    Then click logout