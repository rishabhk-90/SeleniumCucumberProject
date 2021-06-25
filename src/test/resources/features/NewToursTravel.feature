Feature: Check User Registration functionality for NewTours Demo application

  @NewTours @All
  Scenario Outline: Verify user is able to Register on the NewTours app successfully
    Given User opens "NewTours" application
    When User clicks on Register link
    And User enters the required registration details
      | UserName   | Country   |
      | <UserName> | <Country> |
    And Clicks on Submit button
    Then User should be registered successfully and should see message as "Note: Your user name is <UserName>."

    Examples:
      | UserName | Country |
      | Gareth   | Angola  |
      | Bill     | Zambia  |
      | Jim      | Italy   |
