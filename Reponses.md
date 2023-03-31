# TD4 : Patron MVC

### Exercice 1
##### Diagramme de classes (solution AntiPattern):
![AntiPattern](UML/AntiPatternUML.png)

### Question 2

#### Principes SOLID: 
- S : La classe Sudoku gère plusieurs responsabilités (validation des valeurs, mise à jour de la grille, affichage, gestion des entrées utilisateur et affichage des messages) alors qu'elle devrait déléguer ces responsabilités à des classes ou des composants distincts.
- O : La méthode isValueValid() de la classe Sudoku devrait être modifiée pour inclure de nouvelles règles de validation. 
De même, la classe SudokuSolver pourrait également nécessiter des modifications si la logique de résolution devait être changée.
- D : La classe SudokuApp dépend directement de la classe Sudoku et de la classe SudokuSolver, qui sont des implémentations concrètes. 
Selon le "Dependency Inversion Principle", les classes devraient dépendre d'abstractions plutôt que d'implémentations concrètes.

### Question 3
Le modèle MVC peut aider en séparant les responsabilités de l'application et en permettant une meilleure organisation du code.

### Question 4
L'utilisation du modèle MVC offre plusieurs avantages :
- Séparer les responsabilités : divise les responsabilités entre le modèle, la vue et le contrôleur.
- Testabilité : La sépération des tâches permet de tester les différentes parties de l'application de manière indépendante.
- Réutilisabilité : Les composants du MVC peuvent être réutilisés pour d'autres parties de l'application.
- Extensibilité : Il devient plus facile de faire évoluer l'application.
- Flexibilité : On peut facilement remplacer des composants sans affecter les autres.
- Bonnes pratiques de programmation : Encourage à l'utilisation des principes SOLID.

### Question 5
- Statégie : On peut utiliser le pattern stratégie pour implémenter différentes techniques de résolution ou de génération de grilles.
- Observateur : On peut utiliser le pattern observateur pour mettre à jour la vue lorsqu'une valeur est modifiée dans le modèle.
- Composite : utilisé pour gérer les différentes parties de l'interface graphique (blocs, lignes et colonnes de la grille) et les traiter de manière unifiée. 
Cela simplifie également la gestion de l'interface et permet plus de modularité.
- Commande : Gérer les actions de l'utilisateur (remplir une case, annuler ou refaire une action) de manière structurée et indépendante du reste du code. 
Facilite l'ajout de nouvelles fonctionnalités, comme l'implémentation d'un système d'annulation et améliore la modularité du code.

### Question 6
La solution antipattern ne respecte pas les principes SOLID.
En effet, les responsabilités sont mélangés dans la classe Sudoku

### Question 7
