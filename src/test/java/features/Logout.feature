Feature: Logout

Scenario Outline: Logout

Given el usuari esta en la pagina principal 3
When el usuari fa el proces de Login
And el usuari fa click en la seccio de Logout
And es mostra la pantalla per fer Logout
And el usuari fa click al boto de Continue
Then la pantalla principal apareix