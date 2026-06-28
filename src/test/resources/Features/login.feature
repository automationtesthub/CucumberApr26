@test
Feature: Login functionality

  Background:
    Given user should be on login page

@valid
Scenario: valid_login_TC01
  When user enters the valid credentials and click on login button
  Then user should be navigated to home page
  And user can see the logout link on home page


  Scenario: Invalid_login_TC02
    When user enters the invalid credentials and click on login button
    Then user can see the error message

   @seema @abc @smoke @sanity @SDDD545
  Scenario Outline: Invalid login with multi dataset
    When user enters the invalid credentials username as "<userid>" and password as "<password>" and click on login button
    Then user can see the error message
  Examples:
    | userid | password |
    | admin1 | pwd1     |
    | admin2 | pwd2     |
    | admin3 | pwd3     |
