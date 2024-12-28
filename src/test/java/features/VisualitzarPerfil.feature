Feature: Visualitzar Perfil

Scenario Outline: Visualitzar Perfil

Given el usuari esta en la pagina principal 10
When el usuari fa el proces de Login 2
And el usuari torna a la pantalla principal
And obra MyAccount
And fa click a MyAccount
Then el usuari es redirigit a la pagina de account
