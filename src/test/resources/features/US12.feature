Feature: Follow organizer
  Scenario: Registered user follows an organizer
    Given user wants to follow an organizer
    When choose the organizer you want to follow
    Then the system notifies you that you are now following that organizer