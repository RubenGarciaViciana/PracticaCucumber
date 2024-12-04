Feature: IniciarSessio

Scenario Outline: Iniciar Sessio

Given el usuari esta en la pagina principal 2
When el usuari fa click en My Account 1
And el usuari selecciona la opcio de Login
And al usuari se li mostra la pantalla de Login
And el usuari introdueix les dades de Login correctament <email>
And el usuari li dona al boto de Login
Then la pantalla de My Account apareix

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|email|
|ruben.garcia@gmail.com|

Scenario Outline: Correu invalid

Given el usuari esta en la pagina principal 2
When el usuari fa click en My Account 1
And el usuari selecciona la opcio de Login
And al usuari se li mostra la pantalla de Login
And el usuari introdueix un correu invalid <email>
And el usuari li dona al boto de Login
Then el error del email apareix

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|email|
|ruben.garcia|

Scenario Outline: Contrasenya invalida

Given el usuari esta en la pagina principal 2
When el usuari fa click en My Account 1
And el usuari selecciona la opcio de Login
And al usuari se li mostra la pantalla de Login
And el usuari introdueix un contrasenya invalid <email>
And el usuari li dona al boto de Login
Then el error del contrasenya apareix 2

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|email|
|ruben.garcia@gmail.com|

#Scenario Outline: Contrasenya invàlida