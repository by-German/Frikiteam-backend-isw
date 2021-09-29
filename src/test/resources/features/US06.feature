Feature: Ver los detalles de un evento
Scenario: Evento tiene una descripción disponible
  Given que el usuario quiere visualizar la descripción del evento
  When elige uno de los eventos
  Then se aprecia información básica del evento