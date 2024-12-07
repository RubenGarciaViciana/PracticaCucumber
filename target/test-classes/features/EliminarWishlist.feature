Feature: EliminarWishlist

Scenario Outline: Eliminar element Wishlist

Given el usuari esta en la pagina principal 6
When el usuari afegeix un producte a la wishlist 2
And el usuari dona click al boto de wishlist 2
And el usuari inicia sesio 2
And apareix element en la wishlist 2
And elimino el element de la wishlist
Then no esta el element en la wishlist