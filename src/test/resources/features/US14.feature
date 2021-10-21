Feature: Ver ubicación geográfica de un evento
  Scenario: El usuario selecciona un evento y se muestra la geolocalización
    Given El usuario quiere ver la localización de un evento
    When Selecciona un evento
    Then Una ventana se muestra con la localización del evento