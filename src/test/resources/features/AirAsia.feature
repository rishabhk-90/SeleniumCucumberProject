Feature: Check Flight Search feature for AirAsia application

  @AirAsia @All
  Scenario Outline: Verify user is able to search flights successfully
    Given User opens "AirAsia" application
    When User enters the required flight search details
      | TripType   | From   | To   | Adults   |
      | <TripType> | <From> | <To> | <Adults> |
    And User Clicks on Search button
    Then Flight search results are displayed on a new tab
    And Total number of search results should not be zero

    Examples:
      | TripType | From  | To  | Adults |
      | One way  | Delhi | LHR | 1      |
