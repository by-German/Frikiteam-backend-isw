Feature: See number of tickets sold

  Scenario: View sold tickets.
    Given the organizer wants to see the number of tickets sold
    When the organizer chooses one of your events
    Then the system will also show you the information of the number of tickets sold

  Scenario: View tickets sold without logging in
    Given the organizer wants to see the number of tickets sold
    And the organizer did not log in
    When the organizer select the option to see your events
    Then the system tells you that you must be logged in