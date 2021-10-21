Feature: Notify for event modification
  Scenario: The user receives notifications about the modification of events.
    Given the user wants to be notified when changes are posted to the events they follow or will attend
    When events are modified
    Then the application sends notifications of these modified events.