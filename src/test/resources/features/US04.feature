Feature: purchase tickets from the platform

  Scenario: The user enters all the payment data requested for the purchase of tickets and the operation is validated
    Given the user wants to purchase tickets to an event
    When the user enters the number of tickets
    And  payment method with the requested information
    Then the system notifies the user that their purchase was successful

  Scenario: The user enters the requested payment information, and some is incorrect
    Given the user wants to purchase tickets to an event
    When the user enters the number of tickets
    And the payment method with the wrong information
    Then the user is notified that it has not been possible to complete the purchase

  Scenario: The user enters the requested payment data and does not present money in the payment method
    Given the user wants to purchase tickets to an event
    When the user enters the number of tickets
    And the payment method does not present credit for the action
    Then the user is notified that the purchase could not be completed