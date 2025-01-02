Feature: DetallProducte

Scenario Outline: Visualitzar Detall dels productes

Given el usuari esta en la pagina principal 13
When el usuari fa click a un producte <producte>
Then el detall de <producte> es mostra

Examples:
|producte|
|iPhone|
|MacBook|