Feature: Check Create Account feature of Automation Practice application

  Background:
    Given User opens "Automation Practice" application

  @AutomationPractice @All
  Scenario Outline: Verify user is able to CreateAccount successfully
    When User clicks on Sign In link
    And User enters email in the create account section and Clicks on Create Account button
    Then User should land on "Login - My Store" page
    When User enters the required user details and clicks on Register button
      | State   | Country   | AddressType   |
      | <State> | <Country> | <AddressType> |
    Then User should land on "My account - My Store" page

    Examples:
      | State    | Country       | AddressType      |
      | Delaware | United States | Home Address     |
      | Indiana  | United States | Business Address |

  @AutomationPractice @All
  Scenario: Verify error message is displayed if user clicks on Create Account button and email is blank
    When User clicks on Sign In link
    And User clicks on Create Account button
    Then User should see error message "Invalid email address."