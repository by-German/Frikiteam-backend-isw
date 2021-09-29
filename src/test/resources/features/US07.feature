Feature: Iniciar sesión en la plataforma como organizador
  Scenario: El usuario ingresa a la plataforma
    Given cuando selecciona el boton de la imagen de usuario
    And selecciona el boton Register
    When selecciona la categoria ORGANIZER
    And llena el formulario de datos
    Then el sistema guarda los datos asociados al perfil e ingresa al sistema automaticamente