Feature: VeureWishlist

Scenario Outline: Veure Wishlist

Given el usuari esta en la pagina principal 5
When el usuari afegeix un producte a la wishlist
And el usuari dona click al boto de wishlist
And el usuari inicia sesio
Then apareix la wishlist