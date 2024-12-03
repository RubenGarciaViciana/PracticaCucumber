Feature: VisualitzarCategories

Scenario Outline: Visualitzar Categories de un grup

Given el usuari esta en la pagina principal
When el usuari fa click en el grup <grup>
And el usuari selecciona la categoria <categoria> del grup <grup>
Then la llista de la categoria <categoria> apareix

Examples:
|grup|categoria|
|Desktops|Mac|
|Laptops & Notebooks|Windows|
|Components|Monitors|
|MP3 Players|test 11|

Scenario Outline: Visualitzar Categoria sense grup

Given el usuari esta en la pagina principal
When el usuari fa click en la categoria <categoria>
Then la llista de la categoria <categoria> apareix

Examples:
|categoria|
|Tablets|
|Software|
|Phones & PDAs|
|Cameras|