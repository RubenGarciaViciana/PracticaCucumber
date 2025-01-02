Feature: VisualitzarCarrito

Scenario Outline: Visualitzar producte carrito

Given el usuari esta en la pagina principal 15
When el usuari afegeix un producte al carrito
And el usuari dona click al boto de carrito
Then apareix el carrito

Scenario Outline: Visualitzar carrito buit

Given el usuari esta en la pagina principal 15
When el usuari dona click al boto de carrito
Then el carrito esta buit