Feature: DeleteProductCarrito

Scenario Outline: Delete Carrito

Given el usuari esta en la pagina principal 11
When el usuari fa click en Add to Cart <producte>
And el usuari navega al carrito
And fa click a eliminar producte
Then el carrito està buit

Examples:
|producte|
|iPhone|
