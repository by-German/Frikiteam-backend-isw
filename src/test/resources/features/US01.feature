Feature: Rate an event
  Scenario: Rate an event that has already ended logged in.
    Given that the Friki user wants to rate an event, that has ended,
    And has logged into his account.
    When the user completes the requested qualification data.
    Then the system registers the rating provided by the user.