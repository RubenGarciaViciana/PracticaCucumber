Feature: Register

Scenario Outline: Registrarse

Given el usuari esta en la pagina principal 1
When el usuari fa click en My Account
And el usuari selecciona la opcio de Register
And al usuari se li mostra la pantalla de Registre
And el usuari introdueix les dades correctament <nom>, <cognom>, <email>, <telefon>
And el usuari marca el checkbox de Privacy Policy
And el usuari li dona a continuar
Then la pantalla de te has registrat correctament apareix

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|nom|cognom|email|telefon|
|Rubén|García|ruben.garcia7@gmail.com|123456789|


Scenario Outline: Deixar buits
Given el usuari esta en la pagina principal 1
When el usuari fa click en My Account
And el usuari selecciona la opcio de Register
And al usuari se li mostra la pantalla de Registre
And el usuari li dona a continuar
Then el errors del camps obligatoris apareixen

Scenario Outline: Contrasenyes no coincideixen
Given el usuari esta en la pagina principal 1
When el usuari fa click en My Account
And el usuari selecciona la opcio de Register
And al usuari se li mostra la pantalla de Registre
And el usuari introdueix les dades malament <nom>, <cognom>, <email>, <telefon>
And el usuari marca el checkbox de Privacy Policy
And el usuari li dona a continuar
Then el error del contrasenya apareix

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|nom|cognom|email|telefon|
|Rubén|García|ruben.g7@gmail.com|123456789|

Scenario Outline: No acceptar politiques de privacitat

Given el usuari esta en la pagina principal 1
When el usuari fa click en My Account
And el usuari selecciona la opcio de Register
And al usuari se li mostra la pantalla de Registre
And el usuari introdueix les dades correctament <nom>, <cognom>, <email>, <telefon>
And el usuari li dona a continuar
Then el error de politiques de privacitat apareix

# En el caso del registro no se puede registrar un usuario que ya ha sido registrado entonces
# Por cada ejecución TENEMOS QUE CAMBIAR EL CORREO
Examples:
|nom|cognom|email|telefon|
|Rubén|García|ruben.gar7@gmail.com|123456789|
