Feature: SearchProduct

Scenario Outline: Valid product

Given el usuari esta en la pagina principal 12
When el usuari busca <producte>
Then el usuari veu <producte>

Examples:
|producte|
|iPhone|


Scenario Outline: Invalid product

Given el usuari esta en la pagina principal 12
When el usuari busca <producte>
Then el usuari no veu cap producte

Examples:
|producte|
|Hamburguesa|