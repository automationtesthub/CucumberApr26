@test
Feature: Lead Functionality


  Scenario: Create_lead_with_mandatory_fields_TC04
    Given user should be on login page
    When user enters the valid credentials and click on login button
    And click on new lead link and fill mandatory "<lastname>" and "<company>" fields
      | lastname | company  |
      | Modi     | BJP      |
      | Gandhi   | Congress |
      | Pawar    | NCP      |
    Then click logout


    @lead
  Scenario: Create_lead_with_mandatory_fields_TC05
    Given user should be on login page
    When user enters the valid credentials and click on login button
    And click on new lead link and fill mandatory fields
    Then click logout
