Feature: AfegirCarrito

Scenario Outline: Afegir Carrito

Given el usuari esta en la pagina principal 7
When el usuari fa click en Add to Cart de <producte>
Then apareix el missatge de correctament afegit al <producte>

Examples:
|producte|
|iPhone|
