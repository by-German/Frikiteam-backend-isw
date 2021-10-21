Feature: Follow an event
  Scenario: The user is registered and selects an event to follow.
    Given the user wants to follow an event
    When the user chooses the event, they want to follow
    Then the system will show the user who is now following the event