Feature: AfegirWishlist

Scenario Outline: Afegir Wishlist

Given el usuari esta en la pagina principal 4
When el usuari fa click en Add to Wish List de <producte>
Then apareix el missatge de correctament afegit el <producte>

Examples:
|producte|
|MacBook|