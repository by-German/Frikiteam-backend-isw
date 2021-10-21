Feature: Ver la fecha de un evento
  Scenario: El usuario quiere saber la fecha de un evento futuro
    Given El usuario friki quiere poder ver la fecha de un evento
    When Observa uno de los eventos
    Then Puede observar la fecha en la descripción del evento