Feature: Crear un evento
  Scenario: El usuario ingresa a la sección de crear evento y crea un evento
  Given que el usuario quiere crear un evento
  When ingresa los datos del evento y selecciona el boton guardar
  Then el evento es guardado en la base de datos.