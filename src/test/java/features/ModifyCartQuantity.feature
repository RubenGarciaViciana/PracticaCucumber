Feature: ModifyCartQuantity

Scenario Outline: Modify Cart Quantity

Given el usuari esta en la pagina principal 9
When el usuari fa click a afegir al carrito <producte>
And el usuari navega al carrito 2
And el usuari modifica la quantitat
Then la quantitat ha augmentat

Examples:
|producte|
|iPhone|
